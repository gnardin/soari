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
public class SPARQLObject implements ObjectInterface, Serializable{
	
	public enum Command{
		SELECT{
			
			@Override
			public String toString(){
				return "SELECT";
			}
		},
		UPDATE{
			
			@Override
			public String toString(){
				return "UPDATE";
			}
		},
		RESULT{
			
			@Override
			public String toString(){
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
	public SPARQLObject(){
	}
	
	
	/**
	 * 
	 */
	public void addConcepts(List<String> concepts){
		this.concepts = concepts;
	}
	
	
	/**
	 * 
	 */
	public void addFilter(Filter filter){
		this.filter = filter;
	}
	
	
	/**
	 * 
	 */
	public void addResult(Result result){
		this.result = result;
	}
	
	
	/**
	 * 
	 */
	public void addResult(String message){
		try{
			this.result.setXML(message);
		}catch(LanguageException le){
			this.result = new Result();
		}
	}
	
	
	/**
	 * 
	 */
	public void addWhere(Where where){
		this.where = where;
	}
	
	
	/**
	 * 
	 */
	public Command getCommand(){
		return this.command;
	}
	
	
	/**
	 * 
	 */
	@Override
	public List<String> getConcepts(){
		return this.concepts;
	}
	
	
	/**
	 * 
	 */
	public Filter getFilter(){
		return this.filter;
	}
	
	
	/**
	 * 
	 */
	@Override
	public MapTable getMapTable(){
		return this.mapTable;
	}
	
	
	/**
	 * 
	 */
	@Override
	public String getMessage(){
		String msg = "";
		if(command == Command.SELECT){
			msg = "SELECT";
			if(this.result != null){
				Iterator<String> iResult = this.result.getResults().keySet().iterator();
				while(iResult.hasNext()){
					msg = msg + " " + iResult.next();
				}
			}
			
			msg = msg + getSPARQLWhere();
		}else if(command == Command.UPDATE){
			msg = "UPDATE";
			if(this.result != null){
				Map<String, List<Term>> mResult = this.result.getResults();
				Iterator<String> iResult = mResult.keySet().iterator();
				String var;
				List<Term> value;
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
							msg = msg + " " + var + "=" + ((String) valueTerm.getTerm());
						}
					}
				}
			}
			
			msg = msg + getSPARQLWhere();
		}else if(command == Command.RESULT){
			try{
				msg = this.result.getXML();
			}catch(LanguageException le){
				msg = "";
			}
		}
		
