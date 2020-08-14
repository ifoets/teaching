package com.design.analysis.ds.binarytree;

import java.util.List;

import com.design.analysis.ds.tree.node.BTNode;

/*
 * 
 * @author GuruG
 * 
 * Construction & Conversion :
 * 0.1 Consturct tree using given preorder travel as list
 * 0.2 Consturct tree using given postorder travel as list
 * 0.3 Consturct tree using given inorder travel as list
 * 
1.	Construct Tree from given Inorder and Preorder traversals
2.	Construct a tree from Inorder and Level order traversals
3.	Construct Complete Binary Tree from its Linked List Representation
4.	Construct Full Binary Tree from given preorder and postorder traversals
5.	Construct a special tree from given preorder traversal
6.	Construct tree from ancestor matrix
7.	Construct Ancestor Matrix from a Given Binary Tree
8.	Construct Special Binary Tree from given Inorder traversal
9.	Construct Binary Tree from given Parent Array representation
10.	Construct a Binary Tree from Postorder and Inorder
11.	Create a Doubly Linked List from a Ternary Tree
12.	Creating a tree with Left-Child Right-Sibling Representation
13.	Convert a given Binary Tree to Doubly Linked List | Set 1
14.	Convert a given Binary Tree to Doubly Linked List | Set 2
15.	Convert a given Binary Tree to Doubly Linked List | Set 3
16.	Convert a given Binary Tree to Doubly Linked List | Set 4
17.	Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
18.	Convert a Binary Tree to Threaded binary tree | Set 1 (Using Queue)
19.	Convert a Binary Tree to Threaded binary tree | Set 2 (Efficient)
20.	Convert left-right representation of a binary tree to down-right
21.	Convert a given tree to its Sum Tree
22.	Change a Binary Tree so that every node stores sum of all nodes in left subtree
23.	Write an Efficient Function to Convert a Binary Tree into its Mirror Tree
24.	Convert a normal BST to Balanced BST
25.	Convert a Binary Tree into Doubly Linked List in spiral fashion
26.	Convert a Binary Tree to a Circular Doubly Link List
27.	Convert a tree to forest of even nodes
28.	Convert a given Binary tree to a tree that holds Logical AND property
29.	Convert Ternary Expression to a Binary Tree

 */
public interface IConstructConvert<T> {

	public BTNode<T> createPositionTree(BTNode<T> node, T key, T t, boolean ltOrRt);

	public BTNode<T> findNode(BTNode<T> node, T x);

	public void inorderPrint(BTNode<T> node);

	// R&D
	/** 0.1 Consturct tree using given preorder travel as list **/
	public BTNode<T> createbstUsingPreorderList(BTNode<T> node, List<T> l);

	public BTNode<Integer> createFromPre(BTNode<T> node, String str);

	/** 0.2 Consturct tree using given postorder travel as list **/
	public BTNode<T> createbstUsingPostorderList(BTNode<T> node, List<T> l);

	public BTNode<Integer> createFromPost(BTNode<T> node, String str);

	// end of R&D
	/** 0.3 Consturct tree using given inorder travel as list **/
	public BTNode<T> createbstUsingInorderderList(BTNode<T> node, List<T> l);

	public BTNode<Integer> createFromIn(BTNode<Integer> node, String str);

	/** 1. Construct Tree from given Inorder and Preorder traversals **/
	public BTNode<T> buildTreeFromGivenInorderPreorder(T[] in, T[] pre);

	/** 2. Construct a tree from Inorder and Level order traversals **/
	public BTNode<T> buildTreeFromGivenInorderlevelorder(T[] in, T[] lev);

	public BTNode<T> findInsertPostion(BTNode<T> node);
	/* 3. Construct Complete Binary Tree from its Linked List Representation */
	/* 4. Construct Full Binary Tree from given preorder and postorder traversals */
	/* 5. Construct a special tree from given preorder traversal */
	/* 6. Construct tree from ancestor matrix */
	/* 7. Construct Ancestor Matrix from a Given Binary Tree */
	/* 8. Construct Special Binary Tree from given Inorder traversal */
	/* 9. Construct Binary Tree from given Parent Array representation */
	/* 10. Construct a Binary Tree from Postorder and Inorder */
}
