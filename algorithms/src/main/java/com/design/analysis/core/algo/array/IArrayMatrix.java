package com.design.analysis.core.algo.array;

/*
	 Matrix Archives
	Recent Articles on Matrix
	1.	Rotate Matrix Elements
	2.	Inplace rotate square matrix by 90 degrees | Set 1
	3.	Rotate a matrix by 90 degree without using any extra space | Set 2
	4.	Rotate a Matrix by 180 degree
	5.	Rotate each ring of matrix anticlockwise by K elements
	6.	Turn an image by 90 degree
	7.	Check if all rows of a matrix are circular rotations of each other
	8.	Sort the given matrix
	9.	Find the row with maximum number of 1s
	10.	Find median in row wise sorted matrix
	11.	Matrix Multiplication | Recursive
	12.	Program to multiply two matrices
	13.	Program for scalar multiplication of a matrix
	14.	Program to print Lower triangular and Upper triangular matrix of an array
	15.	Find distinct elements common to all rows of a matrix
	16.	Print a given matrix in spiral form
	17.	Find maximum element of each row in a matrix
	18.	Find unique elements in a matrix
	19.	Shift matrix elements row-wise by k
	20.	Different Operations on Matrices
	21.	Print a given matrix in counter-clock wise spiral form
	22.	Swap major and minor diagonals of a square matrix
	23.	Maximum path sum in matrix
	24.	Squares of Matrix Diagonal Elements
	25.	Move matrix elements in given direction and add elements with same value
	26.	Sorting rows of matrix in ascending order followed by columns in descending order
	27.	Sum of middle row and column in Matrix
	28.	Row-wise vs column-wise traversal of matrix
	29.	Rotate the matrix right by K times
	30.	Program to check idempotent matrix
	31.	Program to check Involutory Matrix
	32.	Interchange elements of first and last rows in matrix
	33.	Print matrix in zag-zag fashion
	34.	Row wise sorting in 2D array
	35.	Program for Markov matrix
	36.	Program to check diagonal matrix and scalar matrix
	37.	Sort the matrix row-wise and column-wise
	38.	Find the number of islands
	39.	Magic Square | Even Order
	40.	Magic Square
	41.	Check given matrix is magic square or not
	42.	Check given matrix is magic square or not
	43.	Kronecker Product of two matrices
	44.	Count sub-matrices having sum divisible ‘k’
	45.	Diagonally Dominant Matrix
	46.	Minimum operations required to make each row and column of matrix equals
	47.	Count frequency of k in a matrix of size n where matrix(i, j) = i+j
	48.	Given 1’s, 2’s, 3’s ……k’s print them in zig zag way.
	49.	Number of cells a queen can move with obstacles on the chessborad
	50.	Maximum product of 4 adjacent elements in matrix
	51.	Minimum flip required to make Binary Matrix symmetric
	52.	Program to check if matrix is lower triangular
	53.	Program to check if matrix is upper triangular
	54.	Frequencies of even and odd numbers in a matrix 
	
	55.	Center element of matrix equals sums of half diagonals
	56.	Program for Identity Matrix
	57.	Program to swap upper diagonal elements with lower diagonal elements of matrix.
	58.	Sparse Matrix Representations
	59.	Ways of filling matrix such that product of all rows and all columns are equal to unity
	60.	Mirror of matrix across diagonal
	61.	Find if there is a rectangle in binary matrix with corners as 1
	62.	Find all rectangles filled with 0
	63.	Shortest distance between two cells in a matrix or grid
	64.	Counting sets of 1s and 0s in a binary matrix
	65.	Search in a row wise and column wise sorted matrix
	66.	Create a matrix with alternating rectangles of O and X
	67.	Zigzag (or diagonal) traversal of Matrix
	68.	Inplace (Fixed space) M x N size matrix transpose | Updated
	69.	Minimum cost to sort a matrix of numbers from 0 to n^2 – 1
	70.	Unique cells in a binary matrix
	71.	Count entries equal to x in a special matrix
	72.	Check if a given matrix is sparse or not
	73.	Row-wise common elements in two diagonals of a square matrix
	74.	Check if sums of i-th row and i-th column are same in matrix
	75.	Find row number of a binary matrix having maximum number of 1s
	76.	Program to check if a matrix is symmetric
	77.	Find if a 2-D array is completely traversed or not by following the cell values
	78.	Program to Print Matrix in Z form
	79.	Print all palindromic paths from top left to bottom right in a matrix
	80.	Possible moves of knight
	81.	Efficiently compute sums of diagonals of a matrix
	82.	Boundary elements of a Matrix
	83.	Print a matrix in a spiral form starting from a point
	84.	Print matrix in snake pattern
	85.	Program to Interchange Diagonals of Matrix
	86.	Find difference between sums of two diagonals
	87.	Construct Ancestor Matrix from a Given Binary Tree
	88.	Construct tree from ancestor matrix
	89.	Circular Matrix (Construct a matrix with numbers 1 to m*n in spiral way)
	90.	Program for Sudoku Generator
	91.	Program for Conway’s Game Of Life
	92.	Maximum sum of hour glass in matrix
	93.	Maximum and Minimum in a square matrix.
	94.	Print matrix in antispiral form
	95.	Program to find Normal and Trace of a matrix
	96.	Sort a Matrix in all way increasing order
	97.	Minimum operations required to set all elements of binary matrix
	98.	Print a given matrix in reverse spiral form
	99.	C Program To Check whether Matrix is Skew Symmetric or not
	100.	Sum of matrix element where each elements is integer division of row and column
	101.	Sparse Matrix and its representations
	102.	Find number of transformation to make two Matrix Equal
	103.	Form coils in a matrix
	104.	Sum of matrix in which each element is absolute difference of its row and column numbers
	105.	Check horizontal and vertical symmetry in binary matrix
	106.	Maximum determinant of a matrix with every values either 0 or n
	107.	Sum of both diagonals of a spiral odd-order square matrix
	108.	Find pair of rows in a binary matrix that has maximum bit difference
	109.	Find all permuted rows of a given row in a matrix
	110.	Find perimeter of shapes formed with 1s in binary matrix
	111.	Print cells with same rectangular sums in a matrix
	112.	Print matrix in diagonal pattern
	113.	Maximum difference of sum of elements in two rows in a matrix
	114.	Find pairs with given sum such that elements of pair are in different rows
	115.	Total coverage of all zeros in a binary matrix
	116.	Replace every matrix element with maximum of GCD of row or column
	117.	Count all sorted rows in a matrix
	118.	Queries in a Matrix
	119.	Maximum XOR value in matrix
	120.	Maximum mirrors which can transfer light from bottom to right
	121.	Direction at last square block
	122.	Print K’th element in spiral form of matrix
	123.	Find if given matrix is Toeplitz or not
	124.	Count zeros in a row wise and column wise sorted matrix
	125.	Count Negative Numbers in a Column-Wise and Row-Wise Sorted Matrix
	126.	Find size of the largest ‘+’ formed by all ones in a binary matrix
	127.	Return previous element in an expanding matrix
	128.	Print n x n spiral matrix using O(1) extra space
	129.	Shortest path in a Binary Maze
	130.	Find orientation of a pattern in a matrix
	131.	Find a specific pair in Matrix
	132.	Print maximum sum square sub-matrix of given size
	133.	Common elements in all rows of a given matrix
	134.	In-place convert matrix in specific order
	135.	A Boolean Matrix Question
	136.	Given a Boolean Matrix, find k such that all elements in k’th row are 0 and k’th column are 1.
	137.	Print unique rows in a given boolean matrix
	138.	Find the largest rectangle of 1’s with swapping of columns allowed
	139.	Validity of a given Tic-Tac-Toe board configuration
	140.	Submatrix Sum Queries
	141.	Program for Rank of Matrix
	142.	Maximum size rectangle binary sub-matrix with all 1s
	143.	Maximum size square sub-matrix with all 1s
	144.	Find sum of all elements in a matrix except the elements in row and/or column of given cell?
	145.	Count number of islands where every island is row-wise and column-wise separated
	146.	Find a common element in all rows of a given row-wise sorted matrix
	147.	Given a matrix of ‘O’ and ‘X’, replace ‘O’ with ‘X’ if surrounded by ‘X’
	148.	Given a matrix of ‘O’ and ‘X’, find the largest subsquare surrounded by ‘X’
	149.	Flood fill Algorithm – how to implement fill() in paint?
	150.	Print all elements in sorted order from row and column wise sorted matrix
	151.	Given an n x n square matrix, find sum of all sub-squares of size k x k
	152.	Program to find transpose of a matrix
	153.	C program for addition of two matrices
	154.	C program for subtraction of matrices
	155.	Collect maximum points in a grid using two traversals
	156.	Collect maximum coins before hitting a dead end
	157.	Number of paths with exactly k coins
	158.	Find length of the longest consecutive path from a given starting character
	159.	Find the longest path in a matrix with given constraints
	160.	Minimum Initial Points to Reach Destination
	161.	Divide and Conquer | Set 5 (Strassen’s Matrix Multiplication)
	162.	Dynamic Programming | Set 27 (Maximum sum rectangle in a 2D matrix)

 */
