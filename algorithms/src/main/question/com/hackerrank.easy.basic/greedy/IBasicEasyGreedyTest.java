package com.hackerrank.ps.basic.easy.greedy;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBasicEasyGreedyTest {

	IBasicEasyGreedy ibg;

	@Before
	public void init() {
		ibg = new BasicEasyGreedyImpl();
	}

	/* Minimum Absolute Difference in an Array */
	@Test
	public void minimumAbsoluteDifferenceTest() {
		Assert.assertTrue(ibg.minimumAbsoluteDifference(List.of(3, -7, 0)) == 3);
	}

	/* Marc's Cakewalk */
	@Test
	public void marcsCakewalkTest() {
		Assert.assertTrue(ibg.marcsCakewalk(List.of(7, 4, 9, 6)) == 79);
	}

	/* Grid Challenge */
	@Test
	public void gridChallengeTest() {
		Assert.assertTrue(ibg.gridChallenge(List.of("ebacd", "fghij", "olmkn", "trpqs", "xywuv")) == "YES");
		Assert.assertTrue(ibg.gridChallenge(List.of("kc", "iu")) == "YES");
		Assert.assertTrue(ibg.gridChallenge(List.of("1", "l")) == "YES");
	}

	/* Luck Balance */
	@Test
	public void luckBalanceTest() {
		List<List<Integer>> ll = new ArrayList<>();
		int a[][] = { { 4, 0 }, { 1, 1 }, { 5, 1 } };
		for (int i = 0; i < 3; i++) {
			List<Integer> l = new ArrayList<>();
			l.add(a[i][0]);
			l.add(a[i][1]);
			ll.add(l);
		}
		Assert.assertTrue(ibg.luckBalance(2, ll) == 10);
		List<List<Integer>> ll1 = new ArrayList<>();
		int b[][] = { { 5, 1 }, { 2, 1 }, { 1, 1 }, { 8, 1 }, { 10, 0 }, { 5, 0 } };
		for (int i = 0; i < 6; i++) {
			List<Integer> l = new ArrayList<>();
			l.add(b[i][0]);
			l.add(b[i][1]);
			ll1.add(l);
		}
		Assert.assertTrue(ibg.luckBalance(3, ll1) == 29);
	}

	/* Maximum Perimeter Triangle */
	@Test
	public void maximumPerimeterTriangleTest() {
		List<Integer> result = ibg.maximumPerimeterTriangle(List.of(1, 2, 3, 4, 5, 10));
		System.out.println(result);
	}

	/* Priyanka and Toys */
	@Test
	public void toysTest() {
		Assert.assertTrue(ibg.toys(List.of(1, 2, 3, 21, 7, 12, 14, 21)) == 4);
	}

	/* Largest Permutation */
	@Test
	public void largestPermutationTest() {
		List<Integer> result = ibg.largestPermutation(1, List.of(2, 1));
		System.out.println(result);
		List<Integer> result1 = ibg.largestPermutation(1, List.of(4, 2, 3, 5, 1));
		System.out.println(result1);
	}

	/* Mark and Toys */
	@Test
	public void maximumToysTest() {
		Assert.assertTrue(ibg.maximumToys(List.of(1, 12, 5, 111, 200, 1000, 10), 50) == 4);
	}

	/* Beautiful Pairs */
	@Test
	public void beautifulPairsTest() {
		 Assert.assertTrue(ibg.beautifulPairs(List.of(3, 5, 7, 11, 5, 8), List.of(5,
		 7, 11, 10, 5, 8)) == 6);
		Assert.assertTrue(ibg.beautifulPairs(List.of(1, 2, 3, 4), List.of(1, 2, 3, 3)) == 4);
	}
}
