package com.design.analysis.core.ds.stack;

import com.design.analysis.core.ds.stack.node.SNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SNodeTest {

    public SNode<Integer> sNode;
    @Before
    public void init()
    {
        sNode  = new SNode<>(5);
    }

    @Test
    public void stackOprTest()
    {
        int a[] = {1,2,3,4,5,6,7,8,9};
        for (int x:a)
            sNode.push(x);
        sNode.display();
        Assert.assertTrue(sNode.peek()==9);
        Assert.assertTrue(sNode.pop()==9);
        Assert.assertTrue(sNode.pop()==8);
    }
}
