package com.design.analysis.core.ds.hashing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IHashingTest {

	public IHashing ihs = null;

	@Before
	public void init() {
		ihs = new HashingImpl();
	}
	
	@Test
	public void insertIndexMappingTest()
	{
		int arr[] = {1,2,3,4,5,6,7,8,9,0-1,-2,-3,-4,-9};
		ihs.insertIndexMapping(arr,10);
		ihs.printIndexMapping();
		
	}
	
	@Test
	public void searchIndexMappingTest()
	{
		int arr[] = {1,2,3,4,5,6,7,8,9,0-1,-2,-3,-4,-9};
		ihs.insertIndexMapping(arr,10);
		ihs.printIndexMapping();
		Assert.assertTrue(ihs.searchIndexMapping(-4)==-4);
		Assert.assertTrue(ihs.searchIndexMapping(-9)==-9);
		Assert.assertTrue(ihs.searchIndexMapping(0)==0);
		Assert.assertTrue(ihs.searchIndexMapping(9)==9);
		Assert.assertTrue(ihs.searchIndexMapping(8)==8);
		Assert.assertTrue(ihs.searchIndexMapping(-1)==-1);
	}
	
	@Test
	public void deleteIndexMappingTest()
	{
		int arr[] = {1,2,3,4,5,6,7,8,9,0-1,-2,-3,-4,-9};
		ihs.insertIndexMapping(arr,10);
		ihs.printIndexMapping();
		ihs.deleteIndexMapping(-4);
		ihs.deleteIndexMapping(4);
		Assert.assertTrue(ihs.searchIndexMapping(-4)==0);
		Assert.assertTrue(ihs.searchIndexMapping(4)==0);
		ihs.printIndexMapping();
		
	}
}
