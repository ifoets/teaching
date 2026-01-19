package com.design.analysis.experiment.algo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class IExperimentArrayTest {

    IExperimentArray iea;

    @Before
    public void init()
    {
        iea = new ExperimentArrayImpl();
    }
    /**sort coloar in bundle frrquency(1,2,3) if freq is same sort on code,(0,1,2) r coloar code of green blue green **/
    /** Ex-{0,0,2,2,2,2,1,1,1,1,1->{[1], [[1, 2], [1, 2], [[0, 1, 2], [0, 1, 2]}, here color is only 3*/
    @Test
    public void sortColoarBundleFrequencyTest()
    {
        int[] a={0,0,2,2,2,2,1,1,1,1,1};
        int[]b={1, 1, 2, 1, 2, 0, 1, 2, 0, 1, 2};
       iea.sortColoarBundleFrequency(a,3);
        Assert.assertArrayEquals(b,a);
    }
}
