package com.design.analysis.algo.matheticalalgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IGcdAndLcmTest {

	public IGcdAndLcm igl = null;

	@Before
	public void init() {
		igl = new GcdAndLcmImpl();
	}

	/** 1. GCD and LCM **/
	@Test
	public void GCDTest() {
		Assert.assertTrue(igl.GCD(15, 20) == 5);
	}

	@Test
	public void LCMTest() {

		Assert.assertTrue(igl.LCM(15, 20) == 60);
	}

	/** 2. LCM of array **/
	@Test
	public void lcmOfArrayTest() {
		int arr[] = { 2, 7, 3, 9, 4 };
		Assert.assertTrue(igl.lcmOfArray(arr) == 252);
	}

	/** 3. GCD of array **/
	@Test
	public void gcdOfArrayTest() {
		int arr[] = { 10, 70, 15, 90, 20 };
		Assert.assertTrue(igl.gcdOfArray(arr) == 5);
	}

	/** 4. Basic and Extended Euclidean algorithms **/
	@Test
	public void gcdTest() {
		Assert.assertTrue(igl.gcd(15, 20) == 5);
	}

	/** 5. Product of given N fractions in reduced form **/
	@Test
	public void productOfNFractionTest() {

		int num[] = { 1, 2, 5 };
		int den[] = { 2, 1, 6 };

		int a[] = igl.productOfNFraction(num, den);
		Assert.assertTrue(a[0] == 5);
		Assert.assertTrue(a[1] == 6);
	}

	/** 6. GCD of two numbers when one of them can be very large **/
	@Test
	public void gcdWithVeryLargeNoTest() {
		int a = 1221;

		// second number is represented as string because
		// it can not be handled by integer data type
		String x = "1234567891011121314151617181920212223242526272829";
		Assert.assertTrue(igl.gcdWithVeryLargeNo(a, x) == 3);
	}

	/** 7. Stein’s Algorithm for finding GCD **/
	/* it is just finding the gcd by different apporach */
	/** 8. GCD, LCM and Distributive Property **/
	/** 9. Replace every matrix element with maximum of GCD of row or column **/
	@Test
	public void gcdlcmAndDistributiveTest() {

		Assert.assertTrue(igl.gcdlcmAndDistributive(15, 20, 100) == 60);
		Assert.assertTrue(igl.gcdlcmAndDistributive(30, 40, 400) == 120);
	}

	@Test
	public void replaceElemByGcdOfRowOrColmTest() {
		int[][] m = { { 1, 2, 3, 3 }, { 4, 5, 6, 6 }, { 7, 8, 9, 9 }, };

		igl.replaceElemByGcdOfRowOrColm(m);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j] + " ");
			System.out.println();
		}
	}

	/** 10. GCD of two numbers formed by n repeating x and y times **/
	@Test
	public void gcdFormByNrepeatinOFXAndYTest() {
		int n = 123, x = 5, y = 2;
		Assert.assertTrue(igl.gcdFormByNrepeatinOFXAndY(n, x, y) == 123);
	}

}
