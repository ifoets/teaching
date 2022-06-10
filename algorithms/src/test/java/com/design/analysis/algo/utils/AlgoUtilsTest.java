package com.design.analysis.algo.utils;

import org.junit.Assert;
import org.junit.Test;

public class AlgoUtilsTest {

	@Test
	public void countSetBitsUtilTest() {
		Assert.assertTrue(AlgoUtils.countSetBitsUtil(7) == 3);
		Assert.assertTrue(AlgoUtils.countSetBitsUtil(16) == 1);
		Assert.assertTrue(AlgoUtils.countSetBitsUtil(15) == 4);
	}

	@Test
	public void numOfDigitTest() {

		Assert.assertTrue(1 == AlgoUtils.numOfDigit(7));
		Assert.assertTrue(2 == AlgoUtils.numOfDigit(10));
		Assert.assertTrue(4 == AlgoUtils.numOfDigit(7109));
		Assert.assertTrue(5 == AlgoUtils.numOfDigit(19087));
	}

	@Test
	public void numOfDigitInArrayTest() {
		int a1[] = new int[10];
		a1[0] = 1;
		a1[1] = 2;

		int b1[] = new int[10];
		b1[0] = 1;
		b1[1] = 1;
		b1[2] = 3;

		int c[] = new int[10];
		Assert.assertTrue(2 == AlgoUtils.numOfDigitInArray(a1));
		Assert.assertTrue(3 == AlgoUtils.numOfDigitInArray(b1));
		Assert.assertTrue(0 == AlgoUtils.numOfDigitInArray(c));

		int a[] = { 1, 2, 3, 4, 5 };
		Assert.assertTrue(5 == AlgoUtils.numOfDigitInArray(a));

	}

	@Test
	public void precedenceTest() {
		Assert.assertTrue(AlgoUtils.precedence('*') == 2);
		Assert.assertTrue(AlgoUtils.precedence('+') == 1);
		Assert.assertTrue(AlgoUtils.precedence('^') == 3);
	}

	@Test
	public void isOperandTest() {
		Assert.assertTrue(AlgoUtils.isOperand('*') == false);
		Assert.assertTrue(AlgoUtils.isOperand('A') == true);
		Assert.assertTrue(AlgoUtils.isOperand('1') == false);
	}
}
