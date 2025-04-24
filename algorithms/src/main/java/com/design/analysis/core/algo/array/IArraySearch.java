package com.design.analysis.core.algo.array;

import java.util.List;

/*
 * 
 * @author GuruG
 * Searching :
1.	Search, insert and delete in an unsorted array
2.	Search, insert and delete in a sorted array
3.	Given an array []a and a number x, check for pair in []a with sum as x
4.	Searching in an array where adjacent differ by at most k
5.	Find common elements in three sorted arrays
6.	Find position of an element in a sorted array of infinite numbers
7.	Find the only repetitive element between 1 to n-1
8.	Find the element that appears once
9.	Maximum Subarray Sum Excluding Certain Elements
10.	Maximum equlibrium sum in an array
11.	Equilibrium index of an array
12.	Leaders in an array
13.	Ceiling in a sorted array
14.	Majority Element
15.	Check for Majority Element in a sorted array
16.	Check if an array has a majority element
17.	Two Pointers Technique
18.	Find a peak element
19.	Find the two repeating elements in a given array
20.	Find a Fixed Point in a given array
21.	Find sub-array with given sum
22.	Maximum triplet sum in array
23.	Smallest Difference Triplet from Three arrays
24.	Find a triplet that sum to a given value
25.	Find all triplets with zero sum

 */
interface IArraySearch {

    /** 1. Search, insert and delete in an unsorted array **/
    boolean searchInsertDelUnsortedArr(int []a, int n, int x, String flage);

    /** 2. Search, insert and delete in an sorted array **/
    boolean searchInsertDelSortedArr(int []a, int n, int x, String flage);

    /**
     * 3. Given an array []a and a number x, check for pair in []a with sum as x
     **/
    List<List<Integer>> pairOfSumX(int []a, int x);

    /** 4. Searching in an array where adjacent differ by at most k **/

    /** 12.Leaders in an array **/
    List<Integer> findLeader(int []a);

    /** 14. Majority Element **/
    //o(n)
    Integer majorityElement(int []a);

    /** 15.	Check for Majority Element in a sorted array,
     A majority element in an array arr of size N is an element that appears more than N/2 times in the array.**/
    //O(long(n))
    boolean majorityElementSorted(int []a, int x);

    /**16.	Check if an array has a majority element
     * A majority element in an array is an element that appears strictly more than arr.size() / 2 times in the array**/
    boolean checkMajorityElements(int []a);
    /**17.	Two Pointers Technique, it get used for sorted array
     * typically used for Two Sum in Sorted Arrays, Closest Two Sum, Three Sum, Four Sum, Trapping Rain Water **/
    List<Integer> pairSumTwoPointerTech(int []a, int sum);
    /**18.	Find a peak element, greater than its left and right Log(n)**/
    int peakElement(int []a);
    /**19.	Find the two repeating elements in a given array**/
    /**20.	Find a Fixed Point in a given array**/

}
