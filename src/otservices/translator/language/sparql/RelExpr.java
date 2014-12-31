/**
<<<<<<< HEAD
 * Copyright (c) 2008 Luis Gustavo Nardin <gnardin@gmail.com>
=======
 * Copyright (c) 2008  Luis Gustavo Nardin <gnardin@gmail.com>
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
<<<<<<< HEAD
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
=======
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package otservices.translator.language.sparql;

import java.io.Serializable;
<<<<<<< HEAD
import otservices.translator.language.sparql.Term.Position;

public class RelExpr extends Expression implements Serializable {
	
	public enum RelationalOp {
		NONE{
			
			public String toString() {
=======

import otservices.translator.language.sparql.Term.Position;

public class RelExpr extends Expression implements Serializable{

	public enum RelationalOp {
		NONE{
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "";
			}
		},
		GT{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return " > ";
			}
		},
		GTE{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return " >= ";
			}
		},
		LT{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return " < ";
			}
		},
		LTE{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return " <= ";
			}
		},
		EQ{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return " = ";
			}
		},
		DIF{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return " != ";
			}
		},
	}
<<<<<<< HEAD
	
	private Term					term1;
	
	private Term					term2;
	
	private RelationalOp	op	= RelationalOp.NONE;
	
	
	/**
	 * 
	 */
	public RelExpr() {
		this.setExpressionType(ExpressionType.RELATIONAL);
	}
	
	
	/**
	 * 
	 */
	public Boolean evaluate(Term varValue) {
		Boolean result = new Boolean(false);
		
		Term value = null;
		if(this.term1.getType() == Term.TermType.VARIABLE) {
			value = this.term2;
		} else {
			value = this.term1;
		}
		
		if(value.getType() == varValue.getType()) {
			
			if(value.getType() == Term.TermType.BOOLEAN) {
				if((this.op == RelationalOp.EQ)
						&& ((Boolean) value.getTerm()).toString().equals(
								((Boolean) varValue.getTerm()).toString())) {
					result = new Boolean(true);
				} else if((this.op == RelationalOp.DIF)
						&& (!((Boolean) value.getTerm()).toString().equals(
								((Boolean) varValue.getTerm()).toString()))) {
					result = new Boolean(true);
				}
			} else if(value.getType() == Term.TermType.INTEGER) {
				if((this.op == RelationalOp.EQ)
						&& ((((Integer) value.getTerm()).intValue()) == (((Integer) varValue
								.getTerm()).intValue()))) {
					result = new Boolean(true);
				} else if((this.op == RelationalOp.DIF)
						&& ((((Integer) value.getTerm()).intValue()) != (((Integer) varValue
								.getTerm()).intValue()))) {
					result = new Boolean(true);
				} else if(this.op == RelationalOp.GT) {
					if(value.getPosition() == Position.FIRST) {
						if((((Integer) value.getTerm()).intValue()) > (((Integer) varValue
								.getTerm()).intValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Integer) varValue.getTerm()).intValue()) > (((Integer) value
								.getTerm()).intValue())) {
							result = new Boolean(true);
						}
					}
				} else if(this.op == RelationalOp.GTE) {
					if(value.getPosition() == Position.FIRST) {
						if((((Integer) value.getTerm()).intValue()) >= (((Integer) varValue
								.getTerm()).intValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Integer) varValue.getTerm()).intValue()) >= (((Integer) value
								.getTerm()).intValue())) {
							result = new Boolean(true);
						}
					}
				} else if(this.op == RelationalOp.LT) {
					if(value.getPosition() == Position.FIRST) {
						if((((Integer) value.getTerm()).intValue()) < (((Integer) varValue
								.getTerm()).intValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Integer) varValue.getTerm()).intValue()) < (((Integer) value
								.getTerm()).intValue())) {
							result = new Boolean(true);
						}
					}
				} else if(this.op == RelationalOp.LTE) {
					if(value.getPosition() == Position.FIRST) {
						if((((Integer) value.getTerm()).intValue()) <= (((Integer) varValue
								.getTerm()).intValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Integer) varValue.getTerm()).intValue()) <= (((Integer) value
								.getTerm()).intValue())) {
=======

	private Term			term1;
	private Term			term2;
	private RelationalOp	op	= RelationalOp.NONE;

	/**
	 * 
	 */
	public RelExpr(){
		this.setExpressionType(ExpressionType.RELATIONAL);
	}

	/**
	 * 
	 */
	public Boolean evaluate(Term varValue){
		Boolean result = new Boolean(false);

		Term value = null;
		if(this.term1.getType() == Term.TermType.VARIABLE){
			value = this.term2;
		}else{
			value = this.term1;
		}

		if(value.getType() == varValue.getType()){

			if(value.getType() == Term.TermType.BOOLEAN){
				if((this.op == RelationalOp.EQ)
						&& ((Boolean) value.getTerm()).toString().equals(
								((Boolean) varValue.getTerm()).toString())){
					result = new Boolean(true);
				}else if((this.op == RelationalOp.DIF)
						&& (!((Boolean) value.getTerm()).toString().equals(
								((Boolean) varValue.getTerm()).toString()))){
					result = new Boolean(true);
				}
			}else if(value.getType() == Term.TermType.INTEGER){
				if((this.op == RelationalOp.EQ)
						&& ((((Integer) value.getTerm()).intValue()) == (((Integer) varValue
								.getTerm()).intValue()))){
					result = new Boolean(true);
				}else if((this.op == RelationalOp.DIF)
						&& ((((Integer) value.getTerm()).intValue()) != (((Integer) varValue
								.getTerm()).intValue()))){
					result = new Boolean(true);
				}else if(this.op == RelationalOp.GT){
					if(value.getPosition() == Position.FIRST){
						if((((Integer) value.getTerm()).intValue()) > (((Integer) varValue
								.getTerm()).intValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Integer) varValue.getTerm()).intValue()) > (((Integer) value
								.getTerm()).intValue())){
							result = new Boolean(true);
						}
					}
				}else if(this.op == RelationalOp.GTE){
					if(value.getPosition() == Position.FIRST){
						if((((Integer) value.getTerm()).intValue()) >= (((Integer) varValue
								.getTerm()).intValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Integer) varValue.getTerm()).intValue()) >= (((Integer) value
								.getTerm()).intValue())){
							result = new Boolean(true);
						}
					}
				}else if(this.op == RelationalOp.LT){
					if(value.getPosition() == Position.FIRST){
						if((((Integer) value.getTerm()).intValue()) < (((Integer) varValue
								.getTerm()).intValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Integer) varValue.getTerm()).intValue()) < (((Integer) value
								.getTerm()).intValue())){
							result = new Boolean(true);
						}
					}
				}else if(this.op == RelationalOp.LTE){
					if(value.getPosition() == Position.FIRST){
						if((((Integer) value.getTerm()).intValue()) <= (((Integer) varValue
								.getTerm()).intValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Integer) varValue.getTerm()).intValue()) <= (((Integer) value
								.getTerm()).intValue())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							result = new Boolean(true);
						}
					}
				}
