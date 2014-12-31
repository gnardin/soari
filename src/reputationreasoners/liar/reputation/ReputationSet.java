package reputationreasoners.liar.reputation;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
<<<<<<< HEAD
import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.reputation.Reputation.RepType;

public class ReputationSet {
	
	// Map<AgentName Debtor, Reputation[Facet][Dimension]>
	private Map<String, Reputation[][]>	repSetByDeb;
	
	private Weight											repWeight;
	
	
	/**
	 * 
	 */
	public ReputationSet(Weight sPolWeight) {
		this.repSetByDeb = new Hashtable<String, Reputation[][]>();
		this.repWeight = sPolWeight;
	}
	
	
	/**
	 * 
	 */
	public Boolean exists(String agent) {
		return this.repSetByDeb.containsKey(agent);
	}
	
	
	/**
	 * 
	 */
	public String[] getDebtors() {
		String[] result = new String[this.repSetByDeb.size()];
		
		int i = 0;
		for(Iterator<String> iDeb = this.repSetByDeb.keySet().iterator(); iDeb
				.hasNext();) {
			result[i++] = iDeb.next();
		}
		
		return result;
	}
	
	
=======

import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.reputation.Reputation;
import reputationreasoners.liar.reputation.Reputation.RepType;

public class ReputationSet{

	// Map<AgentName Debtor, Reputation[Facet][Dimension]>
	private Map<String, Reputation[][]>	repSetByDeb;
	private Weight						repWeight;

	/**
	 * 
	 */
	public ReputationSet(Weight sPolWeight){
		this.repSetByDeb = new Hashtable<String, Reputation[][]>();
		this.repWeight = sPolWeight;
	}

	/**
	 * 
	 */
	public Boolean exists(String agent){
		return this.repSetByDeb.containsKey(agent);
	}

