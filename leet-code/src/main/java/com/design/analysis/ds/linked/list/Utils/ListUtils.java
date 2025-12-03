package com.design.analysis.ds.linked.list.Utils;

import com.design.analysis.ds.node.ListNode;

public class ListUtils {

    public static ListNode createList(int[] a)
    {
        ListNode head = null;
        ListNode tail = null;
        for (int j : a) {
            if (tail == null)
                head = tail = new ListNode(j);
            else {
                tail.next = new ListNode(j);
                tail = tail.next;
            }
        }
        return head;
    }

    public static int len(ListNode node)
    {
        if(node==null)
            return 0;
        return 1+len(node.next);
    }
    public static ListNode reverse(ListNode node)
    {
        if(node==null || node.next==null)
            return node;
        ListNode newNode = reverse(node.next);
        node.next.next = node;
        node.next=null;
        return newNode;
    }
    public static void print(ListNode head)
    {
        while (head!=null)
        {
            System.out.print(head.val+"->");
            head=head.next;
        }
    }
}
