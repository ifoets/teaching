package com.design.analysis.core.algo.sorting;

import com.design.analysis.core.algo.sorting.model.Person;
import com.design.analysis.core.algo.sorting.model.Student;

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
	20.	Strand Sort
	21.	Bitonic Sort
	22.	Pancake sorting
	23.	Binary Insertion Sort
	24.	BogoSort or Permutation Sort
	25.	Gnome Sort
	26.	Sleep Sort � The King of Laziness / Sorting while Sleeping
	27.	Structure Sorting (By Multiple Rules) in C++
	28.	Stooge Sort
	29.	Tag Sort (To get both sorted and original)
	30.	Tree Sort
	31.	Cartesian Tree Sorting
	32.	Odd-Even Sort / Brick Sort
	33.	QuickSort on Singly Linked List
	34.	QuickSort on Doubly Linked List
	35.	3-Way QuickSort (Dutch National Flag)
	36.	Merge Sort for Linked Lists
	37.	Merge Sort for Doubly Linked List
	38.	3-way Merge Sort

 */
public interface ISortingAlgo {

	/** 0. GuruJi Sort O(n) */
	public void guruJiSort(int a[]);

	/** 1. Selection Sort **/
	public void selectionSort(int a[]);

	/** 2. Bubble Sort **/
	public void bubbleSort(int a[]);

	/** 3. Recursive Bubble Sort **/
	public void bubbleSortRecursive(int arr[], int n);

	/** 4. Insertion Sort **/
	public void insertionSort(int[] a);

	public void insertionSortX(int[] a);

	/** 5. Recursive Insertion Sort **/
	public void insertionSortRecursive(int arr[], int n);

	public void insertionSortRecursiveX(int arr[], int n);

	/** 6. Merge Sort **/
	public void mergeTwoPartSorted(int a[], int l, int m, int r);

	public void mergeTwoPartSortedX(int a[], int l, int m, int r);

	// special binary search just greater element
	public int speicalBinarySearch(int a[], int l, int r, int x);

	public void mergeSort(int arr[], int l, int r);

	/** 7. Iterative Merge Sort **/
	public void mergeSortIterative(int a[]);

	/** 8. Quick Sort **/

	public void beforeLastElementQuickSort(int a[], int l, int h);

	public void afterLastElementHalfQuickSort(int a[], int l, int h);

	public void beforeIthIndexElemeQuickSort(int a[], int l, int h, int I);

	public void afterIthIndexElemeQuickSort(int a[], int l, int h, int I);

	public void quickSort(int a[], int l, int h);

	public int partition(int a[], int l, int h);

	/** divide and concure find the smallest element **/
	public int smallestDivideConcure(int a[], int l, int h);

	/** 9. Iterative Quick Sort **/

	/** 10. Heap Sort **/
	/**
	 * arrange i index element greater than 2*i+1 index and 2*i+2 index element
	 **/
	public void maxHeapify(int a[], int n, int i);

	/**
	 * arrange i index element less than 2*i+1 index and 2*i+2 index element
	 **/
	public void minHeapify(int a[], int n, int i);

	public void maxHeapSort(int a[]);

	public void minHeapSort(int a[]);

	/** 11. Counting Sort **/
	public void countingSort(int[] a);

	public void countingSortX(int[] a);

	/** 12. Radix Sort **/
	/** 11. Counting Sort for Radix sort **/
	public void countingSortRadiX(int[] a, int exp);

	public void radixSort(int a[]);

	/** 13. Bucket Sort **/
	public void bucketSort(double[] a);

	/** 14. ShellSort **/
	public void shellSort(int arr[]);

	/** 15. TimSort **/
	public void timeSort(int a[]);

	/** 16. Comb Sort **/
	public void combSort(int a[]);

	/** 17. Pigeonhole Sort **/
	public void pigeonholeSort(int a[]);

	/** 18. Cycle Sort **/
	public void cycleSort(int a[]);

	/** 19. Cocktail Sort **/
	public void cocktailSort(int a[]);

	/** 20. Strand Sort **/
	public void strandSort(int a[]);

	/** 21. Bitonic Sort **/ // TODO
	public void compAndSwap(int a[], int i, int j, int dir);

	public void bitonicMerge(int a[], int low, int cnt, int dir);

	public void bitonicSort(int a[], int low, int cnt, int dir);

	/** 22. Pancake sorting **/
	public void pankakeSorte(int a[]);

	/** 23. Binary Insertion Sort **/
	public void binaryInsertionSort(int a[]);

	/** 24. BogoSort or Permutation Sort **/
	public boolean isSorted(int a[], int n);

	// To generate permuatation of the array
	public void shuffle(int a[], int n);

	// Sorts array a[0..n-1] using Bogo sort
	public void bogosort(int a[]);

	/** 25. Gnome Sort **/
	public void gnomeSort(int a[]);

	/** 26. Sleep Sort � The King of Laziness / Sorting while Sleeping **/
	public void sleepSort(int a[]);

	/** 27. Structure Sorting (By Multiple Rules) in C++ **/
	public void structureSort(Student s[]);

	/** 28. Stooge Sort **/
	public void stoogeSort(int a[], int l, int h);

	/** 29. Tag Sort (To get both sorted and original) **/
	public void tagSort(Person persons[], int tag[]);

	/** 30. Tree Sort **/
	/** create tree and print data in inorder traverse */

	/** 31. Cartesian Tree Sorting **/
	/** 32. Odd-Even Sort / Brick Sort **/
	public void oddEvenSort(int arr[]);

	/* 33. QuickSort on Singly Linked List */
	/* 34. QuickSort on Doubly Linked List */
	/* 35. 3-Way QuickSort (Dutch National Flag) */
	/* 36. Merge Sort for Linked Lists */
	/* 37. Merge Sort for Doubly Linked List */
	/* 38. 3-way Merge Sort */
	/*******************************************************************************************************************************************************************/
	/** swap two element of array **/
	public void swap(int a[], int i, int j);

	/** min element in a array **/
	public int min(int a[]);

	/** max element in a array **/
	public int max(int a[]);
}
