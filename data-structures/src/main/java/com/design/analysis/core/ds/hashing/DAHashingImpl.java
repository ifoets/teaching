package com.design.analysis.core.ds.hashing;

import com.design.analysis.core.ds.hashing.node.HNodeLp;
import com.design.analysis.core.ds.hashing.node.HNodeTp;

public class DAHashingImpl implements DAIHashing {

	public HNodeLp lpT[] = null; // linear probing table
	public int maxlpSize = 0;

	public HNodeTp tpT[] = null; //// tree probing table
	public int maxtpSize = 0;

	/** end of operation on linear probing usring link list **/
	@Override
	public void listLinerProbingInsert(int a[], int maxSize) {
		lpT = new HNodeLp[maxSize];
		maxlpSize = maxSize;
		HNodeLp temp = null;

		for (int i = 0; i < a.length; i++) {
			int hash = hashOfListProb(a[i]);
			temp = new HNodeLp(a[i]);
			if (lpT[hash] == null)
				lpT[hash] = temp;
			else {
				HNodeLp p = lpT[hash];
				while (p.next != null)
					p = p.next;
				p.next = temp;
			}
		}
	}

	@Override
	public void listLinerProbingInsert(int x) {

		HNodeLp temp = null;
		int hash = hashOfListProb(x);

		temp = new HNodeLp(x);
		if (lpT[hash] == null)
			lpT[hash] = temp;
		else {
			HNodeLp p = lpT[hash];
			while (p.next != null)
				p = p.next;
			p.next = temp;
		}
	}

	@Override
	public void printListProb() {

		for (int i = 0; i < lpT.length; i++) {
			System.out.println();
			HNodeLp p = null;
			for (p = lpT[i]; p != null; p = p.next)
				System.out.print(p.dt + "->");
		}
	}

	@Override
	public boolean listLinerProbingSearch(int x) {

		boolean found = false;
		int hash = hashOfListProb(x);
		HNodeLp p = null;

		for (p = lpT[hash]; p != null; p = p.next) {
			if (p.dt == x) {
				found = true;
				break;
			}
		}
		return found;
	}

	@Override
	public void listLinerProbingDelete(int y) {
		// delete the link list node if found
	}

	@Override
	public int hashOfListProb(int x) {
		return (int) x % maxlpSize;
	}

	/** end of operation on linear probing using link list **/

	/** start operation on bst tree probing using link of bst **/
	@Override
	public HNodeTp create(HNodeTp node, int dt) {

		if (node == null)
			node = new HNodeTp(dt);
		else {
			if (dt <= node.dt) {
				node.lt = create(node.lt, dt);
				node.lt.pt = node;
			} else {
				node.rt = create(node.rt, dt);
				node.rt.pt = node;
			}
		}
		return node;
	}

	@Override
	public void bstTreeProbingInsert(int[] a, int maxSize) {
		tpT = new HNodeTp[maxSize];
		maxlpSize = maxSize;
		HNodeTp temp = null;

		for (int i = 0; i < a.length; i++) {
			int hash = hashOfTreeProb(a[i]);
			temp = new HNodeTp(a[i]);
			if (tpT[hash] == null)
				tpT[hash] = temp;
			else {
				tpT[hash] = create(tpT[hash], a[i]);
			}
		}
	}

	@Override
	public void bstTreeProbingInsert(int x) {
		HNodeTp temp = null;
		int hash = hashOfTreeProb(x);

		temp = new HNodeTp(x);
		if (tpT[hash] == null)
			tpT[hash] = temp;
		else {
			tpT[hash] = create(tpT[hash], x);
		}
	}

	@Override
	public boolean bstTreeProbingSearch(int x) {
		
		return recursveSearch(tpT[hashOfTreeProb(x)], x);
	}

	@Override
	public boolean recursveSearch(HNodeTp node, int key) {
		if (node == null) {
			return false;
		}
		if (node.dt == key) {
			return true;
		}
		if (!recursveSearch(node.lt, key) && !recursveSearch(node.rt, key)) {
			return false;
		}
		return true;
	}
	@Override
	public void bstTreeProbingDelete(int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public int hashOfTreeProb(int x) {
		return (int) (x % 10);
	}

	@Override
	public void printbstTreeProb() {

		for (int i = 0; i < tpT.length; i++) {
			System.out.println();
			print(tpT[i]);
		}
	}

	@Override
	public void print(HNodeTp hashRoot) {
		if (hashRoot != null) {
			print(hashRoot.lt);
			System.out.print(hashRoot.dt + "->");
			print(hashRoot.rt);
		}
	}
	/** end operation on bst tree probing using link of bst **/
	
	
}
