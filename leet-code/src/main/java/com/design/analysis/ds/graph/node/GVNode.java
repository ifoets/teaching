package com.design.analysis.ds.graph.node;

import java.util.ArrayList;
import java.util.List;

public class GVNode<T> {

    public T value;
    public List<Edge<T>> edges = new ArrayList<>();

    public GVNode(T value)
    {
        this.value = value;
    }
    public void addEdge(GVNode<T> des, T w)
    {
        edges.add(new Edge<>(this, des,w));
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
