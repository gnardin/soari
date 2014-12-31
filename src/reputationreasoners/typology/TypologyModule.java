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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import reputationreasoners.typology.Reputation.RepType;

public class TypologyModule {
=======

import reputationreasoners.typology.Reputation;
import reputationreasoners.typology.Reputation.RepType;

public class TypologyModule{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	// Lista de informacoes de agentes
	private List<TUnit>	typology	= new ArrayList<TUnit>();
	
	
	/**
	 * Verifica se existe na lista o agente 'target' no contexto 'context'
	 */
<<<<<<< HEAD
	public boolean exists(String target, String context) {
		boolean exist = false;
		
		if(this.typology.isEmpty()) {
=======
	public boolean exists(String target, String context){
		boolean exist = false;
		
		if (this.typology.isEmpty()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return false;
		}
		
		TUnit unit;
<<<<<<< HEAD
		for(int i = 0; i < this.typology.size(); i++) {
			unit = this.typology.get(i);
			if(unit.getContext().equalsIgnoreCase(context)
=======
		for(int i = 0; i < this.typology.size(); i++){
			unit = this.typology.get(i);
			if (unit.getContext().equalsIgnoreCase(context)
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					&& unit.getTarget().equalsIgnoreCase(target))
				exist = true;
		}
		
		return exist;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public int getUnitIndex(String target, String context)
<<<<<<< HEAD
			throws IndexOutOfBoundsException {
		int i;
		TUnit unit;
		for(i = 0; i < this.typology.size(); i++) {
			unit = this.typology.get(i);
			if((unit.getTarget().toUpperCase().equals(target.toUpperCase()))
					&& (unit.getContext().toUpperCase().equals(context.toUpperCase()))) {
=======
			throws IndexOutOfBoundsException{
		int i;
		TUnit unit;
		for(i = 0; i < this.typology.size(); i++){
			unit = this.typology.get(i);
			if ((unit.getTarget().toUpperCase().equals(target.toUpperCase()))
					&& (unit.getContext().toUpperCase().equals(context.toUpperCase()))){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				break;
			}
		}
		return i;
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public List<TUnit> getTypologyMemory() {
		return this.typology;
	}
	
	
=======

	/**
	 * 
	 */
	public List<TUnit> getTypologyMemory(){
		return this.typology;
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Retorna a unidade Typology of Reputation. Já deve ter sido verificado se a
	 * unidade existe.
	 */
<<<<<<< HEAD
	public TUnit getUnit(String target, String context) {
		TUnit unit;
		
		for(int i = 0; i < this.typology.size(); i++) {
			unit = this.typology.get(i);
			if(unit.getContext().equalsIgnoreCase(context)
=======
	public TUnit getUnit(String target, String context){
		TUnit unit;
		
		for(int i = 0; i < this.typology.size(); i++){
			unit = this.typology.get(i);
			if (unit.getContext().equalsIgnoreCase(context)
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					&& unit.getTarget().equalsIgnoreCase(target))
				return unit;
		}
		
		return null;
	}
	
<<<<<<< HEAD
	
	/**
	 * Adiciona a lista deste modulo um novo agente em um contexto.
	 */
	public void addUnit(String target, String context) {
=======

	/**
	 * Adiciona a lista deste modulo um novo agente em um contexto.
	 */
	public void addUnit(String target, String context){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		TUnit unit = new TUnit();
		unit.setTarget(target);
		unit.setContext(context);
		this.typology.add(unit);
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation();
		} else {
=======

	/**
	 * 
	 */
	public double getReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation();
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getReputation(RepType type, String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(type);
		} else {
=======

	/**
	 * 
	 */
	public double getReputation(RepType type, String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(type);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getTypologyOfReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.TYPOLOGY);
		} else {
=======

	/**
	 * 
	 */
	public double getTypologyOfReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.TYPOLOGY);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getIndividualReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INDIVIDUAL);
		} else {
=======

	/**
	 * 
	 */
	public double getIndividualReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INDIVIDUAL);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getGroupReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.GROUP);
		} else {
=======

	/**
	 * 
	 */
	public double getGroupReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.GROUP);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getDirectReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.DIRECT);
		} else {
=======

	/**
	 * 
	 */
	public double getDirectReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.DIRECT);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getInteractionDerivedReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INTERACTION_DERIVED);
		} else {
=======

	/**
	 * 
	 */
	public double getInteractionDerivedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INTERACTION_DERIVED);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getObservedReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.OBSERVED);
		} else {
=======

	/**
	 * 
	 */
	public double getObservedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.OBSERVED);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getIndirectReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INDIRECT);
		} else {
=======

	/**
	 * 
	 */
	public double getIndirectReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.INDIRECT);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getPriorDerivedReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.PRIOR_DERIVED);
		} else {
=======

	/**
	 * 
	 */
	public double getPriorDerivedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.PRIOR_DERIVED);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getPropagatedReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.PROPAGATED);
		} else {
=======

	/**
	 * 
	 */
	public double getPropagatedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.PROPAGATED);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public double getGroupDerivedReputation(String target, String context) {
		if(this.exists(target, context)) {
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.GROUP_DERIVED);
		} else {
=======

	/**
	 * 
	 */
	public double getGroupDerivedReputation(String target, String context){
		if (this.exists(target, context)){
			return this.typology.get(this.getUnitIndex(target, context))
					.getReputation(RepType.GROUP_DERIVED);
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return Reputation.UNKNOWN;
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setTypologyOfReputation(String target, String context,
<<<<<<< HEAD
			double value) {
		if(!this.exists(target, context)) {
=======
			double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.TYPOLOGY, value);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setIndividualReputation(String target, String context,
<<<<<<< HEAD
			double value) {
		if(!this.exists(target, context)) {
=======
			double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.INDIVIDUAL, value);
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void setGroupReputation(String target, String context, double value) {
		if(!this.exists(target, context)) {
=======

	/**
	 * 
	 */
	public void setGroupReputation(String target, String context, double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.GROUP, value);
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void setDirectReputation(String target, String context, double value) {
		if(!this.exists(target, context)) {
=======

	/**
	 * 
	 */
	public void setDirectReputation(String target, String context, double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.DIRECT, value);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setInteractionDerivedReputation(String target, String context,
<<<<<<< HEAD
			double value) {
		if(!this.exists(target, context)) {
=======
			double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.INTERACTION_DERIVED, value);
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void setObservedReputation(String target, String context, double value) {
		if(!this.exists(target, context)) {
=======

	/**
	 * 
	 */
	public void setObservedReputation(String target, String context, double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.OBSERVED, value);
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void setIndirectReputation(String target, String context, double value) {
		if(!this.exists(target, context)) {
=======

	/**
	 * 
	 */
	public void setIndirectReputation(String target, String context, double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.INDIRECT, value);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setPriorDerivedReputation(String target, String context,
<<<<<<< HEAD
			double value) {
		if(!this.exists(target, context)) {
=======
			double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.PRIOR_DERIVED, value);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setPropagatedReputation(String target, String context,
<<<<<<< HEAD
			double value) {
		if(!this.exists(target, context)) {
=======
			double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.PROPAGATED, value);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setGroupDerivedReputation(String target, String context,
<<<<<<< HEAD
			double value) {
		if(!this.exists(target, context)) {
=======
			double value){
		if (!this.exists(target, context)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.addUnit(target, context);
		}
		
		this.typology.get(this.getUnitIndex(target, context)).setReputation(
				RepType.GROUP_DERIVED, value);
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public String[] getContexts(String target) {
=======

	/**
	 * 
	 */
	public String[] getContexts(String target){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		String[] result = null;
		Map<String, String> targets = new HashMap<String, String>();
		
		TUnit unit;
<<<<<<< HEAD
		for(Iterator<TUnit> i = this.typology.iterator(); i.hasNext();) {
			unit = i.next();
			if(unit.getTarget().equals(target)) {
=======
		for(Iterator<TUnit> i = this.typology.iterator(); i.hasNext();){
			unit = i.next();
			if (unit.getTarget().equals(target)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				targets.put(unit.getContext(), null);
			}
		}
		
<<<<<<< HEAD
		if(targets.size() > 0) {
			result = new String[targets.size()];
			int i = 0;
			for(Iterator<String> x = targets.keySet().iterator(); x.hasNext();) {
=======
		if (targets.size() > 0){
			result = new String[targets.size()];
			int i = 0;
			for(Iterator<String> x = targets.keySet().iterator(); x.hasNext();){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				result[i++] = x.next();
			}
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public String[] getTargets(String facet) {
=======

	/**
	 * 
	 */
	public String[] getTargets(String facet){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		String[] result = null;
		Map<String, String> facets = new HashMap<String, String>();
		
		TUnit unit;
<<<<<<< HEAD
		for(Iterator<TUnit> i = this.typology.iterator(); i.hasNext();) {
			unit = i.next();
			if(unit.getContext().equals(facet)) {
=======
		for(Iterator<TUnit> i = this.typology.iterator(); i.hasNext();){
			unit = i.next();
			if (unit.getContext().equals(facet)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				facets.put(unit.getTarget(), null);
			}
		}
		
<<<<<<< HEAD
		if(facets.size() > 0) {
			result = new String[facets.size()];
			int i = 0;
			for(Iterator<String> x = facets.keySet().iterator(); x.hasNext();) {
=======
		if (facets.size() > 0){
			result = new String[facets.size()];
			int i = 0;
			for(Iterator<String> x = facets.keySet().iterator(); x.hasNext();){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				result[i++] = x.next();
			}
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 *
	 */
	public void updateReputation(RepType type, String sender, String target,
<<<<<<< HEAD
			String context, double value) {
		
		if(this.exists(sender, context)) {
			double senderRep = this.typology.get(this.getUnitIndex(sender, context))
					.getReputation();
			
			if(senderRep == Reputation.UNKNOWN) {
=======
			String context, double value){
		
		if (this.exists(sender, context)){
			double senderRep = this.typology.get(this.getUnitIndex(sender, context))
					.getReputation();
			
			if (senderRep == Reputation.UNKNOWN){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				// Probabilidade de aceitar o resultado segundo Bayesian Estimate
				double probability = (senderRep * value)
						+ ((1 - senderRep) * (1 - value));
				
<<<<<<< HEAD
				if(probability >= 0.5) {
					this.typology.get(this.getUnitIndex(target, context)).setReputation(
							type, value);
				}
			} else {
				this.typology.get(this.getUnitIndex(target, context)).setReputation(
						type, value);
			}
		} else {
=======
				if (probability >= 0.5){
					this.typology.get(this.getUnitIndex(target, context)).setReputation(
							type, value);
				}
			}else{
				this.typology.get(this.getUnitIndex(target, context)).setReputation(
						type, value);
			}
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.typology.get(this.getUnitIndex(target, context)).setReputation(type,
					value);
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public List<String> sortTarget(List<String> targets, String facet,
<<<<<<< HEAD
			Boolean ascending) {
=======
			Boolean ascending){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		List<String> newTargets = new ArrayList<String>(targets);
		
		Comparator<String> comparator = new TypologyComparator(this, facet);
		
<<<<<<< HEAD
		if(!ascending) {
=======
		if (!ascending){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			comparator = Collections.reverseOrder(comparator);
		}
		
		Collections.sort(newTargets, comparator);
		
		return newTargets;
	}
	
<<<<<<< HEAD
	class TypologyComparator implements Comparator<String> {
=======
	class TypologyComparator implements Comparator<String>{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		TypologyModule	typology;
		
		String					context;
		
		
		/**
		 * 
		 */
<<<<<<< HEAD
		public TypologyComparator(TypologyModule typology, String context) {
=======
		public TypologyComparator(TypologyModule typology, String context){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.typology = typology;
			this.context = context;
		}
		
<<<<<<< HEAD
		
		/**
		 * 
		 */
		public final int compare(String target1, String target2) {
=======

		/**
		 * 
		 */
		public final int compare(String target1, String target2){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			double value1 = this.typology.getReputation(target1, this.context);
			
			double value2 = this.typology.getReputation(target2, this.context);
			
			return(value1 < value2 ? -1 : (value1 > value2 ? +1 : 0));
		}
	}
}