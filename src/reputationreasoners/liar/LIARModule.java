package reputationreasoners.liar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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

<<<<<<< HEAD
public class LIARModule {
=======
public class LIARModule{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	private String						id;
	
	private RecommendationSet	recSet;
	
	private ReputationSet			repSet;
	
	private SNormSet					sNormSet;
	
	private SPolSet						sPolSet;
	
	private LevSet						levSet;
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public LIARModule(String id) {
=======
	public LIARModule(String id){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.id = id;
		this.recSet = new RecommendationSet();
		this.repSet = new ReputationSet(new Weight());
		this.sNormSet = new SNormSet();
		this.sPolSet = new SPolSet();
		this.levSet = new LevSet();
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public LIARModule(String id, SNormSet sNormSet, LevSet levSet) {
=======

	/**
	 * 
	 */
	public LIARModule(String id, SNormSet sNormSet, LevSet levSet){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		this.id = id;
		this.recSet = new RecommendationSet();
		this.repSet = new ReputationSet(new Weight());
		
<<<<<<< HEAD
		if(sNormSet == null) {
			this.sNormSet = new SNormSet();
		} else {
=======
		if (sNormSet == null){
			this.sNormSet = new SNormSet();
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.sNormSet = sNormSet;
		}
		this.sPolSet = new SPolSet();
		
<<<<<<< HEAD
		if(levSet == null) {
			this.levSet = new LevSet();
		} else {
=======
		if (levSet == null){
			this.levSet = new LevSet();
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.levSet = levSet;
		}
	}
	
<<<<<<< HEAD
	
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
=======

	/**
	 * 
	 */
	public String getID(){
		return this.id;
	}
	

	/**
	 * 
	 */
	public RecommendationSet getRecommendationSet(){
		return this.recSet;
	}
	

	/**
	 * 
	 */
	public ReputationSet getReputationSet(){
		return this.repSet;
	}
	

	/**
	 * 
	 */
	public SNormSet getSNormSet(){
		return this.sNormSet;
	}
	

	/**
	 * 
	 */
	public SPolSet getSPolSet(){
		return this.sPolSet;
	}
	

	/**
	 * 
	 */
	public LevSet getLevSet(){
		return this.levSet;
	}
	

	/**
	 * 
	 */
	public void setID(String id){
		if (id != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.id = id;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void setSNormSet(SNormSet sNormSet) {
		if(sNormSet != null) {
=======

	/**
	 * 
	 */
	public void setSNormSet(SNormSet sNormSet){
		if (sNormSet != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.sNormSet = sNormSet;
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void setLevSet(LevSet levSet) {
		if(levSet != null) {
=======

	/**
	 * 
	 */
	public void setLevSet(LevSet levSet){
		if (levSet != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.levSet = levSet;
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void newInteraction(String debtor, String creditor,
<<<<<<< HEAD
			Condition condition, Content content, Facets facet, Long timeEmission) {
=======
			Condition condition, Content content, Facets facet, Long timeEmission){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		// Create the Social Commitment
		SCom sCom = new SCom(this.id, debtor, creditor, condition, content, facet,
				States.ACTIVE, timeEmission);
		
		// Evaluate the Social Commitment against all the possible Social Norms
		List<SPol> sPolList = this.sNormSet.evaluation(sCom);
		
		// Update the Social Policy Sets
<<<<<<< HEAD
		if(sPolList.size() > 0) {
			for(SPol sPol : sPolList) {
				if(sPol != null) {
=======
		if (sPolList.size() > 0){
			for(SPol sPol : sPolList){
				if (sPol != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					this.sPolSet.addSPol(sPol);
				}
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void newObservation(SCom sCom) {
		if(sCom != null) {
=======

	/**
	 * 
	 */
	public void newObservation(SCom sCom){
		if (sCom != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			// Evaluate the Social Commitment against all the possible
			// Social Norms
			List<SPol> sPolList = this.sNormSet.evaluation(sCom);
			
			// Update the Social Policy Sets
<<<<<<< HEAD
			if(sPolList.size() > 0) {
				TrustIntention trustInt;
				for(SPol sPol : sPolList) {
					if(sPol != null) {
						trustInt = this.levSet.reason(sCom.getObserver(),
								Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
						
						if(trustInt.getTrustInt().value.booleanValue()) {
=======
			if (sPolList.size() > 0){
				TrustIntention trustInt;
				for(SPol sPol : sPolList){
					if (sPol != null){
						trustInt = this.levSet.reason(sCom.getObserver(),
								Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
						
						if (trustInt.getTrustInt().value.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							this.sPolSet.addSPol(sPol);
						}
					}
				}
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void newEvaluation(SPol sPol) {
		if(sPol != null) {
			TrustIntention trustInt = this.levSet.reason(sPol.getObserver(),
					Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
			
			if(trustInt.getTrustInt().value.booleanValue()) {
=======

	/**
	 * 
	 */
	public void newEvaluation(SPol sPol){
		if (sPol != null){
			TrustIntention trustInt = this.levSet.reason(sPol.getObserver(),
					Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
			
			if (trustInt.getTrustInt().value.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				
				this.sPolSet.addSPol(sPol);
			}
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void newRecommendation(String observer, String target, Facets facet,
<<<<<<< HEAD
			Dimensions dimension, Double value) {
=======
			Dimensions dimension, Double value){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		TrustIntention trustInt = this.levSet.reason(observer,
				Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
		
<<<<<<< HEAD
		if(trustInt.getTrustInt().value.booleanValue()) {
=======
		if (trustInt.getTrustInt().value.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			trustInt = this.levSet.reason(observer, facet, Dimensions.COMPETENCE,
					this.repSet);
			
			Recommendation rec = new Recommendation(value, trustInt.getTrustVal());
			
			this.recSet.addRecommendation(target, facet, dimension, rec);
		}
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void newRecommendation(String observer, Facets facet,
<<<<<<< HEAD
			Dimensions dimension, Double value) {
=======
			Dimensions dimension, Double value){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		TrustIntention trustInt = this.levSet.reason(observer,
				Facets.RECOMMENDATION, Dimensions.INTEGRITY, this.repSet);
		
<<<<<<< HEAD
		if(trustInt.getTrustInt().value.booleanValue()) {
=======
		if (trustInt.getTrustInt().value.booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			trustInt = this.levSet.reason(observer, facet, Dimensions.COMPETENCE,
					this.repSet);
			
			Recommendation rec = new Recommendation(value, trustInt.getTrustVal());
			
			String[] debtors = this.repSet.getDebtors();
<<<<<<< HEAD
			for(String target : debtors) {
=======
			for(String target : debtors){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				this.recSet.addRecommendation(target, facet, dimension, rec);
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void punishmentProcess() {
=======

	/**
	 * 
	 */
	public void punishmentProcess(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.sPolSet.punishment(this.repSet);
		
		this.recSet.punishement(this.repSet, this.levSet);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public TrustIntention reasoningProcess(String target, Facets facet,
<<<<<<< HEAD
			Dimensions dimension) {
=======
			Dimensions dimension){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		return this.levSet.reason(target, facet, dimension, this.repSet);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public List<String> sortTarget(List<String> targets, String facet,
<<<<<<< HEAD
			String dimension, Boolean ascending) {
		
		List<String> newTargets = new ArrayList<String>(targets);
		
		Comparator<String> comparator = new LIARComparator(this,
				Facets.getFacet(facet), Dimensions.getDimension(dimension));
		
		if(!ascending) {
=======
			String dimension, Boolean ascending){
		
		List<String> newTargets = new ArrayList<String>(targets);
		
		Comparator<String> comparator = new LIARComparator(this, Facets
				.getFacet(facet), Dimensions.getDimension(dimension));
		
		if (!ascending){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			comparator = Collections.reverseOrder(comparator);
		}
		
		Collections.shuffle(newTargets);
		Collections.sort(newTargets, comparator);
		
		return newTargets;
	}
}


<<<<<<< HEAD
class LIARComparator implements Comparator<String> {
=======
class LIARComparator implements Comparator<String>{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	LIARModule	liar;
	
	Facets			facet;
	
	Dimensions	dimension;
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public LIARComparator(LIARModule liar, Facets facet, Dimensions dimension) {
=======
	public LIARComparator(LIARModule liar, Facets facet, Dimensions dimension){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.liar = liar;
		this.facet = facet;
		this.dimension = dimension;
	}
	
<<<<<<< HEAD
	
	public final int compare(String target1, String target2) {
=======

	public final int compare(String target1, String target2){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		TrustIntention value1 = this.liar.reasoningProcess(target1, this.facet,
				this.dimension);
		
		TrustIntention value2 = this.liar.reasoningProcess(target2, this.facet,
				this.dimension);
		
		// target1 and target2 TRUSTFULL
<<<<<<< HEAD
		if((value1.getTrustInt().value) && (value2.getTrustInt().value)) {
=======
		if ((value1.getTrustInt().value) && (value2.getTrustInt().value)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			return(value1.getTrustVal().doubleValue() < value2.getTrustVal()
					.doubleValue() ? -1 : (value1.getTrustVal().doubleValue() > value2
					.getTrustVal().doubleValue() ? +1 : 0));
			
			// target1 TRUSTFULL
<<<<<<< HEAD
		} else if(value1.getTrustInt().value) {
			return +1;
			
			// target2 TRUSTFULL
		} else if(value2.getTrustInt().value) {
			return -1;
			
			// target1 and target2 DISTRUSTFULL
		} else {
=======
		}else if (value1.getTrustInt().value){
			return +1;
			
			// target2 TRUSTFULL
		}else if (value2.getTrustInt().value){
			return -1;
			
			// target1 and target2 DISTRUSTFULL
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return 0;
		}
	}
}