package com.design.analysis.experiment.algo;

import java.util.*;
import java.util.stream.Collectors;

public class ExperimentArrayImpl implements IExperimentArray{
    /**sort coloar in bundle frrquency(1,2,3) if freq is same sort on code,(0,1,2) r coloar code of green blue green **/
    /** Ex-{0,0,2,2,2,2,1,1,1,1,1->{[1], [[1, 2], [1, 2], [[0, 1, 2], [0, 1, 2]}, here color is only 3*/
    @Override
    public void sortColoarBundleFrequency(int[]a, int colors){
        int n=a.length;
        int[]x = new int[colors];
        for(int in:a)x[in]++;

        int k=0;
        while (k!=n) {
            for (int i = x.length - 1; i >= 0; i--) {
                if (x[i] != 0&&k!=n) {
                    x[i]--;
                    a[n - 1 - (k++)] = i;
                }
            }
        }
    }
}
