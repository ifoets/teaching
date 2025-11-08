package com.design.analysis.ds.graph.node;

public class Edge<T> {

    public GVNode<T> src;
    public GVNode<T> des;
    public T w;

    public Edge(GVNode<T> src,GVNode<T>des,T wt)
    {
        this.src = src;
        this.des = des;
        this.w = wt;
    }

    @Override
    public String toString() {
        return "(" + src.value + "->" + des.value + ", w=" + w + ")";
    }
}
