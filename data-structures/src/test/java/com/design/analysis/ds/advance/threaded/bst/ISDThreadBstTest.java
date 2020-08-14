package com.design.analysis.ds.advance.threaded.bst;

import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.advance.threaded.bst.DThreadBstImpl;
import com.design.analysis.ds.advance.threaded.bst.IDThreadBst;
import com.design.analysis.ds.node.DThreadNode;

public class ISDThreadBstTest {

	DThreadNode root = null;
	IDThreadBst dtb = null;

	@Before
	public void init() {
		dtb = new DThreadBstImpl();
	}

	@Test
	public void createTest() {

	}
}
