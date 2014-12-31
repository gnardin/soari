/**
 * Copyright (c) 2008-2011 Luis Gustavo Nardin <gnardin@gmail.com>
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
package otservices.mapper.classifier;

import java.util.List;
import org.apache.log4j.Logger;
import otservices.mapper.reasoner.PelletReasoner;
import otservices.mapper.reasoner.ReasonerInterface;
import otservices.mapper.translationrepository.OntRelation;
import otservices.mapper.translationrepository.OntTranslation;
import otservices.mapper.translationrepository.TranslationRepository;
import otservices.util.configuration.ConfigurationElementNotFoundException;
import otservices.util.configuration.ConfigurationParser;

<<<<<<< HEAD
public class Classifier {
=======
public class Classifier{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	// Classifier configuration
	private ConfigurationParser		classifierConfiguration	= null;
	
	// Responsible for the logging
	private static Logger					logger									= Logger
																														.getLogger(Classifier.class
																																.getName());
	
	// Reasoner
	private ReasonerInterface			reasoner								= null;
	
	// Translation repository
	private TranslationRepository	translationRepository		= null;
	
	
	/**
	 * Empty constructor
	 * 
	 * @param none
	 * @return none
	 */
<<<<<<< HEAD
	protected Classifier() {
	}
	
	
=======
	protected Classifier(){
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Initializes the classifier
	 * 
	 * @param classifierConfiguration
	 *          Configuration parameters for the classifier
	 * @param translationRepository
	 *          Translation repository controller
	 * @return none
	 */
	public Classifier(ConfigurationParser classifierConfiguration,
<<<<<<< HEAD
			TranslationRepository translationRepository) {
=======
			TranslationRepository translationRepository){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		this.classifierConfiguration = classifierConfiguration;
		this.translationRepository = translationRepository;
		this.reasoner = new PelletReasoner();
		
		logger.debug("Classifier Initialized");
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Classifies an ontology and add its result to the translation repository
	 * 
	 * @param ontRelation
	 *          Ontology relation that contains the information about the two
	 *          ontologies to classify and the file that contain its mappings
	 * @return none
	 */
<<<<<<< HEAD
	public void classify(OntRelation ontRelation) {
=======
	public void classify(OntRelation ontRelation){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		this.reasoner.setOWL(this.getOWLDirectory() + "/"
				+ ontRelation.getFilename());
		
		this.reasoner.connect();
		
<<<<<<< HEAD
		if(this.reasoner.isConnected().booleanValue()) {
			
			if(this.reasoner.classify().booleanValue()) {
=======
		if(this.reasoner.isConnected().booleanValue()){
			
			if(this.reasoner.classify().booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				List<String> allAssertedClasses = (List<String>) this.reasoner
						.getAllAssertedClasses();
				
				List<String> inferredClasses;
<<<<<<< HEAD
				for(String fromConcept : allAssertedClasses) {
					inferredClasses = (List<String>) this.reasoner
							.getInferredClasses(fromConcept);
					
					for(String inferred : inferredClasses) {
=======
				for(String fromConcept : allAssertedClasses){
					inferredClasses = (List<String>) this.reasoner
							.getInferredClasses(fromConcept);
					
					for(String inferred : inferredClasses){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						OntTranslation ontTranslation = new OntTranslation();
						ontTranslation.setRelationID(ontRelation.getId());
						ontTranslation.setFromConcept(fromConcept.toLowerCase());
						ontTranslation.setToConcept(inferred.toLowerCase());
						
						logger.debug("Relation ID  = " + ontTranslation.getRelationID());
						logger.debug("From Concept = "
								+ ontTranslation.getFromConcept().toLowerCase());
						logger.debug("To Concept   = "
								+ ontTranslation.getToConcept().toLowerCase());
						
						this.translationRepository.insert(ontTranslation);
					}
				}
			}
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Returns the OWL directory repository path
	 * 
	 * @param none
	 * @return OWL directory path
	 */
<<<<<<< HEAD
	public String getOWLDirectory() {
		String owlDirectory = null;
		
		try {
			owlDirectory = ((String) (this.classifierConfiguration
					.get("owlDirectory")));
		} catch(ConfigurationElementNotFoundException cenfe) {
=======
	public String getOWLDirectory(){
		String owlDirectory = null;
		
		try{
			owlDirectory = ((String) (this.classifierConfiguration
					.get("owlDirectory")));
		}catch(ConfigurationElementNotFoundException cenfe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("ConfigurationElementNotFoundException Message " + cenfe);
		}
		
		return owlDirectory;
	}
}
