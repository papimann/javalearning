package com.kapil.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 9, 6, 3, 2, 1 };
		insertionSort(arr);
	}

	private static void insertionSort(int[] arr) {
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
				Arrays.stream(arr).forEach(System.out::print);
				System.out.println();
			}
		}
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
	}

}
