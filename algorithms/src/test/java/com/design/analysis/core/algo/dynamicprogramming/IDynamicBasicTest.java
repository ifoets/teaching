package com.design.analysis.core.algo.dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.design.analysis.core.algo.dynamicprogramming.model.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 *
 * @author GuruG
 */
public class IDynamicBasicTest {

    public IDynamicBasic idb = null;

    @Before
    public void init() {
        idb = new DynamicBasicImpl();
    }

    /** 1. Ugly numbers **/
    /* This function divides a by greatest divisible power of b */
    @Test
    public void maxDivideTest() {

        Assert.assertEquals(1, idb.maxDivide(16, 2));
        Assert.assertEquals(1,idb.maxDivide(125, 5));
        Assert.assertEquals(1,idb.maxDivide(27, 3));
        Assert.assertEquals(9,idb.maxDivide(18, 2));
        Assert.assertEquals(12,idb.maxDivide(12, 5));
        Assert.assertEquals(8, idb.maxDivide(8, 3));
    }

    /* check the no is ugly or not */
    @Test
    public void isUglyTest() {
        Assert.assertTrue(idb.isUgly(15));
        Assert.assertFalse(idb.isUgly(31));
        Assert.assertTrue(idb.isUgly(1500));
        Assert.assertFalse(idb.isUgly(151));
        Assert.assertFalse(idb.isUgly(1511));
        Assert.assertFalse(idb.isUgly(99));
    }

    /* get nth ugly no */
    @Test
    public void nthUgalyNumberTest() {
        Assert.assertEquals(idb.nthUgalyNumber(7) , 8);
        Assert.assertEquals(idb.nthUgalyNumber(10) , 12);
        Assert.assertEquals(idb.nthUgalyNumber(15) , 24);
    }

    /** 2. Fibonacci numbers **/
    /* by using dynamic programming */
    @Test
    public void nthFibNoDynamicTest() {

        Assert.assertEquals(idb.nthFibNoDynamic(9) , 34);
    }

    /* by recursive way */
    @Test
    public void nthFibNoRecursiveTest() {
        Assert.assertEquals(idb.nthFibNoRecursive(9) , 34);
    }

    /* by using minimum space */
    @Test
    public void nthFibNoMinSpaceUseTest() {
        Assert.assertEquals(idb.nthFibNoMinSpaceUse(9) , 34);
    }

    /** 3. nth Catalan Number **/
    @Test
    public void catalanTest() {

        int a[] = { 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862 };
        for (int i = 0; i < 10; i++)
            Assert.assertEquals(idb.catalan(i) , a[i]);
    }

    /* using dp */
    @Test
    public void catalanDPTest() {
        int a[] = { 1, 2, 5, 14, 42, 132, 429, 1430, 4862 };
        for (int i = 1; i < 10; i++)
            Assert.assertEquals(idb.catalanDP(i) , a[i - 1]);
    }

    /* Using Binomial Coefficient */
    @Test
    public void catalanByBinomicalCoeffTest() {
        int a[] = { 1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862 };
        for (int i = 0; i < 10; i++)
            Assert.assertEquals(idb.catalanByBinomicalCoeff(i) , a[i]);
    }

    /** 4. Bell Numbers (Number of ways to Partition a Set) **/
    @Test
    public void bellNumberTest() {

        // idb.bellNumber(3);
        /*
         * int bn[] = { 1, 1, 2, 5, 15, 52 }; for (int i = 0; i < bn.length; i++)
         * Assert.assertEquals(idb.bellNumber(i) , bn[i]);
         */
        Assert.assertEquals(idb.bellNumber(2) , 2);
        Assert.assertEquals(idb.bellNumber(4) , 15);
        Assert.assertEquals(idb.bellNumber(6) , 203);
    }

    /** 5. Binomial Coefficient **/
    @Test
    public void binomialCoeffTest() {
        Assert.assertEquals(idb.binomialCoeff(4, 2) , 6);
        Assert.assertEquals(idb.binomialCoeff(5, 2) , 10);

    }

    @Test
    public void binomialCoeffDpTest() {
        Assert.assertEquals(idb.binomialCoeffDp(4, 2) , 6);
        Assert.assertEquals(idb.binomialCoeffDp(5, 2) , 10);
    }

