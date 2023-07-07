package com.design.analysis.core.ds.advance.threaded.bst;

import com.design.analysis.core.ds.node.DThreadNode;
import org.junit.Before;
import org.junit.Test;

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
