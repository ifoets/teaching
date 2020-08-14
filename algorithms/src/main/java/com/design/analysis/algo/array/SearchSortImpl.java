package com.design.analysis.algo.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.algo.utils.AlgoUtils;

/*
 * Searching and Sorting :
1.	Search, insert and delete in an unsorted array
2.	Search, insert and delete in a sorted array
3.	Given an array A[] and a number x, check for pair in A[] with sum as x
4.	Majority Element
5.	Find the Number Occurring Odd Number of Times
6.	Find the Missing Number
7.	Merge an array of size n into another array of size m+n
8.	Leaders in an array
9.	Sort elements by frequency | Set 1
10.	Count Inversions in an array | Set 1 (Using Merge Sort)
11.	Two elements whose sum is closest to zero
12.	Check for Majority Element in a sorted array
13.	Union and Intersection of two sorted arrays
14.	Ceiling in a sorted array
15.	Find the two repeating elements in a given array
16.	Sort an array of 0s, 1s and 2s
17.	Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
18.	Equilibrium index of an array
19.	Count number of occurrences (or frequency) in a sorted array
20.	Find the repeating and the missing | Added 3 new methods
21.	Median in a stream of integers (running integers)
22.	Find a Fixed Point in a given array
23.	Find sub-array with given sum
24.	Find a triplet that sum to a given value
25.	Find the two numbers with odd occurrences in an unsorted array
26.	Find a pair with the given difference
27.	Find four elements that sum to a given value | Set 1 (n^3 solution)
28.	Find four elements that sum to a given value | Set 2 ( O(n^2Logn) Solution)
29.	Median of two sorted arrays of different sizes
30.	Count the number of possible triangles
31.	Find a peak element
32.	Find number of pairs (x, y) in an array such that x^y > y^x
33.	Count all distinct pairs with difference equal to k
34.	Find if there is a sub-array with 0 sum
35.	Given a sorted array and a number x, find the pair in array whose sum is closest to x
36.	Count 1’s in a sorted binary array
37.	Print All Distinct Elements of a given integer array
38.	Construct an array from its pair-sum array
39.	Find common elements in three sorted arrays
40.	Find the first repeating element in an array of integers
41.	Find position of an element in a sorted array of infinite numbers
42.	Check if a given array contains duplicate elements within k distance from each other
43.	Find the element that appears once
44.	Find Union and Intersection of two unsorted arrays
45.	Delete an element from array (Using two traversals and one traversal)
46.	Count frequencies of all elements in array in O(1) extra space and O(n) time
47.	Trapping Rain Water
48.	Count triplets with sum smaller than a given value
49.	Count Inversions of size three in a given array
50.	Merge two sorted arrays with O(1) extra space
51.	Find lost element from a duplicated array
52.	Count pairs with given sum

 */
public class SearchSortImpl implements ISearchSort {

	/** 1. Search, insert and delete in an unsorted array **/
	public boolean searchInsertDelUnsortedArr(int a[], int n, int x, String flage) {

		boolean isOperationFinished = false;
		switch (flage) {
		case "S":
			for (int i = 0; i < a.length; i++) {
				if (a[i] == x) {
					isOperationFinished = true;
					break;
				}
			}
			break;
		case "I":
			if (a.length > n) {
				a[n] = x;
				isOperationFinished = true;
			} else {
				isOperationFinished = false;
				System.out.println(" Unsorted Arrays size is less..not possible to insert");
			}

			break;
		case "D":
			int i;
			for (i = 0; i < a.length; i++)
				if (a[i] == x) {
					isOperationFinished = true;
					break;
				}
			for (int j = i; j + 1 < a.length; j++)
				a[j] = a[j + 1];
			a[a.length - 1] = 0;

			break;

		}
		return isOperationFinished;
	}

	/** 2. Search, insert and delete in an sorted array **/
	public boolean searchInsertDelSortedArr(int a[], int n, int x, String flage) {
		boolean isOperationFinished = false;
		switch (flage) {
		case "S":
			int keyPos = AlgoUtils.binarySearch(a, 0, a.length - 1, x);
			if (keyPos != -1)
				isOperationFinished = true;
			break;
		case "I":
			if (a.length > n) {
				a[n] = x;
				isOperationFinished = true;
			} else {
				isOperationFinished = false;
				System.out.println("Sorted Arrays size is less..not possible to insert");
			}

			break;
		case "D":

			int pos = AlgoUtils.binarySearch(a, 0, a.length - 1, x);
			if (pos != -1) {
				isOperationFinished = true;
				for (int j = pos; j + 1 < a.length; j++)
					a[j] = a[j + 1];
				a[a.length - 1] = 0;
			}

			break;

		}
		return isOperationFinished;
	}

