package com.design.analysis.ds.advance.list;
/* This is mainly used for fast seraching in singl link list using express way or more more faster path in sorted link list*/

import com.design.analysis.ds.advance.list.node.ExpWayNode;
import com.design.analysis.ds.advance.list.node.HiWayNode;
import com.design.analysis.ds.linklist.node.SLNode;

public class SkipListImpl implements ISkipList<Integer> {

	public SLNode<Integer> head = null;
	public SLNode<Integer> tail = null;
	public HiWayNode<Integer> hiwayHead = null;
	public HiWayNode<Integer> hiwayTail = null;
	public ExpWayNode<Integer> expHead = null; // express way and so on
	public ExpWayNode<Integer> expTail = null;

	/* use mass data for creatng list */
	@Override
	public SLNode<Integer> massCreate(Integer[] a) {

		for (int i = 0; i < a.length; i++) {
			SLNode<Integer> temp = new SLNode<Integer>(a[i]);
			if (head == null) {
				head = tail = temp;
			} else if (a[i] <= head.k) { // = applied later
				temp.next = head;
				head = temp;
			} else {
				SLNode<Integer> p = head;
				while (p.next != null) {
					if (a[i] <= p.next.k) { // = applied later
						temp.next = p.next;
						p.next = temp;
						break;
					}
					p = p.next;
				}
				if (p.next == null) {
					p.next = temp;
					tail = temp;
				}
			}
		}
		return head;
	}

	/* use single data for creatng list */
	@Override
	public SLNode<Integer> createSorted(Integer k) {

		SLNode<Integer> temp = new SLNode<Integer>(k);
		if (head == null) {
			head = tail = temp;
		} else if (k <= head.k) { // = applied later
			temp.next = head;
			head = temp;
		} else {
			SLNode<Integer> p = head;
			while (p.next != null) {
				if (k <= p.next.k) { // = applied later
					temp.next = p.next;
					p.next = temp;
					break;
				}
				p = p.next;
			}
			if (p.next == null)
				p.next = temp;
		}
		return head;
	}

	/* create hiway on top of list for travelle fast */
	@Override
	public HiWayNode<Integer> createHiway(SLNode<Integer> head) {
		int i = 1;
		SLNode<Integer> temp = head;
		HiWayNode<Integer> node = null;

		if (head != null) {
			node = new HiWayNode<Integer>(head.k);
			node.dn = head;
			node.next = null;
			hiwayHead = hiwayTail = node;
		}
		while (temp != tail) {
			if (i % 5 == 0) {
				node = new HiWayNode<Integer>(temp.k);
				node.dn = temp;
				hiwayTail.next = node;
				hiwayTail = hiwayTail.next;
			}
			i++;
			temp = temp.next;
		}

		node = new HiWayNode<Integer>(tail.k);
		node.dn = tail;
		hiwayTail.next = node;
		hiwayTail = hiwayTail.next;
		return hiwayHead;
	}

	/* create express way on top of hiway for travelle faster */
	@Override
	public ExpWayNode<Integer> createExpressway(HiWayNode<Integer> head) {
		int i = 1;
		HiWayNode<Integer> temp = head;
		ExpWayNode<Integer> node = null;

		if (head != null) {
			node = new ExpWayNode<Integer>(head.k);
			node.dn = head;
			node.next = null;
			expHead = expTail = node;
		}
		while (temp != hiwayTail) {
			if (i % 5 == 0) {
				node = new ExpWayNode<Integer>(temp.k);
				node.dn = temp;
				expTail.next = node;
				expTail = expTail.next;
			}
			i++;
			temp = temp.next;
		}

		node = new ExpWayNode<Integer>(hiwayTail.k);
		node.dn = hiwayTail;
		expTail.next = node;
		expTail = expTail.next;
		return expHead;
	}

	/* search use of express way then hiway and list */
	@Override
	public SLNode<Integer> search(Integer k) {

		if (expHead != null) {
			ExpWayNode<Integer> e = expHead;
			ExpWayNode<Integer> ePrev = expHead;
			while (e != null) {
				if (ePrev.k <= k && k <= e.k)
					break;
				ePrev = e;
				e = e.next;
			}
			if (e == null)
				return null;

			HiWayNode<Integer> h = ePrev.dn;
			HiWayNode<Integer> hPrev = e.dn;
			while (h != null) {
				if (hPrev.k <= k && k <= h.k)
					break;
				hPrev = h;
				h = h.next;
			}
			if (h == null)
				return null;
			SLNode<Integer> slH = hPrev.dn;
			SLNode<Integer> slT = hPrev.next != null ? hPrev.next.dn : null;
			while (slH != slT) {
				if (slH.k.equals(k))
					return slH;
				slH = slH.next;
			}
			// for last node
			if (slT != null && slT.k.equals(k))
				return slH;
		}
		return null;
	}

