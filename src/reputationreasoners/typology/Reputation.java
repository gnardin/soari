/**
<<<<<<< HEAD
 * Copyright (c) 2010 Tomas Chaib <t.chaib@hotmail.com>
=======
 * Copyright (c) 2010  Tomas Chaib <t.chaib@hotmail.com>
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
package reputationreasoners.typology;

<<<<<<< HEAD
public class Reputation {
	
	public enum RepType {
		TYPOLOGY{
			
			public String toString() {
=======
public class Reputation{
	
	public enum RepType{
		TYPOLOGY{
			
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "TypologyOfReputation";
			}
		},
		INDIVIDUAL{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "IndividualReputationByTypology";
			}
		},
		GROUP{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "GroupReputationByTypology";
			}
		},
		DIRECT{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "DirectReputationByTypology";
			}
		},
		INTERACTION_DERIVED{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "InteractionDerivedReputationByTypology";
			}
		},
		OBSERVED{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "ObservedReputationByTypology";
			}
		},
		INDIRECT{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "IndirectReputationByTypology";
			}
		},
		PRIOR_DERIVED{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "PriorDerivedReputationByTypology";
			}
		},
		PROPAGATED{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "PropagatedReputationByTypology";
			}
		},
		GROUP_DERIVED{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "GroupDerivedReputationByTypology";
			}
		}
	}
	
	// Nome do tipo de reputacao
	private RepType							type;
	
	// Valor agregado ao tipo de reputacao
	private double							value;
	
	// Peso do tipo de reputação
	private double							weight;
	
	// Atribuido ao tipo de reputacao quando valor real deconhecido
	public static final double	UNKNOWN	= -10000;
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Reputation(RepType type) {
		
		this.type = type;
		
		if(type.ordinal() == RepType.TYPOLOGY.ordinal()) {
			this.weight = 1.0;
		} else if(type.ordinal() == RepType.INDIVIDUAL.ordinal()) {
			this.weight = 0.725;
		} else if(type.ordinal() == RepType.GROUP.ordinal()) {
			this.weight = 0.5;
		} else if(type.ordinal() == RepType.DIRECT.ordinal()) {
			this.weight = 0.9;
		} else if(type.ordinal() == RepType.INTERACTION_DERIVED.ordinal()) {
			this.weight = 1.0;
		} else if(type.ordinal() == RepType.OBSERVED.ordinal()) {
			this.weight = 0.8;
		} else if(type.ordinal() == RepType.INDIRECT.ordinal()) {
			this.weight = 0.55;
		} else if(type.ordinal() == RepType.PRIOR_DERIVED.ordinal()) {
			this.weight = 0.5;
		} else if(type.ordinal() == RepType.PROPAGATED.ordinal()) {
			this.weight = 0.6;
		} else if(type.ordinal() == RepType.GROUP_DERIVED.ordinal()) {
=======
	public Reputation(RepType type){
		
		this.type = type;
		
		if (type.ordinal() == RepType.TYPOLOGY.ordinal()){
			this.weight = 1.0;
		}else if (type.ordinal() == RepType.INDIVIDUAL.ordinal()){
			this.weight = 0.725;
		}else if (type.ordinal() == RepType.GROUP.ordinal()){
			this.weight = 0.5;
		}else if (type.ordinal() == RepType.DIRECT.ordinal()){
			this.weight = 0.9;
		}else if (type.ordinal() == RepType.INTERACTION_DERIVED.ordinal()){
			this.weight = 1.0;
		}else if (type.ordinal() == RepType.OBSERVED.ordinal()){
			this.weight = 0.8;
		}else if (type.ordinal() == RepType.INDIRECT.ordinal()){
			this.weight = 0.55;
		}else if (type.ordinal() == RepType.PRIOR_DERIVED.ordinal()){
			this.weight = 0.5;
		}else if (type.ordinal() == RepType.PROPAGATED.ordinal()){
			this.weight = 0.6;
		}else if (type.ordinal() == RepType.GROUP_DERIVED.ordinal()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.weight = 0.5;
		}
		
		this.value = UNKNOWN;
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public RepType getType() {
		return this.type;
	}
	
	
	/**
	 * 
	 */
	public double getWeight() {
		return this.weight;
	}
	
	
	/**
	 * 
	 */
	public double getValue() {
		return this.value;
	}
	
	
	/**
	 * 
	 */
	public void setValue(double value) {
=======

	/**
	 * 
	 */
	public RepType getType(){
		return this.type;
	}
	

	/**
	 * 
	 */
	public double getWeight(){
		return this.weight;
	}
	

	/**
	 * 
	 */
	public double getValue(){
		return this.value;
	}
	

	/**
	 * 
	 */
	public void setValue(double value){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.value = value;
	}
}