/**
 * Copyright (c) 2008 Luis Gustavo Nardin <gnardin@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package otservices.translator.strategy.impl;

import otservices.translator.mapperserverclient.ws.MapperClientWebServiceInterface;
import otservices.translator.strategy.TranslationStrategyInterface;

<<<<<<< HEAD
public class DefaultStrategy implements TranslationStrategyInterface {
	
=======
public class DefaultStrategy implements TranslationStrategyInterface{

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public String[] run(String concept, String[] translations) {
		String[] result = new String[1];
		
		if(translations == null) {
			result[0] = concept;
		} else {
			if(translations.length > 0) {
				result[0] = translations[0];
			}
		}
		
		return result;
	}
	
	
=======
	public String[] run(String concept, String[] translations){
		String[] result = new String[1];

		if (translations == null){
			result[0] = concept;
		}else{
			if (translations.length > 0){
				result[0] = translations[0];
			}
		}

		return result;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	@Override
	public void setWebServices(String ontInterchangeName,
			Integer ontInterchangeVersion, String ontNativeName,
<<<<<<< HEAD
			Integer ontNativeVersion, MapperClientWebServiceInterface mapperClient) {
=======
			Integer ontNativeVersion, MapperClientWebServiceInterface mapperClient){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	}
}