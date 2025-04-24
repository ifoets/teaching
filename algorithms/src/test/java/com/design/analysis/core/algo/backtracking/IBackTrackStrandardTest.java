package com.design.analysis.core.algo.backtracking;

import java.util.List;

import com.design.analysis.core.algo.backtracking.utils.BackTrackingUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBackTrackStrandardTest {

	public IBackTrackStrandard ibts = null;

	@Before
	public void init() {
		ibts = new BackTrackStrandardImpl();
	}

	/** 0.Backtracking Array **/
	@Test
	public void nonZero() {
		int a[] = { 1, 1, 1, 1, 1, 0 };
		ibts.nonZero(a);
		int b[] = { 1, 1, 1, 1, 1, 1 };
		ibts.nonZero(b);
		int c[] = { 1, 1, 1, 0, 1, 1 };
		ibts.nonZero(c);
	}

	/** 0.1 Backtracking max len non zero **/
	@Test
	public void maxLenNonZeroTest() {

		int a[] = { 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1 };
		ibts.maxLenNonZero(a);
	}

	/** 0.2 Backtracking max sum sub continuous in array **/
	@Test
	public void maxSumSubContineousTest() {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		ibts.maxSumSubContineous(a);
	}

	/** 1. Backtracking | Set 1 (The Knights tour problem) **/
	@Test
	public void knightTourTest() {
		ibts.knightTour();
	}

	/** 2. Backtracking | Set 2 (Rat in a Maze) **/
	@Test
	public void ratMazeproblemTest() {
		int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		ibts.ratMazeproblem(maze);
	}

	/** 3. Backtracking | Set 3 (N Queen Problem) **/
	@Test
	public void nQueenProblemTest() {
		int board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		int result[][] = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 1, 0, 0 } };
		ibts.nQueenProblem(board);
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				Assert.assertTrue(board[i][j] == result[i][j]);

	}

	/** 4. Backtracking | Set 4 (Subset Sum) **/
	@Test
	public void generateSubsetsTest() {
		int weights[] = { 10, 7, 5, 18, 12, 20, 15 };
		List<List<Integer>> listOfList = ibts.generateSubsets(weights, 35);
		Assert.assertTrue(listOfList.size() == 4);
	}

	/** 5. Backtracking | Set 5 (m Coloring Problem) **/
	@Test
	public void graphColorTest() {

		int g[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		int m = 3; // Number of colors
		int color[] = ibts.graphColor(g, m);
		int result[] = { 1, 2, 3, 2 };
		for (int i = 0; i < color.length; i++)
			Assert.assertTrue(color[i] == result[i]);
	}

	/** 6. Backtracking | Set 6 (Hamiltonian Cycle) **/
	@Test
	public void hamCycleGraphTest() {

		int graph1[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 }, };

		int graph2[][] = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 0 },
				{ 0, 1, 1, 0, 0 }, };

		int path1[] = ibts.hamCycleGraph(graph1);
		int path2[] = ibts.hamCycleGraph(graph2);

		Assert.assertTrue(path2 == null);
		int path1Result[] = { 0, 1, 2, 4, 3, 0 };
		for (int i = 0; i < path1.length; i++)
			Assert.assertTrue(path1[i] == path1Result[i]);
	}

	/** 7. Backtracking | Set 7 (Sudoku) **/
	@Test
	public void solveSudokuTest() {
		final int N = 9;
		int[][] mat = { { 6, 5, 0, 8, 7, 3, 0, 9, 0 }, { 0, 0, 3, 2, 5, 0, 0, 0, 8 }, { 9, 8, 0, 1, 0, 4, 3, 5, 7 },
				{ 1, 0, 5, 0, 0, 0, 0, 0, 0 }, { 4, 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0, 5, 0, 3 },
				{ 5, 7, 8, 3, 0, 1, 0, 2, 6 }, { 2, 0, 0, 0, 4, 8, 9, 0, 0 }, { 0, 9, 0, 6, 2, 5, 0, 8, 1 } };
		if (ibts.solveSudoku(mat, N) == true)
			BackTrackingUtils.printSudoku(mat);
		else
			System.out.println("No solution exists");
	}

	/** 17. Write a program to print all permutations of a given string **/
	@Test
	public void permutationOfStringTest() {
		String str = "abc";
		List<String> list = ibts.permutationOfString(str.toCharArray(), 0, str.length() - 1);

		Assert.assertTrue(list.get(0).equals("abc"));
		Assert.assertTrue(list.size() == 6);
	}

	/*****************************************************/

}
