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
package otservices.translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import otservices.mapper.translationrepository.Ontology;
import otservices.translator.interactionmodule.InteractionModuleInterface;
import otservices.translator.language.LanguageFactory;
import otservices.translator.language.LanguageException;
import otservices.translator.language.LanguageInterface;
import otservices.translator.language.ObjectInterface;
import otservices.translator.language.sparql.SPARQLObject;
import otservices.translator.mapperserverclient.ws.MapperClientWebServiceInterface;
import otservices.translator.reputationreasoner.ReputationReasonerInterface;
import otservices.translator.strategy.TranslationStrategyInterface;
import otservices.translator.valuetransformation.ValueTransformationInterface;
import otservices.util.configuration.ConfigurationParser;
import otservices.util.log.Log;
import otservices.util.ObjectCopy;
import org.apache.log4j.Logger;

public class TranslatorController implements TranslatorConstants{
	
	// TranslatorController configuration values
	private ConfigurationParser							confTranslator;
	
	// ID
	String																	id;
	
	// Input Translation Strategy
	private TranslationStrategyInterface		inputTranslationStrategy;
	
	// Interaction Module
	private InteractionModuleInterface			interactionModule;
	
	// Internal query language
	private LanguageFactory									internalLanguage;
	
	// Internal query language name
	private String													internalLanguageName;
	
	// Connection status
	private Boolean													isConnected	= new Boolean(false);
	
	// Responsible for the logging
	private static Logger										logger			= Logger
																													.getLogger(TranslatorController.class
																															.getName());
	
	// Translation from Interchange ontology to Native ontology
	private Map<String, String[]>						mapInterchangeNative;
	
	// Translation from Native ontology to Interchange ontology
	private Map<String, String[]>						mapNativeInterchange;
	
	// Web Service mapper client
	private MapperClientWebServiceInterface	mapperClient;
	
	// Interchange Ontology Name
	private String													ontInterchangeName;
	
	// Interchange Ontology Version
	private Integer													ontInterchangeVersion;
	
	// Native Ontology Name
	private String													ontNativeName;
	
	// Native Ontology Version
	private Integer													ontNativeVersion;
	
	// Output Translation Strategy
	private TranslationStrategyInterface		outputTranslationStrategy;
	
	// Message Queue
	private Map<String, ObjectInterface>		stack;
	
	// Reputation Reasoner
	private ReputationReasonerInterface			reputationReasoner;
	
	// Web Service server URL
	private String													urlMapperServer;
	
	// Value Transformation Concept
	private String													valueTransformationConcept;
	
