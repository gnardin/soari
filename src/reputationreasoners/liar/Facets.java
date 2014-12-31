package reputationreasoners.liar;

public enum Facets {
<<<<<<< HEAD
	ERA1,
	ERA2,
	ERA3,
	ERA4,
	ERA5,
	ERA6,
	ERA7,
	ERA8,
	ERA9,
	ERA10,
	ERA11,
	ERA12,
	ERA13,
	ERA14,
	ERA15,
	ERA16,
	ERA17,
	ERA18,
	ERA19,
	ERA20,
	RECOMMENDATION;
	
	/**
	 * 
	 */
	Facets() {
	}
	
	
	/**
	 * 
	 */
	public static Facets getFacet(String facet) {
		Facets result = null;
		
		if(facet.equalsIgnoreCase(ERA1.toString())) {
			result = ERA1;
		} else if(facet.equalsIgnoreCase(ERA2.toString())) {
			result = ERA2;
		} else if(facet.equalsIgnoreCase(ERA3.toString())) {
			result = ERA3;
		} else if(facet.equalsIgnoreCase(ERA4.toString())) {
			result = ERA4;
		} else if(facet.equalsIgnoreCase(ERA5.toString())) {
			result = ERA5;
		} else if(facet.equalsIgnoreCase(ERA6.toString())) {
			result = ERA6;
		} else if(facet.equalsIgnoreCase(ERA7.toString())) {
			result = ERA7;
		} else if(facet.equalsIgnoreCase(ERA8.toString())) {
			result = ERA8;
		} else if(facet.equalsIgnoreCase(ERA9.toString())) {
			result = ERA9;
		} else if(facet.equalsIgnoreCase(ERA10.toString())) {
			result = ERA10;
		} else if(facet.equalsIgnoreCase(ERA11.toString())) {
			result = ERA11;
		} else if(facet.equalsIgnoreCase(ERA12.toString())) {
			result = ERA12;
		} else if(facet.equalsIgnoreCase(ERA13.toString())) {
			result = ERA13;
		} else if(facet.equalsIgnoreCase(ERA14.toString())) {
			result = ERA14;
		} else if(facet.equalsIgnoreCase(ERA15.toString())) {
			result = ERA15;
		} else if(facet.equalsIgnoreCase(ERA16.toString())) {
			result = ERA16;
		} else if(facet.equalsIgnoreCase(ERA17.toString())) {
			result = ERA17;
		} else if(facet.equalsIgnoreCase(ERA18.toString())) {
			result = ERA18;
		} else if(facet.equalsIgnoreCase(ERA19.toString())) {
			result = ERA19;
		} else if(facet.equalsIgnoreCase(ERA20.toString())) {
			result = ERA20;
		} else if(facet.equalsIgnoreCase(RECOMMENDATION.toString())) {
			result = RECOMMENDATION;
		}
		
=======
	ERA1, ERA2, ERA3, ERA4, ERA5, ERA6, ERA7, ERA8, ERA9, ERA10, ERA11, ERA12, ERA13, ERA14, ERA15, ERA16, ERA17, ERA18, ERA19, ERA20, RECOMMENDATION;

	/**
	 * 
	 */
	Facets(){
	}

	/**
	 * 
	 */
	public static Facets getFacet(String facet){
		Facets result = null;

		if(facet.equalsIgnoreCase(ERA1.toString())){
			result = ERA1;
		}else if(facet.equalsIgnoreCase(ERA2.toString())){
			result = ERA2;
		}else if(facet.equalsIgnoreCase(ERA3.toString())){
			result = ERA3;
		}else if(facet.equalsIgnoreCase(ERA4.toString())){
			result = ERA4;
		}else if(facet.equalsIgnoreCase(ERA5.toString())){
			result = ERA5;
		}else if(facet.equalsIgnoreCase(ERA6.toString())){
			result = ERA6;
		}else if(facet.equalsIgnoreCase(ERA7.toString())){
			result = ERA7;
		}else if(facet.equalsIgnoreCase(ERA8.toString())){
			result = ERA8;
		}else if(facet.equalsIgnoreCase(ERA9.toString())){
			result = ERA9;
		}else if(facet.equalsIgnoreCase(ERA10.toString())){
			result = ERA10;
		}else if(facet.equalsIgnoreCase(ERA11.toString())){
			result = ERA11;
		}else if(facet.equalsIgnoreCase(ERA12.toString())){
			result = ERA12;
		}else if(facet.equalsIgnoreCase(ERA13.toString())){
			result = ERA13;
		}else if(facet.equalsIgnoreCase(ERA14.toString())){
			result = ERA14;
		}else if(facet.equalsIgnoreCase(ERA15.toString())){
			result = ERA15;
		}else if(facet.equalsIgnoreCase(ERA16.toString())){
			result = ERA16;
		}else if(facet.equalsIgnoreCase(ERA17.toString())){
			result = ERA17;
		}else if(facet.equalsIgnoreCase(ERA18.toString())){
			result = ERA18;
		}else if(facet.equalsIgnoreCase(ERA19.toString())){
			result = ERA19;
		}else if(facet.equalsIgnoreCase(ERA20.toString())){
			result = ERA20;
		}else if(facet.equalsIgnoreCase(RECOMMENDATION.toString())){
			result = RECOMMENDATION;
		}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return result;
	}
}