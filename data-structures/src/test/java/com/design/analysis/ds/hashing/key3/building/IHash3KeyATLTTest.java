/**
 * 
 */
package com.design.analysis.ds.hashing.key3.building;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.common.model.Product;

/**
 * @author @Gurug
 *
 */
public class IHash3KeyATLTTest {

	public IHash3KeyATLT<Integer, Integer, Integer, Product> ihk3atlt = null;

	@Before
	public void init() {
		ihk3atlt = new Hash3KeyATLTImpl();
	}

	/* add mass of element in single shot */
	@Test
	public void addArrayTest() {
		ihk3atlt.destroyCache();
		Product arr[] = new Product[18];
		int k = 0;
		// here first argument for key1, 3rd argument use for key2 and second
		// for key3 @see hashKey1() and hashKey2() and hashKey3()
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(0, 2, 11, "1.aaple", "computer");
			arr[k++] = new Product(0, 2, 12, "1.aaple", "watch");
			arr[k++] = new Product(0, 2, 13, "1.aaple", "mobile");
			arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
			arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			arr[k++] = new Product(0, 5, 12, "2.aaple", "aaa");
			arr[k++] = new Product(0, 5, 13, "2.aaple", "bbb");
			arr[k++] = new Product(0, 5, 14, "2.aaple", "ccc");
			arr[k++] = new Product(0, 5, 15, "2.aaple", "ddd");

			arr[k++] = new Product(1, 3, 11, "1.lenavo", "computer");
			arr[k++] = new Product(1, 3, 12, "1.lenavo", "watch");
			arr[k++] = new Product(1, 3, 13, "1.lenavo", "mobile");
			arr[k++] = new Product(1, 1, 14, "0.lenavo", "desktop");
			arr[k++] = new Product(1, 1, 15, "0.lenavo", "music");
			arr[k++] = new Product(1, 4, 12, "2.aaple", "aaa");
			arr[k++] = new Product(1, 4, 13, "2.aaple", "bbb");
			arr[k++] = new Product(1, 4, 14, "2.aaple", "ccc");
			arr[k++] = new Product(1, 4, 15, "2.aaple", "ddd");
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Integer key2[] = { 1, 1, 1, 0, 0, 2, 2, 2, 2, 1, 1, 1, 0, 0, 2, 2, 2, 2, };
		Integer key3[] = { 2, 2, 2, 1, 1, 5, 5, 5, 5, 3, 3, 3, 1, 1, 4, 4, 4, 4 };

		ihk3atlt.addArray(key1, key2, key3, arr, 18);
		ihk3atlt.print();
		// +ve test case
		Assert.assertTrue(ihk3atlt.getElement(0, 1, 2, arr[0]).pName == "computer");
		Assert.assertTrue(ihk3atlt.getElement(0, 1, 2, arr[1]).pName == "watch");
		Assert.assertTrue(ihk3atlt.getElement(1, 1, 3, arr[9]).pName == "computer");
		Assert.assertTrue(ihk3atlt.getElement(1, 1, 3, arr[10]).pName == "watch");
		// -ve test case
		Assert.assertTrue(ihk3atlt.getElement(0, 3, 1, arr[0]) == null);
		Assert.assertTrue(ihk3atlt.getElement(0, 0, 0, new Product(0, 14, "0.aaple", "System")) == null);
	}

	/* add an element or replace if existing */
	@Test
	public void addElementTest() {

		ihk3atlt.destroyCache();
		Product arr[] = new Product[18];
		int k = 0;
		// here first argument for key1, 3rd argument use for key2 and second
		// for key3 @see hashKey1() and hashKey2() and hashKey3()
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(0, 2, 11, "1.aaple", "computer");
			arr[k++] = new Product(0, 2, 12, "1.aaple", "watch");
			arr[k++] = new Product(0, 2, 13, "1.aaple", "mobile");
			arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
			arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			arr[k++] = new Product(0, 5, 12, "2.aaple", "aaa");
			arr[k++] = new Product(0, 5, 13, "2.aaple", "bbb");
			arr[k++] = new Product(0, 5, 14, "2.aaple", "ccc");
			arr[k++] = new Product(0, 5, 15, "2.aaple", "ddd");

			arr[k++] = new Product(1, 3, 11, "1.lenavo", "computer");
			arr[k++] = new Product(1, 3, 12, "1.lenavo", "watch");
			arr[k++] = new Product(1, 3, 13, "1.lenavo", "mobile");
			arr[k++] = new Product(1, 1, 14, "0.lenavo", "desktop");
			arr[k++] = new Product(1, 1, 15, "0.lenavo", "music");
			arr[k++] = new Product(1, 4, 12, "2.aaple", "aaa");
			arr[k++] = new Product(1, 4, 13, "2.aaple", "bbb");
			arr[k++] = new Product(1, 4, 14, "2.aaple", "ccc");
			arr[k++] = new Product(1, 4, 15, "2.aaple", "ddd");
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Integer key2[] = { 1, 1, 1, 0, 0, 2, 2, 2, 2, 1, 1, 1, 0, 0, 2, 2, 2, 2, };
		Integer key3[] = { 2, 2, 2, 1, 1, 5, 5, 5, 5, 3, 3, 3, 1, 1, 4, 4, 4, 4 };

		ihk3atlt.addArray(key1, key2, key3, arr, 18);
		Product p1 = new Product(0, 1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 1, 16, "0.lenavo", "headphone");
		ihk3atlt.addElement(0, 0, 1, p1);
		ihk3atlt.addElement(1, 0, 1, p2);
		Assert.assertTrue(ihk3atlt.getElement(0, 0, 1, p1).pName == "headphone");
		Assert.assertTrue(ihk3atlt.getElement(1, 0, 1, p2).pName == "headphone");
		// ihk3atlt.print();
		ihk3atlt.destroyCache();
	}

