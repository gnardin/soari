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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;
import otservices.util.configuration.ConfigurationElementNotFoundException;
import otservices.util.configuration.ConfigurationParser;

public class DatabaseHSQLImpl implements DatabaseInterface {
	
	// This is the shutdown "hook" which will be called when the JVM shuts
	// down from exit, control-C, etc.
	class ShutdownDB extends Thread {
		
		// Database connection
		private Connection	conn;
		
		
		/**
		 * Constructor closes a database connection because an unexpected exit
		 * 
		 * @param conn
		 *          Database connection active
		 * @return none
		 */
		public ShutdownDB(Connection conn) {
			this.conn = conn;
		}
		
		
		/**
		 * Shutdown the database connection after an unexpected exit
		 * 
		 * @param none
		 * @return none
		 */
		@Override
		public void run() {
			if(conn != null) {
				try {
					Statement stmt = conn.createStatement();
					stmt.executeUpdate("SHUTDOWN");
					conn.close();
				} catch(SQLException sqle) {
				}
			}
		}
	}
	
	// Stores the database configuration parameter values
	private ConfigurationParser	conf			= null;
	
	// Connection to the HSQL database
	private Connection					conn			= null;
	
	// Identify if the instance is or not connected to the HSQL database
	private Boolean							connected	= new Boolean(false);
	
	// Responsible for the logging
	private static Logger				logger		= Logger
																						.getLogger(DatabaseHSQLImpl.class
																								.getName());
	
	
	/**
	 * Empty constructor
	 * 
	 * @param none
	 * @return none
	 */
	public DatabaseHSQLImpl() {
	}
	
	
	/**
	 * Constructor
	 * 
	 * @param conf
	 *          Configuration parameter content
	 * @return none
	 */
	public DatabaseHSQLImpl(ConfigurationParser conf) {
		if(conf != null) {
			this.setup(conf);
		}
	}
	
	
	/**
	 * Returns the database connection status
	 * 
	 * @param none
	 * @return true - if it is connected; false - otherwise
	 */
	@Override
	public Boolean isConnected() {
		if(this.connected.booleanValue()) {
			logger.debug("HSQL database instance is connected");
		} else {
			logger.debug("HSQL database instance is not connected");
		}
		
		return this.connected;
	}
	
	
	/**
	 * Setup the database parameter values
	 * 
	 * @param configuration
	 *          List of parameters required for the database startup
	 * @return none
	 */
	@Override
	public void setup(Object configuration) {
		logger.debug("Setting up the HSQL configuration");
		
		if(configuration instanceof ConfigurationParser) {
			this.conf = (ConfigurationParser) configuration;
			
			logger.debug("HSQL configuration set");
		} else {
			logger
					.error("Configuration object is not a ConfigurationParser instance");
		}
	}
	
	
	/**
	 * Startup an database connection if the configuration is setup
	 * 
	 * @param none
	 * @return none
	 */
	@Override
	public void startup() {
		if((!this.isConnected().booleanValue()) && (conf != null)) {
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				
				logger.debug("Trying to connect to HSQL database");
				try {
					logger.debug("jdbc:hsqldb:file:" + ((String) conf.get("dbLocation"))
							+ "/" + ((String) conf.get("dbName")) + ","
							+ ((String) conf.get("dbUsername")));
					logger.debug("dbLocation.: " + ((String) conf.get("dbLocation")));
					logger.debug("dbName.....: " + ((String) conf.get("dbName")));
					logger.debug("dbUsername.: " + ((String) conf.get("dbUsername")));
					
					conn = DriverManager.getConnection(
							"jdbc:hsqldb:file://" + ((String) conf.get("dbLocation")) + "/"
									+ ((String) conf.get("dbName")) + ";ifexists=true",
							((String) conf.get("dbUsername")),
							((String) conf.get("dbPassword")));
				} catch(ConfigurationElementNotFoundException cenfe) {
					logger
							.error("ConfigurationElementNotFoundException Message " + cenfe);
					
					cenfe.printStackTrace();
				}
				
				this.connected = new Boolean(true);
				
				// Shutdown the database connection in case of an unexpected
				// exit
				Runtime.getRuntime().addShutdownHook(new ShutdownDB(this.conn));
				
				logger.debug("Successfuly connected to HSQL database");
			} catch(ClassNotFoundException cnfe) {
				logger.error("ClassNotFoundException Message" + cnfe);
				cnfe.printStackTrace();
			} catch(SQLException sqle) {
				logger.error("SQLException Message" + sqle);
				sqle.printStackTrace();
			}
		}
	}
	
	
	/**
	 * Shutdown the database instance
	 * 
	 * @param none
	 * @return none
	 */
	@Override
	public void shutdown() {
		if(this.isConnected().booleanValue()) {
			try {
				logger.debug("Trying to shutdown HSQL database");
				
				Statement stmt = conn.createStatement();
				stmt.executeUpdate("SHUTDOWN");
				conn.close();
				this.connected = new Boolean(false);
				
				logger.debug("HSQL database shutdown successfuly");
			} catch(SQLException sqle) {
				logger.error("SQLExpression Message" + sqle);
			}
		}
	}
	
	
	/**
	 * Returns the rows that match to the query expression
	 * 
	 * @param expression
	 *          Query to be executed in the database
	 * @return none
	 */
	@Override
	public ResultSet query(SQLExpressionInterface expression) {
		if((this.isConnected().booleanValue())
				&& (expression instanceof SQLExpressionHSQLImpl)) {
			
			if((expression.isValid().booleanValue())
					&& (expression.isQuery().booleanValue())) {
				try {
					Statement stmt = conn.createStatement();
					
					logger.debug("Query SQL Expression " + expression.getSQLExpression());
					
					ResultSet rs = stmt.executeQuery(expression.getSQLExpression());
					
					return rs;
				} catch(SQLException sqle) {
					logger.error("SQLExpression Message " + sqle);
				}
			} else {
				logger
						.error("Expression is not valid and/or expression is not a Query");
			}
		} else {
			logger
					.error("HSQL database is not connected and/or expression is not a instance of HSQLDBExpression");
		}
		
		return null;
	}
	
	
	/**
	 * Updates the rows in the database
	 * 
	 * @param expression
	 *          Update command to be executed in the database
	 * @return none
	 */
	@Override
	public Integer update(SQLExpressionInterface expression) {
		Integer rs = new Integer(0);
		
		if((this.isConnected().booleanValue())
				&& (expression instanceof SQLExpressionHSQLImpl)) {
			
			if((expression.isValid().booleanValue())
					&& (expression.isUpdate().booleanValue())) {
				try {
					Statement stmt = conn.createStatement();
					
					logger.debug("Update SQL Expression");
					logger.debug(expression.getSQLExpression());
					
					rs = new Integer(stmt.executeUpdate(expression.getSQLExpression()));
					
					logger.debug("Update Result = " + rs);
					
				} catch(SQLException sqle) {
					logger.error("SQLExpression Message " + sqle);
				}
			} else {
				logger
						.error("Expression is not valid and/or expression is not a Query");
			}
		} else {
			logger
					.error("HSQL database is not connected and/or expression is not a instance of HSQLDBExpression");
		}
		return rs;
	}
}