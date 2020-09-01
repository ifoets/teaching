package com.design.analysis.hackerrank.algo.medium.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MediumStringImpl implements IMediumString {

	/** Sherlock and the Valid String **/
	@Override
	public String isSherlockValidString(String s) {
		if (s.length() == 1)
			return "YES";

		int a[] = new int[26];
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); a[s.charAt(i) - 97]++, i++)
			;

		List<Integer> list = new ArrayList<>();
		for (int j = 0; j < 26; j++) {
			if(a[j]!=0)
			list.add(a[j]);
		}
		Collections.sort(list);
		int count = 0;
		for (int k = 0, n = list.size(); k < n - 1; k++) {
			if (a[0] != a[k + 1])
				count++;
			if (count > 1)
				return "NO";
		}
		return "YES";
	}
	
	/** Highest Value Palindrome **/
	public String highestValuePalindrome(String s, int n, int k) {
	
		char[] chArr = s.toCharArray();
		return null;
	}
}
