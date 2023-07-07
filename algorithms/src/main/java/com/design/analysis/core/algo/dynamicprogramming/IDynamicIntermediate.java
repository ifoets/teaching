package com.design.analysis.core.algo.dynamicprogramming;

import java.util.List;
import java.util.TreeMap;

import com.design.analysis.core.algo.dynamicprogramming.model.Chain;
import com.design.analysis.core.algo.dynamicprogramming.model.WtJobScheduling;

/*
 * 
 * @author GuruG
Intermediate Problems :
1.	Lobb Number
2.	Eulerian Number
3.	Delannoy Number
4.	Entringer Number
5.	Rencontres Number
6.	Jacobsthal and Jacobsthal-Lucas numbers
7.	Super Ugly Number (Number whose prime factors are in given set)
8.	Floyd Warshall Algorithm
9.	Bellman�Ford Algorithm
10.	0-1 Knapsack Problem
11.	Printing Items in 0/1 Knapsack
12.	Unbounded Knapsack (Repetition of items allowed)
13.	Temple Offerings
14.	Egg Dropping Puzzle
15.	Dice Throw Problem
16.	Word Break Problem
17.	Vertex Cover Problem
18.	Tile Stacking Problem
19.	Box-Stacking Problem
20.	Highway Billboard Problem
21.	Largest Independent Set Problem
22.	Partition Problem
23.	Print equal sum sets of array (Partition problem) | Set 1
24.	Print equal sum sets of array (Partition Problem) | Set 2
25.	High-effort vs. Low-effort Tasks Problem
26.	Travelling Salesman Problem | Set 1 (Naive and Dynamic Programming)
27.	Longest Bitonic Subsequence
28.	Printing Longest Bitonic Subsequence
29.	Longest Palindromic Subsequence
30.	Print Longest Palindromic Subsequence
31.	Longest palindrome subsequence with O(n) space
32.	Count All Palindromic Subsequence in a given String
33.	Longest Palindromic Substring | Set 1
34.	Count All Palindrome Sub-Strings in a String | Set 1
35.	Number of palindromic subsequences of length k
36.	Count of Palindromic substrings in an Index range
37.	Shortest Common Supersequence
38.	Maximum sum alternating subsequence
39.	Longest alternating subsequence
40.	Shortest Uncommon Subsequence
41.	Longest Repeating Subsequence
42.	Count Distinct Subsequences
43.	Count distinct occurrences as a subsequence
44.	Longest Common Increasing Subsequence (LCS + LIS)
45.	Variations of LIS
46.	LCS formed by consecutive segments of at least length K
47.	Printing Maximum Sum Increasing Subsequence
48.	Longest Increasing Odd Even Subsequence
49.	Count number of increasing subsequences of size k
50.	Printing longest Increasing consecutive subsequence
51.	Construction of Longest Increasing Subsequence using Dynamic Programming
52.	Longest Zig-Zag Subsequence
53.	Largest sum Zigzag sequence in a matrix
54.	Find all distinct subset (or subsequence) sums of an array
55.	Print all longest common sub-sequences in lexicographical order
56.	Printing Longest Common Subsequence | Set 2 (Printing All)
57.	Length of Longest Balanced Subsequence
58.	Non-decreasing subsequence of size k with minimum sum
59.	Longest Common Subsequence with at most k changes allowed
60.	Weighted job scheduling
61.	Weighted Job Scheduling | Set 2 (Using LIS)
62.	Weighted Job Scheduling in O(n Log n) time
63.	Number of paths with exactly k coins
64.	Minimum number of coins that make a given value
65.	Collect maximum coins before hitting a dead end
66.	Coin game winner where every player has three choices
67.	Probability of getting at least K heads in N tosses of Coins
68.	Count all increasing subsequences
69.	Count number of paths with at-most k turns
70.	Count possible ways to construct buildings
71.	Count number of ways to jump to reach end
72.	Count number of ways to reach destination in a Maze
73.	Count all triplets whose sum is equal to a perfect cube
74.	Count number of binary strings without consecutive 1�s
75.	Count number of subsets having a particular XOR value
76.	Count Possible Decodings of a given Digit Sequence
77.	Count number of ways to partition a set into k subsets
78.	Count of n digit numbers whose sum of digits equals to given sum
79.	Count ways to assign unique cap to every person
80.	Count binary strings with k times appearing adjacent two set bits
81.	Count of strings that can be formed using a, b and c under given constraints
82.	Count digit groupings of a number with given constraints
83.	Count all possible walks from a source to a destination with exactly k edges
84.	Count Derangements (Permutation such that no element appears in its original position)
85.	Count total number of N digit numbers such that the difference between sum of even and odd digits is 1
86.	Maximum Product Cutting
87.	Maximum profit from sale of wines
88.	Maximum size subset with given sum
89.	Maximum difference of zeros and ones in binary string
90.	Maximum and Minimum Values of an Algebraic Expression
91.	Maximum average sum partition of an array
92.	Maximize array elements upto given number
93.	Maximum subarray sum in O(n) using prefix sum
94.	Maximum sum subarray removing at most one element
95.	K maximum sums of non-overlapping contiguous sub-arrays
96.	Maximum Product Subarray | Added negative product case
97.	Find maximum sum array of length less than or equal to m
98.	Find Maximum dot product of two arrays with insertion of 0�s
99.	Choose maximum weight with given weight and value ratio
100.	Maximum sum subsequence with at-least k distant elements
101.	Maximum profit by buying and selling a share at most twice
102.	Maximum sum path in a matrix from top to bottom
103.	Maximum decimal value path in a binary matrix
104.	Finding the maximum square sub-matrix with all equal elements
105.	Maximum points collected by two persons allowed to meet once
106.	Maximum number of trailing zeros in the product of the subsets of size k
107.	Minimum Sum Path In 3-D Array
108.	Minimum insertions to sort an array
109.	Minimum sum submatrix in a given 2D array
110.	Minimum Initial Points to Reach Destination
111.	Minimum Cost To Make Two Strings Identical
112.	Paper Cut into Minimum Number of Squares | Set 2
113.	Minimum and Maximum values of an expression with * and +
114.	Minimum insertions to form a palindrome
115.	Minimum number of deletions to make a string palindrome
116.	Minimum number of deletions to make a string palindrome | Set 2
117.	Minimum jumps to reach last building in a matrix
118.	Sub-tree with minimum color difference in a 2-coloured tree
119.	Minimum number of deletions to make a sorted sequence
120.	Minimum number of squares whose sum equals to given number n
121.	Remove minimum elements from either side such that 2*min becomes more than max
122.	Minimal moves to form a string by adding characters or appending string itself
123.	Minimum steps to delete a string after repeated deletion of palindrome substrings
124.	Clustering/Partitioning an array such that sum of square differences is minimum
125.	Minimum sum subsequence such that at least one of every four consecutive elements is picked
126.	Minimum cost to make Longest Common Subsequence of length k
127.	Minimum cost to make two strings identical by deleting the digits
128.	Minimum time to finish tasks without skipping two consecutive
129.	Minimum cells required to reach destination with jumps equal to cell values
130.	Minimum number of deletions and insertions to transform one string into another
131.	Find minimum adjustment cost of an array
132.	Find if string is K-Palindrome or not | Set 1
133.	Find if string is K-Palindrome or not | Set 2
134.	Find Jobs involved in Weighted Job Scheduling
135.	Find the Longest Increasing Subsequence in Circular manner
136.	Find the longest path in a matrix with given constraints
137.	Find the minimum cost to reach destination using a train
138.	Find minimum sum such that one of every three consecutive elements is taken
139.	Find number of times a string occurs as a subsequence in given string
140.	Find length of the longest consecutive path from a given starting character
141.	Find length of longest subsequence of one string which is substring of another string
142.	Find longest bitonic sequence such that increasing and decreasing parts are from two different arrays
143.	Wildcard Pattern Matching
144.	WildCard pattern matching having three symbols ( * , + , ? )
145.	Dynamic Programming | Wildcard Pattern Matching | Linear Time and Constant Space
146.	Check if any valid sequence is divisible by M
147.	Check for possible path in 2D matrix
148.	Check if possible to cross the matrix with given power
149.	Check if it is possible to transform one string to another
150.	Given a large number, check if a subsequence of digits is divisible by 8
151.	Hosoya�s Triangle
152.	Optimal Strategy for a game
153.	Optimal Binary Search Tree
154.	Number of permutation with K inversions
155.	Largest divisible pairs subset
156.	Sum of average of all subsets
157.	Compute sum of digits in all numbers from 1 to n
158.	Total number of non-decreasing numbers with n digits
159.	Non-crossing lines to connect points in a circle
160.	Dynamic Programming | Building Bridges
161.	Longest Increasing Path in Matrix
162.	Prefix Sum of Matrix (Or 2D Array)
163.	Multistage Graph (Shortest Path)
164.	Number of n digit stepping numbers
165.	Number of substrings divisible by 8 but not by 3
166.	Number of ordered pairs such that (Ai & Aj) = 0
167.	Number of ways to form a heap with n distinct integers
168.	Ways to write n as sum of two or more positive integers
169.	Modify array to maximize sum of adjacent differences
170.	Sum of products of all combination taken (1 to n) at a time
171.	Maximize the binary matrix by filpping submatrix once
172.	Length of the longest substring without repeating characters
173.	Longest Even Length Substring such that Sum of First and Second Half is same
174.	Shortest path with exactly k edges in a directed and weighted graph
175.	Ways to arrange Balls such that adjacent balls are of different types
176.	Ways of transforming one string to other by removing 0 or more characters
177.	Balanced expressions such that given positions have opening brackets
178.	Longest alternating sub-array starting from every index in a Binary Array
179.	Partition a set into two subsets such that the difference of subset sums is minimum
180.	Pyramid form (increasing then decreasing) consecutive array using reduce operations.

 */
