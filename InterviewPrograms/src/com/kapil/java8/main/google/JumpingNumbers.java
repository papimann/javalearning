package com.kapil.java8.main.google;

public class JumpingNumbers {

	public static void main(String[] args) {
		findJumpingNumbers(4343456);
	}

	private static void findJumpingNumbers(int max) {
		int i = 0;
		while (i <= max) {
			if (i < 10) {
				System.out.print(i + " ");
			} else {
				printNumber(i);
			}
			i++;
		}
	}

	private static void printNumber(int i) {
		int j = i / 10;
		int k = i % 10;
		int diff = 1;
		while (j > 0 && diff == 1) {
			diff = Math.abs(k - Math.min(j, j % 10));
			k = j % 10;
			j = j / 10;
		}
		if (diff == 1) {
			System.out.print(i + " ");
		}
	}

}
