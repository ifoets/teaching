package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.EPAMImpl;
import interview.preparation.company.interviews.question.IEPAM;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IEPAMTest {

    IEPAM ie ;
    @Before
    public void inti()
    {
        ie = new EPAMImpl();
    }
    /*java 8 merge two sorted array in sorted*/
    @Test
    public void mergeTwoSortedArrayTest()
    {
        int arr1[] = { 1, 3, 4, 5};
        int arr2[] = {2, 4, 6, 8};
        List<Integer> rsL = List.of(1, 2, 3, 4, 4, 5, 6, 8);
        List<Integer> list = ie.mergeTwoSortedArray(arr1,arr2);
        Assert.assertTrue(list.containsAll(rsL));
        for (int i=0;i<rsL.size();i++)
            Assert.assertTrue(list.get(i)==rsL.get(i));
    }

    @Test
    public void countCharsInStrTest()
    {
        String text = "Ruchi is in technical discussion with Sagar and Gowthami";
        System.out.println(ie.countCharsInStr(text));
    }

    @Test
    public void removeDuplicateStrTest()
    {
        String text = "Ruchi is in technical discussion with Sagar and Gowthami";
        System.out.println(ie.removeDuplicateChar(text));
    }
    /**find any cyclic in graph if yes return false or true*/
    @Test
    public void isCourseCompletedTest(){

        Assert.assertTrue(ie.isCourseCompleted(4,new int[][]{{1, 0},
            {2, 1},
            {3, 2}}));
        Assert.assertFalse(ie.isCourseCompleted(4,new int[][]{{1, 0},
            {2, 1},
            {0, 2},
            {0,3}
        }));
    }

    @Test
    public void findFrequencyTest(){
        List<String> strings = Arrays.asList("apple", "banana", "orange");
        Map<Character, Long> map = ie.findFrequency(strings);
        Assert.assertEquals(5,map.get('a').intValue());
        Assert.assertEquals(2,map.get('p').intValue());
    }

    /**2nd round of interview **/
    /**sort char in string by descending value count and then key ascending**/
    @Test
    public void sortCharByDesFreqAndThenByAscCharTest(){
        Map<Character, Long> expMap = Map.of('p',5L, 'c',3L, 'd',3L, 'a',2L, 'b',2L, 'e',2L, 'm',1L);
        Map<Character,Long> rsMap = ie.sortCharByDesFreqAndThenByAscChar("aacccdddbbeemppppp");
        System.out.println(rsMap);
        Assert.assertEquals(expMap,rsMap);
    }

    /**find minimum in rotated array*/
    @Test
    public void findMinInRotatedArrayTest(){
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = {3, 4, 5, 1, 2};
        int[] nums3 = {11, 13, 15, 17};
        int[] nums4 = {2, 1};

        Assert.assertEquals(0, ie.findMinInRotatedArray(nums1,0,nums1.length-1)); // Expected 0
        Assert.assertEquals(1, ie.findMinInRotatedArray(nums2,0,nums2.length-1)); // Expected 1
        Assert.assertEquals(11, ie.findMinInRotatedArray(nums3,0,nums3.length-1)); // Expected 11
        Assert.assertEquals(1,ie.findMinInRotatedArray(nums4,0,nums4.length-1)); // Expected 1
    }
}
