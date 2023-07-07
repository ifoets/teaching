package com.design.analysis.core.algo.greedyalgorithms.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class GreedyModelTest {

	@Test
	public void jobSequenTest() {
		List<JobSequen> list = new ArrayList<>();
		String id[] = { "a", "b", "c", "d", "e", "f" };
		int[] deadline = { 2, 1, 2, 1, 3, 4 };
		int profit[] = { 50, 20, 30, 30, 20, 60 };

		for (int i = 0; i < id.length; i++)
			list.add(new JobSequen(id[i], deadline[i], profit[i]));
		Collections.sort(list);
		for (JobSequen jb : list)
			System.out.println(jb);
	}
}
