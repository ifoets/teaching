package com.design.analysis.algo.string;

/*
 * 
	 * Binary String :
	1.	Count of operations to make a binary string”ab” free
	2.	Change if all bits can be made same by single flip
	3.	Length of Longest sub-string that can be removed
	4.	Number of flips to make binary string alternate
	5.	1’s and 2’s complement of a Binary Number
	6.	Efficient method for 2’s complement of a binary string
	7.	Count binary strings with k times appearing adjacent two set bits
	8.	Count strings with consecutive 1’s
	9.	Generate all binary strings from given pattern
	10.	Add two bit strings
	11.	Count number of binary strings without consecutive 1’s
	12.	Generate all binary permutations such that there are more or equal 1’s than 0’s before every point in all permutations
	13.	Check if a string follows a^nb^n pattern or not
	14.	Binary representation of next number
	15.	Binary representation of next greater number with same number of 1’s and 0’s
	16.	Maximum difference of zeros and ones in binary string
	17.	Check if a binary string has a 0 between 1s or not | Set 2
	18.	Min flips of continuous characters to make all characters same in a string
	19.	Concatenation of two strings in PHP
	20.	Program to add two binary strings
	21.	Convert String into Binary Sequence
	22.	Generate all binary strings without consecutive 1’s
	23.	Minimum number of characters to be removed to make a binary string alternate
	24.	Check divisibility of binary string by 2^k
	25.	Removing elements between the two zeros
	26.	Find i’th Index character in a binary string obtained after n iterations
	27.	Number of substrings with odd decimal value in a binary string
	28.	Generate n-bit Gray Codes
	29.	Print N-bit binary numbers having more 1’s than 0’s in all prefixes
	30.	Add n binary strings

 */
public interface IBinaryString {

	/** 1. Count of operations to make a binary string”ab” free **/
	public int countFreeAdjecentBinary(String str, String binary, String replacement);

	/** 2. Change if all bits can be made same by single flip **/
	public boolean canMakeAllSame(String str);

	/** 3. Length of Longest sub-string that can be removed **/
	public String longestStringRemove(String str, String key);

	/** 4. Number of flips to make binary string alternate **/
	public int minFlipMakeAlternative(String str);

	/** 5. 1’s and 2’s complement of a Binary Number **/
	public String onceComplement(String str);

	public String twondComplement(String str);

}
