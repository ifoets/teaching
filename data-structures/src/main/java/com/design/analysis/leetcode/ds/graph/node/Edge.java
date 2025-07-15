package com.design.analysis.leetcode.ds.graph.node;

public class Edge {

    public int val;
    public int wt;

    public Edge(int val, int wt) {
        this.val = val;
        this.wt = wt;
    }

    @Override
    public String toString() {
        return "Edge{" + "val=" + val + ", wt=" + wt +'}';
    }
}
