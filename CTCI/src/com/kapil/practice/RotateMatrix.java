package com.kapil.practice;

public class RotateMatrix {

	public static void main(String[] args) {
		int N = 4;
		int mat[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		rotateMatrix(N, mat);

		// Print rotated matrix
		displayMatrix(N, mat);
	}

	private static void displayMatrix(int N, int[][] matrix) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.print("\n");
		}

		System.out.print("\n");
		System.out.print("\n");
	}

	private static void rotateMatrix(int N, int[][] mat) {
		displayMatrix(N, mat);
		for (int x = 0; x < N / 2; x++) {
			for (int y = 0; y < N - 1 - x; y++) {
				// store current cell in temp variable
				int temp = mat[x][y];

				// move values from right to top
				mat[x][y] = mat[y][N - 1 - x];
				displayMatrix(N, mat);

				// move values from bottom to right
				mat[y][N - 1 - x] = mat[N - 1 - x][N - 1 - y];
				displayMatrix(N, mat);

				// move values from left to bottom
				mat[N - 1 - x][N - 1 - y] = mat[N - 1 - y][x];
				displayMatrix(N, mat);
				// assign temp to left
				mat[N - 1 - y][x] = temp;
				displayMatrix(N, mat);
			}
		}
	}
}
