package com.design.analysis.core.ds.advance.trie;

import java.util.List;

import com.design.analysis.core.ds.advance.trie.node.CamelCaseTrieNode;
import com.design.analysis.core.ds.advance.trie.node.PhoneTrieNode;
import com.design.analysis.core.ds.advance.trie.node.SuffixTrieNode;
import com.design.analysis.core.ds.advance.trie.node.TrieNode;
import com.design.analysis.core.ds.advance.trie.node.UqPrTrieNode;

/*
Trie :
1.	Trie | (Insert and Search)
2.	Trie | (Delete)
3.	Longest prefix matching � A Trie based solution in Java
4.	Pattern Searching using a Trie of all Suffixes
5.	Find shortest unique prefix for every word in a given list
6.	Longest Common Prefix
7.	Print all words matching a pattern in CamelCase Notation Dictonary
8.	Implement a Phone Directory
9.	Construct a unique matrix n x n for an input n
10.	Print unique rows in a given boolean matrix
11.	Count of distinct substrings of a string using Suffix Trie
12.	Find pair of rows in a binary matrix that has maximum bit difference
13.	Minimum XOR Value Pair
14.	Find the maximum subarray XOR in a given array
15.	Weighted Prefix Search
16.	Boggle
17.	Print all valid words that are possible using Characters of Array
18.	Find the k most frequent words from a file
19.	Palindrome pair in an array of words (or strings)
20.	Word formation using concatenation of two dictionary words
21.	Given a sequence of words, print all anagrams together
22.	How to Implement Reverse DNS Look Up Cache?
23.	How to Implement Forward DNS Look Up Cache?
24. Find the k most frequent words from a file
https://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
 */

public interface ITrie {

	public static int ALPHABET_SIZE = 26;

	/** 1. Trie | (Insert and Search) **/

	public TrieNode insert(TrieNode node, String str);

	public boolean search(TrieNode node, String str);

	/** 2. Trie | (Delete) **/

	public TrieNode delete(TrieNode node, String str);

	/** 3. Longest prefix matching � A Trie based solution in Java **/
	public String longestPrefixInDict(TrieNode node, String key);

	/** 4. Pattern Searching using a Trie of all Suffixes **/
	public SuffixTrieNode insertSuffix(String txt);

	public List<Integer> searchAllSuffix(SuffixTrieNode node, String pattern);

	/** 5. Find shortest unique prefix for every word in a given list **/
	public UqPrTrieNode insertUniquePrefix(UqPrTrieNode node, String str);

	public List<String> shortestCommonUniquePrefix(UqPrTrieNode node, String[] keys);

	/** 6. Longest Common Prefix **/
	public String loggestCommonUniquePrefix(TrieNode node, String[] keys);

	/** 7. Print all words matching a pattern in CamelCase Notation Dictonary **/
	public CamelCaseTrieNode insertCamelCaseDict(CamelCaseTrieNode node, String str);

	public boolean searchPatternInCamelCaseDict(CamelCaseTrieNode node, String str);

	/** 8. Implement a Phone Directory **/
	public PhoneTrieNode insertIntoPhoneTrie(String contacts[]);

	public void displayPhoeContacts(PhoneTrieNode rooot, String str);
	/* 9. Construct a unique matrix n x n for an input n */
	/* 10. Print unique rows in a given boolean matrix */

	/** 24. Find the k most frequent words from a file **/

}
