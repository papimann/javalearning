/**
 *
 */
package com.kapil.java8.main.google;

import java.util.Arrays;

/**
 * @author kapil.arora
 *
 */
public class FindNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 1, 2, 4, 12, 12, 31 };
		int length = arr.length;
		findUniqueNumbers(arr, length);
	}

	private static void findUniqueNumbers(int[] arr, int length) {
		int max = 32;
		int[] unique = new int[max];
		for (int i = 0; i < length; i++) {
			if (unique[arr[i]] == arr[i]) {
				unique[arr[i]] = -1;
			} else if (unique[arr[i]] == 0) {
				unique[arr[i]] = arr[i];
			}
		}
		Arrays.stream(unique).filter(x -> x > 0).forEach(System.out::println);
	}

}
