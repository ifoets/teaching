package com.design.analysis.ds.graph.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GVUtilsTest {

    private GVUtils<Integer> gvUtils;

    @Before
    public void init()
    {
        gvUtils = new GVUtils<>();
    }
     @Test
    public void displayValuedGraphTest()
    {
        List<List<Integer>> adjList = List.of(
           List.of(1,2,3),
            List.of(1,4,1),
            List.of(2,3,6),
            List.of(2,1,4),
            List.of(3,2,5),
            List.of(3,4,8),
            List.of(4,3,7),
            List.of(4,1,2)
        );

        gvUtils.printGraph(gvUtils.buildGraph(adjList,true));
    }
}
