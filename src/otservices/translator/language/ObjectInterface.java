/**
 * Copyright (c) 2008  Luis Gustavo Nardin <gnardin@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package otservices.translator.language;

import java.util.List;
import java.util.Map;

import otservices.translator.language.sparql.MapTable;
import otservices.translator.valuetransformation.ValueTransformationInterface;

public interface ObjectInterface{

	/**
	 * 
	 */
	public List<String> getConcepts();

	/**
	 * 
	 */
	public String getMessage();

	/**
	 * 
	 */
	public MapTable getMapTable();

	/**
	 * 
	 */
	public String getSender();

	/**
	 * 
	 */
	public Integer getMessageType();

	/**
	 * 
	 */
	public void setMapTable(MapTable mapTable);

	/**
	 * 
	 */
	public void setSender(String sender);

	/**
	 * 
	 */
	public void updateConcepts(Map<String, String[]> concepts);

	/**
	 * 
	 */
	public void update(ObjectInterface parsedObject);

	/**
	 * 
	 */
	public void updateValue(String concept,
			ValueTransformationInterface valueTransformation, Boolean inOut);
}