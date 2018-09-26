package com.kapil.java8.main.google;

import java.util.Stack;

public class LongestValidParanthesis {

	public static void main(String[] args) {
		String str = "(((i)()";
		System.out.println(findMaxLen(str, '(', ')'));
	}

	private static int findMaxLen(String str, char start, char end) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.charAt(i));
			if (str.charAt(i) == start) {
				stack.push(i);
				System.out.println("0 " + stack);
			} else if (str.charAt(i) == end) {
				System.out.println("1 " + stack);
				stack.pop();
				System.out.println("2 " + stack);
				if (!stack.empty()) {
					result = Math.max(result, i - stack.peek());
					System.out.println("Result " + result + " " + stack);
				} else {
					stack.push(i);
					System.out.println(stack);
				}
			}
		}
		return result;
	}

}
