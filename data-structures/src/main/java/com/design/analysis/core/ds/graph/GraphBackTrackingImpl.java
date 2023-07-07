package com.design.analysis.core.ds.graph;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.ds.graph.node.GLNode;
import com.design.analysis.core.ds.graph.node.Graph;

public class GraphBackTrackingImpl implements IGraphBackTracking<Integer, Integer> {

	/** 1. Find if there is a path of more than k length from a source **/
	List<List<Integer>> ll = null;

	@Override
	public List<List<Integer>> pathMoreThanKLen(Graph<Integer, Integer> g, Integer src, Integer w) {
		int path[] = new int[50];
		boolean visited[] = new boolean[g.vSize];
		backtrackPathRec(g, src, w, 0, path, visited, 0, 0);
		return ll;
	}

	@Override
	public boolean backtrackPathRec(Graph<Integer, Integer> g, int src, int w, int currWt, int[] path,
			boolean visited[], int sum, int size) {
		if (sum == 0)
			visited[src] = true;
		path[size++] = src;
		sum += currWt;

		if (sum > w) {
			if (ll == null)
				ll = new ArrayList<>();
			List<Integer> l = new ArrayList<>();
			for (int i = 0; i < size; i++)
				l.add(path[i]);
			ll.add(l);
		} else {
			for (GLNode<Integer, Integer> p = g.gl[src]; p != null; p = p.next) {
				if (visited[p.v])
					continue;
				visited[p.v] = true;
				if (backtrackPathRec(g, p.v, w, p.wt, path, visited, sum, size))
					return true;
				visited[p.v] = false; // back track
			}
		}
		return false;
	}
}
