package com.design.analysis.core.algo.backtracking.utils;

import java.util.ArrayList;
import java.util.List;

public class BackTrackingUtils {

	public static int KTN = 8; // knightTour constant
	public static int RMN = 4; // rat in maze constnat

	public static int NQP = 4;// N Queue Problem constant

	public static int total_nodes = 0;

	public static int N = 9;

	public static boolean isSafeArrTvl(int a[], int x) {
		return x < a.length && a[x] == 1;
	}

	public static boolean isMaxSumSubContineousUtilSafe(int a[], int maxSum[], int sum[], int x) {
		return x < a.length && sum[x - 1] <= maxSum[x - 1];
	}

	/*
	 * A utility function to check if i,j are valid indexes for N*N chessboard
	 */
	public static boolean isSafeBkt(int x, int y, int sol[][]) {
		return (x >= 0 && x < KTN && y >= 0 && y < KTN && sol[x][y] == 0);
	}

	/* safe funcion for rat in maze */
	public static boolean isSafeRatMaze(int maze[][], int x, int y) {
		// if (x,y outside maze) return false
		return (x >= 0 && x < RMN && y >= 0 && y < RMN && maze[x][y] == 1);
	}

	/* safe function for N Queue problem */
	public static boolean isSafeNQueue(int board[][], int row, int col) {
		int i, j;

		/* Check this row on left side */
		for (i = 0; i < col; i++)
			if (board[row][i] == 1)
				return false;

		/* Check upper diagonal on left side */
		for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;

		/* Check lower diagonal on left side */
		for (i = row, j = col; j >= 0 && i < NQP; i++, j--)
			if (board[i][j] == 1)
				return false;

		return true;
	}

	/* is safe function for graph coloring */
	public static boolean isSafeGraphColor(int v, int g[][], int color[], int c) {
		for (int i = 0; i < g.length; i++)
			if (g[v][i] == 1 && c == color[i])
				return false;
		return true;
	}

	/* hamiltonian-cycle graph is safe function */
	public static boolean isSafeHamCycle(int v, int graph[][], int path[], int pos) {
		/*
		 * Check if this vertex is an adjacent vertex of the previously added vertex.
		 */
		if (graph[path[pos - 1]][v] == 0)
			return false;

		/*
		 * Check if the vertex has already been included. This step can be optimized by
		 * creating an array of size V
		 */
		for (int i = 0; i < pos; i++)
			if (path[i] == v)
				return false;

		return true;
	}

	/* print rat maze **/
	public static void printSolution(int sol[][]) {
		for (int i = 0; i < RMN; i++) {
			for (int j = 0; j < RMN; j++)
				System.out.print(" " + sol[i][j] + " ");
			System.out.println();
		}
	}

	/* N Queue problem to print solution */
	public static void printNQueue(int board[][]) {
		for (int i = 0; i < NQP; i++) {
			for (int j = 0; j < NQP; j++)
				System.out.print(" " + board[i][j] + " ");
			System.out.println();
		}
	}

	/*
	 * A utility function to print solution matrix sol[N][N]
	 */
	public static void printBkt(int sol[][]) {
		for (int x = 0; x < KTN; x++) {
			for (int y = 0; y < KTN; y++)
				System.out.print(sol[x][y] + " ");
			System.out.println();
		}
	}

	/* */
	public static boolean arryTravelUtil(int a[], int sol[], int x) {
		if (x == a.length)
			return true;

		if (isSafeArrTvl(a, x)) {
			sol[x] = 1;
			if (arryTravelUtil(a, sol, x + 1))
				return true;
			else
				sol[x] = 0; // backtracking
		}
		return false;
	}

	public static void maxLenNonZeroUtil(int a[], int sol[], int x) {
		if (x == a.length)
			return;

		if (isSafeArrTvl(a, x)) {
			if (x == 0)
				sol[x] += a[x];
			else
				sol[x] = sol[x - 1] + a[x];
			maxLenNonZeroUtil(a, sol, x + 1);
		} else {
			sol[x] = a[x];// backtracking
			maxLenNonZeroUtil(a, sol, x + 1);
		}
	}

