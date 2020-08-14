
package com.design.analysis.algo.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.design.analysis.algo.dynamicprogramming.model.Chain;
import com.design.analysis.algo.dynamicprogramming.model.WtJobScheduling;

public class DynamicIntermediateImpl implements IDynamicIntermediate {

	/**
	 * 0.1 Find the way of arrangemnet n bodys and n girls together so that 2 boys
	 * or girls cant sit together
	 **/
	public int wayOfSitBoyAndGirl(int n, int m) {

		int t[][] = new int[n + 1][m + 1];
		t[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

			}
		}
		return t[n][m];
	}

	/** 1. Lobb Number **/
	// TODO not understand the the derivation
	/** 2. Eulerian Number **/
	@Override
	public int eulerian(int n, int m) {
		int[][] dp = new int[n + 1][m + 1];

		// For each row from 1 to n
		for (int i = 1; i <= n; i++) {
			// For each column from 0 to m
			for (int j = 0; j <= m; j++) {
				// If i is greater than j
				if (i > j) {
					// If j is 0, then make
					// that state as 1.
					if (j == 0)
						dp[i][j] = 1;

					// basic recurrence relation.
					else
						dp[i][j] = ((i - j) * dp[i - 1][j - 1]) + ((j + 1) * dp[i - 1][j]);
				}
			}
		}
		// for (int i = 0; i <= n; i++)
		// System.out.println(Arrays.toString(dp[i]));
		return dp[n][m];
	}

	/** 3. Delannoy Number **/
	public int dealnnoyRec(int n, int m) {
		// Base case
		if (m == 0 || n == 0)
			return 1;
		// Recursive step.
		return dealnnoyRec(m - 1, n) + dealnnoyRec(m - 1, n - 1) + dealnnoyRec(m, n - 1);
	}

	/** 3. Delannoy Number **/
	public int dealnnoyDp(int n, int m) {
		int dp[][] = new int[m + 1][n + 1];
		// Base cases
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1] + dp[i][j - 1];
			}
		}
		return dp[m][n];
	}

	/** 4. Entringer Number **/
	@Override
	public int zigzagRcv(int n, int k) {
		// Base Case
		if (n == 0 && k == 0)
			return 1;
		// Base Case
		if (k == 0)
			return 0;
		// Recursive step
		return zigzagRcv(n, k - 1) + zigzagRcv(n - 1, n - k);
	}

	@Override
	public int zigzagDp(int n, int k) {
		int dp[][] = new int[n + 1][k + 1];
		// Base cases
		dp[0][0] = 1;
		for (int i = 1; i <= n; i++)
			dp[i][0] = 0;
		// Finding dp[i][j]
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= Math.min(i, k); j++)
				dp[i][j] = dp[i][j - 1] + dp[i - 1][i - j];
		}

		return dp[n][k];
	}

	/** 5. Rencontres Number **/
	// TODO for well understanding copy work
	@Override
	public int rencontresNumberDp(int C[][], int n, int m) {
		binomialCoeff(C, n, m);
		int dp[][] = new int[n + 1][m + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (j <= i) {
					// base case
					if (i == 0 && j == 0)
						dp[i][j] = 1;
					// base case
					else if (i == 1 && j == 0)
						dp[i][j] = 0;

					else if (j == 0)
						dp[i][j] = (i - 1) * (dp[i - 1][0] + dp[i - 2][0]);
					else
						dp[i][j] = C[i][j] * dp[i - j][0];
				}
			}
		}
		return dp[n][m];
	}

	@Override
	public void binomialCoeff(int C[][], int n, int k) {

		// Calculate value of Binomial Coefficient
		// in bottom up manner
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {

				// Base Cases
				if (j == 0 || j == i)
					C[i][j] = 1;

				// Calculate value using previously
				// stored values
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}
	}

	/** 6. Jacobsthal and Jacobsthal-Lucas numbers **/
	@Override
	public int Jacobsthal(int n) {
		// base case
		if (n == 0)
			return 0;
		// base case
		if (n == 1)
			return 1;
		// recursive step.
		return Jacobsthal(n - 1) + 2 * Jacobsthal(n - 2);
	}

	// Return nth Jacobsthal number.
	@Override
	public int JacobsthalDp(int n) {
		int[] dp = new int[n + 1];

		// base case
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + 2 * dp[i - 2];

		return dp[n];
	}

	@Override
	// Return nth Jacobsthal-Lucas number.
	public int Jacobsthal_LucasDp(int n) {
		int[] dp = new int[n + 1];

		// base case
		dp[0] = 2;
		dp[1] = 1;

		for (int i = 2; i <= n; i++)
			dp[i] = dp[i - 1] + 2 * dp[i - 2];

		return dp[n];
	}

	/** 7. Super Ugly Number (Number whose prime factors are in given set) **/
	@Override
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] times = new int[primes.length];
		int[] result = new int[n];
		result[0] = 1; // first is 1

		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				min = Math.min(min, primes[j] * result[times[j]]);
			}

			result[i] = min;

			for (int j = 0; j < times.length; j++) {
				if (result[times[j]] * primes[j] == min) {
					times[j]++;
				}
			}
		}

		return result[n - 1];
	}

	/** 8. Floyd Warshall Algorithm **/
	final static int INF = 99999, V = 4;

	public void floydWarshall(int graph[][]) {
		int dist[][] = new int[V][V];
		int i, j, k;

		for (i = 0; i < V; i++)
			for (j = 0; j < V; j++)
				dist[i][j] = graph[i][j];

		for (k = 0; k < V; k++) {
			// Pick all vertices as source one by one
			for (i = 0; i < V; i++) {
				// Pick all vertices as destination for the
				// above picked source
				for (j = 0; j < V; j++) {
					// If vertex k is on the shortest path from
					// i to j, then update the value of dist[i][j]
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];
				}
			}
		}
		// Print the shortest distance matrix
		printSolution(dist);
	}

	public void printSolution(int dist[][]) {
		System.out.println("The following matrix shows the shortest " + "distances between every pair of vertices");
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (dist[i][j] == INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + "   ");
			}
			System.out.println();
		}
	}

	/** 9. Bellman–Ford Algorithm **/
	// TODO
	/** 1. 0-1 Knapsack Problem **/
	@Override
	public int knapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		return K[n][W];
	}

	@Override
	public void printknapSack(int W, int wt[], int val[], int n) {
		int i, w;
		int K[][] = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (i = 0; i <= n; i++) {
			for (w = 0; w <= W; w++) {
				if (i == 0 || w == 0)
					K[i][w] = 0;
				else if (wt[i - 1] <= w)
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
				else
					K[i][w] = K[i - 1][w];
			}
		}

		// stores the result of Knapsack
		int res = K[n][W];
		System.out.println(res);

		w = W;
		for (i = n; i > 0 && res > 0; i--) {
			// either the result comes from the top
			// (K[i-1][w]) or from (val[i-1] + K[i-1]
			// [w-wt[i-1]]) as in Knapsack table. If
			// it comes from the latter one/ it means
			// the item is included.
			if (res == K[i - 1][w])
				continue;
			else {

				// This item is included.
				System.out.print(wt[i - 1] + " ");

				// Since this weight is included its
				// value is deducted
				res = res - val[i - 1];
				w = w - wt[i - 1];
			}
		}
	}

	/** 12. Unbounded Knapsack (Repetition of items allowed) **/
	@Override
	public int maxValUnboundedKnapSack(int val[], int wt[], int W) {

		// dp[i] is going to store maximum value
		// with knapsack capacity i.
		int dp[] = new int[W + 1];

		// Fill dp[] using above recursive formula
		for (int i = 0; i <= W; i++) {
			for (int j = 0; j < val.length; j++) {
				if (wt[j] <= i) {
					dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[W];

	}

	/** 13. Temple Offerings **/
	public int templeOfferings(int t[]) {
		int n = t.length;
		int rs[] = new int[n];
		Arrays.fill(rs, 1);

		int maxInd = 0;
		int minInd = n - 1;
		for (int i = maxInd; i < n - 1; i++) {
			if (t[maxInd] < t[i + 1]) {
				rs[i + 1] = Math.max(rs[maxInd], rs[i + 1]) + 1;
				maxInd = i + 1;
			}
		}
		for (int i = minInd; i > 0; i--) {
			if (t[minInd] < t[i - 1]) {
				if (rs[i - 1] <= rs[minInd])
					rs[i - 1] = rs[minInd] + 1;
				minInd = i - 1;
			}
		}
		int sum = 0;
		for (int i = 0; i < n; sum += rs[i], i++)
			;
		return sum;
	}

	/** 14. Egg Dropping Puzzle **/
	@Override
	public int eggDropRec(int n, int k) {

		// if no floor or 1 floor
		if (k == 1 || k == 0)
			return k;

		// if 1 egg only then try for k times
		if (n == 1)
			return k;

		int min = Integer.MAX_VALUE, x, res;
		// Consider all droppings from 1st floor to kth floor and
		// return the minimum of these values plus 1.
		for (x = 1; x <= k; x++) {
			res = Math.max(eggDropRec(n - 1, x - 1), eggDropRec(n, k - x));
			if (res < min)
				min = res;
		}
		return min + 1;
	}

	@Override
	public int eggDropDp(int n, int k) {

		int eg[][] = new int[n + 1][k + 1];
		int res;
		int i, j, x;
		// for 1 floor 1 and 0 floor 0 trail
		for (i = 0; i < n; i++) {
			eg[i][1] = 1;
			eg[i][0] = 0;
		}
		// 1 egg for j floor need j trail
		for (j = 1; j < k; j++)
			eg[1][j] = j;

		for (i = 2; i <= n; i++) {
			for (j = 2; j <= k; j++) {
				eg[i][j] = Integer.MAX_VALUE;

				for (x = 1; x <= j; x++) {
					res = 1 + Math.max(eg[i - 1][x - 1], eg[i][j - x]);
					if (res < eg[i][j])
						eg[i][j] = res;
				}
			}
		}
		// @see pattern
		for (i = 0; i <= n; i++)
			System.out.println(Arrays.toString(eg[i]));
		return eg[n][k];
	}

	/** 15. Dice Throw Problem **/
	@Override
	public int findWays(int m, int n, int x) {
		int t[][] = new int[n + 1][x + 1];

		// x= m ie no of dice face max sum of m face is m
		// Table entries for only one dice

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= x; j++) {
				if (i == 1 || i == j)
					t[i][j] = 1;
				else if (i > j)
					t[i][j] = 0;
				else
					t[i][j] = t[i - 1][j - 1] + t[i][j - 1];
			}
		}
		for (int i = 0; i <= n; i++)
			System.out.println(Arrays.toString(t[i]));
		return t[n][x];
	}

	/** 16. Word Break Problem **/
	public boolean isFirstFound = false;

	@Override
	public boolean isWordBreakInDictRcv(String sl[], String s, int iIndex) {
		if (iIndex == 0)
			isFirstFound = false;
		if (s.contains(" "))
			s = s.replace(" ", "");
		if (s.equals(""))
			return true;
		if (s.indexOf(sl[iIndex]) == 0) {
			isFirstFound = true;
			return isWordBreakInDictRcv(sl, s.substring(sl[iIndex].length(), s.length()), ++iIndex);
		} else {
			if (isFirstFound && iIndex == s.length())
				return false;
			return isWordBreakInDictRcv(sl, s, ++iIndex);
		}
	}

	@Override
	public boolean isWordBreakInDict(String sl[], String s) {
		boolean isfound[] = new boolean[sl.length];
		for (int i = 0; i < sl.length; i++) {
			if (s.contains(sl[i])) {
				isfound[i] = true;
			}
		}
		if (s.contains(" "))
			s = s.replace(" ", "");
		String rs = "";
		int k = 0;
		for (int i = 0; i < isfound.length; i++) {
			k = i;
			for (int j = i; j < isfound.length; j++) {
				if (isfound[j] && k == j) {
					k++;
					rs += sl[j];
					if (rs.equals(s))
						return true;
				} else {
					k = j + 1;
					rs = "";
				}
			}
		}
		return false;
	}

	/** 17. Vertex Cover Problem **/
	// TODO
	/** 18. Tile Stacking Problem **/
	@Override
	public int tileStackingProblm(int n, int m, int l) {
		int t[][][] = new int[n + 1][m + 1][l + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				for (int k = 1; k <= l; k++) {
					if (i == 1)
						t[i][j][k] = 1;
					else if (i > j)
						t[i][j][k] = 0;
					else {
						// TODO t[i][j][k] += t[i][j][k - 1] + t[i][j-1][k]+t[i-1][j-1][k-1];//t[i][j -
						// 1][k] +
					}
				}
			}
		}
		for (int i = 0; i <= n; i++) {
			System.out.println();
			for (int j = 0; j <= m; j++) {
				System.out.println(Arrays.toString(t[i][j]));
			}
		}
		return t[n][m][l];
	}

	/** 19. Box-Stacking Problem **/
	public int boxStackingProblem(int a[][]) {
		return 0;
	}

	/**************************************************************************************************************************************************************/

	/** 2. Length of the longest substring without repeating characters **/
	@Override
	public String longestSubString(String str) {
		boolean visited[] = new boolean[26];
		int lPrev, rPrev, l, r;
		lPrev = rPrev = l = r = 0;
		for (int i = 0; i < str.length(); i++) {
			if (!visited[str.charAt(i) - 97]) {
				visited[str.charAt(i) - 97] = true;
				r++;
			} else {
				if (r - l >= rPrev - lPrev) {
					rPrev = r;
					lPrev = l;
					r = i;
				}
				l++;
			}

		}
		if (r - l >= rPrev - lPrev)
			return str.substring(l, r + 1);
		else
			return str.substring(lPrev, rPrev);
	}

	/** 3. Count number of ways to reach destination in a Maze **/
	@Override
	public int noOfWayReachDestnInMaze(int a[][]) {

		int n = a.length;
		int m = a[0].length;
		int b[][] = new int[n + 1][m + 1];

		// make firt row and column 0
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if (i == 0 || j == 0)
					b[i][j] = 0;
				else
					b[i][j] = a[i - 1][j - 1];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (b[i][j] != -1) {

					if (b[i - 1][j] != -1 && b[i][j - 1] != -1) {
						if (i == 1 && j == 1)
							b[i][j] = 1;
						else
							b[i][j] = b[i][j - 1] + b[i - 1][j];
					} else if (b[i - 1][j] != -1 || b[i][j - 1] != -1)
						b[i][j] = Math.max(b[i][j - 1], b[i - 1][j]);
				}
			}
		}
		return b[n][m];
	}

	/** 4. Super Ugly Number (Number whose prime factors are in given set) **/
	/* This function divides a by greatest divisible power of b */
	@Override
	public int maxDivide(int a, int b) {
		while (a % b == 0)
			a = a / b;
		return a;
	}

	/* check the no is ugly or not */
	@Override
	public boolean isUgly(int a[], int n) {
		for (int i = 0; i < a.length; i++)
			n = maxDivide(n, a[i]);
		return (n == 1);
	}

	@Override
	public int superUglyNoPrimeFactInGivenSet(int a[], int n) {
		int i = 1; // conside 1 is ugly no so fist ho initiated
		int count = 1; // since 1 included as ugly

		while (n > count) {
			if (isUgly(a, ++i))
				count++;
		}
		return i;
	}

	/** 5. Count number of ways to partition a set into k subsets **/
	@Override
	/*
	 * this is nothig but selection of k item from nitems ie combination where
	 * nCk=nCk-1+n-1Ck-1
	 */
	public int countP(int n, int k) {
		// Base cases
		if (n == 0 || k == 0 || k > n)
			return 0;
		if (k == 1 || k == n)
			return 1;

		// S(n+1, k) = k*S(n, k) + S(n, k-1)
		return k * countP(n - 1, k) + countP(n - 1, k - 1);
	}

	/* by recursive way */
	public int noOfWayKPartitionNNumsRec(int a[], int k) {
		return countP(a.length, k);
	}

	/* using dp */
	public int noOfWayKPartitionNNumsDp(int a[], int k) {
		int n = a.length;
		int b[][] = new int[k + 1][n + 1];
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (i >= j)
					b[i][j] = 1;
				else {
					if (i == 1)
						b[i][j] = j;
					else
						b[i][j] = b[i][j - 1] + b[i - 1][j - 1];
				}
			}
		}
		/*
		 * for (int i = 0; i < b.length; i++) System.out.println(Arrays.toString(b[i]));
		 */
		return b[k][n];
	}

	/** 6. Longest Palindromic Subsequence **/
	/* recursive way */
	@Override
	public int longestPalindromeRec(String str, int i, int j) {

		if (i == j)
			return 1;

		// only 2 char and both are same
		if (str.charAt(i) == str.charAt(j) && i + 1 == j)
			return 2;
		// if first and last match
		if (str.charAt(i) == str.charAt(j))
			return longestPalindromeRec(str, i + 1, j - 1) + 2;

		return Math.max(longestPalindromeRec(str, i + 1, j), longestPalindromeRec(str, i, j - 1));

	}

	/* by DP way */
	@Override
	public int longestSubsequenceDp(String str) {

		int n = str.length();
		String str1 = new StringBuilder(str).reverse().toString();
		int a[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (str.charAt(i - 1) == str1.charAt(j - 1))
					a[i][j] = 1 + a[i - 1][j - 1];
				else
					a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
			}
		}
		for (int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(a[i]));
		}

		/*
		 * for (int i = 0; i < a.length; i++) System.out.println(Arrays.toString(a[i]));
		 */
		return a[n][n];
	}

	/* this is smae as palindrome */
	@Override
	public int longestSubsequence(String str1, String str2) {

		int n = str1.length();
		int m = str2.length();
		int a[][] = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					a[i][j] = 1 + a[i - 1][j - 1];
				else
					a[i][j] = Math.max(a[i - 1][j], a[i][j - 1]);
			}
		}
		return a[n][m];
	}

	/** 8. Weighted job scheduling **/
	@Override
	public int weightedJobScheduling(List<WtJobScheduling> list) {

		// decreasing order of profit
		Collections.sort(list);
		int mxProit = 0;
		int currentEndTime;
		// take first
		mxProit += list.get(0).profit;
		currentEndTime = list.get(0).eTime;
		list.remove(list.get(0));

		for (int i = 0; i < list.size(); i++) {
			int leastStartTime = Integer.MAX_VALUE;
			int leastStartTimeInd = -1;
			// find nearest start time form currentEndTime
			for (int j = i; j < list.size(); j++) {
				// if startTime is less than currentTime no meaning to proceed
				if (list.get(j).sTime - currentEndTime < 0)
					continue;
				if (leastStartTime > list.get(j).sTime - currentEndTime) {
					leastStartTime = list.get(j).sTime;
					leastStartTimeInd = j;
				}
			}
			// if found any
			if (leastStartTime != Integer.MAX_VALUE) {
				mxProit += list.get(leastStartTimeInd).profit;
				currentEndTime = list.get(leastStartTimeInd).eTime;
				list.remove(list.get(leastStartTimeInd));
			}
		}
		return mxProit;
	}

	/** 9. Longest Bitonic Subsequence **/
	@Override
	public int longestBitonicSubsequenceDp(int arr[]) {

		int n = arr.length;
		int i, j;

		/*
		 * Allocate memory for LIS[] and initialize LIS values as 1 for all indexes
		 */
		int[] lis = new int[n];
		for (i = 0; i < n; i++)
			lis[i] = 1;

		/* Compute LIS values from left to right */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;

		/*
		 * Allocate memory for lds and initialize LDS values for all indexes
		 */
		int[] lds = new int[n];
		for (i = 0; i < n; i++)
			lds[i] = 1;

		/* Compute LDS values from right to left */
		for (i = n - 2; i >= 0; i--)
			for (j = n - 1; j > i; j--)
				if (arr[i] > arr[j] && lds[i] < lds[j] + 1)
					lds[i] = lds[j] + 1;

		/* Return the maximum value of lis[i] + lds[i] - 1 */
		int max = lis[0] + lds[0] - 1;
		for (i = 1; i < n; i++)
			if (lis[i] + lds[i] - 1 > max)
				max = lis[i] + lds[i] - 1;

		return max;
	}

	/** 10. Floyd Warshall Algorithm this is minimum distnce of two node **/
	@Override
	public int[][] floydWarshallAlgo(int g[][]) {

		int n = g.length;
		int i, j, k;
		// initialize the correcct val if any input mistake
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				if (i == j)
					g[i][j] = 0;
				else if (i != j && g[i][j] == 0 || g[i][j] < 0)
					g[i][j] = 99;
			}
		}
		int minDist[][] = new int[n][n];
		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {

				minDist[i][j] = g[i][j];
			}
		}

		for (k = 0; k < n; k++) {
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					if (minDist[i][k] + minDist[k][j] < minDist[i][j])
						minDist[i][j] = minDist[i][k] + minDist[k][j];
				}
			}
		}
		return minDist;
	}

	/** 11. Partition Problem **/
	@Override
	public boolean isPrtitionInEqualSum(int a[]) {
		// sort the array and travel form begning and end togheter
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += a[i];
		if (sum % 2 != 0)
			return false;

		Arrays.sort(a);
		int sumL, sumR;
		sumL = sumR = 0;
		int i = 0;
		int j = a.length - 1;

		sumL += a[i];
		sumR += a[j];
		while (i < j) {
			if (i + 1 == j && sumL == sumR)
				return true;

			if (sumL < sumR) {
				i++;
				sumL += a[i];
			}
			if (sumL > sumR) {
				j--;
				sumR += a[j];
			}
			if (sumL == sumR && i + 1 != j) {
				i++;
				j--;
				sumL += a[i];
				sumR += a[j];
			}
		}
		return false;
	}

	/* Building briedge (max) */
	public TreeMap<Integer, Integer> maxBriedge(int a[], int b[]) {
		// make city b increasing order and find the Longest Increasing Subsequence in a
		Arrays.sort(b);// just for analyzig no use
		return maxIncreasingSubseq(a);
	}

	/* maximumn sum of increasing subsequence */
	@Override
	public TreeMap<Integer, Integer> maxSumIncreasingSubseq(int a[]) {
		int n = a.length;
		int b[] = new int[n];
		int c[] = new int[n];
		// for tracking the index and value
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int i, j;

		// every elemet independently have 1 max lenght of subsequence
		for (i = 0; i < n; b[i] = a[i], c[i] = -1, i++)
			;

		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					if (b[i] < b[j] + a[i])
						c[i] = j;
					b[i] = Math.max(b[i], b[j] + a[i]);
				}
			}
		}
		int max = 0;
		int maxInd = -1;
		for (i = 0; i < n; i++)
			if (max < b[i]) {
				max = b[i];
				maxInd = i;
			}
		map.put(maxInd, a[maxInd]);
		while (maxInd != -1 && c[maxInd] != -1 && maxInd != c[maxInd]) {
			map.put(c[maxInd], a[c[maxInd]]);
			maxInd = c[maxInd];
		}
		return map;
	}

	/* longest increasing subsequence */
	@Override
	public TreeMap<Integer, Integer> maxIncreasingSubseq(int a[]) {
		int n = a.length;
		int b[] = new int[n];
		int c[] = new int[n];
		// for tracking the index and value
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int i, j;

		// every elemet independently have 1 max lenght of subsequence
		for (i = 0; i < n; b[i] = 1, c[i] = -1, i++)
			;

		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (a[j] < a[i]) {
					if (b[i] < b[j] + 1)
						c[i] = j;
					b[i] = Math.max(b[i], b[j] + 1);
				}
			}
		}
		int max = 0;
		int maxInd = -1;
		for (i = 0; i < n; i++)
			if (max < b[i]) {
				max = b[i];
				maxInd = i;
			}
		map.put(maxInd, a[maxInd]);
		while (maxInd != -1 && c[maxInd] != -1 && maxInd != c[maxInd]) {
			map.put(c[maxInd], a[c[maxInd]]);
			maxInd = c[maxInd];
		}
		return map;
	}

	/* longest chain by connecting different chain */
	public List<Chain> longestChainConnect(List<Chain> cl) {

		Collections.sort(cl);
		List<Chain> list = new ArrayList<>();

		// add first default;
		list.add(cl.get(0));
		for (Chain ch : cl) {
			if (list.get(list.size() - 1).xf < ch.xi)
				list.add(ch);
		}
		return list;
	}
}
