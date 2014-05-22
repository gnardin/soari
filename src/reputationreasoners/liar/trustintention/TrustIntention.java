package reputationreasoners.liar.trustintention;

public class TrustIntention{

	public enum TrustType {
		TRUST(new Boolean(true)){
			public String toString(){
				return "Trust";
			}
		},
		DISTRUST(new Boolean(false)){
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
		System.out.println("Trust Value = [" + this.trustVal.toString() + "]");
		System.out.println();
	}
}