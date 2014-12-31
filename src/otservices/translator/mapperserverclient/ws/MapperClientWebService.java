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

<<<<<<< HEAD
public class MapperClientWebService implements MapperClientWebServiceInterface {
=======
public class MapperClientWebService implements MapperClientWebServiceInterface{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
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
<<<<<<< HEAD
	public MapperClientWebService() {
=======
	public MapperClientWebService(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	}
	
	
	/**
	 * Constructor method
	 * 
	 * @param URL
	 *          Web Service URL
	 * @return none
	 */
<<<<<<< HEAD
	public MapperClientWebService(String url) {
=======
	public MapperClientWebService(String url){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			Ontology ontNative, String ontFile) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null) && (ontFile != null)) {
			
			if(new File(ontFile).exists()) {
				try {
=======
			Ontology ontNative, String ontFile){
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null) && (ontFile != null)){
			
			if(new File(ontFile).exists()){
				try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
				} catch(RemoteException re) {
					logger.error("RemoteException Message " + re);
				} catch(RemoteExceptionException0 ree0) {
					logger.error("RemoteExceptionException0 Message " + ree0);
				}
			} else {
=======
				}catch(RemoteException re){
					logger.error("RemoteException Message " + re);
				}catch(RemoteExceptionException0 ree0){
					logger.error("RemoteExceptionException0 Message " + ree0);
				}
			}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
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
=======
	public Boolean connect(){
		Boolean result = new Boolean(false);
		
		if((this.url != null) && (!this.isConnected().booleanValue())){
			try{
				this.stub = new MapperServerWebServiceImplStub(this.url);
				result = new Boolean(true);
			}catch(AxisFault af){
				logger.error("AxisFault Message " + af);
			}
		}else{
			if(this.url == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				logger.debug("URL is NULL");
			}
		}
		
<<<<<<< HEAD
		if(result.booleanValue()) {
			logger.debug("Client is connected");
		} else {
=======
		if(result.booleanValue()){
			logger.debug("Client is connected");
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	private MapperServerWebServiceImplStub.Ontology copyOntology(Ontology ontIn) {
=======
	private MapperServerWebServiceImplStub.Ontology copyOntology(Ontology ontIn){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public void disconnect() {
=======
	public void disconnect(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			Ontology ontInterchange, Ontology ontNative) {
		Map<String, String[]> result = null;
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
=======
			Ontology ontInterchange, Ontology ontNative){
		Map<String, String[]> result = null;
		
		if((ontInterchange != null) && (ontNative != null)){
			try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
				
<<<<<<< HEAD
				if(fromConcepts.length > 0) {
=======
				if(fromConcepts.length > 0){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					result = new HashMap<String, String[]>();
					
					MapperServerWebServiceImplStub.TranslateConcept translate = new MapperServerWebServiceImplStub.TranslateConcept();
					translate.setOntFrom(ontI);
					translate.setOntTo(ontN);
<<<<<<< HEAD
					for(int i = 0; i < fromConcepts.length; i++) {
=======
					for(int i = 0; i < fromConcepts.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						translate.setFromConcept(fromConcepts[i]);
						
						MapperServerWebServiceImplStub.TranslateConceptResponse transResponse = stub
								.translateConcept(translate);
						
						MapperServerWebServiceImplStub.MapperList toConcepts = transResponse
								.get_return();
						
						result.put(fromConcepts[i], toConcepts.getList());
					}
<<<<<<< HEAD
				} else {
					logger.debug("There is no concepts for translation");
				}
			} catch(RemoteException re) {
=======
				}else{
					logger.debug("There is no concepts for translation");
				}
			}catch(RemoteException re){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				System.out.println(re);
				re.printStackTrace();
				logger.debug("RemoteException Message " + re);
			}
<<<<<<< HEAD
		} else {
			if(ontInterchange == null) {
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null) {
=======
		}else{
			if(ontInterchange == null){
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			String owlFilename) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
=======
			String owlFilename){
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)){
			try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
				while(true) {
=======
				while(true){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
				
<<<<<<< HEAD
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
=======
			}catch(FileNotFoundException fnfe){
				logger.error("FileNotFoundException Message " + fnfe);
			}catch(IOException ioe){
				logger.error("IOException Message " + ioe);
			}
		}else{
			if(ontInterchange == null){
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public Boolean isConnected() {
=======
	public Boolean isConnected(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
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
<<<<<<< HEAD
			Ontology ontNative) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
=======
			Ontology ontNative){
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)){
			try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			} catch(RemoteException re) {
				logger.error("RemoteException Message " + re);
			}
		} else {
			if(ontInterchange == null) {
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null) {
=======
			}catch(RemoteException re){
				logger.error("RemoteException Message " + re);
			}
		}else{
			if(ontInterchange == null){
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			Ontology ontNative) {
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)) {
			try {
=======
			Ontology ontNative){
		Boolean result = new Boolean(false);
		
		if((ontInterchange != null) && (ontNative != null)){
			try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			} catch(RemoteException re) {
				logger.debug("RemoteException Message " + re);
			}
		} else {
			if(ontInterchange == null) {
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null) {
=======
			}catch(RemoteException re){
				logger.debug("RemoteException Message " + re);
			}
		}else{
			if(ontInterchange == null){
				logger.debug("Ontology ontInterchange is NULL");
			}
			if(ontNative == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public void setURL(String url) {
=======
	public void setURL(String url){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			Ontology ontTo) {
		
		String[] result = null;
		
		try {
=======
			Ontology ontTo){
		
		String[] result = null;
		
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
			if(result.length == 1) {
				if(result[0] == null) {
					logger.debug("translateConcept Result = NULL");
					
					result = null;
				} else {
					logger.debug("translateConcept Result(s)");
					for(int i = 0; i < result.length; i++) {
=======
			if(result.length == 1){
				if(result[0] == null){
					logger.debug("translateConcept Result = NULL");
					
					result = null;
				}else{
					logger.debug("translateConcept Result(s)");
					for(int i = 0; i < result.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						logger.debug(result[i]);
					}
				}
			}
<<<<<<< HEAD
		} catch(RemoteException re) {
=======
		}catch(RemoteException re){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.debug("RemoteException Message " + re);
		}
		
		return result;
	}
}