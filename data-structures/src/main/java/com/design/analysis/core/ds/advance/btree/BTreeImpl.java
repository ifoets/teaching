package com.design.analysis.core.ds.advance.btree;

import com.design.analysis.core.ds.advance.btree.node.BTINode;
import com.design.analysis.core.ds.advance.btree.node.BTNode;

public class BTreeImpl implements IBTree<Integer> {

	public BTNode<Integer> root = null;
	public int t = 3;// degree of BTNode

	/* insert in B+Tree/BTree */
	public void splitChild(int i, BTNode<Integer> pt, BTNode<Integer> y) {
		// Create a new node which is going to store (t-1) keys
		// of y
		BTNode<Integer> z = new BTNode<Integer>(y.t, y.isLeaf);
		z.n = t - 1;

		// Copy the last (t-1) keys of y to z
		for (int j = 0; j < t - 1; j++) {
			z.keys[j] = y.keys[j + t];
			y.keys[j + t] = null;
		}

		// Copy the last t children of y to z
		if (!y.isLeaf) {
			for (int j = 0; j < t; j++) {
				z.c[j] = y.c[j + t];
				y.c[j + t] = null;
			}
		}

		// Reduce the number of keys in y

		y.n = t - 1;

		// Since this node is going to have a new child,
		// create space of new child
		for (int j = pt.n; j >= i + 1; j--)
			pt.c[j + 1] = pt.c[j];

		// Link the new child to this node
		pt.c[i + 1] = z;

		// A key of y will move to this node. Find location of
		// new key and move all greater keys one space ahead
		for (int j = pt.n - 1; j >= i; j--)
			pt.keys[j + 1] = pt.keys[j];

		// Copy the middle key of y to this node
		pt.keys[i] = y.keys[t - 1];
		y.keys[t - 1] = null;

		// Increment count of keys in this node
		pt.n = pt.n + 1;
	}

	public BTNode<Integer> insert(BTNode<Integer> node, Integer k) {
		// If tree is empty
		if (node == null) {
			// Allocate memory for root
			node = new BTNode<Integer>(t, true);
			node.keys[0] = new BTINode<Integer>(k); // Insert key
			node.n = 1; // Update number of keys in root
		} else // If tree is not empty
		{
			// If root is full, then tree grows in height
			if (node.n == 2 * t - 1) {
				// Allocate memory for new root
				BTNode<Integer> s = new BTNode<Integer>(t, false);

				// Make old root as child of new root
				s.c[0] = node;

				// Split the old root and move 1 key to the new root
				splitChild(0, s, node);

				// New root has two children now. Decide which of the
				// two children is going to have new key
				int i = 0;
				if (s.keys[0].t < k)
					i++;
				insertNonFull(s.c[i], k);

				// Change root
				node = s;
			} else // If root is not full, call insertNonFull for root
				insertNonFull(node, k);
		}
		return node;
	}

	public void insertNonFull(BTNode<Integer> node, Integer k) {
		// Initialize index as index of rightmost element
		int i = node.n - 1;

		// If this is a leaf node
		if (node.isLeaf) {
			// The following loop does two things
			// a) Finds the location of new key to be inserted
			// b) Moves all greater keys to one place ahead
			while (i >= 0 && node.keys[i].t > k) {
				node.keys[i + 1] = node.keys[i];
				i--;
			}

			// Insert the new key at found location
			node.keys[i + 1] = new BTINode<Integer>(k);
			node.n = node.n + 1;
		} else // If this node is not leaf
		{
			// Find the child which is going to have the new key
			while (i >= 0 && node.keys[i].t > k)
				i--;

			// See if the found child is full
			if (node.c[i + 1].n == 2 * t - 1) {
				// If the child is full, then split it
				splitChild(i + 1, node, node.c[i + 1]);

				// After split, the middle key of C[i] goes up and
				// C[i] is splitted into two. See which of the two
				// is going to have the new key
				if (node.keys[i + 1].t < k)
					i++;
			}
			insertNonFull(node.c[i + 1], k);
		}
	}

	public BTINode<Integer> search(BTNode<Integer> node, int k) {
		// Find the first key greater than or equal to k
		int i = 0;
		while (i < node.n && k > node.keys[i].t)
			i++;

		// If the found key is equal to k, return this node
		if (i < 2 * t - 1 && node.keys[i] != null && node.keys[i].t == k)
			return node.keys[i];

		// If key is not found here and this is a leaf node
		if (node.isLeaf)
			return null;

		// Go to the appropriate child
		return search(node.c[i], k);
	}

