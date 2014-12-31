package test;

import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import otservices.translator.language.sparql.Filter;
import otservices.translator.language.sparql.LogExpr;
import otservices.translator.language.sparql.RegExpr;
import otservices.translator.language.sparql.RelExpr;
import otservices.translator.language.sparql.Result;
import otservices.translator.language.sparql.SPARQLObject;
import otservices.translator.language.sparql.Term;
import otservices.translator.language.sparql.Where;
import otservices.translator.reputationreasoner.impl.liar.LIARReputationReasoner;
import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.LIARModule;
import reputationreasoners.liar.condition.TrueCondition;
import reputationreasoners.liar.content.ARTContent;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.reputation.Reputation;
import reputationreasoners.liar.reputation.ReputationValue;
import reputationreasoners.liar.socialnorm.ARTSNorm;
import reputationreasoners.liar.socialnorm.SNorm;
import reputationreasoners.liar.socialnorm.SNormSet;
import reputationreasoners.liar.trustintention.Lev;
import reputationreasoners.liar.trustintention.LevSet;
import reputationreasoners.liar.trustintention.TrustIntention;

<<<<<<< HEAD
public class LIARRRTest {
	
	public static void main(String[] args) {
		SPARQLObject sparql;
		
		LIARReputationReasoner rri = new LIARReputationReasoner();
		rri.setID("A");
		
		LIARModule liarModule = rri.getReputationReasoner();
		
		liarModule.setLevSet(initLevSet());
		liarModule.setSNormSet(initSNormSet());
		
		ReputationValue[] rep = liarModule.getReputationSet().getReputationByDeb(
				"A", Dimensions.INTEGRITY, Reputation.RepType.DIbRp);
		if(rep == null) {
			System.out.println("NULL");
		} else {
			System.out.println(rep[0].getValue());
		}
		
		liarModule.getReputationSet().setReputation("C", Facets.RECOMMENDATION,
				Dimensions.INTEGRITY, Reputation.RepType.DIbRp,
				new ReputationValue(new Double(1), new Integer(1)));
		
		liarModule.getReputationSet().setReputation("C", Facets.ERA1,
				Dimensions.COMPETENCE, Reputation.RepType.DIbRp,
				new ReputationValue(new Double(1), new Integer(1)));
		
		String debtor = "D";
		String creditor = "A";
		
		Content content;
		
=======
public class LIARRRTest{

	public static void main(String[] args){
		SPARQLObject sparql;

		LIARReputationReasoner rri = new LIARReputationReasoner();
		rri.setID("A");

		LIARModule liarModule = rri.getReputationReasoner();

		liarModule.setLevSet(initLevSet());
		liarModule.setSNormSet(initSNormSet());

		ReputationValue[] rep = liarModule.getReputationSet()
				.getReputationByDeb("A", Dimensions.INTEGRITY,
						Reputation.RepType.DIbRp);
		if(rep == null){
			System.out.println("NULL");
		}else{
			System.out.println(rep[0].getValue());
		}

		liarModule.getReputationSet().setReputation("C", Facets.RECOMMENDATION,
				Dimensions.INTEGRITY, Reputation.RepType.DIbRp,
				new ReputationValue(new Double(1), new Integer(1)));

		liarModule.getReputationSet().setReputation("C", Facets.ERA1,
				Dimensions.COMPETENCE, Reputation.RepType.DIbRp,
				new ReputationValue(new Double(1), new Integer(1)));

		String debtor = "D";
		String creditor = "A";

		Content content;

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		// Simulation parameters
		float lies = new Double(Math.random()).floatValue() * 100;
		int numInt = 10000;
		int lie = Math.round(numInt / lies);
		System.out.println(numInt + " / " + lies + " = " + lie);
		Double value;
<<<<<<< HEAD
		for(int i = 0; i < numInt; i++) {
			
			if(i == lie) {
				content = new ARTContent(new Double(Math.rint(Math.random() * 1000)),
						new Double(Math.rint(Math.random() * 1000)));
				lie = lie + Math.round(numInt / lies);
			} else {
				value = new Double(Math.rint(Math.random() * 1000));
				content = new ARTContent(value, value);
			}
			
			liarModule.newInteraction(debtor, creditor, new TrueCondition(), content,
					Facets.ERA1, new Long(System.currentTimeMillis()));
			
			if(i < 100) {
				liarModule.newInteraction(debtor, creditor, new TrueCondition(),
						content, Facets.ERA1, new Long(System.currentTimeMillis()));
			}
			
=======
		for(int i = 0; i < numInt; i++){

			if(i == lie){
				content = new ARTContent(new Double(Math
						.rint(Math.random() * 1000)), new Double(Math.rint(Math
						.random() * 1000)));
				lie = lie + Math.round(numInt / lies);
			}else{
				value = new Double(Math.rint(Math.random() * 1000));
				content = new ARTContent(value, value);
			}

			liarModule.newInteraction(debtor, creditor, new TrueCondition(),
					content, Facets.ERA1, new Long(System.currentTimeMillis()));

			if(i < 100){
				liarModule.newInteraction(debtor, creditor,
						new TrueCondition(), content, Facets.ERA1, new Long(
								System.currentTimeMillis()));
			}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			liarModule.newRecommendation("C", "D", Facets.ERA1,
					Dimensions.COMPETENCE, new Double(Math.random()));
		}
		liarModule.punishmentProcess();
<<<<<<< HEAD
		
		TrustIntention trustInt = liarModule.reasoningProcess("D", Facets.ERA1,
				Dimensions.COMPETENCE);
		
		if(trustInt.getTrustInt().value.booleanValue()) {
			System.out.println("Believe = " + trustInt.getTrustVal().toString());
		} else {
			System.out.println("Do NOT Believe = "
					+ trustInt.getTrustVal().toString());
		}
		
		sparql = setUpdateSPARQLObject("-0.7");
		System.out.println(sparql.getMessage());
		
		for(int i = 0; i < 100; i++) {
=======

		TrustIntention trustInt = liarModule.reasoningProcess("D", Facets.ERA1,
				Dimensions.COMPETENCE);

		if(trustInt.getTrustInt().value.booleanValue()){
			System.out
					.println("Believe = " + trustInt.getTrustVal().toString());
		}else{
			System.out.println("Do NOT Believe = "
					+ trustInt.getTrustVal().toString());
		}

		sparql = setUpdateSPARQLObject("-0.7");
		System.out.println(sparql.getMessage());

		for(int i = 0; i < 100; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			sparql = setUpdateSPARQLObject("-0.7");
			rri.processInMessage(sparql);
			sparql = setUpdateSPARQLObject("0.1");
			rri.processInMessage(sparql);
		}
<<<<<<< HEAD
		
		// liarModule.getReputationSet().print();
		
		sparql = setSelectSPARQLObject();
		System.out.println(sparql.getMessage());
		rri.processInMessage(sparql);
		
		sparql.print();
	}
	
	
	private static SPARQLObject setSelectSPARQLObject() {
		SPARQLObject sparql = new SPARQLObject();
		
		sparql.setCommand(SPARQLObject.Command.SELECT);
		
		Result result = new Result();
		Where where = new Where();
		Filter filter = new Filter();
		
=======

		// liarModule.getReputationSet().print();

		sparql = setSelectSPARQLObject();
		System.out.println(sparql.getMessage());
		rri.processInMessage(sparql);

		sparql.print();
	}

	private static SPARQLObject setSelectSPARQLObject(){
		SPARQLObject sparql = new SPARQLObject();

		sparql.setCommand(SPARQLObject.Command.SELECT);

		Result result = new Result();
		Where where = new Where();
		Filter filter = new Filter();

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		LogExpr logical1 = new LogExpr();
		LogExpr logical2 = new LogExpr();
		LogExpr logical3 = new LogExpr();
		RegExpr regcontext = new RegExpr();
		RegExpr regname = new RegExpr();
		RelExpr relational1 = new RelExpr();
		RelExpr relational2 = new RelExpr();
<<<<<<< HEAD
		
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Term term1 = new Term();
		Term term2 = new Term();
		Term term3 = new Term();
		Term term4 = new Term();
<<<<<<< HEAD
		
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		result.addResult("?value");
		result.addResult("?drep1");
		result.addResult("?drep2");
		result.addResult("?context");
		result.addResult("?name");
		sparql.addResult(result);
<<<<<<< HEAD
		
		where.addWhere("?drep1", "reputationrecommendationbasedreputationbyliar");
=======

		where.addWhere("?drep1",
				"reputationrecommendationbasedreputationbyliar");
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		where.addWhere("?drep2", "directinteractionbasedreputationbyliar");
		where.addWhere("?context", "facetbyliar");
		where.addWhere("?name", "agentname");
		where.addWhere("?value", "reputationvaluebyliar");
		sparql.addWhere(where);
<<<<<<< HEAD
		
		// regname.setVariable("?name");
		// regname.setPattern("D");
		
		regcontext.setVariable("?context");
		regcontext.setPattern("era1");
		
		term1.setPosition(Term.Position.FIRST);
		term1.setType(Term.TermType.VARIABLE);
		term1.setTerm(new String("?drep1"));
		
		term2.setPosition(Term.Position.SECOND);
		term2.setType(Term.TermType.BOOLEAN);
		term2.setTerm(new Boolean(true));
		
		relational1.setTerm1(term1);
		relational1.setTerm2(term2);
		relational1.setRelationalOp(RelExpr.RelationalOp.EQ);
		
		term3.setPosition(Term.Position.FIRST);
		term3.setType(Term.TermType.VARIABLE);
		term3.setTerm(new String("?drep2"));
		
		term4.setPosition(Term.Position.SECOND);
		term4.setType(Term.TermType.BOOLEAN);
		term4.setTerm(new Boolean(true));
		
		relational2.setTerm1(term3);
		relational2.setTerm2(term4);
		relational2.setRelationalOp(RelExpr.RelationalOp.EQ);
		
		// logical1.setLogicalOp(LogExpr.LogicalOp.AND);
		// logical1.addExpression(regname);
		// logical1.addExpression(regcontext);
		
		logical2.setLogicalOp(LogExpr.LogicalOp.AND);
		logical2.addExpression(regcontext);
		logical2.addExpression(relational1);
		
		logical3.setLogicalOp(LogExpr.LogicalOp.AND);
		logical3.addExpression(relational1);
		logical3.addExpression(relational2);
		
=======

		// regname.setVariable("?name");
		// regname.setPattern("D");

		regcontext.setVariable("?context");
		regcontext.setPattern("era1");

		term1.setPosition(Term.Position.FIRST);
		term1.setType(Term.TermType.VARIABLE);
		term1.setTerm(new String("?drep1"));

		term2.setPosition(Term.Position.SECOND);
		term2.setType(Term.TermType.BOOLEAN);
		term2.setTerm(new Boolean(true));

		relational1.setTerm1(term1);
		relational1.setTerm2(term2);
		relational1.setRelationalOp(RelExpr.RelationalOp.EQ);

		term3.setPosition(Term.Position.FIRST);
		term3.setType(Term.TermType.VARIABLE);
		term3.setTerm(new String("?drep2"));

		term4.setPosition(Term.Position.SECOND);
		term4.setType(Term.TermType.BOOLEAN);
		term4.setTerm(new Boolean(true));

		relational2.setTerm1(term3);
		relational2.setTerm2(term4);
		relational2.setRelationalOp(RelExpr.RelationalOp.EQ);

		// logical1.setLogicalOp(LogExpr.LogicalOp.AND);
		// logical1.addExpression(regname);
		// logical1.addExpression(regcontext);

		logical2.setLogicalOp(LogExpr.LogicalOp.AND);
		logical2.addExpression(regcontext);
		logical2.addExpression(relational1);

		logical3.setLogicalOp(LogExpr.LogicalOp.AND);
		logical3.addExpression(relational1);
		logical3.addExpression(relational2);

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		// filter.addItem(regname);
		filter.addItem(regcontext);
		// filter.addItem(logical1);
		filter.addItem(term1);
		filter.addItem(term2);
		filter.addItem(relational1);
		filter.addItem(logical2);
		filter.addItem(term3);
		filter.addItem(term4);
		filter.addItem(relational2);
		filter.addItem(logical3);
		sparql.addFilter(filter);
<<<<<<< HEAD
		
		return sparql;
	}
	
	
	private static SPARQLObject setUpdateSPARQLObject(String value) {
		SPARQLObject sparql = new SPARQLObject();
		
		sparql.setCommand(SPARQLObject.Command.UPDATE);
		sparql.setSender("C");
		
		Result result = new Result();
		Where where = new Where();
		Filter filter = new Filter();
		
=======

		return sparql;
	}

	private static SPARQLObject setUpdateSPARQLObject(String value){
		SPARQLObject sparql = new SPARQLObject();

		sparql.setCommand(SPARQLObject.Command.UPDATE);
		sparql.setSender("C");

		Result result = new Result();
		Where where = new Where();
		Filter filter = new Filter();

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		LogExpr logical1 = new LogExpr();
		LogExpr logical2 = new LogExpr();
		RegExpr regcontext = new RegExpr();
		RegExpr regname = new RegExpr();
		RelExpr relational = new RelExpr();
<<<<<<< HEAD
		
		Term term = new Term();
		Term term1 = new Term();
		Term term2 = new Term();
		
=======

		Term term = new Term();
		Term term1 = new Term();
		Term term2 = new Term();

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		term.setType(Term.TermType.STRING);
		term.setTerm(value);
		result.addResult("?value", term);
		sparql.addResult(result);
<<<<<<< HEAD
		
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		where.addWhere("?drep", "directreputationbasedreputationbyliar");
		where.addWhere("?context", "facetbyliar");
		where.addWhere("?name", "agentname");
		where.addWhere("?value", "reputationvaluebyliar");
		sparql.addWhere(where);
<<<<<<< HEAD
		
		regname.setVariable("?name");
		regname.setPattern("D");
		
		regcontext.setVariable("?context");
		regcontext.setPattern("era1");
		
		term1.setPosition(Term.Position.FIRST);
		term1.setType(Term.TermType.VARIABLE);
		term1.setTerm(new String("?drep"));
		
		term2.setPosition(Term.Position.SECOND);
		term2.setType(Term.TermType.BOOLEAN);
		term2.setTerm(new Boolean(true));
		
		relational.setTerm1(term1);
		relational.setTerm2(term2);
		relational.setRelationalOp(RelExpr.RelationalOp.EQ);
		
		logical1.setLogicalOp(LogExpr.LogicalOp.AND);
		logical1.addExpression(regname);
		logical1.addExpression(regcontext);
		
		logical2.setLogicalOp(LogExpr.LogicalOp.AND);
		logical2.addExpression(logical1);
		logical2.addExpression(relational);
		
=======

		regname.setVariable("?name");
		regname.setPattern("D");

		regcontext.setVariable("?context");
		regcontext.setPattern("era1");

		term1.setPosition(Term.Position.FIRST);
		term1.setType(Term.TermType.VARIABLE);
		term1.setTerm(new String("?drep"));

		term2.setPosition(Term.Position.SECOND);
		term2.setType(Term.TermType.BOOLEAN);
		term2.setTerm(new Boolean(true));

		relational.setTerm1(term1);
		relational.setTerm2(term2);
		relational.setRelationalOp(RelExpr.RelationalOp.EQ);

		logical1.setLogicalOp(LogExpr.LogicalOp.AND);
		logical1.addExpression(regname);
		logical1.addExpression(regcontext);

		logical2.setLogicalOp(LogExpr.LogicalOp.AND);
		logical2.addExpression(logical1);
		logical2.addExpression(relational);

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		filter.addItem(regname);
		filter.addItem(regcontext);
		filter.addItem(logical1);
		filter.addItem(term1);
		filter.addItem(term2);
		filter.addItem(relational);
		filter.addItem(logical2);
		sparql.addFilter(filter);
<<<<<<< HEAD
		
		return sparql;
	}
	
	
	/**
	 * 
	 */
	public static SNormSet initSNormSet() {
=======

		return sparql;
	}

	/**
	 * 
	 */
	public static SNormSet initSNormSet(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		List<String> targets = new ArrayList<String>();
		List<String> evaluators = new ArrayList<String>();
		List<String> punishers = new ArrayList<String>();
		Content content = new ARTContent(new Double(0), new Double(0));
<<<<<<< HEAD
		
		ARTSNorm sNorm = new ARTSNorm(SNorm.OperatorType.O, targets, evaluators,
				punishers, new TrueCondition(), content, SNorm.States.ACTIVE);
		
		SNormSet sNormSet = new SNormSet();
		sNormSet.addNorm(sNorm);
		
		return sNormSet;
	}
	
	
	/**
	 * 
	 */
	public static LevSet initLevSet() {
		LevSet levSet = new LevSet();
		levSet.setGDtT(TrustIntention.TrustType.TRUST);
		
		Lev lev;
		
		// DIbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(10));
		levSet.setLev(Reputation.RepType.DIbRp, lev);
		
		// IIbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(7));
		levSet.setLev(Reputation.RepType.IIbRp, lev);
		
		// ObsRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(0));
		levSet.setLev(Reputation.RepType.ObsRcbRp, lev);
		
		// EvRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(0));
		levSet.setLev(Reputation.RepType.EvRcbRp, lev);
		
		// RepRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(5));
		levSet.setLev(Reputation.RepType.RpRcbRp, lev);
		
=======

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
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(10));
		levSet.setLev(Reputation.RepType.DIbRp, lev);

		// IIbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(7));
		levSet.setLev(Reputation.RepType.IIbRp, lev);

		// ObsRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(0));
		levSet.setLev(Reputation.RepType.ObsRcbRp, lev);

		// EvRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(0));
		levSet.setLev(Reputation.RepType.EvRcbRp, lev);

		// RepRcbRp Lev
		lev = new Lev(new Double(0.8), new Double(0.5), new Integer(5));
		levSet.setLev(Reputation.RepType.RpRcbRp, lev);

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return levSet;
	}
}