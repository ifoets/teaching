package com.design.analysis.algo.string;

public class BinaryStringImpl implements IBinaryString {

	/** 1. Count of operations to make a binary string ”ab” free, ex- ab->bba **/
	public int countFreeAdjecentBinary(String str, String binary, String replacement) {
		int count = 0;
		while (str.contains(binary)) {
			str = str.replaceFirst(binary, replacement);
			count++;
		}
		return count;
	}

	/** 2. Change if all bits can be made same by single flip **/
	public boolean canMakeAllSame(String str) {
		int zero = 0;
		int one = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '0')
				zero++;
			else
				one++;
		}
		return one == 1 || zero == 1;
	}

	/** 3. Length of Longest sub-string that can be removed **/
	public String longestStringRemove(String str, String key) {
		// TODO for any key
		return null;
	}

	/** 4. Number of flips to make binary string alternate **/
	public int minFlipMakeAlternative(String str) {
		int len = str.length();
		if (len < 2)
			return 0;

		int minCount = 0;
		for (int i = 0; i + 1 < len; i += 2) {
			if (str.charAt(i) == str.charAt(i + 1))
				minCount++;
		}
		return minCount;
	}

	/** 5. 1’s and 2’s complement of a Binary Number **/
	public String onceComplement(String str) {
		char[] charArr = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			if (charArr[i] == '0')
				charArr[i] = '1';
			if (charArr[i] == '1')
				charArr[i] = '0';
		}
		return charArr.toString();
	}

	public String twondComplement(String str) {
		// TODO
		return null;
	}
}
