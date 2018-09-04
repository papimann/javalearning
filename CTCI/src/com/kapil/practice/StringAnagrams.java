package com.kapil.practice;

import java.util.Arrays;

public class StringAnagrams {

	public static void main(String[] args) {
		String str = "acb";
		String str1 = "bca";
		if (str.length() != str1.length()) {
			System.out.println(false);
		} else {
			System.out.println(isAnagramNonArrayEqual(str, str1));
			System.out.println(isAnagramArraySort(str, str1));
			System.out.println(isAnagramQuickSort(str.toCharArray(), str1.toCharArray()));
		}
	}

	private static boolean isAnagramQuickSort(char[] s1, char[] s2) {
		quickSort(s1, 0, s1.length - 1);
		quickSort(s2, 0, s2.length - 1);
		for (int i = 0; i < s1.length; i++) {
			if (s1[i] != s2[i]) {
				return false;
			}
		}
		return true;
	}

	private static void quickSort(char[] arr, int low, int high) {
		/*if (low < high) {
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}*/

		while (low < high) {
			/*
			 * pi is partitioning index, arr[p] is now at right place
			 */
			int pi = partition(arr, low, high);

			// Separately sort elements before
			// partition and after partition
			quickSort(arr, low, pi - 1);

			low = pi + 1;
		}
	}

	private static int partition(char[] str, int low, int high) {
		char pivot = str[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (str[j] <= pivot) {
				i++;
				swap(str, i, j);
			}
		}
		swap(str, i + 1, high);
		return (i + 1);
	}

	private static void swap(char[] str, int i, int j) {
		char c = str[i];
		str[i] = str[j];
		str[j] = c;
	}

	private static boolean isAnagramNonArrayEqual(String s1, String s2) {
		for (char c : s1.toCharArray()) {
			if (s2.indexOf(c) > -1) {
				s2 = s2.replace("" + c, "");
			}
		}
		return s2.isEmpty();
	}

	private static boolean isAnagramArraySort(String s1, String s2) {
		char[] s1Arr = s1.toCharArray(), s2Arr = s2.toCharArray();
		Arrays.sort(s1Arr);
		Arrays.sort(s2Arr);
		return Arrays.equals(s1Arr, s2Arr);
	}

}
