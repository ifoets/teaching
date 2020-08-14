package com.design.analysis.ds.graph;

import java.util.List;

import com.design.analysis.ds.graph.node.Graph;

/*
 * 
 * @author GuruG
 * 
 * BackTracking
1.	Find if there is a path of more than k length from a source
2.	Tug of War
3.	The Knight-Tour Problem
4.	Rat in a Maze
5.	n-Queen’s Problem
6.	m Coloring Problem

 */
public interface IGraphBackTracking<V, W> {

	/** 1. Find if there is a path of more than k length from a source **/
	public List<List<Integer>> pathMoreThanKLen(Graph<V, W> g, V src, W w);

	public boolean backtrackPathRec(Graph<Integer, Integer> g, int src, int w, int currWt, int[] path,
			boolean visited[], int sum, int size);
	// Follwing 2 to 6 not related to graph all r solved in @Backtracing part
	/** 2. Tug of War **/
	/* 3. The Knight-Tour Problem */
	/* 4. Rat in a Maze */
	/* 5. n-Queen’s Problem */
	/* 6. m Coloring Problem */
}
