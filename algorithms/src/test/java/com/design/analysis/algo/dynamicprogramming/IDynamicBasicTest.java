package com.design.analysis.algo.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algo.dynamicprogramming.model.Pair;

/*
 * 
 * @author GuruG
 */
public class IDynamicBasicTest {

	public IDynamicBasic idb = null;

	@Before
	public void init() {
		idb = new DynamicBasicImpl();
	}

	/** 1. Ugly numbers **/
	/* This function divides a by greatest divisible power of b */
	@Test
	public void maxDivideTest() {

		Assert.assertTrue(idb.maxDivide(16, 2) == 1);
		Assert.assertTrue(idb.maxDivide(125, 5) == 1);
		Assert.assertTrue(idb.maxDivide(27, 3) == 1);
		Assert.assertTrue(idb.maxDivide(18, 2) == 9);
		Assert.assertTrue(idb.maxDivide(12, 5) == 12);
		Assert.assertTrue(idb.maxDivide(8, 3) == 8);
	}

	/* check the no is ugly or not */
	@Test
	public void isUglyTest() {
		Assert.assertTrue(idb.isUgly(15));
		Assert.assertTrue(!idb.isUgly(31));
		Assert.assertTrue(idb.isUgly(1500));
		Assert.assertTrue(!idb.isUgly(151));
		Assert.assertTrue(!idb.isUgly(1511));
		Assert.assertTrue(!idb.isUgly(99));

	}

	/* get nth ugly no */
	@Test
	public void nthUgalyNumberTest() {
		Assert.assertTrue(idb.nthUgalyNumber(7) == 8);
		Assert.assertTrue(idb.nthUgalyNumber(10) == 12);
		Assert.assertTrue(idb.nthUgalyNumber(15) == 24);
	}

	/** 2. Fibonacci numbers **/
	/* by using dynamic programming */
	@Test
	public void nthFibNoDynamicTest() {

		Assert.assertTrue(idb.nthFibNoDynamic(9) == 34);
	}

	/* by recursive way */
	@Test
	public void nthFibNoRecursiveTest() {
		Assert.assertTrue(idb.nthFibNoRecursive(9) == 34);
	}

	/* by using minimum space */
	@Test
	public void nthFibNoMinSpaceUseTest() {
		Assert.assertTrue(idb.nthFibNoMinSpaceUse(9) == 34);
	}

	/** 3. nth Catalan Number **/
	@Test
	public void catalanTest() {

		int a[] = { 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862 };
		for (int i = 0; i < 10; i++)
			Assert.assertTrue(idb.catalan(i) == a[i]);
	}

	/* using dp */
	@Test
	public void catalanDPTest() {
		int a[] = { 1, 2, 5, 14, 42, 132, 429, 1430, 4862 };
		for (int i = 1; i < 10; i++)
			Assert.assertTrue(idb.catalanDP(i) == a[i - 1]);
	}

	/* Using Binomial Coefficient */
	@Test
	public void catalanByBinomicalCoeffTest() {
		int a[] = { 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862 };
		for (int i = 0; i < 10; i++)
			Assert.assertTrue(idb.catalanByBinomicalCoeff(i) == a[i]);
	}

	/** 4. Bell Numbers (Number of ways to Partition a Set) **/
	@Test
	public void bellNumberTest() {

		idb.bellNumber(3);
		/*int bn[] = { 1, 1, 2, 5, 15, 52 };
		for (int i = 0; i < bn.length; i++)
			Assert.assertTrue(idb.bellNumber(i) == bn[i]);*/
	}

	/** 5. Binomial Coefficient **/
	@Test
	public void binomialCoeffTest() {
		Assert.assertTrue(idb.binomialCoeff(4, 2) == 6);
		Assert.assertTrue(idb.binomialCoeff(5, 2) == 10);

	}

	@Test
	public void binomialCoeffDpTest() {
		Assert.assertTrue(idb.binomialCoeffDp(4, 2) == 6);
		Assert.assertTrue(idb.binomialCoeffDp(5, 2) == 10);
	}

	/** 6.Permutation Coefficient **/
	@Test
	public void permutationCoefficientTest() {
		Assert.assertTrue(idb.permutationCoefficient(10, 2) == 90);
	}

