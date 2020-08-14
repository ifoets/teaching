/**
 * 
 */
package com.design.analysis.ds.hashing.key2.building;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.common.model.Product;

/**
 * @author @Gurug
 *
 */
public class IHash2KeyATLTest {

	public IHash2KeyATL<Integer, Integer, Product> ihk2atl = null;

	@Before
	public void init() {
		ihk2atl = new Hash2KeyATLImpl();
	}

	/* add mass of element in single shot */
	@Test
	public void addArrayTest() {
		ihk2atl.destroyCache();
		Product arr[] = new Product[18];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(3, 11, "0.aaple", "computer");
				arr[k++] = new Product(3, 12, "0.aaple", "watch");
				arr[k++] = new Product(3, 13, "0.aaple", "mobile");
				arr[k++] = new Product(2, 14, "0.aaple", "desktop");
				arr[k++] = new Product(2, 15, "0.aaple", "music");
				arr[k++] = new Product(1, 16, "0.aaple", "aaaa");
				arr[k++] = new Product(1, 17, "0.aaple", "bbbb");
				arr[k++] = new Product(1, 18, "0.aaple", "cccc");
				arr[k++] = new Product(1, 19, "0.aaple", "dddd");
			} else {

				arr[k++] = new Product(3, 11, "1.lenavo", "computer");
				arr[k++] = new Product(3, 12, "1.lenavo", "watch");
				arr[k++] = new Product(3, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(2, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(2, 15, "1.lenavo", "music");
				arr[k++] = new Product(1, 16, "1.lenavo", "aaaa");
				arr[k++] = new Product(1, 17, "1.lenavo", "bbbb");
				arr[k++] = new Product(1, 18, "1.lenavo", "cccc");
				arr[k++] = new Product(1, 19, "1.lenavo", "dddd");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Integer key2[] = { 3, 3, 3, 2, 2, 1, 1, 1, 1, 3, 3, 3, 2, 2, 1, 1, 1, 1 };

		ihk2atl.addArray(key1, key2, arr, 18);
		// ihk2atl.print();
		// +ve test case
		Assert.assertTrue(ihk2atl.getElement(0, 3, arr[0]).pName == "computer");
		Assert.assertTrue(ihk2atl.getElement(0, 3, arr[1]).pName == "watch");
		Assert.assertTrue(ihk2atl.getElement(1, 1, arr[16]).pName == "cccc");
		Assert.assertTrue(ihk2atl.getElement(1, 1, arr[17]).pName == "dddd");
		// -ve test case
		Assert.assertTrue(ihk2atl.getElement(3, 1, arr[0]) == null);
		Assert.assertTrue(ihk2atl.getElement(0, 0, new Product(0, 14, "0.aaple", "System")) == null);
	}

	/* add an element or replace if existing */
	@Test
	public void addElementTest() {
		ihk2atl.destroyCache();
		Product arr[] = new Product[18];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(3, 11, "0.aaple", "computer");
				arr[k++] = new Product(3, 12, "0.aaple", "watch");
				arr[k++] = new Product(3, 13, "0.aaple", "mobile");
				arr[k++] = new Product(2, 14, "0.aaple", "desktop");
				arr[k++] = new Product(2, 15, "0.aaple", "music");
				arr[k++] = new Product(1, 16, "0.aaple", "aaaa");
				arr[k++] = new Product(1, 17, "0.aaple", "bbbb");
				arr[k++] = new Product(1, 18, "0.aaple", "cccc");
				arr[k++] = new Product(1, 19, "0.aaple", "dddd");
			} else {

				arr[k++] = new Product(3, 11, "1.lenavo", "computer");
				arr[k++] = new Product(3, 12, "1.lenavo", "watch");
				arr[k++] = new Product(3, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(2, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(2, 15, "1.lenavo", "music");
				arr[k++] = new Product(1, 16, "1.lenavo", "aaaa");
				arr[k++] = new Product(1, 17, "1.lenavo", "bbbb");
				arr[k++] = new Product(1, 18, "1.lenavo", "cccc");
				arr[k++] = new Product(1, 19, "1.lenavo", "dddd");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Integer key2[] = { 3, 3, 3, 2, 2, 1, 1, 1, 1, 3, 3, 3, 2, 2, 1, 1, 1, 1 };

		ihk2atl.addArray(key1, key2, arr, 18);

		// +ve test case
		Assert.assertTrue(ihk2atl.getElement(0, 3, arr[0]).pName == "computer");
		Assert.assertTrue(ihk2atl.getElement(0, 3, arr[1]).pName == "watch");
		Assert.assertTrue(ihk2atl.getElement(1, 1, arr[16]).pName == "cccc");
		Assert.assertTrue(ihk2atl.getElement(1, 1, arr[17]).pName == "dddd");
		// -ve test case
		Assert.assertTrue(ihk2atl.getElement(3, 1, arr[0]) == null);
		Assert.assertTrue(ihk2atl.getElement(0, 0, new Product(0, 14, "0.aaple", "System")) == null);

		// adding element
		Product p1 = new Product(1, 20, "0.aaple", "headphone");
		Product p2 = new Product(1, 20, "1.lenavo", "headphone");
		ihk2atl.addElement(0, 1, p1);
		ihk2atl.addElement(1, 1, p2);
		Assert.assertTrue(ihk2atl.getElement(0, 1, p1).pName == "headphone");
		// ihk2atl.print();
		Assert.assertTrue(ihk2atl.getElement(1, 1, p2).pName == "headphone");
		ihk2atl.destroyCache();
	}

	/* find an element */
	@Test
	public void getElementTest() {
		// all ready tested in above two test cases
	}

	/* delete an element */
	@Test
	public void deleteElementTest() {

		ihk2atl.destroyCache();
		Product arr[] = new Product[18];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(3, 11, "0.aaple", "computer");
				arr[k++] = new Product(3, 12, "0.aaple", "watch");
				arr[k++] = new Product(3, 13, "0.aaple", "mobile");
				arr[k++] = new Product(2, 14, "0.aaple", "desktop");
				arr[k++] = new Product(2, 15, "0.aaple", "music");
				arr[k++] = new Product(1, 16, "0.aaple", "aaaa");
				arr[k++] = new Product(1, 17, "0.aaple", "bbbb");
				arr[k++] = new Product(1, 18, "0.aaple", "cccc");
				arr[k++] = new Product(1, 19, "0.aaple", "dddd");
			} else {

				arr[k++] = new Product(3, 11, "1.lenavo", "computer");
				arr[k++] = new Product(3, 12, "1.lenavo", "watch");
				arr[k++] = new Product(3, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(2, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(2, 15, "1.lenavo", "music");
				arr[k++] = new Product(1, 16, "1.lenavo", "aaaa");
				arr[k++] = new Product(1, 17, "1.lenavo", "bbbb");
				arr[k++] = new Product(1, 18, "1.lenavo", "cccc");
				arr[k++] = new Product(1, 19, "1.lenavo", "dddd");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
		Integer key2[] = { 3, 3, 3, 2, 2, 1, 1, 1, 1, 3, 3, 3, 2, 2, 1, 1, 1, 1 };

		ihk2atl.addArray(key1, key2, arr, 18);

		// +ve test case
		Assert.assertTrue(ihk2atl.getElement(0, 3, arr[0]).pName == "computer");
		Assert.assertTrue(ihk2atl.getElement(0, 3, arr[1]).pName == "watch");
		Assert.assertTrue(ihk2atl.getElement(1, 1, arr[16]).pName == "cccc");
		Assert.assertTrue(ihk2atl.getElement(1, 1, arr[17]).pName == "dddd");
		// -ve test case
		Assert.assertTrue(ihk2atl.getElement(3, 1, arr[0]) == null);
		Assert.assertTrue(ihk2atl.getElement(0, 0, new Product(0, 14, "0.aaple", "System")) == null);

		// adding element
		Product p1 = new Product(1, 20, "0.aaple", "headphone");
		Product p2 = new Product(1, 20, "1.lenavo", "headphone");
		ihk2atl.addElement(0, 1, p1);
		ihk2atl.addElement(1, 1, p2);
		Assert.assertTrue(ihk2atl.getElement(0, 1, p1).pName == "headphone");
		Assert.assertTrue(ihk2atl.getElement(1, 1, p2).pName == "headphone");

		Assert.assertTrue(ihk2atl.deleteElement(p1));
		Assert.assertTrue(ihk2atl.deleteElement(p2));
		Assert.assertTrue(ihk2atl.getElement(0, 1, p1) == null);
		Assert.assertTrue(ihk2atl.getElement(1, 1, p2) == null);
		// ihk2atl.print();
		ihk2atl.destroyCache();
	}

	/* destroy cache */
	public void destroyCache() {
		ihk2atl.destroyCache();
	}

	/* a way to find the key1 */
	public void hashKey1Test() {
		Product p1 = new Product(1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk2atl.hashKey1(p1) == 0);
		Assert.assertTrue(ihk2atl.hashKey1(p2) == 1);

	}

	/* /* a way to find the key1 */
	public void hashKey2Test() {
		Product p1 = new Product(4, 16, "0.aaple", "headphone");
		Product p2 = new Product(5, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk2atl.hashKey2(p1) == 4);
		Assert.assertTrue(ihk2atl.hashKey2(p2) == 5);

	}

	/* print all the element if found */
	public void print() {
		/* all ready tested in addArrayTest() */
	}

}
