package com.design.analysis.core.ds.advance.btree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.design.analysis.core.ds.node.BTNode;

public class SpecialBinaryTreeImpl implements ISpecialBinaryTree {

	public Map<Integer, List<BTNode>> map = new HashMap<>();

	@Override
	public BTNode create(BTNode node, int dt) {
		if (node == null) {
			node = new BTNode(dt);
			node.pt = node;// used for root for others it will we be update in
							// else
		} else {
			BTNode temp = findInsertPostion(node, 0);
			if (temp.lt == null) {
				temp.lt = create(temp.lt, dt);
				temp.lt.pt = temp;
				temp.lt.ind = temp.ind - 1;
			} else {
				temp.rt = create(temp.rt, dt);
				temp.rt.pt = temp;
				temp.rt.ind = temp.ind + 1;
			}
		}
		return node;
	}

	@Override
	public BTNode findInsertPostion(BTNode node, int index) {
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
	public void levelPrint(BTNode node) {
		Queue<BTNode> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BTNode temp = queue.poll();
			System.out.print("(" + temp.dt + "[" + temp.ind + "])->");

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
	public void columnWsiePrint(BTNode node) {

		if (node != null) {
			List<BTNode> list = null;
			columnWsiePrint(node.lt);
			if (map.get(node.ind) == null) {
				list = new ArrayList<>();
				list.add(node);
				map.put(node.ind, list);

			} else {
				list = map.get(node.ind);
				list.add(node);
				map.put(node.ind, list);
			}
			
			columnWsiePrint(node.rt);
		}
	}
}
