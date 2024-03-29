package com.design.analysis.core.ds.advance.threaded.bst;

import com.design.analysis.core.ds.node.STBstNode;
import org.junit.Before;
import org.junit.Test;

public class ISThreadBstTest {

	public ISThreadBst<Integer> istb = null;

	@Before
	public void init() {
		istb = new SThreadBstImpl();
	}

	@Test // hole method is testing here only
	public void singleThreadedTest() {

		STBstNode<Integer> root = null;
		int a[] = {5,3,4};//{ 5, 3, 7, 6, 9, 8, 10, 4, 1, 2, 0 };
		for (int i = 0; i < a.length; i++)
			root = istb.createSThreadBst(root, a[i]);
		istb.display(root);
	}
}
