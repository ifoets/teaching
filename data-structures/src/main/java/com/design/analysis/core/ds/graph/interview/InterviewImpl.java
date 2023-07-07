package com.design.analysis.core.ds.graph.interview;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.ds.graph.node.GLNode;
import com.design.analysis.core.ds.graph.node.Graph;
import com.design.analysis.core.ds.graph.utils.GraphUtils;
import com.design.analysis.core.ds.graph.utils.IGraphUtils;

public class InterviewImpl implements IInterview {

	public static IGraphUtils<Integer, Integer> igu = new GraphUtils();

	public int minCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {
		return minWeightBetwnTwoVertex(igu.createGraph(gFrom, gTo, gWeight), 0, 3);
	}

	public List<List<Integer>> allPathsBetwnTwoVertex(Graph<Integer, Integer> g, int x, int y) {

		List<Integer> localPathList = new ArrayList<>();
		localPathList.add(x);
		List<List<Integer>> allPath = new ArrayList<>();
		boolean isVisited[] = new boolean[g.vSize];
		allPathsBetwnTwoVertex(g, x, y, isVisited, localPathList, allPath);
		return allPath;
	}

	public int minWeightBetwnTwoVertex(Graph<Integer, Integer> g, int x, int y) {

		List<Integer> localPathList = new ArrayList<>();
		// localPathList.add(x);
		List<List<Integer>> allPathWeight = new ArrayList<>();
		boolean isVisited[] = new boolean[g.vSize];
		allPathWeightBetwnTwoVertex(g, x, y, isVisited, localPathList, allPathWeight);
		int min = Integer.MAX_VALUE;
		for (List<Integer> l : allPathWeight) {
			int sum = 0;
			for (Integer it : l) {
				sum += it;
				if (sum > min)
					break;
			}
			if (sum < min)
				min = sum;
		}
		return min;
	}

	public void allPathWeightBetwnTwoVertex(Graph<Integer, Integer> g, int x, int y, boolean[] isVisited,
			List<Integer> localPathWeith, List<List<Integer>> allPathWeight) {
		isVisited[x] = true;
		if (x == y) {
			// System.out.println(localPathWeith);
			List<Integer> newNodeList = new ArrayList<>(localPathWeith);
			allPathWeight.add(newNodeList);
			// if match found then no need to traverse more till depth
			isVisited[x] = false;
		}
		// Recur for all the vertices adjacent to current vertex
		for (GLNode<Integer, Integer> p = g.gl[x]; p != null; p = p.next) {
			if (!isVisited[p.v]) {
				// store current node in path[]
				localPathWeith.add(p.wt);
				allPathWeightBetwnTwoVertex(g, p.v, y, isVisited, localPathWeith, allPathWeight);
				// remove current node in path[]
				localPathWeith.remove(p.wt);
			}
		}
		// Mark the current node
		isVisited[x] = false;
	}

	public void allPathsBetwnTwoVertex(Graph<Integer, Integer> g, int x, int y, boolean[] isVisited,
			List<Integer> localPathList, List<List<Integer>> allPath) {
		isVisited[x] = true;
		if (x == y) {
			System.out.println(localPathList);
			allPath.add(new ArrayList<>(localPathList));
			// if match found then no need to traverse more till depth
			isVisited[x] = false;
		}
		// Recur for all the vertices adjacent to current vertex
		for (GLNode<Integer, Integer> p = g.gl[x]; p != null; p = p.next) {
			if (!isVisited[p.v]) {
				// store current node in path[]
				localPathList.add(p.v);
				allPathsBetwnTwoVertex(g, p.v, y, isVisited, localPathList, allPath);
				// remove current node in path[]
				localPathList.remove(p.v);
			}
		}
		// Mark the current node
		isVisited[x] = false;
	}

	public void printAllPathsUtil(Graph<Integer, Integer> g, Integer u, Integer d, boolean[] isVisited,
			List<Integer> localPathList) {
		// Mark the current node
		isVisited[u] = true;

		if (u.equals(d)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			isVisited[u] = false;
		}
		// Recur for all the vertices
		// adjacent to current vertex
		for (GLNode<Integer, Integer> p = g.gl[u]; p != null; p = p.next) {
			if (!isVisited[p.v]) {
				// store current node in path[]
				localPathList.add(p.v);
				printAllPathsUtil(g, p.v, d, isVisited, localPathList);
				// remove current node in path[]
				localPathList.remove(p.v);
			}
		}
		// Mark the current node
		isVisited[u] = false;
	}

	/** find all path between start node to end node of graph **/
	public List<List<Integer>> allPathBtnTwoNodes(Graph<Integer, Integer> g, Integer s, Integer d) {
		List<Integer> path = new ArrayList<>();
		path.add(s);
		List<List<Integer>> allPath = new ArrayList<>();
		allPathBtnTwoNodes(g, s, d, path, allPath);
		return allPath;
	}

	public void allPathBtnTwoNodes(Graph<Integer, Integer> g, Integer x, Integer y, List<Integer> path,
			List<List<Integer>> allPath) {
		if (x == y) {
			List<Integer> temp = new ArrayList<>(path);
			allPath.add(temp);
		} else {
			GLNode<Integer, Integer> h = g.gl[x];
			for (; h != null; h = h.next) {
				path.add(h.v);
				allPathBtnTwoNodes(g, h.v, y, path, allPath);
				path.remove(h.v);
			}
			path.remove(x);
		}
	}

	public int minWeightBtnTwoNodes(Graph<Integer, Integer> g, Integer s, Integer d) {
		List<Integer> path = new ArrayList<>();
		List<List<Integer>> allPathWeight = new ArrayList<>();
		minWeightBtnTwoNodes(g, s, d, path, allPathWeight);

		int min = Integer.MAX_VALUE;
		for (List<Integer> l : allPathWeight) {
			int sum = 0;
			for (Integer it : l) {
				sum += it;
				if (sum > min)
					break;
			}
			if (sum < min)
				min = sum;
		}
		return min;

	}

	public void minWeightBtnTwoNodes(Graph<Integer, Integer> g, Integer x, Integer y, List<Integer> path,
			List<List<Integer>> allPath) {
		if (x == y) {
			List<Integer> temp = new ArrayList<>(path);
			allPath.add(temp);
		} else {
			GLNode<Integer, Integer> h = g.gl[x];
			for (; h != null; h = h.next) {
				path.add(h.wt);
				minWeightBtnTwoNodes(g, h.v, y, path, allPath);
				path.remove(h.wt);
			}
		}
	}
}
