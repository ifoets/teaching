package com.design.analysis.ds.matrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Gurug
 */
public class MatrixImpl implements IMatrix {

	/* 1. Search in a row wise and column wise sorted matrix m*n */
	public int[] searchSortedRowColumn(int a[][], int x) {

		int result[] = new int[2];
		int m = a.length;
		int i = 0;
		int j = a[0].length - 1;

		while (i < m && j >= 0) {
			if (a[i][j] == x) {
				result[0] = i;
				result[1] = j;
				return result;
			} else if (x < a[i][j])
				j--;
			else
				i++;
		}
		return null;
	}

	/* 2. Print a given matrix in spiral form */
	@Override
	public int[] printSpiralForm(int[][] a) {

		int temp[] = new int[a.length * a[0].length];
		int m = a.length;
		int n = a[0].length;
		int row, col;
		row = 0;
		col = 0;
		int tmp = 0;

		while (row < m && col < n) {

			for (int j = col; j < n; j++) {
				temp[tmp++] = a[row][j];
			}
			row++;

			/* elements of last column */
			for (int i = row; i < m; i++) {
				temp[tmp++] = a[i][n - 1];
			}
			n--;
			/* elements of bottom row */
			if (row < m) {

				for (int j = n - 1; j >= col; j--) {
					temp[tmp++] = a[m - 1][j];
				}
			}
			m--;

			/* Move elements of first column. */
			if (col < n) {
				for (int i = m - 1; i >= row; --i) {
					temp[tmp++] = a[i][col];
				}
			}
			col++;
		}
		return temp;
	}

	/* 3. A Boolean Matrix Question */
	public void setRowColmOne(int a[][], int row, int col) {

		for (int i = 0; i < a[0].length; i++) {
			a[i][row] = 1;
			a[row][i] = 1;
		}
		for (int j = 0; j < a.length; j++) {
			a[col][j] = 1;
			a[j][col] = 1;
		}
	}

	@Override
	public void booleanMatrix(int mat[][]) {

		// variables to check if there are any 1
		// in first row and column
		boolean row_flag = false;
		boolean col_flag = false;

		// updating the first row and col if 1
		// is encountered
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (i == 0 && mat[i][j] == 1)
					row_flag = true;

				if (j == 0 && mat[i][j] == 1)
					col_flag = true;

				if (mat[i][j] == 1) {

					mat[0][j] = 1;
					mat[i][0] = 1;
				}

			}
		}

		// Modify the input matrix mat[] using the
		// first row and first column of Matrix mat
		for (int i = 1; i < mat.length; i++) {
			for (int j = 1; j < mat[0].length; j++) {

				if (mat[0][j] == 1 || mat[i][0] == 1) {
					mat[i][j] = 1;
				}
			}
		}

		// modify first row if there was any 1
		if (row_flag == true) {
			for (int i = 0; i < mat[0].length; i++) {
				mat[0][i] = 1;
			}
		}

		// modify first col if there was any 1
		if (col_flag == true) {
			for (int i = 0; i < mat.length; i++) {
				mat[i][0] = 1;
			}
		}
	}

	/* 4. Print unique rows in a given boolean matrix */
	@Override
	public int[][] uniqueRows(int a[][]) {

		String st[] = new String[a.length];
		Set<String> set = new HashSet<>();

		for (int i = 0; i < a.length; i++) {
			st[i] = "";
			for (int j = 0; j < a[0].length; j++) {
				st[i] += String.valueOf(a[i][j]);
			}
			set.add(st[i]);
		}
		a = new int[set.size()][a[0].length];
		List<String> list = new ArrayList<>(set);
		for (int i = 0; i < set.size(); i++) {
			for (int j = 0; j < a[0].length; j++) {
				a[i][j] = Integer.valueOf(list.get(i).charAt(j) - 48);
			}
		}
		return a;
	}

	/* 5. Maximum size square sub-matrix with all 1s */
	@Override
	public int[][] maxSizeSubMatrix(int a[][]) {

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

	/* 6. Inplace M x N size matrix transpose | Updated */
	@Override
	public int[][] transpose(int a[][]) {
		// space O(m*n)
		int trap[][] = new int[a[0].length][a.length];

		for (int j = 0; j < a[0].length; j++) {
			for (int i = 0; i < a.length; i++)
				trap[j][i] = a[i][j];
		}
		return trap;
	}
}
