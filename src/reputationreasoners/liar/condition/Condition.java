package reputationreasoners.liar.condition;

public interface Condition {
	
	/**
	 * 
	 */
	public boolean evaluate(Object value);
	
	
	/**
	 * 
	 */
	public Boolean getCondition();
	
	
	/**
	 * 
	 */
	public void setCondition(Boolean condition);
	
	
	/**
	 * 
	 */
	public void print();
}