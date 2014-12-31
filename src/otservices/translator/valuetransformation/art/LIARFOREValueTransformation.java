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
package otservices.translator.valuetransformation.art;

import otservices.translator.valuetransformation.Value;
import otservices.translator.valuetransformation.Value.ValueType;

<<<<<<< HEAD
public class LIARFOREValueTransformation extends FOREValueTransformation {
	
	/**
	 * 
	 */
	public Value incomingTransformation(Value value) {
		Value v = new Value();
		if(value.getType() == ValueType.STRING) {
			this.setValues((String) value.getValue());
			
			v.setType(ValueType.FLOAT);
			
			// Transform from [0,1] to [-1,1] value range
			float x = new Double((this.fromFOREtoReal().floatValue() - 0.5) * 2)
					.floatValue();
			
			v.setValue(new Float(x));
		}
		
		return v;
	}
	
	
	/**
	 * 
	 */
	public Value outgoingTransformation(Value value) {
		Value v = new Value();
		if(value.getType() == ValueType.FLOAT) {
			
			float x = new Double((((Float) value.getValue()).floatValue() / 2) + 0.5)
					.floatValue();
			
			this.fromRealtoFORE(new Float(x));
			
			v.setType(ValueType.STRING);
			v.setValue(this.toString());
		}
		
=======
public class LIARFOREValueTransformation extends FOREValueTransformation{

	/**
	 * 
	 */
	public Value incomingTransformation(Value value){
		Value v = new Value();
		if(value.getType() == ValueType.STRING){
			this.setValues((String) value.getValue());

			v.setType(ValueType.FLOAT);

			// Transform from [0,1] to [-1,1] value range
			float x = new Double((this.fromFOREtoReal().floatValue() - 0.5) * 2)
					.floatValue();

			v.setValue(new Float(x));
		}

		return v;
	}

	/**
	 * 
	 */
	public Value outgoingTransformation(Value value){
		Value v = new Value();
		if(value.getType() == ValueType.FLOAT){
			
			float x = new Double(
					(((Float) value.getValue()).floatValue() / 2) + 0.5)
					.floatValue();

			this.fromRealtoFORE(new Float(x));

			v.setType(ValueType.STRING);
			v.setValue(this.toString());
		}

>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		return v;
	}
}