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

import reputationreasoners.typology.Reputation;
import reputationreasoners.typology.Reputation.RepType;

public class TUnit{
	
	private String			target;
	
	private String			context;
	
	private Reputation[]	type	= new Reputation[Reputation.RepType.values().length];
	
	
	/**
	 * 
	 */
	public TUnit(){
		for(RepType r : RepType.values())
			this.type[r.ordinal()] = new Reputation(r);
	}
	

	/**
	 * 
	 */
	public String getContext(){
		return context;
	}
	

	/**
	 * 
	 */
	public void setContext(String context){
		this.context = context;
	}
	

	/**
	 * 
	 */
	public String getTarget(){
		return target;
	}
	

	/**
	 * 
	 */
	public void setTarget(String target){
		this.target = target;
	}
	

	/**
	 * 
	 */
	public Reputation[] getRepTypes(){
		return this.type;
	}
	

	public Reputation getRepType(RepType index){
		return this.type[index.ordinal()];
	}
	

	/**
	 * Media ponderada de todas as reputacoes existentes
	 */
	public double getReputation(){
		double reputation = 0;
		double value = 0;
		double weight = 0;
		int contador = 0;
		for(RepType i : RepType.values()){
			if (this.type[i.ordinal()].getValue() != Reputation.UNKNOWN){
				value += (this.type[i.ordinal()].getValue() * this.type[i.ordinal()]
						.getWeight());
				weight += this.type[i.ordinal()].getWeight();
			}else{
				contador++;
			}
		}
		
		if (contador != this.type.length){
			reputation = value / weight;
			return reputation;
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getReputation(RepType index){
		return this.type[index.ordinal()].getValue();
	}
	

	/**
	 * 
	 */
	public void setReputation(RepType type, double value){
		if (this.type[type.ordinal()].getValue() == Reputation.UNKNOWN){
			this.type[type.ordinal()].setValue(value);
			return;
		}
		double rep = (this.type[type.ordinal()].getValue() + value) / 2;
		this.type[type.ordinal()].setValue(rep);
	}
}