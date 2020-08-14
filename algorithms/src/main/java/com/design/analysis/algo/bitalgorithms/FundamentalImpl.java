package com.design.analysis.algo.bitalgorithms;

import java.util.ArrayList;
import java.util.List;

public class FundamentalImpl implements Ifundamental {

	/** decimal to binary **/
	public String decimalToBinary(int n) {
		List<Integer> list = new ArrayList<>();
		StringBuilder sBuilder = new StringBuilder();
		int i = 0;
		while (n > 0) {
			if (n % 2 == 1)
				list.add(1);
			else
				list.add(0);
			n /= 2;
		}
		for (i = list.size() - 1; i >= 0; sBuilder.append(list.get(i)), i--)
			;
		int len = sBuilder.length();
		for (i = len; i < 8; sBuilder.append(0), i++)
			;
		return sBuilder.reverse().toString();
	}

	/** addition of bit numbers **/
	public int addBitInteger(int n1, int n2) {

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int num;
		while (n1 > 0 || n2 > 0) {
			num = n1 % 10 + n2 % 10 + carry;
			if (num < 2)
				sb.append(num);
			else {
				sb.append(num - 2);
				carry = 1;
			}

			n1 /= 10;
			n2 /= 10;
		}
		if (carry == 1)
			sb.append(carry);
		return Integer.valueOf(sb.reverse().toString());
	}

	/** 1. & (bitwise AND) **/
	public int bitwiseAND(int n1, int n2) {
		StringBuilder sb = new StringBuilder();
		while (n1 > 0 || n2 > 0) {
			if (n1 % 10 == 1 && n2 % 10 == 1)
				sb.append(1);
			else
				sb.append(0);
			n1 /= 10;
			n2 /= 10;
		}
		return Integer.valueOf(sb.reverse().toString());
	}

	/** 2. | (bitwise OR) **/
	public int bitwiseOR(int n1, int n2) {
		StringBuilder sb = new StringBuilder();
		while (n1 > 0 || n2 > 0) {
			if (n1 % 10 == 1 || n2 % 10 == 1)
				sb.append(1);
			else
				sb.append(0);
			n1 /= 10;
			n2 /= 10;
		}
		return Integer.valueOf(sb.reverse().toString());
	}

	/** 3. ~ (bitwise NOT) **/
	public int bitwiseNOT(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			if (n % 10 == 1)
				sb.append(0);
			else
				sb.append(1);
			n /= 10;
		}
		return Integer.valueOf(sb.reverse().toString());
	}

	/** 4. ^ (bitwise XOR) **/
	public int bitwiseXOR(int n1, int n2) {
		StringBuilder sb = new StringBuilder();
		while (n1 > 0 || n2 > 0) {
			if (n1 % 10 == n2 % 10)
				sb.append(0);
			else
				sb.append(1);
			n1 /= 10;
			n2 /= 10;
		}
		return Integer.valueOf(sb.reverse().toString());
	}

	/** 5. << (bitwise left shift) **/
	//TODO
	public String lefShift(int n, int key) {
		StringBuilder sb = new StringBuilder(decimalToBinary(n).substring(key));
		while (key-- > 0) {
			sb.append(0);
		}
		return sb.toString();
	}
}
