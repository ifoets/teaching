package com.design.analysis.core.ds.advance.btree;

import com.design.analysis.core.ds.node.BTNode;

public interface IAvlBSTree {

	public BTNode create(BTNode node, int dt);

	public void levelPrint(BTNode node);

	public void spirialPrintLeft(BTNode node);

	public void spiralPrintRight(BTNode node);

	public BTNode leftRotate(BTNode x);

	public BTNode rightRotate(BTNode y);

	public int height(BTNode node);

	public int max(int x, int y);

	public int balance(BTNode node);
	
	public void inorderPrint(BTNode node);
}