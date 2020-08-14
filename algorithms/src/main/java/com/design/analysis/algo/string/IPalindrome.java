package com.design.analysis.algo.string;

/*
 * 
	 * Palindrome :
	1.	C Program to Check if a Given String is Palindrome
	2.	Check if a given string is a rotation of a palindrome
	3.	C++ Program to print all palindromes in a given range
	4.	Check if characters of a given string can be rearranged to form a palindrome
	5.	Dynamic Programming | Set 28 (Minimum insertions to form a palindrome)
	6.	Longest Palindromic Substring | Set 2
	7.	Find all palindromic sub-strings of a given string
	8.	Online algorithm for checking palindrome in a stream
	9.	Given a string, print all possible palindromic partitions
	10.	Print all palindromic partitions of a string
	11.	Dynamic Programming | Set 17 (Palindrome Partitioning)
	12.	Count All Palindromic Subsequence in a given String
	13.	Minimum characters to be added at front to make string palindrome
	14.	Palindrome Substring Queries
	15.	Suffix Tree Application 6 – Longest Palindromic Substring
	16.	Palindrome pair in an array of words (or strings)
	17.	Make largest palindrome by changing at most K-digits
	18.	Lexicographically first palindromic string
	19.	Recursive function to check if a string is palindrome
	20.	Minimum number of Appends needed to make a string palindrome
	21.	Longest Non-palindromic substring
	22.	Minimum number of deletions to make a string palindrome
	23.	Minimum steps to delete a string after repeated deletion of palindrome substrings
	24.	Count of Palindromic substrings in an Index range
	25.	Minimum insertions to form a palindrome with permutations allowed
	26.	Nth Even length Palindrome

 */
public interface IPalindrome {

	/** 1. C Program to Check if a Given String is Palindrome **/
	public boolean isPalindrome(String str);

	public boolean isPalindromeX(String str);

	/** 2. Check if a given string is a rotation of a palindrome **/

	public String oneCharRotateString(String str);

	// O(n2)
	public boolean isRotationOfPalindrome(String str);

	// O(n)
	public boolean isRotationOfPalindromeX(String str);

	/** 3. C++ Program to print all palindromes in a given range **/
	public boolean ispalindromeNum(int n);

	public int countAllPalindrome(int min, int max);

	/** 4. Characters of string can be rearranged to form a palindrome **/
	public boolean isReArrageInPlaindrome(String str);

	/** 5. Minimum insertions to form a palindromes **/
	public int countInsertionMakePalindrom(String str);
}
