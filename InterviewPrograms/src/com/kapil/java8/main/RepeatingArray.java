package com.kapil.java8.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RepeatingArray {

	void findRepeats(int[] arr) {
		System.out.println("The repeating elements are : ");
		/**
		 * Time Complexity O(n) Space Complexity O(1)
		 */
		for (int i = 0; i < arr.length; i++) {
			if (arr[Math.abs(arr[i])] >= 0) {
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			} else {
				System.out.print(Math.abs(arr[i]) + " ");
			}
		}
	}

	void findRepeatsBruteForce(int[] arr) {
		System.out.println("The repeating elements are : ");
		/**
		 * Time Complexity O(n^2)
		 */
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.print(Math.abs(arr[i]) + " ");
					break;
				}
			}
		}
	}

	void findRepeatsSet(int[] arr) {
		System.out.println("The repeating elements are : ");
		/**
		 * Time Complexity O(n^2)
		 */
		Set<Integer> setArr = new HashSet<>();
		for (int i : arr) {
			if (setArr.contains(i)) {
				System.out.print(i + " ");
			} else {
				setArr.add(i);
			}
		}
	}

	void findDuplicateInArray(int[] arr) {
		List<int[]> listInteger = Arrays.asList(arr);
		listInteger.stream().filter(i -> Collections.frequency(listInteger, i) > 1).collect(Collectors.toSet())
				.forEach(System.out::println);
	}

	public static void main(String[] args) {
		RepeatingArray repeat = new RepeatingArray();
		int[] arr = { 1, 3, 4, 2, 4, 2, 4, 5, 5 };
		repeat.findRepeats(arr);
	}

}
