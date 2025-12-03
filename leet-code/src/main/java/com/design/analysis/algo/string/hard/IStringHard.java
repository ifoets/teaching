package com.design.analysis.algo.string.hard;

public interface IStringHard {

    /**10. Regular Expression Matching*
     * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
     *
     * '.' Matches any single character.​​​​
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     */
    boolean isMatch(String s, String p);

    boolean isMatchDp(String s, String p);
}
