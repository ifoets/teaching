package com.design.analysis.leetcode.ds.graph;

import com.design.analysis.leetcode.ds.graph.node.GNode;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class GraphUtilsTest {

    @Test
    public void createDisplayTest() {
        List<List<Integer>> list = List.of(

            List.of(2, 4),
            List.of(1, 3),
            List.of(2, 4),
            List.of(1, 3)
        );

       GNode gNodeMap = GraphUtils.createGraph(list);
        GraphUtils.printGraph(gNodeMap);
    }
}