    @Test
    public void binomialCoeffDpXTest() {
        Assert.assertEquals(idb.binomialCoeffDpX(4, 2) , 6);
        Assert.assertEquals(idb.binomialCoeffDpX(5, 2) , 10);
    }

    /** 6.Permutation Coefficient **/
    @Test
    public void permutationCoefficientTest() {
        Assert.assertEquals(idb.permutationCoefficient(10, 2) , 90);
    }

    @Test
    public void permutationCoefficientXTest() {
        Assert.assertEquals(idb.permutationCoefficientX(10, 2) , 90);
    }

    /** 7. Tiling Problem **/ // bord 2*n and tiles 2*1
    @Test
    public void tillingProblemTest() {
        Assert.assertEquals(idb.tillingProblem(4) , 5);
        Assert.assertEquals(idb.tillingProblem(5) , 8);
    }

    /* Tiling Problem 1*m to n*m borad **/
    @Test
    public void tillingProblemXTest() {
        Assert.assertEquals(idb.tillingProblemX(4, 2) , 5);
        Assert.assertEquals(idb.tillingProblemX(5, 2) , 8);
    }

    /** 8. Gold Mine Problem **/
    @Test
    public void goldMineProblemTest() {

        int mat[][] = { { 1, 3, 3 }, { 2, 1, 4 }, { 0, 6, 4 } };

        idb.goldMineProblem(mat);
        /*
         * int mat1[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2
         * } }; idb.goldMineProblem(mat1); Assert.assertEquals(idb.goldMineProblem(mat1)
         * , 16);
         *
         * int mat2[][] = { { 1, 3, 1, 5 }, { 2, 2, 4, 1 }, { 5, 0, 2, 3 }, { 0, 6, 1, 2
         * } }; Assert.assertEquals(idb.goldMineProblem(mat2) , 16);
         *
         * int mat3[][] = { { 10, 33, 13, 15 }, { 22, 21, 04, 1 }, { 5, 0, 2, 3 }, { 0,
         * 6, 14, 2 } }; Assert.assertEquals(idb.goldMineProblem(mat3) , 83);
         */
    }

    /** 9. Min Cost Path **/
    /* by recursive way */
    @Test
    public void minCostPathRecursiveTest() {
        int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
        Assert.assertEquals(idb.minCostPathRecursive(cost, cost.length - 1, cost[0].length - 1) , 8);
    }

    /** 10. Friends Pairing Problem **/
    @Test
    public void countFriendsPairingsTest() {
        Assert.assertEquals(idb.countFriendsPairings(4) , 10);
    }

    /** 11. Subset Sum Problem **/
    @Test
    public void isSubsetSumRcvTest() {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        Assert.assertTrue(idb.isSubsetSumRcv(set, set.length, 9));
    }

    @Test
    public void isSubsetSumDpTest() {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        Assert.assertTrue(idb.isSubsetSumDp(set, set.length, 9));
    }

    /** 12. Subset Sum Problem in O(sum) space **/
    @Test
    public void isSubsetSumTest() {
        int set[] = { 1, 10, 4, 12, 5, 2 };
        int rs[] = { 9, 17, 1, 6, 8 };
        for (int i = 0; i < rs.length; i++)
            Assert.assertTrue(idb.isSubsetSum(set, set.length, rs[i]));
    }

    /** 13. Subset with sum divisible by m **/
    @Test
    public void modularSumTest() {
        int a[] = { 3, 1, 7, 5 };
        Assert.assertTrue(idb.modularSum(a, a.length, 6));

        int b[] = { 1, 6 };
        Assert.assertFalse(idb.modularSum(a, b.length, 5));
    }

    /** 14. Largest divisible pairs subset **/
    @Test
    public void largestDivisiblePairSubsetDpTest() {
        int a[] = { 10, 5, 3, 15, 20 };
        Assert.assertEquals(idb.largestDivisiblePairSubsetDp(a) , 3);
        int b[] = { 18, 1, 3, 6, 13, 17 };
        Assert.assertEquals(idb.largestDivisiblePairSubsetDp(b) , 4);
    }

