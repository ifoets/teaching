package com.design.analysis.algo.string;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPalindromeTest {

	IPalindrome ipl = null;

	@Before
	public void init() {
		ipl = new PalindromeImpl();
	}

	/** 1. C Program to Check if a Given String is Palindrome **/
	@Test
	public void isPalindromeTest() {
		Assert.assertTrue(ipl.isPalindrome("abcbc"));
		Assert.assertTrue(ipl.isPalindrome("aabaa"));
		Assert.assertTrue(ipl.isPalindrome("b"));
		Assert.assertTrue(!ipl.isPalindrome("bbcbbc"));
	}

	/** 2. Check if a given string is a rotation of a palindrome **/
	@Test
	public void oneCharRotateStringTest() {
		Assert.assertTrue(ipl.oneCharRotateString("bbcbbc").equals("bcbbcb"));

	}

	// O(n*n)
	@Test
	public void isRotationOfPalindromeTest() {
		Assert.assertTrue(ipl.isRotationOfPalindrome("aab"));
		Assert.assertTrue(!ipl.isRotationOfPalindrome("abcde"));
		Assert.assertTrue(ipl.isRotationOfPalindrome("aaaad"));
	}

	// O(n)
	@Test
	public void isRotationOfPalindromeXTest() {
		Assert.assertTrue(ipl.isRotationOfPalindromeX("aab"));
		Assert.assertTrue(!ipl.isRotationOfPalindromeX("abcde"));
		Assert.assertTrue(ipl.isRotationOfPalindromeX("aaaad"));
	}

	/** 3. C++ Program to print all palindromes in a given range **/
	@Test
	public void ispalindromeNumTest() {
		Assert.assertTrue(ipl.ispalindromeNum(121));
		Assert.assertTrue(ipl.ispalindromeNum(1221));
		Assert.assertTrue(!ipl.ispalindromeNum(123));
	}

	@Test
	public void countAllPalindromeTest() {
		Assert.assertTrue(ipl.countAllPalindrome(100, 2000) == 100);
	}

	/** 4. Characters of string can be rearranged to form a palindrome **/
	@Test
	public void isReArrageInPlaindromeTest() {
		Assert.assertTrue(ipl.isReArrageInPlaindrome("geeksogeeks"));
		Assert.assertTrue(!ipl.isReArrageInPlaindrome("geeksforgeeks"));
	}

	/** 5. Minimum insertions to form a palindromes **/
	@Test
	public void countInsertionMakePalindromTest() {
		Assert.assertTrue(ipl.countInsertionMakePalindrom("ab") == 1);
		Assert.assertTrue(ipl.countInsertionMakePalindrom("aa") == 0);
		Assert.assertTrue(ipl.countInsertionMakePalindrom("abcd") == 3);
		Assert.assertTrue(ipl.countInsertionMakePalindrom("abcda") == 2);
		Assert.assertTrue(ipl.countInsertionMakePalindrom("abcde") == 4);
	}
}