	//TODO incomplete
	public static void maxSumSubContineousUtil(int a[], int maxSum[], int sum[], int x) {
		if (x == a.length)
			return;

		if (isMaxSumSubContineousUtilSafe(a, maxSum, sum, x)) {
			if (a[x] < 0 && maxSum[x - 1] < 0) {
				maxSum[x] = Math.max(maxSum[x - 1], a[x]);
			} else {
				if (a[x] > 0)
					maxSum[x] = a[x];
				else
					maxSum[x] = maxSum[x - 1];// backtracking
			}
			if (a[x] < 0 && sum[x - 1] <= 0)
				sum[x] = 0;
			else
				sum[x] = a[x] + sum[x - 1];

			maxSumSubContineousUtil(a, maxSum, sum, x + 1);
		} else {
			maxSum[x] = sum[x];
			sum[x] += sum[x - 1];
			maxSumSubContineousUtil(a, maxSum, sum, x + 1);
		}
	}

	/* utility funtion for knight Tour problem */
	public static boolean knightTourUtil(int x, int y, int movei, int sol[][], int xMove[], int yMove[]) {

		int k, xNext, yNext;

		if (movei == KTN * KTN)
			return true;
		/*
		 * Try all next moves from the current coordinate x, y
		 */
		for (k = 0; k < KTN; k++) {
			xNext = x + xMove[k];
			yNext = y + yMove[k];

			if (isSafeBkt(xNext, yNext, sol)) {
				sol[xNext][yNext] = movei;

				if (knightTourUtil(xNext, yNext, movei + 1, sol, xMove, yMove))
					return true;
				else
					sol[xNext][yNext] = 0;// backtracking ie go back and again start to move
			}
		}
		return false;
	}

	/* Utility function for rat in mazze */
	public static boolean ratMazeUtil(int[][] maze, int x, int y, int sol[][]) {
		// if (x,y is goal) return true
		if (x == RMN - 1 && y == RMN - 1) {
			sol[x][y] = 1;
			return true;
		}

		// Check if maze[x][y] is valid
		if (isSafeRatMaze(maze, x, y) == true) {
			// mark x,y as part of solution path
			sol[x][y] = 1;

			/* Move forward in x direction */
			if (ratMazeUtil(maze, x + 1, y, sol))
				return true;

			/*
			 * If moving in x direction doesn't give solution then Move down in y direction
			 */
			if (ratMazeUtil(maze, x, y + 1, sol))
				return true;

			/*
			 * If none of the above movements work then BACKTRACK: unmark x,y as part of
			 * solution path
			 */
			sol[x][y] = 0;
			// return false;
		}

		return false;
	}

	/* utility function for N Queue problem */
	public static boolean nQuqueUtil(int board[][], int col) {
		/*
		 * base case: If all queens are placed then return true
		 */
		if (col >= board.length)
			return true;

		/*
		 * Consider this column and try placing this queen in all rows one by one
		 */
		for (int i = 0; i < board.length; i++) {
			/*
			 * Check if queen can be placed on board[i][col]
			 */
			if (isSafeNQueue(board, i, col)) {
				/* Place this queen in board[i][col] */
				board[i][col] = 1;

				/* recur to place rest of the queens */
				if (nQuqueUtil(board, col + 1) == true)
					return true;

				/*
				 * If placing queen in board[i][col] doesn't lead to a solution then remove
				 * queen from board[i][col]
				 */
				board[i][col] = 0; // BACKTRACK
			}
		}

		/*
		 * If queen can not be place in any row in this colum col, then return false
		 */
		return false;
	}

	public static List<List<Integer>> listOfList = null;

