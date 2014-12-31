package reputationreasoners.liar.recommendation;

<<<<<<< HEAD
public class Recommendation {
	
	private Double	value;
	
	private Double	trustVal;
	
	
	/**
	 * 
	 */
	public Recommendation(Double value, Double trustVal) {
		this.value = value;
		this.trustVal = trustVal;
	}
	
	
	/**
	 * 
	 */
	public Double getValue() {
		return this.value;
	}
	
	
	/**
	 * 
	 */
	public Double getTrustVal() {
=======
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
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.trustVal;
	}
}