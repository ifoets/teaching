package com.design.analysis.core.algo.bitalgorithms;

/*
 * Basic :
1.	Find the element that appears once
2.	Detect if two integers have opposite signs
3.	Add 1 to a given number
4.	Multiply a given Integer with 3.5
5.	Turn off the rightmost set bit
6.	Find whether a given number is a power of 4 or not
7.	Compute modulus division by a power-of-2-number
8.	Rotate bits of a number
9.	Find the Number Occurring Odd Number of Times
10.	Check for Integer Overflow
11.	Little and Big Endian Mystery
12.	Count set bits in an integer
13.	Count number of bits to be flipped to convert A to B
14.	Efficient way to multiply with 7
15.	Program to find whether a no is power of two
16.	Position of rightmost set bit
17.	Binary representation of a given number
18.	Find position of the only set bit
19.	How to swap two numbers without using a temporary variable?
20.	Swap two nibbles in a byte
21.	How to turn off a particular bit in a number?
22.	Russian Peasant (Multiply two numbers using bitwise operators)
23.	Add two bit strings
24.	Write your own strcmp that ignores cases
25.	Check if two numbers are equal without using arithmetic and comparison operators
26.	Find XOR of two number without using XOR operator
27.	XOR counts of 0s and 1s in binary representation
28.	Calculate XOR from 1 to n
29.	Multiply a number with 10 without using multiplication operator
30.	Equal Sum and XOR
31.	Swap three variables without using temporary variable
32.	Check if a number has bits in alternate pattern
33.	Count minimum bits to flip such that XOR of A and B equal to C
34.	Efficient method for 2’s complement of a binary string
35.	Toggle case of a string using Bitwise operators
36.	Toggling k-th bit of a number
37.	Convert decimal fraction to binary number
38.	Toggle all the bits of a number except k-th bit
39.	Set the rightmost unset bit
40.	Convert a binary number to octal
41.	Check in binary array the number represented by a subarray is odd or even
42.	Toggle the last m bits
43.	1 to n bit numbers with no consecutive 1s in binary representation
44.	Toggle bits in the given range
45.	Unset bits in the given range
46.	Find the largest number with n set and m unset bits
47.	Find the smallest number with n set and m unset bits
48.	Sum of numbers with exactly 2 bits set
49.	Check if binary representation of a given number and its complement are anagram
50.	Josephus Problem Using Bit Magic

 */
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBitAlgoBasicTest {

	public IBitAlgoBasic iba = null;

	@Before
	public void init() {
		iba = new BitAlgoBasicImpl();
	}

	/** 1.Find the element that appears once **/
	@Test
	public void eleApperOnceTest() {
		int arr[] = { 12, 1, 12, 3, 12, 1, 1, 2, 3, 3 };
		Assert.assertTrue(iba.eleApperOnce(arr) == 2);
	}

	/** 2.Detect if two integers have opposite signs **/
	@Test
	public void detectOppositeSignTest() {
		Assert.assertTrue(!iba.detectOppositeSign(1, 2));
		Assert.assertTrue(iba.detectOppositeSign(1, -2));
	}

	@Test
	public void countSetBitsTest() {
		Assert.assertTrue(iba.countSetBits(3) == 4);
		Assert.assertTrue(iba.countSetBits(6) == 9);
		Assert.assertTrue(iba.countSetBits(7) == 12);
		Assert.assertTrue(iba.countSetBits(8) == 13);
	}

	/** 3. Add 1 to a given number **/
	/** 4. Multiply a given Integer with 3. **/
	/** 5. Turn off the rightmost set bit **/

}
