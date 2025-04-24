package com.udemy.basic.functional.demo;

public class ReferentialTransparency {

	public static void main(String[] args) {

		int result = add(multiply(2, 3), multiply(3, 4));
		result = add(6, multiply(3, 4));
		System.out.println(result);
		result = add(multiply(2, 3), 12);
		System.out.println(result);
		System.out.println(result);
		result = add(6, 12);
		System.out.println(result);
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int multiply(int a, int b) {
		return a * b;
	}
}
