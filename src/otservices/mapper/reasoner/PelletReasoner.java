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
package otservices.mapper.reasoner;

import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.inference.pellet.ProtegePelletOWLAPIReasoner;
import edu.stanford.smi.protegex.owl.inference.protegeowl.ReasonerManager;
import edu.stanford.smi.protegex.owl.inference.reasoner.ProtegeReasoner;
import edu.stanford.smi.protegex.owl.inference.reasoner.exception.ProtegeReasonerException;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.model.RDFSNamedClass;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.log4j.Logger;

<<<<<<< HEAD
public class PelletReasoner implements ReasonerInterface {
=======
public class PelletReasoner implements ReasonerInterface{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	// Reasoner connection status
	private Boolean					connected				= new Boolean(false);
	
	// Responsible for the logging
	private static Logger		logger					= Logger
																							.getLogger(PelletReasoner.class
																									.getName());
	
	// OWL filename
	private String					owlFilename			= null;
	
	// OWL handling model
	private OWLModel				owlModel				= null;
	
	// Protege Reasoner
	private ProtegeReasoner	reasoner				= null;
	
	// Reasoner instance
	private ReasonerManager	reasonerManager	= ReasonerManager.getInstance();
	
	
	/**
	 * Empty constructor
	 * 
	 * @param none
	 * @return none
	 */
<<<<<<< HEAD
	public PelletReasoner() {
	}
	
	
=======
	public PelletReasoner(){
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the OWL filename and connects the module to the reasoner
	 * 
	 * @param owlFilename
	 *          OWL filename
	 * @return none
	 */
<<<<<<< HEAD
	public PelletReasoner(String owlFilename) {
		if(this.setOWL(owlFilename).booleanValue()) {
=======
	public PelletReasoner(String owlFilename){
		if(this.setOWL(owlFilename).booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.connect();
			
			logger.debug("PelletReasoner Initialized");
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Returns the OWL filename
	 * 
	 * @param none
	 * @return OWL filename
	 */
	@Override
<<<<<<< HEAD
	public String getOWL() {
=======
	public String getOWL(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		logger.debug("OWL file name = " + this.owlFilename);
		
		return this.owlFilename;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the OWL filename
	 * 
	 * @param owlFilename
	 *          OWL filename
	 * @return true if file exists; false otherwise
	 */
	@Override
<<<<<<< HEAD
	public Boolean setOWL(String owlFilename) {
		Boolean result = new Boolean(true);
		
		if(new File(owlFilename).exists()) {
			try {
				this.owlModel = ProtegeOWL
						.createJenaOWLModelFromInputStream(new FileInputStream(owlFilename));
			} catch(Exception e) {
=======
	public Boolean setOWL(String owlFilename){
		Boolean result = new Boolean(true);
		
		if(new File(owlFilename).exists()){
			try{
				this.owlModel = ProtegeOWL
						.createJenaOWLModelFromInputStream(new FileInputStream(owlFilename));
			}catch(Exception e){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				
				logger.error("Error while creating JenaOWLModel");
				logger.error(e);
				
				this.owlFilename = null;
				return new Boolean(false);
			}
			
			logger.debug("OWL file " + owlFilename + " set successfully");
			
			this.owlFilename = owlFilename;
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error(owlFilename + " does not exist");
			
			result = new Boolean(false);
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Connect the module to the reasoner
	 * 
	 * @param none
	 * @return none
	 */
	@Override
<<<<<<< HEAD
	public void connect() {
		if(this.owlModel != null) {
=======
	public void connect(){
		if(this.owlModel != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.reasoner = this.reasonerManager.createProtegeReasoner(this.owlModel,
					ProtegePelletOWLAPIReasoner.class);
			
			logger.debug("Connected to Reasoner");
			
			connected = new Boolean(true);
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("owlModel not set, use the method setOWL(owlFilename)");
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the reasoner connection status
	 * 
	 * @param none
	 * @return true if connected; false otherwise
	 */
	@Override
<<<<<<< HEAD
	public Boolean isConnected() {
=======
	public Boolean isConnected(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		logger.debug("Reasoner Connection Status = " + this.connected.toString());
		
		return this.connected;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Disconnects the module to the reasoner
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
		logger.debug("Reasoner Disconnected");
		
		this.reasoner = null;
		this.connected = new Boolean(false);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Classify the ontology uploaded from the OWL file
	 * 
	 * @param none
	 * @return true if was possible to classify; false otherwise
	 */
	@Override
<<<<<<< HEAD
	public Boolean classify() {
		try {
=======
	public Boolean classify(){
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.reasoner.classifyTaxonomy();
			
			logger.debug("Ontology classified successfully");
			
<<<<<<< HEAD
		} catch(ProtegeReasonerException pre) {
=======
		}catch(ProtegeReasonerException pre){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			logger.error("Error while classifing Ontology");
			logger.error("ProtegeReasonerException  Message " + pre);
			
			return new Boolean(false);
		}
		
		return new Boolean(true);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Returns a list of inferred classes under a specific class
	 * 
	 * @param fromClass
	 *          Class under which the other classes are related
	 * @return Collection of inferred classes
	 */
	@Override
<<<<<<< HEAD
	public Collection<String> getInferredClasses(String fromClass) {
		Collection<String> inferredClasses = new ArrayList<String>();
		
		if((this.isConnected().booleanValue()) && (owlModel != null)) {
=======
	public Collection<String> getInferredClasses(String fromClass){
		Collection<String> inferredClasses = new ArrayList<String>();
		
		if((this.isConnected().booleanValue()) && (owlModel != null)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			String defaultNamespace = this.owlModel.getNamespaceManager()
					.getDefaultNamespace();
			
			OWLNamedClass owlClass = owlModel.getOWLNamedClass(fromClass);
			
			Collection<String> assertedClasses = this.getAssertedClasses(fromClass,
					new Boolean(false));
			
			Collection<OWLNamedClass> inferred = owlClass.getInferredSubclasses();
			
			logger.debug("Inferred Classes");
			
<<<<<<< HEAD
			for(Iterator<OWLNamedClass> i = inferred.iterator(); i.hasNext();) {
				OWLNamedClass namedClass = i.next();
				
				String assertedClassName = namedClass.getName();
				if(assertedClassName.startsWith(defaultNamespace)) {
					assertedClassName = assertedClassName.substring(defaultNamespace
							.length());
					
					if(!assertedClasses.contains(assertedClassName)) {
=======
			for(Iterator<OWLNamedClass> i = inferred.iterator(); i.hasNext();){
				OWLNamedClass namedClass = i.next();
				
				String assertedClassName = namedClass.getName();
				if(assertedClassName.startsWith(defaultNamespace)){
					assertedClassName = assertedClassName.substring(defaultNamespace
							.length());
					
					if(!assertedClasses.contains(assertedClassName)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						
						inferredClasses.add(assertedClassName);
						
						logger.debug(assertedClassName);
					}
				}
			}
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("Reasoner is not connected or OWL file name not set");
		}
		
		return inferredClasses;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return a list of all asserted classes under this class
	 * 
	 * @param forClass
	 *          Class under which the other classes are related
	 * @return Collection of all asserted classes
	 */
	@Override
<<<<<<< HEAD
	public Collection<String> getAllAssertedClasses() {
		Collection<String> allAssertedClasses = new ArrayList<String>();
		
		if((this.isConnected().booleanValue()) && (this.owlModel != null)) {
=======
	public Collection<String> getAllAssertedClasses(){
		Collection<String> allAssertedClasses = new ArrayList<String>();
		
		if((this.isConnected().booleanValue()) && (this.owlModel != null)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			String defaultNamespace = this.owlModel.getNamespaceManager()
					.getDefaultNamespace();
			
			OWLNamedClass named = this.owlModel.getOWLThingClass();
			
			Collection<RDFSNamedClass> asserted = named.getNamedSubclasses(true);
			
			logger.debug("All Asserted Classes");
			
<<<<<<< HEAD
			for(Iterator<RDFSNamedClass> i = asserted.iterator(); i.hasNext();) {
				RDFSNamedClass assertedClass = i.next();
				
				String assertedClassName = assertedClass.getName();
				if(assertedClassName.startsWith(defaultNamespace)) {
=======
			for(Iterator<RDFSNamedClass> i = asserted.iterator(); i.hasNext();){
				RDFSNamedClass assertedClass = i.next();
				
				String assertedClassName = assertedClass.getName();
				if(assertedClassName.startsWith(defaultNamespace)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					assertedClassName = assertedClassName.substring(defaultNamespace
							.length());
					
					allAssertedClasses.add(assertedClassName);
					
					logger.debug(assertedClassName);
				}
			}
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("Reasoner is not connected or OWL file name not set");
		}
		
		return allAssertedClasses;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return a list of asserted classes under this class
	 * 
	 * @param forClass
	 *          Class under which the other classes are related
	 * @param all
	 *          true if all the asserted; false otherwise
	 * @return Collection of asserted classes
	 */
	@Override
<<<<<<< HEAD
	public Collection<String> getAssertedClasses(String forClass, Boolean all) {
		Collection<String> allAssertedClasses = new ArrayList<String>();
		
		if((this.isConnected().booleanValue()) && (this.owlModel != null)) {
=======
	public Collection<String> getAssertedClasses(String forClass, Boolean all){
		Collection<String> allAssertedClasses = new ArrayList<String>();
		
		if((this.isConnected().booleanValue()) && (this.owlModel != null)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			String defaultNamespace = this.owlModel.getNamespaceManager()
					.getDefaultNamespace();
			
			OWLNamedClass named = this.owlModel.getOWLNamedClass(forClass);
			
			Collection<RDFSNamedClass> asserted = named.getNamedSubclasses(all
					.booleanValue());
			
			logger.debug("Asserted Classes");
			
<<<<<<< HEAD
			for(Iterator<RDFSNamedClass> i = asserted.iterator(); i.hasNext();) {
				RDFSNamedClass assertedClass = i.next();
				
				String assertedClassName = assertedClass.getName();
				if(assertedClassName.startsWith(defaultNamespace)) {
=======
			for(Iterator<RDFSNamedClass> i = asserted.iterator(); i.hasNext();){
				RDFSNamedClass assertedClass = i.next();
				
				String assertedClassName = assertedClass.getName();
				if(assertedClassName.startsWith(defaultNamespace)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					allAssertedClasses.add(assertedClassName.substring(defaultNamespace
							.length()));
				}
				
				logger.debug(assertedClass.getName());
			}
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			logger.error("Reasoner is not connected or OWL file name not set");
		}
		
		return allAssertedClasses;
	}
}