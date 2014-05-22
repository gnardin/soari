package reputationreasoners.liar.socialpolicy;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.reputation.ImpValue;
import reputationreasoners.liar.reputation.Reputation;
import reputationreasoners.liar.reputation.ReputationSet;
import reputationreasoners.liar.reputation.ReputationValue;
import reputationreasoners.liar.reputation.Weight;
import reputationreasoners.liar.socialpolicy.SPol;

public class SPolSet{

	public enum SPolSetType {
		DIbRpByFacet{
			public String toString(){
				return "Direct Interaction based Reputation by Facet";
			}
		},
		DIbRpByDeb{
			public String toString(){
				return "Direct Interaction based Reputation by Debitor";
			}
		},
		DIbRpByCred{
			public String toString(){
				return "Direct Interaction based Reputation by Creditor";
			}
		},
		IIbRpByFacet{
			public String toString(){
				return "Indirect Interaction based Reputation by Facet";
			}
		},
		IIbRpByDeb{
			public String toString(){
				return "Indirect Interaction based Reputation by Debitor";
			}
		},
		IIbRpByCred{
			public String toString(){
				return "Indirect Interaction based Reputation by Creditor";
			}
		},
		ObsRcbRpByFacet{
			public String toString(){
				return "Observation Recommendation based Reputation by Facet";
			}
		},
		ObsRcbRpByDeb{
			public String toString(){
				return "Observation Recommendation based Reputation by Debitor";
			}
		},
		ObsRcbRpByCred{
			public String toString(){
				return "Observation Recommendation based Reputation by Creditor";
			}
		},
		EvRcbRpByFacet{
			public String toString(){
				return "Evaluation Recommendation based Reputation by Facet";
			}
		},
		EvRcbRpByDeb{
			public String toString(){
				return "Evaluation Recommendation based Reputation by Debitor";
			}
		},
		EvRcbRpByCred{
			public String toString(){
				return "Evaluation Recommendation based Reputation by Creditor";
			}
		}
	};

	// used to compute DIbRps
	private Hashtable<Facets, Vector<SPol>>	DIbSPolSetByFacet;
	private Hashtable<String, Vector<SPol>>	DIbSPolSetByDeb;
	private Hashtable<String, Vector<SPol>>	DIbSPolSetByCred;
	private Boolean							addedDIb	= new Boolean(false);

	// used to compute IIbRps
	private Hashtable<Facets, Vector<SPol>>	IIbSPolSetByFacet;
	private Hashtable<String, Vector<SPol>>	IIbSPolSetByDeb;
	private Hashtable<String, Vector<SPol>>	IIbSPolSetByCred;
	private Boolean							addedIIb	= new Boolean(false);

	// used to compute ObsRcbRps
	private Hashtable<Facets, Vector<SPol>>	ObsRcbSPolSetByFacet;
	private Hashtable<String, Vector<SPol>>	ObsRcbSPolSetByDeb;
	private Hashtable<String, Vector<SPol>>	ObsRcbSPolSetByCred;
	private Boolean							addedObsRcb	= new Boolean(false);

	// used to compute EvRcbRps
	private Hashtable<Facets, Vector<SPol>>	EvRcbSPolSetByFacet;
	private Hashtable<String, Vector<SPol>>	EvRcbSPolSetByDeb;
	private Hashtable<String, Vector<SPol>>	EvRcbSPolSetByCred;
	private Boolean							addedEvRcb	= new Boolean(false);

	/**
	 * 
	 */
	public SPolSet(){
		DIbSPolSetByFacet = new Hashtable<Facets, Vector<SPol>>();
		DIbSPolSetByDeb = new Hashtable<String, Vector<SPol>>();
		DIbSPolSetByCred = new Hashtable<String, Vector<SPol>>();

		IIbSPolSetByFacet = new Hashtable<Facets, Vector<SPol>>();
		IIbSPolSetByDeb = new Hashtable<String, Vector<SPol>>();
		IIbSPolSetByCred = new Hashtable<String, Vector<SPol>>();
	}

