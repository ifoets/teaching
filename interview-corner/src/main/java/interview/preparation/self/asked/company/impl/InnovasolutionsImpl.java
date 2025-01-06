package interview.preparation.self.asked.company.impl;

import interview.preparation.self.asked.company.question.IInnovasolutions;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class InnovasolutionsImpl implements IInnovasolutions {

    /*return integer start with 1*/
    public List<Integer> getIntStartWithI(List<Integer> list, int I, boolean startOrEndWith){
        return list.stream().map(String::valueOf).filter(e-> startOrEndWith ? e.startsWith(String.valueOf(I)) : e.endsWith(String.valueOf(I)))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    /*return max length continuous sub string having unique char*/
    public String getMaxLenSubStrUniqueChar(String str){
        StringBuilder sbr = new StringBuilder();
        String strMax=null;
        Set<Character> set = new HashSet<>();
        char []chars = str.toCharArray();
        for(int i=0;i<str.length();i++)
        {
           if(!set.contains(chars[i]))
           {
               set.add(chars[i]);
               sbr.append(chars[i]);
           }
           else {
               set = new HashSet<>();
               if(strMax==null)
                   strMax = sbr.toString();
               strMax = strMax.length() <= sbr.toString().length() ? sbr.toString() : strMax;
               sbr = new StringBuilder();
               sbr.append(chars[i]);
               set.add(chars[i]);
           }
        }
        return  strMax;
    }
}