	public void display(BTNode<Integer> node) {
		// There are n keys and n+1 children, travers through n keys
		// and first n children
		int i;
		for (i = 0; i < node.n; i++) {
			// If this is not leaf, then before printing key[i],
			// traverse the subtree rooted with child C[i].
			if (!node.isLeaf)
				display(node.c[i]);
			System.out.print(node.keys[i].t + "->");
		}

		// Print the subtree rooted with last child
		if (!node.isLeaf)
			display(node.c[i]);
	}

	/** delete the B-Tree node */
	// A utility function that returns the index of the first key that is
	// greater than or equal to k
	public int findKey(BTNode<Integer> node, int k) {
		int idx = 0;
		while (idx < node.n && node.keys[idx].t < k)
			++idx;
		return idx;
	}

	// A function to remove the idx-th key from this node - which is a leaf node
	public void removeFromLeaf(BTNode<Integer> node, int idx) {

		// Move all the keys after the idx-th pos one place backward
		for (int i = idx + 1; i < node.n; ++i)
			node.keys[i - 1] = node.keys[i];

		// Reduce the count of keys
		node.n--;
		return;
	}

	// A function to get predecessor of keys[idx]
	public int getPred(BTNode<Integer> node, int idx) {
		// Keep moving to the right most node until we reach a leaf
		BTNode<Integer> cur = node.c[idx];
		while (!cur.isLeaf)
			cur = cur.c[cur.n];

		// Return the last key of the leaf
		return cur.keys[cur.n - 1].t;
	}

	// A function to get sucessessor of keys[idx]
	public int getSucc(BTNode<Integer> node, int idx) {

		// Keep moving the left most node starting from C[idx+1] until we reach a leaf
		BTNode<Integer> cur = node.c[idx + 1];
		while (!cur.isLeaf)
			cur = cur.c[0];

		// Return the first key of the leaf
		return cur.keys[0].t;
	}

	// A function to remove the key k from the sub-tree rooted with this node
	public void remove(BTNode<Integer> node, int k) {
		int idx = findKey(node, k);

		// The key to be removed is present in this node
		if (idx < node.n && node.keys[idx].t == k) {

			// If the node is a leaf node - removeFromLeaf is called
			// Otherwise, removeFromNonLeaf function is called
			if (node.isLeaf)
				removeFromLeaf(node, idx);
			else
				removeFromNonLeaf(node, idx);
		} else {

			// If this node is a leaf node, then the key is not present in tree
			if (node.isLeaf) {
				System.out.println(k + " does not exists");
				return;
			}

			// The key to be removed is present in the sub-tree rooted with this node
			// The flag indicates whether the key is present in the sub-tree rooted
			// with the last child of this node
			boolean flag = ((idx == node.n) ? true : false);

			// If the child where the key is supposed to exist has less that t keys,
			// we fill that child
			if (node.c[idx].n < t)
				fill(node, idx);

			// If the last child has been merged, it must have merged with the previous
			// child and so we recurse on the (idx-1)th child. Else, we recurse on the
			// (idx)th child which now has atleast t keys
			if (flag && idx > node.n)
				remove(node.c[idx - 1], k);
			else
				remove(node.c[idx], k);
		}
		return;
	}

	// A function to remove the idx-th key from this node - which is a non-leaf node
	public void removeFromNonLeaf(BTNode<Integer> node, int idx) {

		int k = node.keys[idx].t;

		// If the child that precedes k (C[idx]) has atleast t keys,
		// find the predecessor 'pred' of k in the subtree rooted at
		// C[idx]. Replace k by pred. Recursively delete pred
		// in C[idx]
		if (node.c[idx].n >= t) {
			int pred = getPred(node, idx);
			node.keys[idx].t = pred;
			remove(node.c[idx], pred);
		}

		// If the child C[idx] has less that t keys, examine C[idx+1].
		// If C[idx+1] has atleast t keys, find the successor 'succ' of k in
		// the subtree rooted at C[idx+1]
		// Replace k by succ
		// Recursively delete succ in C[idx+1]
		else if (node.c[idx + 1].n >= t) {
			int succ = getSucc(node, idx);
			node.keys[idx].t = succ;
			remove(node.c[idx + 1], succ);
		}

		// If both C[idx] and C[idx+1] has less that t keys,merge k and all of C[idx+1]
		// into C[idx]
		// Now C[idx] contains 2t-1 keys
		// Free C[idx+1] and recursively delete k from C[idx]
		else {
			merge(node, idx);
			remove(node.c[idx], k);
		}
		return;
	}

