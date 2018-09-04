package com.kapil.practice;

public class ReverseCStyleString {

	public static void main(String[] args) {
		String str = "abcd";
		char[] try1 = str.toCharArray();
		for (int i = try1.length - 1; i > 0; i--) {
			System.out.print(try1[i]);
		}
		System.out.println(new StringBuilder(str).reverse());
		System.out.println(reverseCString(str));
	}

	private static String reverseCString(String str) {

		// TODO Auto-generated method stub
		char[] data = str.toCharArray();
		int i = 0;
		int j = data.length - 1;
		char temp;

		while (i < j) {
			temp = data[i];
			data[i] = data[j];
			data[j] = temp;
			i++;
			j--;
		}

		String s = new String(data);
		return s;
	}

}
