package com.design.analysis.ds.advance.btree;

import com.design.analysis.ds.node.BTNode;

public interface ISpecialBinaryTree {

	public BTNode create(BTNode node, int dt);

	public BTNode findInsertPostion(BTNode node, int index);

	public void levelPrint(BTNode node);

	public void columnWsiePrint(BTNode node);
}
