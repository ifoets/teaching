package com.design.analysis.algo.backtracking.medium;

import com.design.analysis.ds.binary.tree.easy.BinaryTreeEasyImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IBacktrackingMediumTest {

    IBacktrackingMedium ibm;

    @Before
    public void init()
    {
        ibm = new BacktrackingMediumImpl();
    }

    /**17. Letter Combinations of a Phone Number**/
    @Test
    public void letterCombinationsTest()
    {
        List<String> expList =List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        String phoneStr="23";
        List<String> resultList = ibm.letterCombinations(phoneStr);
        Assert.assertEquals(expList,resultList);
    }

    /**22. Generate Parentheses**/
    @Test
    public void generateValidParenthesisTest(){
        List<String> expList =List.of("()()()", "(()())", "()(())", "((()))", "(())()");
        List<String> resultList = ibm.generateValidParenthesis(3);
        Assert.assertEquals(expList,resultList);
    }
    /**39. Combination Sum**/
    @Test
    public void combinationSumTest()
    {
        int[]a = {2,3,6,7};
        List<List<Integer>> expList = List.of(List.of(2,2,3),List.of(7));
        List<List<Integer>> resultList = ibm.combinationSum(a,7);
        for(int i=0;i<resultList.size();i++)
            Assert.assertEquals(expList.get(i),resultList.get(i));

        int[]b = {2,3,5};
        List<List<Integer>> expList1 = List.of(List.of(2,2,2,2),List.of(2,3,3),List.of(3,5));
        List<List<Integer>> resultList1 = ibm.combinationSum(b,8);
        for(int i=0;i<resultList1.size();i++)
            Assert.assertEquals(expList1.get(i),resultList1.get(i));

    }

    /**40. Combination Sum II**/
    @Test
    public void combinationSum2Test()
    {
        int[]a ={10,1,2,7,6,1,5};
        List<List<Integer>> expResult = List.of(List.of(1,2,5),List.of(1,7),List.of(1,1,6),List.of(2,6));
        List<List<Integer>> resultList = ibm.combinationSum2(a,8);
        for(int i=0;i<resultList.size();i++) {
            System.out.println(resultList.get(i));
            Assert.assertEquals(expResult.get(i), resultList.get(i));
        }
    }
    @Test
    public void combinationSum2RecTest()
    {
        int[]a ={10,1,2,7,6,1,5};
        List<List<Integer>> resultList = ibm.combinationSum2Rec(a,8);
        List<List<Integer>> expResult = List.of(List.of(1,1,6),List.of(1,2,5),List.of(1,7),List.of(2,6));
        for(int i=0;i<resultList.size();i++) {
            System.out.println(resultList.get(i));
            //Assert.assertEquals(expResult.get(i), resultList.get(i));
        }
    }
    /**46. Permutations*/
    @Test
    public void permuteTest()
    {
        List<List<Integer>> expResult = List.of(List.of(1, 2, 3),List.of(1, 3, 2),List.of(2, 1, 3),List.of(2, 3, 1),List.of(3, 2, 1),List.of(3, 1, 2));
        List<List<Integer>> resultList = ibm.permute(new int[]{1,2,3});
        for(int i=0;i<resultList.size();i++) {
            System.out.println(resultList.get(i));
            Assert.assertEquals(expResult.get(i), resultList.get(i));
        }
    }
    @Test
    public void permuteXTest()
    {
        List<List<Integer>> expResult = List.of(List.of(1, 2, 3),List.of(1, 3, 2),List.of(2, 1, 3),List.of(2, 3, 1),List.of(3, 1, 2),List.of(3, 2, 1));
        List<List<Integer>> resultList = ibm.permuteX(new int[]{1,2,3});
        for(int i=0;i<resultList.size();i++) {
            System.out.println(resultList.get(i));
            Assert.assertEquals(expResult.get(i), resultList.get(i));
        }
    }
    /**47. Permutations II**/
    @Test
    public void permuteUniqueTest()
    {
        List<List<Integer>> expResult = List.of(List.of(1, 1, 2),List.of(2, 1, 1),List.of(1, 2, 1));
        List<List<Integer>> resultList = ibm.permuteUnique(new int[]{1,1,2});
        for(int i=0;i<resultList.size();i++) {
            System.out.println(resultList.get(i));
            Assert.assertEquals(expResult.get(i), resultList.get(i));
        }
    }
}
