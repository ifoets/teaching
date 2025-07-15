package interview.preparation.company.interviews;

import interview.preparation.company.interviews.impl.AltimetrikImpl;
import interview.preparation.company.interviews.model.Student;
import interview.preparation.company.interviews.question.IAltimetrik;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;


public class IAltimetrikTest {

    public IAltimetrik ial;

    @Before
    public void init()
    {
        ial = new AltimetrikImpl();
    }

    @Test
    public void minimumCandiesPerHourTest()
    {
        int a[] = {1, 0, 2};
        Assert.assertEquals(5,ial.minimumCandiesPerHour(a));
        int b[]={1,2,2};
        Assert.assertEquals(4,ial.minimumCandiesPerHour(b));
        int c[]={8,3,2,1,4,5,2,3,4};
        System.out.println(ial.minimumCandiesPerHour(c));
        Assert.assertEquals(21,ial.minimumCandiesPerHour(c));
        int d[]={4, 9, 11, 17};
        System.out.println(ial.minimumCandiesPerHour(d));
        Assert.assertEquals(10,ial.minimumCandiesPerHour(d));
    }

    public static void main(String[] args) {
        System.out.println("Hi");
    }
    @Test
    public void minimumCandiesPerHourXTest()
    {
        int a[] = {1, 0, 2};
        Assert.assertEquals(5,ial.minimumCandiesPerHourX(a));
        int b[]={1,2,2};
        Assert.assertEquals(4,ial.minimumCandiesPerHourX(b));
        int c[]={8,3,2,1,4,5,2,3,4};
        System.out.println(ial.minimumCandiesPerHourX(c));
        Assert.assertEquals(21,ial.minimumCandiesPerHourX(c));
        int d[]={4, 9, 11, 17};
        System.out.println(ial.minimumCandiesPerHourX(d));
        Assert.assertEquals(10,ial.minimumCandiesPerHourX(d));
    }
    @Test
    public void checkDuplicateCountValTest()
    {
        int a[] = {4,6, 6,7,7,7,9,9,9,9};
        Assert.assertTrue(ial.checkDuplicateCountVal(a));
        int b[] ={1, 2,3,1};
        Assert.assertTrue(!ial.checkDuplicateCountVal(b));
    }

    @Test
    public  void get2ndMaxNoTest() {
        List<List<Integer>> lists = Arrays.asList(Arrays.asList(1, 2, 2, 2, 3),
            Arrays.asList(4, 4, 4, 5, 5, 6),
            Arrays.asList(6, 6, 7, 7, 7, 8, 8, 8));
        Assert.assertTrue(ial.get2ndMaxNo(lists)==7);
    }

    @Test
    public void findVowlesIndexTest(){
        List<Integer> rsList = List.of(0,3,5,8,11,13);
        Assert.assertEquals(rsList,ial.findVowlesIndex("abhimanyu kumar"));
        System.out.print(ial.findVowlesIndex("abhimanyu kumar"));
    }

    @Test
    public void pivotInRotatedArrayTest()
    {
        int []a = {5,6,7,8,9,1,2,3,4};
        int []b = {9,1,2,3,4,5,6,7,8};
        int []c = {2,3,4,5,6,7,8,9,1};
        Assert.assertEquals(4,ial.pivotInRotatedArray(a,0,a.length-1));
        Assert.assertEquals(0,ial.pivotInRotatedArray(b,0,b.length-1));
        Assert.assertEquals(7,ial.pivotInRotatedArray(c,0,c.length-1));
    }
    @Test
    public void searchInRotatedArrayTest()
    {
        int []a = {5,6,7,8,9,1,2,3,4};
        int []b = {9,1,2,3,4,5,6,7,8};
        int []c = {2,3,4,5,6,7,8,9,1};
        Assert.assertEquals(5,ial.searchInRotatedArray(a,1));
        Assert.assertEquals(3,ial.searchInRotatedArray(b,3));
        Assert.assertEquals(8,ial.searchInRotatedArray(c,1));
    }

    @Test
    public void maxPalindromeSubStrTest()
    {
        String str ="abdbcd";
        Assert.assertEquals("bdb",ial.maxPalindromeSubStr(str));
    }

    @Test
    public void rotateListTest()
    {
        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> list2 = List.of(3,4,5,1,2);

        list1 = ial.rotateList(list1,2);
        for(int i=0;i<list2.size();i++)
            Assert.assertEquals(list1.get(i),list2.get(i));
    }

