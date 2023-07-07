package com.design.analysis.core.ds.advance.binaryindexedtree;

import com.design.analysis.core.ds.advance.binaryindexedtree.model.Query;

public class BinaryIndxTreeImpl implements IBinaryIndxTree {

	@Override
	public int parentIndex(int index) {
		index += index & (-index);
		return index;
	}

	@Override
	public int[] createBITree(int[] arr, int n) {

		int bITree[] = new int[n + 1];// default initialization in javva
		// Store the actual values in BITree[] using update()
		for (int i = 0; i < n; i++)
			updateBITree(bITree, n, i, arr[i]);
		return bITree;
	}

	@Override
	public int getSum(int[] bITree, int index) {

		int sum = 0;
		index = index + 1;
		while (index > 0) {
			sum += bITree[index];
			index -= index & (-index);
		}
		return sum;
	}

	@Override
	public void updateBITree(int[] bITree, int n, int index, int val) {
		// index in BITree[] is 1 more than the index in arr[]
		index = index + 1;

		// Traverse all ancestors and add 'val'
		while (index <= n) {
			// Add 'val' to current node of BI Tree
			bITree[index] += val;

			// Update index to that of parent in update View
			index += index & (-index);
		}
	}

	/** 2. Two Dimensional Binary Indexed Tree or Fenwick Tree **/
	/* A function to update the 2D BIT */
	public void updateBIT(int BIT[][], int x, int y, int val) {
		int N = BIT.length - 1;
		for (; x <= N; x += (x & -x)) {
			// This loop update all the 1D BIT inside the
			// array of 1D BIT = BIT[x]
			for (; y <= N; y += (y & -y))
				BIT[x][y] += val;
		}
		return;
	}

	/* A function to get sum from (0, 0) to (x, y) */
	public int getSum(int BIT[][], int x, int y) {
		int sum = 0;

		for (; x > 0; x -= x & -x) {
			// This loop sum through all the 1D BIT
			// inside the array of 1D BIT = BIT[x]
			for (; y > 0; y -= y & -y) {
				sum += BIT[x][y];
			}
		}
		return sum;
	}

	/* A function to create an auxiliary matrix from the given input matrix */
	public void constructAux(int mat[][], int aux[][]) {
		int N = mat.length;
		// Initialise Auxiliary array to 0
		for (int i = 0; i <= N; i++)
			for (int j = 0; j <= N; j++)
				aux[i][j] = 0;

		// Construct the Auxiliary Matrix
		for (int j = 1; j <= N; j++)
			for (int i = 1; i <= N; i++)
				aux[i][j] = mat[N - j][i - 1];

		return;
	}

	/* A function to construct a 2D BIT */
	public void construct2DBIT(int mat[][], int BIT[][]) {
		int N = mat.length;
		// Create an auxiliary matrix
		int aux[][] = new int[N + 1][N + 1];
		constructAux(mat, aux);

		// Initialise the BIT to 0
		for (int i = 1; i <= N; i++)
			for (int j = 1; j <= N; j++)
				BIT[i][j] = 0;

		for (int j = 1; j <= N; j++) {
			for (int i = 1; i <= N; i++) {
				// Creating a 2D-BIT using update function
				// everytime we/ encounter a value in the
				// input 2D-array
				int v1 = getSum(BIT, i, j);
				int v2 = getSum(BIT, i, j - 1);
				int v3 = getSum(BIT, i - 1, j - 1);
				int v4 = getSum(BIT, i - 1, j);

				// Assigning a value to a particular element
				// of 2D BIT
				updateBIT(BIT, i, j, aux[i][j] - (v1 - v2 - v4 + v3));
			}
		}
	}

	/* A function to answer the queries */
	public void answerQueries(Query q[], int m, int BIT[][]) {
		for (int i = 0; i < m; i++) {
			int x1 = q[i].x1 + 1;
			int y1 = q[i].y1 + 1;
			int x2 = q[i].x2 + 1;
			int y2 = q[i].y2 + 1;
			int ans = getSum(BIT, x2, y2) - getSum(BIT, x2, y1 - 1) - getSum(BIT, x1 - 1, y2)
					+ getSum(BIT, x1 - 1, y1 - 1);
			System.out.println("(" + q[i].x1 + "," + q[i].y1 + "), (" + q[i].x2 + "," + q[i].y2 + "):->" + ans);
		}
		return;
	}

	/**
	 * 3. Binary Indexed Tree : Range Updates and Point Queries and by getSum() can
	 * get the indexed value .
	 **/
	/* construct empty binary index tree */
	@Override
	public int[] constructBITree(int n) {
		// Create and initialize BITree[] as 0
		int BITree[] = new int[n + 1];
		for (int i = 1; i <= n; i++)
			BITree[i] = 0;

		return BITree;
	}

	@Override
	public void updateInRange(int BITree[], int l, int r, int n, int val) {
		// Increase value at 'l' by 'val'
		updateBITree(BITree, n, l, val);

		// Decrease value at 'r+1' by 'val'
		updateBITree(BITree, n, r + 1, -val);
	}

	/**
	 * 4. Binary Indexed Tree : Range Update and Range Queries..here need to
	 * construct empty tree
	 * 
	 **/

	/* sum of value in for index x */
	@Override
	public int sum(int x, int BITTree1[], int BITTree2[]) {
		return (getSum(BITTree1, x) * x) - getSum(BITTree2, x);
	}

	/* update the tree in range */
	@Override
	public void updateRange(int BITTree1[], int BITTree2[], int n, int val, int l, int r) {
		// Update BIT1
		updateBITree(BITTree1, n, l, val);
		updateBITree(BITTree1, n, r + 1, -val);

		// Update BIT2
		updateBITree(BITTree2, n, l, val * (l - 1));
		updateBITree(BITTree2, n, r + 1, -val * r);
	}

	/* get sum in query range value */
	@Override
	public int rangeSum(int l, int r, int BITTree1[], int BITTree2[]) {
		// Find sum from [0,r] then subtract sum
		// from [0,l-1] in order to find sum from
		// [l,r]
		return sum(r, BITTree1, BITTree2) - sum(l - 1, BITTree1, BITTree2);
	}

	/** 5. Count inversions in an array **/
	@Override
	public int getInvCount(int arr[], int n) {
		int invcount = 0; // Initialize result

		// Find maximum element in arr[]
		int maxElement = 0;
		for (int i = 0; i < n; i++)
			if (maxElement < arr[i])
				maxElement = arr[i];

		int BIT[] = new int[maxElement + 1];
		for (int i = 1; i <= maxElement; i++)
			BIT[i] = 0;

		// Traverse all elements from right.
		for (int i = n - 1; i >= 0; i--) {
			// Get count of elements smaller than arr[i]
			invcount += getSum(BIT, arr[i] - 1);
			// Add current element to BIT
			updateBITree(BIT, maxElement, arr[i], 1);
		}
		return invcount;
	}

	/** 6. Count Inversions of size three in a give array **/
	public int getInvCountSizeInThree(int arr[], int n) {
		int invcount = 0; // Initialize result

		for (int i = 1; i < n - 1; i++) {
			// Count all smaller elements on right of arr[i]
			int small = 0;
			for (int j = i + 1; j < n; j++)
				if (arr[i] > arr[j])
					small++;

			// Count all greater elements on left of arr[i]
			int great = 0;
			for (int j = i - 1; j >= 0; j--)
				if (arr[i] < arr[j])
					great++;

			// Update inversion count by adding all inversions
			// that have arr[i] as middle of three elements
			invcount += great * small;
		}

		return invcount;
	}
}
