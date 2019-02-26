package com.kapil.lenskart;

public class ZeroSum {

	public static void main(String[] args) {
		int arr[] = { 1, 4, 5, 5, 3, 5, 2 };
		findSubArrayWithSumZero(arr);
		findEffSubArrayWithZeroSum(arr);
	}

	private static void findSubArrayWithSumZero(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if (sum == 0) {
					System.out.println("Zero Sum Found from index " + i + " to " + j);
					return;
				}
			}
		}
		System.out.println("No Sub Array Found with sum 0");
	}

	private static void findEffSubArrayWithZeroSum(int[] arr) {

	}

}
