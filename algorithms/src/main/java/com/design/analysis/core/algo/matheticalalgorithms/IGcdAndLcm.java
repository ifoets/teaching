package com.design.analysis.core.algo.matheticalalgorithms;

/*
 * 
 * @author GuruG
 * 
 * GCD and LCM :
1.	GCD and LCM
2.	LCM of array
3.	GCD of array
4.	Basic and Extended Euclidean algorithms
5.	Product of given N fractions in reduced form
6.	GCD of two numbers when one of them can be very large
7.	Stein�s Algorithm for finding GCD
8.	GCD, LCM and Distributive Property
9.	Replace every matrix element with maximum of GCD of row or column
10.	GCD of two numbers formed by n repeating x and y times
11.	Count number of pairs (A <= N, B <= N) such that gcd (A , B) is B
12.	Array with GCD of any of its subset belongs to the given array
13.	First N natural can be divided into two sets with given difference and co-prime sums
14.	Minimum gcd operations to make all array elements one
15.	Program to find GCD of floating point numbers
16.	GCD of digits of a given number
17.	Series with largest GCD and sum equals to n
18.	Find pair with maximum GCD in an array
19.	GCD of elements in a given range
20.	Minimum operations to make GCD of array a multiple of k
21.	Largest Subset with GCD 1
22.	Queries for GCD of all numbers of an array except elements in a given range
23.	Summation of GCD of all the pairs up to N
24.	Largest subsequence having GCD greater than 1
25.	Largest subarray with GCD one

 */
public interface IGcdAndLcm {

	/** 1. GCD and LCM **/
	public int GCD(int a, int b);

	public int LCM(int a, int b);

	/** 2. LCM of array **/
	public int lcmOfArray(int arr[]);

	/** 3. GCD of array **/
	public int gcdOfArray(int arr[]);

	/** 4. Basic and Extended Euclidean algorithms **/
	public int gcd(int a, int b);

	/** 5. Product of given N fractions in reduced form **/
	public int[] productOfNFraction(int num[], int den[]);

	/** 6. GCD of two numbers when one of them can be very large **/
	public int gcdWithVeryLargeNo(int a, String b);

	/** 7. Stein�s Algorithm for finding GCD **/
	/* it is just finding the gcd by different apporach */
	/** 8. GCD, LCM and Distributive Property **/
	public int gcdlcmAndDistributive(int x, int y, int z);

	/** 9. Replace every matrix element with maximum of GCD of row or column **/
	public void replaceElemByGcdOfRowOrColm(int a[][]);

	/** 10. GCD of two numbers formed by n repeating x and y times **/
	public int gcdFormByNrepeatinOFXAndY(int n, int x, int y);
}
