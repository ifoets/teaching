/**
 * 
 */
package com.design.analysis.core.algo.randomizedalgorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/****/
public class IRandomAlgoTest {

	public IRandomAlgo ira = null;

	@Before
	public void init() {
		ira = new RandomAlgoImpl();
	}

	/** 1. Randomized Algorithms | Set 3 (1/2 Approximate Median) **/
	@Test
	public void randApproxMedian() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };

		ira.randApproxMedian(a, a.length);
	}

	/** 2. Binomial Random Variables **/
	/** 3. Generate integer from 1 to 7 with equal probability **/
	/* generate 1-5 with equal probability */
	@Test
	public void equlProbRandom1To5Test() {
		int sum = 0;
		for (int i = 1; i <= 25; i++) {
			sum += ira.equlProbRandom1To5();
			if (i % 5 == 0) {
				Assert.assertTrue(sum == 15);
				sum = 0;
			}
		}
	}

	// @Test TODO need to test
	public void rad1To7ByRand1To5() {
		int sum = 0;
		for (int i = 1; i <= 35; i++) {
			sum += ira.equlProbRandom1To5();
			System.out.print(ira.rad1To7ByRand1To5() + " ");
			if (i % 7 == 0) {
				System.out.println();
				Assert.assertTrue(sum == 28);
				sum = 0;
			}
		}
	}

	/** 4. Make a fair coin from a biased coin */
	@Test
	public void zero60AndOne40ReturnTest() {

		int sum = 0;
		for (int i = 1; i <= 25; i++) {
			// System.out.println(ira.zero60AndOne40Return());
			sum += ira.zero60AndOne40Return();
			if (i % 5 == 0) {
				Assert.assertTrue(sum == 2);
				sum = 0;
			}
		}
	}

	@Test
	public void zero60AndOne40ReturnTestTest() {

		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += ira.equlProbByzero60AndOne40Return();
			// System.out.print(ira.equlProbByzero60AndOne40Return());
			if (i % 2 == 0) {
				Assert.assertTrue(sum == 1);
				sum = 0;
			}
		}
	}

	/** 5. Shuffle a given array **/
	@Test
	public void suffleArrayTest() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		ira.suffleArray(a);
		int sum = 0;
		for (int i = 0; i < a.length; i++)
			sum += a[i];
		Assert.assertTrue(sum == 36);
	}

	/** 6. Reservoir Sampling **/
	@Test
	public void selectKItemsTest() {

		int stream[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		int k = 5;
		ira.selectKItems(stream, k);
	}

	/** 7.Select a random number from stream, with O(1) space **/
	@Test
	public void selectRnFromStreamTest() {
		Integer stream[] = { 1, 2, 3, 4 };
		int n = stream.length;
		for (int i = 0; i < n; i++)
			System.out.println("Random number from first " + (i + 1) + " numbers is " + ira.selectRnFromStream(stream));
	}

	/** 8. Random number generator in arbitrary probability distribution fashion **/
	@Test
	public void randomByFreqDistirbutionTest() {
		int arr[] = { 10, 30, 20, 40 };
		int freq[] = { 1, 6, 2, 1 };

		for (int i = 0; i < 10; i++)
			System.out.println(ira.randomByFreqDistirbution(arr, freq));
	}

	/**
	 * 9. Write a function that generates one of 3 numbers according to given
	 * probabilities
	 **/
	@Test
	public void generateNoInGienProbalTest() {

		int x = 2;
		int y = 3;
		int z = 4;
		int px = 40;	
		int py = 25;
		int pz = 35;
		for (int i = 0; i < 10; i++)
			System.out.println(ira.generateNoInGienProbal(x, y, z, px, py, pz));
	}

	/**
	 * 10. K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/
	@Test
	public void kthLargestSmallestUnsortedArrTest() {

		int arr[] = { 12, 3, 5, 7, 4, 19, 26 };

		Assert.assertTrue(ira.kthLargestSmallestUnsortedArr(arr, 4, true) == 7);
		Assert.assertTrue(ira.kthLargestSmallestUnsortedArr(arr, 3, false) == 12);
	}

	/** 11. Birthday Paradox **/
	@Test
	public void birthdayParadoxTest() {
		Assert.assertTrue(ira.birthdayParadox(0.7) == 30);
	}
}
