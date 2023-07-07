package com.design.analysis.core.algo.string;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBasicStringTest {

	IBasicString ib = null;

	@Before
	public void init() {
		ib = new BasicStringIml();
	}

	/** 1. Function to copy string **/
	@Test
	public void copyStringTest() {
		String s1 = "sita";
		String s2 = "RadheShyam";
		char s1a[] = s1.toCharArray();
		char s2a[] = s2.toCharArray();
		ib.copyString(s1a, s2a);
		Assert.assertTrue(String.valueOf(s2a).equals("sitaeShyam"));
	}

	/** 2. Pangram Checking **/
	@Test
	public void pangramCheckingTest() {
		String st = "The quick brown fox jumps over the lazy dog ";
		Assert.assertTrue(ib.pangramChecking(st));
	}

	/** 3. Missing characters to make a string Pangram **/
	@Test
	public void missingCharForpangramTest() {
		String st = "The quick brown fox jumps over the dog ";
		List<Character> clist = ib.missingCharForpangram(st);
		Assert.assertTrue(clist.contains('l'));
		Assert.assertTrue(clist.contains('z'));
		Assert.assertTrue(clist.contains('y'));
		Assert.assertTrue(clist.contains('a'));
	}

	/** 4. Check if a string is Pangrammatic Lipogram **/
	@Test
	public void isPangrammaticLipogramTest() {

		String str = "The quick brown fox jumped over the lazy dog";
		Assert.assertTrue(ib.isPangrammaticLipogram(str));

		str = "The quick brown fox jumps over the lazy dog";
		Assert.assertTrue(!ib.isPangrammaticLipogram(str));

		str = "The quick brown fox jum over the lazy dog";
		Assert.assertTrue(!ib.isPangrammaticLipogram(str));
	}

	/** 5. Removing punctuations from a given string **/
	@Test
	public void removePunctuationTest() {
		String str = "Welcome ???@@##$ to#$% Geeks%$^for$%^&Geeks";
		String s = "Welcome  to GeeksforGeeks";
		Assert.assertTrue(ib.removePunctuation(str).equals(s));
	}

	/** 6. Rearrange characters in a string such that no two adjacent are same **/
	@Test
	public void rearrangeAdjNotSameTest() {
		String str = "aaabc";
		Assert.assertTrue(ib.rearrangeAdjNotSame(str).equals("abaca"));

		str = "aaabb";
		Assert.assertTrue(ib.rearrangeAdjNotSame(str).equals("ababa"));

		str = "aa";
		Assert.assertTrue(ib.rearrangeAdjNotSame(str).equals("aa"));

		str = "aaaabc";
		Assert.assertTrue(ib.rearrangeAdjNotSame(str).equals("aaaabc"));
	}

	/** 7. Program to check if input is an integer or a string **/
	@Test
	public void isIntOrStringTest() {
		String str = "6790";
		Assert.assertTrue(ib.isIntOrString(str));
		str = "67a0";
		Assert.assertTrue(!ib.isIntOrString(str));
	}

	/** 8. Quick way to check if all the characters of a string are same **/
	@Test
	public void isAllcharSameTest() {
		Assert.assertTrue(ib.isAllcharSame("eeeee"));
		Assert.assertTrue(!ib.isAllcharSame("gggge"));
	}

	/** 9. Program to find the initials of a name **/
	@Test
	public void intitialOfNameTest() {

		String name = "prabhat kumar singh";
		List<Character> list = ib.intitialOfName(name);
		Assert.assertTrue(list.contains('P'));
		Assert.assertTrue(list.contains('K'));
		Assert.assertTrue(list.contains('S'));
	}

	/** 10. Check Whether a number is Duck Number or not **/
	@Test
	public void isDuckNumberTest() {
		String str = "707069";
		Assert.assertTrue(ib.isDuckNumber(str));
		str = "02364";
		Assert.assertTrue(!ib.isDuckNumber(str));
	}

	/** 11. Round the given number to nearest multiple of 10 **/
	@Test
	public void nearestRoudMulofTenTest() {
		Assert.assertTrue(ib.nearestRoudMulofTen(10) == 10);
		Assert.assertTrue(ib.nearestRoudMulofTen(1234) == 1230);
	}

	/***********************************************************************************************************************************************************************/
	@Test
	public void reverseStringTest() {

		String str = "parmatma";
		str = ib.reverseString(str);
		Assert.assertTrue(str.equals("amtamrap"));
	}

	@Test
	public void reverseSkipSpecialCharTest() {
		Assert.assertTrue(ib.reverseSkipSpecialChar("a,b$c").equals("c,b$a"));
		Assert.assertTrue(ib.reverseSkipSpecialChar("Ab,c,de!$").equals("ed,c,bA!$"));
	}

	@Test
	public void removeDuplicateTest() {
		Assert.assertTrue(ib.removeDuplicate("abceabcefgh").equals("abcefgh"));
	}

	/** 13. Remove spaces from a given string **/
	@Test
	public void removeSapceTest() {
		String str = "g  eeks   for ge  eeks  ";
		String rs = "geeksforgeeeks";
		str = ib.removeSapce(str);
		Assert.assertTrue(str.endsWith(rs));
	}
}
