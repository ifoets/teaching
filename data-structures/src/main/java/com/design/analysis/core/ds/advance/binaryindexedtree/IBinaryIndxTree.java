package com.design.analysis.core.ds.advance.binaryindexedtree;

import com.design.analysis.core.ds.advance.binaryindexedtree.model.Query;

/*
 * 
 * @author GuruG
 * Binary Indexed Tree :
1.	Binary Indexed Tree or Fenwick Tree
2.	Two Dimensional Binary Indexed Tree or Fenwick Tree
3.	Binary Indexed Tree : Range Updates and Point Queries
4.	Binary Indexed Tree : Range Update and Range Queries
5.	Count inversions in an array
6.	Count Inversions of size three in a give array
7.	Count inversion pairs in a matrix
8.	Counting Triangles in a Rectangular space using BIT
9.	Number of triangles amongst horizontal and vertical line segments
10.	Querying the number of distinct colors in a subtree of a colored tree using BIT
11.	Queries on substring palindrome formation
12.	proto van Emde Boas Trees | Background and Introduction

 */
public interface IBinaryIndxTree {

	/** 1. Binary Indexed Tree or Fenwick Tree **/
	public int parentIndex(int index);

	public int[] createBITree(int arr[], int n);

	public int getSum(int bITree[], int index);

	public void updateBITree(int bITree[], int n, int index, int val);// TODO testig below

	/** 2. Two Dimensional Binary Indexed Tree or Fenwick Tree **/
	/* A function to update the 2D BIT */
	public void updateBIT(int BIT[][], int x, int y, int val);

	/* A function to get sum from (0, 0) to (x, y) */
	public int getSum(int BIT[][], int x, int y);

	/* A function to create an auxiliary matrix from the given input matrix */
	public void constructAux(int mat[][], int aux[][]);

	/* A function to construct a 2D BIT */
	public void construct2DBIT(int mat[][], int BIT[][]);

	/* A function to answer the queries */
	public void answerQueries(Query q[], int m, int BIT[][]);

	/** 3. Binary Indexed Tree : Range Updates and Point Queries **/
	public int[] constructBITree(int n);

	public void updateInRange(int BITree[], int l, int r, int n, int val);

	/** 4. Binary Indexed Tree : Range Update and Range Queries **/
	/* sum of value in for index x */
	public int sum(int x, int BITTree1[], int BITTree2[]);

	/* update the tree in range */
	public void updateRange(int BITTree1[], int BITTree2[], int n, int val, int l, int r);

	/* sum[l,r]=sum from [0,r]-sum[0,l-1] */
	public int rangeSum(int l, int r, int BITTree1[], int BITTree2[]);

	/** 5. Count inversions in an array **/
	public int getInvCount(int arr[], int n);

	/** 6. Count Inversions of size three in a give array **/
	public int getInvCountSizeInThree(int arr[], int n);

	/** 7. Count inversion pairs in a matrix **/
	/* ie. x1 ≤ x2 y1 ≤ y2 and A[x2][y2] < A[x1][y1] */
	/* 8. Counting Triangles in a Rectangular space using BIT */
	/* 9. Number of triangles amongst horizontal and vertical line segments */
	/*
	 * 10. Querying the number of distinct colors in a subtree of a colored tree
	 * using BIT
	 */
}
