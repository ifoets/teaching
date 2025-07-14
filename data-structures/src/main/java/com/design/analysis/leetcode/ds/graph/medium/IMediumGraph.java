package com.design.analysis.leetcode.ds.graph.medium;

import com.design.analysis.leetcode.ds.graph.node.GNode;
import com.design.analysis.leetcode.ds.graph.node.GraphNode;

public interface IMediumGraph {

    /**133. Clone Graph*/
    GNode cloneGraph(GNode node);

    /**clone weighted graph**/
    GraphNode cloneGraph(GraphNode g);
}
