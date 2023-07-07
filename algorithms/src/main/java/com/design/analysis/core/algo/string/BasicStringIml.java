package com.design.analysis.core.algo.string;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BasicStringIml implements IBasicString {

	private static String EMPTY_STRING = "";

	/** 1. Function to copy string **/
	@Override
	public void copyString(char[] s1, char[] s2) {
		// copy s1 to s2
		if (s1.length <= s2.length)
			for (int i = 0; i < s1.length; s2[i] = s1[i], i++)
				;
	}

	/** 2. Pangram Checking **/
	@Override
	public boolean pangramChecking(String s) {
		boolean[] isChar = new boolean[26];
		int count = 0;
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				continue;
			if (!isChar[s.charAt(i) - 97]) {
				isChar[s.charAt(i) - 97] = true;
				count++;
			}
			if (count == 26)
				return true;
		}
		return false;
	}

	/** 3. Missing characters to make a string Pangram **/
	@Override
	public List<Character> missingCharForpangram(String s) {
		List<Character> clist = new ArrayList<>();
		boolean[] isChar = new boolean[26];

		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ')
				continue;
			if (!isChar[s.charAt(i) - 97])
				isChar[s.charAt(i) - 97] = true;
		}
		for (int i = 0; i < isChar.length; i++)
			if (!isChar[i])
				clist.add(Character.valueOf((char) (i + 97)));
		return clist;
	}

	/** 4. Check if a string is Pangrammatic Lipogram **/
	public boolean isPangrammaticLipogram(String s) {
		return missingCharForpangram(s).size() == 1;
	}

	/** 5. Removing punctuations from a given string **/
	@Override
	public String removePunctuation(String str) {
		return str.replaceAll("\\p{Punct}", "");
	}

	/** 6. Rearrange characters in a string such that no two adjacent are same **/
	@Override
	public String rearrangeAdjNotSame(String s) {

		char sArr[] = s.toCharArray();
		for (int i = 0; i < s.length() - 1; i++) {
			if (sArr[i] == sArr[i + 1]) {
				int j = i + 1;
				boolean isFound = false;
				while (j < s.length()) {
					if (sArr[i + 1] != sArr[j]) {
						isFound = true;
						char temp = sArr[i + 1];
						sArr[i + 1] = sArr[j];
						sArr[j] = temp;
						break;
					}
					j++;
				}
				if (!isFound) {
					System.out.println("Not possible");
					return s;
				}
			}
		}
		return String.valueOf(sArr);
	}

	/** 7. Program to check if input is an integer or a string **/
	@Override
	public boolean isIntOrString(String s) {
		s = s.toLowerCase();
		char[] sArr = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (sArr[i] >= 97 && sArr[i] <= 122)
				return false;
		}
		return true;
	}

	/** 8. Quick way to check if all the characters of a string are same **/
	@Override
	public boolean isAllcharSame(String s) {
		int n = s.length();
		for (int i = 1; i < n; i++)
			if (s.charAt(i) != s.charAt(0))
				return false;
		return true;
	}

	/** 9. Program to find the initials of a name **/
	@Override
	public List<Character> intitialOfName(String name) {
		if (name.length() == 0)
			return null;

		List<Character> list = new ArrayList<>();
		list.add(Character.toUpperCase(name.charAt(0)));

		for (int i = 1; i < name.length() - 1; i++)
			if (name.charAt(i) == ' ')
				list.add(Character.toUpperCase(name.charAt(i + 1)));
		return list;
	}

	/** 10. Check Whether a number is Duck Number or not **/
	@Override
	public boolean isDuckNumber(String num) {
		// Length of the number(number of digits)
		int len = num.length();
		int count_zero = 0;
		char first_digit1 = num.charAt(0);
		char ch;

		for (int i = 1; i < len; i++) {
			// Checking for a digit whether it is a '0' or not
			ch = num.charAt(i);
			if (ch == '0')
				count_zero++;
		}
		if (count_zero > 0 && first_digit1 != '0')
			return true;
		return false;
	}

	/** 11. Round the given number to nearest multiple of 10 **/
	@Override
	public int nearestRoudMulofTen(int n) {
		// Smaller multiple
		int a = (n / 10) * 10;

		// Larger multiple
		int b = a + 10;

		// Return of closest of two
		return (n - a > b - n) ? b : a;
	}

	/** 12. Change string to a new character set **/
	@Override
	public String strTOnewCharSet(String s) {
		return null;
	}

	/***********************************************************************************************************************************************************************/
	/** 8. Print reverse of a string using recursion **/
	@Override
	public String reverseString(String str) {
		if (str == null)
			return null;
		if (str.length() == 0)
			return EMPTY_STRING;
		else {
			return reverseString(str.substring(1, str.length())) + str.substring(0, 1);
		}
	}

	/** 9.Reverse an array without affecting special characters **/
	@Override
	public String reverseSkipSpecialChar(String str) {
		char arr[] = str.toCharArray();
		int i = 0;
		int j = arr.length - 1;

		while (i < j) {

			if (!(arr[i] >= 'a' && arr[i] < 'z') && !(arr[i] >= 'A' && arr[i] < 'Z')) {
				i++;
			}

			if (!(arr[j] >= 'a' && arr[j] < 'z') && !(arr[j] >= 'A' && arr[j] < 'Z')) {
				j--;
			}

			if (((arr[i] >= 'a' && arr[i] < 'z') || (arr[i] >= 'A' && arr[i] < 'Z'))
					&& ((arr[j] >= 'a' && arr[j] < 'z') || (arr[j] >= 'A' && arr[j] < 'Z'))) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		str = new String(arr);
		return str;
	}

	/** 10.Remove all duplicates from a given string **/
	@Override
	public String removeDuplicate(String str) {
		if (str == null)
			return str;
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {
			map.put(str.charAt(i), 1);
		}

		String strResult = EMPTY_STRING;
		for (Map.Entry<Character, Integer> entry : map.entrySet())
			strResult += entry.getKey().toString();
		return strResult;
	}

	/** 13. Remove spaces from a given string **/
	@Override
	public String removeSapce(String str) {

		String rsult = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				rsult += str.charAt(i);
		}
		return rsult;
	}
}
