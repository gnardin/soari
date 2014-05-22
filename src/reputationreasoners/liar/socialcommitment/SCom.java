package reputationreasoners.liar.socialcommitment;

import reputationreasoners.liar.Facets;
import reputationreasoners.liar.condition.Condition;
import reputationreasoners.liar.content.Content;

public class SCom {
	
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
	
	private final long	TIMECANCELLATION	= -1;
	
	private String			observer;
	
	private String			debtor;
	
	private String			creditor;
	
	private Condition		condition;
	
	private Content			content;
	
	private Facets			facet;
	
	private States			state;
	
	private long				timeEmission;
	
	private long				timeCancellation;
	
	
	/**
	 * 
	 */
	public SCom(String observer, String debtor, String creditor,
			Condition condition, Content content, Facets facet, States state,
			Long timeEmission) {
		this.observer = observer;
		this.debtor = debtor;
		this.creditor = creditor;
		this.condition = condition;
		this.content = content;
		this.facet = facet;
		this.state = state;
		this.timeEmission = timeEmission.longValue();
		this.timeCancellation = TIMECANCELLATION;
	}
	
	
	/**
	 * 
	 */
	public String getObserver() {
		return this.observer;
	}
	
	
	/**
	 * 
	 */
	public String getDebtor() {
		return this.debtor;
	}
	
	
	/**
	 * 
	 */
	public String getCreditor() {
		return this.creditor;
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
	public States getState() {
		return this.state;
	}
	
	
	/**
	 * 
	 */
	public Long getTimeEmission() {
		return this.timeEmission;
	}
	
	
	/**
	 * 
	 */
	public Long getTimeCancellation() {
		return this.timeCancellation;
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
	public void setTimeCancellation(Long timeCancellation) {
		this.timeCancellation = timeCancellation.longValue();
	}
	
	
	/**
	 * 
	 */
	public boolean equals(Object obj) {
		if(obj instanceof SCom) {
			SCom sCom = (SCom) obj;
			return((this.observer.equals(sCom.observer))
					&& (this.debtor.equals(sCom.debtor))
					&& (this.creditor.equals(sCom.creditor))
					&& (this.content.equals(sCom.content))
					&& (this.facet.equals(sCom.facet)) && (this.timeEmission == sCom.timeEmission));
		} else {
			System.out.println("Object is not SCom");
		}
		
		return false;
	}
	
	
	/**
	 * 
	 */
	public boolean inconsistent() {
		return false;
	}
	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("=== Social Commitment ===");
		System.out.println("Observer = [" + this.observer + "]");
		System.out.println("Debtor = [" + this.debtor + "]");
		System.out.println("Creditor = [" + this.creditor + "]");
		this.condition.print();
		this.content.print();
		System.out.println("Facet = [" + this.facet.toString() + "]");
		System.out.println("State = [" + this.state.toString() + "]");
		System.out.println("Time Emission = [" + this.timeEmission + "]");
		System.out.println("Time Cancellation = [" + this.timeCancellation + "]");
		System.out.println();
	}
}