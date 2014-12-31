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
package otservices.translator.valuetransformation.art;

import otservices.translator.valuetransformation.ValueTransformationInterface;

public abstract class FOREValueTransformation implements
		ValueTransformationInterface {
	
	public static final Integer	VB			= new Integer(0);
	
	public static final Integer	B				= new Integer(1);
	
	public static final Integer	N				= new Integer(2);
	
	public static final Integer	G				= new Integer(3);
	
	public static final Integer	VG			= new Integer(4);
	
	private Float[]							values	= new Float[5];
	
	
	/**
	 * 
	 * (2x - 1) / 10
	 * 
	 */
	private Float cm(Float x) {
		return new Float((2 * x - 1) / 10);
	}
	
	
	/**
	 * 
	 * 1/10 * Ei (2i - 1) Xi
	 * 
	 */
	public Float fromFOREtoReal() {
		float cm = 0;
		float aux = 0;
		for(int i = 1; i <= 5; i++) {
			aux = ((2 * i) - 1) * this.values[i - 1].floatValue();
			cm = cm + aux;
		}
		cm = cm / 10;
		
		return new Float(cm);
	}
	
	
	/**
	 * 
	 */
	public void fromRealtoFORE(Float realValue) {
		int i1 = Math.min(this.convertIndex(realValue).intValue(), this
				.convertIndex(new Float(Math.max(realValue - 0.1, 0))).intValue());
		
		int i2 = Math.min(5, i1 + 1);
		
		// 1 - ((realValue - cm(i1)) / (cm(i2) - cm(i1)))
		float p = 1 - (realValue - this.cm(new Float(i1)).floatValue())
				/ (cm(new Float(i2)).floatValue() - cm(new Float(i1)).floatValue());
		
		p = new Double(Math.min(1.0, Math.max(0.0, p))).floatValue();
		
		values[i1 - 1] = new Float(p);
		values[i2 - 1] = new Float(1 - p);
		for(int i = 0; i < 5; i++) {
			if((i != (i1 - 1)) && (i != (i2 - 1))) {
				values[i] = new Float(0);
			}
		}
	}
	
	
	/**
	 * 
	 */
	private Integer convertIndex(Float realValue) {
		Integer result = 1;
		float aux = realValue.floatValue();
		
		if((aux >= 0) && (aux <= 0.2)) {
			result = new Integer(1);
		} else if((aux > 0.2) && (aux <= 0.4)) {
			result = new Integer(2);
		} else if((aux > 0.4) && (aux <= 0.6)) {
			result = new Integer(3);
		} else if((aux > 0.6) && (aux <= 0.8)) {
			result = new Integer(4);
		} else if((aux > 0.8) && (aux <= 1)) {
			result = new Integer(5);
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public void setValues(Float vb, Float b, Float n, Float g, Float vg) {
		values = new Float[5];
		values[VB.intValue()] = vb;
		values[B.intValue()] = b;
		values[N.intValue()] = n;
		values[G.intValue()] = g;
		values[VG.intValue()] = vg;
	}
	
	
	/**
	 * 
	 */
	public void setValues(Float[] values) {
		for(int i = 0; i < 5; i++) {
			this.values[i] = values[i];
		}
	}
	
	
	/**
	 * 
	 */
	public Boolean setValues(String strValues) {
		Boolean result = new Boolean(false);
		
		strValues = strValues.substring(1, strValues.length() - 1);
		String[] v = strValues.split(";");
		if(v.length == 5) {
			for(int i = 0; i < v.length; i++) {
				try {
					values[i] = new Float(v[i]);
				} catch(NumberFormatException nfe) {
					continue;
				}
			}
		}
		
		return result;
	}
	
	
	/**
	 * 
	 */
	public String toString() {
		return "[" + values[VB.intValue()].toString().substring(0, 3) + ";"
				+ values[B.intValue()].toString().substring(0, 3) + ";"
				+ values[N.intValue()].toString().substring(0, 3) + ";"
				+ values[G.intValue()].toString().substring(0, 3) + ";"
				+ values[VG.intValue()].toString().substring(0, 3) + "]";
	}
}
