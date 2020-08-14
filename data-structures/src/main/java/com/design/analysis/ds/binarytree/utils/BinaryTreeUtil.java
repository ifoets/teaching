package com.design.analysis.ds.binarytree.utils;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import com.design.analysis.ds.tree.node.BTNode;

public class BinaryTreeUtil {

	public static Comparator<BTNode<Integer>> indComparator = new Comparator<BTNode<Integer>>() {
		@Override
		public int compare(BTNode<Integer> p1, BTNode<Integer> p2) {
			return p1.ind - p2.ind;
		}
	};

	public static BTNode<Integer> createCustomTree(BTNode<Integer> node, Integer parent, Integer dt) {

		BTNode<Integer> temp = findParnetNode(node, parent);
		if (temp != null && temp.lt != null && temp.rt != null) {
			System.out.println("invalid input");
			return node;
		}
		if (temp == null) {// for root node
			temp = new BTNode<Integer>(parent);
			temp.lt = new BTNode<Integer>(dt);
			temp.lt.pt = temp;
			temp.lt.ind = temp.ind - 1;
			temp.lt.h = temp.h + 1;
			node = temp;
		} else {
			if (temp.lt == null) {
				temp.lt = new BTNode<Integer>(dt);
				temp.lt.pt = temp;
				temp.lt.ind = temp.ind - 1;
				temp.lt.h = temp.h + 1;
			}

			else {
				temp.rt = new BTNode<Integer>(dt);
				temp.rt.pt = temp;
				temp.rt.ind = temp.ind + 1;
				temp.rt.h = temp.h + 1;
			}
		}
		return node;
	}

