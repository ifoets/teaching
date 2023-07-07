package com.design.analysis.core.ds.advance.avltree;

import com.design.analysis.core.ds.node.AVLTNode;
import com.design.analysis.core.ds.utils.DSUtil;

public class AVLTreeImpl implements IAVLTree {

	@Override
	public int height(AVLTNode node) {
		return node == null ? 0 : node.height;
	}

	@Override
	public AVLTNode insert(AVLTNode node, int dt) {

		if (node == null)
			return new AVLTNode(dt);

		if (dt < node.dt)
			node.lt = insert(node.lt, dt);
		else if (dt > node.dt)
			node.rt = insert(node.rt, dt);
		else
			return node;// duplicate key not allowed

		/* 2. Update height of this ancestor node */
		node.height = 1 + DSUtil.max(height(node.lt), height(node.rt));
		/*
		 * 3. Get the balance factor of this ancestor node to check whether this
		 * node became unbalanced
		 */
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && dt < node.lt.dt)
			return rightRotate(node);

		// Right Right Case
		if (balance < -1 && dt > node.rt.dt)
			return leftRotate(node);

		// Left Right Case
		if (balance > 1 && dt > node.lt.dt) {
			node.lt = leftRotate(node.lt);
			return rightRotate(node);
		}

		// Right Left Case
		if (balance < -1 && dt < node.rt.dt) {
			node.rt = rightRotate(node.rt);
			return leftRotate(node);
		}

		/* return the (unchanged) node pointer */
		return node;
	}

	@Override
	public AVLTNode rightRotate(AVLTNode y) {
		AVLTNode x = y.lt;
		AVLTNode T = x.rt;
		x.rt = y;
		y.rt = T;

		x.height = DSUtil.max(height(x.lt), height(x.rt)) + 1;
		y.height = DSUtil.max(height(y.lt), height(y.rt)) + 1;

		return x;
	}

	@Override
	public AVLTNode leftRotate(AVLTNode x) {
		AVLTNode y = x.rt;
		AVLTNode T = y.lt;

		y.lt = x;
		x.rt = T;

		x.height = DSUtil.max(height(x.lt), height(x.rt)) + 1;
		y.height = DSUtil.max(height(y.lt), height(y.rt)) + 1;
		return y;
	}

	@Override
	public int getBalance(AVLTNode node) {
		return node == null ? 0 : (height(node.lt) - height(node.rt));
	}

	@Override
	public AVLTNode minValueNode(AVLTNode node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AVLTNode deleteNode(AVLTNode node, int key) {
		// STEP 1: PERFORM STANDARD BST DELETE
		if (node == null)
			return node;

		// If the key to be deleted is smaller than
		// the node's key, then it lies in left subtree
		if (key < node.dt)
			node.lt = deleteNode(node.lt, key);

		// If the key to be deleted is greater than the
		// node's key, then it lies in right subtree
		else if (key > node.dt)
			node.rt = deleteNode(node.rt, key);

		// if key is same as node's key, then this is the node
		// to be deleted
		else {

			// node with only one child or no child
			if ((node.lt == null) || (node.rt == null)) {
				AVLTNode temp = null;
				if (temp == node.lt)
					temp = node.rt;
				else
					temp = node.lt;

				// No child case
				if (temp == null) {
					temp = node;
					node = null;
				} else // One child case
					node = temp; // Copy the contents of
									// the non-empty child
			} else {

				// node with two children: Get the inorder
				// successor (smallest in the right subtree)
				AVLTNode temp = minValueNode(node.rt);

				// Copy the inorder successor's data to this node
				node.dt = temp.dt;

				// Delete the inorder successor
				node.rt = deleteNode(node.rt, temp.dt);
			}
		}

		// If the tree had only one node then return
		if (node == null)
			return node;

		// STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
		node.height = DSUtil.max(height(node.lt), height(node.rt)) + 1;

		// STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
		// this node became unbalanced)
		int balance = getBalance(node);

		// If this node becomes unbalanced, then there are 4 cases
		// Left Left Case
		if (balance > 1 && getBalance(node.lt) >= 0)
			return rightRotate(node);

		// Left Right Case
		if (balance > 1 && getBalance(node.lt) < 0) {
			node.lt = leftRotate(node.lt);
			return rightRotate(node);
		}

		// Right Right Case
		if (balance < -1 && getBalance(node.rt) <= 0)
			return leftRotate(node);

		// Right Left Case
		if (balance < -1 && getBalance(node.rt) > 0) {
			node.rt = rightRotate(node.rt);
			return leftRotate(node);
		}
		return node;
	}
}
