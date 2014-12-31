package test;

import otservices.mapper.translationrepository.Ontology;
import otservices.translator.mapperserverclient.ws.MapperClientWebService;

<<<<<<< HEAD
public class WebServiceClientTest {
	
	public static void main(String[] args) {
=======
public class WebServiceClientTest{
	
	public static void main(String[] args){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		MapperClientWebService a = new MapperClientWebService();
		a.setURL("http://localhost:8080/axis2/services/MapperServerWebService");
		a.connect();
		
		System.out.println("Connected = " + a.isConnected());
		
<<<<<<< HEAD
		if(a.isConnected().booleanValue()) {
=======
		if(a.isConnected().booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			
			Ontology ontInterchange = new Ontology();
			ontInterchange.setType(Ontology.TYPE_INTERCHANGE);
			ontInterchange.setUri("FORE");
			ontInterchange.setVersion(1);
			
			Ontology ontNative = new Ontology();
			// ontNative.setType(ontNative.TYPE_NATIVE);
			// ontNative.setUri("LIAR");
			// ontNative.setVersion(1);
			
			// a
			// .addOntologyTranslation(
			// ontInterchange,
			// ontNative,
			// "/media/data/Projects/workspace/soari/ReputationFunctionalOntology_LIAR.owl");
			
			ontNative = new Ontology();
			ontNative.setType(Ontology.TYPE_NATIVE);
			ontNative.setUri("REPAGE");
			ontNative.setVersion(1);
			// a
			// .addOntologyTranslation(
			// ontInterchange,
			// ontNative,
			// "/data/workspace/soari/tools/data/ReputationFunctionalOntology_REPAGE.owl");
			
			// ontNative = new Ontology();
			// ontNative.setType(ontNative.TYPE_NATIVE);
			// ontNative.setUri("TYPOLOGY");
			// ontNative.setVersion(1);
			// a
			// .addOntologyTranslation(
			// ontInterchange,
			// ontNative,
			// "/data/workspace/soari/ReputationFunctionalOntology_TYPOLOGY.owl");
			
			System.out.println("isOntologyTranslation = "
					+ a.isOntologyTranslation(ontInterchange, ontNative));
			
			String[] r = a.translateConcept("imagebyrepage", ontNative,
					ontInterchange);
<<<<<<< HEAD
			if(r != null) {
				for(int i = 0; i < r.length; i++) {
					System.out.println(r[i]);
				}
			} else {
=======
			if(r != null){
				for(int i = 0; i < r.length; i++){
					System.out.println(r[i]);
				}
			}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				System.out.println("Resultado Nulo");
			}
			
			// HashMap<String, String[]> x = (HashMap<String, String[]>) a
			// .getInterchangeNativeMapping(ontInterchange, ontNative);
			
			// Iterator<String> i = x.keySet().iterator();
			// String key;
			// String[] values;
			// while(i.hasNext()){
			// key = i.next();
			// System.out.println("Translation ------- " + key);
			
			// values = x.get(key);
			// for(int j = 0; j < values.length; j++)
			// System.out.println(values[j]);
			// System.out.println();
			// }
			
			// a.getOWLFile(ontInterchange, ontNative, "D:/teste.owl");
			// a.removeOntologyTranslation(ontInterchange, ontNative);
			
			a.disconnect();
		}
	}
}