package com.design.analysis.core.algo.matheticalalgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ITrianglesTest {

	ITriangles it = null;

	@Before
	public void init() {
		it = new TrianglesImpl();
	}

	/** 1.Time required to meet in equilateral triangle **/
	@Test
	public void timeToMeetTest() {
		double s = 45, v = 15;
		System.out.println(it.timeToMeet(s, v));
		Assert.assertTrue(it.timeToMeet(s, v) == 2.0);
	}

	/** 2.Trinomial Triangle **/
	/* Function to print Trinomial Triangle of height n. */
	@Test
	public void printTrinomialTest() {
		it.printTrinomial(4);
	}

	/** 3.Leibniz harmonic triangle **/
	@Test
	public void leibnizHarmonicTriangleTest() {
		it.leibnizHarmonicTriangle(7);
	}

	/** 4.Hosoya’s Triangle **/
	/* Print the Hosoya triangle of height n. */
	@Test
	public void printHosoyaTest() {
		it.printHosoya(5);
	}

	/** 5. Number of triangles after N moves **/
	@Test
	public void numberOfTrianglesTest() {
		Assert.assertTrue(it.numberOfTriangles(2) == 17);
	}

	/** 6. Find Perimeter of a triangle **/
	@Test
	public void perimeterOfTringleTest() {
		Assert.assertTrue(it.perimeterOfTringle(3, 4, 5) == 12);
	}

	/** 7. Check whether right angled triangle is valid or not for large sides **/
	@Test
	public void tripletsTest() {
		long a = 4, b = 3, c = 5;
		Assert.assertTrue(it.triplets(a, b, c));

		a = 8;
		b = 13;
		c = 5;
		Assert.assertTrue(!it.triplets(a, b, c));

		a = 1200000000;
		b = 1600000000;
		c = 2000000000;
		Assert.assertTrue(it.triplets(a, b, c));
	}

	/** 8. Maximum height of triangular arrangement of array values **/
	/** 9. Find other two sides of a right angle triangle **/
	@Test
	public void printOtherSidesTest() {
		it.printOtherSides(3);
	}

	/** 10. Find coordinates of the triangle given midpoint of each side **/
	/* Finds vertices of a triangles from given middle vertices. */
	@Test
	public void findVertexTest() {
		int xmid[] = { 5, 4, 5 };
		int ymid[] = { 3, 4, 5 };
		it.findVertex(xmid, ymid);
	}

	/** 11. Number of possible Triangles in a Cartesian coordinate system **/
	/** 12. Triangular Numbers **/
	/** 13. Pascal’s Triangle **/

	@Test
	public void printPascalTest() {
		int n = 7;
		it.printPascal(n);
	}
}
