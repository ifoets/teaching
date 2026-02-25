package com.design.analysis.ds.linkd.list;

import com.design.analysis.ds.linked.list.Utils.ListUtils;
import com.design.analysis.ds.linked.list.easy.IListEasy;
import com.design.analysis.ds.linked.list.easy.ListEasyImpl;
import com.design.analysis.ds.node.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IListEasyTest {

    IListEasy ile;

    @Before
    public void init()
    {
        ile = new ListEasyImpl();
    }

    /**141. Linked List Cycle**/
    @Test
    public void hasCycleTest()
    {
        int[] a ={3,2,0,-4};
        ListNode head = ListUtils.createList(a);
        Assert.assertFalse(ile.hasCycle(head));

        ListNode tail =  head;
        while (tail.next!=null)tail=tail.next;
        if(head.next!=null) {
            tail.next = head.next.next;
        }
        Assert.assertTrue(ile.hasCycle(head));

    }
    /**21. Merge Two Sorted Lists**/
    @Test
    public void mergeTwoListsTest()
    {
        int[]l1 = {1,2,4};
        int[]l2 = {1,3,4};
        int[] expL= {1,1,2,3,4,4};
        ListNode list1 = ListUtils.createList(l1);
        ListNode list2 = ListUtils.createList(l2);
        ListNode expList = ListUtils.createList(expL);

        ListNode list = ile.mergeTwoLists(list1,list2);
        while (list!=null)
        {
            Assert.assertEquals(expList.val,list.val);
            list=list.next;
            expList=expList.next;
        }
    }

    /**83. Remove Duplicates from Sorted List**/
    @Test
    public void deleteDuplicatesTest()
    {
        int[]input = {1,1,2,3,3};
        int[]output ={1,2,3};
        ListNode head = ile.deleteDuplicates(ListUtils.createList(input));
        ListNode expHead = ListUtils.createList(output);

        while (head!=null)
        {
            Assert.assertEquals(expHead.val,head.val);
            head=head.next;
            expHead=expHead.next;
        }
    }

    /**160. Intersection of Two Linked Lists**/
    @Test
    public void getIntersectionNodeTest()
    {
        int[] a = {4,1,8,4,5};
        int[]b = {5,6,1};
        ListNode listA = ListUtils.createList(a);
        ListNode listB = ListUtils.createList(b);
        listB.next.next.next=listA.next.next;

        ListNode expList = ile.getIntersectionNode(listA,listB);
        Assert.assertEquals(8,expList.val);
    }
    /**203. Remove Linked List Elements**/
    @Test
    public void removeElementsTest()
    {
      int[]a ={1,2,6,3,4,5,6};
      ListNode list = ile.removeElements(ListUtils.createList(a),6);
      ListNode expList = ListUtils.createList(new int[]{1,2,3,4,5});
        while (list!=null)
        {
            Assert.assertEquals(expList.val,list.val);
            list=list.next;
            expList=expList.next;
        }
    }

    /**206. Reverse Linked List**/
    @Test
    public void reverseListTest(){
        int[] input = {1,2,3,4,5};
        int[] output = {5,4,3,2,1};

        ListNode list = ile.reverseList(ListUtils.createList(input));
        ListNode expList = ListUtils.createList(output);

        while (list!=null)
        {
            Assert.assertEquals(expList.val,list.val);
            list=list.next;
            expList=expList.next;
        }
    }

    /**234. Palindrome Linked List**/
    @Test
    public void isPalindromeTest()
    {
       int[] a ={1,2,3,4,3,2,1};
       ListNode list = ListUtils.createList(a);
       Assert.assertTrue(ile.isPalindrome(list));
    }
}
