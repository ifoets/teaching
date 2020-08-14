package com.design.analysis.ds.advance.trie.node;

/*
 * 
 * @author GuruG
 * UniquePrefixTrieNode used for finding the unique frequency in of string in dictonary
 */
public class UqPrTrieNode {
	public static final int MAX = 256;
	// Maximum length of an input word
	static final int MAX_WORD_LEN = 500;
	public UqPrTrieNode child[];
	public int frq;

	public UqPrTrieNode() {
		this.frq = 1;
		this.child = new UqPrTrieNode[MAX];
		for (int i = 0; i < MAX; i++)
			this.child[i] = null;
	}
}
