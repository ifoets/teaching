package com.design.analysis.algo.geometricalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.design.analysis.algo.node.Point;
import com.design.analysis.algo.utils.AlgoUtils;

public class TriangleImpl implements ITriangle {

	/** 1. Check whether a given point lies inside a triangle or not **/
	public double area(Point a, Point b, Point c) {
		int x1 = a.x;
		int y1 = a.y;
		int x2 = b.x;
		int y2 = b.y;
		int x3 = c.x;
		int y3 = c.y;
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}

	/** 1. Check whether a given point lies inside a triangle or not **/
	@Override
	public boolean pointInOutTringle(Point p1, Point p2, Point p3, Point p) {
		/* Calculate area of triangle ABC */
		double A = area(p1, p2, p3);

		/* Calculate area of triangle ABP */
		double A1 = area(p1, p2, p);

		/* Calculate area of triangle BCP */
		double A2 = area(p2, p3, p);

		/* Calculate area of triangle CAP */
		double A3 = area(p3, p1, p);

		/* Check if sum of A1, A2 and A3 is same as A */
		return (A == A1 + A2 + A3);
	}

	/** 2. C program to find area of a triangle **/
	@Override
	public int areaOfTringle(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0 || (a + b <= c) || a + c <= b || b + c <= a) {
			System.out.println("Not a valid triangle");
			System.exit(0);
		}
		float s = (a + b + c) / 2;
		return (int) Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}

	/** 3. Count Integral points inside a Triangle **/
	public int getBoundaryCount(Point p, Point q) {
		// Check if line parallel to axes
		if (p.x == q.x)
			return Math.abs(p.y - q.y) - 1;
		if (p.y == q.y)
			return Math.abs(p.x - q.x) - 1;

		return (int) AlgoUtils.gcd(Math.abs(p.x - q.x), Math.abs(p.y - q.y)) - 1;
	}

	// Returns count of points inside the triangle
	public int getInternalCount(Point p, Point q, Point r) {
		// 3 extra integer points for the vertices
		int BoundaryPoints = getBoundaryCount(p, q) + getBoundaryCount(p, r) + getBoundaryCount(q, r) + 3;

		// Calculate 2*A for the triangle
		int doubleArea = Math.abs(p.x * (q.y - r.y) + q.x * (r.y - p.y) + r.x * (p.y - q.y));

		// Use Pick's theorem to calculate the no. of Interior points
		return (doubleArea - BoundaryPoints + 2) / 2;
	}

	/** 4. Classify a triangle **/
	public int euclidDistSquare(Point p1, Point p2) {
		return (int) Math.sqrt(p1.x - p2.x) + (int) Math.sqrt(p1.y - p2.y);
	}

	// Method to classify side
	public String getSideClassification(int a, int b, int c) {
		// if all sides are equal
		if (a == b && b == c)
			return "Equilateral";

		// if any two sides are equal
		else if (a == b || b == c)
			return "Isosceles";

		else
			return "Scalene";
	}

	// Method to classify angle
	public String getAngleClassification(int a, int b, int c) {
		// If addition of sum of square of two side
		// is less, then acute
		if (a + b > c)
			return "acute";

		// by pythagoras theorem
		else if (a + b == c)
			return "right";

		else
			return "obtuse";
	}

	// Method to classify triangle by sides and angles
	public void classifyTriangle(Point p1, Point p2, Point p3) {
		// Find squares of distances between points
		int a = euclidDistSquare(p1, p2);
		int b = euclidDistSquare(p1, p3);
		int c = euclidDistSquare(p2, p3);
		int arr[] = new int[3];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		Arrays.sort(arr);

		System.out.println("Triangle is " + getAngleClassification(a, b, c) + " and " + getSideClassification(a, b, c));
	}

	/** 5. Maximum height when coins are arranged in a triangle **/
	// H*(H + 1)/2 <= N
	public float squareRoot(float n) {
		float x = n;
		float y = 1;
		// e decides the accuracy level
		float e = 0.000001f;
		while (x - y > e) {
			x = (x + y) / 2;
			y = n / x;
		}

		return x;
	}

	// Method to find maximum height of arrangement of coins
	public int findMaximumHeight(int N) {
		// calculating portion inside
		// the square root
		int n = 1 + 8 * N;
		int maxH = (int) (-1 + squareRoot(n)) / 2;

		return maxH;
	}

	// limit for float comparison
	final static double eps = (double) 1e-6;

	/*
	 * Utility method to get area of right angle triangle, given base and hypotenuse
	 */
	public double getArea(double base, double hypotenuse) {
		double height = Math.sqrt(hypotenuse * hypotenuse - base * base);
		return 0.5 * base * height;
	}

	/**
	 * 6. Find all sides of a right angled triangle from given hypotenuse and area |
	 * Set 1
	 **/
	@Override
	public Point findSidesRightAnglTri(int hypotenuse, int area) {
		int hsquare = hypotenuse * hypotenuse;

		// maximum area will be obtained when base and height
		// are equal (= sqrt(h*h/2))
		double sideForMaxArea = Math.sqrt(hsquare / 2.0);
		double maxArea = getArea(sideForMaxArea, hypotenuse);

		// if given area itself is larger than maxArea then no solution is possible
		if (area > maxArea) {
			System.out.print("Not possible");
			return null;
		}

		double low = 0.0;
		double high = sideForMaxArea;
		double base = 0;

		// binary search for base
		while (Math.abs(high - low) > eps) {
			base = (low + high) / 2.0;
			if (getArea(base, hypotenuse) >= area) {
				high = base;
			} else {
				low = base;
			}
		}
		// get height by pythagorean rule
		double height = Math.sqrt(hsquare - base * base);
		return new Point((int) Math.round(base), (int) Math.round(height));
	}

	/**
	 * 7. Maximum number of n×n squares that can be fit inside a right isosceles
	 * triangle
	 **/
	@Override
	public int noOfSqurareInRitIsoTrin(int b, int n) {

		// base used for making side
		int base = b - n;
		base = base / n;
		return base * (base + 1) / 2;
	}

	/** 8. Check if right triangle possible from given area and hypotenuse **/
	/*
	 * Area : A = 0.5 * a * b Hypotenuse Square : H^2 = a^2 + b^2 Substituting b, we
	 * get H2 = a2 + (4 * A2)/a2 On re-arranging, we get the equation a4 – (H2)(a2)
	 * + 4*(A2)
	 * 
	 * The discriminant D of this equation would be D = H4 – 16*(A2) If D = 0, then
	 * roots are given by the linear equation formula, roots = (-b +- sqrt(D) )/2*a
	 */
	@Override
	public boolean findRightAngle(double A, double H) {
		// Descriminant of the equation
		double D = Math.pow(H, 4) - 16 * A * A;

		if (D >= 0) {
			// applying the linear equation
			// formula to find both the roots
			double root1 = (H * H + Math.sqrt(D)) / 2;
			double root2 = (H * H - Math.sqrt(D)) / 2;

			double a = Math.sqrt(root1);
			double b = Math.sqrt(root2);
			if (b >= a)
				System.out.print(a + " " + b + " " + H);
			else
				System.out.print(b + " " + a + " " + H);
			return true;
		} else
			System.out.print("-1");
		return false;
	}

	/** 9. Triangle with no point inside **/
	public int getDistance(Point p1, Point p2) {
		return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
	}

	@Override
	public List<Point> tringleNoPointInside(Point p[]) {
		// finding three clogest non colliner points
		List<Point> rsp = new ArrayList<>();

		// any point can be chosen as first point of triangle
		int first = 0;
		int second = 0;
		int third = 0;
		int minD = Integer.MAX_VALUE;
		int N = p.length;

		// choose nearest point as second point of triangle
		for (int i = 0; i < N; i++) {
			if (i == first)
				continue;

			// Get distance from first point and choose
			// nearest one
			int d = getDistance(p[i], p[first]);
			if (minD > d) {
				minD = d;
				second = i;
			}
		}

		// Pick third point by finding the second closest
		// point with different slope.
		minD = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			// if already chosen point then skip them
			if (i == first || i == second)
				continue;

			// get distance from first point
			int d = getDistance(p[i], p[first]);
			// checking colliner (y2-y1)(x3-x2)!=(x2-x1)(y3-y2) for p1,p2,and p3
			if (((p[first].y - p[i].y) * (p[second].x - p[first].x) != (p[first].x - p[i].x)
					* (p[second].y - p[first].y)) && minD > d) {
				minD = d;
				third = i;
			}
		}
		rsp.add(p[first]);
		rsp.add(p[second]);
		rsp.add(p[third]);
		return rsp;
	}

	// returns square of distance b/w two points
	public int lengthSquare(Point p1, Point p2) {
		int xDiff = p1.x - p2.x;
		int yDiff = p1.y - p2.y;
		return xDiff * xDiff + yDiff * yDiff;
	}

	/** 10. Find all angles of a given triangle **/
	@Override
	public List<Float> findAnglesOfTingle(Point A, Point B, Point C) {
		List<Float> rs = new ArrayList<>();
		// Square of lengths be a2, b2, c2
		int a2 = lengthSquare(B, C);
		int b2 = lengthSquare(A, C);
		int c2 = lengthSquare(A, B);

		// lenght of sides be a, b, c
		float a = (float) Math.sqrt(a2);
		float b = (float) Math.sqrt(b2);
		float c = (float) Math.sqrt(c2);

		// From Cosine law
		float alpha = (float) Math.acos((b2 + c2 - a2) / (2 * b * c));
		float betta = (float) Math.acos((a2 + c2 - b2) / (2 * a * c));
		float gamma = (float) Math.acos((a2 + b2 - c2) / (2 * a * b));

		// Converting to degree
		alpha = (int) (alpha * 180 / Math.PI);
		betta = (int) (betta * 180 / Math.PI);
		gamma = (int) (gamma * 180 / Math.PI);
		rs.add(alpha);
		rs.add(betta);
		rs.add(gamma);
		return rs;
	}
}
