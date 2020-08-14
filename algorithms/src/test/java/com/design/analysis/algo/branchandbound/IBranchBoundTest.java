package com.design.analysis.algo.branchandbound;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
/*
 * Branch and Bound:
1.	Branch and Bound | Set 1 (Introduction with 0/1 Knapsack) this is just introduction
2.	Branch and Bound | Set 2 (Implementation of 0/1 Knapsack)
3.	Branch and Bound | Set 3 (8 puzzle Problem)
4.	Branch And Bound | Set 4 (Job Assignment Problem)
5.	Branch and Bound | Set 5 (N Queen Problem)
6.	Branch And Bound | Set 6 (Traveling Salesman Problem)

 */
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algo.branchandbound.model.KnapsackItem;
import com.design.analysis.algo.branchandbound.node.KnapsackNode;

public class IBranchBoundTest {

	public IBranchBound ibb = null;

	@Before
	public void init() {
		ibb = new BranchBoundImpl();
	}

	/** 2. Branch and Bound | Set 2 (Implementation of 0/1 Knapsack) **/
	/*
	 * // Returns bound of profit in subtree rooted with u. // This function mainly
	 * uses Greedy solution to find // an upper bound on maximum profit.
	 */
	@Test
	public void boundTest() {
		float a[][] = { { 1.8f, 3 }, { 1, 2 }, { 1, 2 } };
		List<KnapsackItem> list = new ArrayList<>();
		KnapsackItem item = null;
		for (int i = 0; i < a.length; i++) {
			item = new KnapsackItem(a[i][0], (int) a[i][1]);
			list.add(item);
		}
		KnapsackNode node = new KnapsackNode();
		node.bound = 0;
		node.level = 0;
		node.profit = 0;
		node.weight = 0;
		int bound = ibb.bound(list, node, 4, 3);
		Assert.assertTrue(bound == 4);
	}

	/* Returns maximum profit we can get with capacity W */
	@Test
	public void knapsackTest() {

		float a[][] = { { 2, 40 }, { 3.14f, 50 }, { 1.98f, 100 }, { 5, 95 }, { 3, 30 } };
		List<KnapsackItem> list = new ArrayList<>();
		KnapsackItem item = null;
		for (int i = 0; i < a.length; i++) {
			item = new KnapsackItem(a[i][0], (int) a[i][1]);
			list.add(item);
		}
		int maxProfit = ibb.knapsack(list, 10, list.size());
		Assert.assertTrue(maxProfit == 235);
	}

	/** 3. Branch and Bound | Set 3 (8 puzzle Problem) **/
	/*
	 * Function to calculate the the number of misplaced tiles ie. number of
	 * non-blank tiles not in their goal position
	 */
	@Test
	public void printMatrixTest() {
		int init[][] = { { 1, 2, 3 }, { 5, 6, 0 }, { 7, 8, 4 } };
		ibb.printMatrix(init);
		System.out.println("*****************");
	}

	@Test
	public void calculateCostTest() {
		int init[][] = { { 1, 2, 3 }, { 5, 6, 0 }, { 7, 8, 4 } };
		int finl[][] = { { 1, 2, 3 }, { 5, 8, 6 }, { 0, 7, 4 } };

		int cost1 = ibb.calculateCost(init, finl);
		Assert.assertTrue(cost1 == 4);
	}

	/*
	 * Function to solve N*N - 1 puzzle algorithm using Branch and Bound. x and y
	 * are blank tile coordinates in initial state
	 */
	@Test
	public void sove8PuzzleTest() {

		int init[][] = { { 1, 2, 3 }, { 5, 6, 0 }, { 7, 8, 4 } };
		int finl[][] = { { 1, 2, 3 }, { 5, 8, 6 }, { 0, 7, 4 } };

		// Blank tile coordinates in initial
		// configuration
		int x = 1, y = 2;

		ibb.sove8Puzzle(init, finl, x, y);
	}

	/** 4. Branch And Bound | Set 4 (Job Assignment Problem) **/
	@Test
	public void findMinCostTest() {
		int costMatrix[][] = { { 9, 2, 7, 8 }, { 6, 4, 3, 7 }, { 5, 8, 1, 8 }, { 7, 6, 9, 4 } };
		ibb.findMinCost(costMatrix);
	}

	/** 5. Branch and Bound | Set 5 (N Queen Problem) **/
	@Test
	public void solveNQueensTest() {
		ibb.solveNQueens(new int[8][8]);
	}
}
