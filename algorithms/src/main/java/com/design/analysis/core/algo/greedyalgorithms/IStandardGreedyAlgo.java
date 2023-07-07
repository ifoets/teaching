package com.design.analysis.core.algo.greedyalgorithms;

import java.util.List;
import java.util.Queue;

import com.design.analysis.core.algo.branchandbound.model.KnapsackItem;
import com.design.analysis.core.algo.common.ActivityTime;
import com.design.analysis.core.algo.common.EgyptianFraction;
import com.design.analysis.core.algo.common.JobSequencing;
import com.design.analysis.core.algo.greedyalgorithms.model.HuffmanElement;
import com.design.analysis.core.algo.greedyalgorithms.model.HuffmanNode;
import com.design.analysis.core.algo.greedyalgorithms.model.JobSequen;
import com.design.analysis.core.algo.greedyalgorithms.model.LossMin;
import com.design.analysis.core.algo.greedyalgorithms.model.LossMinSequn;

/*
 * 
 * @author GuruG
 * 
 * Standard Greedy Algorithms :
 * 0-1 Knapsack Problem 
 * Fractional Knapsack Problem
 * /** max and min no of array element use to cross sum @guruji 
	1.	Activity Selection Problem
	
	2.	Egyptian Fraction
	3.	Job Sequencing Problem
	4.	Job Sequencing Problem (Using Disjoint Set)
	5.	Job Sequencing Problem � Loss Minimization
	6.	Job Selection Problem � Loss Minimization Strategy | Set 2
	7.	Huffman Coding
	8.	Efficient Huffman Coding for sorted input
	9.	Huffman Decoding
	10.	Water Connection Problem
	11.	Policemen catch thieves
	12.	Minimum Swaps for Bracket Balancing
	13.	Fitting Shelves Problem
	14.	Assign Mice to Holes

 */
interface IStandardGreedyAlgo {
	/** 0-1 Knapsack Problem **/
	public int knapsack01(int capacity, int val[], int wt[], int n);

	/** Fractional Knapsack Problem **/
	public long fractionalKnapsack(List<KnapsackItem> list, int W);

	/** max and min no of array element use to cross sum @guruji **/
	public int[] maxMinNoofElementUse(int arr[], int sum);

	/** 1. Activity Selection Problem **/
	public List<ActivityTime> activitySelection(List<ActivityTime> list);

	/** 2. Egyptian Fraction **/
	public List<EgyptianFraction> egyptianFraction(List<EgyptianFraction> result, int nr, int dr);

	/** 3. Job Sequencing Problem **/
	public List<String> jobSequencingProblem(List<JobSequencing> list);

	/** 4. Job Sequencing Problem (Using Disjoint Set) **/
	public List<JobSequen> jobSequencingProblemDisjointSet(List<JobSequen> list);

	/** 5. Job Sequencing Problem � Loss Minimization **/
	public List<LossMin> jobSequencingLossMinStrategy(List<LossMin> list);

	public List<LossMinSequn> jobSequencingLossMinStrategyX(List<LossMinSequn> list);

	/** 6. Job Selection Problem � Loss Minimization Strategy | Set 2 **/
	public double maxVolumeBestJobSelection(int vol[], double percentage);

	/** 7. Huffman Coding **/
	public HuffmanNode create(List<HuffmanElement> hufList);

	/* print the hufman code for string compression */
	public void printCode(HuffmanNode root, String str);

	// TODO result is not correct
	/** 8. Efficient Huffman Coding for sorted input **/
	public HuffmanNode efficientCreate(List<HuffmanElement> hufList);

	public HuffmanNode findMin(Queue<HuffmanNode> firstQueue, Queue<HuffmanNode> secondQueue);

	public void printCodes(HuffmanNode root, String str);

	/** 9. Huffman Decoding **/
	/* 10. Water Connection Problem */
	/* 11. Policemen catch thieves */
	/* 12. Minimum Swaps for Bracket Balancing */
	/* 13. Fitting Shelves Problem */
	/* 14. Assign Mice to Holes */
}
