package com.design.analysis.core.algo.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.core.algo.string.node.Anag;

public class AnagramImpl implements IAnagram {

	public static final int NO_OF_CHARS = 26;

	/** 1. Check whether two strings are anagram of each other **/
	// O(n)
	public boolean anagramEachOther(String str1, String str2) {
		int i = 0;
		if (str1.length() != str2.length())
			return false;
		int arr[] = new int[NO_OF_CHARS];
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		for (; i < str1.length(); arr[str1.charAt(i) - 97]++, arr[str2.charAt(i) - 97]--, i++)
			;
		for (i = 0; i < NO_OF_CHARS; i++) {
			if (arr[i] != 0)
				return false;
		}
		return true;
	}

	/** 2. Given a sequence of words, print all anagrams together | Set 2 **/
	public List<String> togetherAangrams(String strArr[]) {

		List<Anag> list = new ArrayList<>();
		List<String> resultList = new ArrayList<>();

		for (String str : strArr) {
			char charr[] = str.toCharArray();
			Arrays.sort(charr);
			String strSoted = new String(charr);
			list.add(new Anag(str, strSoted));
		}
		Collections.sort(list);
		for (Anag ang : list) {
			resultList.add(ang.org);
		}
		return resultList;
	}

	/** 3. Anagram Substring Search **/
	public List<Integer> searchIndex(String text, String pattern) {
		List<Integer> list = new ArrayList<>();
		int N = text.length();
		int M = pattern.length();
		for (int i = 0; i < N - M + 1; i++) {
			if (anagramEachOther(text.substring(i, i + M), pattern))
				list.add(i);
		}
		return list;
	}

	/** 4. Print all pairs of anagrams in a given array of strings **/
	// O(n)
	public Map<String, String> allPairOfAnagrams(String arr[]) {
		int l = arr.length;
		Map<String, String> map = new HashMap<>();
		Map<String, String> mapCheck = new HashMap<>();
		for (int i = 0; i < l; i++) {
			String strKey = arr[i];
			char charr[] = strKey.toCharArray();
			Arrays.sort(charr);
			String strSoted = new String(charr);
			if (mapCheck.containsKey(strSoted)) {
				map.put(mapCheck.get(strSoted), arr[i]);
			} else {
				mapCheck.put(strSoted, arr[i]);
			}
		}
		return map;
	}

	/** 5. Remove minimum number of characters so two strings become anagram **/
	public List<Character> removeCharToMakeAnagram(String str1, String str2) {
		List<Character> listChar = new ArrayList<>();

		int N = str1.length();
		int M = str2.length();
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		int a[] = new int[NO_OF_CHARS];
		for (int i = 0; i < N; a[str1.charAt(i) - 97]++, i++)
			;
		for (int i = 0; i < M; a[str2.charAt(i) - 97]--, i++)
			;

		for (int i = 0; i < NO_OF_CHARS; i++) {
			if (a[i] != 0) {
				for (int j = 0; j < Math.abs(a[i]); listChar.add((char) (i + 97)), j++)
					;
			}
		}
		return listChar;
	}

	/** 6. Check if two strings are k-anagrams or not **/
	public boolean checkKAnagram(String str1, String str2, int k) {
		int N = str1.length();
		int M = str2.length();
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		if (N != M)
			return false;
		int a[] = new int[NO_OF_CHARS];
		for (int i = 0; i < N; a[str1.charAt(i) - 97]++, i++)
			;
		for (int i = 0; i < N; i++) {
			if (a[str2.charAt(i) - 97] != 0) {
				a[str2.charAt(i) - 97]--;
			}
		}
		for (int i = 0; i < NO_OF_CHARS; i++) {
			if (a[i] != 0)
				k -= a[i];
		}
		return k >= 0;
	}
}