public interface IArrayMatrix {

	/** 1. Turn an image by 90 degree **/
	public int[][] rotateImageBy90DegreeClock(int a[][]);

	public int[][] rotateImageBy90DegreeClockX(int a[][]);

	/** 2. Rotate Matrix Elements **/
	public void rotateEleemntColck(int a[][]);

	public void rotateEleemntColckX(int a[][]);

	public void rotateEleemntAntiColck(int a[][]);

	/** 3. rotate square matrix by 90 degrees n*n matrix without extra space **/
	public void rotateImageBy90DegreeAntiClock(int a[][]);

	/**
	 * 4. Rotate a matrix by 90 degree without using any extra space
	 **/
	public void rotateMatixBy90AntiColck(int a[][]);

	/** 4. Rotate a Matrix by 180 degree **/
	public void rorateMatrix180(int a[][]);

	/** 5. Rotate each ring of matrix anti clockwise by K elements **/
	public void rotateRingKelemAntiClock(int a[][], int k);

	/** 6. Turn an image by 90 degree **/
	public void turnImageBy90Degree(int a[][]);

	public void turnImageBy90DegreeAntyClockWise(int a[][]);

	/** 7. Check if all rows of a matrix are circular rotations of each other **/
	public boolean isAllColumnsCiucularRotated(int a[][]);

