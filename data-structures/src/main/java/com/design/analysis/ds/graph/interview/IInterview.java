package com.design.analysis.ds.graph.interview;

import java.util.List;

import com.design.analysis.ds.graph.node.Graph;

public interface IInterview {

	/**
	 * find the sortest weight in graph from first to last node you may connect the
	 * node by 1 weight if not conneted
	 **/
	public int minCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight);

	/** find the min weight from source x to destination y */
	public List<List<Integer>> allPathsBetwnTwoVertex(Graph<Integer, Integer> g, int x, int y);

	public void printAllPathsUtil(Graph<Integer, Integer> g, Integer u, Integer d, boolean[] isVisited,
			List<Integer> localPathList);

	/** find all path between start node to end node of graph **/

	public List<List<Integer>> allPathBtnTwoNodes(Graph<Integer, Integer> g, Integer s, Integer d);

	public void allPathBtnTwoNodes(Graph<Integer, Integer> g, Integer x, Integer y, List<Integer> path,
			List<List<Integer>> allPath);

	public int minWeightBtnTwoNodes(Graph<Integer, Integer> g, Integer s, Integer d);
}
