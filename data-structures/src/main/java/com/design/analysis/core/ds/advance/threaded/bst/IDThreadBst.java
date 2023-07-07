package com.design.analysis.core.ds.advance.threaded.bst;

import com.design.analysis.core.ds.node.DThreadNode;

public interface IDThreadBst {

	public DThreadNode create(DThreadNode node, int dt);

	public DThreadNode successor(DThreadNode node, int dt);

	public DThreadNode predecessor(DThreadNode node, int dt);

	public void display();
}
