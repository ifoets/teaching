package com.design.analysis.core.algo.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphInterviewImpl implements IGraphInterview {

	/*
	 * find the min weight form start point to end point(biggest node) if graph is
	 * not connect you may connect with weight 1
	 */

	public int[][] createGraph(int gNode, List<Integer> gFro, List<Integer> gTo, List<Integer> gWt) {
		// ausume garaph started node is 0
		// this is to find the exact size of graph since it may be all node is not in
		// gFrom
		Set<Integer> set = new HashSet<>(gFro);
		set.addAll(gTo);
		int z = set.size();

		// create graph if not connect ..connect with 1 weight
		int g[][] = new int[z][z];

		for (int i = 0; i < gFro.size(); i++)
			g[gFro.get(i)][gTo.get(i)] = gWt.get(i);

		// connect the graph not connect takcare no need to connect any node form to
		// start and no need to connect tha last to any one
		for (int i = 0; i < z - 1; i++) {
			// till z-1 since no nedd to connect last nodet to any one
			// start j start from 1 since no need to connect any node to first node
			for (int j = 1; j < z; j++) {
				if (g[i][j] == 0 && i != j)
					g[i][j] = 1;
			}
			// System.out.println();
		}

		for (int i = 0; i < z; i++) {
			System.out.print("[" + i + "]-> ");
			for (int j = 0; j < z; j++) {
				System.out.print("(" + g[i][j] + ")->"); //
				// System.out.print("(" + j + "," + g[i][j] + ")->");
			}
			System.out.println();
		}

		minWeightBetwnTwoVertex(g, gNode, g.length - 1);
		return g;
	}

	public int minWeightBetwnTwoVertex(int[][] g, int x, int y) {

		List<Integer> localPathList = new ArrayList<>();
		// localPathList.add(x);
		List<List<Integer>> allPathWeight = new ArrayList<>();
		boolean isVisited[] = new boolean[g.length];
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

//TODO
	public void allPathWeightBetwnTwoVertex(int[][] g, int x, int y, boolean[] isVisited, List<Integer> localPathWeigth,
			List<List<Integer>> allPathWeight) {

		isVisited[x] = true;
		if (x == y) {
			System.out.println(localPathWeigth);
			List<Integer> newNodeList = new ArrayList<>(localPathWeigth);
			allPathWeight.add(newNodeList);
			// if match found then no need to traverse more till depth
			isVisited[x] = false;
		}
		for (int j = 0; j < g.length; j++) {
			if (!isVisited[j] && g[x][j] != 0) {
				// store current node in path[]
				localPathWeigth.add(g[x][j]);
				allPathWeightBetwnTwoVertex(g, j, y, isVisited, localPathWeigth, allPathWeight);
				// remove current node in path[]
				localPathWeigth.remove(g[x][j]);
			}
		}

		// Mark the current node
		isVisited[x] = false;

	}
}
