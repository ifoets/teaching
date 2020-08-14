package com.design.analysis.algo.array;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algo.array.IOptimizationProblems;
import com.design.analysis.algo.array.OptimizationProblemsImpl;

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
public class IOptimizationProblemsTest {

	public IOptimizationProblems iop = null;

	@Before
	public void init() {
		iop = new OptimizationProblemsImpl();
	}

	/** 1. Largest Sum Contiguous Sub array **/
	@Test
	public void largestSumContiguousSubArrTest() {

		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		Assert.assertTrue(iop.largestSumContiguousSubArr(a) == 7);
	}

	@Test
	public void largestSumContiguousSubArrPosTest() {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
	
		
		System.out.println(iop.largestSumContiguousSubArrPos(a));
	}

	/** 2. Maximum profit by buying and selling a share at most twice **/
	public void maxProfileBuySellShareTest() {

	}

	/****************************************************************************************************************************************************************/
	/** 1. Largest Sum Contiguous Sub array return **/
	@Test
	public void largestSumContiguousSubArrayTest() {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		List<Integer> list = iop.largestSumContiguousSubArray(a);
		Assert.assertTrue(list.size() == 5);
		Assert.assertTrue(list.get(0) == 4);
		Assert.assertTrue(list.get(list.size() - 1) == 5);

	}
}
