package com.design.analysis.ds.hash.table.medium;

import java.util.*;

public class HashTableMediumImpl implements IHashTableMedium{

    /**73. Set Matrix Zeroes**/
    @Override
    public void setZeroesRowsColms(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Step 1: Check first row
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Step 2: Check first column
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Step 3: Mark rows & columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Step 4: Set zeroes based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Step 5: Handle first row
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Step 6: Handle first column
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    @Override
    public void setZeroesDigonals(int[][] matrix){
        Map<Integer,Integer> map = new HashMap<>();
        int m=matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                    map.put(i,j);
            }
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int ki=entry.getKey();
            int vj=entry.getValue();

            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if((i+j==ki+vj)|| (i-j==ki-vj) ||(j-i==vj-ki))
                        matrix[i][j]=0;
                }
            }
        }
    }
}