<<<<<<< HEAD
			} else if(value.getType() == Term.TermType.FLOAT) {
				if((this.op == RelationalOp.EQ)
						&& ((((Float) value.getTerm()).floatValue()) == (((Float) varValue
								.getTerm()).floatValue()))) {
					result = new Boolean(true);
				} else if((this.op == RelationalOp.DIF)
						&& ((((Float) value.getTerm()).floatValue()) != (((Float) varValue
								.getTerm()).floatValue()))) {
					result = new Boolean(true);
				} else if(this.op == RelationalOp.GT) {
					if(value.getPosition() == Position.FIRST) {
						if((((Float) value.getTerm()).floatValue()) > (((Float) varValue
								.getTerm()).floatValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Float) varValue.getTerm()).floatValue()) > (((Float) value
								.getTerm()).floatValue())) {
							result = new Boolean(true);
						}
					}
				} else if(this.op == RelationalOp.GTE) {
					if(value.getPosition() == Position.FIRST) {
						if((((Float) value.getTerm()).floatValue()) >= (((Float) varValue
								.getTerm()).floatValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Float) varValue.getTerm()).floatValue()) >= (((Float) value
								.getTerm()).floatValue())) {
							result = new Boolean(true);
						}
					}
				} else if(this.op == RelationalOp.LT) {
					if(value.getPosition() == Position.FIRST) {
						if((((Float) value.getTerm()).floatValue()) < (((Float) varValue
								.getTerm()).floatValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Float) varValue.getTerm()).floatValue()) < (((Float) value
								.getTerm()).floatValue())) {
							result = new Boolean(true);
						}
					}
				} else if(this.op == RelationalOp.LTE) {
					if(value.getPosition() == Position.FIRST) {
						if((((Float) value.getTerm()).floatValue()) <= (((Float) varValue
								.getTerm()).floatValue())) {
							result = new Boolean(true);
						}
					} else if(value.getPosition() == Position.SECOND) {
						if((((Float) varValue.getTerm()).floatValue()) <= (((Float) value
								.getTerm()).floatValue())) {
=======
			}else if(value.getType() == Term.TermType.FLOAT){
				if((this.op == RelationalOp.EQ)
						&& ((((Float) value.getTerm()).floatValue()) == (((Float) varValue
								.getTerm()).floatValue()))){
					result = new Boolean(true);
				}else if((this.op == RelationalOp.DIF)
						&& ((((Float) value.getTerm()).floatValue()) != (((Float) varValue
								.getTerm()).floatValue()))){
					result = new Boolean(true);
				}else if(this.op == RelationalOp.GT){
					if(value.getPosition() == Position.FIRST){
						if((((Float) value.getTerm()).floatValue()) > (((Float) varValue
								.getTerm()).floatValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Float) varValue.getTerm()).floatValue()) > (((Float) value
								.getTerm()).floatValue())){
							result = new Boolean(true);
						}
					}
				}else if(this.op == RelationalOp.GTE){
					if(value.getPosition() == Position.FIRST){
						if((((Float) value.getTerm()).floatValue()) >= (((Float) varValue
								.getTerm()).floatValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Float) varValue.getTerm()).floatValue()) >= (((Float) value
								.getTerm()).floatValue())){
							result = new Boolean(true);
						}
					}
				}else if(this.op == RelationalOp.LT){
					if(value.getPosition() == Position.FIRST){
						if((((Float) value.getTerm()).floatValue()) < (((Float) varValue
								.getTerm()).floatValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Float) varValue.getTerm()).floatValue()) < (((Float) value
								.getTerm()).floatValue())){
							result = new Boolean(true);
						}
					}
				}else if(this.op == RelationalOp.LTE){
					if(value.getPosition() == Position.FIRST){
						if((((Float) value.getTerm()).floatValue()) <= (((Float) varValue
								.getTerm()).floatValue())){
							result = new Boolean(true);
						}
					}else if(value.getPosition() == Position.SECOND){
						if((((Float) varValue.getTerm()).floatValue()) <= (((Float) value
								.getTerm()).floatValue())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							result = new Boolean(true);
						}
					}
				}
			}
		}
<<<<<<< HEAD
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public Term getTerm1() {
		return this.term1;
	}
	
	
	/**
	 * 
	 */
	public Term getTerm2() {
		return this.term2;
	}
	
	
	/**
	 * 
	 */
	public RelationalOp getRelationalOp() {
		return this.op;
	}
	
	
	/**
	 * 
	 */
	public void setTerm1(Term term) {
		this.term1 = term;
	}
	
	
	/**
	 * 
	 */
	public void setTerm2(Term term) {
		this.term2 = term;
	}
	
	
	/**
	 * 
	 */
	public void setRelationalOp(RelationalOp op) {
=======

		return result;
	}

	/**
	 * 
	 */
	public Term getTerm1(){
		return this.term1;
	}

	/**
	 * 
	 */
	public Term getTerm2(){
		return this.term2;
	}

	/**
	 * 
	 */
	public RelationalOp getRelationalOp(){
		return this.op;
	}

	/**
	 * 
	 */
	public void setTerm1(Term term){
		this.term1 = term;
	}

	/**
	 * 
	 */
	public void setTerm2(Term term){
		this.term2 = term;
	}

	/**
	 * 
	 */
	public void setRelationalOp(RelationalOp op){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.op = op;
	}
}