package com.design.analysis.hackerrank.algo.medium.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IMediumStringTest {

	IMediumString ims = null;

	@Before
	public void init() {
		ims = new MediumStringImpl();
	}

	/** Sherlock and the Valid String **/
	@Test
	public void isSherlockValidStringTest() {
		String s1 = "abc";
		String s2 = "abcc";
		String s3 = "aabbcd";
		String s4 = "xxxaabbccrry";
		Assert.assertTrue(ims.isSherlockValidString(s1) == "YES");
		Assert.assertTrue(ims.isSherlockValidString(s2) == "YES");
		Assert.assertTrue(ims.isSherlockValidString(s3) == "NO");
		Assert.assertTrue(ims.isSherlockValidString(s4) == "NO");
	}

	/** Highest Value Palindrome **/
	public void highestValuePalindromeTest() {

	}
}
