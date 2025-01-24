package com.design.analysis.core.algo.string;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.design.analysis.core.algo.string.node.Node;

public class IConversionStringTest {

	public IConversionString ics = null;

	@Before
	public void init() {
		ics = new ConversionStringImpl();
	}

	/** 1. Convert all substrings of length k from base b to decimal **/
	@Test
	public void substringConversionsTest() {
		String str = "12212";
		int b = 3, k = 3;
		List<Integer> list = ics.substringConversions(str, k, b);
		Assert.assertTrue(list.size() == 3);
		Assert.assertTrue(list.contains(25));
		Assert.assertTrue(list.contains(23));
	}

	/** 2. Convert Binary fraction to Decimal **/
	@Test
	public void binaryToDecimalTest() {
		String n = "110.101";
		Assert.assertTrue(ics.binaryToDecimal(n).equals("6.625"));
	}

	/** 3. Convert decimal fraction to binary number **/
	@Test
	public void decimalToBinaryNumTest() {
		String n = "6.986";
		int k = 5;
		Assert.assertTrue(ics.decimalToBinaryNum(n, k).equals("110.11111"));
	}

	/** 4. Convert a sentence into its equivalent mobile numeric keypad sequence **/
	@Test
	public void printSequenceTest() {
		String str[] = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7",
				"77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };
		String input = "GEEKSFORGEEKS";
		Assert.assertTrue(ics.printSequence(str, input).equals("4333355777733366677743333557777"));
	}

	/**
	 * 5. Check if it is possible to convert one string into another with given
	 * constraints
	 **/
	@Test
	public void isItPossibleTest() {
		String str1 = "#A#B#B#";
		String str2 = "A###B#B";
		Assert.assertTrue(ics.isItPossible(str1, str2, str1.length(), str2.length()));
	}

	/** 16. Convert Ternary Expression to a Binary Tree **/
	@Test
	public void convertExpressionTest() {
		String exp = "a?b?c:d:e";
		char[] expression = exp.toCharArray();
		Node root = ics.convertExpression(expression, 0);
		ics.printTree(root);
	}

	/** 17. Prefix to Infix Conversion **/
	@Test
	public void prefixToInfixTest() {
		String pre_exp = "*-A/BC-/AKL";
		System.out.println(ics.prefixToInfix(pre_exp));
	}

	/** 18. Prefix to Postfix Conversion **/
	@Test
	public void prefixToPostfixTest() {
		String pre_exp = "*-A/BC-/AKL";
		System.out.println(ics.prefixToPostfix(pre_exp));
	}

	/** 19. Postfix to Prefix Conversion **/
	@Test
	public void postfixToPrefixTest() {
		String post_exp = "ABC/-AK/L-*";
		System.out.println(ics.postfixToPrefix(post_exp));
	}

	/** 20. Postfix to Infix **/
	@Test
	public void postfixToInfixTest() {
		String post_exp = "ab*c+";
		System.out.println(ics.postfixToInfix(post_exp));
	}
}
