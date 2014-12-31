package test;

<<<<<<< HEAD
import java.util.List;
import otservices.mapper.reasoner.PelletReasoner;

public class ReasonerTest {
	
	public static void main(String[] args) {
=======
import java.util.Iterator;
import java.util.List;

import otservices.mapper.reasoner.*;

public class ReasonerTest{
	
	public static void main(String[] args){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		PelletReasoner reasoner = new PelletReasoner(
				"/media/data/Projects/workspace/soari/ReputationFunctionalOntology_TYPOLOGY.owl");
		reasoner.connect();
		System.out.println("Classify = " + reasoner.classify());
		
		List<String> allAssertedClasses = (List<String>) reasoner
				.getAllAssertedClasses();
		
		System.out.println("New Size = " + allAssertedClasses.size());
		
<<<<<<< HEAD
		for(String fromConcept : allAssertedClasses) {
=======
		for(String fromConcept : allAssertedClasses){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			System.out.println(fromConcept);
			
			List<String> inferredClasses = (List<String>) reasoner
					.getInferredClasses(fromConcept);
			
<<<<<<< HEAD
			for(String inferred : inferredClasses) {
=======
			for(String inferred : inferredClasses){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				System.out.println("    " + fromConcept.toLowerCase() + " - "
						+ inferred.toLowerCase());
			}
			
		}
	}
}