	/**
	 * Add the SPol to the corresponding HashTables according to: 1. the
	 * observer 2. the facet 3. the fact it is DI/II
	 */
	public void addSPol(SPol sPol){
		if(sPol != null){
			Hashtable<Facets, Vector<SPol>> sPolSetByFacet = null;
			Hashtable<String, Vector<SPol>> sPolSetByDeb = null;
			Hashtable<String, Vector<SPol>> sPolSetByCred = null;

			String sPolObserver = sPol.getObserver();
			String sPolDebtor = sPol.getDebtor();
			String sPolCreditor = sPol.getCreditor();
			Facets sPolFacet = sPol.getFacet();

			// DIbRp
			if((sPolDebtor.equals(sPolObserver)) // Direct Interaction
					|| (sPolCreditor.equals(sPolObserver))){
				sPolSetByFacet = this.DIbSPolSetByFacet;
				sPolSetByDeb = this.DIbSPolSetByDeb;
				sPolSetByCred = this.DIbSPolSetByCred;

				this.addedDIb = new Boolean(true);

				// IIbRp
			}else if(!(sPolDebtor.equals(sPolObserver))
					&& !(sPolCreditor.equals(sPolObserver))){
				sPolSetByFacet = this.IIbSPolSetByFacet;
				sPolSetByDeb = this.IIbSPolSetByDeb;
				sPolSetByCred = this.IIbSPolSetByCred;

				this.addedIIb = new Boolean(true);
			}

			Vector<SPol> listSPolSameFacet = sPolSetByFacet.get(sPolFacet);
			if(listSPolSameFacet == null){
				listSPolSameFacet = new Vector<SPol>();
			}
			listSPolSameFacet.add(sPol);
			sPolSetByFacet.put(sPolFacet, listSPolSameFacet);

			Vector<SPol> listSPolSameDeb = sPolSetByDeb.get(sPolDebtor);
			if(listSPolSameDeb == null){
				listSPolSameDeb = new Vector<SPol>();
			}
			listSPolSameDeb.add(sPol);
			sPolSetByDeb.put(sPolDebtor, listSPolSameDeb);

			Vector<SPol> listSPolSameCred = sPolSetByCred.get(sPolCreditor);
			if(listSPolSameCred == null){
				listSPolSameCred = new Vector<SPol>();
			}
			listSPolSameCred.add(sPol);
			sPolSetByCred.put(sPolCreditor, listSPolSameCred);
		}
	}

	/**
	 * 
	 */
	public void ObsRcbSPol(SPol sPol){
		if(sPol != null){
			Hashtable<Facets, Vector<SPol>> sPolSetByFacet = this.ObsRcbSPolSetByFacet;
			Hashtable<String, Vector<SPol>> sPolSetByDeb = this.ObsRcbSPolSetByDeb;
			Hashtable<String, Vector<SPol>> sPolSetByCred = this.ObsRcbSPolSetByCred;

			this.addedObsRcb = new Boolean(true);

			String sPolDebtor = sPol.getDebtor();
			String sPolCreditor = sPol.getCreditor();
			Facets sPolFacet = sPol.getFacet();

			Vector<SPol> listSPolSameFacet = sPolSetByFacet.get(sPolFacet);
			if(listSPolSameFacet == null){
				listSPolSameFacet = new Vector<SPol>();
			}
			listSPolSameFacet.add(sPol);
			sPolSetByFacet.put(sPolFacet, listSPolSameFacet);

			Vector<SPol> listSPolSameDeb = sPolSetByDeb.get(sPolDebtor);
			if(listSPolSameDeb == null){
				listSPolSameDeb = new Vector<SPol>();
			}
			listSPolSameDeb.add(sPol);
			sPolSetByDeb.put(sPolDebtor, listSPolSameDeb);

			Vector<SPol> listSPolSameCred = sPolSetByCred.get(sPolCreditor);
			if(listSPolSameCred == null){
				listSPolSameCred = new Vector<SPol>();
			}
			listSPolSameCred.add(sPol);
			sPolSetByCred.put(sPolCreditor, listSPolSameCred);
		}
	}

