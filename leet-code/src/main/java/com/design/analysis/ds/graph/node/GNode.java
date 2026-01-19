package com.design.analysis.ds.graph.node;

import java.util.ArrayList;
import java.util.List;

public class GNode<V> {

    public V val;
    public List<GNode<V>> neighbours;

    public GNode(V node)
    {
        this.val = node;
        neighbours = new ArrayList<>();
    }

    public GNode(V node,List<GNode<V>> list)
    {
        this.val = node;
        neighbours = new ArrayList<>();
    }
}
