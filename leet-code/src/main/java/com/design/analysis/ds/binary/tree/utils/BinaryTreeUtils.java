package com.design.analysis.ds.binary.tree.utils;

import com.design.analysis.ds.node.TreeNode;

import java.util.List;
import java.util.Objects;

public class BinaryTreeUtils {

    public static TreeNode createBinarySearchTree(int[] a)
    {
          TreeNode root = null;
        for (int j : a) root = createBst(root, j);

        return root;
    }
    public static TreeNode createBinarySearchTree(List<Integer> list)
    {
        TreeNode root = null;
        for (Integer j : list)
        {
            if(Objects.nonNull(j)) {
                root = createBst(root, j);
            }
        }

        return root;
    }
    public static TreeNode createBst(TreeNode root, int val)
    {
        if(Objects.isNull(root))
            return new TreeNode(val);
        else if(val<root.val)
            root.lt = createBst(root.lt,val);
        else
            root.rt = createBst(root.rt,val);
        return root;
    }

    public static void inorder(TreeNode node)
    {
        if(Objects.nonNull(node))
        {
            System.out.print(node.val+"->");
            inorder(node.lt);
            inorder(node.rt);
        }
    }

    public static void preorder(TreeNode node)
    {
        if(Objects.nonNull(node))
        {
            inorder(node.lt);
            System.out.print(node.val+"->");
            inorder(node.rt);
        }
    }
}
