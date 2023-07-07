package com.design.analysis.core.algo.branchandbound;

import java.util.List;

import com.design.analysis.core.algo.branchandbound.model.KnapsackItem;
import com.design.analysis.core.algo.branchandbound.node.KnapsackNode;
import com.design.analysis.core.algo.branchandbound.node.PuzzleNode;

/*
 * Branch and Bound:
1.	Branch and Bound | Set 1 (Introduction with 0/1 Knapsack) this is introduction
2.	Branch and Bound | Set 2 (Implementation of 0/1 Knapsack)
3.	Branch and Bound | Set 3 (8 puzzle Problem)
4.	Branch And Bound | Set 4 (Job Assignment Problem)
5.	Branch and Bound | Set 5 (N Queen Problem)
6.	Branch And Bound | Set 6 (Traveling Salesman Problem)

 */
public interface IBranchBound {
	/** 2. Branch and Bound | Set 2 (Implementation of 0/1 Knapsack) **/
	/*
	 * // Returns bound of profit in subtree rooted with u. // This function mainly
	 * uses Greedy solution to find // an upper bound on maximum profit.
	 */
	public int bound(List<KnapsackItem> items, KnapsackNode u, int W, int n);

	/* Returns maximum profit we can get with capacity W */
	public int knapsack(List<KnapsackItem> items, int W, int n);

	/** 3. Branch and Bound | Set 3 (8 puzzle Problem) **/

	public void printMatrix(int mat[][]);

	/* print path from root node to destination node */
	public void printPath(PuzzleNode root);

	/* Function to check if (x, y) is a valid matrix cordinate */
	public boolean isSafe(int x, int y);

	/*
	 * Function to calculate the the number of misplaced tiles ie. number of
	 * non-blank tiles not in their goal position
	 */
	public int calculateCost(int initl[][], int finl[][]);

	/*
	 * Function to solve N*N - 1 puzzle algorithm using Branch and Bound. x and y
	 * are blank tile coordinates in initial state
	 */
	public void sove8Puzzle(int initl[][], int finl[][], int x, int y);

	/** 4. Branch And Bound | Set 4 (Job Assignment Problem) **/
	public int findMinCost(int costMatrix[][]);

	/*
	 * Function to calculate the least promising cost of node after worker x is
	 * assigned to job y.
	 */
	public int calculateCost(int costMatrix[][], int x, int y, boolean assigned[]);

	/** 5. Branch and Bound | Set 5 (N Queen Problem) **/
	public boolean solveNQueens(int board[][]);

	public boolean solveNQueensUtil(int board[][], int col, int slashCode[][], int backslashCode[][],
			boolean rowLookup[], boolean slashCodeLookup[], boolean backslashCodeLookup[]);

	/** 6. Branch And Bound | Set 6 (Traveling Salesman Problem) **/

	/**********************************************************************************************************************************************************/
	// public List<Point> clogestPoints(List<Point> list);
}
