package com.design.analysis.core.ds.advance.btree;

import java.util.LinkedList;
import java.util.Queue;

import com.design.analysis.core.ds.node.BTNode;

public class AvlBSTreeImpl implements IAvlBSTree {

	@Override
	public BTNode create(BTNode node, int dt) {

		if (node == null)
			node = new BTNode(dt);
		
		if (dt <node.dt) {
				node.lt = create(node.lt, dt);
				node.lt.pt = node;
			} else if(dt>node.dt){
				node.rt = create(node.rt, dt);
				node.rt.pt = node;
			}
			else return node;
			
			//update height of node
			node.ht = 1 + max(height(node.lt),height(node.rt));
			
			//get balance factor and check whether unbalanced
			int balance = balance(node);
			
			// If this node becomes unbalanced, then
		    // there are 4 cases
		 
		    // Left Left Case
		    if (balance > 1 && dt < node.lt.dt)
		        return rightRotate(node);
		 
		    // Right Right Case
		    if (balance < -1 && dt > node.rt.dt)
		        return leftRotate(node);
		 
		    // Left Right Case
		    if (balance > 1 && dt > node.lt.dt)
		    {
		        node.lt =  leftRotate(node.lt);
		        return rightRotate(node);
		    }
		 
		    // Right Left Case
		    if (balance < -1 && dt < node.rt.dt)
		    {
		        node.rt = rightRotate(node.rt);
		        return leftRotate(node);
		    }
	
		    /* return the (unchanged) node pointer */
		    return node;
	}
	@Override
	public void inorderPrint(BTNode node){
		
		if(node!=null){
			inorderPrint(node.lt);
			System.out.print(node.dt+"->");
			inorderPrint(node.rt);
		}
	}
	@Override
	public void levelPrint(BTNode node) {

		Queue<BTNode> que = new LinkedList<>();
		que.add(node);
		while (!que.isEmpty()) {
			BTNode temp = que.poll();
			System.out.print("(" + temp.dt + ")");
			if (temp.lt != null)
				que.add(temp.lt);
			if (temp.rt != null)
				que.add(temp.rt);
		}

	}

	public BTNode leftRotate(BTNode x){
		
		BTNode y=x.rt;
		BTNode t1 = y.lt;
		x.rt=t1;
		y.lt=x;
		
		 // Update heights
		x.ht = max(height(x.lt), height(x.rt))+1;
	    y.ht = max(height(y.lt), height(y.rt))+1;
	   
	    // Return new root
	    return y;
		
	}

	public BTNode rightRotate(BTNode y){
	
		BTNode x = y.lt;
		BTNode t2=x.rt;
		x.rt = y;
		y.lt=t2;	
		
	    // Update heights
	    y.ht = max(height(y.lt), height(y.rt))+1;
	    x.ht = max(height(x.lt), height(x.rt))+1;
	 
	    // Return new root
	    return x;
	}
	@Override
	public void spirialPrintLeft(BTNode node) {
		// TODO Auto-generated method stub

	}

	@Override
	public void spiralPrintRight(BTNode node) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public int height(BTNode node) {
		
		if(node==null)
			return 0;
		return node.ht;
	}

	@Override
	public int max(int x, int y) {

		return x >= y ? x : y;
	}

	@Override
	public int balance(BTNode node) {
		if (node == null)
			return 0;

		return height(node.lt) - height(node.rt);
	}
	
	/*
	 * NEED TO VERITY 
	 * // right child only get left rotation
	@Override
	public BTNode leftRotate(BTNode node, BTNode actNode) {
		if (actNode.pt.lt == actNode)// if right child
		{
			System.out.println(actNode.dt + ": is left child so not possible to left rotation");
			return node;
		} else {
			if (actNode.pt == node) // ie action node is child node of root
			{
				BTNode temp = node.rt;
				node.rt = temp.lt;
				temp.lt = node;
				return temp;
			} // act node is not the child node of root
			else {
				BTNode temp = actNode.pt;
				temp.pt.lt = actNode;
				temp.lt = actNode.rt;
				actNode.rt = temp;
			}
		}
		return node;
	}

	// left child get right rotation only
	@Override
	public BTNode rightRotate(BTNode node, BTNode actNode) {

		if (actNode.pt.rt == actNode)// if right child
		{
			System.out.println(actNode.dt + ": is right child so not possible to right rotation");
			return node;
		} else {
			if (actNode.pt == node) // ie action node is child node of root
			{
				BTNode temp = node.lt;
				node.lt = temp.rt;
				temp.rt = node;
				return temp;
			} // act node is not the child node of root
			else {
				BTNode temp = actNode.pt;
				temp.pt.lt = actNode;
				temp.lt = actNode.rt;
				actNode.rt = temp;
			}
		}
		return node;
	}

	 */

}
