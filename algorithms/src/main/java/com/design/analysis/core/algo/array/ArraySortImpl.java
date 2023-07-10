package com.design.analysis.core.algo.array;

import java.util.*;

import com.design.analysis.core.algo.sorting.ISortingAlgo;
import com.design.analysis.core.algo.sorting.SortingAlgoImpl;
import com.design.analysis.core.algo.utils.AlgoUtils;
import com.design.analysis.core.algo.utils.ArraysUtil;

public class ArraySortImpl implements IArraySort {

	public ISortingAlgo isa = new SortingAlgoImpl();

	/** 1. Alternative Sorting **/
	@Override
	public void alternativeSorting(int a[]) {

		AlgoUtils.sortByN(a);
		int b[] = new int[a.length];
		int i = 0;
		int j = a.length - 1;
		int k = 0;

		while (i < j) {
			b[k++] = a[j];
			b[k++] = a[i];
			i++;
			j--;
			if (i == j) // for odd no of array
				b[k] = a[i];
		}
		// copying the result
		for (i = 0; i < a.length; i++)
			a[i] = b[i];
	}

	/** 2. Sort a nearly sorted (or K sorted) array **/
	@Override
	public void sortNearlySorted(int a[]) {
		// insertion sort or heap sort is useful here
		isa.maxHeapSort(a);
	}

	/** 3. Sort an array according to absolute difference with given value **/
	@Override
	public void sortByAbsDiffGivenValue(int a[], int x) {

		TreeMap<Integer, List<Integer>> multiMap = new TreeMap<>();
		List<Integer> list = null;
		int i = 0;
		for (; i < a.length; i++) {
			int abs = Math.abs(a[i] - x);
			if (multiMap.get(abs) == null) {
				list = new ArrayList<>();
				list.add(a[i]);
				multiMap.put(abs, list);
			} else {
				list = multiMap.get(abs);
				list.add(a[i]);
				multiMap.put(abs, list);
			}
		}

		i = 0;
		for (Map.Entry<Integer, List<Integer>> map : multiMap.entrySet()) {
			for (Integer inte : map.getValue())
				a[i++] = inte;
		}
	}

