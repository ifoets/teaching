package com.design.analysis.leetcode.ds.graph;

import com.design.analysis.leetcode.ds.graph.node.GNode;

import java.util.*;

public class GraphUtils {

    public static GNode createGraph (List<List<Integer>> list){
        Map<Integer,GNode> map = new LinkedHashMap<>();
        for(int i=0;i<list.size();i++) {
            GNode node = new GNode(i + 1);
            for (Integer integer : list.get(i)) {
                if (map.containsKey(integer))
                    node.neighbors.add(map.get(integer)); //for connecting nodes
                else node.neighbors.add(new GNode(integer));
                map.put(i + 1, node);
            }
        }
       /* //inter connecting graph nodes
         for(Map.Entry<Integer,GNode> entry: map.entrySet())
         {
             GNode gNode = entry.getValue();
             List<GNode> neighbours = gNode.neighbors;
             for (GNode neighbour : neighbours) {
                 neighbour.neighbors = map.get(neighbour.val).neighbors;
             }
         }
*/
        return map.get(1);
    }
    public static Map<Integer,GNode> visited = new HashMap<>();
    public static void printGraph(Map<Integer,GNode> map)
    {
       for(Map.Entry<Integer,GNode> entry:map.entrySet())
       {
           System.out.print(entry.getValue().val+"=>");
           List<GNode> neighbours = entry.getValue().neighbors;
           for(GNode gNode:neighbours)
               System.out.print(gNode.val+"->");
           System.out.println();
       }
    }
    public static void printGraph(GNode node)
    {
        Stack<GNode> stack = new Stack<>();
        Map<Integer,GNode> visited = new HashMap<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GNode node1 = stack.pop();
            if (!visited.containsKey(node1.val)) {
                visited.put(node1.val,node);
                System.out.print(node1.val + "=>");
                for (GNode nodeNew : node1.neighbors) {
                    System.out.print(nodeNew.val + "->");
                    stack.push(nodeNew);
                }
                System.out.println();
            }
        }
    }
}
