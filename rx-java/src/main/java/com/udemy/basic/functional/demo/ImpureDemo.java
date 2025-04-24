package com.udemy.basic.functional.demo;

public class ImpureDemo {

	public static void main(String[] args) {

		int result = add(multiply(2, 3), multiply(3, 4));
		System.out.println(result);
		// if calling by returning multiply function return the the significance of the
		// code get changed
		int resultNew = add(6, 12);
		System.out.println(resultNew);
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int multiply(int a, int b) {
		log(String.format("Returning %s as result of %s * %s", a * b, a, b));
		return a * b;
	}

	public static void log(String str) {
		System.out.println(str);
	}
}
