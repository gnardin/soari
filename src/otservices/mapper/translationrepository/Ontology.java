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
package otservices.mapper.translationrepository;

<<<<<<< HEAD
public class Ontology {
	
	// Ontology possible types
	public final static Integer	TYPE_INTERCHANGE	= new Integer(1);
	
	public final static Integer	TYPE_NATIVE				= new Integer(2);
	
	// Ontology Identification
	private Integer							ID								= null;
	
	// Ontology type
	private Integer							ontType						= null;
	
	// Ontology Name
	private String							ontUri						= null;
	
	// Ontology Version
	private Integer							ontVersion				= null;
	
	// Ontology Description
	private String							ontDescription		= null;
	
	
=======
public class Ontology{

	// Ontology possible types
	public final static Integer	TYPE_INTERCHANGE	= new Integer(1);
	public final static Integer	TYPE_NATIVE			= new Integer(2);

	// Ontology Identification
	private Integer					ID						= null;

	// Ontology type
	private Integer					ontType				= null;

	// Ontology Name
	private String						ontUri				= null;

	// Ontology Version
	private Integer					ontVersion			= null;

	// Ontology Description
	private String						ontDescription		= null;


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the ontology ID
	 * 
	 * @param none
	 * @return Ontology ID
	 */
<<<<<<< HEAD
	public Integer getId() {
		return this.ID;
	}
	
	
=======
	public Integer getId(){
		return this.ID;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the ontology Type (1 - Interchange / 2 - Native)
	 * 
	 * @param none
	 * @return Ontology Type
	 */
<<<<<<< HEAD
	public Integer getType() {
		return this.ontType;
	}
	
	
=======
	public Integer getType(){
		return this.ontType;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the ontology URI
	 * 
	 * @param none
	 * @return Ontology URI
	 */
<<<<<<< HEAD
	public String getUri() {
		return this.ontUri;
	}
	
	
=======
	public String getUri(){
		return this.ontUri;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return ontology version
	 * 
	 * @param none
	 * @return Ontology version
	 */
<<<<<<< HEAD
	public Integer getVersion() {
		return this.ontVersion;
	}
	
	
=======
	public Integer getVersion(){
		return this.ontVersion;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return ontology description
	 * 
	 * @param none
	 * @return Ontology description
	 */
<<<<<<< HEAD
	public String getDescription() {
		return this.ontDescription;
	}
	
	
=======
	public String getDescription(){
		return this.ontDescription;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the ontology ID
	 * 
	 * @param ontID
<<<<<<< HEAD
	 *          Ontology ID
	 * @return none
	 */
	public void setId(Integer ID) {
		this.ID = ID;
	}
	
	
=======
	 *        Ontology ID
	 * @return none
	 */
	public void setId(Integer ID){
		this.ID = ID;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the ontology Type (1 - Interchange / 2 - Native)
	 * 
	 * @param ontType
<<<<<<< HEAD
	 *          Ontology type
	 * @return none
	 */
	public void setType(Integer ontType) {
		if((ontType.intValue() >= Ontology.TYPE_INTERCHANGE.intValue())
				&& (ontType.intValue() <= Ontology.TYPE_NATIVE.intValue())) {
			this.ontType = ontType;
		}
	}
	
	
=======
	 *        Ontology type
	 * @return none
	 */
	public void setType(Integer ontType){
		if ((ontType.intValue() >= Ontology.TYPE_INTERCHANGE.intValue())
				&& (ontType.intValue() <= Ontology.TYPE_NATIVE.intValue())){
			this.ontType = ontType;
		}
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the ontology URI
	 * 
	 * @param ontURI
<<<<<<< HEAD
	 *          Ontology URI
	 * @return none
	 */
	public void setUri(String ontURI) {
		this.ontUri = ontURI;
	}
	
	
=======
	 *        Ontology URI
	 * @return none
	 */
	public void setUri(String ontURI){
		this.ontUri = ontURI;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the ontology version
	 * 
	 * @param ontVersion
<<<<<<< HEAD
	 *          Ontology version
	 * @return none
	 */
	public void setVersion(Integer ontVersion) {
		this.ontVersion = ontVersion;
	}
	
	
=======
	 *        Ontology version
	 * @return none
	 */
	public void setVersion(Integer ontVersion){
		this.ontVersion = ontVersion;
	}


>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the ontology description
	 * 
	 * @param ontDescription
<<<<<<< HEAD
	 *          Ontology description
	 * @return none
	 */
	public void setDescription(String ontDescription) {
=======
	 *        Ontology description
	 * @return none
	 */
	public void setDescription(String ontDescription){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.ontDescription = ontDescription;
	}
}
