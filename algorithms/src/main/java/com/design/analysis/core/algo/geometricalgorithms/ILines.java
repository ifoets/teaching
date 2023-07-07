package com.design.analysis.core.algo.geometricalgorithms;

import java.util.List;

import com.design.analysis.core.algo.geometricalgorithms.model.Line;
import com.design.analysis.core.algo.geometricalgorithms.model.Segment;
import com.design.analysis.core.algo.node.Point;

/*
 * 
 * @author GuruG
 * 
 * Lines :
1.	How to check if two given line segments intersect?
2.	Given n line segments, find if any two segments intersect
3.	Klee�s Algorithm (Length Of Union Of Segments of a line)
4.	Count maximum points on same line
5.	Find an Integer point on a line segment with given two ends
6.	Minimum lines to cover all points
7.	Minimum block jumps to reach destination
8.	Program for Point of Intersection of Two Lines
9.	Represent a given set of points by the best possible straight line
10.	Program to find line passing through 2 Points
11.	Reflection of a point about a line in C++
12.	Find points at a given distance on a line of given slope
13.	Number of ordered points pair satisfying line equation
14.	Check if a line passes through the origin
15.	Count of different straight lines with total n points with m collinear
16.	Number of horizontal or vertical line segments to connect 3 points
17.	Program to find the mid-point of a line
18.	Section formula (Point that divides a line in given ratio)
19.	Sum of Manhattan distances between all pairs of points
20.	Minimum number of points to be removed to get remaining points on one side of axis
21.	Program to find slope of a line
22.	Maximum integral co-ordinates with non-integer distances
23.	Direction of a Point from a Line Segment
24.	Find intersection point of lines inside a section
25.	Program to check if three points are collinear

 */
public interface ILines {

	/** 1. How to check if two given line segments intersect? **/
	public boolean isCollinear(Point p, Point q, Point r);

	public boolean onSegment(Point p, Point q, Point r);

	public int orientation(Point p, Point q, Point r);

	public boolean isIntersected(Point p1, Point q1, Point p2, Point q2);

	/* it will develope after redblack tree implementatin since it use */
	/** 2. Given n line segments, find if any two segments intersect **/

	/** 3. Klee�s Algorithm (Length Of Union Of Segments of a line) **/
	public int lenUnionOfSegmentOfLine(List<Segment> list);

	/** 4. Count maximum points on same line **/
	public int maxPointOnSameLine(List<Point> lp);

	/** 5. Find an Integer point on a line segment with given two ends **/
	public Point pointsOnTwoPointsEnd(Point p1, Point p2);

	/** 6. Minimum lines to cover all points **/
	public int minLinesCoverAllPoints(List<Point> lp, Point p);

	/** 7. Minimum block jumps to reach destination **/
	public int minBlockJumpForDestination(List<Line> ll, Point src, Point dest);

	/** 8. Program for Point of Intersection of Two Lines **/
	public Point InterSetOfTwoLines(Point a, Point b, Point c, Point d);

	/** 9. Represent a given set of points by the best possible straight line **/
	public void bestPossibleStragitLine(int x[], int y[]);

	/** 10. Program to find line passing through 2 Points **/
	public String lineFromPoints(Point p, Point q);
	/** 11. Reflection of a point about a line in C++ **/
	/** 12. Find points at a given distance on a line of given slope **/
	/** 13. Number of ordered points pair satisfying line equation **/
	/** 14. Check if a line passes through the origin **/
	/**
	 * 15. Count of different straight lines with total n points with m collinear
	 **/
}
