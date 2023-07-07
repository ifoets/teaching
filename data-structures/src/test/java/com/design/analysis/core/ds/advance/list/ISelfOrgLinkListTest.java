package com.design.analysis.core.ds.advance.list;

import com.design.analysis.core.ds.linklist.node.SOrgNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ISelfOrgLinkListTest {

	public ISelfOrgLinkList<Integer> isol = null;

	@Before
	public void init() {
		isol = new SelfOrgLinkListImpl();
	}

	/* creating list in mass */
	@Test
	public void massCreateTest() {

		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SOrgNode<Integer> head = isol.massCreate(a);
		Assert.assertTrue(head.n == 1 && head.frq == 0);
		// isol.display(head);
	}

	/* insert the node based on sorted frquency */
	@Test
	public void insertTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SOrgNode<Integer> head = isol.massCreate(a);
		SOrgNode<Integer> sl = new SOrgNode<Integer>(10);
		sl.frq = 1;
		// head = isol.insert(sl);
		isol.display(head);
		Assert.assertTrue(head.n == 10 && head.frq == 1);
	}

	/* creating list in single unit by unit */
	@Test
	public void createTest() {

	}

	/* frequency arrangement is done and return element of search */
	@Test
	public void searchTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SOrgNode<Integer> head = isol.massCreate(a);
		Integer b[] = { 1, 2, 2, 3, 3, 3 };
		Assert.assertTrue(head.n == 1 && head.frq == 0);
		SOrgNode<Integer> searchNode = null;
		for (int i = 0; i < b.length; i++) {
			searchNode = isol.search(b[i]);
			Assert.assertTrue(searchNode.n.equals(b[i]));
		}
		isol.display();
	}

	/* delering the element */
	@Test
	public void deleteTest() {
		Integer a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		SOrgNode<Integer> head = isol.massCreate(a);
		Assert.assertTrue(head.n == 1 && head.frq == 0);
		Integer b[] = { 1, 2, 5, 8, 9 };
		SOrgNode<Integer> delNode = null;
		for (int i = 0; i < b.length; i++) {
			delNode = isol.delete(b[i]);
			Assert.assertTrue(delNode.n == b[i]);
		}
		// isol.display();
	}
}
