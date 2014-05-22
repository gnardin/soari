package reputationreasoners.liar.socialnorm;

import java.util.ArrayList;
import java.util.List;

import reputationreasoners.liar.condition.Condition;
import reputationreasoners.liar.condition.TrueCondition;
import reputationreasoners.liar.content.ARTContent;
import reputationreasoners.liar.content.Content;
import reputationreasoners.liar.Dimensions;
import reputationreasoners.liar.socialcommitment.SCom;
import reputationreasoners.liar.socialpolicy.SPol;

public class ARTSNorm extends SNorm{

	/**
	 * 
	 */
	public ARTSNorm(OperatorType operator, List<String> targets,
			List<String> evaluators, List<String> punishers,
			Condition condition, Content content, States state){
		super(operator, targets, evaluators, punishers, condition, content,
				state);
	}

	/**
	 * 
	 */
	public SPol evaluate(SCom sCom){
		SPol sPol = null;

		if((this.getState().name().equals(States.ACTIVE.name()))
				&& (this.getCondition().getCondition().booleanValue())){
			if(this.getContent().inconsistentContent(sCom.getContent())){

				sPol = new SPol(sCom, new ArrayList<SCom>(), new Long(System
						.currentTimeMillis()), new TrueCondition(), sCom
						.getContent(), SPol.States.VIOLATED, sCom.getFacet(),
						Dimensions.COMPETENCE, this.calculatePenalty(sCom
								.getContent()));
			}else{
				sPol = new SPol(sCom, new ArrayList<SCom>(), new Long(System
						.currentTimeMillis()), new TrueCondition(), sCom
						.getContent(), SPol.States.FULFILLED, sCom.getFacet(),
						Dimensions.COMPETENCE, this.calculatePenalty(sCom
								.getContent()));
			}
		}

		return sPol;
	}

	/**
	 * 
	 */
	private Float calculatePenalty(Object content){
		if(content instanceof ARTContent){
			ARTContent c = (ARTContent) content;

			double nominator = ((Math.max(c.getOpinionValue().doubleValue(), c
					.getOfficialValue().doubleValue()) - Math.min(c
					.getOpinionValue().doubleValue(), c.getOfficialValue()
					.doubleValue())));

			double denominator = Math.max(c.getOpinionValue().doubleValue(), c
					.getOfficialValue().doubleValue());

			double result;
			if(denominator != 0){
				result = 1 - (nominator / denominator);
			}else{
				result = 1;
			}

			return new Float(new Double(result).floatValue());
		}

		return null;
	}

	/**
	 * 
	 */
	public Boolean match(SCom sCom){

		return new Boolean(this.getContent().getClass().getName().equals(
				sCom.getContent().getClass().getName()));
	}
}