/**
 * Copyright (c) 2008 Luis Gustavo Nardin <gnardin@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package otservices.mapper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import otservices.mapper.classifier.Classifier;
import otservices.mapper.translationrepository.OntRelation;
import otservices.mapper.translationrepository.OntTranslation;
import otservices.mapper.translationrepository.Ontology;
import otservices.mapper.translationrepository.TranslationRepository;
import otservices.mapper.webservice.MapperList;
import otservices.util.configuration.ConfigurationElementNotFoundException;
import otservices.util.configuration.ConfigurationFileInvalidException;
import otservices.util.configuration.ConfigurationFileNotFoundException;
import otservices.util.configuration.ConfigurationParser;
import otservices.util.log.Log;

public class MapperController {
	
	// Responsible for the logging
	private static Logger						logger		= Logger
																								.getLogger(MapperController.class
																										.getName());
	
	// Classifier
	Classifier											classifier;
	
	// MapperController Singleton
	private static MapperController	instance	= null;
	
	// MapperController configuration values
	private ConfigurationParser			mapperConfigurator;
	
	// Translation Repository object
	private TranslationRepository		translationRepository;
	
	
	/**
	 * Singleton method
	 * 
	 * @param configXMLFilename
	 *          XML configuration file
	 * @param configXSDFilename
	 *          XML parameters configuration filename
	 * @param logFilename
	 *          Log configuration filename
	 * @return RMMController object
	 */
	public static synchronized MapperController getInstance(
			String configXMLFilename, String configXSDFilename, String logFilename) {
		if(MapperController.instance == null) {
			MapperController.instance = new MapperController(configXMLFilename,
					configXSDFilename, logFilename);
			
			logger.debug("New MapperController instance created");
		}
		
		return MapperController.instance;
	}
	
	
	/**
	 * Constructor for the Reputation Mapping Module
	 * 
	 * @param configXMLFilename
	 *          XML configuration file
	 * @param configXSDFilename
	 *          XML parameters configuration filename
	 * @param logFilename
	 *          Log configuration filename
	 * @return none
	 */
	private MapperController(String configXMLFilename, String configXSDFilename,
			String logFilename) {
		
		// Initialize the logging
		try {
			new Log(logFilename);
		} catch(java.io.FileNotFoundException e) {
			e.printStackTrace();
		}
		
		logger.debug("Logging initialized");
		logger.debug("Loaded log4j configuration file = " + logFilename);
		
		try {
			// Load the Reputation Mapping configuration parameter values
			this.mapperConfigurator = new ConfigurationParser(configXMLFilename,
					configXSDFilename);
			
			// Load the database configuration parameter values
			ConfigurationParser mapperDBConfigurator = new ConfigurationParser(
					(String) this.mapperConfigurator.get("dbXMLConfiguration"),
					(String) this.mapperConfigurator.get("dbXSDConfiguration"));
			
			// Initializes the Mapping Repository database
			this.translationRepository = new TranslationRepository(
					mapperDBConfigurator);
			this.translationRepository.run();
			
			if(translationRepository.isConnected().booleanValue()) {
				// Classifies the ontologies and store it in the translation
				// database
				classifier = new Classifier(this.mapperConfigurator,
						this.translationRepository);
			}
			
			mapperDBConfigurator = null;
		} catch(ConfigurationElementNotFoundException cenfe) {
			logger.error("ConfigurationElementNotFoundException Message " + cenfe);
		} catch(ConfigurationFileInvalidException cfie) {
			logger.error("ConfigurationFileInvalidException Message " + cfie);
		} catch(ConfigurationFileNotFoundException cfnfe) {
			logger.error("ConfigurationFileNotFoundException Message " + cfnfe);
		}
	}
	
	
	/**
	 * Add an Ontology Translation into the Database
	 * 
	 * IMPORTANT - If 2 files have the same name, the second will overwrite the
	 * first one
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @param owlFile
	 *          Ontology filename
	 * @return true - if the ontology translation was performed / false -
	 *         otherwise
	 */
	@SuppressWarnings("unchecked")
	public Boolean addOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative, String owlFile) {
		Boolean result = new Boolean(false);
		
		logger.debug("Ontology Interchange");
		logger.debug("ID..........: " + ontInterchange.getId());
		logger.debug("URI.........: " + ontInterchange.getUri());
		logger.debug("Type........: " + ontInterchange.getType());
		logger.debug("Version.....: " + ontInterchange.getVersion());
		logger.debug("Description.: " + ontInterchange.getDescription());
		
		List<Ontology> ontA = this.translationRepository.select(ontInterchange);
		if(ontA.size() == 0) {
			logger.debug("Adding the OntologyInterchange");
			this.translationRepository.insert(ontInterchange);
			ontA = this.translationRepository.select(ontInterchange);
		} else {
			logger.debug("Ontology Interchange already exists");
		}
		
		logger.debug("Ontology Native");
		logger.debug("ID..........: " + ontNative.getId());
		logger.debug("URI.........: " + ontNative.getUri());
		logger.debug("Type........: " + ontNative.getType());
		logger.debug("Version.....: " + ontNative.getVersion());
		logger.debug("Description.: " + ontNative.getDescription());
		
		List<Ontology> ontB = this.translationRepository.select(ontNative);
		if(ontB.size() == 0) {
			logger.debug("Adding OntologyNative");
			this.translationRepository.insert(ontNative);
			ontB = this.translationRepository.select(ontNative);
		} else {
			logger.debug("Ontology Native already exists");
		}
		
		try {
			String filename = new File(owlFile).getName();
			String directory = (String) this.mapperConfigurator.get("owlDirectory");
			
			logger.debug("Saving file " + filename + " to " + directory);
			
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
					directory + "/" + filename));
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(
					owlFile));
			
			byte[] buffer = new byte[256];
			while(true) {
				int bytesRead = in.read(buffer);
				if(bytesRead == -1)
					break;
				
				out.write(buffer, 0, bytesRead);
			}
			out.flush();
			out.close();
			in.close();
			
			logger.debug("File saved successfully");
			
			OntRelation ontAB = new OntRelation();
			
			logger.debug("Ontology Interchange Id = " + ontA.get(0).getId());
			ontAB.setInterchangeOntology(ontA.get(0).getId());
			
			logger.debug("Ontology Native Id = " + ontB.get(0).getId());
			ontAB.setNativeOntology(ontB.get(0).getId());
			
			List<OntRelation> ontRel = this.translationRepository.select(ontAB);
			if(ontRel.size() == 0) {
				ontAB.setFilename(new File(owlFile).getName());
				this.translationRepository.insert(ontAB);
				ontRel = this.translationRepository.select(ontAB);
				
				logger.debug("Classifying...");
				this.classifier.classify(ontRel.get(0));
			} else {
				logger.debug("Ontology Relation already exists");
			}
			
			result = new Boolean(true);
		} catch(ConfigurationElementNotFoundException cenfe) {
			logger.error("ConfigurationElementNotFoundException Message " + cenfe);
		} catch(FileNotFoundException fnfe) {
			logger.error("FileNotFoundException Message " + fnfe);
		} catch(IOException ioe) {
			logger.error("IOException Message " + ioe);
		}
		
		return result;
	}
	
	
	/**
	 * Returns all From concepts for the ontology relation
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return Returns a list containing all the From concepts for the ontology
	 *         relation
	 */
	@SuppressWarnings("unchecked")
	public String[] getFromMapping(Ontology ontInterchange, Ontology ontNative) {
		String[] result = null;
		
		logger.debug("Ontology Interchange");
		logger.debug("ID..........: " + ontInterchange.getId());
		logger.debug("URI.........: " + ontInterchange.getUri());
		logger.debug("Type........: " + ontInterchange.getType());
		logger.debug("Version.....: " + ontInterchange.getVersion());
		logger.debug("Description.: " + ontInterchange.getDescription());
		
		logger.debug("Ontology Native");
		logger.debug("ID..........: " + ontNative.getId());
		logger.debug("URI.........: " + ontNative.getUri());
		logger.debug("Type........: " + ontNative.getType());
		logger.debug("Version.....: " + ontNative.getVersion());
		logger.debug("Description.: " + ontNative.getDescription());
		
		List<Ontology> ontA = translationRepository.select(ontInterchange);
		List<Ontology> ontB = translationRepository.select(ontNative);
		
		if((ontA.size() > 0) && (ontB.size() > 0)) {
			
			logger.debug("Ontology Interchange and Native exist");
			
			OntRelation ontRel = new OntRelation();
			ontRel.setInterchangeOntology(ontA.get(0).getId());
			ontRel.setNativeOntology(ontB.get(0).getId());
			
			List<OntRelation> ontAB = translationRepository.select(ontRel);
			if(ontAB.size() > 0) {
				
				logger.debug("Ontology Relation was found");
				
				OntTranslation ontTrans = new OntTranslation();
				ontTrans.setRelationID(ontAB.get(0).getId());
				
				List<OntTranslation> trans = translationRepository.select(ontTrans);
				if(trans.size() > 0) {
					List<String> list = new ArrayList<String>();
					
					String fromConcept = trans.get(0).getFromConcept();
					for(int i = 0; i < trans.size(); i++) {
						if(!fromConcept.equals(trans.get(i).getFromConcept())) {
							list.add(fromConcept);
							fromConcept = trans.get(i).getFromConcept();
						}
					}
					list.add(fromConcept);
					
					// Transfer the values to the result
					logger.debug("Results");
					result = new String[list.size()];
					for(int i = 0; i < list.size(); i++) {
						result[i] = (String) list.get(i);
						
						logger.debug(result[i]);
					}
				}
			} else {
				logger.debug("Did not find an ontology relation");
			}
		} else {
			if(ontA.size() <= 0) {
				logger.debug("Ontology Interchange does not exist");
			}
			if(ontB.size() <= 0) {
				logger.debug("Ontology Native does not exist");
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public String getOWLFile(Ontology ontInterchange, Ontology ontNative) {
		String result = null;
		
		logger.debug("Ontology Interchange");
		logger.debug("ID..........: " + ontInterchange.getId());
		logger.debug("URI.........: " + ontInterchange.getUri());
		logger.debug("Type........: " + ontInterchange.getType());
		logger.debug("Version.....: " + ontInterchange.getVersion());
		logger.debug("Description.: " + ontInterchange.getDescription());
		
		logger.debug("Ontology Native");
		logger.debug("ID..........: " + ontNative.getId());
		logger.debug("URI.........: " + ontNative.getUri());
		logger.debug("Type........: " + ontNative.getType());
		logger.debug("Version.....: " + ontNative.getVersion());
		logger.debug("Description.: " + ontNative.getDescription());
		
		List<Ontology> ontA = translationRepository.select(ontInterchange);
		List<Ontology> ontB = translationRepository.select(ontNative);
		
		if((ontA.size() > 0) && (ontB.size() > 0)) {
			
			logger.debug("Ontology Interchange and Native exist");
			
			OntRelation ontRel = new OntRelation();
			ontRel.setInterchangeOntology(ontA.get(0).getId());
			ontRel.setNativeOntology(ontB.get(0).getId());
			
			List<OntRelation> ontAB = translationRepository.select(ontRel);
			if(ontAB.size() > 0) {
				
				logger.debug("Ontology Relation was found");
				
				try {
					result = this.mapperConfigurator.get("owlDirectory") + "/"
							+ ontAB.get(0).getFilename();
				} catch(ConfigurationElementNotFoundException cenfe) {
					logger
							.error("ConfigurationElementNotFoundException Message " + cenfe);
				}
			} else {
				logger.debug("Did not find an ontology relation");
			}
		} else {
			if(ontA.size() <= 0) {
				logger.debug("Ontology Interchange does not exist");
			}
			if(ontB.size() <= 0) {
				logger.debug("Ontology Native does not exist");
			}
		}
		
		logger.debug("OWL Filename = " + result);
		return result;
	}
	
	
	/**
	 * Returns the directory path used to transfer files
	 * 
	 * @param none
	 * @return Transfer directory path
	 */
	public String getTransferDirectory() {
		String tempDir = "";
		
		try {
			tempDir = (String) this.mapperConfigurator.get("transferDirectory");
			
			logger.debug("transferDirectory = " + tempDir);
		} catch(ConfigurationElementNotFoundException cenfe) {
			logger.error("ConfigurationElementNotFoundException Message " + cenfe);
		}
		
		return tempDir;
	}
	
	
	/**
	 * Verify if there is a relation between two ontologies
	 * 
	 * @param ontInterchange
	 *          Interchange ontology object
	 * @param ontNative
	 *          Native ontology object
	 * @return true - if there is a relation / false - otherwise
	 */
	@SuppressWarnings("unchecked")
	public Boolean isOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative) {
		Boolean result = new Boolean(false);
		
		logger.debug("Ontology Interchange");
		logger.debug("ID..........: " + ontInterchange.getId());
		logger.debug("URI.........: " + ontInterchange.getUri());
		logger.debug("Type........: " + ontInterchange.getType());
		logger.debug("Version.....: " + ontInterchange.getVersion());
		logger.debug("Description.: " + ontInterchange.getDescription());
		
		logger.debug("Ontology Native");
		logger.debug("ID..........: " + ontNative.getId());
		logger.debug("URI.........: " + ontNative.getUri());
		logger.debug("Type........: " + ontNative.getType());
		logger.debug("Version.....: " + ontNative.getVersion());
		logger.debug("Description.: " + ontNative.getDescription());
		
		List<Ontology> ontA = translationRepository.select(ontInterchange);
		List<Ontology> ontB = translationRepository.select(ontNative);
		
		// If exists both ontologies
		if((ontA.size() > 0) && (ontB.size() > 0)) {
			
			logger.debug("Ontology Interchange and Native exist");
			
			// Create an OntRelation instance
			OntRelation ontRel = new OntRelation();
			ontRel.setInterchangeOntology(ontA.get(0).getId());
			ontRel.setNativeOntology(ontB.get(0).getId());
			
			// Seek the OntRelation
			List<OntRelation> ontAB = translationRepository.select(ontRel);
			if(ontAB.size() > 0) {
				logger.debug("Ontology Relation was found");
				result = new Boolean(true);
			} else {
				logger.debug("Did not find an ontology relation");
			}
		} else {
			if(ontA.size() <= 0) {
				logger.debug("Ontology Interchange does not exist");
			}
			if(ontB.size() <= 0) {
				logger.debug("Ontology Native does not exist");
			}
		}
		
		return result;
	}
	
	
	/**
	 * Remove an ontology translation from the translation repository, but leave
	 * the ontology records there
	 * 
	 * @param ontInterchange
	 *          Intechange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return true - if translation exists and it was removed / false -
	 *         otherwise
	 */
	@SuppressWarnings("unchecked")
	public Boolean removeOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative) {
		Boolean result = new Boolean(false);
		
		logger.debug("Ontology Interchange");
		logger.debug("ID..........: " + ontInterchange.getId());
		logger.debug("URI.........: " + ontInterchange.getUri());
		logger.debug("Type........: " + ontInterchange.getType());
		logger.debug("Version.....: " + ontInterchange.getVersion());
		logger.debug("Description.: " + ontInterchange.getDescription());
		
		logger.debug("Ontology Native");
		logger.debug("ID..........: " + ontNative.getId());
		logger.debug("URI.........: " + ontNative.getUri());
		logger.debug("Type........: " + ontNative.getType());
		logger.debug("Version.....: " + ontNative.getVersion());
		logger.debug("Description.: " + ontNative.getDescription());
		
		List<Ontology> ontA = translationRepository.select(ontInterchange);
		List<Ontology> ontB = translationRepository.select(ontNative);
		
		if((ontA.size() > 0) && (ontB.size() > 0)) {
			
			logger.debug("Ontology Interchange and Native exist");
			
			ontA = translationRepository.select(ontInterchange);
			ontB = translationRepository.select(ontNative);
			
			OntRelation ontAB = new OntRelation();
			ontAB.setInterchangeOntology(ontA.get(0).getId());
			ontAB.setNativeOntology(ontB.get(0).getId());
			List<OntRelation> ontRel = translationRepository.select(ontAB);
			
			if(ontRel.size() > 0) {
				logger.debug("Ontology Relation was found");
				
				ontRel = translationRepository.select(ontAB);
				
				OntTranslation ontTrans = new OntTranslation();
				ontTrans.setRelationID(ontRel.get(0).getId());
				
				translationRepository.delete(ontTrans);
				translationRepository.delete(ontRel.get(0));
				
				try {
					(new File(((String) this.mapperConfigurator.get("owlDirectory"))
							+ "/" + ontRel.get(0).getFilename())).delete();
				} catch(ConfigurationElementNotFoundException cenfe) {
					logger
							.error("ConfigurationElementNotFoundException Message " + cenfe);
				}
				
				result = new Boolean(true);
			}
		} else {
			if(ontA.size() <= 0) {
				logger.debug("Ontology Interchange does not exist");
			}
			if(ontB.size() <= 0) {
				logger.debug("Ontology Native does not exist");
			}
		}
		
		return result;
	}
	
	
	/**
	 * Shuts down connection to the translation repository database
	 * 
	 * @param none
	 * @return none
	 */
	public void shutdown() {
		
		logger.debug("Shutting down Translation Repository");
		if(translationRepository != null) {
			if(translationRepository.isConnected()) {
				translationRepository.shutdown();
				
				logger.debug("Translation Repository shutdown successfully");
			} else {
				logger.debug("Translation Repository is not connected");
			}
		} else {
			logger.debug("Translation Repository is NULL");
		}
	}
	
	
	/**
	 * Returns a list of all the concepts of a target ontology related to
	 * fromConcept from a source ontology
	 * 
	 * @param ontFrom
	 *          Souce ontology
	 * @param ontTo
	 *          Target ontology
	 * @param fromConcept
	 *          Concept to be translated
	 * @return List of all the concepts related to fromConcept
	 */
	@SuppressWarnings("unchecked")
	public MapperList translateConcept(Ontology ontFrom, Ontology ontTo,
			String fromConcept) {
		String[] result = null;
		Boolean direction;
		
		logger.debug("Ontology From");
		logger.debug("ID..........: " + ontFrom.getId());
		logger.debug("URI.........: " + ontFrom.getUri());
		logger.debug("Type........: " + ontFrom.getType());
		logger.debug("Version.....: " + ontFrom.getVersion());
		logger.debug("Description.: " + ontFrom.getDescription());
		
		logger.debug("Ontology To");
		logger.debug("ID..........: " + ontTo.getId());
		logger.debug("URI.........: " + ontTo.getUri());
		logger.debug("Type........: " + ontTo.getType());
		logger.debug("Version.....: " + ontTo.getVersion());
		logger.debug("Description.: " + ontTo.getDescription());
		
		List<Ontology> ontA = translationRepository.select(ontFrom);
		List<Ontology> ontB = translationRepository.select(ontTo);
		
		if((ontA.size() > 0) && (ontB.size() > 0)) {
			OntRelation ontRel = new OntRelation();
			
			logger.debug("Ontologies From and To exist");
			
			if((ontA.get(0).getType() == Ontology.TYPE_INTERCHANGE.intValue())
					&& (ontB.get(0).getType() == Ontology.TYPE_NATIVE.intValue())) {
				ontRel.setInterchangeOntology(ontA.get(0).getId());
				ontRel.setNativeOntology(ontB.get(0).getId());
				direction = new Boolean(true);
				
				logger.debug("Direction Ontology Interchange -> Ontology Native");
			} else if((ontA.get(0).getType() == Ontology.TYPE_NATIVE.intValue())
					&& (ontB.get(0).getType() == Ontology.TYPE_INTERCHANGE.intValue())) {
				ontRel.setInterchangeOntology(ontB.get(0).getId());
				ontRel.setNativeOntology(ontA.get(0).getId());
				direction = new Boolean(false);
				
				logger.debug("Direction Ontology Native -> Ontology Interchange");
			} else {
				logger.debug("Both Ontologies of the same type");
				
				return new MapperList(result);
			}
			
			List<OntRelation> ontAB = translationRepository.select(ontRel);
			if(ontAB.size() > 0) {
				
				logger.debug("Ontology Relation exists");
				
				OntTranslation ontTrans = new OntTranslation();
				ontTrans.setRelationID(ontAB.get(0).getId());
				if(direction.booleanValue()) {
					ontTrans.setFromConcept(fromConcept.toLowerCase());
				} else {
					ontTrans.setToConcept(fromConcept.toLowerCase());
				}
				
				List<OntTranslation> trans = translationRepository.select(ontTrans);
				if(trans.size() > 0) {
					result = new String[trans.size()];
					for(int i = 0; i < trans.size(); i++) {
						if(direction.booleanValue()) {
							
							logger.debug(i + " = " + trans.get(i).getToConcept());
							
							result[i] = trans.get(i).getToConcept();
						} else {
							logger.debug(i + " = " + trans.get(i).getFromConcept());
							
							result[i] = trans.get(i).getFromConcept();
						}
					}
				} else {
					logger.debug("There is no translation");
				}
			} else {
				logger.debug("Ontology Relation does not exist");
			}
		} else {
			if(ontA.size() <= 0) {
				logger.debug("Ontology From does not exist");
			}
			if(ontB.size() <= 0) {
				logger.debug("Ontology To does not exist");
			}
		}
		
		return new MapperList(result);
		
	}
}