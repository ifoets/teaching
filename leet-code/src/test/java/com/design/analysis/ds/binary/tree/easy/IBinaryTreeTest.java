package com.design.analysis.ds.binary.tree.easy;

import com.design.analysis.ds.binary.tree.medium.IBinaryTreeMedium;
import com.design.analysis.ds.binary.tree.medium.IBinaryTreeMediumTest;
import com.design.analysis.ds.binary.tree.utils.BinaryTreeUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IBinaryTreeTest {

    IBinaryTreeEasy iBte;

    @Before
    public void init()
    {
        iBte = new BinaryTreeEasyImpl();
    }

    @Test
    public void inorderTraversalTest()
    {
        int[] a ={5,3,7,4,2,6,8};
        List<Integer> rsList = iBte.inorderTraversal(BinaryTreeUtils.createBinarySearchTree(a));
        System.out.println(rsList.toString());
    }
}
