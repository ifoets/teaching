package com.design.analysis.core.ds.advance.btree;

import java.util.List;

import com.design.analysis.core.ds.node.BTNode;

public interface IBinaryTree {

	public BTNode createBstIndex(BTNode node, int dt, int index);
	
	public BTNode createBst(BTNode node, int dt);
	
	public BTNode createBstDuplicate(BTNode node, int dt);
	
	public List<BTNode> printVertical(BTNode node); //facebook interview qun
	
	public int height(BTNode node);
	
	public void print(BTNode node);

	public BTNode insert(BTNode node, int[] arr, int l, int r);

	public BTNode create(BTNode node, int dt);

	public BTNode findInsertPostion(BTNode node);

	public void preOrder(BTNode node);

	public void inOrder(BTNode node);

	public void postOrder(BTNode node);

	public void levelPrint(BTNode node);

	public void lavelOrderPrint(BTNode node);

	public void printGivenLevel(BTNode root, int level);

	public void spiralLevelPrint(BTNode node);

	public void printSpiralLevel(BTNode root, int level, boolean ltr);

	public boolean recursveSearch(BTNode node, int element);
	
	public BTNode recvSearch(BTNode node, int element);
	
	public void deleteCompletly(BTNode node);
	
	public int count(BTNode node);

	public BTNode delete(BTNode node, int key);

	public BTNode mirrorTree(BTNode node);

	public void printAllPath(BTNode node);

	public void printPatWise(BTNode node, int[] path, int size);

	public void printPath(int[] path, int size);

	public void treeListRecursion(BTNode node);

	public List<BTNode> arrangeNode(List<BTNode> list, BTNode node);

	public int countLeafNode(BTNode node);

	public boolean isChildrenSum(BTNode node);

	public BTNode makeChildrenSun(BTNode node);

	public int dimeter(BTNode node);

	public boolean isHeightBalance(BTNode node);

	public boolean rootToLeavPathSum(BTNode node, int number);

	public boolean pathWiseSum(BTNode node, int[] path, int size, int number);

	public boolean validate(int[] a, int size, int element);

	public BTNode doubleBTree(BTNode node);

	public int getMaxWidth(BTNode node);

	public int getWidth(BTNode node, int level);

	public boolean isFoldable(BTNode node);

	public boolean leftRightFoldable(BTNode a, BTNode b);

	public void printAllKthNodesFromRoot(BTNode node, int k);

	public int levelOfNode(BTNode node, int k);

	public int getLevelUtil(BTNode node, int data, int level);

	public boolean ancestor(BTNode node, int data);

	public int isSumTree(BTNode node);

	public int sum(BTNode node);
	
	public void distoryTree();

	public BTNode inorderSuccessor(BTNode node, int key, boolean isMax);

	public BTNode inorderPredecessor(BTNode node, int key, boolean isMin);
	
	public BTNode image(BTNode node);
}
