package com.design.analysis.core.ds.advance.trie;

import java.util.List;

import com.design.analysis.core.ds.advance.trie.node.CamelCaseTrieNode;
import com.design.analysis.core.ds.advance.trie.node.PhoneTrieNode;
import com.design.analysis.core.ds.advance.trie.node.SuffixTrieNode;
import com.design.analysis.core.ds.advance.trie.node.TrieNode;
import com.design.analysis.core.ds.advance.trie.node.UqPrTrieNode;

public class TrieUtil {

	public static int ALPHABET_SIZE = 26;

	public static int charToIinex(char c) {
		return (int) c - (int) 'a';
	}

	public static int charToIinexCamelCase(char c) {
		return (int) c - (int) 'A';
	}

	/* checking no child exists for even other node */
	public static boolean isItFreeNode(TrieNode node) {
		int i;
		for (i = 0; i < ALPHABET_SIZE; i++) {
			if (node.child[i] != null)
				return false;
		}
		return true;
	}

	public static boolean leafNode(TrieNode node) {
		return node.isLeaf;
	}

	/* deleting utils if none of key depends on its path */
	public static boolean deleteTrieUtil(TrieNode node, char key[], int level, int len) {

		if (node != null) {// Base case
			if (level == len) {
				if (node.isLeaf) {
					// Unmark leaf node
					node.isLeaf = false;
					// If empty, node to be deleted
					if (isItFreeNode(node))
						return true;
					return false;
				}
			} else // Recursive case
			{
				int index = charToIinex(key[level]);

				if (deleteTrieUtil(node.child[index], key, level + 1, len)) {
					// last node marked, delete it
					node.child[index] = null;
					// recursively climb up, and delete eligible nodes
					return (!leafNode(node) && isItFreeNode(node));
				}
			}
		}
		return false;
	}

	/* insert in suffix by suffix util */
	public static SuffixTrieNode insertSuffixUtil(SuffixTrieNode node, String s, int index) {
		// Store index in linked list
		node.indexes.add(index);

		// If string has more characters
		if (s.length() > 0) {

			// Find the first character
			char cIndex = s.charAt(0);

			// If there is no edge for this character,
			// add a new edge
			if (node.children[cIndex] == null)
				node.children[cIndex] = new SuffixTrieNode();

			// Recur for next suffix
			node.children[cIndex] = insertSuffixUtil(node.children[cIndex], s.substring(1), index + 1);
		}
		return node;
	}

	/* search utils */
	public static List<Integer> searchUtil(SuffixTrieNode node, String s) {

		// If all characters of pattern have been
		// processed,
		if (s.length() == 0)
			return node.indexes;

		// if there is an edge from the current node of
		// suffix tree, follow the edge.
		if (node.children[s.charAt(0)] != null)
			return searchUtil(node.children[s.charAt(0)], s.substring(1));

		// If there is no edge, pattern doesnt exist in
		// text
		else
			return null;
	}

	/* utility for find the unidque prefix of a word in dictonary */
	public static List<String> findPrefixesUtil(List<String> rl, UqPrTrieNode root, char[] prefix, int ind,
                                                int inputLen) {
		// Corner case
		if (rl.size() == inputLen)
			return rl;
		if (root != null) {
			// Base case
			if (root.frq == 1) {
				prefix[ind] = '\0';
				int i = 0;
				String str = "";
				while (prefix[i] != '\0')
					str += prefix[i++];
				rl.add(str);
				return rl;
			}

			for (int i = 0; i < UqPrTrieNode.MAX; i++) {
				if (root.child[i] != null) {
					prefix[ind] = (char) i;
					findPrefixesUtil(rl, root.child[i], prefix, ind + 1, inputLen);
				}
			}
		}
		return rl;
	}

	public static int indexs = 0;

	/* utility for find the unidque prefix of a word in dictonary */
	public static int countChildren(TrieNode node) {
		int count = 0;
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			if (node.child[i] != null) {
				count++;
				indexs = i;
			}
		}
		return (count);
	}

	/* Function to print all children of Trie node root */
	public static void printAllWords(CamelCaseTrieNode root) {

		// if current node is leaf
		if (root.isLeaf) {
			for (String str : root.word)
				System.out.println(str);
		}

		// recurse for all children of root node
		for (int i = 0; i < ALPHABET_SIZE; i++) {
			CamelCaseTrieNode child = root.child[i];
			if (child != null)
				printAllWords(child);
		}
	}

	/* utility used to display the searched contact */
	public static void displayPhoneContactsUtil(PhoneTrieNode curNode, String prefix) {

		if (curNode.isLast)
			System.out.println(prefix);

		for (char i = 'a'; i <= 'z'; i++) {
			PhoneTrieNode nextNode = curNode.child.get(i);
			if (nextNode != null) {
				displayPhoneContactsUtil(nextNode, prefix + i);
			}
		}
	}

}
