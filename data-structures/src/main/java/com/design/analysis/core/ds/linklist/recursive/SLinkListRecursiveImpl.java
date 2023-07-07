package com.design.analysis.core.ds.linklist.recursive;

import com.design.analysis.core.ds.node.SLNode;

public class SLinkListRecursiveImpl implements ISLinkListRecursive {

	public SLNode create(SLNode node, int dt) {
		if (node == null)
			return new SLNode(dt);
		else {
			node.next = create(node.next, dt);
			return node;
		}
	}

	public void display(SLNode node) {
		if (node == null)
			return;
		System.out.print(node.dt + "->");
		display(node.next);
	}

	public int length(SLNode node) {
		if (node == null)
			return 0;
		return 1 + length(node.next);
	}

	public int sum(SLNode node) {
		if (node == null)
			return 0;
		return node.dt + sum(node.next);
	}

	public void reversePrint(SLNode node) {
		if (node == null)
			return;
		reversePrint(node.next);
		System.out.print(node.dt + "->");
	}

	public int search(SLNode node, int key) {
		if (node == null) {
			System.out.println(key + "not found");
			return -1;
		} else if (node.dt == key)
			return key;
		else
			return search(node.next, key);
	}

	public SLNode addRear(SLNode node, int key) {
		if (node == null)
			return null;
		else {
			SLNode head = new SLNode(key);
			head.next = node;
			return head;
		}
	}
	public SLNode addAtPoistion(SLNode node,int key,int pos, int i)
	{
		//TODO
		/*if(node==null || pos==0)
		{
			System.out.println("Position is out of range");
			return node;
		}else if(pos==1)
				return addRear(node,key);
		else
		{
			if(pos==i+2)
			{
			  SLNode newNode = new SLNode(key);
			  newNode.next=node.next;
			  node.next=newNode;
			}
			addAtPoistion(node, key, pos, i++);
			return node;
		}*/
		return null;
	}
}
