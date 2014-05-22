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
package otservices.translator.reputationreasoner.impl;

public class ARTDecision{
	
	private boolean lie;
	private double	bias;

	/**
	 *
	 */
	public double getBias(){
		return this.bias;
	}

	/**
	 * 
	 */
	public void setBias(double bias){
		this.bias = bias;
	}

	/**
	 *
	 */
	public boolean isLie(){
		return this.lie;
	}

	/**
	 *
	 */
	public void setLie(boolean lie){
		this.lie = lie;
	}

	/**
	 * 
	 */
	public double lie(double truth){
		double deviation = truth * this.bias;
		if((truth - deviation) > 0){
			return truth - deviation;
		}
		return truth + deviation;
	}
}