	public static List<List<Integer>> subSetUtil(int a[], int t[], int a_size, int t_size, int currentSum,
			int itemCount, int targetSum) {

		total_nodes++;

		if (currentSum == targetSum) {
			if (listOfList == null)
				listOfList = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < t_size; i++)
				list.add(t[i]);
			listOfList.add(list);
			// constraint check
			if (itemCount + 1 < a_size && currentSum - a[itemCount] + a[itemCount + 1] <= targetSum) {
				// Exclude previously added item and consider next candidate
				subSetUtil(a, t, a_size, t_size - 1, currentSum - a[itemCount], itemCount + 1, targetSum);
				return listOfList;
			}
		} else {
			// constraint check
			if (itemCount < a_size && currentSum + a[itemCount] <= targetSum) {
				// generate nodes along with breath
				for (int i = itemCount; i < a_size; i++) {
					t[t_size] = a[i];
					// consider next level node (along depth)
					subSetUtil(a, t, a_size, t_size + 1, currentSum + a[i], i + 1, targetSum);
				}
			}
		}
		return listOfList;
	}

	public static boolean graphColorUtil(int g[][], int color[], int m, int v) {

		if (v == g.length)
			return true;

		for (int c = 1; c <= m; c++) {
			if (isSafeGraphColor(v, g, color, c)) {
				color[v] = c;

				if (graphColorUtil(g, color, m, v + 1))
					return true;

				color[v] = 0;// back track
			}
		}
		/*
		 * If no color can be assigned to this vertex then return false
		 */
		return false;
	}

	public static boolean hamCycleUtil(int g[][], int path[], int pos) {
		/*
		 * base case: If all vertices are included in Hamiltonian Cycle
		 */
		if (pos == g.length) {
			// And if there is an edge from the last included
			// vertex to the first vertex
			if (g[path[pos - 1]][path[0]] == 1)
				return true;
			else
				return false;
		}

		// included 0 as starting point in in hamCycle()
		for (int v = 1; v < g.length; v++) {
			/*
			 * Check if this vertex can be added to Hamiltonian Cycle
			 */
			if (isSafeHamCycle(v, g, path, pos)) {
				path[pos] = v;

				/* recur to construct rest of the path */
				if (hamCycleUtil(g, path, pos + 1) == true)
					return true;

				path[pos] = -1;// backtrack
			}
		}

		/*
		 * If no vertex can be added to Hamiltonian Cycle constructed so far, then
		 * return false
		 */
		return false;
	}

	/** 7. Backtracking | Set 7 (Sudoku) Utility **/
	public static int[] numberUnassigned(int mat[][], int row, int col) {
		int numunassign = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// cell is unassigned
				if (mat[i][j] == 0) {
					// changing the values of row and col
					row = i;
					col = j;
					// there is one or more unassigned cells
					numunassign = 1;
					int[] a = { numunassign, row, col };
					return a;
				}
			}
		}
		int[] a = { numunassign, -1, -1 };
		return a;
	}

	public static boolean isSafe(int mat[][], int n, int r, int c) {
		// checking in row
		for (int i = 0; i < N; i++) {
			// there is a cell with same value
			if (mat[r][i] == n)
				return false;
		}
		// checking column
		for (int i = 0; i < N; i++) {
			// there is a cell with the value equal to i
			if (mat[i][c] == n)
				return false;
		}
		// checking sub matrix
		int row_start = (r / 3) * 3;
		int col_start = (c / 3) * 3;
		for (int i = row_start; i < row_start + 3; i++) {
			for (int j = col_start; j < col_start + 3; j++) {
				if (mat[i][j] == n)
					return false;
			}
		}
		return true;
	}

	public static void printSudoku(int mat[][]) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + "\t");
			}
			System.out.println("");
		}
	}

	/*********************************************************************************************************************************************************************/
	/*********************************************************************************************************************************************************************/

	/** Misc Utility methods **/
	/** 1. Tug of War **/
	public static int min_diff = Integer.MAX_VALUE;

	// function that tries every possible solution
	// by calling itself recursively
	public static void TOWUtil(int arr[], int n, boolean curr_elements[], int no_of_selected_elements, boolean soln[],
			int sum, int curr_sum, int curr_position) {
		// checks whether the it is going out of bound
		if (curr_position == n)
			return;

		// checks that the numbers of elements left
		// are not less than the number of elements
		// required to form the solution
		if ((n / 2 - no_of_selected_elements) > (n - curr_position))
			return;

		// consider the cases when current element
		// is not included in the solution
		TOWUtil(arr, n, curr_elements, no_of_selected_elements, soln, sum, curr_sum, curr_position + 1);

		// add the current element to the solution
		no_of_selected_elements++;
		curr_sum = curr_sum + arr[curr_position];
		curr_elements[curr_position] = true;

		// checks if a solution is formed
		if (no_of_selected_elements == n / 2) {
			// checks if the solution formed is
			// better than the best solution so
			// far
			if (Math.abs(sum / 2 - curr_sum) < min_diff) {
				min_diff = Math.abs(sum / 2 - curr_sum);
				for (int i = 0; i < n; i++)
					soln[i] = curr_elements[i];
			}
		} else {
			// consider the cases where current
			// element is included in the
			// solution
			TOWUtil(arr, n, curr_elements, no_of_selected_elements, soln, sum, curr_sum, curr_position + 1);
		}

		// removes current element before
		// returning to the caller of this
		// function
		curr_elements[curr_position] = false;
	}
}
