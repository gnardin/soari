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

public class OntTranslation{

	// Ontology Mapping Identification
	private Integer	ID			= null;

	// Ontology relation identification
	private Integer	ontRelID	= null;

	// From concept
	private String	fromConcept	= null;

	// To concept
	private String	toConcept	= null;

	/**
	 * Return the ontology translation ID
	 * 
	 * @param none
	 * @return Ontology translation ID
	 */
	public Integer getId(){
		return this.ID;
	}

	/**
	 * Return ontology relation ID
	 * 
	 * @param none
	 * @return Ontology relation ID
	 */
	public Integer getRelationID(){
		return this.ontRelID;
	}

	/**
	 * Return the from concept
	 * 
	 * @param none
	 * @return From concept
	 */
	public String getFromConcept(){
		return this.fromConcept;
	}

	/**
	 * Return the to concept
	 * 
	 * @param none
	 * @return To concept
	 */
	public String getToConcept(){
		return this.toConcept;
	}

	/**
	 * Set the ontology translation ID
	 * 
	 * @param ID
	 *            Ontology translation ID
	 * @return none
	 */
	public void setId(Integer ID){
		this.ID = ID;
	}

	/**
	 * Set the ontology relation ID
	 * 
	 * @param ID
	 *            Ontology relation ID
	 * @return none
	 */
	public void setRelationID(Integer ontRelID){
		this.ontRelID = ontRelID;
	}

	/**
	 * Set the from concept
	 * 
	 * @param fromConcept
	 *            From concept
	 * @return none
	 */
	public void setFromConcept(String fromConcept){
		this.fromConcept = fromConcept;
	}

	/**
	 * Set the to concept
	 * 
	 * @param toConcept
	 *            To concept
	 * @return none
	 */
	public void setToConcept(String toConcept){
		this.toConcept = toConcept;
	}
}
