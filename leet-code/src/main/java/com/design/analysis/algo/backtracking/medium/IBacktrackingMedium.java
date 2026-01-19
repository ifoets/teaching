package com.design.analysis.algo.backtracking.medium;

import java.util.List;

public interface IBacktrackingMedium {
    /**17. Letter Combinations of a Phone Number**/
    List<String> letterCombinations(String digits);

    /**22. Generate Parentheses**/
    List<String> generateValidParenthesis(int n);

    /**39. Combination Sum**/
    List<List<Integer>> combinationSum(int[] candidates, int target);

    /**40. Combination Sum II**/
    List<List<Integer>> combinationSum2(int[] candidates, int target);
    List<List<Integer>> combinationSum2Rec(int[] candidates, int target);

    /**46. Permutations*/
    List<List<Integer>> permute(int[] nums);
    List<List<Integer>> permuteX(int[] nums);

    /**47. Permutations II**/
    List<List<Integer>> permuteUnique(int[] nums);
}
