package com.design.analysis.leetcode.ds.graph.medium;

import com.design.analysis.leetcode.ds.graph.node.GNode;
import com.design.analysis.leetcode.ds.graph.node.GraphNode;

import java.util.*;

public class MediumGraphImpl implements IMediumGraph{

    /**133. Clone Graph*/
    Map<Integer, GNode> visited = new HashMap<>();
    public GNode cloneGraph(GNode node){
        if (node == null) return null;

        // Map to store original -> clone
        Map<GNode, GNode> map = new HashMap<>();
        Queue<GNode> queue = new LinkedList<>();
        queue.add(node);

        // Clone the root node
        map.put(node, new GNode(node.val));

        while (!queue.isEmpty()) {
            GNode curr = queue.poll();

            for (GNode neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone and put into map
                    map.put(neighbor, new GNode(neighbor.val));
                    queue.add(neighbor);
                }
                // Connect clone to its neighbor
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    /**clone weighted graph**/
    public GraphNode cloneGraph(GraphNode start){
        if (start == null) return null;

        Map<GraphNode, GraphNode> cloneMap = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();

        // Clone the start node
        cloneMap.put(start, new GraphNode(start.val));
        queue.add(start);

        while (!queue.isEmpty()) {
            GraphNode curr = queue.poll();

            for (Map.Entry<GraphNode, Integer> entry : curr.neighbors.entrySet()) {
                GraphNode neighbor = entry.getKey();
                int weight = entry.getValue();

                // If neighbor not cloned, clone and add to queue
                if (!cloneMap.containsKey(neighbor)) {
                    cloneMap.put(neighbor, new GraphNode(neighbor.val));
                    queue.add(neighbor);
                }

                // Link cloned neighbor with weight
                cloneMap.get(curr).neighbors.put(cloneMap.get(neighbor), weight);
            }
        }

        return cloneMap.get(start);
    }
}
