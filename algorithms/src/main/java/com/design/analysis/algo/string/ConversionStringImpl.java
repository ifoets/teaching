package com.design.analysis.algo.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.design.analysis.algo.string.node.Node;

public class ConversionStringImpl implements IConversionString {

	/** 1. Convert all substrings of length ‘k’ from base ‘b’ to decimal **/
	@Override
	public List<Integer> substringConversions(String str, int k, int b) {

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i + k <= str.length(); i++) {
			// Saving substring in sub
			String sub = str.substring(i, k + i);
			// Evaluating decimal for current substring
			// and printing it.
			int sum = 0, counter = 0;
			for (int j = sub.length() - 1; j >= 0; j--) {
				sum = sum + (int) ((sub.charAt(j) - '0') * Math.pow(b, counter));
				counter++;
			}
			list.add(sum);
		}
		return list;
	}

	/** 2. Convert Binary fraction to Decimal **/
	@Override
	public String binaryToDecimal(String binary) {
		double intDecimal = 0, fracDecimal = 0, twos = 1;

		// Convert integral part of binary to decimal
		// equivalent
		int point = binary.length();
		if (binary.contains("."))
			point = binary.indexOf(".");
		for (int i = point - 1; i >= 0; --i) {
			// Subtract '0' to convert character
			// into integer
			intDecimal += (binary.charAt(i) - '0') * twos;
			twos *= 2;
		}
		// decimal part to from binary to decimal
		twos = 2;
		for (int i = point + 1; i < binary.length(); ++i) {
			fracDecimal += (binary.charAt(i) - '0') / twos;
			twos *= 2.0;
		}

		// Add both integral and fractional part
		return String.valueOf(intDecimal + fracDecimal);
	}

	/** 3. Convert decimal fraction to binary number **/
	@Override
	public String decimalToBinaryNum(String decimal, int k_prec) {
		String rslt = null;
		double fractional;
		int point = decimal.length();
		if (decimal.contains("."))
			point = decimal.indexOf(".");
		int inte = Integer.valueOf(decimal.substring(0, point));
		fractional = Double.valueOf(decimal.substring(point, decimal.length()));

		StringBuilder sb = new StringBuilder();
		// integral part
		while (inte > 0) {
			int rem = inte % 2;

			// Append 0 in binary
			sb.append(rem);

			inte /= 2;
		}
		rslt = sb.reverse().toString() + ".";
		sb = new StringBuilder();

		// fraction part
		while (k_prec-- > 0) {
			// Find next bit in fraction
			fractional *= 2;
			int fract_bit = (int) fractional;

			if (fract_bit == 1) {
				fractional -= fract_bit;
				sb.append(1);
			} else
				sb.append(0);
		}
		rslt += sb.toString();
		return rslt;
	}

	/** 4. Convert a sentence into its equivalent mobile numeric keypad sequence **/
	@Override
	public String printSequence(String arr[], String input) {
		String output = "";

		int n = input.length();
		for (int i = 0; i < n; i++) {
			// Checking for space
			if (input.charAt(i) == ' ')
				output = output + "0";

			else {
				// Calculating index for each
				// character
				int position = input.charAt(i) - 'A';
				output = output + arr[position];
			}
		}
		// Output sequence
		return output;
	}

	@Override
	public boolean isItPossible(String s1, String s2, int m, int n) {

		char str1[] = s1.toCharArray();
		char str2[] = s2.toCharArray();
		// To Check Length of Both String is Equal or Not
		if (m != n)
			return false;

		// To Check Frequency of A's and B's are
		// equal in both strings or not.
		if (s1.chars().filter(ch -> ch == 'A').count() != s2.chars().filter(ch -> ch == 'A').count()
				|| s1.chars().filter(ch -> ch == 'B').count() != s1.chars().filter(ch -> ch == 'B').count())
			return false;

		// Start traversing
		for (int i = 0; i < m; i++) {
			if (str1[i] != '#') {
				for (int j = 0; j < n; j++) {

					// To Check no two elements cross each other.
					if ((str2[j] != str1[i]) && str2[j] != '#')
						return false;

					if (str2[j] == str1[i]) {
						str2[j] = '#';

						// To Check Is it Possible to Move
						// towards Left or not.
						if (str1[i] == 'A' && i < j)
							return false;

						// To Check Is it Possible to Move
						// towards Right or not.
						if (str1[i] == 'B' && i > j)
							return false;

						break;
					}
				}
			}
		}
		return true;
	}

	/** 16. Convert Ternary Expression to a Binary Tree **/
	public Node convertExpression(char[] expression, int i) {
		// Base case
		if (i >= expression.length)
			return null;

		// store current character of expression_string
		// [ 'a' to 'z']
		Node root = new Node(expression[i]);

		// Move ahead in str
		++i;

		// if current character of ternary expression is '?'
		// then we add next character as a left child of
		// current node
		if (i < expression.length && expression[i] == '?')
			root.lt = convertExpression(expression, i + 1);

		// else we have to add it as a right child of
		// current node expression.at(0) == ':'
		else if (i < expression.length)
			root.rt = convertExpression(expression, i + 1);

		return root;
	}

	public void printTree(Node root) {
		if (root == null)
			return;

		System.out.print(root.dt + " ");
		printTree(root.lt);
		printTree(root.rt);
	}

	/** 17. Prefix to Infix Conversion **/
	@Override
	public String prefixToInfix(String preExpStr) {
		Stack<String> s = new Stack<>();
		char pre_exp[] = preExpStr.toCharArray();
		int length = preExpStr.length();

		// reading from right to left
		for (int i = length - 1; i >= 0; i--) {
			// check if symbol is operator
			if (isOperator(pre_exp[i])) {
				// pop two operands from stack
				String op1 = s.pop();
				String op2 = s.pop();
				// concat the operands and operator
				String temp = "(" + op1 + pre_exp[i] + op2 + ")";
				// Push string temp back to stack
				s.push(temp);
			}
			// if symbol is an operand
			else {
				// push the operand to the stack
				s.push(pre_exp[i] + "");
			}
		}
		// Stack now contains the Infix expression
		return s.toString();
	}

	@Override
	public boolean isOperator(char x) {
		switch (x) {
		case '+':
		case '-':
		case '/':
		case '*':
			return true;
		}
		return false;
	}

	/** 18. Prefix to Postfix Conversion **/
	@Override
	public String prefixToPostfix(String preExpStr) {
		Stack<String> s = new Stack<>();
		char pre_exp[] = preExpStr.toCharArray();
		int length = preExpStr.length();

		// reading from right to left
		for (int i = length - 1; i >= 0; i--) {
			// check if symbol is operator
			if (isOperator(pre_exp[i])) {
				// pop two operands from stack
				String op1 = s.pop();
				String op2 = s.pop();
				// concat the operands and operator
				String temp = op1 + op2 + pre_exp[i];
				// Push string temp back to stack
				s.push(temp);
			}
			// if symbol is an operand
			else {
				// push the operand to the stack
				s.push(pre_exp[i] + "");
			}
		}
		// Stack now contains the Infix expression
		return s.toString();
	}

	/** 19. Postfix to Prefix Conversion **/
	@Override
	public String postfixToPrefix(String postExpStr) {
		Stack<String> s = new Stack<>();
		char pre_exp[] = postExpStr.toCharArray();
		int length = postExpStr.length();

		// reading from right to left
		for (int i = 0; i < length; i++) {
			// check if symbol is operator
			if (isOperator(pre_exp[i])) {
				// pop two operands from stack
				String op1 = s.pop();
				String op2 = s.pop();
				// concat the operands and operator
				String temp = pre_exp[i] + op1 + op2;
				// Push string temp back to stack
				s.push(temp);
			}
			// if symbol is an operand
			else {
				// push the operand to the stack
				s.push(pre_exp[i] + "");
			}
		}
		// Stack now contains the Infix expression
		return s.toString();
	}

	/** 20. Postfix to Infix **/
	public boolean isOperand(char x) {
		return (x >= 'a' && x <= 'z') || (x >= 'A' && x <= 'Z');
	}

	@Override
	public String postfixToInfix(String postExpStr) {
		Stack<String> s = new Stack<>();
		char post_exp[] = postExpStr.toCharArray();
		int length = postExpStr.length();

		// reading from right to left
		for (int i = 0; i < length; i++) {
			// if(isOperand(pre))
			// check if symbol is operator
			if (isOperator(post_exp[i])) {
				// pop two operands from stack
				String op1 = s.pop();
				String op2 = s.pop();
				// concat the operands and operator
				String temp = "(" + op1 + post_exp[i] + op2 + ")";
				// Push string temp back to stack
				s.push(temp);
			}
			// if symbol is an operand
			else {
				// push the operand to the stack
				s.push(post_exp[i] + "");
			}
		}
		// Stack now contains the Infix expression
		return s.toString();
	}
}
