package com.design.analysis.core.ds.advance.trie;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.core.ds.advance.trie.node.CamelCaseTrieNode;
import com.design.analysis.core.ds.advance.trie.node.PhoneTrieNode;
import com.design.analysis.core.ds.advance.trie.node.SuffixTrieNode;
import com.design.analysis.core.ds.advance.trie.node.TrieNode;
import com.design.analysis.core.ds.advance.trie.node.UqPrTrieNode;

//TODO nothing has been done here ...check it properly TODO? right
public class ITrieImpl implements ITrie {

	@Override
	public TrieNode insert(TrieNode node, String key) {
		TrieNode root = node;
		int level;
		int len = key.length();
		int index;
		if (node == null)
			root = node = new TrieNode(ALPHABET_SIZE);
		for (level = 0; level < len; level++) {
			index = TrieUtil.charToIinex(key.charAt(level));
			if (node.child[index] == null)
				node.child[index] = new TrieNode(ALPHABET_SIZE);
			node = node.child[index];
		}
		node.isLeaf = true;
		return root;
	}

	@Override
	public boolean search(TrieNode node, String key) {
		TrieNode root = node;
		int level;
		int len = key.length();
		int index;

		for (level = 0; level < len; level++) {
			index = TrieUtil.charToIinex(key.charAt(level));
			if (root != null && root.child[index] == null)
				return false;
			root = root.child[index];
		}
		return (root != null && root.isLeaf);
	}

	/** 2. Trie | (Delete) **/

	@Override
	public TrieNode delete(TrieNode node, String key) {

		TrieNode root = node;
		char keys[] = key.toCharArray();
		int len = keys.length;

		if (len > 0) {
			if (TrieUtil.deleteTrieUtil(root, keys, 0, len)) {
				System.out.println(key + ": is deleted");
			} else
				System.out.println(key + ": deleted but complete delete not possible due to dependency");
		}
		return root;
	}

	/** 3. Longest prefix matching � A Trie based solution in Java **/
	@Override
	public String longestPrefixInDict(TrieNode node, String key) {
		String str = "";
		TrieNode root = node;
		int level;
		int len = key.length();
		int index;

		for (level = 0; level < len; level++) {
			index = TrieUtil.charToIinex(key.charAt(level));
			if (root != null && root.child[index] == null)
				return str;
			else {
				str += key.charAt(level);
				root = root.child[index];
			}
		}
		return str;
	}

	/** 4. Pattern Searching using a Trie of all Suffixes **/
	public SuffixTrieNode insertSuffix(String txt) {

		SuffixTrieNode root = new SuffixTrieNode();
		for (int i = 0; i < txt.length(); i++)
			TrieUtil.insertSuffixUtil(root, txt.substring(i), i);
		return root;
	}

	public List<Integer> searchAllSuffix(SuffixTrieNode node, String pattern) {
		return TrieUtil.searchUtil(node, pattern);
	}

	/** 5. Find shortest unique prefix for every word in a given list **/
	public UqPrTrieNode insertUniquePrefix(UqPrTrieNode node, String str) {
		// Length of the URL
		int len = str.length();
		if (node == null)
			node = new UqPrTrieNode();
		UqPrTrieNode pCrawl = node;

		// Traversing over the length of given str.
		for (int level = 0; level < len; level++) {
			// Get index of child node from current character
			// in str.
			int index = str.charAt(level);

			// Create a new child if not exist already
			if (pCrawl.child[index] == null)
				pCrawl.child[index] = new UqPrTrieNode();
			else
				(pCrawl.child[index].frq)++;

			// Move to the child
			pCrawl = pCrawl.child[index];
		}
		return node;
	}

