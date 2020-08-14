package com.design.analysis.ds.advance.list;

import com.design.analysis.ds.advance.list.node.ExpWayNode;
import com.design.analysis.ds.advance.list.node.HiWayNode;
import com.design.analysis.ds.linklist.node.SLNode;

public interface ISkipList<K> {

	/* use mass data for creatng list */
	public SLNode<K> massCreate(K[] k);

	/* use single data for creatng list */
	public SLNode<K> createSorted(K k);

	/* create hiway on top of list for travelle fast */
	public HiWayNode<K> createHiway(SLNode<K> head);

	/* create express way on top of hiway for travelle faster */
	public ExpWayNode<K> createExpressway(HiWayNode<K> head);

	/* search use of express way then hiway and list */
	public SLNode<K> search(K k);

	/* after use of search express way then hiway and then list deleing the node */
	public boolean delete(K k);

	/* print list */
	public void dispay(SLNode<Integer> head);

	public void dispay();

	/* pring hiway */
	public void dispayHiway(HiWayNode<Integer> head);

	public void dispayHiway();

	/* print express way */
	public void dispayExpway(ExpWayNode<Integer> head);

	public void dispayExpway();
}
