/**
 * 
 */
package com.design.analysis.core.algo.randomizedalgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/*
 * 
 * @author GuruG
 * 
 * 1.	Random Variables
2.	Binomial Random Variables
3.	Generate integer from 1 to 7 with equal probability
4.	Make a fair coin from a biased coin
5.	Shuffle a given array
6.	Reservoir Sampling
7.	Select a random number from stream, with O(1) space
8.	Random number generator in arbitrary probability distribution fashion
9.	Write a function that generates one of 3 numbers according to given probabilities
10.	K�th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear Time)
11.	Birthday Paradox
12.	Linearity of Expectation
13.	Expected Number of Trials until Success
14.	Load Balancing on Servers (Randomized Algorithm)
15.	Karger�s algorithm for Minimum Cut | Set 1 (Introduction and Implementation)
16.	Select a Random Node from a Singly Linked List
17.	Karger�s algorithm for Minimum Cut | Set 2 (Analysis and Applications)
18.	Primality Test | Set 2 (Fermat Method)
19.	Generate 0 and 1 with 25% and 75% probability
20.	Implement rand3() using rand2()
21.	Strong Password Suggester Program
22.	Freivald�s Algorithm to check if a matrix is product of two
23.	mplement random-0-6-Generator using the given random-0-1-Generator
24.	Select a Random Node from a tree with equal probability
25.	QuickSort using Random Pivoting
26.	Operations on Sparse Matrices
27.	Random Walk (Implementation in Python)
28.	Expectation or expected value of an array
29.	Estimating the value of Pi using Monte Carlo
30.	Randomized Binary Search Algorithm
31.	Shuffle a deck of cards
32.	Program to generate CAPTCHA and verify user
33.	Find an index of maximum occurring element with equal probability
34.	Implement rand12() using rand6() in one line


 */
public class RandomAlgoImpl implements IRandomAlgo {

	/** 1. Randomized Algorithms | Set 3 (1/2 Approximate Median) **/
	public int randApproxMedian(int a[], int n) {

		Random r = new Random();

		if (n == 0)
			return 0;

		double k = 100 * Math.log(n);
		int k1 = (int) k;

		TreeSet<Integer> tree = new TreeSet<>();

		for (int i = 0; i < k1; i++) {
			int index = r.nextInt(n);
			tree.add(a[index]);
		}
		Iterator<Integer> itr = tree.iterator();
		int temp = tree.size() / 2 - 1;

		for (int i = 0; i < temp; i++) {
			itr.next();
		}
		return itr.next();
	}

	/** 2. Binomial Random Variables **/
	/** 3. Generate integer from 1 to 7 with equal probability **/
	/* generate 1-5 with equal probability */
	Set<Integer> set = new HashSet<>();

	@Override
	public int equlProbRandom1To5() {
		int rNo = 0;
		Random r = new Random();
		if (set.isEmpty()) {
			set = new HashSet<>();
			for (int i = 1; i <= 5; i++)
				set.add(i);
		}
		rNo = r.nextInt(25);
		while (!set.contains(rNo + 1)) {
			rNo = r.nextInt(25);
		}
		set.remove(rNo + 1);

		return rNo + 1;
	}

	Set<Integer> set1 = new HashSet<>();

	@Override // TODO test is failing
	public int rad1To7ByRand1To5() {

		int i = equlProbRandom1To5() + equlProbRandom1To5() - 5;
		if (i < 22)
			return i % 7 + 1;
		return rad1To7ByRand1To5();
	}

	/** 4. Make a fair coin from a biased coin */
	int i = 0;

	@Override
	public int zero60AndOne40Return() {
		i++;
		if (i % 2 == 0) {
			return 1;
		} else {
			if (i == 5)
				i = 0;
			return 0;
		}
	}

	int j = 1;

	// @Override
	public int zero60AndOne40Return1() {
		j++;
		if (j % 2 == 0) {
			return 1;
		} else {
			if (j == 5)
				j = 0;
			return 0;
		}
	}

