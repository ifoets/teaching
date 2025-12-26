package com.design.analysis.experiment.algo;

import java.util.List;
import java.util.Map;

public interface IExperimentArray {

    /**sort coloar in bundle frrquency(1,2,3) if freq is same sort on code,(0,1,2) r coloar code of green blue green **/
    /** Ex-{0,0,2,2,2,2,1,1,1,1,1->{[1], [[1, 2], [1, 2], [[0, 1, 2], [0, 1, 2]}, here color is only 3*/
    void sortColoarBundleFrequency(int[]a, int colors);
}
