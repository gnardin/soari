package reputationreasoners.liar.reputation;

<<<<<<< HEAD
public class Weight {
	
	public enum WeightType {
		FULFILLED(new Double(1)){
			
			public String toString() {
=======
import reputationreasoners.liar.reputation.Reputation;

public class Weight{

	public enum WeightType {
		FULFILLED(new Double(1)){
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "FULFILLED";
			}
		},
		VIOLATED(new Double(-1)){
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "VIOLATED";
			}
		},
		CANCELLED(new Double(0)){
<<<<<<< HEAD
			
			public String toString() {
				return "CANCELLED";
			}
		};
		
		private Double	value;
		
		
		// Constructor
		WeightType(Double value) {
			this.value = value;
		}
		
		
		public Double value() {
			return this.value;
		}
	};
	
	private Double[][]	sPolWeight;
	
	
	/**
	 * 
	 */
	public Weight() {
		sPolWeight = new Double[Reputation.RepType.values().length][WeightType
				.values().length];
		
		for(Reputation.RepType i : Reputation.RepType.values()) {
			for(WeightType j : WeightType.values()) {
=======
			public String toString(){
				return "CANCELLED";
			}
		};
		private Double	value;

		// Constructor
		WeightType(Double value){
			this.value = value;
		}

		public Double value(){
			return this.value;
		}
	};

	private Double[][]	sPolWeight;

	/**
	 * 
	 */
	public Weight(){
		sPolWeight = new Double[Reputation.RepType.values().length][WeightType
				.values().length];

		for(Reputation.RepType i : Reputation.RepType.values()){
			for(WeightType j : WeightType.values()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				this.sPolWeight[i.ordinal()][j.ordinal()] = j.value();
			}
		}
	}
<<<<<<< HEAD
	
	
	/**
	 * 
	 */
	public Weight(Double[][] sPolWeight) {
		if(sPolWeight != null) {
			for(Reputation.RepType i : Reputation.RepType.values()) {
				for(WeightType j : WeightType.values()) {
					this.sPolWeight[i.ordinal()][j.ordinal()] = sPolWeight[i.ordinal()][j
							.ordinal()];
				}
			}
		} else {
			sPolWeight = new Double[Reputation.RepType.values().length][WeightType
					.values().length];
			
			for(Reputation.RepType i : Reputation.RepType.values()) {
				for(WeightType j : WeightType.values()) {
=======

	/**
	 * 
	 */
	public Weight(Double[][] sPolWeight){
		if(sPolWeight != null){
			for(Reputation.RepType i : Reputation.RepType.values()){
				for(WeightType j : WeightType.values()){
					this.sPolWeight[i.ordinal()][j.ordinal()] = sPolWeight[i
							.ordinal()][j.ordinal()];
				}
			}
		}else{
			sPolWeight = new Double[Reputation.RepType.values().length][WeightType
					.values().length];

			for(Reputation.RepType i : Reputation.RepType.values()){
				for(WeightType j : WeightType.values()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					this.sPolWeight[i.ordinal()][j.ordinal()] = j.value();
				}
			}
		}
	}
<<<<<<< HEAD
	
	
	/**
	 * 
	 */
	public Double getWeight(Reputation.RepType repType, WeightType weightType) {
		return this.sPolWeight[repType.ordinal()][weightType.ordinal()];
	}
	
	
=======

	/**
	 * 
	 */
	public Double getWeight(Reputation.RepType repType, WeightType weightType){
		return this.sPolWeight[repType.ordinal()][weightType.ordinal()];
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setWeight(Reputation.RepType repType, WeightType weightType,
<<<<<<< HEAD
			Double value) {
		if(value != null) {
			this.sPolWeight[repType.ordinal()][weightType.ordinal()] = value;
		}
	}
	
	
	/**
	 * 
	 */
	public void print() {
		for(Reputation.RepType repType : Reputation.RepType.values()) {
			for(WeightType weightType : WeightType.values()) {
				System.out.println(repType.toString() + " - " + weightType.toString()
						+ " = " + this.sPolWeight[repType.ordinal()][weightType.ordinal()]);
=======
			Double value){
		if(value != null){
			this.sPolWeight[repType.ordinal()][weightType.ordinal()] = value;
		}
	}

	/**
	 * 
	 */
	public void print(){
		for(Reputation.RepType repType : Reputation.RepType.values()){
			for(WeightType weightType : WeightType.values()){
				System.out.println(repType.toString()
						+ " - "
						+ weightType.toString()
						+ " = "
						+ this.sPolWeight[repType.ordinal()][weightType
								.ordinal()]);
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			}
		}
	}
}