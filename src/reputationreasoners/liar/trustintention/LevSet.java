package reputationreasoners.liar.trustintention;

import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.reputation.Reputation;
<<<<<<< HEAD
import reputationreasoners.liar.reputation.Reputation.RepType;
import reputationreasoners.liar.reputation.ReputationSet;
import reputationreasoners.liar.reputation.ReputationValue;
import reputationreasoners.liar.trustintention.TrustIntention.TrustType;

public class LevSet {
	
	public final TrustType	DEFAULT_GDtT	= TrustIntention.TrustType.TRUST;
	
	// Lev[Reputation.RepType]
	private Lev[]						levSet;
	
	private TrustType				GDtT;
	
	
	/**
	 * 
	 */
	public LevSet() {
		this.levSet = new Lev[Reputation.RepType.values().length];
		for(Reputation.RepType repType : Reputation.RepType.values()) {
			this.levSet[repType.ordinal()] = new Lev(new Double(0), new Double(0),
					new Integer(0));
		}
	}
	
	
	/**
	 * 
	 */
	public LevSet(TrustType GDtT) {
		this.levSet = new Lev[Reputation.RepType.values().length];
		for(Reputation.RepType repType : Reputation.RepType.values()) {
			this.levSet[repType.ordinal()] = new Lev(new Double(0), new Double(0),
					new Integer(0));
		}
		this.GDtT = GDtT;
	}
	
	
	/**
	 * 
	 */
	public TrustType getGDtT() {
		return this.GDtT;
	}
	
	
	/**
	 * 
	 */
	public Lev getLev(Reputation.RepType repType) {
		return this.levSet[repType.ordinal()];
	}
	
	
	/**
	 * 
	 */
	public void setGDtT(TrustType GDtT) {
		this.GDtT = GDtT;
	}
	
	
	/**
	 * 
	 */
	public void setLev(Reputation.RepType repType, Lev lev) {
		if(lev != null) {
			this.levSet[repType.ordinal()] = lev;
		}
	}
	
	
=======
import reputationreasoners.liar.reputation.ReputationSet;
import reputationreasoners.liar.reputation.ReputationValue;
import reputationreasoners.liar.reputation.Reputation.RepType;
import reputationreasoners.liar.trustintention.TrustIntention.TrustType;

public class LevSet{

	public final TrustType	DEFAULT_GDtT	= TrustIntention.TrustType.TRUST;

	// Lev[Reputation.RepType]
	private Lev[]			levSet;
	private TrustType		GDtT;

	/**
	 * 
	 */
	public LevSet(){
		this.levSet = new Lev[Reputation.RepType.values().length];
		for(Reputation.RepType repType : Reputation.RepType.values()){
			this.levSet[repType.ordinal()] = new Lev(new Double(0), new Double(
					0), new Integer(0));
		}
	}

	/**
	 * 
	 */
	public LevSet(TrustType GDtT){
		this.levSet = new Lev[Reputation.RepType.values().length];
		for(Reputation.RepType repType : Reputation.RepType.values()){
			this.levSet[repType.ordinal()] = new Lev(new Double(0), new Double(
					0), new Integer(0));
		}
		this.GDtT = GDtT;
	}

	/**
	 * 
	 */
	public TrustType getGDtT(){
		return this.GDtT;
	}

	/**
	 * 
	 */
	public Lev getLev(Reputation.RepType repType){
		return this.levSet[repType.ordinal()];
	}

	/**
	 * 
	 */
	public void setGDtT(TrustType GDtT){
		this.GDtT = GDtT;
	}

	/**
	 * 
	 */
	public void setLev(Reputation.RepType repType, Lev lev){
		if(lev != null){
			this.levSet[repType.ordinal()] = lev;
		}
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public TrustIntention reason(String target, Facets facet,
<<<<<<< HEAD
			Dimensions dimension, ReputationSet repSet) {
		
		ReputationValue repValue;
		double value;
		int relevance;
		
		for(RepType repType : RepType.values()) {
			repValue = repSet.getReputation(target, facet, dimension, repType);
			
			if(repValue != null) {
				value = repValue.getValue().doubleValue();
				relevance = repValue.getReliability().intValue();
				
=======
			Dimensions dimension, ReputationSet repSet){

		ReputationValue repValue;
		double value;
		int relevance;

		for(RepType repType : RepType.values()){
			repValue = repSet.getReputation(target, facet, dimension, repType);

			if(repValue != null){
				value = repValue.getValue().doubleValue();
				relevance = repValue.getReliability().intValue();

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				// Check the relevance
				// It is not checking the relevance
				// If you want to check, include
				// "&& (relevance >= levSet[repType.ordinal()].getRelevance())"
<<<<<<< HEAD
				if(value != ReputationValue.UNKNOWN.doubleValue()) {
					
					if(value > levSet[repType.ordinal()].getTrust().doubleValue()) {
						return new TrustIntention(TrustIntention.TrustType.TRUST, value);
						
					} else if(value < levSet[repType.ordinal()].getDistrust()
							.doubleValue()) {
						return new TrustIntention(TrustIntention.TrustType.DISTRUST, value);
					}
				} else if(value == ReputationValue.UNKNOWN.doubleValue()) {
					return new TrustIntention(TrustIntention.TrustType.DISTRUST,
							new Double(0));
				}
			}
		}
		
=======
				if(value != ReputationValue.UNKNOWN.doubleValue()){

					if(value > levSet[repType.ordinal()].getTrust()
							.doubleValue()){
						return new TrustIntention(
								TrustIntention.TrustType.TRUST, value);

					}else if(value < levSet[repType.ordinal()].getDistrust()
							.doubleValue()){
						return new TrustIntention(
								TrustIntention.TrustType.DISTRUST, value);
					}
				}else if(value == ReputationValue.UNKNOWN.doubleValue()){
					return new TrustIntention(
							TrustIntention.TrustType.DISTRUST, new Double(0));
				}
			}
		}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return new TrustIntention(this.GDtT, new Double(0));
	}
}