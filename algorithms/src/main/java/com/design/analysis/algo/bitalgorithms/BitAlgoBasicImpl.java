package com.design.analysis.algo.bitalgorithms;

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
import java.util.HashMap;
import java.util.Map;

import com.design.analysis.algo.utils.AlgoUtils;

public class BitAlgoBasicImpl implements IBitAlgoBasic {

	/** 1.Find the element that appears once **/
	@Override // assume only one is unique
	public int eleApperOnce(int arr[]) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == null)
				map.put(arr[i], 1);
			else
				map.put(arr[i], map.get(arr[i]) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1)
				return entry.getKey();
		}
		return -1;
	}

	/** 2.Detect if two integers have opposite signs **/
	public boolean detectOppositeSign(int x, int y) {
		return (x ^ y) < 0;
	}

	public int countSetBits(int n) {
		int bitCount = 0;
		for (int i = 1; i <= n; i++)
			bitCount += AlgoUtils.countSetBitsUtil(i);
		return bitCount;
	}

	/** 3. Add 1 to a given number **/
	@Override
	public int addOne(int n) {
          return 1;
	}
}
