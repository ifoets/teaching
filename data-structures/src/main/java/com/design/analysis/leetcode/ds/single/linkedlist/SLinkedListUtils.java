package com.design.analysis.leetcode.ds.single.linkedlist;

import com.design.analysis.leetcode.ds.node.SLNode;

import java.util.List;

public class SLinkedListUtils {

    public static <K> SLNode<K> getList(List<K> list)
    {
        SLNode<K> head=null,tail=null;
        for (K k:list)
        {
            if(head==null)
            {
                head = tail= new SLNode<>(k,null);
            }
            else {
                tail.next = new SLNode<>(k,null);
                tail = tail.next;
            }
        }
        return head;
    }
    public static <K> void printSList(SLNode<K> k)
    {
        SLNode<K> head = k;
        while (head!=null)
        {
            System.out.print(head.k+"->");
            head=head.next;
        }
    }

    public static <K> SLNode<K> reverse(SLNode<K> k)
    {
        if(k==null || k.next == null)
            return k;
        SLNode<K> newNode = reverse(k.next);
        k.next.next=k;
        k.next=null;
        return newNode;
    }

    public static <K> int length(SLNode<Integer> k)
    {
        int count=0;
        SLNode<Integer> head = k;
        while (head!=null)
        {
            count++;
            head=head.next;
        }
        return count;
    }
}
