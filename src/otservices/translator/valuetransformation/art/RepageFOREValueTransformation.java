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
package otservices.translator.valuetransformation.art;

import otservices.translator.valuetransformation.Value;
import otservices.translator.valuetransformation.Value.ValueType;

public class RepageFOREValueTransformation extends FOREValueTransformation{

	/**
	 * 
	 */
	public Value incomingTransformation(Value value){
		Value v = new Value();
		if(value.getType() == ValueType.STRING){
			this.setValues((String) value.getValue());

			v = value;
		}

		return v;
	}

	/**
	 * 
	 */
	public Value outgoingTransformation(Value value){
		Value v = new Value();
		if(value.getType() == ValueType.STRING){
			this.setValues((String) value.getValue());

			v = new Value();
			v.setType(ValueType.STRING);
			v.setValue(this.toString());
		}

		return v;
	}
}