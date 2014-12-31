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
package otservices.mapper.webservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.activation.DataHandler;
import otservices.mapper.translationrepository.Ontology;

public interface MapperServerWebServiceInterface extends Remote {
	
	/**
	 * Add an Ontology Translation into the Database
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @param ontFile
	 *          Ontology filename
	 * @param dh
	 *          File data handler
	 * @return true - if the ontology translation was performed / false -
	 *         otherwise
	 * @throws RemoteException
	 */
	public Boolean addOntologyTranslation(Ontology ontInterchange,
			Ontology ontNative, String ontFile, DataHandler dataHandler)
			throws RemoteException;
	
	
	/**
	 * Returns all From concepts for the ontology relation
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return Returns a list containing all the From concepts for the ontology
	 *         relation
	 */
	public String[] getFromMapping(Ontology ontInterchange, Ontology ontNative);
	
	
	/**
	 * Returns a data handler representing the ontology relation file
	 * 
	 * @param ontInterchange
	 *          Interchange ontology
	 * @param ontNative
	 *          Native ontology
	 * @return Returns file containing all the concepts for those ontology
	 *         relation in OWL format
	 */
	public DataHandler getOWLFile(Ontology ontInterchange, Ontology ontNative);
	
	
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
	public MapperList translateConcept(String fromConcept, Ontology ontFrom,
			Ontology ontTo);
}