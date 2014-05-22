package reputationreasoners.liar.content;

public class ARTContent implements Content {
	
	private Double	opinionValue;
	
	private Double	officialValue;
	
	
	/**
	 * 
	 */
	public ARTContent(Double opinionValue, Double officialValue) {
		this.opinionValue = opinionValue;
		this.officialValue = officialValue;
	}
	
	
	/**
	 * 
	 */
	public Double getOpinionValue() {
		return this.opinionValue;
	}
	
	
	/**
	 * 
	 */
	public Double getOfficialValue() {
		return this.officialValue;
	}
	
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object content) {
		if(content instanceof ARTContent) {
			return((this.opinionValue == ((ARTContent) content).getOpinionValue()) && (this.officialValue == ((ARTContent) content)
					.getOfficialValue()));
		}
		
		return false;
	}
	
	
	/**
	 * 
	 */
	@Override
	public boolean inconsistentContent(Content content) {
		if(content instanceof ARTContent) {
			return((((ARTContent) content).getOfficialValue().doubleValue()) != ((ARTContent) content)
					.getOpinionValue().doubleValue());
		}
		
		return false;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void print() {
		System.out.println("Opinion Value = [" + opinionValue + "]");
		System.out.println("Official Value = [" + officialValue + "]");
	}
}