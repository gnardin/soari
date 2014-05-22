package test;

import java.util.ArrayList;
import reputationreasoners.typology.*;
import reputationreasoners.typology.Reputation.RepType;

public class TypologyModuleTest{
	
	/**
	 *
	 */
	public static void main(String[] args){
		TypologyModule rr = new TypologyModule();
		String context = "ZZ";
		
		rr.addUnit("A", context);
		rr.addUnit("B", context);
		rr.addUnit("C", context);
		
		rr.setIndividualReputation("A", context, 0.9);
		rr.setPriorDerivedReputation("A", context, 0.8);
		rr.setObservedReputation("A", context, 0.5);
		
		rr.setIndividualReputation("B", context, 1.0);
		
		rr.updateReputation(RepType.PROPAGATED,"A", "C", context, 0.8);
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("A");
		a.add("B");
		a.add("C");
		a = (ArrayList<String>) rr.sortTarget(a, context, false);
		
		ArrayList<String> b = (ArrayList<String>) rr.sortTarget(a, context, true);
		
		System.out.println("Lista de agentes por reputacao decrescente:");
		for(String lista : a){
			System.out.println((a.indexOf(lista) + 1) + ": " + lista);
		}
		System.out.println();
		
		System.out.println("Lista de agentes por reputacao crescente:");
		for(String lista : b){
			System.out.println((b.indexOf(lista) + 1) + ": " + lista);
		}
		System.out.println();
		
		String[] names = rr.getTargets(context);
		
		for(int i = 0; i < names.length; i++){
			String[] contexts = rr.getContexts(names[i]);
			for(int j = 0; j < contexts.length; j++)
				System.out.println("Agent " + names[i] + " Context: " + contexts[j]
						+ " Reputation: " + rr.getReputation(names[i], context));
		}
		
	}
}