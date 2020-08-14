package com.design.analysis.ds.advance.threaded.bst;

import com.design.analysis.ds.node.STBstNode;

public interface ISThreadBst<T> {
//TODO
	public STBstNode<T> createSThreadBst(STBstNode<T> node, int dt);

	public STBstNode<T> leftMostNode(STBstNode<T> node);

	public STBstNode<T> rightMostNode(STBstNode<T> node);

	public void display(STBstNode<T> node);

}
