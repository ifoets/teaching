package com.design.analysis.core.ds.matrix;
/*
 * @author GuruG
 */

/*
 * Matrix:
1.	Search in a row wise and column wise sorted matrix
2.	Print a given matrix in spiral form
3.	A Boolean Matrix Question
4.	Print unique rows in a given boolean matrix
5.	Maximum size square sub-matrix with all 1s
6.	Inplace M x N size matrix transpose | Updated
7.	Print Matrix Diagonally
8.	Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix)
9.	Strassen�s Matrix Multiplication
10.	Create a matrix with alternating rectangles of O and X
11.	Find the row with maximum number of 1s
12.	Print all elements in sorted order from row and column wise sorted matrix
13.	Given an n x n square matrix, find sum of all sub-squares of size k x k
14.	Count number of islands where every island is row-wise and column-wise separated
15.	Given a matrix of �O� and �X�, replace �O� with �X� if surrounded by �X�
16.	Find the longest path in a matrix with given constraints
17.	Given a Boolean Matrix, find k such that all elements in k�th row are 0 and k�th column are 1.
18.	Find the largest rectangle of 1�s with swapping of columns allowed
19.	Validity of a given Tic-Tac-Toe board configuration
20.	Minimum Initial Points to Reach Destination
21.	Find length of the longest consecutive path from a given starting character
22.	Collect maximum points in a grid using two traversals
23.	Rotate Matrix Elements
24.	Find sum of all elements in a matrix except the elements in row and/or column of given cell?
25.	Find a common element in all rows of a given row-wise sorted matrix
26.	Number of paths with exactly k coins
27.	Collect maximum coins before hitting a dead end
28.	Program for Rank of Matrix
29.	Submatrix Sum Queries
30.	Maximum size rectangle binary sub-matrix with all 1s
31.	Count Negative Numbers in a Column-Wise and Row-Wise Sorted Matrix
32.	Construct Ancestor Matrix from a Given Binary Tree
33.	Construct tree from ancestor matrix
34.	In-place convert matrix in specific order
35.	Common elements in all rows of a given matrix
36.	Print maximum sum square sub-matrix of given size
37.	Find a specific pair in Matrix
38.	Find orientation of a pattern in a matrix
39.	Shortest path in a Binary Maze
40.	Inplace rotate square matrix by 90 degrees
41.	Return previous element in an expanding matrix
*/

public interface IMatrix {
	/* 1. Search in a row wise and column wise sorted matrix */
	public int[] searchSortedRowColumn(int a[][], int x);

	/* 2. Print a given matrix in spiral form */
	public int[] printSpiralForm(int a[][]);

	/* 3. A Boolean Matrix Question */
	public void setRowColmOne(int a[][], int row, int col);

	public void booleanMatrix(int a[][]);

	/* 4. Print unique rows in a given boolean matrix */
	public int[][] uniqueRows(int a[][]);

	/* 5. Maximum size square sub-matrix with all 1s */
	public int[][] maxSizeSubMatrix(int a[][]);

	/* 6. Inplace M x N size matrix transpose | Updated */
	public int[][] transpose(int a[][]);
	
	/* 7. Print Matrix Diagonally */
	/* 8. Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix) */
	/* 9. Strassen�s Matrix Multiplication */
	/* 10. Create a matrix with alternating rectangles of O and X */
	
}