	/* delete an element */
	@Test
	public void deleteElementTest() {

		ihk3atlt.destroyCache();
		Product arr[] = new Product[18];
		int k = 0;
		// here first argument for key1, 3rd argument use for key2 and second
		// for key3 @see hashKey1() and hashKey2() and hashKey3()
		for (int i = 0; i < 1; i++) {
			arr[k++] = new Product(0, 2, 11, "1.aaple", "computer");
			arr[k++] = new Product(0, 2, 12, "1.aaple", "watch");
			arr[k++] = new Product(0, 2, 13, "1.aaple", "mobile");
			arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
			arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			arr[k++] = new Product(0, 5, 12, "2.aaple", "aaa");
			arr[k++] = new Product(0, 5, 13, "2.aaple", "bbb");
			arr[k++] = new Product(0, 5, 14, "2.aaple", "ccc");
			arr[k++] = new Product(0, 5, 15, "2.aaple", "ddd");

			arr[k++] = new Product(1, 3, 11, "1.lenavo", "computer");
			arr[k++] = new Product(1, 3, 12, "1.lenavo", "watch");
			arr[k++] = new Product(1, 3, 13, "1.lenavo", "mobile");
			arr[k++] = new Product(1, 1, 14, "0.lenavo", "desktop");
			arr[k++] = new Product(1, 1, 15, "0.lenavo", "music");
			arr[k++] = new Product(1, 4, 12, "2.aaple", "aaa");
			arr[k++] = new Product(1, 4, 13, "2.aaple", "bbb");
			arr[k++] = new Product(1, 4, 14, "2.aaple", "ccc");
			arr[k++] = new Product(1, 4, 15, "2.aaple", "ddd");
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Integer key2[] = { 1, 1, 1, 0, 0, 2, 2, 2, 2, 1, 1, 1, 0, 0, 2, 2, 2, 2, };
		Integer key3[] = { 2, 2, 2, 1, 1, 5, 5, 5, 5, 3, 3, 3, 1, 1, 4, 4, 4, 4 };

		ihk3atlt.addArray(key1, key2, key3, arr, 18);
		Product p1 = new Product(0, 1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 1, 16, "0.lenavo", "headphone");
		ihk3atlt.addElement(0, 0, 1, p1);
		ihk3atlt.addElement(1, 0, 1, p2);
		Assert.assertTrue(ihk3atlt.getElement(0, 0, 1, p1).pName == "headphone");
		Assert.assertTrue(ihk3atlt.getElement(1, 0, 1, p2).pName == "headphone");
		ihk3atlt.deleteElement(p1);
		ihk3atlt.deleteElement(p2);
		// ihk3atlt.print();
		Assert.assertTrue(ihk3atlt.getElement(0, 0, 1, p1) == null);
		Assert.assertTrue(ihk3atlt.getElement(1, 0, 1, p2) == null);
		ihk3atlt.destroyCache();
	}

	/*
	 * find an element
	 */
	@Test
	public void getElementTest() {
		// all ready tested in above two test cases
	}

	/* destroy cache */
	@Test
	public void destroyCache() {
		ihk3atlt.destroyCache();
	}

	/* a way to find the key1 */
	@Test
	public void hashKey1Test() {
		Product p1 = new Product(10, 4, 16, "0.aaple", "headphone");
		Product p2 = new Product(11, 5, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk3atlt.hashKey1(p1) == 10);
		Assert.assertTrue(ihk3atlt.hashKey1(p2) == 11);

	}

	/* a way to find the key2 */
	@Test
	public void hashKey2Test() {
		Product p1 = new Product(5, 1, 16, "0.aaple", "headphone");
		Product p2 = new Product(6, 1, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk3atlt.hashKey2(p1) == 0);
		Assert.assertTrue(ihk3atlt.hashKey2(p2) == 1);

	}

	/* a way to find the key3 */
	@Test
	public void hashKey3Test() {
		Product p1 = new Product(0, 4, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 5, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk3atlt.hashKey3(p1) == 4);
		Assert.assertTrue(ihk3atlt.hashKey3(p2) == 5);

	}

	/* print all the element if found */
	@Test
	public void print() {
		// all ready tested in addArrayTest()
	}

}
