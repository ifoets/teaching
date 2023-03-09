package interview.preparation.self.basic.prep;

import java.util.List;
import java.util.Map;

/*
Question 1 : How to reverse a String in java? Can you write a program without using any java inbuilt methods?
Question 2 : Write a java program to check if two Strings are anagram in java?
Question 3 : Write a program to check if String has all unique characters in java?
Question 4 : How to check if one String is rotation of another String in java?
Question 5 : How to find duplicate characters in String in java?
Question 6 : Find first non repeated character in String in java?
Question 7 : Find all substrings of String in java?
Question 8 : Find length of String without using any inbuilt method in java?
Question 9 : Write a program to print all permutations of String in java?


Array
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
Stack
Question 41:  Implement a stack using array.
Question 42: Implement a stack using Linked List.
Question 43:  Implement a stack using two queues.
Question 44 : Sort an stack using another stack
Queue
Question 45:  Implement Queue using Array in java.
Question 46:  Implement a stack using two queues .
Linked List
Question 47 : Implement singly linked list in java.
Question 48: How to reverse linked list in java.
Question 49: How to find middle element of linked list.
Question 50 : How to find nth element from end of linked list .
Question 51 : How to detect a loop in linked list. If linked list has loop, find the start node for the loop.
Question 52: How to check if linked list is palindrome or not?
Question 53 :  Find intersection of two linked lists?
Question 54 :  How to reverse a linked list in pairs?
Question 55 :  Implement Doubly linked list in java?


Binary Tree
Question 56 : How can you traverse binary tree?
Question 57 : Write an algorithm to do level order traversal of binary tree?
Question 58 :  Write an algorithm to do spiral order traversal of binary tree?
Question 59 : How can you print leaf nodes of binary tree?
Question 60 : How to count leaf nodes of binary tree.
Question 61 : How to print all paths from root to leaf in binary tree.
Question 62 : How to find level of node in binary tree
Question 63 : How to find maximum element in binary tree.
Question 64 : How to find lowest common ancestor(LCA) in binary tree.
Question 65 : How to do boundary traversal of binary tree.
Question 66 : How to print vertical sum of binary tree?
Question 67 : Count subtrees with Sum equal to target in binary tree?
Binary Search tree
Question 68 : What is binary search tree?
Question 69 : Can you write algorithm to insert a node in binary search tree.
Question 70 : Can you write algorithm to delete a node in binary search tree.
Question 71 :  How can you find minimum and maximum elements in binary search tree?
Question 72 : How to find lowest common ancestor(LCA) in binary search tree.
Question 73 : Find inorder successor in a Binary search Tree
Question 74 : Convert sorted array to balanced BST
Question 75 : Convert sorted Linked List to balanced BST
Question 76 : Check if a binary tree is binary search tree or not in java
Sorting
Question 77 : Write an algorithm to implement bubble sort?
Question 78 : Write an algorithm to implement insertion sort sort?
Question 79 : Write an algorithm to implement selection sort sort?
Question 80 : Can you write algorithm for merge sort and also do you know complexity of merge sort?
Question 81 : Do you know how to implement Heap sort?
Question 82 : Implement quick sort in java?
Question 83 : Implement shell sort in java?
Question 84 : Implement Counting sort in java?
Question 85 : What is binary search? Can you write an algorithm to find an element in sorted array using binary search?
Graph
Question 86 : Write algorithm to do depth first search in a graph.
Question 87 : Write algorithm to do breadth first search in a graph.
Question 88 : Explain Dijkstra algorithm from source to all other vertices.
Question 89 : Explain Bellman Ford algorithm to find shortest distance
Question 90 : Explain Kruskal’s algorithm for finding minimum spanning tree
Dynamic Programming
Question 91 : Given two String, find longest common substring.
Question 92 : Given two Strings A and B. Find the length of the Longest Common Subsequence (LCS) of the given Strings.
Question 93 : Given a matrix, we need to count all paths from top left to bottom right of MxN matrix. You can either move down or right.
Question 94 : Edit Distance Problem in java
Question 95: Coin change problem in java
Question 96 : Minimum number of jumps to reach last index
Miscellaneous
Question 97 : What is an algorithm and how to calculate complexity of algorithms.
Question 98 : Implement trie data structure in java.
Question 99 : Count Factorial Trailing Zeroes in java.
Question 100 : Largest Rectangular Area in a Histogram.
Question 101 : Check for balanced parentheses in an expression in java.
Question 102 : What is Memoization.
public interface IBasicInterview {
*/
public interface IBasicInterview {
	/*Search element in array in fastest way */
	public int advSearch(int a[], int x);
	/*
	 * Question 1 : How to reverse a String in java? Can you write a program without
	 * using any java inbuilt methods?
	 */
	public String recursiveReverse(String str);

	/*
	 * Question 2 : Write a java program to check if two Strings are anagram in
	 */
	public boolean checkAnagram(String str1, String str2);

	/*
	 * java? Question 3 : Write a program to check if String has all unique
	 * characters in java?
	 */
	public boolean checkAllUniqueChar(String str);

	/*
	 * Question 4 : How to check if one String is rotation of another String in
	 * java?
	 */
	public boolean checkStringRoation(String str1, String str2);

	/*
	 * Question 5 : How to find duplicate characters in String in java?
	 * 
	 * 
	 */
	public char[] duplicateChar(String str);

	/*
	 * Question 6 : Find first non repeated character in String in java? Question
	 */
	public Character firstNonReptChar(String str);

	/*
	 * 7 : Find all substrings of String in java? Question
	 */
	public List<String> allSubstr(String str);

	/*
	 * 8 : Find length of String without using any inbuilt method in java?
	 */
	public int leng(String str);

	/*
	 * Question 9 : Write a program to print all permutations of String in java?
	 */
	public void permutationStr(String str, int l, int r);

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
}
	

	/*

Question 35 : Find maximum difference between two elements such that larger element appears after the smaller number.
Question 36 : Search in a row wise and column wise sorted matrix.
Question 37 : Largest sum contiguous subarray.
Question 38 : Find the Contiguous Subarray with Sum to a Given Value in an array.


Question 39 : Longest Common Prefix in an array of Strings in java.
Question 40 : Find all subsets of set (power set) in java.
Stack
Question 41:  Implement a stack using array.
Question 42: Implement a stack using Linked List.
Question 43:  Implement a stack using two queues.
Question 44 : Sort an stack using another stack
Queue
Question 45:  Implement Queue using Array in java.
Question 46:  Implement a stack using two queues .
Linked List
Question 47 : Implement singly linked list in java.
Question 48: How to reverse linked list in java.
Question 49: How to find middle element of linked list.
Question 50 : How to find nth element from end of linked list .
Question 51 : How to detect a loop in linked list. If linked list has loop, find the start node for the loop.
Question 52: How to check if linked list is palindrome or not?
Question 53 :  Find intersection of two linked lists?
Question 54 :  How to reverse a linked list in pairs?
Question 55 :  Implement Doubly linked list in java?
*/
	 

