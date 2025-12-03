package com.design.analysis.ds.binary.tree.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeUtilsTest {


    @Test
    public void inorderTest()
    {
        int[] a ={5,3,7,4,2,6,8};
        BinaryTreeUtils.inorder(BinaryTreeUtils.createBinarySearchTree(a));

        List<Integer> list  = new ArrayList<>();
        list.add(1);
        list.add(null);
        list.add(2);
        list.add(3);
        BinaryTreeUtils.inorder(BinaryTreeUtils.createBinarySearchTree(list));
    }
}
