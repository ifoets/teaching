package com.design.analysis.algo.string;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ICharCountTest {

	ICharCount icc = null;

	@Before
	public void init() {
		icc = new CharCountImpl();
	}

	/** 1. Return maximum occurring character in an input string **/
	@Test
	public void maxOccuranceCharTest() {
		Assert.assertTrue(icc.maxOccuranceChar("abcabcabcaefghi") == 'a');
	}

	// without using libarary
	@Test
	public void maxOccuranceChaXTest() {
		Assert.assertTrue(icc.maxOccuranceCharX("abbcbabcbabbbcaebfbghi") == 'b');
	}

	/**
	 * 2.Find the smallest window in a string containing all characters of another
	 * string
	 **/
	@Test
	public void smallestWindowTest() {
		String str = "this is a test string";
		String pattern = "tist";
		String strResult = icc.smallestWindow(str, pattern);
		Assert.assertTrue(strResult.equals("t stri"));
		Assert.assertTrue(icc.smallestWindow("geeksforgeeks", "ork").equals("ksfor"));
	}

	// TODOwithout use of libirary
	@Test
	public void smallestWindowXTest() {
		/*
		 * String str = "this is a test string"; String pattern = "tist"; String
		 * strResult = icc.smallestWindowX(str, pattern);
		 * Assert.assertTrue(strResult.equals("t stri"));
		 */
		// Assert.assertTrue(icc.smallestWindowX("geeksforgeeks",
		// "ork").equals("ksfor"));
	}

	/** 3.program to find first second most frequent character **/
	@Test
	public void first2ndMostCharTest() {
		Assert.assertTrue(icc.firstKndMostChar("aabababa", 2) == 'b');
		Assert.assertTrue(icc.firstKndMostChar("geeksforgeekstt", 2) == 's');
	}

	/** 4. K’th Non-repeating Character **/
	@Test
	public void kthNonRepeatingCharTest() {
		Assert.assertTrue(icc.kthNonRepeatingChar("geeksforgeeks", 3) == 'r');
		Assert.assertTrue(icc.kthNonRepeatingChar("geeksforgeeks", 1) == 'f');
		Assert.assertTrue(icc.kthNonRepeatingChar("geeksforgeeks", 2) == 'o');
		Assert.assertTrue(icc.kthNonRepeatingChar("geeksforgeeks", 4) == null);
	}

	/** 5.Count number of substrings with exactly k distinct characters **/
	@Test
	public void kDistinctCharTest() {
		Assert.assertTrue(icc.kDistinctChar("abc", 2).size() == 2);
		Assert.assertTrue(icc.kDistinctChar("aba", 2).size() == 3);
		Assert.assertTrue(icc.kDistinctChar("aa", 1).size() == 3);
	}

	@Test
	/** 6. Find k’th character of decrypted string **/
	public void kthCharInDesryptedTest() {
		Assert.assertTrue(icc.kthCharInDesrypted("a2b2c3", 5) == 'c');
		Assert.assertTrue(icc.kthCharInDesrypted("ab4c2ed3", 9) == 'c');
		Assert.assertTrue(icc.kthCharInDesrypted("ab2c1", 2) == 'b');
		Assert.assertTrue(icc.kthCharInDesrypted("ab4c12ed3", 21) == 'e');
	}

	@Test
	public void kthCharInDesryptedXTest() {
		Assert.assertTrue(icc.kthCharInDesryptedX("a2b2c3", 5) == 'c');
		Assert.assertTrue(icc.kthCharInDesryptedX("ab4c2ed3", 9) == 'c');
		Assert.assertTrue(icc.kthCharInDesryptedX("ab2c1", 2) == 'b');
		Assert.assertTrue(icc.kthCharInDesryptedX("ab4c12ed3", 21) == 'e');
	}

	/** 7.Count characters at same position as in English alphabets **/
	@Test
	public void exactPositionCharTest() {
		Assert.assertTrue(icc.exactPositionChar("ABcED") == 3);
		Assert.assertTrue(icc.exactPositionChar("geeksforgeeks") == 1);
		Assert.assertTrue(icc.exactPositionChar("alphabetical") == 3);
	}

	/** 8. Check if two strings are k-anagrams or not **/
	@Test
	public void arekAnagramsTest() {

		String str1 = "anagram";
		String str2 = "grammar";
		int k = 2;
		Assert.assertTrue(icc.arekAnagrams(str1, str2, k));
	}

	/** 9. Count words in a given string **/
	@Test
	public void countWordsTest() {
		String str = "One two       three\n four\tfive  ";
		Assert.assertTrue(icc.countWords(str) == 5);
	}

	/**
	 * 10. Count of words whose i-th letter is either (i-1)-th, i-th, or (i+1)-th
	 * letter of given word
	 **/
	@Test
	public void countWordsIthBefOrAfterSameTest() {

		String str = "abc";
		Assert.assertTrue(icc.countWordsIthBefOrAfterSame(str) == 12);
	}

	/** 11. Count substrings with same first and last characters **/
	@Test
	public void countSubstrWhereFirstLastSameTest() {
		String str = "abcab";
		Assert.assertTrue(icc.countSubstrWhereFirstLastSame(str) == 7);
		Assert.assertTrue(icc.countSubstrWhereFirstLastSame("aba") == 4);
	}

	/* by O(n) frq+1C2 */
	@Test
	public void countSubstrWhereFirstLastSameXTest() {
		String str = "abcab";
		Assert.assertTrue(icc.countSubstrWhereFirstLastSame(str) == 7);
		Assert.assertTrue(icc.countSubstrWhereFirstLastSame("aba") == 4);
	}

	/**
	 * 13. Count of strings that can be formed using a, b and c under given
	 * constraints
	 **/
	@Test
	public void stringFormationTest() {
		/*
		 * Given a length n, count the number of strings of length n that can be made
		 * using ‘a’, ‘b’ and ‘c’ with at-most one ‘b’ and two ‘c’s allowed.
		 */
		String str = "abc";
		Assert.assertTrue(icc.stringFormation(str) == 19);
	}

	/** 14. Group words with same set of characters **/
	@Test
	public void groupSameSetCharWordTest() {
		String words[] = { "may", "student", "students", "dog", "studentssess", "god", "cat", "act", "tab", "bat",
				"flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle" };
		List<List<String>> ll = icc.groupSameSetCharWord(words);
		Assert.assertTrue(ll.size() == 8);
		// [[may, amy, yam], [student, students, studentssess], [dog, god], [cat, act],
		// [tab, bat], [flow, wolf], [lambs, balms], [looped, poodle]]
	}
}
