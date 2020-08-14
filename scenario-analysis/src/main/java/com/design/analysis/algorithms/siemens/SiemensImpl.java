package com.design.analysis.algorithms.siemens;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SiemensImpl implements ISiemens {

	/**
	 * Find duplicates in a file containing 6 digit numbers (like u id) in O (n)
	 * time.
	 * 
	 * @throws IOException
	 **/
	public int findDuplicateInFile() throws IOException {
		InputStreamReader isr = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("siemens.txt"));
		BufferedReader br = new BufferedReader(isr);
		String str = "";
		String curStr = "";
		while ((curStr = br.readLine()) != null) {
			str += curStr;
		}
		List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
		Set<String> set = new HashSet<>(list);
		for (String string : list) {
			if (set.contains(string))
				return Integer.valueOf(string);
			else
				set.add(string);
		}
		return -1;
	}

	/** Given an integer N. Convert it into MS Excel column string. **/
	public String interToMsExcelCol(int n) {

		StringBuilder str = new StringBuilder();
		while (n > 0) {
			char ch;
			if (n > 26)
				ch = (char) (65);
			else if (n == 26)
				ch = (char) (90);
			else
				ch = (char) (n % 26 + 64);
			str.append(ch);
			n = n - 26;
		}
		return str + "";
	}
}