    @Test
    public void rotateListXTest()
    {
        List<Integer> list1 = List.of(1,2,3,4,5);
        List<Integer> list2 = List.of(3,4,5,1,2);

        list1 = ial.rotateListX(list1,2);
        for(int i=0;i<list2.size();i++)
            Assert.assertEquals(list1.get(i),list2.get(i));
    }
    @Test
    public void rotateListYTest()
    {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = List.of(3,4,5,1,2);

        ial.rotateListY(list1,2);
        for(int i=0;i<list2.size();i++)
            Assert.assertEquals(list1.get(i),list2.get(i));
    }

    @Test
    public void rotateMapTest()
    {

        LinkedHashMap<Integer,Integer> lhm1 = new LinkedHashMap();
        lhm1.put(1,10);//Map.of(
        lhm1.put(2,20);
        lhm1.put(3,30);
        lhm1.put(4,40);
        lhm1.put(5,50);

        LinkedHashMap<Integer,Integer> lhm2 = new LinkedHashMap(Map.of(
            3,30,
            4,40,
            5,50,
            1,10,
            2,20
        ));

        lhm1 = (LinkedHashMap<Integer,Integer>)ial.rotateMap(lhm1,2);
        for(int i=0;i<lhm1.size();i++)
            Assert.assertEquals(lhm1.get(i),lhm2.get(i));
    }
    @Test
    public void rotateMapXTest()
    {
        LinkedHashMap<Integer,Integer> lhm1 = new LinkedHashMap();
        lhm1.put(1,10);//Map.of(
        lhm1.put(2,20);
        lhm1.put(3,30);
        lhm1.put(4,40);
        lhm1.put(5,50);

        LinkedHashMap<Integer,Integer> lhm2 = new LinkedHashMap(Map.of(
            3,30,
            4,40,
            5,50,
            1,10,
            2,20
        ));

        lhm1 = (LinkedHashMap<Integer, Integer>) ial.rotateMapX(lhm1,2);
        for(int i=0;i<lhm1.size();i++)
            Assert.assertEquals(lhm1.get(i),lhm2.get(i));
    }

    /**O(n2)*/
    @Test
    public void countUniqueSubstringTest()
    {
        String str="abcd";
        //Assert.assertEquals(10,ial.countUniqueSubstring(str));
        str ="abca";
        Assert.assertEquals(9,ial.countUniqueSubstring(str));
    }
    @Test
    public void allUniqueSubstringTest()
    {
        List<String> strList = new ArrayList<>();
        ial.allUniqueSubstring(strList,"abca");
        Assert.assertEquals(9,strList.size());
        System.out.println(strList.toString());
    }

    @Test
    public void getSumOfAgeSameNameStudentTest()
    {
        List<Student> studentLit = DataUtils.getStudentList();
        Map<String,Integer> map = ial.getSumOfAgeSameNameStudent(studentLit);
        Assert.assertEquals(45,(int)map.get("Alice"));
        Assert.assertEquals(50,(int)map.get("Bob"));
        Assert.assertEquals(19,(int)map.get("Charlie"));
    }
    @Test
    public void getMaxAgeStudentTest()
    {
        List<Student> studentLit = DataUtils.getStudentList();
        Map<String, Optional<Student>> map = ial.getMaxAgeStudent(studentLit);
        Assert.assertEquals(25,map.get("Alice").orElseThrow().age);
        Assert.assertEquals(28,map.get("Bob").orElseThrow().age);
        Assert.assertEquals(19,map.get("Charlie").orElseThrow().age);
    }

    @Test
    public void getMinAgeStudentTest()
    {
        List<Student> studentLit = DataUtils.getStudentList();
        Map<String, Optional<Student>> map = ial.getMinAgeStudent(studentLit);
        Assert.assertEquals(20,map.get("Alice").orElseThrow().age);
        Assert.assertEquals(22,map.get("Bob").orElseThrow().age);
        Assert.assertEquals(19,map.get("Charlie").orElseThrow().age);
    }
    @Test
    public void segregateOddEvenPredicateTest()
    {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11);
        List<List<Integer>> oddEvenList = ial.segregateOddEvenPredicate(list);
        System.out.println(oddEvenList.get(0));
        System.out.println(oddEvenList.get(1));
        Assert.assertEquals(5,oddEvenList.get(0).size());
        Assert.assertEquals(6,oddEvenList.get(1).size());
    }
    @Test
    public void test()
    {
        String s = "abca";

        // System.out.println(s.chars().distinct().length);
    }

}


