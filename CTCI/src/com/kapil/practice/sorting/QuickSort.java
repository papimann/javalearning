package com.kapil.practice.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 9, 6, 5, 4, 2, 1 };
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		int i = 0;
		if (i > 0) {
			if (low < high) {
				int pivot = partition(arr, low, high);

				quickSort(arr, low, pivot - 1);
				quickSort(arr, pivot + 1, high);
			}
		} else {
			while (low < high) {
				int pivot = partition(arr, low, high);
				if (i > 0) {
					quickSort(arr, low, pivot - 1);
					low = pivot + 1;
				} else {
					if (pivot - low < high - pivot) {
						quickSort(arr, low, pivot - 1);
						low = pivot + 1;
					} else {
						quickSort(arr, pivot + 1, high);
						high = pivot - 1;
					}
				}
			}
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
		return (i + 1);
	}

}
