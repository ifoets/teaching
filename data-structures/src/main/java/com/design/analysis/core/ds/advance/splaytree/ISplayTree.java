package com.design.analysis.core.ds.advance.splaytree;

import com.design.analysis.core.ds.node.SplayTNode;

public interface ISplayTree {

	public SplayTNode insert(SplayTNode node, int key);

	public SplayTNode rightRotate(SplayTNode y);

	public SplayTNode leftRotate(SplayTNode x);

	public SplayTNode search(SplayTNode node, int key);

	public SplayTNode splay(SplayTNode node, int key);

	public void preOrder(SplayTNode node);
}
