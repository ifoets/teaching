package com.design.analysis.ds.binary.tree.medium;

import com.design.analysis.ds.node.TreeNode;
import com.design.analysis.ds.binary.tree.utils.BinaryTreeUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IBinaryTreeMediumTest {

    IBinaryTreeMedium iBtm;

    @Before
    public void init()
    {
        iBtm = new BinaryTreeMediumImpl();
    }

    @Test
    public void generateTreesTest()
    {
        List<TreeNode> list = iBtm.generateTrees(3);
        Assert.assertEquals(5,list.size());
    }


   /**96. Unique Binary Search Trees**/
   @Test
   public void numTreesTest()
   {
       int[] a = new int[]{2,3,4,5,6};
       int[]b = new int[]{2,5,14,42,132};
      for (int i=0;i<a.length;i++)
       Assert.assertEquals(b[i],iBtm.numTrees(a[i]));

   }

    /**98. Validate Binary Search Tree**/
    @Test
    public void isValidBSTTest()
    {
        int[] a ={5,3,7,4,2,6,8};
        TreeNode root = BinaryTreeUtils.createBinarySearchTree(a);
        Assert.assertTrue(iBtm.isValidBST(root));
        root.lt.lt.lt = new TreeNode(6);
        Assert.assertFalse(iBtm.isValidBST(root));
    }

    /**99. Recover Binary Search Tree**/
    @Test
    public void recoverTreeTest()
    {
        TreeNode root = new TreeNode(1);
        root.lt = new TreeNode(3);
        root.lt.rt = new TreeNode(2);
        BinaryTreeUtils.preorder(root);
        iBtm.recoverTree(root);
        BinaryTreeUtils.preorder(root);
    }
}

