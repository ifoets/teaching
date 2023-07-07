package com.design.analysis.core.algo.sorting;

import com.design.analysis.core.algo.node.BTNode;

/*
 * 
 * @author GuruG
 * 
 * Coding Problems :
1.	Sort elements by frequency | Set 1
2.	Sort elements by frequency | Set 2
3.	Count Inversions in an array | Set 1 (Using Merge Sort)
4.	Sort an array of 0s, 1s and 2s
5.	Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
6.	Find whether an array is subset of another array | Added Method 3
7.	Sort a nearly sorted (or K sorted) array
8.	Sort numbers stored on different machines
9.	Sort a linked list of 0s, 1s and 2s
10.	A Pancake Sorting Problem
11.	Find number of pairs (x, y) in an array such that x^y > y^x
12.	Count all distinct pairs with difference equal to k
13.	C Program for Bubble Sort on Linked List
14.	Sort n numbers in range from 0 to n^2 � 1 in linear time
15.	C Program to Sort an array of names or strings
16.	Sort an array according to the order defined by another array
17.	Given a sorted array and a number x, find the pair in array whose sum is closest to x
18.	Sort an array in wave form
19.	Check if any two intervals overlap among a given set of intervals
20.	How to efficiently sort a big list dates in 20�s
21.	Sort an almost sorted array where only two elements are swapped
22.	Find the point where maximum intervals overlap
23.	Sort a linked list that is sorted alternating ascending and descending orders?
24.	C++ program for Sorting Dates using Selection Sort
25.	How to sort an array of dates in C/C++?
26.	Sorting Strings using Bubble Sort
27.	Maximum product of a triplet (subsequnece of size 3) in array
28.	Find missing elements of a range
29.	Find a permutation that causes worst case of Merge Sort
30.	Minimum sum of two numbers formed from digits of an array
31.	Find minimum difference between any two elements
32.	Convert an array to reduced form | Set 1 (Simple and Hashing)
33.	Sorting Vector of Pairs in C++ | Set 1 (Sort by first and second)
34.	Sorting Vector of Pairs in C++ | Set 2 (Sort in descending order by first and second)
35.	Sorting 2D Vector in C++ | Set 1 (By row and column)
36.	Sorting 2D Vector in C++ | Set 2 (In descending order by row and column)
37.	Sorting 2D Vector in C++ | Set 3 (By number of columns)
38.	Find Surpasser Count of each element in array
39.	Rearrange positive and negative numbers with constant extra space
40.	Sort an array according to count of set bits
41.	Count distinct occurrences as a subsequence
42.	Minimum number of swaps required to sort an array
43.	Number of swaps to sort when only adjacent swapping allowed
44.	Minimum swaps to make two arrays identical
45.	Find elements larger than half of the elements in an array
46.	Count minimum number of subsets (or subsequences) with consecutive numbers
47.	Sum of all elements between k1�th and k2�th smallest elements
48.	Number of sextuplets (or six values) that satisfy an equation
49.	Sort an array according to absolute difference with given value
50.	Minimize the sum of product of two arrays with permutations allowed
51.	Position of an element after stable sort
52.	Chocolate Distribution Problem
53.	Sort even-placed elements in increasing and odd-placed in decreasing order
54.	Permute two arrays such that sum of every pair is greater or equal to K
55.	Chose k array elements such that difference of maximum and minimum is minimized
56.	Sort an array when two halves are sorted
57.	Find pair with greatest product in array
58.	Minimum swap required to convert binary tree to binary search tree
59.	K-th smallest element after removing some integers from natural numbers
60.	Check whether Arithmetic Progression can be formed from the given array
61.	Bucket Sort To Sort an Array with Negative Numbers
62.	Possible to form a triangle from array values
63.	Maximum difference between frequency of two elements such that element having greater frequency is also greater
64.	Check if reversing a sub array make the array sorted
65.	Find all triplets with zero sum
66.	Sort a Matrix in all way increasing order
67.	Sort array after converting elements to their squares
68.	Sort all even numbers in ascending order and then sort all odd numbers in descending order
69.	Sorting Big Integers
70.	Sort an array of large numbers
71.	Sort 3 Integers without using if condition or using only max() function
72.	Minimum difference between max and min of all K-size subsets
73.	Minimum swaps to reach permuted array with at most 2 positions left swaps allowed
74.	Convert an array to reduced form | Set 2 (Using vector of pairs)
75.	Find sum of non-repeating (distinct) elements in an array
76.	Minimum sum of absolute difference of pairs of two arrays
77.	Find the largest multiple of 3 from array of digits | Set 2 (In O(n) time and O(1) space)
78.	Noble integers in an array (count of greater elements is equal to value)
79.	Find maximum height pyramid from the given array of objects
80.	Program to check if an array is sorted or not (Iterative and Recursive)
81.	Smallest Difference Triplet from Three arrays
82.	Smallest Difference pair of values between two unsorted Arrays
83.	Find whether it is possible to make array elements same using one external number
84.	Sort an array of strings according to string lengths
85.	Check if it is possible to sort an array with conditional swapping of adjacent allowed
86.	Sort an array after applying the given equation
87.	Print array of strings in sorted order without copying one string into another
88.	Sort elements on the basis of number of factors

 */
