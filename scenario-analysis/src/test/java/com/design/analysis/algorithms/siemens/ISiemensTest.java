package com.design.analysis.algorithms.siemens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISiemensTest {

	public ISiemens ism = null;

	@Before
	public void init() {
		ism = new SiemensImpl();
	}

	/**
	 * Find duplicates in a file containing 6 digit numbers (like u id) in O (n)
	 * time.
	 **/
	@Test
	public void findDuplicateInFileTest() throws IOException {
		Assert.assertTrue(ism.findDuplicateInFile() == 123456);
	}

	/** Given an integer N. Convert it into MS Excel column string. **/
	@Test
	public void interToMsExcelColTest() {

		int a[] = { 1, 2, 27, 52 };
		String str[] = { "A", "B", "AA", "AZ" };
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(ism.interToMsExcelCol(a[i]).equals(str[i]));
	}
}
