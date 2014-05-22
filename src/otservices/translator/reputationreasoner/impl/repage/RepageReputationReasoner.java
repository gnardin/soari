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
package otservices.translator.reputationreasoner.impl.repage;

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
import reputationreasoners.repage.RepageModule;

public class RepageReputationReasoner implements ReputationReasonerInterface{
	
	private ARTDecision					decision						= new ARTDecision();
	
	private List<RepageElement>	elementList;
	
	private String							id;
	
	private RepageModule				reputationReasoner	= new RepageModule();
	
	private SPARQLObject				sparqlMsg;
	
	
	/**
	 * 
	 */
	@Override
	public synchronized ObjectInterface processInMessage(Object parsedObject){
		this.sparqlMsg = (SPARQLObject) parsedObject;
		
		this.elementList = new ArrayList<RepageElement>();
		
		// SELECT
		if(this.sparqlMsg.getCommand() == SPARQLObject.Command.SELECT){
			this.getElements(this.isImage(), this.isReputation());
			
			Result newResult = new Result();
			this.sparqlMsg.setCommand(SPARQLObject.Command.RESULT);
			
			Result result = this.sparqlMsg.getResult();
			Where where = this.sparqlMsg.getWhere();
			Filter filter = this.sparqlMsg.getFilter();
			
			String var;
			String concept;
			Term term;
			RepageElement element;
			for(Iterator<RepageElement> iElement = this.elementList.iterator(); iElement
					.hasNext();){
				element = iElement.next();
				if(element.getValue() != null){
					
					for(Iterator<String> iResult = result.getResults().keySet()
							.iterator(); iResult.hasNext();){
						var = iResult.next();
						concept = where.getConcept(var);
						term = new Term();
						
						if(element.isImage().booleanValue()){
							if(concept.equalsIgnoreCase("agentimagebyrepage")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.getAgentFacet());
								newResult.addResult(var, term);
							}else if(concept.equalsIgnoreCase("agentname")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.getAgentName());
								newResult.addResult(var, term);
							}else if(concept.equalsIgnoreCase("imagebyrepage")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.isImage().toString());
								newResult.addResult(var, term);
							}else if(concept.equalsIgnoreCase("valuebyrepage")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.getValue());
								newResult.addResult(var, term);
							}else{
								term = filter.getValue(var);
								if(term != null){
									newResult.addResult(var, term);
								}
							}
						}else if(element.isReputation().booleanValue()){
							if(concept.equalsIgnoreCase("agentreputationbyrepage")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.getAgentFacet());
								newResult.addResult(var, term);
							}else if(concept.equalsIgnoreCase("agentname")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.getAgentName());
								newResult.addResult(var, term);
							}else if(concept.equalsIgnoreCase("reputationbyrepage")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.isReputation().toString());
								newResult.addResult(var, term);
							}else if(concept.equalsIgnoreCase("valuebyrepage")){
								term.setType(Term.TermType.STRING);
								term.setTerm(element.getValue());
								newResult.addResult(var, term);
							}else{
								term = filter.getValue(var);
								if(term != null){
									newResult.addResult(var, term);
								}
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
	 */
	@Override
	public String getID(){
		return this.id;
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
	public RepageModule getReputationReasoner(){
		return this.reputationReasoner;
	}
	
	
	/**
	 * 
	 */
	public void setReputationReasoner(RepageModule reputationReasoner){
		this.reputationReasoner = reputationReasoner;
	}
	
	
	/**
	 * 
	 */
	private Boolean isImage(){
		Boolean result = new Boolean(false);
		
		Filter filter = this.sparqlMsg.getFilter();
		
		Where where = this.sparqlMsg.getWhere();
		Iterator<String> i = where.getWhere().keySet().iterator();
		String var;
		String concept;
		Object item;
		while(i.hasNext()){
			var = i.next();
			concept = where.getConcept(var);
			if(concept != null){
				if(concept.equalsIgnoreCase("imagebyrepage")){
					item = filter.getItem(var);
					
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						
						Term term = new Term();
						term.setType(Term.TermType.BOOLEAN);
						term.setTerm(new Boolean(true));
						if(rel.evaluate(term).booleanValue()){
							result = new Boolean(true);
							break;
						}
						break;
					}
				}else if(concept.equalsIgnoreCase("agentimagebyrepage")){
					result = new Boolean(true);
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	private Boolean isReputation(){
		Boolean result = new Boolean(false);
		
		Filter filter = this.sparqlMsg.getFilter();
		
		Where where = this.sparqlMsg.getWhere();
		Iterator<String> i = where.getWhere().keySet().iterator();
		String var;
		String concept;
		Object item;
		while(i.hasNext()){
			var = i.next();
			concept = where.getConcept(var);
			if(concept != null){
				if(concept.equalsIgnoreCase("reputationbyrepage")){
					item = filter.getItem(var);
					
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						
						Term term = new Term();
						term.setType(Term.TermType.BOOLEAN);
						term.setTerm(new Boolean(true));
						if(rel.evaluate(term).booleanValue()){
							result = new Boolean(true);
							break;
						}
						break;
					}
				}else if(concept.equalsIgnoreCase("agentreputationbyrepage")){
					result = new Boolean(true);
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	private void getElements(Boolean isImage, Boolean isReputation){
		Where where = this.sparqlMsg.getWhere();
		Filter filter = this.sparqlMsg.getFilter();
		
		RegExpr reg;
		Object item;
		RepageElement element;
		
		// Image
		if(isImage.booleanValue()){
			Boolean imageByRepage = isImage;
			String varAgentImageByRepage = where.getVariable("agentimagebyrepage")[0];
			String agentImageByRepage = null;
			String varAgentName = where.getVariable("agentname")[0];
			String agentNameByRepage = null;
			String varValueByRepage = where.getVariable("valuebyrepage")[0];
			
			if((varAgentImageByRepage != null) && (varAgentName != null)
					&& (varValueByRepage != null)){
				
				// Get target
				item = filter.getItem(varAgentName);
				if(item != null){
					if(item instanceof RegExpr){
						reg = (RegExpr) item;
						agentNameByRepage = reg.getPattern();
					}
					
					// Get facet
					item = filter.getItem(varAgentImageByRepage);
					if(item != null){
						if(item instanceof RegExpr){
							reg = (RegExpr) item;
							agentImageByRepage = reg.getPattern();
						}
					}
					
					if((agentNameByRepage != null) && (agentImageByRepage != null)){
						
						if(this.reputationReasoner.exists(agentNameByRepage,
								agentImageByRepage)){
							
							String value = this.getImage(agentNameByRepage,
									agentImageByRepage);
							
							element = new RepageElement();
							element.setAgentFacet(agentImageByRepage);
							element.setAgentName(agentNameByRepage);
							element.setImage(imageByRepage);
							element.setValue(value);
							this.elementList.add(element);
						}
					}else if(agentNameByRepage != null){
						String[] facets = this.reputationReasoner
								.getFacets(agentNameByRepage);
						
						if(facets != null){
							String value;
							for(int i = 0; i < facets.length; i++){
								value = this.getImage(agentNameByRepage, facets[i]);
								
								element = new RepageElement();
								element.setAgentFacet(facets[i]);
								element.setAgentName(agentNameByRepage);
								element.setImage(imageByRepage);
								element.setValue(value);
								this.elementList.add(element);
							}
						}
					}else if(agentImageByRepage != null){
						String[] targets = this.reputationReasoner
								.getTargets(agentImageByRepage);
						
						if(targets != null){
							String value;
							for(int i = 0; i < targets.length; i++){
								value = this.getImage(targets[i], agentImageByRepage);
								
								element = new RepageElement();
								element.setAgentFacet(agentImageByRepage);
								element.setAgentName(targets[i]);
								element.setImage(imageByRepage);
								element.setValue(value);
								this.elementList.add(element);
							}
						}
					}
				}
			}
		}
		
		// Reputation
		if(isReputation.booleanValue()){
			Boolean reputationByRepage = isReputation;
			String varAgentReputationByRepage = where
					.getVariable("agentreputationbyrepage")[0];
			String agentReputationByRepage = null;
			String varAgentName = where.getVariable("agentname")[0];
			String agentNameByRepage = null;
			String varValueByRepage = where.getVariable("valuebyrepage")[0];
			
			if((varAgentReputationByRepage != null) && (varAgentName != null)
					&& (varValueByRepage != null)){
				
				// Get target
				item = filter.getItem(varAgentName);
				if(item != null){
					if(item instanceof RegExpr){
						reg = (RegExpr) item;
						agentNameByRepage = reg.getPattern();
					}
					
					// Get facet
					item = filter.getItem(varAgentReputationByRepage);
					if(item != null){
						if(item instanceof RegExpr){
							reg = (RegExpr) item;
							agentReputationByRepage = reg.getPattern();
						}
					}
					
					if((agentNameByRepage != null) && (agentReputationByRepage != null)){
						
						if(this.reputationReasoner.exists(agentNameByRepage,
								agentReputationByRepage)){
							
							String value = this.getReputation(agentNameByRepage,
									agentReputationByRepage);
							
							element = new RepageElement();
							element.setAgentFacet(agentReputationByRepage);
							element.setAgentName(agentNameByRepage);
							element.setReputation(reputationByRepage);
							element.setValue(value);
							this.elementList.add(element);
						}
					}else if(agentNameByRepage != null){
						String[] facets = this.reputationReasoner
								.getFacets(agentNameByRepage);
						
						if(facets != null){
							String value;
							for(int i = 0; i < facets.length; i++){
								value = this.getReputation(agentNameByRepage, facets[i]);
								
								element = new RepageElement();
								element.setAgentFacet(facets[i]);
								element.setAgentName(agentNameByRepage);
								element.setReputation(reputationByRepage);
								element.setValue(value);
								this.elementList.add(element);
							}
						}
					}else if(agentReputationByRepage != null){
						String[] targets = this.reputationReasoner
								.getTargets(agentReputationByRepage);
						
						if(targets != null){
							String value;
							for(int i = 0; i < targets.length; i++){
								value = this.getReputation(targets[i], agentReputationByRepage);
								
								element = new RepageElement();
								element.setAgentFacet(agentReputationByRepage);
								element.setAgentName(targets[i]);
								element.setReputation(reputationByRepage);
								element.setValue(value);
								this.elementList.add(element);
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
		RepageElement element;
		
		for(int i = 0; i < this.sparqlMsg.getResult().getLength().intValue(); i++){
			element = new RepageElement();
			Map<String, List<Term>> r = this.sparqlMsg.getResult().getResults();
			Iterator<String> iResult = r.keySet().iterator();
			
			while(iResult.hasNext()){
				var = iResult.next();
				listTerm = r.get(var);
				if(i < listTerm.size()){
					term = listTerm.get(i);
					concept = where.getConcept(var);
					
					if(term != null){
						if(concept.equalsIgnoreCase("imagebyrepage")){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setImage(((Boolean) term.getTerm()));
							}
						}else if(concept.equalsIgnoreCase("reputationbyrepage")){
							if(term.getType() == Term.TermType.BOOLEAN){
								element.setReputation((Boolean) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase("agentimagebyrepage")){
							if(term.getType() == Term.TermType.STRING){
								element.setAgentFacet((String) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase("agentreputationbyrepage")){
							if(term.getType() == Term.TermType.STRING){
								element.setAgentFacet((String) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase("agentname")){
							if(term.getType() == Term.TermType.STRING){
								element.setAgentName((String) term.getTerm());
							}
						}else if(concept.equalsIgnoreCase("valuebyrepage")){
							if(term.getType() == Term.TermType.STRING){
								element.setValue((String) term.getTerm());
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
			
			if(element.getAgentFacet() == null){
				values = where.getVariable("agentimagebyrepage");
				if(values != null){
					item = filter.getItem(values[0]);
					
					if(item != null){
						if(item instanceof RegExpr){
							element.setAgentFacet(((RegExpr) item).getPattern());
						}
					}
				}
			}
			
			// isImage
			values = where.getVariable("imagebyrepage");
			if(values != null){
				item = filter.getItem(values[0]);
				if(item != null){
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
							element.setImage((Boolean) rel.getTerm2().getTerm());
						}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
							element.setImage((Boolean) rel.getTerm1().getTerm());
						}
					}
				}
			}
			
			// isReputation
			values = where.getVariable("reputationbyrepage");
			if(values != null){
				item = filter.getItem(values[0]);
				
				if(item != null){
					if(item instanceof RelExpr){
						RelExpr rel = (RelExpr) item;
						if((rel.getTerm1().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm2().getType() == Term.TermType.BOOLEAN)){
							element.setReputation((Boolean) rel.getTerm2().getTerm());
						}else if((rel.getTerm2().getType() == Term.TermType.VARIABLE)
								&& (rel.getTerm1().getType() == Term.TermType.BOOLEAN)){
							element.setReputation((Boolean) rel.getTerm1().getTerm());
						}
					}
				}
			}
			
			if((element.getAgentName() != null) && (element.getAgentFacet() != null)){
				
				if(!this.reputationReasoner.exists(element.getAgentName(),
						element.getAgentFacet())){
					
					this.reputationReasoner.setRepageMemory(element.getAgentName(),
							element.getAgentFacet());
				}
				
				if(element.isImage().booleanValue()){
					this.reputationReasoner.calculateTPImage(element.getAgentName(),
							element.getAgentFacet(), element.getValue());
				}else if(element.isReputation().booleanValue()){
					this.reputationReasoner.calculateReputation(element.getAgentName(),
							element.getAgentFacet(), element.getValue());
				}
			}
			
			/*
			 * else if (element.getAgentName() != null){
			 * String[] facets = this.reputationReasoner.getFacets(element
			 * .getAgentName());
			 * 
			 * if (element.isImage().booleanValue()){
			 * for(int x = 0; x < facets.length; x++){
			 * this.reputationReasoner.calculateTPImage(element.getAgentName(),
			 * facets[x], element.getValue());
			 * }
			 * }else if (element.isReputation().booleanValue()){
			 * for(int x = 0; x < facets.length; x++){
			 * this.reputationReasoner.calculateReputation(element.getAgentName(),
			 * facets[x], element.getValue());
			 * }
			 * }
			 * }else if (element.getAgentFacet() != null){
			 * String[] targets = this.reputationReasoner.getTargets(element
			 * .getAgentFacet());
			 * 
			 * if (element.isImage().booleanValue()){
			 * for(int x = 0; x < targets.length; x++){
			 * this.reputationReasoner.calculateTPImage(targets[x], element
			 * .getAgentName(), element.getValue());
			 * }
			 * }else if (element.isReputation().booleanValue()){
			 * for(int x = 0; x < targets.length; x++){
			 * this.reputationReasoner.calculateReputation(targets[x], element
			 * .getAgentName(), element.getValue());
			 * }
			 * }
			 * }
			 */
		}
	}
	
	
	/**
	 * 
	 */
	private String getImage(String agentNameByRepage, String agentImageByRepage){
		String value;
		
		if(this.decision.isLie()){
			double image = this.decision.lie(this.reputationReasoner.getImage(
					agentNameByRepage, agentImageByRepage));
			
			double strength = this.reputationReasoner.getImageStrength(
					agentNameByRepage, agentImageByRepage);
			
			value = this.reputationReasoner
					.convertRealToString(new Double(image).floatValue(), strength)
					.substring(1, 22).replace(",", ";");
		}else{
			value = this.reputationReasoner
					.getImageText(agentNameByRepage, agentImageByRepage).substring(1, 22)
					.replace(",", ";");
		}
		
		return value;
	}
	
	
	/**
	 * 
	 */
	private String getReputation(String agentNameByRepage,
			String agentReputationByRepage){
		String value;
		
		if(this.decision != null){
			if(this.decision.isLie()){
				double reputation = this.decision.lie(this.reputationReasoner
						.getReputation(agentNameByRepage, agentReputationByRepage));
				
				double strength = this.reputationReasoner.getReputationStrength(
						agentNameByRepage, agentReputationByRepage);
				
				value = this.reputationReasoner
						.convertRealToString(new Double(reputation).floatValue(), strength)
						.substring(1, 22).replace(",", ";");
				
			}else{
				value = this.reputationReasoner
						.getReputationText(agentNameByRepage, agentReputationByRepage)
						.substring(1, 22).replace(",", ";");
			}
		}else{
			value = this.reputationReasoner
					.getReputationText(agentNameByRepage, agentReputationByRepage)
					.substring(1, 22).replace(",", ";");
		}
		
		return value;
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
	public void setObject(Object object){
		if(object instanceof ARTDecision){
			this.decision = (ARTDecision) object;
		}
	}
}


/**
 * 
 */
class RepageElement{
	
	private String	agentFacet;
	
	private String	agentName;
	
	private Boolean	image				= new Boolean(false);
	
	private Boolean	reputation	= new Boolean(false);
	
	private String	value;
	
	
	/**
	 * 
	 */
	public String getAgentFacet(){
		return this.agentFacet;
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
	public String getValue(){
		return this.value;
	}
	
	
	/**
	 * 
	 */
	public Boolean isImage(){
		return this.image;
	}
	
	
	/**
	 * 
	 */
	public Boolean isReputation(){
		return this.reputation;
	}
	
	
	/**
	 * 
	 */
	public void setAgentFacet(String agentFacet){
		this.agentFacet = agentFacet;
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
	public void setImage(Boolean image){
		this.image = image;
		if(image.booleanValue()){
			this.reputation = new Boolean(false);
		}else{
			this.reputation = new Boolean(true);
		}
	}
	
	
	/**
	 * 
	 */
	public void setReputation(Boolean reputation){
		this.reputation = reputation;
		if(reputation.booleanValue()){
			this.image = new Boolean(false);
		}else{
			this.image = new Boolean(true);
		}
	}
	
	
	/**
	 * 
	 */
	public void setValue(String value){
		this.value = value;
	}
	
	
	/**
	 * 
	 */
	public void print(){
		System.out.println(" ========== Repage Element Information ==========");
		System.out.println("Agent Name = " + this.agentName);
		System.out.println("Agent Image = " + this.agentFacet);
		System.out.println("Image = " + this.image.toString());
		System.out.println("Reputation = " + this.reputation.toString());
		System.out.println("Value = " + this.value);
	}
}