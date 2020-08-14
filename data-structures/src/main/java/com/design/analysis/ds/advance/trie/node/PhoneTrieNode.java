package com.design.analysis.ds.advance.trie.node;

/*
 * Each Trie Node contains a Map 'child where each alphabet points to a PhoneTrieNode.
 */
import java.util.HashMap;

public class PhoneTrieNode {

	public HashMap<Character, PhoneTrieNode> child;
	public boolean isLast;

	// Default Constructor
	public PhoneTrieNode() {
		child = new HashMap<Character, PhoneTrieNode>();
		// Initialize all the Trie nodes with NULL
		for (char i = 'a'; i <= 'z'; i++)
			this.child.put(i, null);
		this.isLast = false;
	}
}
