package com.design.analysis.ds.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class DSUtilsTest {


    @Test
    public void permutationTest()
    {
        String[] words = {"ab","cd","ef"};
        List<String> exp = List.of("cdefab", "efcdab", "efabcd", "abefcd", "abcdef", "cdabef");
        List<String> list = DSUtils.permutation(words);
        Assert.assertEquals(list.stream().sorted().collect(Collectors.joining()), exp.stream().sorted().collect(Collectors.joining()));
    }
}
