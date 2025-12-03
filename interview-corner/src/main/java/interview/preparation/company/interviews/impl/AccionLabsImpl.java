package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IAccionLabs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class AccionLabsImpl implements IAccionLabs {

    /**find the max len unique sub string**/
    @Override
    public String maxLenUniqueSubStr(String str){
        int n = str.length();

       return IntStream.range(0, n)
            .boxed()
            .flatMap(i -> IntStream.rangeClosed(i + 1, n)
                .filter(j -> str.substring(i, j).chars().distinct().count() == str.substring(i, j).length())
                .mapToObj(j-> str.substring(i,j))
            )
            .map(String::valueOf)
            .max(Comparator.comparingInt(String::length))
            .orElse("");
    }

    @Override
    public String maxLenUniqueSubStrX(String str){
        int maxLen=0;
        int left =0;
        int start=0;
        Map<Character,Integer> map = new HashMap<>();
        for(int right=0;right<str.length();right++)
        {
            char c = str.charAt(right);
            // If character repeated inside current window, move left pointer
            if(map.containsKey(c)&&map.get(c)>=left)
            {
                left=map.get(c)+1;
            }
            map.put(c,right);

            if(right-left+1>maxLen)
            {
                maxLen = right-left+1;
                start = left;
            }
        }
        return str.substring(start,start+maxLen);
    }
}
