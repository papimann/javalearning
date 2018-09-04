package com.kapil.practice.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 78, 9, 6, 5, 4, 2, 1 };
		mergeSort(arr, 0, arr.length - 1);
		Arrays.stream(arr).forEach(System.out::print);
		System.out.println();
	}

	private static void mergeSort(int[] arr, int low, int high) {
		if (low < high) {
			int pivot = (low + high) / 2;
			mergeSort(arr, low, pivot);
			mergeSort(arr, pivot + 1, high);

			merge(arr, low, pivot, high);
		}
	}

	private static void merge(int[] arr, int low, int pivot, int high) {
		int left = pivot - low + 1;
		int right = high - pivot;

		int leftArr[] = new int[left];
		int rightArr[] = new int[right];

		/* Copy data to temp arrays */

		for (int i = 0; i < left; ++i) {
			leftArr[i] = arr[low + i];
		}

		for (int j = 0; j < right; ++j) {
			rightArr[j] = arr[pivot + 1 + j];
		}

		int i = 0, j = 0;

		int k = low;

		while (i < left && j < right) {
			if (leftArr[i] <= rightArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = rightArr[j];
				j++;
			}
			k++;
		}
		for (; i < left; i++) {
			arr[k] = leftArr[i];
			k++;
		}
		for (; j < right; j++) {
			arr[k] = rightArr[j];
			k++;
		}
	}

}
