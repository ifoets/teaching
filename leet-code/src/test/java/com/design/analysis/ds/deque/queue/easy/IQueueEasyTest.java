package com.design.analysis.ds.deque.queue.easy;

import com.design.analysis.ds.deque.queue.easy.IQueueEasy;
import com.design.analysis.ds.deque.queue.easy.QueueEasyImpl;
import com.design.analysis.ds.deque.queue.easy.fundamental.QueueUsingStack;
import com.design.analysis.ds.deque.queue.easy.fundamental.StackUsingQueue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IQueueEasyTest {

    IQueueEasy iqe;

    @Before
    public void init()
    {
        iqe = new QueueEasyImpl();
    }

    /**225. Implement Stack using Queues**/
    @Test
    public void impStackUsingQueueTest(){
        StackUsingQueue suq = new StackUsingQueue();
        String[] commands={"push","push","pop","top","empty"};
        int[] values={1,2,0,0,0};
        int[] exp={-1,-1,2,1,1};
        for(int i=0;i<commands.length;i++)
            Assert.assertEquals(exp[i],iqe.impStackUsingQueue(suq,commands[i],values[i]));
    }

    /**232. Implement Queue using Stacks**/
    @Test
    public void impQueueUsingStackTest(){
        QueueUsingStack qus = new QueueUsingStack();
        String[] commands={"push","push","pop","top","empty"};
        int[] values={1,2,0,0,0};
        int[] exp={-1,-1,1,2,1};
        for(int i=0;i<commands.length;i++)
            Assert.assertEquals(exp[i],iqe.impQueueUsingStack(qus,commands[i],values[i]));
    }
}
