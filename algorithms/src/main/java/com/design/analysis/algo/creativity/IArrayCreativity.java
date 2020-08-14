package com.design.analysis.algo.creativity;

public interface IArrayCreativity {

	/*
	 * 1. Find the Diff of KthMax-KthMin from Unique element of array
	 */

	/** 1. Find the Diff of KthMax-KthMin from Unique element of array **/
	// O(kn)
	public int DiffOfKtheMaxMin(int a[], int kth);

	/**
	 * print the array such a ways if less than 100 then add to first less 100 till
	 * it not meet to -ve
	 **/
	// exint a[] = { 200, 6, 36, 612, 121, 66, 63, 39, 661, 106, -1 };
	/*
	 * print 200 42 612 121 168 661 106
	 */
	public int process(int[] a);

	/**
	 * Sort two array sorted or non sorted such a ways first all contain all less
	 * element than 2nd array
	 **/
	public void sortTwoArray(int a[], int b[]);
}
