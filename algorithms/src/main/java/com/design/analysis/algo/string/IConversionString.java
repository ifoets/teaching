package com.design.analysis.algo.string;

import java.util.List;

import com.design.analysis.algo.string.node.Node;

/*
 * 
 * @author GuruG
 * 
 * Conversion :
	1.	Convert all substrings of length ‘k’ from base ‘b’ to decimal
	2.	Convert Binary fraction to Decimal
	3.	Convert decimal fraction to binary number
	4.	Convert a sentence into its equivalent mobile numeric keypad sequence
	5.	Check if it is possible to convert one string into another with given constraints
	6.	Converting one string to other using append and delete last operations
	7.	Converting Decimal Number lying between 1 to 3999 to Roman Numerals
	8.	Converting Roman Numerals to Decimal lying between 1 to 3999
	9.	Inverting the Move to Front Transform
	10.	Burrows – Wheeler Data Transform Algorithm
	11.	Check if it is possible to transform one string to another
	12.	Transform the string
	13.	An in-place algorithm for String Transformation
	14.	Ways of transforming one string to other by removing 0 or more characters
	15.	Transform One String to Another using Minimum Number of Given Operation
	16.	Convert Ternary Expression to a Binary Tree
	17.	Prefix to Infix Conversion
	18.	Prefix to Postfix Conversion
	19.	Postfix to Prefix Conversion
	20.	Postfix to Infix

 */
public interface IConversionString {

	/** 1. Convert all substrings of length ‘k’ from base ‘b’ to decimal **/
	public List<Integer> substringConversions(String str, int k, int b);

	/** 2. Convert Binary fraction to Decimal **/
	public String binaryToDecimal(String binary);

	/** 3. Convert decimal fraction to binary number **/
	public String decimalToBinaryNum(String s, int k_prec);

	/** 4. Convert a sentence into its equivalent mobile numeric keypad sequence **/
	public String printSequence(String arr[], String input);

	/**
	 * 5. Check if it is possible to convert one string into another with given
	 * constraints
	 **/
	public boolean isItPossible(String s1, String s2, int m, int n);

	/** 6. Converting one string to other using append and delete last operations */
	/* 7. Converting Decimal Number lying between 1 to 3999 to Roman Numerals */
	/* 8. Converting Roman Numerals to Decimal lying between 1 to 3999 */
	/* 9. Inverting the Move to Front Transform */
	/* 10. Burrows – Wheeler Data Transform Algorithm */

	/** 16. Convert Ternary Expression to a Binary Tree **/
	public Node convertExpression(char[] expression, int i);

	public void printTree(Node root);

	/** 17. Prefix to Infix Conversion **/
	public String prefixToInfix(String str);

	public boolean isOperator(char x);

	/** 18. Prefix to Postfix Conversion **/
	public String prefixToPostfix(String str);

	/** 19. Postfix to Prefix Conversion **/
	public String postfixToPrefix(String str);

	/** 20. Postfix to Infix **/
	public String postfixToInfix(String str);
}
