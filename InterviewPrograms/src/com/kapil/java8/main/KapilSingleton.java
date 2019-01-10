package com.kapil.java8.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class KapilSingleton implements Serializable, Cloneable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8209545511719629495L;

	private static KapilSingleton myObj;

	private static Object mutex = new Object();

	private KapilSingleton() {
		if (myObj != null) {
			throw new IllegalStateException("Singleton already constructed");
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// return myObj;
		throw new CloneNotSupportedException();
	}

	protected Object readResolve() {
		return myObj;
	}

	/*
	 * public static KapilSingleton getInstance() { if (myObj == null) { myObj = new
	 * KapilSingleton(); } return myObj; }
	 */

	public static KapilSingleton getInstance() {
		KapilSingleton result = myObj;
		if (result == null) {
			synchronized (mutex) {
				result = myObj;
				if (result == null) {
					myObj = result = new KapilSingleton();
				}
			}
		}
		return result;
	}

	public void getSomeThing() {
		// do something here
		System.out.println("I am here....");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			KapilSingleton st = KapilSingleton.getInstance();
			KapilSingleton st1 = null;
			/**
			 * Reflection
			 */

			try {
				Constructor<?>[] constructors = KapilSingleton.class.getDeclaredConstructors();
				for (Constructor<?> constructor : constructors) {
					constructor.setAccessible(true);
					st1 = (KapilSingleton) constructor.newInstance();
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			/**
			 * Serialization
			 */
 
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file.txt"));
			out.writeObject(st);
			out.close();
			ObjectInput in = new ObjectInputStream(new FileInputStream("file.txt"));
			st1 = (KapilSingleton) in.readObject();
			in.close();

			/**
			 * Normal
			 */
			// st.getSomeThing();
			/**
			 * Cloneable
			 */
			st1 = (KapilSingleton) st.clone();
			System.out.println("1 " + st.hashCode());
			System.out.println("2 " + st1.hashCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
