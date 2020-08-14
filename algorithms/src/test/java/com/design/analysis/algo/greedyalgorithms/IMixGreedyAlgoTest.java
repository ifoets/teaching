package com.design.analysis.algo.greedyalgorithms;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.algo.common.JobSequencing;

public class IMixGreedyAlgoTest {

	public IMixGreedyAlgo img = null;

	@Before
	public void init() {
		img = new MixGreedyAlgoImpl();
	}

	/** 1. Minimum time to finish all jobs with given constraints **/
	@Test
	public void minTimeToFinishJobByKEmplTest() {

		Integer jobTime[] = { 4, 5, 10 };
		Assert.assertTrue(img.minTimeToFinishJobByKEmpl(jobTime, 2, 5) == 50);

		Integer jobTime1[] = { 10, 7, 8, 12, 6, 8 };
		Assert.assertTrue(img.minTimeToFinishJobByKEmpl(jobTime1, 4, 5) == 75);

		Integer jobTime2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		Assert.assertTrue(img.minTimeToFinishJobByKEmpl(jobTime2, 3, 5) == 95);
	}

	/** 2. Job Sequencing Problem | Set 2 (Using Disjoint Set) **/
	@Test
	public void jobSequencingProblemTest() {
		JobSequencing[] arr = { new JobSequencing("a", 2, 100), new JobSequencing("b", 1, 19),
				new JobSequencing("c", 2, 27), new JobSequencing("d", 1, 25), new JobSequencing("e", 3, 15) };
		List<JobSequencing> list = Arrays.asList(arr);

		List<String> result = img.jobSequencingProblem(list);
		Assert.assertTrue(result.contains("a"));
		Assert.assertTrue(result.contains("c"));
		Assert.assertTrue(result.contains("e"));
		Assert.assertTrue(!result.contains("d"));
	}

	/** 3. Minimum sum of two(X) numbers formed from digits of an array **/
	@Test
	public void minSumOfTwoNoFormByAllElemTest() {
		int a[] = { 6, 8, 4, 5, 2, 3 };
		Assert.assertTrue(img.minSumOfTwoNoFormByAllElem(a, 2) == 604);

		int b[] = { 5, 3, 0, 7, 4 };
		Assert.assertTrue(img.minSumOfTwoNoFormByAllElem(b, 2) == 82);
	}

	/** 4. Find Smallest number with given number of digits and digits sum **/

	/* it check for 1 not then for 2 so on.... */
	@Test
	public void comfortableForLeastDigitTest() {
		Assert.assertTrue(!img.comfortableForLeastDigit(1, 26, 3));
		Assert.assertTrue(!img.comfortableForLeastDigit(5, 26, 3));
		Assert.assertTrue(!img.comfortableForLeastDigit(7, 26, 3));
		Assert.assertTrue(img.comfortableForLeastDigit(8, 26, 3));
		Assert.assertTrue(img.comfortableForLeastDigit(2, 20, 3));
		Assert.assertTrue(img.comfortableForLeastDigit(9, 18, 2));
	}

	@Test
	public void minNoByGivenSumAndNoOfDigitTest() {

		Assert.assertTrue(img.minNoByGivenSumAndNoOfDigit(9, 2) == 18);
		Assert.assertTrue(img.minNoByGivenSumAndNoOfDigit(20, 3) == 299);
		Assert.assertTrue(img.minNoByGivenSumAndNoOfDigit(9, 3) == 117);
	}

	/** 5. Connect n ropes with minimum cost **/
	@Test
	public void connectNRopsInMinCostTest() {

		Integer a[] = { 4, 3, 2, 6 };
		Assert.assertTrue(img.connectNRopsInMinCost(a) == 29);
	}

	/** 6. Minimum number of Platforms required for a railway/bus station **/
	@Test
	public void minNoOfPlatformTest() {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };

		Assert.assertTrue(img.minNoOfPlatform(arr, dep) == 3);
	}

	/** 7. Minimum sum of absolute difference of pairs of two arrays **/
	@Test
	public void minSumByDiffOfTowArrTest() {

		int a[] = { 3, 2, 1 };
		int b[] = { 2, 1, 3 };
		Assert.assertTrue(img.minSumByDiffOfTowArr(a, b) == 0);

		int a1[] = { 4, 1, 8, 7 };
		int b1[] = { 2, 3, 6, 5 };
		Assert.assertTrue(img.minSumByDiffOfTowArr(a1, b1) == 6);
		;
	}

	/** 8. Maximize sum of consecutive differences in a circular array **/
	@Test
	public void maxSumConsDifOfCircularArrTest() {
		int arr[] = { 4, 2, 1, 8 };
		Assert.assertTrue(img.maxSumConsDifOfCircularArr(arr) == 18);
	}

	/** 9. Paper cut into minimum number of squares **/
	@Test
	public void cutPaperIntoMinNoOfSquareTest() {
		Assert.assertTrue(img.cutPaperIntoMinNoOfSquare(13, 29) == 9);
	}

	/** 10. Minimize sum of product of two arrays with permutation allowed **/
	@Test
	public void minSumOfProductOfTwoArraysTest() {

		Integer a[] = { 2, 1, 3 };
		Integer b[] = { 3, 2, 1 };

		Assert.assertTrue(img.minSumOfProductOfTwoArrays(a, b) == 10);
	}
}