public interface IDynamicIntermediate {

	/**
	 * 0.1 Find the way of arrangemnet n bodys and n girls together so that 2 boys
	 * or girls cant sit together by Guruji
	 **/
	public int wayOfSitBoyAndGirl(int n, int m);

	/** 1. Lobb Number **/
	// TODO not understand the the derivation
	/** 2. Eulerian Number **/
	public int eulerian(int n, int m);

	/** 3. Delannoy Number **/
	public int dealnnoyRec(int n, int m);

	public int dealnnoyDp(int n, int m);

	/** 4. Entringer Number **/
	public int zigzagRcv(int n, int k);

	public int zigzagDp(int n, int k);

	/** 5. Rencontres Number **/
	public int rencontresNumberDp(int C[][], int n, int m);

	public void binomialCoeff(int C[][], int n, int k);

	/** 6. Jacobsthal and Jacobsthal-Lucas numbers **/
	public int Jacobsthal(int n);

	// Return nth Jacobsthal number.
	public int JacobsthalDp(int n);

	// Return nth Jacobsthal-Lucas number.
	public int Jacobsthal_LucasDp(int n);

	/** 7. Super Ugly Number (Number whose prime factors are in given set) **/
	public int nthSuperUglyNumber(int n, int[] primes);

	/** 8. Floyd Warshall Algorithm **/
	public void floydWarshall(int graph[][]);

