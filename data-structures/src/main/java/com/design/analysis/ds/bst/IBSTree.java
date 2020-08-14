package com.design.analysis.ds.bst;

import com.design.analysis.ds.node.BTNode;

public interface IBSTree {

    public BTNode create(BTNode node, int dt);
		
	public void levelPrint(BTNode node);
	
	public void spirialPrintLeft(BTNode node);
	
	public void spiralPrintRight(BTNode node);
}
