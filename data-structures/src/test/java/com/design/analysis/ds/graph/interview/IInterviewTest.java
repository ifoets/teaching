package com.design.analysis.ds.graph.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.graph.utils.IGraphUtils;

public class IInterviewTest {

	IInterview ii = null;
	public static IGraphUtils<Integer, Integer> igu = InterviewImpl.igu;

	@Before
	public void init() {
		ii = new InterviewImpl();
	}

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<>();
		l.add(0);
		System.out.println(l);
		m(l);
		System.out.println(l);
	}

	public static void m(List<Integer> l) {
		l.add(2);
	}

	@Test
	public void minCostTest() {

		List<Integer> gFrom = new ArrayList<>(Arrays.asList(0, 1, 0, 0));
		List<Integer> gTo = new ArrayList<>(Arrays.asList(1, 0, 2, 3));
		List<Integer> gWeight = new ArrayList<>(Arrays.asList(3, 3, 2, 5));
		Assert.assertTrue(ii.minCost(0, gFrom, gTo, gWeight) == 3);
	}

	@Test
	public void allPathBtnTwoNodesTest() {
		List<Integer> gF = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 2));
		List<Integer> gT = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 4, 4));
		List<Integer> gW = new ArrayList<>(Arrays.asList(2, 5, 6, 7, 2, 5, 4));
		List<List<Integer>> list = ii.allPathBtnTwoNodes(igu.createGraphConnect(gF, gT, gW), 0, 4);
		for (List<Integer> l : list)
			System.out.println(l);
	}

	@Test
	public void minWeightBtnTwoNodesTest() {
		List<Integer> gF = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1, 1, 2));
		List<Integer> gT = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 4, 4));
		List<Integer> gW = new ArrayList<>(Arrays.asList(2, 5, 6, 7, 2, 5, 4));
		Assert.assertTrue(ii.minWeightBtnTwoNodes(igu.createGraphConnect(gF, gT, gW), 0, 4) == 5);
	}
}
