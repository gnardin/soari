package reputationreasoners.liar.recommendation;

public class Recommendation{

	private Double	value;
	private Double	trustVal;

	/**
	 * 
	 */
	public Recommendation(Double value, Double trustVal){
		this.value = value;
		this.trustVal = trustVal;
	}

	/**
	 * 
	 */
	public Double getValue(){
		return this.value;
	}

	/**
	 * 
	 */
	public Double getTrustVal(){
		return this.trustVal;
	}
}