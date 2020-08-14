package com.design.analysis.company.operativemedia;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IOperativeMediaTest {

	public IOperativeMedia iom = null;

	@Before
	public void init() {
		iom = new OperativeMediaImpl();
	}

	/** find the repetative element **/
	@Test
	public void indexOfRepetativeElemTest() {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4 };
		Assert.assertTrue(iom.indexOfRepetativeElem(a, 0, a.length - 1) == 8);

		int b[] = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		Assert.assertTrue(iom.indexOfRepetativeElem(b, 0, b.length - 1) == 5);
	}
}
