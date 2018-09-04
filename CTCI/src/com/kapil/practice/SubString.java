package com.kapil.practice;

public class SubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "waterbottle";
		String str2 = "erbottlewat";
		isSubString(str1, str2);
	}

	private static void isSubString(String str1, String str2) {
		for (char c : str1.toCharArray()) {
			if (str2.indexOf(c) > -1) {
				str2 = str2.replace("" + c, "");
			}
		}
		System.out.println(str2.isEmpty());
	}

}
