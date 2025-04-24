package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IEPAM;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EPAMImpl implements IEPAM {

    /*java 8 merge two sorted array in sorted*/
    public List<Integer> mergeTwoSortedArray(int []a1, int []a2){
       return Stream.concat(Arrays.stream(a1).boxed(),Arrays.stream(a2).boxed()).sorted().toList();
    }

    public Map<Character, Long> countCharsInStr(String str){
        return  str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    public String removeDuplicateChar(String str){
         StringBuilder builder = new StringBuilder();
         str.chars().distinct().forEach(c->builder.append((char)c));
         return  builder.toString();
    }
}
