package test;

import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Iterator;

<<<<<<< HEAD
public class OWLTest {
	
	public static void main(String[] args) throws Exception {
=======
public class OWLTest{
	
	public static void main(String[] args) throws Exception{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
	
<<<<<<< HEAD
	
	public static String getClassNameMatches(String name, OWLModel owlModel) {
=======

	public static String getClassNameMatches(String name, OWLModel owlModel){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Boolean found = new Boolean(false);
		String className = null;
		
		Collection classes = owlModel.getUserDefinedOWLNamedClasses();
		for(Iterator it = classes.iterator(); (it.hasNext() && !found
<<<<<<< HEAD
				.booleanValue());) {
			OWLNamedClass cls = (OWLNamedClass) it.next();
			
			if(cls.getName().toLowerCase().contains(name.toLowerCase())) {
=======
				.booleanValue());){
			OWLNamedClass cls = (OWLNamedClass) it.next();
			
			if (cls.getName().toLowerCase().contains(name.toLowerCase())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				found = new Boolean(true);
				className = cls.getName();
			}
		}
		return className;
	}
	
}