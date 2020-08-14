package com.design.analysis.algo.interview;

import java.util.List;

public interface IGraphInterview {

	/*
	 * find the min weight form start point to end point if graph is not connect you
	 * may connect with weight 1
	 */
	public int[][] createGraph(int gNode, List<Integer> gFro, List<Integer> gTo, List<Integer> gWt);

	
}