    @Test
    public void largestDivisiblePairSubsetTest() {
        int a[] = { 10, 5, 3, 15, 20 };
        Assert.assertEquals(idb.largestDivisiblePairSubset(a) , 3);
        int b[] = { 18, 1, 3, 6, 13, 17 };
        Assert.assertEquals(idb.largestDivisiblePairSubset(b) , 4);
    }

    /** 15. Perfect Sum Problem (Print all subsets with given sum) **/
    @Test
    public void subsetsOfGivenSumTest() {
        // TODO
    }

    @Test
    public void nCrModpTest() {
        int n = 10, r = 2, p = 13;
        Assert.assertEquals(idb.nCrModp(n, r, p) , 6);
    }

    /** 17. Choice of area **/
    // TODDO
    /** 18. Cutting a Rod **/
    @Test
    public void cutRodRcvTest() {
        int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        Assert.assertEquals(idb.cutRodRcv(arr, arr.length) , 22);
    }

    @Test
    public void cutRoDpTest() {
        int arr[] = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        Assert.assertEquals(idb.cutRoDp(arr, arr.length) , 22);
    }

    /** 19. Tiling with Dominoes **/
    @Test
    public void tillingDominoesTest() {

        Assert.assertEquals(idb.tillingDominoes(8) , 153);
    }

    /** 20. Painting Fence Algorithm **/
    @Test
    public void paintingFenceTest() {
        Assert.assertEquals(idb.paintingFence(3, 2) , 6);
    }

    @Test
    public void paintingFenceXTest() {
        Assert.assertEquals(idb.paintingFenceX(3, 2) , 6);
    }

    /** 21. Newman�Shanks�Williams prime **/
    @Test
    public void newmanShanksWilliamsPrimeTest() {
        Assert.assertEquals(idb.newmanShanksWilliamsPrime(3) , 7);
    }

    @Test
    public void newmanShanksWilliamsPrimeDpTest() {
        Assert.assertEquals(idb.newmanShanksWilliamsPrimeDp(3) , 7);
    }

    /** 22. Assembly line scheduling **/
    @Test
    public void carAssemblyTest() {
        int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
        int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };
        int e[] = { 10, 12 }, x[] = { 18, 7 };

