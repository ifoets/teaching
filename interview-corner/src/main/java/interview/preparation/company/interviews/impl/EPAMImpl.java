package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IEPAM;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EPAMImpl implements IEPAM {

    /*java 8 merge two sorted array in sorted*/
    @Override
    public List<Integer> mergeTwoSortedArray(int []a1, int []a2){
       return Stream.concat(Arrays.stream(a1).boxed(),Arrays.stream(a2).boxed()).sorted().toList();
    }

    @Override
    public Map<Character, Long> countCharsInStr(String str){
        return  str.chars().mapToObj(c -> (char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
    }

    @Override
    public String removeDuplicateChar(String str){
         StringBuilder builder = new StringBuilder();
         str.chars().distinct().forEach(c->builder.append((char)c));
         return  builder.toString();
    }

    /**find any cyclic in graph if yes return false or true*/
    //@see IGraphMedium, /**207. Course Schedule**/ canFinish(..)
    @Override
    public boolean isCourseCompleted(int n, int[][] prerequisites){

        Map<Integer,List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];

        for(int i=0;i<n;i++) graph.put(i,new ArrayList<>());
        //create graph and indeed
        for(int[]p:prerequisites)
        {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        int count=0;
        for(int i=0;i<n;i++)
            if(indegree[i]==0)queue.add(indegree[i]);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            for (int next : graph.get(node))
            {
                indegree[next]--;
                if(indegree[next]==0)
                    queue.add(next);
            }
        }
        return count==n;
    }

    @Override
    public Map<Character,Long> findFrequency(List<String> list){
        return
            list.stream().flatMap(s->s.chars().mapToObj(c->(char)c))
                .collect(Collectors.groupingBy(
                   c->c,
                   Collectors.counting()
                ));
    }

    /**2nd round of interview **/
    /**sort char in string by descending value count and then key ascending**/
    @Override
    public Map<Character,Long> sortCharByDesFreqAndThenByAscChar(String str){
        return
            str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(
                    Map.Entry.<Character,Long>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey())
                )
                .collect(Collectors.toMap(
                   Map.Entry::getKey,
                   Map.Entry::getValue,
                    (e1,e2)-> e1,
                    LinkedHashMap::new
                ));
    }

    /**find minimum in rotated array*/
    @Override
    public int findMinInRotatedArray(int[] a, int l, int r){
        if(a[0]<a[a.length-1])
            return a[0];
        if(l<r)
        {
            int m = (l+r)/2;
            if(m>0 && a[m-1]>a[m])
                return a[m];
            if(m<a.length-1 && a[m]>a[m+1])
                return a[m+1];
            if(a[l]<a[m])
                return findMinInRotatedArray(a,m+1,r);
            return findMinInRotatedArray(a,l,m-1);
        }
        return -1;
    }
}
