package com.design.analysis.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.design.analysis.ds.graph.node.GLNode;
import com.design.analysis.ds.graph.node.Graph;

public class ShortestPathImpl implements IShortestPath<Integer, Integer> {

	/** 1. Dijkstra’s shortest path algorithm **/
	// TODO
	
	public Map<Integer, List<Integer>> dijkstraShortestPath(Graph<Integer, Integer> g, Integer src) {

		Map<Integer, List<Integer>> map = new HashMap<>();
		Map<Integer, List<Integer>> currentPath = new HashMap<>();
		int currentSumPath[] = new int[g.vSize];
		int sum[] = new int[g.vSize];
		sum[src] = 0;
		List<Integer> l = new ArrayList<>();
		map.put(src, l);
		int n = g.vSize;
		for (int i = src; i < n; i++) {
			GLNode<Integer, Integer> x = g.gl[i];
			for (; x != null; x = x.next) {
				if (currentPath.containsKey(x.v)) {
					currentSumPath[x.v] = x.wt;

					if (currentSumPath[x.v] < sum[x.v]) {
						sum[x.v] = currentSumPath[x.v];
						l = map.get(x.v);
						l.add(i);
						currentPath.put(x.v, l);
						map.put(x.v, l);

					}

				} else {
					l = new ArrayList<>();
					l.add(x.v);
					map.put(i, l);
					currentPath.put(i, l);
					sum[x.v] += x.wt;
					currentSumPath[x.v] = x.wt;
				}
			}
			// if src node is not 0
			if (src != 0 && i == g.vSize - 1) {
				i = 0;
				n = src;
			}
		}
		return map;
	}
}
