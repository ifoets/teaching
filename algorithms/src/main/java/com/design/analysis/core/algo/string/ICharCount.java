package com.design.analysis.core.algo.string;

/*
 * Character Counting Based Problems :
1.	Return maximum occurring character in an input string
2.	Find the smallest window in a string containing all characters of another string
3.	C program to find second most frequent character
4.	K�th Non-repeating Character
5.	Count number of substrings with exactly k distinct characters
6.	Find k�th character of decrypted string
7.	Count characters at same position as in English alphabets
8.	Check if two strings are k-anagrams or not
9.	Count words in a given string
10.	Count of words whose i-th letter is either (i-1)-th, i-th, or (i+1)-th letter of given word
11.	Count substrings with same first and last characters
12.	Maximum consecutive repeating character in string
13.	Count of strings that can be formed using a, b and c under given constraints
14.	Group words with same set of characters
15.	Count of total anagram substrings
16.	Substring with highest frequency length product
17.	Number of even substrings in a string of digits
18.	Print all distinct characters of a string in order (3 Methods)
19.	Smallest window that contains all characters of string itself
20.	Print common characters of two Strings in alphabetical order
21.	Program to count occurrence of a given character in a string
22.	Minimum sum of squares of character counts in a given string after removing k characters
23.	Program to count vowels in a string (Iterative and Recursive)
24.	Number of distinct permutation a String can have
25.	Check if both halves of the string have same set of characters
26.	Count words that appear exactly two times in an array of words
27.	Check if frequency of all characters can become same by one removal
28.	Count ways to increase LCS length of two strings by one
29.	Print the string after the specified character has occurred given no. of times
30.	Remove characters from the first string which are present in the second string

 */
import java.util.List;

public interface ICharCount {
	/** 1. Return maximum occurring character in an input string **/
	public Character maxOccuranceChar(String str);

	// without using libarary
	public Character maxOccuranceCharX(String str);

	/**
	 * 2.Find the smallest window in a string containing all characters of another
	 * string
	 **/
	public String smallestWindow(String str, String pattern);

	// TODO without use of libirary
	public String smallestWindowX(String str, String pattern);

	/** 3.program to find first second most frequent character **/
	public Character firstKndMostChar(String str, int k);

	/** 4. K�th Non-repeating Character **/
	public Character kthNonRepeatingChar(String str, int kth);

	/** 5.Count number of substrings with exactly k distinct characters **/
	public List<String> kDistinctChar(String str, int k);

	/** 6. Find k�th character of decrypted string **/
	public Character kthCharInDesrypted(String str, int kth);

	public Character kthCharInDesryptedX(String str, int kth);

	/** 7.Count characters at same position as in English alphabets **/
	public int exactPositionChar(String str);

	/** 8. Check if two strings are k-anagrams or not **/
	public boolean arekAnagrams(String str1, String str2, int k);

	/** 9. Count words in a given string **/
	public int countWords(String str);

	/**
	 * 10. Count of words whose i-th letter is either (i-1)-th, i-th, or (i+1)-th
	 * letter of given word
	 **/
	public int countWordsIthBefOrAfterSame(String str);

	/** 11. Count substrings with same first and last characters **/
	/* by O(n*n) */
	public int countSubstrWhereFirstLastSame(String str);

	/* by O(n) */
	public int countSubstrWhereFirstLastSameX(String str);

	/** 12. Maximum consecutive repeating character in string **/
	public char maxConsecutiveChar(String str);

	/**
	 * 13. Count of strings that can be formed using a, b and c under given
	 * constraints
	 **/
	public int stringFormation(String str);

	/** 14. Group words with same set of characters **/
	public List<List<String>> groupSameSetCharWord(String[] words);
	/* 15. Count of total anagram substrings */
	/* 16. Substring with highest frequency length product */
	/* 17. Number of even substrings in a string of digits */
	/* 18. Print all distinct characters of a string in order (3 Methods) */
	/* 19. Smallest window that contains all characters of string itself */
	/* 20. Print common characters of two Strings in alphabetical order */
}
