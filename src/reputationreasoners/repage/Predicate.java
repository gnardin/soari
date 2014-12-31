/**
<<<<<<< HEAD
 * Copyright (c) 2007 Priscilla Barreira Avegliano <priavegliano@gmail.com>
=======
 * Copyright (c) 2007  Priscilla Barreira Avegliano <priavegliano@gmail.com>
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
package reputationreasoners.repage;

<<<<<<< HEAD
import repage.fuzzy.FzzNum;
import repage.memory.TupleFzz;
=======
import repage.memory.*;
import repage.fuzzy.*;
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05

/**
 * Class that defines a Repage's Predicate. A Predicate presents a TupleFzz (6
 * numbers: the 5 evaluations and the strength) and a type that determines which
 * kind of predicate it is.
 */
<<<<<<< HEAD
public class Predicate {
	
	public enum predicateType {
		TPIMAGE{
			
			public String toString() {
=======
public class Predicate{

	public enum predicateType{
		TPIMAGE{
			
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "THIRD PARTY IMAGE";
			}
		},
		FULFILLMENT{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "FULFILLMENT";
			}
		},
		OUTCOME{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "OUTCOME";
			}
		},
		VAL_COMM{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "VALUE COMMUNICATION";
			}
		},
		SHARED_EVAL{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "SHARED EVALUATION";
			}
		},
		SHARED_VOICE{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "SHARED VOICE";
			}
		},
		IMAGE{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "IMAGE";
			}
		},
		REPUTATION{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "REPUTATION";
			}
		},
		CAND_IMAGE{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "CANDIDATE IMAGE";
			}
		},
		COM_REP{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "COM_REP";
			}
		}
	}
<<<<<<< HEAD
	
	private TupleFzz			tuple;
	
	private predicateType	type;
	
	
=======

	private TupleFzz		tuple;
	private predicateType	type;

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 * @param type
	 */
<<<<<<< HEAD
	public Predicate(predicateType type) {
		this.type = type;
	}
	
	
	/**
	 * 
	 */
	public predicateType getPredicateType() {
		return this.type;
	}
	
	
	/**
	 * 
	 */
	public void setTuple(TupleFzz t) {
		this.tuple = t;
	}
	
	
	/**
	 * 
	 */
	public TupleFzz getTuple() {
		return this.tuple;
	}
	
	
	/**
	 * The DON'T KNOW predicate presents 0.2 of probability in each fuzzy set
	 */
	public void setDontKnowPredicate() {
=======
	public Predicate(predicateType type){
		this.type = type;
	}

	/**
	 * 
	 */
	public predicateType getPredicateType(){
		return this.type;
	}

	/**
	 * 
	 */
	public void setTuple(TupleFzz t){
		this.tuple = t;
	}

	/**
	 * 
	 */
	public TupleFzz getTuple(){
		return this.tuple;
	}

	/**
	 * The DON'T KNOW predicate presents 0.2 of probability in each fuzzy set
	 */
	public void setDontKnowPredicate(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		int i;
		double values[] = new double[5];
		for(i = 0; i < 5; i++)
			values[i] = 0.2;
		FzzNum num = new FzzNum(values);
		this.tuple = new TupleFzz(num, 0.0);
	}
}