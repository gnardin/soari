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
import otservices.translator.TranslatorConstants;
import otservices.translator.language.LanguageException;
import otservices.translator.language.ObjectInterface;
import otservices.translator.valuetransformation.ValueTransformationInterface;

@SuppressWarnings("serial")
<<<<<<< HEAD
public class SPARQLObject implements ObjectInterface, Serializable {
	
	public enum Command {
		SELECT{
			
			@Override
			public String toString() {
=======
public class SPARQLObject implements ObjectInterface, Serializable{
	
	public enum Command{
		SELECT{
			
			@Override
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "SELECT";
			}
		},
		UPDATE{
			
			@Override
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "UPDATE";
			}
		},
		RESULT{
			
			@Override
<<<<<<< HEAD
			public String toString() {
=======
			public String toString(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				return "RESULT";
			}
		}
	};
	
	private Command				command;
	
	private List<String>	concepts;
	
	private Filter				filter;
	
	private MapTable			mapTable;
	
	private Result				result;
	
	private String				sender;
	
	private Where					where;
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public SPARQLObject() {
=======
	public SPARQLObject(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void addConcepts(List<String> concepts) {
=======
	public void addConcepts(List<String> concepts){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.concepts = concepts;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void addFilter(Filter filter) {
=======
	public void addFilter(Filter filter){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.filter = filter;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void addResult(Result result) {
=======
	public void addResult(Result result){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.result = result;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void addResult(String message) {
		try {
			this.result.setXML(message);
		} catch(LanguageException le) {
=======
	public void addResult(String message){
		try{
			this.result.setXML(message);
		}catch(LanguageException le){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.result = new Result();
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void addWhere(Where where) {
=======
	public void addWhere(Where where){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.where = where;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Command getCommand() {
=======
	public Command getCommand(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.command;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public List<String> getConcepts() {
=======
	public List<String> getConcepts(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.concepts;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Filter getFilter() {
=======
	public Filter getFilter(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.filter;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public MapTable getMapTable() {
=======
	public MapTable getMapTable(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.mapTable;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public String getMessage() {
		String msg = "";
		if(command == Command.SELECT) {
			msg = "SELECT";
			if(this.result != null) {
				Iterator<String> iResult = this.result.getResults().keySet().iterator();
				while(iResult.hasNext()) {
=======
	public String getMessage(){
		String msg = "";
		if(command == Command.SELECT){
			msg = "SELECT";
			if(this.result != null){
				Iterator<String> iResult = this.result.getResults().keySet().iterator();
				while(iResult.hasNext()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					msg = msg + " " + iResult.next();
				}
			}
			
			msg = msg + getSPARQLWhere();
<<<<<<< HEAD
		} else if(command == Command.UPDATE) {
			msg = "UPDATE";
			if(this.result != null) {
=======
		}else if(command == Command.UPDATE){
			msg = "UPDATE";
			if(this.result != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				Map<String, List<Term>> mResult = this.result.getResults();
				Iterator<String> iResult = mResult.keySet().iterator();
				String var;
				List<Term> value;
<<<<<<< HEAD
				while(iResult.hasNext()) {
					var = iResult.next();
					value = mResult.get(var);
					
					if(value != null) {
						Term valueTerm = value.get(0);
						if(valueTerm.getType() == Term.TermType.INTEGER) {
							msg = msg + " " + var + "="
									+ ((Integer) value.get(0).getTerm()).toString();
						} else if(valueTerm.getType() == Term.TermType.FLOAT) {
							msg = msg + " " + var + "="
									+ ((Float) valueTerm.getTerm()).toString();
						} else if(valueTerm.getType() == Term.TermType.BOOLEAN) {
							msg = msg + " " + var + "="
									+ ((Boolean) valueTerm.getTerm()).toString();
						} else if(valueTerm.getType() == Term.TermType.STRING) {
=======
				while(iResult.hasNext()){
					var = iResult.next();
					value = mResult.get(var);
					
					if(value != null){
						Term valueTerm = value.get(0);
						if(valueTerm.getType() == Term.TermType.INTEGER){
							msg = msg + " " + var + "="
									+ ((Integer) value.get(0).getTerm()).toString();
						}else if(valueTerm.getType() == Term.TermType.FLOAT){
							msg = msg + " " + var + "="
									+ ((Float) valueTerm.getTerm()).toString();
						}else if(valueTerm.getType() == Term.TermType.BOOLEAN){
							msg = msg + " " + var + "="
									+ ((Boolean) valueTerm.getTerm()).toString();
						}else if(valueTerm.getType() == Term.TermType.STRING){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							msg = msg + " " + var + "=" + ((String) valueTerm.getTerm());
						}
					}
				}
			}
			
			msg = msg + getSPARQLWhere();
<<<<<<< HEAD
		} else if(command == Command.RESULT) {
			try {
				msg = this.result.getXML();
			} catch(LanguageException le) {
=======
		}else if(command == Command.RESULT){
			try{
				msg = this.result.getXML();
			}catch(LanguageException le){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				msg = "";
			}
		}
		
		return msg;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Result getResult() {
=======
	public Result getResult(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.result;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public String getSender() {
=======
	public String getSender(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.sender;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	private String getSPARQLWhere() {
		String msg = "";
		
		if(this.where != null) {
=======
	private String getSPARQLWhere(){
		String msg = "";
		
		if(this.where != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			msg = msg + " " + "WHERE{";
			Map<String, String> mWhere = this.where.getWhere();
			Iterator<String> iWhere = mWhere.keySet().iterator();
			String concept;
			String var;
<<<<<<< HEAD
			while(iWhere.hasNext()) {
=======
			while(iWhere.hasNext()){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				var = iWhere.next();
				concept = mWhere.get(var);
				msg = msg + " " + "?_ reputation:" + concept + " " + var + " .";
			}
			
<<<<<<< HEAD
			if(this.filter != null) {
				if(this.filter.getFilter().size() > 0) {
=======
			if(this.filter != null){
				if(this.filter.getFilter().size() > 0){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					msg = msg + " FILTER (";
					
					Iterator<Object> iFilter = this.filter.getFilter().iterator();
					
					List<String> auxList = new ArrayList<String>();
					Object aux;
					String auxMsg = "";
					String filterMsg = "";
					RegExpr auxRegExpr;
					LogExpr auxLogExpr;
					RelExpr auxRelExpr;
					Term auxTerm;
					String auxTermx = "";
					String auxTerm1 = "";
					String auxTerm2 = "";
<<<<<<< HEAD
					while(iFilter.hasNext()) {
						aux = iFilter.next();
						if(aux instanceof Term) {
							auxTerm = (Term) aux;
							if(auxTerm.getType() == Term.TermType.INTEGER) {
								auxTermx = ((Integer) auxTerm.getTerm()).toString();
							} else if(auxTerm.getType() == Term.TermType.FLOAT) {
								auxTermx = ((Float) auxTerm.getTerm()).toString();
							} else if(auxTerm.getType() == Term.TermType.BOOLEAN) {
								auxTermx = ((Boolean) auxTerm.getTerm()).toString();
							} else if(auxTerm.getType() == Term.TermType.STRING) {
								auxTermx = (String) auxTerm.getTerm();
							} else if(auxTerm.getType() == Term.TermType.VARIABLE) {
								auxTermx = (String) auxTerm.getTerm();
							}
							
							if(auxTerm.getPosition() == Term.Position.FIRST) {
								auxTerm1 = auxTermx;
							} else if(auxTerm.getPosition() == Term.Position.SECOND) {
								auxTerm2 = auxTermx;
							}
						} else if(aux instanceof RelExpr) {
							auxRelExpr = (RelExpr) aux;
							auxMsg = "(" + auxTerm1 + auxRelExpr.getRelationalOp() + auxTerm2
									+ ")";
							if(filterMsg == "") {
								filterMsg = auxMsg;
							} else {
								auxList.add(auxMsg);
							}
						} else if(aux instanceof RegExpr) {
							auxRegExpr = (RegExpr) aux;
							auxMsg = "(REGEX(" + auxRegExpr.getVariable() + ","
									+ auxRegExpr.getPattern() + "))";
							if(filterMsg == "") {
								filterMsg = auxMsg;
							} else {
								auxList.add(auxMsg);
							}
						} else if(aux instanceof LogExpr) {
							auxLogExpr = (LogExpr) aux;
							
							if(auxList.size() == 1) {
=======
					while(iFilter.hasNext()){
						aux = iFilter.next();
						if(aux instanceof Term){
							auxTerm = (Term) aux;
							if(auxTerm.getType() == Term.TermType.INTEGER){
								auxTermx = ((Integer) auxTerm.getTerm()).toString();
							}else if(auxTerm.getType() == Term.TermType.FLOAT){
								auxTermx = ((Float) auxTerm.getTerm()).toString();
							}else if(auxTerm.getType() == Term.TermType.BOOLEAN){
								auxTermx = ((Boolean) auxTerm.getTerm()).toString();
							}else if(auxTerm.getType() == Term.TermType.STRING){
								auxTermx = (String) auxTerm.getTerm();
							}else if(auxTerm.getType() == Term.TermType.VARIABLE){
								auxTermx = (String) auxTerm.getTerm();
							}
							
							if(auxTerm.getPosition() == Term.Position.FIRST){
								auxTerm1 = auxTermx;
							}else if(auxTerm.getPosition() == Term.Position.SECOND){
								auxTerm2 = auxTermx;
							}
						}else if(aux instanceof RelExpr){
							auxRelExpr = (RelExpr) aux;
							auxMsg = "(" + auxTerm1 + auxRelExpr.getRelationalOp() + auxTerm2
									+ ")";
							if(filterMsg == ""){
								filterMsg = auxMsg;
							}else{
								auxList.add(auxMsg);
							}
						}else if(aux instanceof RegExpr){
							auxRegExpr = (RegExpr) aux;
							auxMsg = "(REGEX(" + auxRegExpr.getVariable() + ","
									+ auxRegExpr.getPattern() + "))";
							if(filterMsg == ""){
								filterMsg = auxMsg;
							}else{
								auxList.add(auxMsg);
							}
						}else if(aux instanceof LogExpr){
							auxLogExpr = (LogExpr) aux;
							
							if(auxList.size() == 1){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								auxMsg = "(" + filterMsg + " " + auxLogExpr.getLogicalOp()
										+ " " + auxList.get(0) + ")";
								filterMsg = auxMsg;
								auxList.remove(0);
<<<<<<< HEAD
							} else if(auxList.size() > 1) {
=======
							}else if(auxList.size() > 1){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								auxMsg = "(" + auxList.get(auxList.size() - 2) + " "
										+ auxLogExpr.getLogicalOp() + " "
										+ auxList.get(auxList.size() - 1) + ")";
								auxList.remove(auxList.size() - 1);
								auxList.set(auxList.size() - 1, auxMsg);
							}
						}
					}
					
					msg = msg + filterMsg + ")";
				}
			}
			msg = msg + " }";
		}
		
		return msg;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public Integer getMessageType() {
		Integer result = TranslatorConstants.FAULT;
		
		if(this.command == Command.SELECT) {
			result = TranslatorConstants.REQUEST;
		} else if(this.command == Command.UPDATE) {
			result = TranslatorConstants.INFORM;
		} else if(this.command == Command.RESULT) {
=======
	public Integer getMessageType(){
		Integer result = TranslatorConstants.FAULT;
		
		if(this.command == Command.SELECT){
			result = TranslatorConstants.REQUEST;
		}else if(this.command == Command.UPDATE){
			result = TranslatorConstants.INFORM;
		}else if(this.command == Command.RESULT){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			result = TranslatorConstants.RESULT;
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Where getWhere() {
=======
	public Where getWhere(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return this.where;
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public Boolean isValid() {
=======
	public Boolean isValid(){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return new Boolean(true);
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void setCommand(Command command) {
=======
	public void setCommand(Command command){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.command = command;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public void setMapTable(MapTable mapTable) {
=======
	public void setMapTable(MapTable mapTable){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.mapTable = mapTable;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public void setSender(String sender) {
=======
	public void setSender(String sender){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		this.sender = sender;
	}
	
	
	/**
	 * 
	 */
	@Override
<<<<<<< HEAD
	public void update(ObjectInterface parsedObject) {
=======
	public void update(ObjectInterface parsedObject){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		SPARQLObject sparqlObject = (SPARQLObject) parsedObject;
		
		this.setCommand(SPARQLObject.Command.RESULT);
		
		Result oldResult = sparqlObject.getResult();
		
<<<<<<< HEAD
		if(oldResult != null) {
=======
		if(oldResult != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			// Matrix
			Map<String, List<Term>> mResult = oldResult.getResults();
			Map<String, Integer> vars = new Hashtable<String, Integer>();
			
			Iterator<String> iResult = mResult.keySet().iterator();
			Object[] oList = new Object[mResult.size()];
			String auxVar;
<<<<<<< HEAD
			for(int i = 0; iResult.hasNext(); i++) {
=======
			for(int i = 0; iResult.hasNext(); i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				auxVar = iResult.next();
				vars.put(auxVar, new Integer(i));
				oList[i] = mResult.get(auxVar);
			}
			
			Term[][] values = new Term[oldResult.getLength()][vars.size()];
<<<<<<< HEAD
			for(int i = 0; i < oldResult.getLength(); i++) {
				for(int j = 0; j < vars.size(); j++) {
					if(((List<Term>) oList[j]).size() > i) {
						values[i][j] = ((List<Term>) oList[j]).get(i);
					} else {
=======
			for(int i = 0; i < oldResult.getLength(); i++){
				for(int j = 0; j < vars.size(); j++){
					if(((List<Term>) oList[j]).size() > i){
						values[i][j] = ((List<Term>) oList[j]).get(i);
					}else{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						values[i][j] = null;
					}
				}
			}
			
			Result newResult = new Result();
			
			Map<String, String[]> mapping = this.mapTable.getSourceToTarget(
					MapRow.FieldType.SOURCEVAR, MapRow.FieldType.TARGETVAR);
			
			Integer newNumLines = 1;
			
			// Obtain the variables
			Map<String, Integer[]> variables = new Hashtable<String, Integer[]>();
			String[] map;
			Integer[] intMap;
			Integer index;
<<<<<<< HEAD
			for(String var : this.result.getResultsVar()) {
				if(mapping.containsKey(var)) {
					map = mapping.get(var);
					if(map != null) {
						if(map.length > 0) {
=======
			for(String var : this.result.getResultsVar()){
				if(mapping.containsKey(var)){
					map = mapping.get(var);
					if(map != null){
						if(map.length > 0){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
							newNumLines = newNumLines * map.length;
							
							intMap = new Integer[map.length];
							index = 0;
<<<<<<< HEAD
							for(String m : map) {
								if(vars.containsKey(m)) {
=======
							for(String m : map){
								if(vars.containsKey(m)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
									intMap[index++] = vars.get(m);
								}
							}
							variables.put(var, intMap);
						}
					}
				}
			}
			
			// Process Result
			Integer oldNumLines = values.length;
			newNumLines = newNumLines * oldNumLines;
			
			Term[][] newMatrix = new Term[newNumLines][this.result.getResultsVar().length];
			
			String oldVar;
			Integer newPos = 0;
			Integer numMultiVarVar;
			Integer numRepetition;
			Integer[] oldPos;
			
			// For each line
<<<<<<< HEAD
			for(int i = 0; i < values.length; i++) {
=======
			for(int i = 0; i < values.length; i++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
				numMultiVarVar = 1;
				newPos = 0;
				
				// For each variable
				for(Iterator<String> iVariables = variables.keySet().iterator(); iVariables
<<<<<<< HEAD
						.hasNext();) {
					oldVar = iVariables.next();
					oldPos = variables.get(oldVar);
					
					if(oldPos.length == 1) {
						
						for(int j = 0; j < (newNumLines / oldNumLines); j++) {
							newMatrix[j + (i * (newNumLines / oldNumLines))][newPos] = values[i][oldPos[0]];
						}
					} else if(oldPos.length > 1) {
=======
						.hasNext();){
					oldVar = iVariables.next();
					oldPos = variables.get(oldVar);
					
					if(oldPos.length == 1){
						
						for(int j = 0; j < (newNumLines / oldNumLines); j++){
							newMatrix[j + (i * (newNumLines / oldNumLines))][newPos] = values[i][oldPos[0]];
						}
					}else if(oldPos.length > 1){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
						numRepetition = new Float(
								((newNumLines / oldNumLines) / oldPos.length) / numMultiVarVar)
								.intValue();
						
<<<<<<< HEAD
						for(int x = 0; x < oldPos.length; x++) {
							for(int y = 0; y < numRepetition; y++) {
=======
						for(int x = 0; x < oldPos.length; x++){
							for(int y = 0; y < numRepetition; y++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
								newMatrix[(x + y) + (i * (newNumLines / oldNumLines))][newPos] = values[i][oldPos[x]];
							}
						}
						numMultiVarVar++;
					}
					newPos++;
				}
			}
			
			// Transfer values from newMatrix to newResult
			Object[] auxVars = variables.keySet().toArray();
<<<<<<< HEAD
			for(int i = 0; i < newMatrix.length; i++) {
				for(int j = 0; j < newMatrix[i].length; j++) {
=======
			for(int i = 0; i < newMatrix.length; i++){
				for(int j = 0; j < newMatrix[i].length; j++){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					newResult.addResult((String) auxVars[j], newMatrix[i][j]);
				}
			}
			
			this.result = newResult;
		}
		
<<<<<<< HEAD
		if(sparqlObject.getWhere() != null) {
			this.where = sparqlObject.getWhere();
		}
		
		if(sparqlObject.getFilter() != null) {
=======
		if(sparqlObject.getWhere() != null){
			this.where = sparqlObject.getWhere();
		}
		
		if(sparqlObject.getFilter() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.filter = sparqlObject.getFilter();
		}
	}
	
	
	/**
	 *
	 */
	@Override
<<<<<<< HEAD
	public void updateConcepts(Map<String, String[]> concepts) {
=======
	public void updateConcepts(Map<String, String[]> concepts){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		
		this.mapTable = this.where.updateConcepts(concepts);
		this.result.updateConcepts(this.mapTable);
		
		this.filter.updateConcepts(this.mapTable);
		
		// Update the concepts on the concepts list
		this.concepts = new ArrayList<String>();
		Iterator<String> i = concepts.keySet().iterator();
		String key;
		String[] str;
<<<<<<< HEAD
		while(i.hasNext()) {
			key = i.next();
			str = concepts.get(key);
			for(int j = 0; j < str.length; j++) {
				if(!this.concepts.contains(str[j])) {
=======
		while(i.hasNext()){
			key = i.next();
			str = concepts.get(key);
			for(int j = 0; j < str.length; j++){
				if(!this.concepts.contains(str[j])){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					this.concepts.add(str[j]);
				}
			}
		}
	}
	
	
	/**
	  *
	  */
	@Override
	public void updateValue(String concept,
<<<<<<< HEAD
			ValueTransformationInterface valueTransformation, Boolean inOut) {
		
		if(this.where != null) {
			String var[] = this.where.getVariable(concept);
			if(var != null) {
				for(int i = 0; i < var.length; i++) {
					this.result.updateValue(var[i], valueTransformation, inOut);
				}
			}
		} else {
			if(this.mapTable != null) {
				if(this.mapTable.contains(MapRow.FieldType.SOURCECONCEPT, concept)) {
=======
			ValueTransformationInterface valueTransformation, Boolean inOut){
		
		if(this.where != null){
			String var[] = this.where.getVariable(concept);
			if(var != null){
				for(int i = 0; i < var.length; i++){
					this.result.updateValue(var[i], valueTransformation, inOut);
				}
			}
		}else{
			if(this.mapTable != null){
				if(this.mapTable.contains(MapRow.FieldType.SOURCECONCEPT, concept)){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
					String[] vars = this.mapTable.get(MapRow.FieldType.SOURCECONCEPT,
							concept, MapRow.FieldType.SOURCEVAR);
					this.result.updateValue(vars[0], valueTransformation, inOut);
				}
			}
		}
	}
	
	
	/**
	 * 
	 */
<<<<<<< HEAD
	public void print() {
		if(this.getResult() != null) {
			this.getResult().print();
		}
		
		if(this.getWhere() != null) {
			this.getWhere().print();
		}
		
		if(this.getFilter() != null) {
=======
	public void print(){
		if(this.getResult() != null){
			this.getResult().print();
		}
		
		if(this.getWhere() != null){
			this.getWhere().print();
		}
		
		if(this.getFilter() != null){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			this.getFilter().print();
		}
	}
}