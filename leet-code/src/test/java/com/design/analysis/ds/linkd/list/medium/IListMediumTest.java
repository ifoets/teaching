package com.design.analysis.ds.linkd.list.medium;

import com.design.analysis.ds.linked.list.Utils.ListUtils;
import com.design.analysis.ds.linked.list.medium.IListMedium;
import com.design.analysis.ds.linked.list.medium.ListMediumImpl;
import com.design.analysis.ds.node.ListNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IListMediumTest {

    IListMedium ilm;

    @Before
    public void init()
    {
        ilm = new ListMediumImpl();
    }

    /**2. Add Two Numbers, The digits are stored in reverse order*/
    @Test
    public void addTwoNumbersTest()
    {
        int[] l1= {2,4,3};
        int[] l2 = {5,6,4};
        int[] output={ 7,0,8};
        ListNode fHead = ListUtils.createList(l1);
        ListNode sHead = ListUtils.createList(l2);
        ListNode outHead = ListUtils.createList(output);

        ListNode resultHead = ilm.addTwoNumbers(fHead,sHead);
        ListUtils.print(fHead);
        System.out.println();
        ListUtils.print(sHead);
        System.out.println();
        ListUtils.print(outHead);
        while (outHead!=null&&resultHead!=null)
        {
            Assert.assertEquals(outHead.val,resultHead.val);
            outHead = outHead.next;
            resultHead = resultHead.next;
        }
        Assert.assertEquals(outHead,resultHead);
    }
    /**Add two numbers, list is as nos ex 342+465, 3->4->2 + 4->6->5 = 8->0->7**/
    @Test
    public void addTwoNumbersAsItInListTest()
    {
        int[] la ={9,9,9,9,9,9,9};
        int[] lb ={9,9,9,9};
        int[] rb={1,0,0,0,9,9,9,8};
        ListNode l1 = ListUtils.createList(la);
        ListNode l2 = ListUtils.createList(lb);
        ListNode add = ilm.addTwoNumbersAsItInList(l1,l2);
        ListNode expAdd = ListUtils.createList(rb);
        ListUtils.print(add);
        System.out.println();
        ListUtils.print(expAdd);
        while (add!=null&&expAdd!=null)
        {
            Assert.assertEquals(add.val,expAdd.val);
            add = add.next;
            expAdd = expAdd.next;
        }
        Assert.assertEquals(add,expAdd);
    }

    /**19. Remove Nth Node From End of List**/
    @Test
    public void removeNthFromEndTest()
    {
        int[]a ={1,2,3,4,5};
        int[] b = {1,2,3,5};
        ListNode delHead = ilm.removeNthFromEnd(ListUtils.createList(a),2);
        ListNode expRs = ListUtils.createList(b);

        ListUtils.print(delHead);
        System.out.println();
        ListUtils.print(expRs);
        while (delHead!=null&&expRs!=null)
        {
            Assert.assertEquals(delHead.val,expRs.val);
            delHead = delHead.next;
            expRs = expRs.next;
        }
        Assert.assertEquals(delHead,expRs);
    }

    /**24. Swap Nodes in Pairs**/
    @Test
    public void swapPairsTest()
    {
        int[]a ={1,2,3,4,5};
        int[] b = {2,1,4,3,5};
        ListNode swapList = ilm.swapPairs(ListUtils.createList(a));
        ListUtils.print(swapList);
        ListNode swapExpList = ListUtils.createList(b);
        while (swapList!=null&&swapExpList!=null)
        {
            Assert.assertEquals(swapList.val,swapExpList.val);
            swapList = swapList.next;
            swapExpList = swapExpList.next;
        }
        Assert.assertEquals(swapList,swapExpList);
    }

    /**reverse list in part wise, n=2 pairwise, n=k,in k nodes**/
    @Test
    public void reverseInSlotNTest()
    {
        int[]a ={1,2,3,4,5,6,7,8,9,10,11};
        int[] b = {3,2,1,6,5,4,9,8,7,11,10};
        ListNode swapList = ilm.reverseInSlotN(ListUtils.createList(a),3);
        ListNode expList = ListUtils.createList(b);
        ListUtils.print(swapList);
        while (swapList!=null&&expList!=null)
        {
            Assert.assertEquals(swapList.val,expList.val);
            swapList = swapList.next;
            expList = expList.next;
        }
        Assert.assertEquals(swapList,expList);
    }
    /**61. Rotate List k from right1,2,3,4,5-> 4,5,1,2,3**/
    @Test
    public void rotateRightTest()
    {
        int []a={1,2,3,4,5};
        int [] b={4,5,1,2,3};
        ListNode swapList = ilm.rotateRight(ListUtils.createList(a),2);
        ListNode expList = ListUtils.createList(b);
        ListUtils.print(swapList);
        while (swapList!=null&&expList!=null)
        {
            Assert.assertEquals(swapList.val,expList.val);
            swapList = swapList.next;
            expList = expList.next;
        }
        Assert.assertEquals(swapList,expList);
    }
    /**. Rotate List k from Left, k=2, 1,2,3,4,5-> 3,4,5,1,2**/
    @Test
    public void rotateLeftTest()
    {
        int []a={1,2,3,4,5};
        int [] b={4,5,1,2,3};
        ListNode swapList = ilm.rotateLeft(ListUtils.createList(a),3);
        ListNode expList = ListUtils.createList(b);
        ListUtils.print(swapList);
        while (swapList!=null&&expList!=null)
        {
            Assert.assertEquals(swapList.val,expList.val);
            swapList = swapList.next;
            expList = expList.next;
        }
        Assert.assertEquals(swapList,expList);
    }

    /**82. Remove Duplicates from Sorted List II**/
    @Test
    public void deleteDuplicatesTest()
    {
        int []a={1,2,3,3,4,4,5};
        int [] b={1,2,5};
        ListNode duplicates = ilm.deleteDuplicates(ListUtils.createList(a));
        ListNode expList = ListUtils.createList(b);
        ListUtils.print(duplicates);
       while (duplicates!=null&&expList!=null)
        {
            Assert.assertEquals(duplicates.val,expList.val);
            duplicates = duplicates.next;
            expList = expList.next;
        }
        Assert.assertEquals(duplicates,expList);
    }
}