	/* after use of search express way then hiway and then list deleing the node */
	// after deletion may be node pointed by hiway node may be deleted the need to
	// extra take care
	@Override // TODO
	public boolean delete(Integer k) {
		SLNode<Integer> del = null;

		if (head != null) {// first element is del node
			if (head.k.equals(k)) {
				del = head;
				head = head.next;
				del.next = null;
				del = null;
				hiwayHead.k = head.k;
				hiwayHead.dn = head;
				expHead.k = k;
				return true;
			}
		}
		if (expTail.dn.dn.k.equals(k))// last elemt is del node
		{
			ExpWayNode<Integer> ex = expHead;
			while (ex.next != expTail)
				ex = ex.next;
			HiWayNode<Integer> hi = ex.dn;
			while (hi.next != hiwayTail)
				hi = hi.next;
			SLNode<Integer> h = hi.dn;
			while (h.next != tail)
				h = h.next;
			del = tail;
			tail = h;
			tail.next = null;
			hiwayTail.k = k;
			expHead.k = k;
			hiwayTail.dn = tail;
			del = null;
			return true;
		}
		if (expHead != null) {
			ExpWayNode<Integer> e = expHead;
			ExpWayNode<Integer> ePrev = expHead;
			while (e != null) {
				if (ePrev.k < k && k <= e.k)
					break;
				ePrev = e;
				e = e.next;
			}
			if (e == null)
				return false;

			HiWayNode<Integer> h = ePrev.dn;
			HiWayNode<Integer> hPrev = e.dn;
			while (h != null) {
				if (hPrev.k < k && k <= h.k)
					break;
				hPrev = h;
				h = h.next;
			}
			if (h == null)
				return false;
			SLNode<Integer> delHead = hPrev.dn;
			SLNode<Integer> delTail = h.dn;// this is going to delete
			if (h.k.equals(k))// deleting the node pointed by hiWayNode
			{
				while (delHead.next != delTail)
					delHead = delHead.next;
				del = delTail;
				delHead = del.next;
				h.dn = del.next;
				h.k = del.next.k;
				del.next = null;
				del = null;
				return true;
			} else {
				SLNode<Integer> delHeadPrev = hPrev.dn;
				while (delHead != delTail) {
					if (delHead.k.equals(k)) {
						del = delHead;
						delHeadPrev.next = del.next;
						del.next = null;
						del = null;
						return true;
					}
					delHeadPrev = delHead;
					delHead = delHead.next;
				}

			}
		}
		return false;
	}

	/* print list */
	@Override
	public void dispay(SLNode<Integer> head) {
		int i = 0;
		SLNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.k + "->");
			temp = temp.next;
			i++;
			if (i % 20 == 0)
				System.out.println();
		}
	}

	@Override
	public void dispay() {
		int i = 0;
		SLNode<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.k + "->");
			temp = temp.next;
			i++;
			if (i % 20 == 0)
				System.out.println();
		}
	}

	/* pring hiway */
	@Override
	public void dispayHiway(HiWayNode<Integer> hiwayHead) {
		int i = 0;
		System.out.println("\nHiway express:-");
		HiWayNode<Integer> node = hiwayHead;
		while (node != null) {
			System.out.print(node.k + "->");
			node = node.next;
			i++;
			if (i % 10 == 0)
				System.out.println();
		}
	}

	@Override
	public void dispayHiway() {
		int i = 0;
		System.out.println("\nHiway express:-");
		HiWayNode<Integer> node = hiwayHead;
		while (node != null) {
			System.out.print(node.k + "->");
			node = node.next;
			i++;
			if (i % 10 == 0)
				System.out.println();
		}
	}

	/* print express way */
	@Override
	public void dispayExpway(ExpWayNode<Integer> expHead) {
		int i = 0;
		System.out.println("\nExpress way:-");
		ExpWayNode<Integer> node = expHead;
		while (node != null) {
			System.out.print(node.k + "->");
			node = node.next;
			i++;
			if (i % 5 == 0)
				System.out.println();
		}
	}

	@Override
	public void dispayExpway() {
		int i = 0;
		System.out.println("\nExpress way:-");
		ExpWayNode<Integer> node = expHead;
		while (node != null) {
			System.out.print(node.k + "->");
			node = node.next;
			i++;
			if (i % 5 == 0)
				System.out.println();
		}
	}
}
