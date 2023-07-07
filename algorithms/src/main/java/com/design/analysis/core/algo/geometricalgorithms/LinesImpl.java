package com.design.analysis.core.algo.geometricalgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.core.algo.geometricalgorithms.model.Line;
import com.design.analysis.core.algo.geometricalgorithms.model.Segment;
import com.design.analysis.core.algo.node.Point;
import com.design.analysis.core.algo.utils.AlgoUtils;

public class LinesImpl implements ILines {

	/** 1. How to check if two given line segments intersect? **/
	// p , q and r are collinear or not

	@Override
	public boolean isCollinear(Point p, Point q, Point r) {
		return ((q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x)) == 0 ? true : false;
	}

	// here q is on line of p and r ie q lies on segment pr
	@Override
	public boolean onSegment(Point p, Point q, Point r) {
		// coordinate of q must lies between p and r
		boolean isPointLies = q.x <= Math.max(p.x, r.x) && q.y <= Math.max(p.y, r.y) && q.x >= Math.min(p.x, r.x)
				&& q.y >= Math.min(p.y, r.y);

		// slop of p,q and q,r must be same
		boolean isSameSlop = ((q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x)) == 0 ? true : false;
		return isPointLies && isSameSlop;
	}

	@Override
	public int orientation(Point p, Point q, Point r) {

		int val = (q.y - p.y) * (r.x - q.x) - (r.y - q.y) * (q.x - p.x);
		if (val == 0)
			return 0;
		return val > 0 ? 1 : 2; // 1 for clock wise and 2 for anticloclwise
	}

	@Override
	public boolean isIntersected(Point p1, Point q1, Point p2, Point q2) {

		// Find the four orientations needed for general and
		// special cases
		int o1 = orientation(p1, q1, p2);
		int o2 = orientation(p1, q1, q2);
		int o3 = orientation(p2, q2, p1);
		int o4 = orientation(p2, q2, q1);

		// General case
		if (o1 != o2 && o3 != o4)
			return true;

		// Special Cases
		// p1, q1 and p2 are colinear and p2 lies on segment p1q1
		if (o1 == 0 && onSegment(p1, p2, q1))
			return true;

		// p1, q1 and p2 are colinear and q2 lies on segment p1q1
		if (o2 == 0 && onSegment(p1, q2, q1))
			return true;

		// p2, q2 and p1 are colinear and p1 lies on segment p2q2
		if (o3 == 0 && onSegment(p2, p1, q2))
			return true;

		// p2, q2 and q1 are colinear and q1 lies on segment p2q2
		if (o4 == 0 && onSegment(p2, q1, q2))
			return true;

		return false; // Doesn't fall in any of the above cases
	}

	/* it will develope after redblack tree implementatin since it use */
	/** 2. Given n line segments, find if any two segments intersect **/

	/** 3. Klee’s Algorithm (Length Of Union Of Segments of a line) **/
	@Override
	public int lenUnionOfSegmentOfLine(List<Segment> list) {

		if (list == null || list.size() == 0)
			return 0;
		int len = 0;
		Collections.sort(list);
		List<Segment> newSeg = new ArrayList<>();
		newSeg.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			if (newSeg.get(newSeg.size() - 1).end > list.get(i).st) {
				newSeg.get(newSeg.size() - 1).setEnd(list.get(i).end);
			} else {
				newSeg.add(list.get(i));
			}
		}

