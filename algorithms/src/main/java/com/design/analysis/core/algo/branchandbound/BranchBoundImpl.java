package com.design.analysis.core.algo.branchandbound;

import java.util.Collections;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.design.analysis.core.algo.branchandbound.model.KnapsackItem;
import com.design.analysis.core.algo.branchandbound.node.JobNode;
import com.design.analysis.core.algo.branchandbound.node.KnapsackNode;
import com.design.analysis.core.algo.branchandbound.node.PuzzleNode;

/*
 * Branch and Bound:
1.	Branch and Bound | Set 1 (Introduction with 0/1 Knapsack) this is just introduction
2.	Branch and Bound | Set 2 (Implementation of 0/1 Knapsack)
3.	Branch and Bound | Set 3 (8 puzzle Problem)
4.	Branch And Bound | Set 4 (Job Assignment Problem)
5.	Branch and Bound | Set 5 (N Queen Problem)
6.	Branch And Bound | Set 6 (Traveling Salesman Problem)

 */
public class BranchBoundImpl implements IBranchBound {

	public final int N = 3;

	/** 2. Branch and Bound | Set 2 (Implementation of 0/1 Knapsack) **/
	/*
	 * // Returns bound of profit in subtree rooted with u. // This function mainly
	 * uses Greedy solution to find // an upper bound on maximum profit.
	 */
	public int bound(List<KnapsackItem> items, KnapsackNode u, int W, int n) {

		if (u.weight >= W)
			return 0;

		int profit_bound = u.profit;

		int j = u.level + 1;
		int totalWeight = (int) u.weight;

		while (j < n && totalWeight <= (totalWeight + items.get(j).weight)) {
			totalWeight += items.get(j).weight;
			profit_bound += (int) items.get(j).value;
			j++;
		}

		// include the last item partially if j<n
		if (j < n) {
			profit_bound += (W - totalWeight) * items.get(j).value / items.get(j).weight;
		}
		return profit_bound;
	}

	/* Returns maximum profit we can get with capacity W */
	public int knapsack(List<KnapsackItem> items, int W, int n) {
		Collections.sort(items);

		Queue<KnapsackNode> que = new LinkedList<>();
		KnapsackNode u, v;

		u = new KnapsackNode();
		v = new KnapsackNode();

		que.add(u);

		int max_profit = 0;

		while (!que.isEmpty()) {
			u = que.poll();

			if (u.level == -1)
				v.level = 0;

			if (u.level == n - 1)
				continue;

			v.level = u.level + 1;
			v.profit = u.profit + items.get(v.level).value;
			v.weight = u.weight + items.get(v.level).weight;

			if (v.profit > max_profit && v.weight <= W)
				max_profit = v.profit;

			v.bound = bound(items, v, W, n);

			if (v.bound > max_profit)
				que.add(v);

			/* do the same for 0 ie Without taking the item in knapsack */
			v = new KnapsackNode();
			v.level = u.level + 1;
			v.profit = u.profit;
			v.weight = u.weight;
			v.bound = bound(items, v, W, n);

			if (v.bound > max_profit)
				que.add(v);

		}
		return max_profit;
	}

	/** 3. Branch and Bound | Set 3 (8 puzzle Problem) **/

