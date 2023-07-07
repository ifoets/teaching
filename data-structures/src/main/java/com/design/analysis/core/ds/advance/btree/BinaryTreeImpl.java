
package com.design.analysis.core.ds.advance.btree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.design.analysis.core.ds.node.BTNode;

public class BinaryTreeImpl implements IBinaryTree {

	public BTNode root = null;
	public List<BTNode> list = new ArrayList<BTNode>();
	public List<BTNode> verticalList = new ArrayList<BTNode>();
	public int rs;

	@Override
	public BTNode createBstIndex(BTNode node, int dt, int index) {

		if (node == null) {
			node = new BTNode(dt);
			node.ind = index;
			verticalList.add(node);
		} else {
			if (dt <= node.dt) {
				node.lt = createBstIndex(node.lt, dt, --index);
				node.lt.pt = node;
			} else {
				node.rt = createBstIndex(node.rt, dt, ++index);
				node.rt.pt = node;
			}
		}
		return node;
	}

	@Override
	public BTNode createBst(BTNode node, int dt) {

		if (node == null)
			node = new BTNode(dt);
		else {
			if (dt < node.dt) {
				node.lt = createBst(node.lt, dt);
				node.lt.pt = node;
			} else {
				node.rt = createBst(node.rt, dt);
				node.rt.pt = node;
			}
		}
		return node;
	}

	@Override
	public BTNode createBstDuplicate(BTNode node, int dt) {
		if (node == null) {
			node = new BTNode(dt);
			node.ind = 1;
		} else {
			if (node.dt == dt) {
				node.ind++;
			} else if (dt < node.dt) {
				node.lt = createBstDuplicate(node.lt, dt);
				node.lt.pt = node;
			} else {
				node.rt = createBstDuplicate(node.rt, dt);
				node.rt.pt = node;
			}
		}
		return node;
	}

	// level order inserton
	@Override
	public BTNode insert(BTNode node, int[] arr, int l, int r) {

		int left = 2 * l + 1;
		int right = 2 * l + 2;
		if (left > r || right > r) {
			return null;
		}
		if (node == null) {
			node = new BTNode(arr[l]);
		}
		if (node.lt == null && node.rt == null) {
			if (left < r) {
				node.lt = new BTNode(arr[left]);
				node.lt.pt = node;
			}
			if (right < r) {
				node.rt = new BTNode(arr[right]);
				node.rt.pt = node;
			}
		}
		insert(node.lt, arr, left, r);
		insert(node.rt, arr, right, r);
		return node;
	}

	// level order insert from left to right
	@Override
	public BTNode create(BTNode node, int dt) {

		if (node == null) {
			node = new BTNode(dt);
			node.pt = node;// this will be update in else except root
		} else {
			BTNode temp = findInsertPostion(node);
			if (temp.lt == null) {
				temp.lt = create(temp.lt, dt);
				temp.lt.pt = temp;
			}

			else {
				temp.rt = create(temp.rt, dt);
				temp.rt.pt = temp;
			}
		}
		return node;
	}

