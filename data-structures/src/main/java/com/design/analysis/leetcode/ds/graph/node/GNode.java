package com.design.analysis.leetcode.ds.graph.node;

import java.util.ArrayList;
import java.util.List;

public class GNode {

    public int val;
    public List<GNode> neighbors;

    public GNode(int val)
    {
        this.val = val;
        this.neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "GNode{" +  "val=" + val +", neighbors=" + neighbors + '}';
    }
}
