package com.design.analysis.algo.greedyalgorithms;

import java.util.List;

import com.design.analysis.algo.greedyalgorithms.model.Customer;
import com.design.analysis.algo.greedyalgorithms.model.StockPrice;
import com.design.analysis.algo.greedyalgorithms.model.TrainStatus;

/*
 * 
 * @author GuruG
 * 
 * Misc :
	1.	Split n into maximum composite numbers
	2.	Maximum trains for which stoppage can be provided
	3.	Buy Maximum Stocks if i stocks can be bought on i-th day
	4.	Find the minimum and maximum amount to buy all N candies
	5.	Maximum sum possible equal to sum of three stacks
	6.	Maximum elements that can be made equal with k updates
	7.	Divide cuboid into cubes such that sum of volumes is maximum
	8.	Maximum number of customers that can be satisfied with given quantity
	9.	Minimum Fibonacci terms with sum equal to K
	10.	Divide 1 to n into two groups with minimum sum difference
	11.	Minimize cash flow among friends
	12.	Minimum rotations to unlock a circular lock
	13.	Paper cut into minimum number of squares
	14.	Minimum difference between groups of size two
	15.	Minimum rooms for m events of n batches with given schedule
	16.	Connect n ropes with minimum cost
	17.	Minimum Cost to cut a board into squares
	18.	Minimum cost to process m tasks where switching costs
	19.	Minimum cost to make array size 1 by removing larger of pairs
	20.	Minimum cost for acquiring all coins with k extra coins allowed with every coin
	21.	Minimum time to finish all jobs with given constraints
	22.	Minimum number of Platforms required for a railway/bus station
	23.	Minimize the maximum difference between the heights of towers
	24.	Minimum increment by k operations to make all elements equal
	25.	Minimum edges to reverse to make path from a source to a destination
	26.	Find minimum number of currency notes and values that sum to given amount
	27.	Minimum initial vertices to traverse whole matrix with given conditions
	28.	Find the Largest Cube formed by Deleting minimum Digits from a number
	29.	Check if it is possible to survive on Island
	30.	Largest palindromic number by permuting digits
	31.	Smallest number with sum of digits as N and divisible by 10^N
	32.	Find Smallest number with given number of digits and digits sum
	33.	Rearrange characters in a string such that no two adjacent are same
	34.	Rearrange a string so that all same characters become d distance away
	35.	Print a closest string that does not contain adjacent duplicates
	36.	Smallest subset with sum greater than all other elements
	37.	Lexicographically largest subsequence such that every character occurs at least k times

 */
public interface IMiscGreedyAlgo {

	/** 1. Split n into maximum composite numbers **/
	public int splitIntoMaxCompoiteNums(int n);

	/** 2. Maximum trains for which stoppage can be provided **/
	public int maxStoppedTrain(List<TrainStatus> list);

	/** 3. Buy Maximum Stocks if i stocks can be bought on i-th day **/
	public int buyMaxStock(List<StockPrice> list, int price);

	/** 4. Find the minimum and maximum amount to buy all N candies **/
	public int minMaxAmountToBuyAllCandy(int prices[], int noOfOffer, boolean isMinOrMax);

	/** 5. Maximum sum possible equal to sum of three stacks **/
	public int maxSumEqualtoThreeStack(int stack1[], int stack2[], int stack3[]);

	/** 6. Maximum elements that can be made equal with k updates **/
	public int maxEquals(int a[], int k);

	/** 7. Divide cuboid into cubes such that sum of volumes is maximum **/
	public int sumOfVolIsMax(int l, int b, int h);

	/** 8. Maximum number of customers that can be satisfied with given quantity **/
	List<Character> maxStisfiedCustomer(List<Customer> list, int total, int bagsizeA, int bagSizeB);

	/** 9. Minimum Fibonacci terms with sum equal to K **/
	public int minFibonacciUse(int a, int b, int K);

	/** 10. Divide 1 to n into two groups with minimum sum difference **/
	public List<List<Integer>> minSumDiff2Group(int n);

	public int getMinDiffTwoGroup(List<Integer> firstL, List<Integer> secondL);
}
