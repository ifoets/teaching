package com.design.analysis.core.ds.queue.node;

import java.util.Arrays;

public class QNode<E> {

    public int size;
    public Object[] qa;
    public int head;
    public int tail;

    public QNode (int n)
    {
        this.size = n;
        qa = new Object[size];
        head = tail = 0;
    }
    public void add(E e)
    {
        if(tail==size)
        {
            int newSize = size*2;
            Object[] newArr = Arrays.copyOf(qa, size);
            qa = new Object[newSize];
            for (int i = 0; i<size; qa[i]=newArr[i], i++);
            size = newSize;
        }
        qa[tail++]=e;
    }
   public E poll(){
       if(tail==0)
           throw new RuntimeException("Queue is under flow");
       E ne = (E)qa[head];
       shift(head,qa);
       tail--;
       return ne;
   }
   public E peek(){
       if(tail==0)
           throw new RuntimeException("Queue is under flow");
       return (E)qa[head];
   }

   public  void shift(int i,Object[] obj){
        for(int e=i;e<tail-1;e++)
        {
            obj[e]=obj[e+1];
        }
   }
 public boolean isEmpty()
 {
     return tail==0;
 }
    public void display()
    {
        System.out.println(Arrays.toString(qa));
    }
}
