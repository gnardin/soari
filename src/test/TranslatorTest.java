package test;

import otservices.translator.TranslatorController;
import otservices.translator.interactionmodule.GenericInteractionModule;
import otservices.translator.language.sparql.SPARQLObject;
import otservices.translator.reputationreasoner.impl.ARTDecision;

public class TranslatorTest {
	
	public static void main(String[] args) throws Exception{
		// Source Translation Controller
		String xml = "/data/workspace/soari/conf/liar/translatorconfiguration.xml";
		String xsd = "/data/workspace/soari/conf/liar/translatorconfiguration.xsd";
		String log = "/data/workspace/soari/conf/liar/log4j.properties";
		TranslatorController sourceTC = new TranslatorController(xml, xsd, log);
		sourceTC.setInteractionModule(new GenericInteractionModule());
		
		// Target Translation Controller
		xml = "/data/workspace/soari/conf/repage/translatorconfiguration.xml";
		xsd = "/data/workspace/soari/conf/repage/translatorconfiguration.xsd";
		log = "/data/workspace/soari/conf/repage/log4j.properties";
		TranslatorController targetTC = new TranslatorController(xml, xsd, log);
		targetTC.setInteractionModule(new GenericInteractionModule());
		
		ARTDecision decision = new ARTDecision();
		decision.setBias(0.4);
		decision.setLie(true);
		sourceTC.getReputationReasoner().setObject(decision);
		targetTC.getReputationReasoner().setObject(decision);
		
		String requestMessageLIAR;
		String informMessageLIAR1;
		String informMessageLIAR2;
		
		// message =
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><sparql xmlns=\"http://www.w3.org/2005/sparql-results#\"><head><variable name=\"?value\"/><variable name=\"?l\"/></head><results><result><binding name=\"?value\"><literal datatype=\"http://www.w3.org/2001/XMLSchema#integer\">20</literal></binding><binding name=\"?l\"><literal datatype=\"http://www.w3.org/2001/XMLSchema#integer\">20</literal></binding></result></results></sparql>"
		// ;
		
		// message =
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><sparql xmlns=\"http://www.w3.org/2005/sparql-results#\"><head><variable name=\"?value11\"/><variable name=\"?value10\"/></head><results><result><binding name=\"?value11\"><literal datatype=\"http://www.w3.org/2001/XMLSchema#float\">20.0</literal></binding><binding name=\"?value10\"><literal datatype=\"http://www.w3.org/2001/XMLSchema#float\">20.0</literal></binding></result></results></sparql>"
		// ;
		
		/**
		 * message = "UPDATE ?value=[0.3;0.0;0.2;0.1;0.4] ?l=20 " +
		 * "WHERE{ ?x reputation:DirectReputation ?drep ." +
		 * "       ?x reputation:AgentName ?name ." +
		 * "       ?x reputation:ReputationFinalVAlue ?value ." +
		 * "       FILTER (REGEX(?name,ABC) && (?drep = true))}";
		 */
		
		/**
		 * message = "UPDATE ?value=10 ?l=20 " +
		 * "WHERE{ ?x reputation:DirectReputation ?drep ." +
		 * "       ?x reputation:AgentName ?name ." +
		 * "       ?x reputation:ReputationFinalVAlue ?value ." +"       FILTER (((?A = true) && (?B = true) && (?C = true)) || ((?D = true) && ((?E = true) || (?F = true))))}"
		 * ;
		 */
		
		/**
		 * message = "SELECT ?value ?prep" +
		 * " WHERE{ ?x reputation:DirectReputation ?drep ." +
		 * "        ?x reputation:PropagatedReputation ?prep ." +
		 * "        ?x reputation:AgentName ?name ." +
		 * 
		 * "        FILTER (((REGEX(?name,ABC) && (?drep >= 1.8)) && (?prep != true)) "
		 * + "               || (REGEX(?name,BCD) || (2.6 > ?drep)))" +
		 * "        ?x reputation:ReputationFinalVAlue ?value . }";
		 */
		
		/**
		 * message = "SELECT ?value" +
		 * " WHERE{ ?x reputation:DirectReputation ?drep ." +
		 * "        ?x reputation:AgentName ?name ." +
		 * "        FILTER (REGEX(?name,ABC) || (?drep = true)) " +
		 * "        ?x reputation:ReputationFinalVAlue ?value . }";
		 */
		
		informMessageLIAR1 = "UPDATE ?value=0.8 "
				+ "WHERE{ ?x reputation:DirectInteractionBasedReputationByLIAR ?drep ."
				+ "       ?x reputation:AgentName ?name ."
				+ "       ?x reputation:ReputationValuebyLIAR ?value ."
				+ "       ?x reputation:FacetByLIAR ?context ."
				+ "       FILTER (REGEX(?name,A) && REGEX(?context,era1) && (?drep = true)) }";
		
		informMessageLIAR2 = "UPDATE ?value=0.4 "
				+ "WHERE{ ?x reputation:DirectInteractionBasedReputationByLIAR ?drep ."
				+ "       ?x reputation:AgentName ?name ."
				+ "       ?x reputation:ReputationValuebyLIAR ?value ."
				+ "       ?x reputation:FacetByLIAR ?context ."
				+ "       FILTER (REGEX(?name,A) && REGEX(?context,era2) && (?drep = true)) }";
		
		requestMessageLIAR = "SELECT ?name ?value ?rprcbrp ?context"
				+ " WHERE{ ?x reputation:ReputationRecommendationBasedReputationByLIAR ?rprcbrp ."
				+ "        ?x reputation:AgentName ?name ."
				+ "        ?x reputation:FacetByLIAR ?context ."
				+ "        ?x reputation:ReputationValuebyLIAR ?value ."
				+ " FILTER (REGEX(?name,A) && REGEX(?context,era1) && (?rprcbrp = true)) }";
		
		/**
		 * message = "SELECT ?value" +
		 * " WHERE{ ?x reputation:imagebyrepage ?drep ." +
		 * "        ?x reputation:AgentName ?name ." +
		 * "        FILTER (REGEX(?name,ABC) || (?drep = true)) " +
		 * "        ?x reputation:valuebyrepage ?value . }";
		 */
		
		SPARQLObject sendObject;
		SPARQLObject receivedObject;
		String[] receivers = new String[1];
		
		System.out.println("1.1 = " + informMessageLIAR1);
		
		receivers[0] = "B";
		sendObject = (SPARQLObject) sourceTC.sendReputationMessage(receivers,
				"SPARQL", "LIAR", new Integer(1), informMessageLIAR1, "123");
		
		System.out.println("\n1.2 = " + sendObject.getMessage());
		
		receivedObject = (SPARQLObject) targetTC.receiveReputationMessage("A",
				"SPARQL", "FORE", new Integer(1), sendObject.getMessage(), "123");
		
		// System.out.println("\n1.3 = " + receivedObject.getMessage());
		
		System.out.println("\n2.1 = " + informMessageLIAR2);
		
		receivers[0] = "B";
		sendObject = (SPARQLObject) sourceTC.sendReputationMessage(receivers,
				"SPARQL", "LIAR", new Integer(1), informMessageLIAR2, "123");
		
		System.out.println("\n2.2 = " + sendObject.getMessage());
		
		receivedObject = (SPARQLObject) targetTC.receiveReputationMessage("A",
				"SPARQL", "FORE", new Integer(1), sendObject.getMessage(), "123");
		
		System.out.println("\n2.3 = " + receivedObject.getMessage());
		
		// Request the Reputation
		System.out.println("\n3.1 = " + requestMessageLIAR);
		
		receivers = new String[1];
		receivers[0] = "B";
		sendObject = (SPARQLObject) sourceTC.sendReputationMessage(receivers,
				"SPARQL", "LIAR", new Integer(1), requestMessageLIAR, "123");
		
		System.out.println("\n3.2 = " + sendObject.getMessage());
		
		receivedObject = (SPARQLObject) targetTC.receiveReputationMessage("A",
				"SPARQL", "FORE", new Integer(1), sendObject.getMessage(), "123");
		
		System.out.println("\n3.3 = " + receivedObject.getMessage());
		
		receivedObject = (SPARQLObject) sourceTC.receiveReputationMessage("B",
				"SPARQL", "FORE", new Integer(1), receivedObject.getMessage(), "123");
		
		System.out.println("\n3.4 = " + receivedObject.getMessage());
	}
}