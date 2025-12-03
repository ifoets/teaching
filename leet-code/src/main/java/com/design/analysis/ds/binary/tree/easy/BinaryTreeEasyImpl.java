package com.design.analysis.ds.binary.tree.easy;

import com.design.analysis.ds.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeEasyImpl implements IBinaryTreeEasy{

    /**94. Binary Tree Inorder Traversal**/
    List<Integer> list = new ArrayList<>();
    @Override
    public List<Integer> inorderTraversal(TreeNode root){
        if(Objects.nonNull(root))
        {
            list.add(root.val);
            inorderTraversal(root.lt);
            inorderTraversal(root.rt);
        }
        return list;
    }
}
