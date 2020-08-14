/**
 * 
 */
package com.design.analysis.algo.patternsearching;

import java.util.ArrayList;
import java.util.List;

/**
 * @author @Gurug
 *
 */
public class PatternSearchImpl implements IPatternSearch {

	/** 1. Naive Pattern Searching **/
	@Override
	public List<Integer> naivePatternSearch(String txt, String pat) {

		List<Integer> list = new ArrayList<>();
		int n = txt.length();
		int m = pat.length();
		int i, j;
		for (i = 0; i < n - m; i++) {
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == m)
				list.add(i);
		}
		return list;
	}

	/** 2. KMP Algorithm **/
	/*
	 * lps indicates longest proper prefix which is also suffix A proper prefix
	 * is prefix with whole string not allowed
	 */
	@Override
	public void computeLPSArray(String pat, int lps[]) {

		int n = pat.length();
		int len = 0;
		int i = 1; // start from 1
		lps[0] = 0;// always

		// the loop calculates lps[i] for i = 1 to M-1
		while (i < n) {

			if (pat.charAt(i) == pat.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
					// here i is not increasing
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

	@Override
	public List<Integer> KMPAlgorithm(String txt, String pat) {
		List<Integer> list = new ArrayList<>();
		int M = pat.length();
		int N = txt.length();

		// create lps[] that will hold the longest
		// prefix suffix values for pattern
		int lps[] = new int[M];
		int j = 0; // index for pat[]

		// Preprocess the pattern (calculate lps[]
		// array)
		computeLPSArray(pat, lps);

		int i = 0; // index for txt[]
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				list.add(i - j);
				j = lps[j - 1];
			}

			// mismatch after j matches
			else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				// Do not match lps[0..lps[j-1]] characters,
				// they will match anyway
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		return list;
	}

	/** 3. Rabin-Karp Algorithm **/
	@Override // TODO
	public List<Integer> rabinKarpAlgorithm(String txt, String pat) {
		return null;
	}

	/** 4. A Naive Pattern Searching Question for all character r different **/
	@Override
	public List<Integer> naivePatternSearchDiffCharPattern(String txt, String pat) {
		List<Integer> list = new ArrayList<>();
		int n = txt.length();
		int m = pat.length();
		int i, j;
		i = 0;
		while (i <= n - m) {
			for (j = 0; j < m; j++) {
				if (txt.charAt(i + j) != pat.charAt(j))
					break;
			}
			if (j == m) {
				list.add(i);
				i = i + m;
			}
			if (j == 0)
				i = i + 1;
			else {
				i = i + j;
			}
		}
		return list;
	}
}
