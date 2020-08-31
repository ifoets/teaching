package com.design.analysis.hackerrank.algo.easy.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IEasyWarmupTest {

	IEasyWarmup iew = null;

	@Before
	public void init() {
		iew = new EasyWarmupImpl();
	}

	/** Compare the Triplets **/
	@Test
	public void compareTripletsTest() {
		List<Integer> al = Arrays.asList(new Integer[] { 5, 6, 7 });
		List<Integer> bl = Arrays.asList(new Integer[] { 3, 6, 10 });
		List<Integer> erlL = Arrays.asList(new Integer[] { 1, 1 });
		List<Integer> rL = iew.compareTriplets(al, bl);
		Assert.assertTrue(rL.get(0) == erlL.get(0) && rL.get(1) == erlL.get(1));
	}

	/** A Very Big Sum **/
	@Test
	public void aVeryBigSumTest() {
		long ar[] = { 1000000001l, 1000000002l, 1000000003l, 1000000004l, 1000000005l };
		Assert.assertTrue(iew.aVeryBigSum(ar) == 5000000015l);
	}

	/** Diagonal Difference [n][m] */
	@Test
	public void diagonalDifferenceTest() {
		Integer a[] = new Integer[] { 11, 2, 4 };
		Integer b[] = new Integer[] { 4, 5, 6 };
		Integer c[] = new Integer[] { 10, 8, -12 };
		List<List<Integer>> ll = new ArrayList<List<Integer>>();
		ll.add(new ArrayList<>(Arrays.asList(a)));
		ll.add(new ArrayList<>(Arrays.asList(b)));
		ll.add(new ArrayList<>(Arrays.asList(c)));
		Assert.assertTrue(iew.diagonalDifference(ll) == 15);
	}
}
