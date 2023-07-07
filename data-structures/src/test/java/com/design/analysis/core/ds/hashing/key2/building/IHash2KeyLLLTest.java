package com.design.analysis.core.ds.hashing.key2.building;

import com.design.analysis.core.ds.hashing.key2.node.HK2LLLNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.ds.common.model.Product;

/**@author @Gurug
 * start 2 key building key1 list , key2 link list and value also link list for
 * store value (LIST(key1)-LIST(key2)-LIST(value))
 **/
/** Scenario, product key will be up to x digit unique no **/
public class IHash2KeyLLLTest {

	public IHash2KeyLLL<Integer, Integer, Product> ihk2lll = null;

	@Before
	public void init() {
		ihk2lll = new Hash2KeyLLLImpl();
	}

	/* add mass of element in single shot */
	@Test
	public void addArrayTest() {
		HK2LLLNode<Integer, Integer, Product> mainHead = null;
		Product arr[] = new Product[10];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(0, 11, "0.aaple", "computer");
				arr[k++] = new Product(0, 12, "0.aaple", "watch");
				arr[k++] = new Product(0, 13, "0.aaple", "mobile");
				arr[k++] = new Product(1, 14, "0.aaple", "desktop");
				arr[k++] = new Product(1, 15, "0.aaple", "music");
			} else {
				arr[k++] = new Product(0, 11, "1.lenavo", "computer");
				arr[k++] = new Product(0, 12, "1.lenavo", "watch");
				arr[k++] = new Product(0, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(1, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(1, 15, "1.lenavo", "music");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key2[] = { 0, 0, 0, 1, 1, 0, 0, 0, 1, 1 };

		mainHead= ihk2lll.addArray(mainHead, key1, key2, arr);
		//ihk2lll.print(mainHead);
		// +ve test case
		Assert.assertTrue(ihk2lll.getElement(mainHead,0, 0, arr[0]).pName == "computer");
		Assert.assertTrue(ihk2lll.getElement(mainHead,0, 0, arr[1]).pName == "watch");
		Assert.assertTrue(ihk2lll.getElement(mainHead,1, 0, arr[5]).pName == "computer");
		Assert.assertTrue(ihk2lll.getElement(mainHead,1, 0, arr[6]).pName == "watch");
		// -ve test case
		Assert.assertTrue(ihk2lll.getElement(mainHead,3, 1, arr[0]) == null);
		Assert.assertTrue(ihk2lll.getElement(mainHead,0, 0, new Product(0, 14, "0.aaple", "System")) == null);
	}

	/* add an element or replace if existing */
	@Test
	public void addElementTest() {
		//ihk2lll.destroyCache();
		HK2LLLNode<Integer, Integer, Product> mainHead = null;
		Product arr[] = new Product[10];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(0, 11, "0.aaple", "computer");
				arr[k++] = new Product(0, 12, "0.aaple", "watch");
				arr[k++] = new Product(0, 13, "0.aaple", "mobile");
				arr[k++] = new Product(1, 14, "0.aaple", "desktop");
				arr[k++] = new Product(1, 15, "0.aaple", "music");
			} else {
				arr[k++] = new Product(0, 11, "1.lenavo", "computer");
				arr[k++] = new Product(0, 12, "1.lenavo", "watch");
				arr[k++] = new Product(0, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(1, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(1, 15, "1.lenavo", "music");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key2[] = { 0, 0, 0, 1, 1, 0, 0, 0, 1, 1 };

		mainHead = ihk2lll.addArray(mainHead, key1, key2, arr);
		Product p1 = new Product(1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 16, "1.lenavo", "headphone");
		mainHead = ihk2lll.addElement(mainHead, 0, 1, p1);
		mainHead = ihk2lll.addElement(mainHead, 1, 1, p2);
		Assert.assertTrue(ihk2lll.getElement(mainHead,0, 1, p1).pName == "headphone");
		Assert.assertTrue(ihk2lll.getElement(mainHead,1, 1, p2).pName == "headphone");
		// ihk2lll.print();
		//ihk2lll.destroyCache();
	}

	/* find an element */
	@Test
	public void getElementTest() {
		/* all ready tested in above two test cases */
	}

	/* delete an element */
	@Test
	public void deleteElementTest() {

		//ihk2lll.destroyCache();
		HK2LLLNode<Integer, Integer, Product> mainHead = null;
		Product arr[] = new Product[10];
		int k = 0;
		// here 3rd argment use for key1 and first for key2 @see hashKey1() and
		// hashKey2()
		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				arr[k++] = new Product(0, 11, "0.aaple", "computer");
				arr[k++] = new Product(0, 12, "0.aaple", "watch");
				arr[k++] = new Product(0, 13, "0.aaple", "mobile");
				arr[k++] = new Product(1, 14, "0.aaple", "desktop");
				arr[k++] = new Product(1, 15, "0.aaple", "music");
			} else {
				arr[k++] = new Product(0, 11, "1.lenavo", "computer");
				arr[k++] = new Product(0, 12, "1.lenavo", "watch");
				arr[k++] = new Product(0, 13, "1.lenavo", "mobile");
				arr[k++] = new Product(1, 14, "1.lenavo", "desktop");
				arr[k++] = new Product(1, 15, "1.lenavo", "music");
			}
		}

		Integer key1[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 1 };
		Integer key2[] = { 0, 0, 0, 1, 1, 0, 0, 0, 1, 1 };

		mainHead = ihk2lll.addArray(mainHead,key1, key2, arr);
		Product p1 = new Product(1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 16, "1.lenavo", "headphone");
		mainHead = ihk2lll.addElement(mainHead, 0, 1, p1);
		mainHead = ihk2lll.addElement(mainHead, 1, 1, p2);
		Assert.assertTrue(ihk2lll.getElement(mainHead,0, 1, p1).pName == "headphone");
		Assert.assertTrue(ihk2lll.getElement(mainHead,1, 1, p2).pName == "headphone");
		//ihk2lll.print(mainHead);
		ihk2lll.deleteElement(mainHead, p1);
		ihk2lll.deleteElement(mainHead, p2);
		ihk2lll.print(mainHead);
		/*Assert.assertTrue(ihk2lll.getElement(mainHead,0, 0, arr[0]) == null);
		Assert.assertTrue(ihk2lll.getElement(mainHead,0, 0, arr[1]).pName == "watch");
		Assert.assertTrue(ihk2lll.getElement(mainHead,1, 0, arr[5]) == null);
		Assert.assertTrue(ihk2lll.getElement(mainHead,1, 0, arr[6]).pName == "watch");*/

		//ihk2lll.destroyCache();
	}

	/* destroy cache */
	public void destroyCache() {
		HK2LLLNode<Integer, Integer, Product> mainHead = new HK2LLLNode<Integer, Integer, Product>(5);
		ihk2lll.destroyCache(mainHead);
	}

	/* a way to find the key1 */
	public void hashKey1Test() {
		Product p1 = new Product(1, 16, "0.aaple", "headphone");
		Product p2 = new Product(1, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk2lll.hashKey1(p1) == 0);
		Assert.assertTrue(ihk2lll.hashKey1(p2) == 1);

	}

	/* /* a way to find the key1 */
	public void hashKey2Test() {
		Product p1 = new Product(4, 16, "0.aaple", "headphone");
		Product p2 = new Product(5, 16, "1.lenavo", "headphone");
		Assert.assertTrue(ihk2lll.hashKey2(p1) == 4);
		Assert.assertTrue(ihk2lll.hashKey2(p2) == 5);

	}

	/* print all the element if found */
	public void print() {
		/* all ready tested in addArrayTest() */
	}

}
