package reputationreasoners.liar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import reputationreasoners.liar.condition.Condition;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.recommendation.Recommendation;
import reputationreasoners.liar.recommendation.RecommendationSet;
import reputationreasoners.liar.reputation.ReputationSet;
import reputationreasoners.liar.reputation.Weight;
import reputationreasoners.liar.socialcommitment.SCom;
import reputationreasoners.liar.socialcommitment.SCom.States;
import reputationreasoners.liar.socialnorm.SNormSet;
import reputationreasoners.liar.socialpolicy.SPol;
import reputationreasoners.liar.socialpolicy.SPolSet;
import reputationreasoners.liar.trustintention.LevSet;
import reputationreasoners.liar.trustintention.TrustIntention;

public class LIARModule {
	
	private String						id;
	
	private RecommendationSet	recSet;
	
	private ReputationSet			repSet;
	
	private SNormSet					sNormSet;
	
	private SPolSet						sPolSet;
	
	private LevSet						levSet;
	
	
	/**
	 * 
	 */
	public LIARModule(String id) {
		this.id = id;
		this.recSet = new RecommendationSet();
		this.repSet = new ReputationSet(new Weight());
		this.sNormSet = new SNormSet();
		this.sPolSet = new SPolSet();
		this.levSet = new LevSet();
	}
	
	
	/**
	 * 
	 */
	public LIARModule(String id, SNormSet sNormSet, LevSet levSet) {
		
		this.id = id;
		this.recSet = new RecommendationSet();
		this.repSet = new ReputationSet(new Weight());
		
		if(sNormSet == null) {
			this.sNormSet = new SNormSet();
		} else {
			this.sNormSet = sNormSet;
		}
		this.sPolSet = new SPolSet();
		
		if(levSet == null) {
			this.levSet = new LevSet();
		} else {
			this.levSet = levSet;
		}
	}
	
	
	/**
	 * 
	 */
	public String getID() {
		return this.id;
	}
	
	
	/**
	 * 
	 */
	public RecommendationSet getRecommendationSet() {
		return this.recSet;
	}
	
	
	/**
	 * 
	 */
	public ReputationSet getReputationSet() {
		return this.repSet;
	}
	
	
	/**
	 * 
	 */
	public SNormSet getSNormSet() {
		return this.sNormSet;
	}
	
	
	/**
	 * 
	 */
	public SPolSet getSPolSet() {
		return this.sPolSet;
	}
	
	
	/**
	 * 
	 */
	public LevSet getLevSet() {
		return this.levSet;
	}
	
	
	/**
	 * 
	 */
	public void setID(String id) {
		if(id != null) {
			this.id = id;
		}
	}
	
	
	/**
	 * 
	 */
	public void setSNormSet(SNormSet sNormSet) {
		if(sNormSet != null) {
			this.sNormSet = sNormSet;
		}
	}
	
	
	/**
	 * 
	 */
	public void setLevSet(LevSet levSet) {
		if(levSet != null) {
			this.levSet = levSet;
		}
	}
	
	
	/**
	 * 
	 */
	public void newInteraction(String debtor, String creditor,
			Condition condition, Content content, Facets facet, Long timeEmission) {
		
		// Create the Social Commitment
		SCom sCom = new SCom(this.id, debtor, creditor, condition, content, facet,
				States.ACTIVE, timeEmission);
		
		// Evaluate the Social Commitment against all the possible Social Norms
		List<SPol> sPolList = this.sNormSet.evaluation(sCom);
		
		// Update the Social Policy Sets
		if(sPolList.size() > 0) {
			for(SPol sPol : sPolList) {
				if(sPol != null) {
					this.sPolSet.addSPol(sPol);
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void newObservation(SCom sCom) {
		if(sCom != null) {
			// Evaluate the Social Commitment against all the possible
			// Social Norms
			List<SPol> sPolList = this.sNormSet.evaluation(sCom);
			
			// Update the Social Policy Sets
			if(sPolList.size() > 0) {
				TrustIntention trustInt;
				for(SPol sPol : sPolList) {
					if(sPol != null) {
						trustInt = this.levSet.reason(sCom.getObserver(),
								Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
						
						if(trustInt.getTrustInt().value.booleanValue()) {
							this.sPolSet.addSPol(sPol);
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void newEvaluation(SPol sPol) {
		if(sPol != null) {
			TrustIntention trustInt = this.levSet.reason(sPol.getObserver(),
					Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
			
			if(trustInt.getTrustInt().value.booleanValue()) {
				
				this.sPolSet.addSPol(sPol);
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void newRecommendation(String observer, String target, Facets facet,
			Dimensions dimension, Double value) {
		
		TrustIntention trustInt = this.levSet.reason(observer,
				Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
		
		if(trustInt.getTrustInt().value.booleanValue()) {
			
			trustInt = this.levSet.reason(observer, facet, Dimensions.COMPETENCE,
					this.repSet);
			
			Recommendation rec = new Recommendation(value, trustInt.getTrustVal());
			
			this.recSet.addRecommendation(target, facet, dimension, rec);
		}
	}
	
	
	/**
	 * 
	 */
	public void newRecommendation(String observer, Facets facet,
			Dimensions dimension, Double value) {
		
		TrustIntention trustInt = this.levSet.reason(observer,
				Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
		
		if(trustInt.getTrustInt().value.booleanValue()) {
			trustInt = this.levSet.reason(observer, facet, Dimensions.COMPETENCE,
					this.repSet);
			
			Recommendation rec = new Recommendation(value, trustInt.getTrustVal());
			
			String[] debtors = this.repSet.getDebtors();
			for(String target : debtors) {
				this.recSet.addRecommendation(target, facet, dimension, rec);
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void punishmentProcess() {
		this.sPolSet.punishment(this.repSet);
		
		this.recSet.punishement(this.repSet, this.levSet);
	}
	
	
	/**
	 * 
	 */
	public TrustIntention reasoningProcess(String target, Facets facet,
			Dimensions dimension) {
		
		return this.levSet.reason(target, facet, dimension, this.repSet);
	}
	
	
	/**
	 * 
	 */
	public List<String> sortTarget(List<String> targets, String facet,
			String dimension, Boolean ascending) {
		
		List<String> newTargets = new ArrayList<String>(targets);
		
		Comparator<String> comparator = new LIARComparator(this,
				Facets.getFacet(facet), Dimensions.getDimension(dimension));
		
		if(!ascending) {
			comparator = Collections.reverseOrder(comparator);
		}
		
		Collections.shuffle(newTargets);
		Collections.sort(newTargets, comparator);
		
		return newTargets;
	}
}


class LIARComparator implements Comparator<String> {
	
	LIARModule	liar;
	
	Facets			facet;
	
	Dimensions	dimension;
	
	
	/**
	 * 
	 */
	public LIARComparator(LIARModule liar, Facets facet, Dimensions dimension) {
		this.liar = liar;
		this.facet = facet;
		this.dimension = dimension;
	}
	
	
	public final int compare(String target1, String target2) {
		TrustIntention value1 = this.liar.reasoningProcess(target1, this.facet,
				this.dimension);
		
		TrustIntention value2 = this.liar.reasoningProcess(target2, this.facet,
				this.dimension);
		
		// target1 and target2 TRUSTFULL
		if((value1.getTrustInt().value) && (value2.getTrustInt().value)) {
			
			return(value1.getTrustVal().doubleValue() < value2.getTrustVal()
					.doubleValue() ? -1 : (value1.getTrustVal().doubleValue() > value2
					.getTrustVal().doubleValue() ? +1 : 0));
			
			// target1 TRUSTFULL
		} else if(value1.getTrustInt().value) {
			return +1;
			
			// target2 TRUSTFULL
		} else if(value2.getTrustInt().value) {
			return -1;
			
			// target1 and target2 DISTRUSTFULL
		} else {
			return 0;
		}
	}
}