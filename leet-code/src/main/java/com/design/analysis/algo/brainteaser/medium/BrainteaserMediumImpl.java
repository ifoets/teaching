package com.design.analysis.algo.brainteaser.medium;

import lombok.ToString;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BrainteaserMediumImpl implements IBrainteaserMedium {

    /**319. Bulb Switcher**/
    @Override
    public int bulbSwitch(int n){
        return (int) Math.sqrt(n);
    }
}
