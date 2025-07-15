package com.design.analysis.leetcode.ds.graph.node;

import java.util.*;

public class GraphNode {

    public int val;
    public Map<GraphNode, Integer> neighbors;

    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new HashMap<>();
    }
}
class Graph {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Add edge (for undirected graph)
    public void addEdge(int src, int dest) {
        adjList.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        adjList.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // Remove for directed graph
    }

    // DFS
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    private void dfsUtil(int node, Set<Integer> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.print(node + " ");
        for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
            dfsUtil(neighbor, visited);
        }
    }

    // BFS
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited.add(start);
        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}