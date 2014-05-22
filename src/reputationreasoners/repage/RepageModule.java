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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import repage.memory.*;
import repage.fuzzy.*;
import reputationreasoners.repage.Predicate.predicateType;

/**
 * Class that defines the Repage Module used by the agents in the system.
 */
public class RepageModule{

	private List<RepageUnit>	repage	= new ArrayList<RepageUnit>();

	/**
	 * 
	 */
	public boolean exists(String target, String facet){
		boolean exist = false;

		RepageUnit unit;
		for(int i = 0; i < this.repage.size(); i++){
			unit = this.repage.get(i);
			if((unit.getTarget().toUpperCase().equals(target.toUpperCase()))
					&& (unit.getFacet().toUpperCase().equals(facet
							.toUpperCase()))){
				exist = true;
				break;
			}
		}
		return exist;
	}

	/**
	 * 
	 */
	public int getUnitIndex(String target, String facet)
			throws IndexOutOfBoundsException{
		int i;
		RepageUnit unit;
		for(i = 0; i < this.repage.size(); i++){
			unit = this.repage.get(i);
			if((unit.getTarget().toUpperCase().equals(target.toUpperCase()))
					&& (unit.getFacet().toUpperCase().equals(facet
							.toUpperCase()))){
				break;
			}
		}
		return i;
	}

	/**
	 * 
	 */
	public List<RepageUnit> getRepageMemory(){
		return this.repage;
	}

	/**
	 * 
	 */
	public void setRepageMemory(String target, String facet){
		RepageUnit unit = new RepageUnit(target, facet);
		this.repage.add(unit);
	}

	/**
	 * Fuzzyfy a number
	 */
	private TupleFzz fuzzyfy(float input, double strength){
		double values[] = new double[5];
		TupleFzz result;

		/**
		 * values[0] = very bad evaluation values[1] = bad evaluation values[2]
		 * = neutral evaluation values[3] = good evaluation values[4] = very
		 * good evaluation
		 */

		if(input <= 0.2){
			values[0] = 1.0;
			values[1] = 0.0;
			values[2] = 0.0;
			values[3] = 0.0;
			values[4] = 0.0;
		}else if(0.2 < input && input <= 0.4){
			values[0] = 0.0;
			values[1] = 1.0;
			values[2] = 0.0;
			values[3] = 0.0;
			values[4] = 0.0;
		}else if(0.4 < input && input <= 0.6){
			values[0] = 0.0;
			values[1] = 0.0;
			values[2] = 1.0;
			values[3] = 0.0;
			values[4] = 0.0;
		}else if(0.6 < input && input <= 0.8){
			values[0] = 0.0;
			values[1] = 0.0;
			values[2] = 0.0;
			values[3] = 1.0;
			values[4] = 0.0;
		}else{
			values[0] = 0.0;
			values[1] = 0.0;
			values[2] = 0.0;
			values[3] = 0.0;
			values[4] = 1.0;
		}
		FzzNum num = new FzzNum(values);
		result = new TupleFzz(num, strength);
		return result;
	}

	/**
	 * Process that calculates the Image of a target
	 */
	public void calculateImage(String target, String facet, float newInput){

		ArrayList<TupleFzz> aux = new ArrayList<TupleFzz>();

		try{
			RepageUnit unit = this.repage.get(getUnitIndex(target, facet));

			// Level 1 of Repage's memory
			Predicate active = unit
					.getPredicate(Predicate.predicateType.FULFILLMENT);
			// strength = 0.8
			TupleFzz tuple = fuzzyfy(newInput, 0.8);
			active.setTuple(tuple);

			// Level 2 of Repage's memory
			active = unit.getPredicate(Predicate.predicateType.OUTCOME);
			active.setTuple(tuple);

			aux
					.add(unit.getPredicate(Predicate.predicateType.IMAGE)
							.getTuple());
			aux.add(unit.getPredicate(Predicate.predicateType.SHARED_EVAL)
					.getTuple());
			aux.add(unit.getPredicate(Predicate.predicateType.OUTCOME)
					.getTuple());

			active = unit.getPredicate(Predicate.predicateType.IMAGE);
			// Sums the Predicates Image, Shared Evaluation and Outcome
			tuple = FzzNum.sum_simpleWeightedMean(aux);

			// The result is the new image of the target
			active.setTuple(tuple);
		}catch(IndexOutOfBoundsException ioobe){
		}
	}

