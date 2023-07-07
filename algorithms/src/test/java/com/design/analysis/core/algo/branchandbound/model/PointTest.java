package com.design.analysis.core.algo.branchandbound.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class PointTest {

	@Test
	public void compareToTest() {

		int a[][] = { { 1, 1 }, { 2, 1 }, { 3, 2 }, { 3, 4 }, { 1, 4 }, { 5, 3 }, { 4, 5 } };
		List<Point> list = new ArrayList<>();
		Point item = null;
		for (int i = 0; i < a.length; i++) {
			item = new Point(a[i][0], a[i][1]);
			list.add(item);
		}
		Collections.sort(list);
		for (Point itm : list)
			System.out.println(itm.toString());
	}
}
