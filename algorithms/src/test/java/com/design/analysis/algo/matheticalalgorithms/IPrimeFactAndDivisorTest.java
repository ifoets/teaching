package com.design.analysis.algo.matheticalalgorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPrimeFactAndDivisorTest {

	IPrimeFactAndDivisor ifd = null;

	@Before
	public void init() {
		ifd = new PrimeFactAndDivisorImpl();
	}

	/** 1. Prime factors **/
	@Test
	public void primeFactorsTest() {
		List<Integer> list = ifd.primeFactors(315);
		System.out.println(Arrays.toString(list.toArray()));
	}

	/** 2. Smith Numbers **/
	@Test
	public void isSmithNumberTest() {
		Assert.assertTrue(ifd.isSmithNumber(4));
		Assert.assertTrue(ifd.isSmithNumber(666));
		Assert.assertTrue(!ifd.isSmithNumber(6));
	}

	/** 3. Sphenic Number **/
	@Test
	public void isSphenicNumberTest() {

		int a[] = { 19, 20, 75, 30, 42, 66, 70, 78, 102, 105, 110, 114 };
		for (int i = 0; i < a.length; i++) {
			if (i < 3)
				Assert.assertTrue(!ifd.isSphenicNumber(a[i]));
			else
				Assert.assertTrue(ifd.isSphenicNumber(a[i]));
		}
	}

	/** 4. Hoax Number **/
	@Test
	public void hoaxNumberTest() {
		Assert.assertTrue(ifd.hoaxNumber(22));
		Assert.assertTrue(ifd.hoaxNumber(84));
		Assert.assertTrue(!ifd.hoaxNumber(19));
	}

	/** 7. Prime Factorization using Sieve O(log n) for multiple queries **/
	@Test
	public void primeFactorizationTest() {
		List<Integer> list = ifd.primeFactorization(12246);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
