package com.design.analysis.core.algo.utils;

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
	@Test
	public void binarySearchJustGreaterTest()
	{
        int a[] = {3,4};
		Assert.assertTrue(AlgoUtils.binarySearchJustGreaterOrLess(a,0,a.length-1,-1, true)==0);
		Assert.assertTrue(AlgoUtils.binarySearchJustGreaterOrLess(a,0,a.length-1,-1, false)==-1);
		int b[]= {-1,4,5,8};

		Assert.assertTrue(AlgoUtils.binarySearchJustGreaterOrLess(b,0,b.length-1,2, true)==1);
		Assert.assertTrue(AlgoUtils.binarySearchJustGreaterOrLess(b,0,b.length-1,2, false)==0);
		int c[]= {-1,2,3,7,12};

		Assert.assertTrue(AlgoUtils.binarySearchJustGreaterOrLess(c,0,c.length-1,9, true)==4);
		Assert.assertTrue(AlgoUtils.binarySearchJustGreaterOrLess(c,0,c.length-1,9, false)==3);
	}
}
