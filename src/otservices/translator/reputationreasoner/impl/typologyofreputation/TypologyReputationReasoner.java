/**
 * Copyright (c) 2010 Tomas Chaib <t.chaib@hotmail.com>
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
package otservices.translator.reputationreasoner.impl.typologyofreputation;

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
import reputationreasoners.typology.Reputation.RepType;
import reputationreasoners.typology.TypologyModule;

public class TypologyReputationReasoner implements ReputationReasonerInterface{
	
	private ARTDecision									decision						= new ARTDecision();
	
	private ArrayList<TypologyElement>	elementList;
	
	private String											id;
	
	private TypologyModule							reputationReasoner	= new TypologyModule();
	
	private SPARQLObject								sparqlMsg;
	
	
	/**
	 * 
	 */
	@Override
	public String getID(){
		return this.id;
	}
	
	
	/**
	 * 
	 */
	@Override
	public Object getObject(){
		return this.decision;
	}
	
	
	/**
	 * 
	 */
	@Override
	public synchronized ObjectInterface processInMessage(Object parsedObject){
		
		this.sparqlMsg = (SPARQLObject) parsedObject;
		
		this.elementList = new ArrayList<TypologyElement>();
		
		// Select
		if(this.sparqlMsg.getCommand() == SPARQLObject.Command.SELECT){
			this.getElements(this.isReputation());
			
			Result newResult = new Result();
			this.sparqlMsg.setCommand(SPARQLObject.Command.RESULT);
			
			Result result = this.sparqlMsg.getResult();
			Where where = this.sparqlMsg.getWhere();
			Filter filter = this.sparqlMsg.getFilter();
			
			String var;
			String concept;
			Term term;
			
			for(TypologyElement element : this.elementList){
				if(element.getValue() != null){
					
					for(Iterator<String> iResult = result.getResults().keySet()
							.iterator(); iResult.hasNext();){
						var = iResult.next();
						concept = where.getConcept(var);
						term = new Term();
						
						if(concept.equalsIgnoreCase("agentname")){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.getAgentName());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase("contextbytypology")){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.getContext().toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase("reputationvaluebytypology")){
							term.setType(Term.TermType.FLOAT);
							term.setTerm(new Double(element.getValue()).floatValue());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.TYPOLOGY.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.TYPOLOGY).toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.INDIVIDUAL.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.INDIVIDUAL).toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.GROUP.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.GROUP).toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.DIRECT.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.DIRECT).toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.INTERACTION_DERIVED
								.toString().toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.INTERACTION_DERIVED)
									.toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.OBSERVED.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.OBSERVED).toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.INDIRECT.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.INDIRECT).toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.PRIOR_DERIVED.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.PRIOR_DERIVED)
									.toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.PROPAGATED.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.PROPAGATED).toString());
							newResult.addResult(var, term);
						}else if(concept.equalsIgnoreCase(RepType.GROUP_DERIVED.toString()
								.toLowerCase())){
							term.setType(Term.TermType.STRING);
							term.setTerm(element.isReputation(RepType.GROUP_DERIVED)
									.toString());
							newResult.addResult(var, term);
						}else{
							term = filter.getValue(var);
							if(term != null){
								newResult.addResult(var, term);
							}
						}
					}
				}
				this.sparqlMsg.addResult(newResult);
			}
			return this.sparqlMsg;
			
		}else if(this.sparqlMsg.getCommand() == SPARQLObject.Command.UPDATE){
			this.setElements();
		}else if(this.sparqlMsg.getCommand() == SPARQLObject.Command.RESULT){
			this.setElements();
		}
		
		return null;
		
	}
	
	
	/**
	 * 
	 * Tipo de reputacao requisitados
	 */
	public Boolean[] isReputation(){
		
		Boolean result[] = new Boolean[RepType.values().length];
		
		Filter filter = this.sparqlMsg.getFilter();
		Where where = this.sparqlMsg.getWhere();
		String namedConcept = null;
		Iterator<String> i;
		String var;
		String concept;
		Object item;
		
		for(RepType type : RepType.values()){
			
			namedConcept = type.toString();
			result[type.ordinal()] = new Boolean(false);
			
			i = where.getWhere().keySet().iterator();
			while(i.hasNext()){
				var = i.next();
				concept = where.getConcept(var);
				if(concept != null){
					if(concept.equalsIgnoreCase(namedConcept)){
						item = filter.getItem(var);
						
						if(item instanceof RelExpr){
							RelExpr rel = (RelExpr) item;
							
							Term term = new Term();
							term.setType(Term.TermType.BOOLEAN);
							term.setTerm(new Boolean(true));
							if(rel.evaluate(term).booleanValue()){
								result[type.ordinal()] = new Boolean(true);
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
	private void getElements(Boolean[] isRepType){
		Where where = this.sparqlMsg.getWhere();
		Filter filter = this.sparqlMsg.getFilter();
		
		RegExpr reg;
		Object item;
		
		TypologyElement element;
		
		for(RepType type : RepType.values()){
			if(isRepType[type.ordinal()].booleanValue()){
				Boolean reputationByTypology = isRepType[type.ordinal()];
				
				String varAgentReputationByTypology = where
						.getVariable("contextbytypology")[0];
				String contextByTypology = null;
				String varAgentName = where.getVariable("agentname")[0];
				String agentNameByTypology = null;
				String varValueByTypology = where
						.getVariable("reputationvaluebytypology")[0];
				
				if((varAgentReputationByTypology != null) && (varAgentName != null)
						&& (varValueByTypology != null)){
					
					// Get target
					item = filter.getItem(varAgentName);
					if(item != null){
						if(item instanceof RegExpr){
							reg = (RegExpr) item;
							agentNameByTypology = reg.getPattern();
						}
						
						// Get context
						item = filter.getItem(varAgentReputationByTypology);
						if(item != null){
							if(item instanceof RegExpr){
								reg = (RegExpr) item;
								contextByTypology = reg.getPattern();
							}
						}
						
						if((agentNameByTypology != null) && (contextByTypology != null)){
							
							if(this.reputationReasoner.exists(agentNameByTypology,
									contextByTypology)){
								
								double value = this.getReputation(type, agentNameByTypology,
										contextByTypology);
								
								element = new TypologyElement();
								element.setContext(contextByTypology);
								element.setAgentName(agentNameByTypology);
								element.setReputation(type, reputationByTypology);
								element.setValue(value);
								this.elementList.add(element);
							}
						}else if(agentNameByTypology != null){
							String[] contexts = this.reputationReasoner
									.getContexts(agentNameByTypology);
							
							if(contexts != null){
								double value;
								for(int j = 0; j < contexts.length; j++){
									value = this.getReputation(type, agentNameByTypology,
											contexts[j]);
									
									element = new TypologyElement();
									element.setContext(contexts[j]);
									element.setAgentName(agentNameByTypology);
									element.setReputation(type, reputationByTypology);
									element.setValue(value);
									this.elementList.add(element);
								}
							}
						}else if(contextByTypology != null){
							String[] targets = this.reputationReasoner
									.getTargets(contextByTypology);
							
							if(targets != null){
								double value;
								for(int j = 0; j < targets.length; j++){
									value = this.getReputation(type, targets[j],
											contextByTypology);
									
									element = new TypologyElement();
									element.setContext(contextByTypology);
									element.setAgentName(targets[j]);
									element.setReputation(type, reputationByTypology);
									element.setValue(value);
									this.elementList.add(element);
								}
							}
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
	private void setElements(){
		
		Where where = this.sparqlMsg.getWhere();
		Filter filter = this.sparqlMsg.getFilter();
		
		String var;
		String concept;
		List<Term> listTerm;
		Term term;
		TypologyElement element;
		
		for(int i = 0; i < this.sparqlMsg.getResult().getLength().intValue(); i++){
			element = new TypologyElement();
			Map<String, List<Term>> r = this.sparqlMsg.getResult().getResults();
			
			for(Iterator<String> iResult = r.keySet().iterator(); iResult.hasNext();){
				var = iResult.next();
				listTerm = r.get(var);
				if(i < listTerm.size()){
					term = listTerm.get(i);
					
					if(term != null){
						concept = where.getConcept(var);
						
						if(concept.equalsIgnoreCase("agentname")){
							if(term.getType() == Term.TermType.STRING){
								element.setAgentName(((String) term.getTerm()));
							}
						}else if(concept.equalsIgnoreCase("contextbytypology")){
							if(term.getType() == Term.TermType.STRING){
								element.setContext((String) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase("reputationvaluebytypology")){
							if(term.getType() == Term.TermType.FLOAT){
								element.setValue(new Double((Float) term.getTerm()));
							}
						}else if(concept.equalsIgnoreCase(RepType.TYPOLOGY.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.TYPOLOGY,
										(Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.INDIVIDUAL.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.INDIVIDUAL,
										(Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.GROUP.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.GROUP, (Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.DIRECT.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.DIRECT, (Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.INTERACTION_DERIVED
								.toString().toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.INTERACTION_DERIVED,
										(Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.OBSERVED.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.OBSERVED,
										(Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.INDIRECT.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.INDIRECT,
										(Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.PRIOR_DERIVED.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.PRIOR_DERIVED,
										(Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.PROPAGATED.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.PROPAGATED,
										(Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase(RepType.GROUP_DERIVED.toString()
								.toLowerCase())){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation(RepType.GROUP, (Boolean) term.getTerm());
							}
						}
					}
				}
			}
			
			Object item;
			String[] values;
			if(element.getAgentName() == null){
				values = where.getVariable("agentname");
				if(values != null){
					item = filter.getItem(values[0]);
					
					if(item != null){
						if(item instanceof RegExpr){
							element.setAgentName(((RegExpr) item).getPattern());
						}
					}
				}
			}
			
			if(element.getContext() == null){
				values = where.getVariable("contextbytypology");
				if(values != null){
					item = filter.getItem(values[0]);
					
					if(item != null){
						if(item instanceof RegExpr){
							element.setContext(((RegExpr) item).getPattern());
						}
					}
				}
			}
			
			// Set the Reputation Type
			for(RepType type : RepType.values()){
				values = where.getVariable(type.toString().toLowerCase());
				
				if(values != null){
					item = filter.getItem(values[0]);
					if(item != null){
						if(item instanceof RelExpr){
							RelExpr rel = (RelExpr) item;
							if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
									&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
								element.setReputation(type, (Boolean) rel.getTerm2().getTerm());
							}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
									&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
								element.setReputation(type, (Boolean) rel.getTerm1().getTerm());
							}
						}
					}
				}
			}
			
			// Agent and Context are set
			if((element.getAgentName() != null) && (element.getContext() != null)){
				
				if(!this.reputationReasoner.exists(element.getAgentName(),
						element.getContext())){
					this.reputationReasoner.addUnit(element.getAgentName(),
							element.getContext());
				}
				
				for(RepType type : RepType.values()){
					if(element.isReputation(type)){
						this.reputationReasoner.updateReputation(RepType.PROPAGATED,
								this.sparqlMsg.getSender(), element.getAgentName(),
								element.getContext(), element.getValue());
					}
				}
			}
		}
	}
	
	
	/**
	 * Obtem valor de um tipo especifico de reputacao
	 */
	private double getReputation(RepType type, String agentNameByTypology,
			String contextByTypology){
		double value;
		
		if(this.decision != null){
			if(this.decision.isLie()){
				value = this.decision.lie(this.reputationReasoner.getReputation(type,
						agentNameByTypology, contextByTypology));
				
			}else{
				value = this.reputationReasoner.getReputation(type,
						agentNameByTypology, contextByTypology);
				
			}
		}else{
			value = this.reputationReasoner.getReputation(type, agentNameByTypology,
					contextByTypology);
			
		}
		
		return value;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void setID(String id){
		this.id = id;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void setObject(Object object){
		if(object instanceof ARTDecision)
			this.decision = (ARTDecision) object;
	}
	
	
	/**
	 * 
	 */
	public TypologyModule getReputationReasoner(){
		return this.reputationReasoner;
	}
	
	
	/**
	 * 
	 */
	public void setReputationReasoner(TypologyModule reputationReasoner){
		this.reputationReasoner = reputationReasoner;
	}
	
	/**
	 * 
	 */
	class TypologyElement{
		
		private String		context;
		
		private String		agentName;
		
		private Boolean[]	reputation	= new Boolean[RepType.values().length];
		
		private Double		value;
		
		
		/**
		 * 
		 */
		public TypologyElement(){
			for(RepType type : RepType.values()){
				this.reputation[type.ordinal()] = false;
			}
		}
		
		
		/**
		 * 
		 */
		public String getContext(){
			return this.context;
		}
		
		
		/**
		 * 
		 */
		public String getAgentName(){
			return this.agentName;
		}
		
		
		/**
		 * 
		 */
		public Double getValue(){
			return this.value;
		}
		
		
		/**
		 * 
		 */
		public Boolean isReputation(RepType type){
			return this.reputation[type.ordinal()];
		}
		
		
		/**
		 * 
		 */
		public void setContext(String context){
			this.context = context;
		}
		
		
		/**
		 * 
		 */
		public void setAgentName(String agentName){
			this.agentName = agentName;
		}
		
		
		/**
		 * 
		 */
		public void setReputation(Boolean[] reputation){
			this.reputation = reputation;
		}
		
		
		/**
		 * 
		 */
		public void setReputation(RepType type, Boolean reputation){
			this.reputation[type.ordinal()] = reputation;
		}
		
		
		/**
		 * 
		 */
		public void setValue(double value){
			this.value = value;
		}
		
		
		/**
		 * 
		 */
		public void print(){
			System.out.println(" ========== Typology Element Information ==========");
			System.out.println("Agent Name = " + this.agentName);
			System.out.println("Context = " + this.context);
			for(RepType type : RepType.values()){
				System.out.println(type.toString() + " = "
						+ this.reputation[type.ordinal()].toString());
			}
			System.out.println("Value = " + this.value);
		}
	}
	
}