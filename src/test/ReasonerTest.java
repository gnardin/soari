package test;

import java.util.List;
import otservices.mapper.reasoner.PelletReasoner;

public class ReasonerTest {
	
	public static void main(String[] args) {
		
		PelletReasoner reasoner = new PelletReasoner(
				"/media/data/Projects/workspace/soari/ReputationFunctionalOntology_TYPOLOGY.owl");
		reasoner.connect();
		System.out.println("Classify = " + reasoner.classify());
		
		List<String> allAssertedClasses = (List<String>) reasoner
				.getAllAssertedClasses();
		
		System.out.println("New Size = " + allAssertedClasses.size());
		
		for(String fromConcept : allAssertedClasses) {
			System.out.println(fromConcept);
			
			List<String> inferredClasses = (List<String>) reasoner
					.getInferredClasses(fromConcept);
			
			for(String inferred : inferredClasses) {
				System.out.println("    " + fromConcept.toLowerCase() + " - "
						+ inferred.toLowerCase());
			}
			
		}
	}
}