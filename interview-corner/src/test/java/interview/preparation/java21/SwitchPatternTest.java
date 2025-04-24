package interview.preparation.java21;

import org.junit.Assert;
import org.junit.Test;

public class SwitchPatternTest {


    @Test
    public void switchPatternTest() {

    SwitchPattern.SavingsAccount sa = new SwitchPattern.SavingsAccount();
    SwitchPattern.TermAccount ta = new SwitchPattern.TermAccount();
    SwitchPattern.CurrentAccount ca = new SwitchPattern.CurrentAccount();

    Assert.assertEquals((int)SwitchPattern.getBalanceWithOutSwitchPattern(sa),(int)SwitchPattern.getBalanceWithSwitchPattern(sa));
    Assert.assertEquals((int)SwitchPattern.getBalanceWithOutSwitchPattern(ta),(int)SwitchPattern.getBalanceWithSwitchPattern(ta));
    Assert.assertEquals((int)SwitchPattern.getBalanceWithOutSwitchPattern(ca),(int)SwitchPattern.getBalanceWithSwitchPattern(ca));
}
}
