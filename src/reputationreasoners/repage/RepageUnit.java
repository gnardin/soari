/**
 * Copyright (c) 2007  Priscilla Barreira Avegliano <priavegliano@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package reputationreasoners.repage;

import java.util.ArrayList;
import java.util.List;

import reputationreasoners.repage.Predicate;
import reputationreasoners.repage.Predicate.predicateType;

/**
 * Class that defines the RepageUnit, which is a set of predicates concerning a
 * target.
 */
public class RepageUnit{

	private String			target;
	private String			facet;
	private List<Predicate>	predicates	= new ArrayList<Predicate>();

	/**
	 * 
	 */
	public RepageUnit(){
	}

	/**
	 * 
	 */
	public RepageUnit(String target, String facet){
		this.target = target;
		this.facet = facet;
		Predicate pred;
		for(predicateType p : predicateType.values()){
			pred = new Predicate(p);
			pred.setDontKnowPredicate();
			this.predicates.add(pred);
		}
	}

	/**
	 * 
	 */
	public String getFacet(){
		return this.facet;
	}

	/**
	 * 
	 */
	public Predicate getPredicate(predicateType type){
		return this.predicates.get(type.ordinal());
	}

	/**
	 * 
	 */
	public List<Predicate> getPredicates(){
		return this.predicates;
	}

	/**
	 * 
	 */
	public int getSize(){
		return this.predicates.size();
	}

	/**
	 * 
	 */
	public String getTarget(){
		return this.target;
	}
}