package com.design.analysis.core.algo.sorting;

import java.util.Arrays;

import org.junit.Assert;
/*
Sorting Algorithms :
1.	Selection Sort
2.	Bubble Sort
3.	Recursive Bubble Sort
4.	Insertion Sort
5.	Recursive Insertion Sort
6.	Merge Sort
7.	Iterative Merge Sort
8.	Quick Sort
9.	Iterative Quick Sort
10.	Heap Sort
11.	Counting Sort
12.	Radix Sort
13.	Bucket Sort
14.	ShellSort
15.	TimSort
16.	Comb Sort
17.	Pigeonhole Sort
18.	Cycle Sort
19.	Cocktail Sort
20.	Bitonic Sort
21.	Pancake sorting
22.	Binary Insertion Sort
23.	BogoSort or Permutation Sort
24.	Gnome Sort
25.	Sleep Sort � The King of Laziness / Sorting while Sleeping
26.	Structure Sorting (By Multiple Rules) in C++
27.	Stooge Sort
28.	Tag Sort (To get both sorted and original)
29.	Tree Sort
30.	Cartesian Tree Sorting
31.	Odd-Even Sort / Brick Sort
32.	QuickSort on Singly Linked List
33.	QuickSort on Doubly Linked List
34.	3-Way QuickSort (Dutch National Flag)
35.	Merge Sort for Linked Lists
36.	Merge Sort for Doubly Linked List
37.	3-way Merge Sort
*/
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.algo.sorting.model.Person;
import com.design.analysis.core.algo.sorting.model.Student;

public class ISortingAlgoTest {

	public ISortingAlgo isa = null;

	@Before
	public void init() {
		isa = new SortingAlgoImpl();
	}

	/** 0. GuruJi Sort O(n) */
	@Test
	public void guruJiSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		int b[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		isa.guruJiSort(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);

		int a1[] = { 1, 9, 2, 8, 1, 2, 5, 4, 3, 6, 8, 9, 6, 7, 3, 4, 5, 6, 4, 3, 2, 1, 8, 9, 7 };
		isa.guruJiSort(a1);
		System.out.println(Arrays.toString(a1));
	}

