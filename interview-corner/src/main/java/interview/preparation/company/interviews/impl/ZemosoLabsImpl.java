package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IZemosoLabs;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class ZemosoLabsImpl implements IZemosoLabs {

    /**find unique char in string**/
    @Override
    public Map<Character,Long> uniqueChar(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                    c->c,
                    Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(e->e.getValue()==1L)
                .collect(Collectors.toMap(
                   Map.Entry::getKey,
                   Map.Entry::getValue,
                    (e1,d2)->e1,
                    LinkedHashMap::new
                ));
    }

    /**collect all the arrangement of String**/
    @Override
    public void permutation(String str, int l, int r, List<String> list){
        if (l == r) {
            list.add(str);
            return;
        }

        for (int i = l; i <= r; i++) {   // <= r not < r
            str = swap(str, l, i);
            permutation(str, l + 1, r, list);
            str = swap(str, l, i);       // backtrack
        }
    }
    private String swap(String str, int i, int j)
    {
        char[] arr = str.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return new String(arr);
    }
}
