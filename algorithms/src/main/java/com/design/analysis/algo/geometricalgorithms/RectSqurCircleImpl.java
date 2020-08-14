package com.design.analysis.algo.geometricalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.algo.geometricalgorithms.model.DPoint;
import com.design.analysis.algo.geometricalgorithms.model.PointSegment;
import com.design.analysis.algo.node.Point;
import com.design.analysis.algo.utils.AlgoUtils;

public class RectSqurCircleImpl implements IRectSqurCircle {

	/** 1. Find if two rectangles overlap **/
	@Override
	public boolean isOverlapTwoRect(Point l1, Point r1, Point l2, Point r2) {

		// l is lefttop and r is right bottom of rectangle
		// either one is left or rigght to anoter without overlaping
		if (r1.x < l2.x || r2.x < l1.x)
			return false;
		// eighter one is up or down to anoter without overlaping
		if (r1.y > l2.y || r2.y > l1.y)
			return false;

		return true;
	}

	/** 2. Check if four segments form a rectangle **/
	@Override
	public boolean isFormRect(List<PointSegment> ls) {
		List<Point> lp = new ArrayList<>();
		List<Point> flp = new ArrayList<>();
		Map<Point, Integer> map = new HashMap<Point, Integer>();
		for (PointSegment ps : ls) {
			lp.add(ps.st);
			lp.add(ps.end);
		}
		for (Point p : lp) {
			if (map.get(p) != null)
				map.put(p, 1 + map.get(p));
			else {
				map.put(p, 1);
				flp.add(p);
			}
		}
		if (map.size() != 4)
			return false;
		List<Integer> ldist = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == 0)
					ldist.add(AlgoUtils.getDistance(flp.get(i), flp.get(j)));
				else {
					int dist = AlgoUtils.getDistance(flp.get(i), flp.get(j));
					if (!ldist.contains(dist))
						return false;
				}
			}
		}
		return true;
	}

	/** 3. Check whether a given point lies inside a rectangle or not **/
	@Override
	public boolean isPointInsideRectangle(Point p1, Point p2, Point p3, Point p4, Point p) {

		double A = AlgoUtils.areaTringle(p1, p2, p3) + AlgoUtils.areaTringle(p1, p3, p4);

		double A1 = AlgoUtils.areaTringle(p1, p2, p);
		double A2 = AlgoUtils.areaTringle(p2, p3, p);
		double A3 = AlgoUtils.areaTringle(p3, p4, p);
		double A4 = AlgoUtils.areaTringle(p4, p1, p);

		return A == (A1 + A2 + A3 + A4);
	}

	/** 4. Minimum Perimeter of n blocks **/
	@Override
	public long minPerimeter(int n) {
		int l = (int) Math.sqrt(n);
		int sq = l * l;

		// if n is a perfect square
		if (sq == n)
			return l * 4;
		else {
			// Number of rows
			long row = n / l;

			// perimeter of the rectangular grid
			long perimeter = 2 * (l + row);

			// if there are blocks left
			if (n % l != 0)
				perimeter += 2;
			return perimeter;
		}
	}

	/** 5. Number of rectangles in N*M grid **/
	@Override
	public int noOfRectInMNGrid(int m, int n) {
		return m * (m + 1) * n * (n + 1) / 4;
	}

	/** 6. Find Corners of Rectangle using mid points **/
	@Override
	public List<DPoint> cornerOfRect(DPoint p, DPoint q, double l) {
		List<DPoint> dpl = new ArrayList<>();
		DPoint a, b, c, d;
		a = new DPoint();
		b = new DPoint();
		c = new DPoint();
		d = new DPoint();
		// horizontal rectangle
		if (p.x == q.x) {
			a.x = p.x - (l / 2.0);
			a.y = p.y;

			d.x = p.x + (l / 2.0);
			d.y = p.y;

			b.x = q.x - (l / 2.0);
			b.y = q.y;

			c.x = q.x + (l / 2.0);
			c.y = q.y;
		}

		// vertical rectangle
		else if (p.y == q.y) {
			a.y = p.y - (l / 2.0);
			a.x = p.x;

			d.y = p.y + (l / 2.0);
			d.x = p.x;

			b.y = q.y - (l / 2.0);
			b.x = q.x;

			c.y = q.y + (l / 2.0);
			c.x = q.x;
		}

		// slanted rectangle
		else {
			// calculate slope of the side
			double m = (p.x - q.x) / (q.y - p.y);

			// calculate displacements along axes
			double dx = (l / Math.sqrt(1 + (m * m))) * 0.5;
			double dy = m * dx;

			a.x = p.x - dx;
			a.y = p.y - dy;

			d.x = p.x + dx;
			d.y = p.y + dy;

			b.x = q.x - dx;
			b.y = q.y - dy;

			c.x = q.x + dx;
			c.y = q.y + dy;
		}
		dpl.add(a);
		dpl.add(b);
		dpl.add(c);
		dpl.add(d);
		return dpl;
	}

	/** 7. Coordinates of rectangle with given points lie inside **/
	@Override
	public List<Point> minRectCordinate(Integer x[], Integer y[]) {
		List<Point> lp = new ArrayList<>();
		// find Xmax and Xmin
		int Xmax = Collections.max(Arrays.asList(x));
		int Xmin = Collections.min(Arrays.asList(x));

		// find Ymax and Ymin
		int Ymax = Collections.max(Arrays.asList(y));
		int Ymin = Collections.min(Arrays.asList(y));

		lp.add(new Point(Xmin, Ymin));
		lp.add(new Point(Xmin, Ymax));
		lp.add(new Point(Xmax, Ymax));
		lp.add(new Point(Xmax, Ymin));
		return lp;
	}

	/** 8. Total area of two overlapping rectangles **/
	@Override
	public int totalAreaOverlapRectls(Point l1, Point r1, Point l2, Point r2) {
		// l and r are the bottom left and top right point
		// Area of 1st Rectangle
		int area1 = Math.abs(l1.x - r1.x) * Math.abs(l1.y - r1.y);

		// Area of 2nd Rectangle
		int area2 = Math.abs(l2.x - r2.x) * Math.abs(l2.y - r2.y);

		int areaI = (Math.min(r1.x, r2.x) - Math.max(l1.x, l2.x)) * (Math.min(r1.y, r2.y) - Math.max(l1.y, l2.y));

		return (area1 + area2 - areaI);
	}

	/** 9. Program for Area And Perimeter Of Rectangle **/
	@Override
	public int[] areaAndPerimeterOfRect(int a, int b) {
		int r[] = new int[2];
		r[0] = a * b;
		r[1] = 2 * (a + b);
		return r;
	}

	/** 10. Program to find Perimeter / Circumference of Square and Rectangle **/
	@Override
	public int perimeter(int a, int b) {
		// for square a=b
		return 2 * (a + b);
	}

	/** 11. Program for Area Of Square **/
	@Override
	public int areaSqure(int a) {
		return a * a;
	}

	/** 12. Number of unique rectangles formed using N unit squares **/
	@Override
	public int uniqueRectByNUnitsSqure(int n) {

		int qur = 0;
		for (int len = 1; len <= Math.sqrt(n); len++) {
			for (int height = len; height * len <= n; height++)
				qur++;
		}
		return qur;
	}

	/** 13. How to check if given four points form a square **/
	@Override
	public boolean isSquare(Point p1, Point p2, Point p3, Point p4) {

		int d2 = AlgoUtils.getDistance(p1, p2); // from p1 to p2
		int d3 = AlgoUtils.getDistance(p1, p3); // from p1 to p3
		int d4 = AlgoUtils.getDistance(p1, p4); // from p1 to p4

		if (d2 == d3 && 2 * d2 == d4 && 2 * d2 == AlgoUtils.getDistance(p2, p3)) {
			int d = AlgoUtils.getDistance(p2, p4);
			return (d == AlgoUtils.getDistance(p3, p4) && d == d2);
		}

		// The below two cases are similar to above case
		if (d3 == d4 && 2 * d3 == d2 && 2 * d3 == AlgoUtils.getDistance(p3, p4)) {
			int d = AlgoUtils.getDistance(p2, p3);
			return (d == AlgoUtils.getDistance(p2, p4) && d == d3);
		}
		if (d2 == d4 && 2 * d2 == d3 && 2 * d2 == AlgoUtils.getDistance(p2, p4)) {
			int d = AlgoUtils.getDistance(p2, p3);
			return (d == AlgoUtils.getDistance(p3, p4) && d == d2);
		}
		return false;
	}

	/** 14. Paper Cut into Minimum Number of Squares **/
	@Override
	public int cutPaperMinNoOfSqaure(int a, int b) {
		int result = 0;
		int rem = 0;

		// swap if a is small size side .
		if (a < b)
			AlgoUtils.swap(a, b);
		// Iterate until small size side is
		// greater then 0
		while (b > 0) {
			// Update result
			result += a / b;

			rem = a % b;
			a = b;
			b = rem;
		}
		return result;
	}

	/** 15. Program to find area of a circle **/
	@Override
	public double areaOfCircle(int r) {
		return (3.14) * r * r;
	}

	/** 16. Non-crossing lines to connect points in a circle **/
	@Override
	public int noOfWaysConnectAllLinsNonCross(int n) {

		// divide the points in two parts
		n = n / 2;
		int[] catalan = new int[n + 1];
		catalan[0] = catalan[1] = 1;

		for (int i = 2; i <= n; i++) {
			catalan[i] = 0;
			for (int j = 0; j < i; j++)
				catalan[i] += catalan[j] * catalan[i - j - 1];
		}
		return catalan[n];
	}

	/** 17. Circle and Lattice Points **/
	@Override
	public int countLatticeOnCircumOfCircle(int r) {
		if (r <= 0)
			return 0;
		// Initialize result as 4 for (r, 0), (-r. 0),
		// (0, r) and (0, -r)
		int result = 4;

		// Check every value that can be potential x
		for (int x = 1; x < r; x++) {
			// Find a potential y
			int ySquare = r * r - x * x;
			int y = (int) Math.sqrt(ySquare);

			if (y * y == ySquare)
				result += 4;
		}

		return result;
	}

	/** 18. Queries on count of points lie inside a circle **/
	public void preprocess(int p[], int x[], int y[], int n) {
		for (int i = 0; i < n; i++)
			p[i] = x[i] * x[i] + y[i] * y[i];

		Arrays.sort(p);
	}

	@Override
	public int countPointsInsideCircle(int p[], int r) {
		int n = p.length;
		return query(p, n, r);
	}

