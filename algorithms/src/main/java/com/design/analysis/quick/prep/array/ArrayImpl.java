package com.design.analysis.quick.prep.array;

import com.design.analysis.core.algo.utils.AlgoUtils;

import java.util.*;

public class ArrayImpl implements  IArray{

    /* Array */
    /*
     * Question 10 : Write java Program to Find Smallest and Largest Element in an
     *
     * Array.
     */
    @Override
    public int[] smallestLagest(int a[]) {

        int b[] = new int[2];
        b[0] = Integer.MAX_VALUE;
        b[1] = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            // for min
            if (b[0] > a[i])
                b[0] = a[i];
            if (b[1] < a[i])
                b[1] = a[i];
        }
        return b;
    }

    /*
     * Question 11 : Find missing number in the array.
     */
    @Override
    public int missingNo(int a[]) {
        int n = a.length;
        int N = n + 1;// one is missing
        int sum = 0;
        for (int i = 0; i < n; sum += a[i++])
            ;
        return (int) (N * (N + 1) / 2 - sum);
    }

    /*
     * Question 12 : Search an element in rotated and sorted array.
     */
    @Override
    public int elemInSortedRotatedArr(int a[], int key) {

        int n = a.length;
        int pvt = findPivot(a, 0, n - 1);
        if (pvt == -1)
            binSearch(a, key, 0, n - 1);
        ;
        if (key == a[pvt])
            return pvt;
        if (a[0] < key)
            return binSearch(a, key, 0, pvt);
        return binSearch(a, key, pvt + 1, n - 1);

    }

    public int findPivot(int a[], int l, int r) {
        if (l > r)
            return -1;
        if (l == r)
            return l;
        int m = (l + r) / 2;

        if (l < m && a[m] < a[m - 1])
            return m - 1;
        if (m < r && a[m + 1] < a[m])
            return m;
        if (a[l] >= a[m])
            return findPivot(a, l, m - 1);
        return findPivot(a, m + 1, r);

    }

    public int binSearch(int a[], int key, int l, int r) {
        if (l > r)
            return -1;
        else {
            int m = (l + r) / 2;
            if (key == a[m])
                return m;
            else if (key > a[m])
                return binSearch(a, key, m + 1, r);
            return binSearch(a, key, l, m - 1);
        }
    }

    /*
     * public Question 13 : Find minimum element in a sorted and rotated array.
     */
    @Override
    public int minSortedRotatedArr(int a[]) {

        int pvt = findPivot(a, 0, a.length - 1);
        return pvt == -1 ? a[0] : a[pvt + 1];
    }

    /*
     * Question 14: Find second largest number in an array Question xth largest
     * means n-x smallest
     */
    @Override
    public int nLargest(int a[], int x) {

        for (int i = 0; i < x; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a[x - 1];
    }

    /*
     * *15 : Find the number occurring odd number of times in an array Question in
     * single traverse
     */
    @Override
    public int oddNumsInArr(int a[]) {
        int xor = 0;
        for (int i : a) {
            xor = xor ^ i;
        }
        return xor;
    }

    /*
     * 16 : Find minimum number of platforms required for railway station
     */
    public int minNoOfPlatform(int a[], int d[]) {
        // no meaning which train arr and which train departure
        int n = a.length;
        Arrays.sort(a);
        Arrays.sort(d);
        int plt = 1;
        int i = 1;
        int j = 0;
        int result = 1;

        while (i < n && j < n) {
            if (a[i] <= d[j]) {
                plt++;
                i++;
            } else if (a[i] > d[j]) {
                plt--;
                j++;
            }
            if (plt > result)
                result = plt;
        }
        return result;
    }

    /*
     * Question 17 : Find a Pair Whose Sum is Closest to zero in Array Question
     */
    @Override
    public int pariSumCloestToZero(int a[]) {

        // nlogn
        Arrays.sort(a);
        int l = 0;
        int r = a.length;
        int minSum = Integer.MAX_VALUE;

        while (l < r) {
            int sum = a[l] + a[r - 1];
            if (Math.abs(minSum) > Math.abs(sum)) {
                minSum = sum;
            }
            if (sum < 0)
                l++;
            else
                r--;
        }
        return minSum;
    }

    // clogest to zero the triple
    @Override
    public int tripleSumCloestToZero(int a[]) {
        // nlog(n)
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(a);
        int minSum = Integer.MAX_VALUE;
        int l = 0;
        int r = a.length - 1;
        int x, y, z;
        x = y = z = 0;

        // O(n)
        while (l <= r) {
            int sum = a[l] + a[r];
            if (Math.abs(minSum) > Math.abs(sum)) {
                minSum = sum;
                x = l;
                y = r;
            }
            if (sum < 0)
                l++;
            else
                r--;
        }
        System.out.println(a[x]);
        System.out.println(a[y]);
        // O(n)
        int nextMinSum = Integer.MAX_VALUE;
        for (int i = 1; i < a.length; i++) {
            if (i != x && i != y) {
                int sum = minSum + a[i];
                if (Math.abs(nextMinSum) > Math.abs(sum)) {
                    nextMinSum = sum;
                    z = i;
                }
            }
        }
        map.put(x, a[x]);
        map.put(y, a[y]);
        map.put(z, a[z]);
        System.out.println(map);
        return a[x] + a[y] + a[z];
    }

    /*
     * 18 : Given a sorted array and a number x, find the pair in array whose sum is
     * closest to x
     */
    @Override
    public int[] pairClogest(int a[], int x) {
        // if array is not sorted Arrays.sort(a)
        int rs[] = new int[2];
        int l = 0;
        int r = a.length - 1;
        int minSum = Integer.MAX_VALUE;

        int n1 = 0;
        int n2 = 0;
        while (l <= r) {
            int sum = Math.abs(a[l] + a[r]);
            if (minSum > Math.abs(sum - x)) {
                n1 = a[l];
                n2 = a[r - 1];
                minSum = Math.abs(sum - x);
            }
            if (sum - x < 0)
                l++;
            else
                r--;
        }
        rs[0] = n1;
        rs[1] = n2;
        return rs;
    }

    /*
     * Question 19 : Find all pairs of elements from an array whose sum is equal to
     * given number
     */
    @Override
    public Map<Integer, Integer> pairSumOfX(int a[], int x) {
        Arrays.sort(a);
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int sum = a[l] + a[r];
            if (x == sum) {
                map.put(a[l], a[r]);
            }
            if (sum - x < 0)
                l++;
            else
                r--;
        }
        return map;
    }

    /*
     * Question 20: Given an array of 0’s and 1’s in random order, you need to
     * separate 0’s and 1’s in an array.
     */
    @Override
    public void seperate01(int a[]) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            if (a[l] == 1 && a[r] == 0) {
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
            }
            if (a[l] == 0)
                l++;
            if (a[r] == 1)
                r--;
        }
    }

    /*
     * Question 21 : Separate odd and even numbers in an array Question 22
     */
    @Override
    public void seperateOddEven(int a[]) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            if (a[l] % 2 == 0 && a[r] % 2 == 1) {
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
            }
            if (a[l] % 2 == 1)
                l++;
            if (a[r] % 2 == 0)
                r--;
        }
    }

    /*
     * : Given an array containing zeroes, ones and twos only. Write a function to
     * sort the given array in O(n) time complexity.
     */
    @Override
    public void sort012(int a[], int n) {
        int x[] = new int[n];
        for (int i : a) {
            x[i]++;
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            while (x[i]-- > 0)
                a[k++] = i;
        }
    }

    /*
     * Question 23 : Find local minima in array
     */
    @Override
    public int localMinima(int a[], int l, int r, int n) {

        int mid = (l + r) / 2;

        if (mid == 0 || a[mid - 1] > a[mid] && a[mid] < a[mid + 1] || mid == n - 1)
            return a[mid];
        else if (mid > 0 && a[mid - 1] < a[mid])
            return localMinima(a, l, mid - 1, n);
        return localMinima(a, mid + 1, r, n);
    }

    /*
     * Question 24 : Sliding window maximum in java Question
     */
    @Override
    public List<Integer> slidingWindowMax(int a[], int k) {

        List<Integer> list = new ArrayList<>();
        int n = a.length;

        for (int i = 0; i <= n - k; i++) {
            int max = a[i];
            for (int j = 1; j < k; j++) {
                if (max < a[i + j])
                    max = a[i + j];
            }
            list.add(max);
        }
        return list;
    }

    /*
     * 25 : Count number of occurrences (or frequency) of each element in a sorted
     * array
     */
    @Override
    public int frequencyOfItems(int a[], int k) {

        int freq = 0;
        int index = binSearch(a, k, 0, a.length - 1);
        if (index < 0)
            return 0;
        int i = index;
        while (i < a.length && a[i++] == a[index])
            freq++;
        i = index;
        while (i >= 0 && a[i--] == a[index])
            freq++;
        // 2 extra get added in first comparison
        return freq - 1;

    }

    /* Question 29 : Count 1’s in sorted Binary Array. */

    public int binSearchBinary(int a[], int key, int l, int r) {
        if (l > r)
            return -1;
        else {
            int m = (l + r) / 2;
            if (key == a[m])
                return m;
            // for increasing
            return binSearch(a, key, m + 1, r);
            // for decreasing arr
            // return binSearch(a, key, l, m-1);
        }
    }

    @Override
    public int count1sInSortedBinaryArr(int a[]) {
        int freq = 0;
        int index = binSearchBinary(a, 1, 0, a.length - 1);
        if (index < 0)
            return 0;
        int i = index;
        while (i < a.length && a[i++] == a[index])
            freq++;
        i = index;
        while (i >= 0 && a[i--] == a[index])
            freq++;
        // 2 extra get added in first comparison
        return freq - 1;
    }

    /* Question 30 : Find first repeating element in an array of integers. */
    @Override
    public int firstRepetating(int a[]) {
        Set<Integer> set = new HashSet<>();
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i]))
                l.add(a[i]);
            else
                set.add(a[i]);
        }
        for (Integer x : l) {
            for (int i = 0; i < a.length; i++) {
                if (x == a[i])
                    return x;
            }
        }
        return -1;
    }

    @Override
    public int firstMinMaxRpetation(int a[], int minMax) {
        int n = a.length;
        int max = a[0];
        for (int i = 1; i < n; i++) {
            if (max < a[i])
                max = a[i];
        }
        int b[] = new int[max + 1];
        for (int i = 0; i < n; b[a[i++]]++)
            ;
        if (minMax == 0) {
            for (int i = 0; i <= max; i++) {
                if (b[i] > 1)
                    return i;
            }
        } else {
            for (int i = max; i >= 0; i--) {
                if (b[i] > 1)
                    return i;
            }
        }
        return -1;
    }

    /* Question 31 : Check if Array Elements are Consecutive. */
    @Override
    public boolean checkConsecutive(int a[]) {
        int n = a.length;
        int min = a[0];
        int max = a[0];

        for (int i = 1; i < n; i++) {
            if (max < a[i])
                max = a[i];
            if (min > a[i])
                min = a[i];
        }
        int b[] = new int[max - min + 1];
        for (int i = 0; i < b.length; b[a[i++] - min]++)
            ;
        for (int j = 0; j < b.length - 1; j++) {
            if (b[j] != 1)
                return false;
        }
        return true;
    }

    /* Question 32 : Permutations of array in java. */
    @Override
    public void permutation(List<Integer> arr, int k) {

        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permutation(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
    }

    /* Question 33 : Rotate an array by K positions. */
    public void reverse(int a[], int l, int r) {
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    @Override
    public void rotateKpos(int a[], int k) {

        int r = a.length - 1;
        int d = r - k;
        reverse(a, 0, d);
        reverse(a, d + 1, r);
        reverse(a, 0, r);
    }

    /* Question 34 : Stock Buy Sell to Maximize Profit. */
    @Override
    public int stockSellMaxPofit(int a[]) {
        return -1;
    }
    /*Question 41 :
     * Two sorted array a1 and a2 a2 have some element and exttra space of size a1
     * sort without extra space and complexity n arr1 m [3,4,9,10,20] arr2 n with m
     * space [ ,1,2, ,8,11, ,13, , ]
     */
    @Override
    public void specialSort(int a[], int b[]){

        // shift all zero of b to left as keep sorted order
        int N = b.length - 1;
        int k = N;
        int i = N;
        while (i > 0) {
            while (b[k] != 0)
                k--;
            while (i > 0 && b[i] == 0)
                i--;
            if (k > 0 && i > 0) {
                b[k] = b[i];
                b[i] = 0;
            }
        }
        // k is the last zero in b
        i = 0;
        int j = k + 1;
        int t = 0;
        while (i < a.length && j < N + 1 && t < N + 1) {
            if (a[i] > b[j]) {
                b[t] = b[j];
                b[j] = 0;
                t++;
                j++;
            } else {
                b[t] = a[i];
                t++;
                i++;
            }
        }
        if (j >= N) {
            while (i < a.length)
                b[t++] = a[i++];
        }
        System.out.println(Arrays.toString(b));
    }





}
