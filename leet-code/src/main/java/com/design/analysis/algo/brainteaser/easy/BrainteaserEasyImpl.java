package com.design.analysis.algo.brainteaser.easy;

public class BrainteaserEasyImpl implements IBrainteaserEasy{

    /**292. Nim Game**/
    @Override
    public boolean canWinNim(int n){
        return n%4!=0;
    }
}
