package com.design.analysis.ds.graph.utils;

import com.design.analysis.ds.graph.node.Edge;
import org.junit.Test;

import java.util.List;

public class GUtilsTest {

    @Test
    public void displayGraphTest()
    {
        List<List<Integer>> adjList = List.of(
            List.of(2, 4), // Node 1 -> 2,4
            List.of(1, 3), // Node 2 -> 1,3
            List.of(2, 4), //Node 3->2,4
            List.of(1, 3)// Node 4 -> 1,3
        );

        GUtils.display(GUtils.createGraph(adjList));
    }


}
