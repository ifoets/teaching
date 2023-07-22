package com.design.analysis.quick.prep.array;

import java.util.List;
import java.util.Map;
/*Array
Question 10 : Write java Program to Find Smallest and Largest Element in an Array.
Question 11 : Find missing number in the array.
Question 12 : Search an element in rotated and sorted array.
Question 13 : Find minimum element in a sorted and rotated array.
Question 14: Find second largest number in an array
Question 15 : Find the number occurring odd number of times in an array
Question 16 : Find minimum number of platforms required for railway station
Question 17 : Find a Pair Whose Sum is Closest to zero in Array
Question 18 : Given a sorted array and a number x, find the pair in array whose sum is closest to x
Question 19 : Find all pairs of elements from an array whose sum is equal to given number
Question 20: Given an array of 0’s and 1’s in random order, you need to separate 0’s and 1’s in an array.
Question 21 : Separate odd and even numbers in an array
Question 22 : Given an array containing zeroes, ones and twos only. Write a function to sort the given array in O(n) time complexity.
Question 23 : Find local minima in array

Question 24 : Sliding window maximum in java
Question 25 : Count number of occurrences (or frequency) of each element in a sorted array


Question 29 : Count 1’s in sorted Binary Array.
Question 30 : Find first repeating element in an array of integers.
Question 31 : Check if Array Elements are Consecutive.
Question 32 : Permutations of array in java.
Question 33 : Rotate an array by K positions.
Question 34 : Stock Buy Sell to Maximize Profit.
Question 35 : Find maximum difference between two elements such that larger element appears after the smaller number.
Question 36 : Search in a row wise and column wise sorted matrix.
Question 37 : Largest sum contiguous subarray.
Question 38 : Find the Contiguous Subarray with Sum to a Given Value in an array.


Question 39 : Longest Common Prefix in an array of Strings in java.
Question 40 : Find all subsets of set (power set) in java.
Question 41 :/*
	 * Two sorted array a1 and a2 a2 have some element and exttra space of size a1
	 * sort without extra space and complexity n arr1 m [3,4,9,10,20] arr2 n with m
	 * space [ ,1,2, ,8,11, ,13, , ]
	 */

public interface IArray {

    /* Array */
    /*
     * Question 10 : Write java Program to Find Smallest and Largest Element in an
     * Array.
     */
    public int[] smallestLagest(int a[]);

    /*
     * Question 11 : Find missing number in the array.
     */
    public int missingNo(int a[]);

    /*
     * Question 12 : Search an element in rotated and sorted array.
     */
    public int elemInSortedRotatedArr(int a[], int key);

    /*
     * public Question 13 : Find minimum element in a sorted and rotated array.
     */
    public int minSortedRotatedArr(int a[]);

    /*
     * Question 14: Find second largest number in an array Question
     */
    public int nLargest(int a[], int x);

    /*
     * *15 : Find the number occurring odd number of times in an array Question in
     * single traverse
     */
    public int oddNumsInArr(int a[]);

    /*
     * 16 : Find minimum number of platforms required for railway station
     */
    public int minNoOfPlatform(int a[], int d[]);

    /*
     * Question 17 : Find a Pair Whose Sum is Closest to zero in Array Question
     */
    public int pariSumCloestToZero(int a[]);

    // clogest to zero the triple
    public int tripleSumCloestToZero(int a[]);

    /*
     * 18 : Given a sorted array and a number x, find the pair in array whose sum is
     * closest to x
     */
    public int[] pairClogest(int a[], int x);

    /*
     * Question 19 : Find all pairs of elements from an array whose sum is equal to
     * given number
     */
    public Map<Integer, Integer> pairSumOfX(int a[], int x);

    /*
     * Question 20: Given an array of 0’s and 1’s in random order, you need to
     * separate 0’s and 1’s in an array.
     */
    public void seperate01(int a[]);

    /*
     * Question 21 : Separate odd and even numbers in an array Question 22
     */
    public void seperateOddEven(int a[]);

    /*
     * : Given an array containing zeroes, ones and twos only. Write a function to
     * sort the given array in O(n) time complexity.
     */
    public void sort012(int a[], int n);
    /*
     * Question 23 : Find local minima in array
     */
    public int localMinima(int a[], int l, int r, int n);
    /*
     * Question 24 : Sliding window maximum in java Question
     */
    public List<Integer> slidingWindowMax(int a[], int k);

    /*25 : Count number of
     * occurrences (or frequency) of each element in a sorted array
     */
    public int frequencyOfItems(int a[], int k);

    /* Question 29 : Count 1’s in sorted Binary Array.*/
    public int count1sInSortedBinaryArr(int a[]);

    /*Question 30 : Find first repeating element in an array of integers.*/
    public int firstRepetating(int a[]);

    public int firstMinMaxRpetation(int x[], int minMax);

    /*Question 31 : Check if Array Elements are Consecutive.*/
    public boolean checkConsecutive(int a[]);

    /*Question 32 : Permutations of array in java.*/
    public void permutation(List<Integer> l,int k);

    /*Question 33 : Rotate an array by K positions.*/
    public void rotateKpos(int a[], int k);

    /*Question 34 : Stock Buy Sell to Maximize Profit.*/
    public int stockSellMaxPofit(int a[]);

    /*Question 41 :
     * Two sorted array a1 and a2 a2 have some element and exttra space of size a1
     * sort without extra space and complexity n arr1 m [3,4,9,10,20] arr2 n with m
     * space [ ,1,2, ,8,11, ,13, , ]
     */
    public void specialSort(int a[], int b[]);
}
