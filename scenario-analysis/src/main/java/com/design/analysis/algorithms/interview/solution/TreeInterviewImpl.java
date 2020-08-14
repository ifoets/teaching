package com.design.analysis.algorithms.interview.solution;

import java.util.LinkedList;
import java.util.Queue;

import com.design.analysis.algorithms.interview.node.TNode;

public class TreeInterviewImpl implements ITreeInterview<Long> {

	TNode<Long> root = null;

	@Override
	public TNode<Long> creazyTree(int l) {
		// l = 21;
		l = 3;
		TNode<Long> node = new TNode<Long>(1l);
		Queue<TNode<Long>> que = new LinkedList<TNode<Long>>();
		que.add(node);
		while (l != 1) {
			Queue<TNode<Long>> queNew = new LinkedList<TNode<Long>>();
			while (!que.isEmpty()) {
				queNew.add(que.poll());
			}
			while (!queNew.isEmpty()) {
				TNode<Long> temp = queNew.poll();
				TNode<Long> lt = new TNode<Long>(1l);
				TNode<Long> rt = new TNode<Long>(1l);
				temp.lt = lt;
				temp.rt = rt;
				lt.pt = temp;
				rt.pt = temp;

				que.add(lt);
				que.add(rt);
			}
			l--;
		}
		root = connectToRightNode(node);
		return root;
	}

	@Override
	public TNode<Long> connectToRightNode(TNode<Long> node) {
		Queue<TNode<Long>> que = new LinkedList<TNode<Long>>();
		que.add(node);
		while (!que.isEmpty()) {
			TNode<Long> temp = que.poll();
			if (temp == null)
				break;
			if (temp.pt != null)// ie for root node
			{
				temp.next = temp.pt.lt == temp ? temp.pt.rt : temp.pt.next != null ? temp.pt.next.lt : null;
			}
			que.add(temp.lt);
			que.add(temp.rt);
		}
		return fillData(node);
	}

	@Override
	public TNode<Long> fillData(TNode<Long> node) {
		TNode<Long> temp = node;
		while (temp.lt != null)
			temp = temp.lt;

		while (temp != null) {
			TNode<Long> x = temp;
			long d = 1;
			while (x != null) {
				if (x.lt == null && x.rt == null) // complete binary tree
				{
					x.t = d++;
				} else {
					x.t = x.lt.t * x.rt.t;
				}
				x = x.next;
			}
			temp = temp.pt;
		}
		return node;
	}

	@Override
	public void print(TNode<Long> node) {
		TNode<Long> temp = node;
		while (temp != null) {
			TNode<Long> x = temp;
			while (x != null) {
				System.out.print(x.t + "->");
				x = x.next;
			}
			temp = temp.lt;
			System.out.println();
		}
	}

	@Override
	public int query(int N, int X, int Y) {
		TNode<Long> temp = root;
		while (N-- != 1)
			temp = temp.lt;
		int t = X;
		int sum = 0;
		while (t-- != 1)
			temp = temp.next;
		for (int i = 0; i <= Y - X; i++) {
			sum += temp.t;
			temp = temp.next;
		}
		return sum;
	}
}
