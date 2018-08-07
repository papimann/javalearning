package com.kapil.java8.main;

import com.kapil.java8.interfaces.Vehicle;
import com.kapil.java8.interfaces.impl.Car;

public class InterfaceMethod {

	public static void main(String[] args) {
		Vehicle vehicle = new Car();
		vehicle.print();
	}

}
