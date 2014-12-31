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
package otservices.translator.reputationreasoner.impl.liar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import otservices.translator.language.ObjectInterface;
import otservices.translator.language.sparql.Filter;
import otservices.translator.language.sparql.RegExpr;
import otservices.translator.language.sparql.RelExpr;
import otservices.translator.language.sparql.Result;
import otservices.translator.language.sparql.SPARQLObject;
import otservices.translator.language.sparql.Term;
import otservices.translator.language.sparql.Where;
import otservices.translator.reputationreasoner.ReputationReasonerInterface;
import otservices.translator.reputationreasoner.impl.ARTDecision;
<<<<<<< HEAD
import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.LIARModule;
import reputationreasoners.liar.condition.TrueCondition;
import reputationreasoners.liar.content.ARTContent;
import reputationreasoners.liar.content.Content;
=======
import reputationreasoners.liar.condition.TrueCondition;
import reputationreasoners.liar.content.ARTContent;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.LIARModule;
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import reputationreasoners.liar.reputation.Reputation;
import reputationreasoners.liar.reputation.ReputationValue;
import reputationreasoners.liar.socialnorm.ARTSNorm;
import reputationreasoners.liar.socialnorm.SNorm;
import reputationreasoners.liar.socialnorm.SNormSet;
import reputationreasoners.liar.trustintention.Lev;
import reputationreasoners.liar.trustintention.LevSet;
import reputationreasoners.liar.trustintention.TrustIntention;

<<<<<<< HEAD
public class LIARReputationReasoner implements ReputationReasonerInterface {
=======
public class LIARReputationReasoner implements ReputationReasonerInterface{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	private final static Dimensions	DEFAULT_DIMENSION	= Dimensions.COMPETENCE;
	
	private ARTDecision							decision					= new ARTDecision();
	
	private List<LIARElement>				elementList;
	
	private String									id;
	
	private LIARModule							reputationReasoner;
	
