/**
<<<<<<< HEAD
 * Copyright (c) 2008 Luis Gustavo Nardin <gnardin@gmail.com>
=======
 * Copyright (c) 2008  Luis Gustavo Nardin <gnardin@gmail.com>
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
<<<<<<< HEAD
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
=======
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package otservices.translator.language;

import java.util.List;
import java.util.Map;
<<<<<<< HEAD
import otservices.translator.language.sparql.MapTable;
import otservices.translator.valuetransformation.ValueTransformationInterface;

public interface ObjectInterface {
	
=======

import otservices.translator.language.sparql.MapTable;
import otservices.translator.valuetransformation.ValueTransformationInterface;

public interface ObjectInterface{

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public List<String> getConcepts();
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public String getMessage();
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public MapTable getMapTable();
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public String getSender();
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public Integer getMessageType();
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setMapTable(MapTable mapTable);
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void setSender(String sender);
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void updateConcepts(Map<String, String[]> concepts);
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void update(ObjectInterface parsedObject);
<<<<<<< HEAD
	
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void updateValue(String concept,
			ValueTransformationInterface valueTransformation, Boolean inOut);
}