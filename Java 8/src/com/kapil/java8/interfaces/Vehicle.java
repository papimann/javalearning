package com.kapil.java8.interfaces;

public interface Vehicle {

	default void print() {
		System.out.println("I am a vehicle!");
	}
}
