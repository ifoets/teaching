package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.ITanishiConsultants;
import io.reactivex.rxjava3.internal.functions.Functions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TanishiConsultantsImpl implements ITanishiConsultants {

    /**find duplicate char in given string**/
    public Map<Character,Long> duplicateChar(String str){

        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream().filter(e->e.getValue()>1L)
                .collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1,e2)-> e1,
                    LinkedHashMap::new
                ));
    }
}
