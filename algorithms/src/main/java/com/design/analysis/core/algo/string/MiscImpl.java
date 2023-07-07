package com.design.analysis.core.algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MiscImpl implements IMisc {

	// 1. A Program to check if strings are rotations of each other or not
	@Override
	public boolean checkStringRotation(String str1, String str2) {
		if (str1 == null || str2 == null)
			return false;
		return (str2 + str2).contains(str1);
	}

	// 2. Print all the duplicates in the input string
	@Override
	public Map<Character, Integer> duplicateCount(String str) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}
		return map;
	}

	public Map<Character, Integer> duplicateCountX(String str) {
		str=str.replace(" ","").toLowerCase();
		Map<Character, Integer> map = new HashMap<>();
		int N = str.length();
		int ind[] = new int[26];
		System.out.println(str.charAt(0) - 97);
		for (int i = 0; i < N ; i++) {
			ind[str.charAt(i) - 97]++;
		}
		for (int i = 0; i < 26; i++) {
			if (ind[i] != 0) {
				map.put((char) (i + 97), ind[i]);
			}
		}
		return map;

	}

	// Given a string, find its first non-repeating character
	@Override
	public char firstNonReapetinChar(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();

		}
		return '-';
	}

	// Given a string, find its last non-repeating character
	@Override
	public char lastNonReapetinChar(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		Character result = null;
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				result = entry.getKey();

		}
		return result;
	}

	// Print list items containing all characters of a given word
	@Override
	public List<String> listItemContaingAllChar(String[] list, String key) {
		List<String> result = new ArrayList<>();
		Map<Character, Integer> map = null;

		for (String str : list) {
			map = new HashMap<>();
			for (int i = 0; i < str.length(); i++) {
				map.put(str.charAt(i), 1);
			}
			boolean found = true;
			for (int i = 0; i < key.length(); i++) {
				if (!map.containsKey(key.charAt(i))) {
					found = false;
					break;
				}
			}
			if (found) {
				result.add(str);
			}
		}
		return result;
	}

	// Reverse words in a given string
	@Override
	public String reverseWordInString(String str) {
		String strList[] = str.split(" ");
		int i = 0;
		int j = strList.length - 1;
		while (i < j) {
			String temp = strList[i];
			strList[i] = strList[j];
			strList[j] = temp;
			i++;
			j--;
		}
		String result = "";
		for (int k = 0; k < strList.length; k++) {
			if (k != strList.length - 1)
				result += reverseWord(strList[k]) + " ";
			else
				result += reverseWord(strList[k]);
		}
		return result;
	}

	// reverse word
	@Override
	public String reverseWord(String str) {
		char listChar[] = str.toCharArray();
		int i = 0;
		int j = listChar.length - 1;

		while (i < j) {
			char temp = listChar[i];
			listChar[i] = listChar[j];
			listChar[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(listChar);
	}

	// Run Length Encoded
	@Override
	public String runLengthEncoded(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			}
		}
		String result = "";
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			result += entry.getKey().toString() + map.get(entry.getKey());
		}
		return result;
	}

	public List<String> allPermutation = new ArrayList<>();

	// Print all permutations with repetition of characters
	@Override
	public void allPermutation(String prefix, String str) {
		if (prefix.length() == str.length()) {
			System.out.println(prefix);
			allPermutation.add(prefix);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			allPermutation(prefix + str.charAt(i), str);
		}
	}

	// Rearrange a string so that all same characters become d distance away
	// incomplete

	// Recursively remove all adjacent duplicates
	@Override
	public void removeAllAdjacent(String str) {
		/*
		 * List<Character> charList = new ArrayList<>();
		 * 
		 * for(int i=0;i<str.length();i++) { charList.add(str.charAt(i)); } boolean
		 * found = false; for(int i=0;i<str.length()-1;i++) { if(str.charAt(i) ==
		 * str.charAt(i+1)) { found = true; for(int j=i+1;j<str.length()-1;j++) {
		 * if(str.charAt(j-1)==str.charAt(j)) { charList.remove(j); } }
		 * charList.remove(i); } } String strNew=""; for(int k=0;k<charList.size();k++)
		 * { strNew+=charList.get(k); }
		 * 
		 * if(found) { removeAllAdjacent(strNew); } else { System.out.println(strNew); }
		 */

	}
}
