package com.design.analysis.core.algo.matheticalalgorithms;

import java.util.List;

/*
 * 
 * @author GuruG
 * 
 * Fibonacci Numbers :
1.	Fibonacci Numbers
2.	Interesting facts about Fibonacci numbers
3.	How to check if a given number is Fibonacci number?
4.	Zeckendorf�s Theorem (Non-Neighbouring Fibonacci Representation)
5.	Finding nth Fibonacci Number using Golden Ratio
6.	Matrix Exponentiation
7.	Fibonacci Coding
8.	n�th multiple of a number in Fibonacci Series
9.	GCD and Fibonacci Numbers
10.	Cassini�s Identity
11.	N-bonacci Numbers
12.	Space efficient iterative method to Fibonacci number
13.	The Magic of Fibonacci Numbers
14.	Program to print Fibonacci Triangle
15.	Factorial of each element in Fibonacci series
16.	Fibonomial coefficient and Fibonomial triangle
17.	Hosoya�s Triangle
18.	Prime numbers and Fibonacci
19.	Leonardo Number
20.	Fibonacci number in an array
21.	Fibonacci modulo p
22.	An efficient way to check whether n-th Fibonacci number is multiple of 10
23.	Find Index of given fibonacci number in constant time
24.	Tail Recursion for Fibonacci
25.	Large Fibonacci Numbers in Java
26.	Even Fibonacci Numbers Sum
27.	Nth Even Fibonacci Number
28.	Finding number of digits in n�th Fibonacci number
29.	Non Fibonacci Numbers
30.	Sum of Fibonacci Numbers
31.	Count ways to reach the n�th stair
32.	Count Possible Decodings of a given Digit Sequence
33.	Program to print first n Fibonacci Numbers | Set 1

 */
public interface IFibonacciNumber {

	/** 1. Fibonacci Numbers **/
	public int nthFibonaciNum(int n);

	/** 2. Interesting facts about Fibonacci numbers **/

	/* the last digit is repeating in fibonaci after soem index */
	public int repeatingIndexOfLastDigit();

	/* Every 3-rd x*2, 4-th x*n, 5-th 5*x and 6-th 8*x */
	/** 3. How to check if a given number is Fibonacci number? **/
	public boolean isFibonacci(int x);

	public boolean isPerfectSquare(int x);

	/** 4. Zeckendorf�s Theorem (Non-Neighbouring Fibonacci Representation) **/
	public List<Integer> nonNeighborFibonacciRepresent(int n);

	/* nearest fibonacci no */
	public int nearestSmallerEqFib(int n);

	/** 5. Finding nth Fibonacci Number using Golden Ratio **/
	public int fiboNoByGoldenRatio(int n);

	/** 6. Matrix Exponentiation **/
	// TODO
	/** 7. Fibonacci Coding **/
	public String fibonacciEncoding(int n);

	public int largestFiboIndexLessOrEqual(int n);

	/** 8. n�th multiple of a number in Fibonacci Series **/
	public int nthMaulitpleInFiboIndex(int k, int n);

	/** 9. GCD and Fibonacci Numbers **/
	public int gcdOfFiboNums(int m, int n);

	/** 10. Cassini�s Identity **/
	public int cassintiIndentity(int n);

	/** 11. N-bonacci Numbers **/
	public void nBonacciNumm(int m, int n);

	/** 12. Space efficient iterative method to Fibonacci number **/
	/** 13. The Magic of Fibonacci Numbers **/
	/** 14. Program to print Fibonacci Triangle **/
	public void fiboTriangle(int n);

	public void fib(int f[], int N);
	/** 15. Factorial of each element in Fibonacci series **/
}