	// Value Transformation Class
	private ValueTransformationInterface		valueTransformationClass;
	
	
	/**
	 * Constructor method
	 * 
	 * @param XMLFilename
	 *          Configuration XML filename
	 * @param XSDFilename
	 *          Configuration schema specification filename
	 * @param logFilename
	 *          Log filename
	 * @return none
	 * @throws Exception
	 */
	public TranslatorController(String XMLFilename, String XSDFilename,
			String logFilename) throws Exception{
		
		// Initialize the logging
		try{
			new Log(logFilename);
		}catch(java.io.FileNotFoundException e){
			e.printStackTrace();
		}
		
		logger.debug("Logging initialized");
		logger.debug("Loaded log4j configuration file = " + logFilename);
		
		// Load the Translator configuration parameter values
		this.confTranslator = new ConfigurationParser(XMLFilename, XSDFilename);
		
		// Load Agent Name
		this.id = (String) confTranslator.get("id");
		
		// Initialize the map tables
		this.mapInterchangeNative = new HashMap<String, String[]>();
		this.mapNativeInterchange = new HashMap<String, String[]>();
		
		// Load and connects to the MapperServer URL
		this.urlMapperServer = (String) confTranslator.get("urlMapperServer");
		this.mapperClient = (MapperClientWebServiceInterface) getClass()
				.getClassLoader()
				.loadClass((String) confTranslator.get("mapperClientClass"))
				.newInstance();
		this.mapperClient.setURL(this.urlMapperServer);
		this.isConnected = this.mapperClient.connect();
		
		// Load the Native Ontology Name
		this.ontNativeName = (String) confTranslator.get("ontNativeName");
		
		// Load the Native Ontology Version
		this.ontNativeVersion = (Integer) confTranslator.get("ontNativeVersion");
		
		// Load the Interchange Ontology Name
		this.ontInterchangeName = (String) confTranslator.get("ontInterchangeName");
		
		// Load the Interchange Ontology Version
		this.ontInterchangeVersion = (Integer) confTranslator
				.get("ontInterchangeVersion");
		
		// Load the Internal Query Language name
		this.internalLanguageName = (String) confTranslator
				.get("internalLanguageName");
		
		// Load the Internal Query Language class
		this.internalLanguage = (LanguageFactory) getClass().getClassLoader()
				.loadClass((String) confTranslator.get("internalLanguageClass"))
				.newInstance();
		
		// Load the Input Translation Strategy class
		this.inputTranslationStrategy = (TranslationStrategyInterface) getClass()
				.getClassLoader()
				.loadClass((String) confTranslator.get("inputTranslationStrategyClass"))
				.newInstance();
		this.inputTranslationStrategy.setWebServices(ontInterchangeName,
				ontInterchangeVersion, ontNativeName, ontNativeVersion, mapperClient);
		
		// Load the Output Translation Strategy class
		this.outputTranslationStrategy = (TranslationStrategyInterface) getClass()
				.getClassLoader()
				.loadClass(
						(String) confTranslator.get("outputTranslationStrategyClass"))
				.newInstance();
		this.outputTranslationStrategy.setWebServices(ontInterchangeName,
				ontInterchangeVersion, ontNativeName, ontNativeVersion, mapperClient);
		
		// Load Reputation Reasoner
		this.reputationReasoner = (ReputationReasonerInterface) getClass()
				.getClassLoader()
				.loadClass((String) confTranslator.get("reputationReasonerClass"))
				.newInstance();
		this.reputationReasoner.setID(this.id);
		
		// Load the Value Transformation Concept
		this.valueTransformationConcept = ((String) confTranslator
				.get("valueTransformationConcept")).toLowerCase();
		
		// Load the Value Transformation class
		this.valueTransformationClass = (ValueTransformationInterface) getClass()
				.getClassLoader()
				.loadClass((String) confTranslator.get("valueTransformationClass"))
				.newInstance();
		
		this.stack = new Hashtable<String, ObjectInterface>();
		
		this.confTranslator = null;
	}
	
	
	/**
	 * Empty the message stack
	 * 
	 * @param none
	 * @return none
	 */
	public void clearStack(){
		this.stack.clear();
	}
	
	
	/**
	 * Return the Translator Controller id
	 * 
	 * @param none
	 * @return Translator Controller id
	 */
	public String getID(){
		return this.id;
	}
	
	
	/**
	 * Return the Input Translation Strategy interface
	 * 
	 * @param none
	 * @return Input Translation Strategy interface
	 */
	public TranslationStrategyInterface getInputTranslationStrategy(){
		return this.inputTranslationStrategy;
	}
	
	
	/**
	 * Return the Interaction Module interface
	 * 
	 * @param none
	 * @return Interaction Module interface
	 */
	public InteractionModuleInterface getInteractionModule(){
		return this.interactionModule;
	}
	
	
	/**
	 * Return the internal Language Parser interface
	 * 
	 * @param none
	 * @return Internal Language Parser interface
	 */
	public LanguageFactory getInternalLanguage(){
		return this.internalLanguage;
	}
	
	
	/**
	 * Return the Internal Language Name
	 * 
	 * @param none
	 * @return Internal Query Language Name
	 */
	public String getInternalLanguageName(){
		return this.internalLanguageName;
	}
	
	
	/**
	 * Return the Mapper Client interface
	 * 
	 * @param none
	 * @return Mapper Client interface
	 */
	public MapperClientWebServiceInterface getMapperClient(){
		return this.mapperClient;
	}
	
	
	/**
	 * Return the Ontology Interchange name
	 * 
	 * @param none
	 * @return Ontology Interchange name
	 */
	public String getOntInterchangeName(){
		return this.ontInterchangeName;
	}
	
	
	/**
	 * Return the Ontology Interchange version
	 * 
	 * @param none
	 * @return Ontology Interchange version
	 */
	public Integer getOntInterchangeVersion(){
		return this.ontInterchangeVersion;
	}
	
	
	/**
	 * Return the Ontology Native name
	 * 
	 * @param none
	 * @return Ontology Native name
	 */
	public String getOntNativeName(){
		return this.ontNativeName;
	}
	
	
	/**
	 * Return the Ontology Native version
	 * 
	 * @param none
	 * @return Ontology Native version
	 */
	public Integer getOntNativeVersion(){
		return this.ontNativeVersion;
	}
	
	
	/**
	 * Return the Output Translation Strategy interface
	 * 
	 * @param none
	 * @return Output Translation Strategy interface
	 */
	public TranslationStrategyInterface getOutputTranslationStrategy(){
		return this.outputTranslationStrategy;
	}
	
	
	/**
	 * Return the Reputation Reasoner interface
	 * 
	 * @param none
	 * @return Reputation Reasoner interface
	 */
	public ReputationReasonerInterface getReputationReasoner(){
		return this.reputationReasoner;
	}
	
	
	/**
	 * Return the Mapper Server URL
	 * 
	 * @param none
	 * @return Mapper Server URL
	 */
	public String getURLMapperServer(){
		return this.urlMapperServer;
	}
	
	
	/**
	 * Return the concept associated to the Value Transformation
	 * 
	 * @param none
	 * @return Concept associated to the Value Transformation
	 */
	public String getValueTransformationConcept(){
		return this.valueTransformationConcept;
	}
	
	
	/**
	 * Return the Value Transformation interface
	 * 
	 * @param none
	 * @return Value Transformation interface
	 */
	public ValueTransformationInterface getValueTransformation(){
		return this.valueTransformationClass;
	}
	
	
	/**
	 * Return if the Translator Controller is connected to the Mapper Server
	 * 
	 * @param none
	 * @return true - if it is connected / false - otherwise
	 */
	public Boolean isConnected(){
		return this.isConnected;
	}
	
	
	/**
	 * Process a incoming message and reply, if required
	 * 
	 * @param sender
	 *          Sender's address
	 * @param language
	 *          Internal language
	 * @param ontology
	 *          Interchange ontology
	 * @param version
	 *          Interchange ontology version
	 * @param msgType
	 *          Type of the message
	 * @param message
	 *          Message content
	 * @param reply
	 *          Message reply identification
	 * @return Translated received object message
	 */
	public synchronized ObjectInterface receiveReputationMessage(String sender,
			String language, String ontology, Integer version, String message,
			String reply) throws LanguageException{
		
		ObjectInterface result = null;
		ObjectInterface originalParsed = null;
		ObjectInterface parsed = null;
		
		if((language.equals(this.internalLanguageName))
				&& (ontology.equals(this.ontInterchangeName))
				&& (version.intValue() == this.ontInterchangeVersion.intValue())){
			
			LanguageInterface parser = this.internalLanguage.createParser(message);
			
			// Parse the message
			parser.run();
			
			Object parsedObject = parser.getParsedObject();
			parsed = (ObjectInterface) parsedObject;
			
			// Copy the original parsed object to keep for future use
			originalParsed = (ObjectInterface) ObjectCopy.copy(parsed);
			
			// If a REQUEST message
			if(parsed.getMessageType().intValue() == TranslatorConstants.REQUEST
					.intValue()){
				
				// Set sender
				parsed.setSender(sender);
				
				// Translate the concepts from Interchange to Native
				List<String> conceptsList = parsed.getConcepts();
				
				Map<String, String[]> concepts = null;
				if(conceptsList != null){
					concepts = this.translateConcepts(conceptsList, INPUT);
					
					// Update the parsed object with the new concepts
					parsed.updateConcepts(concepts);
				}
				
				// Update the concept value for Input
				parsed.updateValue(this.getValueTransformationConcept(),
						this.getValueTransformation(), INPUT);
				
				// Log the translated message
				logger.info("Translated Message = ["
						+ ((SPARQLObject) parsed).getMessage() + "]");
				
				result = this.reputationReasoner.processInMessage(parsedObject);
				
				// Update the concept value for Output
				result.updateValue(this.getValueTransformationConcept(),
						this.getValueTransformation(), OUTPUT);
				
				originalParsed.setMapTable(result.getMapTable());
				
				originalParsed.update(result);
				
				String[] receivers = new String[1];
				receivers[0] = sender;
				
				this.interactionModule.outMessage(receivers, language, ontology,
						version, TranslatorConstants.RESULT, originalParsed.getMessage(),
						reply);
				
				result = originalParsed;
			}
			// If an INFORM message
			else if(parsed.getMessageType().intValue() == TranslatorConstants.INFORM
					.intValue()){
				
				// Set sender
				parsed.setSender(sender);
				
				// Translate Concepts
				List<String> conceptsList = parsed.getConcepts();
				Map<String, String[]> concepts = null;
				if(conceptsList != null){
					concepts = this.translateConcepts(conceptsList, INPUT);
					
					// Update the parsed object with the new concepts
					parsed.updateConcepts(concepts);
				}
				
				// Update the concept value
				parsed.updateValue(this.getValueTransformationConcept(),
						this.getValueTransformation(), INPUT);
				
				this.reputationReasoner.processInMessage(parsedObject);
				
				result = parsed;
				
				// RESULT
			}else if(parsed.getMessageType().intValue() == TranslatorConstants.RESULT
					.intValue()){
				
				if(this.stack.containsKey(reply)){
					originalParsed = this.stack.get(reply);
					this.stack.remove(reply);
					
					originalParsed.update(parsed);
					
					originalParsed.updateValue(this.getValueTransformationConcept(),
							this.getValueTransformation(), INPUT);
					
					// Set the sender
					originalParsed.setSender(sender);
					this.reputationReasoner.processInMessage(originalParsed);
					
					result = originalParsed;
				}
				
				// FAULT
			}else if(parsed.getMessageType().intValue() == TranslatorConstants.FAULT
					.intValue()){
				if(this.stack.containsKey(reply)){
					this.stack.remove(reply);
				}
			}
		}
		
		if(result == null){
			throw new LanguageException();
		}
		
		originalParsed = null;
		parsed = null;
		
		return result;
	}
	
	
	/**
	 * Process a outgoing message and send it out
	 * 
	 * @param receivers
	 *          Message target agent
	 * @param language
	 *          Internal language
	 * @param ontology
	 *          Native ontology
	 * @param version
	 *          Native ontology version
	 * @param msgType
	 *          Type of the message
	 * @param message
	 *          Message content
	 * @return Translated sent object message
	 * @throws LanguageException
	 */
	public synchronized ObjectInterface sendReputationMessage(String[] receivers,
			String language, String ontology, Integer version, String message,
			String replyWith) throws LanguageException{
		
		ObjectInterface parsed = null;
		
		if((language.equals(this.internalLanguageName))
				&& (ontology.equals(this.ontNativeName))
				&& (version.intValue() == this.ontNativeVersion.intValue())){
			
			// Creates a parser
			LanguageInterface parser = this.internalLanguage.createParser(message);
			
			// Parse the message
			parser.run();
			
			Object parsedObject = parser.getParsedObject();
			parsed = (ObjectInterface) parsedObject;
			
			// Copy the original parsed object to keep for future use
			ObjectInterface originalParsed = (ObjectInterface) ObjectCopy
					.copy(parsed);
			
			// Translate Concepts
			List<String> conceptsList = parsed.getConcepts();
			Map<String, String[]> concepts = null;
			if(conceptsList != null){
				concepts = this.translateConcepts(conceptsList, OUTPUT);
			}
			
			// Update the concept value
			parsed.updateValue(this.getValueTransformationConcept(),
					this.getValueTransformation(), OUTPUT);
			
			if(conceptsList != null){
				// Update the parsed object with the new concepts
				parsed.updateConcepts(concepts);
			}
			
			// If an INFORM message
			if(parsed.getMessageType().intValue() == TranslatorConstants.INFORM
					.intValue()){
				
				this.interactionModule.outMessage(receivers, this.internalLanguageName,
						this.ontInterchangeName, this.ontInterchangeVersion,
						parsed.getMessageType(), parsed.getMessage(), null);
				
				// If a REQUEST message
			}else if(parsed.getMessageType().intValue() == TranslatorConstants.REQUEST
					.intValue()){
				
				if(replyWith == null){
					replyWith = parsed.getSender()
							+ (new Double(Math.random() * 100)).toString()
							+ new Long(System.currentTimeMillis()).toString();
				}
				
				originalParsed.setMapTable(parsed.getMapTable());
				this.stack.put(replyWith, originalParsed);
				
				this.interactionModule.outMessage(receivers, this.internalLanguageName,
						this.ontInterchangeName, this.ontInterchangeVersion,
						parsed.getMessageType(), parsed.getMessage(), replyWith);
			}
		}
		
		if(parsed == null){
			throw new LanguageException();
		}
		
		return parsed;
	}
	
	
	/**
	 * Set the Interaction Module interface
	 * 
	 * @param interactionModule
	 *          Interaction Module interface
	 * @return none
	 */
	public void setInteractionModule(InteractionModuleInterface interactionModule){
		this.interactionModule = interactionModule;
	}
	
	
	/**
	 * Translate the concepts between ontologies considering the Translation
	 * Strategies configured
	 * 
	 * @param conceptsList
	 *          List of concepts to translate
	 * @param inOut
	 *          true if incoming message / false - if outgoing message
	 * @return Translation Map of the concepts
	 */
	private synchronized Map<String, String[]> translateConcepts(
			List<String> conceptsList, Boolean inOut){
		Map<String, String[]> result = new HashMap<String, String[]>();
		Ontology ontFrom = new Ontology();
		Ontology ontTo = new Ontology();
		
		if(inOut){ // Incoming Message
			ontFrom.setType(Ontology.TYPE_INTERCHANGE);
			ontFrom.setUri(this.ontInterchangeName);
			ontFrom.setVersion(this.ontInterchangeVersion);
			
			ontTo.setType(Ontology.TYPE_NATIVE);
			ontTo.setUri(this.ontNativeName);
			ontTo.setVersion(this.ontNativeVersion);
		}else{ // Outgoing Message
			ontFrom.setType(Ontology.TYPE_NATIVE);
			ontFrom.setUri(this.ontNativeName);
			ontFrom.setVersion(this.ontNativeVersion);
			
			ontTo.setType(Ontology.TYPE_INTERCHANGE);
			ontTo.setUri(this.ontInterchangeName);
			ontTo.setVersion(this.ontInterchangeVersion);
		}
		
		if(!conceptsList.isEmpty()){
			List<String> t = new ArrayList<String>();
			String[] toConcepts;
			for(String fromConcept : conceptsList){
				
				if(!t.contains(fromConcept)){
					toConcepts = null;
					
					if(inOut){
						if(this.mapInterchangeNative.containsKey(fromConcept)){
							toConcepts = this.mapInterchangeNative.get(fromConcept);
						}else{
							toConcepts = mapperClient.translateConcept(fromConcept, ontFrom,
									ontTo);
							
							this.mapInterchangeNative.put(fromConcept, toConcepts);
						}
					}else{
						if(this.mapNativeInterchange.containsKey(fromConcept)){
							toConcepts = this.mapNativeInterchange.get(fromConcept);
						}else{
							toConcepts = mapperClient.translateConcept(fromConcept, ontFrom,
									ontTo);
							
							this.mapNativeInterchange.put(fromConcept, toConcepts);
						}
					}
					
					String[] concepts;
					if(inOut){
						concepts = this.inputTranslationStrategy.run(fromConcept,
								toConcepts);
					}else{
						concepts = this.outputTranslationStrategy.run(fromConcept,
								toConcepts);
					}
					result.put(fromConcept, concepts);
					t.add(fromConcept);
				}
			}
		}
		
		return result;
	}
}