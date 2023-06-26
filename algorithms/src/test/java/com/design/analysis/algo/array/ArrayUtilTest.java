package com.design.analysis.algo.array;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilTest {

	public static void main(String[] args) {
		System.out.printf("%.3fGiB", Runtime.getRuntime().totalMemory() / (1024.0 * 1024.0 * 1024.0));
		//
	}
	@Test
	public void swapIn2ArrTest() {
		int[] a = { 1, 3 };
		int b[] = { 2, 4 };

		ArrayUtil.swapIn2Arr(a, 1, b, 0);
		Assert.assertTrue(a[1] == 2);
		Assert.assertTrue(b[0] == 3);
	}

	@Test
	public void swap2DArrTest() {

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int N = a.length;

		int k = 2;
		// rorate elements k times
		for (int x = 0; x < k; x++) {
			// cloclwise rotation of every element
			for (int i = 0; i < N / 2; i++) {
				for (int j = i; j < N - 1 - i; j++)
					ArrayUtil.swap2DArr(a, j, i, j + 1, i);
				for (int j = i; j < N - 1 - i; j++)
					ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - i, j + 1);

				for (int j = N - 1 - i; j > i; j--)
					ArrayUtil.swap2DArr(a, j, N - 1 - i, j - 1, N - 1 - i);
				for (int j = N - 1 - i; j > i + 1; j--)
					ArrayUtil.swap2DArr(a, i, j, i, j - 1);
			}
		}
		// rorate elements k times
		for (int x = 0; x < k; x++) {
			// anticloclwise rotation of every element
			for (int i = 0; i < N / 2; i++) {
				for (int j = i; j < N - 1 - i; j++)
					ArrayUtil.swap2DArr(a, i, j, i, j + 1);
				for (int j = i; j < N - 1 - i; j++)
					ArrayUtil.swap2DArr(a, j, N - 1 - i, j + 1, N - 1 - i);

				for (int j = N - 1 - i; j > i; j--)
					ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - i, j - 1);
				for (int j = N - 1 - i; j > i + 1; j--)
					ArrayUtil.swap2DArr(a, j, i, j - 1, i);
			}
		}

		// trun 90 degree clock wise
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - 1 - i; j++) {
				ArrayUtil.swap2DArr(a, j, i, N - 1 - i, j);
				ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - j, N - 1 - i);
				ArrayUtil.swap2DArr(a, N - 1 - j, N - 1 - i, i, N - 1 - j);
			}
		}
		// trun 90 degree anticlock wise
		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - 1 - i; j++) {
				ArrayUtil.swap2DArr(a, i, N - 1 - j, N - 1 - j, N - 1 - i);
				ArrayUtil.swap2DArr(a, N - 1 - j, N - 1 - i, N - 1 - i, j);
				ArrayUtil.swap2DArr(a, N - 1 - i, j, j, i);
			}
		}
		/// spirial print matrx clockwise
		for (int j = 0; j < N - 1 - 0; System.out.print(a[0][j] + " "), j++)
			;
		for (int j = 0; j < N - 1 - 0; System.out.print(a[j][N - 1 - 0] + " "), j++)
			;
		for (int j = 0; j < N - 1 - 0; System.out.print(a[N - 1 - 0][N - 1 - j] + " "), j++)
			;
		for (int j = 0; j < N - 1 - 0; System.out.print(a[N - 1 - j][0] + " "), j++)
			;
		System.out.println();
		for (int j = 1; j < N - 1 - 1; System.out.print(a[1][j] + " "), j++)
			;
		for (int j = 1; j < N - 1 - 1; System.out.print(a[j][N - 1 - 1] + " "), j++)
			;
		for (int j = 1; j < N - 1 - 1; System.out.print(a[N - 1 - 1][N - 1 - j] + " "), j++)
			;
		for (int j = 1; j < N - 1 - 1; System.out.print(a[N - 1 - j][1] + " "), j++)
			;
		System.out.println();

		/// spirial print matrx anticlockwise

		for (int i = 0; i < N / 2; i++) {
			for (int j = i; j < N - 1 - i; System.out.print(a[j][i] + " "), j++)
				;
			for (int j = i; j < N - 1 - i; System.out.print(a[N - 1 - i][j] + " "), j++)
				;
			for (int j = i; j < N - 1 - i; System.out.print(a[N - 1 - j][N - 1 - i] + " "), j++)
				;
			for (int j = i; j < N - 1 - i; System.out.print(a[i][N - 1 - j] + " "), j++)
				;
			System.out.println();
		}

		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
