package com.hackerrank.ps.basic.easy.search;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBasicEasySearchTest {

	IBasicEasySearch ibs;

	@Before
	public void init() {
		ibs = new BasicEasySearchImpl();
	}

	/* Missing Numbers */
	@Test
	public void missingNumbersTest() {

		List<Integer> rList = ibs.missingNumbers(List.of(203, 204, 205, 206, 207, 208, 203, 204, 205, 206),
				List.of(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204));
		System.out.println(rList);
	}

	/* Sherlock and Array */
	@Test
	public void balancedSumsTest() {
		Assert.assertTrue(ibs.balancedSums(List.of(5, 6, 8, 11))=="YES");
		Assert.assertTrue(ibs.balancedSums(List.of(2,0,0,0))=="YES");
		Assert.assertTrue(ibs.balancedSums(List.of(1,2,3))=="NO");
	}
}
