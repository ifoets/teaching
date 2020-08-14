package com.design.analysis.ds.advance.trie.node;

import java.util.ArrayList;
import java.util.List;

public class CamelCaseTrieNode {

	public CamelCaseTrieNode child[];
	public boolean isLeaf;
	public List<String> word;

	public CamelCaseTrieNode(int size) {
		super();
		this.isLeaf = false;
		child = new CamelCaseTrieNode[size];
		for (int i = 0; i < size; i++)
			this.child[i] = null;
		word = new ArrayList<>();
	}
}
