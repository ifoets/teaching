package com.design.analysis.ds.linked.list.easy;

import com.design.analysis.ds.node.ListNode;

public class ListEasyImpl implements IListEasy{

    /**141. Linked List Cycle**/
    @Override
    public boolean hasCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;

        if(head==null||head.next==null)return false;
        while (fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return true;
        }
        return false;
    }

    /**21. Merge Two Sorted Lists**/
    @Override
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode head = new ListNode();
        ListNode tail=head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) tail.next = list1;
        if (list2 != null) tail.next = list2;
        return head.next;
    }

    /**83. Remove Duplicates from Sorted List**/
    @Override
    public ListNode deleteDuplicates(ListNode head){
        ListNode node = head;

        while (node!=null&&node.next!=null)
        {
            if(node.val==node.next.val)
                node.next=node.next.next;
            else node=node.next;
        }
        return head;
    }

    /**160. Intersection of Two Linked Lists**/
    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){

        int d1=0,d2=0;
        ListNode h1 = headA;
        ListNode h2 = headB;
        while (h1!=null)
        {
            d1++;
            h1=h1.next;
        }
        while (h2!=null)
        {
            d2++;
            h2=h2.next;
        }
        h1=headA;
        h2=headB;
        if(d1>d2)
        {
            int d=d1-d2;
            while (d-->0)
                h1=h1.next;
        }else {
                int d=d2-d1;
                while (d-->0)
                    h2=h2.next;
            }

        while(h1!=null&&h2!=null)
        {
            if(h1==h2)
                return h1;
            h1=h1.next;
            h2=h2.next;
        }
        return null;
    }

    /**203. Remove Linked List Elements**/
    @Override
    public ListNode removeElements(ListNode head, int val){
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }
    /**206. Reverse Linked List**/
    @Override
    public ListNode reverseList(ListNode head){
        if(head==null||head.next==null)
            return head;
        ListNode newNode = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newNode;
    }
    /**234. Palindrome Linked List**/
    @Override
    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverseList(slow);

        ListNode p1 = head;
        ListNode p2 = secondHalf;
        while (p2 != null) {   // only need to check second half
            if (p1.val != p2.val) return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        reverseList(secondHalf);
        return true;
    }
}
