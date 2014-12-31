package reputationreasoners.liar.condition;

public class TrueCondition implements Condition {
	
	private Boolean	condition;
	
	
	/**
	 * 
	 */
	public TrueCondition() {
		this.condition = new Boolean(true);
	}
	
	
	/**
	 * 
	 */
	@Override
	public boolean evaluate(Object value) {
		return this.condition.booleanValue();
	}
	
	
	/**
	 * 
	 */
	@Override
	public Boolean getCondition() {
		return this.condition;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void setCondition(Boolean condition) {
		this.condition = condition;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void print() {
		System.out.println("Condition = [" + this.condition.toString() + "]");
	}
}