package reputationreasoners.liar.socialpolicy;

import java.util.List;
import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.condition.Condition;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.socialcommitment.SCom;

public class SPol {
	
	public enum States {
		INACTIVE{
			
			public String toString() {
				return "INACTIVE";
			}
		},
		ACTIVE{
			
			public String toString() {
				return "ACTIVE";
			}
		},
		JUSTIFYING{
			
			public String toString() {
				return "JUSTIFYING";
			}
		},
		CANCELLED{
			
			public String toString() {
				return "CANCELED";
			}
		},
		VIOLATED{
			
			public String toString() {
				return "VIOLATED";
			}
		},
		FULFILLED{
			
			public String toString() {
				return "FULFILLED";
			}
		}
	};
	
	private Long				datetime;
	
	private States			state;
	
	private Condition		condition;
	
	private Content			content;
	
	private Facets			facet;
	
	private Dimensions	dimension;
	
	private Float				penalty;
	
	private SCom				violatingSCom;
	
	private List<SCom>	inconsistentSComs;
	
	
	/**
	 * 
	 */
	public SPol(SCom violatingSCom, List<SCom> inconsistentSComs, Long datetime,
			Condition condition, Content content, States state, Facets facet,
			Dimensions dimension, Float penalty) {
		this.violatingSCom = violatingSCom;
		this.inconsistentSComs = inconsistentSComs;
		this.datetime = datetime;
		this.state = state;
		this.condition = condition;
		this.content = content;
		this.facet = facet;
		this.dimension = dimension;
		this.penalty = penalty;
	}
	
	
	/**
	 * 
	 */
	public String getObserver() {
		return this.violatingSCom.getObserver();
	}
	
	
	/**
	 * 
	 */
	public String getDebtor() {
		return this.violatingSCom.getDebtor();
	}
	
	
	/**
	 * 
	 */
	public String getCreditor() {
		return this.violatingSCom.getCreditor();
	}
	
	
	/**
	 * 
	 */
	public SCom getViolatingSCom() {
		return this.violatingSCom;
	}
	
	
	/**
	 * 
	 */
	public List<SCom> getInconsistentSComs() {
		return this.inconsistentSComs;
	}
	
	
	/**
	 * 
	 */
	public Long getDateTime() {
		return new Long(this.datetime);
	}
	
	
	/**
	 * 
	 */
	public States getState() {
		return this.state;
	}
	
	
	/**
	 * 
	 */
	public Condition getCondition() {
		return this.condition;
	}
	
	
	/**
	 * 
	 */
	public Content getContent() {
		return this.content;
	}
	
	
	/**
	 * 
	 */
	public Facets getFacet() {
		return this.facet;
	}
	
	
	/**
	 * 
	 */
	public Dimensions getDimension() {
		return this.dimension;
	}
	
	
	/**
	 * 
	 */
	public Float getPenalty() {
		return this.penalty;
	}
	
	
	/**
	 * 
	 */
	public void setState(States state) {
		this.state = state;
	}
	
	
	/**
	 * 
	 */
	public Float punishes() {
		return this.penalty;
	}
	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("=== Social Policy ===");
		System.out.println("Time = [" + this.datetime.toString() + "]");
		System.out.println("State = [" + this.state.toString() + "]");
		condition.print();
		content.print();
		System.out.println("Facet = [" + this.facet.toString() + "]");
		System.out.println("Dimension = [" + this.dimension.toString() + "]");
		System.out.println("Penalty = [" + this.penalty.toString() + "]");
		System.out.println("--- Violating Social Commitment ---");
		this.violatingSCom.print();
		
		if(this.inconsistentSComs != null) {
			System.out.println("--- Inconsistent Social Commitment ---");
			for(SCom sCom : inconsistentSComs) {
				sCom.print();
			}
		}
		System.out.println();
	}
}