package com.design.analysis.core.algo.array;

import java.util.ArrayList;
import java.util.List;

/*
 * Optimization Problems :
	1.	Largest Sum Contiguous Subarray
	2.	Maximum profit by buying and selling a share at most twice
	3.	Find the subarray with least average
	4.	Find the minimum distance between two numbers
	5.	Minimize the maximum difference between the heights
	6.	Minimum number of jumps to reach end
	7.	Dynamic Programming | Set 14 (Maximum Sum Increasing Subsequence)
	8.	Smallest subarray with sum greater than a given value
	9.	Find maximum average subarray of k length
	10.	Count minimum steps to get the given desired array
	11.	Number of subsets with product less than k
	12.	Find minimum number of merge operations to make an array palindrome
	13.	Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
	14.	Size of The Subarray With Maximum Sum
	15.	Find minimum difference between any two elements
	16.	Space optimization using bit manipulations
	17.	Longest Span with same Sum in two Binary arrays


 */
public class OptimizationProblemsImpl implements IOptimizationProblems {

	/** 1. Largest Sum Contiguous Sub array **/
	@Override
	public int largestSumContiguousSubArr(int a[]) {

		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;

		for (int i = 0; i < a.length; i++) {
			maxEndingHere = maxEndingHere + a[i];
			if (maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
			if (maxEndingHere < 0)
				maxEndingHere = 0;
		}
		return maxSoFar;

	}

	@Override
	public int[] largestSumContiguousSubArrPos(int a[]) {
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;
		int pos[] = new int[2];
		for (int i = 0; i < a.length; i++) {
			maxEndingHere = maxEndingHere + a[i];
			if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
				pos[1] = i;
			}
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
				pos[0] = i;
			}
		}
		return pos;
	}

	/** 2. Maximum profit by buying and selling a share at most twice **/
	@Override // TODO
	public int maxProfileBuySellShare(int a[]) {
		return 0;
	}

	/****************************************************************************************************************************************************************/
	/** 1. Largest Sum Contiguous Sub array return **/
	@Override
	public List<Integer> largestSumContiguousSubArray(int a[]) {

		List<Integer> resultList = new ArrayList<>();
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndingHere = 0;

		for (int i = 0; i < a.length; i++) {
			maxEndingHere = maxEndingHere + a[i];
			resultList.add(a[i]);
			if (maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
			if (maxEndingHere < 0) {
				resultList = new ArrayList<>();
				maxEndingHere = 0;
			}
		}
		/* last element added */
		resultList.remove(resultList.size() - 1);
		return resultList;
	}
}
