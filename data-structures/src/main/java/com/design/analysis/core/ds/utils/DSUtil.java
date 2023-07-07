package com.design.analysis.core.ds.utils;

public class DSUtil {

	public static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
	
	public static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	public static int min(int a, int b, int c) {
		return min(min(a, b), c);
	}

	public static int min(int a, int b) {
		return a > b ? b : a;
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

	public static int numOfDigit(int num) {
		int n = 1;
		while (num / 10 > 0) {
			n++;
			num /= 10;
		}
		return n;
	}

	// number of continuous element filled in array except 0
	public static int numOfDigitInArray(int arr[]) {
		int i = 0;
		int count = 0;
		while (arr[i++] > 0) {
			count++;
			if (i == arr.length)
				break;
		}
		return count;
	}

	public static void copyArray(int src[], int initSrcPos, int dest[], int initDestPos, int len) {
		try {
			if (len > src.length || len > dest.length) {
				throw new Exception("length of copy is greater");
			}
			for (int i = initSrcPos; i < len; i++) {
				if (initSrcPos == src.length || initDestPos == dest.length)
					throw new Exception("lenghth of copy is greater");
				dest[initDestPos++] = src[initSrcPos++];
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * public static Object XOR(Object obj1, Object obj2) { Object obj = new
	 * Object(); obj =obj1 ^ obj2; return (Object) obj1 ^ obj2; }
	 */

	/*
	 * A utility function to return precedence of a given operator Higher returned
	 * value means higher precedence
	 */
	public static int precedence(char ch) {

		switch (ch) {

		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}

	// A utility function to check if the given character is operand
	public static boolean isOperand(char ch) {
		return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
	}

	public static int binarySearch(int arr[], int low, int high, int key) {
		if (high < low)
			return -1;
		int mid = (low + high) / 2;
		if (key == arr[mid])
			return mid;
		if (key > arr[mid])
			return binarySearch(arr, (mid + 1), high, key);
		return binarySearch(arr, low, (mid - 1), key);
	}
}
