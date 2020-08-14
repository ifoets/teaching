package com.design.analysis.ds.advance.btree;

import com.design.analysis.ds.advance.btree.SpecialBinaryTreeImpl;
import com.design.analysis.ds.node.BTNode;

public class ISpecialBinaryTreeTest {

	public static void main(String[] args) {
		SpecialBinaryTreeImpl impl = new SpecialBinaryTreeImpl();
		BTNode root = null;

		for (int i = 0; i < 10; i++) {
			root = impl.create(root, i);
		}
		impl.columnWsiePrint(root);
		System.out.println(impl.map);
		
		impl.levelPrint(root);
		System.out.println(impl.map);
	}
}
