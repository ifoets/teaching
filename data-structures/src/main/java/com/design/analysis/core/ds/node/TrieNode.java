package com.design.analysis.core.ds.node;

public class TrieNode {

	public TrieNode child[];
	public boolean isLeaf;

	public TrieNode(int size) {
		super();
		this.isLeaf = false;
		child = new TrieNode[size];
		for (int i = 0; i < size; i++)
			this.child[i] = null;
	}
}