	/** 8. Sort the given matrix **/
	public void strictSotMatrix(int a[][]);

	/** 9. Find the row with maximum number of 1s where each row is sorted**/
	public int rowMaxNumbOf1s(int a[][]);

	/** 10. Find median in row wise sorted matrix **/
	public int binaryMedian(int a[][], int r, int c);
	
	/** 11. Matrix Multiplication | Recursive **/
	public int[][] multiplyMatrixRec(int a[][], int r1, int c1, int b[][], int r2,int c2);
	/** 12. Program to multiply two matrices **/
	/** 13. Program for scalar multiplication of a matrix **/
	/**
	 * 14. Program to print Lower triangular and Upper triangular matrix of an array
	 **/
	/** 15. Find distinct elements common to all rows of a matrix **/
	/** 16. Print a given matrix in spiral form clockwise **/
	/** 17. Find maximum element of each row in a matrix **/
	/** 18. Find unique elements in a matrix **/
	/** 19. Shift matrix elements row-wise by k **/
	/** 20. Different Operations on Matrices **/
	public void spiralPrintMatrix(int a[][]);

	public void spiralPrintMatrixAnticlockwise(int a[][]);
	// ***********************************************************************************************************************************************************//

	/** transpose the matrix **/
	public void transposeOfMatrix(int a[][]);

	/** Reverse column **/
	public void reverseColumns(int arr[][]);

	/** Spiral traverse */
	public int[] spiralTraverse(int a[][]);

	/** spiral fill **/
	public void spiralFill(int a[][], int tamp[]);

	/** Function to reverse arr[] from index start to end **/
	public void rvereseArray(int arr[], int start, int end);
}
