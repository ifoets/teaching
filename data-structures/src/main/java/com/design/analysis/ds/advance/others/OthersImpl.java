package com.design.analysis.ds.advance.others;

import java.util.ArrayList;
import java.util.List;

import com.design.analysis.ds.advance.others.node.TernaryNode;

public class OthersImpl implements IOthers<Character, Integer> {

	/** 1. Palindromic Tree | Introduction & Implementation **/

	/** 2. Ternary Search Tree **/
	TernaryNode<Integer> root = null;

	@Override
	public TernaryNode<Character> insert(TernaryNode<Character> node, Character[] word, int ptr) {
		if (node == null)
			node = new TernaryNode<>(word[ptr]);

		if (word[ptr] < node.dt)
			node.lt = insert(node.lt, word, ptr);

		else if (word[ptr] > node.dt)
			node.rt = insert(node.rt, word, ptr);

		else {
			if (ptr + 1 < word.length)
				node.eq = insert(node.eq, word, ptr + 1);
			else {
				node.isEnd = true;
			}
		}
		return node;
	}

	public List<String> resultList = new ArrayList<>();

	@Override
	public void traverse(TernaryNode<Character> node, String str) {
		if (node != null) {
			traverse(node.lt, str);
			str += node.dt;
			if (node.isEnd == true) {
				System.out.println(str);
				resultList.add(str);
			}
			traverse(node.eq, str);
			str = str.substring(0, str.length() - 1);
			traverse(node.rt, str);
		}

	}

	@Override
	public boolean search(TernaryNode<Character> node, Character[] word, int ptr) {

		if (node == null)
			return false;
		if (word[ptr] < node.dt)
			return search(node.lt, word, ptr);
		else if (word[ptr] > node.dt)
			return search(node.rt, word, ptr);
		else {
			if (node.isEnd && ptr == word.length - 1)
				return true;
			else if (ptr == word.length - 1)
				return false;
			return search(node.eq, word, ptr + 1);
		}
	}

	@Override
	public void delete(TernaryNode<Character> node, Character word[], int ptr) {
		if (node == null)
			return;
		if (word[ptr] < node.dt)
			delete(node.lt, word, ptr);
		else if (word[ptr] > node.dt)
			delete(node.rt, word, ptr);
		else {
			if (node.isEnd && ptr == word.length - 1)
				node.isEnd = false;
			else if (ptr < word.length - 1)
				delete(node.eq, word, ptr + 1);
		}
	}

}
