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
package otservices.mapper.translationrepository;

<<<<<<< HEAD
public class OntTranslation {
	
	// Ontology Mapping Identification
	private Integer	ID					= null;
	
	// Ontology relation identification
	private Integer	ontRelID		= null;
	
	// From concept
	private String	fromConcept	= null;
	
	// To concept
	private String	toConcept		= null;
	
	
=======
public class OntTranslation{

	// Ontology Mapping Identification
	private Integer	ID			= null;

	// Ontology relation identification
	private Integer	ontRelID	= null;

	// From concept
	private String	fromConcept	= null;

	// To concept
	private String	toConcept	= null;

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the ontology translation ID
	 * 
	 * @param none
	 * @return Ontology translation ID
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
	 * Return ontology relation ID
	 * 
	 * @param none
	 * @return Ontology relation ID
	 */
<<<<<<< HEAD
	public Integer getRelationID() {
		return this.ontRelID;
	}
	
	
=======
	public Integer getRelationID(){
		return this.ontRelID;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the from concept
	 * 
	 * @param none
	 * @return From concept
	 */
<<<<<<< HEAD
	public String getFromConcept() {
		return this.fromConcept;
	}
	
	
=======
	public String getFromConcept(){
		return this.fromConcept;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the to concept
	 * 
	 * @param none
	 * @return To concept
	 */
<<<<<<< HEAD
	public String getToConcept() {
		return this.toConcept;
	}
	
	
=======
	public String getToConcept(){
		return this.toConcept;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the ontology translation ID
	 * 
	 * @param ID
<<<<<<< HEAD
	 *          Ontology translation ID
	 * @return none
	 */
	public void setId(Integer ID) {
		this.ID = ID;
	}
	
	
=======
	 *            Ontology translation ID
	 * @return none
	 */
	public void setId(Integer ID){
		this.ID = ID;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the ontology relation ID
	 * 
	 * @param ID
<<<<<<< HEAD
	 *          Ontology relation ID
	 * @return none
	 */
	public void setRelationID(Integer ontRelID) {
		this.ontRelID = ontRelID;
	}
	
	
=======
	 *            Ontology relation ID
	 * @return none
	 */
	public void setRelationID(Integer ontRelID){
		this.ontRelID = ontRelID;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the from concept
	 * 
	 * @param fromConcept
<<<<<<< HEAD
	 *          From concept
	 * @return none
	 */
	public void setFromConcept(String fromConcept) {
		this.fromConcept = fromConcept;
	}
	
	
=======
	 *            From concept
	 * @return none
	 */
	public void setFromConcept(String fromConcept){
		this.fromConcept = fromConcept;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the to concept
	 * 
	 * @param toConcept
<<<<<<< HEAD
	 *          To concept
	 * @return none
	 */
	public void setToConcept(String toConcept) {
=======
	 *            To concept
	 * @return none
	 */
	public void setToConcept(String toConcept){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.toConcept = toConcept;
	}
}
