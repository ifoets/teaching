package com.design.analysis.core.algo.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.design.analysis.core.algo.dynamicprogramming.model.Chain;
import com.design.analysis.core.algo.dynamicprogramming.model.WtJobScheduling;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IDynamicIntermediateTest {

	public IDynamicIntermediate idi = null;

	@Before
	public void init() {
		idi = new DynamicIntermediateImpl();
	}

	/** 1. Lobb Number **/
	// TODO not understand the the derivation
	/** 2. Eulerian Number **/
	@Test
	public void eulerianTest() {
		Assert.assertTrue(idi.eulerian(3, 3) == 0);
		Assert.assertTrue(idi.eulerian(3, 1) == 4);
		Assert.assertTrue(idi.eulerian(5, 2) == 66);
	}

	/** 3. Delannoy Number **/
	@Test
	public void dealnnoyRecTest() {
		int n = 3, m = 4;
		Assert.assertTrue(idi.dealnnoyRec(m, n) == 129);
	}

	@Test
	public void dealnnoyDpTest() {
		int n = 3, m = 4;
		Assert.assertTrue(idi.dealnnoyDp(m, n) == 129);
	}

	/** 4. Entringer Number **/
	@Test
	public void zigzagRcvTest() {
		int n = 4, k = 3;
		Assert.assertTrue(idi.zigzagRcv(n, k) == 5);
	}

	@Test
	public void zigzagDpTest() {
		int n = 4, k = 3;
		Assert.assertTrue(idi.zigzagDp(n, k) == 5);
	}

	/** 5. Rencontres Number **/

	@Test
	public void rencontresNumberDpTest() {
		int n = 7, m = 2;
		int C[][] = new int[100][100];
		Assert.assertTrue(idi.rencontresNumberDp(C, n, m) == 924);
	}

	/** 6. Jacobsthal and Jacobsthal-Lucas numbers **/
	@Test
	public void JacobsthalTest() {
		Assert.assertTrue(idi.Jacobsthal(5) == 11);
	}

	// Return nth Jacobsthal number.
	@Test
	public void JacobsthalDpTest() {
		Assert.assertTrue(idi.JacobsthalDp(5) == 11);
	}

	// Return nth Jacobsthal-Lucas number.
	@Test
	public void Jacobsthal_LucasDpTest() {
		Assert.assertTrue(idi.Jacobsthal_LucasDp(5) == 31);
	}

	/** 7. Super Ugly Number (Number whose prime factors are in given set) **/
	@Test
	public void nthSuperUglyNumberTest() {
		int primes[] = { 2, 7, 13, 19 };
		int n = 12;
		Assert.assertTrue(idi.nthSuperUglyNumber(n, primes) == 32);
	}

	/** 8. Floyd Warshall Algorithm **/
	final static int INF = 99999, V = 4;

	@Test
	public void floydWarshallTest() {
		int graph[][] = { { 0, 5, INF, 10 }, { INF, 0, 3, INF }, { INF, INF, 0, 1 }, { INF, INF, INF, 0 } };
		idi.floydWarshall(graph);
	}

	/** 9. Bellman Ford Algorithm **/
	// TODO
	/** 1. 0-1 Knapsack Problem **/
	@Test
	public void knapSackTest() {

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		System.out.println(idi.knapSack(W, wt, val, val.length));
	}

	/** 11. Printing Items in 0/1 Knapsack **/
	@Test
	public void printknapSackTest() {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		int n = val.length;

		idi.printknapSack(W, wt, val, n);
	}

	/** 12. Unbounded Knapsack (Repetition of items allowed) **/
	@Test
	public void maxValUnboundedKnapSackTest() {
		int W = 8;
		int val[] = { 10, 40, 50, 70 };
		int wt[] = { 1, 3, 4, 5 };
		Assert.assertTrue(idi.maxValUnboundedKnapSack(val, wt, W) == 110);
	}

	/** 13. Temple Offerings **/
	@Test
	public void templeOfferingsTest() {
		int arr1[] = { 1, 2, 2 };
		Assert.assertTrue(idi.templeOfferings(arr1) == 4);
		int arr2[] = { 1, 4, 3, 6, 2, 1 };
		Assert.assertTrue(idi.templeOfferings(arr2) == 10);
	}

	/** 7. Egg Dropping Puzzle **/
	@Test
	public void eggDropRecTest() {

		int n = 2;
		int k = 10;
		Assert.assertTrue(idi.eggDropRec(n, k) == 4);
	}

	@Test
	public void eggDropDpTest() {

		int n = 5;
		int k = 20;
		Assert.assertTrue(idi.eggDropRec(n, k) == 5);
	}

	/** 15. Dice Throw Problem **/
	@Test
	public void findWaysTest() {
		System.out.println(idi.findWays(4, 4, 5));
	}

	/** 16. Word Break Problem **/
	@Test
	public void isWordBreakInDictRcvTest() {
		String sl[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go",
				"mango" };
		String st1 = "ilike";
		Assert.assertTrue(idi.isWordBreakInDictRcv(sl, st1, 0));

		String st2 = "ilikesamsung";
		Assert.assertTrue(idi.isWordBreakInDictRcv(sl, st2, 0));
		String st3 = "like sam sung";
		Assert.assertTrue(idi.isWordBreakInDictRcv(sl, st3, 0));

		String st4 = "ice cream go";
		Assert.assertTrue(!idi.isWordBreakInDictRcv(sl, st4, 0));
	}

	@Test
	public void isWordBreakInDictTest() {
		String sl[] = { "i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go",
				"mango" };
		String st1 = "ilike";
		Assert.assertTrue(idi.isWordBreakInDict(sl, st1));

		String st2 = "ilikesamsung";
		Assert.assertTrue(idi.isWordBreakInDict(sl, st2));
		String st3 = "like sam sung";
		Assert.assertTrue(idi.isWordBreakInDict(sl, st3));

		String st4 = "ice cream go";
		Assert.assertTrue(!idi.isWordBreakInDict(sl, st4));
	}

	/** 17. Vertex Cover Problem **/
	// TODO
	/** 18. Tile Stacking Problem **/
	@Test
	public void tileStackingProblmTest() {
		int n = 2;
		int m = 3;
		int k = 3;
		System.out.println(idi.tileStackingProblm(n, m, k));
	}

	/** 19. Box-Stacking Problem **/
	@Test
	public void boxStackingProblemTest() {

	}

	/*****************************************************************************************************************************************************************/

	/* 2. Length of the longest substring without repeating characters */
	@Test
	public void longestSubStringTest() {
		String str = "abcdab";
		Assert.assertTrue(idi.longestSubString(str).equals("abcd"));
		String str1 = "aabcdaefghijk";
		Assert.assertTrue(idi.longestSubString(str1).equals("bcdaefghijk"));
	}

	/** 3. Count number of ways to reach destination in a Maze **/
	@Test
	public void noOfWayReachDestnInMazeTest() {
		int a[][] = { { 0, 0, 0, 0 }, { 0, -1, 0, 0 }, { -1, 0, 0, 0 }, { 0, 0, 0, 0 } };
		Assert.assertTrue(idi.noOfWayReachDestnInMaze(a) == 4);
	}

	/** 4. Super Ugly Number (Number whose prime factors are in given set) **/
	@Test
	public void superUglyNoPrimeFactInGivenSetTest() {

		int primes1[] = { 2, 5 };
		int n1 = 5;
		Assert.assertTrue(idi.superUglyNoPrimeFactInGivenSet(primes1, n1) == 8);
		int primes2[] = { 2, 3, 5 };
		int n2 = 50;
		Assert.assertTrue(idi.superUglyNoPrimeFactInGivenSet(primes2, n2) == 243);
		int primes3[] = { 3, 5, 7, 11, 13 };
		int n3 = 9;
		Assert.assertTrue(idi.superUglyNoPrimeFactInGivenSet(primes3, n3) == 21);
	}

	/** 5. Count number of ways to partition a set into k subsets **/

	/* recursive way */
	@Test
	public void noOfWayKPartitionNNumsRecTest() {
		int a[] = { 1, 2, 3 };
		int k = 2;
		Assert.assertTrue(idi.noOfWayKPartitionNNumsRec(a, k) == 3);
	}

	/* using dp */
	@Test
	public void noOfWayKPartitionNNumsDpTest() {
		int a[] = { 1, 2, 3 };
		int k = 2;
		Assert.assertTrue(idi.noOfWayKPartitionNNumsDp(a, k) == 3);

		int b[] = { 7, 6, 9, 3, 4 };
		int k1 = 3;
		int k2 = 2;
		Assert.assertTrue(idi.noOfWayKPartitionNNumsDp(b, k1) == 10);
		Assert.assertTrue(idi.noOfWayKPartitionNNumsDp(b, k2) == 10);
	}

	/** 6. Longest Palindromic Subsequence **/
	@Test
	public void longestPalindromeRecTest() {
		String str = "BBABCBCAB";
		Assert.assertTrue(idi.longestPalindromeRec(str, 0, str.length() - 1) == 7);
	}

	/* this is smae as palindrome */
	@Test
	public void longestSubsequenceDpTest() {
		String str = "geeksforgeeks";
		String str1 = "BBABCBCAB";
		Assert.assertTrue(idi.longestSubsequenceDp(str) == 5);
		Assert.assertTrue(idi.longestSubsequenceDp(str1) == 7);
		System.out.println(idi.longestSubsequenceDp(str1));
	}

	/* longest subsequence from two strings is simillar prob */
	@Test
	public void longestSubsequenceTest() {
		String str = "geeksforgeeks";
		String st = new StringBuilder(str).reverse().toString();
		String str1 = "BBABCBCAB";
		String st1 = new StringBuilder(str1).reverse().toString();
		Assert.assertTrue(idi.longestSubsequence(str, st) == 5);
		Assert.assertTrue(idi.longestSubsequence(str1, st1) == 7);
	}

	/** 8. Weighted job scheduling **/
	@Test
	public void weightedJobSchedulingTest() {
		List<WtJobScheduling> list = new ArrayList<>();
		list.add(new WtJobScheduling(1, 2, 50));
		list.add(new WtJobScheduling(2, 100, 200));
		list.add(new WtJobScheduling(6, 19, 100));
		list.add(new WtJobScheduling(3, 5, 20));
		Assert.assertTrue(idi.weightedJobScheduling(list) == 250);
	}

	/** 9. Longest Bitonic Subsequence **/
	@Test
	public void longestBitonicSubsequenceDpTest() {

		int a[] = { 1, 11, 2, 10, 4, 5, 2, 1 };
		Assert.assertTrue(idi.longestBitonicSubsequenceDp(a) == 6);
	}

	/** 10. Floyd Warshall Algorithm this is minimum distnce of two node **/
	@Test
	public void floydWarshallAlgoTest() {
		int g[][] = { { 0, 5, -1, 10 }, { -1, 0, 3, -1 }, { -1, -1, 0, 1 }, { -1, -1, -1, 0 } };

		int a[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 2, 3 } };
		int b[] = { 5, 8, 9, 3, 4, 1 };
		int minDist[][] = idi.floydWarshallAlgo(g);

		for (int i = 0; i < minDist.length; i++)
			System.out.println(Arrays.toString(minDist[i]));

		for (int i = 0; i < b.length; i++) {

			Assert.assertTrue(minDist[a[i][0]][a[i][1]] == b[i]);
		}
	}

	/** 11. Partition Problem **/
	@Test
	public void isPrtitionInEqualSumTest() {

		int arr[] = { 3, 1, 1, 2, 2, 1 };
		Assert.assertTrue(idi.isPrtitionInEqualSum(arr));

		int arr1[] = { 1, 5, 11, 5 };
		Assert.assertTrue(idi.isPrtitionInEqualSum(arr1));

		int arr2[] = { 3, 1, 1, 2, 2, 1, 1 };
		Assert.assertTrue(!idi.isPrtitionInEqualSum(arr2));
	}

	/** 12. Variations of LIS **/
	/* Building briedge (max) */
	@Test
	public void maxBriedgeTest() {

		int a[] = { 8, 1, 4, 3, 5, 2, 6, 7 };
		int b[] = { 1, 2, 4, 3, 5, 6, 7, 8 };
		int c[] = { 2, 5, 1, 8, 3 };
		int d[] = { 2, 5, 1, 8, 3 };
		TreeMap<Integer, Integer> tm = idi.maxBriedge(a, b);
		Assert.assertTrue(tm.size() == 5);
		TreeMap<Integer, Integer> tm1 = idi.maxBriedge(c, d);
		Assert.assertTrue(tm1.size() == 3);
	}

	/* maximumn sum of increasing subsequence */
	@Test
	public void maxSumIncreasingSubseqTest() {

		int c[] = { 3, 4, -1, 0, 6, 2, 3 };
		int b[] = { 8, 1, 4, 3, 5, 2, 6, 7 };
		int a[] = { 2, 5, 1, 8, 3 };
		TreeMap<Integer, Integer> tm = idi.maxSumIncreasingSubseq(a);
		int sum = 0;
		for (Entry<Integer, Integer> entry : tm.entrySet())
			sum += entry.getValue();
		Assert.assertTrue(sum == 15);

		tm = idi.maxSumIncreasingSubseq(b);
		sum = 0;
		for (Entry<Integer, Integer> entry : tm.entrySet())
			sum += entry.getValue();
		Assert.assertTrue(sum == 23);

		tm = idi.maxSumIncreasingSubseq(c);
		sum = 0;
		for (Entry<Integer, Integer> entry : tm.entrySet())
			sum += entry.getValue();
		Assert.assertTrue(sum == 13);
	}

	/* longest increasing subsequence */
	@Test
	public void maxIncreasingSubseqTest() {
		int c[] = { 3, 4, -1, 0, 6, 2, 3 };
		int a[] = { 8, 1, 4, 3, 5, 2, 6, 7 };
		int b[] = { 2, 5, 1, 8, 3 };

		Assert.assertTrue(idi.maxIncreasingSubseq(c).size() == 4);
		Assert.assertTrue(idi.maxIncreasingSubseq(a).size() == 5);
		Assert.assertTrue(idi.maxIncreasingSubseq(b).size() == 3);
	}

	/* longest chain by connecting different chain */
	@Test
	public void longestChainConnectTest() {
		int a[][] = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 }, { 50, 90 } };
		int b[][] = { { 5, 24 }, { 27, 40 }, { 50, 90 } };

		int c[][] = { { 11, 20 }, { 10, 40 }, { 45, 60 }, { 39, 40 } };
		int d[][] = { { 11, 20 }, { 39, 40 }, { 45, 60 } };
		List<Chain> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++)
			list.add(new Chain(a[i][0], a[i][1]));

		list = idi.longestChainConnect(list);
		for (int i = 0; i < list.size(); i++)
			Assert.assertTrue(b[i][0] == list.get(i).xi && b[i][1] == list.get(i).xf);

		list = new ArrayList<>();
		for (int i = 0; i < c.length; i++)
			list.add(new Chain(c[i][0], c[i][1]));

		list = idi.longestChainConnect(list);
		for (int i = 0; i < list.size(); i++)
			Assert.assertTrue(d[i][0] == list.get(i).xi && d[i][1] == list.get(i).xf);
	}
}
