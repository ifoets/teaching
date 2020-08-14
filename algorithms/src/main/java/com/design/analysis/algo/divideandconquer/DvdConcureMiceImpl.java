package com.design.analysis.algo.divideandconquer;

import com.design.analysis.algo.utils.AlgoUtils;

public class DvdConcureMiceImpl implements IDvdConcureMice {

	/** 1. Largest Rectangular Area in a Histogram | Set 1 **/
	// O(n2)//this is just like max contenious sum
	public int larestRectInHistogram(int a[]) {

		int n = a.length;

		int i = 0;
		int j = 1;
		int maxArea = Integer.MIN_VALUE;
		int curMaxArea = Integer.MIN_VALUE;
		int minHeight = Integer.MAX_VALUE;
		int minInArr = Integer.MAX_VALUE;
		for (int x = 0; x < n; x++) {
			if (minInArr > a[x])
				minInArr = a[x];
		}

		while (i <= j && j < n) {
			int k = i;
			minHeight = a[k];
			while (k <= j) {
				if (minHeight > a[k])
					minHeight = a[k];
				k++;
			}
			curMaxArea = (j - i + 1) * minHeight;
			if (curMaxArea > maxArea)
				maxArea = curMaxArea;
			i++;
			if (i == j) {
				i = 0;
				j++;
			}
		}
		return maxArea > minInArr * n ? maxArea : minInArr * n;
	}

	// O(nlogn)
	// len * min or left side or right side min max area
	@Override
	public int larestRectInHistogramX(int a[], int l, int r) {
		int minInd = l;
		int min = a[l];
		int maxArea = 0;
		if (l == r || l > r)
			return a[l];
		else if (l < r) {
			minInd = l;
			min = a[l];
			for (int i = l + 1; i <= r; i++) {
				if (min > a[i]) {
					min = a[i];
					minInd = i;
				}
			}
			maxArea = min * (r - l + 1);
		}
		return AlgoUtils.max(maxArea, larestRectInHistogramX(a, l, minInd - 1),
				larestRectInHistogramX(a, minInd + 1, r));
	}

	/* 2. Maximum and minimum of an array using minimum number of comparisons */
	@Override
	public int[] maxMinByMinComp(int a[]) {

		int x[] = new int[2];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] > a[j]) {
				if (max < a[i])
					max = a[i];
				if (min > a[j])
					min = a[j];
			} else {
				if (max < a[j])
					max = a[j];
				if (min > a[i])
					min = a[i];
			}
			i++;
			j--;
		}
		x[0] = min;
		x[1] = max;
		return x;
	}

	/** 3. Write you own Power without using multiplication(*) and division(/) **/
	@Override
	public int ownPow(int x, int y) {
		int toSum = x;
		int prod = 0;
		for (int i = 1; i < y; i++) {
			prod = 0;
			for (int j = 1; j <= x; j++) {
				prod += toSum;
			}
			toSum = prod;
		}
		return prod;
	}

	/** 4. Program to count number of set bits in an (big) array **/
	@Override
	public int setBitOfNum(int n) {
		int count = 0;
		while (n > 0) {
			count += n & 1;
			n >>= 1; // n==n>>1
		}
		return count;
	}

	@Override
	public int setBitOfArr(int a[]) {

		int countSetBit = 0;
		for (int i = 0; i < a.length; i++) {
			countSetBit += setBitOfNum(a[i]);
		}
		return countSetBit;
	}

	/** 5. Maximum Subarray Sum **/
	@Override
	public int maxSumContiSubArr(int arr[], int l, int h) {
		// Base Case: Only one element
		if (l == h)
			return arr[l];

		// Find middle point
		int m = (l + h) / 2;

		return Math.max(Math.max(maxSumContiSubArr(arr, l, m), maxSumContiSubArr(arr, m + 1, h)),
				maxCrossingSum(arr, l, m, h));
	}

	@Override
	public int maxCrossingSum(int arr[], int l, int m, int h) {
		// Include elements on left of mid.
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		for (int i = m; i >= l; i--) {
			sum = sum + arr[i];
			if (sum > left_sum)
				left_sum = sum;
		}

		// Include elements on right of mid
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		for (int i = m + 1; i <= h; i++) {
			sum = sum + arr[i];
			if (sum > right_sum)
				right_sum = sum;
		}

		// Return sum of elements on left
		// and right of mid
		return left_sum + right_sum;
	}

	/** 6. Search in a Row-wise and Column-wise Sorted 2D Array **/
	@Override
	public int[] searchInSortedMat(int a[][], int x) {

		int i = 0, j = a.length - 1; // set indexes for top right
		// element

		while (i < a.length && j >= 0) {
			if (a[i][j] == x) {
				int b[] = new int[2];
				b[0] = i;
				b[1] = j;
				return b;
			}
			if (a[i][j] > x)
				j--;
			else // if mat[i][j] < x
				i++;
		}
		return null;
	}
}
