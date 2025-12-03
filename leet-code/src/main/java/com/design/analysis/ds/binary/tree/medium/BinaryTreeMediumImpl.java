package com.design.analysis.ds.binary.tree.medium;

import com.design.analysis.ds.node.TreeNode;
import com.design.analysis.ds.binary.tree.utils.BinaryTreeUtils;

import java.util.*;
import java.util.stream.IntStream;

public class BinaryTreeMediumImpl implements IBinaryTreeMedium{

    /**95. Unique Binary Search Trees II**/
    public List<TreeNode> generateTrees(int n){
        int[] numbs = IntStream.rangeClosed(1,n).toArray();
        List<List<Integer>> list =permutation(numbs);

        Set<TreeNode> set = new HashSet<>();
        for (List<Integer> l:list)
            set.add(BinaryTreeUtils.createBinarySearchTree(l));
        return new ArrayList<>(set);
    }

    private List<List<Integer>> permutation(int[] nums)
    {
        int N = nums.length;
        boolean[] used = new boolean[N];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp =new ArrayList<>();
        backtrack(nums,used,result,temp);
        return result;
    }
    private void backtrack(int[]nums,boolean[] used,List<List<Integer>> rs,List<Integer> temp)
    {
        if(temp.size()==nums.length)
        {
            rs.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i])continue;
            used[i]=true;
            temp.add(nums[i]);
            backtrack(nums,used,rs,temp);
            temp.removeLast(); //backtrack
            used[i]=false;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<TreeNode> generateTreesX(int n){

        List<TreeNode>[] result = new ArrayList[n+1];
        result[0] = new ArrayList<>();
        if(n==0) return result[0];

        result[0].add(null);
        for(int len=1;len<=n;len++)
        {
            result[len] = new ArrayList<>();
            for (int j=0;j<n;j++)
            {
                for(TreeNode lNode:result[j])
                {
                    for(TreeNode rNode:result[n-j-1])
                    {
                        TreeNode node = new TreeNode(j+1);
                        node.lt = lNode;
                        node.rt = rightShiftValueClone(rNode,j+1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }
    private TreeNode rightShiftValueClone(TreeNode n, int offset)
    {
        if(n==null)
            return n;
        TreeNode node = new TreeNode(n.val+offset);
        node.lt = rightShiftValueClone(node.lt,offset);
        node.rt = rightShiftValueClone(node.rt,offset);
        return node;
    }

    /**96. Unique Binary Search Trees**/
    @Override
    public int numTrees(int n){
       int[] uniqTree = new int[n + 1];
        Arrays.fill(uniqTree,1);

        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;
            for (int root = 1; root <= nodes; root++) {
                total += uniqTree[root - 1] * uniqTree[nodes - root];
            }
            uniqTree[nodes] = total;
        }
        return uniqTree[n];
    }

    /**98. Validate Binary Search Tree**/
    int minVal = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root){
       if(Objects.isNull(root)) return true;
       if(!isValidBST(root.lt))return false;
       if(minVal>=root.val)return false;
       minVal = root.val;
        return isValidBST(root.rt);
    }

    /**99. Recover Binary Search Tree**/
    @Override
    public void recoverTree(TreeNode root) {

        /*List<Integer> list = new ArrayList<>();
        preorder(root, list);
        int lf = 0;
        int rt = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                lf = i;
                break;
            }
        }

        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) < list.get(i - 1)) {
                rt = i;
                break;
            }
        }
        Collections.swap(list,lf,rt);
        preorderSwap(root,list,0);*/
        preorder(root,null,null);
    }
    public int preorderSwap(TreeNode node,List<Integer> list, int i)
    {
        if (node == null) return i;
        // LEFT
        i = preorderSwap(node.lt, list, i);
        // ROOT
        if (node.val != list.get(i)) {
            node.val = list.get(i);
        }
        i++; // move to next index
        // RIGHT
        return preorderSwap(node.rt, list, i);
    }

    public void preorder(TreeNode node, TreeNode first,TreeNode last)
    {
        if(Objects.nonNull(node))
        {
            preorder(node.lt,first,last);
            if(first!=null && last!=null)
            {
               int temp = first.val;
               first.val = last.val;
               last.val=temp;
            }
            if(first==null)
            {
                if(node.lt!=null&&node.lt.val> node.val)
                    first=node.lt;
                if(node.rt!=null && node.rt.val< node.val)
                    first=node.rt;
            }
            else {
                if(node.lt!=null&&node.lt.val> node.val)
                    last=node.lt;
                if(node.rt!=null && node.rt.val< node.val)
                    last=node.rt;
            }
            preorder(node.rt,first,last);

        }
    }
}
