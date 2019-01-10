package com.kapil.practice;

public class ZeroRowColumn {

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 0, 4 }, { 5, 0, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		new ZeroRowColumn().setZeroes(matrix);
		displayMatrix(matrix);
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

	@SuppressWarnings("unused")
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
			for (int j = 0; j < matrix[0].length; j++) {
				if (row[i] || column[j]) {
					matrix[i][j] = 0;
				}
			}
		}
		displayMatrix(matrix);
	}


	public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColumnZero = false;
        System.out.println("1111111111111");
        displayMatrix(matrix);
        //set first row and column zero or not
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0){
                firstColumnZero = true;
                break;
            }
        }

        for(int i=0; i<matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZero = true;
                break;
            }
        }

        //mark zeros on first row and column
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                   matrix[i][0] = 0;
                   matrix[0][j] = 0;
                }
            }
        }
        System.out.println("w1111111111111");
        displayMatrix(matrix);
        //use mark to set elements
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                   matrix[i][j] = 0;
                }
            }
        }
        System.out.println("12111111111111");
        displayMatrix(matrix);

        //set first column and row
        if(firstColumnZero){
            for(int i=0; i<matrix.length; i++)
                matrix[i][0] = 0;
        }
        System.out.println("311112111111111");
        displayMatrix(matrix);

        if(firstRowZero){
            for(int i=0; i<matrix[0].length; i++)
                matrix[0][i] = 0;
        }

    }
}
