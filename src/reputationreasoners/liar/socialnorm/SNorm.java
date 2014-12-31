package reputationreasoners.liar.socialnorm;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import reputationreasoners.liar.condition.Condition;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.socialcommitment.SCom;
import reputationreasoners.liar.socialpolicy.SPol;

<<<<<<< HEAD
public abstract class SNorm {
	
	public enum OperatorType {
		I{
			
			public String toString() {
=======
public abstract class SNorm{

	public enum OperatorType {
		I{
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "Prohibition";
			}
		},
		O{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "Obligation";
			}
		},
		P{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "Permission";
			}
		}
	};
<<<<<<< HEAD
	
	public enum States {
		ACTIVE{
			
			public String toString() {
=======

	public enum States {
		ACTIVE{
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "Active";
			}
		},
		INACTIVE{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "Inactive";
			}
		}
	}
<<<<<<< HEAD
	
	private OperatorType	operator;
	
	private List<String>	targets;
	
	private List<String>	evaluators;
	
	private List<String>	punishers;
	
	private Condition			condition;
	
	private Content				content;
	
	private States				state;
	
	
=======

	private OperatorType	operator;
	private List<String>	targets;
	private List<String>	evaluators;
	private List<String>	punishers;
	private Condition		condition;
	private Content			content;
	private States			state;

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public SNorm(OperatorType operator, List<String> targets,
<<<<<<< HEAD
			List<String> evaluators, List<String> punishers, Condition condition,
			Content content, States state) {
=======
			List<String> evaluators, List<String> punishers,
			Condition condition, Content content, States state){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.operator = operator;
		this.targets = targets;
		this.evaluators = evaluators;
		this.punishers = punishers;
		this.condition = condition;
		this.content = content;
		this.state = state;
	}
<<<<<<< HEAD
	
	
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
	
	
=======

	/**
	 * 
	 */
	public OperatorType getOperator(){
		return this.operator;
	}

	/**
	 * 
	 */
	public List<String> getTargets(){
		return this.targets;
	}

	/**
	 * 
	 */
	public List<String> getEvaluators(){
		return this.evaluators;
	}

	/**
	 * 
	 */
	public List<String> getPunishers(){
		return this.punishers;
	}

	/**
	 * 
	 */
	public Condition getCondition(){
		return this.condition;
	}

	/**
	 * 
	 */
	public Content getContent(){
		return this.content;
	}

	/**
	 * 
	 */
	public States getState(){
		return this.state;
	}

	/**
	 * 
	 */
	public void setState(States state){
		this.state = state;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Evaluate the Social Commitment against the Social Norm returning a Social
	 * Policy as a result
	 */
	public abstract SPol evaluate(SCom sCom);
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Verifies if the Social Norm is applicable for a Social Commitment
	 */
	public abstract Boolean match(SCom sCom);
}
