package com.design.analysis.leetcode.ds.single.linkedlist.medium;

import com.design.analysis.leetcode.ds.node.SLNode;
import com.design.analysis.leetcode.ds.single.linkedlist.SLinkedListUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ISLinkedListMediumTest {

    private ISLinkedListMedium<Integer> islm;

    @Before
    public void init()
    {
      islm = new SLinkedListMediumImpl();
    }

    /**2. Add Two Numbers, The digits are stored in reverse order, and each of their nodes contains a single digit**/
    @Test
    public void addTwoNumbersTest()
    {
        List<Integer> l1 = List.of(2,4,3);
        List<Integer> l2 = List.of(5,6,4);
        SLNode<Integer> head = islm.addTwoNumbers(SLinkedListUtils.getList(l1),SLinkedListUtils.getList(l2));
        SLNode<Integer> expected =  SLinkedListUtils.getList(List.of(7,0,8));
        while (head!=null)
        {
            Assert.assertEquals(expected.k,head.k);
            head=head.next;
            expected=expected.next;
        }
        Assert.assertNull(head);
        Assert.assertNull(expected);
    }

    @Test
    public void addTwoNoReversedNumbersTest()
    {
        List<Integer> l1 = List.of(9,9,9,9,9,9);
        List<Integer> l2 = List.of(9,9,9);
        List<Integer> result = List.of(1,0,0,0,9,9,8);
        SLNode<Integer> head = islm.addTwoNoReversedNumbers(SLinkedListUtils.getList(l1),SLinkedListUtils.getList(l2));
        SLinkedListUtils.printSList(head);
        int i=0;
        while (head!=null)
        {
            Assert.assertEquals(result.get(i++),head.k);
            head=head.next;
        }
    }

    @Test
    public void removeNthFromEndTest()
    {
        List<Integer> l = List.of(1,2,3,4,5,6,7,8,9);
        SLNode<Integer> head = SLinkedListUtils.getList(l);
        head = islm.removeNthFromEnd(head,1);
        Assert.assertEquals(8,SLinkedListUtils.length(head));
        SLinkedListUtils.printSList(head);
        System.out.println();
        head = islm.removeNthFromEnd(head,8);
        SLinkedListUtils.printSList(head);
        System.out.println();
        Assert.assertEquals(2,(int)head.k);
        head = islm.removeNthFromEnd(head,3);
        SLinkedListUtils.printSList(head);
        System.out.println();
        Assert.assertEquals(6,SLinkedListUtils.length(head));
        head = islm.removeNthFromEnd(head,7);
        SLinkedListUtils.printSList(head);
        Assert.assertEquals(6,SLinkedListUtils.length(head));
    }
}