	/**
	 * Process that calculates the Image of a target
	 */
	public void calculateImage(String target, String facet, String newInput){
		this.calculateImage(target, facet, fromVectortoReal(newInput)
				.floatValue());
	}

	/**
	 * Process that calculates the Third Party Image of a target
	 */
	public void calculateTPImage(String target, String facet, float newInput){

		ArrayList<TupleFzz> aux = new ArrayList<TupleFzz>();

		try{
			RepageUnit unit = this.repage.get(getUnitIndex(target, facet));

			// Level 1 of Repage's memory
			Predicate active = unit
					.getPredicate(Predicate.predicateType.TPIMAGE);
			// strength = 0.5
			TupleFzz tuple = fuzzyfy(newInput, 0.5);
			active.setTuple(tuple);

			// Level 2 of Repage's memory
			active = unit.getPredicate(Predicate.predicateType.VAL_COMM);
			active.setTuple(tuple);

			// Level 3 of Repage's Memory
			active = unit.getPredicate(Predicate.predicateType.SHARED_EVAL);
			active.setTuple(tuple);

			// Sums the predicates image and shared evaluation
			aux
					.add(unit.getPredicate(Predicate.predicateType.IMAGE)
							.getTuple());
			aux.add(unit.getPredicate(Predicate.predicateType.SHARED_EVAL)
					.getTuple());

			active = unit.getPredicate(Predicate.predicateType.IMAGE);
			// The result is the new image of the target
			tuple = FzzNum.sum_simpleWeightedMean(aux);

			// The result is the new image of the target
			active.setTuple(tuple);
		}catch(IndexOutOfBoundsException ioobe){
		}
	}

	/**
	 * Process that calculates the Third Party Image of a target
	 */
	public void calculateTPImage(String target, String facet, String newInput){
		this.calculateTPImage(target, facet, fromVectortoReal(newInput)
				.floatValue());
	}

	/**
	 * Process that calculates the Reputation of a target
	 */
	public void calculateReputation(String target, String facet, float newInput){

		ArrayList<TupleFzz> aux = new ArrayList<TupleFzz>();

		try{
			RepageUnit unit = this.repage.get(getUnitIndex(target, facet));
			// Level 1 of Repage's memory
			Predicate active = unit
					.getPredicate(Predicate.predicateType.COM_REP);
			// strength = 0.3
			TupleFzz tuple = fuzzyfy(newInput, 0.3);
			active.setTuple(tuple);

			// Level 2 of Repage's memory
			active = unit.getPredicate(Predicate.predicateType.VAL_COMM);
			active.setTuple(tuple);

			// Level 3 of Repage's memory
			active = unit.getPredicate(Predicate.predicateType.SHARED_VOICE);
			active.setTuple(tuple);

			// Sums the predicates reputation and shared voice
			aux.add(unit.getPredicate(Predicate.predicateType.REPUTATION)
					.getTuple());
			aux.add(unit.getPredicate(Predicate.predicateType.SHARED_VOICE)
					.getTuple());

			active = unit.getPredicate(Predicate.predicateType.REPUTATION);
			// The result is the new reputation of the target
			tuple = FzzNum.sum_simpleWeightedMean(aux);

			// The result is the new reputation of the target
			active.setTuple(tuple);
		}catch(IndexOutOfBoundsException ioobe){
		}
	}

	/**
	 * Process that calculates the Reputation of a target
	 */
	public void calculateReputation(String target, String facet, String newInput){
		this.calculateReputation(target, facet, fromVectortoReal(newInput)
				.floatValue());
	}

	/**
	 * 
	 */
	public String convertRealToString(Float input, Double strength){
		return this.convertTuple(this.fuzzyfy(input, strength));
	}

	/**
	 * 
	 */
	public Float convertStringToReal(String input){
		return this.fromVectortoReal(input);
	}

