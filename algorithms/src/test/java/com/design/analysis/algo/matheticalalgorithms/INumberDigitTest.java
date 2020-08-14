package com.design.analysis.algo.matheticalalgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class INumberDigitTest {
	
	INumberDigit ind = null;

	@Before
	public void init() {
		ind = new NumberDigitImpl();
	}

	/** 1. n-th number whose sum of digits is ten **/
	@Test
	public void nthNoWhoseSumIs10Test() {
		Assert.assertTrue(ind.nthNoWhoseSumIs10(2) == 28);
		Assert.assertTrue(ind.nthNoWhoseSumIs10(5) == 55);
	}
	public static void main(String[] args) {
		
		System.out.println(Math.sqrt(8314));
	}
}
