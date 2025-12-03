package com.design.analysis.ds.heap.priority.queue.hard;

import com.design.analysis.ds.node.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueHardImpl implements IPriorityQueueHard {

    /**23. Merge k Sorted Lists**/
    @Override
    public ListNode mergeKLists(ListNode[] lists){
        if(lists==null)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for(ListNode p:lists)
        {
            if(p!=null)pq.add(p);//adding headers of each
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty())
        {
           ListNode min = pq.poll();
           tail.next=min;
           tail=tail.next;
           if(min.next!=null)pq.add(min.next);
        }
        return dummy.next;
    }

}