	// A function to fill child C[idx] which has less than t-1 keys
	public void fill(BTNode<Integer> node, int idx) {

		// If the previous child(C[idx-1]) has more than t-1 keys, borrow a key
		// from that child
		if (idx != 0 && node.c[idx - 1].n >= t)
			borrowFromPrev(node, idx);

		// If the next child(C[idx+1]) has more than t-1 keys, borrow a key
		// from that child
		else if (idx != node.n && node.c[idx + 1].n >= t)
			borrowFromNext(node, idx);

		// Merge C[idx] with its sibling
		// If C[idx] is the last child, merge it with with its previous sibling
		// Otherwise merge it with its next sibling
		else {
			if (idx != node.n)
				merge(node, idx);
			else
				merge(node, idx - 1);
		}
		return;
	}

	// A function to borrow a key from C[idx-1] and insert it
	// into C[idx]
	public void borrowFromPrev(BTNode<Integer> node, int idx) {

		BTNode<Integer> child = node.c[idx];
		BTNode<Integer> sibling = node.c[idx - 1];

		// The last key from C[idx-1] goes up to the parent and key[idx-1]
		// from parent is inserted as the first key in C[idx]. Thus, the loses
		// sibling one key and child gains one key

		// Moving all key in C[idx] one step ahead
		for (int i = child.n - 1; i >= 0; --i)
			child.keys[i + 1] = child.keys[i];

		// If C[idx] is not a leaf, move all its child pointers one step ahead
		if (!child.isLeaf) {
			for (int i = child.n; i >= 0; --i)
				child.c[i + 1] = child.c[i];
		}

		// Setting child's first key equal to keys[idx-1] from the current node
		child.keys[0] = node.keys[idx - 1];

		// Moving sibling's last child as C[idx]'s first child
		if (!node.isLeaf)
			child.c[0] = sibling.c[sibling.n];

		// Moving the key from the sibling to the parent
		// This reduces the number of keys in the sibling
		node.keys[idx - 1] = sibling.keys[sibling.n - 1];

		child.n += 1;
		sibling.n -= 1;
	}

	// A function to borrow a key from the C[idx+1] and place
	// it in C[idx]
	public void borrowFromNext(BTNode<Integer> node, int idx) {

		BTNode<Integer> child = node.c[idx];
		BTNode<Integer> sibling = node.c[idx + 1];

		// keys[idx] is inserted as the last key in C[idx]
		child.keys[(child.n)] = node.keys[idx];

		// Sibling's first child is inserted as the last child
		// into C[idx]
		if (!(child.isLeaf))
			child.c[(child.n) + 1] = sibling.c[0];

		// The first key from sibling is inserted into keys[idx]
		node.keys[idx] = sibling.keys[0];

		// Moving all keys in sibling one step behind
		for (int i = 1; i < sibling.n; ++i)
			sibling.keys[i - 1] = sibling.keys[i];

		// Moving the child pointers one step behind
		if (!sibling.isLeaf) {
			for (int i = 1; i <= sibling.n; ++i)
				sibling.c[i - 1] = sibling.c[i];
		}

		// Increasing and decreasing the key count of C[idx] and C[idx+1]
		// respectively
		child.n += 1;
		sibling.n -= 1;

		return;
	}

	// A function to merge C[idx] with C[idx+1]
	// C[idx+1] is freed after merging
	public void merge(BTNode<Integer> node, int idx) {
		BTNode<Integer> child = node.c[idx];
		BTNode<Integer> sibling = node.c[idx + 1];

		// Pulling a key from the current node and inserting it into (t-1)th
		// position of C[idx]
		child.keys[t - 1] = node.keys[idx];

		// Copying the keys from C[idx+1] to C[idx] at the end
		for (int i = 0; i < sibling.n; ++i)
			child.keys[i + t] = sibling.keys[i];

		// Copying the child pointers from C[idx+1] to C[idx]
		if (!child.isLeaf) {
			for (int i = 0; i <= sibling.n; ++i)
				child.c[i + t] = sibling.c[i];
		}

		// Moving all keys after idx in the current node one step before -
		// to fill the gap created by moving keys[idx] to C[idx]
		for (int i = idx + 1; i < node.n; ++i)
			node.keys[i - 1] = node.keys[i];

		// Moving the child pointers after (idx+1) in the current node one
		// step before
		for (int i = idx + 2; i <= node.n; ++i)
			node.c[i - 1] = node.c[i];

		// Updating the key count of child and the current node
		child.n += sibling.n + 1;
		node.n--;

		// Freeing the memory occupied by sibling
		// delete(sibling);
		sibling = null;
		return;
	}
}
