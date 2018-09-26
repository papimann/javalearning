package com.kapil.practice;

public class SpaceReplace {

	public static void main(String[] args) {
		String str = "Hi, I am Kapil Arora.";
		replaceSpace(str);
	}

	private static void replaceSpace(String str) {
		char[] data = str.toCharArray();
		int length = data.length;
		int spaceCount = 0;
		for (int i = 0; i < length; i++) {
			if (data[i] == ' ') {
				spaceCount++;
			}
		}
		int newLength = length + (spaceCount * 2);
		System.out.println(newLength);
		char[] str1 = new char[newLength];
		for (int i = length - 1; i >= 0; i--) {
			if (data[i] == ' ') {
				str1[newLength - 1] = '0';
				str1[newLength - 2] = '2';
				str1[newLength - 3] = '%';
				newLength -= 3;
			} else {
				str1[newLength - 1] = data[i];
				newLength -= 1;
			}
		}
		System.out.println(str1);
	}

}
