package com.design.analysis.core.ds.stack.node;

import java.util.Arrays;

public class SNode<N> {

    public int size;
    public Object[] na;
    public int loc=0;
    public SNode(int size)
    {
        this.size = size;
        na = new Object[size];
    }

    public void push(N n)
    {
        if(loc==size)
        {
            int newSize = size*2;
            Object[] newArr = Arrays.copyOf(na, size);
            na = new Object[newSize];
           for (int i=0;i<size;na[i]=newArr[i], i++);
            size = newSize;
        }
            na[loc++]= n;
    }
    public N pop()
    {
        if(loc>=0)
        {
            N n = (N)na[loc-1];
            loc--;
            return n;
        }
        else throw new RuntimeException("Stack is under flow");
    }
    public N peek()
    {
        if(loc>=0)
            return (N)na[loc-1];
        else
            throw new RuntimeException("Stack is underflow");
    }
    public void display()
    {
        System.out.println(Arrays.toString(na));
    }
}