		return msg;
	}
	
	
	/**
	 * 
	 */
	public Result getResult(){
		return this.result;
	}
	
	
	/**
	 * 
	 */
	@Override
	public String getSender(){
		return this.sender;
	}
	
	
	/**
	 * 
	 */
	private String getSPARQLWhere(){
		String msg = "";
		
		if(this.where != null){
			msg = msg + " " + "WHERE{";
			Map<String, String> mWhere = this.where.getWhere();
			Iterator<String> iWhere = mWhere.keySet().iterator();
			String concept;
			String var;
			while(iWhere.hasNext()){
				var = iWhere.next();
				concept = mWhere.get(var);
				msg = msg + " " + "?_ reputation:" + concept + " " + var + " .";
			}
			
			if(this.filter != null){
				if(this.filter.getFilter().size() > 0){
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
								auxMsg = "(" + filterMsg + " " + auxLogExpr.getLogicalOp()
										+ " " + auxList.get(0) + ")";
								filterMsg = auxMsg;
								auxList.remove(0);
							}else if(auxList.size() > 1){
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
	public Integer getMessageType(){
		Integer result = TranslatorConstants.FAULT;
		
		if(this.command == Command.SELECT){
			result = TranslatorConstants.REQUEST;
		}else if(this.command == Command.UPDATE){
			result = TranslatorConstants.INFORM;
		}else if(this.command == Command.RESULT){
			result = TranslatorConstants.RESULT;
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public Where getWhere(){
		return this.where;
	}
	
	
	/**
	 * 
	 */
	public Boolean isValid(){
		return new Boolean(true);
	}
	
	
	/**
	 * 
	 */
	public void setCommand(Command command){
		this.command = command;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void setMapTable(MapTable mapTable){
		this.mapTable = mapTable;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void setSender(String sender){
		this.sender = sender;
	}
	
	
	/**
	 * 
	 */
	@Override
	public void update(ObjectInterface parsedObject){
		SPARQLObject sparqlObject = (SPARQLObject) parsedObject;
		
		this.setCommand(SPARQLObject.Command.RESULT);
		
		Result oldResult = sparqlObject.getResult();
		
		if(oldResult != null){
			// Matrix
			Map<String, List<Term>> mResult = oldResult.getResults();
			Map<String, Integer> vars = new Hashtable<String, Integer>();
			
			Iterator<String> iResult = mResult.keySet().iterator();
			Object[] oList = new Object[mResult.size()];
			String auxVar;
			for(int i = 0; iResult.hasNext(); i++){
				auxVar = iResult.next();
				vars.put(auxVar, new Integer(i));
				oList[i] = mResult.get(auxVar);
			}
			
			Term[][] values = new Term[oldResult.getLength()][vars.size()];
			for(int i = 0; i < oldResult.getLength(); i++){
				for(int j = 0; j < vars.size(); j++){
					if(((List<Term>) oList[j]).size() > i){
						values[i][j] = ((List<Term>) oList[j]).get(i);
					}else{
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
			for(String var : this.result.getResultsVar()){
				if(mapping.containsKey(var)){
					map = mapping.get(var);
					if(map != null){
						if(map.length > 0){
							newNumLines = newNumLines * map.length;
							
							intMap = new Integer[map.length];
							index = 0;
							for(String m : map){
								if(vars.containsKey(m)){
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
			for(int i = 0; i < values.length; i++){
				numMultiVarVar = 1;
				newPos = 0;
				
				// For each variable
				for(Iterator<String> iVariables = variables.keySet().iterator(); iVariables
						.hasNext();){
					oldVar = iVariables.next();
					oldPos = variables.get(oldVar);
					
					if(oldPos.length == 1){
						
						for(int j = 0; j < (newNumLines / oldNumLines); j++){
							newMatrix[j + (i * (newNumLines / oldNumLines))][newPos] = values[i][oldPos[0]];
						}
					}else if(oldPos.length > 1){
						numRepetition = new Float(
								((newNumLines / oldNumLines) / oldPos.length) / numMultiVarVar)
								.intValue();
						
						for(int x = 0; x < oldPos.length; x++){
							for(int y = 0; y < numRepetition; y++){
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
			for(int i = 0; i < newMatrix.length; i++){
				for(int j = 0; j < newMatrix[i].length; j++){
					newResult.addResult((String) auxVars[j], newMatrix[i][j]);
				}
			}
			
			this.result = newResult;
		}
		
		if(sparqlObject.getWhere() != null){
			this.where = sparqlObject.getWhere();
		}
		
		if(sparqlObject.getFilter() != null){
			this.filter = sparqlObject.getFilter();
		}
	}
	
	
	/**
	 *
	 */
	@Override
	public void updateConcepts(Map<String, String[]> concepts){
		
		this.mapTable = this.where.updateConcepts(concepts);
		this.result.updateConcepts(this.mapTable);
		
		this.filter.updateConcepts(this.mapTable);
		
		// Update the concepts on the concepts list
		this.concepts = new ArrayList<String>();
		Iterator<String> i = concepts.keySet().iterator();
		String key;
		String[] str;
		while(i.hasNext()){
			key = i.next();
			str = concepts.get(key);
			for(int j = 0; j < str.length; j++){
				if(!this.concepts.contains(str[j])){
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
	public void print(){
		if(this.getResult() != null){
			this.getResult().print();
		}
		
		if(this.getWhere() != null){
			this.getWhere().print();
		}
		
		if(this.getFilter() != null){
			this.getFilter().print();
		}
	}
}