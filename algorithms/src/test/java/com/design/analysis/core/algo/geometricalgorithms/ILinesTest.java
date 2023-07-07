package com.design.analysis.core.algo.geometricalgorithms;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.algo.geometricalgorithms.model.Line;
import com.design.analysis.core.algo.geometricalgorithms.model.Segment;
import com.design.analysis.core.algo.node.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ILinesTest {
	public ILines il = null;

	@Before
	public void init() {
		il = new LinesImpl();
	}

	@Test
	public void isCollinearTest() {
		Point p = new Point(0, 0);
		Point q = new Point(6, 6);
		Point r = new Point(4, 4);
		Assert.assertTrue(il.isCollinear(p, q, r) == true);

		Point p1 = new Point(0, 0);
		Point q1 = new Point(1, 1);
		Point r1 = new Point(4, 4);
		Assert.assertTrue(il.isCollinear(p1, q1, r1) == true);

		Point p2 = new Point(0, 0);
		Point q2 = new Point(-1, 0);
		Point r2 = new Point(4, 4);
		Assert.assertTrue(il.isCollinear(p2, q2, r2) == false);

		Point p3 = new Point(0, 0);
		Point q3 = new Point(6, 5);
		Point r3 = new Point(4, 4);
		Assert.assertTrue(il.isCollinear(p3, q3, r3) == false);
	}

	@Test
	public void onSegmentTest() {
		Point p = new Point(0, 0);
		Point q = new Point(6, 6);
		Point r = new Point(4, 4);
		Assert.assertTrue(il.onSegment(p, q, r) == false);

		Point p1 = new Point(0, 0);
		Point q1 = new Point(1, 1);
		Point r1 = new Point(4, 4);
		Assert.assertTrue(il.onSegment(p1, q1, r1) == true);

		Point p2 = new Point(0, 0);
		Point q2 = new Point(-1, -1);
		Point r2 = new Point(4, 4);
		Assert.assertTrue(il.onSegment(p2, q2, r2) == false);

		Point p3 = new Point(0, 0);
		Point q3 = new Point(3, 3);
		Point r3 = new Point(4, 4);
		Assert.assertTrue(il.onSegment(p3, q3, r3) == true);
	}

	@Test
	public void orientationTest() {
		Point p = new Point(0, 0);
		Point q = new Point(6, 6);
		Point r = new Point(4, 4);
		Assert.assertTrue(il.orientation(p, q, r) == 0);

		Point p1 = new Point(0, 0);
		Point q1 = new Point(4, 4);
		Point r1 = new Point(3, 4);
		Assert.assertTrue(il.orientation(p1, q1, r1) == 2);

		Point p2 = new Point(0, 0);
		Point q2 = new Point(6, 6);
		Point r2 = new Point(4, 3);
		Assert.assertTrue(il.orientation(p2, q2, r2) == 1);

		Point p3 = new Point(0, 0);
		Point q3 = new Point(5, 5);
		Point r3 = new Point(-1, -1);
		Assert.assertTrue(il.orientation(p3, q3, r3) == 0);
	}

	@Test
	public void isIntersectedTest() {
		Point p1 = new Point(0, 0);
		Point q1 = new Point(6, 6);
		Point p2 = new Point(0, 4);
		Point q2 = new Point(4, 0);
		Assert.assertTrue(il.isIntersected(p1, q1, p2, q2) == true);

		Point p11 = new Point(0, 0);
		Point q11 = new Point(6, 6);
		Point p12 = new Point(0, 0);
		Point q12 = new Point(4, 6);
		Assert.assertTrue(il.isIntersected(p11, q11, p12, q12) == true);

		Point p13 = new Point(0, 0);
		Point q13 = new Point(6, 6);
		Point p14 = new Point(3, 3);
		Point q14 = new Point(4, 0);
		Assert.assertTrue(il.isIntersected(p13, q13, p14, q14) == true);

		Point p15 = new Point(0, 0);
		Point q15 = new Point(6, 6);
		Point p16 = new Point(7, 7);
		Point q16 = new Point(10, 10);
		Assert.assertTrue(il.isIntersected(p15, q15, p16, q16) == false);

		Point p17 = new Point(0, 0);
		Point q17 = new Point(6, 6);
		Point p18 = new Point(-1, -1);
		Point q18 = new Point(0, 8);
		Assert.assertTrue(il.isIntersected(p17, q17, p18, q18) == false);

	}

	/* it will develope after redblack tree implementatin since it use */
	/** 2. Given n line segments, find if any two segments intersect **/

	/** 3. Klee’s Algorithm (Length Of Union Of Segments of a line) **/
	@Test
	public void lenUnionOfSegmentOfLineTest() {

		int s[][] = { { 2, 4 }, { 3, 5 }, { 4, 6 }, { 7, 9 }, { 8, 10 }, { 11, 12 } };
		List<Segment> list = new ArrayList<>();
		for (int i = 0; i < s.length; i++)
			list.add(new Segment(s[i][0], s[i][1]));
		Assert.assertTrue(il.lenUnionOfSegmentOfLine(list) == 8);
	}

	/** 4. Count maximum points on same line **/
	@Test
	public void maxPointOnSameLineTest() {
		int points[][] = { { -1, 1 }, { 0, 0 }, { 1, 1 }, { 2, 2 }, { 3, 3 }, { 3, 4 } };
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			list.add(new Point(points[i][0], points[i][1]));
		}
		Assert.assertTrue(il.maxPointOnSameLine(list) == 4);
	}

	/** 5. Find an Integer point on a line segment with given two ends **/
	/* Utility method for extended Euclidean Algorithm */
	@Test
	public void gcdExtendedTest() {
		Point p1 = new Point(1, -1);
		Point p2 = new Point(-4, 1);
		Point p = il.pointsOnTwoPointsEnd(p1, p2);
		Assert.assertTrue(p.x == 6 && p.y == -3);
	}

	/** 6. Minimum lines to cover all points **/
	@Test
	public void minLinesCoverAllPointsTest() {

		int points[][] = { { -1, 3 }, { 4, 3 }, { 2, 1 }, { -1, -2 }, { 3, -3 } };
		Point p = new Point(1, 0);
		List<Point> list = new ArrayList<>();
		for (int i = 0; i < points.length; i++) {
			list.add(new Point(points[i][0], points[i][1]));
		}
		Assert.assertTrue(il.minLinesCoverAllPoints(list, p) == 2);
	}

	/** 7. Minimum block jumps to reach destination **/
	@Test
	public void minBlockJumpForDestinationTest() {

		Point src = new Point(1, 1);
		Point dest = new Point(-2, -1);

		List<Line> ll = new ArrayList<>();
		ll.add(new Line(1, 0, 0));
		ll.add(new Line(0, 1, 0));
		ll.add(new Line(1, 1, -2));
		Assert.assertTrue(il.minBlockJumpForDestination(ll, src, dest) == 2);
	}

	/** 8. Program for Point of Intersection of Two Lines **/
	@Test
	public void InterSetOfTwoLinesTest() {

		Point A = new Point(1, 1);
		Point B = new Point(4, 4);
		Point C = new Point(1, 8);
		Point D = new Point(2, 4);

		Point ip = il.InterSetOfTwoLines(A, B, C, D);
		Assert.assertTrue(ip.x == 2 && ip.y == 2);
	}

	/** 9. Represent a given set of points by the best possible straight line **/
	@Test
	public void bestPossibleStragitLineTest() {
		int x[] = { 1, 2, 3, 4, 5 };
		int y[] = { 14, 27, 40, 55, 68 };
		il.bestPossibleStragitLine(x, y);
	}

	/** 10. Program to find line passing through 2 Points **/
	@Test
	public void lineFromPointsTest() {
		Point p = new Point(3, 2);
		Point q = new Point(2, 6);
		System.out.println(il.lineFromPoints(p, q));
	}
}
