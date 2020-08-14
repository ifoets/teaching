package com.design.analysis.algo.greedyalgorithms;

import java.util.List;

import com.design.analysis.algo.common.JobSequencing;

/*
 * 
 * @author GuruG
 * 
 * More Greedy Problems:
1.	Minimum time to finish all jobs with given constraints
2.	Job Sequencing Problem | Set 2 (Using Disjoint Set)
3.	Minimum sum of two numbers formed from digits of an array
4.	Find Smallest number with given number of digits and digits sum
5.	Connect n ropes with minimum cost
6.	Minimum number of Platforms required for a railway/bus station
7.	Minimum sum of absolute difference of pairs of two arrays
8.	Maximize sum of consecutive differences in a circular array
9.	Paper cut into minimum number of squares
10.	Minimize sum of product of two arrays with permutation allowed
11.	Lexicographically smallest array after at-most K consecutive swaps
12.	Rearrange characters in a string such that no two adjacent are same
13.	Maximum height pyramid from the given array of objects
14.	Minimum cost for acquiring all coins with k extra coins allowed with every coin
15.	Maximum sum possible equal to sum of three stacks
16.	Maximize array sum after k-negations | Set 1
17.	Maximize array sum after k-negations | Set 2
18.	Rearrange a string so that all same characters become d distance away
19.	Minimum Cost to cut a board into squares
20.	Minimize cash flow among friends
21.	Minimum edges to reverse to make path from a source to a destination
22.	Minimize the maximum difference between the heights of towers

 */
public interface IMixGreedyAlgo {

	/** 1. Minimum time to finish all jobs with given constraints **/
	public Integer minTimeToFinishJobByKEmpl(Integer jobTime[], int emp, int workTime);

	/** 2. Job Sequencing Problem | Set 2 (Using Disjoint Set) **/
	public List<String> jobSequencingProblem(List<JobSequencing> list);

	/** 3. Minimum sum of two(X) numbers formed from digits of an array **/
	public int minSumOfTwoNoFormByAllElem(int a[], int xNums);

	/** 4. Find Smallest number with given number of digits and digits sum **/

	/* it check for 1 not then for 2 so on.... */
	public boolean comfortableForLeastDigit(int minDigit, int sum, int noOfDigits);

	public Integer minNoByGivenSumAndNoOfDigit(int sum, int noOfDigits);

	/** 5. Connect n ropes with minimum cost **/
	public Integer connectNRopsInMinCost(Integer ropArr[]);

	/** 6. Minimum number of Platforms required for a railway/bus station **/
	public Integer minNoOfPlatform(int[] arrivalTimes, int[] departureTimes);

	/** 7. Minimum sum of absolute difference of pairs of two arrays **/
	public Integer minSumByDiffOfTowArr(int a[], int b[]);

	/** 8. Maximize sum of consecutive differences in a circular array **/
	public Integer maxSumConsDifOfCircularArr(int a[]);

	/** 9. Paper cut into minimum number of squares **/
	public Integer cutPaperIntoMinNoOfSquare(int height, int width);

	/** 10. Minimize sum of product of two arrays with permutation allowed **/
	public Integer minSumOfProductOfTwoArrays(Integer a[], Integer b[]);

	/* 11. Lexicographically smallest array after at-most K consecutive swaps */

	/* 12. Rearrange characters in a string such that no two adjacent are same */
	/* 13. Maximum height pyramid from the given array of objects */
	/*
	 * 14. Minimum cost for acquiring all coins with k extra coins allowed with
	 * every coin
	 */
	/* 15. Maximum sum possible equal to sum of three stacks */
}
