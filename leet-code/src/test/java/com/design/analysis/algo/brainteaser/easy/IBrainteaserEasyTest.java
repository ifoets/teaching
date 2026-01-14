package com.design.analysis.algo.brainteaser.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IBrainteaserEasyTest {

  IBrainteaserEasy ibe;

  @Before
  public void init()
  {
    ibe = new BrainteaserEasyImpl();
  }

    /**292. Nim Game**/
    @Test
    public void canWinNimTest()
    {
        Assert.assertTrue(ibe.canWinNim(5));
        Assert.assertFalse(ibe.canWinNim(16));
        Assert.assertTrue(ibe.canWinNim(51));
    }
}
