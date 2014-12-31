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
package otservices.translator.language;

@SuppressWarnings("serial")
<<<<<<< HEAD
public class LanguageException extends Exception {
	
	/**
	 * 
	 */
	public LanguageException() {
	}
	
	
	/**
	 * 
	 */
	public LanguageException(String msg) {
		super(msg);
	}
	
	
	/**
	 * 
	 */
	public LanguageException(String msg, Exception cause) {
=======
public class LanguageException extends Exception{

	/**
	 * 
	 */
	public LanguageException(){
	}

	/**
	 * 
	 */
	public LanguageException(String msg){
		super(msg);
	}

	/**
	 * 
	 */
	public LanguageException(String msg, Exception cause){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
		super(msg);
		initCause(cause);
	}
}
