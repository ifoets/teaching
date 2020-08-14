package com.design.analysis.algo.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.design.analysis.algo.backtracking.utils.BackTrackingUtils;
import com.design.analysis.algo.utils.AlgoUtils;

public class BackTrackStrandardImpl implements IBackTrackStrandard {

	/** 0.Backtracking Array **/
	public void nonZero(int a[]) {
		int sol[] = new int[a.length];

		// let start from 0
		if (!BackTrackingUtils.arryTravelUtil(a, sol, 0)) {
			System.out.println("Solution does not exists");
			System.out.println(Arrays.toString(sol));
		} else {
			System.out.println(Arrays.toString(sol));
		}
	}

	/** 0.1 Backtracking max len non zero **/
	public void maxLenNonZero(int a[]) {

		int sol[] = new int[a.length];

		// let start from 0
		BackTrackingUtils.maxLenNonZeroUtil(a, sol, 0);

		System.out.println(AlgoUtils.max(sol));

	}

	/** 0.2 Backtracking max sum sub continuous in array **/
	public void maxSumSubContineous(int a[]) {

		int maxSum[] = new int[a.length];
		int sum[] = new int[a.length];
		maxSum[0] = sum[0] = a[0];

		// let start from 0
		BackTrackingUtils.maxSumSubContineousUtil(a, maxSum, sum, 1);
		System.out.println(Arrays.toString(maxSum));
		// System.out.println(AlgoUtils.max(maxSum));
	}

	/** 1. Backtracking | Set 1 (The Knight’s tour problem) **/
	@Override
	public void knightTour() {
		int N = BackTrackingUtils.KTN;

		int sol[][] = new int[N][N]; // by default 0 initialize

		// xMove and yMove is combination of +/-(1,2)
		int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		// let start from 0,0
		if (!BackTrackingUtils.knightTourUtil(0, 0, 1, sol, xMove, yMove)) {
			System.out.println("Solution does not exists");
		} else {
			BackTrackingUtils.printBkt(sol);
		}
	}

	/** 2. Backtracking | Set 2 (Rat in a Maze) **/
	@Override
	public boolean ratMazeproblem(int maze[][]) {

		int sol[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

		if (!BackTrackingUtils.ratMazeUtil(maze, 0, 0, sol)) {
			System.out.print("Solution doesn't exist");
			return false;
		}
		BackTrackingUtils.printSolution(sol);
		return true;
	}

	/** 3. Backtracking | Set 3 (N Queen Problem) **/
	public boolean nQueenProblem(int board[][]) {

		if (BackTrackingUtils.nQuqueUtil(board, 0) == false) {
			System.out.print("Solution does not exist");
			return false;
		}

		BackTrackingUtils.printNQueue(board);
		return true;
	}

	/** 4. Backtracking | Set 4 (Subset Sum) **/
	@Override
	public List<List<Integer>> generateSubsets(int a[], int targetSum) {
		int n = a.length;
		int total = 0;
		Arrays.sort(a);

		int t[] = new int[n];
		for (int i = 0; i < n; total += a[i], i++)
			;

		if (a[0] <= targetSum && total >= targetSum) {
			return BackTrackingUtils.subSetUtil(a, t, n, 0, 0, 0, targetSum);
		}
		return null;
	}

	/** 5. Backtracking | Set 5 (m Coloring Problem) **/
	@Override
	public int[] graphColor(int g[][], int m) {
		int color[] = new int[g.length];

		// Call graphColoringUtil() for vertex 0
		if (!BackTrackingUtils.graphColorUtil(g, color, m, 0)) {
			System.out.println("Solution does not exist");
			return null;
		}
		return color;
	}

	/** 6. Backtracking | Set 6 (Hamiltonian Cycle) **/
	public int[] hamCycleGraph(int graph[][]) {

		int path[] = new int[graph.length];
		Arrays.fill(path, -1);
		// let start form 0 vertex
		path[0] = 0;
		if (!BackTrackingUtils.hamCycleUtil(graph, path, 1)) {
			System.out.println("\nSolution does not exist");
			return null;
		}
		return path;
	}

	/** 7. Backtracking | Set 7 (Sudoku) **/
	@Override
	public boolean solveSudoku(int mat[][], int N) {
		int row = 0;
		int col = 0;
		int[] a = BackTrackingUtils.numberUnassigned(mat, row, col);
		// if all cells are assigned then the sudoku is already solved
		// pass by reference because number_unassigned will change the values of row and
		// col
		if (a[0] == 0)
			return true;
		// number between 1 to 9
		row = a[1];
		col = a[2];
		for (int i = 1; i <= N; i++) {
			// if we can assign i to the cell or not
			// the cell is matrix[row][col]
			if (BackTrackingUtils.isSafe(mat, i, row, col)) {
				mat[row][col] = i;
				// backtracking
				if (solveSudoku(mat, N))
					return true;
				// if we can't proceed with this solution
				// reassign the cell
				mat[row][col] = 0;
			}
		}
		return false;
	}

	/** 8. Backtracking | Set 8 (Solving Cryptarithmetic Puzzles) **/
	// TODO understanding is not clear

	/** 17. Write a program to print all permutations of a given string **/
	List<String> result = new ArrayList<>();

	@Override
	public List<String> permutationOfString(char[] chars, int l, int r) {

		if (l == r) {
			result.add(String.valueOf(chars));
		} else {

			for (int i = l; i <= r; i++) {
				AlgoUtils.swapChar(chars, l, i);
				permutationOfString(chars, l + 1, r);
				AlgoUtils.swapChar(chars, l, i);
			}
		}
		return result;
	}

}
