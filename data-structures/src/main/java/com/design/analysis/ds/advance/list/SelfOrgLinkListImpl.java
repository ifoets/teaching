package com.design.analysis.ds.advance.list;

import com.design.analysis.ds.linklist.node.SOrgNode;

public class SelfOrgLinkListImpl implements ISelfOrgLinkList<Integer> {

	SOrgNode<Integer> head = null;
	SOrgNode<Integer> tail = null;

	/* creating list in mass */
	@Override
	public SOrgNode<Integer> massCreate(Integer[] n) {
		SOrgNode<Integer> temp = null;

		for (int i = 0; i < n.length; i++) {
			temp = new SOrgNode<Integer>(n[i]);
			if (head == null)
				head = tail = temp;
			else {
				tail.next = temp;
				tail = temp;
			}
		}
		return head;
	}

	/* insert the node based on sorted frquency */
	@Override
	public SOrgNode<Integer> insert(SOrgNode<Integer> n) {

		if (head == null)
			head = tail = n;
		else if (n.frq >= head.frq) {
			n.next = head;
			head = n;
		} else {
			SOrgNode<Integer> p = head;
			SOrgNode<Integer> pPrev = head;
			while (p.next != null) {
				if (pPrev.frq < n.frq && n.frq <= p.frq) // inset here
				{
					pPrev.next = n;
					n.next = p;
					break;
				}
				pPrev = p;
				p = p.next;
			}
			if (p.next == null) {
				p.next = n;
				tail = n;
			}
		}
		return head;
	}

	/* creating list in single unit by unit */
	@Override
	public SOrgNode<Integer> create(Integer n) {

		SOrgNode<Integer> temp = new SOrgNode<Integer>(n);
		if (head == null)
			head = tail = temp;
		else {
			tail.next = temp;
			tail = temp;
		}
		return head;
	}

	/* frequency arrangement is done and return element of search */
	@Override
	public SOrgNode<Integer> search(Integer n) {

		SOrgNode<Integer> serchNode = null;
		if (head != null) {
			if (head.n.equals(n)) {
				head.frq++;
				serchNode = head;
			} else {
				SOrgNode<Integer> delNode = delete(n);
				if (delNode != null) {
					delNode.frq++;
					serchNode = delNode;
					head = insert(delNode);
				}
			}
		}
		return serchNode;
	}

	@Override
	public SOrgNode<Integer> delete(Integer n) {
		SOrgNode<Integer> delNode = null;
		SOrgNode<Integer> p = head;
		SOrgNode<Integer> pPrev = head;

		if (head.n.equals(n)) {
			delNode = head;
			head = head.next;
			delNode.next = null;
		}
		for (; p != null; pPrev = p, p = p.next) {
			if (p.n.equals(n)) {
				delNode = p;
				pPrev.next = delNode.next;
				delNode.next = null;
				break;
			}
		}
		return delNode;
	}

	/* delering the element */
	@Override
	public void display(SOrgNode<Integer> head) {
		SOrgNode<Integer> p = head;
		while (p != null) {
			System.out.print(p.n + "(" + p.frq + ")");
			p = p.next;
		}
	}

	@Override
	public void display() {
		SOrgNode<Integer> p = head;
		while (p != null) {
			System.out.print(p.n + "(" + p.frq + ")");
			p = p.next;
		}
	}
}