// Return count of points lie inside or on circumference of circle using binary search on p[0..n-1] 
	public int query(int p[], int n, int rad) {
		int start = 0, end = n - 1;
		while ((end - start) > 1) {
			int mid = (start + end) / 2;
			double tp = Math.sqrt(p[mid]);

			if (tp > (rad * 1.0))
				end = mid - 1;
			else
				start = mid;
		}

		double tp1 = Math.sqrt(p[start]);
		double tp2 = Math.sqrt(p[end]);

		if (tp1 > (rad * 1.0))
			return 0;
		else if (tp2 <= (rad * 1.0))
			return end + 1;
		else
			return start + 1;
	}

	/** 19. Check whether a point exists in circle sector or not **/
	@Override
	public boolean isPointInsideCircleSector(Point p, int r, float percent, float startAngle) {
		// calculate endAngle
		// assumed origin is the center of cirlcle
		float endAngle = 360 / percent + startAngle;
		// Calculate polar co-ordinates
		double polarradius = Math.sqrt(p.x * p.x + p.y * p.y);
		double Angle = Math.atan(p.y / p.x);
		if (Angle >= startAngle && Angle <= endAngle && polarradius < r)
			return true;
		return false;
	}

	/** 20. Pizza cut problem (Or Circle Division by Lines) **/
	@Override
	public int noOfMaxPeacesOfCircle(int cut) {
		return 1 + cut * (cut + 1) / 2;
	}
}
