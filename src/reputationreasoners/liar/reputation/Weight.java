package reputationreasoners.liar.reputation;

import reputationreasoners.liar.reputation.Reputation;

public class Weight{

	public enum WeightType {
		FULFILLED(new Double(1)){
			public String toString(){
				return "FULFILLED";
			}
		},
		VIOLATED(new Double(-1)){
			public String toString(){
				return "VIOLATED";
			}
		},
		CANCELLED(new Double(0)){
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
				this.sPolWeight[i.ordinal()][j.ordinal()] = j.value();
			}
		}
	}

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
					this.sPolWeight[i.ordinal()][j.ordinal()] = j.value();
				}
			}
		}
	}

	/**
	 * 
	 */
	public Double getWeight(Reputation.RepType repType, WeightType weightType){
		return this.sPolWeight[repType.ordinal()][weightType.ordinal()];
	}

	/**
	 * 
	 */
	public void setWeight(Reputation.RepType repType, WeightType weightType,
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
			}
		}
	}
}