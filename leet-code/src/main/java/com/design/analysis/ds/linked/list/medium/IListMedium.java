package com.design.analysis.ds.linked.list.medium;

import com.design.analysis.ds.node.ListNode;

public interface IListMedium {

    /**2. Add Two Numbers, The digits are stored in reverse order*/
    ListNode addTwoNumbers(ListNode l1, ListNode l2);
    /**Add two numbers, list is as nos ex 342+465, 3->4->2 + 4->6->5 = 8->0->7**/
    ListNode addTwoNumbersAsItInList(ListNode l1, ListNode l2);

    /**19. Remove Nth Node From End of List**/
    ListNode removeNthFromEnd(ListNode head, int n);

    /**24. Swap Nodes in Pairs**/
    ListNode swapPairs(ListNode head);

    /**reverse list in part wise, n=2 pairwise, n=k,in k nodes**/
    ListNode reverseInSlotN(ListNode head, int n);

    /**61. Rotate List k from right, k=2,1,2,3,4,5-> 4,5,1,2,3**/
    ListNode rotateRight(ListNode head, int k);
    /**. Rotate List k from Left, k=2, 1,2,3,4,5-> 3,4,5,1,2**/
    ListNode rotateLeft(ListNode head, int k);

    /**82. Remove Duplicates from Sorted List II**/
    ListNode deleteDuplicates(ListNode head);
}
