package com.design.analysis.ds.hashing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DAIHashingTest {

	DAIHashing daih = null;

	@Before
	public void init() {
		daih = new DAHashingImpl();
	}

	@Test
	public void listLinerProbingInsertTestArr() {

		int arr[] = {1,11,21,31,41,51,61,71,81,91,22,2,32,42,52,62,72,82,10,20,30,40,50};
		daih.listLinerProbingInsert(arr, 10);
		daih.printListProb();
	}

	@Test
	public void listLinerProbingInsertTestX() {

		System.out.println("\nSingle insertion in linear probabig start\n");
		int arr[] = {1,11,21,31,41,51,61,71,81,91,22,2,32,42,52,62,72,82,10,20,30,40,50};
		daih.listLinerProbingInsert(arr, 10);
		daih.printListProb();
		System.out.println("60 92 and 90 have inserted");
		daih.listLinerProbingInsert(60);
		daih.listLinerProbingInsert(92);
		daih.listLinerProbingInsert(101);
		daih.printListProb();
		System.out.println("\nSingle insertion in linear probabig start\n");
		
	}

	@Test
	public void listLinerProbingSearchTest(){
		
		int arr[] = {1,11,21,31,41,51,61,71,81,91,22,2,32,42,52,62,72,82,10,20,30,40,50};
		daih.listLinerProbingInsert(arr, 10);
		Assert.assertTrue(daih.listLinerProbingSearch(50));
		Assert.assertTrue(daih.listLinerProbingSearch(81));
		Assert.assertTrue(daih.listLinerProbingSearch(11));
		Assert.assertTrue(daih.listLinerProbingSearch(121)==false);
		Assert.assertTrue(daih.listLinerProbingSearch(98)==false);
		
	}

	@Test
	public void listLinerProbingDelete(){
		
	}

	/**end of operation on linear probing using link list **/
	
	/**start operation on bst tree probing using link list **/
	
	@Test
	public void bstTreeProbingInsertTestArr()
	{
		int arr[] = {1,11,21,31,41,51,61,71,81,91,22,2,32,42,52,62,72,82,10,20,30,40,50};
		daih.bstTreeProbingInsert(arr, 10);
		System.out.println("\nbst tree probing start\n");
		daih.printbstTreeProb();
		System.out.println("\nbst tree probing end\n");
	}
	
	@Test
	public void bstTreeProbingInsertTestElement(){
		
		System.out.println("\nSingle insertion in tree probabig start\n");
		int arr[] = {1,11,21,31,41,51,61,71,81,91,22,2,32,42,52,62,72,82,10,20,30,40,50};
		daih.bstTreeProbingInsert(arr, 10);
		daih.printbstTreeProb();
		System.out.println("60 92 and 90 have inserted in bst probing");
		daih.bstTreeProbingInsert(60);
		daih.bstTreeProbingInsert(92);
		daih.bstTreeProbingInsert(101);
		daih.printbstTreeProb();
		System.out.println("\nSingle insertion in tree probabig start\n");
	}
	
	@Test
	public void bstTreeProbingSearchTest()
	{
		int arr[] = {1,11,21,31,41,51,61,71,81,91,22,2,32,42,52,62,72,82,10,20,30,40,50};
		daih.bstTreeProbingInsert(arr, 10);
		Assert.assertTrue(daih.bstTreeProbingSearch(50));
		Assert.assertTrue(daih.bstTreeProbingSearch(81));
		Assert.assertTrue(daih.bstTreeProbingSearch(11));
		Assert.assertTrue(daih.bstTreeProbingSearch(121)==false);
		Assert.assertTrue(daih.bstTreeProbingSearch(98)==false);
	}
	
	@Test
	public void bstTreeProbingDeleteTest(){
		
	}
}
