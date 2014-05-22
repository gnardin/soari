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

import java.io.ByteArrayInputStream;

import otservices.translator.language.LanguageFactory;
import otservices.translator.language.LanguageInterface;
import otservices.translator.language.sparql.parser.SPARQLParser;

public class SPARQLFactory implements LanguageFactory{

	/**
	 * 
	 */
	public LanguageInterface createParser(Object message){
		LanguageInterface result = null;

		if(message instanceof String){
			String msg = (String) message;
			if((msg.startsWith("UPDATE")) || (msg.startsWith("SELECT"))){
				result = new SPARQLParser(new ByteArrayInputStream(msg
						.getBytes()));
			}else{
				result = new SPARQLParser(msg);
			}
		}

		return result;
	}
}
