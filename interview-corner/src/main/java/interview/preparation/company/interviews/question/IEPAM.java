package interview.preparation.company.interviews.question;

import java.util.List;
import java.util.Map;

public interface IEPAM {

    /*java 8 merge two sorted array in sorted*/
     List<Integer> mergeTwoSortedArray(int[] a1,int[] a2);

     Map<Character, Long> countCharsInStr(String str);

     String removeDuplicateChar(String str);
     /**find any cyclic in graph if yes return false or true*/
     boolean isCourseCompleted(int n, int[][] prerequisites);

     Map<Character,Long> findFrequency(List<String> list);

     /**2nd round of interview **/
     /**sort char in string by descending value count and then key ascending**/
     Map<Character,Long> sortCharByDesFreqAndThenByAscChar(String str);

     /**find minimum in rotated array*/
     int findMinInRotatedArray(int[] a, int l,int r);

}
