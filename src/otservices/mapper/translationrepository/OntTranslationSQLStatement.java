/**
<<<<<<< HEAD
 * Copyright (c) 2008 Luis Gustavo Nardin <gnardin@gmail.com>
=======
 * Copyright (c) 2008  Luis Gustavo Nardin <gnardin@gmail.com>
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
<<<<<<< HEAD
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
=======
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package otservices.mapper.translationrepository;

import org.apache.log4j.Logger;
<<<<<<< HEAD
import otservices.util.database.SQLExpressionHSQLImpl;
import otservices.util.database.SQLStatementInterface;

public class OntTranslationSQLStatement implements SQLStatementInterface {
	
	// Responsible for the logging
	private static Logger	logger	= Logger
																		.getLogger(OntTranslationSQLStatement.class
																				.getName());
	
	
=======

import otservices.util.database.SQLExpressionHSQLImpl;
import otservices.util.database.SQLStatementInterface;

public class OntTranslationSQLStatement implements SQLStatementInterface{

	// Responsible for the logging
	private static Logger	logger	= Logger
											.getLogger(OntTranslationSQLStatement.class
													.getName());

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the delete statement to delete the ontologies translation that
	 * matches with the parameter's content
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Ontology translation parameters to compose the delete
	 *          statement
	 * @return Delete SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl delete(Object where) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof OntTranslation) {
			String whereClause = this.parseWhere((OntTranslation) where);
			
			if(whereClause == null) {
				exp.setSQLExpression("DELETE FROM ONTTRANSLATION");
			} else {
				exp.setSQLExpression("DELETE FROM ONTTRANSLATION WHERE " + whereClause);
			}
			
			logger.debug("DELETE SQL STATEMENT = " + exp.getSQLExpression());
		} else {
			logger.error("[DELETE] Parameter object is not an OntTranslation object");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology translation parameters to compose the delete
	 *            statement
	 * @return Delete SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl delete(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if(where instanceof OntTranslation){
			String whereClause = this.parseWhere((OntTranslation) where);

			if(whereClause == null){
				exp.setSQLExpression("DELETE FROM ONTTRANSLATION");
			}else{
				exp.setSQLExpression("DELETE FROM ONTTRANSLATION WHERE "
						+ whereClause);
			}

			logger.debug("DELETE SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger
					.error("[DELETE] Parameter object is not an OntTranslation object");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the insert statement to insert the ontology translation set as
	 * the parameter's content
	 * 
	 * @param reg
<<<<<<< HEAD
	 *          Ontology Translation to compose the insert statement
	 * @return Insert SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl insert(Object reg) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(reg instanceof OntTranslation) {
			
			exp.setSQLExpression("INSERT INTO ONTTRANSLATION (ID,ONTRELID,FROMCONCEPT,TOCONCEPT) VALUES (NULL,"
					+ ((OntTranslation) reg).getRelationID().toString()
					+ ",'"
					+ ((OntTranslation) reg).getFromConcept()
					+ "','"
					+ ((OntTranslation) reg).getToConcept() + "')");
			
			logger.debug("INSERT SQL STATEMENT = " + exp.getSQLExpression());
		} else {
			logger.error("[INSERT] Parameter object is not an OntTranslation object");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology Translation to compose the insert statement
	 * @return Insert SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl insert(Object reg){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if(reg instanceof OntTranslation){

			exp
					.setSQLExpression("INSERT INTO ONTTRANSLATION (ID,ONTRELID,FROMCONCEPT,TOCONCEPT) VALUES (NULL,"
							+ ((OntTranslation) reg).getRelationID().toString()
							+ ",'"
							+ ((OntTranslation) reg).getFromConcept()
							+ "','"
							+ ((OntTranslation) reg).getToConcept()
							+ "')");

			logger.debug("INSERT SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger
					.error("[INSERT] Parameter object is not an OntTranslation object");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the select statement to select the ontologies translation that
	 * matches with the parameter's content
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Ontology Translation parameters to compose the select
	 *          statement
	 * @return Select SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl select(Object where) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof OntTranslation) {
			String whereClause = this.parseWhere((OntTranslation) where);
			
			if(whereClause == null) {
				exp.setSQLExpression("SELECT * FROM ONTTRANSLATION");
			} else {
				exp.setSQLExpression("SELECT * FROM ONTTRANSLATION WHERE "
						+ whereClause);
			}
			
			logger.debug("SELECT SQL STATEMENT = " + exp.getSQLExpression());
		} else {
			logger.error("[SELECT] Parameter object is not an OntTranslation object");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology Translation parameters to compose the select
	 *            statement
	 * @return Select SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl select(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if(where instanceof OntTranslation){
			String whereClause = this.parseWhere((OntTranslation) where);

			if(whereClause == null){
				exp.setSQLExpression("SELECT * FROM ONTTRANSLATION");
			}else{
				exp.setSQLExpression("SELECT * FROM ONTTRANSLATION WHERE "
						+ whereClause);
			}

			logger.debug("SELECT SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger
					.error("[SELECT] Parameter object is not an OntTranslation object");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the update statement to update the ontologies translation that
	 * matches with the parameter's content
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Ontology Translation parameters to compose the update
	 *          statement
	 * @param values
	 *          Values to compose the update statement
	 * @return Update SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl update(Object where, Object values) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if((where instanceof OntTranslation) && (values instanceof OntTranslation)) {
			String whereClause = this.parseWhere((OntTranslation) where);
			String setClause = this.parseSet((OntTranslation) values);
			
			if(setClause != null) {
				
				if(whereClause == null) {
					exp.setSQLExpression("UPDATE ONTTRANSLATION SET " + setClause);
				} else {
					exp.setSQLExpression("UPDATE ONTTRANSLATION SET " + setClause
							+ " WHERE " + whereClause);
				}
				
				logger.debug("UPDATE SQL STATEMENT = " + exp.getSQLExpression());
			} else {
				logger.error("[UPDATE] Set clause is NULL");
			}
		} else {
			logger.error("[UPDATE] Parameters are not OntTranslation objects");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology Translation parameters to compose the update
	 *            statement
	 * @param values
	 *            Values to compose the update statement
	 * @return Update SQL Statement for the Ontology Translation
	 */
	public SQLExpressionHSQLImpl update(Object where, Object values){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if((where instanceof OntTranslation)
				&& (values instanceof OntTranslation)){
			String whereClause = this.parseWhere((OntTranslation) where);
			String setClause = this.parseSet((OntTranslation) values);

			if(setClause != null){

				if(whereClause == null){
					exp.setSQLExpression("UPDATE ONTTRANSLATION SET "
							+ setClause);
				}else{
					exp.setSQLExpression("UPDATE ONTTRANSLATION SET "
							+ setClause + " WHERE " + whereClause);
				}

				logger
						.debug("UPDATE SQL STATEMENT = "
								+ exp.getSQLExpression());
			}else{
				logger.error("[UPDATE] Set clause is NULL");
			}
		}else{
			logger.error("[UPDATE] Parameters are not OntTranslation objects");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Based on the Ontology Translation object compose the SET part of the
	 * insert SQL statement
	 * 
	 * @param set
<<<<<<< HEAD
	 *          Parameters to compose the SET part of the insert SQL statement
	 * @return SET part of the insert SQL statement composed
	 */
	private String parseSet(OntTranslation set) {
		String clause = null;
		
		if(set.getId() != null)
			clause = "ID = " + set.getId();
		
		if(set.getRelationID() != null) {
			if(clause == null)
				clause = "ONTRELID = " + set.getRelationID().toString();
			else
				clause = clause + ", ONTRELID = " + set.getRelationID().toString();
		}
		
		if(set.getFromConcept() != null) {
			if(clause == null)
				clause = "FROMCONCEPT = '" + set.getFromConcept() + "'";
			else
				clause = clause + ", FROMCONCEPT = '" + set.getFromConcept() + "'";
		}
		
		if(set.getToConcept() != null) {
=======
	 *            Parameters to compose the SET part of the insert SQL statement
	 * @return SET part of the insert SQL statement composed
	 */
	private String parseSet(OntTranslation set){
		String clause = null;

		if(set.getId() != null)
			clause = "ID = " + set.getId();

		if(set.getRelationID() != null){
			if(clause == null)
				clause = "ONTRELID = " + set.getRelationID().toString();
			else
				clause = clause + ", ONTRELID = "
						+ set.getRelationID().toString();
		}

		if(set.getFromConcept() != null){
			if(clause == null)
				clause = "FROMCONCEPT = '" + set.getFromConcept() + "'";
			else
				clause = clause + ", FROMCONCEPT = '" + set.getFromConcept()
						+ "'";
		}

		if(set.getToConcept() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "TOCONCEPT = '" + set.getToConcept() + "'";
			else
				clause = clause + ", TOCONCEPT = '" + set.getToConcept() + "'";
		}
<<<<<<< HEAD
		
		logger.debug("SET CLAUSE = " + clause);
		
		return clause;
	}
	
	
=======

		logger.debug("SET CLAUSE = " + clause);

		return clause;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Based on the Ontology Translation object compose the WHERE part of the
	 * select, delete and update SQL statement
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Parameters to compose the WHERE part of the select, delete and
	 *          update SQL statement
	 * @return WHERE part of the select, delete and update SQL statement
	 *         composed
	 */
	private String parseWhere(OntTranslation where) {
		String clause = null;
		
		if(where.getId() != null)
			clause = "ID = " + where.getId();
		
		if(where.getRelationID() != null) {
			if(clause == null)
				clause = "ONTRELID = " + where.getRelationID().toString();
			else
				clause = clause + " AND ONTRELID = " + where.getRelationID().toString();
		}
		
		if(where.getFromConcept() != null) {
			if(clause == null)
				clause = " FROMCONCEPT = '" + where.getFromConcept() + "'";
			else
				clause = clause + " AND FROMCONCEPT = '" + where.getFromConcept() + "'";
		}
		
		if(where.getToConcept() != null) {
			if(clause == null)
				clause = "TOCONCEPT = '" + where.getToConcept() + "'";
			else
				clause = clause + " AND TOCONCEPT = '" + where.getToConcept() + "'";
		}
		
		logger.debug("WHERE CLAUSE = " + clause);
		
=======
	 *            Parameters to compose the WHERE part of the select, delete and
	 *            update SQL statement
	 * @return WHERE part of the select, delete and update SQL statement
	 *         composed
	 */
	private String parseWhere(OntTranslation where){
		String clause = null;

		if(where.getId() != null)
			clause = "ID = " + where.getId();

		if(where.getRelationID() != null){
			if(clause == null)
				clause = "ONTRELID = " + where.getRelationID().toString();
			else
				clause = clause + " AND ONTRELID = "
						+ where.getRelationID().toString();
		}

		if(where.getFromConcept() != null){
			if(clause == null)
				clause = " FROMCONCEPT = '" + where.getFromConcept() + "'";
			else
				clause = clause + " AND FROMCONCEPT = '"
						+ where.getFromConcept() + "'";
		}

		if(where.getToConcept() != null){
			if(clause == null)
				clause = "TOCONCEPT = '" + where.getToConcept() + "'";
			else
				clause = clause + " AND TOCONCEPT = '" + where.getToConcept()
						+ "'";
		}

		logger.debug("WHERE CLAUSE = " + clause);

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return clause;
	}
}