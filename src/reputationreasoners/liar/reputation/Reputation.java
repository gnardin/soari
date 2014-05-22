package reputationreasoners.liar.reputation;

public class Reputation{
	
	public enum RepType{
		DIbRp{
			
			public String toString(){
				return "DirectInteractionBasedReputationByLIAR";
			}
		},
		IIbRp{
			
			public String toString(){
				return "IndirectInteractionBasedReputationByLIAR";
			}
		},
		ObsRcbRp{
			
			public String toString(){
				return "ObservationRecommendationBasedReputationByLIAR";
			}
		},
		EvRcbRp{
			
			public String toString(){
				return "EvaluationRecommendationBasedReputationByLIAR";
			}
		},
		RpRcbRp{
			
			public String toString(){
				return "ReputationRecommendationBasedReputationByLIAR";
			}
		}
	}
	
	private ReputationValue[]	repValue;
	
	
	/**
	 * 
	 */
	public Reputation(){
		// Initializes the reputation type with UNKNOWN values
		this.repValue = new ReputationValue[RepType.values().length];
		for(int i = 0; i < RepType.values().length; i++){
			this.repValue[i] = new ReputationValue(ReputationValue.UNKNOWN,
					new Integer(0));
		}
	}
	

	/**
	 * 
	 */
	public ReputationValue get(RepType repType){
		return this.repValue[repType.ordinal()];
	}
	

	/**
	 * 
	 */
	public void set(RepType repType, ReputationValue repValue){
		this.repValue[repType.ordinal()] = repValue;
	}
	

	/**
	 * 
	 */
	public void print(){
		for(RepType repType : RepType.values()){
			System.out.println(repType.toString() + " = "
					+ this.repValue[repType.ordinal()].getValue() + " , "
					+ this.repValue[repType.ordinal()].getReliability());
		}
	}
}