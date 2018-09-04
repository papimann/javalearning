package com.kapil.practice;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String str = "aaaab";
		if (str == null || str.length() < 2) {
			System.out.println(str);
		} else {
			System.out.println(removeDuplicates(str));
			removeDuplicatesUsingSet(str);
			System.out.println();
			removeDups(str);
			removeDupsEff(str);
		}
	}

	private static void removeDupsEff(String str) {
		boolean[] hit = new boolean[256];
		char[] s = new char[str.length()];
		int i = 0;
		for (char c : str.toCharArray()) {
			if (!hit[c]) {
				hit[c] = true;
				s[i++] = c;
			}
		}
		System.out.println(s);
	}

	private static void removeDups(String str) {
		char[] s = str.toCharArray();
		int tail = 1;
		for (int i = 0; i < s.length; i++) {
			int j;
			for (j = 0; j < tail; j++) {
				if (s[i] == s[j]) {
					break;
				}
			}
			if (j == tail) {
				s[tail++] = s[i];
			}
		}
		while (tail < str.length()) {
			s[tail++] = 0;
		}
		System.out.println(s);
	}

	private static void removeDuplicatesUsingSet(String str) {
		Set<Character> set = new HashSet<>();
		for (char c : str.toCharArray()) {
			set.add(c);
		}
		set.forEach(System.out::print);
	}

	private static String removeDuplicates(String str) {
		String s = new String();
		for (char c : str.toCharArray()) {
			if (s.indexOf(c) < 0) {
				s += c;
			}
		}
		return s;
	}

}
