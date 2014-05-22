/**
 * Copyright (c) 2010  Tomas Chaib <t.chaib@hotmail.com>
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
package reputationreasoners.typology;

public class Reputation{
	
	public enum RepType{
		TYPOLOGY{
			
			public String toString(){
				return "TypologyOfReputation";
			}
		},
		INDIVIDUAL{
			
			public String toString(){
				return "IndividualReputationByTypology";
			}
		},
		GROUP{
			
			public String toString(){
				return "GroupReputationByTypology";
			}
		},
		DIRECT{
			
			public String toString(){
				return "DirectReputationByTypology";
			}
		},
		INTERACTION_DERIVED{
			
			public String toString(){
				return "InteractionDerivedReputationByTypology";
			}
		},
		OBSERVED{
			
			public String toString(){
				return "ObservedReputationByTypology";
			}
		},
		INDIRECT{
			
			public String toString(){
				return "IndirectReputationByTypology";
			}
		},
		PRIOR_DERIVED{
			
			public String toString(){
				return "PriorDerivedReputationByTypology";
			}
		},
		PROPAGATED{
			
			public String toString(){
				return "PropagatedReputationByTypology";
			}
		},
		GROUP_DERIVED{
			
			public String toString(){
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
			this.weight = 0.5;
		}
		
		this.value = UNKNOWN;
	}
	

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
		this.value = value;
	}
}