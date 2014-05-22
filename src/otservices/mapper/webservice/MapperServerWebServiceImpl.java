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
package otservices.mapper.webservice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import org.apache.log4j.Logger;
import otservices.mapper.MapperController;
import otservices.mapper.translationrepository.Ontology;
import otservices.util.configuration.ConfigurationParser;

public class MapperServerWebServiceImpl implements
		MapperServerWebServiceInterface {
	
	// Responsible for the logging
	private static Logger	logger	= Logger
																		.getLogger(MapperServerWebServiceImpl.class
																				.getName());
	
	// Ontology Mapping Service controller
	MapperController			mapperController;
	
	
	/**
	 * WebService Constructor
	 * 
	 * mapperserverwebservice.xml and mapperserverwebservice.xsd must be placed
	 * at the $AXIS_HOME directory when using Windows and on local directory where
	 * you run the AXIS2 when using Linux/Unix
	 * 
	 * @param none
	 * @return none
	 */
	public MapperServerWebServiceImpl() throws Exception {
		
		ConfigurationParser conf = new ConfigurationParser(
				"mapperserverwebservice.xml", "mapperserverwebservice.xsd");
		
		this.mapperController = MapperController.getInstance(
				(String) conf.get("confXMLFilename"),
				(String) conf.get("confXSDFilename"), (String) conf.get("logFilename"));
		
		logger.debug("mapperController Instance obtained");
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
	 * @param dh
	 *          File data handler
	 * @return true - if the ontology translation was performed / false -
	 *         otherwise
	 * @throws RemoteException
	 */
	@Override
	public Boolean addOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative, String ontFile, DataHandler dataHandler)
			throws RemoteException {
		Boolean result = new Boolean(false);
		
		logger.debug("Entered MapperServerWebServiceImpl addOntologyTranslation");
		
		String filename = new File(ontFile).getName();
		String absoluteFilename = this.mapperController.getTransferDirectory()
				+ "/" + filename;
		
		logger.debug("Saving file " + filename + " to "
				+ this.mapperController.getTransferDirectory());
		
		try {
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(
					absoluteFilename));
			BufferedInputStream in = new BufferedInputStream(
					dataHandler.getInputStream());
			
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
			
			logger.debug("File salved successfully");
			
			logger.debug("mapperController.addOntologyTranslation");
			
			result = this.mapperController.addOntologyTranslation(ontInterchange,
					ontNative, absoluteFilename);
			
			new File(absoluteFilename).delete();
			
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
	@Override
	public String[] getFromMapping(Ontology ontInterchange, Ontology ontNative) {
		
		logger.debug("Entered MapperServerWebServiceImpl getFromMapping");
		
		ontInterchange.setType(Ontology.TYPE_INTERCHANGE);
		ontNative.setType(Ontology.TYPE_NATIVE);
		
		logger.debug("Calling mapperController.getFromMapping");
		
		return this.mapperController.getFromMapping(ontInterchange, ontNative);
	}
	
	
	/**
	 * Returns a data handler representing the ontology relation file
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return Returns file containing all the concepts for those ontology
	 *         relation in OWL format
	 */
	@Override
	public DataHandler getOWLFile(Ontology ontInterchange, Ontology ontNative) {
		
		logger.debug("Entered MapperServerWebServiceImpl getOWLFile");
		
		ontInterchange.setType(Ontology.TYPE_INTERCHANGE);
		ontNative.setType(Ontology.TYPE_NATIVE);
		
		logger.debug("Calling mapperController.getOWLFile");
		
		String file = this.mapperController.getOWLFile(ontInterchange, ontNative);
		if(file != null) {
			logger.debug("OWL File = " + file);
			
			return new DataHandler(new FileDataSource(file));
		}
		
		return null;
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
		
		logger.debug("Entered MapperServerWebServiceImpl isOntologyTranslation");
		
		ontInterchange.setType(Ontology.TYPE_INTERCHANGE);
		ontNative.setType(Ontology.TYPE_NATIVE);
		
		logger.debug("Calling mapperController.isOntologyTranslation");
		
		return this.mapperController.isOntologyTranslation(ontInterchange,
				ontNative);
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
		
		logger
				.debug("Entered MapperServerWebServiceImpl removeOntologyTranslation");
		
		ontInterchange.setType(Ontology.TYPE_INTERCHANGE);
		ontNative.setType(Ontology.TYPE_NATIVE);
		
		logger.debug("Calling mapperController.removeOntologyTranslation");
		
		return this.mapperController.removeOntologyTranslation(ontInterchange,
				ontNative);
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
	public MapperList translateConcept(String fromConcept, Ontology ontFrom,
			Ontology ontTo) {
		
		logger.debug("Entered MapperServerWebServiceImpl translateConcept");
		
		logger.debug("Calling mapperController.translateConcept");
		
		return this.mapperController.translateConcept(ontFrom, ontTo, fromConcept);
	}
}