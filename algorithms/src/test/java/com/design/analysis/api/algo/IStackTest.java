package com.design.analysis.api.algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IStackTest {

    private IStack<Integer> iStack =null;

    @Before
    public void init()
    {
        iStack = new StackImpl<>();
    }

@Test
public void stackOprTest()
{
    for (int i=0;i<10;iStack.push(i),i++);
    iStack.traverse();
    Assert.assertTrue(iStack.peek()==9);
    Assert.assertTrue(iStack.pop()==9);
    Assert.assertTrue(iStack.pop()==8);
    iStack.push(1);
    iStack.push(6);
    iStack.push(9);
    iStack.push(2);
    Assert.assertTrue(iStack.pop()==2);
    Assert.assertTrue(iStack.pop()==9);
    Assert.assertTrue(iStack.pop()==6);
;}

}
