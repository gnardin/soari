package reputationreasoners.liar.socialpolicy;

import java.util.List;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.Facets;
import reputationreasoners.liar.condition.Condition;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.socialcommitment.SCom;

<<<<<<< HEAD
public class SPol {
	
	public enum States {
		INACTIVE{
			
			public String toString() {
=======
public class SPol{

	public enum States {
		INACTIVE{
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "INACTIVE";
			}
		},
		ACTIVE{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "ACTIVE";
			}
		},
		JUSTIFYING{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "JUSTIFYING";
			}
		},
		CANCELLED{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "CANCELED";
			}
		},
		VIOLATED{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "VIOLATED";
			}
		},
		FULFILLED{
<<<<<<< HEAD
			
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "FULFILLED";
			}
		}
	};
<<<<<<< HEAD
	
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
=======

	private Long		datetime;
	private States		state;
	private Condition	condition;
	private Content		content;
	private Facets		facet;
	private Dimensions	dimension;
	private Float		penalty;
	private SCom		violatingSCom;
	private List<SCom>	inconsistentSComs;

	/**
	 * 
	 */
	public SPol(SCom violatingSCom, List<SCom> inconsistentSComs,
			Long datetime, Condition condition, Content content, States state,
			Facets facet, Dimensions dimension, Float penalty){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	
	
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
=======

	/**
	 * 
	 */
	public String getObserver(){
		return this.violatingSCom.getObserver();
	}

	/**
	 * 
	 */
	public String getDebtor(){
		return this.violatingSCom.getDebtor();
	}

	/**
	 * 
	 */
	public String getCreditor(){
		return this.violatingSCom.getCreditor();
	}

	/**
	 * 
	 */
	public SCom getViolatingSCom(){
		return this.violatingSCom;
	}

	/**
	 * 
	 */
	public List<SCom> getInconsistentSComs(){
		return this.inconsistentSComs;
	}

	/**
	 * 
	 */
	public Long getDateTime(){
		return new Long(this.datetime);
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
	public Facets getFacet(){
		return this.facet;
	}

	/**
	 * 
	 */
	public Dimensions getDimension(){
		return this.dimension;
	}

	/**
	 * 
	 */
	public Float getPenalty(){
		return this.penalty;
	}

	/**
	 * 
	 */
	public void setState(States state){
		this.state = state;
	}

	/**
	 * 
	 */
	public Float punishes(){
		return this.penalty;
	}

	/**
	 * 
	 */
	public void print(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
		
		if(this.inconsistentSComs != null) {
			System.out.println("--- Inconsistent Social Commitment ---");
			for(SCom sCom : inconsistentSComs) {
=======

		if(this.inconsistentSComs != null){
			System.out.println("--- Inconsistent Social Commitment ---");
			for(SCom sCom : inconsistentSComs){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				sCom.print();
			}
		}
		System.out.println();
	}
}