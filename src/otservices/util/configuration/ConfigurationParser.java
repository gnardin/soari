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
package otservices.util.configuration;

import java.io.File;
import org.apache.log4j.Logger;

public class ConfigurationParser {
	
	// XML configuration file name
	private String								xmlConfigurationFilename	= null;
	
	// XSD schema configuration file name
	private String								xsdConfigurationFilename	= null;
	
	//
	private ConfigurationHandler	conf											= null;
	
	private static Logger					logger										= Logger
																															.getLogger(ConfigurationParser.class
																																	.getName());
	
	
	/**
	 * Empty constructor
	 * 
	 * @param none
	 * @return none
	 */
	public ConfigurationParser() {
	}
	
	
	/**
	 * Initializes the configuration parsing
	 * 
	 * @param xmlConfigurationFilename
	 *          XML configuration filename to parse
	 * @param xsdConfigurationFilename
	 *          XSD configuration schema specification filename
	 * @return none
	 */
	public ConfigurationParser(String xmlConfigurationFilename,
			String xsdConfigurationFilename)
			throws ConfigurationFileInvalidException,
			ConfigurationFileNotFoundException {
		if(((new File(xmlConfigurationFilename)).exists())
				&& ((new File(xsdConfigurationFilename)).exists())) {
			this.xmlConfigurationFilename = xmlConfigurationFilename;
			this.xsdConfigurationFilename = xsdConfigurationFilename;
			
			logger.debug("XML Configuration Filename = "
					+ this.xmlConfigurationFilename);
			logger.debug("XSD Configuration Schema Specification Filename = "
					+ this.xsdConfigurationFilename);
			
			this.parse();
		} else {
			logger.error(xmlConfigurationFilename + " and/or "
					+ xsdConfigurationFilename + " does not exist");
			
			if(!(new File(xmlConfigurationFilename).exists()))
				throw new ConfigurationFileNotFoundException(xmlConfigurationFilename);
			
			if(!(new File(xsdConfigurationFilename).exists()))
				throw new ConfigurationFileNotFoundException(xsdConfigurationFilename);
		}
	}
	
	
	/**
	 * Returns the content of a parameter
	 * 
	 * @param elementName
	 *          Name of the parameter to obtain its content
	 * @return Element content
	 */
	public Object get(String elementName)
			throws ConfigurationElementNotFoundException {
		
		logger.debug("Getting content of element name = " + elementName);
		
		Object value = null;
		if(conf != null)
			value = conf.getElement(elementName);
		else {
			logger.error("Element " + elementName + " not found");
			
			throw new ConfigurationElementNotFoundException("Element " + elementName
					+ " not found");
		}
		
		logger.debug("Element Name = " + elementName + "    Value = " + value);
		
		return value;
	}
	
	
	/**
	 * Return the XML configuration filename
	 * 
	 * @param none
	 * @return Configuration filename
	 */
	public String getXMLFilename() {
		
		logger.debug("XML Configuration Filename = "
				+ this.xmlConfigurationFilename);
		
		return this.xmlConfigurationFilename;
	}
	
	
	/**
	 * Return the XSD configuration schema specification filename
	 * 
	 * @param none
	 * @return XSD configuration schema specification filename
	 */
	public String getXSDFilename() {
		
		logger.debug("XSD Configuration Schema Specification Filename = "
				+ this.xsdConfigurationFilename);
		
		return this.xsdConfigurationFilename;
	}
	
	
	/**
	 * Parses the XML file
	 * 
	 * @param none
	 * @return none
	 * @throws ConfigurationFileInvalidException
	 */
	public void parse() throws ConfigurationFileInvalidException {
		conf = new ConfigurationHandler(this.xmlConfigurationFilename,
				this.xsdConfigurationFilename);
	}
	
	
	/**
	 * Set the configuration filename
	 * 
	 * @param xmlConfigurationFilename
	 *          Configuration filename
	 * @return true if the filename was set; false otherwise
	 * @throws ConfigurationFileNotFoundException
	 */
	public void setXMLFilename(String xmlConfigurationFilename)
			throws ConfigurationFileNotFoundException {
		if((new File(xmlConfigurationFilename)).exists()) {
			this.xmlConfigurationFilename = xmlConfigurationFilename;
			
			logger.debug("XML Configuration Filename = "
					+ this.xmlConfigurationFilename);
		} else {
			logger.error("XML Configuration Filename = " + xmlConfigurationFilename
					+ " does not exist");
			
			throw new ConfigurationFileNotFoundException();
		}
	}
	
	
	/**
	 * Set the XSD schema specification filename
	 * 
	 * @param xsdConfigurationFilename
	 *          Configuration schema specification filename
	 * @return none
	 * @throws ConfigurationFileNotFoundException
	 */
	public void setXSDFilename(String xsdConfigurationFilename)
			throws ConfigurationFileNotFoundException {
		if((new File(xsdConfigurationFilename)).exists()) {
			this.xsdConfigurationFilename = xsdConfigurationFilename;
			
			logger.debug("XSD Configuration Schema Specification Filename = "
					+ this.xsdConfigurationFilename);
		} else {
			logger.error("XSD Configuration Schema Specification Filename = "
					+ xsdConfigurationFilename + " does not exist");
			
			throw new ConfigurationFileNotFoundException();
		}
	}
}