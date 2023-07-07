package com.design.analysis.core.ds.bst;

import com.design.analysis.core.ds.node.BTNode;

public interface IBSTree {

    public BTNode create(BTNode node, int dt);
		
	public void levelPrint(BTNode node);
	
	public void spirialPrintLeft(BTNode node);
	
	public void spiralPrintRight(BTNode node);
}
