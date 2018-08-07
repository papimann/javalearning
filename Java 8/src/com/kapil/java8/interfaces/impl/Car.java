package com.kapil.java8.interfaces.impl;

import com.kapil.java8.interfaces.FourWheeler;
import com.kapil.java8.interfaces.Vehicle;

public class Car implements Vehicle, FourWheeler {

	@Override
	public void print() {
		Vehicle.super.print();
		FourWheeler.super.print();
		FourWheeler.blowHorn();
		System.out.println("I am a car!");
	}

}