	/**
	 * 3. Given an array A[] and a number x, check for pair in A[] with sum as x
	 **/
	public List<List<Integer>> pairOfSumX(int a[], int x) {
		List<List<Integer>> listOfList = null;

		if (a.length > 1) {
			listOfList = new ArrayList<>();
			List<Integer> list = null;
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < a.length; i++) {
				if (map.containsKey(x - a[i])) {
					list = new ArrayList<>();
					list.add(a[i]);
					list.add(x - a[i]);
					listOfList.add(list);
				} else
					map.put(a[i], x - a[i]);
			}
		}
		return listOfList;
	}

	/** 4. Majority Element @assume one is majority **/
	public Integer majorityElement(int a[]) {

		Map<Integer, Integer> map = null;
		if (a == null || a.length == 0)
			return null;
		else if (a.length == 1) {
			return a[0];
		} else {
			map = new HashMap<>();

			for (int i = 0; i < a.length; i++) {
				if (map.containsKey(a[i]))
					map.put(a[i], map.get(a[i]) + 1);
				else
					map.put(a[i], 1);
			}
			int min = 0;
			int key = 0;
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				int val = entry.getValue();
				if (val > min) {
					min = val;
					key = entry.getKey();
				}
			}
			return key;
		}
	}

	/** 5. Find the Number Occurring Odd Number of Times **/
	@Override
	public List<Integer> oddNumberOfTimes(int a[]) {
		Map<Integer, Integer> map = null;
		List<Integer> resultList = null;
		if (a == null || a.length == 0)
			return null;
		else {
			map = new HashMap<>();
			resultList = new ArrayList<>();

			for (int i = 0; i < a.length; i++) {
				if (map.containsKey(a[i]))
					map.put(a[i], map.get(a[i]) + 1);
				else
					map.put(a[i], 1);
			}
			/* collecting odd number of times key */
			for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
				if (entry.getValue() % 2 == 1)
					resultList.add(entry.getKey());
			}
			return resultList;
		}
	}

	/** 6. Find the Missing **/
	@Override
	public int missingNumber(int a[]) {
		int sumArrs = 0;
		int sumNmum = 0;
		for (int i = 0; i < a.length; sumArrs += a[i], i++)
			;
		for (int j = 1; j <= a.length + 1; sumNmum += j, j++)
			;
		return sumNmum - sumArrs;
	}

	/** 7. Merge an array of size n into another array of size m+n **/
	public int[] meargeNArrToMNArr(int mnArr[], int nArr[]) {

		int j = mnArr.length - 1;

		for (int i = mnArr.length - 1; i >= 0; i--) {
			if (mnArr[i] != 0) {
				mnArr[j] = mnArr[i];
				mnArr[i] = 0;
				j--;
			}
		}

		/* j+1 at mnArr value start */
		j = j + 1;
		int m = 0;
		int k = 0;
		while (k < mnArr.length) {

			if (j == mnArr.length || m == nArr.length)
				break;

			if (nArr[m] < mnArr[j]) {
				mnArr[k] = nArr[m];
				m++;
			} else {
				mnArr[k] = mnArr[j];
				j++;
			}
			k++;
		}
		/* when nArr end copy pest the rest of mnArr */
		while (j < mnArr.length && k < mnArr.length)
			mnArr[k++] = mnArr[j++];

		/* when mnArr end copy pest the rest of nArr */
		while (m < nArr.length && k < mnArr.length)
			mnArr[k++] = nArr[m++];

		return mnArr;
	}

	/** 8.Leaders in an array **/
	public List<Integer> findLeader(int a[]) {
		int maxFromRight = a[a.length - 1];// rightmost always leader
		List<Integer> resultList = new ArrayList<>();
		resultList.add(maxFromRight);
		for (int i = a.length - 2; i >= 0; i--) {
			if (maxFromRight < a[i]) {
				resultList.add(a[i]);
				maxFromRight = a[i];
			}
		}
		return resultList;
	}

	/** 9. Sort elements by frequency | Set 1 **/
	@Override
	public void sortByfriquency(int a[]) {

		if (a == null || a.length == 0 || a.length == 1)
			return;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i]))
				map.put(a[i], map.get(a[i]) + 1);
			else
				map.put(a[i], 1);
		}

		List<Element> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			list.add(new Element(entry.getValue(), entry.getKey()));
		Collections.sort(list);

		int i = 0;
		for (Element elm : list) {
			int x = elm.index;
			for (int j = 0; j < x; j++)
				a[i++] = elm.elem;
		}
	}

	/********************************************************************************************************************************************************************/
	class Element implements Comparable<Element> {
		public int index;
		public int elem;

		@Override
		public int compareTo(Element o) {
			return o.index - this.index;
		}

		public Element(int index, int elem) {
			super();
			this.index = index;
			this.elem = elem;
		}

	}

}
