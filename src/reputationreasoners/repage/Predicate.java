/**
 * Copyright (c) 2007 Priscilla Barreira Avegliano <priavegliano@gmail.com>
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
package reputationreasoners.repage;

import repage.fuzzy.FzzNum;
import repage.memory.TupleFzz;

/**
 * Class that defines a Repage's Predicate. A Predicate presents a TupleFzz (6
 * numbers: the 5 evaluations and the strength) and a type that determines which
 * kind of predicate it is.
 */
public class Predicate {
	
	public enum predicateType {
		TPIMAGE{
			
			public String toString() {
				return "THIRD PARTY IMAGE";
			}
		},
		FULFILLMENT{
			
			public String toString() {
				return "FULFILLMENT";
			}
		},
		OUTCOME{
			
			public String toString() {
				return "OUTCOME";
			}
		},
		VAL_COMM{
			
			public String toString() {
				return "VALUE COMMUNICATION";
			}
		},
		SHARED_EVAL{
			
			public String toString() {
				return "SHARED EVALUATION";
			}
		},
		SHARED_VOICE{
			
			public String toString() {
				return "SHARED VOICE";
			}
		},
		IMAGE{
			
			public String toString() {
				return "IMAGE";
			}
		},
		REPUTATION{
			
			public String toString() {
				return "REPUTATION";
			}
		},
		CAND_IMAGE{
			
			public String toString() {
				return "CANDIDATE IMAGE";
			}
		},
		COM_REP{
			
			public String toString() {
				return "COM_REP";
			}
		}
	}
	
	private TupleFzz			tuple;
	
	private predicateType	type;
	
	
	/**
	 * 
	 * @param type
	 */
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
		int i;
		double values[] = new double[5];
		for(i = 0; i < 5; i++)
			values[i] = 0.2;
		FzzNum num = new FzzNum(values);
		this.tuple = new TupleFzz(num, 0.0);
	}
}