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
package otservices.translator.mapperserverclient.ws;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;
import otservices.mapper.translationrepository.Ontology;
import otservices.mapper.webservice.MapperServerWebServiceImplStub;
import otservices.mapper.webservice.RemoteExceptionException0;

public class MapperClientWebService implements MapperClientWebServiceInterface {
	
	// Indicate if the client is pointing to a server
	private Boolean													connected	= new Boolean(false);
	
	// Responsible for the logging
	private static Logger										logger		= Logger
																												.getLogger(MapperClientWebService.class
																														.getName());
	
	// Web Service URL
	private String													url				= null;
	
	// Stub to connect to the WSReputationMappingServer
	private MapperServerWebServiceImplStub	stub;
	
	
	/**
	 * Constructor method
	 * 
	 * @param none
	 * @return none
	 */
	public MapperClientWebService() {
	}
	
	
	/**
	 * Constructor method
	 * 
	 * @param URL
	 *          Web Service URL
	 * @return none
	 */
	public MapperClientWebService(String url) {
		this.url = url;
	}
	
	
	/**
	 * Add an Ontology Translation into the Database
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @param ontFile
	 *          Ontology filename
	 * @return true - if the ontology translation was performed / false -
	 *         otherwise
	 */
	@Override
	public Boolean addOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative, String ontFile) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null) && (ontFile != null)) {
			
			if(new File(ontFile).exists()) {
				try {
					MapperServerWebServiceImplStub.Ontology ontI = this
							.copyOntology(ontInterchange);
					MapperServerWebServiceImplStub.Ontology ontN = this
							.copyOntology(ontNative);
					
					MapperServerWebServiceImplStub.AddOntologyTranslation add = new MapperServerWebServiceImplStub.AddOntologyTranslation();
					add.setOntFile(ontFile);
					add.setOntInterchange(ontI);
					add.setOntNative(ontN);
					add.setDataHandler(new DataHandler(new FileDataSource(ontFile)));
					
					MapperServerWebServiceImplStub.AddOntologyTranslationResponse response = stub
							.addOntologyTranslation(add);
					
					result = new Boolean(response.get_return());
				} catch(RemoteException re) {
					logger.error("RemoteException Message " + re);
				} catch(RemoteExceptionException0 ree0) {
					logger.error("RemoteExceptionException0 Message " + ree0);
				}
			} else {
				logger.error("FileNotFoundException Message = File name = " + ontFile);
			}
		}
		
		return result;
	}
	
	
	/**
	 * Connects the client to the server
	 * 
	 * @param none
	 * @return true - if successfully connected / false - otherwise
	 */
	@Override
	public Boolean connect() {
		Boolean result = new Boolean(false);
		
		if((this.url != null) && (!this.isConnected().booleanValue())) {
			try {
				this.stub = new MapperServerWebServiceImplStub(this.url);
				result = new Boolean(true);
			} catch(AxisFault af) {
				logger.error("AxisFault Message " + af);
			}
		} else {
			if(this.url == null) {
				logger.debug("URL is NULL");
			}
		}
		
		if(result.booleanValue()) {
			logger.debug("Client is connected");
		} else {
			logger.debug("Client is not connected");
		}
		this.connected = result;
		return result;
	}
	
	
	/**
	 * Copy the content of an Ontology object into an
	 * OMSWebServiceServerStub.Ontology object
	 * 
	 * @param ontIn
	 *          Source ontology
	 * @return Target ontology
	 */
	private MapperServerWebServiceImplStub.Ontology copyOntology(Ontology ontIn) {
		MapperServerWebServiceImplStub.Ontology ontOut = new MapperServerWebServiceImplStub.Ontology();
		
		if(ontIn.getId() != null)
			ontOut.setId(ontIn.getId().intValue());
		
		if(ontIn.getType() != null)
			ontOut.setType(ontIn.getType().intValue());
		
		if(ontIn.getUri() != null)
			ontOut.setUri(ontIn.getUri());
		
		if(ontIn.getVersion() != null)
			ontOut.setVersion(ontIn.getVersion().intValue());
		
		if(ontIn.getDescription() != null)
			ontOut.setDescription(ontIn.getDescription());
		
		return ontOut;
	}
	
	
	/**
	 * Disconnects the client from the server
	 * 
	 * @param none
	 * @return none
	 */
	@Override
	public void disconnect() {
		this.url = null;
		this.stub = null;
		this.connected = new Boolean(false);
		
		logger.debug("disconnected WebService Client");
	}
	
	
	/**
	 * Returns all mapping translation from an ontInterchange ontology to
	 * ontNative ontology
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return Returns an array containing all the translation for those
	 *         ontology relation
	 */
	@Override
	public Map<String, String[]> getInterchangeNativeMapping(
			Ontology ontInterchange, Ontology ontNative) {
		Map<String, String[]> result = null;
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
				MapperServerWebServiceImplStub.Ontology ontI = this
						.copyOntology(ontInterchange);
				MapperServerWebServiceImplStub.Ontology ontN = this
						.copyOntology(ontNative);
				
				MapperServerWebServiceImplStub.GetFromMapping fromMapping = new MapperServerWebServiceImplStub.GetFromMapping();
				fromMapping.setOntInterchange(ontI);
				fromMapping.setOntNative(ontN);
				
				MapperServerWebServiceImplStub.GetFromMappingResponse response = stub
						.getFromMapping(fromMapping);
				
				String[] fromConcepts = response.get_return();
				
				if(fromConcepts.length > 0) {
					result = new HashMap<String, String[]>();
					
					MapperServerWebServiceImplStub.TranslateConcept translate = new MapperServerWebServiceImplStub.TranslateConcept();
					translate.setOntFrom(ontI);
					translate.setOntTo(ontN);
					for(int i = 0; i < fromConcepts.length; i++) {
						translate.setFromConcept(fromConcepts[i]);
						
						MapperServerWebServiceImplStub.TranslateConceptResponse transResponse = stub
								.translateConcept(translate);
						
						MapperServerWebServiceImplStub.MapperList toConcepts = transResponse
								.get_return();
						
						result.put(fromConcepts[i], toConcepts.getList());
					}
				} else {
					logger.debug("There is no concepts for translation");
				}
			} catch(RemoteException re) {
				System.out.println(re);
				re.printStackTrace();
				logger.debug("RemoteException Message " + re);
			}
		} else {
			if(ontInterchange == null) {
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null) {
				logger.debug("Ontology ontNative is NULL");
			}
		}
		
		return result;
	}
	
	
	/**
	 * Download a OWL file to a local filesystem
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @param owlFilename
	 *          Absolute filename to save the file
	 * @return true - if download was successful / false - otherwise
	 */
	@Override
	public Boolean getOWLFile(Ontology ontInterchange, Ontology ontNative,
			String owlFilename) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
				MapperServerWebServiceImplStub.Ontology ontI = this
						.copyOntology(ontInterchange);
				MapperServerWebServiceImplStub.Ontology ontN = this
						.copyOntology(ontNative);
				
				MapperServerWebServiceImplStub.GetOWLFile owlFile = new MapperServerWebServiceImplStub.GetOWLFile();
				owlFile.setOntInterchange(ontI);
				owlFile.setOntNative(ontN);
				
				MapperServerWebServiceImplStub.GetOWLFileResponse response = stub
						.getOWLFile(owlFile);
				
				DataHandler dataHandler = response.get_return();
				
				BufferedInputStream in = new BufferedInputStream(
						dataHandler.getInputStream());
				
				BufferedOutputStream out = new BufferedOutputStream(
						new FileOutputStream(owlFilename));
				
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
				
				logger.debug("File " + owlFile + " salved successfully");
				
				logger.debug("mapperController.getOWLFile");
				
				result = new Boolean(true);
				
			} catch(FileNotFoundException fnfe) {
				logger.error("FileNotFoundException Message " + fnfe);
			} catch(IOException ioe) {
				logger.error("IOException Message " + ioe);
			}
		} else {
			if(ontInterchange == null) {
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null) {
				logger.debug("Ontology ontNative is NULL");
			}
		}
		return result;
	}
	
	
	/**
	 * Indicates if the client is connected to the server
	 * 
	 * @param none
	 * @return true - if it is connected / false - otherwise
	 */
	@Override
	public Boolean isConnected() {
		
		if(this.connected.booleanValue())
			logger.debug("WebService is connected");
		else
			logger.debug("WebService is not connected");
		
		return this.connected;
	}
	
	
	/**
	 * Verify if there is an Ontology Relation between the interchange ontology
	 * and the native ontology
	 * 
	 * @param ontInterchange
	 *          Intechange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return true - if there is an ontology relation / false - otherwise
	 */
	@Override
	public Boolean isOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
				MapperServerWebServiceImplStub.Ontology ontI = this
						.copyOntology(ontInterchange);
				MapperServerWebServiceImplStub.Ontology ontN = this
						.copyOntology(ontNative);
				
				MapperServerWebServiceImplStub.IsOntologyTranslation is = new MapperServerWebServiceImplStub.IsOntologyTranslation();
				is.setOntInterchange(ontI);
				is.setOntNative(ontN);
				
				MapperServerWebServiceImplStub.IsOntologyTranslationResponse response = stub
						.isOntologyTranslation(is);
				
				result = new Boolean(response.get_return());
			} catch(RemoteException re) {
				logger.error("RemoteException Message " + re);
			}
		} else {
			if(ontInterchange == null) {
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null) {
				logger.debug("Ontology ontNative is NULL");
			}
		}
		
		logger.debug("Result = " + result.booleanValue());
		return result;
	}
	
	
	/**
	 * Remove an ontology translation from the translation repository
	 * 
	 * @param ontInterchange
	 *          Intechange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return true - if translation exists and it was removed / false -
	 *         otherwise
	 */
	@Override
	public Boolean removeOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
				MapperServerWebServiceImplStub.Ontology ontI = this
						.copyOntology(ontInterchange);
				MapperServerWebServiceImplStub.Ontology ontN = this
						.copyOntology(ontNative);
				
				MapperServerWebServiceImplStub.RemoveOntologyTranslation remove = new MapperServerWebServiceImplStub.RemoveOntologyTranslation();
				remove.setOntInterchange(ontI);
				remove.setOntNative(ontN);
				
				MapperServerWebServiceImplStub.RemoveOntologyTranslationResponse response = stub
						.removeOntologyTranslation(remove);
				
				result = new Boolean(response.get_return());
			} catch(RemoteException re) {
				logger.debug("RemoteException Message " + re);
			}
		} else {
			if(ontInterchange == null) {
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null) {
				logger.debug("Ontology ontNative is NULL");
			}
		}
		
		return result;
	}
	
	
	/**
	 * Set the Web Service URL
	 * 
	 * @param URL
	 *          Web Service URL
	 * @return none
	 */
	@Override
	public void setURL(String url) {
		this.url = url;
	}
	
	
	/**
	 * Returns a list of all the concepts that translate from fromConcept in
	 * ontFrom to ontTo
	 * 
	 * @param fromConcept
	 *          Concept to be translated
	 * @param ontFrom
	 *          Source ontology
	 * @param ontTo
	 *          Target ontology
	 * @return List of concepts related to the fromConcept
	 */
	@Override
	public String[] translateConcept(String fromConcept, Ontology ontFrom,
			Ontology ontTo) {
		
		String[] result = null;
		
		try {
			MapperServerWebServiceImplStub.Ontology ontF = this.copyOntology(ontFrom);
			MapperServerWebServiceImplStub.Ontology ontT = this.copyOntology(ontTo);
			
			MapperServerWebServiceImplStub.TranslateConcept translate = new MapperServerWebServiceImplStub.TranslateConcept();
			translate.setFromConcept(fromConcept);
			translate.setOntFrom(ontF);
			translate.setOntTo(ontT);
			
			MapperServerWebServiceImplStub.TranslateConceptResponse response = stub
					.translateConcept(translate);
			
			MapperServerWebServiceImplStub.MapperList translation = response
					.get_return();
			
			result = translation.getList();
			
			// This part of the code detects when the result should be NULL,
			// despite it is not indicating so. Its a trick to workaround an Web
			// Service problem when receiving an object as a response back
			if(result.length == 1) {
				if(result[0] == null) {
					logger.debug("translateConcept Result = NULL");
					
					result = null;
				} else {
					logger.debug("translateConcept Result(s)");
					for(int i = 0; i < result.length; i++) {
						logger.debug(result[i]);
					}
				}
			}
		} catch(RemoteException re) {
			logger.debug("RemoteException Message " + re);
		}
		
		return result;
	}
}