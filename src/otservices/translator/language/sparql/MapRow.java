/**
 * Copyright (c) 2008  Luis Gustavo Nardin <gnardin@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2, or (at your option)
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package otservices.translator.language.sparql;

import java.io.Serializable;

public class MapRow implements Serializable{

	public enum FieldType {
		SOURCEVAR, SOURCECONCEPT, TARGETVAR, TARGETCONCEPT
	};

	private String	sourceConcept;
	private String	sourceVar;
	private String	targetConcept;
	private String	targetVar;

	/**
	 * 
	 */
	public String get(FieldType fieldType){
		String result = null;

		if(fieldType.equals(FieldType.SOURCECONCEPT)){
			result = this.sourceConcept;
		}else if(fieldType.equals(FieldType.SOURCEVAR)){
			result = this.sourceVar;
		}else if(fieldType.equals(FieldType.TARGETCONCEPT)){
			result = this.targetConcept;
		}else if(fieldType.equals(FieldType.TARGETVAR)){
			result = this.targetVar;
		}

		return result;
	}

	/**
	 * 
	 */
	public String getSourceConcept(){
		return this.sourceConcept;
	}

	/**
	 * 
	 */
	public String getSourceVar(){
		return this.sourceVar;
	}

	/**
	 * 
	 */
	public String getTargetConcept(){
		return this.targetConcept;
	}

	/**
	 * 
	 */
	public String getTargetVar(){
		return this.targetVar;
	}

	/**
	 * 
	 */
	public void setSourceConcept(String sourceConcept){
		this.sourceConcept = sourceConcept;
	}

	/**
	 * 
	 */
	public void setSourceVar(String sourceVar){
		this.sourceVar = sourceVar;
	}

	/**
	 * 
	 */
	public void setTargetConcept(String targetConcept){
		this.targetConcept = targetConcept;
	}

	/**
	 * 
	 */
	public void setTargetVar(String targetVar){
		this.targetVar = targetVar;
	}
}