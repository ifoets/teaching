package com.design.analysis.company.hakarrank.goldmansachs;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		pascalTringleX(6);
	}

	public static void pascalTringle(int n) {
		int a[][] = new int[n][n];
		for (int i = 1; i < n; i++) {
			for (int k = i; k < n; k++)
				System.out.print(" ");
			for (int j = 0; j < i; j++) {
				if (j == 0 || i == j)
					a[i][j] = 1;
				else
					a[i][j] = a[i - 1][j] + a[i - 1][j - 1];
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void pascalTringleX(int n) {

		for (int i = 1; i < n; i++) {

			int C = 1;// used to represent C(line, i)
			for (int j = 1; j <= i; j++) {
				// The first value in a line is always 1
				System.out.print(C + " ");
				C = C * (i - j) / j;
			}
			System.out.println();
		}
	}

	static long buyMaximumProducts(int n, long k, int[] a) {
		long count = 0;
		for (int i = 0; i < n; i++) {

			if (k >= (i + 1) * a[i]) {
				k -= (i + 1) * a[i];
				count += (i + 1);
			} else {
				for (int j = 0; j <= i; j++) {
					if (k >= a[i]) {
						k -= a[i];
						count++;
					} else
						return count;
				}
			}
		}
		return count;
	}

	public static void main1(String[] args) {
		System.out.println("Enter input");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = in.nextInt();
		}
		long k = in.nextLong();
		long result = buyMaximumProducts(n, k, arr);
		System.out.println(result);
		in.close();
	}
}