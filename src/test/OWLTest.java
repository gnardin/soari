package test;

import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Iterator;

public class OWLTest {
	
	public static void main(String[] args) throws Exception {
		OWLModel owlModel = ProtegeOWL
				.createJenaOWLModelFromInputStream(new FileInputStream(
						"/media/data/Projects/workspace/soari/ReputationFunctionalOntology_REPAGE.owl"));
		
		Collection matchedClasses = owlModel.getClsNameMatches("reputationtype", 1);
		System.out.println(matchedClasses.size());
		
		String matchedClass = getClassNameMatches("reputationtype", owlModel);
		
		String defaultNamespace = owlModel.getNamespaceManager()
				.getDefaultNamespace();
		
		System.out.println(matchedClass.substring(defaultNamespace.length()));
	}
	
	
	public static String getClassNameMatches(String name, OWLModel owlModel) {
		Boolean found = new Boolean(false);
		String className = null;
		
		Collection classes = owlModel.getUserDefinedOWLNamedClasses();
		for(Iterator it = classes.iterator(); (it.hasNext() && !found
				.booleanValue());) {
			OWLNamedClass cls = (OWLNamedClass) it.next();
			
			if(cls.getName().toLowerCase().contains(name.toLowerCase())) {
				found = new Boolean(true);
				className = cls.getName();
			}
		}
		return className;
	}
	
}