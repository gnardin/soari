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

public class OntologySQLStatement implements SQLStatementInterface{
	
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
	public SQLExpressionHSQLImpl delete(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof Ontology){
			String whereClause = this.parseWhere((Ontology) where);
			
			if(whereClause == null){
				exp.setSQLExpression("DELETE FROM ONTOLOGY");
			}else{
				exp.setSQLExpression("DELETE FROM ONTOLOGY WHERE " + whereClause);
			}
			
			logger.debug("DELETE SQL STATEMENT = " + exp.getSQLExpression());
			
		}else{
			logger.error("[DELETE] Parameter object is not an Ontology object");
		}
		
		return exp;
	}
	

	/**
	 * Construct the insert statement to insert the ontology set as the
	 * parameter's content
	 * 
	 * @param reg
	 *          Ontology to compose the insert statement
	 * @return Insert SQL Statement for the Ontology
	 */
	@Override
	public SQLExpressionHSQLImpl insert(Object reg){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(reg instanceof Ontology){
			
			if(((Ontology) reg).getDescription() != null){
				exp.setSQLExpression("INSERT INTO ONTOLOGY (ID,ONTTYPE,ONTURI,ONTVERSION,ONTDESCRIPTION) VALUES (NULL,"
						+ ((Ontology) reg).getType()
						+ ",'"
						+ ((Ontology) reg).getUri()
						+ "',"
						+ ((Ontology) reg).getVersion().toString()
						+ ",'"
						+ ((Ontology) reg).getDescription() + "')");
			}else{
				exp.setSQLExpression("INSERT INTO ONTOLOGY (ID,ONTTYPE,ONTURI,ONTVERSION) VALUES (NULL,"
						+ ((Ontology) reg).getType()
						+ ",'"
						+ ((Ontology) reg).getUri()
						+ "'," + ((Ontology) reg).getVersion().toString() + ")");
			}
			
			logger.debug("INSERT SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger.error("[INSERT] Parameter is not an Ontology object");
		}
		
		return exp;
	}
	

	/**
	 * Construct the select statement to select the ontologies that matches with
	 * the parameter's content
	 * 
	 * @param where
	 *          Ontology parameters to compose the select statement
	 * @return Select SQL Statement for the Ontology
	 */
	@Override
	public SQLExpressionHSQLImpl select(Object where){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if(where instanceof Ontology){
			String whereClause = this.parseWhere((Ontology) where);
			
			if(whereClause == null){
				exp.setSQLExpression("SELECT * FROM ONTOLOGY");
			}else{
				exp.setSQLExpression("SELECT * FROM ONTOLOGY WHERE " + whereClause);
			}
			
			logger.debug("SELECT SQL STATEMENT = " + exp.getSQLExpression());
		}else{
			logger.error("[SELECT] Parameter is not an Ontology object");
		}
		
		return exp;
	}
	

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
	public SQLExpressionHSQLImpl update(Object where, Object values){
		SQLExpressionHSQLImpl exp = new SQLExpressionHSQLImpl();
		
		if((where instanceof OntRelation) && (values instanceof OntRelation)){
			String whereClause = this.parseWhere((Ontology) where);
			String setClause = this.parseSet((Ontology) values);
			
			if(setClause != null){
				
				if(whereClause == null){
					exp.setSQLExpression("UPDATE ONTOLOGY SET " + setClause);
				}else{
					exp.setSQLExpression("UPDATE ONTOLOGY SET " + setClause + " WHERE "
							+ whereClause);
				}
				
				logger.debug("UPDATE SQL STATEMENT = " + exp.getSQLExpression());
			}else{
				logger.error("[UPDATE] Set clause is NULL");
			}
		}else{
			logger.error("[UPDATE] Parameters are not Ontology objects");
		}
		
		return exp;
	}
	

	/**
	 * Based on the Ontology object compose the SET part of the insert SQL
	 * statement
	 * 
	 * @param set
	 *          Parameters to compose the SET part of the insert SQL statement
	 * @return SET part of the insert SQL statement composed
	 */
	private String parseSet(Ontology set){
		String clause = null;
		
		if(set.getId() != null)
			clause = "ID = " + set.getId();
		
		if(set.getType() != null){
			if(clause == null)
				clause = "ONTTYPE = " + set.getType();
			else
				clause = clause + ", ONTTYPE = " + set.getType();
		}
		
		if(set.getUri() != null){
			if(clause == null)
				clause = "ONTURI = '" + set.getUri() + "'";
			else
				clause = clause + ", ONTURI = '" + set.getUri() + "'";
		}
		
		if(set.getVersion() != null){
			if(clause == null)
				clause = "ONTVERSION = " + set.getVersion().toString();
			else
				clause = clause + ", ONTVERSION = " + set.getVersion().toString();
		}
		
		if(set.getDescription() != null){
			if(clause == null)
				clause = "ONTDESCRIPTION = '" + set.getDescription() + "'";
			else
				clause = clause + ", ONTDESCRIPTION = '" + set.getDescription() + "'";
		}
		
		logger.debug("SET CLAUSE = " + clause);
		
		return clause;
	}
	

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
	private String parseWhere(Ontology where){
		String clause = null;
		
		if(where.getId() != null)
			clause = "ID = " + where.getId();
		
		if(where.getType() != null){
			if(clause == null)
				clause = "ONTTYPE = " + where.getType();
			else
				clause = clause + ", ONTTYPE = '" + where.getType() + "'";
		}
		
		if(where.getUri() != null){
			if(clause == null)
				clause = "ONTURI = '" + where.getUri() + "'";
			else
				clause = clause + " AND ONTURI = '" + where.getUri() + "'";
		}
		
		if(where.getVersion() != null){
			if(clause == null)
				clause = "ONTVERSION = " + where.getVersion().toString();
			else
				clause = clause + " AND ONTVERSION = " + where.getVersion().toString();
		}
		
		if(where.getDescription() != null){
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