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
package otservices.mapper.reasoner;

import java.util.Collection;

<<<<<<< HEAD
public interface ReasonerInterface {
=======
public interface ReasonerInterface{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	/**
	 * Returns the OWL filename
	 * 
	 * @param none
	 * @return OWL filename
	 */
	public String getOWL();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Set the OWL filename
	 * 
	 * @param owlFilename
	 *          OWL filename
	 * @return true if file exists; false otherwise
	 */
	public Boolean setOWL(String owlFilename);
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Connect the module to the reasoner
	 * 
	 * @param none
	 * @return none
	 */
	public void connect();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return the reasoner connection status
	 * 
	 * @param none
	 * @return true if connected; false otherwise
	 */
	public Boolean isConnected();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Disconnects the module to the reasoner
	 * 
	 * @param none
	 * @return none
	 */
	public void disconnect();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Classify the ontology uploaded from the OWL file
	 * 
	 * @param none
	 * @return true if was possible to classify; false otherwise
	 */
	public Boolean classify();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Returns a list of inferred classes under a specific class
	 * 
	 * @param fromClass
	 *          Class under which the other classes are related
	 * @return List of inferred classes
	 */
	public Collection<String> getInferredClasses(String forClass);
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return a list of all asserted classes under this class
	 * 
	 * @param none
	 * @return List of all asserted classes
	 */
	public Collection<String> getAllAssertedClasses();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return a list of asserted classes under this class
	 * 
	 * @param forClass
	 *          Class under which the other classes are related
	 * @param all
	 *          true if all the asserted; false otherwise
	 * @return List of asserted classes
	 */
	public Collection<String> getAssertedClasses(String forClass, Boolean all);
}
