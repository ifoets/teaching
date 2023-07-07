package com.design.analysis.core.algo.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CharCountImpl implements ICharCount {
	private static String EMPTY_STRING = "";

	/** 1. Return maximum occurring character in an input string **/
	@Override
	public Character maxOccuranceChar(String str) {
		if (str == null)
			return 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), 1 + map.get(str.charAt(i)));
			}
		}
		int maxCount = 0;
		char maxCountChar = '.';
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (maxCount < entry.getValue()) {
				maxCount = entry.getValue();
				maxCountChar = entry.getKey();
			}
		}
		return maxCountChar;
	}

	// without using libarary
	public Character maxOccuranceCharX(String str) {
		char[] strChr = str.toCharArray();
		int a[] = new int[26];
		for (int i = 0; i < str.length(); a[strChr[i] - 97]++, i++)
			;
		int max = a[0];
		char maxChar = 'a';
		for (int i = 1; i < 26; i++) {
			if (max < a[i]) {
				max = a[i];
				maxChar = (char) (i + 97);
			}
		}
		return maxChar;
	}

	/**
	 * 2.Find the smallest window in a string containing all characters of another
	 * string
	 **/
	@Override
	public String smallestWindow(String str, String pattern) {
		if (pattern.length() > str.length()) {
			return null;
		}
		List<Character> pattList = new ArrayList<>();
		List<Character> matchigList = null;
		for (int i = 0; i < pattern.length(); i++) {
			pattList.add(pattern.charAt(i));
		}

		String minWindow = str;
		for (int i = 0; i < str.length(); i++) {
			int start = -1;
			matchigList = new ArrayList<>(pattList);
			for (int k = i; k < str.length(); k++) {
				if (matchigList.contains(str.charAt(k))) {
					for (int l = 0; l < matchigList.size(); l++) {
						if (matchigList.get(l) == str.charAt(k)) {
							matchigList.remove(l);
							break;
						}
					}
					if (start == -1) {
						start = Integer.valueOf(k);
					}
					if (matchigList.size() == 0) {
						if (str.substring(start, k).length() < minWindow.length()) {
							minWindow = str.substring(start, k + 1);
						}
						break;
					}
				}
			}
		}
		return minWindow;
	}

	// TODO without use of libirary
	public String smallestWindowX(String str, String pattern) {
		/*
		 * char main[] = str.toCharArray(); char pat[] = str.toCharArray();
		 */
		/*
		 * ArrayList<Character> patL = null; for (int i = 0; i < main.length; i++) {
		 * patL = new ArrayList<>(pat);
		 * 
		 * for(int j=i;j<main.length;j++) {
		 * 
		 * }
		 */
		return null;
	}

	/** 3.program to find first second most frequent character **/
	@Override
	public Character firstKndMostChar(String str, int knd) {
		if (str == null)
			return null;

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), 1 + map.get(str.charAt(i)));
			}
		}
		Set<Entry<Character, Integer>> set = map.entrySet();
		List<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(set);
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		return list.get(knd - 1).getKey();
	}

	/** 4. K�th Non-repeating Character **/
	@Override
	public Character kthNonRepeatingChar(String str, int kth) {
		if (str == null)
			return null;

		Map<Character, Integer> map = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {
			if (!map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), 1);
			} else {
				map.put(str.charAt(i), 1 + map.get(str.charAt(i)));
			}
		}
		int i = 0;
		Character resultChar = null;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				i++;
			}
			if (i == kth) {
				resultChar = entry.getKey();
			}
		}
		if (kth > i)
			return null;
		return resultChar;
	}

	/** 5.Count number of substrings with exactly k distinct characters **/
	@Override
	public List<String> kDistinctChar(String str, int k) {
		if (str == null)
			return null;
		List<String> subStrList = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			for (int j = i; j < str.length(); j++) {
				subStrList.add(str.substring(i, j + 1));
			}
		}

		List<String> resultList = new ArrayList<>();
		Map<Character, Integer> map = null;

		for (String subStr : subStrList) {
			if (subStr.length() < k) {
				continue;
			}
			map = new HashMap<>();

			for (int i = 0; i < subStr.length(); i++) {
				map.put(str.charAt(i), 1);
			}
			if (map.size() == k) {
				resultList.add(subStr);
			}
		}
		return resultList;
	}

	/** 6. Find k�th character of decrypted string **/
	@Override
	public Character kthCharInDesrypted(String str, int kth) {
		String decriptedStr = EMPTY_STRING;

		String subDecripted = EMPTY_STRING;

		for (int i = 0; i < str.length(); i++) {
			int length = 0;
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
					length = length * 10 + Integer.valueOf(str.charAt(i) - 48);
					i++;
				}
				i--;
				for (int j = 0; j < length; j++) {
					decriptedStr += subDecripted;
				}
				subDecripted = EMPTY_STRING;
			} else {
				subDecripted += str.charAt(i);
			}
		}
		return decriptedStr.charAt(kth - 1);
	}

	public Character kthCharInDesryptedX(String str, int kth) {
		String original = EMPTY_STRING;
		int i;
		int j;
		for (i = 0; i < str.length();) {
			for (j = i; j < str.length(); j++) {
				if (str.charAt(j) >= '0' && str.charAt(j) <= '9') {
					int size = 0;
					int t = j;
					while (j < str.length() && str.charAt(j) >= '0' && str.charAt(j) <= '9') {
						// it may be more than 1 digit will be the digit contineously
						size = 10 * size + Integer.valueOf(str.charAt(j) + "");
						j++;
					}
					for (int k = 0; k < size; k++)
						original += str.substring(i, t);
					i = j;
					break;
				}

			}
		}
		return original.charAt(kth - 1);
	}

	/** 7.Count characters at same position as in English alphabets **/
	@Override
	public int exactPositionChar(String str) {
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (i == str.charAt(i) - 'a' || i == str.charAt(i) - 'A') {
				count++;
			}
		}
		return count;
	}

	/** 8. Check if two strings are k-anagrams or not **/
	@Override
	public boolean arekAnagrams(String str1, String str2, int k) {
		if (str1 != null && str2 != null && str1.length() != str2.length())
			return false;

		char cha1[] = str1.toCharArray();
		char cha2[] = str2.toCharArray();
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < cha1.length; i++)
			list.add(Character.valueOf(cha1[i]));

		for (int i = 0; i < cha2.length; i++) {
			if (list.contains(Character.valueOf(cha2[i])))
				list.remove(Character.valueOf(cha2[i]));
		}
		return list.size() <= k;
	}

	/** 9. Count words in a given string **/
	@Override
	public int countWords(String str) {
		boolean state = true; // OUT false IN
		int wc = 0; // word count
		int i = 0;

		// Scan all characters one by one
		while (i < str.length()) {
			if (str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t')
				state = true;
			else if (state) {
				state = false;
				++wc;
			}
			++i;
		}
		return wc;
	}

	/**
	 * 10. Count of words whose i-th letter is either (i-1)-th, i-th, or (i+1)-th
	 * letter of given word
	 **/
	@Override
	public int countWordsIthBefOrAfterSame(String str) {

		int len = str.length();
		int count = 1;
		if (str.length() == 1)
			return count;
		// take care first char here
		if (str.charAt(0) == str.charAt(1))
			count *= 1;
		else
			count *= 2;
		for (int i = 1; i < len - 1; i++) {// If all three letters are same.
			if (str.charAt(i) == str.charAt(i - 1) && str.charAt(i) == str.charAt(i + 1))
				count *= 1;

			// If two letter are distinct.
			else if (str.charAt(i) == str.charAt(i - 1) || str.charAt(i) == str.charAt(i + 1)
					|| str.charAt(i - 1) == str.charAt(i + 1))
				count *= 2;

			// If all three letter are distinct.
			else
				count *= 3;
		}
		// Checking for last letter.
		if (str.charAt(len - 1) == str.charAt(len - 2))
			count *= 1;
		else
			count *= 2;

		return count;
	}

	/** 11. Count substrings with same first and last characters O(n*n/2) **/
	@Override
	public int countSubstrWhereFirstLastSame(String str) {
		// all substing having 1 lenght;
		int n = str.length();
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (str.charAt(i) == str.charAt(j)) {
					count++;
				}
			}
		}
		return count;
	}

	/* by O(n) frq+1C2 */
	@Override
	public int countSubstrWhereFirstLastSameX(String str) {
		int result = 0;
		int n = str.length();

		// Calculating frequency of each character
		// in the string.
		int count[] = new int[26]; // 26 char
		for (int i = 0; i < n; i++)
			count[str.charAt(i) - 'a']++;

		// Computing result using counts
		for (int i = 0; i < 26; i++)
			result += (count[i] * (count[i] + 1) / 2);

		return result;
	}

	/** 12. Maximum consecutive repeating character in string O(n) **/
	public char maxConsecutiveChar(String str) {

		int n = str.length();
		int count = 0;
		char res = str.charAt(0);
		int cur_count = 1;

		// Traverse string except last character
		for (int i = 0; i < n; i++) {
			// If current character matches with next
			if (i < n - 1 && str.charAt(i) == str.charAt(i + 1))
				cur_count++;

			// If doesn't match, update result
			// (if required) and reset count
			else {
				if (cur_count > count) {
					count = cur_count;
					res = str.charAt(i);
				}
				cur_count = 1;
			}
		}
		return res;
	}

	/**
	 * 13. Count of strings that can be formed using a, b and c under given
	 * constraints
	 **/
	/*
	 * Given a length n, count the number of strings of length n that can be made
	 * using �a�, �b� and �c� with at-most one �b� and two �c�s allowed.
	 */
	public int stringFormation(String str) {
		int n;// total no of stirng formed form a,b,c repetatioin is allowed
		int n1;// string frmed by using 2b an 3b
		int n2;// string form by 3c
		n = 3 * 3 * 3;
		n1 = 2 * 3 + 1;// (3 with a and 3 with c havig 2b)+3b
		n2 = 1;// 3c
		return n - n1 - n2;
	}

	/** 14. Group words with same set of characters O(n*n) **/
	@Override
	public List<List<String>> groupSameSetCharWord(String[] words) {

		List<List<String>> ll = new ArrayList<>();
		List<String> li = null;
		Set<Character> set = new HashSet<>();
		Set<Character> set1 = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (list.contains(i))// it skip many
				continue;
			li = new ArrayList<>();
			li.add(words[i]);
			set.removeAll(set);
			for (int j = 0; j < words[i].length(); j++)
				set.add(words[i].charAt(j));

			for (int k = i + 1; k < words.length; k++) {
				set1.removeAll(set1);
				int l;
				for (l = 0; l < words[k].length(); l++) {
					set1.add(words[k].charAt(l));
					if (set1.size() > set.size())
						break;
				}
				if (set.size() == set1.size() && set.containsAll(set1) && l == words[k].length()) {
					li.add(words[k]);
					list.add(k);
				}
			}
			ll.add(li);
		}
		return ll;
	}
}
