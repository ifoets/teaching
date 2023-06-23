package com.design.analysis.algo.creativity;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class IArrayCreativityTest {

	private IArrayCreativity irc = null;

	@Before
	public void init() {
		irc = new ArrayCreativityImpl();
	}

	/** 1. Find the Diff of KthMax-KthMin from Unique element of array **/
	@Test
	public void DiffOfKtheMaxMinTest() {

		int a[] = { 9, 1, 8, 2, 7, 3, 6, 4, 5 };
		assertTrue(irc.DiffOfKtheMaxMin(a, 4) == 2);
		assertTrue(irc.DiffOfKtheMaxMin(a, 3) == 4);
		assertTrue(irc.DiffOfKtheMaxMin(a, 1) == 8);
	}

	/**
	 * print the array such a ways if less than 100 then add to first less 100 till
	 * it not meet to -ve
	 **/
	// exint a[] = { 200, 6, 36, 612, 121, 66, 63, 39, 661, 106, -1 };
	/*
	 * print 200 42 612 121 168 661 106
	 */
	@Test
	public void processTest() {
		int a[] = { 200, 6, 36, 612, 121, 66, 63, 39, 661, 106, -1 };
		int n = irc.process(a);
		for (int i = 0; i < n; i++)
			System.out.print(a[i] + ", ");
	}

	/**
	 * Sort two array sorted or non sorted such a ways first all contain all less
	 * element than 2nd array
	 **/
	@Test
	public void sortTwoArrayTest() {

		int a[] = { 2, 4, 6, 8 };
		int b[] = { 1, 3, 5, 7, 9 };
		irc.sortTwoArray(a, b);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
	}
}
