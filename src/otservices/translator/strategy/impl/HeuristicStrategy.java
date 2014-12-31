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
package otservices.translator.strategy.impl;

import edu.stanford.smi.protegex.owl.ProtegeOWL;
import edu.stanford.smi.protegex.owl.model.OWLModel;
import edu.stanford.smi.protegex.owl.model.OWLNamedClass;
import edu.stanford.smi.protegex.owl.model.RDFSClass;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import otservices.mapper.translationrepository.Ontology;
import otservices.translator.mapperserverclient.ws.MapperClientWebServiceInterface;
import otservices.translator.strategy.TranslationStrategyInterface;

public class HeuristicStrategy implements TranslationStrategyInterface {
	
	// OWL Filename
	private String													filename;
	
	// Indicates the OWL file was uploaded
	private Boolean													isOK		= new Boolean(false);
	
	// Web Services Mapper Client
	private MapperClientWebServiceInterface	mapperClient;
	
	// Interchange Ontology Name
	private String													ontInterchangeName;
	
	// Interchange Ontology Version
	private Integer													ontInterchangeVersion;
	
	// Native Ontology Name
	private String													ontNativeName;
	
	// Native Ontology Version
	private Integer													ontNativeVersion;
	
	// OWL Model
	private OWLModel												owlModel;
	
	// Original Mapping
	private Map<String, String[]>						originalMap;
	
