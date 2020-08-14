package com.design.analysis.algo.bitalgorithms;

//https://code.tutsplus.com/articles/number-systems-an-introduction-to-binary-hexadecimal-and-more--active-10848
//https://code.tutsplus.com/articles/understanding-bitwise-operators--active-11301
/*
 * 
 * 
	1.	& (bitwise AND)
	2.	| (bitwise OR)
	3.	~ (bitwise NOT)
	4.	^ (bitwise XOR)
	5.	<< (bitwise left shift)
	6.	>> (bitwise right shift)
	7.	>>> (bitwise unsigned right shift)
	8.	&= (bitwise AND assignment)
	9.	|= (bitwise OR assignment)
	10.	^= (bitwise XOR assignment)
	11.	<<= (bitwise left shift and assignment)
	12.	>>= (bitwise right shift and assignment)
	13.	>>>= (bitwise unsigned right shift and assignment)
	14. Converting From Base-8 to Base-10
	15. Converting from Base-10 to Base-8
	16. Dealing With Any Base

 */
public interface Ifundamental {

	/** decimal to binary **/
	public String decimalToBinary(int n);

	/** addition of bit numbers **/
	public int addBitInteger(int n1, int n2);

	/** 1. & (bitwise AND) **/
	public int bitwiseAND(int n1, int n2);

	/** 2. | (bitwise OR) **/
	public int bitwiseOR(int n1, int n2);

	/** 3. ~ (bitwise NOT) **/
	public int bitwiseNOT(int n);

	/** 4. ^ (bitwise XOR) **/
	public int bitwiseXOR(int n1, int n2);

	/** 5. << (bitwise left shift) **/
	public String lefShift(int n, int key);
}
