package com.hackerrank.ps.basic.easy.strings;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBasicEasyStringsTest {

	IBasicEasyStrings ibs;

	@Before
	public void init() {
		ibs = new BasicEasyStringsImpl();
	}

	/** strings **/ // Start...
	/* CamelCase */
	@Test
	public void camelcaseTest() {
		Assert.assertTrue(ibs.camelcase("saveChangesInTheEditor") == 5);
		Assert.assertTrue(ibs.camelcase("oneTwoThree") == 3);
	}

	/* Strong Password */
	@Test
	public void minimumNumberTest() {
		Assert.assertTrue(ibs.minimumNumber(3, "Ab1") == 3);
		Assert.assertTrue(ibs.minimumNumber(11, "#HackerRank") == 1);
	}

	/* Caesar Cipher */
	@Test
	public void caesarCipherTest() {
		Assert.assertTrue(ibs.caesarCipher("middle-Outz", 2).equals("okffng-Qwvb"));
	}

	/* Mars Exploration */
	@Test
	public void marsExplorationTest() {
		Assert.assertTrue(ibs.marsExploration("SOSTOT") == 2);
		Assert.assertTrue(ibs.marsExploration("SOSSPSSQSSOR") == 3);
	}

	/* HackerRank in a String! */
	@Test
	public void hackerrankInStringTest() {
		Assert.assertTrue(ibs.hackerrankInString("hereiamstackerrank") == "YES");
		Assert.assertTrue(ibs.hackerrankInString("hackerworld") == "NO");
	}

	/* Alternating Characters */
	@Test
	public void alternatingCharactersTest() {
		Assert.assertTrue(ibs.alternatingCharacters("AAAA") == 3);
		Assert.assertTrue(ibs.alternatingCharacters("AAABBB") == 4);
		Assert.assertTrue(ibs.alternatingCharacters("BABABABA") == 0);
	}

	/* Gemstones */
	@Test
	public void gemstonesTest() {
		Assert.assertTrue(ibs.gemstones(List.of("abcdde", "baccd", "eeabg")) == 2);
	}

	/* Funny String */
	@Test
	public void funnyStringTest() {
		Assert.assertTrue(ibs.funnyString("lmnop") == "Funny");
		Assert.assertTrue(ibs.funnyString("acxz") == "Funny");
		Assert.assertTrue(ibs.funnyString("bcxz") == "Not Funny");
	}

	/* Separate the Numbers */
	@Test
	public void separateNumbersTest() {
		ibs.separateNumbers("1234");
		ibs.separateNumbers("91011");

	}

	/* Pangrams */
	@Test
	public void pangramsTest() {
		Assert.assertTrue(ibs.pangrams("We promptly judged antique ivory buckles for the prize") == "not pangram");
		Assert.assertTrue(ibs.pangrams("We promptly judged antique ivory buckles for the next prize") == "pangram");
	}

	/* The Love-Letter Mystery */
	@Test
	public void theLoveLetterMysteryTest() {
		Assert.assertTrue(ibs.theLoveLetterMystery("abc") == 2);
		Assert.assertTrue(ibs.theLoveLetterMystery("abcba") == 0);
		Assert.assertTrue(ibs.theLoveLetterMystery("abcd") == 4);
	}

	/* Palindrome Index */
	@Test
	public void palindromeIndexTest() {
		Assert.assertTrue(ibs.palindromeIndex("aaab") == 3);
		Assert.assertTrue(ibs.palindromeIndex("baa") == 0);
	}

	/* Anagram */
	@Test
	public void anagramTest() {
		Assert.assertTrue(ibs.anagram("aaabbb") == 3);
		Assert.assertTrue(ibs.anagram("ab") == 1);
		Assert.assertTrue(ibs.anagram("abc") == -1);
	}

	/* Making Anagrams */
	@Test
	public void makingAnagramsTest() {
		Assert.assertTrue(ibs.makingAnagrams("cde", "abc") == 4);
		Assert.assertTrue(ibs.makingAnagrams("abc", "amnop") == 6);
	}

	/* Game of Thrones - I */
	@Test
	public void gameOfThronesTest() {
		Assert.assertTrue(ibs.gameOfThrones("cdcdcdcdeeeef") == "YES");
		Assert.assertTrue(ibs.gameOfThrones("cdefghmnopqrstuvw") == "NO");
	}

	/* Two Strings */
	@Test
	public void twoStringsTest() {
		Assert.assertTrue(ibs.twoStrings("hello", "world") == "YES");
		Assert.assertTrue(ibs.twoStrings("hi", "world") == "NO");
	}

	/* String Construction */
	@Test
	public void stringConstructionTest() {
		Assert.assertTrue(ibs.stringConstruction("abcabc") == 3);
		Assert.assertTrue(ibs.stringConstruction("abcd") == 4);
	}

	/* Beautiful Binary String */
	@Test
	public void beautifulBinaryStringTest() {
		Assert.assertTrue(ibs.beautifulBinaryString("0101010") == 2);
		Assert.assertTrue(ibs.beautifulBinaryString("01100") == 0);
		Assert.assertTrue(ibs.beautifulBinaryString("0100101010") == 3);
	}

	/*********************************************************************************************************************************/
	/** strings **/ // Continue...
	public static void main(String[] args) {
		System.out.println("bacdef".substring(-1, 0));
	}
}
