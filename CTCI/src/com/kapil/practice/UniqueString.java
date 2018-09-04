package com.kapil.practice;

import java.util.Arrays;

/**
 * @author kapil.arora
 *
 */
public class UniqueString {

	final static int MAX_CHAR = 256;

	/**
	 * Implement an algorithm to determine if a string has all unique characters.
	 * What if you can not use additional data structures?
	 */

	public static void main(String[] args) {
		String str = "abad";
		System.out.print(isUniqueString(str));
		System.out.print(isUniqueBitVectorString(str));
		System.out.print(uniqueCharactersForLoop(str));
		System.out.println(uniqueCharactersSorted(str));
	}

	/**
	 * Time Complexity O(nlogn)
	 */
	private static boolean uniqueCharactersSorted(String str) {
		/*
		 * Convert the string to character array for sorting
		 */
		char[] charSet = str.toCharArray();
		// Using sorting
		Arrays.sort(charSet);
		for (int i = 0; i < charSet.length - 1; i++) {
			// if at any time, 2 adjacent elements
			// become equal, return false
			if (charSet[i] == charSet[i++]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Time Complexity O(n^2)
	 */
	private static boolean uniqueCharactersForLoop(String str) {

		// If at any time we encounter 2 same
		// characters, return false
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(i) == str.charAt(j)) {
					return false;
				}
			}
		}
		// If no duplicate characters encountered,
		// return true
		return true;
	}

	/**
	 * Time Complexity O(n)
	 */
	private static boolean isUniqueBitVectorString(String str) {
		// Assuming string can have characters a-z
		// this has 32 bits set to 0
		int check = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			System.out.println("val " + val);
			System.out.println(1 << val);
			// if that bit is already set in checker,
			// return false
			if ((check & (1 << val)) > 0) {
				return false;
			}

			// otherwise update and continue by
			// setting that bit in the checker
			System.out.println("check 1 " + check);
			check |= (1 << val);
			System.out.println("check 2 " + check);
		}
		// no duplicates encountered, return true
		return true;
	}

	/**
	 * Time Complexity O(n)
	 */
	private static boolean isUniqueString(String str) {
		// If length is greater than 256,
		// some characters must have been repeated
		if (str.length() > MAX_CHAR)
			return false;

		boolean[] arr = new boolean[MAX_CHAR];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.println(val);
			/*
			 * If the value is already true, string has duplicate characters, return false
			 */
			if (arr[val]) {
				return false;
			}
			arr[val] = true;
		}
		/* No duplicates encountered, return true */
		return true;
	}

}
