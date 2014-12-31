package reputationreasoners.liar.reputation;

<<<<<<< HEAD
public class ReputationValue {
	
	// Fake value to represent UNKNOWN
	public static final Double	UNKNOWN	= new Double(-10000);
	
	private Double							value;
	
	private Integer							reliability;
	
	
	/**
	 * 
	 */
	public ReputationValue(Double value, Integer reliability) {
		this.reliability = reliability;
		if(reliability < 0) {
			this.value = UNKNOWN;
		} else {
			this.value = Math.min(1.0, Math.max(-1.0, value));
		}
	}
	
	
	public Double getValue() {
		return value;
	}
	
	
	public Integer getReliability() {
=======
public class ReputationValue{

	// Fake value to represent UNKNOWN
	public static final Double	UNKNOWN	= new Double(-10000);

	private Double				value;
	private Integer				reliability;

	/**
	 * 
	 */
	public ReputationValue(Double value, Integer reliability){
		this.reliability = reliability;
		if(reliability < 0){
			this.value = UNKNOWN;
		}else{
			this.value = Math.min(1.0, Math.max(-1.0, value));
		}
	}

	public Double getValue(){
		return value;
	}

	public Integer getReliability(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return reliability;
	}
}