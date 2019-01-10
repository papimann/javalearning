package com.kapil.practice.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 9, 5, 4, 6, 2, 1 };
		bubbleSort(arr);
	}

	private static void bubbleSort(int[] arr) {
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		for (int i = 0; i < arr.length - 1; i++) {
			boolean isSwap = false;
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwap = true;
				}
				Arrays.stream(arr).forEach(System.out::print);
				System.out.println();
			}
			Arrays.stream(arr).forEach(System.out::print);
			System.out.println();
			if (isSwap == false) {
				break;
			}
		}
	}

}
