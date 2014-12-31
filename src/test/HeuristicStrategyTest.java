package test;

import otservices.translator.mapperserverclient.ws.MapperClientWebService;
import otservices.translator.strategy.impl.HeuristicStrategy;

public class HeuristicStrategyTest {
	
	public static void main(String[] args) {
		HeuristicStrategy hs = new HeuristicStrategy();
		
		String ontInterchangeName = "FORE";
		Integer ontInterchangeVersion = new Integer(1);
		String ontNativeName = "TYPOLOGY";
		Integer ontNativeVersion = new Integer(1);
		
		MapperClientWebService mapperClient = new MapperClientWebService();
		mapperClient
				.setURL("http://localhost:8080/axis2/services/MapperServerWebService");
		mapperClient.connect();
		
		if(mapperClient.isConnected().booleanValue()) {
			hs.setWebServices(ontInterchangeName, ontInterchangeVersion,
					ontNativeName, ontNativeVersion, mapperClient);
			
			String[] translations = hs.run("directreputation", null);
			if(translations != null) {
				for(int i = 0; i < translations.length; i++) {
					System.out.println(translations[i]);
				}
			}
			
			mapperClient.disconnect();
		}
	}
}