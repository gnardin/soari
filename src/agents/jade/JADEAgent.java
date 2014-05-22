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

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.domain.AMSService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.AMSAgentDescription;
import jade.domain.FIPAAgentManagement.SearchConstraints;
import jade.lang.acl.ACLMessage;
import otservices.translator.TranslatorConstants;
import otservices.translator.TranslatorController;
import otservices.translator.language.LanguageException;
import otservices.translator.language.ObjectInterface;

public class JADEAgent extends Agent {
	
	JADEInteractionModule	interaction						= null;
	
	JADEAgentGUI					gui										= null;
	
	TranslatorController	translatorController	= null;
	
	String								path									= null;
	
	String								reputationType				= null;
	
	
	/**
	 * 
	 */
	@Override
	protected void setup() {
		Object[] args = this.getArguments();
		
		String xml = null;
		String xsd = null;
		String log = null;
		
		path = (String) args[0];
		reputationType = (String) args[1];
		System.out.println("translatorController " + reputationType);
		
		if(reputationType.toUpperCase().equals("LIAR")) {
			xml = path + "/conf/liar/translatorconfiguration.xml";
			xsd = path + "/conf/liar/translatorconfiguration.xsd";
			log = path + "/conf/liar/log4j.properties";
		} else if(reputationType.toUpperCase().equals("REPAGE")) {
			xml = path + "/conf/repage/translatorconfiguration.xml";
			xsd = path + "/conf/repage/translatorconfiguration.xsd";
			log = path + "/conf/repage/log4j.properties";
		} else if(reputationType.toUpperCase().equals("TYPOLOGY")) {
			xml = path + "/conf/typology/translatorconfiguration.xml";
			xsd = path + "/conf/typology/translatorconfiguration.xsd";
			log = path + "/conf/typology/log4j.properties";
		}
		
		// Error when create TranslatorController
		try {
			this.translatorController = new TranslatorController(xml, xsd, log);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		this.interaction = new JADEInteractionModule();
		this.interaction.setTranslatorController(this.translatorController);
		this.interaction.setJADEAgent(this);
		
		this.translatorController.setInteractionModule(this.interaction);
		
		Integer posX = null;
		Integer posY = null;
		try {
			posX = new Integer((String) args[2]);
			posY = new Integer((String) args[3]);
		} catch(NumberFormatException nfe) {
		}
		
		gui = new JADEAgentGUI(this, this.getAID().getName(), posX, posY);
		gui.setVisible(true);
		
		// Receiving Behaviour
		this.addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				ACLMessage msg = myAgent.receive();
				
				if(msg != null) {
					gui.logWrite("RECEIVED = [" + msg.getContent() + "]");
					
					Integer msgType = TranslatorConstants.FAULT;
					if(msg.getPerformative() == ACLMessage.INFORM) {
						msgType = TranslatorConstants.INFORM;
					} else if(msg.getPerformative() == ACLMessage.REQUEST) {
						msgType = TranslatorConstants.REQUEST;
					} else if(msg.getPerformative() == ACLMessage.CONFIRM) {
						msgType = TranslatorConstants.RESULT;
					}
					
					String[] token = msg.getOntology().split("_v_");
					
					if((token[0].toUpperCase().equals(translatorController
							.getOntInterchangeName()))
							&& (token[1].equals(translatorController
									.getOntInterchangeVersion().toString()))) {
						
						gui.logWrite("RECEIVED BEFORE TRANSLATE = [" + msg.getContent()
								+ "]");
						
						String sender = msg.getSender().getName();
						
						String rcvMsg = interaction.inMessage(sender, msg.getLanguage(),
								translatorController.getOntInterchangeName(),
								translatorController.getOntInterchangeVersion(), msgType,
								msg.getContent(), msg.getReplyWith());
						
						if(rcvMsg != null) {
							gui.logWrite("RECEIVED AFTER TRANSLATE = [" + rcvMsg + "]");
						}
					}
				} else {
					block();
				}
			}
		});
	}
	
	
	/**
	 * Remove the graphical user from screen
	 * 
	 * @param none
	 * @return none
	 */
	@Override
	protected void takeDown() {
		if(gui != null) {
			gui.dispose();
		}
	}
	
	
	/**
	 * 
	 */
	public void send(String targetAgent, String content) {
		
		try {
			String[] receivers = new String[1];
			receivers[0] = targetAgent;
			
			gui.logWrite("SENT BEFORE TRANSLATE = [" + content + "]");
			
			ObjectInterface sentMsg = this.translatorController
					.sendReputationMessage(receivers,
							this.translatorController.getInternalLanguageName(),
							this.translatorController.getOntNativeName(),
							this.translatorController.getOntNativeVersion(), content, null);
			
			if(sentMsg != null) {
				gui.logWrite("SENT AFTER TRANSLATE = [" + sentMsg.getMessage() + "]");
			}
		} catch(LanguageException le) {
			le.printStackTrace();
		}
	}
	
	
	/**
	 * Returns the agents active in the system
	 * 
	 * @param none
	 * @return Array of active agent names
	 */
	public String[] getAgents() {
		try {
			SearchConstraints c = new SearchConstraints();
			c.setMaxResults(new Long(-1));
			AMSAgentDescription[] agentsList = AMSService.search(this,
					new AMSAgentDescription(), c);
			
			if(agentsList.length > 0) {
				String[] list = new String[agentsList.length];
				String name;
				int j = 0;
				for(int i = 0; i < agentsList.length; i++) {
					name = agentsList[i].getName().getName();
					if((!name.startsWith("ams@")) && (!name.startsWith("RMA@"))
							&& (!name.startsWith("df@"))
							&& (!name.equals(this.getAID().getName()))) {
						list[j] = name;
						j++;
					}
				}
				return list;
			}
		} catch(FIPAException e) {
			e.printStackTrace();
		}
		return null;
	}
}