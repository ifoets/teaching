package com.design.analysis.leetcode.ds.single.linkedlist;

import com.design.analysis.leetcode.ds.single.linkedlist.node.SLNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class SLinkedListUtilsTest {

    @Test
    public void printSListTest()
    {
        List<Integer> list = List.of(1,2,3,4,5);
        SLNode<Integer> head = SLinkedListUtils.getList(list);
        SLinkedListUtils.printSList(head);
        Assert.assertEquals(1,(int)head.k);
        Assert.assertEquals(2,(int)head.next.k);
    }

    @Test
    public void reverseTest()
    {
        List<Integer> list = List.of(1,2,3,4,5);
        SLNode<Integer> head = SLinkedListUtils.reverse(SLinkedListUtils.getList(list));
        SLinkedListUtils.printSList(head);
        Assert.assertEquals(5,(int)head.k);
        Assert.assertEquals(4,(int)head.next.k);
    }

    @Test
    public void lengthTest()
    {
        List<Integer> list = List.of(1,2,3,4,5);
        Assert.assertEquals(5,SLinkedListUtils.length(SLinkedListUtils.getList(list)));
    }
}