	/**
	 * 
	 */
	public void EvRcbSPol(SPol sPol){
		if(sPol != null){
			Hashtable<Facets, Vector<SPol>> sPolSetByFacet = this.EvRcbSPolSetByFacet;
			Hashtable<String, Vector<SPol>> sPolSetByDeb = this.EvRcbSPolSetByDeb;
			Hashtable<String, Vector<SPol>> sPolSetByCred = this.EvRcbSPolSetByCred;

			this.addedEvRcb = new Boolean(true);

			String sPolDebtor = sPol.getDebtor();
			String sPolCreditor = sPol.getCreditor();
			Facets sPolFacet = sPol.getFacet();

			Vector<SPol> listSPolSameFacet = sPolSetByFacet.get(sPolFacet);
			if(listSPolSameFacet == null){
				listSPolSameFacet = new Vector<SPol>();
			}
			listSPolSameFacet.add(sPol);
			sPolSetByFacet.put(sPolFacet, listSPolSameFacet);

			Vector<SPol> listSPolSameDeb = sPolSetByDeb.get(sPolDebtor);
			if(listSPolSameDeb == null){
				listSPolSameDeb = new Vector<SPol>();
			}
			listSPolSameDeb.add(sPol);
			sPolSetByDeb.put(sPolDebtor, listSPolSameDeb);

			Vector<SPol> listSPolSameCred = sPolSetByCred.get(sPolCreditor);
			if(listSPolSameCred == null){
				listSPolSameCred = new Vector<SPol>();
			}
			listSPolSameCred.add(sPol);
			sPolSetByCred.put(sPolCreditor, listSPolSameCred);
		}
	}

	/**
	 *
	 */
	public Vector<SPol> getSPolByFacet(Reputation.RepType repType, Facets facet){
		Vector<SPol> result = new Vector<SPol>();

		Hashtable<Facets, Vector<SPol>> sPolByFacet = null;

		if(repType.name().equals(Reputation.RepType.DIbRp.name())){
			sPolByFacet = this.DIbSPolSetByFacet;
		}else if(repType.name().equals(Reputation.RepType.IIbRp.name())){
			sPolByFacet = this.IIbSPolSetByFacet;
		}else if(repType.name().equals(Reputation.RepType.ObsRcbRp.name())){
			sPolByFacet = this.ObsRcbSPolSetByFacet;
		}else if(repType.name().equals(Reputation.RepType.EvRcbRp.name())){
			sPolByFacet = this.EvRcbSPolSetByFacet;
		}

		if(!repType.name().equals(Reputation.RepType.RpRcbRp.name())){
			if(sPolByFacet.containsKey(facet)){
				result = sPolByFacet.get(facet);
			}
		}

		return result;
	}

	/**
	 * 
	 */
	public Vector<SPol> getSPolByState(Reputation.RepType repType,
			SPol.States state){
		Vector<SPol> result = new Vector<SPol>();

		Hashtable<String, Vector<SPol>> sPolByState = null;

		if(repType.name().equals(Reputation.RepType.DIbRp.name())){
			sPolByState = this.DIbSPolSetByCred;
		}else if(repType.name().equals(Reputation.RepType.IIbRp.name())){
			sPolByState = this.IIbSPolSetByCred;
		}else if(repType.name().equals(Reputation.RepType.ObsRcbRp.name())){
			sPolByState = this.ObsRcbSPolSetByCred;
		}else if(repType.name().equals(Reputation.RepType.EvRcbRp.name())){
			sPolByState = this.EvRcbSPolSetByCred;
		}

		if(!repType.name().equals(Reputation.RepType.RpRcbRp.name())){
			if(sPolByState != null){
				Vector<SPol> vSPol;
				for(Iterator<String> iVSPol = sPolByState.keySet().iterator(); iVSPol
						.hasNext();){
					vSPol = sPolByState.get(iVSPol.next());
					if(vSPol != null){
						for(SPol sPol : vSPol){
							if(sPol.getState().name().equals(state.name())){
								result.add(sPol);
							}
						}
					}
				}
			}
		}

		return result;
	}

