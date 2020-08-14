package com.design.analysis.company.hakarrank.visa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.company.hakarrank.visa.model.VPoint;

public class IVisaTest {

	public IVisa iv = null;

	@Before
	public void init() {
		iv = new VisaImpl();
	}

	/** card Removal problem **/
	@Test
	public void noOfTimesCardRemoveTest() {

		int[] a = { 4, 5, 6 };
		int b[] = { 2, 0, 1 };
		for (int i = 0; i < a.length; i++)
			Assert.assertTrue(iv.noOfTimesCardRemove(a[i]) == b[i]);
	}

	@Test
	public void visaEncryptStringTest() {
		String s = "hello";
		int k = 2;
		Assert.assertTrue(iv.visaEncryptString(s, k).equals("1101"));
		s = "character";
		k = 3;
		Assert.assertTrue(iv.visaEncryptString(s, k).equals("2222222"));
	}

	@Test
	public void sumQueryTest() {

		int arr[] = { 1, 2, 3, 4, 5 };
		iv.leftRotation(arr, 3, 1);
		Assert.assertTrue(iv.sumQuery(arr, 0, 2) == 12);

		iv.leftRotation(arr, 1, 2);
		Assert.assertTrue(iv.sumQuery(arr, 1, 4) == 11);
	}

	/** Square with minimum area enclosing K points among given N points **/
	// point should not touch the mimimum squre of K points under squre*/
	@Test
	public void kClogestPointTest() {
		Integer x[] = { -1, 0, 1, 1, 2 };
		Integer y[] = { -1, 0, 1, 2, 2 };
		List<Integer> xList = Arrays.asList(x);
		List<Integer> yList = Arrays.asList(y);
		List<VPoint> list = new ArrayList<>();
		for (int i = 0; i < xList.size(); i++)
			list.add(new VPoint(xList.get(i), yList.get(i)));
		list = iv.kClogestPoint(list, new VPoint(1, 1), 3);
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).toString());
	}

	@Test
	public void minAreaTest() {

		Integer x[] = { -1, 0, 1, 1, 2 };
		Integer y[] = { -1, 0, 1, 2, 2 };
		List<Integer> xList = Arrays.asList(x);
		List<Integer> yList = Arrays.asList(y);
		Assert.assertTrue(iv.minArea(xList, yList, 3) == 9);
	}

	/** Supermarket price invention **/
	// find the size of decresing of k size sub arrays in array
	@Test
	public void sizeOfSuperMarketTest() {
		int a[] = { 5, 4, 3, 2, 1 };
		Assert.assertTrue(iv.sizeOfSuperMarket(a, 3) == 10);
	}
}
