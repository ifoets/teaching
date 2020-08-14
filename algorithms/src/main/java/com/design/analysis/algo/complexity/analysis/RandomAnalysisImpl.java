package com.design.analysis.algo.complexity.analysis;

public class RandomAnalysisImpl implements IRandomAnalysis {

	/** find the max without looping in unsorted array */
	public int findMax(int a[], int l, int r) {

		if (l < r) {
			int mid = (l + r) / 2;
			return Math.max(a[mid], Math.max(findMax(a, l, mid - 1), findMax(a, mid + 1, r)));
		} else
			return a[l];
	}

	/** find the min without looping in unsorted array */
	public int findMin(int a[], int l, int r) {
		if (l < r) {
			int mid = (l + r) / 2;
			return Math.min(a[mid], Math.min(findMin(a, l, mid - 1), findMin(a, mid + 1, r)));
		} else
			return a[l];
	}
}
