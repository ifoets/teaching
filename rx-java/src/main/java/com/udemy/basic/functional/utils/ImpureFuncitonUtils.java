package com.udemy.basic.functional.utils;

public class ImpureFuncitonUtils {

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
