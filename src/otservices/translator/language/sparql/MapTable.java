/**
<<<<<<< HEAD
 * Copyright (c) 2008 Luis Gustavo Nardin <gnardin@gmail.com>
=======
 * Copyright (c) 2008  Luis Gustavo Nardin <gnardin@gmail.com>
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
<<<<<<< HEAD
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
=======
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
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

public class MapTable implements Serializable {
	
	private List<MapRow>	rows	= new ArrayList<MapRow>();
	
	
	/**
	 * 
	 */
	public void addRow(String sourceConcept, String sourceVar,
<<<<<<< HEAD
			String targetConcept, String targetVar) {
=======
			String targetConcept, String targetVar){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		MapRow row = new MapRow();
		row.setSourceConcept(sourceConcept);
		row.setSourceVar(sourceVar);
		row.setTargetConcept(targetConcept);
		row.setTargetVar(targetVar);
		
		this.rows.add(row);
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public Boolean contains(MapRow.FieldType searchField, String value) {
=======

	/**
	 * 
	 */
	public Boolean contains(MapRow.FieldType searchField, String value){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Boolean result = new Boolean(false);
		
		MapRow mapRow;
		for(Iterator<MapRow> r = rows.iterator(); r.hasNext()
<<<<<<< HEAD
				&& (!result.booleanValue());) {
			mapRow = r.next();
			
			if(searchField.equals(MapRow.FieldType.SOURCECONCEPT)) {
				if(value.equals(mapRow.getSourceConcept())) {
					result = new Boolean(true);
				}
			} else if(searchField.equals(MapRow.FieldType.SOURCEVAR)) {
				if(value.equals(mapRow.getSourceVar())) {
					result = new Boolean(true);
				}
			} else if(searchField.equals(MapRow.FieldType.TARGETCONCEPT)) {
				if(value.equals(mapRow.getTargetConcept())) {
					result = new Boolean(true);
				}
			} else if(searchField.equals(MapRow.FieldType.TARGETVAR)) {
				if(value.equals(mapRow.getTargetVar())) {
=======
				&& (!result.booleanValue());){
			mapRow = r.next();
			
			if (searchField.equals(MapRow.FieldType.SOURCECONCEPT)){
				if (value.equals(mapRow.getSourceConcept())){
					result = new Boolean(true);
				}
			}
			else if (searchField.equals(MapRow.FieldType.SOURCEVAR)){
				if (value.equals(mapRow.getSourceVar())){
					result = new Boolean(true);
				}
			}
			else if (searchField.equals(MapRow.FieldType.TARGETCONCEPT)){
				if (value.equals(mapRow.getTargetConcept())){
					result = new Boolean(true);
				}
			}
			else if (searchField.equals(MapRow.FieldType.TARGETVAR)){
				if (value.equals(mapRow.getTargetVar())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					result = new Boolean(true);
				}
			}
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public String[] get(MapRow.FieldType searchField, String value,
<<<<<<< HEAD
			MapRow.FieldType returnField) {
=======
			MapRow.FieldType returnField){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		String result[] = null;
		
		MapRow mapRow = null;
		List<String> listResult = new ArrayList<String>();
<<<<<<< HEAD
		for(Iterator<MapRow> r = rows.iterator(); r.hasNext();) {
			mapRow = r.next();
			
			if(searchField.equals(MapRow.FieldType.SOURCECONCEPT)) {
				if(value.equals(mapRow.getSourceConcept())) {
					listResult.add(mapRow.get(returnField));
				}
			} else if(searchField.equals(MapRow.FieldType.SOURCEVAR)) {
				if(value.equals(mapRow.getSourceVar())) {
					listResult.add(mapRow.get(returnField));
				}
			} else if(searchField.equals(MapRow.FieldType.TARGETCONCEPT)) {
				if(value.equals(mapRow.getTargetConcept())) {
					listResult.add(mapRow.get(returnField));
				}
			} else if(searchField.equals(MapRow.FieldType.TARGETVAR)) {
				if(value.equals(mapRow.getTargetVar())) {
=======
		for(Iterator<MapRow> r = rows.iterator(); r.hasNext();){
			mapRow = r.next();
			
			if (searchField.equals(MapRow.FieldType.SOURCECONCEPT)){
				if (value.equals(mapRow.getSourceConcept())){
					listResult.add(mapRow.get(returnField));
				}
			}
			else if (searchField.equals(MapRow.FieldType.SOURCEVAR)){
				if (value.equals(mapRow.getSourceVar())){
					listResult.add(mapRow.get(returnField));
				}
			}
			else if (searchField.equals(MapRow.FieldType.TARGETCONCEPT)){
				if (value.equals(mapRow.getTargetConcept())){
					listResult.add(mapRow.get(returnField));
				}
			}
			else if (searchField.equals(MapRow.FieldType.TARGETVAR)){
				if (value.equals(mapRow.getTargetVar())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					listResult.add(mapRow.get(returnField));
				}
			}
		}
		
		Object[] o = listResult.toArray();
		result = new String[o.length];
<<<<<<< HEAD
		for(int i = 0; i < o.length; i++) {
=======
		for(int i = 0; i < o.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			result[i] = (String) o[i];
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
	public Integer[] getIndex(MapRow.FieldType searchField, String value) {
=======

	public Integer[] getIndex(MapRow.FieldType searchField, String value){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Integer[] result = null;
		
		MapRow mapRow = null;
		List<Integer> listResult = new ArrayList<Integer>();
		Integer index = new Integer(0);
<<<<<<< HEAD
		for(Iterator<MapRow> r = rows.iterator(); r.hasNext();) {
			mapRow = r.next();
			
			if(searchField.equals(MapRow.FieldType.SOURCECONCEPT)) {
				if(value.equals(mapRow.getSourceConcept())) {
					listResult.add(index);
				}
			} else if(searchField.equals(MapRow.FieldType.SOURCEVAR)) {
				if(value.equals(mapRow.getSourceVar())) {
					listResult.add(index);
				}
			} else if(searchField.equals(MapRow.FieldType.TARGETCONCEPT)) {
				if(value.equals(mapRow.getTargetConcept())) {
					listResult.add(index);
				}
			} else if(searchField.equals(MapRow.FieldType.TARGETVAR)) {
				if(value.equals(mapRow.getTargetVar())) {
=======
		for(Iterator<MapRow> r = rows.iterator(); r.hasNext();){
			mapRow = r.next();
			
			if (searchField.equals(MapRow.FieldType.SOURCECONCEPT)){
				if (value.equals(mapRow.getSourceConcept())){
					listResult.add(index);
				}
			}
			else if (searchField.equals(MapRow.FieldType.SOURCEVAR)){
				if (value.equals(mapRow.getSourceVar())){
					listResult.add(index);
				}
			}
			else if (searchField.equals(MapRow.FieldType.TARGETCONCEPT)){
				if (value.equals(mapRow.getTargetConcept())){
					listResult.add(index);
				}
			}
			else if (searchField.equals(MapRow.FieldType.TARGETVAR)){
				if (value.equals(mapRow.getTargetVar())){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					listResult.add(index);
				}
			}
			index++;
		}
		
		Object[] o = listResult.toArray();
		result = new Integer[o.length];
<<<<<<< HEAD
		for(int i = 0; i < o.length; i++) {
=======
		for(int i = 0; i < o.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			result[i] = (Integer) o[i];
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
=======

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	/**
	 * 
	 */
	public Map<String, String[]> getSourceToTarget(MapRow.FieldType sourceField,
<<<<<<< HEAD
			MapRow.FieldType targetField) {
=======
			MapRow.FieldType targetField){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		Map<String, String[]> result = new Hashtable<String, String[]>();
		
		String source;
		List<String> target;
		MapRow row;
		MapRow r;
<<<<<<< HEAD
		for(Iterator<MapRow> i = this.rows.iterator(); i.hasNext();) {
			row = i.next();
			source = row.get(sourceField);
			
			if(!result.containsKey(source)) {
				target = new ArrayList<String>();
				for(Iterator<MapRow> j = this.rows.iterator(); j.hasNext();) {
					r = j.next();
					if(source.equals(r.get(sourceField))) {
=======
		for(Iterator<MapRow> i = this.rows.iterator(); i.hasNext();){
			row = i.next();
			source = row.get(sourceField);
			
			if (!result.containsKey(source)){
				target = new ArrayList<String>();
				for(Iterator<MapRow> j = this.rows.iterator(); j.hasNext();){
					r = j.next();
					if (source.equals(r.get(sourceField))){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						target.add(r.get(targetField));
					}
				}
				
				Object[] o = target.toArray();
				String[] strTarget = new String[o.length];
<<<<<<< HEAD
				for(int x = 0; x < o.length; x++) {
=======
				for(int x = 0; x < o.length; x++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					strTarget[x] = (String) o[x];
				}
				
				result.put(source, strTarget);
			}
		}
		
		return result;
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public Iterator<String> iterator(MapRow.FieldType field) {
		List<String> list = new ArrayList<String>();
		
		MapRow row;
		for(Iterator<MapRow> l = this.rows.iterator(); l.hasNext();) {
=======

	/**
	 * 
	 */
	public Iterator<String> iterator(MapRow.FieldType field){
		List<String> list = new ArrayList<String>();
		
		MapRow row;
		for(Iterator<MapRow> l = this.rows.iterator(); l.hasNext();){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			row = l.next();
			list.add(row.get(field));
		}
		
		return list.iterator();
	}
	
<<<<<<< HEAD
	
	/**
	 * 
	 */
	public void print() {
		
		MapRow row;
		for(Iterator<MapRow> l = this.rows.iterator(); l.hasNext();) {
=======

	/**
	 * 
	 */
	public void print(){
		
		MapRow row;
		for(Iterator<MapRow> l = this.rows.iterator(); l.hasNext();){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			row = l.next();
			System.out.println(row.getSourceConcept() + " " + row.getSourceVar()
					+ " " + row.getTargetConcept() + " " + row.getTargetVar());
		}
	}
}