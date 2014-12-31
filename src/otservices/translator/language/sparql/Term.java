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
public class Term implements Serializable {
	
	public enum TermType {
		STRING{
			
			public String toString() {
=======
public class Term implements Serializable{

	public enum TermType {
		STRING{
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "STRING";
			}
		},
		INTEGER{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "INTEGER";
			}
		},
		FLOAT{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "FLOAT";
			}
		},
		BOOLEAN{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "BOOLEAN";
			}
		},
		VARIABLE{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "VARIABLE";
			}
		}
	};
<<<<<<< HEAD
	
	public enum Position {
		FIRST{
			
			public String toString() {
=======

	public enum Position {
		FIRST{
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "FIRST";
			}
		},
		SECOND{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "SECOND";
			}
		}
	}
<<<<<<< HEAD
	
	private Position	position;
	
	private Object		term;
	
	private TermType	type;
	
	
	/**
	 * 
	 */
	public Position getPosition() {
		return this.position;
	}
	
	
	/**
	 * 
	 */
	public Object getTerm() {
		return this.term;
	}
	
	
	/**
	 * 
	 */
	public TermType getType() {
		return this.type;
	}
	
	
	/**
	 * 
	 */
	public void setPosition(Position position) {
		this.position = position;
	}
	
	
	/**
	 * 
	 */
	public void setTerm(Object term) {
=======

	private Position	position;
	private Object		term;
	private TermType	type;

	/**
	 * 
	 */
	public Position getPosition(){
		return this.position;
	}

	/**
	 * 
	 */
	public Object getTerm(){
		return this.term;
	}

	/**
	 * 
	 */
	public TermType getType(){
		return this.type;
	}

	/**
	 * 
	 */
	public void setPosition(Position position){
		this.position = position;
	}

	/**
	 * 
	 */
	public void setTerm(Object term){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		if(((this.type == TermType.BOOLEAN) && (term instanceof Boolean))
				|| ((this.type == TermType.INTEGER) && (term instanceof Integer))
				|| ((this.type == TermType.FLOAT) && (term instanceof Float))
				|| ((this.type == TermType.STRING) && (term instanceof String))
<<<<<<< HEAD
				|| ((this.type == TermType.VARIABLE) && (term instanceof String))) {
			this.term = term;
		}
	}
	
	
	/**
	 * 
	 */
	public void setType(TermType type) {
		this.type = type;
	}
	
	
	/**
	 * 
	 */
	public String toString() {
		String result = new String();
		
		if(this.term instanceof Boolean) {
			result = ((Boolean) this.term).toString();
		} else if(this.term instanceof Integer) {
			result = ((Integer) this.term).toString();
		} else if(this.term instanceof Float) {
			result = ((Float) this.term).toString();
		} else if(this.term instanceof String) {
			result = ((String) this.term);
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public void print() {
		if(this.term instanceof Boolean) {
			System.out.println((Boolean) this.term);
		} else if(this.term instanceof Integer) {
			System.out.println((Integer) this.term);
		} else if(this.term instanceof Float) {
			System.out.println((Float) this.term);
		} else if(this.term instanceof String) {
=======
				|| ((this.type == TermType.VARIABLE) && (term instanceof String))){
			this.term = term;
		}
	}

	/**
	 * 
	 */
	public void setType(TermType type){
		this.type = type;
	}

	/**
	 * 
	 */
	public String toString(){
		String result = new String();

		if(this.term instanceof Boolean){
			result = ((Boolean) this.term).toString();
		}else if(this.term instanceof Integer){
			result = ((Integer) this.term).toString();
		}else if(this.term instanceof Float){
			result = ((Float) this.term).toString();
		}else if(this.term instanceof String){
			result = ((String) this.term);
		}

		return result;
	}

	/**
	 * 
	 */
	public void print(){
		if(this.term instanceof Boolean){
			System.out.println((Boolean) this.term);
		}else if(this.term instanceof Integer){
			System.out.println((Integer) this.term);
		}else if(this.term instanceof Float){
			System.out.println((Float) this.term);
		}else if(this.term instanceof String){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			System.out.println((String) this.term);
		}
	}
}