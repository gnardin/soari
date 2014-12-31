package reputationreasoners.liar.reputation;

<<<<<<< HEAD
public class Reputation {
	
	public enum RepType {
		DIbRp{
			
			public String toString() {
=======
public class Reputation{
	
	public enum RepType{
		DIbRp{
			
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "DirectInteractionBasedReputationByLIAR";
			}
		},
		IIbRp{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "IndirectInteractionBasedReputationByLIAR";
			}
		},
		ObsRcbRp{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "ObservationRecommendationBasedReputationByLIAR";
			}
		},
		EvRcbRp{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "EvaluationRecommendationBasedReputationByLIAR";
			}
		},
		RpRcbRp{
			
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "ReputationRecommendationBasedReputationByLIAR";
			}
		}
	}
	
	private ReputationValue[]	repValue;
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Reputation() {
		// Initializes the reputation type with UNKNOWN values
		this.repValue = new ReputationValue[RepType.values().length];
		for(int i = 0; i < RepType.values().length; i++) {
=======
	public Reputation(){
		// Initializes the reputation type with UNKNOWN values
		this.repValue = new ReputationValue[RepType.values().length];
		for(int i = 0; i < RepType.values().length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.repValue[i] = new ReputationValue(ReputationValue.UNKNOWN,
					new Integer(0));
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public ReputationValue get(RepType repType) {
		return this.repValue[repType.ordinal()];
	}
	
	
	/**
	 * 
	 */
	public void set(RepType repType, ReputationValue repValue) {
		this.repValue[repType.ordinal()] = repValue;
	}
	
	
	/**
	 * 
	 */
	public void print() {
		for(RepType repType : RepType.values()) {
=======

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
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			System.out.println(repType.toString() + " = "
					+ this.repValue[repType.ordinal()].getValue() + " , "
					+ this.repValue[repType.ordinal()].getReliability());
		}
	}
}