	// New Mapping
	private Map<String, String[]>						newMap	= new HashMap<String, String[]>();
	
	
	/**
	 * 
	 */
	private Boolean getOWLFile() {
		Boolean result = new Boolean(false);
		
		if(mapperClient.isConnected().booleanValue()) {
			
			Ontology ontInterchange = new Ontology();
			ontInterchange.setUri(this.ontInterchangeName);
			ontInterchange.setVersion(this.ontInterchangeVersion);
			
			Ontology ontNative = new Ontology();
			ontNative.setUri(this.ontNativeName);
			ontNative.setVersion(this.ontNativeVersion);
			
			if(!(new File(this.filename)).exists()) {
				
				try {
					result = mapperClient.getOWLFile(ontInterchange, ontNative,
							this.filename);
				} catch(Exception e) {
					result = new Boolean(false);
				}
			} else {
				result = new Boolean(true);
			}
			
			try {
				this.owlModel = ProtegeOWL
						.createJenaOWLModelFromInputStream(new FileInputStream(
								this.filename));
			} catch(Exception e) {
				result = new Boolean(false);
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	private String getClassNameMatches(String name) {
		Boolean found = new Boolean(false);
		String className = null;
		
		Collection classes = owlModel.getUserDefinedOWLNamedClasses();
		for(Iterator it = classes.iterator(); (it.hasNext() && !found
				.booleanValue());) {
			OWLNamedClass cls = (OWLNamedClass) it.next();
			
			if(cls.getName().toLowerCase().contains(name.toLowerCase())) {
				found = new Boolean(true);
				className = cls.getName();
			}
		}
		return className;
	}
	
	
	/**
	 * 
	 */
	@Override
	public String[] run(String concept, String[] translations) {
		String[] result = new String[0];
		
		if(translations == null) {
			translations = new String[0];
		}
		
		if(isOK.booleanValue()) {
			if(translations.length == 0) {
				
				// Check if the concept was not translated before
				if(!newMap.containsKey(concept.toLowerCase())) {
					
					// Find the first correct concept name in the OWL
					// model
					String matchedClass = getClassNameMatches(concept);
					if(matchedClass != null) {
						// Remove Namespace
						matchedClass = matchedClass
								.substring(matchedClass.indexOf("#") + 1);
						
						// Old way of removing the namespace
						//
						// matchedClass.substring(this.owlModel.getNamespaceManager()
						// .getDefaultNamespace().length());
						
						// Try find sub and super match concepts
						result = this.runSubClasses(matchedClass, new Boolean(true));
						if(result.length == 0) {
							result = this.runSuperClasses(matchedClass);
						}
						
						// If does not find
						if(result.length != 0) {
							this.newMap.put(matchedClass.toLowerCase(), result);
						}
					}
				} else {
					result = this.newMap.get(concept.toLowerCase());
				}
			} else if(translations.length > 0) {
				result = translations;
			}
		}
		
		if(result.length == 0) {
			result = new String[1];
			result[0] = concept;
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	private String[] runSubClasses(String concept, Boolean depth) {
		String[] result = null;
		
		OWLNamedClass owlClass = owlModel.getOWLNamedClass(concept);
		if(owlClass != null) {
			List<String> list = new ArrayList<String>();
			String className;
			for(Iterator i = owlClass.getSubclasses(false).iterator(); i.hasNext();) {
				className = ((RDFSClass) i.next()).getName().toLowerCase();
				
				if(!className.startsWith("@")) {
					
					// Remove Namespace
					className = className.substring(className.indexOf("#") + 1);
					
					// Old way of removing the namespace
					//
					// className = className.substring(this.owlModel.getNamespaceManager()
					// .getDefaultNamespace().length());
					
					// Look for the subclass into the newMap
					if(this.newMap.containsKey(className)) {
						result = this.newMap.get(className);
						
						for(int x = 0; x < result.length; x++) {
							list.add(result[x]);
						}
						
					} else {
						
						// Look for the subclass into the originalMap
						if(this.originalMap.containsKey(className)) {
							result = this.originalMap.get(className);
							
							for(int x = 0; x < result.length; x++) {
								list.add(result[x]);
							}
						}
					}
				}
			}
			
			// If it does not find a subclass translation
			if((list.size() == 0) && (depth.booleanValue())) {
				for(Iterator i = owlClass.getSubclasses(false).iterator(); i.hasNext();) {
					className = ((RDFSClass) i.next()).getName();
					if(!className.startsWith("@")) {
						// Remove Namespace
						className = className.substring(className.indexOf("#") + 1);
						
						// Old way of removing the namespace
						//
						// className =
						// className.substring(this.owlModel.getNamespaceManager()
						// .getDefaultNamespace().length());
						
						result = this.runSubClasses(className, new Boolean(false));
						
						for(int x = 0; x < result.length; x++) {
							list.add(result[x]);
						}
					}
				}
			}
			
			if(list.size() > 0) {
				result = new String[list.size()];
				int c = 0;
				for(Iterator<String> i = list.iterator(); i.hasNext(); c++) {
					result[c] = i.next();
				}
			}
		}
		
		if(result == null) {
			result = new String[0];
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	private String[] runSuperClasses(String concept) {
		String[] result = null;
		
		OWLNamedClass owlClass = this.owlModel.getOWLNamedClass(concept);
		if(owlClass != null) {
			String className;
			for(Iterator i = owlClass.getSuperclasses(false).iterator(); i.hasNext();) {
				className = ((RDFSClass) i.next()).getName();
				
				if(!className.startsWith("@")) {
					// Remove Namespace
					className = className.substring(className.indexOf("#") + 1);
					
					// Old way of removing the namespace
					//
					// className = className.substring(this.owlModel.getNamespaceManager()
					// .getDefaultNamespace().length());
					
					if(this.newMap.containsKey(className.toLowerCase())) {
						result = this.newMap.get(className.toLowerCase());
					} else {
						
						if(this.originalMap.containsKey(className.toLowerCase())) {
							result = this.originalMap.get(className.toLowerCase());
						} else {
							result = this.runSuperClasses(className);
						}
					}
				}
			}
		}
		
		if(result == null) {
			result = new String[0];
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void setWebServices(String ontInterchangeName,
			Integer ontInterchangeVersion, String ontNativeName,
			Integer ontNativeVersion, MapperClientWebServiceInterface mapperClient) {
		
		this.mapperClient = mapperClient;
		this.ontInterchangeName = ontInterchangeName;
		this.ontInterchangeVersion = ontInterchangeVersion;
		this.ontNativeName = ontNativeName;
		this.ontNativeVersion = ontNativeVersion;
		
		this.filename = this.ontInterchangeName + this.ontNativeName + ".owl";
		
		isOK = this.getOWLFile();
		if(isOK.booleanValue()) {
			Ontology ontInterchange = new Ontology();
			ontInterchange.setUri(this.ontInterchangeName);
			ontInterchange.setVersion(this.ontInterchangeVersion);
			
			Ontology ontNative = new Ontology();
			ontNative.setUri(this.ontNativeName);
			ontNative.setVersion(this.ontNativeVersion);
			
			originalMap = this.mapperClient.getInterchangeNativeMapping(
					ontInterchange, ontNative);
		}
	}
}