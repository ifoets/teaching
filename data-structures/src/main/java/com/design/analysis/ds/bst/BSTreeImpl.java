package com.design.analysis.ds.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.design.analysis.ds.node.BTNode;

class BITNode {
	public String str;
	public BITNode lt, rt;

	public BITNode(String str) {
		this.str = str;
		this.rt = this.lt = null;
	}
}

public class BSTreeImpl implements IBSTree {

	public static void main(String[] args) {
		/*
		 * String str = "5";// "5213768"; BITNode node = create(null, str); print(node);
		 * List<Integer> list = Inorderlist; boolean isSorted = true; for (int i = 1; i
		 * < list.size(); i++) { // if(list.get(i-1)>list.get(i)) // return false;
		 * 
		 * 
		 * 
		 *}*/

	}

	public static int minCost(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> gWeight) {

		int N = gFrom.size();
		int a[][] = new int[N + 1][N + 1];

		// arr row is gFrom and column is gTo and value o array elemnnt is gWeight
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < N + 1; j++) {
				a[i][j] = 1; // if not connected we can connect by 1 weight
				if (i == 0 || j == 0 || i == j)// cyclic connect of same node have 0 weight
					a[i][j] = 0;
				else
					a[gFrom.get(i)][gTo.get(j)] = gWeight.get(i);
			}
		}

		int minWight = Integer.MAX_VALUE;
		// I assumed gNode is start node ie 1 and last node is N;
		for (int i = 1; i <= N; i++) {
			int min = 0;
			for (int j = i; j <= N; j = j + i) // i is the step
			{
				min += a[i][j];
			}
			if (min < minWight)
				minWight = min;
		}
		return minWight;
		/*1,2 2,3 3,4
		 * 1,2 2,4
		 * 1,3 3,4
		 * 1,4
		 * 
		 */
	}

	public static BITNode create(BITNode node, String str) {

		if (str.length() > 0) {
			if (node == null)
				node = new BITNode(str.charAt(0) + "");
			if (str.length() == 1)
				return node;
			if (str.length() == 2) {
				if (str.charAt(0) > str.charAt(1))
					node.lt = new BITNode(str.charAt(1) + "");
				else
					node.rt = new BITNode(str.charAt(1) + "");
			} else {

				if (str.charAt(0) > str.charAt(1)) {
					int stIndOfRightChild = 0;
					for (int i = 1; i < str.length(); i++) {
						if (str.charAt(0) < str.charAt(i)) {
							stIndOfRightChild = i;
							break;
						}
					}
					node.lt = create(node.lt, str.substring(1, stIndOfRightChild));
					if (stIndOfRightChild != 0)
						node.rt = create(node.rt, str.substring(stIndOfRightChild, str.length()));

				} else {
					node.rt = create(node.rt, str.substring(1));
				}
			}

		}
		return node;
	}

	public static List<Integer> Inorderlist = new ArrayList<>();

	public static void print(BITNode node) {
		if (node != null) {
			print(node.lt);
			Inorderlist.add(Integer.valueOf(node.str));
			// System.out.print(node.str + "->");
			print(node.rt);
		}
	}

	@Override
	public BTNode create(BTNode node, int dt) {

		if (node == null)
			node = new BTNode(dt);
		else {
			if (dt <= node.dt) {
				node.lt = create(node.lt, dt);
				node.lt.pt = node;
			} else {
				node.rt = create(node.rt, dt);
				node.rt.pt = node;
			}
		}
		return node;
	}

//this is also level order insertion
	public BTNode insert(BTNode node, int[] arr, int start, int size) {
		int left = 2 * start + 1;
		int right = 2 * start + 2;
		if (left > size || right > size) {
			return null;
		}
		if (node == null) {

			node = new BTNode(arr[start]);
		}
		if (node.lt == null && node.rt == null) {
			if (left < size) {
				node.lt = new BTNode(arr[left]);
			}
			if (right < size) {
				node.rt = new BTNode(arr[right]);
			}
		}
		insert(node.lt, arr, left, size);
		insert(node.rt, arr, right, size);
		return node;
	}

	// row wise ie 1 row, 2nd row etc
	@Override
	public void levelPrint(BTNode node) {
		Queue<BTNode> que = new LinkedList<>();
		que.add(node);
		while (!que.isEmpty()) {
			BTNode temp = que.poll();
			System.out.print("(" + temp.dt + ")");
			if (temp.lt != null)
				que.add(temp.lt);
			if (temp.rt != null)
				que.add(temp.rt);
		}
	}

	/*
	 * public static void main(String[] args) { BSTreeImpl imp = new BSTreeImpl();
	 * int arr[] = { 5, 4, 6, 3, 7, 2, 8, 1, 9 }; BTNode root = null; for (int i =
	 * 0; i < arr.length; i++) root = imp.create(root, arr[i]);
	 * imp.levelPrint(root); }
	 */

	// root,left to right level,then right to left and so on
	@Override
	public void spirialPrintLeft(BTNode node) {
		// TODO Auto-generated method stub

	}

	// root,right to left level,then left to right
	@Override
	public void spiralPrintRight(BTNode node) {
		// TODO Auto-generated method stub

	}

}
