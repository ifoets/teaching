package com.design.analysis.company.hakarrank.goldmansachs;

public interface IGoldmanSachs {

	/** Bank Accounts **/
	public String feeOrUpfront(int n, int k, int x, int d, int[] p);

	/** Buy Maximum Stocks ..max i stock by on ith day **/
	public int buyMaximumProducts(int n, long k, int[] a);

	/** Trader Profit **/
	public long traderProfit(int a[], int k);

	/** Time Series Queries **/
	public int query(int t[], int p[], int type, int val);

	// **hackerran test question*/
	/** Non reapeating digits in producct **/
	/*
	 * Given a number x and a range y to z please find the count of all the numers n
	 * that range such that the porduct of the number n and x does not contian any
	 * digit from the number n
	 */
	public long nonRepeatingDigitProductCount(int x, int y, int z);

	public boolean findDigit(long n, long prd);

	/** Number Patterns & finding the the possible smallest numeric value **/

	public long smallest(String pattern);

	public boolean diffInt(long i, int N);

	public boolean satisfyCondition(boolean c[], String s);

	/** live coding round **/
	/** find average in two sorted array */
	public double findAverage(int a[], int b[]);

	/**
	 * Your task is ultimately to implement a function that takes in an array of
	 * non-negative numbers and an integer. You want to return the *LENGTH* of the
	 * shortest subarray whose sum is at least the integer,
	 **/

	// public int minLength(int a[], int target);

	/** Minimum Initial Energy Required To Cross Street **/
	/*
	 * Given an array containing positive and negative numbers. The array represents
	 * checkpoints from one end to other end of street. Positive and negative values
	 * represent amount of energy at that checkpoint. Positive numbers increase the
	 * energy and negative numbers decrease. Find the minimum initial energy
	 * required to cross the street such that Energy level never becomes 0 or less
	 * than 0.
	 */

	public int minEnergyRequired(int a[]);

	/** Find number of Positional Elements **/
	/*
	 * Given a matrix of integers, task is to find out number of positional
	 * elements. A positional element is one which is either minimum or maximum in a
	 * row or in a column.
	 */

	public int numberOfPositionalElemnts(int a[][]);

	/** Find number of Positional Elements in single d array **/
	public int noOfMaxMinInArr(int a[]);
}
