package test;

import java.util.ArrayList;
import java.util.List;

import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.LIARModule;
import reputationreasoners.liar.condition.TrueCondition;
import reputationreasoners.liar.content.ARTContent;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.reputation.Reputation;
import reputationreasoners.liar.reputation.ReputationValue;
import reputationreasoners.liar.reputation.Reputation.RepType;
import reputationreasoners.liar.socialnorm.ARTSNorm;
import reputationreasoners.liar.socialnorm.SNorm;
import reputationreasoners.liar.socialnorm.SNormSet;
import reputationreasoners.liar.trustintention.Lev;
import reputationreasoners.liar.trustintention.LevSet;
import reputationreasoners.liar.trustintention.TrustIntention;

public class LIARTest{

	public static void main(String[] args){
		LIARModule liar = new LIARModule("A");

		liar.setLevSet(initLevSet());
		liar.setSNormSet(initSNormSet());

		liar.getReputationSet().setReputation("B", Facets.ERA1,
				Dimensions.COMPETENCE, RepType.DIbRp,
				new ReputationValue(-0.1, 1));

		liar.getReputationSet().setReputation("C", Facets.ERA1,
				Dimensions.COMPETENCE, RepType.DIbRp,
				new ReputationValue(1.0, 1));

		liar.getReputationSet().setReputation("D", Facets.ERA1,
				Dimensions.COMPETENCE, RepType.DIbRp,
				new ReputationValue(0.75, 1));

		liar.getReputationSet().setReputation("E", Facets.ERA1,
				Dimensions.COMPETENCE, RepType.DIbRp,
				new ReputationValue(0.75, 1));

		List<String> targets = new ArrayList<String>();
		targets.add("B");
		targets.add("C");
		targets.add("D");
		targets.add("E");

		List<String> sorted = liar.sortTarget(targets, Facets.ERA1.toString(),
				Dimensions.COMPETENCE.toString(), false);

		for(String agent : sorted){
			System.out.println(agent);
		}
	}

	/**
	 * 
	 */
	public static SNormSet initSNormSet(){
		List<String> targets = new ArrayList<String>();
		List<String> evaluators = new ArrayList<String>();
		List<String> punishers = new ArrayList<String>();
		Content content = new ARTContent(new Double(0), new Double(0));

		ARTSNorm sNorm = new ARTSNorm(SNorm.OperatorType.O, targets,
				evaluators, punishers, new TrueCondition(), content,
				SNorm.States.ACTIVE);

		SNormSet sNormSet = new SNormSet();
		sNormSet.addNorm(sNorm);

		return sNormSet;
	}

	/**
	 * 
	 */
	public static LevSet initLevSet(){
		LevSet levSet = new LevSet();
		levSet.setGDtT(TrustIntention.TrustType.TRUST);

		Lev lev;

		// DIbRp Lev
		lev = new Lev(new Double(0.7), new Double(-0.3), new Integer(10));
		levSet.setLev(Reputation.RepType.DIbRp, lev);

		// IIbRp Lev
		lev = new Lev(new Double(0.7), new Double(-0.3), new Integer(7));
		levSet.setLev(Reputation.RepType.IIbRp, lev);

		// ObsRcbRp Lev
		lev = new Lev(new Double(0.7), new Double(-0.3), new Integer(0));
		levSet.setLev(Reputation.RepType.ObsRcbRp, lev);

		// EvRcbRp Lev
		lev = new Lev(new Double(0.7), new Double(-0.3), new Integer(0));
		levSet.setLev(Reputation.RepType.EvRcbRp, lev);

		// RepRcbRp Lev
		lev = new Lev(new Double(0.7), new Double(-0.3), new Integer(5));
		levSet.setLev(Reputation.RepType.RpRcbRp, lev);

		return levSet;
	}
}