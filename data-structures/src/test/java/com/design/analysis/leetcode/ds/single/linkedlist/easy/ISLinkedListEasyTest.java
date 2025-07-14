package com.design.analysis.leetcode.ds.single.linkedlist.easy;

import com.design.analysis.leetcode.ds.single.linkedlist.node.SLNode;
import com.design.analysis.leetcode.ds.single.linkedlist.SLinkedListUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ISLinkedListEasyTest {

    private ISLinkedListEasy<Integer> isle;

    @Before
    public void init()
    {
        isle = new SLinkedListEasyImpl();
    }

    @Test
    public void mergeTwoListsTest()
    {
        //[1,2,4], list2 = [1,3,4]
        List<Integer> l1= List.of(1,2,4);
        List<Integer> l2 = List.of(1,3,4);
        List<Integer> expected = List.of(1,1,2,3,4,4);
        SLNode<Integer> head = isle.mergeTwoLists(SLinkedListUtils.getList(l1),SLinkedListUtils.getList(l2));
        SLinkedListUtils.printSList(head);
        System.out.println();
        int i=0;
        while (head!=null)
        {
            Assert.assertEquals(expected.get(i++),head.k);
            head = head.next;
        }

        List<Integer> l3= List.of(1,2,4);
        head = isle.mergeTwoLists(null,SLinkedListUtils.getList(l3));
        i=0;
        while (head!=null)
        {
            Assert.assertEquals(l3.get(i++),head.k);
            head = head.next;
        }
        List<Integer> l10= List.of(5);
        List<Integer> l20 = List.of(1,2,4);
        SLNode<Integer> head10 = isle.mergeTwoLists(SLinkedListUtils.getList(l10),SLinkedListUtils.getList(l20));
        SLinkedListUtils.printSList(head10);
        System.out.println();
        SLNode<Integer> head11 = isle.mergeTwoLists(SLinkedListUtils.getList(l20),SLinkedListUtils.getList(l10));
        SLinkedListUtils.printSList(head11);

        List<Integer> l11 = List.of(-9,-7,-3,-3,-1,2,3);
        List<Integer> l21 = List.of(-7,-7,-6,-6,-5,-3,2,4);
        SLinkedListUtils.printSList(isle.mergeTwoLists(SLinkedListUtils.getList(l11),SLinkedListUtils.getList(l21)));
    }
}
