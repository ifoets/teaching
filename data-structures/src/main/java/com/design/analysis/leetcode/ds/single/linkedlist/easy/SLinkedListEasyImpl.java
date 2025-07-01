package com.design.analysis.leetcode.ds.single.linkedlist.easy;

import com.design.analysis.leetcode.ds.node.SLNode;

public class SLinkedListEasyImpl implements ISLinkedListEasy<Integer>{

    @Override
    public /**21. Merge Two Sorted Lists, space efficient, not use extra space**/
    SLNode<Integer> mergeTwoLists(SLNode<Integer> l1, SLNode<Integer> l2){

        SLNode<Integer> head = new SLNode<>(0,null);
        SLNode<Integer> tail = head;

        while (l1!=null && l2!=null)
        {
            if(l1.k<l2.k)
            {
                tail.next=l1;
                l1=l1.next;
            }else {
                tail.next=l2;
                l2=l2.next;
            }
            tail = tail.next;
        }
        //append reaming node
        if(l1!=null)tail.next=l1;
        if(l2!=null)tail.next=l2;
        return head.next;
    }
}
