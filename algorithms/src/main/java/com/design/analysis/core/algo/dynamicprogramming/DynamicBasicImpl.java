package com.design.analysis.core.algo.dynamicprogramming;

import java.util.*;

import com.design.analysis.core.algo.dynamicprogramming.model.Pair;
import com.design.analysis.core.algo.utils.AlgoUtils;

/*
 * 
 * @author GuruG
 */
public class DynamicBasicImpl implements IDynamicBasic {

	/** 1. Ugly numbers **/
	/* This function divides a by greatest divisible power of b */
	@Override
	public int maxDivide(int a, int b) {
		while (a % b == 0)
			a = a / b;
		return a;
	}

	/* check the no is ugly or not */
	@Override
	public boolean isUgly(int n) {
		n = maxDivide(n, 2);
		n = maxDivide(n, 3);
		n = maxDivide(n, 5);
		return (n == 1);
	}

	/* get nth ugly no ..whose only prime factors are 2, 3 or 5 */
	@Override
	public int nthUgalyNumber(int n) {
		int i = 1; // conside 1 is ugly no so fist ho initiated
		int count = 1; // since 1 included as ugly

		while (n > count) {
			if (isUgly(++i))
				count++;
		}
		return i;
	}

	/** 2. Fibonacci numbers **/
	/* by using dynamic programming */
	@Override
	public int nthFibNoDynamic(int n) {

		int fib[] = new int[n + 1];
		fib[0] = 0;
		fib[1] = 1;

		for (int i = 2; i <= n; i++)
			fib[i] = fib[i - 1] + fib[i - 2];
		return fib[n];
	}

	/* by recursive way */
	@Override
	public int nthFibNoRecursive(int n) {

		if (n <= 1)
			return n;
		return nthFibNoRecursive(n - 1) + nthFibNoRecursive(n - 2);
	}

	/* by using minimum space */
	@Override
	public int nthFibNoMinSpaceUse(int n) {

		int a, b, c, i;
		a = 0;
		b = 1;
		if (n == 0)
			return 0;
		for (i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}

	/** 3. nth Catalan Number **/
	public int catalan(int n) {
		int res = 0;

		// Base case
		if (n <= 1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			res += catalan(i) * catalan(n - i - 1);
		}
		return res;
	}

	/* using dp */
	public int catalanDP(int n) {
		// Table to store results of subproblems
		int ctln[] = new int[n + 1];

		// Initialize first two values in table
		ctln[0] = ctln[1] = 1;

		// Fill entries in catalan[] using recursive formula
		for (int i = 2; i <= n; i++) {
			ctln[i] = 0;
			for (int j = 0; j < i; j++)
				ctln[i] += ctln[j] * ctln[i - j - 1];
		}

		// Return last entry
		return ctln[n];
	}

	/* Using Binomial Coefficient */
	public int catalanByBinomicalCoeff(int n) {
		// Calculate value of 2nCn
		int c = binomialCoeff(2 * n, n);

		// return 2nCn/(n+1)
		return c / (n + 1);
	}

	/** 4. Bell Numbers (Number of ways to Partition a Set) **/
	// TODO understanding the partition
	public int bellNumber(int n) {
		int[][] bell = new int[n + 1][n + 1];
		bell[0][0] = 1;

		for (int i = 1; i <= n; i++) {
			// Explicitly fill for j = 0
			bell[i][0] = bell[i - 1][i - 1];

			// Fill for remaining values of j
			for (int j = 1; j <= i; j++)
				bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
		}

		for (int i = 0; i <= n; i++)
			System.out.println(Arrays.toString(bell[i]));
		return bell[n][0];
	}

	/** 5. Binomial Coefficient **/
	public int binomialCoeff(int n, int k) {
		// Base Cases
		if (k == 0 || k == n)
			return 1;

		// Recur
		return binomialCoeff(n - 1, k - 1) + binomialCoeff(n - 1, k);
	}

	/* by dp */
	public int binomialCoeffDp(int n, int k) {
		int b[] = new int[k + 1];
		int i, j;
		for (i = 0; i <= k; i++)
			b[i] = 0;
		b[0] = 1;
		for (i = 1; i <= n; i++) {
			for (j = Math.min(i, k); j > 0; j--)
				b[j] = b[j] + b[j - 1];
		}
		return b[k];
	}

	public int binomialCoeffDpX(int n, int k) {
		if (k > n)
			return 0;

		int a[][] = new int[n + 1][k + 1];
		a[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= k; j++) {
				if (i == j || j == 0)
					a[i][j] = 1;
				else if (i == j - 1)
					a[i][j] = i;
				else
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
			}
		}
		return a[n][k];
	}

	/** 6.Permutation Coefficient **/
	public int permutationCoefficient(int n, int k) {
		int P[][] = new int[n + 2][k + 2];

		// Caculate value of Permutation
		// Coefficient in bottom up manner
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0)
					P[i][j] = 1;

				// Calculate value using previosly
				// stored values
				else
					P[i][j] = P[i - 1][j] + (j * P[i - 1][j - 1]);

