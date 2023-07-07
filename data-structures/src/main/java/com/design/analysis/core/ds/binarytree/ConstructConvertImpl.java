package com.design.analysis.core.ds.binarytree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.design.analysis.core.ds.tree.node.BTNode;

public class ConstructConvertImpl implements IConstructConvert<Integer> {

	public BTNode<Integer> createPositionTree(BTNode<Integer> node, Integer key, Integer dt, boolean ltOrRt) {
		if (node == null) {
			node = new BTNode<>(dt);
			node.pt = null;// this will be update in else except root
		} else {
			BTNode<Integer> temp = findNode(node, key);
			if (temp != null) {
				if (ltOrRt) {
					temp.lt = new BTNode<>(dt);
					temp.lt.pt = temp;
				} else {
					temp.rt = new BTNode<>(dt);
					temp.rt.pt = temp;
				}
			}
		}
		return node;
	}

	@Override
	public BTNode<Integer> findNode(BTNode<Integer> node, Integer y) {

		Queue<BTNode<Integer>> que = new LinkedList<>();
		que.add(node);
		while (!que.isEmpty()) {
			BTNode<Integer> x = que.poll();
			if (x.t == y)
				return x;
			if (x.lt != null)
				que.add(x.lt);
			if (x.rt != null)
				que.add(x.rt);
		}
		return null;
	}

	public void inorderPrint(BTNode<Integer> node) {
		if (node != null) {
			inorderPrint(node.lt);
			System.out.print(node.t + "->");
			inorderPrint(node.rt);
		}
	}

	public String intToString(List<Integer> l) {
		String str = "";
		for (Integer in : l)
			str += in + "";
		return str;
	}

	/** 0.1 Consturct tree using given preorder travel as list **/
	@Override
	public BTNode<Integer> createbstUsingPreorderList(BTNode<Integer> node, List<Integer> l) {

		return createFromPre(node, intToString(l));
	}

	@Override
	public BTNode<Integer> createFromPre(BTNode<Integer> node, String str) {

		if (str.length() > 0) {
			if (node == null)
				node = new BTNode<Integer>((int) str.charAt(0) - 48);
			if (str.length() == 1)
				return node;
			if (str.length() == 2) {
				if (str.charAt(0) > str.charAt(1))
					node.lt = new BTNode<Integer>((int) str.charAt(1) - 48);
				else
					node.rt = new BTNode<Integer>((int) str.charAt(1) - 48);
			} else {

				if (str.charAt(0) > str.charAt(1)) {
					int stIndOfRightChild = 0;
					for (int i = 1; i < str.length(); i++) {
						if (str.charAt(0) < str.charAt(i)) {
							stIndOfRightChild = i;
							break;
						}
					}
					if (stIndOfRightChild == 0)
						node.lt = createFromPre(node.lt, str.substring(1, str.length()));
					else
						node.lt = createFromPre(node.lt, str.substring(1, stIndOfRightChild));
					if (stIndOfRightChild != 0)
						node.rt = createFromPre(node.rt, str.substring(stIndOfRightChild, str.length()));

				} else {
					node.rt = createFromPre(node.rt, str.substring(1));
				}
			}
		}
		return node;
	}

	/** 0.2 Consturct tree using given postorder travel as list **/
	@Override
	public BTNode<Integer> createbstUsingPostorderList(BTNode<Integer> node, List<Integer> l) {
		return createFromPost(node, intToString(l));
	}

	@Override
	public BTNode<Integer> createFromPost(BTNode<Integer> node, String str) {

		int N = str.length();
		if (N > 0) {
			if (node == null)
				node = new BTNode<Integer>((int) str.charAt(str.length() - 1) - 48);
			if (N == 1)
				return node;
			if (N == 2) {
				if (str.charAt(N - 1) > str.charAt(0))
					node.lt = new BTNode<Integer>((int) str.charAt(0) - 48);
				else
					node.rt = new BTNode<Integer>((int) str.charAt(0) - 48);
			} else {

				if (str.charAt(N - 1) < str.charAt(N - 2)) {
					int endIndOfleftChild = N - 2;
					for (int i = N - 2; i >= 0; i--) {
						if (str.charAt(N - 1) > str.charAt(i)) {
							endIndOfleftChild = i;
							break;
						}
					}
					if (endIndOfleftChild == N - 2)
						node.rt = createFromPost(node.rt, str.substring(0, N - 1));
					else
						node.rt = createFromPost(node.rt, str.substring(endIndOfleftChild + 1, N - 1));
					if (endIndOfleftChild != N - 2)
						node.lt = createFromPost(node.lt, str.substring(0, endIndOfleftChild + 1));

				} else {
					node.lt = createFromPost(node.lt, str.substring(0, N - 1));
				}
			}
		}
		return node;
	}

	/** 0.3 Consturct tree using given inorder travel as list **/
	public BTNode<Integer> createbstUsingInorderderList(BTNode<Integer> node, List<Integer> l) {
		return createFromIn(node, intToString(l));
	}

	@Override
	public BTNode<Integer> createFromIn(BTNode<Integer> node, String str) {

		int N = str.length();
		boolean isEven = (N % 2 == 0) ? true : false;
		if (N > 0) {
			if (node == null)
				if (isEven)
					node = new BTNode<Integer>((int) str.charAt(N / 2 - 1) - 48);
				else
					node = new BTNode<Integer>((int) str.charAt(N / 2) - 48);
			if (N == 1)
				return node;
			if (N == 2)
				node.rt = new BTNode<Integer>((int) str.charAt(N - 1) - 48);
			else if (N == 3) {
				node.lt = new BTNode<Integer>((int) str.charAt(0) - 48);
				node.rt = new BTNode<Integer>((int) str.charAt(N - 1) - 48);
			} else {

				if (isEven) {
					node.lt = createFromIn(node.lt, str.substring(0, N / 2 - 1));
					node.rt = createFromIn(node.rt, str.substring(N / 2, N));
				} else {
					node.lt = createFromIn(node.lt, str.substring(0, N / 2));
					node.rt = createFromIn(node.rt, str.substring(N / 2 + 1, N));
				}
			}
		}
		return node;
	}

	/** 1. Construct Tree from given Inorder and Preorder traversals **/
	// TODO for well understand
	public BTNode<Integer> buildTreeFromGivenInorderPreorder(Integer[] inorder, Integer[] preorder) {

		Set<BTNode<Integer>> set = new HashSet<>();
		Stack<BTNode<Integer>> stack = new Stack<>();

		BTNode<Integer> root = null;

		for (int pre = 0, in = 0; pre < preorder.length;) {

			BTNode<Integer> node = null;
			do {
				node = new BTNode<>(preorder[pre]);
				if (root == null) {
					root = node;
				}
				if (!stack.isEmpty()) {
					if (set.contains(stack.peek())) {
						set.remove(stack.peek());
						stack.pop().rt = node;
					} else {
						stack.peek().lt = node;
					}
				}
				stack.push(node);
			} while (preorder[pre++] != inorder[in] && pre < preorder.length);

			node = null;
			while (!stack.isEmpty() && in < inorder.length && stack.peek().t == inorder[in]) {
				node = stack.pop();
				in++;
			}

			if (node != null) {
				set.add(node);
				stack.push(node);

			}
		}
		return root;
	}

	/** 2. Construct a tree from Inorder and Level order traversals **/
	public BTNode<Integer> buildTreeFromGivenInorderlevelorder(Integer[] in, Integer[] lev) {
		return null;
	}

	@Override
	public BTNode<Integer> findInsertPostion(BTNode<Integer> node) {
		// TODO Auto-generated method stub
		return null;
	}
}
