package com.design.analysis.ds.node;

import java.util.Objects;

public class TreeNode {

    public int val;
    public TreeNode lt, rt;

    public TreeNode(int val)
    {
        this.val = val;
        this.lt = this.rt = null;
    }
    public TreeNode(int val, TreeNode lt, TreeNode rt)
    {
        this.val = val;
        this.lt = lt;
        this.rt = rt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(lt, treeNode.lt) && Objects.equals(rt, treeNode.rt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, lt, rt);
    }
}
