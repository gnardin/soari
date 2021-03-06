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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("serial")
public class RegExpr extends Expression implements Serializable {
	
	public RegExpr() {
		this.setExpressionType(ExpressionType.REGULAR);
	}
	
	private String	pattern;
	
	private String	var;
	
	
	/**
	 * 
	 */
	public Boolean evaluate(String varValue) {
		Boolean result = new Boolean(false);
		
		Pattern pattern = Pattern.compile(this.pattern);
		Matcher matcher = pattern.matcher(varValue);
		
		while(matcher.find()) {
			result = new Boolean(true);
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public String getPattern() {
		return this.pattern;
	}
	
	
	/**
	 * 
	 */
	public String getVariable() {
		return this.var;
	}
	
	
	/**
	 * 
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
	/**
	 * 
	 */
	public void setVariable(String var) {
		this.var = var;
	}
}