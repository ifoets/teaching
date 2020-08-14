package com.design.analysis.ds.hashing;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.hashing.node.HTreeNode;

public class DAIHashingWithTreeTest {

	HTreeNode root = null;
	DAIHashingWithTree iht = null;

	@Before
	public void init() {
		iht = new DAIHashingWithTreeImpl();
	}

	@Test
	public void createBstIndexTreeTest() {

		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}
		System.out.println("\nInorder print start");
		iht.printInorder(root);
		System.out.println("\nInorder print end");
	}

	@Test
	public void printColumWiseTest() {

		int arr[] = { 3, 9, 8, 7, 6, 5, 4 };// { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}
		System.out.println("\nColumn wise print start");
		Map<Integer, List<HTreeNode>> map = iht.printColumWise(root);
		for (Map.Entry<Integer, List<HTreeNode>> entry : map.entrySet()) {
			System.out.println();
			List<HTreeNode> list = map.get(entry.getKey());
			for (HTreeNode integer : list) {
				System.out.print(integer.dt + "->");
			}
		}
		System.out.println("\nColumn print end");
	}

	@Test
	public void printBottomImageTest() {

		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 }
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}
		System.out.println("\nBottom wise print start");
		List<Integer> listRs = iht.printBottomView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\nBottom view print end");
	}

	@Test
	public void printTomImageTest() {

		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 }
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}
		System.out.println("\nTop wise view print start");
		List<Integer> listRs = iht.printTomView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\nTop wise view print end");
	}

	@Test
	public void printLeftViewTest() {

		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}
		System.out.println("\nleft wise view print start");
		List<Integer> listRs = iht.printLeftView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\nleft wise view print end");
	}

	@Test
	public void printRightViewTest() {

		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}

		System.out.println("\n Riht  wise view print start");
		List<Integer> listRs = iht.printRightView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\n Right wise view print end");
	}

	/**
	 * square corner view of tree top-left, bottom-left, bottom-right and top-right
	 **/

	@Test
	public void topLeftCornerViewTest() {
		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}

		System.out.println("\n Top Left corner view print start");
		List<Integer> listRs = iht.topLeftCornerView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\n Top Left corner  view print end");
	}

	@Test
	public void bottomRightCornerViewTest() {
		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}

		System.out.println("\n Bottom Right Corner view print start");
		List<Integer> listRs = iht.bottomRightCornerView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\n Bottom Right Corner view print end");
	}

	@Test
	public void bottomLeftCornerViewTest() {
		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}

		System.out.println("\n Bottom Left Corner view print start");
		List<Integer> listRs = iht.bottomLeftCornerView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\n Bottom Left Corner view print end");
	}

	@Test
	public void topRightCornerViewTest() {
		int arr[] = { 5, 3, 8, 2, 4, 6, 7, 0, 1, 10, 9 };// { 3, 9, 8, 7, 6, 5, 4 };
		for (int i = 0; i < arr.length; i++) {
			root = iht.createBstIndexTree(root, arr[i], 0);
		}

		System.out.println("\n Top Right Corner view print start");
		List<Integer> listRs = iht.topRightCornerView(root);

		for (Integer inte : listRs)
			System.out.print(inte + "->");
		System.out.println("\n Top Right Corner view print end");
	}
}
