package com.design.analysis.core.algo.matheticalalgorithms;

import java.util.List;

/*
 * 
 * @author GuruG
 * Triangles :
1.	Time required to meet in equilateral triangle
2.	Trinomial Triangle
3.	Leibniz harmonic triangle
4.	Hosoya�s Triangle
5.	Number of triangles after N moves
6.	Find Perimeter of a triangle
7.	Check whether right angled triangle is valid or not for large sides
8.	Maximum height of triangular arrangement of array values
9.	Find other two sides of a right angle triangle
10.	Find coordinates of the triangle given midpoint of each side
11.	Number of possible Triangles in a Cartesian coordinate system
12.	Triangular Numbers
13.	Pascal�s Triangle

 */
public interface ITriangles {

	/** 1.Time required to meet in equilateral triangle **/
	public float timeToMeet(double s, double v);

	/** 2.Trinomial Triangle **/
	/* Function to print Trinomial Triangle of height n. */
	public void printTrinomial(int n);

	/* Function to find the trinomial triangle value. */
	public int trinomialValue(int dp[][], int n, int k);

	/** 3.Leibniz harmonic triangle **/
	public void leibnizHarmonicTriangle(int n);

	/** 4.Hosoya�s Triangle **/
	/* Print the Hosoya triangle of height n. */
	public void printHosoya(int n);

	/** 5. Number of triangles after N moves **/
	public int numberOfTriangles(int n);

	/** 6. Find Perimeter of a triangle **/
	public int perimeterOfTringle(int a, int b, int c);

	/** 7. Check whether right angled triangle is valid or not for large sides **/
	public boolean triplets(long a, long b, long c);

	/** 8. Maximum height of triangular arrangement of array values **/
	public void printOtherSides(int n);

	/** 9. Find other two sides of a right angle triangle **/
	/* Finds vertices of a triangles from given middle vertices. */
	public void findVertex(int xmid[], int ymid[]);

	public List<Integer> solve(int v[]);

	/** 10. Find coordinates of the triangle given midpoint of each side **/
	/** 11. Number of possible Triangles in a Cartesian coordinate system **/
	/** 12. Triangular Numbers **/
	/** 13. Pascal�s Triangle **/
	public void printPascal(int n);

	// Link for details of this function
	// https://www.geeksforgeeks.org/archives/25621
	public int binomialCoeff(int n, int k);
}
