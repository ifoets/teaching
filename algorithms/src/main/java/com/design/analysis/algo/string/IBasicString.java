package com.design.analysis.algo.string;

import java.util.List;

/*
 * 
 * @author GuruG
	Basics :
	1.	Function to copy string
	2.	Pangram Checking
	3.	Missing characters to make a string Pangram
	4.	Check if a string is Pangrammatic Lipogram
	5.	Removing punctuations from a given string
	6.	Rearrange characters in a string such that no two adjacent are same
	7.	Program to check if input is an integer or a string
	8.	Quick way to check if all the characters of a string are same
	9.	Program to find the initials of a name
	10.	Check Whether a number is Duck Number or not
	11.	Round the given number to nearest multiple of 10
	12.	Change string to a new character set
	13.	Find one extra character in a string
 */
public interface IBasicString {

	/** 1. Function to copy string **/
	public void copyString(char[] s1, char[] s2);

	/** 2. Pangram Checking **/
	public boolean pangramChecking(String s);

	/** 3. Missing characters to make a string Pangram **/
	public List<Character> missingCharForpangram(String s);

	/** 4. Check if a string is Pangrammatic Lipogram **/
	public boolean isPangrammaticLipogram(String s);

	/** 5. Removing punctuations from a given string **/
	public String removePunctuation(String s);

	/** 6. Rearrange characters in a string such that no two adjacent are same **/
	public String rearrangeAdjNotSame(String s);

	/** 7. Program to check if input is an integer or a string **/
	public boolean isIntOrString(String s);

	/** 8. Quick way to check if all the characters of a string are same **/
	public boolean isAllcharSame(String s);

	/** 9. Program to find the initials of a name **/
	public List<Character> intitialOfName(String s);

	/** 10. Check Whether a number is Duck Number or not **/
	public boolean isDuckNumber(String s);

	/** 11. Round the given number to nearest multiple of 10 **/
	public int nearestRoudMulofTen(int n);

	/** 12. Change string to a new character set **/
	public String strTOnewCharSet(String s);
	/* 13. Find one extra character in a string */

	/***********************************************************************************************************************************************************************/
	/** 8. Print reverse of a string using recursion **/
	public String reverseString(String str);

	/** 9.Reverse an array without affecting special characters **/
	public String reverseSkipSpecialChar(String str);

	/** 10.Remove all duplicates from a given string **/
	public String removeDuplicate(String str);

	/** 13. Remove spaces from a given string **/
	public String removeSapce(String str);
}
