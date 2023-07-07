package com.design.analysis.core.algo.matheticalalgorithms;

public class NumberDigitImpl implements INumberDigit {

	/** 1. n-th number whose sum of digits is ten **/
	@Override
	public int nthNoWhoseSumIs10(int n) {
		int count = 0;
		int i = 19; // first no whouse sum is 10;
		for (;; i++) {
			if (sumOfDigit(i) == 10) {
				count++;
				if (count == n)
					break;
			}
		}
		return i;

	}

	public int sumOfDigit(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}

	/** 2. Minimum digits to remove to make a number Perfect Square **/
	@Override
	public int minDigitsToMakePerectSquare(int n) {
		return 0;
	}
}
