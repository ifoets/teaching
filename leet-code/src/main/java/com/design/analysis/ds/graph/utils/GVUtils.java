package com.design.analysis.ds.graph.utils;

import com.design.analysis.ds.graph.node.Edge;
import com.design.analysis.ds.graph.node.GVNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GVUtils<T> {

    public Map<T, GVNode<T>> graph = new HashMap<>();

    //ensure node exists or create it
    private GVNode<T> getOrCreateNode(T value)
    {
        return graph.computeIfAbsent(value,GVNode::new);
    }

    public void addEdge(T src, T des, T w)
    {
        GVNode<T> srcNode = getOrCreateNode(src);
        GVNode<T> desNode = getOrCreateNode(des);
        srcNode.addEdge(desNode,w);
    }

    // Add edge (undirected)
    public void addUndirectedEdge(T src, T dest, T weight) {
        addEdge(src, dest, weight);
        addEdge(dest, src, weight);
    }

    // Build graph from edge list

    public Map<T, GVNode<T>>  buildGraph(List<List<T>> adjList, boolean directed) {
        for (List<T> edge : adjList) {
            if (edge.size() < 3) continue;
            T src = edge.get(0);
            T des = edge.get(1);
            T weight = edge.get(2);

            if (directed)
                addEdge(src, des, weight);
            else
                addUndirectedEdge(src,des, weight);
        }
        return graph;
    }


    public void printGraph(Map<T, GVNode<T>> graph) {
        for (GVNode<T> node : graph.values()) {
            System.out.print(node.value + " -> ");
            for (Edge<T> e : node.edges)
                System.out.print("["+e.des.value + "(" + e.w + ")], ");
            System.out.println();
        }
    }
}
