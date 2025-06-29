package com.design.analysis.leetcode.ds.single.linkedlist;

import com.design.analysis.leetcode.ds.node.SLNode;

public interface ISLinkedList<K> {

    /**2. Add Two Numbers, The digits are stored in reverse order, and each of their nodes contains a single digit**/
    SLNode<K> addTwoNumbers(SLNode<K> l1, SLNode<K> l2);
    /**Non reversed no*/
    SLNode<K> addTwoNoReversedNumbers(SLNode<K> l1, SLNode<K> l2);

    /**19. Remove Nth Node From End of List*/
    SLNode<K> removeNthFromEnd(SLNode<K> l1, int n);

    /**21. Merge Two Sorted Lists, space efficient, not use extra space**/
    SLNode<K> mergeTwoLists(SLNode<K> l1,SLNode<K> l2);
}