	/**
	 * 
	 * 1/10 * Ei (2i - 1) Xi
	 * 
	 */
	private Float fromVectortoReal(String newInput){
		Float[] values = new Float[5];

		String strValues = newInput.substring(1, newInput.length() - 1);
		String[] v = strValues.split(";");
		if(v.length == 5){
			for(int i = 0; i < v.length; i++){
				try{
					values[i] = new Float(v[i]);
				}catch(NumberFormatException nfe){
					continue;
				}
			}
		}

		float cm = 0;
		float aux = 0;
		for(int i = 0; i < 5; i++){
			aux = ((2 * i) - 1) * values[i].floatValue();
			cm = cm + aux;
		}
		cm = cm / 10;

		return new Float(cm);
	}

	/**
	 * 
	 */
	public String[] getFacets(String target){
		String[] result = null;
		Map<String, String> targets = new HashMap<String, String>();

		RepageUnit unit;
		for(Iterator<RepageUnit> i = this.repage.iterator(); i.hasNext();){
			unit = i.next();
			if(unit.getTarget().equals(target)){
				targets.put(unit.getFacet(), null);
			}
		}

		if(targets.size() > 0){
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

		RepageUnit unit;
		for(Iterator<RepageUnit> i = this.repage.iterator(); i.hasNext();){
			unit = i.next();
			if(unit.getFacet().equals(facet)){
				facets.put(unit.getTarget(), null);
			}
		}

		if(facets.size() > 0){
			result = new String[facets.size()];
			int i = 0;
			for(Iterator<String> x = facets.keySet().iterator(); x.hasNext();){
				result[i++] = x.next();
			}
		}

		return result;
	}

	/**
	 * Returns a target image
	 */
	public float getImage(String target, String facet){
		float result = 0;

		try{
			RepageUnit unit = this.repage.get(getUnitIndex(target, facet));
			Predicate image = unit.getPredicate(Predicate.predicateType.IMAGE);

			TupleFzz tuple = image.getTuple();

			result = new Float(tuple.fzzNum.centerOfMass()).floatValue() / 4;
		}catch(IndexOutOfBoundsException ioobe){
		}

		return result;
	}

	/**
	 * 
	 */
	public float getDeviatedImage(String target, String facet, Double bias){
		RepageUnit unit = this.repage.get(getUnitIndex(target, facet));

		Predicate image = unit.getPredicate(Predicate.predicateType.IMAGE);

		TupleFzz tuple = image.getTuple();

		double value = tuple.fzzNum.centerOfMass() / 4;

		double deviation = value * bias;

		if((value - deviation) > 0){
			value = value - deviation;
		}else{
			value = value + deviation;
		}

		return new Double(value).floatValue();
	}

	/**
	 * Returns the strength of a target image
	 */
	public double getImageStrength(String target, String facet){
		RepageUnit unit = this.repage.get(getUnitIndex(target, facet));
		Predicate image = unit.getPredicate(Predicate.predicateType.IMAGE);

		return image.getTuple().strength;
	}

	/**
	 * Returns a target image
	 */
	public String getImageText(String target, String facet){
		String result = "";

		try{
			RepageUnit unit = this.repage.get(getUnitIndex(target, facet));
			Predicate image = unit.getPredicate(Predicate.predicateType.IMAGE);

			result = this.convertTuple(image.getTuple());
		}catch(IndexOutOfBoundsException ioobe){
		}

		return result;
	}

	/**
	 * 
	 */
	public String getDeviatedImageText(String target, String facet, Double bias){
		RepageUnit unit = this.repage.get(getUnitIndex(target, facet));

		Predicate image = unit.getPredicate(Predicate.predicateType.IMAGE);

		TupleFzz tuple = image.getTuple();

		double value = tuple.fzzNum.centerOfMass() / 4;

		double strength = tuple.strength;

		double deviation = value * bias;

		if((value - deviation) > 0){
			value = value - deviation;
		}else{
			value = value + deviation;
		}

		String strImage = convertRealToString(new Double(value).floatValue(),
				strength);

		return strImage;
	}

	/**
	 * Returns a target reputation
	 */
	public float getReputation(String target, String facet){
		float result = 0;

		try{
			RepageUnit unit = this.repage.get(getUnitIndex(target, facet));
			Predicate reputation = unit
					.getPredicate(Predicate.predicateType.REPUTATION);
			TupleFzz tuple = reputation.getTuple();

			result = new Float(tuple.fzzNum.centerOfMass()).floatValue() / 4;
		}catch(IndexOutOfBoundsException ioobe){
		}

		return result;
	}

	/**
	 * 
	 */
	public float getDeviatedReputation(String target, String facet, Double bias){
		RepageUnit unit = this.repage.get(getUnitIndex(target, facet));

		Predicate reputation = unit
				.getPredicate(Predicate.predicateType.REPUTATION);

		TupleFzz tuple = reputation.getTuple();

		double value = tuple.fzzNum.centerOfMass() / 4;

		double deviation = value * bias;

		if((value - deviation) > 0){
			value = value - deviation;
		}else{
			value = value + deviation;
		}

		return new Double(value).floatValue();
	}

	/**
	 * Returns the strength of a target reputation
	 */
	public double getReputationStrength(String target, String facet){
		RepageUnit unit = this.repage.get(getUnitIndex(target, facet));
		Predicate reputation = unit
				.getPredicate(Predicate.predicateType.REPUTATION);

		return reputation.getTuple().strength;
	}

	/**
	 * Returns a target reputation
	 */
	public String getReputationText(String target, String facet){
		String result = "";

		try{
			RepageUnit unit = this.repage.get(getUnitIndex(target, facet));
			Predicate reputation = unit
					.getPredicate(Predicate.predicateType.REPUTATION);

			result = this.convertTuple(reputation.getTuple());
		}catch(IndexOutOfBoundsException ioobe){
		}

		return result;
	}

	/**
	 * 
	 */
	public String getDeviatedReputationText(String target, String facet,
			Double bias){
		RepageUnit unit = this.repage.get(getUnitIndex(target, facet));

		Predicate reputation = unit
				.getPredicate(Predicate.predicateType.REPUTATION);

		TupleFzz tuple = reputation.getTuple();

		double value = tuple.fzzNum.centerOfMass() / 4;

		double strength = tuple.strength;

		double deviation = value * bias;

		if((value - deviation) > 0){
			value = value - deviation;
		}else{
			value = value + deviation;
		}

		String strReputation = convertRealToString(new Double(value)
				.floatValue(), strength);

		return strReputation;
	}

	/**
	 * 
	 */
	public float getAggregated(String agent, String era){
		return((this.getImage(agent, era) + this.getReputation(agent, era)) / 2);
	}

	/**
	 * 
	 */
	public List<String> sortTarget(List<String> targets, String facet,
			Boolean ascending){

		List<String> newTargets = new ArrayList<String>(targets);

		Comparator<String> comparator = new RepageComparator(this, facet);

		if(!ascending){
			comparator = Collections.reverseOrder(comparator);
		}

		Collections.sort(newTargets, comparator);

		return newTargets;
	}

	/**
	 * 
	 */
	public void printRepage(){
		RepageUnit unit = new RepageUnit();
		for(int i = 0; i < this.repage.size(); i++){
			unit = this.repage.get(i);
			for(predicateType p : predicateType.values()){
				Predicate pred = unit.getPredicate(p);
				System.out.println(unit.getTarget() + " | "
						+ pred.getPredicateType().toString() + " | "
						+ pred.getTuple().toString());
			}
		}
	}

	/**
	 * 
	 */
	private String convertTuple(TupleFzz tuple){
		String result;

		DecimalFormat decimalFormat = new DecimalFormat("0.0",
				new DecimalFormatSymbols(Locale.US));

		// result = image.getTuple().toString();
		double[] d = tuple.fzzNum.value;
		result = "[[" + decimalFormat.format(d[0]) + ";"
				+ decimalFormat.format(d[1]) + ";" + decimalFormat.format(d[2])
				+ ";" + decimalFormat.format(d[3]) + ";"
				+ decimalFormat.format(d[4]) + "];"
				+ decimalFormat.format(tuple.strength) + "]";

		return result;
	}
}

class RepageComparator implements Comparator<String>{

	RepageModule	repage;
	String			facet;

	/**
	 * 
	 */
	public RepageComparator(RepageModule repage, String facet){
		this.repage = repage;
		this.facet = facet;
	}

	public final int compare(String target1, String target2){
		float value1 = this.repage.getAggregated(target1, this.facet);

		float value2 = this.repage.getAggregated(target2, this.facet);

		return(value1 < value2 ? -1 : (value1 > value2 ? +1 : 0));
	}
}