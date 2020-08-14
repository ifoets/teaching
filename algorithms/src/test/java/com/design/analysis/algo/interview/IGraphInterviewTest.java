package com.design.analysis.algo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class IGraphInterviewTest {

	IGraphInterview igi = null;

	@Before
	public void init() {
		igi = new GraphInterviewImpl();
	}

	@Test
	public void minWeight() {
		int gNode = 0;
		List<Integer> gFrom = new ArrayList<>(Arrays.asList(0, 1, 0, 0));
		List<Integer> gTo = new ArrayList<>(Arrays.asList(1, 0, 2, 3));
		List<Integer> gWt = new ArrayList<>(Arrays.asList(3, 3, 2, 5));
       igi.createGraph(gNode, gFrom, gTo, gWt);
	}
}