	/** 1. Selection Sort **/
	@Test
	public void selectionSortTest() {

		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.selectionSort(a);
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	/** 2. Bubble Sort **/
	@Test
	public void bubbleSortTest() {

		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.bubbleSort(a);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	/** 3. Recursive Bubble Sort **/
	@Test
	public void bubbleSortRecursiveTest() {

		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.bubbleSortRecursive(a, a.length);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	/** 4. Insertion Sort **/
	@Test
	public void insertionSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.insertionSort(a);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	// from last
	@Test
	public void insertionSortXTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.insertionSortX(a);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	/** 5. Recursive Insertion Sort **/
	@Test
	public void insertionSortRecursiveTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.insertionSortRecursive(a, a.length);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	@Test
	// from last
	public void insertionSortRecursiveXTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.insertionSortRecursiveX(a, a.length);

		/*
		 * Assert.assertTrue(a[0] == 0); Assert.assertTrue(a[5] == 5);
		 * Assert.assertTrue(a[9] == 9);
		 */
		System.out.println(Arrays.toString(a));
	}

	/** 6. Merge Sort **/
	@Test
	public void mergeTwoPartSortedTest() {
		int a[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };
		isa.mergeTwoPartSorted(a, 0, 5, a.length - 1);
		// System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[4] == 5);
		Assert.assertTrue(a[8] == 9);
		int b[] = { 1, 2, 3, 7, 8, 9, 4, 5, 6 };
		isa.mergeTwoPartSorted(b, 4, 6, b.length - 1);
		// System.out.println(Arrays.toString(b));
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[5] == 6);
		Assert.assertTrue(a[8] == 9);
	}

	@Test
	public void mergeTwoPartSortedXTest() {
		int a[] = { 1, 4, 5, 9, 2, 3, 6, 7 };// { 4, 5, 6, 7, 8, 9, 1, 2, 3 };// {1,6,2,3,4,5};//{2,3,4,5,1,6};
		isa.mergeTwoPartSortedX(a, 0, 3, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	// special binary search just greater element
	@Test
	public void speicalBinarySearchTest() {
		int a[] = { 1, 3, 4, 5, 7, 9 };
		int b[] = { 1, 3, 4, 5, 9 };
		System.out.println(isa.speicalBinarySearch(b, 0, 4, 6));
		int N = a.length;
		Assert.assertTrue(isa.speicalBinarySearch(a, 0, N - 1, 6) == 4);
		Assert.assertTrue(isa.speicalBinarySearch(a, 0, N - 1, 2) == 1);
	}

	@Test

	public void mergeSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.mergeSort(a, 0, a.length - 1);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	/** 7. Iterative Merge Sort **/
	@Test
	public void mergeSortIterativeTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.mergeSortIterative(a);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	/** 8. Quick Sort **/

	@Test
	public void beforeLastElementQuickSortTest() {
		int a[] = { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		int l = 0;
		int h = a.length - 1;
		isa.beforeLastElementQuickSort(a, l, h);
		System.out.println(Arrays.toString(a));
	}

	@Test
	public void afterLastElementHalfQuickSortTest() {
		int a[] = { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		int l = 0;
		int h = a.length - 1;
		isa.afterLastElementHalfQuickSort(a, l, h);
		System.out.println(Arrays.toString(a));
	}

	@Test
	public void beforeIthIndexElemeQuickSortTest() {
		int a[] = { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		int l = 0;
		int h = a.length - 1;
		isa.beforeIthIndexElemeQuickSort(a, l, h, 7);
		System.out.println(Arrays.toString(a));
	}

	@Test
	public void afterIthIndexElemeQuickSortTest() {
		int a[] = { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		int l = 0;
		int h = a.length - 1;
		isa.afterIthIndexElemeQuickSort(a, l, h, 6);
		System.out.println(Arrays.toString(a));
	}

	@Test
	public void quickSortTestX() {
		int a[] = { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		isa.quickSort(a, 0, a.length - 1);

		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println(Arrays.toString(a));
	}

	/** divide and concure find the smallest element **/
	@Test
	public void smallestDivideConcureTest() {
		int a[] = { 0, 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		System.out.println(isa.smallestDivideConcure(a, 0, a.length - 1));
		Assert.assertTrue(isa.smallestDivideConcure(a, 0, a.length - 1) == 0);
	}

	/** 9. Iterative Quick Sort **/
	/** 10. Heap Sort **/
	/**
	 * arrange i index element greater than 2*i+1 index and 2*i+2 index element
	 **/
	@Test
	public void maxHeapifyTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		for (int i = a.length / 2 - 1; i >= 0; i--) // build head so max is at 0
			isa.maxHeapify(a, a.length, i);
		 //System.out.println("Max Heap:"+Arrays.toString(a));
		Assert.assertTrue(a[0] == 9);
		Assert.assertTrue(a[3] == 5);
		Assert.assertTrue(a[8] == 0);
	}

	/**
	 * arrange i index element less than 2*i+1 index and 2*i+2 index element
	 **/
	@Test
	public void minHeapifyTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.minHeapify(a, a.length, 0);
		// System.out.println("Min heafipy"+Arrays.toString(a));
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[3] == 9);
		Assert.assertTrue(a[8] == 5);
	}

	@Test
	public void maxHeapSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.maxHeapSort(a);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		System.out.println("Max Heap sort" + Arrays.toString(a));
	}

	@Test
	public void minHeapSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.maxHeapSort(a);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println("Min heap sort" + Arrays.toString(a));
	}

	/** 11. Counting Sort **/
	@Test
	public void countingSortTest() {

		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.countingSort(a);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		System.out.println("Count sort" + Arrays.toString(a));
	}

	// only +ve intergers
	@Test
	public void countingSortXTest() {

		int a[] = { 1, 9, 0, 2, 4, 1, 0, 5, 1, 9, 8 };
		isa.countingSortX(a);
		System.out.println("Count sort" + Arrays.toString(a));
	}

	/** 12. Radix Sort **/
	@Test
	public void countingSortRadixTest() {
		int a[] = { 170, 45	, 75, 90, 802, 24, 2, 66 };
		isa.countingSortRadiX(a, 1);
		Assert.assertTrue(a[0] == 170);
		Assert.assertTrue(a[1] == 90);
		Assert.assertTrue(a[2] == 802);
		Assert.assertTrue(a[3] == 2);
		Assert.assertTrue(a[7] == 66);
		//System.out.println("Radix sort for for 1 digit:"+Arrays.toString(a));
	}

	@Test
	public void radixSortTest() {
		int a[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		isa.radixSort(a);
		Assert.assertTrue(a[0] == 2);
		Assert.assertTrue(a[1] == 24);
		Assert.assertTrue(a[2] == 45);
		Assert.assertTrue(a[3] == 66);
		Assert.assertTrue(a[7] == 802);
		// System.out.println("Radix sort:"+Arrays.toString(a));
	}

	/** 13. Bucket Sort **/
	@Test
	public void bucketSortTest() {
		double a[] = { 0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434 };
		double b[] = { 0.1234, 0.3434, 0.565, 0.656, 0.665, 0.897 };
		isa.bucketSort(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 14. ShellSort **/
	@Test
	public void shellSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		int b[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		isa.shellSort(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 15. TimSort **/
	@Test
	public void timeSortTest() {
		int a[] = { 5, 21, 7, 23, 19 };
		int b[] = { 5, 7, 19, 21, 23 };
		isa.timeSort(a);
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(a[i] == b[i]);
	}

	/** 16. Comb Sort **/
	@Test
	public void combSortTest() {

	}

	/** 17. Pigeonhole Sort **/
	@Test
	public void pigeonholeSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.pigeonholeSort(a);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
		// System.out.println("Pigeonhole Sort" + Arrays.toString(a));
	}

	/** 18. Cycle Sort **/
	@Test
	public void cycleSortTest() {

		int a[] = { 1, 8, 3, 9, 10, 10, 2, 4 };
		isa.cycleSort(a);
		System.out.println(Arrays.toString(a));
	}

	/** 19. Cocktail Sort **/
	@Test
	public void cocktailSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.cocktailSort(a);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	/** 20. Strand Sort **/
	@Test
	public void strandSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.strandSort(a);
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	/** 21. Bitonic Sort **/
	@Test
	public void bitoicSortTest() {
		int a[] = { 3, 7, 4, 8, 6, 2, 1, 5 };
		// not working for below rray TODO
		// int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.bitonicSort(a, 0, a.length, 1);
		System.out.println(Arrays.toString(a));
	}

	/** 22. Pancake sorting **/
	@Test
	public void pankakeSorteTest() {
		int a[] = { 10, 5, 2, 3, 1, 0 };
		isa.pankakeSorte(a);
		System.out.println(Arrays.toString(a));
	}

	/** 23. Binary Insertion Sort **/
	@Test
	public void binaryInsertionSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.binaryInsertionSort(a);
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	/** 24. BogoSort or Permutation Sort **/
	@Test
	public void bogosortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.bogosort(a);
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	/** 25. Gnome Sort **/
	@Test
	public void gnomeSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.gnomeSort(a);
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	// TODO not give proper result
	/** 26. Sleep Sort � The King of Laziness / Sorting while Sleeping **/
	@Test
	public void sleepSortTest() {

		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.sleepSort(a);
		System.out.println(Arrays.toString(a));
	}

	/** 27. Structure Sorting (By Multiple Rules) in C++ **/
	@Test // TODO for correct result
	public void structureSortTest() {
		int n = 5;
		// array of structure objects
		Student a[] = new Student[n];
		for (int i = 0; i < a.length; i++)
			a[i] = new Student();

		// Details of Student 1
		a[0].name = "Bryan";
		a[0].math = 80;
		a[0].phy = 95;
		a[0].che = 85;

		// Details of Student 2
		a[1].name = "Kevin";
		a[1].math = 95;
		a[1].phy = 85;
		a[1].che = 99;

		// Details of Student 3
		a[2].name = "Nick";
		a[2].math = 95;
		a[2].phy = 85;
		a[2].che = 80;

		// Details of Student 4
		a[3].name = "AJ";
		a[3].math = 80;
		a[3].phy = 70;
		a[3].che = 90;

		// Details of Student 5
		a[4].name = "Howie";
		a[4].math = 80;
		a[4].phy = 80;
		a[4].che = 80;

		isa.structureSort(a);
		// computeRanks(a, n);

		for (int i = 0; i < a.length; i++)
			System.out.println("Rank : " + a[i].rank + " Name :" + a[i].name);

	}

	/** 28. Stooge Sort **/
	@Test
	public void stoogesortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.stoogeSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 0);
		Assert.assertTrue(a[5] == 5);
		Assert.assertTrue(a[9] == 9);
	}

	/** 29. Tag Sort (To get both sorted and original) **/
	@Test
	public void tagSortTest() {
		int n = 5;
		Person persons[] = new Person[n];
		persons[0] = new Person(0, 233.5f);
		persons[1] = new Person(1, 23f);
		persons[2] = new Person(2, 13.98f);
		persons[3] = new Person(3, 143.2f);
		persons[4] = new Person(4, 3f);
		int tag[] = new int[n];
		for (int i = 0; i < n; i++)
			tag[i] = i;

		// Every Person object is tagged to
		// an element in the tag array.
		System.out.println("Given Person and Tag ");
		for (int i = 0; i < n; i++)
			System.out.println(persons[i] + " : Tag: " + tag[i]);

		// Modifying tag array so that we can access
		// persons in sorted order.
		isa.tagSort(persons, tag);

		System.out.println("New Tag Array after " + "getting sorted as per Person[] ");
		for (int i = 0; i < n; i++)
			System.out.println(tag[i]);

		// Accessing persons in sorted (by salary)
		// way using modified tag array.
		for (int i = 0; i < n; i++)
			System.out.println(persons[tag[i]]);

	}

	/** 30. Tree Sort **/
	/** create tree and print data in inorder traverse */

	/** 31. Cartesian Tree Sorting **/
	/** 32. Odd-Even Sort / Brick Sort **/
	@Test
	public void oddEvenSortTest() {
		int a[] = { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };// 4, 3, 2, 1 };// { 1, 0, 2, 9, 3, 8, 7, 4, 5, 6 };
		isa.oddEvenSort(a);
		System.out.println(Arrays.toString(a));
		/*
		 * Assert.assertTrue(a[0] == 0); Assert.assertTrue(a[5] == 5);
		 * Assert.assertTrue(a[9] == 9);
		 */
	}
}
