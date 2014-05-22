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

public interface SQLStatementInterface{
	
	/**
	 * 
	 */
	public SQLExpressionHSQLImpl insert(Object reg);
	

	/**
	 * Construct the delete statement
	 * 
	 * @param where
	 *          Parameter content that compose the delete statement
	 * @return Delete SQL Statement
	 */
	public SQLExpressionHSQLImpl delete(Object where);
	

	/**
	 * Construct the select statement
	 * 
	 * @param where
	 *          Parameter content that compose the select statement
	 * @return Select SQL Statement
	 */
	public SQLExpressionHSQLImpl select(Object where);
	

	/**
	 * Construct the update statement
	 * 
	 * @param where
	 *          Parameter content that compose the update statement
	 * @param values
	 *          Values to update the content of the registers filtered by
	 *          where
	 * @return Update SQL Statement
	 */
	public SQLExpressionHSQLImpl update(Object where, Object values);
}