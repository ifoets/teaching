package com.design.analysis.core.algo.backtracking;

import org.junit.Before;
import org.junit.Test;

public class IBackTrackingMiscTest {

	public IBackTrackingMisc ibtm = null;

	@Before
	public void init() {
		ibtm = new BackTrackingMiscImpl();
	}

	/** 1. Tug of War **/
	@Test
	public void turofWarTest() {
		int a[] = { 3, 4, 5, -3, 100, 1, 89, 54, 23, 20 };
		ibtm.turofWar(a);
	}
}
