package com.design.analysis.core.ds.advance.suffixarrayandtree;

import java.util.Arrays;

import com.design.analysis.core.ds.advance.suffixarrayandtree.model.AdvSuffix;
import com.design.analysis.core.ds.advance.suffixarrayandtree.model.Suffix;

public class SuffixArrAndSuffTreeImpl implements ISuffixArrAndSuffTree {

	/** 1. Suffix Array Introduction **/
	/*
	 * Following are some famous problems where Suffix array can be used. 1) Pattern
	 * Searching 2) Finding the longest repeated substring 3) Finding the longest
	 * common substring 4) Finding the longest palindrome in a string
	 */
	@Override
	public Suffix[] build(String str) {

		Suffix[] sufArr = new Suffix[str.length()];
		for (int i = 0; i < str.length(); i++)
			sufArr[i] = new Suffix(i, str.substring(i, str.length()));
		Arrays.sort(sufArr);
		return sufArr;
	}

	@Override
	public boolean search(Suffix[] sufArr, String ptrn) {

		int l = 0, r = sufArr.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int res = ptrn.compareTo(sufArr[mid].sfix);

			if (res == 0)
				return true;
			if (res < 0)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return false;
	}

	/** 2. Suffix Array nLogn Algorithm **/
	@Override
	public int[] buildNlogN(String str) {

		int n = str.length();
		AdvSuffix[] sufx = new AdvSuffix[n];

		for (int i = 0; i < n; i++) {
			sufx[i] = new AdvSuffix(i, str.substring(i, str.length()));
			sufx[i].rank[0] = str.charAt(i) - 'a';
			sufx[i].rank[1] = ((i + 1) < n) ? (str.charAt(i + 1) - 'a') : -1;
		}

		Arrays.sort(sufx);
		int ind[] = new int[n];
		for (int k = 4; k < 2 * n; k = k * 2) {
			// Assigning rank and index values to first suffix
			int rank = 0;
			int prev_rank = sufx[0].rank[0];
			sufx[0].rank[0] = rank;
			ind[sufx[0].ind] = 0;

			// Assigning rank to suffixes
			for (int i = 1; i < n; i++) {
				if (sufx[i].rank[0] == prev_rank && sufx[i].rank[1] == sufx[i - 1].rank[1]) {
					prev_rank = sufx[i].rank[0];
					sufx[i].rank[0] = rank;
				} else // Otherwise increment rank and assign
				{
					prev_rank = sufx[i].rank[0];
					sufx[i].rank[0] = ++rank;
				}
				ind[sufx[i].ind] = i;
			}

			// Assign next rank to every suffix
			for (int i = 0; i < n; i++) {
				int nextindex = sufx[i].ind + k / 2;
				sufx[i].rank[1] = (nextindex < n) ? sufx[ind[nextindex]].rank[0] : -1;
			}

			// Sort the suffixes according to first k characters
			Arrays.sort(sufx);
		}

		// Store indexes of all sorted suffixes in the suffix array
		int suffixArr[] = new int[n];
		for (int i = 0; i < n; i++)
			suffixArr[i] = sufx[i].ind;

		// Return the suffix array
		return suffixArr;
	}
}
