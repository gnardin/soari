/**
 * Copyright (c) 2008-2011 Luis Gustavo Nardin <gnardin@gmail.com>
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
package otservices.util.database;

import java.sql.ResultSet;

<<<<<<< HEAD
public interface DatabaseInterface {
=======
public interface DatabaseInterface{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	/**
	 * Returns if the connection to the database is established
	 * 
	 * @param none
	 * @return true - if it is connected; false - otherwise
	 */
	public Boolean isConnected();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Setup the database parameter values
	 * 
	 * @param configuration
	 *          List of parameters required for the database startup
	 * @return none
	 */
	public void setup(Object configuration);
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Startup an database connection
	 * 
	 * @param none
	 * @return none
	 */
	public void startup();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Shutdown the database instance
	 * 
	 * @param none
	 * @return none
	 */
	public void shutdown();
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Returns the rows that match to the query expression
	 * 
	 * @param expression
	 *          Query to be executed in the database
	 * @return Result set
	 */
	public ResultSet query(SQLExpressionInterface expression);
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Updates the rows in the database
	 * 
	 * @param expression
	 *          Update command to be executed in the database
	 * @return Number of rows affected by the update
	 */
	public Integer update(SQLExpressionInterface expression);
}
