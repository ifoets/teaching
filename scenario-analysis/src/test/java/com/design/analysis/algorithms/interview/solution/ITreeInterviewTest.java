package com.design.analysis.algorithms.interview.solution;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algorithms.interview.node.TNode;

public class ITreeInterviewTest {

	public ITreeInterview<Long> it = null;

	@Before
	public void init() {
		it = new TreeInterviewImpl();
	}

	@Test
	public void print() {

		TNode<Long> root = it.creazyTree(10);
		it.print(root);
	}

	@Test
	public void query() {
		TNode<Long> root = it.creazyTree(3);
		it.print(root);
		System.out.println(it.query(2, 1, 1));
		if (root != null) {
			Assert.assertTrue(it.query(1, 1, 1) == 24);
			Assert.assertTrue(it.query(3, 1, 4) == 10);
			Assert.assertTrue(it.query(2, 1, 2) == 14);
		}
	}
}
