package com.design.analysis.ds.hashing.key2.building;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.ds.hashing.key2.building.Hash2KyeAAAImpl;
import com.design.analysis.ds.hashing.key2.building.IHash2KyeAAA;

public class IHash2KyeAAATest {

	public IHash2KyeAAA<Integer, Integer, Integer> ishk2 = null;

	@Before
	public void init() {
		ishk2 = new Hash2KyeAAAImpl();
	}

	/* add mass of element in single shot */
	@Test
	public void addArrayTest() {
		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, 106, 107, 109, -109 };
		Integer key1[] = new Integer[arr.length];
		Integer key2[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key1[i] = ishk2.hashKey1(arr[i]);
			key2[i] = ishk2.hashKey2(arr[i]);
		}
		ishk2.addArray(key1, key2, arr, 10);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(104), ishk2.hashKey2(104), true) == 104);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), false) == null);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-101), ishk2.hashKey2(-101), false) == -101);
	}

	/* add an element */
	@Test
	public void addElementTest() {

		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, -106, 107, 109, -109 };
		Integer key1[] = new Integer[arr.length];
		Integer key2[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key1[i] = ishk2.hashKey1(arr[i]);
			key2[i] = ishk2.hashKey2(arr[i]);
		}
		ishk2.addArray(key1, key2, arr, 10);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(104), ishk2.hashKey2(104), true) == 104);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), false) == null);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-101), ishk2.hashKey2(-101), false) == -101);

		ishk2.addElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), -104);
		ishk2.addElement(ishk2.hashKey1(-105), ishk2.hashKey2(-105), -105);
		ishk2.addElement(ishk2.hashKey1(106), ishk2.hashKey2(106), 110);

		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-105), ishk2.hashKey2(-105), false) == -105);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), false) == -104);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(106), ishk2.hashKey2(106), true) == 110);
	}

	/* find an element */
	@Test
	public void getElementTest() {

		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, -106, 107, 109, -109 };
		Integer key1[] = new Integer[arr.length];
		Integer key2[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key1[i] = ishk2.hashKey1(arr[i]);
			key2[i] = ishk2.hashKey2(arr[i]);
		}
		ishk2.addArray(key1, key2, arr, 10);

		ishk2.addElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), -104);
		ishk2.addElement(ishk2.hashKey1(-105), ishk2.hashKey2(-105), -105);
		ishk2.addElement(ishk2.hashKey1(106), ishk2.hashKey2(106), 106);

		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-105), ishk2.hashKey2(-105), false) == -105);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), false) == -104);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(106), ishk2.hashKey2(106), true) == 106);
	}

	/* delete an element */
	@Test
	public void deleteElementTest() {

		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, -106, 107, 109, -109 };
		Integer key1[] = new Integer[arr.length];
		Integer key2[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key1[i] = ishk2.hashKey1(arr[i]);
			key2[i] = ishk2.hashKey2(arr[i]);
		}
		ishk2.addArray(key1, key2, arr, 10);

		ishk2.deleteElement(105);
		ishk2.deleteElement(-106);
		// ishk2.prInteger();
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(105), ishk2.hashKey2(105), true) == null);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), false) == null);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-106), ishk2.hashKey2(-106), false) == null);
	}

	/* destroy cache */
	@Test
	public void destroyCache() {
		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, -106, 107, 109, -109 };
		Integer key1[] = new Integer[arr.length];
		Integer key2[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key1[i] = ishk2.hashKey1(arr[i]);
			key2[i] = ishk2.hashKey2(arr[i]);
		}
		ishk2.addArray(key1, key2, arr, 10);
		ishk2.destroyCache();
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(105), ishk2.hashKey2(105), true) == null);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-104), ishk2.hashKey2(-104), false) == null);
		Assert.assertTrue(ishk2.getElement(ishk2.hashKey1(-106), ishk2.hashKey2(-106), false) == null);
	}

	/* a way to find key1 */
	@Test
	public void hashKey1Test() {

		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, -106, 107, 109, -109 };
		Integer key1[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key1[i] = ishk2.hashKey1(arr[i]);
		}
		Assert.assertTrue(key1[0] == 1);
		Assert.assertTrue(key1[1] == -1);
		Assert.assertTrue(key1[2] == 1);
		Assert.assertTrue(key1[3] == -1);
	}

	/* a way to find key2 */
	@Test
	public void hashKey2Test() {
		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, -106, 107, 109, -109 };
		Integer key2[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key2[i] = ishk2.hashKey2(arr[i]);
		}
		Assert.assertTrue(key2[0] == 0);
		Assert.assertTrue(key2[1] == -0);
		Assert.assertTrue(key2[2] == 1);
		Assert.assertTrue(key2[3] == -1);
	}

	/* prInteger all the element if found */
	@Test
	public void prIntegerTest() {
		Integer arr[] = { 100, -100, 101, -101, 102, -102, 103, 104, 105, -106, 107, 109, -109 };
		Integer key1[] = new Integer[arr.length];
		Integer key2[] = new Integer[arr.length];
		for (Integer i = 0; i < arr.length; i++) {
			key1[i] = ishk2.hashKey1(arr[i]);
			key2[i] = ishk2.hashKey2(arr[i]);
		}
		ishk2.addArray(key1, key2, arr, 10);
		ishk2.print();
	}
}
