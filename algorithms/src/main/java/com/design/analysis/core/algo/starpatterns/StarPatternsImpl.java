package com.design.analysis.core.algo.starpatterns;

import static java.lang.System.out;

public class StarPatternsImpl implements IStarPatterns {

    /**
     * 1. print left bottom 90 degree triangle
     */
    @Override
    public int leftBottom90Triangle(int n) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                out.print(" * ");
                count++;
            }
            out.println();
        }
        return count;
    }

    public int leftBottom90LPrint(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || i == n - 1) {
                    out.print(" * ");
                    count++;
                }
            }
            out.println();
        }
        return count;
    }

    public int leftTopToRightBottomDiagonal(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j) {
                    out.print("   ");
                } else {
                    out.print(" * ");
                    count++;
                }
            }
            out.println();
        }
        return count;
    }

    @Override
    public int leftBottom90EmptyTriangle(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (i != j && j != 0 && i != n - 1) {
                    out.print("   ");
                } else {
                    out.print(" * ");
                    count++;
                }
            }
            out.println();
        }
        return count;
    }

    /**
     * 2. print right up 90 degree triangle
     */
    @Override
    public int rightTop90Triangle(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                out.print("   ");
            }
            for (int j = 0; j < n - i; j++) {
                out.print(" * ");
                count++;
            }
            out.println();
        }
        return count;
    }

    @Override
    public int rightTop90LTriangle(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    out.print(" * ");
                    count++;
                } else out.print("   ");
            }
            out.println();
        }
        return count;
    }

    public int rightTop90EmptyTriangle(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                out.print("  ");
            }
            for (int j = 0; j < n - i; j++) {
                if (i != 0 && j != n - i - 1 && j != 0) {
                    out.print("   ");
                } else {
                    out.print(" * ");
                    count++;
                }
            }
            out.println();
        }
        return count;
    }

    /**
     * 3. print right up 90 degree triangle
     */
    @Override
    public int rightUpTriangle(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                out.print(" * ");
                count++;
            }
            out.println();
        }
        return count;
    }

    @Override
    public int rightTopToLeftBottomEmptyTriangle(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (i != 0 && j != 0)
                    out.print("   ");
                else {
                    out.print(" * ");
                    count++;
                }
            }
            out.print(" * ");
            count++;
            out.println();
        }
        return count;
    }

    @Override
    public int rightTopToLetBottomDiagonal(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                out.print("   ");
            }
            out.println(" * ");
            count++;
        }
        return count;
    }

    /**
     * 4. print right up 90 degree triangle
     */
    public int rightDownTriangle(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                out.print("   ");
            }
            for (int j = 0; j < i + 1; j++) {
                out.print(" * ");
                count++;
            }
            out.println();
        }
        return count;
    }

    /**
     * 5. print temple
     */
    public int printTempleTopUp(int n) {

        int count = 0;
        for (int i = 0; i < n; i++) {
            //left half triangle
            for (int j = 0; j < n; j++) {
                if (j < n - i-1) {
                    out.print("   ");
                } else {
                    out.print(" * ");
                    count++;
                }
            }
            //right half triangle
            for(int j=0;j<i;j++){
                out.print(" * ");
                count++;
            }
            out.println();
        }
        return count;
    }

    /** print temple TOP RIGHT */
    public int printTempleTopRight(int n){
        int count=0;
        //print upper half of temle
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++){
                out.print(" * ");
                count++;
            }
            out.println();
        }
        //print lower half of triangle
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-1-i;j++){
                out.print(" * ");
                count++;
            }
            out.println();
        }
        return count;
    }

    /**7 print temple TOP DOWN */
    public int printTempleTopDown(int n){
        int count=0;
        //print left half of temle
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++){
                if(j<i)
                    out.print("   ");
                else{
                    out.print(" * ");
                    count++;
                }
            }
            //print right half of Teample
            for(int j=1;j<n-i;j++){
                out.print(" * ");
                count++;
            }
            out.println();
        }

        return count;
    }

    /**8 print temple TOP LEFT*/
    public int printTempleTopLeft(int n){
        int count=0;

        //print upper half of temple
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(j<n-i-1) {
                    out.print("   ");
                }
                else{
                    out.print(" * ");
                    count++;
                }
            }
            out.println();
        }

        //print lower half of temple

        for(int i=0;i<n-1;i++)
        {
            //print left space
            for(int j=0;j<=i;j++)
            {
                out.print("   ");
            }
            for(int j=0;j<n-i-1;j++)
            {
                out.print(" * ");
                count++;
            }
            out.println();
        }
        return count;
    }

    @Override
    public int printUpDownDumbbell(int n){
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                //top half
                if(j<n/2)
                {
                   if(j<=i && i+j<n)
                   {
                       out.print("   ");
                       count++;
                   }
                   else
                       out.print(" * ");
                }
                //bottom half
               else
                {
                    if(j>i && i+j>=n)
                    {
                        out.print("   ");
                        count++;
                    }
                    else
                        out.print(" * ");
                }
            }
            out.println();
        }
        return count;
    }
    /**10 print butter fly*/
    public int printButterFly(int n){
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                //left hafl
              if(i<n/2)
              {
                  if(j>i && i+j<n-1)
                      out.print("   ");
                  else {
                      out.print(" * ");
                      count++;
                  }

              }
              //right half
              else
              {
                  if(i>=j && i+j>=n-1)
                      out.print("   ");
                  else {
                      out.print(" * ");
                      count++;
                  }
              }
            }
            out.println();
        }
        return count;
    }

    @Override
    public int printSwasticSymbol(int n){
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0&&j<n/2 ||j==0&&i>n/2 || i==n-1&&j>n/2 ||j==n-1&&i<n/2 || i==n/2 || j==n/2)
                {
                    out.print(" * ");
                    count++;
                }else
                    out.print("   ");
            }
            out.println();
        }
        return  count;
    }

    public int printSquareWithDiagonal(int n){
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 || j==0 || i==n-1 ||j ==n-1 || i==j ||i+j==n-1)
                {
                    out.print(" * ");
                    count++;
                }else
                    out.print("   ");
            }
            out.println();
        }
        return  count;
    }
}
