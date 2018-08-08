package com.kapil.java8.main;

import java.util.HashMap;

public final class KapilImmutable {

	private final int id;

	private final String name;

	private final HashMap<String, String> testMap;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public KapilImmutable(int id, String name, HashMap<String, String> testMap, boolean shallow) {
		super();
		this.id = id;
		this.name = name;
		if (shallow) {
			this.testMap = testMap;
		} else {
			HashMap<String, String> tempMap = new HashMap<>();
			testMap.keySet().forEach(key -> tempMap.put(key, testMap.get(key)));
			this.testMap = tempMap;
		}
	}

	@SuppressWarnings("unchecked")
	public HashMap<String, String> getTestMap() {
		return (HashMap<String, String>) testMap.clone();
	}

	public static void main(String[] args) {
		HashMap<String, String> h1 = new HashMap<>();
		h1.put("1", "first");
		h1.put("2", "second");
		String s = "original";
		int i = 10;
		KapilImmutable ce = new KapilImmutable(i, s, h1, true);
		System.out.println("Shallow Copy");
		System.out.println(s == ce.getName());
		System.out.println(h1 == ce.getTestMap());
		System.out.println("class id " + ce.getId());
		System.out.println("class name " + ce.getName());
		System.out.println("class map " + ce.getTestMap());
		i = 20;
		s = "modified";
		h1.put("3", "Hello");

		System.out.println("ce id after local variable change:" + ce.getId());
		System.out.println("ce name after local variable change:" + ce.getName());
		System.out.println("ce testMap after local variable change:" + ce.getTestMap());

		HashMap<String, String> hmTest = ce.getTestMap();
		hmTest.put("4", "new");

		System.out.println("ce testMap after changing variable from accessor methods:" + ce.getTestMap());
	}

}
