package com.design.analysis.ds.graph.utils;

import com.design.analysis.ds.graph.node.GNode;

import java.util.LinkedList;
import java.util.List;

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

}