public interface ISortingApplication {

	/** 1. Sort elements by frequency | Set 1 **/
	public int[] sortByFrequency(int a[]);

	// without using inbuilt library
	public int[] sortByFrequencyX(int a[]);

	public int[] sortByFrequencyMaxToMin(int a[]);

	public int[] sortByFrequencyMinToMax(int a[]);

	/** 2. Sort elements by frequency | Set 2 **/
	public BTNode create(BTNode node, int fre, String dt);

	public void revInorderTravel(BTNode node, int b[]);

	public int[] sortByFrequencyBst(int a[]);

	/** 3. Count Inversions in an array | Set 1 (Using Merge Sort) **/
	public int countInversion(int a[]);

	// TODO by merge sort
	/** 4. Sort an array of 0s, 1s and 2s **/
	public int[] sortThreeElementX(int a[]);

	public int[] sortThreeElementY(int a[]);

	public int[] sortThreeElementZ(int a[]);

	// O(n)
	public int[] sortNPerfectNumber(int a[], int n);

	/**
	 * 5. Find the Minimum length Unsorted Subarray, sorting which makes the
	 * complete array sorted
	 **/
	public int[] unsortedSubArrayLen(int a[]);

	public int[] unsortedSubArrayLenX(int a[]);

	/** 6. Find whether an array is subset of another array | Added Method 3 **/
	public boolean isSubsetArrInOtherArray(int main[], int subset[]);
	/** 7. Sort a nearly sorted (or K sorted) array **/
	/* use heap sortO(k+(n-k)logk) or insetion sort O(nk) */
	/** 8. Sort numbers stored on different machines **/
	/* this is heap-link list problem added to heap lession-data structure */
	/** 9. Sort a linked list of 0s, 1s and 2s **/
	/* @ ISLinkList.java @ point 98....program */
	/** 10. A Pancake Sorting Problem **/

	/* @see ISortingAlgo.java ...point 21. Pancake Sorting */
	/** 11. Find number of pairs (x, y) in an array such that x^y > y^x **/
	public int count(int x, int y[], int n, int nofY[]);

	public int noOfPair(int x[], int y[], int m, int n);
	/*
	 * 12. Count all distinct pairs with difference equal to k 13. C Program for
	 * Bubble Sort on Linked List 14. Sort n numbers in range from 0 to n^2 � 1 in
	 * linear time 15. C Program to Sort an array of names or strings 16. Sort an
	 * array according to the order defined by another array 17. Given a sorted
	 * array and a number x, find the pair in array whose sum is closest to x 18.
	 * Sort an array in wave form 19. Check if any two intervals overlap among a
	 * given set of intervals 20. How to efficiently sort a big list dates in 20�s
	 * 21. Sort an almost sorted array where only two elements are swapped 22. Find
	 * the point where maximum intervals overlap 23. Sort a linked list that is
	 * sorted alternating ascending and descending orders? 24. C++ program for
	 * Sorting Dates using Selection Sort 25. How to sort an array of dates in
	 * C/C++? 26. Sorting Strings using Bubble Sort 27. Maximum product of a triplet
	 * (subsequnece of size 3) in array 28. Find missing elements of a range 29.
	 * Find a permutation that causes worst case of Merge Sort 30. Minimum sum of
	 * two numbers formed from digits of an array
	 */
}
