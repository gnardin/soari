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

public interface DatabaseInterface{
	
	/**
	 * Returns if the connection to the database is established
	 * 
	 * @param none
	 * @return true - if it is connected; false - otherwise
	 */
	public Boolean isConnected();
	

	/**
	 * Setup the database parameter values
	 * 
	 * @param configuration
	 *          List of parameters required for the database startup
	 * @return none
	 */
	public void setup(Object configuration);
	

	/**
	 * Startup an database connection
	 * 
	 * @param none
	 * @return none
	 */
	public void startup();
	

	/**
	 * Shutdown the database instance
	 * 
	 * @param none
	 * @return none
	 */
	public void shutdown();
	

	/**
	 * Returns the rows that match to the query expression
	 * 
	 * @param expression
	 *          Query to be executed in the database
	 * @return Result set
	 */
	public ResultSet query(SQLExpressionInterface expression);
	

	/**
	 * Updates the rows in the database
	 * 
	 * @param expression
	 *          Update command to be executed in the database
	 * @return Number of rows affected by the update
	 */
	public Integer update(SQLExpressionInterface expression);
}
