package com.design.analysis.ds.advance.threaded.bst;

import com.design.analysis.ds.node.DThreadNode;

public interface IDThreadBst {

	public DThreadNode create(DThreadNode node, int dt);

	public DThreadNode successor(DThreadNode node, int dt);

	public DThreadNode predecessor(DThreadNode node, int dt);

	public void display();
}
