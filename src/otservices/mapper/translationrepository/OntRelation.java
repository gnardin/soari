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
public class OntRelation {
	
	// Ontology Relation Identification
	private Integer	ID									= null;
	
	// Interchange ontology
	private Integer	interchangeOntology	= null;
	
	// Native ontology
	private Integer	nativeOntology			= null;
	
	// Mapped Ontology filename
	private String	ontFilename					= null;
	
	
=======
public class OntRelation{

	// Ontology Relation Identification
	private Integer	ID					= null;

	// Interchange ontology
	private Integer	interchangeOntology	= null;

	// Native ontology
	private Integer	nativeOntology		= null;

	// Mapped Ontology filename
	private String	ontFilename			= null;

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the ontology relation ID
	 * 
	 * @param none
	 * @return Ontology relation ID
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
	 * Return the interchange ontology ID that composes the relation
	 * 
	 * @param none
	 * @return Interchange ontology ID
	 */
<<<<<<< HEAD
	public Integer getInterchangeOntology() {
		return this.interchangeOntology;
	}
	
	
=======
	public Integer getInterchangeOntology(){
		return this.interchangeOntology;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the native ontology ID that composes the relation
	 * 
	 * @param none
	 * @return Native ontology ID
	 */
<<<<<<< HEAD
	public Integer getNativeOntology() {
		return this.nativeOntology;
	}
	
	
=======
	public Integer getNativeOntology(){
		return this.nativeOntology;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the mapping ontology OWL filename
	 * 
	 * @param none
	 * @return Mapping ontology OWL filename
	 */
<<<<<<< HEAD
	public String getFilename() {
		return this.ontFilename;
	}
	
	
=======
	public String getFilename(){
		return this.ontFilename;
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
	public void setId(Integer ID) {
		this.ID = ID;
	}
	
	
=======
	 *            Ontology relation ID
	 * @return none
	 */
	public void setId(Integer ID){
		this.ID = ID;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the interchange ontology ID that composes the relation
	 * 
	 * @param ontA
<<<<<<< HEAD
	 *          Ontology ID of the interchange ontology that composes the
	 *          relation
	 * @return none
	 */
	public void setInterchangeOntology(Integer interchangeOntology) {
		this.interchangeOntology = interchangeOntology;
	}
	
	
=======
	 *            Ontology ID of the interchange ontology that composes the
	 *            relation
	 * @return none
	 */
	public void setInterchangeOntology(Integer interchangeOntology){
		this.interchangeOntology = interchangeOntology;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the native ontology ID that composes the relation
	 * 
	 * @param ontB
<<<<<<< HEAD
	 *          Ontology ID of the native ontology that composes the relation
	 * @return none
	 */
	public void setNativeOntology(Integer nativeOntology) {
		this.nativeOntology = nativeOntology;
	}
	
	
=======
	 *            Ontology ID of the native ontology that composes the relation
	 * @return none
	 */
	public void setNativeOntology(Integer nativeOntology){
		this.nativeOntology = nativeOntology;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the mapping ontology OWL filename
	 * 
	 * @param ontFilename
<<<<<<< HEAD
	 *          Mapping ontology OWL filename
	 * @return none
	 */
	public void setFilename(String ontFilename) {
=======
	 *            Mapping ontology OWL filename
	 * @return none
	 */
	public void setFilename(String ontFilename){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.ontFilename = ontFilename;
	}
}
