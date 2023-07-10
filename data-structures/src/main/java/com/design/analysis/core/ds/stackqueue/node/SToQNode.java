package com.design.analysis.core.ds.stackqueue.node;

import com.design.analysis.core.ds.stack.DaStack;

public class SToQNode {
    public DaStack s1;
    public  DaStack s2;

    public SToQNode()
    {
        this.s1 = new DaStack();
        this.s2 = new DaStack();
    }
}
