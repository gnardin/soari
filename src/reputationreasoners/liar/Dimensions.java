package reputationreasoners.liar;

public enum Dimensions {
<<<<<<< HEAD
	INTEGRITY,
	BENEVOLENCE,
	PREVISIBILITY,
	COMPETENCE;
	
	/**
	 * 
	 */
	Dimensions() {
	}
	
	
	/**
	 * 
	 */
	public static Dimensions getDimension(String dimension) {
		Dimensions result = null;
		
		if(dimension.equalsIgnoreCase(BENEVOLENCE.toString())) {
			result = BENEVOLENCE;
		} else if(dimension.equalsIgnoreCase(COMPETENCE.toString())) {
			result = COMPETENCE;
		} else if(dimension.equalsIgnoreCase(INTEGRITY.toString())) {
			result = INTEGRITY;
		} else if(dimension.equalsIgnoreCase(PREVISIBILITY.toString())) {
			result = PREVISIBILITY;
		}
		
=======
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

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return result;
	}
}