	public static BTNode<Integer> findParnetNode(BTNode<Integer> node, Integer parent) {
		if (node == null)
			return node;
		Queue<BTNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BTNode<Integer> temp = queue.poll();
			if (temp.t.equals(parent))
				return temp;
			if (temp.lt != null)
				queue.add(temp.lt);
			if (temp.rt != null)
				queue.add(temp.rt);
		}
		return null;

	}

	public static BTNode<Integer> createBst(BTNode<Integer> node, Integer k) {

		if (node == null)
			node = new BTNode<Integer>(k);
		else {
			// replacing
			if (k.equals(node.t)) {
				node.t = k;
			} else if (k.compareTo(node.t) < 0) {
				boolean isLtNull = false;// stop repoing during travelled
				if (node.lt == null)
					isLtNull = true;
				node.lt = createBst(node.lt, k);
				if (isLtNull) {
					node.lt.pt = node;
					node.lt.h = node.h + 1;
				}

			} else {
				boolean isRtNull = false;
				if (node.rt == null)
					isRtNull = true;
				node.rt = createBst(node.rt, k);
				if (isRtNull) {
					node.rt.pt = node;
					node.rt.h = node.h + 1;
				}
			}
		}
		return node;
	}

	public static BTNode<Integer> create(BTNode<Integer> node, Integer dt) {

		if (node == null) {
			node = new BTNode<>(dt);
			node.pt = null;// this will be update in else except root
		} else {
			BTNode<Integer> temp = findInsertPostion(node);
			if (temp.lt == null) {
				temp.lt = create(temp.lt, dt);
				temp.lt.pt = temp;
				temp.lt.ind = temp.ind - 1;
				temp.lt.h = temp.h + 1;

			}

			else {
				temp.rt = create(temp.rt, dt);
				temp.rt.pt = temp;
				temp.rt.ind = temp.ind + 1;
				temp.rt.h = temp.h + 1;
			}
		}
		return node;
	}

	public static BTNode<Integer> findInsertPostion(BTNode<Integer> node) {

		Queue<BTNode<Integer>> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BTNode<Integer> temp = queue.poll();
			if (temp.lt == null || temp.rt == null)
				return temp;
			else if (temp.lt != null && temp.rt != null) {
				queue.add(temp.lt);
				queue.add(temp.rt);
			}
		}
		return null;
	}

	// this is for complete binary tree not for bst
	public static void linkNextPrevLevelWise(BTNode<Integer> node) {

		// Base case
		if (node == null)
			return;
		if (node.lt != null) {
			node.lt.next = node.rt;
			if (node.rt != null)
				node.rt.prev = node.lt;
		}

		if (node.rt != null) {
			node.rt.next = (node.next != null) ? node.next.lt : null;
			if (node.rt.next != null)
				node.rt.next.prev = node.rt;
		}
		// Set nextRight for other nodes in pre order fashion
		linkNextPrevLevelWise(node.lt);
		linkNextPrevLevelWise(node.rt);
	}

	public static void printLevelByLink(BTNode<Integer> node) {

		BTNode<Integer> h = node;
		BTNode<Integer> x = null;
		System.out.println("From left to right print");
		while (h != null) {
			x = h;
			while (x != null) {
				System.out.print(x.t + "->");
				x = x.next;
			}
			h = h.lt;
			System.out.println();
		}

		h = node;
		System.out.println("\nRight to left print");
		while (h != null) {
			x = h;
			while (x != null) {
				System.out.print(x.t + "->");
				x = x.prev;
			}
			h = h.rt;
			System.out.println();
		}
	}

	public static boolean areIdentical(BTNode<Integer> b1, BTNode<Integer> b2) {
		if (b1 == null && b2 == null)
			return true;
		if (b1 == null || b2 == null)
			return false;
		return b1.t.equals(b2.t) && areIdentical(b1.lt, b2.lt) && areIdentical(b1.rt, b2.rt);

	}

	public static BTNode<Integer> search(BTNode<Integer> t, BTNode<Integer> sub) {
		if (t != null) {
			Queue<BTNode<Integer>> que = new LinkedList<>();
			que.add(t);
			while (!que.isEmpty()) {
				BTNode<Integer> bt = que.poll();
				if (bt.t.equals(sub.t))
					return bt;
				if (bt.lt != null)
					que.add(bt.lt);
				if (bt.rt != null)
					que.add(bt.rt);
			}
		}
		return null;
	}

	public static void levelTravelLineByline(BTNode<Integer> node) {
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

	public static int height(BTNode<Integer> node) {
		if (node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.lt), height(node.rt));
	}

	public static void printGivenLevel(BTNode<Integer> root, int level) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.print(String.valueOf(root.t) + "->");
		} else if (level > 1) {
			printGivenLevel(root.lt, level - 1);
			printGivenLevel(root.rt, level - 1);
		}
	}

	public static void delete(BTNode<Integer> node, Integer key) {
		if (node == null) {
			System.out.println(key + " not found in tree");
			return;
		} else if (key.compareTo(node.t) < 0) {
			delete(node.lt, key);
		} else if (key.compareTo(node.t) > 0) {
			delete(node.rt, key);
		} else if (node.t.equals(key)) // found the node
		{
			// case 1: if no child of deleting node
			if (node.lt == null && node.rt == null) {
				BTNode<Integer> q = node;
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
				BTNode<Integer> p = node.lt;
				if (p != null) // find largest in left subtree
				{
					if (p.lt == null && p.rt == null) {
						node.t = node.lt.t;
						node.lt = null;
					} else if (p.rt != null) {
						while (p.rt != null) {
							p = p.rt;
						}
						BTNode<Integer> q = p;
						p.pt.rt = q.lt; // add left predecesor to right to its
										// parent
						node.t = q.t; // copy the right precedesor to deleing
										// node and nullify it
						q = null;
					} else {
						node.t = node.lt.t;
						node.lt = node.lt.lt;
						node.lt.pt = node;
					}
				} else // find smallest in right subtree
				{
					BTNode<Integer> x = node.rt;
					if (x.lt == null && x.rt == null) {
						node.t = node.rt.t;
						node.rt = null;
					} else if (x.lt != null) {
						while (x.lt != null) {
							x = x.lt;
						}
						BTNode<Integer> y = x;
						x.pt.lt = y.rt; // add left predecesor to right to its
										// parent
						node.t = y.t; // copy the right precedesor to deleing
										// node and nullify it
						x = null;
					} else {
						node.t = node.rt.t;
						node.rt = node.rt.rt;
						node.rt.pt = node;
					}
				}
			}
		}
	}
}
