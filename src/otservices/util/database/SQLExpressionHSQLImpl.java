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

import org.apache.log4j.Logger;

public class SQLExpressionHSQLImpl implements SQLExpressionInterface {
	
	// Stores the SQL expression
	private String				expression	= null;
	
	// Expression empty
	private Boolean				empty				= new Boolean(true);
	
	// Responsible for the logging
	private static Logger	logger			= Logger
																				.getLogger(SQLExpressionHSQLImpl.class
																						.getName());
	
	
	/**
	 * Returns the SQL Expression stored
	 * 
	 * @param none
	 * @return SQL expression
	 */
	@Override
	public String getSQLExpression() {
		logger.debug("SQL Expression = " + this.expression);
		
		return this.expression;
	}
	
	
	/**
	 * Set the SQL expression to be validated
	 * 
	 * @param expression
	 *          SQL expression to be stored
	 * @return none
	 */
	@Override
	public void setSQLExpression(String expression) {
		logger.debug("Setting SQL Expression = " + expression);
		
		this.expression = expression;
		this.empty = new Boolean(false);
	}
	
	
	/**
	 * Determine if the expression is empty
	 * 
	 * @param none
	 * @return true - if it is empty; false - otherwise
	 */
	@Override
	public Boolean isEmpty() {
		return this.empty;
	}
	
	
	/**
	 * Determine if the expression is a query (SELECT)
	 * 
	 * @param none
	 * @return true - if the expression is a query; false - otherwise
	 */
	@Override
	public Boolean isQuery() {
		logger.debug("isQuery() = true");
		
		return new Boolean(true);
	}
	
	
	/**
	 * Determines if the expression is an update (INSERT, UPDATE, DELETE)
	 * 
	 * @param none
	 * @return true - if the expression is an update; false - otherwise
	 */
	@Override
	public Boolean isUpdate() {
		logger.debug("isUpdate() = true");
		
		return new Boolean(true);
	}
	
	
	/**
	 * Validates the SQL expression based on the SQL Statements supported by the
	 * database system for which the implementation class was developed
	 * 
	 * @param none
	 * @return true - if the SQL expression is valid; false - if the SQL
	 *         expression is not valid
	 */
	@Override
	public Boolean isValid() {
		logger.debug("isValid() = true");
		
		return new Boolean(true);
	}
}