	@Override
	public void printMatrix(int mat[][]) {
		int N = mat.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	/* print path from root node to destination node */

	@Override
	public void printPath(PuzzleNode root) {
		if (root == null)
			return;
		printPath(root.pt);
		printMatrix(root.mat);
		System.out.println();
	}

	/* Function to check if (x, y) is a valid matrix cordinate */
	public boolean isSafe(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	public static Comparator<PuzzleNode> idComparator = new Comparator<PuzzleNode>() {
		@Override
		public int compare(PuzzleNode lhs, PuzzleNode rhs) {
			return (lhs.cost + lhs.level) - (rhs.cost + rhs.level);
		}
	};

	// Function to allocate a new node
	public PuzzleNode newNode(int mat[][], int x, int y, int newX, int newY, int level, PuzzleNode pt) {
		PuzzleNode node = new PuzzleNode();

		// set pointer for path to root
		node.pt = pt;

		// copy data from parent node to current node
		node.mat = mat;

		// move tile by 1 postion
		// swap(node.mat[x][y], node.mat[newX][newY]);
		int temp = mat[x][y];
		mat[x][y] = mat[newX][newY];
		mat[newX][newY] = temp;

		// set number of misplaced tiles
		node.cost = Integer.MAX_VALUE;

		// set number of moves so far
		node.level = level;

		// update new blank tile cordinates
		node.x = newX;
		node.y = newY;

		return node;
	}

	/*
	 * Function to calculate the the number of misplaced tiles ie. number of
	 * non-blank tiles not in their goal position
	 */
	@Override
	public int calculateCost(int initl[][], int finl[][]) {
		int N = initl.length;
		int count = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				if (initl[i][j] != finl[i][j])
					count++;
		return count;
	}

	/*
	 * Function to solve N*N - 1 puzzle algorithm using Branch and Bound. x and y
	 * are blank tile coordinates in initial state
	 */
	// TODO
	public void sove8Puzzle(int initl[][], int finl[][], int x, int y) {

		Queue<PuzzleNode> pq = new PriorityQueue<PuzzleNode>(idComparator);

		PuzzleNode root = newNode(initl, x, y, x, y, 0, null);
		root.cost = calculateCost(initl, finl);

		pq.add(root);

		// bottom, left, top, right
		int row[] = { 1, 0, -1, 0 };
		int col[] = { 0, -1, 0, 1 };
		while (!pq.isEmpty()) {
			PuzzleNode min = pq.poll();

			if (min.cost == 0) {
				printPath(min);
				System.out.println("size of que:" + pq.size());
				return;
			}

			// do for each child of min
			// max 4 children for a node
			/*
			 * int leastCost = Integer.MAX_VALUE; PuzzleNode minCostNode = null;
			 */
			for (int i = 0; i < 4; i++) {
				if (isSafe(min.x + row[i], min.y + col[i])) {
					// create a child node and calculate
					// its cost
					PuzzleNode child = newNode(min.mat, min.x, min.y, min.x + row[i], min.y + col[i], min.level + 1,
							min);
					child.cost = calculateCost(child.mat, finl);
					/*
					 * if (leastCost > child.cost) { minCostNode = child; leastCost = child.cost; }
					 */
					// Add child to list of live nodes
					// if (min.cost >= child.cost)
					pq.add(child);
				}
			}
			// pq.add(minCostNode);
		}
	}

	/** 4. Branch And Bound | Set 4 (Job Assignment Problem) **/
	public static Comparator<JobNode> costComp = new Comparator<JobNode>() {
		@Override
		public int compare(JobNode lhs, JobNode rhs) {
			return lhs.cost - rhs.cost;
		}
	};

	@Override
	public int findMinCost(int costMatrix[][]) {
		// Create a priority queue to store live nodes of
		// search tree;
		Queue<JobNode> pq = new PriorityQueue<JobNode>(costComp);
		int N = costMatrix.length;
		// initailize heap to dummy node with cost 0
		// boolean assigned[] = new boolean[N];
		JobNode root = new JobNode();
		root.pathCost = root.cost = 0;
		root.workerID = -1;
		root.assigned = new boolean[N];

		// Add dummy node to list of live nodes;
		pq.add(root);

		// Finds a live node with least cost,
		// add its childrens to list of live nodes and
		// finally deletes it from the list.
		while (!pq.isEmpty()) {
			// Find a live node with least estimated cost
			JobNode min = pq.peek();
			// The found node is deleted from the list of live nodes
			pq.poll();
			// i stores next worker
			int i = min.workerID + 1;

			// if all workers are assigned a job
			if (i == N) {
				printAssignments(min);
				return min.cost;
			}
			// do for each job
			for (int j = 0; j < N; j++) {
				// If unassigned
				if (!min.assigned[j]) {
					// create a new tree node
					JobNode jobNode = new JobNode();
					JobNode child = jobNode.newNode(i, j, min.assigned, min);
					// cost for ancestors nodes including current node
					child.pathCost = min.pathCost + costMatrix[i][j];
					// calculate its lower bound
					child.cost = child.pathCost + calculateCost(costMatrix, i, j, child.assigned);
					// Add child to list of live nodes;
					pq.add(child);
				}
			}
		}
		return -1;
	}

	/*
	 * Function to calculate the least promising cost of node after worker x is
	 * assigned to job y.
	 */
	@Override
	public int calculateCost(int costMatrix[][], int x, int y, boolean assigned[]) {
		int cost = 0;
		int N = costMatrix.length;
		// to store unavailable jobs
		boolean available[] = new boolean[N];

		// start from next worker
		for (int i = x + 1; i < N; i++) {
			int min = Integer.MAX_VALUE, minIndex = -1;

			// do for each job
			for (int j = 0; j < N; j++) {
				// if job is unassigned
				if (!assigned[j] && available[j] && costMatrix[i][j] < min) {
					// store job number
					minIndex = j;

					// store cost
					min = costMatrix[i][j];
				}
			}
			// add cost of next worker
			cost += min;
			// job becomes unavailable
			if (minIndex != -1)
				available[minIndex] = false;
		}
		return cost;
	}

	// print Assignments
	public void printAssignments(JobNode min) {
		if (min.parent == null)
			return;

		printAssignments(min.parent);
		System.out.println("Assign Worker " + min.workerID + 'A' + " to Job " + min.jobID);

	}

	/** 5. Branch and Bound | Set 5 (N Queen Problem) **/
	/* A utility function to print solution */
	public void printSolution(int board[][]) {
		int N = board.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
	}

	/*
	 * A Optimized function to check if a queen can be placed on board[row][col]
	 */
	public boolean isSafe(int row, int col, int slashCode[][], int backslashCode[][], boolean rowLookup[],
			boolean slashCodeLookup[], boolean backslashCodeLookup[]) {
		if (slashCodeLookup[slashCode[row][col]] || backslashCodeLookup[backslashCode[row][col]] || rowLookup[row])
			return false;
		return true;
	}

	/* A recursive utility function to solve N Queen problem */
	public boolean solveNQueensUtil(int board[][], int col, int slashCode[][], int backslashCode[][],
			boolean rowLookup[], boolean slashCodeLookup[], boolean backslashCodeLookup[]) {
		int N = board.length;
		/*
		 * base case: If all queens are placed then return true
		 */
		if (col >= N)
			return true;
		/*
		 * Consider this column and try placing this queen in all rows one by one
		 */
		for (int i = 0; i < N; i++) {
			/*
			 * Check if queen can be placed on board[i][col]
			 */
			if (isSafe(i, col, slashCode, backslashCode, rowLookup, slashCodeLookup, backslashCodeLookup)) {
				/* Place this queen in board[i][col] */
				board[i][col] = 1;
				rowLookup[i] = true;
				slashCodeLookup[slashCode[i][col]] = true;
				backslashCodeLookup[backslashCode[i][col]] = true;

				/* recur to place rest of the queens */
				if (solveNQueensUtil(board, col + 1, slashCode, backslashCode, rowLookup, slashCodeLookup,
						backslashCodeLookup))
					return true;
				/*
				 * If placing queen in board[i][col] doesn't lead to a solution, then backtrack
				 */

				/* Remove queen from board[i][col] */
				board[i][col] = 0;
				rowLookup[i] = false;
				slashCodeLookup[slashCode[i][col]] = false;
				backslashCodeLookup[backslashCode[i][col]] = false;
			}
		}
		/*
		 * If queen can not be place in any row in this colum col then return false
		 */
		return false;
	}

	public boolean solveNQueens(int board[][]) {
		int N = board.length;
		// memset(board, 0, sizeof board);

		// helper matrices
		int slashCode[][] = new int[N][N];
		int backslashCode[][] = new int[N][N];

		// arrays to tell us which rows are occupied
		boolean rowLookup[] = new boolean[N];

		// keep two arrays to tell us which diagonals are occupied
		boolean slashCodeLookup[] = new boolean[2 * N - 1];
		boolean backslashCodeLookup[] = new boolean[2 * N - 1];

		// initalize helper matrices
		for (int r = 0; r < N; r++)
			for (int c = 0; c < N; c++) {
				slashCode[r][c] = r + c;
				backslashCode[r][c] = r - c + 7;
			}

		if (solveNQueensUtil(board, 0, slashCode, backslashCode, rowLookup, slashCodeLookup,
				backslashCodeLookup) == false) {
			System.out.println("Solution does not exist");
			return false;
		}

		// solution found
		printSolution(board);
		return true;
	}
	/**********************************************************************************************************************************************************/
	// TODO
	/*
	 * public List<Point> clogestPoints(List<Point> points) {
	 * Collections.sort(points);
	 * 
	 * int n = points.size(); Queue<PointNode> que = new LinkedList<>(); PointNode
	 * u, v;
	 * 
	 * Point p = new Point(0, 0); Point q = new Point(0, 0); u = new PointNode(p,
	 * q); v = new PointNode(p, q);
	 * 
	 * que.add(u);
	 * 
	 * int min_dist = Integer.MAX_VALUE;
	 * 
	 * while (!que.isEmpty()) { u = que.poll();
	 * 
	 * if (u.level == -1) v.level = 0;
	 * 
	 * if (u.level == n - 1) continue;
	 * 
	 * v.level = u.level + 1; v.dist = v.profit = u.profit +
	 * items.get(v.level).value; v.weight = u.weight + items.get(v.level).weight;
	 * 
	 * if (v.profit > max_profit && v.weight <= W) max_profit = v.profit;
	 * 
	 * v.bound = bound(items, v, W, n);
	 * 
	 * if (v.bound > max_profit) que.add(v);
	 * 
	 * do the same for 0 ie Without taking the item in knapsack v = new
	 * KnapsackNode(); v.level = u.level + 1; v.profit = u.profit; v.weight =
	 * u.weight; v.bound = bound(items, v, W, n);
	 * 
	 * if (v.bound > max_profit) que.add(v);
	 * 
	 * } return max_profit;
	 */
	// }
}
