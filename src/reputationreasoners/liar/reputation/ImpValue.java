package reputationreasoners.liar.reputation;

<<<<<<< HEAD
public class ImpValue {
	
	private Integer	numberOfSPol;
	
	private Double	sumOfPenalties;
	
	
	public ImpValue(Double sumOfPenalties, Integer numberOfSPol) {
		this.numberOfSPol = numberOfSPol;
		this.sumOfPenalties = sumOfPenalties;
	}
	
	
	/**
	 * 
	 */
	public Integer getNumberOfSPol() {
		return this.numberOfSPol;
	}
	
	
	/**
	 * 
	 */
	public Double getSumOfPenalties() {
		return this.sumOfPenalties;
	}
	
	
	public void print() {
		System.out.println("Number of SPol = [" + this.numberOfSPol.toString()
				+ "]");
		System.out.println("Sum of Penalties = [" + this.sumOfPenalties.toString()
				+ "]");
=======
public class ImpValue{
	private Integer	numberOfSPol;
	private Double	sumOfPenalties;

	public ImpValue(Double sumOfPenalties, Integer numberOfSPol){
		this.numberOfSPol = numberOfSPol;
		this.sumOfPenalties = sumOfPenalties;
	}

	/**
	 * 
	 */
	public Integer getNumberOfSPol(){
		return this.numberOfSPol;
	}

	/**
	 * 
	 */
	public Double getSumOfPenalties(){
		return this.sumOfPenalties;
	}

	public void print(){
		System.out.println("Number of SPol = [" + this.numberOfSPol.toString()
				+ "]");
		System.out.println("Sum of Penalties = ["
				+ this.sumOfPenalties.toString() + "]");
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	}
}