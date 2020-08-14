package com.design.analysis.ds.advance.list;

import com.design.analysis.ds.advance.list.node.UnrollListNode;
import com.design.analysis.ds.common.model.Product;

public class UnrollListImpl implements IUnrollList<Product> {
	public UnrollListNode<Product> head = null;

	@Override
	public UnrollListNode<Product> createInMass(Product[] pl) {

		UnrollListNode<Product> p = null;
		if (head == null)
			head = new UnrollListNode<>(1);

		for (int i = 0; i < pl.length; i++) {
			int pType = pl[i].pTypeId;
			p = head;
			int j = 1;
			for (; j < pType; j++, p = p.next) {
				if (p.next == null)
					p.next = new UnrollListNode<>(j + 1);
			}
			if (j == pType) {
				p.u[pl[i].mno] = pl[i];
			}

		}
		return head;
	}

	@Override
	public UnrollListNode<Product> createInUnit(Product prd) {
		UnrollListNode<Product> p = null;
		if (head == null)
			head = new UnrollListNode<>(1);

		int pType = prd.pTypeId;
		p = head;
		int j = 1;
		for (; j < pType; j++, p = p.next) {
			if (p.next == null)
				p.next = new UnrollListNode<>(j + 1);
		}
		if (j == pType) {
			p.u[prd.mno] = prd;
		}

		return head;
	}

	@Override
	public Product search(UnrollListNode<Product> head, Product prd) {
		UnrollListNode<Product> p = head;
		int pType = prd.pTypeId;
		int j = 1;
		for (; j < pType && p != null; j++, p = p.next)
			;
		if (j == pType) {
			if (p.u[prd.mno] != null)
				return p.u[prd.mno];
		}
		return null;
	}

	@Override
	public boolean delete(UnrollListNode<Product> head, Product prd) {
		UnrollListNode<Product> p = head;
		int pType = prd.pTypeId;
		int j = 1;
		for (; j < pType && p != null; j++, p = p.next)
			;
		if (j == pType) {
			if (p.u[prd.mno] != null) {
				p.u[prd.mno] = null;
				return true;
			}
		}
		return false;
	}

	@Override
	public void display(UnrollListNode<Product> head) {
		UnrollListNode<Product> p = head;

		while (p != null) {
			System.out.println("PTyepId:" + p.uType);
			for (int i = 0; i < p.u.length; i++) {
				if (p.u[i] != null)
					System.out.print(p.u[i] + "->");
			}
			System.out.println();
			p = p.next;
		}
	}

	@Override
	public void dispaly() {

		UnrollListNode<Product> p = head;

		while (p != null) {
			System.out.println("PTyepId:" + p.uType);
			for (int i = 0; i < p.u.length; i++) {
				if (p.u[i] != null)
					System.out.print(p.u[i] + "->");
			}
			System.out.println();
			p = p.next;
		}
	}
}
