/**
 * Copyright (c) 2003-2007 Philip Isenhour
 */
package otservices.util;

<<<<<<< HEAD
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
=======
import java.io.IOException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05

/**
 * Utility for making deep copies (vs. clone()'s shallow copies) of objects.
 * Objects are first serialized and then deserialized. Error checking is fairly
 * minimal in this implementation. If an object is encountered that cannot be
 * serialized (or that references an object that cannot be serialized) an error
 * is printed to System.err and null is returned. Depending on your specific
 * application, it might make more sense to have copy(...) re-throw the
 * exception.
 * 
 * A later version of this class includes some minor optimizations.
 */
<<<<<<< HEAD
public class ObjectCopy {
=======
public class ObjectCopy{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
	
	/**
	 * Returns a copy of the object, or null if the object cannot be serialized.
	 */
<<<<<<< HEAD
	public static Object copy(Object orig) {
		Object obj = null;
		try {
=======
	public static Object copy(Object orig){
		Object obj = null;
		try{
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			// Write the object out to a byte array
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);
			out.writeObject(orig);
			out.flush();
			out.close();
			
			// Make an input stream from the byte array and read
			// a copy of the object back in.
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
					bos.toByteArray()));
			obj = in.readObject();
<<<<<<< HEAD
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
=======
		}catch(IOException e){
			e.printStackTrace();
		}catch(ClassNotFoundException cnfe){
>>>>>>> 181e5e943b8d63ecfeef46d9e31900f14099ac05
			cnfe.printStackTrace();
		}
		return obj;
	}
}