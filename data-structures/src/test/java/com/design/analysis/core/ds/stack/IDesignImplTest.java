package com.design.analysis.core.ds.stack;

/*
Design and Implementation :
1.	Implement Queue using Stacks
2.	Design and Implement Special Stack Data Structure | Added Space Optimized Version
3.	Implement two stacks in an array
4.	Implement Stack using Queues
5.	Design a stack with operations on middle element
6.	How to efficiently implement k stacks in a single array?
7.	How to create mergable stack?
8.	Design a stack that supports getMin() in O(1) time and O(1) extra space
9.	Implement a stack using single queue
10.	How to implement stack using priority queue or heap?
11.	Create a customized data structure which evaluates functions in O(1)
*/
import com.design.analysis.core.ds.node.SLNode;
import com.design.analysis.core.ds.queue.node.QNode;
import com.design.analysis.core.ds.stackqueue.node.QToSNode;
import com.design.analysis.core.ds.stackqueue.node.SToQNode;
import com.design.analysis.core.ds.stack.node.TwoStackNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IDesignImplTest {

	public IDesignImpl idi = null;
    public DaStack ist = null;

	@Before
	public void init() {
		idi = new DesignImplImpl();
        ist = new DaStack();
	}

	/** 1. Implement Queue using Stacks **/

    @Test
    public void pushTest()
    {
        int a[] = {1,2,3,4,5};
        for(int i=0;i<a.length;i++)
        {
            SLNode head = ist.push(a[i]);
        }
        System.out.println(ist.head);
    }
    @Test
    public  void queueOprTest() throws Exception
    {
        SToQNode qNode = new SToQNode();
        idi.enQueue(qNode,1);
        idi.enQueue(qNode,2);
        idi.enQueue(qNode,3);
        idi.enQueue(qNode,4);
        idi.enQueue(qNode,5);
        idi.enQueue(qNode,6);
        idi.enQueue(qNode,7);
       Assert.assertTrue(idi.dQueue(qNode)==1);
       Assert.assertTrue(idi.dQueue(qNode)==2);
    }
    /*3.Implement two stacks in an array*/
    @Test
    public void twoStackImplTest()
    {
        TwoStackNode twoStackNode = new TwoStackNode(7);
        twoStackNode.push1(1);
        twoStackNode.push1(2);
        twoStackNode.push1(3);
        twoStackNode.push1(7);

        twoStackNode.push2(4);
        twoStackNode.push2(5);
        twoStackNode.push2(6);

        Assert.assertTrue(twoStackNode.pop1()==7);
        Assert.assertTrue(twoStackNode.pop2()==6);
    }

    @Test
    public void stackUsingQueue()
    {
        QToSNode<Integer> qToSNode = idi.stackUsingQueue(5);
        qToSNode.push(1);
        qToSNode.push(2);
        qToSNode.push(3);
        qToSNode.push(4);
        qToSNode.push(5);
        qToSNode.push(6);

        Assert.assertTrue(qToSNode.peek()==6);
        Assert.assertTrue(qToSNode.pop()==6);
        Assert.assertTrue(qToSNode.pop()==5);

    }
}