	public void printSolution(int dist[][]);

	/** 9. Bellman�Ford Algorithm **/
	// TODO
	/** 1. 0-1 Knapsack Problem **/
	public int knapSack(int W, int wt[], int val[], int n);

	/** 11. Printing Items in 0/1 Knapsack **/
	public void printknapSack(int W, int wt[], int val[], int n);

	/** 12. Unbounded Knapsack (Repetition of items allowed) **/
	public int maxValUnboundedKnapSack(int val[], int wt[], int W);

	/** 13. Temple Offerings **/
	public int templeOfferings(int t[]);

	/** 14. Egg Dropping Puzzle **/
	public int eggDropRec(int n, int k);

	public int eggDropDp(int n, int k);

	/** 15. Dice Throw Problem **/
	public int findWays(int m, int n, int x);

	/** 16. Word Break Problem **/
	public boolean isWordBreakInDictRcv(String sl[], String s, int iIndex);

	public boolean isWordBreakInDict(String sl[], String s);

	/** 17. Vertex Cover Problem **/
	// TODO
	/** 18. Tile Stacking Problem **/
	// TODO
	public int tileStackingProblm(int n, int m, int k);

	/** 19. Box-Stacking Problem **/
	public int boxStackingProblem(int a[][]);

	/* 20. Highway Billboard Problem */
	/******************************************************************************************************************************************************************/

	/** 2. Length of the longest substring without repeating characters **/
	public String longestSubString(String str);

	/** 3. Count number of ways to reach destination in a Maze **/
	public int noOfWayReachDestnInMaze(int a[][]);

	/** 4. Super Ugly Number (Number whose prime factors are in given set) **/
	/* This function divides a by greatest divisible power of b */
	public int maxDivide(int a, int b);

	/* check the no is ugly or not */
	public boolean isUgly(int a[], int n);

	public int superUglyNoPrimeFactInGivenSet(int a[], int n);

	/** 5. Count number of ways to partition a set into k subsets **/
	public int countP(int n, int k);

	/* recursive way */
	public int noOfWayKPartitionNNumsRec(int a[], int k);

	/* using dp */
	public int noOfWayKPartitionNNumsDp(int a[], int k);

	/** 6. Longest Palindromic Subsequence **/
	public int longestPalindromeRec(String str, int l, int r);

	/* this is smae as palindrome */
	public int longestSubsequenceDp(String str);

	/* longest subsequence from two strings is simillar prob */
	public int longestSubsequence(String str1, String str2);

	/** 8. Weighted job scheduling **/
	public int weightedJobScheduling(List<WtJobScheduling> list);

	/** 9. Longest Bitonic Subsequence **/
	public int longestBitonicSubsequenceDp(int a[]);

	/** 10. Floyd Warshall Algorithm this is minimum distnce of two node **/
	public int[][] floydWarshallAlgo(int g[][]);

	/** 11. Partition Problem **/
	public boolean isPrtitionInEqualSum(int a[]);

	/** 12. Variations of LIS **/
	/* Building briedge (max) */
	public TreeMap<Integer, Integer> maxBriedge(int a[], int b[]);

	/* maximumn sum of increasing subsequence */
	public TreeMap<Integer, Integer> maxSumIncreasingSubseq(int a[]);

	/* longest increasing subsequence */
	public TreeMap<Integer, Integer> maxIncreasingSubseq(int a[]);

	/* longest chain by connecting different chain */
	public List<Chain> longestChainConnect(List<Chain> cl);
	/* 13. Box-Stacking Problem */
	/* 14. Bellman�Ford Algorithm */
	/* 15. Optimal Binary Search Tree */
	/* 16. Largest Independent Set Problem */
	/* 17. Minimum insertions to form a palindrome */
	/* 18. Minimum number of deletions to make a string palindrome */
	/* 19. Maximum Product Cutting */
	/*
	 * 20. Clustering/Partitioning an array such that sum of square differences is
	 * minimum
	 */
}