        Assert.assertEquals(idb.carAssembly(a, t, e, x) , 35);
    }

    /** 23. Golomb sequence **/
    @Test
    public void printGolombTest() {
        List<Integer> rl = idb.printGolomb(10);
        System.out.println(Arrays.asList(rl));
    }

    /** 24. Moser-de Bruijn Sequence **/
    @Test
    public void moserDeBruijnSequenceTest() {
        System.out.println(Arrays.toString(idb.moserDeBruijnSequence(15)));
    }

    /** 25. Newman-Conway Sequence **/
    @Test
    public void newmanConwaySequenceTest() {
        Assert.assertEquals(idb.newmanConwaySequence(10) , 6);
    }

    @Test
    public void newmanConwaySequenceDpTest() {
        Assert.assertEquals(idb.newmanConwaySequenceDp(10) , 6);
    }

    /** 26. Find maximum length Snake sequence **/
    @Test
    public void maxLenSnakeSequenceTest() {
        int mat[][] = { { 9, 6, 5, 2 }, { 8, 7, 6, 5 }, { 7, 3, 1, 6 }, { 1, 1, 1, 7 }, };

        List<Integer> list = idb.maxLenSnakeSequence(mat);
        Assert.assertEquals(list.size() , 7);
        System.out.println(idb.maxLenSnakeSequence(mat));
    }

    /** 27. Print n terms of Newman-Conway Sequence **/
    // @See 25.
    /** 28. Print Fibonacci sequence using 2 variables **/
    @Test
    public void fibTest() {
        idb.fib(10);
    }

    /** 29. Print Fibonacci Series in reverse order **/
    @Test
    public void reverseFibonacciTest() {
        idb.reverseFibonacci(10);
    }

    /**
     * 30. Count even length binary sequences with same sum of first and second half
     * bits
     **/
    @Test
    public void countSeqTest() {
        Assert.assertEquals(idb.countSeq(2, 0) , 6);
    }

    @Test
    public void countSeqDpTest() {
        Assert.assertEquals(idb.countSeqDp(2, 0) , 6);
    }

    @Test
    public void countSeqRecTest() {
        Assert.assertEquals(idb.countSeqRec(2) , 6);
    }

    /**
     * 31. Sequences of given length where every element is more than or equal to
     * twice of previous
     **/
    @Test
    public void getTotalNumberOfSequencesTest() {
        Assert.assertEquals(idb.getTotalNumberOfSequences(10, 4) , 4);
    }

    /* using dp */
    @Test
    public void getTotalNumberOfSequencesDpTest() {
        Assert.assertEquals(idb.getTotalNumberOfSequencesDp(10, 4) , 4);
    }

    /** 32. Longest Common Subsequence **/
    /* using recursive way */
    @Test
    public void longestCommonSubsequenceRecvTest() {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        Assert.assertEquals(idb.longestCommonSubsequenceRecv(str1, str2, str1.length(), str2.length()) , 4);
    }

    /* using dynaic programming */
    @Test
    public void longestCommonSubsequenceDynamicTest() {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        Assert.assertEquals(idb.longestCommonSubsequenceDynamic(str1.toCharArray(), str2.toCharArray(), str1.length(),
            str2.length()) , 4);
    }

    /** 33. Longest Repeated Subsequence */
    @Test
    public void longestRepeatedSubsequenceDynamicTest() {
        String str = "AABEBCDD";
        Assert.assertEquals(idb.longestRepeatedSubsequenceDynamic(str),"ABD");
    }

    /** 34. Longest Increasing Subsequence **/
    /* by iterative way */
    @Test
    public void longestIncreasingSubsequenceItrTest() {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        List<Integer> list = idb.longestIncreasingSubsequenceItr(arr, arr.length);
        // System.out.println(Arrays.toString(list.toArray()));
        Assert.assertEquals(list.size() , 5);
    }

    /* by dynamic programming */
    @Test
    public void longestIncreasingSubsequenceDynamicTest() {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        Assert.assertEquals(idb.longestIncreasingSubsequenceDynamic(arr, arr.length) , 5);
    }

    /** 35. A Space Optimized Solution of LCS **/
    @Test
    public void spaceOptimizedLongestCommonSubsequenceTest() {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        Assert.assertEquals(idb.spaceOptimizedLongestCommonSubsequence(str1, str2) , 4);
    }

    /** 36. LCS (Longest Common Subsequence) of three strings **/
    @Test
    public void lcsOf3Test() {
        String X = "AGGT12";
        String Y = "12TXAYB";
        String Z = "12XBA";

        int m = X.length();
        int n = Y.length();
        int o = Z.length();
        Assert.assertEquals(idb.lcsOf3(X, Y, Z, m, n, o) , 2);
    }

    /** 37. Maximum sum Bi-tonic Sub-sequence **/
    @Test
    public void MaxSumBSTest() {
        int arr[] = { 1, 15, 51, 45, 33, 100, 12, 18, 9 };
        Assert.assertEquals(idb.MaxSumBS(arr, arr.length) , 194);
    }

    /** 38. Maximum Sum Increasing Subsequence **/
    @Test
    public void maxSumIncreasingSubseqTest() {
        int arr[] = new int[] { 1, 101, 2, 3, 100, 4, 5 };
        int n = arr.length;
        Assert.assertEquals(idb.maxSumIncreasingSubseq(arr, n) , 106);
    }

    /** 39. Maximum product of an increasing subsequence **/
    @Test
    public void maxProductIncreasingSubseqTest() {
        int[] arr = { 3, 100, 4, 5, 150, 6 };
        int n = arr.length;
        Assert.assertEquals(idb.maxProductIncreasingSubseq(arr, n) , 45000);
    }

    /** 40. Count all subsequences having product less than K **/
    @Test
    public void productSubSeqCountTest() {
        ArrayList<Integer> A = new ArrayList<Integer>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(4);
        int k = 10;
        Assert.assertEquals(idb.productSubSeqCount(A, k) , 11);
    }

    /** 41. Maximum subsequence sum such that no three are consecutive **/
    @Test
    public void maxSumWO3ConsecTest() {
        int arr[] = { 100, 1000, 100, 1000, 1 };
        int n = arr.length;
        Assert.assertEquals(idb.maxSumWO3Consec(arr, n) , 2101);
    }

    /** 42. Longest subsequence such that difference between adjacents is one **/
    @Test
    public void longestSubseqAdjDiffIsOneTest() {
        int a[] = { 10, 9, 4, 5, 4, 8, 6 };
        Assert.assertEquals(idb.longestSubseqAdjDiffIsOne(a) , 3);
        int b[] = { 1, 2, 3, 2, 3, 7, 2, 1 };
        Assert.assertEquals(idb.longestSubseqAdjDiffIsOne(b) , 7);
    }

    /**
     * 43. Maximum length subsequence with difference between adjacent elements as
     * either 0 or 1
     **/
    @Test
    public void longestSubseqAdjDiffIsOneOrZeroTest() {
        int a[] = { 2, 5, 6, 3, 7, 6, 5, 8 };
        Assert.assertEquals(idb.longestSubseqAdjDiffIsOneOrZero(a) , 5);
        int b[] = { -2, -1, 5, -1, 4, 0, 3 };
        Assert.assertEquals(idb.longestSubseqAdjDiffIsOneOrZero(b) , 4);
    }

    /**
     * 44. Maximum sum increasing subsequence from a prefix and a given element
     * after prefix is must
     **/
    @Test
    public void preComputeTest() {
        int a[] = { 1, 101, 2, 3, 100, 4, 5 };
        int n = a.length;
        int index = 4, k = 6;
        Assert.assertEquals(idb.preCompute(a, n, index, k) , 11);
    }

    /** 45. Maximum Length Chain of Pairs **/
    @Test
    public void maxChainLengthTest() {
        Pair arr[] = new Pair[] { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60) };
        Assert.assertEquals(idb.maxChainLength(arr, arr.length) , 3);
    }

    /** 46. Print Maximum Length Chain of Pairs **/
    @Test
    public void printMaxChainLengthTest() {
        Pair a[] = { new Pair(5, 29), new Pair(39, 40), new Pair(15, 28), new Pair(27, 40), new Pair(50, 90) };
        List<Pair> rl = idb.printMaxChainLength(a, a.length);
        for (Pair p : rl)
            System.out.println(p);
    }

    /** 47. Path with maximum average value **/
    @Test
    public void maxAverageValuePathTest() {
        int cost[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(idb.maxAverageValuePath(cost, cost.length));
    }

    /** 48. Maximum games played by winner **/
    @Test
    public void maxGameByWinnerTest() {
        Assert.assertEquals(idb.maxGameByWinner(10) , 4);
    }

    /** 49. Maximum path sum in a triangle **/
    @Test
    public void maxPathSumTest() {
        int tri[][] = { { 3, 0, 0, 0 }, { 7, 4, 0, 0 }, { 2, 4, 6, 0 }, { 8, 5, 9, 3 } };
        Assert.assertEquals(idb.maxPathSum(tri, 3, 3) , 23);
    }

    /** 50. Minimum Sum Path in a Triangle **/
    @Test
    public void minSumPathTest() {
        int A[][] = { { 2 }, { 3, 9 }, { 1, 6, 7 } };
        Assert.assertEquals(idb.minSumPath(A) , 6);

    }

    /**51.	Maximum sum of a path in a Right Number Triangle**/
    @Test
    public void maxSumPathRightNumTringleRecTest()
    {
        int A[][] = { { 2 }, { 3, 9 }, { 1, 6, 7 } };
        Assert.assertEquals(idb.maxSumPathRightNumTringleRec(A,0,0) , 18);
    }
    @Test
    public void maxSumPathRightNumTringleTest(){
        int A[][] = { { 2 }, { 3, 9 }, { 1, 6, 7 } };
        int dp[][]= new int[A.length][A.length];
        for(int i=0;i<dp.length;Arrays.fill(dp[i],-1),i++);
        Assert.assertEquals(idb.maxSumPathRightNumTringle(A,0,0,dp) , 18);
    }

    /*52.	Size of The Subarray With Maximum Sum, max sum continuous array*/
    @Test
    public void maxLexSubArrayOfMaxSumTest()
    {
        int  a[] = {1, -2, 1, 1, -2, 1};
        int b[] = { -2, -3, 4, -1, -2, 1, 5, -3 };

        Assert.assertEquals(idb.maxLexSubArrayOfMaxSum(a) , 2);
        Assert.assertEquals(idb.maxLexSubArrayOfMaxSum(b) , 5);
    }

    /*53.	Maximum sum of pairs with specific difference*/
    @Test
    public void maxSumPairsOnKDiffTest()
    {
        int a[] = {3, 5, 10, 15, 17, 12, 9}, k1 = 4;
        Assert.assertEquals(idb.maxSumPairsOnKDiff(a, k1) , 62);
        int b[] = {5, 15, 10, 300}, k2 = 12;
        Assert.assertEquals(idb.maxSumPairsOnKDiff(b, k2) , 25);

    }

    /*54.	Maximum size square sub-matrix with all 1s*/
    @Test
    public void maxSquareSubMatrixTest()
    {
        int a[][] = { { 0, 1, 1, 0, 1 }, { 1, 1, 0, 1, 0 }, { 0, 1, 1, 1, 0 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 },
            { 0, 0, 0, 0, 0 } };
        a = idb.maxSquareSubMatrix(a);
        Assert.assertEquals(a.length , 3);
        Assert.assertEquals(a[0].length , 3);
        Assert.assertEquals(a[2][2] , 1);
        Assert.assertEquals(a[0][0] , 1);
        Assert.assertEquals(a[1][1] , 1);
    }

    /*55.	Maximum number of segments of lengths a, b and c*/
    @Test
    public void maxNoOfSegmentTest()
    {
        int n = 7, a = 5, b = 2, c = 5;
        Assert.assertEquals(idb.maxNoOfSegment(n,a,b,c),2);
        int  N = 17, a1 = 2, b1 = 1, c1 = 3;
        Assert.assertEquals(idb.maxNoOfSegment(N,a1,b1,c1),17);
    }
    /*********************************************************************************************************************************************************************/

    /** 5. Largest Sum Contiguous Subarray **/
    /* by iterative */
    @Test
    public void LargestSumContiguousSubarrayItrTest() {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        Assert.assertEquals(idb.LargestSumContiguousSubarrayItr(a) , 7);
    }

    /* by dynamic programming */
    @Test
    public void LargestSumContiguousSubarrayDynamicTest() {
        int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        Assert.assertEquals(idb.LargestSumContiguousSubarrayDynamic(a) , 7);
    }

    /* by dynamic programming */
    @Test
    public void minCostPathDynamicTest() {
        int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
        Assert.assertEquals(idb.minCostPathDynamic(cost, cost.length - 1, cost[0].length - 1) , 8);
    }

    /** max suqure sub matrix whouse corner is x **/
    @Test
    public void maxSqureOfXCorenrTest() {

        int mat[][] = { { 1, 2, 4, 4, 5 }, { 4, 4, 4, 4, 1 }, { 1, 2, 3, 4, 5 }, { 4, 4, 1, 4, 5 }, { 4, 2, 3, 4, 5 } };
        System.out.println(idb.maxSqureOfXCorenr(mat, 4));
    }

    /** 9. Coin change problem **/
    /* recursive way */
    @Test
    public void noOfWayCoinChangeRecvTest() {

        int a[] = { 1, 2, 3 };
        int b[] = { 2, 5, 3, 6 };
        Assert.assertEquals(idb.noOfWayCoinChangeRecv(a, a.length, 4) , 4);
        Assert.assertEquals(idb.noOfWayCoinChangeRecv(b, b.length, 10) , 5);
    }

    /* by dynamic programming way */
    @Test
    public void noOfWayCoinChangeDynamicTest() {
        int a[] = { 1, 2, 3 };
        int b[] = { 2, 5, 3, 6 };
        Assert.assertEquals(idb.noOfWayCoinChangeDynamic(a, a.length, 4) , 4);
        Assert.assertEquals(idb.noOfWayCoinChangeDynamic(b, b.length, 10) , 5);
    }

}
