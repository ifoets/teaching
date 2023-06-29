package com.design.analysis.algo.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.algo.dynamicprogramming.model.Pair;

/*
 * 
 * @author GuruG
 * 
Basic Problems :
	1.	Ugly numbers
	2.	Fibonacci numbers
	3.	nth Catalan Number
	4.	Bell Numbers (Number of ways to Partition a Set)
	5.	Binomial Coefficient
	6.	Permutation Coefficient
	7.	Tiling Problem
	8.	Gold Mine Problem
	9.	Coin change problem
	10.	Friends Pairing Problem
	11.	Subset Sum Problem
	12.	Subset Sum Problem in O(sum) space
	13.	Subset with sum divisible by m
	14.	Largest divisible pairs subset
	15.	Perfect Sum Problem (Print all subsets with given sum)
	16.	Compute nCr % p
	17.	Choice of area
	18.	Cutting a Rod
	19.	Tiling with Dominoes
	20.	Painting Fence Algorithm
	21.	Newman�Shanks�Williams prime
	22.	Assembly line scheduling
	23.	Golomb sequence
	24.	Moser-de Bruijn Sequence
	25.	Newman-Conway Sequence
	26.	Find maximum length Snake sequence
	27.	Print n terms of Newman-Conway Sequence
	28.	Print Fibonacci sequence using 2 variables
	29.	Print Fibonacci Series in reverse order
	30.	Count even length binary sequences with same sum of first and second half bits
	31.	Sequences of given length where every element is more than or equal to twice of previous
	32.	Longest Common Subsequence
	33.	Longest Repeated Subsequence
	34.	Longest Increasing Subsequence
	35.	A Space Optimized Solution of LCS
	36.	LCS (Longest Common Subsequence) of three strings
	37.	Maximum sum Bi-tonic Sub-sequence
	38.	Maximum Sum Increasing Subsequence
	39.	Maximum product of an increasing subsequence
	40.	Count all subsequences having product less than K
	41.	Maximum subsequence sum such that no three are consecutive
	42.	Longest subsequence such that difference between adjacents is one
	43.	Maximum length subsequence with difference between adjacent elements as either 0 or 1
	44.	Maximum sum increasing subsequence from a prefix and a given element after prefix is must
	45.	Maximum Length Chain of Pairs
	46.	Print Maximum Length Chain of Pairs
	47.	Path with maximum average value
	48.	Maximum games played by winner
	49.	Maximum path sum in a triangle
	50.	Minimum Sum Path in a Triangle
	51.	Maximum sum of a path in a Right Number Triangle
	52.	Size of The Subarray With Maximum Sum
	53.	Maximum sum of pairs with specific difference
	54.	Maximum size square sub-matrix with all 1s
	55.	Maximum number of segments of lengths a, b and c
	*
	*
	56.	Recursively break a number in 3 parts to get maximum sum
	57.	Maximum value with the choice of either dividing or considering as it is
	58.	Maximum weight path ending at any element of last row in a matrix
	59.	Maximum sum in a 2 x n grid such that no two elements are adjacent
	60.	Maximum difference of zeros and ones in binary string | Set 2 (O(n) time)
	61.	Maximum path sum for each position with jumps under divisibility condition
	62.	Maximize the sum of selected numbers from an array to make it empty
	63.	Maximum subarray sum in an array created after repeated concatenation
	64.	Maximum path sum that starting with any cell of 0-th row and ending with any cell of (N-1)-th row
	65.	Min Cost Path
	66.	Minimum number of jumps to reach end
	67.	Minimum cost to fill given weight in a bag
	68.	Minimum sum of multiplications of n numbers
	69.	Minimum removals from array to make max � min <= K
	70.	Minimum steps to minimize n as per given condition
	71.	Minimum number of edits ( operations ) require to convert string 1 to string 2
	72.	Minimum time to write characters using insert, delete and copy operation
	73.	Longest Common Substring
	74.	Longest Common Substring (Space optimized DP solution)
	75.	Sum of all substrings of a string representing a number | Set 1
	76.	Find number of endless points
	77.	Find n-th element from Stern�s Diatomic Series
	78.	Find maximum possible stolen value from houses
	79.	Find number of solutions of a linear equation of n variables
	80.	Count number of ways to reach a given score in a game
	81.	Count ways to reach the nth stair using step 1, 2 or 3
	82.	Count of different ways to express N as the sum of 1, 3 and 4
	83.	Count ways to build street under given constraints
	84.	Count Balanced Binary Trees of Height h
	85.	Counting pairs when a person can form pair with at most one
	86.	Counts paths from a point to reach Origin
	87.	Count number of ways to cover a distance
	88.	Count of arrays having consecutive element with different values
	89.	Count ways to divide circle using N non-intersecting chords
	90.	Count the number of ways to tile the floor of size n x m using 1 x m size tiles
	91.	Count all possible paths from top left to bottom right of a mXn matrix
	92.	Count number of ways to fill a �n x 4� grid using �1 x 4� tiles
	93.	Largest Sum Contiguous Subarray
	94.	Smallest sum contiguous subarray
	95.	Size of array after repeated deletion of LIS
	96.	Remove array end element to maximize the sum of product
	97.	Convert to Strictly increasing array with minimum changes
	98.	Longest alternating (positive and negative) subarray starting at every index
	99.	Ways to sum to N using array elements with repetition allowed
	100.	Unique paths in a Grid with Obstacles
	101.	Number of n-digits non-decreasing integers
	102.	Number of ways to arrange N items under given constraints
	103.	Probability of reaching a point with 2 or 3 steps at a time
	104.	Value of continuous floor function : F(x) = F(floor(x/2)) + x
	105.	Number of decimal numbers of length k, that are strict monotone
	106.	Different ways to sum n using numbers greater than or equal to m


 */
