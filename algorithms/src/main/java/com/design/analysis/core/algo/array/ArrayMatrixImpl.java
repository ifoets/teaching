package com.design.analysis.core.algo.array;

import java.util.*;

/*
Matrix :
1.	Turn an image by 90 degree
2.	Rotate Matrix Elements
3.	Inplace rotate square matrix by 90 degrees | Set 1
4.	Rotate a matrix by 90 degree withoust using any extra space | Set 2
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
public class ArrayMatrixImpl implements IArrayMatrix
{

    /** 1. Turn an image by 90 degree **/
    @Override
    public int[][] rotateImageBy90DegreeClock(int [][]a) {

        // analysis for reducing space complexity and time complexity TO(n/2*n)
        // and SO(1)time if m==n
        // TODO it is incomplete code
        boolean TODO = false;
        if (a[0].length == a.length && TODO) {

            int N = a.length;
            for (int x = 0; x < N / 2; x++) {
                for (int y = x; y < N - 1 - x; y++) {

                    // store current cell in temp variable
                    int temp = a[x][y];

                    // move values from bottom to top
                    a[x][y] = a[N - y - 1][x];

                    // move values from bottom to left
                    a[N - y - 1][x] = a[N - 1 - x][N - 1 - y];

                    // move values from right to bottom
                    a[N - 1 - x][N - 1 - y] = a[y][N - x - 1];

                    // assign temp to right
                    a[y][N - x - 1] = temp;
                }

            }
            return a;
        }
        // TO and SO both (m*n)
        else {
            int [][]b = new int[a[0].length][a.length];
            int k, l;
            k = 0;
            for (int i = 0; i < a[0].length; i++) {
                l = 0;
                for (int j = a.length - 1; j >= 0; j--) {
                    b[k][l++] = a[j][i];
                }
                k++;
            }
            return b;
        }
    }

    //making circular rotation layer by layer
    public int[][] rotateImageBy90DegreeClockX(int [][]a) {

        int N = a.length;

        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                int temp = a[i][j];
                a[i][j] = a[N - 1 - j][i];
                a[N - 1 - j][i] = a[N - 1 - i][N - 1 - j];
                a[N - 1 - i][N - 1 - j] = a[j][N - 1 - i];
                a[j][N - 1 - i] = temp;
            }
        }
        return a;
    }

    /** 2. Rotate Matrix Elements **/
    @Override
    public void rotateElementClock(int [][]a) {
        int m = a.length;
        int n = a[0].length;
        int cur, prev;
        int row, col;
        row = 0;
        col = 0;

        while (row < m && col < n) {

            if (row + 1 == m || col + 1 == n)
                break;
            /* Move elements of top row. */
            prev = a[row + 1][col];

            for (int j = col; j < n; j++) {
                cur = a[row][j];
                a[row][j] = prev;
                prev = cur;
            }
            row++;

            /* Move elements of last column */
            for (int i = row; i < m; i++) {
                cur = a[i][n - 1];
                a[i][n - 1] = prev;
                prev = cur;
            }
            n--;
            /* Move elements of bottom row */
            if (row < m) {

                for (int j = n - 1; j >= col; j--) {
                    cur = a[m - 1][j];
                    a[m - 1][j] = prev;
                    prev = cur;
                }
            }
            m--;

            /* Move elements of first column. */
            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    cur = a[i][col];
                    a[i][col] = prev;
                    prev = col;
                }
            }
            col++;
        }
    }

    public void rotateElementClockX(int [][]a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++)
                ArrayUtil.swap2DArr(a, j, i, j + 1, i);
            for (int j = i; j < N - 1 - i; j++)
                ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - i, j + 1);

            for (int j = N - 1 - i; j > i; j--)
                ArrayUtil.swap2DArr(a, j, N - 1 - i, j - 1, N - 1 - i);
            for (int j = N - 1 - i; j > i + 1; j--)
                ArrayUtil.swap2DArr(a, i, j, i, j - 1);
        }
    }

    public void rotateElementAntiClock(int [][]a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++)
                ArrayUtil.swap2DArr(a, i, j, i, j + 1);
            for (int j = i; j < N - 1 - i; j++)
                ArrayUtil.swap2DArr(a, j, N - 1 - i, j + 1, N - 1 - i);

            for (int j = N - 1 - i; j > i; j--)
                ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - i, j - 1);
            for (int j = N - 1 - i; j > i + 1; j--)
                ArrayUtil.swap2DArr(a, j, i, j - 1, i);
        }
    }

    /**
     * 3. rotate square matrix by 90 degrees anti clock wise n*n matrix without
     * extra space
     **/
    @Override
    public void rotateImageBy90DegreeAntiClock(int [][]a) {
        int N = a.length;
        /* consider all square one by one */
        for (int x = 0; x < N / 2; x++) {
            /* consider element in group of N in current square ie i=0 */
            for (int y = x; y < N - x - 1; y++) {
                // store current cell in temp variable
                int temp = a[x][y];

                // move values from right to top
                a[x][y] = a[y][N - 1 - x];

                // move values from bottom to right
                a[y][N - 1 - x] = a[N - 1 - x][N - 1 - y];

                // move values from left to bottom
                a[N - 1 - x][N - 1 - y] = a[N - 1 - y][x];

                // assign temp to left
                a[N - 1 - y][x] = temp;
            }
        }
    }

    /** 4. Rotate a Matrix by 180 degree clockwise/anticlock wise **/
    public void rorateMatrix180(int [][]a) {
        int N = a.length;
        // 2 time rorate 90 degree
        for (int x = 0; x < 2; x++) {
            for (int i = 0; i < N / 2; i++) {
                for (int j = i; j < N - 1 - i; j++) {
                    ArrayUtil.swap2DArr(a, j, i, N - 1 - i, j);
                    ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - j, N - 1 - i);
                    ArrayUtil.swap2DArr(a, N - 1 - j, N - 1 - i, i, N - 1 - j);
                }
            }
        }
    }

    /**
     * * 4. Rotate a matrix by 90 degree without using any extra space
     **/
    @Override
    public void rotateMatixBy90AntiColck(int [][]a) {

        transposeOfMatrix(a);
        reverseColumns(a);
    }

    /** 5. Rotate each ring of matrix anti clockwise by K elements **/
    @Override
    public void rotateRingKelemAntiClock(int [][]a, int k) {

        int N = a.length;
        for (int x = 0; x < k; x++) {
            for (int i = 0; i < N / 2; i++) {
                for (int j = i; j < N - 1 - i; j++)
                    ArrayUtil.swap2DArr(a, i, j, i, j + 1);
                for (int j = i; j < N - 1 - i; j++)
                    ArrayUtil.swap2DArr(a, j, N - 1 - i, j + 1, N - 1 - i);

                for (int j = N - 1 - i; j > i; j--)
                    ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - i, j - 1);
                for (int j = N - 1 - i; j > i + 1; j--)
                    ArrayUtil.swap2DArr(a, j, i, j - 1, i);
            }
        }
    }

    /** 6. Turn an image by 90 degree clockwise **/
    public void turnImageBy90Degree(int [][]a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                ArrayUtil.swap2DArr(a, j, i, N - 1 - i, j);
                ArrayUtil.swap2DArr(a, N - 1 - i, j, N - 1 - j, N - 1 - i);
                ArrayUtil.swap2DArr(a, N - 1 - j, N - 1 - i, i, N - 1 - j);
            }
        }

    }

    public void turnImageBy90DegreeAntyClockWise(int [][]a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; j++) {
                ArrayUtil.swap2DArr(a, i, N - 1 - j, N - 1 - j, N - 1 - i);
                ArrayUtil.swap2DArr(a, N - 1 - j, N - 1 - i, N - 1 - i, j);
                ArrayUtil.swap2DArr(a, N - 1 - i, j, j, i);
            }
        }

    }

    /**
     * 7. Check if all rows of a matrix are circular rotations of each other
     **/
    public boolean isAllColumnsCiucularRotated(int [][]a) {
        boolean isFound = true;

        String str = "";
        for (int i = 0; i < a[0].length; i++) {
            str += String.valueOf(a[0][i]);
        }
        str = str + str;
        String checkedString = "";
        for (int i = 1; i < a.length; i++) {
            checkedString = "";
            for (int j = 0; j < a[i].length; j++) {
                checkedString += String.valueOf(a[i][j]);
            }
            if (!str.contains(checkedString)) {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    /** 8. Sort the given matrix **/
    // @Idea collect all element in single array sort it and fill the matrix row by
    // row
    @Override
    public void strictSotMatrix(int [][]a) {

        int n = a.length;
        int m = a[0].length;
        int k = 0;
        int x[] = new int[m * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                x[k++] = a[i][j];
            }
        }
        Arrays.sort(x);
        k = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = x[k++];
            }
        }
    }

    /** 9. Find the row with maximum number of 1s where each row is sorted **/
    // @Idea1 traverse and count in each row T O(m*n)
    // @Idea2 vertical travel and find first 1, return row j, average TO(n/2)
    // @Idea2
    @Override
    public int rowMaxNumbOf1s(int [][]a) {
        int m = a.length;
        int n = a[0].length;
        for (int j = 0, i = 0; i < m; j++) {
            if (a[j][i] == 1)
                return j;
            if (j == n - 1) {
                j = -1;
                i++;
            }
        }
        return -1;
    }

    /** 10. Find median in row wise sorted matrix **/
    public int binaryMedian(int [][]a, int r, int c) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < r; i++) {
            if (a[i][0] < min)
                min = a[i][0];
            if (a[c - 1][i] > max)
                max = a[c - 1][i];
        }

        int desired = (r * c + 1) / 2;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int place = 0;
            int get = 0;
            for (int i = 0; i < r; ++i) {

                get = Arrays.binarySearch(a[i], mid);
                if (get < 0)
                    get = Math.abs(get) - 1;

                else { // for duplicate last reach to last duplicate
                    while (get < a[i].length && a[i][get] == mid)
                        get += 1;
                }

                place = place + get;
            }

            if (place < desired)
                min = mid + 1;
            else
                max = mid;
        }
        return min;
    }

    /** 11. Matrix Multiplication | Recursive **/
    public static int i = 0, j = 0, k = 0,c[][];
    public int[][] multiplyMatrixRec(int [][]a, int r1, int c1, int [][]b, int r2,int c2){
        if(c==null)
            c=new int[r1][c2];
        if(i>=r1)
            return c;
        if( j < c2)
        {
            if(k < c1)
            {
                c[i][j] += a[i][k]*b[k][j];
                k++;
                multiplyMatrixRec(a, r1, c1, b, r2, c2);
            }
            k=0;
            j++;
            multiplyMatrixRec(a, r1, c1, b, r2, c2);
        }
        j=0;
        i++;
        multiplyMatrixRec(a, r1, c1, b, r2, c2);
        return  c;
    }
    /** 12. Program to multiply two matrices **/
    public int [][] matrixMultiplication(int [][]a,int [][]b){
        if(a[0].length!=b.length)
            return null;
        int x=a.length;
        int y=b[0].length;
        int z=a[0].length;
        int [][]c=new int[x][y];
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {
                for(int k=0;k<z;k++) {
                    c[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return c;
    }
    /** 13. Program for scalar multiplication of a matrix
     @Note just iterate and multiplying every element with given value k**/
    /**
     * 14. Program to print Lower triangular and Upper triangular matrix of an array
     **/
    public void lowerTriangle(int [][]a){
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                if(i<j)
                    a[i][j]=0;
    }
    public void upperTriangle(int [][]a){
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                if(i>j)
                    a[i][j]=0;
    }
    /** 15. Find distinct elements common to all rows of a matrix **/
    public List<Integer> distinctCommonToAllRows(int [][]a) {
        List<Integer> rList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                set.add(a[i][j]);
        List<Integer> list = new ArrayList<>(set);
        for (int distinct : list) {
            int rowCount = 0;
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++)
                    if (distinct == a[i][j]) {
                        rowCount++;
                        break;
                    }
            }
            if (rowCount == a[0].length)
                rList.add(distinct);
        }
        return rList;
    }
    @Override
    public List<Integer> distinctCommonToAllRowsAndCols(int [][]a) {
            List<Integer> rList = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            for(int i=0;i<a.length;i++)
                for(int j=0;j<a[0].length;j++)
                    set.add(a[i][j]);
            List<Integer> list = new ArrayList<>(set);
            for(int distinct:list) {
                int rowCount=0;
                int colCount=0;
                //searching in rows
                for (int i = 0; i < a.length; i++)
                    for (int j = 0; j < a[0].length; j++)
                        if (distinct == a[i][j]) {
                            rowCount++;
                            break;
                        }
                //searching in columns
                for (int j = 0; j < a[0].length; j++)
                    for (int i = 0; i < a.length; i++)
                    if(distinct == a[i][j]) {
                        colCount++;
                        break;
                    }

                if(rowCount==a[0].length && colCount==a.length)
                    rList.add(distinct);
            }
            return rList;
    }
    /** 16. Print a given matrix in spiral form **/
    public void spiralPrintMatrix(int [][]a) {

        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; System.out.print(a[i][j] + " "), j++)
                ;
            for (int j = i; j < N - 1 - i; System.out.print(a[j][N - 1 - i] + " "), j++)
                ;
            for (int j = i; j < N - 1 - i; System.out.print(a[N - 1 - i][N - 1 - j] + " "), j++)
                ;
            for (int j = i; j < N - 1 - i; System.out.print(a[N - 1 - j][i] + " "), j++)
                ;
            System.out.println();
        }
    }

    public void spiralPrintMatrixAnticlockwise(int [][]a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - 1 - i; System.out.print(a[j][i] + " "), j++)
                ;
            for (int j = i; j < N - 1 - i; System.out.print(a[N - 1 - i][j] + " "), j++)
                ;
            for (int j = i; j < N - 1 - i; System.out.print(a[N - 1 - j][N - 1 - i] + " "), j++)
                ;
            for (int j = i; j < N - 1 - i; System.out.print(a[i][N - 1 - j] + " "), j++)
                ;
            System.out.println();
        }
    }

    // **************************************************************************************************************************************************************//
    /** transpose the matrix **/
    @Override
    public void transposeOfMatrix(int [][]a) {

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[0].length; j++) {
                int temp = a[j][i];
                a[j][i] = a[i][j];
                a[i][j] = temp;
            }
        }
    }

    /** Reverse column **/
    @Override
    public void reverseColumns(int arr[][]) {
        for (int i = 0; i < arr[0].length; i++)
            for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
    }

    /** Spiral traverse */
    @Override
    public int[] spiralTraverse(int [][]a) {

        int temp[] = new int[a.length * a[0].length];
        int m = a.length;
        int n = a[0].length;
        int row, col;
        row = 0;
        col = 0;
        int tmp = 0;

        while (row < m && col < n) {

            /*
             * if (row + 1 == m || col + 1 == n) break;
             */
            /* elements of top row. */

            for (int j = col; j < n; j++) {
                temp[tmp++] = a[row][j];
            }
            row++;

            /* elements of last column */
            for (int i = row; i < m; i++) {
                temp[tmp++] = a[i][n - 1];
            }
            n--;
            /* elements of bottom row */
            if (row < m) {

                for (int j = n - 1; j >= col; j--) {
                    temp[tmp++] = a[m - 1][j];
                }
            }
            m--;

            /* Move elements of first column. */
            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    temp[tmp++] = a[i][col];
                }
            }
            col++;
        }
        return temp;
    }

    /** spiral fill **/
    public void spiralFill(int [][]a, int temp[]) {
        int m = a.length;
        int n = a[0].length;
        int row, col;
        row = 0;
        col = 0;
        int tmp = 0;

        while (row < m && col < n) {

            if (row + 1 == m || col + 1 == n)
                break;
            /* elements of top row. */

            for (int j = col; j < n; j++) {
                a[row][j] = temp[tmp++];
            }
            row++;

            /* elements of last column */
            for (int i = row; i < m; i++) {
                a[i][n - 1] = temp[tmp++];
            }
            n--;
            /* elements of bottom row */
            if (row < m) {

                for (int j = n - 1; j >= col; j--) {
                    a[m - 1][j] = temp[tmp++];
                }
            }
            m--;

            /* Move elements of first column. */
            if (col < n) {
                for (int i = m - 1; i >= row; i--) {
                    a[i][col] = temp[tmp++];
                }
            }
            col++;
        }
    }

    /* Function to reverse arr[] from index start to end */
    @Override
    public void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