	/**
	 * 
	 */
	public Vector<SPol> getSPolByDeb(Reputation.RepType repType, String debtor){
		Vector<SPol> result = new Vector<SPol>();

		Hashtable<String, Vector<SPol>> sPolByDeb = null;

		if(repType.name().equals(Reputation.RepType.DIbRp.name())){
			sPolByDeb = this.DIbSPolSetByDeb;
		}else if(repType.name().equals(Reputation.RepType.IIbRp.name())){
			sPolByDeb = this.IIbSPolSetByDeb;
		}else if(repType.name().equals(Reputation.RepType.ObsRcbRp.name())){
			sPolByDeb = this.ObsRcbSPolSetByDeb;
		}else if(repType.name().equals(Reputation.RepType.EvRcbRp.name())){
			sPolByDeb = this.EvRcbSPolSetByDeb;
		}

		if(!repType.name().equals(Reputation.RepType.RpRcbRp.name())){
			if(sPolByDeb.containsKey(debtor)){
				result = sPolByDeb.get(debtor);
			}
		}

		return result;
	}

	/**
	 * 
	 */
	public Vector<SPol> getSPolByCred(Reputation.RepType repType,
			String creditor){
		Vector<SPol> result = new Vector<SPol>();

		Hashtable<String, Vector<SPol>> sPolByCred = null;

		if(repType.name().equals(Reputation.RepType.DIbRp.name())){
			sPolByCred = this.DIbSPolSetByCred;
		}else if(repType.name().equals(Reputation.RepType.IIbRp.name())){
			sPolByCred = this.IIbSPolSetByCred;
		}else if(repType.name().equals(Reputation.RepType.ObsRcbRp.name())){
			sPolByCred = this.ObsRcbSPolSetByCred;
		}else if(repType.name().equals(Reputation.RepType.RpRcbRp.name())){
			sPolByCred = this.EvRcbSPolSetByCred;
		}

		if(!repType.name().equals(Reputation.RepType.RpRcbRp.name())){
			if(sPolByCred.containsKey(creditor)){
				result = sPolByCred.get(creditor);
			}
		}

		return result;
	}

	/**
	 * 
	 */
	private Map<String, ImpValue[]> Imp(Reputation.RepType repType,
			Facets facet, Dimensions dimension){
		Hashtable<String, ImpValue[]> result = new Hashtable<String, ImpValue[]>();
		Hashtable<String, Vector<SPol>> sPolSet = null;

		if(repType.name().equals(Reputation.RepType.DIbRp.name())){
			sPolSet = this.DIbSPolSetByDeb;
		}else if(repType.name().equals(Reputation.RepType.IIbRp.name())){
			sPolSet = this.IIbSPolSetByDeb;
		}else if(repType.name().equals(Reputation.RepType.ObsRcbRp.name())){
			sPolSet = this.ObsRcbSPolSetByDeb;
		}else if(repType.name().equals(Reputation.RepType.EvRcbRp.name())){
			sPolSet = this.EvRcbSPolSetByDeb;
		}

		if(sPolSet != null){
			String debtor;
			ImpValue[] value;
			Double[] sumOfPenalties;
			Integer[] numOfSPol;
			for(Iterator<String> iPolSet = sPolSet.keySet().iterator(); iPolSet
					.hasNext();){
				debtor = iPolSet.next();

				sumOfPenalties = new Double[SPol.States.values().length];
				numOfSPol = new Integer[SPol.States.values().length];
				for(int i = 0; i < SPol.States.values().length; i++){
					sumOfPenalties[i] = new Double(0);
					numOfSPol[i] = new Integer(0);
				}

				Vector<SPol> vSPol = sPolSet.get(debtor);
				if(vSPol != null){
					for(SPol sPol : vSPol){
						if(sPol != null){
							if((sPol.getFacet().name().equals(facet.name()))
									&& (sPol.getDimension().name()
											.equals(dimension.name()))){

								int sPolState = sPol.getState().ordinal();

								sumOfPenalties[sPolState] = new Double(
										sumOfPenalties[sPolState].doubleValue()
												+ sPol.punishes().doubleValue());

								numOfSPol[sPolState] = new Integer(
										numOfSPol[sPolState].intValue() + 1);
							}

						}
					}
				}

				// Initialize the value
				value = new ImpValue[SPol.States.values().length];
				for(int i = 0; i < SPol.States.values().length; i++){
					value[i] = new ImpValue(sumOfPenalties[i], numOfSPol[i]);
				}
				result.put(debtor, value);
			}
		}

		return result;
	}

