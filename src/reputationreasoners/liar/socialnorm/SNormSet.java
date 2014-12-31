package reputationreasoners.liar.socialnorm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
<<<<<<< HEAD
import reputationreasoners.liar.socialcommitment.SCom;
import reputationreasoners.liar.socialpolicy.SPol;

public class SNormSet {
	
	protected ArrayList<SNorm>	sNormSet;
	
	
	/**
	 * 
	 */
	public SNormSet() {
		this.sNormSet = new ArrayList<SNorm>();
	}
	
	
	/**
	 * 
	 */
	public void addNorm(SNorm sNorm) {
		if(sNorm != null) {
			sNormSet.add(sNorm);
		}
	}
	
	
	/**
	 * 
	 */
	public List<SPol> evaluation(SCom sCom) {
		List<SPol> result = new ArrayList<SPol>();
		
		SNorm sNorm;
		SPol sPol;
		for(Iterator<SNorm> iSNormSet = this.sNormSet.iterator(); iSNormSet
				.hasNext();) {
			sNorm = iSNormSet.next();
			
			if((sNorm.getState().name().equals(SNorm.States.ACTIVE.name()))
					&& (sNorm.match(sCom))) {
				
				sPol = sNorm.evaluate(sCom);
				
				if(sPol != null) {
=======

import reputationreasoners.liar.socialcommitment.SCom;
import reputationreasoners.liar.socialpolicy.SPol;

public class SNormSet{

	protected ArrayList<SNorm>	sNormSet;

	/**
	 * 
	 */
	public SNormSet(){
		this.sNormSet = new ArrayList<SNorm>();
	}

	/**
	 * 
	 */
	public void addNorm(SNorm sNorm){
		if(sNorm != null){
			sNormSet.add(sNorm);
		}
	}

	/**
	 * 
	 */
	public List<SPol> evaluation(SCom sCom){
		List<SPol> result = new ArrayList<SPol>();

		SNorm sNorm;
		SPol sPol;
		for(Iterator<SNorm> iSNormSet = this.sNormSet.iterator(); iSNormSet
				.hasNext();){
			sNorm = iSNormSet.next();

			if((sNorm.getState().name().equals(SNorm.States.ACTIVE.name()))
					&& (sNorm.match(sCom))){
				
				sPol = sNorm.evaluate(sCom);

				if(sPol != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					result.add(sPol);
				}
			}
		}
<<<<<<< HEAD
		
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return result;
	}
}