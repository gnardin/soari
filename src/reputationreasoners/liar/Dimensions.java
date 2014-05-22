package reputationreasoners.liar;

public enum Dimensions {
	INTEGRITY, BENEVOLENCE, PREVISIBILITY, COMPETENCE;

	/**
	 * 
	 */
	Dimensions(){
	}

	/**
	 * 
	 */
	public static Dimensions getDimension(String dimension){
		Dimensions result = null;

		if(dimension.equalsIgnoreCase(BENEVOLENCE.toString())){
			result = BENEVOLENCE;
		}else if(dimension.equalsIgnoreCase(COMPETENCE.toString())){
			result = COMPETENCE;
		}else if(dimension.equalsIgnoreCase(INTEGRITY.toString())){
			result = INTEGRITY;
		}else if(dimension.equalsIgnoreCase(PREVISIBILITY.toString())){
			result = PREVISIBILITY;
		}

		return result;
	}
}