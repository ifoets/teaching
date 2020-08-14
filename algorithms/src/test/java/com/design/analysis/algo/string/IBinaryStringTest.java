package com.design.analysis.algo.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBinaryStringTest {

	IBinaryString ibs = null;

	@Before
	public void init() {
		ibs = new BinaryStringImpl();
	}

	/** 1. Count of operations to make a binary string”ab” free **/
	@Test
	public void countFreeAdjecentBinaryTest() {

		Assert.assertTrue(ibs.countFreeAdjecentBinary("abbaa", "ab", "bba") == 2);
		Assert.assertTrue(ibs.countFreeAdjecentBinary("aab", "ab", "bba") == 3);
		Assert.assertTrue(ibs.countFreeAdjecentBinary("ababab", "ab", "bba") == 11);
	}

	/** 2. Change if all bits can be made same by single flip **/
	@Test
	public void canMakeAllSameTest() {
		Assert.assertTrue(!ibs.canMakeAllSame("01010"));
		Assert.assertTrue(ibs.canMakeAllSame("00010"));
		Assert.assertTrue(ibs.canMakeAllSame("11110"));
	}

	/** 3. Length of Longest sub-string that can be removed **/
	@Test
	public void longestStringRemoveTest() {
		// TODO
	}

	/** 4. Number of flips to make binary string alternate **/
	@Test
	public void minFlipMakeAlternativeTest() {
		Assert.assertTrue(ibs.minFlipMakeAlternative("11110") == 2);
		Assert.assertTrue(ibs.minFlipMakeAlternative("110") == 1);
		Assert.assertTrue(ibs.minFlipMakeAlternative("001") == 1);
		Assert.assertTrue(ibs.minFlipMakeAlternative("0001010111") == 2);
	}

	/** 5. 1’s and 2’s complement of a Binary Number **/
	@Test
	public void onceComplementTest() {
		
	}

	@Test
	public void twondComplementTest() {

	}
}
