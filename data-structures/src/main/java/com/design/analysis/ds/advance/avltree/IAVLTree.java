package com.design.analysis.ds.advance.avltree;

import com.design.analysis.ds.node.AVLTNode;

public interface IAVLTree {

	public int height(AVLTNode node);

	public AVLTNode insert(AVLTNode node, int dt);

	public AVLTNode rightRotate(AVLTNode y);

	public AVLTNode leftRotate(AVLTNode x);

	public int getBalance(AVLTNode node);

	public AVLTNode minValueNode(AVLTNode node);

	public AVLTNode deleteNode(AVLTNode node, int key);

}
