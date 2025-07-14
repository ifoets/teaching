package com.design.analysis.leetcode.ds.single.linkedlist.easy;

import com.design.analysis.leetcode.ds.node.SLNode;

public interface ISLinkedListEasy<K> {


    /**21. Merge Two Sorted Lists, space efficient, not use extra space**/
    SLNode<K> mergeTwoLists(SLNode<K> l1, SLNode<K> l2);
}
