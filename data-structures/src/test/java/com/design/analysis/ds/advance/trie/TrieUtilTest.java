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

public class TrieUtilTest {

	public ITrie trie = null;

	@Before
	public void init() {
		trie = new ITrieImpl();
	}

	@Test
	public void charToIinexTest() {
		Assert.assertTrue(TrieUtil.charToIinex('c') == 2);
		Assert.assertTrue(TrieUtil.charToIinex('b') == 1);
	}

	/* internally called the deleteUtils */
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

	@Test
	public void insertSuffixUtilTest() {
		SuffixTrieNode root = new SuffixTrieNode();
		String txt = "geeksforgeeks.org";
		for (int i = 0; i < txt.length(); i++)
			TrieUtil.insertSuffixUtil(root, txt.substring(i), i);
		;
	}

	/* search utils */
	@Test
	public void searchUtilTest() {

		SuffixTrieNode root = new SuffixTrieNode();
		String txt = "geeksforgeeks.org";
		for (int i = 0; i < txt.length(); i++)
			TrieUtil.insertSuffixUtil(root, txt.substring(i), i);
		;
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

	/* utility for find the unidque prefix of a word in dictonary */
	@Test
	public void findPrefixesUtilTest() {
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

	/* utility for find no of children and the index of it */
	@Test
	public void countChildrenTest() {

		String keys[] = { "geeksforgeeks", "geeks", "geek", "geezer" };
		int i;
		TrieNode root = null;
		for (i = 0; i < keys.length; i++)
			root = trie.insert(root, keys[i]);
		Assert.assertTrue(TrieUtil.countChildren(root) == 1);
		Assert.assertTrue(TrieUtil.indexs == 6);
	}

	/* Function to print all children of Trie node root */
	@Test
	public void printAllWordsTest() {
		// dictionary of words where each word follows
		// CamelCase notation
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

	/* internally displayPhoneContactsUtil is called */
	@Test
	public void displayPhoneContactsUtilTest() {

		PhoneTrieNode root = new PhoneTrieNode();
		String contacts[] = { "gforgeeks", "geeksquiz" };
		root = trie.insertIntoPhoneTrie(contacts);
		String query = "gekk";
		trie.displayPhoeContacts(root, query);
	}
}