	private SPARQLObject						sparqlMsg;
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public synchronized ObjectInterface processInMessage(Object parsedObject) {
=======
	public synchronized ObjectInterface processInMessage(Object parsedObject){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.sparqlMsg = (SPARQLObject) parsedObject;
		
		this.elementList = new ArrayList<LIARElement>();
		
		// SELECT
<<<<<<< HEAD
		if(this.sparqlMsg.getCommand() == SPARQLObject.Command.SELECT) {
=======
		if(this.sparqlMsg.getCommand() == SPARQLObject.Command.SELECT){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			this.getElements(this.isRepType());
			
			Result newResult = new Result();
			this.sparqlMsg.setCommand(SPARQLObject.Command.RESULT);
			
			Result result = this.sparqlMsg.getResult();
			Where where = this.sparqlMsg.getWhere();
			Filter filter = this.sparqlMsg.getFilter();
			
			String var;
			String concept;
			Term term;
			
<<<<<<< HEAD
			for(LIARElement element : this.elementList) {
				
				if(element.getValue() != null) {
					
					for(Iterator<String> iResult = result.getResults().keySet()
							.iterator(); iResult.hasNext();) {
=======
			for(LIARElement element : this.elementList){
				
				if(element.getValue() != null){
					
					for(Iterator<String> iResult = result.getResults().keySet()
							.iterator(); iResult.hasNext();){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						var = iResult.next();
						concept = where.getConcept(var);
						
						term = new Term();
<<<<<<< HEAD
						if(concept.equalsIgnoreCase("agentname")) {
							term.setType(Term.TermType.STRING);
							term.setTerm(element.getAgentName());
							newResult.addResult(var, term);
						} else if(concept.equalsIgnoreCase("facetbyliar")) {
							term.setType(Term.TermType.STRING);
							term.setTerm(element.getFacet().toString());
							newResult.addResult(var, term);
						} else if(concept.equalsIgnoreCase("reputationvaluebyliar")) {
							term.setType(Term.TermType.FLOAT);
							term.setTerm(new Double(element.getValue()).floatValue());
							newResult.addResult(var, term);
						} else if(concept.equalsIgnoreCase(Reputation.RepType.DIbRp
								.toString().toLowerCase())) {
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isDIbRp().toString());
							newResult.addResult(var, term);
						} else if(concept.equalsIgnoreCase(Reputation.RepType.IIbRp
								.toString().toLowerCase())) {
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isIIbRp().toString());
							newResult.addResult(var, term);
						} else if(concept.equalsIgnoreCase(Reputation.RepType.ObsRcbRp
								.toString().toLowerCase())) {
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isObsRcbRp().toString());
							newResult.addResult(var, term);
						} else if(concept.equalsIgnoreCase(Reputation.RepType.EvRcbRp
								.toString().toLowerCase())) {
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isEvRcbRp().toString());
							newResult.addResult(var, term);
						} else if(concept.equalsIgnoreCase(Reputation.RepType.RpRcbRp
								.toString().toLowerCase())) {
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isRpRcbRp().toString());
							newResult.addResult(var, term);
						} else {
							term = filter.getValue(var);
							if(term != null) {
=======
						if(concept.equalsIgnoreCase("agentname")){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.getAgentName());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase("facetbyliar")){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.getFacet().toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase("reputationvaluebyliar")){
							term.setType(Term.TermType.FLOAT);
							term.setTerm(new Double(element.getValue()).floatValue());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(Reputation.RepType.DIbRp
								.toString().toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isDIbRp().toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(Reputation.RepType.IIbRp
								.toString().toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isIIbRp().toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(Reputation.RepType.ObsRcbRp
								.toString().toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isObsRcbRp().toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(Reputation.RepType.EvRcbRp
								.toString().toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isEvRcbRp().toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(Reputation.RepType.RpRcbRp
								.toString().toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isRpRcbRp().toString());
							newResult.addResult(var, term);
						}else{
							term = filter.getValue(var);
							if(term != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								newResult.addResult(var, term);
							}
						}
					}
				}
				this.sparqlMsg.addResult(newResult);
			}
			return this.sparqlMsg;
			
<<<<<<< HEAD
		} else if(this.sparqlMsg.getCommand() == SPARQLObject.Command.UPDATE) {
			this.setElements();
		} else if(this.sparqlMsg.getCommand() == SPARQLObject.Command.RESULT) {
=======
		}else if(this.sparqlMsg.getCommand() == SPARQLObject.Command.UPDATE){
			this.setElements();
		}else if(this.sparqlMsg.getCommand() == SPARQLObject.Command.RESULT){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.setElements();
		}
		
		return null;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public String getID() {
=======
	public String getID(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.id;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public void setID(String id) {
=======
	public void setID(String id){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.id = id;
		this.reputationReasoner = new LIARModule(this.id);
		this.reputationReasoner.setSNormSet(this.initSNormSet());
		this.reputationReasoner.setLevSet(this.initLevSet());
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public LIARModule getReputationReasoner() {
=======
	public LIARModule getReputationReasoner(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.reputationReasoner;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setReputationReasoner(LIARModule reputationReasoner) {
=======
	public void setReputationReasoner(LIARModule reputationReasoner){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.reputationReasoner = reputationReasoner;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	private SNormSet initSNormSet() {
=======
	private SNormSet initSNormSet(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		List<String> targets = new ArrayList<String>();
		List<String> evaluators = new ArrayList<String>();
		List<String> punishers = new ArrayList<String>();
		Content content = new ARTContent(new Double(0), new Double(0));
		
		ARTSNorm sNorm = new ARTSNorm(SNorm.OperatorType.O, targets, evaluators,
				punishers, new TrueCondition(), content, SNorm.States.ACTIVE);
		
		SNormSet sNormSet = new SNormSet();
		sNormSet.addNorm(sNorm);
		
		return sNormSet;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	private LevSet initLevSet() {
=======
	private LevSet initLevSet(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		LevSet levSet = new LevSet();
		levSet.setGDtT(TrustIntention.TrustType.TRUST);
		
		Lev lev;
		
		// DIbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(10));
		levSet.setLev(Reputation.RepType.DIbRp, lev);
		
		// IIbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(7));
		levSet.setLev(Reputation.RepType.IIbRp, lev);
		
		// ObsRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(0));
		levSet.setLev(Reputation.RepType.ObsRcbRp, lev);
		
		// EvRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(0));
		levSet.setLev(Reputation.RepType.EvRcbRp, lev);
		
		// RepRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(5));
		levSet.setLev(Reputation.RepType.RpRcbRp, lev);
		
		return levSet;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	private Boolean[] isRepType() {
=======
	private Boolean[] isRepType(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Boolean[] result = new Boolean[Reputation.RepType.values().length];
		
		Filter filter = this.sparqlMsg.getFilter();
		Where where = this.sparqlMsg.getWhere();
		Iterator<String> i;
		String var;
		String concept;
		Object item;
<<<<<<< HEAD
		for(Reputation.RepType repType : Reputation.RepType.values()) {
			
			result[repType.ordinal()] = new Boolean(false);
			i = where.getWhere().keySet().iterator();
			while(i.hasNext()) {
				var = i.next();
				concept = where.getConcept(var);
				if(concept != null) {
					if(concept.equalsIgnoreCase(repType.toString().toLowerCase())) {
						item = filter.getItem(var);
						
						if(item instanceof RelExpr) {
=======
		for(Reputation.RepType repType : Reputation.RepType.values()){
			
			result[repType.ordinal()] = new Boolean(false);
			i = where.getWhere().keySet().iterator();
			while(i.hasNext()){
				var = i.next();
				concept = where.getConcept(var);
				if(concept != null){
					if(concept.equalsIgnoreCase(repType.toString().toLowerCase())){
						item = filter.getItem(var);
						
						if(item instanceof RelExpr){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							RelExpr rel = (RelExpr) item;
							
							Term term = new Term();
							term.setType(Term.TermType.BOOLEAN);
							term.setTerm(new Boolean(true));
<<<<<<< HEAD
							if(rel.evaluate(term).booleanValue()) {
=======
							if(rel.evaluate(term).booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								result[repType.ordinal()] = new Boolean(true);
								break;
							}
							break;
						}
					}
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	private void getElements(Boolean[] isRepType) {
=======
	private void getElements(Boolean[] isRepType){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Where where = this.sparqlMsg.getWhere();
		Filter filter = this.sparqlMsg.getFilter();
		
		RegExpr reg;
		Object item;
		
		// Get AgentName
		String varAgentName = where.getVariable("agentname")[0];
		String agentName = null;
<<<<<<< HEAD
		if(varAgentName != null) {
			item = filter.getItem(varAgentName);
			if(item != null) {
				if(item instanceof RegExpr) {
=======
		if(varAgentName != null){
			item = filter.getItem(varAgentName);
			if(item != null){
				if(item instanceof RegExpr){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					reg = (RegExpr) item;
					agentName = reg.getPattern();
				}
			}
		}
		
		// Get Facet
		String varFacet = null;
		String agentFacet = null;
		Facets facet = null;
<<<<<<< HEAD
		// try{
		varFacet = where.getVariable("facetbyliar")[0];
		if(varFacet != null) {
			item = filter.getItem(varFacet);
			if(item != null) {
				if(item instanceof RegExpr) {
					reg = (RegExpr) item;
					agentFacet = reg.getPattern();
				}
				
				if(agentFacet != null) {
					for(Facets f : Facets.values()) {
						if(agentFacet.equalsIgnoreCase(f.toString())) {
							facet = f;
=======
	//	try{
			varFacet = where.getVariable("facetbyliar")[0];
			if(varFacet != null){
				item = filter.getItem(varFacet);
				if(item != null){
					if(item instanceof RegExpr){
						reg = (RegExpr) item;
						agentFacet = reg.getPattern();
					}
					
					if(agentFacet != null){
						for(Facets f : Facets.values()){
							if(agentFacet.equalsIgnoreCase(f.toString())){
								facet = f;
							}
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						}
					}
				}
			}
<<<<<<< HEAD
		}
		// }catch(Exception e){
		// where.print();
		// }
=======
	//	}catch(Exception e){
	//		where.print();
	//	}
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		String agent;
		ReputationValue value;
		LIARElement element = new LIARElement();
		ReputationValue[] rep;
		Map<String, ReputationValue> mRep;
<<<<<<< HEAD
		for(Reputation.RepType repType : Reputation.RepType.values()) {
			if(isRepType[repType.ordinal()].booleanValue()) {
				
				if(((varAgentName != null) && (varFacet != null))
						&& ((agentName != null) && (facet != null))) {
					
					if(this.reputationReasoner.getReputationSet().exists(agentName)
							.booleanValue()) {
=======
		for(Reputation.RepType repType : Reputation.RepType.values()){
			if(isRepType[repType.ordinal()].booleanValue()){
				
				if(((varAgentName != null) && (varFacet != null))
						&& ((agentName != null) && (facet != null))){
					
					if(this.reputationReasoner.getReputationSet().exists(agentName)
							.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						
						value = this.reputationReasoner.getReputationSet().getReputation(
								agentName, facet, DEFAULT_DIMENSION, repType);
						
						element = new LIARElement();
						element.setAgentName(agentName);
						element.setFacet(facet);
						element.setValue(this.updateValue(value.getValue()));
						
<<<<<<< HEAD
						if(repType.toString().equals(Reputation.RepType.DIbRp.toString())) {
							element.setDIbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.IIbRp.toString())) {
							element.setIIbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.ObsRcbRp.toString())) {
							element.setObsRcbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.EvRcbRp.toString())) {
							element.setEvRcbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.RpRcbRp.toString())) {
=======
						if(repType.toString().equals(Reputation.RepType.DIbRp.toString())){
							element.setDIbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.IIbRp.toString())){
							element.setIIbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.ObsRcbRp.toString())){
							element.setObsRcbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.EvRcbRp.toString())){
							element.setEvRcbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.RpRcbRp.toString())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setRpRcbRp(isRepType[repType.ordinal()].booleanValue());
						}
						
						this.elementList.add(element);
					}
					
<<<<<<< HEAD
				} else if((varAgentName != null) && (agentName != null)) {
=======
				}else if((varAgentName != null) && (agentName != null)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					
					rep = this.reputationReasoner.getReputationSet().getReputationByDeb(
							agentName, DEFAULT_DIMENSION, repType);
					
<<<<<<< HEAD
					for(int i = 0; i < rep.length; i++) {
=======
					for(int i = 0; i < rep.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						element = new LIARElement();
						element.setAgentName(agentName);
						element.setFacet(Facets.values()[i]);
						element.setValue(this.updateValue(rep[i].getValue()));
						
<<<<<<< HEAD
						if(repType.toString().equals(Reputation.RepType.DIbRp.toString())) {
							element.setDIbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.IIbRp.toString())) {
							element.setIIbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.ObsRcbRp.toString())) {
							element.setObsRcbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.EvRcbRp.toString())) {
							element.setEvRcbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.RpRcbRp.toString())) {
=======
						if(repType.toString().equals(Reputation.RepType.DIbRp.toString())){
							element.setDIbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.IIbRp.toString())){
							element.setIIbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.ObsRcbRp.toString())){
							element.setObsRcbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.EvRcbRp.toString())){
							element.setEvRcbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.RpRcbRp.toString())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setRpRcbRp(isRepType[repType.ordinal()].booleanValue());
						}
						
						this.elementList.add(element);
					}
					
<<<<<<< HEAD
				} else if((varFacet != null) && (facet != null)) {
=======
				}else if((varFacet != null) && (facet != null)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					
					mRep = this.reputationReasoner.getReputationSet()
							.getReputationByFacet(facet, DEFAULT_DIMENSION,
									Reputation.RepType.DIbRp);
					
					for(Iterator<String> iAgent = mRep.keySet().iterator(); iAgent
<<<<<<< HEAD
							.hasNext();) {
=======
							.hasNext();){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						agent = iAgent.next();
						value = mRep.get(agent);
						
						element = new LIARElement();
						element.setAgentName(agent);
						element.setFacet(facet);
						element.setValue(this.updateValue(value.getValue()));
						
<<<<<<< HEAD
						if(repType.toString().equals(Reputation.RepType.DIbRp.toString())) {
							element.setDIbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.IIbRp.toString())) {
							element.setIIbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.ObsRcbRp.toString())) {
							element.setObsRcbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.EvRcbRp.toString())) {
							element.setEvRcbRp(isRepType[repType.ordinal()].booleanValue());
						} else if(repType.toString().equals(
								Reputation.RepType.RpRcbRp.toString())) {
=======
						if(repType.toString().equals(Reputation.RepType.DIbRp.toString())){
							element.setDIbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.IIbRp.toString())){
							element.setIIbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.ObsRcbRp.toString())){
							element.setObsRcbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.EvRcbRp.toString())){
							element.setEvRcbRp(isRepType[repType.ordinal()].booleanValue());
						}else if(repType.toString().equals(
								Reputation.RepType.RpRcbRp.toString())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setRpRcbRp(isRepType[repType.ordinal()].booleanValue());
						}
						
						this.elementList.add(element);
					}
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	private void setElements() {
=======
	private void setElements(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		Where where = this.sparqlMsg.getWhere();
		Filter filter = this.sparqlMsg.getFilter();
		
		String var;
		String concept;
		List<Term> listTerm;
		Term term;
		LIARElement element;
		
<<<<<<< HEAD
		for(int i = 0; i < this.sparqlMsg.getResult().getLength().intValue(); i++) {
			element = new LIARElement();
			Map<String, List<Term>> r = this.sparqlMsg.getResult().getResults();
			
			for(Iterator<String> iResult = r.keySet().iterator(); iResult.hasNext();) {
				var = iResult.next();
				listTerm = r.get(var);
				if(i < listTerm.size()) {
					term = listTerm.get(i);
					concept = where.getConcept(var);
					
					if(term != null) {
						if(concept.equalsIgnoreCase("agentname")) {
							if(term.getType() == Term.TermType.STRING) {
								element.setAgentName(((String) term.getTerm()));
							}
						} else if(concept.equalsIgnoreCase("facetbyliar")) {
							if(term.getType() == Term.TermType.STRING) {
								element.setFacet(Facets.getFacet((String) term.getTerm()));
							}
						} else if(concept.equalsIgnoreCase("reputationvaluebyliar")) {
							if(term.getType() == Term.TermType.FLOAT) {
								element.setValue(new Double((Float) term.getTerm()));
							}
						} else if(concept.equalsIgnoreCase(Reputation.RepType.DIbRp
								.toString().toLowerCase())) {
							if(term.getType() == Term.TermType.BOOLEAN) {
								element.setDIbRp((Boolean) term.getTerm());
							}
						} else if(concept.equalsIgnoreCase(Reputation.RepType.IIbRp
								.toString().toLowerCase())) {
							if(term.getType() == Term.TermType.BOOLEAN) {
								element.setIIbRp((Boolean) term.getTerm());
							}
						} else if(concept.equalsIgnoreCase(Reputation.RepType.ObsRcbRp
								.toString().toLowerCase())) {
							if(term.getType() == Term.TermType.BOOLEAN) {
								element.setObsRcbRp((Boolean) term.getTerm());
							}
						} else if(concept.equalsIgnoreCase(Reputation.RepType.EvRcbRp
								.toString().toLowerCase())) {
							if(term.getType() == Term.TermType.BOOLEAN) {
								element.setEvRcbRp((Boolean) term.getTerm());
							}
						} else if(concept.equalsIgnoreCase(Reputation.RepType.RpRcbRp
								.toString().toLowerCase())) {
							if(term.getType() == Term.TermType.BOOLEAN) {
=======
		for(int i = 0; i < this.sparqlMsg.getResult().getLength().intValue(); i++){
			element = new LIARElement();
			Map<String, List<Term>> r = this.sparqlMsg.getResult().getResults();
			
			for(Iterator<String> iResult = r.keySet().iterator(); iResult.hasNext();){
				var = iResult.next();
				listTerm = r.get(var);
				if(i < listTerm.size()){
					term = listTerm.get(i);
					concept = where.getConcept(var);
					
					if(term != null){
						if(concept.equalsIgnoreCase("agentname")){
							if(term.getType() == Term.TermType.STRING){
								element.setAgentName(((String) term.getTerm()));
							}
						}else if(concept.equalsIgnoreCase("facetbyliar")){
							if(term.getType() == Term.TermType.STRING){
								element.setFacet(Facets.getFacet((String) term.getTerm()));
							}
						}else if(concept.equalsIgnoreCase("reputationvaluebyliar")){
							if(term.getType() == Term.TermType.FLOAT){
								element.setValue(new Double((Float) term.getTerm()));
							}
						}else if(concept.equalsIgnoreCase(Reputation.RepType.DIbRp
								.toString().toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setDIbRp((Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(Reputation.RepType.IIbRp
								.toString().toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setIIbRp((Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(Reputation.RepType.ObsRcbRp
								.toString().toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setObsRcbRp((Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(Reputation.RepType.EvRcbRp
								.toString().toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setEvRcbRp((Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(Reputation.RepType.RpRcbRp
								.toString().toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								element.setRpRcbRp((Boolean) term.getTerm());
							}
						}
					}
				}
			}
			
			Object item;
			String[] values;
<<<<<<< HEAD
			if(element.getAgentName() == null) {
				values = where.getVariable("agentname");
				if(values != null) {
					item = filter.getItem(values[0]);
					
					if(item != null) {
						if(item instanceof RegExpr) {
=======
			if(element.getAgentName() == null){
				values = where.getVariable("agentname");
				if(values != null){
					item = filter.getItem(values[0]);
					
					if(item != null){
						if(item instanceof RegExpr){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setAgentName(((RegExpr) item).getPattern());
						}
					}
				}
			}
			
<<<<<<< HEAD
			if(element.getFacet() == null) {
				values = where.getVariable("facetbyliar");
				if(values != null) {
					item = filter.getItem(values[0]);
					
					if(item != null) {
						if(item instanceof RegExpr) {
=======
			if(element.getFacet() == null){
				values = where.getVariable("facetbyliar");
				if(values != null){
					item = filter.getItem(values[0]);
					
					if(item != null){
						if(item instanceof RegExpr){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element
									.setFacet(Facets.getFacet((((RegExpr) item).getPattern())));
						}
					}
				}
			}
			
			// isDIbRp
			values = where.getVariable(Reputation.RepType.DIbRp.toString()
					.toLowerCase());
<<<<<<< HEAD
			if(values != null) {
				item = filter.getItem(values[0]);
				if(item != null) {
					if(item instanceof RelExpr) {
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)) {
							element.setDIbRp((Boolean) rel.getTerm2().getTerm());
						} else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)) {
=======
			if(values != null){
				item = filter.getItem(values[0]);
				if(item != null){
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
							element.setDIbRp((Boolean) rel.getTerm2().getTerm());
						}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setDIbRp((Boolean) rel.getTerm1().getTerm());
						}
					}
				}
			}
			
			// isIIbRp
			values = where.getVariable(Reputation.RepType.IIbRp.toString()
					.toLowerCase());
<<<<<<< HEAD
			if(values != null) {
				item = filter.getItem(values[0]);
				
				if(item != null) {
					if(item instanceof RelExpr) {
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)) {
							element.setIIbRp((Boolean) rel.getTerm2().getTerm());
						} else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)) {
=======
			if(values != null){
				item = filter.getItem(values[0]);
				
				if(item != null){
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
							element.setIIbRp((Boolean) rel.getTerm2().getTerm());
						}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setIIbRp((Boolean) rel.getTerm1().getTerm());
						}
					}
				}
			}
			
			// isObsRcbRp
			values = where.getVariable(Reputation.RepType.ObsRcbRp.toString()
					.toLowerCase());
<<<<<<< HEAD
			if(values != null) {
				item = filter.getItem(values[0]);
				
				if(item != null) {
					if(item instanceof RelExpr) {
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)) {
							element.setObsRcbRp((Boolean) rel.getTerm2().getTerm());
						} else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)) {
=======
			if(values != null){
				item = filter.getItem(values[0]);
				
				if(item != null){
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
							element.setObsRcbRp((Boolean) rel.getTerm2().getTerm());
						}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setObsRcbRp((Boolean) rel.getTerm1().getTerm());
						}
					}
				}
			}
			
			// isEvRcbRP
			values = where.getVariable(Reputation.RepType.EvRcbRp.toString()
					.toLowerCase());
<<<<<<< HEAD
			if(values != null) {
				item = filter.getItem(values[0]);
				
				if(item != null) {
					if(item instanceof RelExpr) {
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)) {
							element.setEvRcbRp((Boolean) rel.getTerm2().getTerm());
						} else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)) {
=======
			if(values != null){
				item = filter.getItem(values[0]);
				
				if(item != null){
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
							element.setEvRcbRp((Boolean) rel.getTerm2().getTerm());
						}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setEvRcbRp((Boolean) rel.getTerm1().getTerm());
						}
					}
				}
			}
			
			// isRpRcbRp
			values = where.getVariable(Reputation.RepType.RpRcbRp.toString()
					.toLowerCase());
<<<<<<< HEAD
			if(values != null) {
				item = filter.getItem(values[0]);
				
				if(item != null) {
					if(item instanceof RelExpr) {
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)) {
							element.setRpRcbRp((Boolean) rel.getTerm2().getTerm());
						} else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)) {
=======
			if(values != null){
				item = filter.getItem(values[0]);
				
				if(item != null){
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
							element.setRpRcbRp((Boolean) rel.getTerm2().getTerm());
						}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element.setRpRcbRp((Boolean) rel.getTerm1().getTerm());
						}
					}
				}
			}
			
			// Agent and Facet are set
<<<<<<< HEAD
			if((element.getAgentName() != null) && (element.getFacet() != null)) {
=======
			if((element.getAgentName() != null) && (element.getFacet() != null)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				
				this.reputationReasoner.newRecommendation(this.sparqlMsg.getSender(),
						element.getAgentName(), element.getFacet(), Dimensions.COMPETENCE,
						element.getValue());
				
				// Only Agent is set
			}
			
			/*
			 * else if (element.getAgentName() != null){
			 * for(Facets facet : Facets.values()){
			 * this.reputationReasoner.newRecommendation(this.sparqlMsg.getSender(),
			 * element.getAgentName(), facet, Dimensions.COMPETENCE, element
			 * .getValue());
			 * }
			 * 
			 * // Only Facet is set
			 * }else if (element.getFacet() != null){
			 * 
			 * this.reputationReasoner.newRecommendation(this.sparqlMsg.getSender(),
			 * element.getFacet(), Dimensions.COMPETENCE, element.getValue());
			 * 
			 * }
			 */
			
			this.reputationReasoner.punishmentProcess();
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	private Double updateValue(Double value) {
		
		Double newValue = value;
		
		if(this.decision.isLie()) {
=======
	private Double updateValue(Double value){
		
		Double newValue = value;
		
		if(this.decision.isLie()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			newValue = new Double(this.decision.lie(value));
		}
		
		return newValue;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public Object getObject() {
=======
	public Object getObject(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.decision;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public void setObject(Object object) {
		if(object instanceof ARTDecision) {
=======
	public void setObject(Object object){
		if(object instanceof ARTDecision){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.decision = (ARTDecision) object;
		}
	}
}


/**
 * 
 */
<<<<<<< HEAD
class LIARElement {
=======
class LIARElement{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	private String	agentName;
	
	private Facets	facet;
	
	private Double	value;
	
	private Boolean	dibrp			= new Boolean(false);
	
	private Boolean	iibrp			= new Boolean(false);
	
	private Boolean	obsrcbrp	= new Boolean(false);
	
	private Boolean	evrcbrp		= new Boolean(false);
	
	private Boolean	rprcbrp		= new Boolean(false);
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public String getAgentName() {
=======
	public String getAgentName(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.agentName;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Facets getFacet() {
=======
	public Facets getFacet(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.facet;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Double getValue() {
=======
	public Double getValue(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.value;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Boolean isDIbRp() {
=======
	public Boolean isDIbRp(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.dibrp;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Boolean isIIbRp() {
=======
	public Boolean isIIbRp(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.iibrp;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Boolean isObsRcbRp() {
=======
	public Boolean isObsRcbRp(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.obsrcbrp;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Boolean isEvRcbRp() {
=======
	public Boolean isEvRcbRp(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.evrcbrp;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Boolean isRpRcbRp() {
=======
	public Boolean isRpRcbRp(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.rprcbrp;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setAgentName(String agentName) {
=======
	public void setAgentName(String agentName){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.agentName = agentName;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setFacet(Facets facet) {
=======
	public void setFacet(Facets facet){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.facet = facet;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setValue(Double value) {
=======
	public void setValue(Double value){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.value = Math.min(1.0, Math.max(-1.0, value));
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setDIbRp(Boolean dibrp) {
		if(dibrp.booleanValue()) {
=======
	public void setDIbRp(Boolean dibrp){
		if(dibrp.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.dibrp = dibrp;
			
			this.iibrp = new Boolean(false);
			this.obsrcbrp = new Boolean(false);
			this.evrcbrp = new Boolean(false);
			this.rprcbrp = new Boolean(false);
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.dibrp = new Boolean(false);
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setIIbRp(Boolean iibrp) {
		if(iibrp.booleanValue()) {
=======
	public void setIIbRp(Boolean iibrp){
		if(iibrp.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.iibrp = iibrp;
			
			this.dibrp = new Boolean(false);
			this.obsrcbrp = new Boolean(false);
			this.evrcbrp = new Boolean(false);
			this.rprcbrp = new Boolean(false);
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.iibrp = new Boolean(false);
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setObsRcbRp(Boolean obsrcbrp) {
		if(obsrcbrp.booleanValue()) {
=======
	public void setObsRcbRp(Boolean obsrcbrp){
		if(obsrcbrp.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.obsrcbrp = obsrcbrp;
			
			this.dibrp = new Boolean(false);
			this.iibrp = new Boolean(false);
			this.evrcbrp = new Boolean(false);
			this.rprcbrp = new Boolean(false);
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.obsrcbrp = new Boolean(false);
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setEvRcbRp(Boolean evrcbrp) {
		if(evrcbrp.booleanValue()) {
=======
	public void setEvRcbRp(Boolean evrcbrp){
		if(evrcbrp.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.evrcbrp = evrcbrp;
			
			this.dibrp = new Boolean(false);
			this.iibrp = new Boolean(false);
			this.obsrcbrp = new Boolean(false);
			this.rprcbrp = new Boolean(false);
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.evrcbrp = new Boolean(false);
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setRpRcbRp(Boolean rprcbrp) {
		if(rprcbrp.booleanValue()) {
=======
	public void setRpRcbRp(Boolean rprcbrp){
		if(rprcbrp.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.rprcbrp = rprcbrp;
			
			this.dibrp = new Boolean(false);
			this.iibrp = new Boolean(false);
			this.obsrcbrp = new Boolean(false);
			this.evrcbrp = new Boolean(false);
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.rprcbrp = new Boolean(false);
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void print() {
=======
	public void print(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		System.out.println(" ========== LIAR Element Information ==========");
		System.out.println("Agent Name = " + this.agentName);
		System.out.println("Facet = " + this.facet);
		System.out.println("Value = " + this.value);
		System.out.println("DIbRp = " + this.dibrp.toString());
		System.out.println("IIbRp = " + this.iibrp.toString());
		System.out.println("ObsRcbRp = " + this.obsrcbrp.toString());
		System.out.println("EvRcbRp = " + this.evrcbrp.toString());
		System.out.println("RpRcbRp = " + this.rprcbrp.toString());
	}
}