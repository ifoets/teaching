package com.design.analysis.core.ds.stackqueue.node;

import com.design.analysis.core.ds.node.Stack;
import com.design.analysis.core.ds.queue.node.QNode;
import com.design.analysis.core.ds.stack.node.SNode;

import java.util.Arrays;

public class QToSNode<E> {

   public QNode<E> qNode1;
   public QNode<E> qNode2;

   public QToSNode(QNode<E> qNode1,QNode<E> qNode2)
   {
       this.qNode1 = qNode1;
       this.qNode2 = qNode2;
   }

    public void push(E e)
    {
        while (!qNode1.isEmpty())
            qNode2.add(qNode1.poll());
        qNode1.add(e);
        while (!qNode2.isEmpty())
            qNode1.add(qNode2.poll());
    }
    public E pop()
    {
        if(qNode1.isEmpty())
            throw  new RuntimeException("Queue is under flow");
        return (E)qNode1.poll();
    }
    public E peek()
    {
        if(qNode1.isEmpty())
            throw  new RuntimeException("Queue is under flow");
        return (E)qNode1.peek();
    }
    public void display()
    {
        qNode1.display();
    }
}