	/**
	 * 
	 */
	public void punishment(ReputationSet repSet){
		if(this.addedDIb.booleanValue()){
			this.calculate(Reputation.RepType.DIbRp, repSet);
			this.addedDIb = new Boolean(false);
		}

		if(this.addedIIb.booleanValue()){
			this.calculate(Reputation.RepType.IIbRp, repSet);
			this.addedIIb = new Boolean(false);
		}

		if(this.addedObsRcb.booleanValue()){
			this.calculate(Reputation.RepType.ObsRcbRp, repSet);
			this.addedObsRcb = new Boolean(false);
		}

		if(this.addedEvRcb.booleanValue()){
			this.calculate(Reputation.RepType.EvRcbRp, repSet);
			this.addedEvRcb = new Boolean(false);
		}
	}

	/**
	 * 
	 */
	private void calculate(Reputation.RepType repType, ReputationSet repSet){
		Map<String, ImpValue[]> imp;
		String debtor;
		ImpValue[] impValue;
		Double nominator;
		Double denominator;
		Integer relevance;
		Weight weight = repSet.getWeight();
		ReputationValue value;

		for(Facets facet : Facets.values()){
			for(Dimensions dimension : Dimensions.values()){
				nominator = new Double(0);
				denominator = new Double(0);
				relevance = new Integer(0);

				imp = this.Imp(repType, facet, dimension);

				for(Iterator<String> debtors = imp.keySet().iterator(); debtors
						.hasNext();){
					debtor = debtors.next();
					impValue = imp.get(debtor);

					// FULFILLED
					nominator = weight.getWeight(repType,
							Weight.WeightType.FULFILLED)
							* impValue[SPol.States.FULFILLED.ordinal()]
									.getSumOfPenalties();

					denominator = Math.abs(weight.getWeight(repType,
							Weight.WeightType.FULFILLED).doubleValue())
							* impValue[SPol.States.FULFILLED.ordinal()]
									.getSumOfPenalties();

					// VIOLATED
					nominator = nominator
							+ weight.getWeight(repType,
									Weight.WeightType.VIOLATED)
							* impValue[SPol.States.VIOLATED.ordinal()]
									.getSumOfPenalties();

					denominator = denominator
							+ Math.abs(weight.getWeight(repType,
									Weight.WeightType.VIOLATED).doubleValue())
							* impValue[SPol.States.VIOLATED.ordinal()]
									.getSumOfPenalties();

					// CANCELED
					nominator = nominator
							+ weight.getWeight(repType,
									Weight.WeightType.CANCELLED)
							* impValue[SPol.States.CANCELLED.ordinal()]
									.getSumOfPenalties();

					denominator = denominator
							+ Math.abs(weight.getWeight(repType,
									Weight.WeightType.CANCELLED).doubleValue())
							* impValue[SPol.States.CANCELLED.ordinal()]
									.getSumOfPenalties();

					// Relevance
					relevance = impValue[SPol.States.FULFILLED.ordinal()]
							.getNumberOfSPol()
							+ impValue[SPol.States.VIOLATED.ordinal()]
									.getNumberOfSPol()
							+ impValue[SPol.States.CANCELLED.ordinal()]
									.getNumberOfSPol();

					// Calculate
					if(denominator != 0){
						value = new ReputationValue(new Double(nominator
								/ denominator), relevance);

						repSet.setReputation(debtor, facet, dimension, repType,
								value);
					}
				}
			}
		}
	}

