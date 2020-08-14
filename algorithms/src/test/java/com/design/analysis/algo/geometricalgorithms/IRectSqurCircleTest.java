package com.design.analysis.algo.geometricalgorithms;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algo.geometricalgorithms.model.DPoint;
import com.design.analysis.algo.geometricalgorithms.model.PointSegment;
import com.design.analysis.algo.node.Point;

public class IRectSqurCircleTest {

	public IRectSqurCircle irsc = null;

	@Before
	public void init() {
		irsc = new RectSqurCircleImpl();
	}

	/** 1. Find if two rectangles overlap **/
	@Test
	public void isOverlapTwoRectTest() {
		Point l1 = new Point(0, 10), r1 = new Point(10, 0), l2 = new Point(5, 5), r2 = new Point(15, 0);
		Assert.assertTrue(irsc.isOverlapTwoRect(l1, r1, l2, r2));
	}

	/** 2. Check if four segments form a rectangle **/
	@Test
	public void isFormRectTest() {
		List<PointSegment> lps = new ArrayList<>();
		lps.add(new PointSegment(new Point(4, 2), new Point(7, 5)));
		lps.add(new PointSegment(new Point(2, 4), new Point(4, 2)));
		lps.add(new PointSegment(new Point(2, 4), new Point(5, 7)));
		lps.add(new PointSegment(new Point(5, 7), new Point(7, 5)));

		Assert.assertTrue(irsc.isFormRect(lps));
	}

	/** 3. Check whether a given point lies inside a rectangle or not **/
	@Test
	public void isPointInsideRectangleTest() {
		Point p = new Point(10, 15);
		Point p1 = new Point(0, 10);
		Point p2 = new Point(10, 0);
		Point p3 = new Point(0, -10);
		Point p4 = new Point(-10, 0);
		Assert.assertTrue(!irsc.isPointInsideRectangle(p1, p2, p3, p4, p));
		Assert.assertTrue(irsc.isPointInsideRectangle(p1, p2, p3, p4, new Point(0, 0)));
	}

	/** 4. Minimum Perimeter of n blocks **/
	@Test
	public void minPerimeterTest() {
		Assert.assertTrue(irsc.minPerimeter(22) == 20);
		Assert.assertTrue(irsc.minPerimeter(24) == 20);
	}

	/** 5. Number of rectangles in N*M grid **/
	@Test
	public void noOfRectInMNGridTest() {
		Assert.assertTrue(irsc.noOfRectInMNGrid(4, 5) == 150);
		Assert.assertTrue(irsc.noOfRectInMNGrid(2, 3) == 18);
	}

	/** 6. Find Corners of Rectangle using mid points **/
	@Test
	public void cornerOfRectTest() {
		List<DPoint> ldp = irsc.cornerOfRect(new DPoint(1, 0), new DPoint(1, 2), 2);
		for (DPoint dp : ldp)
			System.out.println(dp.x + ", " + dp.y);
		ldp = irsc.cornerOfRect(new DPoint(1, 1), new DPoint(-1, -1), 2 * Math.sqrt(2));
		for (DPoint dp : ldp)
			System.out.println(dp.x + ", " + dp.y);
	}

	/** 7. Coordinates of rectangle with given points lie inside **/
	@Test
	public void minRectCordinateTest() {
		Integer X[] = { 4, 3, 6, 1, -1, 12 };
		Integer Y[] = { 4, 1, 10, 3, 7, -1 };
		List<Point> lp = irsc.minRectCordinate(X, Y);
		int a[][] = { { -1, -1 }, { -1, 10 }, { 12, 10 }, { 12, -1 } };
		for (int i = 0; i < a.length; i++) {
			Point p = lp.get(i);
			Assert.assertTrue(p.x == a[i][0] && p.y == a[i][1]);
		}
	}

	/** 8. Total area of two overlapping rectangles **/
	@Test
	public void totalAreaOverlapRectlsTest() {
		Point l1 = new Point(2, 2);
		Point r1 = new Point(5, 7);
		Point l2 = new Point(3, 4);
		Point r2 = new Point(6, 9);
		Assert.assertTrue(irsc.totalAreaOverlapRectls(l1, r1, l2, r2) == 24);
	}

	/** 9. Program for Area And Perimeter Of Rectangle **/
	@Test
	public void areaAndPerimeterOfRectTest() {
		int r[] = irsc.areaAndPerimeterOfRect(5, 6);
		Assert.assertTrue(r[0] == 30 && r[1] == 22);
	}

	/** 10. Program to find Perimeter / Circumference of Square and Rectangle **/
	@Test
	public void perimeterTest() {
		Assert.assertTrue(irsc.perimeter(8, 4) == 24);
	}

	/** 11. Program for Area Of Square **/
	@Test
	public void areaSqureTest() {
		Assert.assertTrue(irsc.areaSqure(5) == 25);
	}

	/** 12. Number of unique rectangles formed using N unit squares **/
	@Test
	public void uniqueRectByNUnitsSqureTest() {
		Assert.assertTrue(irsc.uniqueRectByNUnitsSqure(5) == 6);
	}

	/** 13. How to check if given four points form a square **/
	@Test
	public void isSquareTest() {
		Point p1 = new Point(20, 10);
		Point p2 = new Point(10, 20);
		Point p3 = new Point(20, 20);
		Point p4 = new Point(10, 10);
		Assert.assertTrue(irsc.isSquare(p1, p2, p3, p4));
	}

	/** 14. Paper Cut into Minimum Number of Squares **/
	@Test
	public void cutPaperMinNoOfSqaureTest() {
		Assert.assertTrue(irsc.cutPaperMinNoOfSqaure(13, 29) == 9);
	}

	/** 15. Program to find area of a circle **/
	@Test
	public void areaOfCircleTest() {
		Assert.assertTrue((int) irsc.areaOfCircle(5) == 78);
	}

	/** 16. Non-crossing lines to connect points in a circle **/
	@Test
	public void noOfWaysConnectAllLinsNonCrossTest() {
		Assert.assertTrue(irsc.noOfWaysConnectAllLinsNonCross(6) == 5);
	}

	/** 17. Circle and Lattice Points **/
	@Test
	public void countLatticeOnCircumOfCircleTest() {
		Assert.assertTrue(irsc.countLatticeOnCircumOfCircle(5) == 12);
	}

	/** 18. Queries on count of points lie inside a circle **/
	@Test
	public void countPointsInsideCircleTest() {
		int x[] = { 1, 2, 3, -1, 4 };
		int y[] = { 1, 2, 3, -1, 4 };
		int n = x.length;
		// Compute distances of all points and keep
		// the distances sorted so that query can
		// work in O(logn) using Binary Search.
		int p[] = new int[n];
		irsc.preprocess(p, x, y, n);
		// Print number of points in a circle of
		// radius 3.
		Assert.assertTrue(irsc.query(p, n, 3) == 3);
		// Print number of points in a circle of
		// radius 32.
		Assert.assertTrue(irsc.query(p, n, 32) == 5);
	}

	/** 19. Check whether a point exists in circle sector or not **/
	@Test
	public void isPointInsideCircleSectorTest() {
		int radius = 8;
		Point p = new Point(3, 4);
		float percent = 12, startAngle = 0;
		Assert.assertTrue(irsc.isPointInsideCircleSector(p, radius, percent, startAngle));
	}

	/** 20. Pizza cut problem (Or Circle Division by Lines) **/
	@Test
	public void noOfMaxPeacesOfCircleTest() {
		Assert.assertTrue(irsc.noOfMaxPeacesOfCircle(3) == 7);
	}
}
