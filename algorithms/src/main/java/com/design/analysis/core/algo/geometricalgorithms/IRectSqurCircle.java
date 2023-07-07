package com.design.analysis.core.algo.geometricalgorithms;

import java.util.List;

import com.design.analysis.core.algo.geometricalgorithms.model.DPoint;
import com.design.analysis.core.algo.geometricalgorithms.model.PointSegment;
import com.design.analysis.core.algo.node.Point;

/*
 * 
 * @author GuruG
 * 
 * Rectangle | Square | Circle :
1.	Find if two rectangles overlap
2.	Check if four segments form a rectangle
3.	Check whether a given point lies inside a rectangle or not
4.	Minimum Perimeter of n blocks
5.	Number of rectangles in N*M grid
6.	Find Corners of Rectangle using mid points
7.	Coordinates of rectangle with given points lie inside
8.	Total area of two overlapping rectangles
9.	Program for Area And Perimeter Of Rectangle
10.	Program to find Perimeter / Circumference of Square and Rectangle
11.	Program for Area Of Square
12.	Number of unique rectangles formed using N unit squares
13.	How to check if given four points form a square
14.	Paper Cut into Minimum Number of Squares
15.	Program to find area of a circle
16.	Non-crossing lines to connect points in a circle
17.	Circle and Lattice Points
18.	Queries on count of points lie inside a circle
19.	Check whether a point exists in circle sector or not
20.	Pizza cut problem (Or Circle Division by Lines)
21.	Minimum revolutions to move center of a circle to a target
22.	Angular Sweep (Maximum points that can be enclosed in a circle of given radius)
23.	Check if a line touches or intersects a circle
24.	Check if a given circle lies completely inside the ring formed by two concentric circles
25.	Area of a Circumscribed Circle of a Square
26.	Path in a Rectangle with Circles
27.	Area of square Circumscribed by Circle
28.	Count ways to divide circle using N non-intersecting chords
29.	Find the center of the circle using endpoints of diameter
30.	Program to find area of a Circular Segment
31.	Program to find smallest difference of angles of two parts of a given circle
32.	Arc length from given Angle
33.	Area of a Circular Sector
34.	Find minimum radius such that atleast k point lie inside the circle
35.	Program to find Circumference of a Circle
36.	Check whether given circle resides in boundary maintained by two other circles
37.	Check if two given circles touch or intersect each other
38.	Count of obtuse angles in a circle with �k� equidistant points between 2 given points

 */
public interface IRectSqurCircle {

	/** 1. Find if two rectangles overlap **/
	public boolean isOverlapTwoRect(Point l1, Point r1, Point l2, Point r2);

	/** 2. Check if four segments form a rectangle **/
	public boolean isFormRect(List<PointSegment> ls);

	/** 3. Check whether a given point lies inside a rectangle or not **/
	public boolean isPointInsideRectangle(Point p1, Point p2, Point p3, Point p4, Point p);

	/** 4. Minimum Perimeter of n blocks **/
	public long minPerimeter(int n);

	/** 5. Number of rectangles in N*M grid **/
	public int noOfRectInMNGrid(int m, int n);

	/** 6. Find Corners of Rectangle using mid points **/
	public List<DPoint> cornerOfRect(DPoint p, DPoint q, double l);

	/** 7. Coordinates of rectangle with given points lie inside **/
	public List<Point> minRectCordinate(Integer x[], Integer y[]);

	/** 8. Total area of two overlapping rectangles **/
	public int totalAreaOverlapRectls(Point l1, Point r1, Point l2, Point r2);

	/** 9. Program for Area And Perimeter Of Rectangle **/
	public int[] areaAndPerimeterOfRect(int a, int b);

	/** 10. Program to find Perimeter / Circumference of Square and Rectangle **/
	public int perimeter(int a, int b);

	/** 11. Program for Area Of Square **/
	public int areaSqure(int a);

	/** 12. Number of unique rectangles formed using N unit squares **/
	public int uniqueRectByNUnitsSqure(int n);

	/** 13. How to check if given four points form a square **/
	public boolean isSquare(Point p1, Point p2, Point p3, Point p4);

	/** 14. Paper Cut into Minimum Number of Squares **/
	public int cutPaperMinNoOfSqaure(int a, int b);

	/** 15. Program to find area of a circle **/
	public double areaOfCircle(int r);

	/** 16. Non-crossing lines to connect points in a circle **/
	public int noOfWaysConnectAllLinsNonCross(int n);

	/** 17. Circle and Lattice Points **/
	public int countLatticeOnCircumOfCircle(int r);

	/** 18. Queries on count of points lie inside a circle **/
	public void preprocess(int p[], int x[], int y[], int n);

	public int countPointsInsideCircle(int p[], int r);

	public int query(int p[], int n, int rad);

	/** 19. Check whether a point exists in circle sector or not **/
	public boolean isPointInsideCircleSector(Point p, int r, float percent, float startAngle);

	/** 20. Pizza cut problem (Or Circle Division by Lines) **/
	public int noOfMaxPeacesOfCircle(int cut);
}
