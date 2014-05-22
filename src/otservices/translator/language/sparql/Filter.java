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
package otservices.translator.language.sparql;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Filter implements Serializable {
	
	private List<Object>	filter	= new ArrayList<Object>();
	
	
	/**
	 * 
	 */
	public List<Object> getFilter() {
		return this.filter;
	}
	
	
	/**
	 * 
	 */
	public void addItem(Object item) {
		this.filter.add(item);
	}
	
	
	/**
	 * 
	 */
	public Boolean evalute(Map<String, Term> varValue) {
		Boolean result = null;
		
		Iterator<Object> iFilter = this.filter.iterator();
		Object e;
		List<Object> auxList = new ArrayList<Object>();
		Term auxTerm1 = null;
		Term auxTerm2 = null;
		RelExpr auxRelExpr;
		RegExpr auxRegExpr;
		LogExpr auxLogExpr;
		while(iFilter.hasNext()) {
			e = iFilter.next();
			if(e instanceof Term) {
				if(((Term) e).getPosition() == Term.Position.FIRST) {
					auxTerm1 = (Term) e;
				} else if(((Term) e).getPosition() == Term.Position.SECOND) {
					auxTerm2 = (Term) e;
				}
			} else if(e instanceof RelExpr) {
				if((auxTerm1 != null) && (auxTerm2 != null)) {
					auxRelExpr = (RelExpr) e;
					auxRelExpr.setTerm1(auxTerm1);
					auxRelExpr.setTerm2(auxTerm2);
					
					auxList.add(auxRelExpr);
				}
				auxTerm1 = null;
				auxTerm2 = null;
			} else if(e instanceof RegExpr) {
				auxRegExpr = (RegExpr) e;
				
				auxList.add(auxRegExpr);
			} else if(e instanceof LogExpr) {
				auxLogExpr = (LogExpr) e;
				
				if(auxList.size() == 1) {
					auxLogExpr.addExpression(auxList.get(0));
					auxList.remove(0);
					auxList.add(auxLogExpr);
				} else if(auxList.size() > 1) {
					auxLogExpr.addExpression(auxList.get(auxList.size() - 1));
					auxLogExpr.addExpression(auxList.get(auxList.size() - 2));
					auxList.remove(auxList.size() - 1);
					auxList.remove(auxList.size() - 1);
					auxList.add(auxLogExpr);
				}
			}
		}
		
		if(auxList.size() == 1) {
			e = auxList.get(0);
			if(e instanceof LogExpr) {
				result = ((LogExpr) e).evaluate(varValue);
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public Object getItem(String variable) {
		Object result = null;
		
		RegExpr reg;
		RelExpr rel;
		Term term1;
		Term term2;
		
		Object o;
		Boolean found = new Boolean(false);
		for(Iterator<Object> i = this.filter.iterator(); (i.hasNext() && (!found
				.booleanValue()));) {
			
			o = i.next();
			if(o instanceof RegExpr) {
				reg = (RegExpr) o;
				if(reg.getVariable().equals(variable)) {
					result = reg;
					found = new Boolean(true);
				}
			} else if(o instanceof Term) {
				term1 = (Term) o;
				if((term1.getPosition() == Term.Position.FIRST)
						&& (term1.getType() == Term.TermType.VARIABLE)) {
					
					if((((String) term1.getTerm()).equals(variable)) && (i.hasNext())) {
						term2 = (Term) i.next();
						
						if(i.hasNext()) {
							rel = (RelExpr) i.next();
							rel.setTerm1(term1);
							rel.setTerm2(term2);
							
							result = rel;
							found = new Boolean(true);
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
	public Term getValue(String variable) {
		Term returnValue = null;
		
		Object item = this.getItem(variable);
		if(item != null) {
			returnValue = new Term();
			
			if(item instanceof RelExpr) {
				
				RelExpr relExpr = (RelExpr) item;
				
				if(relExpr.getTerm1().getType() == Term.TermType.VARIABLE) {
					returnValue.setTerm(relExpr.getTerm2().getTerm());
					returnValue.setTerm(relExpr.getTerm2().getType());
				} else if(relExpr.getTerm2().getType() == Term.TermType.VARIABLE) {
					returnValue.setTerm(relExpr.getTerm1().getTerm());
					returnValue.setTerm(relExpr.getTerm1().getType());
				}
				
			} else if(item instanceof RegExpr) {
				
				RegExpr regExpr = (RegExpr) item;
				
				returnValue.setTerm(regExpr.getPattern());
				returnValue.setType(Term.TermType.STRING);
			}
		}
		
		return returnValue;
	}
	
	
	/**
	 * 
	 */
	public void updateConcepts(MapTable varMap) {
		List<Object> newFilter = new ArrayList<Object>();
		
		Iterator<Object> iFilter = this.filter.iterator();
		Object element;
		
		Term term;
		Term term1 = null;
		Term term2 = null;
		
		RegExpr auxRegExpr = null;
		RegExpr newRegExpr = null;
		
		String[] newVars = null;
		String[] newVarsTerm1 = null;
		String[] newVarsTerm2 = null;
		
		Boolean termRemoved = new Boolean(false);
		
		Boolean contain = new Boolean(false);
		Boolean containTerm1 = new Boolean(false);
		Boolean containTerm2 = new Boolean(false);
		
		LogExpr andExpr = new LogExpr();
		andExpr.setLogicalOp(LogExpr.LogicalOp.AND);
		
		while(iFilter.hasNext()) {
			element = iFilter.next();
			if(element instanceof Term) {
				term = (Term) element;
				if(term.getPosition() == Term.Position.FIRST) {
					term1 = term;
				} else if(term.getPosition() == Term.Position.SECOND) {
					term2 = term;
				}
			} else if(element instanceof RelExpr) {
				
				if(((term1.getType() == Term.TermType.VARIABLE) && (term2.getType() != Term.TermType.VARIABLE))
						|| ((term1.getType() != Term.TermType.VARIABLE) && (term2.getType() == Term.TermType.VARIABLE))) {
					
					newVars = null;
					if(term1.getType() == Term.TermType.VARIABLE) {
						contain = new Boolean(varMap.contains(MapRow.FieldType.SOURCEVAR,
								(String) term1.getTerm()));
						if(contain.booleanValue()) {
							newVars = varMap.get(MapRow.FieldType.SOURCEVAR,
									(String) term1.getTerm(), MapRow.FieldType.TARGETVAR);
						}
					} else if(term2.getType() == Term.TermType.VARIABLE) {
						contain = new Boolean(varMap.contains(MapRow.FieldType.SOURCEVAR,
								(String) term2.getTerm()));
						if(contain.booleanValue()) {
							newVars = varMap.get(MapRow.FieldType.SOURCEVAR,
									(String) term2.getTerm(), MapRow.FieldType.TARGETVAR);
						}
					}
					
					if((newVars != null) && (contain.booleanValue())) {
						for(int x = 0; x < newVars.length; x++) {
							term = new Term();
							if(term1.getType() == Term.TermType.VARIABLE) {
								term.setPosition(Term.Position.FIRST);
								term.setType(Term.TermType.VARIABLE);
								term.setTerm(newVars[x]);
								newFilter.add(term);
								newFilter.add(term2);
								newFilter.add(element);
							} else if(term2.getType() == Term.TermType.VARIABLE) {
								newFilter.add(term1);
								term.setPosition(Term.Position.FIRST);
								term.setType(Term.TermType.VARIABLE);
								term.setTerm(newVars[x]);
								newFilter.add(term);
								newFilter.add(element);
							}
							
							if(x != 0) {
								newFilter.add(andExpr);
							}
						}
					} else if((newVars == null) && (contain.booleanValue())) {
						termRemoved = new Boolean(true);
					} else if(!contain.booleanValue()) {
						newFilter.add(term1);
						newFilter.add(term2);
						newFilter.add(element);
					}
				} else if((term1.getType() == Term.TermType.VARIABLE)
						&& (term2.getType() == Term.TermType.VARIABLE)) {
					
					containTerm1 = new Boolean(varMap.contains(
							MapRow.FieldType.SOURCEVAR, (String) term1.getTerm()));
					if(containTerm1.booleanValue()) {
						newVarsTerm1 = varMap.get(MapRow.FieldType.SOURCEVAR,
								(String) term1.getTerm(), MapRow.FieldType.TARGETVAR);
					}
					
					containTerm2 = new Boolean(varMap.contains(
							MapRow.FieldType.SOURCEVAR, (String) term2.getTerm()));
					if(containTerm2.booleanValue()) {
						newVarsTerm2 = varMap.get(MapRow.FieldType.SOURCEVAR,
								(String) term2.getTerm(), MapRow.FieldType.TARGETVAR);
					}
					
					if(containTerm1.booleanValue() && containTerm2.booleanValue()) {
						
						if((newVarsTerm1 != null) && (newVarsTerm2 != null)) {
							
							for(int x = 0; x < newVarsTerm1.length; x++) {
								for(int y = 0; y < newVarsTerm2.length; y++) {
									term1 = new Term();
									term1.setPosition(Term.Position.FIRST);
									term1.setType(Term.TermType.VARIABLE);
									term1.setTerm(newVarsTerm1[x]);
									newFilter.add(term1);
									term2 = new Term();
									term2.setPosition(Term.Position.FIRST);
									term2.setType(Term.TermType.VARIABLE);
									term2.setTerm(newVarsTerm2[y]);
									newFilter.add(term2);
									newFilter.add(element);
									
									if((x != 0) || (y != 0)) {
										newFilter.add(andExpr);
									}
								}
							}
						} else {
							termRemoved = new Boolean(true);
						}
						
					} else if(containTerm1.booleanValue()) {
						if(newVarsTerm1 != null) {
							for(int x = 0; x < newVarsTerm1.length; x++) {
								term = new Term();
								term.setPosition(Term.Position.FIRST);
								term.setType(Term.TermType.VARIABLE);
								term.setTerm(newVarsTerm1[x]);
								newFilter.add(term);
								newFilter.add(term2);
								newFilter.add(element);
								
								if(x != 0) {
									newFilter.add(andExpr);
								}
							}
						} else {
							termRemoved = new Boolean(true);
						}
					} else if(containTerm2.booleanValue()) {
						if(newVarsTerm2 != null) {
							for(int x = 0; x < newVarsTerm2.length; x++) {
								newFilter.add(term1);
								term = new Term();
								term.setPosition(Term.Position.FIRST);
								term.setType(Term.TermType.VARIABLE);
								term.setTerm(newVarsTerm2[x]);
								newFilter.add(term);
								newFilter.add(element);
								
								if(x != 0) {
									newFilter.add(andExpr);
								}
							}
						} else {
							termRemoved = new Boolean(true);
						}
					}
				}
			} else if(element instanceof RegExpr) {
				if(varMap.contains(MapRow.FieldType.SOURCEVAR,
						((RegExpr) element).getVariable())) {
					
					auxRegExpr = (RegExpr) element;
					newVars = varMap.get(MapRow.FieldType.SOURCEVAR,
							auxRegExpr.getVariable(), MapRow.FieldType.TARGETVAR);
					
					for(int x = 0; x < newVars.length; x++) {
						newRegExpr = new RegExpr();
						newRegExpr.setVariable(newVars[x]);
						newRegExpr.setPattern(auxRegExpr.getPattern());
						
						newFilter.add(newRegExpr);
						if(x != (newVars.length - 1)) {
							newFilter.add(andExpr);
						}
					}
				} else {
					newFilter.add((RegExpr) element);
				}
				
			} else if(element instanceof LogExpr) {
				if(!termRemoved.booleanValue()) {
					newFilter.add(element);
				} else {
					termRemoved = new Boolean(false);
				}
			} else {
				newFilter.add(element);
			}
		}
		
		this.filter = newFilter;
	}
	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("============= Filters =============");
		if(this.filter != null) {
			Iterator<Object> l = this.filter.iterator();
			Object o;
			while(l.hasNext()) {
				o = l.next();
				
				if(o instanceof LogExpr) {
					System.out.println("LogExpr " + ((LogExpr) o).getLogicalOp());
				} else if(o instanceof RegExpr) {
					System.out.println("RegExpr " + ((RegExpr) o).getVariable() + " "
							+ ((RegExpr) o).getPattern());
				} else if(o instanceof RelExpr) {
					System.out.println("RelExpr " + ((RelExpr) o).getRelationalOp());
				} else if(o instanceof Term) {
					System.out.println("Term " + ((Term) o).getTerm() + "  "
							+ ((Term) o).getPosition());
				}
			}
		}
	}
}