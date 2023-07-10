package com.design.analysis.api.algo;

import java.util.Arrays;
import java.util.Objects;

public class StackImpl<E> implements IStack<E>{

    public  int CAPACITY=10;

    public Object[] stack;

    public int loc=0;

    public void StackImpl() {
        stack = new Object[CAPACITY];
    }

    @Override
    public E push(E e) {
       if(Objects.isNull(stack))
       {
           stack = new Object[CAPACITY];
       }else if(loc==CAPACITY)
       {
           CAPACITY = (int)(3*CAPACITY/2);
           Object[] objArr = new Object[CAPACITY];
          for (int i=0;i<loc;objArr[i]=stack[i],i++);
          stack = objArr;
          objArr = null;
       }
       stack[loc++]=e;
       return e;
    }

    @Override
    public synchronized E pop() {
        if(Objects.isNull(stack))
            throw new RuntimeException("Stack is Empty");
        return (E) stack[(loc--)-1];
    }

    @Override
    public synchronized E peek() {
        if(Objects.isNull(stack))
            throw new RuntimeException("Stack is Empty");
        return (E) stack[loc-1];
    }

    @Override
    public int search(Object obj) {
        if(Objects.isNull(stack))
            throw new RuntimeException("Stack is Empty");
        for(int i=0;i<CAPACITY;i++)
        {
            if(obj.equals(stack[i]))
                return i;
        }
        return -1;
    }

    public void traverse()
    {
        System.out.println(Arrays.toString(stack));
    }
}
