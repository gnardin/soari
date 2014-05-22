package reputationreasoners.liar.recommendation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.reputation.Reputation;
import reputationreasoners.liar.reputation.ReputationSet;
import reputationreasoners.liar.reputation.ReputationValue;
import reputationreasoners.liar.trustintention.LevSet;

public class RecommendationSet{

	private final int								DEFAULT_TIME_WINDOW	= 100;

	// Map<target, List<Recommendation>[Facets][Dimensions]>
	private Map<String, List<Recommendation>[][]>	recSet;
	private Integer									timeWindow			= new Integer(
																				DEFAULT_TIME_WINDOW);
	private Boolean									addedRpRcbRp		= new Boolean(
																				false);

	/**
	 * 
	 */
	public RecommendationSet(){
		this.recSet = new Hashtable<String, List<Recommendation>[][]>();
	}

	/**
	 * 
	 */
	public RecommendationSet(Integer timeWindow){
		if(timeWindow != null){
			if(timeWindow.intValue() > 0){
				this.timeWindow = timeWindow;
			}
		}

		this.recSet = new Hashtable<String, List<Recommendation>[][]>();
	}

	/**
	 * 
	 */
	public void addRecommendation(String agent, Facets facet,
			Dimensions dimension, Recommendation recommendation){
		List<Recommendation>[][] values;

		if(!this.recSet.containsKey(agent)){
			values = new ArrayList[Facets.values().length][Dimensions.values().length];

			// Initializes all the Recommendation[facet][dimension]
			for(int i = 0; i < Facets.values().length; i++){
				for(int j = 0; j < Dimensions.values().length; j++){
					values[i][j] = new ArrayList<Recommendation>();
				}
			}
		}else{
			values = this.recSet.get(agent);
		}

		int iFacet = facet.ordinal();
		int iDimension = dimension.ordinal();
		if(values[iFacet][iDimension].size() >= this.timeWindow.intValue()){
			values[iFacet][iDimension].remove(0);
		}

		values[iFacet][iDimension].add(recommendation);

		this.recSet.put(agent, values);

		this.addedRpRcbRp = new Boolean(true);
	}

	/**
	 * 
	 */
	public List<Recommendation> getRecommendations(String agent, Facets facet,
			Dimensions dimension){
		List<Recommendation> result = null;

		if(this.recSet.containsKey(agent)){
			List<Recommendation>[][] values = this.recSet.get(agent);

			result = values[facet.ordinal()][dimension.ordinal()];
		}

		if(result == null){
			result = new ArrayList<Recommendation>();
		}

		return result;
	}

	/**
	 * 
	 */
	public void punishement(ReputationSet repSet, LevSet levSet){
		if(this.addedRpRcbRp.booleanValue()){
			this.calculateRpRcbRp(repSet, levSet);
			this.addedRpRcbRp = new Boolean(false);
		}
	}

	/**
	 * 
	 */
	private void calculateRpRcbRp(ReputationSet repSet, LevSet levSet){
		List<Recommendation> recs;
		ReputationValue value;
		String agent;

		double nominator;
		double denominator;
		int numRec;

		for(Iterator<String> iAgent = this.recSet.keySet().iterator(); iAgent
				.hasNext();){
			agent = iAgent.next();
			List<Recommendation>[][] lRec = this.recSet.get(agent);

			for(Facets facet : Facets.values()){
				for(Dimensions dimension : Dimensions.values()){
					recs = lRec[facet.ordinal()][dimension.ordinal()];

					nominator = 0;
					denominator = 0;
					numRec = 0;
					for(Recommendation rec : recs){

						nominator = nominator
								+ (rec.getValue() * rec.getTrustVal());

						denominator = denominator + rec.getTrustVal();

						numRec++;
					}

					if((denominator != 0) && (numRec > 0)){
						value = new ReputationValue(new Double(nominator
								/ denominator), new Integer(numRec));

						repSet.setReputation(agent, facet, dimension,
								Reputation.RepType.RpRcbRp, value);
					}
				}
			}
		}
	}
}