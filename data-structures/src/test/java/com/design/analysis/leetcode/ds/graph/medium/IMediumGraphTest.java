package com.design.analysis.leetcode.ds.graph.medium;

import com.design.analysis.leetcode.ds.graph.GraphUtils;
import com.design.analysis.leetcode.ds.graph.node.GNode;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IMediumGraphTest {

    private IMediumGraph img;

    @Before
    public void init()
    {
        img = new MediumGraphImpl();
    }
    /**133. Clone Graph*/
    @Test
    public void cloneGraphTest()
    {
        List<List<Integer>> list = List.of(

            List.of(2, 4),
            List.of(1, 3),
            List.of(2, 4),
            List.of(1, 3)
        );
          GNode node = img.cloneGraph(GraphUtils.createGraph(list));
          GraphUtils.printGraph(node);
    }
}
