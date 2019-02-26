package com.kapil.lenskart;

import java.util.ArrayList;
import java.util.List;

public class ProductArray {

	public static void main(String[] args) {
		int[] arr = { 5, 2, 6, 20, 3, 13 };
		findPairofNumbersWithProduct(arr, 27);
		findPairEffWithProduct(arr, 26);
	}

	private static void findPairofNumbersWithProduct(int[] arr, int product) {
		int a, b;
		for (int i = 0; i < arr.length; i++) {
			a = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				b = arr[j];
				if (a * b == product) {
					System.out.println("Product Found with Sum 36 i.e. " + a + " & " + b);
					return;
				}
			}
		}
		System.out.println("No Pair Found");
	}

	private static void findPairEffWithProduct(int[] arr, int product) {
		List<Integer> list = new ArrayList<>();
		for (int x : arr) {
			int y = product / x;
			if (product % x == 0 && list.contains(y)) {
				System.out.println("Product found with pairs " + x + " & " + (product / x));
				return;
			} else {
				list.add(x);
			}
		}
		System.out.println("No Pair Found");
	}
}
