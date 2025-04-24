package com.design.analysis.core.algo.array;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * Matrix :
1.	Turn an image by 90 degree
2.	Rotate Matrix Elements
3.	Inplace rotate square matrix by 90 degrees | Set 1
4.	Rotate a matrix by 90 degree without using any extra space | Set 2
5.	Rotate each ring of matrix anticlockwise by K elements
6.	Check if all rows of a matrix are circular rotations of each other
7.	Magic Square
8.	Find the row with maximum number of 1s
9.	Find the number of islands
10.	Magic Square | Even Order
11.	Find median in row wise sorted matrix
12.	Number of cells a queen can move with obstacles on the chessborad
13.	Matrix Multiplication | Recursive
14.	Program to print Lower triangular and Upper triangular matrix of an array
15.	Find distinct elements common to all rows of a matrix

 */
public class IArrayMatrixTest {

    public IArrayMatrix iam = null;

    @Before
    public void init() {

        iam = new ArrayMatrixImpl();
    }

    /** 1. Turn an image by 90 degree **/
    @Test
    public void rotateImageBy90Test() {

        int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        a = iam.rotateImageBy90DegreeClock(a);
        Assert.assertEquals(a[0][0] , 10);
        Assert.assertEquals(a[0][1] , 7);
        Assert.assertEquals(a[0][2] , 4);
        Assert.assertEquals(a[0][3] , 1);
        Assert.assertEquals(a[1][3] , 2);
        Assert.assertEquals(a[2][3] , 3);

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        b = iam.rotateImageBy90DegreeClock(b);

        /*
         * for (int i = 0; i < b.length; i++) {
         * System.out.println(Arrays.toString(b[i])); }
         */
        Assert.assertEquals(b[0][0] , 13);
        Assert.assertEquals(b[0][1] , 9);
        Assert.assertEquals(b[0][2] , 5);
        Assert.assertEquals(b[0][3] , 1);
        Assert.assertEquals(b[1][3] , 2);
        Assert.assertEquals(b[2][3] , 3);

    }

