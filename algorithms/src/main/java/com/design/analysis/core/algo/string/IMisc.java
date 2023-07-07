package com.design.analysis.core.algo.string;

import java.util.List;
import java.util.Map;

public interface IMisc {

	// 1. A Program to check if strings are rotations of each other or not
	public boolean checkStringRotation(String str1, String str2);

	// 2. Print all the duplicates in the input string
	public Map<Character, Integer> duplicateCount(String str);

	public Map<Character, Integer> duplicateCountX(String str);

	// Given a string, find its first non-repeating character
	// IDEA create linke list with node(char,index)
	public char firstNonReapetinChar(String str);

	// IDEA create linke list with node(char,index)
	// Given a string, find its last non-repeating character
	public char lastNonReapetinChar(String str);

	// Print list items containing all characters of a given word
	public List<String> listItemContaingAllChar(String[] list, String key);

	// Reverse words in a given string
	public String reverseWordInString(String str);

	// reverse word
	public String reverseWord(String str);

	// Run Length Encoded
	public String runLengthEncoded(String str);

	// Print all permutations with repetition of characters
	public void allPermutation(String prefix, String str);

	// Rearrange a string so that all same characters become d distance away
	// incomplete
	// Recursively remove all adjacent duplicates
	public void removeAllAdjacent(String str);
}
