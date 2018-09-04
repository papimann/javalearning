package com.kapil.practice;

public class ZeroRowColumn {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 0, 4 }, { 5, 0, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		setZeroRowColumn(matrix);
	}

	private static void displayMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print("\t " + matrix[i][j]);
			}
			System.out.print("\n");
		}

		System.out.print("\n");
		System.out.print("\n");
	}

	private static void setZeroRowColumn(int[][] matrix) {
		// Print rotated matrix
		displayMatrix(matrix);
		boolean[] row = new boolean[matrix.length];
		boolean[] column = new boolean[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = true;
					column[j] = true;
				}
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			if (row[i]) {
				for (int j = 0; j < matrix[0].length; j++) {
					matrix[i][j] = 0;
				}
			}
		}
		for (int j = 0; j < matrix[0].length; j++) {
			if (column[j]) {
				for (int i = 0; i < matrix.length; i++) {
					matrix[i][j] = 0;
				}
			}
		}
		displayMatrix(matrix);
	}

}
