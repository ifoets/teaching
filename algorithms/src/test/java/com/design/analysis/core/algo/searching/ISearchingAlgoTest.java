package com.design.analysis.core.algo.searching;

import com.design.analysis.core.algo.node.SLNode;
import org.junit.Assert;
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

 */
import org.junit.Before;
import org.junit.Test;

public class ISearchingAlgoTest {

	public ISearchingAlgo isa = null;

	@Before
	public void init() {
		isa = new SearchingAlgoImpl();
	}

	// ** 1. Linear Search **/
	@Test
	public void linearSearchTest() {
		int a[] = null;
		int b[] = {};
		int c[] = { 1 };
		int d[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.linearSearch(a, 1) == null);
		Assert.assertTrue(isa.linearSearch(b, 1) == null);
		Assert.assertTrue(isa.linearSearch(c, 1) == 0);
		Assert.assertTrue(isa.linearSearch(d, 7) == 6);
		Assert.assertTrue(isa.linearSearch(d, 10) == null);
	}

	/** 2. Binary Search l=start index, and e end index **/
	@Test
	public void binarySearchTest() {

		int a[] = null;
		int b[] = {};
		int c[] = { 1 };
		int d[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.binarySearch(a, 0, 0, 1) == null);
		Assert.assertTrue(isa.binarySearch(b, 0, b.length - 1, 1) == null);
		Assert.assertTrue(isa.binarySearch(c, 0, c.length - 1, 1) == 0);
		Assert.assertTrue(isa.binarySearch(d, 0, d.length - 1, 7) == 6);
		Assert.assertTrue(isa.binarySearch(d, 0, d.length - 1, 10) == null);
		Assert.assertTrue(isa.binarySearch(d, 0, d.length - 1, 9) == 8);

		int a1[] = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
		Assert.assertTrue(isa.binarySearch(a1, 5, 8, 85) == 8);
	}

	/** 3. Jump Search **/
	@Test
	public void jumpSearchTest() {
		int a[] = null;
		int b[] = {};
		int c[] = { 1 };
		int d[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.jumpSearch(a, 1) == null);
		Assert.assertTrue(isa.jumpSearch(b, 1) == null);
		Assert.assertTrue(isa.jumpSearch(c, 1) == 0);
		Assert.assertTrue(isa.jumpSearch(d, 7) == 6);
		Assert.assertTrue(isa.jumpSearch(d, 10) == null);
	}

	/** 4. Interpolation Search **/
	@Test
	public void interpolationSearchTest() {
		int a[] = null;
		int b[] = {};
		int c[] = { 1 };
		int d[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.interpolationSearch(a, 1) == null);
		Assert.assertTrue(isa.interpolationSearch(b, 1) == null);
		Assert.assertTrue(isa.interpolationSearch(c, 1) == 0);
		Assert.assertTrue(isa.interpolationSearch(d, 7) == 6);
		Assert.assertTrue(isa.interpolationSearch(d, 10) == null);
	}

	/** 5. Exponential Search **/
	@Test
	public void exponentialSearchTest() {
		int a[] = null;
		int b[] = {};
		int c[] = { 1 };
		int d[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Assert.assertTrue(isa.exponentialSearch(a, 1) == null);
		Assert.assertTrue(isa.exponentialSearch(b, 1) == null);
		Assert.assertTrue(isa.exponentialSearch(c, 1) == 0);
		Assert.assertTrue(isa.exponentialSearch(d, 7) == 6);
		Assert.assertTrue(isa.exponentialSearch(d, 10) == null);
	}

	/** link list creation **/
	@Test
	public void createLinkListTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode head = null;
		for (int i = 0; i < a.length; i++)
			head = isa.createLinkList(head, a[i]);
		isa.printSingleLinkList(head);
	}

	@Test
	public void subListInListSearchTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SLNode head = null;
		for (int i = 0; i < a.length; i++)
			head = isa.createLinkList(head, a[i]);

