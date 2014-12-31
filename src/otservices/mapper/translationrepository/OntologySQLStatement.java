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
package otservices.mapper.translationrepository;

import org.apache.log4j.Logger;
import otservices.util.database.SQLExpressionHSQLImpl;
import otservices.util.database.SQLStatementInterface;

<<<<<<< HEAD
public class OntologySQLStatement implements SQLStatementInterface {
=======
public class OntologySQLStatement implements SQLStatementInterface{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	// Responsible for the logging
	private static Logger	logger	= Logger.getLogger(OntologySQLStatement.class
																		.getName());
	
	
	/**
	 * Construct the delete statement to delete the ontologies that matches with
	 * the parameter's content
	 * 
	 * @param where
	 *          Ontology parameters to compose the delete statement
	 * @return Delete SQL Statement for the Ontology
	 */
	@Override
<<<<<<< HEAD
	public SQLExpressionHSQLImpl delete(Object where) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof Ontology) {
			String whereClause = this.parseWhere((Ontology) where);
			
			if(whereClause == null) {
				exp.setSQLExpression("DELETE FROM ONTOLOGY");
			} else {
=======
	public SQLExpressionHSQLImpl delete(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof Ontology){
			String whereClause = this.parseWhere((Ontology) where);
			
			if(whereClause == null){
				exp.setSQLExpression("DELETE FROM ONTOLOGY");
			}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				exp.setSQLExpression("DELETE FROM ONTOLOGY WHERE " + whereClause);
			}
			
			logger.debug("DELETE SQL STATEMENT = " + exp.getSQLExpression());
			
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("[DELETE] Parameter object is not an Ontology object");
		}
		
		return exp;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the insert statement to insert the ontology set as the
	 * parameter's content
	 * 
	 * @param reg
	 *          Ontology to compose the insert statement
	 * @return Insert SQL Statement for the Ontology
	 */
	@Override
<<<<<<< HEAD
	public SQLExpressionHSQLImpl insert(Object reg) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(reg instanceof Ontology) {
			
			if(((Ontology) reg).getDescription() != null) {
=======
	public SQLExpressionHSQLImpl insert(Object reg){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(reg instanceof Ontology){
			
			if(((Ontology) reg).getDescription() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				exp.setSQLExpression("INSERT INTO ONTOLOGY (ID,ONTTYPE,ONTURI,ONTVERSION,ONTDESCRIPTION) VALUES (NULL,"
						+ ((Ontology) reg).getType()
						+ ",'"
						+ ((Ontology) reg).getUri()
						+ "',"
						+ ((Ontology) reg).getVersion().toString()
						+ ",'"
						+ ((Ontology) reg).getDescription() + "')");
<<<<<<< HEAD
			} else {
=======
			}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				exp.setSQLExpression("INSERT INTO ONTOLOGY (ID,ONTTYPE,ONTURI,ONTVERSION) VALUES (NULL,"
						+ ((Ontology) reg).getType()
						+ ",'"
						+ ((Ontology) reg).getUri()
						+ "'," + ((Ontology) reg).getVersion().toString() + ")");
			}
			
			logger.debug("INSERT SQL STATEMENT = " + exp.getSQLExpression());
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("[INSERT] Parameter is not an Ontology object");
		}
		
		return exp;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the select statement to select the ontologies that matches with
	 * the parameter's content
	 * 
	 * @param where
	 *          Ontology parameters to compose the select statement
	 * @return Select SQL Statement for the Ontology
	 */
	@Override
<<<<<<< HEAD
	public SQLExpressionHSQLImpl select(Object where) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof Ontology) {
			String whereClause = this.parseWhere((Ontology) where);
			
			if(whereClause == null) {
				exp.setSQLExpression("SELECT * FROM ONTOLOGY");
			} else {
=======
	public SQLExpressionHSQLImpl select(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof Ontology){
			String whereClause = this.parseWhere((Ontology) where);
			
			if(whereClause == null){
				exp.setSQLExpression("SELECT * FROM ONTOLOGY");
			}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				exp.setSQLExpression("SELECT * FROM ONTOLOGY WHERE " + whereClause);
			}
			
			logger.debug("SELECT SQL STATEMENT = " + exp.getSQLExpression());
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("[SELECT] Parameter is not an Ontology object");
		}
		
		return exp;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the update statement to update the ontologies that matches with
	 * the parameter's content
	 * 
	 * @param where
	 *          Ontology parameters to compose the update statement
	 * @param values
	 *          Values to compose the update statement
	 * @return Update SQL Statement for the Ontology
	 */
	@Override
<<<<<<< HEAD
	public SQLExpressionHSQLImpl update(Object where, Object values) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if((where instanceof OntRelation) && (values instanceof OntRelation)) {
			String whereClause = this.parseWhere((Ontology) where);
			String setClause = this.parseSet((Ontology) values);
			
			if(setClause != null) {
				
				if(whereClause == null) {
					exp.setSQLExpression("UPDATE ONTOLOGY SET " + setClause);
				} else {
=======
	public SQLExpressionHSQLImpl update(Object where, Object values){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if((where instanceof OntRelation) && (values instanceof OntRelation)){
			String whereClause = this.parseWhere((Ontology) where);
			String setClause = this.parseSet((Ontology) values);
			
			if(setClause != null){
				
				if(whereClause == null){
					exp.setSQLExpression("UPDATE ONTOLOGY SET " + setClause);
				}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					exp.setSQLExpression("UPDATE ONTOLOGY SET " + setClause + " WHERE "
							+ whereClause);
				}
				
				logger.debug("UPDATE SQL STATEMENT = " + exp.getSQLExpression());
<<<<<<< HEAD
			} else {
				logger.error("[UPDATE] Set clause is NULL");
			}
		} else {
=======
			}else{
				logger.error("[UPDATE] Set clause is NULL");
			}
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("[UPDATE] Parameters are not Ontology objects");
		}
		
		return exp;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Based on the Ontology object compose the SET part of the insert SQL
	 * statement
	 * 
	 * @param set
	 *          Parameters to compose the SET part of the insert SQL statement
	 * @return SET part of the insert SQL statement composed
	 */
<<<<<<< HEAD
	private String parseSet(Ontology set) {
=======
	private String parseSet(Ontology set){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		String clause = null;
		
		if(set.getId() != null)
			clause = "ID = " + set.getId();
		
<<<<<<< HEAD
		if(set.getType() != null) {
=======
		if(set.getType() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTTYPE = " + set.getType();
			else
				clause = clause + ", ONTTYPE = " + set.getType();
		}
		
<<<<<<< HEAD
		if(set.getUri() != null) {
=======
		if(set.getUri() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTURI = '" + set.getUri() + "'";
			else
				clause = clause + ", ONTURI = '" + set.getUri() + "'";
		}
		
<<<<<<< HEAD
		if(set.getVersion() != null) {
=======
		if(set.getVersion() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTVERSION = " + set.getVersion().toString();
			else
				clause = clause + ", ONTVERSION = " + set.getVersion().toString();
		}
		
<<<<<<< HEAD
		if(set.getDescription() != null) {
=======
		if(set.getDescription() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTDESCRIPTION = '" + set.getDescription() + "'";
			else
				clause = clause + ", ONTDESCRIPTION = '" + set.getDescription() + "'";
		}
		
		logger.debug("SET CLAUSE = " + clause);
		
		return clause;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Based on the Ontology object compose the WHERE part of the select, delete
	 * and update SQL statement
	 * 
	 * @param where
	 *          Parameters to compose the WHERE part of the select, delete and
	 *          update SQL statement
	 * @return WHERE part of the select, delete and update SQL statement
	 *         composed
	 */
<<<<<<< HEAD
	private String parseWhere(Ontology where) {
=======
	private String parseWhere(Ontology where){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		String clause = null;
		
		if(where.getId() != null)
			clause = "ID = " + where.getId();
		
<<<<<<< HEAD
		if(where.getType() != null) {
=======
		if(where.getType() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTTYPE = " + where.getType();
			else
				clause = clause + ", ONTTYPE = '" + where.getType() + "'";
		}
		
<<<<<<< HEAD
		if(where.getUri() != null) {
=======
		if(where.getUri() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTURI = '" + where.getUri() + "'";
			else
				clause = clause + " AND ONTURI = '" + where.getUri() + "'";
		}
		
<<<<<<< HEAD
		if(where.getVersion() != null) {
=======
		if(where.getVersion() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTVERSION = " + where.getVersion().toString();
			else
				clause = clause + " AND ONTVERSION = " + where.getVersion().toString();
		}
		
<<<<<<< HEAD
		if(where.getDescription() != null) {
=======
		if(where.getDescription() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTDESCRIPTION = '" + where.getDescription() + "'";
			else
				clause = clause + " AND ONTDESCRIPTION = '" + where.getDescription()
						+ "'";
		}
		
		logger.debug("WHERE CLAUSE = " + clause);
		
		return clause;
	}
}