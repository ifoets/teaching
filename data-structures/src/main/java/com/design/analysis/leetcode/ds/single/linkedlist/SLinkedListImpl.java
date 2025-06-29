package com.design.analysis.leetcode.ds.single.linkedlist;

import com.design.analysis.leetcode.ds.node.SLNode;

import java.util.List;

public class SLinkedListImpl implements ISLinkedList<Integer> {

    /**
     * 2. Add Two Numbers, The digits are stored in reverse order, and each of their nodes contains a single digit
     **/
    @Override
    public SLNode<Integer> addTwoNumbers(SLNode<Integer> l1, SLNode<Integer> l2) {
        SLNode<Integer> head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int k1 = l1 != null ? l1.k : 0;
            int k2 = l2 != null ? l2.k : 0;
            var value = (k1 + k2 + carry) % 10;
            if (head == null)
                head = tail = new SLNode<>(value, null);
            else {
                tail.next = new SLNode<>(value, null);
                tail = tail.next;
            }
            if (l1 != null) {
                l1 = l1.next;
                if (l2 != null)
                    l2 = l2.next;
                carry = (k1 + k2 + carry) / 10;
            }
        }
        if(carry!=0)
            tail.next = new SLNode<>(carry, null);
        return head;
    }

    @Override
   public SLNode<Integer> addTwoNoReversedNumbers(SLNode<Integer> l1, SLNode<Integer> l2){
        return SLinkedListUtils.reverse(addTwoNumbers(SLinkedListUtils.reverse(l1),SLinkedListUtils.reverse(l2)));
    }

    @Override
    public SLNode<Integer> removeNthFromEnd(SLNode<Integer> l1, int n){
        SLNode<Integer> head = l1;
        int lenFromFirst = SLinkedListUtils.length(l1)-n;
        if(lenFromFirst<0)
            return l1;
        if(lenFromFirst==0)//delete head node
        {
            l1=l1.next;
            head.next=null;
            head=null;
        }
        for(int i=1;i<lenFromFirst;i++){
            if(head!=null)
            {
               head = head.next;
            }
        }
        if(head!=null && head.next!=null)
        {
            SLNode<Integer> delNode = head.next;
            head.next=delNode.next;
            delNode.next=null;
        }

        return l1;
    }

    @Override
    public /**21. Merge Two Sorted Lists, space efficient, not use extra space**/
    SLNode<Integer> mergeTwoLists(SLNode<Integer> l1,SLNode<Integer> l2){

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
