package com.design.analysis.ds.graph.medium;

import com.design.analysis.ds.graph.node.GNode;

import java.util.List;
import java.util.Set;

public interface IGraphMedium<V> {

    /**133. Clone Graph**/
     GNode<V> cloneGraph(GNode<V> node);
     GNode<V> cloneGraphX(GNode<V> node);

     /**207. Course Schedule**/
     boolean canFinish(int numCourses, int[][] prerequisites);

     /**210. Course Schedule II**/
     int[] findOrder(int numCourses, int[][] prerequisites);

     /**261. Graph valid tree**/
     boolean validTree(int n, int[][] edges);

     /**277. Find the Celebrity**/
     int celebrity(int n, int[][]knows);

     /**310. Minimum Height Trees**/
     List<Integer> findMinHeightTrees(int n, int[][] edges);

     /**323. Number of Connected Components in an Undirected Graph**/
     List<Set<Integer>> disjointSet(int n, int[][]edges);

     /**399. Evaluate Division**/
     double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries);
}
