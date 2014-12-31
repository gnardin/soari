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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import otservices.util.configuration.ConfigurationParser;
import otservices.util.database.DatabaseHSQLImpl;
import otservices.util.database.DatabaseInterface;
import otservices.util.database.SQLStatementInterface;

public class TranslationRepository {
	
	// Database Configuration
	private ConfigurationParser	databaseConfiguration	= null;
	
	// Database connection
	private DatabaseInterface		db										= null;
	
	// Connection
	private Boolean							conn									= null;
	
	// Responsible for the logging
	private static Logger				logger								= Logger
																												.getLogger(TranslationRepository.class
																														.getName());
	
	
	/**
	 * Constructor that initializes the database configuration parameters
	 * 
	 * @param databaseConfiguration
	 *          Database configuration parameters
	 * @return none
	 */
	public TranslationRepository(ConfigurationParser databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
		
		logger.debug("databaseConfiguration is set");
	}
	
	
	/**
	 * Initializes the database based on the parameters set in the database
	 * configuration
	 * 
	 * @param none
	 * @return none
	 */
	public void run() {
		if(databaseConfiguration != null) {
			logger.debug("Setting up database");
			
			db = new DatabaseHSQLImpl();
			db.setup(this.databaseConfiguration);
			
			logger.debug("Starting up database");
			
			db.startup();
			
			this.conn = db.isConnected();
			
			logger.debug("Database Connected = " + this.conn.toString());
		}
	}
	
	
	/**
	 * Returns if the connection to the database is active
	 * 
	 * @param none
	 * @return true - if it is connected; false - otherwise
	 */
	public Boolean isConnected() {
		logger.debug("Database Connected = " + this.conn.toString());
		
		return this.conn;
	}
	
	
	/**
	 * Deletes records from the database
	 * 
	 * @param where
	 *          Parameters that will compose the WHERE of the delete SQL
	 *          statement
	 * @return Number of records affected
	 */
	public Integer delete(Object where) {
		Integer result = new Integer(0);
		
		logger.debug("TranslationRepository DELETE");
		
		if(where instanceof Ontology) {
			SQLStatementInterface expSQL = new OntologySQLStatement();
			result = db.update(expSQL.delete(where));
		} else if(where instanceof OntRelation) {
			SQLStatementInterface expSQL = new OntRelationSQLStatement();
			result = db.update(expSQL.delete(where));
		} else if(where instanceof OntTranslation) {
			SQLStatementInterface expSQL = new OntTranslationSQLStatement();
			result = db.update(expSQL.delete(where));
		} else {
			logger
					.error("[DELETE] WHERE is not an instance of any of the objects that can be treated");
		}
		
		return result;
	}
	
	
	/**
	 * Insert a record into the database
	 * 
	 * @param reg
	 *          Record to be inserted
	 * @return Number of records affected
	 */
	public Integer insert(Object reg) {
		Integer result = new Integer(0);
		
		logger.debug("TranslationRepository INSERT");
		
		if(reg instanceof Ontology) {
			SQLStatementInterface expSQL = new OntologySQLStatement();
			result = db.update(expSQL.insert(reg));
		} else if(reg instanceof OntRelation) {
			SQLStatementInterface expSQL = new OntRelationSQLStatement();
			result = db.update(expSQL.insert(reg));
		} else if(reg instanceof OntTranslation) {
			SQLStatementInterface expSQL = new OntTranslationSQLStatement();
			result = db.update(expSQL.insert(reg));
		} else {
			logger
					.error("[INSERT] REG is not an instance of any of the objects that can be treated");
		}
		
		return result;
	}
	
	
	/**
	 * Retrieve the records from the database
	 * 
	 * @param where
	 *          Parameters that will compose the WHERE of the select SQL
	 *          statement
	 * @return List of records found in the database
	 */
	@SuppressWarnings("unchecked")
	public List select(Object where) {
		List result = new ArrayList();
		
		logger.debug("TranslationRepository SELECT");
		
		try {
			if(where instanceof Ontology) {
				SQLStatementInterface expSQL = new OntologySQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null) {
					Ontology reg;
					while(rs.next()) {
						reg = new Ontology();
						reg.setId(new Integer(rs.getInt("ID")));
						reg.setType(new Integer(rs.getInt("ONTTYPE")));
						reg.setUri(rs.getString("ONTURI"));
						reg.setVersion(new Integer(rs.getInt("ONTVERSION")));
						reg.setDescription(rs.getString("ONTDESCRIPTION"));
						
						result.add(reg);
					}
				}
			} else if(where instanceof OntRelation) {
				SQLStatementInterface expSQL = new OntRelationSQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null) {
					OntRelation reg;
					while(rs.next()) {
						reg = new OntRelation();
						reg.setId(new Integer(rs.getInt("ID")));
						reg.setInterchangeOntology(new Integer(rs.getInt("ONTINTERCHANGE")));
						reg.setNativeOntology(new Integer(rs.getInt("ONTNATIVE")));
						reg.setFilename(rs.getString("ONTFILENAME"));
						
						result.add(reg);
					}
				}
			} else if(where instanceof OntTranslation) {
				SQLStatementInterface expSQL = new OntTranslationSQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null) {
					OntTranslation reg;
					while(rs.next()) {
						reg = new OntTranslation();
						reg.setId(new Integer(rs.getInt("ID")));
						reg.setRelationID(new Integer(rs.getInt("ONTRELID")));
						reg.setFromConcept(rs.getString("FROMCONCEPT"));
						reg.setToConcept(rs.getString("TOCONCEPT"));
						
						result.add(reg);
					}
				}
			} else {
				logger
						.error("[SELECT] WHERE is not an instance of any of the objects that can be treated");
			}
		} catch(SQLException sqle) {
			logger.error("SQLException Message " + sqle);
		}
		
		return result;
	}
	
	
	/**
	 * Shutdown the translation repository
	 * 
	 * @param none
	 * @return none
	 */
	public void shutdown() {
		if(db.isConnected()) {
			logger.debug("Disconnected successfully");
			
			db.shutdown();
		} else {
			logger.debug("It was not connected");
		}
	}
	
	
	/**
	 * Update records into the database
	 * 
	 * @param where
	 *          Parameters that will compose the WHERE of the update SQL
	 *          statement
	 * @param values
	 *          Parameters that will be updated in the records filtered
	 * @return Number of records affected
	 */
	public Integer update(Object where, Object values) {
		Integer result = new Integer(0);
		
		logger.debug("TranslationRepository UPDATE");
		
		if((where instanceof Ontology) && (values instanceof Ontology)) {
			SQLStatementInterface expSQL = new OntologySQLStatement();
			result = db.update(expSQL.update(where, values));
		} else if((where instanceof OntRelation) && (values instanceof OntRelation)) {
			SQLStatementInterface expSQL = new OntRelationSQLStatement();
			result = db.update(expSQL.update(where, values));
		} else if((where instanceof OntTranslation)
				&& (values instanceof OntTranslation)) {
			SQLStatementInterface expSQL = new OntTranslationSQLStatement();
			result = db.update(expSQL.update(where, values));
		} else {
			logger
					.error("[UPDATE] WHERE or VALUES are not an instance of any of the objects that can be treated");
		}
		
		return result;
	}
}