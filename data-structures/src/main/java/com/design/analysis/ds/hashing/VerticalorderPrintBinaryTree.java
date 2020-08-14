package com.design.analysis.ds.hashing;

class BTNode {
	int d;
	int index;
	BTNode lt, rt;
	BTNode root = null;

	public BTNode(int x, int index) {
		this.d = x;
		this.index = index;
		this.lt = this.rt = null;
	}

	@Override
	public String toString() {
		return "BTNode [d=" + d + ", index=" + index + "]";
	}
}

public class VerticalorderPrintBinaryTree {

	static int a[] = { 5, 3, 8, 2, 4, 7, 9 };
	static BTNode root = null;
	static int index = 0;

	public static void main(String[] args) {

		for (int i = 0; i < a.length; i++)
			root = insert(root, a[i], 0);
		print(root);
	}

	public static BTNode insert(BTNode root, int x, int index) {

		if (root == null)
			root = new BTNode(x, index);
		else if (x < root.d)
			root.lt = insert(root.lt, x, --index);
		else if (x > root.d)
			root.rt = insert(root.rt, x, ++index);
		else
			;
		return root;

	}

	public static void print(BTNode root) {
		if (root != null) {
			System.out.println(root);
			print(root.lt);
			print(root.rt);
		}

	}
}
