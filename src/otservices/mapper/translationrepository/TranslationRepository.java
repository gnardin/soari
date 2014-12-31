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

<<<<<<< HEAD
public class TranslationRepository {
=======
public class TranslationRepository{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
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
<<<<<<< HEAD
	public TranslationRepository(ConfigurationParser databaseConfiguration) {
=======
	public TranslationRepository(ConfigurationParser databaseConfiguration){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public void run() {
		if(databaseConfiguration != null) {
=======
	public void run(){
		if(databaseConfiguration != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public Boolean isConnected() {
=======
	public Boolean isConnected(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public Integer delete(Object where) {
=======
	public Integer delete(Object where){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Integer result = new Integer(0);
		
		logger.debug("TranslationRepository DELETE");
		
<<<<<<< HEAD
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
=======
		if(where instanceof Ontology){
			SQLStatementInterface expSQL = new OntologySQLStatement();
			result = db.update(expSQL.delete(where));
		}else if(where instanceof OntRelation){
			SQLStatementInterface expSQL = new OntRelationSQLStatement();
			result = db.update(expSQL.delete(where));
		}else if(where instanceof OntTranslation){
			SQLStatementInterface expSQL = new OntTranslationSQLStatement();
			result = db.update(expSQL.delete(where));
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public Integer insert(Object reg) {
=======
	public Integer insert(Object reg){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Integer result = new Integer(0);
		
		logger.debug("TranslationRepository INSERT");
		
<<<<<<< HEAD
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
=======
		if(reg instanceof Ontology){
			SQLStatementInterface expSQL = new OntologySQLStatement();
			result = db.update(expSQL.insert(reg));
		}else if(reg instanceof OntRelation){
			SQLStatementInterface expSQL = new OntRelationSQLStatement();
			result = db.update(expSQL.insert(reg));
		}else if(reg instanceof OntTranslation){
			SQLStatementInterface expSQL = new OntTranslationSQLStatement();
			result = db.update(expSQL.insert(reg));
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public List select(Object where) {
=======
	public List select(Object where){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		List result = new ArrayList();
		
		logger.debug("TranslationRepository SELECT");
		
<<<<<<< HEAD
		try {
			if(where instanceof Ontology) {
				SQLStatementInterface expSQL = new OntologySQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null) {
					Ontology reg;
					while(rs.next()) {
=======
		try{
			if(where instanceof Ontology){
				SQLStatementInterface expSQL = new OntologySQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null){
					Ontology reg;
					while(rs.next()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						reg = new Ontology();
						reg.setId(new Integer(rs.getInt("ID")));
						reg.setType(new Integer(rs.getInt("ONTTYPE")));
						reg.setUri(rs.getString("ONTURI"));
						reg.setVersion(new Integer(rs.getInt("ONTVERSION")));
						reg.setDescription(rs.getString("ONTDESCRIPTION"));
						
						result.add(reg);
					}
				}
<<<<<<< HEAD
			} else if(where instanceof OntRelation) {
				SQLStatementInterface expSQL = new OntRelationSQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null) {
					OntRelation reg;
					while(rs.next()) {
=======
			}else if(where instanceof OntRelation){
				SQLStatementInterface expSQL = new OntRelationSQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null){
					OntRelation reg;
					while(rs.next()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						reg = new OntRelation();
						reg.setId(new Integer(rs.getInt("ID")));
						reg.setInterchangeOntology(new Integer(rs.getInt("ONTINTERCHANGE")));
						reg.setNativeOntology(new Integer(rs.getInt("ONTNATIVE")));
						reg.setFilename(rs.getString("ONTFILENAME"));
						
						result.add(reg);
					}
				}
<<<<<<< HEAD
			} else if(where instanceof OntTranslation) {
				SQLStatementInterface expSQL = new OntTranslationSQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null) {
					OntTranslation reg;
					while(rs.next()) {
=======
			}else if(where instanceof OntTranslation){
				SQLStatementInterface expSQL = new OntTranslationSQLStatement();
				ResultSet rs = db.query(expSQL.select(where));
				
				if(rs != null){
					OntTranslation reg;
					while(rs.next()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						reg = new OntTranslation();
						reg.setId(new Integer(rs.getInt("ID")));
						reg.setRelationID(new Integer(rs.getInt("ONTRELID")));
						reg.setFromConcept(rs.getString("FROMCONCEPT"));
						reg.setToConcept(rs.getString("TOCONCEPT"));
						
						result.add(reg);
					}
				}
<<<<<<< HEAD
			} else {
				logger
						.error("[SELECT] WHERE is not an instance of any of the objects that can be treated");
			}
		} catch(SQLException sqle) {
=======
			}else{
				logger
						.error("[SELECT] WHERE is not an instance of any of the objects that can be treated");
			}
		}catch(SQLException sqle){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public void shutdown() {
		if(db.isConnected()) {
			logger.debug("Disconnected successfully");
			
			db.shutdown();
		} else {
=======
	public void shutdown(){
		if(db.isConnected()){
			logger.debug("Disconnected successfully");
			
			db.shutdown();
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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
<<<<<<< HEAD
	public Integer update(Object where, Object values) {
=======
	public Integer update(Object where, Object values){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Integer result = new Integer(0);
		
		logger.debug("TranslationRepository UPDATE");
		
<<<<<<< HEAD
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
=======
		if((where instanceof Ontology) && (values instanceof Ontology)){
			SQLStatementInterface expSQL = new OntologySQLStatement();
			result = db.update(expSQL.update(where, values));
		}else if((where instanceof OntRelation) && (values instanceof OntRelation)){
			SQLStatementInterface expSQL = new OntRelationSQLStatement();
			result = db.update(expSQL.update(where, values));
		}else if((where instanceof OntTranslation)
				&& (values instanceof OntTranslation)){
			SQLStatementInterface expSQL = new OntTranslationSQLStatement();
			result = db.update(expSQL.update(where, values));
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger
					.error("[UPDATE] WHERE or VALUES are not an instance of any of the objects that can be treated");
		}
		
		return result;
	}
}