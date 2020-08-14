package com.design.analysis.algo.randomizedalgorithms;

/*
 * 
 * @author GuruG
 * 
1.	Random Variables
2.	Binomial Random Variables
3.	Generate integer from 1 to 7 with equal probability
4.	Make a fair coin from a biased coin
5.	Shuffle a given array
6.	Reservoir Sampling
7.	Select a random number from stream, with O(1) space
8.	Random number generator in arbitrary probability distribution fashion
9.	Write a function that generates one of 3 numbers according to given probabilities
10.	K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear Time)
11.	Birthday Paradox
12.	Linearity of Expectation
13.	Expected Number of Trials until Success
14.	Load Balancing on Servers (Randomized Algorithm)
15.	Karger’s algorithm for Minimum Cut | Set 1 (Introduction and Implementation)
16.	Select a Random Node from a Singly Linked List
17.	Karger’s algorithm for Minimum Cut | Set 2 (Analysis and Applications)
18.	Primality Test | Set 2 (Fermat Method)
19.	Generate 0 and 1 with 25% and 75% probability
20.	Implement rand3() using rand2()
21.	Strong Password Suggester Program
22.	Freivald’s Algorithm to check if a matrix is product of two
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
public interface IRandomAlgo {

	/** 1. Randomized Algorithms | Set 3 (1/2 Approximate Median) **/
	public int randApproxMedian(int a[], int n);

	/** 2. Binomial Random Variables **/
	/** 3. Generate integer from 1 to 7 with equal probability **/
	/* generate 1-5 with equal probability */
	public int equlProbRandom1To5();

	public int rad1To7ByRand1To5();

	/** 4. Make a fair coin from a biased coin */
	public int zero60AndOne40Return();

	public int equlProbByzero60AndOne40Return();

	/** 5. Shuffle a given array **/
	public void suffleArray(int a[]);

	/** 6. Reservoir Sampling **/
	public int[] selectKItems(int a[], int k);

	/** 7.Select a random number from stream with equal probality **/
	public int selectRnFromStream(Integer strm[]);

	/** 8. Random number generator in arbitrary probability distribution fashion **/
	public int randomByFreqDistirbution(int a[], int frq[]);

	/**
	 * 9. Write a function that generates one of 3 numbers according to given
	 * probabilities
	 **/
	public int generateNoInGienProbal(int x, int y, int z, int px, int py, int pz);

	/**
	 * 10. K’th Smallest/Largest Element in Unsorted Array | Set 2 (Expected Linear
	 * Time)
	 **/
	public int kthLargestSmallestUnsortedArr(int arr[], int k, boolean isLarOrSml);

	/** 11. Birthday Paradox **/
	public double birthdayParadox(double d);
	/* 12. Linearity of Expectation */
	/* 13. Expected Number of Trials until Success */
	/* 14. Load Balancing on Servers (Randomized Algorithm) */
	/*
	 * 15. Karger’s algorithm for Minimum Cut | Set 1 (Introduction and
	 * Implementation)
	 */
	/* 16. Select a Random Node from a Singly Linked List */
	
	/* 17. Karger’s algorithm for Minimum Cut | Set 2 (Analysis and Applications) */
	/* 18. Primality Test | Set 2 (Fermat Method) */
	/* 19. Generate 0 and 1 with 25% and 75% probability */
	/* 20. Implement rand3() using rand2() */
}
