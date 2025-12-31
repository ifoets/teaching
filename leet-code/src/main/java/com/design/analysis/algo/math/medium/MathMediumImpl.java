package com.design.analysis.algo.math.medium;

public class MathMediumImpl implements IMathMedium{

    /**7. Reverse Integer**/
    @Override
    public int reverse(int x){
        int result = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 ||
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }

            if (result < Integer.MIN_VALUE / 10 ||
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }

            result = result * 10 + digit;
        }

        return result;
    }

    /**29. Divide Two Integers, Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.**/
    @Override
    public int divide(int dividend, int divisor){
       return -1;
    }
}
