package com.design.analysis.core.ds.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.design.analysis.core.ds.hashing.node.HTreeNode;

public class DAIHashingWithTreeImpl implements DAIHashingWithTree {

	Map<Integer, Integer> map = new HashMap<>();

	/* comparator used for sort the list index wise or height wise */
	public static Comparator<HTreeNode> heightComp = new Comparator<HTreeNode>() {
		@Override
		public int compare(HTreeNode o1, HTreeNode o2) {
			return o1.hIndex - o2.hIndex;
		}
	};

	public static Comparator<HTreeNode> indexComp = new Comparator<HTreeNode>() {
		@Override
		public int compare(HTreeNode o1, HTreeNode o2) {
			return o1.index - o2.index;
		}
	};

	/*
	 * public static Comparator<HTreeNode> indexHeightComp = new
	 * Comparator<HTreeNode>() {
	 * 
	 * @Override public int compare(HTreeNode o1, HTreeNode o2) { return o1.index -
	 * o2.index; } };
	 */

	@Override
	public HTreeNode createBstIndexTree(HTreeNode node, int dt, int index) {

		if (node == null) {
			node = new HTreeNode(dt);
			node.index = index;
		} else {
			if (dt <= node.dt) {
				node.lt = createBstIndexTree(node.lt, dt, --index);
				node.lt.hIndex = Math.abs(node.hIndex) + 1;
			} else {
				node.rt = createBstIndexTree(node.rt, dt, ++index);
				node.rt.hIndex = Math.abs(node.hIndex) + 1;
			}

		}
		return node;
	}

	@Override
	public void printInorder(HTreeNode node) {
		if (node != null) {
			printInorder(node.lt);
			System.out.print(node.dt + "[" + node.index + "]->");
			printInorder(node.rt);
		}
	}

	@Override
	public void printHashMap(Map<Integer, Integer> map) {
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.print(entry.getValue() + "->");
		}
	}

	@Override
	public void nodeOnIndex(Map<Integer, List<HTreeNode>> map, HTreeNode node) {
		if (map == null)
			return;
		if (node != null) {
			nodeOnIndex(map, node.lt);
			if (map.containsKey(node.index)) {
				List<HTreeNode> list = (List<HTreeNode>) map.get(node.index);
				list.add(node);
				map.put(node.index, list);
			} else {
				List<HTreeNode> list = new ArrayList<>();
				list.add(node);
				map.put(node.index, list);
			}
			nodeOnIndex(map, node.rt);
		}
	}

	@Override
	public void nodeOnLabel(Map<Integer, List<HTreeNode>> map, HTreeNode node) {
		if (map == null)
			return;
		if (node != null) {
			nodeOnLabel(map, node.lt);
			if (map.containsKey(node.hIndex)) {
				List<HTreeNode> list = (List<HTreeNode>) map.get(node.hIndex);
				list.add(node);
				map.put(node.hIndex, list);

			} else {
				List<HTreeNode> list = new ArrayList<>();
				list.add(node);
				map.put(node.hIndex, list);
			}
			nodeOnLabel(map, node.rt);
		}
	}

	@Override
	public void nodeOnLabelMinusIndex(Map<Integer, List<HTreeNode>> map, HTreeNode node) {
		if (map == null)
			return;
		if (node != null) {
			nodeOnLabelMinusIndex(map, node.lt);
			if (map.containsKey(node.hIndex - node.index)) {
				List<HTreeNode> list = (List<HTreeNode>) map.get(node.hIndex - node.index);
				list.add(node);
				map.put(node.hIndex - node.index, list);

			} else {
				List<HTreeNode> list = new ArrayList<>();
				list.add(node);
				map.put(node.hIndex - node.index, list);
			}
			nodeOnLabelMinusIndex(map, node.rt);
		}
	}

	@Override
	public void nodeOnLabelPlusIndex(Map<Integer, List<HTreeNode>> map, HTreeNode node) {
		if (map == null)
			return;
		if (node != null) {
			nodeOnLabelPlusIndex(map, node.lt);
			if (map.containsKey(node.hIndex + node.index)) {
				List<HTreeNode> list = (List<HTreeNode>) map.get(node.hIndex + node.index);
				list.add(node);
				map.put(node.hIndex + node.index, list);
			} else {
				List<HTreeNode> list = new ArrayList<>();
				list.add(node);
				map.put(node.hIndex + node.index, list);
			}
			nodeOnLabelPlusIndex(map, node.rt);
		}
	}

	@Override
	public Map<Integer, List<HTreeNode>> printColumWise(HTreeNode node) {
		Map<Integer, List<HTreeNode>> mapColumnWiseprintMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnIndex(mapColumnWiseprintMap, node);
		return mapColumnWiseprintMap;
	}

	@Override
	public List<Integer> printBottomView(HTreeNode node) {

		Map<Integer, List<HTreeNode>> botmViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnIndex(botmViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : botmViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, heightComp);
			rsList.add(list.get(list.size() - 1).dt);
		}
		return rsList;
	}

	@Override
	public List<Integer> printTomView(HTreeNode node) {
		Map<Integer, List<HTreeNode>> topViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnIndex(topViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : topViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, heightComp);
			rsList.add(list.get(0).dt);
		}
		return rsList;
	}

	@Override
	public List<Integer> printLeftView(HTreeNode node) {

		Map<Integer, List<HTreeNode>> leftViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnLabel(leftViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : leftViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, indexComp);
			rsList.add(list.get(0).dt);
		}
		return rsList;
	}

	public Map<Integer, List<HTreeNode>> rightViewMap = null;

	@Override
	public List<Integer> printRightView(HTreeNode node) {

		Map<Integer, List<HTreeNode>> rightViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnLabel(rightViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : rightViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, indexComp);
			rsList.add(list.get(list.size() - 1).dt);
		}
		return rsList;
	}

	/**
	 * square corner view of tree top-left, bottom-left, bottom-right and top-right
	 **/

	@Override
	public List<Integer> topLeftCornerView(HTreeNode node) {

		Map<Integer, List<HTreeNode>> topLeftCornerViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnLabelMinusIndex(topLeftCornerViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : topLeftCornerViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, indexComp);
			rsList.add(list.get(0).dt);
		}
		return rsList;
	}

	@Override
	public List<Integer> bottomRightCornerView(HTreeNode node) {
		Map<Integer, List<HTreeNode>> topLeftCornerViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnLabelMinusIndex(topLeftCornerViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : topLeftCornerViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, indexComp);
			rsList.add(list.get(list.size() - 1).dt);
		}
		return rsList;
	}

	@Override
	public List<Integer> bottomLeftCornerView(HTreeNode node) {
		Map<Integer, List<HTreeNode>> bottomLeftCornerViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnLabelPlusIndex(bottomLeftCornerViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : bottomLeftCornerViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, heightComp);
			rsList.add(list.get(list.size() - 1).dt);
		}
		return rsList;
	}

	@Override
	public List<Integer> topRightCornerView(HTreeNode node) {
		Map<Integer, List<HTreeNode>> topRightCornerViewMap = new TreeMap<Integer, List<HTreeNode>>();
		nodeOnLabelPlusIndex(topRightCornerViewMap, node);
		List<Integer> rsList = new ArrayList<>();

		for (Map.Entry<Integer, List<HTreeNode>> mapEntry : topRightCornerViewMap.entrySet()) {
			List<HTreeNode> list = mapEntry.getValue();
			Collections.sort(list, heightComp);
			rsList.add(list.get(0).dt);
		}
		return rsList;
	}
}