				// This step is important
				// as P(i,j)=0 for j>i
				P[i][j + 1] = 0;
			}
		}
		return P[n][k];
	}

	/** 6.Permutation Coefficient **/
	public int permutationCoefficientX(int n, int k) {

		if (k > n)
			return 0;
		int p[][] = new int[n + 1][k + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, k); j++) {
				// Base Cases
				if (j == 0)
					p[i][j] = 1;

				// Calculate value using previosly
				// stored values
				else
					p[i][j] = p[i - 1][j] + (j * p[i - 1][j - 1]);
			}
		}
		return p[n][k];
	}

	/** 7. Tiling Problem **/ // bord 2*n and tiles 2*1
	@Override
	public int tillingProblem(int n) {

		int tp[] = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			if (i <= 2)
				tp[i] = i;
			else
				tp[i] = tp[i - 1] + tp[i - 2];
		}
		return tp[n];
	}

	/* Tiling Problem 1*m to n*m borad **/
	public int tillingProblemX(int n, int m) {
		int count[] = new int[n + 1];
		count[0] = 0;

		// Fill the table upto value n
		int i;
		for (i = 1; i <= n; i++) {
			// recurrence relation
			if (i > m)
				count[i] = count[i - 1] + count[i - m];
			// base cases
			else if (i < m || i == 1)
				count[i] = 1;

			// i = = m
			else
				count[i] = 2;
		}
		return count[n];
	}

	/** 8. Gold Mine Problem **/
	// solution belong to greedy apprach with dynamic programming(GD & DP)
	public int goldMineProblem(int g[][]) {

		int m = g.length; // no of rows
		int n = g[0].length; // no of column
		// traverse stat form 0 column
		int goldTable[][] = new int[m][n];

		for (int col = n - 1; col >= 0; col--) {
			for (int row = 0; row < m; row++) {
				int right = (col == n - 1) ? 0 : goldTable[row][col + 1];

				int right_up = (row == 0 || col == n - 1) ? 0 : goldTable[row - 1][col + 1];

				int right_down = (row == m - 1 || col == n - 1) ? 0 : goldTable[row + 1][col + 1];

				goldTable[row][col] = g[row][col] + Math.max(right, Math.max(right_up, right_down));
				;
			}
		}
		// The max amount of gold collected will be
		// the max value in first column of all rows
		int res = goldTable[0][0];

		for (int i = 1; i < m; i++)
			res = Math.max(res, goldTable[i][0]);

		return res;
	}

	/** 9. Coin change problem **/
	/* recursive way */
	@Override
	public int noOfWayCoinChangeRecv(int a[], int m, int n) {
		if (n == 0)
			return 1;

		if (n < 0)
			return 0;

		if (m <= 0 && n >= 1)
			return 0;

		// count is sum of solutions (i)
		// including S[m-1] (ii) excluding S[m-1]
		return noOfWayCoinChangeRecv(a, m - 1, n) + noOfWayCoinChangeRecv(a, m, n - a[m - 1]);
	}

	/* by dynamic programming way */
	@Override
	public int noOfWayCoinChangeDynamic(int a[], int m, int n) {
		// O(mn)

		int[] table = new int[n + 1];

		// Base case (If given value is 0)
		table[0] = 1;

		// Pick all coins one by one and update the table[]
		// values after the index greater than or equal to
		// the value of the picked coin
		for (int i = 0; i < m; i++)
			for (int j = a[i]; j <= n; j++)
				table[j] += table[j - a[i]];

		return table[n];
	}

	/** 10. Friends Pairing Problem **/
	public int countFriendsPairings(int n) {
		int dp[] = new int[n + 1];

		// Filling dp[] in bottom-up manner using
		// recursive formula explained above.
		for (int i = 0; i <= n; i++) {
			if (i <= 2)
				dp[i] = i;
			else
				dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
		}

		return dp[n];
	}

	/** 11. Subset Sum Problem **/
	@Override
	public boolean isSubsetSumRcv(int set[], int n, int sum) {
		// Base Cases
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
			return false;

		// If last element is greater than
		// sum, then ignore it
		if (set[n - 1] > sum)
			return isSubsetSumRcv(set, n - 1, sum);

		/*
		 * else, check if sum can be obtained by any of the following (a) including the
		 * last element (b) excluding the last element
		 */
		return isSubsetSumRcv(set, n - 1, sum) || isSubsetSumRcv(set, n - 1, sum - set[n - 1]);
	}

	@Override
	public boolean isSubsetSumDp(int set[], int n, int sum) {
		// The value of subset[i][j] will be
		// true if there is a subset of
		// set[0..j-1] with sum equal to i
		boolean subset[][] = new boolean[sum + 1][n + 1];

		// If sum is 0, then answer is true
		for (int i = 0; i <= n; i++)
			subset[0][i] = true;

		// If sum is not 0 and set is empty,
		// then answer is false
		for (int i = 1; i <= sum; i++)
			subset[i][0] = false;

		// Fill the subset table in botton
		// up manner
		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1])
					subset[i][j] = subset[i][j] || subset[i - set[j - 1]][j - 1];
			}
		}

		return subset[sum][n];
	}

	/** 12. Subset Sum Problem in O(sum) space **/
	public boolean isSubsetSum(int set[], int n, int sum) {

		Arrays.sort(set);
		for (int i = n - 1; i >= 0; i--) {
			if (sum < set[i])
				continue;
			else if (sum - set[i] == 0)
				return true;
			else if (sum - set[i] > 0) {
				sum = sum - set[i];
			}
		}
		return false;
	}

	/** 13. Subset with sum divisible by m **/
	public boolean modularSum(int arr[], int n, int m) {
		if (n > m)
			return true;
		boolean DP[] = new boolean[m];
		for (int i = 0; i < n; i++) {
			if (DP[0])
				return true;
			boolean temp[] = new boolean[m];
			for (int j = 0; j < m; j++) {
				if (DP[j] == true) {
					if (DP[(j + arr[i]) % m] == false)
						temp[(j + arr[i]) % m] = true;
				}
			}
			for (int j = 0; j < m; j++)
				if (temp[j])
					DP[j] = true;
			DP[arr[i] % m] = true;
		}

		return DP[0];
	}

	/** 14. Largest divisible pairs subset **/
	@Override
	public int largestDivisiblePairSubsetDp(int a[]) {

		int n = a.length;
		int t[][] = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++)
				if (i == 0 || j == 0)
					t[i][j] = 1;// every one is divisile by self
		}

		for (int i = 1; i <= n; i++) {
			int div = a[i - 1];
			for (int j = 1; j <= n; j++) {

				if (j < n && a[j] % div == 0 && div != a[j]) {
					t[i][j] = 1 + Math.max(t[i - 1][j], t[i][j - 1]);
					div = a[j];
				} else

					t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);

			}
		}
		for (int i = 0; i <= n; i++) {
			System.out.println();
			for (int j = 0; j <= n; j++)
				System.out.print(" " + t[i][j]);
		}
		return t[n][n];
	}

	@Override
	public int largestDivisiblePairSubset(int a[]) {
		int n = a.length;
		Arrays.sort(a);

		int max = 0;
		for (int i = 0; i < n; i++) {
			// self divisible
			int cnt = 1;
			int div = a[i];
			for (int j = i + 1; j < n; j++) {
				if (a[j] % div == 0) {
					cnt++;
					div = a[j];
				}
			}
			if (cnt > max)
				max = cnt;
		}
		return max;
	}

	/** 15. Perfect Sum Problem (Print all subsets with given sum) **/
	public List<List<Integer>> subsetsOfGivenSum(int set[], int sm) {

		// TODO
		return null;
	}

	/** 16. Compute nCr % p **/
	@Override
	public int nCrModp(int n, int r, int p) {
		int C[] = new int[r + 1];

		C[0] = 1;
		for (int i = 1; i <= n; i++) {
			// Fill entries of current row using previous
			// row values
			for (int j = Math.min(i, r); j > 0; j--)

				// nCj = (n-1)Cj + (n-1)C(j-1);
				C[j] = (C[j] + C[j - 1]) % p;
		}
		return C[r];
	}

	/** 17. Choice of area **/
	// TODDO
	/** 18. Cutting a Rod **/
	@Override
	public int cutRodRcv(int price[], int n) {
		if (n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;

		// Recursively cut the rod in different pieces and
		// compare different configurations
		for (int i = 0; i < n; i++)
			max_val = Math.max(max_val, price[i] + cutRodRcv(price, n - i - 1));

		return max_val;
	}

	/* dynamic way */
	@Override
	public int cutRoDp(int price[], int n) {
		int val[] = new int[n + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner and return
		// the last entry from the table
		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				max_val = Math.max(max_val, price[j] + val[i - j - 1]);
			val[i] = max_val;
		}

		return val[n];
	}

	/** 19. Tiling with Dominoes **/
	@Override
	public int tillingDominoes(int n) {
		int[] A = new int[n + 1];
		int[] B = new int[n + 1];
		A[0] = 1;
		A[1] = 0;
		B[0] = 0;
		B[1] = 1;
		for (int i = 2; i <= n; i++) {
			A[i] = A[i - 2] + 2 * B[i - 1];
			B[i] = A[i - 1] + B[i - 2];
		}

		return A[n];
	}

	/** 20. Painting Fence Algorithm **/
	@Override
	public int paintingFence(int n, int k) {
		// There are k ways to color first post
		int total = k;

		// There are 0 ways for single post to
		// violate (same color_ and k ways to
		// not violate (different color)
		int same = 0;
		int diff = k;

		// Fill for 2 posts onwards
		for (int i = 2; i <= n; i++) {
			// Current same is same as previous diff
			same = diff;

			// We always have k-1 choices for next post
			diff = total * (k - 1);

			// Total choices till i.
			total = (same + diff);
		}

		return total;
	}

	// ap approch
	public int paintingFenceX(int n, int k) {

		int t[][] = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (i == 1)
					t[i][j] = j;
				else
					t[i][j] = t[i - 1][j - 1] + t[i - 1][j] + t[i][j - 1];
			}
		}
		return t[n][k];
	}

	/** 21. Newman�Shanks�Williams prime **/
	@Override
	public int newmanShanksWilliamsPrime(int n) {

		if (n == 0 || n == 1)
			return 1;
		return 2 * newmanShanksWilliamsPrime(n - 1) + newmanShanksWilliamsPrime(n - 2);
	}

	/* using dp */
	@Override
	public int newmanShanksWilliamsPrimeDp(int n) {

		int np[] = new int[n + 1];
		np[0] = np[1] = 1;
		for (int i = 2; i <= n; i++)
			np[i] = 2 * np[i - 1] + np[n - 2];
		return np[n];
	}

	/** 22. Assembly line scheduling **/
	public static int NUM_LINE = 2;
	public static int NUM_STATION = 4;

	public int carAssembly(int a[][], int t[][], int e[], int x[]) {
		int T1[] = new int[NUM_STATION];
		int T2[] = new int[NUM_STATION];
		int i;

		// time taken to leave first station in line 1
		T1[0] = e[0] + a[0][0];

		// time taken to leave first station in line 2
		T2[0] = e[1] + a[1][0];

		// Fill tables T1[] and T2[] using
		// the above given recursive relations
		for (i = 1; i < NUM_STATION; ++i) {
			T1[i] = Math.min(T1[i - 1] + a[0][i], T2[i - 1] + t[1][i] + a[0][i]);
			T2[i] = Math.min(T2[i - 1] + a[1][i], T1[i - 1] + t[0][i] + a[1][i]);
		}

		// Consider exit times and retutn minimum
		return Math.min(T1[NUM_STATION - 1] + x[0], T2[NUM_STATION - 1] + x[1]);
	}

	/** 23. Golomb sequence **/
	public List<Integer> printGolomb(int n) {
		List<Integer> rl = new ArrayList<>();
		int dp[] = new int[n + 1];
		// base cases
		dp[1] = 1;
		// Finding and printing first n
		// terms of Golomb Sequence.
		rl.add(dp[1]);
		for (int i = 2; i <= n; i++) {
			dp[i] = 1 + dp[i - dp[dp[i - 1]]];
			rl.add(dp[i]);
		}
		return rl;
	}

	/** 24. Moser-de Bruijn Sequence **/
	@Override
	public int[] moserDeBruijnSequence(int n) {
		int[] S = new int[n + 1];

		S[0] = 0;
		if (n != 0)
			S[1] = 1;
		for (int i = 2; i <= n; i++) {
			// S(2 * n) = 4 * S(n)
			if (i % 2 == 0)
				S[i] = 4 * S[i / 2];
			// S(2 * n + 1) = 4 * S(n) + 1
			else
				S[i] = 4 * S[i / 2] + 1;
		}
		return S;
	}

	/** 25. Newman-Conway Sequence **/
	@Override
	public int newmanConwaySequence(int n) {
		if (n == 1 || n == 2)
			return 1;
		else// P(n) = P(P(n - 1)) + P(n - P(n - 1))
			return newmanConwaySequence(newmanConwaySequence(n - 1))
					+ newmanConwaySequence(n - newmanConwaySequence(n - 1));
	}

	@Override
	public int newmanConwaySequenceDp(int n) {
		// Declare array to store sequence
		int f[] = new int[n + 1];
		f[0] = 0;
		f[1] = 1;
		f[2] = 1;
		int i;

		for (i = 3; i <= n; i++)
			f[i] = f[f[i - 1]] + f[i - f[i - 1]];

		return f[n];
	}

	/** 26. Find maximum length Snake sequence **/
	@Override
	public List<Integer> maxLenSnakeSequence(int a[][]) {

		List<Integer> rl = new ArrayList<>();
		int t[][] = new int[a.length][a[0].length];
		int max_row = 0;
		int max_col = 0;
		int max_len = 0;
		int i;
		int j;
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[0].length; j++) {
				if (j > 0 && Math.abs(a[i][j] - a[i][j - 1]) == 1) {
					t[i][j] = Math.max(t[i][j], t[i][j - 1] + 1);
					if (max_len < t[i][j]) {
						max_len = t[i][j];
						max_row = i;
						max_col = j;
					}
				} else if (i > 0 && Math.abs(a[i][j] - a[i - 1][j]) == 1) {
					t[i][j] = Math.max(t[i][j], t[i - 1][j] + 1);
					if (max_len < t[i][j]) {
						max_len = t[i][j];
						max_row = i;
						max_col = j;
					}
				}
			}
		}
		i = max_row;
		j = max_col;
		rl.add(a[max_row][max_col]);
		while (t[i][j] != 0) {
			if (i > 0 && t[i][j] - 1 == t[i - 1][j]) {
				rl.add(a[i - 1][j]);
				i--;
			} else if (j > 0 && t[i][j] - 1 == t[i][j - 1]) {
				rl.add(a[i][j - 1]);
				j--;
			}
		}
		Collections.reverse(rl);
		return rl;
	}

	/** 27. Print n terms of Newman-Conway Sequence **/
	// @See 25.

	/** 28. Print Fibonacci sequence using 2 variables **/
	@Override
	public void fib(int n) {
		int a = 0, b = 1;
		if (n >= 0)
			System.out.print(a + " ");
		if (n >= 1)
			System.out.print(b + " ");
		for (int i = 2; i <= n; i++) {
			System.out.print(a + b + " ");
			b = a + b;
			a = b - a;
		}
	}

	/** 29. Print Fibonacci Series in reverse order **/
	@Override
	public void reverseFibonacci(int n) {
		int a[] = new int[n + 1];
		// assigning first and second elements
		a[0] = 0;
		a[1] = 1;
		for (int i = 2; i <= n; i++) {
			a[i] = a[i - 2] + a[i - 1];
		}
		for (int i = n; i >= 0; i--) {
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 30. Count even length binary sequences with same sum of first and second half
	 * bits
	 **/
	public int countSeq(int n, int diff) {
		// We can't cover difference of more
		// than n with 2n bits
		if (Math.abs(diff) > n)
			return 0;
		// n == 1, i.e., 2 bit long sequences
		if (n == 1 && diff == 0)
			return 2;
		if (n == 1 && Math.abs(diff) == 1)
			return 1;

		int res = // First bit is 0 & last bit is 1
				countSeq(n - 1, diff + 1) +
				// First and last bits are same
						2 * countSeq(n - 1, diff) +
						// First bit is 1 & last bit is 0
						countSeq(n - 1, diff - 1);
		return res;
	}

	@Override
	public int countSeqDp(int n, int diff) {
		int t[][] = new int[1000][1000];
		// Initialize all entries of lookup
		// table as not filled
		// memset(lookup, -1, sizeof(lookup));
		for (int k = 0; k < t.length; k++) {
			for (int j = 0; j < t.length; j++) {
				t[k][j] = -1;
			}
		}

		// call countSeqUtil()
		return countSeqUtil(t, n, diff);
	}

	@Override
	public int countSeqUtil(int[][] t, int n, int dif) {
		// We can't cover diference of
		// more than n with 2n bits
		if (Math.abs(dif) > n)
			return 0;

		// n == 1, i.e., 2 bit long sequences
		if (n == 1 && dif == 0)
			return 2;
		if (n == 1 && Math.abs(dif) == 1)
			return 1;

		// Check if this subbproblem is already
		// solved n is added to dif to make
		// sure index becomes positive
		if (t[n][n + dif] != -1)
			return t[n][n + dif];

		int res = // First bit is 0 & last bit is 1
				countSeqUtil(t, n - 1, dif + 1) +
				// First and last bits are same
						2 * countSeqUtil(t, n - 1, dif) +
						// First bit is 1 & last bit is 0
						countSeqUtil(t, n - 1, dif - 1);
		// Store result in lookup table
		// and return the result
		return t[n][n + dif] = res;
	}

	@Override
	public int countSeqRec(int n) {
		int nCr = 1, res = 1;

		// Calculate SUM ((nCr)^2)
		for (int r = 1; r <= n; r++) {
			// Compute nCr using nC(r-1)
			// nCr/nC(r-1) = (n+1-r)/r;
			nCr = (nCr * (n + 1 - r)) / r;

			res += nCr * nCr;
		}

		return res;
	}

	/**
	 * 31. Sequences of given length where every element is more than or equal to
	 * twice of previous
	 **/
	public int getTotalNumberOfSequences(int m, int n) {
		// A special sequence cannot exist if length
		// n is more than the maximum value m.
		if (m < n)
			return 0;

		// If n is 0, found an empty special sequence
		if (n == 0)
			return 1;
		// There can be two possibilities : (1) Reduce
		// last element value (2) Consider last element
		// as m and reduce number of terms
		return getTotalNumberOfSequences(m - 1, n) + getTotalNumberOfSequences(m / 2, n - 1);
	}

	/* using dp */
	public int getTotalNumberOfSequencesDp(int m, int n) {
		// define T and build in bottom manner to store
		// number of special sequences of length n and
		// maximum value m
		int T[][] = new int[m + 1][n + 1];
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				// Base case : If length of sequence is 0
				// or maximum value is 0, there cannot
				// exist any special sequence
				if (i == 0 || j == 0)
					T[i][j] = 0;

				// if length of sequence is more than
				// the maximum value, special sequence
				// cannot exist
				else if (i < j)
					T[i][j] = 0;

				// If length of sequence is 1 then the
				// number of special sequences is equal
				// to the maximum value
				// For example with maximum value 2 and
				// length 1, there can be 2 special
				// sequences {1}, {2}
				else if (j == 1)
					T[i][j] = i;

				// otherwise calculate
				else
					T[i][j] = T[i - 1][j] + T[i / 2][j - 1];
			}
		}
		return T[m][n];
	}

	/** 32. Longest Common Subsequence **/
	/* using recursive way O(2^n) wost case */
	@Override
	public int longestCommonSubsequenceRecv(String st1, String st2, int m, int n) {

		if (m == 0 || n == 0)
			return 0;
		if (st1.charAt(m - 1) == st2.charAt(n - 1)) {
			return 1 + longestCommonSubsequenceRecv(st1, st2, m - 1, n - 1);
		} else {
			return Math.max(longestCommonSubsequenceRecv(st1, st2, m - 1, n),
					longestCommonSubsequenceRecv(st1, st2, m, n - 1));
		}
	}

	/* using dynaic programming O(mn) */
	@Override
	public int longestCommonSubsequenceDynamic(char[] ch1, char[] ch2, int m, int n) {

		int l[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					l[i][j] = 0;
				else if (ch1[i - 1] == ch2[j - 1]) {
					l[i][j] = 1 + l[i - 1][j - 1];
				} else
					l[i][j] = Math.max(l[i][j - 1], l[i - 1][j]);
			}
		}

		for (int i = 0; i <= m; i++) {
			System.out.println();
			for (int j = 0; j <= n; j++) {
				System.out.print(l[i][j] + " ");
			}
		}
		return l[m][n];
	}

	/** 34. Longest Increasing Subsequence **/

	@Override
	public List<Integer> longestIncreasingSubsequenceItr(int arr[], int n) {
		List<Integer> prev = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (i == 0)
				prev.add(arr[i]);
			else
				curr.add(arr[i]);
			for (int j = i + 1; j < n; j++) {
				if (prev.get(prev.size() - 1) < arr[j]) {
					if (i == 0)
						prev.add(arr[j]);
					else
						curr.add(arr[j]);
				} else if (curr.size() > 0 && curr.get(curr.size() - 1) < arr[j]) {
					curr.add(arr[j]);
				}
			}
			// if rest of size of array is less the then no need to calculate
			if (curr.size() > n - i || prev.size() > n - i)
				break;
			if (curr.size() > prev.size()) {
				prev = curr;
			}
			curr = new ArrayList<>();
		}
		return curr.size() > prev.size() ? curr : prev;
	}

	/* by dynamic programming */
	@Override
	public int longestIncreasingSubsequenceDynamic(int arr[], int n) {
		int max = 0;
		int lis[] = new int[n];
		// initialize the list
		for (int i = 0; i < n; i++)
			lis[i] = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
			}
		}

		for (int i = 0; i < lis.length; i++) {
			if (max < lis[i])
				max = lis[i];
		}
		return max;
	}

	/** 35. A Space Optimized Solution of LCS **/
	@Override
	public int spaceOptimizedLongestCommonSubsequence(String X, String Y) {
		// Find lengths of two strings
		int m = X.length(), n = Y.length();

		int L[][] = new int[2][n + 1];

		// Binary index, used to index
		// current row and previous row.
		int bi = 0;
		for (int i = 0; i <= m; i++) {
			// Compute current binary index
			bi = i & 1;
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[bi][j] = 0;

				else if (X.charAt(i - 1) == Y.charAt(j - 1))
					L[bi][j] = L[1 - bi][j - 1] + 1;

				else
					L[bi][j] = Math.max(L[1 - bi][j], L[bi][j - 1]);
			}
		}
		// Last filled entry contains length of
		// LCS for X[0..n-1] and Y[0..m-1]
		return L[bi][n];
	}

	/** 36. LCS (Longest Common Subsequence) of three strings **/
	@Override
	public int lcsOf3(String X, String Y, String Z, int m, int n, int o) {
		int L[][][] = new int[m + 1][n + 1][o + 1];
		/*
		 * Following steps build L[m+1][n+1][o+1] in bottom up fashion. Note that
		 * L[i][j][k] contains length of LCS of X[0..i-1] and Y[0..j-1] and Z[0.....k-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				for (int k = 0; k <= o; k++) {
					if (i == 0 || j == 0 || k == 0)
						L[i][j][k] = 0;

					else if (X.charAt(i - 1) == Y.charAt(j - 1) && X.charAt(i - 1) == Z.charAt(k - 1))
						L[i][j][k] = L[i - 1][j - 1][k - 1] + 1;

					else
						L[i][j][k] = Math.max(Math.max(L[i - 1][j][k], L[i][j - 1][k]), L[i][j][k - 1]);
				}
			}
		}
		/*
		 * L[m][n][o] contains length of LCS for X[0..n-1] and Y[0..m-1] and Z[0..o-1]
		 */
		return L[m][n][o];
	}

	/** 37. Maximum sum Bi-tonic Sub-sequence **/
	// if arrangement is allowed then just sum of element
	// trick sort and replace the last with middle
	@Override
	public int MaxSumBS(int arr[], int n) {
		int max_sum = Integer.MIN_VALUE;

		// MSIBS[i] ==> Maximum sum Increasing Bi-tonic
		// subsequence ending with arr[i]
		// MSDBS[i] ==> Maximum sum Decreasing Bi-tonic
		// subsequence starting with arr[i]
		// Initialize MSDBS and MSIBS values as arr[i] for
		// all indexes
		int MSIBS[] = new int[n];
		int MSDBS[] = new int[n];
		for (int i = 0; i < n; i++) {
			MSDBS[i] = arr[i];
			MSIBS[i] = arr[i];
		}

		// Compute MSIBS values from left to right */
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && MSIBS[i] < MSIBS[j] + arr[i])
					MSIBS[i] = MSIBS[j] + arr[i];

		// Compute MSDBS values from right to left
		for (int i = n - 2; i >= 0; i--)
			for (int j = n - 1; j > i; j--)
				if (arr[i] > arr[j] && MSDBS[i] < MSDBS[j] + arr[i])
					MSDBS[i] = MSDBS[j] + arr[i];

		// Find the maximum value of MSIBS[i] +
		// MSDBS[i] - arr[i]
		for (int i = 0; i < n; i++)
			max_sum = Math.max(max_sum, (MSDBS[i] + MSIBS[i] - arr[i]));

		// return max sum of bi-tonic
		// sub-sequence
		return max_sum;
	}

	/** 38. Maximum Sum Increasing Subsequence **/
	@Override
	public int maxSumIncreasingSubseq(int arr[], int n) {
		int i, j, max = 0;
		int msis[] = new int[n];

		/* Initialize msis values for all indexes */
		for (i = 0; i < n; i++)
			msis[i] = arr[i];

		/* Compute maximum sum values in bottom up manner */
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (arr[i] > arr[j] && msis[i] < msis[j] + arr[i])
					msis[i] = msis[j] + arr[i];

		/* Pick maximum of all msis values */
		for (i = 0; i < n; i++)
			if (max < msis[i])
				max = msis[i];

		return max;
	}

	/** 39. Maximum product of an increasing subsequence **/
	@Override
	public int maxProductIncreasingSubseq(int arr[], int n) {
		int[] mpis = new int[n];
		int max = Integer.MIN_VALUE;

		/* Initialize MPIS values */
		for (int i = 0; i < n; i++)
			mpis[i] = arr[i];

		/*
		 * Compute optimized MPIS values considering every element as ending element of
		 * sequence
		 */
		for (int i = 1; i < n; i++)
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && mpis[i] < (mpis[j] * arr[i]))
					mpis[i] = mpis[j] * arr[i];
		/*
		 * Pick maximum of all product values using for loop
		 */
		for (int k = 0; k < mpis.length; k++) {
			if (mpis[k] > max) {
				max = mpis[k];
			}
		}

		return max;
	}

	/** 40. Count all subsequences having product less than K **/
	@Override
	public int productSubSeqCount(ArrayList<Integer> arr, int k) {
		int n = arr.size();
		int dp[][] = new int[k + 1][n + 1];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {

				// number of subsequence using j-1 terms
				dp[i][j] = dp[i][j - 1];

				// if arr[j-1] > i it will surely make
				// product greater thus it won't contribute
				// then
				if (arr.get(j - 1) <= i && arr.get(j - 1) > 0)
					// number of subsequence using 1 to j-1
					// terms and j-th term
					dp[i][j] += dp[i / arr.get(j - 1)][j - 1] + 1;
			}
		}
		for (int i = 0; i < k; i++)
			System.out.println(Arrays.toString(dp[i]));
		return dp[k][n];
	}

	/** 41. Maximum subsequence sum such that no three are consecutive **/
	@Override
	public int maxSumWO3Consec(int arr[], int n) {
		// Stores result for subarray arr[0..i], i.e.,
		// maximum possible sum in subarray arr[0..i]
		// such that no three elements are consecutive.
		int sum[] = new int[n];

		// Base cases (process first three elements)
		if (n >= 1)
			sum[0] = arr[0];

		if (n >= 2)
			sum[1] = arr[0] + arr[1];

		if (n > 2)
			sum[2] = Math.max(sum[1], Math.max(arr[1] + arr[2], arr[0] + arr[2]));

		// Process rest of the elements
		// We have three cases
		// 1) Exclude arr[i], i.e., sum[i] = sum[i-1]
		// 2) Exclude arr[i-1], i.e., sum[i] = sum[i-2] + arr[i]
		// 3) Exclude arr[i-2], i.e., sum[i-3] + arr[i] + arr[i-1]
		for (int i = 3; i < n; i++)
			sum[i] = Math.max(Math.max(sum[i - 1], sum[i - 2] + arr[i]), arr[i] + arr[i - 1] + sum[i - 3]);

		return sum[n - 1];
	}

	/** 42. Longest subsequence such that difference between adjacents is one **/
	@Override
	public int longestSubseqAdjDiffIsOne(int a[]) {

		int n = a.length;
		int ld[] = new int[n];
		Arrays.fill(ld, 1);
		for (int i = 0; i < n; i++) {
			int pos = i;
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[pos] - a[j]) == 1) {
					pos = j;
					ld[i]++;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++)
			if (max < ld[i])
				max = ld[i];
		return max;
	}

	/**
	 * 43. Maximum length subsequence with difference between adjacent elements as
	 * either 0 or 1
	 **/
	@Override
	public int longestSubseqAdjDiffIsOneOrZero(int a[]) {
		int n = a.length;
		int ld[] = new int[n];
		Arrays.fill(ld, 1);
		for (int i = 0; i < n; i++) {
			int pos = i;
			for (int j = i + 1; j < n; j++) {
				if (Math.abs(a[pos] - a[j]) == 1 || Math.abs(a[pos] - a[j]) == 0) {
					pos = j;
					ld[i]++;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n; i++)
			if (max < ld[i])
				max = ld[i];
		return max;
	}

	/**
	 * 44. Maximum sum increasing subsequence from a prefix and a given element
	 * after prefix is must
	 **/
	// TODO for better understanding
	@Override
	public int preCompute(int a[], int n, int index, int k) {
		int dp[][] = new int[n][n];

		// Initializing the first row of
		// the dp[][].
		for (int i = 0; i < n; i++) {
			if (a[i] > a[0])
				dp[0][i] = a[i] + a[0];
			else
				dp[0][i] = a[i];
		}

		// Creating the dp[][] matrix.
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[j] > a[i] && j > i) {
					if (dp[i - 1][i] + a[j] > dp[i - 1][j])
						dp[i][j] = dp[i - 1][i] + a[j];
					else
						dp[i][j] = dp[i - 1][j];
				} else
					dp[i][j] = dp[i - 1][j];
			}
		}

		// To calculate for i=4 and k=6.
		return dp[index][k];
	}

	/** 45. Maximum Length Chain of Pairs **/
	@Override
	public int maxChainLength(Pair arr[], int n) {
		int i, j, max = 0;
		int mcl[] = new int[n];

		/* Initialize MCL (max chain length) values for all indexes */
		for (i = 0; i < n; i++)
			mcl[i] = 1;

		/* Compute optimized chain length values in bottom up manner */
		int pos;
		for (i = 0; i < n; i++) {
			pos = i;
			for (j = i + 1; j < n; j++)
				if (arr[pos].b < arr[j].a) {
					mcl[i]++;
					pos = j;
				}
		}
		// mcl[i] now stores the maximum chain length ending with pair i
		/* Pick maximum of all MCL values */
		for (i = 0; i < n; i++)
			if (max < mcl[i])
				max = mcl[i];

		return max;
	}

	/** 46. Print Maximum Length Chain of Pairs **/
	@Override
	public List<Pair> printMaxChainLength(Pair arr[], int n) {
		int i, j, max = 0;
		int mcl[] = new int[n];
		List<Pair> rl = new ArrayList<>();
		/* Initialize MCL (max chain length) values for all indexes */
		for (i = 0; i < n; i++)
			mcl[i] = 1;

		/* Compute optimized chain length values in bottom up manner */
		int pos;

		for (i = 0; i < n; i++) {
			pos = i;
			for (j = i + 1; j < n; j++)
				if (arr[pos].b < arr[j].a) {
					mcl[i]++;
					pos = j;
				}
		}
		// mcl[i] now stores the maximum chain length ending with pair i
		/* Pick maximum of all MCL values */
		int maxInd = 0;
		for (i = 0; i < n; i++) {
			if (max < mcl[i]) {
				max = mcl[i];
				maxInd = i;
			}
		}
		// start from the maxInd
		pos = maxInd;
		rl.add(arr[pos]);
		for (j = pos + 1; j < n; j++)
			if (arr[pos].b < arr[j].a) {
				rl.add(arr[j]);
				pos = j;
			}
		return rl;
	}

	/** 47. Path with maximum average value **/
	public List<Integer> maxAverageValuePath(int cost[][], int N) {
		List<Integer> rl = new ArrayList<>();
		// maximum sum path is max sum average
		int dp[][] = new int[N][N];
		/*
		 * Initialize first column of total cost(dp) array
		 */
		dp[0][0] = cost[0][0];
		for (int i = 1; i < N; i++)
			dp[i][0] = dp[i - 1][0] + cost[i][0];

		/* Initialize first row of dp array */
		for (int j = 1; j < N; j++)
			dp[0][j] = dp[0][j - 1] + cost[0][j];

		/* Construct rest of the dp array */
		for (int i = 1; i < N; i++)
			for (int j = 1; j < N; j++)
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + cost[i][j];

		// divide maximum sum by constant path
		// length : (2N - 1) for getting average
		System.out.println(dp[N - 1][N - 1] / (2 * N - 1));
		// return null;

		// finding the path
		rl.add(cost[N - 1][N - 1]);
		int i = N - 1;
		int j = N - 1;
		while (i != 0 && j != 0) {
			if (dp[i][j - 1] < dp[i - 1][j]) {
				rl.add(cost[i - 1][j]);
				i--;
			} else {
				rl.add(cost[i][j - 1]);
				j--;
			}
		}
		rl.add(cost[0][0]);
		Collections.reverse(rl);
		return rl;
	}

	/** 48. Maximum games played by winner **/
	@Override
	public int maxGameByWinner(int N) {
		int[] dp = new int[N];

		// for 0 games, 1 player is needed
		// for 1 game, 2 players are required
		dp[0] = 1;
		dp[1] = 2;

		// loop until i-th Fibonacci number is
		// less than or equal to N
		int i;
		for (i = 1; dp[i++] < N;)
			dp[i] = dp[i - 1] + dp[i - 2];
		// result is (i - 2) because i will be
		// incremented one extra in while loop
		// and we want the last value which is
		// smaller than N, so one more decrement
		return (i - 2);
	}

	/** 49. Maximum path sum in a triangle **/
	@Override
	public int maxPathSum(int tri[][], int m, int n) {
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (tri[i + 1][j] > tri[i + 1][j + 1])
					tri[i][j] += tri[i + 1][j];
				else
					tri[i][j] += tri[i + 1][j + 1];
			}
		}
		return tri[0][0];
	}

	/** 50. Minimum Sum Path in a Triangle **/
	@Override
	public int minSumPath(int A[][]) {

		int[] memo = new int[A.length];
		int n = A.length - 1;

		// For the bottom row
		for (int i = 0; i < A[n].length; i++)
			memo[i] = A[n][i];
		// Calculation of the
		// remaining rows, in
		// bottom up manner.
		for (int i = n - 1; i >= 0; i--)
			for (int j = 0; j < A[i + 1].length - 1; j++)
				memo[j] = A[i][j] + (int) Math.min(memo[j], memo[j + 1]);
		return memo[0];
	}
	/**51.	Maximum sum of a path in a Right Number Triangle**/
	public int maxSumPathRightNumTringleRec(int tr[][], int i,int j){

		if(i==tr.length)
			return 0;
		int max= tr[i][j] + Math.max(maxSumPathRightNumTringleRec(tr, i+1,j), maxSumPathRightNumTringleRec(tr,i+1,j+1));
		return max;
	}

	public int maxSumPathRightNumTringle(int tr[][], int i,int j,int dp[][]){

		if(i==tr.length)
			return 0;
		if(dp[i][j]!=-1)
			return dp[i][j];
		return dp[i][j]=tr[i][j]+Math.max(maxSumPathRightNumTringle(tr,i+1,j,dp), maxSumPathRightNumTringle(tr,i+1,j+1, dp));
	}

	/*52.	Size of The Subarray With Maximum Sum, max sum continuous array*/
	public int maxLexSubArrayOfMaxSum(int a[])
	{
          int maxSoFar=Integer.MIN_VALUE, maxEndingHere = 0, start=0, end=0, s=0;
		  for(int i=0;i<a.length;i++)
		  {
			  maxEndingHere+=a[i];
			  if(maxSoFar < maxEndingHere)
			  {
				  maxSoFar = maxEndingHere;
				  start=s;
				  end = i;
			  }
			  if(maxEndingHere < 0)
			  {
				  maxEndingHere =0;
				  s = i+1;
			  }
		  }
		  return end-start+1;
	}
	/*53.	Maximum sum of pairs with specific difference*/
	public int maxSumPairsOnKDiff(int a[], int k)
	{
		a = Arrays.stream(a).sorted().toArray();
		int sum=0;
		for(int i =a.length-1;i>0;i-=2)
		{
			if(a[i]-a[i-1] < k)
				sum+=a[i]+a[i-1];
			else i++;
		}
		return sum;
	}
	/*54.	Maximum size square sub-matrix with all 1s*/
	@Override
	public int[][] maxSquareSubMatrix(int a[][]) {
		int i, j;
		int maxS, maxI, maxJ;
		int rArr[][] = null;

		int R = a.length;
		int C = a[0].length;

		int s[][] = new int[R][C];

		// copy first row and rist col of a to s
		for (i = 0; i < R; i++)
			s[i][0] = a[i][0];
		for (j = 0; j < C; j++)
			s[0][j] = a[0][j];

		/* Construct other entries of S[][] */
		for (i = 1; i < R; i++) {
			for (j = 1; j < C; j++) {
				if (a[i][j] == 1)
					s[i][j] = Math.min(s[i][j - 1], Math.min(s[i - 1][j], s[i - 1][j - 1])) + 1;
				else
					s[i][j] = 0;
			}
		}
		/*
		 * Find the maximum entry, and indexes of maximum entry in S[][]
		 */
		maxS = s[0][0];
		maxI = 0;
		maxJ = 0;
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				if (maxS < s[i][j]) {
					maxS = s[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}
		// copy result
		rArr = new int[maxS][maxS];

		int k, l;
		for (i = maxI, k = 0; i > maxI - maxS; i--, k++) {
			for (j = maxJ, l = 0; j > maxJ - maxS; j--, l++) {
				rArr[k][l] = a[i][j];
			}
		}
		return rArr;
	}

	/*55.	Maximum number of segments of lengths a, b and c*/
	public int maxNoOfSegment(int n , int a, int b, int c){
		//enough space
		int dp[] = new int[n+10];
		Arrays.fill(dp,-1);

		dp[0] = 0;

		for(int i = 0; i < n; i++)
		{
			if(dp[i]!=-1)
			{
				if(i+a <= n)
					dp[i+a]= Math.max(dp[i]+1, dp[i+a]);
				if(i+b <= n)
					dp[i+b]= Math.max(dp[i]+1, dp[i+b]);
				if(i+c <= n)
					dp[i+c]= Math.max(dp[i]+1, dp[i+c]);
			}
		}
		return dp[n];
	}
	/*********************************************************************************************************************************************************************/

	/** 4. Longest Repeated Subsequence **/
	@Override
	public String longestRepeatedSubsequenceDynamic(String st) {

		char chArr[] = st.toCharArray();
		int n = st.length();
		int dp[][] = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (chArr[i - 1] == chArr[j - 1] && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}
		String res = "";

		// Traverse dp[][] from bottom right
		int i = n, j = n;
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j - 1] + 1) {
				res = res + st.charAt(i - 1);
				i--;
				j--;
			}

			else if (dp[i][j] == dp[i - 1][j])
				i--;
			else
				j--;
		}
		StringBuffer stb = new StringBuffer(res).reverse();

		return stb.toString();
	}

	/** 5. Largest Sum Contiguous Subarray **/
	/* by iterative */
	@Override
	public int LargestSumContiguousSubarrayItr(int a[]) {

		int max_so_far = 0, max_ending_here = 0;
		for (int i = 0; i < a.length; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_ending_here < 0)
				max_ending_here = 0;

			else if (max_so_far < max_ending_here)
				max_so_far = max_ending_here;
		}
		return max_so_far;
	}

	/* by dynamic programming */
	@Override
	public int LargestSumContiguousSubarrayDynamic(int a[]) {

		int max_so_far = a[0];
		int curr_max = a[0];

		for (int i = 1; i < a.length; i++) {
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_so_far = Math.max(max_so_far, curr_max);
		}
		return max_so_far;
	}

	/** max suqure sub matrix whouse corner is x **/
	// TODO
	public int maxSqureOfXCorenr(int a[][], int x) {
		int n = a.length;
		int m = a[0].length;
		@SuppressWarnings("unused")
		int i, j, l, k, max, posI, posJ;
		max = posI = posJ = 0;
		for (i = n - 1; i >= 0; i--) {
			for (j = m - 1; j >= 0; j--) {
				if (a[i][j] == x) {
					a[i][j] = 1;
					l = i;
					k = j;
					while (l >= 1 && k >= 1) {
						if (a[l - 1][k] == a[l][k - 1] && a[l - 1][k - 1] == a[l - 1][k] && a[l - 1][k - 1] == x) {
							a[i][j] = i - l + 2;
						}
						l--;
						k--;
					}
					if (a[i][j] > max) {
						max = a[i][j];
						posI = i;
						posJ = j;
					}
				}
			}
		}
		return max;
	}
	/* by iterative way */

	/** 9. Min Cost Path **/
	/* by recursive way */
	@Override
	public int minCostPathRecursive(int mcp[][], int m, int n) {

		if (m < 0 || n < 0)
			return Integer.MAX_VALUE;
		else if (m == 0 && n == 0)
			return mcp[m][n];
		else
			return mcp[m][n] + AlgoUtils.min(minCostPathRecursive(mcp, m - 1, n - 1),
					minCostPathRecursive(mcp, m - 1, n), minCostPathRecursive(mcp, m, n - 1));
	}

	/* by dynamic programming */
	@Override
	public int minCostPathDynamic(int cost[][], int m, int n) {
		// int mcp[][]=new int[m+1][n+1]; this process also can be useful
		int i, j;
		int tc[][] = new int[cost.length][cost[0].length];
		tc[0][0] = cost[0][0];

		/* Initialize first column of total cost(tc) array */
		for (i = 1; i <= m; i++)
			tc[i][0] = tc[i - 1][0] + cost[i][0];

		/* Initialize first row of tc array */
		for (j = 1; j <= n; j++)
			tc[0][j] = tc[0][j - 1] + cost[0][j];

		/* Construct rest of the tc array */
		for (i = 1; i <= m; i++)
			for (j = 1; j <= n; j++)
				tc[i][j] = cost[i][j] + AlgoUtils.min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1]);

		return tc[m][n];
	}
}

/*
 * public int editDistance(char[] ch1, char ch2[], int m, int n) {
 * 
 * if (m == 0) return n; if (n == 0) return m; if (ch1[m - 1] == ch1[n - 1])
 * return editDistance(ch1, ch2, m - 1, n - 1);
 * 
 * return 1 + AlgoUtils.min(editDistance(ch1, ch2, m, n - 1), // insert
 * editDistance(ch1, ch2, m - 1, n), // remove editDistance(ch1, ch2, m - 1, n -
 * 1));// replace }
 * 
 * public int ED(char[] ch1, char ch2[], int m, int n) { int ed[][] = new int[m
 * + 1][n + 1];
 * 
 * for (int i = 0; i <= m; i++) { for (int j = 0; j <= n; j++) { if (i == 0)
 * ed[i][j] = j; else if (j == 0) ed[i][j] = i; else if (ch1[m - 1] == ch2[n -
 * 1]) ed[i][j] = ed[i - 1][j - 1]; else ed[i][j] = 1 + AlgoUtils.min(ed[i][j -
 * 1], // insert ed[i - 1][j], // remove ed[i - 1][j - 1]);// replace
 * 
 * } } return ed[m][n]; }
 */
