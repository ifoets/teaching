package com.design.analysis.ds.graph.utils;

import com.design.analysis.ds.graph.node.GNode;

import java.util.*;

public class GUtils<V> {

    public static List<GNode<Integer>> createGraph(List<List<Integer>> adjList)
    {
        List<GNode<Integer>> graph = new LinkedList<>();
        //create non connected graph
        for(int i=0;i<adjList.size();graph.add(new GNode<>(i+1)),i++);

        //connect graph
        for(int i=0;i<graph.size();i++)
        {
            GNode<Integer> gnode = graph.get(i);
            for(Integer neighbours:adjList.get(i))
                gnode.neighbours.add(graph.get(neighbours-1));
        }
       return graph;
    }

    public static void display(List<GNode<Integer>> graph)
    {
        for(GNode<Integer> gnode:graph)
        {
            System.out.print(gnode.val+":->");
            for (GNode<Integer> neighbours:gnode.neighbours)
                System.out.print("("+neighbours.val+"),");
            System.out.println();
        }
    }

    public static void displayNodes(GNode<Integer> node)
    {// Priority queue sorted by node value
        PriorityQueue<GNode<Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(n -> n.val)
        );

        boolean[] visited = new boolean[101];   // or use HashSet instead
        pq.add(node);

        while (!pq.isEmpty()) {
            GNode<Integer> curr = pq.poll();
            // Skip if visited
            if (visited[curr.val]) continue;
            visited[curr.val] = true;

            System.out.print(curr.val + ":->");
            for (GNode<Integer> nb : curr.neighbours) {
                System.out.print("(" + nb.val + "),");
                if (!visited[nb.val]) {
                    pq.add(nb);   // Add neighbor only if not visited
                }
            }
            System.out.println();
        }
    }

}
