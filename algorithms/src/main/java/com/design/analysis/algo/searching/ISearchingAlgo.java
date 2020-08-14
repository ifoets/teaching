package com.design.analysis.algo.searching;

import com.design.analysis.algo.node.SLNode;

/*
 * Searching Algorithms :
1.	Linear Search
2.	Binary Search
3.	Jump Search
4.	Interpolation Search
5.	Exponential Search
6.	Sublist Search (Search a linked list in another list)
7.	Fibonacci Search
8.	The Ubiquitous Binary Search
9.	Recursive program to linearly search an element in a given array
10.	Recursive function to do substring search
11.	Unbounded Binary Search Example (Find the point where a monotonically increasing function becomes positive first time)
12.binary search for first occuracne if multiple value exists
13.binary search for last occurance if multiple value exists
 */
public interface ISearchingAlgo {

	/** 1. Linear Search **/
	public Integer linearSearch(int a[], int x);

	/** 2. Binary Search l=start index, and e end index **/
	public Integer binarySearch(int a[], int l, int e, int x);

	/** 3. Jump Search **/
	public Integer jumpSearch(int a[], int x);

	/** 4. Interpolation Search **/
	public Integer interpolationSearch(int a[], int x);

	/** 5. Exponential Search **/
	public Integer exponentialSearch(int a[], int x);

	/** 6. Sublist Search (Search a linked list in another list) **/

	/** link list creation **/
	public SLNode createLinkList(SLNode node, int dt);

	/** print list **/
	public void printSingleLinkList(SLNode node);

	public boolean subListInListSearch(SLNode list, SLNode subList);

	/** 7. Fibonacci Search **/
	public Integer fibonacciSearch(int a[], int x);

	/**
	 * 8. The Ubiquitous Binary Search : Here array is sorted and element may be
	 * duplicate
	 **/
	public int getRightPosition(int a[], int l, int r, int x);

	// simplw ways
	public int getRightPositionX(int a[], int l, int r, int x);

	public int getLeftPosition(int a[], int l, int r, int x);

	// simplw ways
	public int getLeftPositionX(int a[], int l, int r, int x);

	public Integer ubiquitousBinarySearch(int a[], int x);

	/** 12.binary search for first occuracne if multiple value exists **/
	public int binarySearchFirstOccurance(int a[], int l, int h, int x);

	/** 13.binary search for last occurance if multiple value exists **/
	public int binarySearchLastOccurance(int a[], int l, int h, int x);
}
