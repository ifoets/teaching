package com.design.analysis.core.algo.string;

import java.util.List;
import java.util.Map;

/*
	 * Anagram :
	1.	Check whether two strings are anagram of each other
	2.	Given a sequence of words, print all anagrams together | Set 2
	3.	Anagram Substring Search
	4.	Print all pairs of anagrams in a given array of strings
	5.	Remove minimum number of characters so that two strings become anagram
	6.	Check if two strings are k-anagrams or not
	7.	Check if binary representations of two numbers are anagram
	8.	Given a sequence of words, print all anagrams together using STL
	9.	Check if all levels of two trees are anagrams or not
	10.	Count of total anagram substrings
	11.	Minimum Number of Manipulations required to make two Strings Anagram Without Deletion of Character

 */
public interface IAnagram {

	/** 1. Check whether two strings are anagram of each other **/
	public boolean anagramEachOther(String str1, String st2);

	/** 2. Given a sequence of words, print all anagrams together | Set 2 **/
	public List<String> togetherAangrams(String strArr[]);

	/** 3. Anagram Substring Search **/
	public List<Integer> searchIndex(String text, String pattern);

	/** 4. Print all pairs of anagrams in a given array of strings **/
	public Map<String, String> allPairOfAnagrams(String arr[]);

	/** 5. Remove minimum number of characters so two strings become anagram **/
	public List<Character> removeCharToMakeAnagram(String str1, String str2);

	/** 6. Check if two strings are k-anagrams or not **/
	public boolean checkKAnagram(String str1, String str2, int k);
}
