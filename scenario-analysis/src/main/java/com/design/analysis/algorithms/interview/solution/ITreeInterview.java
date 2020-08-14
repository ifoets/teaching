package com.design.analysis.algorithms.interview.solution;

import com.design.analysis.algorithms.interview.node.TNode;

public interface ITreeInterview<T> {
	/**
	 * creating a complete binary tree having child as 1,2,3,4...so on and give the
	 * result of L, X, Y L level, X positoin in X travel and Y ...X to Y travel
	 */

	public TNode<T> creazyTree(int l);

	public TNode<T> connectToRightNode(TNode<T> node);

	public TNode<T> fillData(TNode<T> node);

	public void print(TNode<T> node);

	public int query(int N, int X, int Y);
}