public interface IDynamicBasic {

	/** 1. Ugly numbers **/
	/* This function divides a by greatest divisible power of b */
	public int maxDivide(int a, int b);

	/* check the no is ugly or not */
	public boolean isUgly(int n);

	/* get nth ugly no */
	public int nthUgalyNumber(int n);

	/** 2. Fibonacci numbers **/
	/* by using dynamic programming */
	public int nthFibNoDynamic(int n);

	/* by recursive way */
	public int nthFibNoRecursive(int n);

	/* by using minimum space */
	public int nthFibNoMinSpaceUse(int n);

	/** 3. nth Catalan Number **/
	public int catalan(int n);

	/* using dp */
	public int catalanDP(int n);

	/* Using Binomial Coefficient */
	public int catalanByBinomicalCoeff(int n);

	/** 4. Bell Numbers (Number of ways to Partition a Set) **/
	public int bellNumber(int n);

	/** 5. Binomial Coefficient **/
	public int binomialCoeff(int n, int k);

	/* using dp */
	public int binomialCoeffDp(int n, int k);
	
	public int binomialCoeffDpX(int n, int k);

	/** 6.Permutation Coefficient **/
	public int permutationCoefficient(int n, int k);
	
	public int permutationCoefficientX(int n, int k);

	/** 7. Tiling Problem **/ // bord 2*n and tiles 2*1
	public int tillingProblem(int n);
	
	/*Tiling Problem 1*m to n*m borad**/
	public int tillingProblemX(int n, int m);

	/** 8. Gold Mine Problem **/
	public int goldMineProblem(int g[][]);

	/** 9. Coin change problem **/
	/* recursive way */
	public int noOfWayCoinChangeRecv(int a[], int m, int n);

	/* by dynamic programming way */
	public int noOfWayCoinChangeDynamic(int a[], int m, int n);

	/** 10. Friends Pairing Problem **/
	public int countFriendsPairings(int n);

	/** 11. Subset Sum Problem **/
	public boolean isSubsetSumRcv(int set[], int n, int sum);

	public boolean isSubsetSumDp(int set[], int n, int sum);

	/** 12. Subset Sum Problem in O(sum) space **/
	public boolean isSubsetSum(int set[], int n, int sum);

	/** 13. Subset with sum divisible by m **/
	public boolean modularSum(int arr[], int n, int m);

	/** 14. Largest divisible pairs subset **/
	public int largestDivisiblePairSubsetDp(int a[]);

	public int largestDivisiblePairSubset(int a[]);

	/** 15. Perfect Sum Problem (Print all subsets with given sum) **/
	public List<List<Integer>> subsetsOfGivenSum(int a[], int sum);

	/** 16. Compute nCr % p **/
	public int nCrModp(int n, int r, int p);

	/** 17. Choice of area **/
	// TODDO
	/** 18. Cutting a Rod **/
	public int cutRodRcv(int price[], int n);

	public int cutRoDp(int price[], int n);

	/** 19. Tiling with Dominoes **/
	public int tillingDominoes(int n);

	/** 20. Painting Fence Algorithm **/
	public int paintingFence(int n, int k);

	public int paintingFenceX(int n, int k);

	/** 21. Newman�Shanks�Williams prime **/
	public int newmanShanksWilliamsPrime(int n);

	public int newmanShanksWilliamsPrimeDp(int n);

	/** 22. Assembly line scheduling **/
	public int carAssembly(int a[][], int t[][], int e[], int x[]);

	/** 23. Golomb sequence **/
	public List<Integer> printGolomb(int n);

	/** 24. Moser-de Bruijn Sequence **/
	public int[] moserDeBruijnSequence(int n);

	/** 25. Newman-Conway Sequence **/
	public int newmanConwaySequence(int n);

	public int newmanConwaySequenceDp(int n);

	/** 26. Find maximum length Snake sequence **/
	public List<Integer> maxLenSnakeSequence(int a[][]);

