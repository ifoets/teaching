package com.design.analysis.core.algo.branchandbound.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class KnapsackItemTest {

	@Test
	public void compareToTest() {

		float a[][] = { { 2, 40 }, { 3.14f, 50 }, { 1.98f, 100 }, { 5, 95 }, { 3, 30 } };
		List<KnapsackItem> list = new ArrayList<>();
		KnapsackItem item = null;
		for (int i = 0; i < a.length; i++) {
			item = new KnapsackItem(a[i][0], (int) a[i][1]);
			list.add(item);
		}
		Collections.sort(list);
		for (KnapsackItem itm : list)
			System.out.println(itm.toString());
	}
}
