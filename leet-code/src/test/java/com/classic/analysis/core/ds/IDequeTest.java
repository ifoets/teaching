package com.classic.analysis.core.ds;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class IDequeTest {

    IDeque<Integer> iDeque;

    @Before
    public void init()
    {
        iDeque = new IDeque<>(5);
    }

    @Test
    public void idequeTest()
    {
        Assert.assertTrue(iDeque.isEmpty());

        Assert.assertTrue(iDeque.insertFront(5));
        Assert.assertTrue(iDeque.insertFront(4));
        Assert.assertTrue(iDeque.insertRear(1));
        Assert.assertTrue(iDeque.insertRear(2));
        Assert.assertEquals(4,iDeque.getFront().intValue());
        Assert.assertEquals(2,iDeque.getRear().intValue());
        Assert.assertTrue(iDeque.insertFront(3));
        Assert.assertFalse(iDeque.insertFront(7));

        Assert.assertTrue(iDeque.deleteFront());
        Assert.assertTrue(iDeque.deleteRear());

        Assert.assertEquals(4,iDeque.getFront().intValue());
        Assert.assertEquals(1,iDeque.getRear().intValue());
    }
}
