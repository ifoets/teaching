package com.design.analysis.ds.utils;

import org.junit.Assert;
import org.junit.Test;

import com.design.analysis.ds.utils.DSUtil;

public class DSUtilTest {

	@Test
	public void numOfDigitTest() {

		Assert.assertTrue(1 == DSUtil.numOfDigit(7));
		Assert.assertTrue(2 == DSUtil.numOfDigit(10));
		Assert.assertTrue(4 == DSUtil.numOfDigit(7109));
		Assert.assertTrue(5 == DSUtil.numOfDigit(19087));
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
		Assert.assertTrue(2 == DSUtil.numOfDigitInArray(a1));
		Assert.assertTrue(3 == DSUtil.numOfDigitInArray(b1));
		Assert.assertTrue(0 == DSUtil.numOfDigitInArray(c));

		int a[] = { 1, 2, 3, 4, 5 };
		Assert.assertTrue(5 == DSUtil.numOfDigitInArray(a));

	}

	@Test
	public void precedenceTest() {
		Assert.assertTrue(DSUtil.precedence('*') == 2);
		Assert.assertTrue(DSUtil.precedence('+') == 1);
		Assert.assertTrue(DSUtil.precedence('^') == 3);
	}

	@Test
	public void isOperandTest() {
		Assert.assertTrue(DSUtil.isOperand('*') == false);
		Assert.assertTrue(DSUtil.isOperand('A') == true);
		Assert.assertTrue(DSUtil.isOperand('1') == false);
	}
}
