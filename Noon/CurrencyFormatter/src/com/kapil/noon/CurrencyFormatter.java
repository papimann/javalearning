package com.kapil.noon;

import java.util.HashMap;
import java.util.Map;

public class CurrencyFormatter {

	static Map<Integer, String> currencyMap = new HashMap<>();
	static Map<Integer, String> placeHolderMap = new HashMap<>();

	public static void main(String[] args) {
		loadValues();
		String curr = "1,02,001";
		String[] hds = curr.split(",");
		loadPlaceHolders(hds[hds.length - 2].length() == 2);
		// TODO Auto-generated method stub

		String str = null;
		int x = 0;
		for (int i = hds.length; i > 0; i--) {
			int numericStr = Integer.parseInt(hds[i - 1]);
			String currStr = convertToString(numericStr, x);
			if (str == null) {
				str = currStr;
			} else {
				str = currStr + ", " + str;
			}
			x++;
		}
		System.out.println(str);
	}

	private static void loadPlaceHolders(boolean isIndian) {
		placeHolderMap.put(1, "Thousand");
		placeHolderMap.put(2, "Millions");
		placeHolderMap.put(3, "Billions");
		if (isIndian) {
			placeHolderMap.put(2, "Lakhs");
			placeHolderMap.put(3, "Crores");
		}

	}

	private static void loadValues() {

		currencyMap.put(1, "One");
		currencyMap.put(2, "Two");
		currencyMap.put(3, "Three");
		currencyMap.put(4, "Four");
		currencyMap.put(5, "Five");
		currencyMap.put(6, "Six");
		currencyMap.put(7, "Seven");
		currencyMap.put(8, "Eight");
		currencyMap.put(9, "Nine");
		currencyMap.put(10, "Ten");
		currencyMap.put(11, "Eleven");
		currencyMap.put(12, "Twelve");
		currencyMap.put(13, "Thirteen");
		currencyMap.put(14, "Fourteen");
		currencyMap.put(15, "Fifteen");
		currencyMap.put(16, "Sixteen");
		currencyMap.put(17, "Seventeen");
		currencyMap.put(18, "Eighteen");
		currencyMap.put(19, "Nineteen");
		currencyMap.put(20, "Twenty");
		currencyMap.put(30, "Thirty");
		currencyMap.put(40, "Forty");
		currencyMap.put(50, "Fifty");
		currencyMap.put(60, "Sixty");
		currencyMap.put(70, "Seventy");
		currencyMap.put(90, "Ninety");
		currencyMap.put(80, "Eighty");
	}

	private static String convertToString(int number, int currencyEnumValue) {
		String appender = placeHolderMap.get(currencyEnumValue);
		appender = appender == null ? "" : appender;
		StringBuffer str = new StringBuffer();
		int hundreds = number % 1000 / 100;
		if (hundreds > 0) {
			str.append(currencyMap.get(hundreds));
			str.append(" Hundred");
		}
		int ones = number % 10;
		int tens = ones > 0 ? (number % 100) / 10 : number % 100;
		if (tens == 1) {
			str.append(" " + currencyMap.get(number % 100));
		} else {
			if (tens > 0) {
				tens = tens * 10;
				str.append(" " + currencyMap.get(tens));
			}
			if (ones > 0) {
				str.append(" " + currencyMap.get(ones));
			}
		}

		return str.append(" " + appender).toString();
	}

}
