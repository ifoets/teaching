package com.design.analysis.algo.geometricalgorithms;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algo.node.Point;

public class ITriangleTest {

	public ITriangle it = null;

	@Before
	public void init() {
		it = new TriangleImpl();
	}

	/** 1. Check whether a given point lies inside a triangle or not **/
	@Test
	public void pointInOutTringleTest() {
		/*
		 * Let us check whether the point P(10, 15) lies inside the triangle formed by
		 * A(0, 0), B(20, 0) and C(10, 30)
		 */
		Point A = new Point(0, 0);
		Point B = new Point(20, 0);
		Point C = new Point(10, 30);
		Point P = new Point(10, 15);

		Assert.assertTrue(it.pointInOutTringle(A, B, C, P));
	}

	/** 2. C program to find area of a triangle **/
	@Test
	public void areaOfTringleTest() {
		Assert.assertTrue(it.areaOfTringle(3, 4, 5) == 6);
	}

	/** 3. Count Integral points inside a Triangle **/
	@Test
	public void getBoundaryCountTest() {
		Point p = new Point(0, 0);
		Point q = new Point(5, 0);
		Point r = new Point(0, 5);
		Assert.assertTrue(it.getBoundaryCount(p, q) == 4);
		Assert.assertTrue(it.getBoundaryCount(p, r) == 4);
		Assert.assertTrue(it.getBoundaryCount(q, r) == 4);
	}

	// Returns count of points inside the triangle
	@Test
	public void getInternalCountTest() {
		Point p = new Point(0, 0);
		Point q = new Point(5, 0);
		Point r = new Point(0, 5);
		Assert.assertTrue(it.getInternalCount(p, q, r) == 6);
	}

	// Method to classify triangle by sides and angles
	/** 4. Classify a triangle **/
	@Test
	public void classifyTriangleTest() {
		Point p1, p2, p3;
		p1 = new Point(3, 0);
		p2 = new Point(0, 4);
		p3 = new Point(4, 7);
		it.classifyTriangle(p1, p2, p3);

		p1 = new Point(0, 0);
		p2 = new Point(1, 1);
		p3 = new Point(1, 2);
		it.classifyTriangle(p1, p2, p3);
	}

	/** 5. Maximum height when coins are arranged in a triangle **/
	@Test
	public void findMaximumHeightTest() {
		int N = 12;
		Assert.assertTrue(it.findMaximumHeight(N) == 4);
	}

	/**
	 * 6. Find all sides of a right angled triangle from given hypotenuse and area |
	 * Set 1
	 **/
	@Test
	public void findSidesRightAnglTriTest() {
		int hypotenuse = 5;
		int area = 6;

		Point p = it.findSidesRightAnglTri(hypotenuse, area);
		Assert.assertTrue(p.x == 3 && p.y == 4);
	}

	/**
	 * 7. Maximum number of n×n squares that can be fit inside a right isosceles
	 * triangle
	 **/
	@Test
	public void noOfSqurareInRitIsoTrinTest() {
		Assert.assertTrue(it.noOfSqurareInRitIsoTrin(8, 2) == 6);
		Assert.assertTrue(it.noOfSqurareInRitIsoTrin(12, 3) == 6);
	}

	/** 8. Check if right triangle possible from given area and hypotenuse **/
	@Test
	public void findRightAngleTest() {
		Assert.assertTrue(it.findRightAngle(6, 5));
	}

	/** 9. Triangle with no point inside **/
	@Test
	public void tringleNoPointInsideTest() {
		int points[][] = { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 2, 2 }, { 1, 1 } };
		Point[] p = new Point[points.length];
		for (int i = 0; i < points.length; i++)
			p[i] = new Point(points[i][0], points[i][1]);
		List<Point> pl = it.tringleNoPointInside(p);
		List<Point> epl = new ArrayList<>();
		epl.add(new Point(0, 0));
		epl.add(new Point(1, 1));
		epl.add(new Point(0, 2));
		for (int i = 0; i < pl.size(); i++)
			Assert.assertTrue(pl.get(i).x == epl.get(i).x && pl.get(i).y == epl.get(i).y);
	}

	/** 10. Find all angles of a given triangle **/
	@Test
	public void findAnglesOfTingleTest() {
		Point A = new Point(0, 0);
		Point B = new Point(0, 1);
		Point C = new Point(1, 0);
		float a[] = { 90, 45, 45 };
		List<Float> list = it.findAnglesOfTingle(A, B, C);
		for (int i = 0; i < list.size(); i++)
			Assert.assertTrue(list.get(i) == a[i]);
	}
}