		for (int i = 0; i < newSeg.size(); i++)
			len += newSeg.get(i).end - newSeg.get(i).st;
		return len;
	}

	/** 4. Count maximum points on same line **/
	@Override
	public int maxPointOnSameLine(List<Point> lp) {

		if (lp == null || lp.size() == 0)
			return 0;
		if (lp.size() == 1)
			return 1;
		if (lp.size() == 2)
			return 2;

		int superMax = 0;
		Point p1 = null;
		Point p2 = null;
		Map<Integer, Integer> map = null;

		for (int i = 0; i < lp.size(); i++) {
			map = new HashMap<Integer, Integer>();
			for (int j = i + 1; j < lp.size(); j++) {
				p1 = lp.get(j - 1);
				p2 = lp.get(j);

				int key;
				if ((p2.x - p1.x) == 0)
					key = Integer.MAX_VALUE;
				else
					key = (p2.y - p1.y) / (p2.x - p1.x);
				if (map.containsKey(key))
					map.put(key, map.get(key) + 1);
				else
					map.put(key, 1);
			}
			int max = 0;
			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				if (max < m.getValue())
					max = m.getValue();
			}
			if (superMax < max)
				superMax = max;
		}
		return 1 + superMax;
	}

	/** 5. Find an Integer point on a line segment with given two ends **/
	// TODO Need to understand well
	@Override
	public Point pointsOnTwoPointsEnd(Point p1, Point p2) {
		// Getting coefficient of line
		// ax+by=c, a line form given point
		int a = p2.y - p1.y;
		int b = p1.x - p2.x;
		int c = p1.x * (p2.y - p1.y) - p1.y * (p2.x - p1.x);
		int g, x, y; // To be assigned a value by extendedGcd()
		int val[] = AlgoUtils.extendedGcd(a, b);
		g = val[0];
		x = val[1];
		y = val[2];
		// return array [d, a, b] such that d = gcd(p, q), ap + bq = d
		// if C is not divisble by g, then no solution
		// is available
		if (c % g != 0)
			return null;
		return new Point(x * c / g, y * c / g);
	}

	/** 6. Minimum lines to cover all points **/
	@Override
	public int minLinesCoverAllPoints(List<Point> lp, Point p) {
		Point p1 = p;
		Point p2 = null;
		Map<Integer, Integer> map = null;

		map = new HashMap<Integer, Integer>();
		for (int j = 1; j < lp.size(); j++) {
			p2 = lp.get(j);
			int key;
			if ((p2.x - p1.x) == 0)
				key = Integer.MAX_VALUE;
			else
				key = (p2.y - p1.y) / (p2.x - p1.x);
			if (map.containsKey(key))
				map.put(key, map.get(key) + 1);
			else
				map.put(key, 1);
		}
		return map.size();
	}

	/** 7. Minimum block jumps to reach destination **/
	/* Returns 1 if evaluation is greater > 0, else returns -1 */
	public int evalPointOnLine(Point p, Line curLine) {
		int eval = curLine.a * p.x + curLine.b * p.y + curLine.c;
		if (eval > 0)
			return 1;
		return -1;
	}

	@Override
	public int minBlockJumpForDestination(List<Line> ll, Point src, Point dest) {
		int jumps = 0;
		for (Line l : ll) {
			// get sign of evaluation from point
			// co-ordinate and line equation
			int signStart = evalPointOnLine(src, l);
			int signDest = evalPointOnLine(dest, l);

			// if both evaluation are of opposite sign,
			// increase jump by 1
			if (signStart * signDest < 0)
				jumps++;
		}
		return jumps;
	}

	/** 8. Program for Point of Intersection of Two Lines **/
	public Point InterSetOfTwoLines(Point a, Point b, Point c, Point d) {
		// Line AB represented as a1x + b1y = c1
		int a1 = b.y - a.y;
		int b1 = a.x - b.x;
		int c1 = a1 * (a.x) + b1 * (a.y);

		// Line CD represented as a2x + b2y = c2
		int a2 = d.y - c.y;
		int b2 = c.x - d.x;
		int c2 = a2 * (c.x) + b2 * (c.y);

		int determinant = a1 * b2 - a2 * b1;

		if (determinant == 0) {
			// The lines are parallel. This is simplified
			// by returning a pair of FLT_MAX
			return new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		} else {
			int x = (b2 * c1 - b1 * c2) / determinant;
			int y = (a1 * c2 - a2 * c1) / determinant;
			return new Point(x, y);
		}
	}

	/** 9. Represent a given set of points by the best possible straight line **/
	@Override
	public void bestPossibleStragitLine(int x[], int y[]) {
		int n = x.length;
		double m, c, sum_x = 0, sum_y = 0, sum_xy = 0, sum_x2 = 0;
		for (int i = 0; i < n; i++) {
			sum_x += x[i];
			sum_y += y[i];
			sum_xy += x[i] * y[i];
			sum_x2 += Math.pow(x[i], 2);
		}

		m = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - Math.pow(sum_x, 2));
		c = (sum_y - m * sum_x) / n;

		System.out.println("m = " + m);
		System.out.println("c = " + c);
	}

	/** 10. Program to find line passing through 2 Points **/
	public String lineFromPoints(Point p, Point q) {
		int a = q.y - p.y;
		int b = p.x - q.x;
		int c = a * (p.x) + b * (p.y);

		if (b < 0) {

			return a + "x " + b + "y = " + c;
		} else {
			return a + "x +" + b + "y = " + c;
		}
	}
	/* (x−x1)/a=(y−y1)/b=−2(ax1+by1+c)/(a2+b2) */
}
