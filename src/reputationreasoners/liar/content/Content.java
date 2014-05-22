package reputationreasoners.liar.content;

public interface Content {
	
	/**
	 * 
	 */
	@Override
	public boolean equals(Object content);
	
	
	/**
	 * 
	 */
	public boolean inconsistentContent(Content content);
	
	
	/**
	 * 
	 */
	public void print();
}