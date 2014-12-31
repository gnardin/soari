package test;

<<<<<<< HEAD
import otservices.translator.mapperserverclient.ws.MapperClientWebService;
import otservices.translator.strategy.impl.HeuristicStrategy;

public class HeuristicStrategyTest {
	
	public static void main(String[] args) {
=======
import otservices.translator.strategy.impl.HeuristicStrategy;
import otservices.translator.mapperserverclient.ws.MapperClientWebService;

public class HeuristicStrategyTest{
	
	public static void main(String[] args){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		HeuristicStrategy hs = new HeuristicStrategy();
		
		String ontInterchangeName = "FORE";
		Integer ontInterchangeVersion = new Integer(1);
		String ontNativeName = "TYPOLOGY";
		Integer ontNativeVersion = new Integer(1);
		
		MapperClientWebService mapperClient = new MapperClientWebService();
		mapperClient
				.setURL("http://localhost:8080/axis2/services/MapperServerWebService");
		mapperClient.connect();
		
<<<<<<< HEAD
		if(mapperClient.isConnected().booleanValue()) {
=======
		if (mapperClient.isConnected().booleanValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			hs.setWebServices(ontInterchangeName, ontInterchangeVersion,
					ontNativeName, ontNativeVersion, mapperClient);
			
			String[] translations = hs.run("directreputation", null);
<<<<<<< HEAD
			if(translations != null) {
				for(int i = 0; i < translations.length; i++) {
=======
			if (translations != null){
				for(int i = 0; i < translations.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					System.out.println(translations[i]);
				}
			}
			
			mapperClient.disconnect();
		}
	}
}