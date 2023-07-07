package com.design.analysis.core.ds.matrix;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author GuruG
 */
public class IMatrixTest {

	public IMatrix imt = null;

	@Before
	public void init() {
		imt = new MatrixImpl();
	}

	/* 1. Search in a row wise and column wise sorted matrix m*n */
	@Test
	public void searchSortedRowColumnTest() {
		int a[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };

		int r1[] = imt.searchSortedRowColumn(a, 29);
		Assert.assertTrue(r1[0] == 2 && r1[1] == 1);

		r1 = imt.searchSortedRowColumn(a, 35);
		Assert.assertTrue(r1[0] == 1 && r1[1] == 2);

		r1 = imt.searchSortedRowColumn(a, 50);
		Assert.assertTrue(r1[0] == 3 && r1[1] == 3);

		r1 = imt.searchSortedRowColumn(a, 15);
		Assert.assertTrue(r1[0] == 1 && r1[1] == 0);

		r1 = imt.searchSortedRowColumn(a, 12);
		Assert.assertTrue(r1 == null);

		r1 = imt.searchSortedRowColumn(a, 51);
		Assert.assertTrue(r1 == null);

	}

	/* 2. Print a given matrix in spiral form */
	@Test
	public void printSpiralFormTest() {
		int aa[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int a[] = imt.printSpiralForm(aa);
		// System.out.println(Arrays.toString(a));
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[5] == 12);
		Assert.assertTrue(a[10] == 9);
		Assert.assertTrue(a[14] == 11);

		int bb[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		int b[] = imt.printSpiralForm(bb);
		// System.out.println(Arrays.toString(b));
		Assert.assertTrue(b[0] == 1);
		Assert.assertTrue(b[5] == 6);
		Assert.assertTrue(b[10] == 15);
		Assert.assertTrue(b[14] == 8);
	}

	/* 3. A Boolean Matrix Question */
	@Test
	public void setRowColmOneTest() {

		int a[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		imt.setRowColmOne(a, 0, 3);
		for (int i = 0; i < a.length; i++) {
			// System.out.println(Arrays.toString(a[i]));
			Assert.assertTrue(a[0][i] == 1);
			Assert.assertTrue(a[i][a.length - 1] == 1);
		}
	}

	@Test
	public void booleanMatrixTest() {

		int a[][] = { { 0, 0, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 1 } };
		imt.booleanMatrix(a);
		for (int i = 0; i < a.length; i++) {
			// System.out.println(Arrays.toString(a[i]));
			Assert.assertTrue(a[i][2] == 1);
			Assert.assertTrue(a[i][a.length - 1] == 1);
		}
	}

	/* 4. Print unique rows in a given boolean matrix */
	@Test
	public void uniqueRowsTest() {

		int a[][] = { { 0, 1, 0, 0, 1 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 1 }, { 1, 1, 1, 0, 0 }, { 0, 1, 0, 0, 1 } };
		a = imt.uniqueRows(a);
		/*
		 * for (int i = 0; i < a.length; i++) {
		 * System.out.println(Arrays.toString(a[i])); }
		 */
		Assert.assertTrue(a.length == 3);
	}

	/* 5. Maximum size square sub-matrix with all 1s */
	@Test
	public void maxSizeSubMatrixTest() {

		int a[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		a = imt.maxSizeSubMatrix(a);
		Assert.assertTrue(a.length == 3);
		Assert.assertTrue(a[0].length == 3);
		Assert.assertTrue(a[2][2] == 1);
		Assert.assertTrue(a[0][0] == 1);
		Assert.assertTrue(a[1][1] == 1);
	}

	@Test
	public void transposeTest() {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		a = imt.transpose(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		
	}
}
