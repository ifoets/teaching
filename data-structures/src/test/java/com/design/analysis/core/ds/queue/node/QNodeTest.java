package com.design.analysis.core.ds.queue.node;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QNodeTest {

    QNode<Integer> qNode ;

    @Before
    public void init()
    {
        qNode = new QNode<>(5);
    }

    @Test
    public void stackOprTest()
    {
        int a[] = {1,2,3,4,5,6,7,8,9};
        for (int x:a)
            qNode.add(x);
        qNode.display();
        Assert.assertTrue(qNode.peek()==1);
        Assert.assertTrue(qNode.poll()==1);
        Assert.assertTrue(qNode.poll()==2);
    }
}
