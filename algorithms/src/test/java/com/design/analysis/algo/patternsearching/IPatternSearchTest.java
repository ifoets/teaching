/**
 * 
 */
package com.design.analysis.algo.patternsearching;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author @Gurug
 *
 */
public class IPatternSearchTest {

	public IPatternSearch ips = null;

	@Before
	public void init() {
		ips = new PatternSearchImpl();
	}

	/** 1. Naive Pattern Searching **/
	@Test
	public void naivePatternSearchTest() {
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		List<Integer> list = ips.naivePatternSearch(txt, pat);
		Assert.assertTrue(list.size() == 3);
		Assert.assertTrue(list.get(0) == 0);
		Assert.assertTrue(list.get(1) == 9);
		Assert.assertTrue(list.get(2) == 13);

		txt = "THIS IS A TEST TEXT";
		pat = "TEST";
		list = ips.naivePatternSearch(txt, pat);
		Assert.assertTrue(list.size() == 1);
		Assert.assertTrue(list.get(0) == 10);
	}

	/** 2. KMP Algorithm **/

	@Test
	public void computeLPSArrayTest() {
		String pat = "AAAA";
		int lps[] = new int[pat.length()];
		ips.computeLPSArray(pat, lps);
		Assert.assertTrue(lps[0] == 0);
		Assert.assertTrue(lps[1] == 1);
		Assert.assertTrue(lps[2] == 2);
		Assert.assertTrue(lps[3] == 3);

		pat = "ABCDE";
		lps = new int[pat.length()];

		ips.computeLPSArray(pat, lps);
		Assert.assertTrue(lps[0] == 0);
		Assert.assertTrue(lps[1] == 0);
		Assert.assertTrue(lps[2] == 0);
		Assert.assertTrue(lps[3] == 0);
		Assert.assertTrue(lps[4] == 0);

		pat = "AABAACAABAA";
		lps = new int[pat.length()];

		ips.computeLPSArray(pat, lps);
		String st = "";
		for (int i = 0; i < lps.length; i++)
			st += lps[i];
		Assert.assertTrue(st.equals("01012012345"));
	}

	@Test
	public void KMPAlgorithmTest() {

		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		List<Integer> list = ips.KMPAlgorithm(txt, pat);
		Assert.assertTrue(list.size() == 3);
		Assert.assertTrue(list.get(0) == 0);
		Assert.assertTrue(list.get(1) == 9);
		Assert.assertTrue(list.get(2) == 13);

		txt = "THIS IS A TEST TEXT";
		pat = "TEST";
		list = ips.KMPAlgorithm(txt, pat);
		Assert.assertTrue(list.size() == 1);
		Assert.assertTrue(list.get(0) == 10);

		txt = "ABABDABACDABABCABAB";
		pat = "ABABCABAB";
		list = ips.KMPAlgorithm(txt, pat);
		Assert.assertTrue(list.size() == 1);
		Assert.assertTrue(list.get(0) == 10);
	}

	@Test
	public void naivePatternSearchDiffCharPatternTest() {
		String txt = "ABCEABCDABCEABCD";
		String pat = "ABCD";

		List<Integer> list = ips.naivePatternSearchDiffCharPattern(txt, pat);
		Assert.assertTrue(list.size() == 2);

		Assert.assertTrue(list.get(1) == 12);
		Assert.assertTrue(list.get(0) == 4);
	}
}