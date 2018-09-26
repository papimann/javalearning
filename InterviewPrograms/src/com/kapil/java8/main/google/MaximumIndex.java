/**
 *
 */
package com.kapil.java8.main.google;

/**
 * @author kapil.arora
 *
 */
public class MaximumIndex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		int n = arr.length;
		int maxDiff = maxIndexDifference(arr, n);
		System.out.println("Maximum Difference is " + maxDiff);
		/*
		 * maxDiff = maxIndexDifferenceEff(arr, n);
		 * System.out.println("Maximum Difference is " + maxDiff);
		 */
	}

	/**
	 * O(n^2) Brute Force
	 */
	private static int maxIndexDifference(int[] arr, int length) {
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < length; ++i) {
			for (int j = length - 1; j > i; --j) {
				if (arr[j] >= arr[i] && maxDiff < (j - 1)) {
					maxDiff = j - i;
				}
			}
		}
		return maxDiff;
	}

	/**
	 * O(n) Efficient Method
	 *//*
	private static int maxIndexDifferenceEff(int[] arr, int length) {
		int maxDiff = -1;
		int[] maxArr = new int[length], minArr = new int[length];
		minArr[0] = arr[0];
		for (int i = 1; i < length; i++) {
			minArr[i] = min(arr[i], minArr[i - 1]);
		}
		maxArr[0] = arr[length - 1];
		for (int i = length - 2; i > 0; i--) {
			maxArr[i] = max(arr[i], maxArr[i + 1]);
		}
		int i = 0, j = 0;
		Arrays.stream(minArr).forEach(System.out::print);
		System.out.println();
		Arrays.stream(maxArr).forEach(System.out::print);
		System.out.println();
		while (i < length && j < length) {
			System.out.println("i " + i + "  " + minArr[i] + " j " + j + "  " + maxArr[j]);
			if (minArr[i] <= maxArr[j]) {
				maxDiff = max(maxDiff, Math.abs(j - i));
				j = j + 1;
			} else {
				i = i + 1;
			}
		}
		return maxDiff;
	}

	private static int max(int i, int j) {
		return i > j ? i : j;
	}

	private static int min(int i, int j) {
		return i > j ? j : i;
	}*/
}
