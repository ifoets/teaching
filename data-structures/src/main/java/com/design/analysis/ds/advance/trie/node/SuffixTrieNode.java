package com.design.analysis.ds.advance.trie.node;

import java.util.LinkedList;
import java.util.List;

public class SuffixTrieNode {

	final static int MAX_CHAR = 256;

	public SuffixTrieNode[] children = new SuffixTrieNode[MAX_CHAR];
	public List<Integer> indexes;

	public SuffixTrieNode() {
		indexes = new LinkedList<Integer>();
		for (int i = 0; i < MAX_CHAR; i++)
			children[i] = null;
	}
}
