package reputationreasoners.liar.condition;

<<<<<<< HEAD
public class TrueCondition implements Condition {
=======
public class TrueCondition implements Condition{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	private Boolean	condition;
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public TrueCondition() {
		this.condition = new Boolean(true);
	}
	
	
=======
	public TrueCondition(){
		this.condition = new Boolean(true);
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public boolean evaluate(Object value) {
		return this.condition.booleanValue();
	}
	
	
=======
	public boolean evaluate(Object value){
		return this.condition.booleanValue();
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public Boolean getCondition() {
		return this.condition;
	}
	
	
=======
	public Boolean getCondition(){
		return this.condition;
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public void setCondition(Boolean condition) {
		this.condition = condition;
	}
	
	
=======
	public void setCondition(Boolean condition){
		this.condition = condition;
	}
	

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
		System.out.println("Condition = [" + this.condition.toString() + "]");
	}
}