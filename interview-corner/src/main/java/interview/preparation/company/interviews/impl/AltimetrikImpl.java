package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.Utils.InterviewUtils;
import interview.preparation.company.interviews.question.IAltimetrik;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AltimetrikImpl implements IAltimetrik {

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

}
