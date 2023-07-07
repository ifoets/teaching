package com.design.analysis.core.ds.advance.list;

import com.design.analysis.core.ds.linklist.node.SLNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.advance.list.node.ExpWayNode;
import com.design.analysis.core.ds.advance.list.node.HiWayNode;

public class ISkipListTest {

	public ISkipList<Integer> iskpl = null;

	@Before
	public void init() {
		iskpl = new SkipListImpl();
	}

	@Test
	public void massCreateTest() {

		Integer a[] = new Integer[106];
		for (int i = 0; i <= 50; i++)
			a[i] = i;
		for (int i = 105; i >= 50; i--)
			a[a.length - 105] = i;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null)
				a[i] = i;
		}
		SLNode<Integer> head = iskpl.massCreate(a);
		// iskpl.dispay(head);
		Assert.assertTrue(head.k == 0);
	}

	@Test
	public void createSortedTes() {
		Integer a[] = { 1, 2, 3, 4, 5, 0, 9, 8, 7, 6, 10 };
		SLNode<Integer> head = null;
		for (int i = 0; i < a.length; i++)
			head = iskpl.createSorted(a[i]);
		// iskpl.dispay(head);
		Assert.assertTrue(head.k == 0);
	}

	@Test
	public void createHiwayTest() {
		Integer a[] = new Integer[106];
		for (int i = 0; i <= 50; i++)
			a[i] = i;
		for (int i = 105; i >= 50; i--)
			a[a.length - 105 + i - 1] = i;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null)
				a[i] = i;
		}
		SLNode<Integer> head = iskpl.massCreate(a);
		HiWayNode<Integer> hiWayHead = iskpl.createHiway(head);
		// iskpl.dispayHiway(hiWayHead);
		Assert.assertTrue(hiWayHead.k == 0);
	}

	@Test
	public void createExpresswayTest() {
		Integer a[] = new Integer[106];
		for (int i = 0; i <= 50; i++)
			a[i] = i;
		for (int i = 105; i >= 50; i--)
			a[a.length - 105 + i - 1] = i;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null)
				a[i] = i;
		}
		SLNode<Integer> head = iskpl.massCreate(a);
		HiWayNode<Integer> hiWayHead = iskpl.createHiway(head);
		ExpWayNode<Integer> expHead = iskpl.createExpressway(hiWayHead);
		// iskpl.dispayExpway(expHead);
		Assert.assertTrue(expHead.k == 0);
	}

	@Test
	public void searchTest() {
		Integer a[] = new Integer[106];
		for (int i = 0; i <= 50; i++)
			a[i] = i;
		for (int i = 105; i >= 50; i--)
			a[a.length - 105 + i - 1] = i + 100;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null)
				a[i] = i;
		}
		SLNode<Integer> head = iskpl.massCreate(a);
		HiWayNode<Integer> hiWayHead = iskpl.createHiway(head);
		ExpWayNode<Integer> expHead = iskpl.createExpressway(hiWayHead);
		Assert.assertTrue(expHead.k == 0);
		// iskpl.dispay(head);
		Integer b[] = { 1, 19, 20, 4, 5, 200, 157, 205, 201, 150, 167, 105, 99, 110, 120 };
		for (int i = 0; i < b.length; i++) {
			SLNode<Integer> rs = iskpl.search(b[i]);
			if (i <= 10)
				Assert.assertTrue(rs.k.equals(b[i]));
			else
				Assert.assertTrue(rs == null);
		}
	}

	/* after use of search express way then hiway and then list deleing the node */
	@Test
	public void deleteTest() {
		Integer a[] = new Integer[106];
		for (int i = 0; i <= 50; i++)
			a[i] = i;
		for (int i = 105; i >= 50; i--)
			a[a.length - 105 + i - 1] = i + 100;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null)
				a[i] = i;
		}
		SLNode<Integer> head = iskpl.massCreate(a);
		HiWayNode<Integer> hiWayHead = iskpl.createHiway(head);
		ExpWayNode<Integer> expHead = iskpl.createExpressway(hiWayHead);
		Assert.assertTrue(expHead.k == 0);
		// iskpl.dispay(head);
		/*
		 * iskpl.dispayHiway(hiWayHead); iskpl.dispayExpway(expHead);
		 */
		//Integer b[] = { 1, 17, 20, 6, 5, 200, 157, 203, 201, 150, 167, 105, 99, 110, 120, 0, 205, 4, 9, 14, 19, 44 };
		Integer del[] = {2,3, 4, 9};//,0, 205 14, 19, 44 };
		for (int i = 0; i < del.length; i++)
			iskpl.delete(del[i]);
		iskpl.dispay();
		/*for (int i = 0; i < b.length; i++) {
			SLNode<Integer> rs = iskpl.search(b[i]);
			if (i <= 10)
				Assert.assertTrue(rs.k.equals(b[i]));
			else
				Assert.assertTrue(rs == null);
		}*/
	}
}
