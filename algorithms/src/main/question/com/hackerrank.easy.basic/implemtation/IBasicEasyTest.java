package com.hackerrank.ps.basic.easy.implemtation;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBasicEasyTest {

	IBasicEasylmentationImp ibe;

	@Before
	public void init() {
		ibe = new BasicEasyImplmentationImpl();
	}

	/** Implementation **/ // start....

	/* count Apple and Orange */
	@Test
	public void countApplesAndOrangesTest() {

		int a[] = ibe.countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[1] == 1);
	}

	@Test
	public void countApplesAndOrangesStreamTest() {

		long a[] = ibe.countApplesAndOrangesStream(7, 11, 5, 15, List.of(-2, 2, 1), List.of(5, -6));
		Assert.assertTrue(a[0] == 1);
		Assert.assertTrue(a[1] == 1);
	}

	/* Number Line Jumps */
	@Test
	public void kangarooTest() {
		// x1, v1, x2, v2
		Assert.assertTrue("YES".equalsIgnoreCase(ibe.kangaroo(0, 3, 4, 2)));
		Assert.assertTrue("NO".equalsIgnoreCase(ibe.kangaroo(0, 2, 5, 3)));
	}

	/* Between Two Sets */
	@Test
	public void getTotalXTest() {
		Assert.assertTrue(ibe.getTotalX(List.of(2, 4), List.of(16, 32, 96)) == 3);
		Assert.assertTrue(ibe.getTotalX(List.of(6, 2), List.of(24, 36)) == 2);
		Assert.assertTrue(ibe.getTotalX(List.of(1), List.of(100)) == 9);
	}

	/* Breaking the Records */
	@Test
	public void breakingRecordsTest() {
		List<Integer> result = ibe.breakingRecords(List.of(10, 5, 20, 20, 4, 5, 2, 25, 1));
		Assert.assertTrue(result.get(0) == 2);
		Assert.assertTrue(result.get(1) == 4);
	}

	/* Subarray Division */
	@Test
	public void birthdayTest() {
		Assert.assertTrue(ibe.birthday(List.of(1, 2, 1, 3, 2), 3, 2) == 2);
	}

	/* Divisible Sum Pairs */
	@Test
	public void divisibleSumPairsTest() {
		Assert.assertTrue(ibe.divisibleSumPairs(6, 3, List.of(1, 3, 2, 6, 1, 2)) == 5);
	}

	/* Migratory Birds */
	@Test
	public void migratoryBirdsTest() {
		Assert.assertTrue(ibe.migratoryBirds(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)) == 3);
	}

	@Test
	public void migratoryBirdsStreamFTest() {
		Assert.assertTrue(ibe.migratoryBirdsStream(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)) == 3);
	}

	/* Day of the Programmer */
	@Test
	public void dayOfProgrammerTest() {
		Assert.assertTrue(ibe.dayOfProgrammer(2017).equals("13.09.2017"));
		Assert.assertTrue(ibe.dayOfProgrammer(1918).equals("26.09.1918"));
	}

	/* Bill Division */
	@Test
	public void bonAppetitTest() {
		ibe.bonAppetit(List.of(3, 10, 2, 9), 1, 12);
	}

	/* Sales by Match */
	@Test
	public void sockMerchantTest() {
		List<Integer> list = List.of(10, 20, 20, 10, 10, 30, 50, 10, 20);
		Assert.assertTrue(ibe.sockMerchant(list.size(), list) == 3);
	}

	/* Drawing Book */
	@Test
	public void pageCountTest() {
		Assert.assertTrue(ibe.pageCount(5, 4) == 0);
		Assert.assertTrue(ibe.pageCount(6, 2) == 1);
	}

	/* Counting Valleys */
	@Test
	public void countingValleysTest() {// DDUUUUDD
		Assert.assertTrue(ibe.countingValleys(8, "UDDDUDUU") == 1);
	}

	/* Electronics Shop */
	@Test
	public void getMoneySpentTest() {
		int a[] = { 40, 50, 60 };
		int b[] = { 5, 8, 12 };
		Assert.assertTrue(ibe.getMoneySpent(a, b, 60) == 58);
	}

	/* Cats and a Mouse */
	@Test
	public void catAndMouseTest() {
		Assert.assertTrue(ibe.catAndMouse(1, 2, 3).equals("Cat B"));
		Assert.assertTrue(ibe.catAndMouse(1, 3, 2).equals("Mouse C"));
	}

	/* Picking Numbers */
	@Test
	public void pickingNumbersTest() {
		Assert.assertTrue(ibe.pickingNumbers(List.of(1, 2, 2, 1, 2)) == 5);
		Assert.assertTrue(ibe.pickingNumbers(List.of(1, 2, 2, 3, 1, 2)) == 5);
		Assert.assertTrue(ibe.pickingNumbers(List.of(4, 6, 5, 3, 3, 1)) == 3);

	}

	/* The Hurdle Race */
	@Test
	public void hurdleRaceTest() {
		Assert.assertTrue(ibe.hurdleRace(7, List.of(2, 5, 4, 5, 2)) == 0);
		Assert.assertTrue(ibe.hurdleRace(4, List.of(1, 6, 3, 5, 2)) == 2);
	}

	/* Designer PDF Viewer */
	@Test
	public void designerPdfViewerTest() {
		List<Integer> list1 = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
		List<Integer> list2 = List.of(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);
		Assert.assertTrue(ibe.designerPdfViewer(list1, "abc") == 9);
		Assert.assertTrue(ibe.designerPdfViewer(list2, "zaba") == 28);
	}

	/** Implementation **/ // continue....
	/**********************************************************************************************************************************************************************/

}
