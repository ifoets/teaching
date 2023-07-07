package com.design.analysis.core.algo.matheticalalgorithms;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumberImpl implements IFibonacciNumber {

	/** 1. Fibonacci Numbers **/
	public int nthFibonaciNum(int n) {

		if (n == 0)
			return 0;
		if (n == 1 || n == 2)
			return 1;
		int a = 0;
		int b = 1;
		int c = 0;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	/* the last digit is repeating in fibonaci after soem index */
	@Override
	public int repeatingIndexOfLastDigit() {
		int max = 100000000;
		long arr[] = new long[max];
		arr[0] = 0;
		arr[1] = 1;

		int i = 0;
		for (i = 2; i < max; i++)
			arr[i] = arr[i - 1] + arr[i - 2];

		// Traversing through store numbers
		for (i = 1; i < max - 1; i++) {
			if ((arr[i] % 10 == 0) && (arr[i + 1] % 10 == 1))
				break;
		}
		return i;
	}

	/** 3. How to check if a given number is Fibonacci number? **/
	@Override
	public boolean isFibonacci(int n) {

		// n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
		// is a perfect square
		return isPerfectSquare(5 * n * n + 4) || isPerfectSquare(5 * n * n - 4);
	}

	@Override
	public boolean isPerfectSquare(int x) {
		int s = (int) Math.sqrt(x);
		return (s * s == x);
	}

	/** 4. Zeckendorf�s Theorem (Non-Neighbouring Fibonacci Representation) **/
	public List<Integer> nonNeighborFibonacciRepresent(int n) {
		List<Integer> list = new ArrayList<>();

		while (n > 0) {
			// Find the greates Fibonacci Number smaller
			// than or equal to n
			int f = nearestSmallerEqFib(n);
			// Print the found fibonacci number
			list.add(f);
			// Reduce n
			n = n - f;
		}
		return list;
	}

	/* nearest fibonacci no */
	@Override
	public int nearestSmallerEqFib(int n) {
		// Corner cases
		if (n == 0 || n == 1)
			return n;

		// Find the greatest Fibonacci Number smaller
		// than n.
		int f1 = 0, f2 = 1, f3 = 1;
		while (f3 <= n) {
			f1 = f2;
			f2 = f3;
			f3 = f1 + f2;
		}
		return f2;
	}

	/** 5. Finding nth Fibonacci Number using Golden Ratio **/
	static double PHI = 1.6180339;

	// Fibonacci numbers upto n = 5
	static int f[] = { 0, 1, 1, 2, 3, 5 };

	@Override
	public int fiboNoByGoldenRatio(int n) {

		// Fibonacci numbers for n < 6
		if (n < 6)
			return f[n];

		// Else start counting from
		// 5th term
		int t = 5;
		int fn = 5;

		while (t < n) {
			fn = (int) Math.round(fn * PHI);
			t++;
		}

		return fn;
	}

	/** 7. Fibonacci Coding **/
	int fib[] = new int[30];

	@Override
	public String fibonacciEncoding(int n) {
		int index = largestFiboIndexLessOrEqual(n);

		// allocate memory for codeword
		char codeword[] = new char[index + 3];

		// index of the largest Fibonacci f <= n
		int i = index;

		while (n > 0) {
			// Mark usage of Fibonacci f (1 bit)
			codeword[i] = '1';

			// Subtract f from n
			n = n - fib[i];

			// Move to Fibonacci just smaller than f
			i = i - 1;

			// Mark all Fibonacci > n as not used (0 bit),
			// progress backwards
			while (i >= 0 && fib[i] > n) {
				codeword[i] = '0';
				i = i - 1;
			}
		}

		// additional '1' bit
		codeword[index + 1] = '1';
		codeword[index + 2] = '\0';

		// return pointer to codeword
		return String.valueOf(codeword);
	}

	@Override
	public int largestFiboIndexLessOrEqual(int n) {

		fib[0] = 1;
		fib[1] = 2;

		int i;
		for (i = 2; fib[i - 1] <= n; i++)
			fib[i] = fib[i - 1] + fib[i - 2];

		return (i - 2);
	}

	/** 8. n�th multiple of a number in Fibonacci Series **/
	@Override
	public int nthMaulitpleInFiboIndex(int k, int n) {
		long f1 = 0, f2 = 1, f3;
		int i = 2;

		while (i != 0) {
			f3 = f1 + f2;
			f1 = f2;
			f2 = f3;

			if (f2 % k == 0) {
				return n * i;
			}

			i++;
		}
		return 0;
	}

	/** 9. GCD and Fibonacci Numbers **/
	public int gcdOfFiboNums(int m, int n) {
		return nthFibonaciNum(gcd(m, n));
	}

	public int gcd(int m, int n) {
		if (m == 0)
			return n;
		return gcd(n % m, m);
	}

	/** 10. Cassini�s Identity **/
	@Override
	public int cassintiIndentity(int n) {
		return nthFibonaciNum(n - 1) * nthFibonaciNum(n + 1) - nthFibonaciNum(n) * nthFibonaciNum(n);
	}

	/** 11. N-bonacci Numbers **/
	@Override
	public void nBonacciNumm(int m, int n) {
		// Assuming m > n.
		int a[] = new int[m];

		a[n - 1] = 1;
		a[n] = 1;

		// Uses sliding window
		for (int i = n + 1; i < m; i++)
			a[i] = 2 * a[i - 1] - a[i - n - 1];

		// Printing result
		for (int i = 0; i < m; i++)
			System.out.print(a[i] + " ");
	}

	/** 12. Space efficient iterative method to Fibonacci number **/
	/** 13. The Magic of Fibonacci Numbers **/
	/** 14. Program to print Fibonacci Triangle **/
	@Override
	public void fiboTriangle(int n) {
		// Fill Fibonacci numbers in f[] using
		// fib(). We need N = n*(n+1)/2 Fibonacci
		// numbers to make a triangle of height
		// n
		int N = n * (n + 1) / 2;
		int f[] = new int[N + 1];
		fib(f, N);

		// To store next Fibonacci
		// Number to print
		int fiboNum = 1;

		// for loop to keep track of
		// number of lines
		for (int i = 1; i <= n; i++) {
			// For loop to keep track of
			// numbers in each line
			for (int j = 1; j <= i; j++)
				System.out.print(f[fiboNum++] + " ");

			System.out.println();
		}
	}

	@Override
	public void fib(int f[], int N) {
		// 1st and 2nd number of the
		// series are 1 and 1
		f[1] = 1;
		f[2] = 1;

		for (int i = 3; i <= N; i++)

			// Add the previous 2 numbers
			// in the series and store it
			f[i] = f[i - 1] + f[i - 2];
	}

	/** 15. Factorial of each element in Fibonacci series **/
}
