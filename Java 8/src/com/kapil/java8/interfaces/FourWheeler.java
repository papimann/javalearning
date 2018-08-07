package com.kapil.java8.interfaces;

public interface FourWheeler {

	default void print() {
		System.out.println("I am a 4 wheeler vehicle!");
	}

	static void blowHorn() {
		System.out.println("Blowing horn!!!");
	}
}
