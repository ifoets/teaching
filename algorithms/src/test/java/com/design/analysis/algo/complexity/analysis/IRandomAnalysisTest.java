package com.design.analysis.algo.complexity.analysis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IRandomAnalysisTest {

	public IRandomAnalysis ira = null;

	@Before
	public void init() {
		ira = new RandomAnalysisImpl();
	}

	/** find the max O(log(n)) in unsorted array */
	@Test
	public void findMaxTest() {
		int a[] = { 1, 9, 2, 8, 3, 7, 4, 6, 5 };
		Assert.assertTrue(ira.findMax(a, 0, a.length - 1) == 10);
	}

	@Test
	public void findMinTest() {
		int a[] = { 1, 9, 2, 8, 3, 7, 4, 6, 0, 5 };
		Assert.assertTrue(ira.findMin(a, 0, a.length - 1) == 0);
	}
}