	/** 7. Tiling Problem **/ // bord 2*n and tiles 2*1
	@Test
	public void tillingProblemTest() {
		Assert.assertTrue(idb.tillingProblem(4) == 5);
		Assert.assertTrue(idb.tillingProblem(5) == 8);
	}

	/** 8. Gold Mine Problem **/
	@Test
	public void goldMineProblemTest() {

		int mat1[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		idb.goldMineProblem(mat1);
		Assert.assertTrue(idb.goldMineProblem(mat1) == 16);

		int mat2[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2 } };
		Assert.assertTrue(idb.goldMineProblem(mat2) == 16);

		int mat3[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0, 6, 14, 2 } };
		Assert.assertTrue(idb.goldMineProblem(mat3) == 83);
	}

	/** 9. Min Cost Path **/
	/* by recursive way */
	@Test
	public void minCostPathRecursiveTest() {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		Assert.assertTrue(idb.minCostPathRecursive(cost, cost.length - 1, cost[0].length - 1) == 8);
	}

	/** 10. Friends Pairing Problem **/
	@Test
	public void countFriendsPairingsTest() {
		Assert.assertTrue(idb.countFriendsPairings(4) == 10);
	}

	/** 11. Subset Sum Problem **/
	@Test
	public void isSubsetSumRcvTest() {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		Assert.assertTrue(idb.isSubsetSumRcv(set, set.length, 9));
	}

	@Test
	public void isSubsetSumDpTest() {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		Assert.assertTrue(idb.isSubsetSumDp(set, set.length, 9));
	}

	/** 12. Subset Sum Problem in O(sum) space **/
	@Test
	public void isSubsetSumTest() {
		int set[] = { 1, 10, 4, 12, 5, 2 };
		int rs[] = { 9, 17, 1, 6, 8 };
		for (int i = 0; i < rs.length; i++)
			Assert.assertTrue(idb.isSubsetSum(set, set.length, rs[i]));
	}

	/** 13. Subset with sum divisible by m **/
	@Test
	public void modularSumTest() {
		int a[] = { 3, 1, 7, 5 };
		Assert.assertTrue(idb.modularSum(a, a.length, 6) == true);

		int b[] = { 1, 6 };
		Assert.assertTrue(idb.modularSum(a, b.length, 5) == false);
	}

	/** 14. Largest divisible pairs subset **/
	@Test
	public void largestDivisiblePairSubsetDpTest() {
		int a[] = { 10, 5, 3, 15, 20 };
		Assert.assertTrue(idb.largestDivisiblePairSubsetDp(a) == 3);
		int b[] = { 18, 1, 3, 6, 13, 17 };
		Assert.assertTrue(idb.largestDivisiblePairSubsetDp(b) == 4);
	}

	@Test
	public void largestDivisiblePairSubsetTest() {
		int a[] = { 10, 5, 3, 15, 20 };
		Assert.assertTrue(idb.largestDivisiblePairSubset(a) == 3);
		int b[] = { 18, 1, 3, 6, 13, 17 };
		Assert.assertTrue(idb.largestDivisiblePairSubset(b) == 4);
	}

	/** 15. Perfect Sum Problem (Print all subsets with given sum) **/
	@Test
	public void subsetsOfGivenSumTest() {
		// TODO
	}

	@Test
	public void nCrModpTest() {
		int n = 10, r = 2, p = 13;
		Assert.assertTrue(idb.nCrModp(n, r, p) == 6);
	}

	/** 17. Choice of area **/
	// TODDO
	/** 18. Cutting a Rod **/
	@Test
	public void cutRodRcvTest() {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		Assert.assertTrue(idb.cutRodRcv(arr, arr.length) == 22);
	}

	@Test
	public void cutRoDpTest() {
		int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
		Assert.assertTrue(idb.cutRoDp(arr, arr.length) == 22);
	}

	/** 19. Tiling with Dominoes **/
	@Test
	public void tillingDominoesTest() {

		Assert.assertTrue(idb.tillingDominoes(8) == 153);
	}

	/** 20. Painting Fence Algorithm **/
	@Test
	public void paintingFenceTest() {
		Assert.assertTrue(idb.paintingFence(3, 2) == 6);
	}
	
	@Test
	public void paintingFenceXTest() {
		Assert.assertTrue(idb.paintingFenceX(3, 2) == 6);
	}

	/** 21. Newman–Shanks–Williams prime **/
	@Test
	public void newmanShanksWilliamsPrimeTest() {
		Assert.assertTrue(idb.newmanShanksWilliamsPrime(3) == 7);
	}

	@Test
	public void newmanShanksWilliamsPrimeDpTest() {
		Assert.assertTrue(idb.newmanShanksWilliamsPrimeDp(3) == 7);
	}

	/** 22. Assembly line scheduling **/
	@Test
	public void carAssemblyTest() {
		int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
		int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
		int e[] = { 10, 12 }, x[] = { 18, 7 };

		Assert.assertTrue(idb.carAssembly(a, t, e, x) == 35);
	}

	/** 23. Golomb sequence **/
	@Test
	public void printGolombTest() {
		List<Integer> rl = idb.printGolomb(10);
		System.out.println(Arrays.asList(rl));
	}

	/** 24. Moser-de Bruijn Sequence **/
	@Test
	public void moserDeBruijnSequenceTest() {
		System.out.println(Arrays.toString(idb.moserDeBruijnSequence(15)));
	}

	/** 25. Newman-Conway Sequence **/
	@Test
	public void newmanConwaySequenceTest() {
		Assert.assertTrue(idb.newmanConwaySequence(10) == 6);
	}

	@Test
	public void newmanConwaySequenceDpTest() {
		Assert.assertTrue(idb.newmanConwaySequenceDp(10) == 6);
	}

	/** 26. Find maximum length Snake sequence **/
	@Test
	public void maxLenSnakeSequenceTest() {
		int mat[][] = { { 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 }, };

		List<Integer> list = idb.maxLenSnakeSequence(mat);
		Assert.assertTrue(list.size() == 7);
		System.out.println(idb.maxLenSnakeSequence(mat));
	}

	/** 27. Print n terms of Newman-Conway Sequence **/
	// @See 25.
	/** 28. Print Fibonacci sequence using 2 variables **/
	@Test
	public void fibTest() {
		idb.fib(10);
	}

	/** 29. Print Fibonacci Series in reverse order **/
	@Test
	public void reverseFibonacciTest() {
		idb.reverseFibonacci(10);
	}

	/**
	 * 30. Count even length binary sequences with same sum of first and second half
	 * bits
	 **/
	@Test
	public void countSeqTest() {
		Assert.assertTrue(idb.countSeq(2, 0) == 6);
	}

	@Test
	public void countSeqDpTest() {
		Assert.assertTrue(idb.countSeqDp(2, 0) == 6);
	}

	@Test
	public void countSeqRecTest() {
		Assert.assertTrue(idb.countSeqRec(2) == 6);
	}

	/**
	 * 31. Sequences of given length where every element is more than or equal to
	 * twice of previous
	 **/
	@Test
	public void getTotalNumberOfSequencesTest() {
		Assert.assertTrue(idb.getTotalNumberOfSequences(10, 4) == 4);
	}

	/* using dp */
	@Test
	public void getTotalNumberOfSequencesDpTest() {
		Assert.assertTrue(idb.getTotalNumberOfSequencesDp(10, 4) == 4);
	}

	/** 32. Longest Common Subsequence **/
	/* using recursive way */
	@Test
	public void longestCommonSubsequenceRecvTest() {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		Assert.assertTrue(idb.longestCommonSubsequenceRecv(str1, str2, str1.length(), str2.length()) == 4);
	}

	/* using dynaic programming */
	@Test
	public void longestCommonSubsequenceDynamicTest() {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		Assert.assertTrue(idb.longestCommonSubsequenceDynamic(str1.toCharArray(), str2.toCharArray(), str1.length(),
				str2.length()) == 4);
	}

	/** 33. Longest Repeated Subsequence */
	@Test
	public void longestRepeatedSubsequenceDynamicTest() {
		String str = "AABEBCDD";
		Assert.assertTrue(idb.longestRepeatedSubsequenceDynamic(str).equals("ABD"));
	}

	/** 34. Longest Increasing Subsequence **/
	/* by iterative way */
	@Test
	public void longestIncreasingSubsequenceItrTest() {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		List<Integer> list = idb.longestIncreasingSubsequenceItr(arr, arr.length);
		// System.out.println(Arrays.toString(list.toArray()));
		Assert.assertTrue(list.size() == 5);
	}

	/* by dynamic programming */
	@Test
	public void longestIncreasingSubsequenceDynamicTest() {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		Assert.assertTrue(idb.longestIncreasingSubsequenceDynamic(arr, arr.length) == 5);
	}

	/** 35. A Space Optimized Solution of LCS **/
	@Test
	public void spaceOptimizedLongestCommonSubsequenceTest() {
		String str1 = "AGGTAB";
		String str2 = "GXTXAYB";
		Assert.assertTrue(idb.spaceOptimizedLongestCommonSubsequence(str1, str2) == 4);
	}

	/** 36. LCS (Longest Common Subsequence) of three strings **/
	@Test
	public void lcsOf3Test() {
		String X = "AGGT12";
		String Y = "12TXAYB";
		String Z = "12XBA";

		int m = X.length();
		int n = Y.length();
		int o = Z.length();
		Assert.assertTrue(idb.lcsOf3(X, Y, Z, m, n, o) == 2);
	}

	/** 37. Maximum sum Bi-tonic Sub-sequence **/
	@Test
	public void MaxSumBSTest() {
		int arr[] = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };
		Assert.assertTrue(idb.MaxSumBS(arr, arr.length) == 194);
	}

	/** 38. Maximum Sum Increasing Subsequence **/
	@Test
	public void maxSumIncreasingSubseqTest() {
		int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		Assert.assertTrue(idb.maxSumIncreasingSubseq(arr, n) == 106);
	}

	/** 39. Maximum product of an increasing subsequence **/
	@Test
	public void maxProductIncreasingSubseqTest() {
		int[] arr = { 3, 100, 4, 5, 150, 6 };
		int n = arr.length;
		Assert.assertTrue(idb.maxProductIncreasingSubseq(arr, n) == 45000);
	}

	/** 40. Count all subsequences having product less than K **/
	@Test
	public void productSubSeqCountTest() {
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(1);
		A.add(2);
		A.add(3);
		A.add(4);
		int k = 10;
		Assert.assertTrue(idb.productSubSeqCount(A, k) == 11);
	}

	/** 41. Maximum subsequence sum such that no three are consecutive **/
	@Test
	public void maxSumWO3ConsecTest() {
		int arr[] = { 100, 1000, 100, 1000, 1 };
		int n = arr.length;
		Assert.assertTrue(idb.maxSumWO3Consec(arr, n) == 2101);
	}

	/** 42. Longest subsequence such that difference between adjacents is one **/
	@Test
	public void longestSubseqAdjDiffIsOneTest() {
		int a[] = { 10, 9, 4, 5, 4, 8, 6 };
		Assert.assertTrue(idb.longestSubseqAdjDiffIsOne(a) == 3);
		int b[] = { 1, 2, 3, 2, 3, 7, 2, 1 };
		Assert.assertTrue(idb.longestSubseqAdjDiffIsOne(b) == 7);
	}

	/**
	 * 43. Maximum length subsequence with difference between adjacent elements as
	 * either 0 or 1
	 **/
	@Test
	public void longestSubseqAdjDiffIsOneOrZeroTest() {
		int a[] = { 2, 5, 6, 3, 7, 6, 5, 8 };
		Assert.assertTrue(idb.longestSubseqAdjDiffIsOneOrZero(a) == 5);
		int b[] = { -2, -1, 5, -1, 4, 0, 3 };
		Assert.assertTrue(idb.longestSubseqAdjDiffIsOneOrZero(b) == 4);
	}

	/**
	 * 44. Maximum sum increasing subsequence from a prefix and a given element
	 * after prefix is must
	 **/
	@Test
	public void preComputeTest() {
		int a[] = { 1, 101, 2, 3, 100, 4, 5 };
		int n = a.length;
		int index = 4, k = 6;
		Assert.assertTrue(idb.preCompute(a, n, index, k) == 11);
	}

	/** 45. Maximum Length Chain of Pairs **/
	@Test
	public void maxChainLengthTest() {
		Pair arr[] = new Pair[] { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
		Assert.assertTrue(idb.maxChainLength(arr, arr.length) == 3);
	}

	/** 46. Print Maximum Length Chain of Pairs **/
	@Test
	public void printMaxChainLengthTest() {
		Pair a[] = { new Pair(5, 29), new Pair(39, 40), new Pair(15, 28), new Pair(27, 40), new Pair(50, 90) };
		List<Pair> rl = idb.printMaxChainLength(a, a.length);
		for (Pair p : rl)
			System.out.println(p);
	}

	/** 47. Path with maximum average value **/
	@Test
	public void maxAverageValuePathTest() {
		int cost[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(idb.maxAverageValuePath(cost, cost.length));
	}

	/** 48. Maximum games played by winner **/
	@Test
	public void maxGameByWinnerTest() {
		Assert.assertTrue(idb.maxGameByWinner(10) == 4);
	}

	/** 49. Maximum path sum in a triangle **/
	@Test
	public void maxPathSumTest() {
		int tri[][] = { { 3, 0, 0, 0 }, { 7, 4, 0, 0 }, { 2, 4, 6, 0 }, { 8, 5, 9, 3 } };
		Assert.assertTrue(idb.maxPathSum(tri, 3, 3) == 23);
	}

	/** 50. Minimum Sum Path in a Triangle **/
	@Test
	public void minSumPathTest() {
		int A[][] = { { 2 }, { 3, 9 }, { 1, 6, 7 } };
		Assert.assertTrue(idb.minSumPath(A) == 6);

	}

	/*********************************************************************************************************************************************************************/

	/** 5. Largest Sum Contiguous Subarray **/
	/* by iterative */
	@Test
	public void LargestSumContiguousSubarrayItrTest() {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		Assert.assertTrue(idb.LargestSumContiguousSubarrayItr(a) == 7);
	}

	/* by dynamic programming */
	@Test
	public void LargestSumContiguousSubarrayDynamicTest() {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		Assert.assertTrue(idb.LargestSumContiguousSubarrayDynamic(a) == 7);
	}

	/** 7. Maximum size square sub-matrix with all 1s **/
	@Test
	public void maxSquareSubMatrixTest() {
		int a[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		a = idb.maxSquareSubMatrix(a);
		Assert.assertTrue(a.length == 3);
		Assert.assertTrue(a[0].length == 3);
		Assert.assertTrue(a[2][2] == 1);
		Assert.assertTrue(a[0][0] == 1);
		Assert.assertTrue(a[1][1] == 1);
	}

	/* by dynamic programming */
	@Test
	public void minCostPathDynamicTest() {
		int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
		Assert.assertTrue(idb.minCostPathDynamic(cost, cost.length - 1, cost[0].length - 1) == 8);
	}

	/** max suqure sub matrix whouse corner is x **/
	@Test
	public void maxSqureOfXCorenrTest() {

		int mat[][] = { { 1, 2, 4, 4, 5 }, { 4, 4, 4, 4, 1 }, { 1, 2, 3, 4, 5 }, { 4, 4, 1, 4, 5 }, { 4, 2, 3, 4, 5 } };
		System.out.println(idb.maxSqureOfXCorenr(mat, 4));
	}

	/** 9. Coin change problem **/
	/* recursive way */
	@Test
	public void noOfWayCoinChangeRecvTest() {

		int a[] = { 1, 2, 3 };
		int b[] = { 2, 5, 3, 6 };
		Assert.assertTrue(idb.noOfWayCoinChangeRecv(a, a.length, 4) == 4);
		Assert.assertTrue(idb.noOfWayCoinChangeRecv(b, b.length, 10) == 5);
	}

	/* by dynamic programming way */
	@Test
	public void noOfWayCoinChangeDynamicTest() {
		int a[] = { 1, 2, 3 };
		int b[] = { 2, 5, 3, 6 };
		Assert.assertTrue(idb.noOfWayCoinChangeDynamic(a, a.length, 4) == 4);
		Assert.assertTrue(idb.noOfWayCoinChangeDynamic(b, b.length, 10) == 5);
	}
}