	public void sortByAbsDiffGivenValueX(int a[], int x) {
		if (a == null || a.length == 0 || a.length == 1)

			return;
		else {
			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < a.length - i - 1; j++) {
					if (Math.abs(a[j] - x) > Math.abs(a[j + 1] - x)) {
						int temp = a[j];
						a[j] = a[j + 1];
						a[j + 1] = temp;
					}
				}
			}
		}
	}

	/** 4. Sort an array in wave form **/
	@Override
	public void sortInWaveForm(int a[]) {
		AlgoUtils.sortByN(a);
		for (int i = 0; i < a.length - 1; i += 2)
			AlgoUtils.swap(a, i, i + 1);
	}

	/** 5. Merge an array of size n into another array of size m+n **/
	@Override
	public void meargeNArrToMNArr(int mnArr[], int nArr[]) {

		int j = mnArr.length - 1;

		for (int i = mnArr.length - 1; i >= 0; i--) {
			if (mnArr[i] != 0) {
				mnArr[j] = mnArr[i];
				mnArr[i] = 0;
				j--;
			}
		}

		/* j+1 at mnArr value start */
		j = j + 1;
		int m = 0;
		int k = 0;
		while (k < mnArr.length) {

			if (j == mnArr.length || m == nArr.length)
				break;

			if (nArr[m] < mnArr[j]) {
				mnArr[k] = nArr[m];
				m++;
			} else {
				mnArr[k] = mnArr[j];
				j++;
			}
			k++;
		}
		/* when nArr end copy pest the rest of mnArr */
		while (j < mnArr.length && k < mnArr.length)
			mnArr[k++] = mnArr[j++];

		/* when mnArr end copy pest the rest of nArr */
		while (m < nArr.length && k < mnArr.length)
			mnArr[k++] = nArr[m++];
	}

	@Override
	public void meargeNArrToMNArrX(int mnArr[], int nArr[]) {

		int k = 0;
		for (int i = 0; i < mnArr.length; i++) {
			if (mnArr[i] == 0)
				mnArr[i] = nArr[k++];
		}
		AlgoUtils.sortByN(mnArr);
	}

	/** 6. Sort an array which contain 1 to n values **/
	// swap function
	public int swap(int itself, int dummy) {
		return itself;
	}

	@Override
	public void sortNaturalNo(int a[]) {
		for (int i = 0; i < a.length; i++) {
			while (i != (a[i] - 1)) {
				a[i] = swap(a[a[i] - 1], a[a[i] - 1] = a[i]);
			}
		}
	}

	/** 7. Sort 1 to N by swapping adjacent elements **/
	public boolean sort1ToNBySwapAdjacent(int a[], boolean b[]) {

		int n = a.length;
		int i, j;

		// Check bool array b and sorts
		// elements for continuos sequnce of 1
		for (i = 0; i < n - 1; i++) {
			if (b[i]) {
				j = i;
				while (b[j]) {
					j++;
				}
				// Sort array A from i to j
				Arrays.sort(a, i, 1 + j);
				i = j;
			}
		}

		// Check if array is sorted or not
		for (i = 0; i < n; i++) {
			if (a[i] != i + 1) {
				return false;
			}
		}

		return true;
	}

	/** 8. Sort an array containing two types of elements **/
	public void sort0And1(int a[]) {
		int i = 0;
		int j = a.length - 1;
		while (i < j) {
			if (a[i] == 0)
				i++;
			if (a[j] == 1)
				j--;
			if (a[i] == 1 && a[j] == 0) {
				AlgoUtils.swap(a, i, j);
				i++;
				j--;
			}
		}
	}

	@Override
	public void sortByfriquency(int a[]) {

		if (a == null || a.length == 0 || a.length == 1)
			return;
		int max = a[0];
		int k = 0;
		for (int i = 1; i < a.length; i++) {
			if (max < a[i])
				max = a[i];
		}

		int b[] = new int[max + 1];
		for (int i = 0; i < a.length; i++)
			b[a[i]]++;

		max = b[0];
		for (int i = 1; i < b.length; i++) {
			if (max < b[i])
				max = b[i];
		}

		for (int i = 1; i <= max; i++) {
			for (int j = 0; j < b.length; j++) {
				if (i == b[j]) {
					for (int l = 0; l < i; l++)
						a[k++] = j;
				}
			}
		}
	}

	/** 10. Count Inversions in an array | Set 1 (Using Merge Sort) **/
	/// @See @IStandardAlgo.java 9.
	/** 11. Two elements whose sum is closest to zero **/
	public int[] sumCloseToZero(int a[]) {
		// combination of max,min +ve/-ve
		int rs[] = new int[2];
		Arrays.sort(a);
		if (a[0] > 0) // ie all no are +ve
		{
			rs[0] = a[0];
			rs[1] = a[1];
			return rs;
		}

		int i = 0;
		int j = a.length;
		while (i < j && a[i] < 0)
			i++;

		// min -ve and max +ve combination
		int min = Math.abs(a[0] + a[a.length - 1]);
		rs[0] = a[0];
		rs[1] = a[a.length - 1];
		// max -ve and min +ve combination
		if (Math.abs(a[i - 1] + a[i]) < min) {
			min = a[i - 1] + a[i];
			rs[0] = a[i - 1];
			rs[1] = a[i];
		}
		// min -ve and min +ve combination
		if (Math.abs(a[0] + a[i]) < min) {
			rs[0] = a[0];
			rs[1] = a[i];
		}
		// max -ve and max +ve combination
		if (Math.abs(a[i - 1] + a[a.length - 1]) < min) {
			rs[0] = a[i - 1];
			rs[1] = a[a.length - 1];
		}
		return rs;
	}

	/** 12. Shortest Un-ordered Subarray **/
	@Override
	public int unOrderedLen(int a[]) {

		int n = a.length;
		int b[] = new int[n];
		for (int i = 0; i < n; i++)
			b[i] = a[i];

		Arrays.sort(b);
		int i = 0;
		int j = a.length - 1;

		for (; i < n; i++) {
			if (a[i] != b[i])
				break;

		}
		for (; j >= 0; j--) {
			if (a[j] != b[j])
				break;
		}
		return j - i + 1;
	}

	public int minSwapForSortX(int a[]) {
		int count = 0;
		int i = 0;
		int n = a.length;
		int b[] = new int[n];
		for (i = 0; i < n; i++)
			b[i] = a[i];

		Arrays.sort(b);
		i = 0;

		for (; i < n; i++) {
			if (a[i] != b[i])
				break;
		}
		i = 0;
		while (i < n) {
			if (a[i] != b[i])
				count++;
		}
		return count;
	}

	/** 13. Minimum number of swaps required to sort an array **/
	@Override
	public int minSwapForSort(int a[]) {
		int N=a.length, count=0;
		int temp[] = new int[N];
		temp = Arrays.copyOf(a,N);
		Arrays.sort(temp);
		for (int i=0;i<a.length;i++)
		{
			if(temp[i]!=a[i])
			{
				AlgoUtils.swap(a,i, ArraysUtil.getIndex(a,temp[i]));
				count++;
			}
		}
		return count;
	}

	/* 14. Union and Intersection of two sorted arrays */
	@Override
	public List<Integer> unionOfArrays(int[] a, int[] b){
		List<Integer> list = new ArrayList<>();
		int i=0, j=0, M=a.length, N=b.length;
		while (i<M && j<N)
		{
			if(a[i]<b[j])
				list.add(a[i++]);
			else if(b[j]<a[i])
				list.add(b[j++]);
			else {
				list.add(a[i++]);
				j++;
			}
		}
		while (i<M)
			list.add(a[i++]);
		while (j<N)
			list.add(b[j++]);
		return list;
	}

	@Override
	public List<Integer>intersectionOfArrays(int a[], int b[]){
		List<Integer> list = new ArrayList<>();
		int i=0, j=0, M=a.length, N=b.length;
		while (i<M && j<N)
		{
			if(a[i]<b[j])
				i++;
			else if(b[j]<a[i])
				j++;
			else {
				list.add(a[i++]);
				j++;
			}
		}
		return list;
	}

	/* 15. Find Union and Intersection of two unsorted arrays */
	@Override
	public List<Integer> unionOfUnSortedArrays(int[] a, int[] b){
		int M=a.length, N=b.length, X = ArraysUtil.getMax(a), Y = ArraysUtil.getMax(b);
		int c[]= new int[X > Y ? X+1 : Y+1];
		List<Integer> unList = new ArrayList<>();
		for(int i =0 ;i< (M>N ? M : N) ;i++)
		{
			if(i<M)
				c[a[i]]++;
			if(i<N)
				c[b[i]]++;
		}
		for(int i=0;i< c.length;i++)
		{
			if(c[i]!=0)
				unList.add(i);
		}
		return unList;
	}

	@Override
	public List<Integer> intersectionOfUnSortedArrays(int a[], int b[]){
		int M=a.length, N=b.length, X = ArraysUtil.getMax(a), Y = ArraysUtil.getMax(b);
		int c[]= new int[X > Y ? X+1 : Y+1];
		List<Integer> intList = new ArrayList<>();
		for(int i =0 ;i< (M>N ? M : N) ;i++)
		{
			if(i<M)
				c[a[i]]++;
			if(i<N)
				c[b[i]]++;
		}
		for(int i=0;i< c.length;i++)
		{
			if(c[i]>1)
				intList.add(i);
		}
		return intList;
	}

	/* 16. Sort an array of 0s, 1s and 2s */
	@Override
	public List<Integer> sort0s1s2s3s(int a[]){
		List<Integer> list = new ArrayList<>();
		int x[] = new int[4];
		for (int i=0;i<a.length;x[a[i]]++,i++);
		for(int i=0;i<x.length;i++)
		{
			int j=0;
			while (j++<x[i])
				list.add(i);
		}
		return list;
	}
	/*
	 * 17. Find the Minimum length Unsorted Subarray, sorting which makes the
	 * complete array sorted
	 */
	@Override
	public int minLenUnSortedSubArray(int a[]){
		int N = a.length, x=0, y=0;
        int temp[] = new int[N];
		temp = Arrays.copyOf(a, N);
		Arrays.sort(temp);
		for(int i=0;i<N;i++)
		{
			if(a[i]!=temp[i])
			{
				x=i;
				break;
			}
		}
		for(int i=N-1;i>=0;i--)
		{
			if(a[i]!=temp[i])
			{
				y=i;
				break;
			}
		}
		return y-x+1;
	}
	/* 18. Median in a stream of integers (running integers),Median of Stream of Running Integers using STL */
	@Override
	public double[] medianInStream(int a[])
	{
        int N = a.length;
		float sum=0f;
          double[] f = new double[N];
		  for ( int i=0;i<N; i++)
		  {
			  sum+=a[i];
			  f[i] = sum/(i+1);
		  }
		  return f;
	}
	/* 19. Count the number of possible triangles */
	@Override
	public List<List<Integer>> possibleTriangles(int a[]){
        List<List<Integer>> ll = new ArrayList<>();
        int N = a.length;
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++)
                    if (a[i] + a[j] > a[k]) {
                        ll.add(List.of(a[i],a[j],a[k]));
                    }
        return ll;
	}

    /* 20. Find number of pairs (x, y) in an array such that x^y > y^x */
    public int pairOfXY(int x[], int y[])
    {
        if(x.length==0 || y.length==0)
            return 0;
        if(x.length==1)
        {
            int count=0;
            for(int y1:y)
            {
                if(x[0] > y1) {
                    System.out.println(x[0]+ ", "+y1);
                    count++;
                }
            }
            return count;
        }
        if(y.length==1)
        {
            int count=0;
            for(int x1:x)
            {
                if(x1 > y[0]) {
                    System.out.println(x1+ ", "+y[0]);
                    count++;
                }
            }
            return count;
        }
        int count=0;
        int[] X_left
            = Arrays.copyOfRange(x, 0, x.length / 2);
        int[] X_right
            = Arrays.copyOfRange(x, x.length / 2, x.length);
        int[] Y_left
            = Arrays.copyOfRange(y, 0, y.length / 2);
        int[] Y_right
            = Arrays.copyOfRange(y, y.length / 2, y.length);
        count+=pairOfXY(X_left, Y_left);
        count+=pairOfXY(X_left, Y_right);
        count+=pairOfXY(X_right, Y_left);
        count+=pairOfXY(X_right, Y_right);
        return count;
    }

}
