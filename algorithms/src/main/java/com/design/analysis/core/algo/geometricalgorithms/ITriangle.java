package com.design.analysis.core.algo.geometricalgorithms;

import java.util.List;

import com.design.analysis.core.algo.node.Point;

/*
 * 
 * @author GuruG
 * 
 * Triangle :
1.	Check whether a given point lies inside a triangle or not
2.	C program to find area of a triangle
3.	Count Integral points inside a Triangle
4.	Classify a triangle
5.	Maximum height when coins are arranged in a triangle
6.	Find all sides of a right angled triangle from given hypotenuse and area | Set 1
7.	Maximum number of 2�2 squares that can be fit inside a right isosceles triangle
8.	Check if right triangle possible from given area and hypotenuse
9.	Triangle with no point inside
10.	Find all angles of a given triangle
11.	Program to find Circumcenter of a Triangle
12.	Number of Triangles that can be formed given a set of lines in Euclidean Plane
13.	Triangular Matchstick Number
14.	Number of jump required of given length to reach a point of form (d, 0) from origin in 2D plane
15.	Program to calculate area of Circumcircle of an Equilateral Triangle
16.	Check whether triangle is valid or not if sides are given
17.	Program to find third side of triangle using law of cosines
18.	Find the dimensions of Right angled triangle
19.	Program to calculate area and perimeter of equilateral triangle
20.	Count of acute, obtuse and right triangles with given sides
21.	Minimum height of a triangle with given base and area
22.	Maximum number of squares that can fit in a right angle isosceles triangle

 */
public interface ITriangle {

	/** 1. Check whether a given point lies inside a triangle or not **/
	public boolean pointInOutTringle(Point p1, Point p2, Point p3, Point p);

	/** 2. C program to find area of a triangle **/
	public int areaOfTringle(int a, int b, int c);

	/** 3. Count Integral points inside a Triangle **/
	public int getBoundaryCount(Point p, Point q);

	// Returns count of points inside the triangle
	public int getInternalCount(Point p, Point q, Point r);

	/** 4. Classify a triangle **/
	public int euclidDistSquare(Point p1, Point p2);

	// Method to classify side
	public String getSideClassification(int a, int b, int c);

	// Method to classify angle
	public String getAngleClassification(int a, int b, int c);

	// Method to classify triangle by sides and angles
	public void classifyTriangle(Point p1, Point p2, Point p3);

	/** 5. Maximum height when coins are arranged in a triangle **/
	public float squareRoot(float n);

	// Method to find maximum height of arrangement of coins
	public int findMaximumHeight(int N);

	/**
	 * 6. Find all sides of a right angled triangle from given hypotenuse and area |
	 * Set 1
	 **/
	public Point findSidesRightAnglTri(int hypotenuse, int area);

	/**
	 * 7. Maximum number of n�n squares that can be fit inside a right isosceles
	 * triangle
	 **/
	public int noOfSqurareInRitIsoTrin(int b, int n);

	/** 8. Check if right triangle possible from given area and hypotenuse **/
	public boolean findRightAngle(double A, double H);

	/** 9. Triangle with no point inside **/
	public List<Point> tringleNoPointInside(Point p[]);

	/** 10. Find all angles of a given triangle **/
	public List<Float> findAnglesOfTingle(Point A, Point B, Point C);
}
