package com.design.analysis.algo.string.easy;

public class StringEasyImpl implements IStringEasy {

    /**
     * 13. Roman to Integer
     */
    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        int num = 0;
        for (int i = 0; i < symbols.length && !s.isEmpty(); i++) {
            while (s.startsWith(symbols[i])) {
                num += values[i];
                s = s.replaceFirst(symbols[i], "");
            }
        }
        return num;
    }

    @Override
    public int romanToIntX(String s) {
        int sum = 0, prev = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = value(s.charAt(i));
            if (cur < prev)
                sum -= cur;
            else sum += cur;
            prev = cur;
        }
        return sum;
    }

    private int value(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
