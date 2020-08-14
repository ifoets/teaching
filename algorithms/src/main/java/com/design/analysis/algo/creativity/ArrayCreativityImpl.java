package com.design.analysis.algo.creativity;

import com.design.analysis.algo.array.ArrayUtil;

public class ArrayCreativityImpl implements IArrayCreativity {

	/** 1. Find the Diff of KthMax-KthMin from Unique element of array **/
	// O(kn) this is combination of selection sort and bubble sort
	public int DiffOfKtheMaxMin(int a[], int k) {
		int N = a.length;
		for (int i = 0; i < k; i++) {
			for (int j = i; j < N - 1 - i; j++) {
				if (a[i] > a[j + 1])
					ArrayUtil.swapArr(a, i, j);

				if (a[j] > a[j + 1])
					ArrayUtil.swapArr(a, j, j + 1);
			}
		}
		return a[N - k] - a[k - 1];
	}

	/**
	 * print the array such a ways if less than 100 then add to first less 100 till
	 * it not meet to -ve
	 **/
	// exint a[] = { 200, 6, 36, 612, 121, 66, 63, 39, 661, 106, -1 };
	/*
	 * print 200 42 612 121 168 661 106
	 */
	public int process(int[] a) {
		int sum = 0;
		int j = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] < 0)
				return j;
			if (a[i] > 100) {
				if (sum != 0) {
					a[j++] = sum;
					a[j] = a[i];
				} else
					a[j] = a[i];
				j++;
				sum = 0;
			}
			if (a[i] < 100)
				sum += a[i];
		}
		return j;
	}

	/**
	 * Sort two array sorted or non sorted such a ways first all contain all less
	 * element than 2nd array it is used in find the median of two sorted array any
	 * lengths O(n2)
	 **/
	public void sortTwoArray(int a[], int b[]) {

		int n1 = a.length;
		int n2 = b.length;
		int N = n1 + n2;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (i < n1) {
					if (j < n1) {
						if (a[i] > a[j])
							ArrayUtil.swapArr(a, i, j);
					} else {
						if (a[i] > b[j - n1])
							ArrayUtil.swapIn2Arr(a, i, b, j - n1);
					}
				} else {
					if (b[i - n1] > b[j - n1])
						ArrayUtil.swapArr(b, i - n1, j - n1);
				}
			}
		}
	}
}