	@Override
	public BTNode findInsertPostion(BTNode node) {

		Queue<BTNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BTNode temp = queue.poll();
			if (temp.lt == null || temp.rt == null)
				return temp;
			else if (temp.lt != null && temp.rt != null) {
				queue.add(temp.lt);
				queue.add(temp.rt);
			}
		}
		return null;
	}

	@Override
	public void print(BTNode node) {
		if (node != null) {
			print(node.lt);
			System.out.print(node.dt + "(" + node.ind + ")->");
			print(node.rt);
		}
	}

	// row wise print ie 1 row 2 nd row ..etc
	@Override
	public void levelPrint(BTNode node) {

		Queue<BTNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BTNode temp = queue.poll();
			System.out.print("(" + temp.dt + ")->");

			if (temp.lt != null && temp.rt != null) {
				queue.add(temp.lt);
				queue.add(temp.rt);
			} else if (temp.lt != null && temp.rt == null) {
				queue.add(temp.lt);
			} else if (temp.lt == null && temp.rt != null) {
				queue.add(temp.rt);
			}
		}
	}

	@Override
	public int height(BTNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.lt), height(node.rt));
	}

	@Override
	public void lavelOrderPrint(BTNode node) {
		if (node == null) {
			System.out.println("No any Node present:-");
			return;
		}
		int height = height(node);
		int i = 1;
		while (i <= height) {
			System.out.println();
			printGivenLevel(node, i);
			++i;
		}
	}

	@Override
	public void printGivenLevel(BTNode root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(String.valueOf(root.dt) + "->");
		} else if (level > 1) {
			printGivenLevel(root.lt, level - 1);
			printGivenLevel(root.rt, level - 1);
		}
	}

	@Override
	public void spiralLevelPrint(BTNode node) {
		if (node == null) {
			System.out.println("No any Node present:-");
			return;
		}
		int height = height(node);
		boolean ltr = false;
		int i = 1;
		while (i <= height) {
			System.out.println();
			printSpiralLevel(node, i, ltr);
			ltr = !ltr;
			++i;
		}
	}

	@Override
	public void printSpiralLevel(BTNode root, int level, boolean ltr) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(String.valueOf(root.dt) + "->");
		} else if (level > 1) {
			if (ltr) {
				printSpiralLevel(root.lt, level - 1, ltr);
				printSpiralLevel(root.rt, level - 1, ltr);
			} else {
				printSpiralLevel(root.rt, level - 1, ltr);
				printSpiralLevel(root.lt, level - 1, ltr);
			}
		}
	}

	@Override
	public boolean recursveSearch(BTNode node, int element) {
		if (node == null) {
			return false;
		}
		if (node.dt == element) {
			return true;
		}
		if (!recursveSearch(node.lt, element) && !recursveSearch(node.rt, element)) {
			return false;
		}
		return true;
	}

	@Override
	public BTNode recvSearch(BTNode node, int element) {
		if (node != null) {
			if (node.dt == element) {
				return node;
			} else if (node.dt < element) {
				return recvSearch(node.rt, element);
			} else {
				return recvSearch(node.lt, element);
			}
		}
		return null;
	}

	@Override
	public void deleteCompletly(BTNode node) {
		if (node != null) {
			BTNode left = node.lt;
			BTNode right = node.rt;
			node.lt = node.rt = null;
			node = null;
			deleteCompletly(left);
			deleteCompletly(right);
		}
	}

	@Override
	public int count(BTNode node) {
		if (node == null) {
			return 0;
		}
		return 1 + count(node.lt) + count(node.rt);
	}

	@Override
	public BTNode delete(BTNode node, int key) {
		if (node == null) {
			System.out.println(key + " not found in tree");
			return null;
		} else if (key < node.dt) {
			delete(node.lt, key);
		} else if (key > node.dt) {
			delete(node.rt, key);
		} else if (node.dt == key) // found the node
		{
			// case 1: if no child of deleting node
			if (node.lt == null && node.rt == null) {
				BTNode q = node;
				// if deleting node is left node of its parent
				if (q.pt.lt == node) {
					q.pt.lt = null;
				} else // deleting node is right child of its parent
				{
					q.pt.rt = null;
				}
				q = null;
			} else // deleting node have left as well as right child ..eighter
					// manage by right succesor or left predecesor
			{
				BTNode p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.dt = node.lt.dt;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						BTNode q = p;
						p.pt.rt = q.lt; // add left predecesor to right to its
										// parent
						node.dt = q.dt; // copy the right precedesor to deleing
										// node and nullify it
						q = null;
					} else {
						node.dt = node.lt.dt;
						node.lt = node.lt.lt;
						node.lt.pt = node;
					}
				} else // find smallest in right subtree
				{
					BTNode x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.dt = node.rt.dt;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						BTNode y = x;
						x.pt.lt = y.rt; // add left predecesor to right to its
										// parent
						node.dt = y.dt; // copy the right precedesor to deleing
										// node and nullify it
						x = null;
					} else {
						node.dt = node.rt.dt;
						node.rt = node.rt.rt;
						node.rt.pt = node;
					}
				}
			}
		}
		return node;
	}

	@Override
	public BTNode mirrorTree(BTNode node) {
		if (node == null) {
			return null;
		}
		mirrorTree(node.lt);
		mirrorTree(node.rt);
		BTNode temp = node.lt;
		node.lt = node.rt;
		node.rt = temp;
		return node;
	}

	@Override
	public void printAllPath(BTNode node) {
		if (node == null) {
			return;
		}
		int[] path = new int[1000];
		printPatWise(node, path, 0);
	}

	@Override
	public void printPatWise(BTNode node, int[] path, int size) {
		if (node == null) {
			return;
		}
		path[size++] = node.dt;
		if (node.lt == null && node.rt == null) {
			printPath(path, size);
		} else {
			printPatWise(node.lt, path, size);
			printPatWise(node.rt, path, size);
		}
	}

	@Override
	public void printPath(int[] path, int size) {
		int i = 0;
		while (i < size) {
			System.out.print(String.valueOf(path[i]) + "->");
			++i;
		}
		System.out.println();
	}

	@Override
	public void treeListRecursion(BTNode node) {
		BTNode head;
		List<BTNode> nodeList = arrangeNode(list, node);
		BTNode last = head = nodeList.get(0);
		head.lt = null;
		int i = 1;
		while (i < nodeList.size()) {
			BTNode tempNode = nodeList.get(i);
			tempNode.rt = null;
			tempNode.lt = last;
			last = last.rt = tempNode;
			++i;
		}
		head.lt = last;
		last.rt = head;
		BTNode temp = head;
		while (temp.rt != head) {
			System.out.print(String.valueOf(temp.dt) + "->");
			temp = temp.rt;
		}
		System.out.print(temp.dt);
	}

	@Override
	public List<BTNode> arrangeNode(List<BTNode> list, BTNode node) {
		if (node == null) {
			return null;
		}
		arrangeNode(list, node.lt);
		list.add(node);
		arrangeNode(list, node.rt);
		return list;
	}

	@Override
	public int countLeafNode(BTNode node) {
		if (node == null) {
			return 0;
		}
		if (node.lt == null && node.rt == null) {
			return 1;
		}
		return countLeafNode(node.lt) + countLeafNode(node.rt);
	}

	@Override
	public boolean isChildrenSum(BTNode node) {
		if (node == null || node.lt == null && node.rt == null) {
			return true;
		}
		if (node.dt == (node.rt != null ? node.rt.dt : 0) + (node.lt != null ? node.lt.dt : 0) && isChildrenSum(node.lt)
				&& isChildrenSum(node.rt)) {
			return true;
		}
		return false;
	}

	@Override
	public BTNode makeChildrenSun(BTNode node) {
		if (node == null) {
			return null;
		}
		if (node.lt == null && node.rt == null) {
			return node;
		}
		makeChildrenSun(node.rt);
		makeChildrenSun(node.lt);
		int diff = (node.lt != null ? node.lt.dt : 0) + (node.rt != null ? node.rt.dt : 0) - node.dt;
		if (diff > 0) {
			node.dt += diff;
		} else if (diff < 0) {
			node.dt -= diff;
		}
		return node;
	}

	@Override
	public int dimeter(BTNode node) {
		if (node == null) {
			return 0;
		}
		int lheight = height(node.lt);
		int rheight = height(node.rt);
		int ldimeter = dimeter(node.lt);
		int rdimeter = dimeter(node.rt);
		return Math.max(lheight + rheight + 1, Math.max(ldimeter, rdimeter));
	}

	@Override
	public boolean isHeightBalance(BTNode node) {
		if (node == null) {
			return true;
		}
		if (Math.abs(height(node.lt) - height(node.rt)) <= 1 && isHeightBalance(node.lt) && isHeightBalance(node.rt)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean rootToLeavPathSum(BTNode node, int number) {
		if (node == null) {
			return false;
		}
		int[] path = new int[1000];
		return pathWiseSum(node, path, 0, number);
	}

	@Override
	public boolean pathWiseSum(BTNode node, int[] path, int size, int number) {
		if (node == null) {
			return true;
		}
		path[size++] = node.dt;
		if (node.lt == null && node.rt == null) {
			if (validate(path, size, number)) {
				return true;
			}
		} else {
			pathWiseSum(node.lt, path, size, number);
			pathWiseSum(node.rt, path, size, number);
		}
		return false;
	}

	@Override
	public boolean validate(int[] a, int size, int element) {
		int sum = 0;
		int i = 0;
		while (i < size) {
			sum += a[i];
			++i;
		}
		if (element == sum) {
			return true;
		}
		return false;
	}

	@Override
	public BTNode doubleBTree(BTNode node) {
		if (node == null) {
			return null;
		}
		BTNode added = new BTNode(node.dt);
		if (node.lt == null) {
			node.lt = new BTNode(node.dt);
		} else {
			BTNode temp = node.lt;
			node.lt = added;
			added.lt = temp;
		}
		doubleBTree(node.lt);
		doubleBTree(node.rt);
		return node;
	}

	@Override
	public int getMaxWidth(BTNode node) {
		int maxWidth = 0;
		int h = height(node);
		int i = 1;
		while (i <= h) {
			int width = getWidth(node, i);
			if (width > maxWidth) {
				maxWidth = width;
			}
			++i;
		}
		return maxWidth;
	}

	@Override
	public int getWidth(BTNode node, int level) {
		if (node == null) {
			return 0;
		}
		if (level == 1) {
			return 1;
		}
		return getWidth(node.lt, level - 1) + getWidth(node.rt, level - 1);
	}

	@Override
	public boolean isFoldable(BTNode node) {
		if (node == null) {
			return true;
		}
		return leftRightFoldable(node.lt, node.rt);
	}

	@Override
	public boolean leftRightFoldable(BTNode a, BTNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a == null && b != null || a != null && b == null) {
			return false;
		}
		if (leftRightFoldable(a.lt, b.lt) && leftRightFoldable(a.rt, b.rt)) {
			return true;
		}
		return false;
	}

	@Override
	public void printAllKthNodesFromRoot(BTNode node, int k) {
		if (node == null) {
			return;
		}
		int h = height(node);
		if (k > h) {
			System.out.println("No any node present at this " + k + "th distance");
		} else {
			printGivenLevel(node, k);
		}
	}

	@Override
	public int levelOfNode(BTNode node, int k) {
		if (node == null) {
			return 0;
		}
		return getLevelUtil(node, k, 1);
	}

	@Override
	public int getLevelUtil(BTNode node, int data, int level) {
		if (node.dt == data) {
			return level;
		}
		int downlevel = getLevelUtil(node.lt, data, level + 1);
		if (downlevel != 0) {
			return downlevel;
		}
		downlevel = getLevelUtil(node.rt, data, level + 1);
		return downlevel;
	}

	@Override
	public boolean ancestor(BTNode node, int data) {
		if (node == null) {
			return false;
		}
		if (node.dt == data) {
			return true;
		}
		if (ancestor(node.lt, data) || ancestor(node.rt, data)) {
			System.out.println(String.valueOf(node.dt) + "->");
			return true;
		}
		return false;
	}

	@Override
	public int isSumTree(BTNode node) {

		if (node == null || node.lt == null && node.rt == null) {
			return 1;
		}
		int ls = sum(node.lt);
		if (node.dt == ls + (rs = sum(node.rt)) && isSumTree(node.lt) == 1 && isSumTree(node.rt) == 1) {
			return 1;
		}
		return 0;
	}

	@Override
	public int sum(BTNode node) {
		if (node == null) {
			return 0;
		}
		return sum(node.lt) + node.dt + sum(node.rt);
	}

	@Override
	public void preOrder(BTNode node) {
		if (node != null) {
			System.out.print("(" + node.dt + ")->");
			preOrder(node.lt);
			preOrder(node.rt);
		}

	}

	@Override
	public void inOrder(BTNode node) {
		if (node != null) {
			inOrder(node.lt);
			System.out.print("(" + node.dt + ")->");
			inOrder(node.rt);
		}
	}

	@Override
	public void postOrder(BTNode node) {
		if (node != null) {
			postOrder(node.lt);
			postOrder(node.rt);
			System.out.print("(" + node.dt + ")->");
		}

	}

	@Override
	public void distoryTree() {
		root = null;
	}

	@Override
	public BTNode inorderSuccessor(BTNode node, int key, boolean isMax) {

		if (isMax) // max element of tree has no successor
		{
			BTNode p = node;
			while (p.rt != null)
				p = p.rt;
			if (p.dt == key) {
				isMax = false;
				return null;
			}
		}
		if (node == null)
			return null;
		else if (node.dt == key) {
			BTNode t = node.rt;
			if (t == null) {
				while (node.dt > node.pt.dt)
					node = node.pt;
				return node.pt;
			} else {
				while (t.lt != null)
					t = t.lt;
				return t;
			}
		} else // traverse to search the node whose successor need to find
		{
			if (key < node.dt)
				return inorderSuccessor(node.lt, key, false);
			else
				return inorderSuccessor(node.rt, key, false);
		}
	}

	@Override
	public BTNode inorderPredecessor(BTNode node, int key, boolean isMin) {

		if (isMin) // max element of tree has no successor
		{
			BTNode p = node;
			while (p.lt != null)
				p = p.lt;
			if (p.dt == key) {
				isMin = false;
				return null;
			}
		}
		if (node == null)
			return null;
		else if (node.dt == key) {
			BTNode t = node.lt;
			if (t == null) {
				while (node.dt < node.pt.dt)
					node = node.pt;
				return node.pt;
			} else {
				while (t.rt != null)
					t = t.rt;
				return t;
			}
		} else // traverse to search the node whose successor need to find
		{
			if (key < node.dt)
				return inorderPredecessor(node.lt, key, false);
			else
				return inorderPredecessor(node.rt, key, false);
		}
	}

	@Override
	public BTNode image(BTNode node) {
		if (node == null || (node.lt == null && node.rht == null))
			return node;
		else {
			BTNode a = node.lt;
			BTNode b = node.rt;
			node.lt = image(b);
			node.rt = image(a);
		}
		return node;
	}

	@Override
	public List<BTNode> printVertical(BTNode node) // facebook interview qun
	{
		Collections.sort(verticalList);
		return verticalList;
	}
}