	/**
	 * 
	 */
	public void print(SPolSetType type){

		if((type == SPolSetType.DIbRpByFacet)
				|| (type == SPolSetType.IIbRpByFacet)
				|| (type == SPolSetType.ObsRcbRpByFacet)
				|| (type == SPolSetType.EvRcbRpByFacet)){

			Hashtable<Facets, Vector<SPol>> sPolSet = null;
			if(type == SPolSetType.DIbRpByFacet){
				System.out.println("=== Social Policy Set DIb By Facet ===");
				sPolSet = this.DIbSPolSetByFacet;
			}else if(type == SPolSetType.IIbRpByFacet){
				System.out.println("=== Social Policy Set IIb By Facet ===");
				sPolSet = this.IIbSPolSetByFacet;
			}else if(type == SPolSetType.ObsRcbRpByFacet){
				System.out.println("=== Social Policy Set ObsRcb By Facet ===");
				sPolSet = this.ObsRcbSPolSetByFacet;
			}else if(type == SPolSetType.EvRcbRpByFacet){
				System.out.println("=== Social Policy Set EvRcb By Facet ===");
				sPolSet = this.EvRcbSPolSetByFacet;
			}

			Facets facet;
			Vector<SPol> vSPol;
			for(Iterator<Facets> iSPolSet = sPolSet.keySet().iterator(); iSPolSet
					.hasNext();){
				facet = iSPolSet.next();
				System.out.println("Facet = [" + facet + "]");
				vSPol = sPolSet.get(facet);
				for(SPol sPol : vSPol){
					sPol.print();
				}
			}
		}

		if((type == SPolSetType.DIbRpByDeb) || (type == SPolSetType.IIbRpByDeb)
				|| (type == SPolSetType.ObsRcbRpByDeb)
				|| (type == SPolSetType.EvRcbRpByDeb)){

			Hashtable<String, Vector<SPol>> sPolSet = null;
			if(type == SPolSetType.DIbRpByDeb){
				System.out.println("=== Social Policy Set DIb By Debitor ===");
				sPolSet = this.DIbSPolSetByDeb;
			}else if(type == SPolSetType.IIbRpByDeb){
				System.out.println("=== Social Policy Set IIb By Debitor ===");
				sPolSet = this.IIbSPolSetByDeb;
			}else if(type == SPolSetType.ObsRcbRpByDeb){
				System.out
						.println("=== Social Policy Set ObsRcb By Debitor ===");
				sPolSet = this.ObsRcbSPolSetByDeb;
			}else if(type == SPolSetType.EvRcbRpByDeb){
				System.out
						.println("=== Social Policy Set EvRcb By Debitor ===");
				sPolSet = this.EvRcbSPolSetByDeb;
			}

			String debtor;
			Vector<SPol> vSPol;
			for(Iterator<String> iSPolSet = sPolSet.keySet().iterator(); iSPolSet
					.hasNext();){
				debtor = iSPolSet.next();
				System.out.println("Debtor = [" + debtor + "]");
				vSPol = sPolSet.get(debtor);
				for(SPol sPol : vSPol){
					sPol.print();
				}
			}
		}

		if((type == SPolSetType.DIbRpByCred)
				|| (type == SPolSetType.IIbRpByCred)
				|| (type == SPolSetType.ObsRcbRpByCred)
				|| (type == SPolSetType.EvRcbRpByCred)){

			Hashtable<String, Vector<SPol>> sPolSet = null;
			if(type == SPolSetType.DIbRpByCred){
				System.out.println("=== Social Policy Set DIb By Creditor ===");
				sPolSet = this.DIbSPolSetByCred;
			}else if(type == SPolSetType.IIbRpByCred){
				System.out.println("=== Social Policy Set IIb By Creditor ===");
				sPolSet = this.IIbSPolSetByCred;
			}else if(type == SPolSetType.ObsRcbRpByCred){
				System.out
						.println("=== Social Policy Set ObsRcb By Creditor ===");
				sPolSet = this.ObsRcbSPolSetByCred;
			}else if(type == SPolSetType.EvRcbRpByCred){
				System.out
						.println("=== Social Policy Set EvRcb By Creditor ===");
				sPolSet = this.EvRcbSPolSetByCred;
			}

			String creditor;
			Vector<SPol> vSPol;
			for(Iterator<String> iSPolSet = sPolSet.keySet().iterator(); iSPolSet
					.hasNext();){
				creditor = iSPolSet.next();
				System.out.println("Creditor = [" + creditor + "]");
				vSPol = sPolSet.get(creditor);
				for(SPol sPol : vSPol){
					sPol.print();
				}
			}
		}
		System.out.println();
	}
}