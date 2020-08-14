package com.design.analysis.algo.string;

public class PalindromeImpl implements IPalindrome {

	/** 1. C Program to Check if a Given String is Palindrome **/
	// O(n2)
	public boolean isPalindrome(String str) {
		int l = 0;
		int r = str.length() - 1;
		while (l++ < r--) {
			if (str.charAt(l) != str.charAt(r))
				return false;
		}
		return true;
	}

	// O(n)
	public boolean isPalindromeX(String str) {
		int l = str.length();
		if (l % 2 == 0 && str.subSequence(0, l / 2).equals(str.subSequence(l / 2, l)))
			return true;
		if (l % 2 == 1 && str.subSequence(0, l / 2).equals(str.subSequence(l / 2 + 1, l)))
			return true;
		return false;

	}

	/** 2. Check if a given string is a rotation of a palindrome **/
	public String oneCharRotateString(String str) {
		return str.substring(1).concat(str.substring(0, 1));
	}

	// O(n2)
	public boolean isRotationOfPalindrome(String str) {
		for (int i = 0; i < str.length(); i++) {
			str = oneCharRotateString(str);
			if (isPalindrome(str))
				return true;
		}
		return false;
	}

	// O(n)
	public boolean isRotationOfPalindromeX(String str) {
		int l = str.length();
		String strAll = str + str;
		for (int i = 0; i < l; i++) {
			if (isPalindromeX(strAll.substring(i, i + l - 1)))
				return true;
		}
		return false;
	}

	/** 3. C++ Program to print all palindromes in a given range **/
	public boolean ispalindromeNum(int n) {
		int rev = 0;
		int no = n;
		while (n > 0) {
			rev = rev * 10 + n % 10;
			n = n / 10;
		}
		return rev == no;
	}

	public int countAllPalindrome(int min, int max) {
		int count = 0;
		for (int i = min; i <= max; i++) {
			if (ispalindromeNum(i))
				count++;
		}
		return count;
	}

	/** 4. Characters of string can be rearranged to form a palindrome **/
	// O(n)
	public boolean isReArrageInPlaindrome(String str) {
		char chArr[] = str.toLowerCase().toCharArray();
		int arr[] = new int[26];

		for (int i = 0; i < str.length(); arr[chArr[i] - 97]++, i++)
			;
		// count odd numbers of character
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1)
				count++;
			if (count > 1)
				return false;
		}
		return true;
	}

	/** 5. Minimum insertions to form a palindromes **/
	public int countInsertionMakePalindrom(String str) {

		char chArr[] = str.toLowerCase().toCharArray();
		int arr[] = new int[26];

		for (int i = 0; i < str.length(); arr[chArr[i] - 97]++, i++)
			;
		// count odd numbers of character
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] % 2 == 1)
				count++;
		}
		return count == 0 ? count : count - 1;
	}
}
