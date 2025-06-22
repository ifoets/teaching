package com.leetcode.algorithms.array.medium;

import com.leetcode.algorithms.array.LeetCodeArrayUtils;

import java.util.*;
import java.util.stream.IntStream;

public class ArrayMediumImpl implements IArrayMedium{

    /** 11. Container With Most Water*/
    @Override
    public int maxArea(int[] height){
        int N = height.length;
        int i=0;
        int maxArea = 0,j=N-1;

        while (i<j)
        {
            int maxCurrent= Math.min(height[i],height[j])*Math.abs(j-i);
            maxArea = Math.max(maxArea, maxCurrent);
            if(height[i]<height[j])
                i++;
            else if(height[i]>=height[j])
                j--    ;
        }
        return maxArea;
    }

    /**
     * 15. 3Sum
     * take two i,i+1 and one j and next take one i and two j, j-1
     * O(n)+O(n)=O(n)*/
    @Override
    public List<List<Integer>> threeSum(int[] arr){

        // Map to store indices for each value
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        if(arr.length>500) {//for big size highly repetitive items
            arr = Arrays.stream(arr).distinct().toArray();
            if(arr.length<100) {
                List<Integer> list1 = Arrays.stream(Arrays.stream(arr).toArray()).boxed().toList();
                List<Integer> ll = new ArrayList<>();
                ll.addAll(list1);
                ll.addAll(list1);
                ll.addAll(list1);
                arr = new int[ll.size()];
                int i = 0;
                while (i < ll.size())
                    arr[i] = ll.get(i++);
            }
        }
        arr = Arrays.stream(arr).sorted().toArray();
        // Resultant list
        List<List<Integer>> ans = new ArrayList<>();

            // Check for all pairs i, j
            for (int j = 0; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    // Value of third index should be
                    int val = -1 * (arr[j] + arr[k]);
                    // If such indices exist
                    if (map.containsKey(val)) {
                        // Append the i, j, k
                        for (int i : map.get(val)) {
                            ans.add(Arrays.asList(arr[i], arr[j], arr[k]).stream().sorted().toList());
                        }
                    }
                }

                // After j'th index is traversed
                // We can use it as i.
                map.putIfAbsent(arr[j], new ArrayList<>());
                map.get(arr[j]).add(j);
            }
        return ans.stream().distinct().toList();
    }

    @Override
    public List<List<Integer>> threeSumX(int[] arr){

        List<List<Integer>> ans = new ArrayList<>();
        // Map to store indices for each value
       HashMap<Integer, List<Integer>> map1 = new HashMap<>();
       arr = LeetCodeArrayUtils.transformArray(arr,3);//three sum sumCount=3
        // Check for all pairs i, j
        for (int j = 0; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                // Value of third index should be
                int val = -1 * (arr[j] + arr[k]);
                // If such indices exist
                if (map1.containsKey(val)) {
                    // Append the i, j, k
                    for (int i : map1.get(val)) {
                        ans.add(Arrays.asList(arr[i], arr[j], arr[k]).stream().sorted().toList());
                    }
                }
            }
            // After j'th index is traversed
            // We can use it as i.
            map1.putIfAbsent(arr[j], new ArrayList<>());
            map1.get(arr[j]).add(j);
        }
        return ans.stream().distinct().toList();
    }
    /**16. 3Sum Closest*/
    @Override
    public int threeSumClosest(int[] arr, int target){
        if(arr.length>500) //for breaking the time complexity of big array having repetitive data
        {
            arr = LeetCodeArrayUtils.transformArray(arr, 3);//three sum/target sumCount=3
        }
        int ans = arr[0] + arr[1] + arr[2];
        //keep sum of two and their indexes in map using O(n2) n is reduced from of array length
        Map<Integer,List<Integer>> map = new HashMap<>();
        int N= arr.length;
        for(int i=0;i<N;i++)
        {
            for(int j=i+1;j<N;j++)
            {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(j);
                map.put(arr[i]+arr[j],list);
            }
        }
        for(int i=0;i<N;i++) {
            for (Map.Entry<Integer, List<Integer>> set : map.entrySet()) {
                if(!set.getValue().contains(i)) {
                    int sum = set.getKey() + arr[i];
                    if (sum == target)
                        return sum;
                    if (Math.abs(sum-target) < Math.abs(ans-target)) {
                        ans=sum;
                    }
                }
            }
        }
        return ans;
    }
    @Override
    public int threeSumClosestX(int[] nums, int target) {
        if(nums.length>500)//for breaking the time complexity of big array having repetitive data
            nums = LeetCodeArrayUtils.transformArray(nums,4);
        int ans = nums[0] + nums[1] + nums[2] + nums[3];

        Arrays.sort(nums);

        for (int i = 0; i + 2 < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // Choose nums[i] as the first number in the triplet, then search the
            // remaining numbers in [i + 1, n - 1].
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                final int sum = nums[i] + nums[l] + nums[r];
                if (sum == target)
                    return sum;
                if (Math.abs(sum - target) < Math.abs(ans - target))
                    ans = sum;
                if (sum < target)
                    ++l;
                else
                    --r;
            }
        }
        return ans;
    }
    @Override
    /**18. 4Sum*/
    public List<List<Integer>> fourSum(int[] nums, int target){
        Arrays.sort(nums);
        if(nums.length<4)
            return new ArrayList<>();
        List<List<Integer>> rs = new ArrayList<>();
        long ans = (long)nums[0] + nums[1] + nums[2] + nums[3];
        if(ans==target)
        {
            rs.add(Arrays.asList(nums[0], nums[1], nums[2],nums[3]).stream().sorted().toList());
        }

        for (int i = 0; i + 3 < nums.length; ++i) {
            if (i> 0 && nums[i] == nums[i-1]) continue;

            for(int j=i+1;j+2<nums.length;++j) {
                if (j >i+1 && nums[j] == nums[j-1]) continue;

                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    final long sum = (long)nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        rs.add(Arrays.asList(nums[i], nums[j], nums[l],nums[r]).stream().sorted().toList());
                    }
                    if (Math.abs(sum - target) < Math.abs(ans - target))
                        ans = sum;
                    if (sum < target)
                        ++l;
                    else
                        --r;
                }
            }
        }
        return rs.stream().distinct().toList();
    }

    /**31. Next Permutation*/
    @Override
    public void nextPermutation(int[] nums){

        int N=nums.length;
        int pivot=-1;
        //find index from end were i+1>i
        for(int i=N-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }
        // If pivot point does not exist, reverse the whole array
        if (pivot == -1) {
            LeetCodeArrayUtils.reverse(nums, 0, N - 1);
            return ;
        }
        //find first big element from right to pivot element
        for(int i=N-1;i>pivot;i--)
        {
            if(nums[pivot]<nums[i])
            {
                LeetCodeArrayUtils.swap(nums,i,pivot);
                break;
            }
        }
        //reverse element from pivot+1 to end
        LeetCodeArrayUtils.reverse(nums,pivot+1,N-1);
    }
    @Override
    public void permutationLexicalOrder(List<List<Integer>> list, int nums[], int idx)
    {
        if(idx==nums.length) {
            list.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for(int l=idx;l<nums.length;l++)
        {
            LeetCodeArrayUtils.rightRotate(nums,idx,l);
            permutationLexicalOrder(list,nums,idx+1);
            LeetCodeArrayUtils.leftRotate(nums,idx,l);
        }
    }
    /**33. Search in Rotated Sorted Array */
    @Override
    public int search(int[] nums, int target){
        int pivot=pivotSortedRotatedArray(nums,0, nums.length-1);
        if(pivot==-1)
            return binarySearch(nums,0,nums.length-1,target);
        else if(nums[pivot]<=target && target<=nums[nums.length-1])
            return binarySearch(nums,pivot,nums.length-1,target);
        return binarySearch(nums,0,pivot-1,target);
    }

    public static int pivotSortedRotatedArray(int[] nums, int l, int r){

        if(r-l==1 && nums[l]>nums[r])
            return r;
        int mid = (l+r)/2;
        while (l<r)
        {
            if(mid-1>=0&& nums[mid-1]>nums[mid])
                return mid;
            else if(nums[l]<nums[mid])
                return pivotSortedRotatedArray(nums,mid,r);
            else return pivotSortedRotatedArray(nums, l,mid);
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int l, int r, int target){

        int mid = (l+r)/2;
        while (l<=r)
        {
            if(nums[mid]==target)
                return mid;
            else if(target>nums[mid])
                return binarySearch(nums,mid+1,r,target);
            else return binarySearch(nums, l,mid-1, target);
        }
        return -1;
    }

    /**34. Find First and Last Position of Element in Sorted Array**/
    public int[] searchRange(int[] nums, int target){

        int []rs = {-1,-1};
        int []resultArr = IntStream.range(0,nums.length).filter( i-> nums[i]==target).toArray();
        if(resultArr.length==0)
            return rs;
        if(resultArr.length==1) {
            rs[1]=rs[0] = resultArr[0];
        }
        else {
            rs[0] = resultArr[0];
            rs[1] = resultArr[resultArr.length - 1];
        }
        return rs;
    }
    public int[] searchRangeX(int[] nums, int target){
       int []rs = new int[2];
        rs[0]=LeetCodeArrayUtils.binarySearchFirstIndex(nums,0,nums.length-1, target);
        rs[1]=LeetCodeArrayUtils.binarySearchLastIndex(nums,0,nums.length-1, target);
        return rs;

    }

    /**36. Valid Sudoku*/
    @Override
    public boolean isValidSudoku(char[][] board){

        int N = board.length;
        HashSet<Character>[] rows = new HashSet[N];
        HashSet<Character>[] cols = new HashSet[N];
        HashSet<Character>[] boxes = new HashSet[N];

        for (int i = 0; i < N; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                char value = board[r][c];
                int boxIndex = (r / 3) * 3 + (c / 3);

                if (rows[r].contains(value) || cols[c].contains(value) || boxes[boxIndex].contains(value)) {
                    return false;
                }

                rows[r].add(value);
                cols[c].add(value);
                boxes[boxIndex].add(value);
            }
        }

        return true;
    }

}
