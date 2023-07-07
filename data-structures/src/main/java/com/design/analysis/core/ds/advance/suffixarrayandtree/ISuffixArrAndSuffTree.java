package com.design.analysis.core.ds.advance.suffixarrayandtree;

import com.design.analysis.core.ds.advance.suffixarrayandtree.model.Suffix;

/*
 * 
 * @author GuruG
 * 
 * Suffix Array and Suffix Tree :
 
1.	Suffix Array Introduction
2.	Suffix Array nLogn Algorithm
3.	kasai�s Algorithm for Construction of LCP array from Suffix Array
4.	Suffix Tree Introduction
5.	Ukkonen�s Suffix Tree Construction � Part 1
6.	Ukkonen�s Suffix Tree Construction � Part 2
7.	Ukkonen�s Suffix Tree Construction � Part 3
8.	Ukkonen�s Suffix Tree Construction � Part 4
9.	Ukkonen�s Suffix Tree Construction � Part 5
10.	Ukkonen�s Suffix Tree Construction � Part 6
11.	Generalized Suffix Tree
12.	Suffix Tree Application 1 � Substring Check
13.	Suffix Tree Application 2 � Searching All Patterns
14.	Suffix Tree Application 3 � Longest Repeated Substring
15.	Suffix Tree Application 4 � Build Linear Time Suffix Array
16.	Suffix Tree Application 5 � Longest Common Substring
17.	Suffix Tree Application 6 � Longest Palindromic Substring
18.	Print Kth character in sorted concatenated substrings of a string
 */
public interface ISuffixArrAndSuffTree {

	/** 1. Suffix Array Introduction **/
	public Suffix[] build(String str);

	/* aaply binary search since string is sorted order */
	public boolean search(Suffix[] sufArr, String ptrn);

	/** 2. Suffix Array nLogn Algorithm **/
	public int[] buildNlogN(String str);

	/** 3. kasai�s Algorithm for Construction of LCP array from Suffix Array **/

	/** 4. Suffix Tree Introduction **/
	
}
