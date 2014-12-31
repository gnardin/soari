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
package otservices.translator.language.sparql;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
<<<<<<< HEAD
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
import otservices.translator.language.LanguageException;
import otservices.translator.valuetransformation.Value;
import otservices.translator.valuetransformation.ValueTransformationInterface;

/**
 * 
 */
<<<<<<< HEAD
public class Result implements Serializable {
=======
public class Result implements Serializable{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	private Map<String, List<Term>>	result	= new HashMap<String, List<Term>>();
	
	// Size of the biggest ArrayList of a Var
	private Integer									length	= new Integer(0);
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void addResult(String var) {
		if(var != null) {
			var = var.toLowerCase();
			if(!this.result.containsKey(var)) {
=======
	public void addResult(String var){
		if (var != null){
			var = var.toLowerCase();
			if (!this.result.containsKey(var)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				this.result.put(var, null);
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void addResult(List<Term> values) {
		if(values.size() == this.result.size()) {
=======

	/**
	 * 
	 */
	public void addResult(List<Term> values){
		if (values.size() == this.result.size()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			int i = 0;
			String var;
			List<Term> auxValue;
			for(Iterator<String> lResult = this.result.keySet().iterator(); lResult
<<<<<<< HEAD
					.hasNext();) {
				var = lResult.next();
				auxValue = this.result.get(var);
				if(auxValue == null) {
=======
					.hasNext();){
				var = lResult.next();
				auxValue = this.result.get(var);
				if (auxValue == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					auxValue = new ArrayList<Term>();
				}
				auxValue.add(values.get(i));
				
				this.result.put(var, auxValue);
				i++;
				
<<<<<<< HEAD
				if(auxValue.size() > this.length.intValue()) {
=======
				if (auxValue.size() > this.length.intValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					this.length = new Integer(auxValue.size());
				}
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void addResult(String var, List<Term> value) {
		List<Term> newValue = new ArrayList<Term>();
		
		if((var != null) && (value != null)) {
			var = var.toLowerCase();
			
			if(!this.result.containsKey(var)) {
				newValue = value;
			} else if(value != null) {
				// add the old values
				for(Iterator<Term> iResult = this.result.get(var).iterator(); iResult
						.hasNext();) {
=======

	/**
	 * 
	 */
	public void addResult(String var, List<Term> value){
		List<Term> newValue = new ArrayList<Term>();
		
		if ((var != null) && (value != null)){
			var = var.toLowerCase();
			
			if (!this.result.containsKey(var)){
				newValue = value;
			}else if (value != null){
				// add the old values
				for(Iterator<Term> iResult = this.result.get(var).iterator(); iResult
						.hasNext();){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					newValue.add(iResult.next());
				}
				
				// append the new values
<<<<<<< HEAD
				for(Term term : value) {
=======
				for(Term term : value){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					newValue.add(term);
				}
			}
			this.result.put(var, newValue);
			
<<<<<<< HEAD
			if(newValue.size() > this.length.intValue()) {
=======
			if (newValue.size() > this.length.intValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				this.length = new Integer(newValue.size());
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void addResult(String var, Term value) {
		
		if(var != null) {
=======

	/**
	 * 
	 */
	public void addResult(String var, Term value){
		
		if (var != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			var = var.toLowerCase();
			
			List<Term> auxValue;
			
<<<<<<< HEAD
			if(!this.result.containsKey(var)) {
				auxValue = new ArrayList<Term>();
			} else {
=======
			if (!this.result.containsKey(var)){
				auxValue = new ArrayList<Term>();
			}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				auxValue = this.result.get(var);
			}
			auxValue.add(value);
			this.result.put(var, auxValue);
			
<<<<<<< HEAD
			if(auxValue.size() > this.length.intValue()) {
=======
			if (auxValue.size() > this.length.intValue()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				this.length = new Integer(auxValue.size());
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public Integer getLength() {
		return this.length;
	}
	
	
	/**
	 * 
	 */
	public Map<String, List<Term>> getResults() {
		return this.result;
	}
	
	
	/**
	 * 
	 */
	public String[] getResultsVar() {
		String[] vars = new String[this.result.size()];
		
		Object[] o = this.result.keySet().toArray();
		for(int i = 0; i < o.length; i++) {
=======

	/**
	 * 
	 */
	public Integer getLength(){
		return this.length;
	}
	

	/**
	 * 
	 */
	public Map<String, List<Term>> getResults(){
		return this.result;
	}
	

	/**
	 * 
	 */
	public String[] getResultsVar(){
		String[] vars = new String[this.result.size()];
		
		Object[] o = this.result.keySet().toArray();
		for(int i = 0; i < o.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			vars[i] = (String) o[i];
		}
		
		return vars;
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public Term[][] getResultsMatrix() {
=======

	/**
	 * 
	 */
	public Term[][] getResultsMatrix(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		String[] vars = new String[this.result.size()];
		
		Iterator<String> iResult = this.result.keySet().iterator();
		Object[] oList = new Object[this.result.size()];
<<<<<<< HEAD
		for(int i = 0; iResult.hasNext(); i++) {
=======
		for(int i = 0; iResult.hasNext(); i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			vars[i] = iResult.next();
			oList[i] = this.result.get(vars[i]);
		}
		
		Term[][] values = new Term[this.length][vars.length];
<<<<<<< HEAD
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < vars.length; j++) {
				if(((List<Term>) oList[j]).size() > i) {
					values[i][j] = ((List<Term>) oList[j]).get(i);
				} else {
=======
		for(int i = 0; i < this.length; i++){
			for(int j = 0; j < vars.length; j++){
				if (((List<Term>) oList[j]).size() > i){
					values[i][j] = ((List<Term>) oList[j]).get(i);
				}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					values[i][j] = null;
				}
			}
		}
		
		return values;
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public String getXML() throws LanguageException {
=======

	/**
	 * 
	 */
	public String getXML() throws LanguageException{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		StringWriter strResult = null;
		
		String[] vars = this.getResultsVar();
		Term[][] values = this.getResultsMatrix();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
<<<<<<< HEAD
		try {
=======
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			
			Document document = documentBuilder.newDocument();
			Element rootElement = document.createElement("sparql");
			rootElement.setAttribute("xmlns",
					"http://www.w3.org/2005/sparql-results#");
			document.appendChild(rootElement);
			
			Element eHead = document.createElement("head");
			rootElement.appendChild(eHead);
			
			Element elementHead;
<<<<<<< HEAD
			for(int j = 0; j < vars.length; j++) {
=======
			for(int j = 0; j < vars.length; j++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				elementHead = document.createElement("variable");
				elementHead.setAttribute("name", vars[j]);
				eHead.appendChild(elementHead);
			}
			
			Element eResults = document.createElement("results");
			rootElement.appendChild(eResults);
			
			Element eResult;
			Element elementResult;
			Element eValue;
			
<<<<<<< HEAD
			for(int i = 0; i < values.length; i++) {
				eResult = document.createElement("result");
				eResults.appendChild(eResult);
				
				for(int j = 0; j < values[i].length; j++) {
					if(values[i][j] != null) {
						if(values[i][j].getTerm() != null) {
=======
			for(int i = 0; i < values.length; i++){
				eResult = document.createElement("result");
				eResults.appendChild(eResult);
				
				for(int j = 0; j < values[i].length; j++){
					if (values[i][j] != null){
						if (values[i][j].getTerm() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							elementResult = document.createElement("binding");
							elementResult.setAttribute("name", vars[j]);
							
							eValue = document.createElement("literal");
<<<<<<< HEAD
							if(values[i][j].getType() == Term.TermType.BOOLEAN) {
								eValue.setAttribute("datatype",
										"http://www.w3.org/2001/XMLSchema#boolean");
								
								if(((Boolean) values[i][j].getTerm()).booleanValue()) {
									eValue.appendChild(document.createTextNode("true"));
								} else {
									eValue.appendChild(document.createTextNode("false"));
								}
							} else if(values[i][j].getType() == Term.TermType.FLOAT) {
=======
							if (values[i][j].getType() == Term.TermType.BOOLEAN){
								eValue.setAttribute("datatype",
										"http://www.w3.org/2001/XMLSchema#boolean");
								
								if (((Boolean) values[i][j].getTerm()).booleanValue()){
									eValue.appendChild(document.createTextNode("true"));
								}else{
									eValue.appendChild(document.createTextNode("false"));
								}
							}else if (values[i][j].getType() == Term.TermType.FLOAT){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								eValue.setAttribute("datatype",
										"http://www.w3.org/2001/XMLSchema#float");
								eValue
										.appendChild(document.createTextNode(((Float) values[i][j]
												.getTerm()).toString()));
<<<<<<< HEAD
							} else if(values[i][j].getType() == Term.TermType.INTEGER) {
=======
							}else if (values[i][j].getType() == Term.TermType.INTEGER){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								eValue.setAttribute("datatype",
										"http://www.w3.org/2001/XMLSchema#integer");
								eValue.appendChild(document
										.createTextNode(((Integer) values[i][j].getTerm())
												.toString()));
<<<<<<< HEAD
							} else if(values[i][j].getType() == Term.TermType.STRING) {
=======
							}else if (values[i][j].getType() == Term.TermType.STRING){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								eValue.appendChild(document
										.createTextNode(((String) values[i][j].getTerm())));
							}
							
							elementResult.appendChild(eValue);
							eResult.appendChild(elementResult);
						}
					}
				}
			}
			
			strResult = new StringWriter();
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(strResult);
			transformer.transform(source, result);
<<<<<<< HEAD
		} catch(ParserConfigurationException pce) {
			throw new LanguageException(pce.getMessage());
		} catch(TransformerException tce) {
=======
		}catch(ParserConfigurationException pce){
			throw new LanguageException(pce.getMessage());
		}catch(TransformerException tce){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			throw new LanguageException(tce.getMessage());
		}
		
		return strResult.toString();
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void setXML(String xmlMessage) throws LanguageException {
=======

	/**
	 * 
	 */
	public void setXML(String xmlMessage) throws LanguageException{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		this.result = new HashMap<String, List<Term>>();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
<<<<<<< HEAD
		try {
=======
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			
			Document dom = documentBuilder.parse(new InputSource(new StringReader(
					xmlMessage)));
			
			Element rootElement = dom.getDocumentElement();
			
			Element element;
			NodeList resultNL = rootElement.getElementsByTagName("result");
<<<<<<< HEAD
			if(resultNL.getLength() > 0) {
=======
			if (resultNL.getLength() > 0){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				NodeList literalNL;
				Element literalEL;
				NodeList el;
				Object value;
				String datatype;
				Term term;
				String var;
				Element resultElement;
				NodeList bindingNL;
<<<<<<< HEAD
				for(int x = 0; x < resultNL.getLength(); x++) {
					resultElement = (Element) resultNL.item(x);
					bindingNL = resultElement.getElementsByTagName("binding");
					
					if(bindingNL.getLength() > 0) {
						for(int y = 0; y < bindingNL.getLength(); y++) {
=======
				for(int x = 0; x < resultNL.getLength(); x++){
					resultElement = (Element) resultNL.item(x);
					bindingNL = resultElement.getElementsByTagName("binding");
					
					if (bindingNL.getLength() > 0){
						for(int y = 0; y < bindingNL.getLength(); y++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							element = (Element) bindingNL.item(y);
							var = element.getAttribute("name");
							literalNL = element.getElementsByTagName("literal");
							literalEL = (Element) literalNL.item(0);
							datatype = literalEL.getAttribute("datatype");
							el = literalEL.getChildNodes();
							
<<<<<<< HEAD
							if(((Node) el.item(0)) != null)
								value = ((Node) el.item(0)).getNodeValue();
							else {
=======
							if (((Node) el.item(0)) != null)
								value = ((Node) el.item(0)).getNodeValue();
							else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								value = null;
							}
							
							term = new Term();
<<<<<<< HEAD
							if(datatype.equals("http://www.w3.org/2001/XMLSchema#boolean")) {
								
								if(value == null) {
=======
							if (datatype.equals("http://www.w3.org/2001/XMLSchema#boolean")){
								
								if (value == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
									value = "false";
								}
								
								term.setType(Term.TermType.BOOLEAN);
<<<<<<< HEAD
								if(((String) value).equals("true")) {
									term.setTerm(new Boolean(true));
								} else {
									term.setTerm(new Boolean(false));
								}
							} else if(datatype
									.equals("http://www.w3.org/2001/XMLSchema#integer")) {
								
								if(value == null) {
=======
								if (((String) value).equals("true")){
									term.setTerm(new Boolean(true));
								}else{
									term.setTerm(new Boolean(false));
								}
							}else if (datatype
									.equals("http://www.w3.org/2001/XMLSchema#integer")){
								
								if (value == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
									value = "0";
								}
								
								term.setType(Term.TermType.INTEGER);
								term.setTerm(new Integer((String) value));
<<<<<<< HEAD
							} else if(datatype
									.equals("http://www.w3.org/2001/XMLSchema#float")) {
								
								if(value == null) {
=======
							}else if (datatype
									.equals("http://www.w3.org/2001/XMLSchema#float")){
								
								if (value == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
									value = "0.0";
								}
								
								term.setType(Term.TermType.FLOAT);
								term.setTerm(new Float((String) value));
<<<<<<< HEAD
							} else if(datatype.equals("")) {
								
								if(value == null) {
=======
							}else if (datatype.equals("")){
								
								if (value == null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
									value = "";
								}
								
								term.setType(Term.TermType.STRING);
								term.setTerm((String) value);
							}
							
							this.addResult(var, term);
						}
					}
				}
			}
			
<<<<<<< HEAD
		} catch(ParserConfigurationException pce) {
			throw new LanguageException(pce.getMessage());
		} catch(IOException ioe) {
			throw new LanguageException(ioe.getMessage());
		} catch(SAXException saxe) {
=======
		}catch(ParserConfigurationException pce){
			throw new LanguageException(pce.getMessage());
		}catch(IOException ioe){
			throw new LanguageException(ioe.getMessage());
		}catch(SAXException saxe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			throw new LanguageException(saxe.getMessage());
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void updateConcepts(MapTable varMap) {
=======

	/**
	 * 
	 */
	public void updateConcepts(MapTable varMap){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Map<String, List<Term>> newResult = new HashMap<String, List<Term>>();
		
		Iterator<String> iResult = result.keySet().iterator();
		String var;
		String[] newVars;
		List<Term> value;
<<<<<<< HEAD
		while(iResult.hasNext()) {
			var = iResult.next();
			value = result.get(var);
			if(varMap.contains(MapRow.FieldType.SOURCEVAR, var)) {
				newVars = varMap.get(MapRow.FieldType.SOURCEVAR, var,
						MapRow.FieldType.TARGETVAR);
				if(newVars != null) {
					for(int c = 0; c < newVars.length; c++) {
						newResult.put(newVars[c], value);
					}
				}
			} else {
=======
		while(iResult.hasNext()){
			var = iResult.next();
			value = result.get(var);
			if (varMap.contains(MapRow.FieldType.SOURCEVAR, var)){
				newVars = varMap.get(MapRow.FieldType.SOURCEVAR, var,
						MapRow.FieldType.TARGETVAR);
				if (newVars != null){
					for(int c = 0; c < newVars.length; c++){
						newResult.put(newVars[c], value);
					}
				}
			}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				newResult.put(var, value);
			}
		}
		
		this.result = newResult;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public void updateValue(String concept,
<<<<<<< HEAD
			ValueTransformationInterface valueTransformation, Boolean inOut) {
		
		if(this.result.containsKey(concept)) {
			List<Term> newTermList = new ArrayList<Term>();
			List<Term> termList = this.result.get(concept);
			
			if(termList != null) {
				Value value;
				Value newValue;
				Term newTerm;
				for(Term term : termList) {
					value = new Value();
					if(term != null) {
						if(term.getType() == Term.TermType.BOOLEAN) {
							value.setType(Value.ValueType.BOOLEAN);
						} else if(term.getType() == Term.TermType.FLOAT) {
							value.setType(Value.ValueType.FLOAT);
						} else if(term.getType() == Term.TermType.INTEGER) {
							value.setType(Value.ValueType.INTEGER);
						} else if(term.getType() == Term.TermType.STRING) {
=======
			ValueTransformationInterface valueTransformation, Boolean inOut){
		
		if (this.result.containsKey(concept)){
			List<Term> newTermList = new ArrayList<Term>();
			List<Term> termList = this.result.get(concept);
			
			if (termList != null){
				Value value;
				Value newValue;
				Term newTerm;
				for(Term term : termList){
					value = new Value();
					if (term != null){
						if (term.getType() == Term.TermType.BOOLEAN){
							value.setType(Value.ValueType.BOOLEAN);
						}else if (term.getType() == Term.TermType.FLOAT){
							value.setType(Value.ValueType.FLOAT);
						}else if (term.getType() == Term.TermType.INTEGER){
							value.setType(Value.ValueType.INTEGER);
						}else if (term.getType() == Term.TermType.STRING){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							value.setType(Value.ValueType.STRING);
						}
						value.setValue(term.getTerm());
						
						newValue = null;
<<<<<<< HEAD
						if(inOut.booleanValue()) {
							newValue = valueTransformation.incomingTransformation(value);
						} else {
=======
						if (inOut.booleanValue()){
							newValue = valueTransformation.incomingTransformation(value);
						}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							newValue = valueTransformation.outgoingTransformation(value);
						}
						
						newTerm = new Term();
						newTerm.setPosition(term.getPosition());
<<<<<<< HEAD
						if(newValue.getType() == Value.ValueType.BOOLEAN) {
							newTerm.setType(Term.TermType.BOOLEAN);
						} else if(newValue.getType() == Value.ValueType.FLOAT) {
							newTerm.setType(Term.TermType.FLOAT);
						} else if(newValue.getType() == Value.ValueType.INTEGER) {
							newTerm.setType(Term.TermType.INTEGER);
						} else if(newValue.getType() == Value.ValueType.STRING) {
=======
						if (newValue.getType() == Value.ValueType.BOOLEAN){
							newTerm.setType(Term.TermType.BOOLEAN);
						}else if (newValue.getType() == Value.ValueType.FLOAT){
							newTerm.setType(Term.TermType.FLOAT);
						}else if (newValue.getType() == Value.ValueType.INTEGER){
							newTerm.setType(Term.TermType.INTEGER);
						}else if (newValue.getType() == Value.ValueType.STRING){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							newTerm.setType(Term.TermType.STRING);
						}
						newTerm.setTerm(newValue.getValue());
						
						newTermList.add(newTerm);
					}
					this.result.put(concept, newTermList);
				}
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("============= Result =============");
		if(this.result != null) {
=======

	/**
	 * 
	 */
	public void print(){
		System.out.println("============= Result =============");
		if (this.result != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			String[] vars = new String[this.result.size()];
			
			Iterator<String> iResult = this.result.keySet().iterator();
			Object[] oList = new Object[this.result.size()];
<<<<<<< HEAD
			for(int i = 0; iResult.hasNext(); i++) {
=======
			for(int i = 0; iResult.hasNext(); i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				vars[i] = iResult.next();
				oList[i] = this.result.get(vars[i]);
			}
			
<<<<<<< HEAD
			if(this.length > 0) {
				for(int i = 0; i < this.length; i++) {
					for(int j = 0; j < vars.length; j++) {
						if(((List<Term>) oList[j]).size() > i) {
							
							if(((List<Term>) oList[j]).get(i).getTerm() != null) {
=======
			if (this.length > 0){
				for(int i = 0; i < this.length; i++){
					for(int j = 0; j < vars.length; j++){
						if (((List<Term>) oList[j]).size() > i){
							
							if (((List<Term>) oList[j]).get(i).getTerm() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								System.out
										.print(vars[j] + " = "
												+ ((List<Term>) oList[j]).get(i).getTerm().toString()
												+ " ");
<<<<<<< HEAD
							} else {
								System.out.print(vars[j] + " = NULL");
							}
						} else {
=======
							}else{
								System.out.print(vars[j] + " = NULL");
							}
						}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							System.out.print(vars[j] + " = ");
						}
					}
					System.out.println();
				}
<<<<<<< HEAD
			} else {
				for(int i = 0; i < vars.length; i++) {
=======
			}else{
				for(int i = 0; i < vars.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					System.out.println(vars[i] + " = ");
				}
			}
		}
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void p() {
		System.out.println("============= Result =============");
		if(this.result != null) {
			Iterator<String> iResult = this.result.keySet().iterator();
			while(iResult.hasNext()) {
=======

	/**
	 * 
	 */
	public void p(){
		System.out.println("============= Result =============");
		if (this.result != null){
			Iterator<String> iResult = this.result.keySet().iterator();
			while(iResult.hasNext()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				String var = iResult.next();
				System.out.print(var + " - ");
				
				List<Term> oList = this.result.get(var);
<<<<<<< HEAD
				if(oList != null) {
					Iterator<Term> iList = oList.iterator();
					while(iList.hasNext()) {
=======
				if (oList != null){
					Iterator<Term> iList = oList.iterator();
					while(iList.hasNext()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						System.out.print(iList.next().getTerm().toString() + " ");
					}
				}
				System.out.println();
			}
		}
	}
}