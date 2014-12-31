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
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import otservices.translator.language.LanguageException;
import otservices.translator.valuetransformation.Value;
import otservices.translator.valuetransformation.ValueTransformationInterface;

/**
 * 
 */
public class Result implements Serializable {
	
	private Map<String, List<Term>>	result	= new HashMap<String, List<Term>>();
	
	// Size of the biggest ArrayList of a Var
	private Integer									length	= new Integer(0);
	
	
	/**
	 * 
	 */
	public void addResult(String var) {
		if(var != null) {
			var = var.toLowerCase();
			if(!this.result.containsKey(var)) {
				this.result.put(var, null);
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void addResult(List<Term> values) {
		if(values.size() == this.result.size()) {
			int i = 0;
			String var;
			List<Term> auxValue;
			for(Iterator<String> lResult = this.result.keySet().iterator(); lResult
					.hasNext();) {
				var = lResult.next();
				auxValue = this.result.get(var);
				if(auxValue == null) {
					auxValue = new ArrayList<Term>();
				}
				auxValue.add(values.get(i));
				
				this.result.put(var, auxValue);
				i++;
				
				if(auxValue.size() > this.length.intValue()) {
					this.length = new Integer(auxValue.size());
				}
			}
		}
	}
	
	
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
					newValue.add(iResult.next());
				}
				
				// append the new values
				for(Term term : value) {
					newValue.add(term);
				}
			}
			this.result.put(var, newValue);
			
			if(newValue.size() > this.length.intValue()) {
				this.length = new Integer(newValue.size());
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void addResult(String var, Term value) {
		
		if(var != null) {
			var = var.toLowerCase();
			
			List<Term> auxValue;
			
			if(!this.result.containsKey(var)) {
				auxValue = new ArrayList<Term>();
			} else {
				auxValue = this.result.get(var);
			}
			auxValue.add(value);
			this.result.put(var, auxValue);
			
			if(auxValue.size() > this.length.intValue()) {
				this.length = new Integer(auxValue.size());
			}
		}
	}
	
	
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
			vars[i] = (String) o[i];
		}
		
		return vars;
	}
	
	
	/**
	 * 
	 */
	public Term[][] getResultsMatrix() {
		String[] vars = new String[this.result.size()];
		
		Iterator<String> iResult = this.result.keySet().iterator();
		Object[] oList = new Object[this.result.size()];
		for(int i = 0; iResult.hasNext(); i++) {
			vars[i] = iResult.next();
			oList[i] = this.result.get(vars[i]);
		}
		
		Term[][] values = new Term[this.length][vars.length];
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < vars.length; j++) {
				if(((List<Term>) oList[j]).size() > i) {
					values[i][j] = ((List<Term>) oList[j]).get(i);
				} else {
					values[i][j] = null;
				}
			}
		}
		
		return values;
	}
	
	
	/**
	 * 
	 */
	public String getXML() throws LanguageException {
		StringWriter strResult = null;
		
		String[] vars = this.getResultsVar();
		Term[][] values = this.getResultsMatrix();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		try {
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
			for(int j = 0; j < vars.length; j++) {
				elementHead = document.createElement("variable");
				elementHead.setAttribute("name", vars[j]);
				eHead.appendChild(elementHead);
			}
			
			Element eResults = document.createElement("results");
			rootElement.appendChild(eResults);
			
			Element eResult;
			Element elementResult;
			Element eValue;
			
			for(int i = 0; i < values.length; i++) {
				eResult = document.createElement("result");
				eResults.appendChild(eResult);
				
				for(int j = 0; j < values[i].length; j++) {
					if(values[i][j] != null) {
						if(values[i][j].getTerm() != null) {
							elementResult = document.createElement("binding");
							elementResult.setAttribute("name", vars[j]);
							
							eValue = document.createElement("literal");
							if(values[i][j].getType() == Term.TermType.BOOLEAN) {
								eValue.setAttribute("datatype",
										"http://www.w3.org/2001/XMLSchema#boolean");
								
								if(((Boolean) values[i][j].getTerm()).booleanValue()) {
									eValue.appendChild(document.createTextNode("true"));
								} else {
									eValue.appendChild(document.createTextNode("false"));
								}
							} else if(values[i][j].getType() == Term.TermType.FLOAT) {
								eValue.setAttribute("datatype",
										"http://www.w3.org/2001/XMLSchema#float");
								eValue
										.appendChild(document.createTextNode(((Float) values[i][j]
												.getTerm()).toString()));
							} else if(values[i][j].getType() == Term.TermType.INTEGER) {
								eValue.setAttribute("datatype",
										"http://www.w3.org/2001/XMLSchema#integer");
								eValue.appendChild(document
										.createTextNode(((Integer) values[i][j].getTerm())
												.toString()));
							} else if(values[i][j].getType() == Term.TermType.STRING) {
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
		} catch(ParserConfigurationException pce) {
			throw new LanguageException(pce.getMessage());
		} catch(TransformerException tce) {
			throw new LanguageException(tce.getMessage());
		}
		
		return strResult.toString();
	}
	
	
	/**
	 * 
	 */
	public void setXML(String xmlMessage) throws LanguageException {
		
		this.result = new HashMap<String, List<Term>>();
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
				.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory
					.newDocumentBuilder();
			
			Document dom = documentBuilder.parse(new InputSource(new StringReader(
					xmlMessage)));
			
			Element rootElement = dom.getDocumentElement();
			
			Element element;
			NodeList resultNL = rootElement.getElementsByTagName("result");
			if(resultNL.getLength() > 0) {
				NodeList literalNL;
				Element literalEL;
				NodeList el;
				Object value;
				String datatype;
				Term term;
				String var;
				Element resultElement;
				NodeList bindingNL;
				for(int x = 0; x < resultNL.getLength(); x++) {
					resultElement = (Element) resultNL.item(x);
					bindingNL = resultElement.getElementsByTagName("binding");
					
					if(bindingNL.getLength() > 0) {
						for(int y = 0; y < bindingNL.getLength(); y++) {
							element = (Element) bindingNL.item(y);
							var = element.getAttribute("name");
							literalNL = element.getElementsByTagName("literal");
							literalEL = (Element) literalNL.item(0);
							datatype = literalEL.getAttribute("datatype");
							el = literalEL.getChildNodes();
							
							if(((Node) el.item(0)) != null)
								value = ((Node) el.item(0)).getNodeValue();
							else {
								value = null;
							}
							
							term = new Term();
							if(datatype.equals("http://www.w3.org/2001/XMLSchema#boolean")) {
								
								if(value == null) {
									value = "false";
								}
								
								term.setType(Term.TermType.BOOLEAN);
								if(((String) value).equals("true")) {
									term.setTerm(new Boolean(true));
								} else {
									term.setTerm(new Boolean(false));
								}
							} else if(datatype
									.equals("http://www.w3.org/2001/XMLSchema#integer")) {
								
								if(value == null) {
									value = "0";
								}
								
								term.setType(Term.TermType.INTEGER);
								term.setTerm(new Integer((String) value));
							} else if(datatype
									.equals("http://www.w3.org/2001/XMLSchema#float")) {
								
								if(value == null) {
									value = "0.0";
								}
								
								term.setType(Term.TermType.FLOAT);
								term.setTerm(new Float((String) value));
							} else if(datatype.equals("")) {
								
								if(value == null) {
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
			
		} catch(ParserConfigurationException pce) {
			throw new LanguageException(pce.getMessage());
		} catch(IOException ioe) {
			throw new LanguageException(ioe.getMessage());
		} catch(SAXException saxe) {
			throw new LanguageException(saxe.getMessage());
		}
	}
	
	
	/**
	 * 
	 */
	public void updateConcepts(MapTable varMap) {
		Map<String, List<Term>> newResult = new HashMap<String, List<Term>>();
		
		Iterator<String> iResult = result.keySet().iterator();
		String var;
		String[] newVars;
		List<Term> value;
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
				newResult.put(var, value);
			}
		}
		
		this.result = newResult;
	}
	
	
	/**
	 * 
	 */
	public void updateValue(String concept,
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
							value.setType(Value.ValueType.STRING);
						}
						value.setValue(term.getTerm());
						
						newValue = null;
						if(inOut.booleanValue()) {
							newValue = valueTransformation.incomingTransformation(value);
						} else {
							newValue = valueTransformation.outgoingTransformation(value);
						}
						
						newTerm = new Term();
						newTerm.setPosition(term.getPosition());
						if(newValue.getType() == Value.ValueType.BOOLEAN) {
							newTerm.setType(Term.TermType.BOOLEAN);
						} else if(newValue.getType() == Value.ValueType.FLOAT) {
							newTerm.setType(Term.TermType.FLOAT);
						} else if(newValue.getType() == Value.ValueType.INTEGER) {
							newTerm.setType(Term.TermType.INTEGER);
						} else if(newValue.getType() == Value.ValueType.STRING) {
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
	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("============= Result =============");
		if(this.result != null) {
			String[] vars = new String[this.result.size()];
			
			Iterator<String> iResult = this.result.keySet().iterator();
			Object[] oList = new Object[this.result.size()];
			for(int i = 0; iResult.hasNext(); i++) {
				vars[i] = iResult.next();
				oList[i] = this.result.get(vars[i]);
			}
			
			if(this.length > 0) {
				for(int i = 0; i < this.length; i++) {
					for(int j = 0; j < vars.length; j++) {
						if(((List<Term>) oList[j]).size() > i) {
							
							if(((List<Term>) oList[j]).get(i).getTerm() != null) {
								System.out
										.print(vars[j] + " = "
												+ ((List<Term>) oList[j]).get(i).getTerm().toString()
												+ " ");
							} else {
								System.out.print(vars[j] + " = NULL");
							}
						} else {
							System.out.print(vars[j] + " = ");
						}
					}
					System.out.println();
				}
			} else {
				for(int i = 0; i < vars.length; i++) {
					System.out.println(vars[i] + " = ");
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
	public void p() {
		System.out.println("============= Result =============");
		if(this.result != null) {
			Iterator<String> iResult = this.result.keySet().iterator();
			while(iResult.hasNext()) {
				String var = iResult.next();
				System.out.print(var + " - ");
				
				List<Term> oList = this.result.get(var);
				if(oList != null) {
					Iterator<Term> iList = oList.iterator();
					while(iList.hasNext()) {
						System.out.print(iList.next().getTerm().toString() + " ");
					}
				}
				System.out.println();
			}
		}
	}
}