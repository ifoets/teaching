package com.design.analysis.leetcode.ds.single.linkedlist.medium;

import com.design.analysis.leetcode.ds.single.linkedlist.node.SLNode;

public interface ISLinkedListMedium<K> {

    /**2. Add Two Numbers, The digits are stored in reverse order, and each of their nodes contains a single digit**/
    SLNode<K> addTwoNumbers(SLNode<K> l1, SLNode<K> l2);
    /**Non reversed no*/
    SLNode<K> addTwoNoReversedNumbers(SLNode<K> l1, SLNode<K> l2);

    /**19. Remove Nth Node From End of List*/
    SLNode<K> removeNthFromEnd(SLNode<K> l1, int n);
}
