package com.design.analysis.core.ds.hashing.key3.building;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.common.model.Product;

public class IHash3KeyALLLTest {

	public IHash3KeyALLL<Integer, Integer, Integer, Product> ihk3alll = null;

	@Before
	public void init() {
		ihk3alll = new Hash3KeyALLLImpl();
	}

	/* add mass of element in single shot */
	@Test
	public void addArrayTest() {
		ihk3alll.destroyCache();
		Product arr[] = new Product[10];
		int k = 0;
		// here first argument for key1, 3rd argument use for key2 and second
		// for key3 @see hashKey1() and hashKey2() and hashKey3()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(0, 0, 11, "0.aaple", "computer");
				arr[k++] = new Product(0, 0, 12, "0.aaple", "watch");
				arr[k++] = new Product(0, 0, 13, "0.aaple", "mobile");
				arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
				arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			} else {
				arr[k++] = new Product(1, 0, 11, "1.lenavo", "computer");
				arr[k++] = new Product(1, 0, 12, "1.lenavo", "watch");
				arr[k++] = new Product(1, 0, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(1, 1, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(1, 1, 15, "1.lenavo", "music");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key2[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key3[] = { 0, 0, 0, 1, 1, 0, 0, 0, 1, 1 };

		ihk3alll.addArray(key1, key2, key3, arr, 10);
		// ihk3alll.print();
		// +ve test case
		Assert.assertTrue(ihk3alll.getElement(0, 0, 0, arr[0]).pName == "computer");
		Assert.assertTrue(ihk3alll.getElement(0, 0, 0, arr[1]).pName == "watch");
		Assert.assertTrue(ihk3alll.getElement(1, 1, 0, arr[5]).pName == "computer");
		Assert.assertTrue(ihk3alll.getElement(1, 1, 0, arr[6]).pName == "watch");
		// -ve test case
		Assert.assertTrue(ihk3alll.getElement(0, 3, 1, arr[0]) == null);
		Assert.assertTrue(ihk3alll.getElement(0, 0, 0, new Product(0, 14, "0.aaple", "System")) == null);
	}

	/* add an element or replace if existing */
	@Test
	public void addElementTest() {
		ihk3alll.destroyCache();
		Product arr[] = new Product[10];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(0, 0, 11, "0.aaple", "computer");
				arr[k++] = new Product(0, 0, 12, "0.aaple", "watch");
				arr[k++] = new Product(0, 0, 13, "0.aaple", "mobile");
				arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
				arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			} else {
				arr[k++] = new Product(1, 0, 11, "1.lenavo", "computer");
				arr[k++] = new Product(1, 0, 12, "1.lenavo", "watch");
				arr[k++] = new Product(1, 0, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(1, 1, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(1, 1, 15, "1.lenavo", "music");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key2[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key3[] = { 0, 0, 0, 1, 1, 0, 0, 0, 1, 1 };

		ihk3alll.addArray(key1, key2, key3, arr, 10);
		Product p1 = new Product(0, 1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 1, 16, "1.lenavo", "headphone");
		ihk3alll.addElement(0, 0, 1, p1);
		ihk3alll.addElement(1, 1, 1, p2);
		Assert.assertTrue(ihk3alll.getElement(0, 0, 1, p1).pName == "headphone");
		// ihk3alll.print();
		Assert.assertTrue(ihk3alll.getElement(1, 1, 1, p2).pName == "headphone");
		ihk3alll.destroyCache();
	}

	/* find an element */
	@Test
	public void getElementTest() {
		// all ready tested in above two test cases
	}

	/* delete an element */
	@Test
	public void deleteElementTest() {

		ihk3alll.destroyCache();
		Product arr[] = new Product[10];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(0, 0, 11, "0.aaple", "computer");
				arr[k++] = new Product(0, 0, 12, "0.aaple", "watch");
				arr[k++] = new Product(0, 0, 13, "0.aaple", "mobile");
				arr[k++] = new Product(0, 1, 14, "0.aaple", "desktop");
				arr[k++] = new Product(0, 1, 15, "0.aaple", "music");
			} else {
				arr[k++] = new Product(1, 0, 11, "1.lenavo", "computer");
				arr[k++] = new Product(1, 0, 12, "1.lenavo", "watch");
				arr[k++] = new Product(1, 0, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(1, 1, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(1, 1, 15, "1.lenavo", "music");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key2[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key3[] = { 0, 0, 0, 1, 1, 0, 0, 0, 1, 1 };

		ihk3alll.addArray(key1, key2, key3, arr, 10);
		Product p1 = new Product(0, 1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 1, 16, "1.lenavo", "headphone");
		ihk3alll.addElement(0, 0, 1, p1);
		ihk3alll.addElement(1, 1, 1, p2);
		Assert.assertTrue(ihk3alll.getElement(0, 0, 1, p1).pName == "headphone");
		Assert.assertTrue(ihk3alll.getElement(1, 1, 1, p2).pName == "headphone");
		// ihk3alll.print();

		ihk3alll.deleteElement(p1);
		ihk3alll.deleteElement(p2);
		// ihk3alll.print();
		Assert.assertTrue(ihk3alll.getElement(0, 0, 1, p1) == null);
		Assert.assertTrue(ihk3alll.getElement(1, 1, 1, p2) == null);

		ihk3alll.destroyCache();
	}

	/* destroy cache */
	public void destroyCache() {
		ihk3alll.destroyCache();
	}

	/* a way to find the key1 */
	public void hashKey1Test() {
		Product p1 = new Product(4, 16, "0.aaple", "headphone");
		Product p2 = new Product(5, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk3alll.hashKey1(p1) == 4);
		Assert.assertTrue(ihk3alll.hashKey1(p2) == 5);

	}

	/* a way to find the key2 */
	public void hashKey2Test() {
		Product p1 = new Product(5, 1, 16, "0.aaple", "headphone");
		Product p2 = new Product(6, 1, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk3alll.hashKey1(p1) == 0);
		Assert.assertTrue(ihk3alll.hashKey1(p2) == 1);

	}

	/* a way to find the key3 */
	public void hashKey3Test() {
		Product p1 = new Product(4, 16, "0.aaple", "headphone");
		Product p2 = new Product(5, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk3alll.hashKey2(p1) == 4);
		Assert.assertTrue(ihk3alll.hashKey2(p2) == 5);

	}

	/* print all the element if found */
	public void print() {
		// all ready tested in addArrayTest()
	}
}
