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
package otservices.translator.interactionmodule;

import otservices.translator.TranslatorConstants;
import otservices.translator.TranslatorController;
import otservices.translator.language.LanguageException;
import otservices.translator.language.ObjectInterface;

<<<<<<< HEAD
public abstract class InteractionModuleInterface implements TranslatorConstants {
=======
public abstract class InteractionModuleInterface implements TranslatorConstants{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	private TranslatorController	translatorController	= null;
	
	private Boolean								isConnected						= new Boolean(false);
	
	
	/**
	 * Returns if the Interaction Module is connected to a Translation
	 * Controller
	 * 
	 * @param none
	 * @return true - if it is connected / false - otherwise
	 */
<<<<<<< HEAD
	public Boolean isConnected() {
		return this.isConnected;
	}
	
	
=======
	public Boolean isConnected(){
		return this.isConnected;
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the Translator Controller related to this Interaction Module
	 * 
	 * @param translatorController
	 *          Translator Controller class
	 * @return none
	 */
<<<<<<< HEAD
	public void setTranslatorController(TranslatorController translatorController) {
		if(translatorController != null) {
			if(translatorController.isConnected()) {
=======
	public void setTranslatorController(TranslatorController translatorController){
		if(translatorController != null){
			if(translatorController.isConnected()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				this.translatorController = translatorController;
				this.isConnected = new Boolean(true);
			}
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Process a incoming message
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
	 * @return Translated received message
	 */
	public String inMessage(String sender, String language, String ontology,
<<<<<<< HEAD
			Integer version, Integer msgType, String message, String reply) {
=======
			Integer version, Integer msgType, String message, String reply){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		ObjectInterface msg = null;
		
		if((msgType.intValue() == TranslatorConstants.FAULT)
				|| (msgType.intValue() == TranslatorConstants.INFORM)
<<<<<<< HEAD
				|| (msgType.intValue() == TranslatorConstants.RESULT)) {
			try {
				msg = this.translatorController.receiveReputationMessage(sender,
						language, ontology, version, message, reply);
			} catch(LanguageException le) {
			}
		} else if(msgType.intValue() == TranslatorConstants.REQUEST) {
			try {
				msg = this.translatorController.receiveReputationMessage(sender,
						language, ontology, version, message, reply);
				
			} catch(LanguageException le) {
=======
				|| (msgType.intValue() == TranslatorConstants.RESULT)){
			try{
				msg = this.translatorController.receiveReputationMessage(sender,
						language, ontology, version, message, reply);
			}catch(LanguageException le){
			}
		}else if(msgType.intValue() == TranslatorConstants.REQUEST){
			try{
				msg = this.translatorController.receiveReputationMessage(sender,
						language, ontology, version, message, reply);
				
			}catch(LanguageException le){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				
				// Returns the same message indicating occurred a Language
				// Exception
				String[] receivers = new String[1];
				receivers[0] = sender;
				
				outMessage(receivers, language, ontology, version,
						TranslatorConstants.FAULT, message, reply);
			}
		}
		
		String result = "";
<<<<<<< HEAD
		if(msg != null) {
=======
		if(msg != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			result = msg.getMessage();
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Process a outgoing message
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
	 * @return Translated sent message
	 */
	public void outMessage(String[] receivers, String language, String ontology,
<<<<<<< HEAD
			Integer version, Integer msgType, String message, String reply) {
=======
			Integer version, Integer msgType, String message, String reply){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	}
}