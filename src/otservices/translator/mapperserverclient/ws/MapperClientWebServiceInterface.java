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
package otservices.translator.mapperserverclient.ws;

import java.util.Map;
import otservices.mapper.translationrepository.Ontology;

<<<<<<< HEAD
public interface MapperClientWebServiceInterface {
=======
public interface MapperClientWebServiceInterface{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	/**
	 * Add an Ontology Translation into the Database
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @param ontFile
	 *          Ontology filename
	 * @return true - if the ontology translation was performed / false -
	 *         otherwise
	 */
	public Boolean addOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative, String ontFile);
	
	
	/**
	 * Connects the client to the server
	 * 
	 * @param none
	 * @return true - if successfully connected / false - otherwise
	 */
	public Boolean connect();
	
	
	/**
	 * Disconnects the client from the server
	 * 
	 * @param none
	 * @return none
	 */
	public void disconnect();
	
	
	/**
	 * Returns all mapping translation from an ontInterchange ontology to
	 * ontNative ontology
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return Returns an array containing all the translation for those
	 *         ontology relation
	 */
	public Map<String, String[]> getInterchangeNativeMapping(
			Ontology ontInterchange, Ontology ontNative);
	
	
	/**
	 * Download a OWL file to a local filesystem
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @param owlFilename
	 *          Absolute filename to save the file
	 * @return true - if download was successful / false - otherwise
	 */
	public Boolean getOWLFile(Ontology ontInterchange, Ontology ontNative,
			String owlFilename);
	
	
	/**
	 * Indicates if the client is connected to the server
	 * 
	 * @param none
	 * @return true - if it is connected / false - otherwise
	 */
	public Boolean isConnected();
	
	
	/**
	 * Verify if there is an Ontology Relation between the interchange ontology
	 * and the native ontology
	 * 
	 * @param ontInterchange
	 *          Intechange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return true - if there is an ontology relation / false - otherwise
	 */
	public Boolean isOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative);
	
	
	/**
	 * Remove an ontology translation from the translation repository
	 * 
	 * @param ontInterchange
	 *          Intechange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return true - if translation exists and it was removed / false -
	 *         otherwise
	 */
	public Boolean removeOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative);
	
	
	/**
	 * Set the Web Service URL
	 * 
	 * @param URL
	 *          Web Service URL
	 * @return none
	 */
	public void setURL(String URL);
	
	
	/**
	 * Returns a list of all the concepts that translate from fromConcept in
	 * ontFrom to ontTo
	 * 
	 * @param fromConcept
	 *          Concept to be translated
	 * @param ontFrom
	 *          Source ontology
	 * @param ontTo
	 *          Target ontology
	 * @return List of concepts related to the fromConcept
	 */
	public String[] translateConcept(String fromConcept, Ontology ontFrom,
			Ontology ontTo);
}
