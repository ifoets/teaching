package com.design.analysis.ds.linkd.list.utils;

import com.design.analysis.ds.linked.list.Utils.ListUtils;
import com.design.analysis.ds.node.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ListUtilsTest {

    @Test
    public void createListTest()
    {
        int []a={1,2,3};
        ListUtils.print(ListUtils.createList(a));
    }
    @Test
    public void reverseTest()
    {
        int[]a ={1,2,3,4,5,6,7,8,9};
        int[]r ={9,8,7,6,5,4,3,2,1};
        ListNode revList = ListUtils.reverse(ListUtils.createList(a));
        ListUtils.print(revList);
        ListNode rList = ListUtils.createList(r);
        while (rList!=null&&revList!=null)
        {
            Assert.assertEquals(rList.val,revList.val);
            rList = rList.next;
            revList = revList.next;
        }
        Assert.assertEquals(rList,revList);
    }
}
