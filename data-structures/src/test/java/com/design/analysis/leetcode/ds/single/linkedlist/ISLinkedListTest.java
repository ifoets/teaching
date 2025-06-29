package com.design.analysis.leetcode.ds.single.linkedlist;

import com.design.analysis.leetcode.ds.node.SLNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ISLinkedListTest {

    private ISLinkedList<Integer> isl;

    @Before
    public void init()
    {
        isl = new SLinkedListImpl();
    }

    /**2. Add Two Numbers, The digits are stored in reverse order, and each of their nodes contains a single digit**/
    @Test
    public void addTwoNumbersTest()
    {
        List<Integer> l1 = List.of(2,4,3);
        List<Integer> l2 = List.of(5,6,4);
        SLNode<Integer> head = isl.addTwoNumbers(SLinkedListUtils.getList(l1),SLinkedListUtils.getList(l2));
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
        SLNode<Integer> head = isl.addTwoNoReversedNumbers(SLinkedListUtils.getList(l1),SLinkedListUtils.getList(l2));
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
       head = isl.removeNthFromEnd(head,1);
        Assert.assertEquals(8,SLinkedListUtils.length(head));
       SLinkedListUtils.printSList(head);
        System.out.println();
        head = isl.removeNthFromEnd(head,8);
        SLinkedListUtils.printSList(head);
        System.out.println();
        Assert.assertEquals(2,(int)head.k);
        head = isl.removeNthFromEnd(head,3);
        SLinkedListUtils.printSList(head);
        System.out.println();
        Assert.assertEquals(6,SLinkedListUtils.length(head));
        head = isl.removeNthFromEnd(head,7);
        SLinkedListUtils.printSList(head);
        Assert.assertEquals(6,SLinkedListUtils.length(head));
    }

    @Test
    public void mergeTwoListsTest()
    {
        //[1,2,4], list2 = [1,3,4]
        List<Integer> l1= List.of(1,2,4);
        List<Integer> l2 = List.of(1,3,4);
        List<Integer> expected = List.of(1,1,2,3,4,4);
        SLNode<Integer> head = isl.mergeTwoLists(SLinkedListUtils.getList(l1),SLinkedListUtils.getList(l2));
        SLinkedListUtils.printSList(head);
        System.out.println();
        int i=0;
        while (head!=null)
        {
            Assert.assertEquals(expected.get(i++),head.k);
            head = head.next;
        }

        List<Integer> l3= List.of(1,2,4);
        head = isl.mergeTwoLists(null,SLinkedListUtils.getList(l3));
        i=0;
        while (head!=null)
        {
            Assert.assertEquals(l3.get(i++),head.k);
            head = head.next;
        }
        List<Integer> l10= List.of(5);
        List<Integer> l20 = List.of(1,2,4);
        SLNode<Integer> head10 = isl.mergeTwoLists(SLinkedListUtils.getList(l10),SLinkedListUtils.getList(l20));
        SLinkedListUtils.printSList(head10);
        System.out.println();
        SLNode<Integer> head11 = isl.mergeTwoLists(SLinkedListUtils.getList(l20),SLinkedListUtils.getList(l10));
        SLinkedListUtils.printSList(head11);

        List<Integer> l11 = List.of(-9,-7,-3,-3,-1,2,3);
        List<Integer> l21 = List.of(-7,-7,-6,-6,-5,-3,2,4);
        SLinkedListUtils.printSList(isl.mergeTwoLists(SLinkedListUtils.getList(l11),SLinkedListUtils.getList(l21)));
    }
}
