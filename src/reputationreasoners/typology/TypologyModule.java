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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import reputationreasoners.typology.Reputation;
import reputationreasoners.typology.Reputation.RepType;

public class TypologyModule{
	
	// Lista de informacoes de agentes
	private List<TUnit>	typology	= new ArrayList<TUnit>();
	
	
	/**
	 * Verifica se existe na lista o agente 'target' no contexto 'context'
	 */
	public boolean exists(String target, String context){
		boolean exist = false;
		
		if (this.typology.isEmpty()){
			return false;
		}
		
		TUnit unit;
		for(int i = 0; i < this.typology.size(); i++){
			unit = this.typology.get(i);
			if (unit.getContext().equalsIgnoreCase(context)
					&& unit.getTarget().equalsIgnoreCase(target))
				exist = true;
		}
		
		return exist;
	}
	

	/**
	 * 
	 */
	public int getUnitIndex(String target, String context)
			throws IndexOutOfBoundsException{
		int i;
		TUnit unit;
		for(i = 0; i < this.typology.size(); i++){
			unit = this.typology.get(i);
			if ((unit.getTarget().toUpperCase().equals(target.toUpperCase()))
					&& (unit.getContext().toUpperCase().equals(context.toUpperCase()))){
				break;
			}
		}
		return i;
	}
	

	/**
	 * 
	 */
	public List<TUnit> getTypologyMemory(){
		return this.typology;
	}
	

	/**
	 * Retorna a unidade Typology of Reputation. Já deve ter sido verificado se a
	 * unidade existe.
	 */
	public TUnit getUnit(String target, String context){
		TUnit unit;
		
		for(int i = 0; i < this.typology.size(); i++){
			unit = this.typology.get(i);
			if (unit.getContext().equalsIgnoreCase(context)
					&& unit.getTarget().equalsIgnoreCase(target))
				return unit;
		}
		
		return null;
	}
	

	/**
	 * Adiciona a lista deste modulo um novo agente em um contexto.
	 */
	public void addUnit(String target, String context){
		TUnit unit = new TUnit();
		unit.setTarget(target);
		unit.setContext(context);
		this.typology.add(unit);
	}
	

	/**
	 * 
	 */
	public double getReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation();
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getReputation(RepType type, String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(type);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getTypologyOfReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.TYPOLOGY);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getIndividualReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INDIVIDUAL);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getGroupReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.GROUP);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getDirectReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.DIRECT);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getInteractionDerivedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INTERACTION_DERIVED);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getObservedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.OBSERVED);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getIndirectReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INDIRECT);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getPriorDerivedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.PRIOR_DERIVED);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getPropagatedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.PROPAGATED);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public double getGroupDerivedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.GROUP_DERIVED);
		}else{
			return Reputation.UNKNOWN;
		}
	}
	

	/**
	 * 
	 */
	public void setTypologyOfReputation(String target, String context,
			double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.TYPOLOGY, value);
	}
	

	/**
	 * 
	 */
	public void setIndividualReputation(String target, String context,
			double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.INDIVIDUAL, value);
	}
	

	/**
	 * 
	 */
	public void setGroupReputation(String target, String context, double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.GROUP, value);
	}
	

	/**
	 * 
	 */
	public void setDirectReputation(String target, String context, double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.DIRECT, value);
	}
	

	/**
	 * 
	 */
	public void setInteractionDerivedReputation(String target, String context,
			double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.INTERACTION_DERIVED, value);
	}
	

	/**
	 * 
	 */
	public void setObservedReputation(String target, String context, double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.OBSERVED, value);
	}
	

	/**
	 * 
	 */
	public void setIndirectReputation(String target, String context, double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.INDIRECT, value);
	}
	

	/**
	 * 
	 */
	public void setPriorDerivedReputation(String target, String context,
			double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.PRIOR_DERIVED, value);
	}
	

	/**
	 * 
	 */
	public void setPropagatedReputation(String target, String context,
			double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.PROPAGATED, value);
	}
	

	/**
	 * 
	 */
	public void setGroupDerivedReputation(String target, String context,
			double value){
		if (!this.exists(target, context)){
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.GROUP_DERIVED, value);
	}
	

	/**
	 * 
	 */
	public String[] getContexts(String target){
		String[] result = null;
		Map<String, String> targets = new HashMap<String, String>();
		
		TUnit unit;
		for(Iterator<TUnit> i = this.typology.iterator(); i.hasNext();){
			unit = i.next();
			if (unit.getTarget().equals(target)){
				targets.put(unit.getContext(), null);
			}
		}
		
		if (targets.size() > 0){
			result = new String[targets.size()];
			int i = 0;
			for(Iterator<String> x = targets.keySet().iterator(); x.hasNext();){
				result[i++] = x.next();
			}
		}
		
		return result;
	}
	

	/**
	 * 
	 */
	public String[] getTargets(String facet){
		String[] result = null;
		Map<String, String> facets = new HashMap<String, String>();
		
		TUnit unit;
		for(Iterator<TUnit> i = this.typology.iterator(); i.hasNext();){
			unit = i.next();
			if (unit.getContext().equals(facet)){
				facets.put(unit.getTarget(), null);
			}
		}
		
		if (facets.size() > 0){
			result = new String[facets.size()];
			int i = 0;
			for(Iterator<String> x = facets.keySet().iterator(); x.hasNext();){
				result[i++] = x.next();
			}
		}
		
		return result;
	}
	

	/**
	 *
	 */
	public void updateReputation(RepType type, String sender, String target,
			String context, double value){
		
		if (this.exists(sender, context)){
			double senderRep = this.typology.get(this.getUnitIndex(sender, context))
					.getReputation();
			
			if (senderRep == Reputation.UNKNOWN){
				// Probabilidade de aceitar o resultado segundo Bayesian Estimate
				double probability = (senderRep * value)
						+ ((1 - senderRep) * (1 - value));
				
				if (probability >= 0.5){
					this.typology.get(this.getUnitIndex(target, context)).setReputation(
							type, value);
				}
			}else{
				this.typology.get(this.getUnitIndex(target, context)).setReputation(
						type, value);
			}
		}else{
			this.typology.get(this.getUnitIndex(target, context)).setReputation(type,
					value);
		}
	}
	

	/**
	 * 
	 */
	public List<String> sortTarget(List<String> targets, String facet,
			Boolean ascending){
		
		List<String> newTargets = new ArrayList<String>(targets);
		
		Comparator<String> comparator = new TypologyComparator(this, facet);
		
		if (!ascending){
			comparator = Collections.reverseOrder(comparator);
		}
		
		Collections.sort(newTargets, comparator);
		
		return newTargets;
	}
	
	class TypologyComparator implements Comparator<String>{
		
		TypologyModule	typology;
		
		String					context;
		
		
		/**
		 * 
		 */
		public TypologyComparator(TypologyModule typology, String context){
			this.typology = typology;
			this.context = context;
		}
		

		/**
		 * 
		 */
		public final int compare(String target1, String target2){
			double value1 = this.typology.getReputation(target1, this.context);
			
			double value2 = this.typology.getReputation(target2, this.context);
			
			return(value1 < value2 ? -1 : (value1 > value2 ? +1 : 0));
		}
	}
}