	@Override
	public int equlProbByzero60AndOne40Return() {

		int a = zero60AndOne40Return();
		int b = zero60AndOne40Return1();
		if (a == 0 && b == 1)
			return 0;
		if (a == 1 && b == 0)
			return 1;
		return equlProbByzero60AndOne40Return();
	}

	/** 5. Shuffle a given array **/
	@Override
	public void suffleArray(int a[]) {
		Random r = new Random();
		for (int i = a.length - 1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	/** 6. Reservoir Sampling **/
	@Override
	public int[] selectKItems(int stream[], int k) {

		int i; // index for elements in stream[]

		// reservoir[] is the output array. Initialize it with
		// first k elements from stream[]
		int reservoir[] = new int[k];
		for (i = 0; i < k; i++)
			reservoir[i] = stream[i];

		Random r = new Random();

		// Iterate from the (k+1)th element to nth element
		for (; i < stream.length; i++) {
			// Pick a random index from 0 to i.
			int j = r.nextInt(i + 1);

			// If the randomly picked index is smaller than k,
			// then replace the element present at the index
			// with new element from stream
			if (j < k)
				reservoir[j] = stream[i];
		}

		System.out.println("Following are k randomly selected items");
		System.out.println(Arrays.toString(reservoir));
		return reservoir;
	}

	/** 7.Select a random number from stream, with O(1) space **/
	public static int count = 0;

	@Override
	public int selectRnFromStream(Integer strm[]) {

		if (count == 0)
			count = strm.length;
		if (count == 1) {
			count--;
			return strm[0];
		}
		// swap the random selected index no with last and decrease the count;
		Random r = new Random();
		int index = r.nextInt(count);
		int temp = strm[index];
		strm[index] = strm[count - 1];
		strm[count - 1] = temp;
		count--;
		return strm[count];
	}

	/** 8. Random number generator in arbitrary probability distribution fashion **/
	public int countr = 0;
	Integer arr[] = null;

	@Override
	public int randomByFreqDistirbution(int a[], int frq[]) {

		if (countr == 0) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < frq.length; i++) {
				for (int j = 0; j < frq[i]; j++)
					list.add(a[i]);
			}
			arr = new Integer[list.size()];
			for (int j = 0; j < arr.length; j++)
				arr[j] = list.get(j);

			if (countr == 0)
				countr = arr.length;
			if (countr == 1) {
				countr--;
				return arr[0];
			}
		}
		Random r = new Random();
		int index = r.nextInt(countr);
		int temp = arr[index];
		arr[index] = arr[countr - 1];
		arr[countr - 1] = temp;
		countr--;
		return arr[countr];
	}

	/**
	 * 9. Write a function that generates one of 3 numbers according to given
	 * probabilities
	 **/
	@Override
	public int generateNoInGienProbal(int x, int y, int z, int px, int py, int pz) {
		// Generate a number from 1 to 100
		Random rm = new Random();
		int r = rm.nextInt(100);

		// r is smaller than px with probability px/100
		if (r < px)
			return x;

		// r is greater than px and smaller than or equal to px+py
		// with probability py/100
		if (r < (px + py))
			return y;

		// r is greater than px+py and smaller than or equal to 100
		// with probability pz/100
		else
			return z;
	}

	/**
	 * 10. K�th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time) no are unque and positive
	 **/
	public int kthLargestSmallestUnsortedArr(int a[], int k, boolean isSmlOrLar) {

		int max = a[0];
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
			if (min > a[i])
				min = a[i];
		}
		int b[] = new int[max + 1];
		for (int i = 0; i < a.length; i++)
			b[a[i]] = a[i];

		int count = 0;
		if (isSmlOrLar) {
			for (int i = 0; i < b.length; i++) {
				if (b[i] != 0)
					count++;
				if (count == k)
					return b[i];
			}
		} else {
			for (int i = b.length - 1; i >= 0; i--) {
				if (b[i] != 0)
					count++;
				if (count == k)
					return b[i];
			}
		}
		return -1;
	}

	/** 11. Birthday Paradox **/
	public double birthdayParadox(double p) {
		return Math.ceil(Math.sqrt(2 * 365 * Math.log(1 / (1 - p))));
	}
}
