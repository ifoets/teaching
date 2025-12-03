package com.design.analysis.ds.binary.tree.medium;

import com.design.analysis.ds.node.TreeNode;

import java.util.List;

public interface IBinaryTreeMedium {

    /**95. Unique Binary Search Trees II**/
    List<TreeNode> generateTrees(int n);

    List<TreeNode> generateTreesX(int n);

    /**96. Unique Binary Search Trees**/
    int numTrees(int n);

    /**98. Validate Binary Search Tree**/
    boolean isValidBST(TreeNode root);

    /**99. Recover Binary Search Tree**/
    void recoverTree(TreeNode root);
}