		int b[] = { 4, 5, 6 };
		SLNode sHead1 = null;
		for (int i = 0; i < b.length; i++)
			sHead1 = isa.createLinkList(sHead1, b[i]);
		Assert.assertTrue(isa.subListInListSearch(head, sHead1));

		int c[] = { 4, 1, 6 };
		SLNode sHead2 = null;
		for (int i = 0; i < c.length; i++)
			sHead2 = isa.createLinkList(sHead2, c[i]);
		Assert.assertTrue(isa.subListInListSearch(head, sHead2) == false);
	}

	/** 7. Fibonacci Search **/
	@Test
	public void fibonacciSearchTest() {
		int a[] = { 10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100 };
		Assert.assertTrue(isa.fibonacciSearch(a, 85) == 8);

		Assert.assertTrue(isa.fibonacciSearch(a, 85) == 8);
		Assert.assertTrue(isa.fibonacciSearch(a, 100) == 10);
		Assert.assertTrue(isa.fibonacciSearch(a, 10) == 0);
		Assert.assertTrue(isa.fibonacciSearch(a, 108) == null);
		Assert.assertTrue(isa.fibonacciSearch(a, 35) == 2);

		Assert.assertTrue(isa.fibonacciSearch(a, 22) == 1);
		Assert.assertTrue(isa.fibonacciSearch(a, 40) == 3);
		Assert.assertTrue(isa.fibonacciSearch(a, 80) == 6);
		Assert.assertTrue(isa.fibonacciSearch(a, 90) == 9);

	}

	@Test
	public void getRightPositionTest() {

		int a[] = { 10, 22, 35, 40, 45, 80, 80, 80, 85, 90, 100 };

		Assert.assertTrue(isa.getRightPosition(a, 0, a.length - 1, 80) == 7);
	}

	@Test
	public void getRightPositionXTest() {
		int a[] = { 10, 22, 35, 40, 45, 80, 80, 80, 85, 90, 100 };

		Assert.assertTrue(isa.getRightPositionX(a, 0, a.length - 1, 80) == 7);
	}

	@Test
	public void getLeftPositionTest() {

		int a[] = { 10, 22, 35, 40, 45, 80, 80, 80, 85, 90, 100 };

		Assert.assertTrue(isa.getLeftPosition(a, 0, a.length - 1, 80) == 5);
	}

	@Test
	public void getLeftPositionXTest() {
		int a[] = { 10, 22, 35, 40, 45, 80, 80, 80, 85, 90, 100 };

		Assert.assertTrue(isa.getLeftPositionX(a, 0, a.length - 1, 80) == 5);
	}

	@Test
	public void ubiquitousBinarySearchTest() {

		int a[] = { 10, 22, 35, 40, 45, 80, 80, 80, 85, 90, 100 };
		Assert.assertTrue(isa.ubiquitousBinarySearch(a, 80) == 3);
	}

	@Test
	public void binarySearchFirstOccuranceTest() {

		int a[] = { 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8 };
		Assert.assertTrue(isa.binarySearchFirstOccurance(a, 0, a.length - 1, 2) == 1);
		Assert.assertTrue(isa.binarySearchFirstOccurance(a, 0, a.length - 1, 5) == 5);
		Assert.assertTrue(isa.binarySearchFirstOccurance(a, 0, a.length - 1, 8) == 12);
	}

	@Test
	public void binarySearchLastOccuranceTest() {

		int a[] = { 1, 2, 2, 2, 4, 5, 5, 5, 6, 7, 7, 7, 8, 8 };
		Assert.assertTrue(isa.binarySearchLastOccurance(a, 0, a.length - 1, 2) == 3);
		Assert.assertTrue(isa.binarySearchLastOccurance(a, 0, a.length - 1, 5) == 7);
		Assert.assertTrue(isa.binarySearchLastOccurance(a, 0, a.length - 1, 8) == 13);
	}
}
