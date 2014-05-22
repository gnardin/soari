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
package otservices.mapper.translationrepository;

public class OntRelation{

	// Ontology Relation Identification
	private Integer	ID					= null;

	// Interchange ontology
	private Integer	interchangeOntology	= null;

	// Native ontology
	private Integer	nativeOntology		= null;

	// Mapped Ontology filename
	private String	ontFilename			= null;

	/**
	 * Return the ontology relation ID
	 * 
	 * @param none
	 * @return Ontology relation ID
	 */
	public Integer getId(){
		return this.ID;
	}

	/**
	 * Return the interchange ontology ID that composes the relation
	 * 
	 * @param none
	 * @return Interchange ontology ID
	 */
	public Integer getInterchangeOntology(){
		return this.interchangeOntology;
	}

	/**
	 * Return the native ontology ID that composes the relation
	 * 
	 * @param none
	 * @return Native ontology ID
	 */
	public Integer getNativeOntology(){
		return this.nativeOntology;
	}

	/**
	 * Return the mapping ontology OWL filename
	 * 
	 * @param none
	 * @return Mapping ontology OWL filename
	 */
	public String getFilename(){
		return this.ontFilename;
	}

	/**
	 * Set the ontology relation ID
	 * 
	 * @param ID
	 *            Ontology relation ID
	 * @return none
	 */
	public void setId(Integer ID){
		this.ID = ID;
	}

	/**
	 * Set the interchange ontology ID that composes the relation
	 * 
	 * @param ontA
	 *            Ontology ID of the interchange ontology that composes the
	 *            relation
	 * @return none
	 */
	public void setInterchangeOntology(Integer interchangeOntology){
		this.interchangeOntology = interchangeOntology;
	}

	/**
	 * Set the native ontology ID that composes the relation
	 * 
	 * @param ontB
	 *            Ontology ID of the native ontology that composes the relation
	 * @return none
	 */
	public void setNativeOntology(Integer nativeOntology){
		this.nativeOntology = nativeOntology;
	}

	/**
	 * Set the mapping ontology OWL filename
	 * 
	 * @param ontFilename
	 *            Mapping ontology OWL filename
	 * @return none
	 */
	public void setFilename(String ontFilename){
		this.ontFilename = ontFilename;
	}
}
