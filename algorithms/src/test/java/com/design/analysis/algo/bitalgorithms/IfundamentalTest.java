package com.design.analysis.algo.bitalgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IfundamentalTest {

	Ifundamental ifm = null;

	@Before
	public void inti() {
		ifm = new FundamentalImpl();
	}

	/** decimal to binary **/
	@Test
	public void decimalToBinaryTest() {
		System.out.println(ifm.decimalToBinary(37));
	}

	/** addition of bit numbers **/
	@Test
	public void addBitIntegerTest() {
		Assert.assertTrue(ifm.addBitInteger(11, 01) == 100);
		Assert.assertTrue(ifm.addBitInteger(111, 111) == 1110);
	}

	/** 1. & (bitwise AND) **/
	@Test
	public void bitwiseANDTest() {
		Assert.assertTrue(ifm.bitwiseAND(11, 01) == 01);
		Assert.assertTrue(ifm.bitwiseAND(111, 101) == 101);
	}

	/** 2. | (bitwise OR) **/
	@Test
	public void bitwiseORTest() {
		Assert.assertTrue(ifm.bitwiseOR(11, 01) == 11);
		Assert.assertTrue(ifm.bitwiseOR(100, 101) == 101);
	}

	/** 3. ~ (bitwise NOT) **/
	@Test
	public void bitwiseNOTTest() {
		Assert.assertTrue(ifm.bitwiseNOT(11) == 00);
		Assert.assertTrue(ifm.bitwiseNOT(100) == 11);
	}

	/** 4. ^ (bitwise XOR) **/
	@Test
	public void bitwiseXORTest() {
		Assert.assertTrue(ifm.bitwiseXOR(11, 01) == 10);
		Assert.assertTrue(ifm.bitwiseXOR(100, 101) == 001);
	}

	/** 5. << (bitwise left shift) **/
	@Test
	public void lefShifTest() {
		System.out.println(ifm.lefShift(37, 3));
	}
}
