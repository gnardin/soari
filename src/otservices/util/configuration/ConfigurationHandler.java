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

<<<<<<< HEAD
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSType;
import com.sun.xml.xsom.parser.XSOMParser;
=======
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
<<<<<<< HEAD
import javax.xml.XMLConstants;
=======
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
<<<<<<< HEAD
=======
import javax.xml.XMLConstants;
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
<<<<<<< HEAD

public class ConfigurationHandler {
=======
import com.sun.xml.xsom.XSComplexType;
import com.sun.xml.xsom.XSContentType;
import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSModelGroup;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSType;
import com.sun.xml.xsom.parser.XSOMParser;
import otservices.util.configuration.ConfigurationFileInvalidException;

public class ConfigurationHandler{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	// Configuration elements
	private Map<String, Object>	confElements	= new Hashtable<String, Object>();
	
	// XML root element
	private Element							rootElement		= null;
	
	// XML filename
	private String							xmlFilename		= null;
	
	// XSD filename
	private String							xsdFilename		= null;
	
	// Responsible for the logging
	private static Logger				logger				= Logger
																								.getLogger(ConfigurationHandler.class
																										.getName());
	
	
	/**
	 * Constructor that initializes the XMLHandler
	 * 
	 * @param xmlFilename
	 *          XML filename to parse
	 * @param xsdFilename
	 *          XSD schema specification
	 * @return none
	 */
	public ConfigurationHandler(String xmlFilename, String xsdFilename)
<<<<<<< HEAD
			throws ConfigurationFileInvalidException {
=======
			throws ConfigurationFileInvalidException{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.xmlFilename = xmlFilename;
		this.xsdFilename = xsdFilename;
		
		// Verify the XML validity
		this.isValid();
		
		this.confElements = new Hashtable<String, Object>();
		
		// Obtain value of XML elements
		this.processXML();
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Return a element value
	 * 
	 * @param elementName
	 *          Name of the element to look for the value
	 * @return Element value
	 * @throws ConfigurationElementNotFoundException
	 */
	public Object getElement(String elementName)
<<<<<<< HEAD
			throws ConfigurationElementNotFoundException {
=======
			throws ConfigurationElementNotFoundException{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		Object value = this.confElements.get(elementName);
		
		logger.debug("Element Value = [" + value + "]");
		
<<<<<<< HEAD
		if(value == null) {
=======
		if(value == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("Element " + elementName + " not found");
			
			throw new ConfigurationElementNotFoundException("Element " + elementName
					+ " was not found");
		}
		
		return value;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Returns the mapping of all the elements and values
	 * 
	 * @param none
	 * @return Map of all the elements and values
	 */
<<<<<<< HEAD
	public Map<String, Object> getResult() {
		return this.confElements;
	}
	
	
=======
	public Map<String, Object> getResult(){
		return this.confElements;
	}
	

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Take a tag name, look for the tag and get the text content
	 * 
	 * @param tagName
	 *          Tag name to look for the text content
	 * @return Tag text content
	 */
<<<<<<< HEAD
	private String getRootValue(String tagName) {
=======
	private String getRootValue(String tagName){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		logger.debug("Getting content from tag = " + tagName);
		
		String value = null;
		NodeList n = rootElement.getElementsByTagName(tagName);
<<<<<<< HEAD
		if((n != null) && (n.getLength() > 0)) {
=======
		if((n != null) && (n.getLength() > 0)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			Element el = (Element) n.item(0);
			if(el.hasChildNodes())
				value = el.getFirstChild().getNodeValue();
			else
				value = "";
			
			logger.debug("Tag Content = [" + value + "]");
			
<<<<<<< HEAD
		} else {
=======
		}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("Tag " + tagName + " does not exist");
		}
		
		return value;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Verify if the XML is valid regarding the XSD schema specification
	 * 
	 * @param none
	 * @return none
	 * @throws ConfigurationFileInvalidException
	 */
<<<<<<< HEAD
	private void isValid() throws ConfigurationFileInvalidException {
=======
	private void isValid() throws ConfigurationFileInvalidException{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		logger.debug("Verifying if " + this.xmlFilename + " is valid based on "
				+ this.xsdFilename + " schema specification ");
		
		SchemaFactory factory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		
<<<<<<< HEAD
		try {
=======
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			Schema schema = factory.newSchema(new File(this.xsdFilename));
			Source source = new StreamSource(this.xmlFilename);
			Validator validator = schema.newValidator();
			validator.validate(source);
			
<<<<<<< HEAD
		} catch(IOException ioe) {
			logger.error("IOException Message " + ioe);
			
			throw new ConfigurationFileInvalidException("IOException Message " + ioe);
		} catch(SAXException saxe) {
=======
		}catch(IOException ioe){
			logger.error("IOException Message " + ioe);
			
			throw new ConfigurationFileInvalidException("IOException Message " + ioe);
		}catch(SAXException saxe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("SAXException Message " + saxe);
			
			throw new ConfigurationFileInvalidException("SAXException Message "
					+ saxe);
		}
		
		logger.debug(this.xmlFilename + " is valid based on " + this.xsdFilename);
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * Generate a table containing the XML elements and values
	 * 
	 * @param none
	 * @return none
	 * @throws ConfigurationFileInvalidException
	 */
<<<<<<< HEAD
	private void processXML() throws ConfigurationFileInvalidException {
=======
	private void processXML() throws ConfigurationFileInvalidException{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		// Parse XML
		logger.debug("Initializing XML parsing");
		
		// Get the document factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
<<<<<<< HEAD
		try {
=======
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			// Using factory get an instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			// Parse using builder to get DOM representation of the XML file
			Document dom = db.parse(this.xmlFilename);
			rootElement = dom.getDocumentElement();
			
			logger.debug(this.xmlFilename + " parsed successfully");
			
<<<<<<< HEAD
		} catch(ParserConfigurationException pce) {
=======
		}catch(ParserConfigurationException pce){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("ParserConfigurationException Message" + pce);
			
			throw new ConfigurationFileInvalidException(
					"ParserConfigurationException Message " + pce);
<<<<<<< HEAD
		} catch(SAXException saxe) {
=======
		}catch(SAXException saxe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("SAXException Message" + saxe);
			
			throw new ConfigurationFileInvalidException("SAXException Message "
					+ saxe);
<<<<<<< HEAD
		} catch(IOException ioe) {
=======
		}catch(IOException ioe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("IOException Message" + ioe);
			
			throw new ConfigurationFileInvalidException("IOException Message " + ioe);
		}
		
		logger.debug("Finilized XML parsing");
		
		// Identifies all the configuration elements
		logger.debug("Initializing XSD parsing");
		
		Map<String, String> elements = new Hashtable<String, String>();
		XSOMParser parser = new XSOMParser();
<<<<<<< HEAD
		try {
=======
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			parser.parse(new File(this.xsdFilename));
			XSSchemaSet sset = parser.getResult();
			
			Iterator<XSSchema> itr = sset.iterateSchema();
<<<<<<< HEAD
			while(itr.hasNext()) {
				XSSchema s = itr.next();
				
				Iterator<XSElementDecl> elementList = s.iterateElementDecls();
				while(elementList.hasNext()) {
					XSElementDecl e = elementList.next();
					XSType eType = e.getType();
					
					if(eType.isComplexType()) {
=======
			while(itr.hasNext()){
				XSSchema s = itr.next();
				
				Iterator<XSElementDecl> elementList = s.iterateElementDecls();
				while(elementList.hasNext()){
					XSElementDecl e = elementList.next();
					XSType eType = e.getType();
					
					if(eType.isComplexType()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						XSContentType theContents = ((XSComplexType) eType)
								.getContentType();
						XSModelGroup theGroup = theContents.asParticle().getTerm()
								.asModelGroup();
						
						// Complex Type Element name
						// Complex Type Element type
<<<<<<< HEAD
						for(int i = 0; i < theGroup.getSize(); i++) {
=======
						for(int i = 0; i < theGroup.getSize(); i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							elements.put(theGroup.getChild(i).asParticle().getTerm()
									.asElementDecl().getName(), theGroup.getChild(i).asParticle()
									.getTerm().asElementDecl().getType().getName());
						}
					}
				}
			}
<<<<<<< HEAD
		} catch(IOException ioe) {
			logger.error("IOException Message" + ioe);
			
			throw new ConfigurationFileInvalidException("IOException Message " + ioe);
		} catch(SAXException saxe) {
=======
		}catch(IOException ioe){
			logger.error("IOException Message" + ioe);
			
			throw new ConfigurationFileInvalidException("IOException Message " + ioe);
		}catch(SAXException saxe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			logger.error("SAXException Message" + saxe);
			
			throw new ConfigurationFileInvalidException("SAXException Message "
					+ saxe);
		}
		
		logger.debug("Finilized XSD parsing");
		
		// Obtain the value of each configuration element
		logger.debug("Initializing value setting");
		
		Iterator<String> elementIterator = elements.keySet().iterator();
<<<<<<< HEAD
		while(elementIterator.hasNext()) {
=======
		while(elementIterator.hasNext()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			String key = elementIterator.next();
			String type = elements.get(key).toUpperCase();
			String value = this.getRootValue(key);
			
<<<<<<< HEAD
			try {
				if(!value.equals(null)) {
					if(type.equals("ANYSIMPLETYPE")) {
						confElements.put(key, value);
					} else if(type.equals("BASE64BINARY")) {
						// confElements.put(key, new Byte(value));
					} else if(type.equals("BOOLEAN")) {
						confElements.put(key, new Boolean(value));
					} else if(type.equals("DATE")) {
						// confElements.put(key, (XMLGregorianCalendar) value);
					} else if(type.equals("DATETIME")) {
						// confElements.put(key, (XMLGregorianCalendar) value);
					} else if(type.equals("DECIMAL")) {
						confElements.put(key, new BigDecimal(value));
					} else if(type.equals("DOUBLE")) {
						// confElements.put(key, new Duration(value));
					} else if(type.equals("DURATION")) {
						confElements.put(key, new Boolean(value));
					} else if(type.equals("FLOAT")) {
						confElements.put(key, new Float(value));
					} else if(type.equals("G")) {
						// confElements.put(key, (XMLGregorianCalendar) value);
					} else if(type.equals("HEXBINARY")) {
						// confElements.put(key, new Boolean(value));
					} else if(type.equals("INT")) {
						confElements.put(key, new Integer(value));
					} else if(type.equals("INTEGER")) {
						confElements.put(key, new BigInteger(value));
					} else if(type.equals("LONG")) {
						confElements.put(key, new Long(value));
					} else if(type.equals("NOTATION")) {
						confElements.put(key, new QName(value));
					} else if(type.equals("SHORT")) {
						confElements.put(key, new Short(value));
					} else if(type.equals("STRING")) {
						confElements.put(key, value);
					} else if(type.equals("QNAME")) {
						confElements.put(key, new QName(value));
					} else if(type.equals("TIME")) {
						// confElements.put(key, (XMLGregorianCalendar) value);
					} else if(type.equals("UNSIGNEDBYTE")) {
						confElements.put(key, new Short(value));
					} else if(type.equals("UNSIGNEDINT")) {
						confElements.put(key, new Long(value));
					} else if(type.equals("UNSIGNEDSHORT")) {
						confElements.put(key, new Integer(value));
					}
				}
			} catch(NumberFormatException nfe) {
=======
			try{
				if(!value.equals(null)){
					if(type.equals("ANYSIMPLETYPE")){
						confElements.put(key, value);
					}else if(type.equals("BASE64BINARY")){
						// confElements.put(key, new Byte(value));
					}else if(type.equals("BOOLEAN")){
						confElements.put(key, new Boolean(value));
					}else if(type.equals("DATE")){
						// confElements.put(key, (XMLGregorianCalendar) value);
					}else if(type.equals("DATETIME")){
						// confElements.put(key, (XMLGregorianCalendar) value);
					}else if(type.equals("DECIMAL")){
						confElements.put(key, new BigDecimal(value));
					}else if(type.equals("DOUBLE")){
						// confElements.put(key, new Duration(value));
					}else if(type.equals("DURATION")){
						confElements.put(key, new Boolean(value));
					}else if(type.equals("FLOAT")){
						confElements.put(key, new Float(value));
					}else if(type.equals("G")){
						// confElements.put(key, (XMLGregorianCalendar) value);
					}else if(type.equals("HEXBINARY")){
						// confElements.put(key, new Boolean(value));
					}else if(type.equals("INT")){
						confElements.put(key, new Integer(value));
					}else if(type.equals("INTEGER")){
						confElements.put(key, new BigInteger(value));
					}else if(type.equals("LONG")){
						confElements.put(key, new Long(value));
					}else if(type.equals("NOTATION")){
						confElements.put(key, new QName(value));
					}else if(type.equals("SHORT")){
						confElements.put(key, new Short(value));
					}else if(type.equals("STRING")){
						confElements.put(key, value);
					}else if(type.equals("QNAME")){
						confElements.put(key, new QName(value));
					}else if(type.equals("TIME")){
						// confElements.put(key, (XMLGregorianCalendar) value);
					}else if(type.equals("UNSIGNEDBYTE")){
						confElements.put(key, new Short(value));
					}else if(type.equals("UNSIGNEDINT")){
						confElements.put(key, new Long(value));
					}else if(type.equals("UNSIGNEDSHORT")){
						confElements.put(key, new Integer(value));
					}
				}
			}catch(NumberFormatException nfe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				logger.error("key = [" + key + "] type = [" + type + "] value = ["
						+ value + "]");
				logger.error("NumberFormatException Message " + nfe);
			}
			
			logger.debug("Finilized value setting");
		}
	}
}