package com.design.analysis.core.algo.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IAnagramTest {

	IAnagram iam = null;

	@Before
	public void init() {
		iam = new AnagramImpl();
	}

	/** 1. Check whether two strings are anagram of each other **/
	@Test
	public void anagramEachOtherTest() {

		Assert.assertTrue(iam.anagramEachOther("listen", "silent"));
		Assert.assertTrue(iam.anagramEachOther("triangle", "integral"));
	}

	/** 2. Given a sequence of words, print all anagrams together | Set 2 **/
	@Test
	public void togetherAangramsTest() {
		String strArr[] = { "cat", "dog", "tac", "god", "act" };
		String strArrResult[] = { "cat", "tac", "act", "dog", "god" };
		List<String> list = iam.togetherAangrams(strArr);
		for (int i = 0; i < list.size(); i++) {
			Assert.assertTrue(list.get(i).equals(strArrResult[i]));
		}
	}

	/** 3. Anagram Substring Search **/
	@Test
	public void searchIndexTest() {
		List<Integer> list = iam.searchIndex("BACDGABCDA", "ABCD");
		List<Integer> rsList = Arrays.asList(0, 5, 6);
		for (int i = 0; i < list.size(); i++)
			Assert.assertTrue(list.get(i) == rsList.get(i));
	}

	/** 4. Print all pairs of anagrams in a given array of strings **/
	// O(n)
	@Test
	public void allPairOfAnagramsTest() {
		String arr[] = { "geeksquiz", "geeksforgeeks", "abcd", "forgeeksgeeks", "zuiqkeegs" };
		Map<String, String> map = iam.allPairOfAnagrams(arr);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " , " + entry.getValue());
		}
	}

	/** 5. Remove minimum number of characters so two strings become anagram **/
	@Test
	public void removeCharToMakeAnagramTest() {
		List<Character> list = iam.removeCharToMakeAnagram("bcadeh", "hea");
		List<Character> expLlist = Arrays.asList('b', 'c', 'd');
		for (int i = 0; i < list.size(); i++)
			Assert.assertTrue(list.get(i) == expLlist.get(i));
	}

	/** 6. Check if two strings are k-anagrams or not **/
	@Test
	public void checkKAnagramTest() {
		Assert.assertTrue(iam.checkKAnagram("anagram", "grammar", 3));
		Assert.assertTrue(!iam.checkKAnagram("geeks", "eggkf", 1));
	}
}
