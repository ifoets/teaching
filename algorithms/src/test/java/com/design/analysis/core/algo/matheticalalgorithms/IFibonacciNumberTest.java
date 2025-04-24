package com.design.analysis.core.algo.matheticalalgorithms;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IFibonacciNumberTest {

	IFibonacciNumber ifn = null;

	@Before
	public void init() {
		ifn = new FibonacciNumberImpl();
	}

	/** 1. Fibonacci Numbers **/
	@Test
	public void nthFibonaciNumTest() {

		Assert.assertTrue(ifn.nthFibonaciNum(2) == 1);
		Assert.assertTrue(ifn.nthFibonaciNum(9) == 34);
	}

	/** 2. Interesting facts about Fibonacci numbers **/

	/* the last digit is repeating in fibonaci after soem index */
	@Test
	public void repeatingIndexOfLastDigitTest() {
		Assert.assertTrue(ifn.repeatingIndexOfLastDigit() == 60);
	}

	/** 3. How to check if a given number is Fibonacci number? **/
	@Test
	public void isFibonacciTest() {
		Assert.assertTrue(ifn.isFibonacci(21));
		Assert.assertTrue(ifn.isFibonacci(144));
		Assert.assertTrue(!ifn.isFibonacci(150));
		Assert.assertTrue(!ifn.isFibonacci(56));
	}

	/** 4. Zeckendorf s Theorem (Non-Neighbouring Fibonacci Representation) **/
	@Test
	public void nonNeighborFibonacciRepresentTest() {
		List<Integer> list = ifn.nonNeighborFibonacciRepresent(30);
		Assert.assertTrue(list.size() == 3);
	}

	/* nearest fibonacci no */
	@Test
	public void nearestSmallerEqFibTest() {
		Assert.assertTrue(ifn.nearestSmallerEqFib(30) == 21);
	}

	/** 5. Finding nth Fibonacci Number using Golden Ratio **/
	@Test
	public void fiboNoByGoldenRatioTest() {
		Assert.assertTrue(ifn.fiboNoByGoldenRatio(9) == 34);
	}

	/** 6. Matrix Exponentiation **/
	// TODO
	/** 7. Fibonacci Coding **/
	@Test
	public void fibonacciEncodingTest() {
		Assert.assertTrue(ifn.fibonacciEncoding(143).trim().equals("01010101011"));
	}

	@Test
	public void largestFiboLessOrEqualTest() {
		Assert.assertTrue(ifn.largestFiboIndexLessOrEqual(30) == 6);
	}

	/** 8. n th multiple of a number in Fibonacci Series **/
	@Test
	public void nthMaulitpleInFiboIndexTest() {
		Assert.assertTrue(ifn.nthMaulitpleInFiboIndex(2, 3) == 9);
		Assert.assertTrue(ifn.nthMaulitpleInFiboIndex(4, 5) == 30);
	}

	/** 9. GCD and Fibonacci Numbers **/
	@Test
	public void gcdOfFiboNumsTest() {

		Assert.assertTrue(ifn.gcdOfFiboNums(3, 12) == 2);
	}

	/** 10. Cassini s Identity **/
	@Test
	public void cassintiIndentityTest() {
		Assert.assertTrue(ifn.cassintiIndentity(5) == -1);
	}

	/** 11. N-bonacci Numbers **/
	@Test
	public void nBonacciNummTest() {
		ifn.nBonacciNumm(15, 5);
	}

	/** 12. Space efficient iterative method to Fibonacci number **/
	/** 13. The Magic of Fibonacci Numbers **/
	/** 14. Program to print Fibonacci Triangle **/
	@Test
	public void fiboTriangleTest() {
		ifn.fiboTriangle(5);
	}
	/** 15. Factorial of each element in Fibonacci series **/
}
