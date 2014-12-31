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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Where implements Serializable {
	
	private Map<String, String>	where	= new Hashtable<String, String>();
	
	
	/**
	 * 
	 */
	public void addWhere(String var, String concept) {
		this.where.put(var, concept);
	}
	
	
	/**
	 * 
	 */
	public String getConcept(String var) {
		return this.where.get(var);
	}
	
	
	/**
	 * 
	 */
	public String[] getVariable(String concept) {
		Iterator<String> i = this.where.keySet().iterator();
		String result[] = null;
		
		List<String> aux = new ArrayList<String>();
		String key = "";
		while(i.hasNext()) {
			key = i.next();
			if(this.where.get(key).equals(concept)) {
				aux.add(key);
			}
		}
		
		if(aux.size() > 0) {
			result = new String[aux.size()];
			int c = 0;
			for(Iterator<String> iAux = aux.iterator(); iAux.hasNext();) {
				result[c++] = iAux.next();
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public Map<String, String> getWhere() {
		return this.where;
	}
	
	
	/**
	 * 
	 */
	public MapTable updateConcepts(Map<String, String[]> concepts) {
		MapTable varMap = new MapTable();
		Map<String, String> newWhere = new Hashtable<String, String>();
		
		List<String> test = new ArrayList<String>();
		
		String var;
		String concept;
		String[] map;
		for(Iterator<String> iWhere = this.where.keySet().iterator(); iWhere
				.hasNext();) {
			var = iWhere.next();
			concept = where.get(var);
			if((concepts.containsKey(concept)) && (!test.contains(var))) {
				map = concepts.get(concept);
				
				// If it did not find any mapping keep the original mapping
				if(map.length == 0) {
					newWhere.put(var, concept);
					
				} else if(map.length == 1) {
					newWhere.put(var, map[0]);
					
					// Adds an entry into the MapTable
					varMap.addRow(concept, var, map[0], var);
				} else if(map.length > 1) {
					String newVar;
					String[] newVars = new String[map.length];
					for(int c = 0; c < map.length; c++) {
						newVar = var + c;
						newVars[c] = newVar;
						newWhere.put(newVar, map[c]);
						
						// Adds an entry into the MapTable
						varMap.addRow(concept, var, map[c], newVar);
					}
				}
				test.add(var);
			} else {
				varMap.addRow(concept, var, null, null);
			}
		}
		
		this.where = newWhere;
		return varMap;
	}
	
	
	/**
	 * 
	 */
	public void print() {
		System.out.println("============= Where =============");
		if(this.where != null) {
			Iterator<String> i = this.where.keySet().iterator();
			String concept;
			while(i.hasNext()) {
				concept = i.next();
				System.out.println(concept + " = " + this.where.get(concept));
			}
		}
	}
}