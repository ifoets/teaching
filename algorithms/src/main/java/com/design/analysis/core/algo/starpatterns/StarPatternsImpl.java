package com.design.analysis.core.algo.starpatterns;

import static java.lang.System.out;

public class StarPatternsImpl implements IStarPatterns{

    /** 1. print left bottom 90 degree triangle*/
    @Override
    public void leftBottomTriangle(int n){

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<=i;j++) {
                out.print("* ");
            }
            out.println();
        }
    }

    /** 2. print right up 90 degree triangle*/
    @Override
    public void rightUpTriangle(int n){
        for(int i=0;i<n;i++)
        {
            for(int j=i;j>=0;j--) {
                out.print("* ");
            }
            out.println();
        }
    }
}
