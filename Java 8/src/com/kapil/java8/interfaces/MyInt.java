package com.kapil.java8.interfaces;

@FunctionalInterface
public interface MyInt {

	public void runs();

	default void accept() {
		System.out.println("");
	}
}
