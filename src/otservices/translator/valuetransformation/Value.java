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
package otservices.translator.valuetransformation;

public class Value{

	public enum ValueType {
		STRING{
			public String toString(){
				return "STRING";
			}
		},
		INTEGER{
			public String toString(){
				return "INTEGER";
			}
		},
		FLOAT{
			public String toString(){
				return "FLOAT";
			}
		},
		BOOLEAN{
			public String toString(){
				return "BOOLEAN";
			}
		},
		VARIABLE{
			public String toString(){
				return "VARIABLE";
			}
		}
	};

	private Object		value;
	private ValueType	type;

	/**
	 * 
	 */
	public Object getValue(){
		return this.value;
	}

	/**
	 * 
	 */
	public ValueType getType(){
		return this.type;
	}

	/**
	 * 
	 */
	public void setValue(Object value){
		this.value = value;
	}

	/**
	 * 
	 */
	public void setType(ValueType type){
		this.type = type;
	}

	/**
	 * 
	 */
	public String toString(){
		String result = "";

		if(this.type == ValueType.STRING){
			result = (String) this.value;
		}else if(this.type == ValueType.INTEGER){
			result = ((Integer) this.value).toString();
		}else if(this.type == ValueType.FLOAT){
			result = ((Float) this.value).toString();
		}else if(this.type == ValueType.BOOLEAN){
			result = ((Boolean) this.value).toString();
		}else if(this.type == ValueType.VARIABLE){
			result = (String) this.value;
		}

		return result;
	}
}