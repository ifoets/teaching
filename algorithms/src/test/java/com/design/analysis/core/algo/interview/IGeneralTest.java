package com.design.analysis.core.algo.interview;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IGeneralTest {

	public IGeneral ig = null;

	@Before
	public void init() {
		ig = new GeneralImpl();
	}

	/**
	 * given n pillor find how much water trap if raning happen between the pillors
	 **/
	@Test
	public void quantityofWaterTrapTest() {
		int a[] = { 3, 0, 1, 2, 1, 4, 1, 4, 2, 3 };
		Assert.assertTrue(ig.quantityofWaterTrap(a) == 12);
	}

	/** find the max 1 in (0,1) sorted row matrix by O(nlog(n)) comlexity **/
	@Test
	public void findMax1RowTest() {

		int a[][] = { { 0, 0, 1, 1, 1 }, { 0, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 1 } };
		Assert.assertTrue(ig.findMax1Row(a) == 2);
	}
}