	/** 27. Print n terms of Newman-Conway Sequence **/
	// @See 25.
	/** 28. Print Fibonacci sequence using 2 variables **/
	public void fib(int n);

	/** 29. Print Fibonacci Series in reverse order **/
	public void reverseFibonacci(int n);

	/**
	 * 30. Count even length binary sequences with same sum of first and second half
	 * bits
	 **/
	public int countSeq(int n, int diff);

	public int countSeqDp(int n, int diff);

	public int countSeqUtil(int[][] t, int n, int dif);

	public int countSeqRec(int n);

	/**
	 * 31. Sequences of given length where every element is more than or equal to
	 * twice of previous
	 **/
	public int getTotalNumberOfSequences(int m, int n);

	/* using dp */
	public int getTotalNumberOfSequencesDp(int m, int n);

	/** 32. Longest Common Subsequence **/
	/* using recursive way */
	public int longestCommonSubsequenceRecv(String st1, String st2, int m, int n);

	/* using dynaic programming */
	public int longestCommonSubsequenceDynamic(char[] ch1, char[] ch2, int m, int n);

	/** 33. Longest Repeated Subsequence */
	public String longestRepeatedSubsequenceDynamic(String st);

	/** 34. Longest Increasing Subsequence **/
	/* by iterative way */
	public List<Integer> longestIncreasingSubsequenceItr(int arr[], int n);

	/* by dynamic programming */
	public int longestIncreasingSubsequenceDynamic(int arr[], int n);

	/** 35. A Space Optimized Solution of LCS **/
	public int spaceOptimizedLongestCommonSubsequence(String X, String Y);

	/** 36. LCS (Longest Common Subsequence) of three strings **/
	public int lcsOf3(String X, String Y, String Z, int m, int n, int o);

	/** 37. Maximum sum Bi-tonic Sub-sequence **/
	public int MaxSumBS(int arr[], int n);

	/** 38. Maximum Sum Increasing Subsequence **/
	public int maxSumIncreasingSubseq(int a[], int n);

	/** 39. Maximum product of an increasing subsequence **/
	public int maxProductIncreasingSubseq(int a[], int n);

	/** 40. Count all subsequences having product less than K **/
	public int productSubSeqCount(ArrayList<Integer> arr, int k);

	/** 41. Maximum subsequence sum such that no three are consecutive **/
	public int maxSumWO3Consec(int arr[], int n);

	/** 42. Longest subsequence such that difference between adjacents is one **/
	public int longestSubseqAdjDiffIsOne(int a[]);

	/**
	 * 43. Maximum length subsequence with difference between adjacent elements as
	 * either 0 or 1
	 **/
	public int longestSubseqAdjDiffIsOneOrZero(int a[]);

	/**
	 * 44. Maximum sum increasing subsequence from a prefix and a given element
	 * after prefix is must
	 **/
	public int preCompute(int a[], int n, int index, int k);

	/** 45. Maximum Length Chain of Pairs **/
	public int maxChainLength(Pair arr[], int n);

	/** 46. Print Maximum Length Chain of Pairs **/
	public List<Pair> printMaxChainLength(Pair arr[], int n);

	/** 47. Path with maximum average value **/
	public List<Integer> maxAverageValuePath(int a[][], int n);

	/** 48. Maximum games played by winner **/
	public int maxGameByWinner(int N);

	/** 49. Maximum path sum in a triangle **/
	public int maxPathSum(int tri[][], int m, int n);

	/** 50. Minimum Sum Path in a Triangle **/
	public int minSumPath(int A[][]);

	/**51.	Maximum sum of a path in a Right Number Triangle**/
	public int maxSumPathRightNumTringleRec(int tr[][], int i,int j);
	public int maxSumPathRightNumTringle(int tr[][], int i,int j,int dp[][]);

	/*52.	Size of The Subarray With Maximum Sum, max sum continuous array*/
	public int maxLexSubArrayOfMaxSum(int a[]);

	/*53.	Maximum sum of pairs with specific difference*/
	public int maxSumPairsOnKDiff(int a[], int k);

	/*54.	Maximum size square sub-matrix with all 1s*/
	public int[][] maxSquareSubMatrix(int a[][]);

	/*55.	Maximum number of segments of lengths a, b and c*/
	public int maxNoOfSegment(int n , int a, int b, int c);
	/*********************************************************************************************************************************************************************/

	/** 5. Largest Sum Contiguous Subarray **/
	/* by iterative */
	public int LargestSumContiguousSubarrayItr(int a[]);

	/* by dynamic programming */
	public int LargestSumContiguousSubarrayDynamic(int a[]);

	/** max suqure sub matrix whouse corner is x **/
	// TODO
	public int maxSqureOfXCorenr(int a[][], int x);

	/** 9. Min Cost Path **/
	/* by recursive way */
	public int minCostPathRecursive(int mcp[][], int m, int n);

	/* by dynamic programming */
	public int minCostPathDynamic(int cost[][], int m, int n);

}
