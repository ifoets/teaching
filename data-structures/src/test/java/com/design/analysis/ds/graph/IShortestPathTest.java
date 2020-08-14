package com.design.analysis.ds.graph;

import org.junit.Before;

public class IShortestPathTest {

	public IShortestPath<Integer, Integer> isp = null;

	@Before
	public void init() {
		isp = new ShortestPathImpl();
	}
}