    @Test
    public void rotateImageBy90DegreeClockXTest() {
        int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        a = iam.rotateImageBy90DegreeClockX(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    @Test
    public void rotateElementClockTest() {
        int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println("\nrotate element clockwise start");
        for (int i = 0; i <
            a.length; i++) { System.out.println(Arrays.toString(a[i])); }


        /* System.out.println("after rotation"); */
        iam.rotateElementClock(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }

        System.out.println("nrotate element clockwise end");

        Assert.assertEquals(a[0][0] , 4);
        Assert.assertEquals(a[0][1] , 1);
        Assert.assertEquals(a[0][2] , 2);
        Assert.assertEquals(a[1][0] , 7);
        Assert.assertEquals(a[1][1] , 5);
        Assert.assertEquals(a[2][1] , 9);
    }

    /** 3. rotate square matrix by 90 degrees n*n matrix without extra space **/
    @Test
    public void rotateImageBy90DegreeAntiClockTest() {

        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.rotateImageBy90DegreeAntiClock(b);

        /*
         * for (int i = 0; i < b.length; i++) {
         * System.out.println(Arrays.toString(b[i])); }
         */

        Assert.assertEquals(b[0][0] , 4);
        Assert.assertEquals(b[0][1] , 8);
        Assert.assertEquals(b[0][2] , 12);
        Assert.assertEquals(b[0][3] , 16);
        Assert.assertEquals(b[1][3] , 15);
        Assert.assertEquals(b[2][3] , 14);
    }

    @Test
    public void rotateElementClockXTest() {
        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.rotateElementClockX(b);

        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }

    }

    @Test
    public void rotateElementAntiClockTest() {
        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.rotateElementAntiClock(b);

        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    /** 4. Rotate a Matrix by 180 degree **/
    @Test
    public void rorateMatrix180Test() {
        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        // int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.rorateMatrix180(b);

        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    /**
     * * 4. Rotate a matrix by 90 degree without using any extra space
     **/
    @Test
    public void rotateMatixBy90AntiColckTest() {

        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        // int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.rotateImageBy90DegreeAntiClock(b);

        // for (int i = 0; i < b.length; i++) {
        // System.out.println(Arrays.toString(b[i])); }

        Assert.assertEquals(b[0][0] , 4);
        Assert.assertEquals(b[0][1] , 8);
        Assert.assertEquals(b[0][2] , 12);
        Assert.assertEquals(b[0][3] , 16);
        Assert.assertEquals(b[1][3] , 15);
        Assert.assertEquals(b[2][3] , 14);
    }

    /** 5. Rotate each ring of matrix anti clockwise by K elements **/
    @Test
    public void rotateRingKelemAntiClockTest() {
        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.rotateRingKelemAntiClock(b, 3);

        /*
         * System.out.println("Kelement rotation start"); for(int i=0;i<b.length;i++) {
         * System.out.println(Arrays.toString(b[i])); }
         * System.out.println("Kelement rotation end");
         */

        Assert.assertEquals(b[0][0] , 4);
        Assert.assertEquals(b[0][1] , 8);
        Assert.assertEquals(b[0][2] , 12);
        Assert.assertEquals(b[0][3] , 16);
        Assert.assertEquals(b[1][3] , 15);
        Assert.assertEquals(b[2][3] , 14);
    }

    /** 6. Turn an image by 90 degree **/
    @Test
    public void turnImageBy90DegreeTest() {
        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.turnImageBy90Degree(b);

        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    @Test
    public void turnImageBy90DegreeAntyClockWiseTest() {
        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.turnImageBy90DegreeAntyClockWise(b);

        for (int i = 0; i < b.length; i++) {
            System.out.println(Arrays.toString(b[i]));
        }
    }

    /** 7. Check if all rows of a matrix are circular rotations of each other **/
    @Test
    public void isAllColumnsCiucularRotatedTest() {
        int a[][] = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };
        Assert.assertTrue(iam.isAllColumnsCiucularRotated(a));
    }

    /** 8. Sort the given matrix **/
    @Test
    public void strictSotMatrixTest() {
        int mat[][] = { { 5, 4, 7 }, { 1, 3, 8 }, { 2, 9, 6 } };
        iam.strictSotMatrix(mat);
        for (int i = 0; i < mat.length; i++) {
            System.out.println(Arrays.toString(mat[i]));
        }
    }

    /** 9. Find the row with maximum number of 1s where each row is sorted **/
    // @Idea
    @Test
    public void rowMaxNumbOf1s() {
        int mat[][] = { { 0, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
        Assert.assertEquals(iam.rowMaxNumbOf1s(mat) , 2);
    }

    /** 10. Find median in row wise sorted matrix **/
    @Test
    public void binaryMedianTest() {
        int r = 3, c = 3;
        int m[][] = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
        Assert.assertEquals(iam.binaryMedian(m,r,c) , 5);
    }

    /** 11. Matrix Multiplication | Recursive **/
    /** 12. Program to multiply two matrices **/
    /** 13. Program for scalar multiplication of a matrix **/
    /**
     * 14. Program to print Lower triangular and Upper triangular matrix of an array
     **/
    /** 15. Find distinct elements common to all rows of a matrix **/
    /** 16. Print a given matrix in spiral form clockwise **/
    @Test
    public void spiralPrintMatrixTest() {
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.spiralPrintMatrix(b);
    }

    @Test
    public void spiralPrintMatrixAnticlockwiseTest() {
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        iam.spiralPrintMatrixAnticlockwise(b);
    }
    /** 11. Matrix Multiplication | Recursive **/
    @Test
    public void multiplyMatrixRecTest()
    {
        int a[][] = { {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};

        int b[][] = { {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9} };
        int d[][] = { {30, 36, 42,},
            {66, 81, 96},
            {102, 126, 150} };
        int c[][] = iam.multiplyMatrixRec(a, a.length, a[0].length,b, b.length, b[0].length);
        for(int i=0; i< d.length ;i++)
        {
            for(int j=0; j < d[0].length; j++)
                Assert.assertEquals(c[i][j],d[i][j]);
        }
    }
    /** 12. Program to multiply two matrices **/
    @Test
   public void matrixMultiplicationTest()
    {
        int [][]a={
            {1,1},
            {2,2},
            {3,3}
        };
        int [][]b ={
            {1,2,3},
            {1,2,3}
        };
        int [][]d={
            {2, 4, 6},
            {4, 8, 12},
            {6, 12, 18}
        };
        int [][]c=iam.matrixMultiplication(a,b);
        for(int []e:c)
            System.out.println(Arrays.toString(e));
        for(int i=0;i<c.length;i++)
            for(int j=0;j<c[0].length;j++)
                Assert.assertEquals(d[i][j],c[i][j]);
    }
    /** 13. Program for scalar multiplication of a matrix
     *  @Note just iterate and multiplying every element with given value k**/
    /**
     * 14. Program to print Lower triangular and Upper triangular matrix of an array
     **/
    @Test
    public void lowerTriangleTest()
    {
        int [][]a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        iam.lowerTriangle(a);
        for(int []e:a)
            System.out.println(Arrays.toString(e));
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                if(i<j) {
                    Assert.assertEquals(0, a[i][j]);
                }
    }
    @Test
    public void upperTriangleTest()
    {
        int [][]a = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        iam.upperTriangle(a);
        for(int []e:a)
            System.out.println(Arrays.toString(e));
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                if(i>j)
                    Assert.assertEquals(0,a[i][j]);
    }

    /** 15. Find distinct elements common to all rows of a matrix **/
    @Test
    public void distinctCommonToAllRowsTest(){
        int [][]a = {
            {2, 1, 4, 3},
            {1, 2, 3, 2},
            {3, 6, 2, 3},
            {5, 2, 5, 3}
        };
       // Output : 2 3
    System.out.println(iam.distinctCommonToAllRows(a));
    Assert.assertEquals(2,iam.distinctCommonToAllRows(a).size());
        int [][]b = {
            {12, 1, 14, 3, 16},
            {14, 2, 1, 3, 35},
            {14, 1, 14, 3, 11},
            {14, 25, 3, 2, 1},
            {1, 18, 3, 21, 14}
        };
       // Output : 1 3 14
        System.out.println(iam.distinctCommonToAllRows(b));
        Assert.assertEquals(3,iam.distinctCommonToAllRows(b).size());

    }
    @Test
    public void distinctCommonToAllRowsAndColsTest()
    {
        int [][]a = {
            {2, 1, 4, 3},
            {1, 2, 3, 2},
            {3, 6, 2, 3},
            {5, 2, 5, 3}
        };
        // Output : 2
        System.out.println(iam.distinctCommonToAllRowsAndCols(a));
        Assert.assertEquals(2,iam.distinctCommonToAllRowsAndCols(a).get(0).intValue());
        int [][]b = {
            {12, 1, 14, 3, 16},
            {14, 14, 1, 3, 35},
            {14, 1, 14, 14, 11},
            {14, 25, 3, 2, 1},
            {1, 18, 3, 21, 14}
        };
        // Output : 14
        System.out.println(iam.distinctCommonToAllRowsAndCols(b));
       Assert.assertEquals(1,iam.distinctCommonToAllRowsAndCols(b).size());
    }

    /***********************************************************************************************************************************************************************/
    /** transpose the matrix **/
    @Test
    public void transposeOfMatrixTest() {

        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        /*
         * System.out.println("tanspose of matrix"); for (int i = 0; i < b.length; i++)
         * { System.out.println(Arrays.toString(b[i])); }
         */
        iam.transposeOfMatrix(b);

        /*
         * System.out.println("tanspose of matrix"); for (int i = 0; i < b.length; i++)
         * { System.out.println(Arrays.toString(b[i])); }
         */

        Assert.assertEquals(b[0][0] , 1);
        Assert.assertEquals(b[0][1] , 5);
        Assert.assertEquals(b[0][2] , 9);
        Assert.assertEquals(b[0][3] , 13);

    }

    /** Reverse column **/
    @Test
    public void reverseColumnsTest() {

        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        /*
         * System.out.println("reverse of column"); for (int i = 0; i < b.length; i++) {
         * System.out.println(Arrays.toString(b[i])); }
         */
        iam.reverseColumns(b);

        /*
         * System.out.println("reverse of column"); for (int i = 0; i < b.length; i++) {
         * System.out.println(Arrays.toString(b[i])); }
         */

        Assert.assertEquals(b[0][0] , 13);
        Assert.assertEquals(b[0][1] , 14);
        Assert.assertEquals(b[0][2] , 15);
        Assert.assertEquals(b[0][3] , 16);

    }

    /** Spiral traverse **/
    @Test
    public void spiralTraverseTest() {
        /* int b[][] = { { 1, 2}, { 3, 4} }; */
        /* int b[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }; */
        int b[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int a[] = new int[b.length * b[0].length];
        a = iam.spiralTraverse(b);

        /* System.out.println(Arrays.toString(a)); */

        Assert.assertEquals(a[1] , 2);
        Assert.assertEquals(a[5] , 12);
        Assert.assertEquals(a[10] , 9);
        Assert.assertEquals(a[15] , 10);
    }

    /** Function to reverse arr[] from index start to end **/
    @Test
    public void rvereseArrayTest() {
        int temp[] = { 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5 };

        iam.reverseArray(temp, 0, 3 - 1);
        iam.reverseArray(temp, 3, temp.length - 1);
        iam.reverseArray(temp, 0, temp.length - 1);

        // System.out.println(Arrays.toString(temp));

    }
}