	@Override
	public List<String> shortestCommonUniquePrefix(UqPrTrieNode node, String[] keys) {
		UqPrTrieNode root = null;
		if (node == null) {
			root = new UqPrTrieNode();
			root.frq = 0;
			for (int i = 0; i < keys.length; i++)
				root = insertUniquePrefix(root, keys[i]);
		} else
			root = node;
		char[] prefix = new char[256];
		List<String> rl = new ArrayList<>();
		return TrieUtil.findPrefixesUtil(rl, root, prefix, 0, keys.length);
	}

	/** 6. Longest Common Prefix **/
	@Override
	public String loggestCommonUniquePrefix(TrieNode node, String[] keys) {

		TrieNode root = null;
		if (node == null) {
			root = new TrieNode(ALPHABET_SIZE);

			for (int i = 0; i < keys.length; i++)
				root = insert(root, keys[i]);
		} else
			root = node;

		TrieNode pCrawl = root;
		String prefix = "";

		while (TrieUtil.countChildren(pCrawl) == 1 && pCrawl.isLeaf == false) {
			pCrawl = pCrawl.child[TrieUtil.indexs];
			prefix += (char) ('a' + TrieUtil.indexs);
		}
		return prefix;

	}

	/** 7. Print all words matching a pattern in CamelCase Notation Dictonary **/
	public CamelCaseTrieNode insertCamelCaseDict(CamelCaseTrieNode node, String key) {

		CamelCaseTrieNode root = node;
		int level;
		int len = key.length();
		int index;
		if (node == null)
			root = node = new CamelCaseTrieNode(ALPHABET_SIZE);
		for (level = 0; level < len; level++) {

			// consider only uppercase characters
			if (Character.isLowerCase(key.charAt(level)))
				continue;

			index = TrieUtil.charToIinexCamelCase(key.charAt(level));
			if (node.child[index] == null)
				node.child[index] = new CamelCaseTrieNode(ALPHABET_SIZE);
			node = node.child[index];
		}
		node.isLeaf = true;
		// push word into vector associated with leaf node
		(node.word).add(key);
		return root;
	}

	public boolean searchPatternInCamelCaseDict(CamelCaseTrieNode root, String str) {

		int index;
		CamelCaseTrieNode node = root;
		int len = str.length();

		for (int level = 0; level < len; level++) {
			index = str.charAt(level) - 'A';
			// Invalid pattern
			if (node.child[index] == null)
				return false;

			node = node.child[index];
		}
		// print all words matching that pattern
		TrieUtil.printAllWords(node);
		return true;
	}

	/** 8. Implement a Phone Directory **/
	@Override
	public PhoneTrieNode insertIntoPhoneTrie(String contacts[]) {

		PhoneTrieNode root = new PhoneTrieNode();
		int n = contacts.length;
		for (int i = 0; i < n; i++) {
			String s = contacts[i];
			int len = s.length();
			PhoneTrieNode itr = root;
			for (int j = 0; j < len; j++) {
				PhoneTrieNode nextNode = itr.child.get(s.charAt(j));
				if (nextNode == null) {
					nextNode = new PhoneTrieNode();
					itr.child.put(s.charAt(j), nextNode);
				}
				itr = nextNode;
				if (j == len - 1)
					itr.isLast = true;
			}
		}
		return root;
	}

	@Override
	public void displayPhoeContacts(PhoneTrieNode root, String str) {

		PhoneTrieNode prevNode = root;
		String prefix = "";
		int len = str.length();

		int i;
		for (i = 0; i < len; i++) {
			// 'str' stores the string entered so far
			prefix += str.charAt(i);
			char lastChar = prefix.charAt(i);
			PhoneTrieNode curNode = prevNode.child.get(lastChar);

			if (curNode == null) {
				System.out.println("nNo Results Found for " + prefix + "");
				i++;
				break;
			}
			System.out.println("nSuggestions based on " + prefix + " are");
			TrieUtil.displayPhoneContactsUtil(curNode, prefix);
			prevNode = curNode;
		}

		for (; i < len; i++) {
			prefix += str.charAt(i);
			System.out.println("nNo Results Found for " + prefix + "");
		}
	}
}
