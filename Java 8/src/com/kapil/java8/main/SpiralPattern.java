package com.kapil.java8.main;

public class SpiralPattern {

	public static void main(String[] args) {
		int n = 2;
		int max = 2 * n - 1;
		int x = 0;
		int[][] arr = new int[max][max];
		while (x < n) {
			arr = formPattern(arr, x, max, n);
			x++;
		}
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	private static int[][] formPattern(int[][] arr, int x, int max, int n) {
		for (int i = 0; i < max; i++) {
			for (int j = 0; j < max; j++) {
				if (i == x || j == x || i == max - 1 - x || j == max - 1 - x) {
					arr[i][j] = arr[i][j] == 0 ? (n - x) : arr[i][j];
				}
			}
		}
		return arr;
	}
}
