package com.design.analysis.core.algo.backtracking;

import java.util.List;

/*
 * 
 * @author GuruG
 * 
Standard Problems :
	1.	Backtracking | Set 1 (The Knight�s tour problem)
	2.	Backtracking | Set 2 (Rat in a Maze)
	3.	Backtracking | Set 3 (N Queen Problem)
	4.	Backtracking | Set 4 (Subset Sum)
	5.	Backtracking | Set 5 (m Coloring Problem)
	6.	Backtracking | Set 6 (Hamiltonian Cycle)
	7.	Backtracking | Set 7 (Sudoku)
	8.	Backtracking | Set 8 (Solving Cryptarithmetic Puzzles)
	9.	Backtracking | Set 9 (Magnet Puzzle)
	10.	N Queen in O(n) space
	11.	Boggle | Set 2 (Using Trie)
	12.	Remove Invalid Parentheses
	13.	Prime numbers after prime P with sum S
	14.	Rat in a Maze with multiple steps or jump allowed
	15.	A backtracking approach to generate n bit Gray Codes
	16.	C++ program for Solving Cryptarithmetic Puzzles
	17.	Write a program to print all permutations of a given string
	18.	Print all possible paths from top left to bottom right of a mXn matrix

 */
public interface IBackTrackStrandard {

	/** 0.Backtracking Array **/
	public void nonZero(int a[]);

	/** 0.1 Backtracking max len non zero **/
	public void maxLenNonZero(int a[]);
	
	/** 0.2 Backtracking max sum sub continuous in array **/
	public void maxSumSubContineous(int a[]);

	/** 1. Backtracking | Set 1 (The Knight�s tour problem) **/
	public void knightTour();

	/** 2. Backtracking | Set 2 (Rat in a Maze) **/
	public boolean ratMazeproblem(int maze[][]);

	/** 3. Backtracking | Set 3 (N Queen Problem) **/
	public boolean nQueenProblem(int board[][]);

	/** 4. Backtracking | Set 4 (Subset Sum) **/
	public List<List<Integer>> generateSubsets(int a[], int targetSum);

	/** 5. Backtracking | Set 5 (m Coloring Problem) **/
	public int[] graphColor(int g[][], int m);

	/** 6. Backtracking | Set 6 (Hamiltonian Cycle) **/
	public int[] hamCycleGraph(int graph[][]);

	/** 7. Backtracking | Set 7 (Sudoku) **/

	public boolean solveSudoku(int mat[][], int N);
	/** 8. Backtracking | Set 8 (Solving Cryptarithmetic Puzzles) **/
	/** 9. Backtracking | Set 9 (Magnet Puzzle) **/
	/* 10. N Queen in O(n) space */
	/* 11. Boggle | Set 2 (Using Trie) */
	/* 12. Remove Invalid Parentheses */
	/* 13. Prime numbers after prime P with sum S */
	/* 14. Rat in a Maze with multiple steps or jump allowed */
	/* 15. A backtracking approach to generate n bit Gray Codes */
	/* 16. C++ program for Solving Cryptarithmetic Puzzles */
	/* 17. Write a program to print all permutations of a given string */

	/** 17. Write a program to print all permutations of a given string **/
	public List<String> permutationOfString(char[] chars, int l, int r);
}
