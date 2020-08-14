/**
 * 
 */
package com.design.analysis.algo.patternsearching;

import java.util.List;

/**
 * @author @Gurug
 *Pattern Searching:
 *
	 1.	Naive Pattern Searching
	 2.	KMP Algorithm
	 3.	Rabin-Karp Algorithm
	 4.	A Naive Pattern Searching Question
	 5.	Finite Automata
	 6.	Efficient Construction of Finite Automata
	 7.	Boyer Moore Algorithm – Bad Character Heuristic
	 8.	Suffix Array
	 9.	Anagram Substring Search (Or Search for all permutations)
	 10.	Pattern Searching using a Trie of all Suffixes
	 11.	Aho-Corasick Algorithm for Pattern Searching
	 12.	kasai’s Algorithm for Construction of LCP array from Suffix Array
	 13.	Z algorithm (Linear time pattern searching Algorithm)
**/
public interface IPatternSearch {

	/** 1. Naive Pattern Searching **/
	public List<Integer> naivePatternSearch(String txt, String pat);

	/** 2. KMP Algorithm **/
	/*
	 * lps indicates longest proper prefix which is also suffix A proper prefix
	 * is prefix with whole string not allowed
	 */
	public void computeLPSArray(String pat, int lps[]);

	public List<Integer> KMPAlgorithm(String txt, String pat);
	
	/** 3.	Rabin-Karp Algorithm**/
	public List<Integer> rabinKarpAlgorithm(String txt, String pat);
	
	/** 4.	A Naive Pattern Searching Question for all character r different**/
	public List<Integer> naivePatternSearchDiffCharPattern(String txt, String pat);
	
}