	/**
	 * 
	 */
	public String[] getDebtors(){
		String[] result = new String[this.repSetByDeb.size()];

		int i = 0;
		for(Iterator<String> iDeb = this.repSetByDeb.keySet().iterator(); iDeb
				.hasNext();){
			result[i++] = iDeb.next();
		}

		return result;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public ReputationValue getReputation(String agent, Facets facet,
<<<<<<< HEAD
			Dimensions dimension, RepType type) {
		ReputationValue result = null;
		
		if(this.repSetByDeb.containsKey(agent)) {
			Reputation[][] values = this.repSetByDeb.get(agent);
			
			result = values[facet.ordinal()][dimension.ordinal()].get(type);
		}
		
		if(result == null) {
			result = new ReputationValue(ReputationValue.UNKNOWN, -1);
		}
		
		return result;
	}
	
	
=======
			Dimensions dimension, RepType type){
		ReputationValue result = null;

		if(this.repSetByDeb.containsKey(agent)){
			Reputation[][] values = this.repSetByDeb.get(agent);

			result = values[facet.ordinal()][dimension.ordinal()].get(type);
		}

		if(result == null){
			result = new ReputationValue(ReputationValue.UNKNOWN, -1);
		}

		return result;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public ReputationValue[] getReputationByDeb(String agent,
<<<<<<< HEAD
			Dimensions dimension, RepType type) {
		ReputationValue[] result = new ReputationValue[Facets.values().length];
		
		Reputation[][] repSet;
		if(this.repSetByDeb.containsKey(agent)) {
			repSet = this.repSetByDeb.get(agent);
			for(Facets facet : Facets.values()) {
				result[facet.ordinal()] = repSet[facet.ordinal()][dimension.ordinal()]
						.get(type);
			}
		} else {
			for(Facets facet : Facets.values()) {
				result[facet.ordinal()] = new ReputationValue(ReputationValue.UNKNOWN,
						-1);
			}
		}
		
		return result;
	}
	
	
=======
			Dimensions dimension, RepType type){
		ReputationValue[] result = new ReputationValue[Facets.values().length];

		Reputation[][] repSet;
		if(this.repSetByDeb.containsKey(agent)){
			repSet = this.repSetByDeb.get(agent);
			for(Facets facet : Facets.values()){
				result[facet.ordinal()] = repSet[facet.ordinal()][dimension
						.ordinal()].get(type);
			}
		}else{
			for(Facets facet : Facets.values()){
				result[facet.ordinal()] = new ReputationValue(
						ReputationValue.UNKNOWN, -1);
			}
		}

		return result;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public Map<String, ReputationValue> getReputationByFacet(Facets facet,
<<<<<<< HEAD
			Dimensions dimension, RepType type) {
		Map<String, ReputationValue> result = new Hashtable<String, ReputationValue>();
		
		String agent;
		Reputation[][] rep;
		for(Iterator<String> iAgent = this.repSetByDeb.keySet().iterator(); iAgent
				.hasNext();) {
			agent = iAgent.next();
			rep = this.repSetByDeb.get(agent);
			result.put(agent, rep[facet.ordinal()][dimension.ordinal()].get(type));
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public Weight getWeight() {
		return this.repWeight;
	}
	
	
=======
			Dimensions dimension, RepType type){
		Map<String, ReputationValue> result = new Hashtable<String, ReputationValue>();

		String agent;
		Reputation[][] rep;
		for(Iterator<String> iAgent = this.repSetByDeb.keySet().iterator(); iAgent
				.hasNext();){
			agent = iAgent.next();
			rep = this.repSetByDeb.get(agent);
			result.put(agent, rep[facet.ordinal()][dimension.ordinal()]
					.get(type));
		}

		return result;
	}

	/**
	 * 
	 */
	public Weight getWeight(){
		return this.repWeight;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setReputation(String agent, Facets facet, Dimensions dimension,
<<<<<<< HEAD
			RepType type, ReputationValue value) {
		Reputation[][] values;
		
		if(!this.repSetByDeb.containsKey(agent)) {
			values = new Reputation[Facets.values().length][Dimensions.values().length];
			
			// Initializes all the Reputation[facet][dimension]
			for(int i = 0; i < Facets.values().length; i++) {
				for(int j = 0; j < Dimensions.values().length; j++) {
					values[i][j] = new Reputation();
				}
			}
		} else {
			values = this.repSetByDeb.get(agent);
		}
		values[facet.ordinal()][dimension.ordinal()].set(type, value);
		
		this.repSetByDeb.put(agent, values);
	}
	
	
	/**
	 * 
	 */
	public void print() {
		String agent;
		Reputation[][] rep;
		for(Iterator<String> iAgent = this.repSetByDeb.keySet().iterator(); iAgent
				.hasNext();) {
			agent = iAgent.next();
			rep = this.repSetByDeb.get(agent);
			
			System.out.println("Agent = [" + agent + "]");
			for(Facets facet : Facets.values()) {
				System.out.println("   Facet = [" + facet.toString() + "]");
				
				for(Dimensions dimension : Dimensions.values()) {
					System.out
							.println("      Dimension = [" + dimension.toString() + "]");
					
=======
			RepType type, ReputationValue value){
		Reputation[][] values;

		if(!this.repSetByDeb.containsKey(agent)){
			values = new Reputation[Facets.values().length][Dimensions.values().length];

			// Initializes all the Reputation[facet][dimension]
			for(int i = 0; i < Facets.values().length; i++){
				for(int j = 0; j < Dimensions.values().length; j++){
					values[i][j] = new Reputation();
				}
			}
		}else{
			values = this.repSetByDeb.get(agent);
		}
		values[facet.ordinal()][dimension.ordinal()].set(type, value);

		this.repSetByDeb.put(agent, values);
	}

	/**
	 * 
	 */
	public void print(){
		String agent;
		Reputation[][] rep;
		for(Iterator<String> iAgent = this.repSetByDeb.keySet().iterator(); iAgent
				.hasNext();){
			agent = iAgent.next();
			rep = this.repSetByDeb.get(agent);

			System.out.println("Agent = [" + agent + "]");
			for(Facets facet : Facets.values()){
				System.out.println("   Facet = [" + facet.toString() + "]");

				for(Dimensions dimension : Dimensions.values()){
					System.out.println("      Dimension = ["
							+ dimension.toString() + "]");

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					rep[facet.ordinal()][dimension.ordinal()].print();
				}
			}
		}
	}
}