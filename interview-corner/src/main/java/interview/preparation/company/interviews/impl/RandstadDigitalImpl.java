package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IRandstadDigital;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RandstadDigitalImpl implements IRandstadDigital {


    @Override
    public Long findUubStr(String str, String subStr){
        return
            Arrays.stream(str.split(" "))
                .filter(s-> s.equals(subStr))
                .count();
    }

    @Override
    public Character secondRepeatedChar(String str)
    {
        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e-> e.getKey()!=' '&& e.getValue()>1)
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();
    }
}
