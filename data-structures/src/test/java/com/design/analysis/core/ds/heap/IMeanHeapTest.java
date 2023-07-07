package com.design.analysis.core.ds.heap;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IMeanHeapTest {

	public MeanHeapImpl imh = null;

	@Before
	public void init() {
		imh = new MeanHeapImpl(20);
	}
	
	@Test
	public void parntTest()
	{
		int arr[]={1,2,3,4,5,6,7,8,9};
		Assert.assertTrue(arr[imh.parent(8)]==4);
		Assert.assertTrue(arr[imh.parent(2)]==1);
		Assert.assertTrue(arr[imh.parent(5)]==3);
	}
	
	@Test
	public void heapifyUpTest()
	{
		int arr[]={1,2,3,4,5,6,7,8,9,-1};
		imh.heap=arr;
		imh.heapifyUp(9);
		Assert.assertTrue(arr[0]==-1);
		Assert.assertTrue(arr[9]==5);
		Assert.assertTrue(arr[1]==1);
		Assert.assertTrue(arr[4]==2);
		imh.heap=null;
	}
	
	@Test
	public void insertTest()
	{
		imh = new MeanHeapImpl(20);
		int arr[]={1,9,2,8,3,7,4,6,5,0};
		for(int i=0;i<arr.length;i++)
			imh.insert(arr[i]);
		imh.printHeap();
	}
	
	@Test
	public void deleteTest()
	{
		System.out.println("\n delete heap test start");
		imh = new MeanHeapImpl(20);
		int arr[]={1,9,2,8,3,7,4,6,5,0};
		for(int i=0;i<arr.length;i++)
			imh.insert(arr[i]);
		imh.printHeap();
		System.out.println();
		imh.delete(1);
		System.out.println("\nindex at 1 ie 1 is deleted\n");
		imh.printHeap();
		System.out.println("\nindex at 0 ie 0 is deleted");
		imh.delete(0);
		imh.printHeap();
		System.out.println("\n delete heap test end");
		
	}
	@Test
	public void minChildTest()
	{
		int arr[]={1,9,2,8,3,7,4,6,5,0};
		for(int i=0;i<arr.length;i++)
			imh.insert(arr[i]);
		imh.printHeap();
		
		Assert.assertTrue(imh.minChild(5)==Integer.MIN_VALUE);
		Assert.assertTrue(imh.minChild(0)==1);
		Assert.assertTrue(imh.minChild(4)==8);
		Assert.assertTrue(imh.minChild(3)==6);
		Assert.assertTrue(imh.minChild(2)==4);
		Assert.assertTrue(imh.minChild(9)==Integer.MIN_VALUE);
	}
	
	@Test
	public void indexOfValueTest()
	{
		int arr[]={1,9,2,8,3,7,4,6,5,0};
		for(int i=0;i<arr.length;i++)
			imh.insert(arr[i]);
		
		Assert.assertTrue(imh.indexOfValue(9)==7);
		Assert.assertTrue(imh.indexOfValue(3)==4);
		Assert.assertTrue(imh.indexOfValue(4)==6);
		Assert.assertTrue(imh.indexOfValue(19)==-1);
		
	}
	
	@Test
	public void decreaseIncreaseKeyTest()
	{
		int arr[]={1,9,2,8,3,7,4,6,5,0};
		for(int i=0;i<arr.length;i++)
			imh.insert(arr[i]);
		System.out.println("\nreplacing 1 by -2\n");
		imh.decreaseIncreaseKey(1, -2);
		imh.printHeap();
		System.out.println("\nreplacing 2 by 10\n");
		imh.decreaseIncreaseKey(2, 10);
		imh.printHeap();
		System.out.println("\nreplacing 3 by -1\n");
		imh.decreaseIncreaseKey(3, -1);
		imh.printHeap();
		System.out.println("\nreplacing 6 by 5\n");
		imh.decreaseIncreaseKey(6, 5);
		imh.printHeap();
		System.out.println("\nreplacing -2 by -2\n");
		imh.decreaseIncreaseKey(-2, -2);
		imh.printHeap();
		System.out.println("\nreplacing 9 by -5\n");
		imh.decreaseIncreaseKey(9, -5);
		imh.printHeap();
	}
	
	@Test
	public void heapSortTest()
	{
		System.out.println("\nheap sort start\n");
		int arr[]={1,9,2,8,3,7,4,6,5,0};
		for(int i=0;i<arr.length;i++)
			imh.insert(arr[i]);
		arr = imh.heapSort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("\nheap sort end\n");
	}
}
