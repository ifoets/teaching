package com.design.analysis.core.ds.hashing;

import java.util.List;
import java.util.Map;

import com.design.analysis.core.ds.hashing.node.HTreeNode;

public interface DAIHashingWithTree {

	public HTreeNode createBstIndexTree(HTreeNode node, int dt, int index);

	/* arrangement of node in index/height as key of map by inorder traverse */
	public void nodeOnIndex(Map<Integer, List<HTreeNode>> map, HTreeNode node);

	public void nodeOnLabel(Map<Integer, List<HTreeNode>> map, HTreeNode node);

	public void nodeOnLabelMinusIndex(Map<Integer, List<HTreeNode>> map, HTreeNode node);

	public void nodeOnLabelPlusIndex(Map<Integer, List<HTreeNode>> map, HTreeNode node);

	public Map<Integer, List<HTreeNode>> printColumWise(HTreeNode node);

	/** side view of tree top, bottom, left and right **/
	public List<Integer> printBottomView(HTreeNode node);

	public List<Integer> printTomView(HTreeNode node);

	/* this is also the same of +90 degree rotational view */
	public List<Integer> printLeftView(HTreeNode node);

	/* this is also the same of -90 degree rotational view */
	public List<Integer> printRightView(HTreeNode node);

	/** corner view of tree top-left, bottom-left, bottom-right and top-right **/
	public List<Integer> topLeftCornerView(HTreeNode node);

	public List<Integer> bottomRightCornerView(HTreeNode node);

	public List<Integer> bottomLeftCornerView(HTreeNode node);

	public List<Integer> topRightCornerView(HTreeNode node);

	public void printInorder(HTreeNode node);

	public void printHashMap(Map<Integer, Integer> map);

}
