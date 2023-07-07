package com.design.analysis.core.ds.advance.segmenttree;

import com.design.analysis.core.ds.advance.segmenttree.model.MinMaxNode;

/*
 * 
 * @author GuruG
 */
public class SegmentTreeImpl implements ISegmentTree {

	/** 1. Sum of given range **/
	/* assumed segment tree not constructed and pass here */
	@Override
	public int getSum(int[] a, int t[], int ql, int qr) {

		return SegmentTreeUtil.querySumUtil(t, 0, a.length - 1, ql, qr, 0);
	}

	/* assumed segment tree constructed and passed here it update the index i */
	@Override
	public int[] getUpdate(int[] a, int[] t, int i, int val) {
		if (i < 0 || i > a.length - 1) {
			System.out.println("Invalid Input");
			return null;
		}
		// int rs[] = createSegmentTree(a);
		// Get the difference between new value and old value
		int diff = val - a[i];

		// Update the value in array
		a[i] = val;
		// Update the values of nodes in segment tree
		SegmentTreeUtil.constructUpdateUtil(t, 0, a.length - 1, i, diff, 0);
		return t;
	}

	/** 2. Range minimum query **/
	@Override
	public int getMinimum(int[] a, int[] t, int ql, int qr) {
		return SegmentTreeUtil.queryMinValueUtil(t, 0, a.length - 1, ql, qr, 0);

	}

	@Override
	public int getMaximum(int[] a, int[] t, int ql, int qr) {
		return SegmentTreeUtil.queryMaxValueUtil(t, 0, a.length - 1, ql, qr, 0);
	}

	/** 3. Lazy Propagation **/
	public int getLazySum(int[] a, int[] t, int ql, int qr) {
		return -1;
	}

	public int[] getLazyUpdateRange(int[] d, int[] t, int i, int val) {
		return null;
	}
	/* 4. Persistent Segment Tree */
	/* 5. Efficiently design Insert, Delete and Median queries on a set */

	/** 6. Range Minimum Query (Square Root Decomposition and Sparse Table) **/
	/** 7. Range LCM queries **/
	public int getLCM(int[] a, int[] t, int ql, int qr) {
		return SegmentTreeUtil.queryLCMUtil(t, 0, a.length - 1, ql, qr, 0);
	}

	/* 8. Min-Max Range queries in array */
	public MinMaxNode getMinMax(int[] a, MinMaxNode[] t, int ql, int qr) {
		return SegmentTreeUtil.queryMinMaxUtil(t, 0, a.length - 1, ql, qr, 0);
	}

	/* 9. Count and Toggle queries on Binary array */
	/* 10. Querying maximum number of divisors that a number in a given range has */
	/* 11. LCA in a binary tree using RMQ */
	/* 12. GCDs of given index ranges in an array */
	/** 13. Smallest sub-array with given GCD **/
	public int getGCD(int[] a, int[] t, int ql, int qr) {
		return SegmentTreeUtil.queryGCDUtil(t, 0, a.length - 1, ql, qr, 0);
	}
	/* 14. Largest Rectangular Area in a Histogram */
}
