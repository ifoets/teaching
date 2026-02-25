package com.design.analysis.ds.linked.list.easy;

import com.design.analysis.ds.node.ListNode;

public interface IListEasy {

    /**141. Linked List Cycle**/
    boolean hasCycle(ListNode head);

    /**21. Merge Two Sorted Lists**/
    ListNode mergeTwoLists(ListNode list1, ListNode list2);

    /**83. Remove Duplicates from Sorted List**/
    ListNode deleteDuplicates(ListNode head);

    /**160. Intersection of Two Linked Lists**/
    ListNode getIntersectionNode(ListNode headA, ListNode headB);

    /**203. Remove Linked List Elements**/
    ListNode removeElements(ListNode head, int val);

    /**206. Reverse Linked List**/
    ListNode reverseList(ListNode head);

    /**234. Palindrome Linked List**/
    boolean isPalindrome(ListNode head);
}
