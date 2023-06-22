package com.design.analysis.ds.advance.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.advance.trie.node.CamelCaseTrieNode;
import com.design.analysis.ds.advance.trie.node.PhoneTrieNode;
import com.design.analysis.ds.advance.trie.node.SuffixTrieNode;
import com.design.analysis.ds.advance.trie.node.TrieNode;
import com.design.analysis.ds.advance.trie.node.UqPrTrieNode;

public class ITrieTest {

	public ITrie trie = null;

	@Before
	public void init() {
		trie = new ITrieImpl();
	}

	/** 1. Trie | (Insert and Search) **/
	// inser and search tested here only*/
	@Test
	public void searchTest() {

		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };
		TrieNode root = null;

		int i;
		for (i = 0; i < keys.length; i++)
			root = trie.insert(root, keys[i]);
		// trie.search(root, "the");
		String skeys[] = { "the", "a", "there", "answer", "any", "noting", "found", "so", "what", "to", "do" };
		for (int j = 0; j < skeys.length; j++) {
			if (j < 5)
				Assert.assertTrue(trie.search(root, skeys[j]));
			else
				Assert.assertTrue(!trie.search(root, skeys[j]));
		}
	}

	/**
	 * 2. Trie | (Delete) all the method come undar 2.Trie is tested here since
	 * interanl call
	 **/
	@Test
	public void deleteTest() {

		String keys[] = { "xyz", "the", "a", "there", "answer", "any", "by", "bye", "their" };
		TrieNode root = null;

		int i;
		for (i = 0; i < keys.length; i++)
			root = trie.insert(root, keys[i]);
		root = trie.delete(root, "xyz");
		root = trie.delete(root, "by");
		root = trie.delete(root, "their");
		root = trie.delete(root, "bye");
		String skeys[] = { "answer", "any", "by", "bye", "their", "noting", "found", "so", "what", "to", "do" };
		for (int j = 0; j < skeys.length; j++) {
			if (j < 2)
				Assert.assertTrue(trie.search(root, skeys[j]));
			else
				Assert.assertTrue(!trie.search(root, skeys[j]));
		}
	}

	/** 3. Longest prefix matching – A Trie based solution in Java **/
	@Test
	public void longestPrefixInDictTest() {
		String keys[] = { "are", "area", "base", "cat", "cater", "basement" };
		TrieNode root = null;

		int i;
		for (i = 0; i < keys.length; i++)
			root = trie.insert(root, keys[i]);

		String input[] = { "caterer", "basement", "are", "arex", "basemexz", "xyz" };
		String output[] = { "cater", "basement", "are", "are", "baseme", "" };
		for (i = 0; i < input.length; i++)
			Assert.assertTrue(trie.longestPrefixInDict(root, input[i]).endsWith(output[i]));
	}

	/** 4. Pattern Searching using a Trie of all Suffixes inset also tested here **/
	@Test
	public void searchAllSuffixTest() {
		SuffixTrieNode root = new SuffixTrieNode();
		String txt = "geeksforgeeks.org";
		root = trie.insertSuffix(txt);

		String pat[] = { "ee", "geek", "quiz", "forgeeks" };
		int k = 0;
		for (int i = 0; i < pat.length; i++) {
			List<Integer> result = trie.searchAllSuffix(root, pat[i]);
			int reArr[] = { 1, 9, 0, 8, 5 };
			int n = pat[i].length();
			// Check if the list of indexes is empty or not
			if (result == null)
				System.out.println("Pattern not found");
			else {
				for (Integer j : result)
					Assert.assertTrue(j - n == reArr[k++]);

			}
		}
	}

	/**
	 * 5. Find shortest unique prefix for every word in a given list..insert is also
	 * tested heresss
	 **/
	@Test
	public void shortestCommonUniquePrefixTest() {
		String arr[] = { "zebra", "dog", "duck", "dove" };
		int n = arr.length;
		// Construct a Trie of all words
		UqPrTrieNode root = new UqPrTrieNode();
		root.frq = 0;
		for (int i = 0; i < n; i++)
			root = trie.insertUniquePrefix(root, arr[i]);

		// Create an array to store all prefixes
		char[] prefix = new char[256];
		List<String> rl = new ArrayList<>();
		rl = TrieUtil.findPrefixesUtil(rl, root, prefix, 0, n);
		String rlStr[] = { "dog", "dov", "du", "z" };
		for (int i = 0; i < rlStr.length; i++)
			Assert.assertTrue(rlStr[i].equals(rl.get(i)));
	}

	/** 6. Longest Common Prefix **/
	@Test
	public void loggestCommonUniquePrefixTest() {

		String keys[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		int i;
		TrieNode root = null;
		for (i = 0; i < keys.length; i++)
			root = trie.insert(root, keys[i]);
		Assert.assertTrue(trie.loggestCommonUniquePrefix(root, keys).endsWith("gee"));
	}

	/**
	 * 7. Print all words matching a pattern in CamelCase Notation Dictonary
	 * insertion also testing from here
	 **/
	@Test
	public void searchPatternInCamelCaseDictTest() {
		List<String> dict = Arrays.asList("Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity",
				"HiTechLab");
		CamelCaseTrieNode root = new CamelCaseTrieNode(26);
		for (String str : dict)
			root = trie.insertCamelCaseDict(root, str);
		String pattern = "HT";
		trie.searchPatternInCamelCaseDict(root, pattern);
		/*
		 * out put:- HiTech HiTechCity HiTechLab HiTechWorld
		 */
	}

	/** 8. Implement a Phone Directory insert and search both testing here **/
	@Test
	public void displayPhoeContactsTest() {

		PhoneTrieNode root = new PhoneTrieNode();
		String contacts[] = { "gforgeeks", "geeksquiz" };
		root = trie.insertIntoPhoneTrie(contacts);
		String query = "gekk";
		trie.displayPhoeContacts(root, query);
	}
}