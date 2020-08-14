package com.design.analysis.ds.advance.splaytree;

import com.design.analysis.ds.node.SplayTNode;

public class ISplayTreeImpl implements ISplayTree {

	public SplayTNode insert(SplayTNode node, int key) {

		if (node == null)
			return new SplayTNode(key);
		// bring the clogest leaf node to root
		node = splay(node, key);

		if (node.dt == key)// ie node is present at root just have to return
			return node;
		SplayTNode newNode = new SplayTNode(key);
		// below operation is with root node
		if (node.dt > key)// ie root node dt is less than key
		{
			newNode.rt = node;
			newNode.lt = node.lt;
			node.lt = null;
		} // if root node key is less than key
		else {
			newNode.lt = node;
			newNode.rt = node.rt;
			node.rt = null;
		}
		return newNode;
	}

	public SplayTNode rightRotate(SplayTNode y) {

		SplayTNode x = y.lt;
		y.lt = x.rt;
		x.rt = y;
		return x;
	}

	public SplayTNode leftRotate(SplayTNode x) {

		SplayTNode y = x.rt;
		x.rt = y.lt;
		y.lt = x;
		return y;
	}

	public SplayTNode search(SplayTNode node, int key) {

		return splay(node, key);
	}

	// This function brings the key at root if key is present in tree.
	// If key is not present, then it brings the last accessed item at
	// root. This function modifies the tree and returns the new root
	public SplayTNode splay(SplayTNode node, int key) {
		// Base cases: root is NULL or key is present at root
		if (node == null || node.dt == key)
			return node;

		// Key lies in left subtree
		if (node.dt > key) {
			// Key is not in tree, we are done
			if (node.lt == null)
				return node;

			// Zig-Zig (Left Left)
			if (node.lt.dt > key) {
				// First recursively bring the key as root of left-left
				node.lt.lt = splay(node.lt.lt, key);

				// Do first rotation for root, second rotation is done after
				// else
				node = rightRotate(node);
			} else if (node.lt.dt < key) // Zig-Zag (Left Right)
			{
				// First recursively bring the key as root of left-right
				node.lt.rt = splay(node.lt.rt, key);

				// Do first rotation for root->left
				if (node.lt.rt != null)
					node.lt = leftRotate(node.lt);
			}

			// Do second rotation for root
			return (node.lt == null) ? node : rightRotate(node);
		} else // Key lies in right subtree
		{
			// Key is not in tree, we are done
			if (node.rt == null)
				return node;

			// Zig-Zag (Right Left)
			if (node.rt.dt > key) {
				// Bring the key as root of right-left
				node.rt.lt = splay(node.rt.lt, key);

				// Do first rotation for root->right
				if (node.rt.lt != null)
					node.rt = rightRotate(node.rt);
			} else if (node.rt.dt < key)// Zag-Zag (Right Right)
			{
				// Bring the key as root of right-right and do first rotation
				node.rt.rt = splay(node.rt.rt, key);
				node = leftRotate(node);
			}

			// Do second rotation for root
			return (node.rt == null) ? node : leftRotate(node);
		}
	}

	public void preOrder(SplayTNode node) {
		if (node != null) {
			System.out.print(node.dt + "->");
			preOrder(node.lt);
			preOrder(node.rt);
		}
	}

}
