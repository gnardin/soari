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

public class LogExpr extends Expression implements Serializable {
	
	public enum LogicalOp {
		NONE{
			
			public String toString() {
				return "";
			}
		},
		AND{
			
			public String toString() {
				return "&&";
			}
		},
		OR{
			
			public String toString() {
				return "||";
			}
		}
	};
	
	private List<Object>	expr	= new ArrayList<Object>();
	
	private LogicalOp			op		= LogicalOp.NONE;
	
	
	/**
	 * 
	 */
	public LogExpr() {
		this.setExpressionType(ExpressionType.LOGICAL);
	}
	
	
	/**
	 * 
	 */
	public void addExpression(Object expr) {
		this.expr.add(expr);
	}
	
	
	/**
	 * 
	 */
	public Boolean evaluate(Map<String, Term> varValue) {
		Boolean result = null;
		
		Iterator<Object> iExpr = this.expr.iterator();
		Object e;
		Boolean auxResult = null;
		Term auxTerm = null;
		RegExpr auxRegExpr;
		RelExpr auxRelExpr;
		LogExpr auxLogExpr;
		while(iExpr.hasNext()) {
			e = iExpr.next();
			
			if(e instanceof RegExpr) {
				auxRegExpr = (RegExpr) e;
				if(varValue.containsKey(auxRegExpr.getVariable())) {
					auxTerm = (Term) varValue.get(auxRegExpr.getVariable());
					if(auxTerm != null) {
						if(auxTerm.getType() == Term.TermType.STRING)
							auxResult = auxRegExpr.evaluate((String) auxTerm.getTerm());
					}
				}
			} else if(e instanceof RelExpr) {
				auxRelExpr = (RelExpr) e;
				if(auxRelExpr.getTerm1().getType() == Term.TermType.VARIABLE) {
					if(varValue.containsKey((String) auxRelExpr.getTerm1().getTerm())) {
						auxResult = auxRelExpr.evaluate(varValue.get((String) auxRelExpr
								.getTerm1().getTerm()));
					}
				} else if(auxRelExpr.getTerm2().getType() == Term.TermType.VARIABLE) {
					if(varValue.containsKey((String) auxRelExpr.getTerm2().getTerm())) {
						auxResult = auxRelExpr.evaluate(varValue.get((String) auxRelExpr
								.getTerm2().getTerm()));
					}
				}
			} else if(e instanceof LogExpr) {
				auxLogExpr = (LogExpr) e;
				auxResult = auxLogExpr.evaluate(varValue);
			}
			
			if(result == null) {
				result = auxResult;
			} else if(auxResult != null) {
				if(this.op == LogicalOp.AND) {
					result = result.booleanValue() && auxResult.booleanValue();
				} else if(this.op == LogicalOp.OR) {
					result = result.booleanValue() || auxResult.booleanValue();
				} else {
					result = auxResult;
				}
			}
		}
		
		if(result == null) {
			result = new Boolean(false);
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public List<Object> getExpression() {
		return this.expr;
	}
	
	
	/**
	 * 
	 */
	public LogicalOp getLogicalOp() {
		return this.op;
	}
	
	
	/**
	 * 
	 */
	public void setLogicalOp(LogicalOp op) {
		this.op = op;
	}
}