package com.design.analysis.core.algo.matheticalalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.design.analysis.core.algo.utils.AlgoUtils;

public class TrianglesImpl implements ITriangles {

	/** 1.Time required to meet in equilateral triangle **/
	public float timeToMeet(double s, double v) {
		return (float) (2 * s / (3 * v));
	}

	/** 2.Trinomial Triangle **/
	private static final int MAX = 10;

	/* Function to print Trinomial Triangle of height n. */
	public void printTrinomial(int n) {
		int[][] dp = new int[MAX][MAX];

		// printing n rows.
		for (int i = 0; i < n; i++) {
			// for space
			for (int j = 1; j < n - i; j++)
				System.out.print("  ");
			// printing first half of triangle
			for (int j = -i; j <= 0; j++)
				System.out.print(trinomialValue(dp, i, j) + " ");

			// printing second half of triangle.
			for (int j = 1; j <= i; j++)
				System.out.print(trinomialValue(dp, i, j) + " ");

			System.out.println();
		}
	}

	/* Function to find the trinomial triangle value. */
	public int trinomialValue(int dp[][], int n, int k) {
		// Using property of trinomial triangle.
		if (k < 0)
			k = -k;

		// If value already calculated, return that.
		if (dp[n][k] != 0)
			return dp[n][k];

		// base case
		if (n == 0 && k == 0)
			return 1;

		// base case
		if (k < -n || k > n)
			return 0;

		// recursive step and storing the value.
		return (dp[n][k] = trinomialValue(dp, n - 1, k - 1) + trinomialValue(dp, n - 1, k)
				+ trinomialValue(dp, n - 1, k + 1));
	}

	/** 3.Leibniz harmonic triangle **/
	public void leibnizHarmonicTriangle(int n) {
		int C[][] = new int[n + 1][n + 1];

		// Calculate value of Binomial
		// Coefficient in bottom up manner
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, n); j++) {

				// Base Cases
				if (j == 0 || j == i)
					C[i][j] = 1;

				// Calculate value using
				// previously stored values
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		// printing Leibniz Harmonic Triangle
		for (int i = 1; i <= n; i++) {
			// for space
			for (int j = 0; j < n - i; j++)
				System.out.print("   ");
			for (int j = 1; j <= i; j++)
				System.out.print("1/" + i * C[i - 1][j - 1] + " ");

			System.out.println();
		}
	}

	/** 4.Hosoya�s Triangle **/
	static int N = 5;

	/* Print the Hosoya triangle of height n. */
	public void printHosoya(int n) {
		int dp[][] = new int[N][N];

		// base case.
		dp[0][0] = dp[1][0] = 1;
		dp[1][1] = 1;

		// For each row.
		for (int i = 2; i < n; i++) {
			// for each column;
			for (int j = 0; j < n; j++) {
				// recursive steps.
				if (i > j)
					dp[i][j] = dp[i - 1][j] + dp[i - 2][j];

				else
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 2][j - 2];
			}
		}

		// printing the solution
		for (int i = 0; i < n; i++) {
			for (int j = 1; j < n - i; j++)
				System.out.print(" ");
			for (int j = 0; j <= i; j++)
				System.out.print(dp[i][j] + " ");

			System.out.println("");
		}
	}

	/** 5. Number of triangles after N moves **/
	public int numberOfTriangles(int n) {
		int[] answer = new int[n + 1];
		answer[0] = 1;

		for (int i = 1; i <= n; i++)
			answer[i] = answer[i - 1] * 3 + 2;

		return answer[n];
	}

	/** 6. Find Perimeter of a triangle **/
	public int perimeterOfTringle(int a, int b, int c) {
		return a + b + c;
	}

	/** 7. Check whether right angled triangle is valid or not for large sides **/
	public boolean triplets(long a, long b, long c) {
		if (a <= 0 || b <= 0 || c <= 0)
			return false;

		List<Long> vec = new ArrayList<>();
		vec.add(a);
		vec.add(b);
		vec.add(c);
		Collections.sort(vec);

		// Re-initialize a, b, c in ascending order
		a = vec.get(0);
		b = vec.get(1);
		c = vec.get(2);

		// Check validation of sides of triangle
		if (a + b <= c)
			return false;

		long p1 = a, p2 = c - b;

		// Reduce fraction to simplified form
		long div = AlgoUtils.gcd(p1, p2);
		p1 /= div;
		p2 /= div;

		long q1 = c + b, q2 = a;

		// Reduce fraction to simplified form
		div = AlgoUtils.gcd(q1, q2);
		q1 /= div;
		q2 /= div;

		// If fraction are equal return
		// 'true' else 'false'
		return (p1 == q1 && p2 == q2);
	}

	/** 8. Maximum height of triangular arrangement of array values **/

	/** 9. Find other two sides of a right angle triangle **/
	public void printOtherSides(int n) {
		// if n is odd
		if (n % 2 != 0) {
			// case of n = 1 handled separately
			if (n == 1)
				System.out.println("-1");
			else {
				int b = (n * n - 1) / 2;
				int c = (n * n + 1) / 2;
				System.out.println("b = " + b + ", c = " + c);
			}
		} else {
			// case of n = 2 handled separately
			if (n == 2)
				System.out.println("-1");
			else {
				int b = n * n / 4 - 1;
				int c = n * n / 4 + 1;
				System.out.println("b = " + b + ", c = " + c);
			}
		}
	}

	/** 10. Find coordinates of the triangle given midpoint of each side **/
	/* Finds vertices of a triangles from given middle vertices. */
	public void findVertex(int xmid[], int ymid[]) {
		// Find X coordinates of verices.
		List<Integer> V1 = solve(xmid);

		// Find Y coordinates of verices.
		List<Integer> V2 = solve(ymid);

		// Output the solution.
		for (int i = 0; i < 3; i++)
			System.out.println("(" + V1.get(i) + ", " + V2.get(i) + ")");
	}

	public List<Integer> solve(int v[]) {

		List<Integer> res = new ArrayList<>();

		// Finding sum of all three coordinate.
		int all3 = v[0] + v[1] + v[2];

		// Solving the equation.
		res.add(all3 - v[1] * 2);
		res.add(all3 - v[2] * 2);
		res.add(all3 - v[0] * 2);

		return res;
	}

	/** 11. Number of possible Triangles in a Cartesian coordinate system **/
	/** 12. Triangular Numbers **/
	/** 13. Pascal�s Triangle **/
	public void printPascal(int n) {

		// Iterate through every line
		// and print entries in it
		for (int line = 0; line < n; line++) {
			// Every line has number of
			// integers equal to line number
			for (int j = 1; j < n - line; j++)
				System.out.print(" ");
			for (int i = 0; i <= line; i++)
				System.out.print(binomialCoeff(line, i) + " ");

			System.out.println();
		}
	}

	// Link for details of this function
	// https://www.geeksforgeeks.org/archives/25621
	public int binomialCoeff(int n, int k) {
		int res = 1;

		if (k > n - k)
			k = n - k;

		for (int i = 0; i < k; ++i) {
			res *= (n - i);
			res /= (i + 1);
		}
		return res;
	}
}
