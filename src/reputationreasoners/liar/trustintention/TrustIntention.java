package reputationreasoners.liar.trustintention;

<<<<<<< HEAD
public class TrustIntention {
	
	public enum TrustType {
		TRUST(new Boolean(true)){
			
			public String toString() {
=======
public class TrustIntention{

	public enum TrustType {
		TRUST(new Boolean(true)){
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "Trust";
			}
		},
		DISTRUST(new Boolean(false)){
<<<<<<< HEAD
			
			public String toString() {
				return "Distrust";
			}
		};
		
		public Boolean	value;
		
		
		private TrustType(Boolean value) {
			this.value = value;
		}
		
		
		public Boolean value() {
			return this.value;
		}
	}
	
	TrustType	trustInt;
	
	Double		trustVal;
	
	
	/**
	 * 
	 */
	public TrustIntention(TrustType trustInt, Double trustVal) {
		this.trustInt = trustInt;
		
		if((trustVal.floatValue() >= -1) && (trustVal.floatValue() <= 1)) {
			this.trustVal = trustVal;
		} else {
			this.trustVal = new Double(0);
		}
	}
	
	
	/**
	 * 
	 */
	public TrustType getTrustInt() {
		return this.trustInt;
	}
	
	
	/**
	 * 
	 */
	public Double getTrustVal() {
		return this.trustVal;
	}
	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("=== TrustIntention ===");
		System.out.println("Trust Intention = [" + this.trustInt.toString() + "]");
=======
			public String toString(){
				return "Distrust";
			}
		};

		public Boolean	value;

		private TrustType(Boolean value){
			this.value = value;
		}

		public Boolean value(){
			return this.value;
		}
	}

	TrustType	trustInt;
	Double		trustVal;

	/**
	 * 
	 */
	public TrustIntention(TrustType trustInt, Double trustVal){
		this.trustInt = trustInt;

		if((trustVal.floatValue() >= -1) && (trustVal.floatValue() <= 1)){
			this.trustVal = trustVal;
		}else{
			this.trustVal = new Double(0);
		}
	}

	/**
	 * 
	 */
	public TrustType getTrustInt(){
		return this.trustInt;
	}

	/**
	 * 
	 */
	public Double getTrustVal(){
		return this.trustVal;
	}

	/**
	 * 
	 */
	public void print(){
		System.out.println("=== TrustIntention ===");
		System.out.println("Trust Intention = [" + this.trustInt.toString()
				+ "]");
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		System.out.println("Trust Value = [" + this.trustVal.toString() + "]");
		System.out.println();
	}
}