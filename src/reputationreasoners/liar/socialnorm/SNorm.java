package reputationreasoners.liar.socialnorm;

import java.util.List;
import reputationreasoners.liar.condition.Condition;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.socialcommitment.SCom;
import reputationreasoners.liar.socialpolicy.SPol;

public abstract class SNorm {
	
	public enum OperatorType {
		I{
			
			public String toString() {
				return "Prohibition";
			}
		},
		O{
			
			public String toString() {
				return "Obligation";
			}
		},
		P{
			
			public String toString() {
				return "Permission";
			}
		}
	};
	
	public enum States {
		ACTIVE{
			
			public String toString() {
				return "Active";
			}
		},
		INACTIVE{
			
			public String toString() {
				return "Inactive";
			}
		}
	}
	
	private OperatorType	operator;
	
	private List<String>	targets;
	
	private List<String>	evaluators;
	
	private List<String>	punishers;
	
	private Condition			condition;
	
	private Content				content;
	
	private States				state;
	
	
	/**
	 * 
	 */
	public SNorm(OperatorType operator, List<String> targets,
			List<String> evaluators, List<String> punishers, Condition condition,
			Content content, States state) {
		this.operator = operator;
		this.targets = targets;
		this.evaluators = evaluators;
		this.punishers = punishers;
		this.condition = condition;
		this.content = content;
		this.state = state;
	}
	
	
	/**
	 * 
	 */
	public OperatorType getOperator() {
		return this.operator;
	}
	
	
	/**
	 * 
	 */
	public List<String> getTargets() {
		return this.targets;
	}
	
	
	/**
	 * 
	 */
	public List<String> getEvaluators() {
		return this.evaluators;
	}
	
	
	/**
	 * 
	 */
	public List<String> getPunishers() {
		return this.punishers;
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
	public States getState() {
		return this.state;
	}
	
	
	/**
	 * 
	 */
	public void setState(States state) {
		this.state = state;
	}
	
	
	/**
	 * Evaluate the Social Commitment against the Social Norm returning a Social
	 * Policy as a result
	 */
	public abstract SPol evaluate(SCom sCom);
	
	
	/**
	 * Verifies if the Social Norm is applicable for a Social Commitment
	 */
	public abstract Boolean match(SCom sCom);
}
