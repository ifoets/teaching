package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.Utils.InterviewUtils;
import interview.preparation.company.interviews.model.Student;
import interview.preparation.company.interviews.question.IAltimetrik;
import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public  class AltimetrikImpl implements IAltimetrik {

	/*find the minimum number of candies required for distributing to N children such that every
	child gets at least one candy and the children having the higher rating get more candies than its neighbours.
	 */
	@Override
	public int minimumCandiesPerHour(int []a) {
        int n=a.length;
        int b[] = new int[n];
        Arrays.fill(b,1);
		int count=0;
        //find the index of min element
        int minIndex =0;
        int minElem=a[0];
        for(int i=0;i<n;i++){
            if(minElem>a[i]){
                minElem =a[i];
                minIndex=i;
            }
        }
        int j= minIndex;
        while (j<n-1)
        {
            if(a[j]<a[j+1])
                b[j+1]=b[j]+1;
            j++;
        }
        int k = minIndex;
        while (k>0)
        {
            if(a[k-1]>a[k])
                b[k-1]=b[k]+1;
            k--;
        }
        for(int i=0;i<n;count+=b[i++]);
        return count;
	}

    public int minimumCandiesPerHourX(int []c){
        int n = c.length;
        if(n<2)
            return 1;
        int []a = new int[n];
        int count=0;
        Arrays.fill(a,1);

        //forward arrange
        for (int i=0;i<n-1;i++)
        {
            if(c[i+1]>c[i])
                a[i+1]=a[i]+1;
        }
        //backward arrange
        for(int i=n-1;i>0;i--)
        {
            if(c[i-1]>c[i])
                a[i-1]=Math.max(a[i]+1,a[i-1]);
        }
        for(int i=0;i<n;count+=a[i++]);
        return count;
    }
	@Override
	public boolean checkDuplicateCountVal(int a[])
	{
		int N=a.length;
	    Map<Integer, Integer> map = new HashMap<>();
		for(int i=0 ;i<N ;i++)
		{
			if(map.containsKey(a[i]))
				map.put(a[i],map.get(a[i])+1);
			else map.put(a[i],1);
		}
		Set<Integer> set = new HashSet<>();
		for(Map.Entry entry:map.entrySet())
			set.add((Integer) entry.getValue());
		return set.size()==map.size();
	}

	@Override
	public int get2ndMaxNo(List<List<Integer>> ll){
		List<Integer> l = ll.stream().flatMap(Collection::stream).collect(Collectors.toSet()).stream().sorted().toList();
		return l.get(l.size()-2);
	}

    @Override
    public List<Integer> findVowlesIndex(String str) {

        List<Character> chList = List.of('a', 'e', 'i', 'o', 'u');
        char[] chars = str.toLowerCase().toCharArray();
        return IntStream.range(0, chars.length)
                .filter(i -> chList.contains(chars[i]))
                .boxed()
                .toList();
    }

    @Override
    public void rotateArrayFromRight(int []a,int x){
        InterviewUtils.reverse(a,0,x-1);
        InterviewUtils.reverse(a,x,a.length-1);
        InterviewUtils.reverse(a,0,a.length-1);
    }

    @Override
    public int searchInRotatedArray(int []a, int x){
      int pivot = pivotInRotatedArray(a,0,a.length-1);

       if(x<a[0]) {
           return InterviewUtils.binarySearch(a, x, pivot+1, a.length-1);
       }
      else return InterviewUtils.binarySearch(a,x,0,pivot);
    }

    @Override
    public int pivotInRotatedArray(int []a,int l, int r){
        int m = (l+r)/2;
        if (l<=r)
        {
            if(m>0 && a[m-1]>a[m])
                return m-1;
            if(m<a.length-1 && a[m]>a[m+1])
                return m;
            if(a[m]<a[r])
                return pivotInRotatedArray(a,l,m-1);
            else
                return pivotInRotatedArray(a,m+1,r);
        }
       return -1;
    }

    @Override
    public String maxPalindromeSubStr(String str){
        int maxLen=0;
        String maxLenPalindromStr=null;
        for(int i=0;i<str.length();i++)
        {
            for(int j=i+1;j<str.length() ;j++)
            {
                    String s = str.substring(i, j);
                    if (isPalindrome(s))
                    {
                        if (maxLen < s.length()) {
                            maxLen = s.length();
                            maxLenPalindromStr = s;
                        }
                    }
            }
        }
        return maxLenPalindromStr;
    }

    public boolean isPalindrome(String str)
    {
        int i=0;
        int j=str.length()-1;
        while (i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    @Override
    public List<Integer> rotateList(List<Integer> list, int k){
        return Stream.concat(list.subList(k, list.size()).stream(),list.subList(0,k).stream()).toList();
    }
    @Override
    public  List<Integer> rotateListX(List<Integer> list, int k){
        List<Integer> list1 = new ArrayList<>(list);
        Collections.rotate(list1,-k); //for right rotation
        return list1;
    }

    @Override
    public  void rotateListY(List<Integer> list, int k){
        reverse(list,0,k-1);
        reverse(list,k,list.size()-1);
        reverse(list,0,list.size()-1);
    }
    public void reverse(List<Integer> list, int i, int j)
    {
        while (i<j)
        {
            int temp = list.get(i);
            list.set(i,list.get(j));
            list.set(j,temp);
            i++;
            j--;
        }
    }
    /**rotate map position by k to right**/
    @Override
    public Map<Integer,Integer> rotateMap(LinkedHashMap<Integer, Integer> map, int k)
    {
         return Stream.concat(map.entrySet().stream().toList().subList(k, map.size()).stream(),map.entrySet().stream().toList().subList(0, k).stream())
             .collect(Collectors.toMap(
                 Map.Entry::getKey,
                 Map.Entry::getValue,
                 (e1,e2)->e1,
                 LinkedHashMap::new
             ));
    }
    @Override
    //make map index based key and vlaue=
    public Map<Integer,Integer> rotateMapX(Map<Integer, Integer> map, int k){

        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet().stream().toList());
        Collections.rotate(entryList,-k);
        return entryList.stream().collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1,e2)->e1,
            LinkedHashMap::new
        ));
    }

    /**O(n2)*/
    public int countUniqueSubstring(String s){
       int N = s.length();
       if(N==s.chars().distinct().toArray().length)
           return N*(N+1)/2;
       int count=0;
       for(int i=0;i<N;i++)
       {
           for(int j=i+1;j<=N;j++)
           {
               String sub = s.substring(i,j);
               if(sub.equals(sub.chars().mapToObj(c->(char)c).distinct().map(String::valueOf).collect(Collectors.joining())))
                   count++;
           }
       }
        return  count;
    }

    @Override
    public int countUniqueSubstringX(String s){
        int N = s.length();
        int count=0;
        Set<Character> set = new HashSet<>();
        int left=0,right=0;

        while (right<N)
        {
            char c = s.charAt(right);
            while (set.contains(c))
            {
                set.remove(s.charAt(left++));
            }
            set.add(c);
            count+=right-left+1;
            right++;
        }
        return count;
    }

    @Override
    public void allUniqueSubstring(List<String> list, String s){
        int N = s.length();

        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<=N;j++)
            {
                String str = s.substring(i, j);
                if(str.equals(str.chars().mapToObj(c->(char)c).distinct().map(String::valueOf).collect(Collectors.joining()))) {
                    list.add(str);
                }
            }
        }
    }

    @Override
    public Map<String, Integer> getSumOfAgeSameNameStudent(List<Student> list){

        return
           list.stream()
               .collect(
                   Collectors.groupingBy(
                       Student::getName,
                       Collectors.summingInt(Student::getAge)
                   )
               );
    }

    @Override
    public Map<String, Optional<Student>> getMaxAgeStudent(List<Student> list){

        return list.stream()
            .collect(
                Collectors.groupingBy(
                    Student::getName,
                    Collectors.
                        reducing(
                        BinaryOperator.maxBy(Comparator.comparing(Student::getAge))
                )
            )
        );
    }
    @Override
    public Map<String, Optional<Student>> getMinAgeStudent(List<Student> list){

      return   list.stream()
                 .collect(
                     Collectors.groupingBy(
                      Student::getName,
                      Collectors.reducing(
                          BinaryOperator.minBy(Comparator.comparing(Student::getAge))
                  )
              )
            );
    }
    @Override
    public List<List<Integer>> segregateOddEvenPredicate(List<Integer> list){
        List<List<Integer>> rsList = new ArrayList<>();
        Predicate<Integer> oddPredicate = i -> i%2!=0;
        Predicate<Integer> evenPredicate = i-> i%2==0;
        rsList.add(filterOddEven(list,evenPredicate));
        rsList.add(filterOddEven(list,oddPredicate));
        return rsList;
    }

    @Override
    public <T> List<T> filterOddEven(List<T> list, Predicate<T> predicate){
        List<T> rsList = new ArrayList<>();
        for(T t:list)
            if(predicate.test(t))
                rsList.add(t);
        return rsList;
    }
    @Override
    public  Map<Boolean, List<Integer>> segregateOddEvenPredicateX(List<Integer> list){
        Predicate<Integer> evenPredicate = num -> num%2==0;
        return list.stream()
            .collect(
                Collectors.partitioningBy(evenPredicate)
            );
    }

}


