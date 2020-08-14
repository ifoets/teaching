package com.design.analysis.ds.advance.segmenttree;

import com.design.analysis.ds.advance.segmenttree.model.MinMaxNode;

/*
 * 
 * @author GuruG
 * Segment Tree :
 * 
	0.1 create complete binary tree(creazy tree) whose level is 1,2,3....and operation on it
	1.	Sum of given range
	2.	Range minimum query
	3.	Lazy Propagation
	4.	Persistent Segment Tree
	5.	Efficiently design Insert, Delete and Median queries on a set
	6.	Range Minimum Query (Square Root Decomposition and Sparse Table)
	7.	Range LCM queries
	8.	Min-Max Range queries in array
	9.	Count and Toggle queries on Binary array
	10.	Querying maximum number of divisors that a number in a given range has
	11.	LCA in a binary tree using RMQ
	12.	GCDs of given index ranges in an array
	13.	Smallest sub-array with given GCD
	14.	Largest Rectangular Area in a Histogram
	15.	Heavy Light Decomposition | Set 1 (Introduction)
	16.	Heavy Light Decomposition | Set 2 (Implementation)
	17.	Reconstructing Segment Tree
	18.	Longest Common Extension / LCE | Set 1 (Introduction and Naive Method)
	19.	Longest Common Extension / LCE | Set 2 ( Reduction to RMQ)
	Longest Common Extension / LCE | Set 3 (Segment Tree Method)

 */
public interface ISegmentTree {
	
	/**0.1 create complete binary tree(creazy tree) whose level is 1,2,3....and operation on it**/
	//public 

	/** 1. Sum of given range **/
	public int getSum(int[] a, int[] t, int ql, int qr);

	public int[] getUpdate(int[] d, int[] t, int i, int val);

	/** 2. Range minimum query **/
	public int getMinimum(int[] a, int[] t, int ql, int qr);

	public int getMaximum(int[] a, int[] t, int ql, int qr);

	/** 3. Lazy Propagation **/
	public int getLazySum(int[] a, int[] t, int ql, int qr);

	public int[] getLazyUpdateRange(int[] d, int[] t, int i, int val);

	/* 4. Persistent Segment Tree */
	/* 5. Efficiently design Insert, Delete and Median queries on a set */

	/** 6. Range Minimum Query (Square Root Decomposition and Sparse Table) **/

	/** 7. Range LCM queries **/
	public int getLCM(int[] a, int[] t, int ql, int qr);

	/** 8. Min-Max Range queries in array **/
	public MinMaxNode getMinMax(int[] a, MinMaxNode[] t, int ql, int qr);

	/* 9. Count and Toggle queries on Binary array */
	/* 10. Querying maximum number of divisors that a number in a given range has */
	/* 11. LCA in a binary tree using RMQ */
	/** 12. GCDs of given index ranges in an array **/
	public int getGCD(int[] a, int[] t, int ql, int qr);
	/* 13. Smallest sub-array with given GCD */
	/* 14. Largest Rectangular Area in a Histogram */

}
