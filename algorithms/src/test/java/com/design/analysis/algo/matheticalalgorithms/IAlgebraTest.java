package com.design.analysis.algo.matheticalalgorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IAlgebraTest {

	public IAlgebra ia = null;

	@Before
	public void init() {
		ia = new AlgebraImpl();
	}

	/** 1. Find x and y satisfying ax + by = n **/
	@Test
	public void findXAndYTest() {
		int a = 2, b = 3, n = 7;
		List<Integer> list = ia.findXAndY(a, b, n);
		Assert.assertTrue(list.get(0) == 2);
		Assert.assertTrue(list.get(1) == 1);
	}

	/** 2. Calculate the Discriminant Value **/
	@Test
	public void discriminantValueTest() {
		Assert.assertTrue(ia.discriminantValue(20, 30, 10) == 100);
	}

	/** 3. Program for dot product and cross product of two vectors **/
	/* dot product */
	@Test
	public void dotProductTest() {
		int vect_A[] = { 3, -5, 4 };
		int vect_B[] = { 2, 6, 5 };
		Assert.assertTrue(ia.dotProduct(vect_A, vect_B) == -4);
	}

	/* cross porduct */
	@Test
	public void crossProductTest() {
		int vect_A[] = { 3, -5, 4 };
		int vect_B[] = { 2, 6, 5 };
		int cross_P[] = new int[3];
		ia.crossProduct(vect_A, vect_B, cross_P);
		System.out.println(Arrays.toString(cross_P));
	}

	/** 5. Program to find correlation coefficient **/
	@Test
	public void correlationCoefficientTest() {
		int X[] = { 15, 18, 21, 24, 27 };
		int Y[] = { 25, 25, 27, 31, 32 };

		// Find the size of array.
		int n = X.length;

		// Function call to correlationCoefficient.
		System.out.printf("%6f", ia.correlationCoefficient(X, Y, n));
	}
}
