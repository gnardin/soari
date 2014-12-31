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

public class OntRelationSQLStatement implements SQLStatementInterface {
	
	// Responsible for the logging
	private static Logger	logger	= Logger
																		.getLogger(OntRelationSQLStatement.class
																				.getName());
	
	
=======

import otservices.util.database.SQLExpressionHSQLImpl;
import otservices.util.database.SQLStatementInterface;

public class OntRelationSQLStatement implements SQLStatementInterface{

	// Responsible for the logging
	private static Logger	logger	= Logger
											.getLogger(OntRelationSQLStatement.class
													.getName());

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the delete statement to delete the ontologies relation that
	 * matches with the parameter's content
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Ontology relation parameters to compose the delete statement
	 * @return Delete SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl delete(Object where) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof OntRelation) {
			String whereClause = this.parseWhere((OntRelation) where);
			
			if(whereClause == null) {
				exp.setSQLExpression("DELETE FROM ONTRELATION");
			} else {
				exp.setSQLExpression("DELETE FROM ONTRELATION WHERE " + whereClause);
			}
			
			logger.debug("DELETE SQL STATEMENT = " + exp.getSQLExpression());
		} else {
			logger.error("[DELETE] Parameter object is not an OntRelation object");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology relation parameters to compose the delete statement
	 * @return Delete SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl delete(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if(where instanceof OntRelation){
			String whereClause = this.parseWhere((OntRelation) where);

			if(whereClause == null){
				exp.setSQLExpression("DELETE FROM ONTRELATION");
			}else{
				exp.setSQLExpression("DELETE FROM ONTRELATION WHERE "
						+ whereClause);
			}

			logger.debug("DELETE SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger
					.error("[DELETE] Parameter object is not an OntRelation object");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the insert statement to insert the ontology relation set as the
	 * parameter's content
	 * 
	 * @param reg
<<<<<<< HEAD
	 *          Ontology Relation to compose the insert statement
	 * @return Insert SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl insert(Object reg) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(reg instanceof OntRelation) {
			
			exp.setSQLExpression("INSERT INTO ONTRELATION (ID,ONTINTERCHANGE,ONTNATIVE,ONTFILENAME) VALUES (NULL,"
					+ ((OntRelation) reg).getInterchangeOntology().toString()
					+ ","
					+ ((OntRelation) reg).getNativeOntology().toString()
					+ ",'"
					+ ((OntRelation) reg).getFilename() + "')");
			
			logger.debug("INSERT SQL STATEMENT = " + exp.getSQLExpression());
		} else {
			logger.error("[INSERT] Parameter object is not an OntRelation object");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology Relation to compose the insert statement
	 * @return Insert SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl insert(Object reg){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if(reg instanceof OntRelation){

			exp
					.setSQLExpression("INSERT INTO ONTRELATION (ID,ONTINTERCHANGE,ONTNATIVE,ONTFILENAME) VALUES (NULL,"
							+ ((OntRelation) reg).getInterchangeOntology()
									.toString()
							+ ","
							+ ((OntRelation) reg).getNativeOntology()
									.toString()
							+ ",'"
							+ ((OntRelation) reg).getFilename() + "')");

			logger.debug("INSERT SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger
					.error("[INSERT] Parameter object is not an OntRelation object");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the select statement to select the ontologies relation that
	 * matches with the parameter's content
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Ontology Relation parameters to compose the select statement
	 * @return Select SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl select(Object where) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof OntRelation) {
			String whereClause = this.parseWhere((OntRelation) where);
			
			if(whereClause == null) {
				exp.setSQLExpression("SELECT * FROM ONTRELATION");
			} else {
				exp.setSQLExpression("SELECT * FROM ONTRELATION WHERE " + whereClause);
			}
			
			logger.debug("SELECT SQL STATEMENT = " + exp.getSQLExpression());
		} else {
			logger.error("[SELECT] Parameter object is not an OntRelation object");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology Relation parameters to compose the select statement
	 * @return Select SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl select(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if(where instanceof OntRelation){
			String whereClause = this.parseWhere((OntRelation) where);

			if(whereClause == null){
				exp.setSQLExpression("SELECT * FROM ONTRELATION");
			}else{
				exp.setSQLExpression("SELECT * FROM ONTRELATION WHERE "
						+ whereClause);
			}

			logger.debug("SELECT SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger
					.error("[SELECT] Parameter object is not an OntRelation object");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Construct the update statement to update the ontologies relation that
	 * matches with the parameter's content
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Ontology Relation parameters to compose the update statement
	 * @param values
	 *          Values to compose the update statement
	 * @return Update SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl update(Object where, Object values) {
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if((where instanceof OntRelation) && (values instanceof OntRelation)) {
			String whereClause = this.parseWhere((OntRelation) where);
			String setClause = this.parseSet((OntRelation) values);
			
			if(setClause != null) {
				
				if(whereClause == null) {
					exp.setSQLExpression("UPDATE ONTRELATION SET " + setClause);
				} else {
					exp.setSQLExpression("UPDATE ONTRELATION SET " + setClause
							+ " WHERE " + whereClause);
				}
				
				logger.debug("UPDATE SQL STATEMENT = " + exp.getSQLExpression());
			} else {
				logger.error("[UPDATE] Set clause is NULL");
			}
		} else {
			logger.error("[UPDATE] Parameters are not OntRelation objects");
		}
		
		return exp;
	}
	
	
=======
	 *            Ontology Relation parameters to compose the update statement
	 * @param values
	 *            Values to compose the update statement
	 * @return Update SQL Statement for the Ontology Relation
	 */
	public SQLExpressionHSQLImpl update(Object where, Object values){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();

		if((where instanceof OntRelation) && (values instanceof OntRelation)){
			String whereClause = this.parseWhere((OntRelation) where);
			String setClause = this.parseSet((OntRelation) values);

			if(setClause != null){

				if(whereClause == null){
					exp.setSQLExpression("UPDATE ONTRELATION SET " + setClause);
				}else{
					exp.setSQLExpression("UPDATE ONTRELATION SET " + setClause
							+ " WHERE " + whereClause);
				}

				logger
						.debug("UPDATE SQL STATEMENT = "
								+ exp.getSQLExpression());
			}else{
				logger.error("[UPDATE] Set clause is NULL");
			}
		}else{
			logger.error("[UPDATE] Parameters are not OntRelation objects");
		}

		return exp;
	}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Based on the Ontology Relation object compose the SET part of the insert
	 * SQL statement
	 * 
	 * @param set
<<<<<<< HEAD
	 *          Parameters to compose the SET part of the insert SQL statement
	 * @return SET part of the insert SQL statement composed
	 */
	private String parseSet(OntRelation set) {
		String clause = null;
		
		if(set.getId() != null)
			clause = "ID = " + set.getId();
		
		if(set.getInterchangeOntology() != null) {
			if(clause == null)
				clause = "ONTINTERCHANGE = " + set.getInterchangeOntology().toString();
=======
	 *            Parameters to compose the SET part of the insert SQL statement
	 * @return SET part of the insert SQL statement composed
	 */
	private String parseSet(OntRelation set){
		String clause = null;

		if(set.getId() != null)
			clause = "ID = " + set.getId();

		if(set.getInterchangeOntology() != null){
			if(clause == null)
				clause = "ONTINTERCHANGE = "
						+ set.getInterchangeOntology().toString();
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			else
				clause = clause + ", ONTINTERCHANGE = "
						+ set.getInterchangeOntology().toString();
		}
<<<<<<< HEAD
		
		if(set.getNativeOntology() != null) {
			if(clause == null)
				clause = "ONTNATIVE = " + set.getNativeOntology().toString();
			else
				clause = clause + ", ONTNATIVE = " + set.getNativeOntology().toString();
		}
		
		if(set.getFilename() != null) {
=======

		if(set.getNativeOntology() != null){
			if(clause == null)
				clause = "ONTNATIVE = " + set.getNativeOntology().toString();
			else
				clause = clause + ", ONTNATIVE = "
						+ set.getNativeOntology().toString();
		}

		if(set.getFilename() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTFILENAME = " + set.getFilename();
			else
				clause = clause + ", ONTFILENAME = " + set.getFilename();
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
	 * Based on the Ontology Relation object compose the WHERE part of the
	 * select, delete and update SQL statement
	 * 
	 * @param where
<<<<<<< HEAD
	 *          Parameters to compose the WHERE part of the select, delete and
	 *          update SQL statement
	 * @return WHERE part of the select, delete and update SQL statement
	 *         composed
	 */
	private String parseWhere(OntRelation where) {
		String clause = null;
		
		if(where.getId() != null)
			clause = "ID = " + where.getId();
		
		if(where.getInterchangeOntology() != null) {
=======
	 *            Parameters to compose the WHERE part of the select, delete and
	 *            update SQL statement
	 * @return WHERE part of the select, delete and update SQL statement
	 *         composed
	 */
	private String parseWhere(OntRelation where){
		String clause = null;

		if(where.getId() != null)
			clause = "ID = " + where.getId();

		if(where.getInterchangeOntology() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTINTERCHANGE = "
						+ where.getInterchangeOntology().toString();
			else
				clause = clause + " AND ONTINTERCHANGE = "
						+ where.getInterchangeOntology().toString();
		}
<<<<<<< HEAD
		
		if(where.getNativeOntology() != null) {
=======

		if(where.getNativeOntology() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			if(clause == null)
				clause = "ONTNATIVE = " + where.getNativeOntology().toString();
			else
				clause = clause + " AND ONTNATIVE = "
						+ where.getNativeOntology().toString();
		}
<<<<<<< HEAD
		
		if(where.getFilename() != null) {
			if(clause == null)
				clause = "ONTFILENAME = '" + where.getFilename() + "'";
			else
				clause = clause + " AND ONTFILENAME = '" + where.getFilename() + "'";
		}
		
		logger.debug("WHERE CLAUSE = " + clause);
		
=======

		if(where.getFilename() != null){
			if(clause == null)
				clause = "ONTFILENAME = '" + where.getFilename() + "'";
			else
				clause = clause + " AND ONTFILENAME = '" + where.getFilename()
						+ "'";
		}

		logger.debug("WHERE CLAUSE = " + clause);

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return clause;
	}
}