package com.design.analysis.utils;

import org.junit.Test;

import java.util.Arrays;

public class StringUtilsTest {

    @Test
    public void getIndexArrTest()
    {
        String s ="abhimanyu";
        System.out.println(Arrays.toString(StringUtils.getIndexArr(s)));
    }
}
