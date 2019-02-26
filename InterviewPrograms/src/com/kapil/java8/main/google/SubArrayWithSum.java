/**
 *
 */
package com.kapil.java8.main.google;

/**
 * @author kapil.arora
 *
 */
public class SubArrayWithSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 };
		int length = arr.length;
		int sum = 15;
		//findSubArrayWithSumBFM(arr, length, sum);
		sum = 34;
		findSubArrayWithSumEFM(arr, length, sum);
	}

	/**
	 * Time Complexity - O(n^2) Brute Force Mechanism
	 */
	@SuppressWarnings("unused")
	private static void findSubArrayWithSumBFM(int[] arr, int length, int sum) {
		int currSum;
		for (int i = 0; i < length; i++) {
			currSum = arr[i];
			for (int j = i + 1; j < length; j++) {
				if (currSum == sum) {
					int end = j - 1;
					System.out.println("Sum is from index " + i + " to " + end);
					return;
				}
				if (currSum > sum || j == length) {
					break;
				}
				currSum += arr[j];
			}
		}
		System.out.println("No subarray found");
	}

	/**
	 * Time Complexity O(n) Effective method
	 */
	private static void findSubArrayWithSumEFM(int[] arr, int length, int sum) {
		int currSum = arr[0];
		int start = 0;
		for (int i = 1; i < length; i++) {
			if (currSum == sum) {
				int end = i - 1;
				System.out.println("Sum is from index " + start + " to " + end);
				return;
			}
			while (currSum > sum && start < i) {
				currSum = currSum - arr[start];
				start++;
			}
			currSum += arr[i];
		}
		System.out.println("No subarray found");
	}

}
