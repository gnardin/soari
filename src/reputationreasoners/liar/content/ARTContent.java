package reputationreasoners.liar.content;

<<<<<<< HEAD
public class ARTContent implements Content {
=======
import reputationreasoners.liar.content.Content;

public class ARTContent implements Content{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	private Double	opinionValue;
	
	private Double	officialValue;
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public ARTContent(Double opinionValue, Double officialValue) {
=======
	public ARTContent(Double opinionValue, Double officialValue){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.opinionValue = opinionValue;
		this.officialValue = officialValue;
	}
	
<<<<<<< HEAD
	
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
	
	
=======

	/**
	 * 
	 */
	public Double getOpinionValue(){
		return this.opinionValue;
	}
	

	/**
	 * 
	 */
	public Double getOfficialValue(){
		return this.officialValue;
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public boolean equals(Object content) {
		if(content instanceof ARTContent) {
=======
	public boolean equals(Object content){
		if(content instanceof ARTContent){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return((this.opinionValue == ((ARTContent) content).getOpinionValue()) && (this.officialValue == ((ARTContent) content)
					.getOfficialValue()));
		}
		
		return false;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public boolean inconsistentContent(Content content) {
		if(content instanceof ARTContent) {
=======
	public boolean inconsistentContent(Content content){
		if(content instanceof ARTContent){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			return((((ARTContent) content).getOfficialValue().doubleValue()) != ((ARTContent) content)
					.getOpinionValue().doubleValue());
		}
		
		return false;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public void print() {
=======
	public void print(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		System.out.println("Opinion Value = [" + opinionValue + "]");
		System.out.println("Official Value = [" + officialValue + "]");
	}
}