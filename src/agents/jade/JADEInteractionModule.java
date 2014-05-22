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
package agents.jade;

import jade.core.AID;
import jade.core.behaviours.SenderBehaviour;
import jade.lang.acl.ACLMessage;
import otservices.translator.TranslatorConstants;
import otservices.translator.interactionmodule.InteractionModuleInterface;

public class JADEInteractionModule extends InteractionModuleInterface implements
		TranslatorConstants{
	
	JADEAgent	agent	= null;
	
	
	/**
	 * 
	 */
	public JADEInteractionModule(){
	}
	

	/**
	 * 
	 */
	@Override
	public void outMessage(String[] receivers, String language, String ontology,
			Integer version, Integer msgType, String message, String replyWith){
		
		if(agent != null){
			ACLMessage msg = null;
			if(msgType.intValue() == REQUEST.intValue()){
				msg = new ACLMessage(ACLMessage.REQUEST);
			}else if(msgType.intValue() == INFORM.intValue()){
				msg = new ACLMessage(ACLMessage.INFORM);
			}else if(msgType.intValue() == RESULT.intValue()){
				msg = new ACLMessage(ACLMessage.CONFIRM);
			}else if(msgType.intValue() == FAULT.intValue()){
				msg = new ACLMessage(ACLMessage.FAILURE);
			}else{
				msg = new ACLMessage(ACLMessage.NOT_UNDERSTOOD);
			}
			
			if(receivers != null){
				for(int i = 0; i < receivers.length; i++){
					msg.addReceiver(new AID(receivers[i], AID.ISLOCALNAME));
				}
				msg.setReplyWith(replyWith);
				msg.setLanguage(language);
				msg.setContent(message);
				msg.setOntology(ontology + "_v_" + version.toString());
				
				agent.addBehaviour(new SenderBehaviour(agent, msg));
			}
		}
	}
	

	/**
	 * 
	 */
	public void setJADEAgent(JADEAgent agent){
		this.agent = agent;
	}
}