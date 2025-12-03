package com.design.analysis.ds.heap.priority.queue.hard;

import com.design.analysis.ds.linked.list.Utils.ListUtils;
import com.design.analysis.ds.node.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IPriorityQueueHardTest {

    IPriorityQueueHard ipqh;

    @Before
    public void init()
    {
        ipqh = new PriorityQueueHardImpl();
    }

    /**23. Merge k Sorted Lists**/
    @Test
    public void mergeKListsTest()
    {
        int [][]a={
            {1,4,5},
            {1,3,4},
            {2,6}
        };
        int[] b={1,1,2,3,4,4,5,6};
        ListNode[] nodes = new ListNode[a.length];
        for (int i = 0; i<nodes.length; nodes[i]=ListUtils.createList(a[i]),i++);

        ListNode result = ipqh.mergeKLists(nodes);
        ListNode expList = ListUtils.createList(b);
        ListUtils.print(result);
        while (result!=null&&expList!=null)
        {
            Assert.assertEquals(result.val,expList.val);
            result = result.next;
            expList = expList.next;
        }
        Assert.assertEquals(result,expList);

        int[] c={-2,-1,-1,-1};
        ListNode[] xyz = new ListNode[1];
        xyz[0] = ListUtils.createList(c);
        ListNode result1 = ipqh.mergeKLists(xyz);
        ListUtils.print(result1);
    }

}
