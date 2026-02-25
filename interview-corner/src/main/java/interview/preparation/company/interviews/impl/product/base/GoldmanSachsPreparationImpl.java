package interview.preparation.company.interviews.impl.product.base;

import interview.preparation.company.interviews.question.product.base.IGoldmanSachsPreparation;
import org.checkerframework.checker.units.qual.Temperature;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GoldmanSachsPreparationImpl implements IGoldmanSachsPreparation {

    /**Find the missing number from a list of numbers from 1 to N in a sequence**/
    @Override
    public int missingNo(int[] a){

        int left =0;
        int right=a.length-1;

        while (left<right)
        {
            int mid=(left+right)/2;
            if(a[mid]==mid+2)
                return mid+1;
            if(a[mid]==mid+1)
                left=mid+1;
            else right = mid-1;
        }
        return -1;
    }

    @Override
    public int lenOfLongestSubStr(int[] nums,int k){
        int start=0,end=0;
        int sum=0;
        int max=0;
        int x=0;
        int y=0;
        while (end<nums.length)
        {
            sum+=nums[end];
            while (sum>k)
                sum-=nums[start++];
            max = Math.max(max, end - start + 1);
            x=start;
            y=end;
            end++;
        }
        System.out.println(x+", "+y);
        return max;
    }
    /**34. Find First and Last Position of Element in Sorted Array**/
    @Override
    public int[] searchRange(int[] nums, int target){
      return new int[]{findLeft(nums,target),findRight(nums,target)};
    }
    public int findLeft(int[] nums, int target)
    {
        int l=0, r=nums.length-1;
        int ans=-1;
        while (l<=r)
        {
            int mid=(l+r)/2;
           if(nums[mid]==target)
           {
               ans=mid;
               r=mid-1;
           }else if(nums[mid]<target)
               l=mid+1;
           else r=mid-1;
        }
        return ans;

    }
    public int findRight(int[] nums,int target)
    {
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid =(l+r)/2;

            if (nums[mid] == target) {
                ans = mid;       // record candidate
                l = mid + 1;    // move right to find later occurrence
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**33. Search in Rotated Sorted Array**/
    @Override
    public int indexOfInRotatedArr(int[]nums,int target){
        int l = 0, r = nums.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid =(l+r)/2;

            if (nums[mid] == target) {
                return mid;
            }
           //if left half sorted
            if(nums[l]<=nums[mid])
            {
                if(nums[l]<=target && target<nums[mid])
                    r=mid-1; //target in left sorted half
                else l=mid+1; //// target in right half
            }
            //right hafl is sorted
            else {
                if(nums[mid]<target && target<=nums[r])
                    l=mid+1;
                else r=mid-1; //// target in left half
            }
        }
        return ans;
    }

    /**81. Search in Rotated Sorted Array II**/
    @Override
    public boolean searchInRotatedDuplicateValArr(int[] nums, int target){
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid =(l+r)/2;

            if (nums[mid] == target) {
                return true;
            }
            // Ambiguous case due to duplicates
            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l++;
                r--;
            }
            else if(nums[l]<=nums[mid])
            {
                if(nums[l]<=target && target<nums[mid])
                    r=mid-1; //target in left sorted half
                else l=mid+1; //// target in right half
            }
            //right hafl is sorted
            else {
                if(nums[mid]<target && target<=nums[r])
                    l=mid+1;
                else r=mid-1; //// target in left half
            }
        }
        return false;
    }
    /**162. Find Peak Element**/
    @Override
    public int findPeakElement(int[] nums){
        int l=0,r=nums.length-1;

        while (l<=r)
        {
            int mid=(l+r)/2;
            if(l==r)return l;
            if(nums[mid]<nums[mid+1])
                l=mid+1;
            else r=mid; //mid itself can be the peak
        }
        return -1;
    }
    /**875. Koko Eating Bananas**/
    @Override
    public int minEatingSpeed(int[] piles, int h){
        int low = 1;
        int high = 0;

        for (int p : piles) {
            high = Math.max(high, p);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatAll(piles, h, mid)) {
                ans = mid;        // try slower speed
                high = mid - 1;
            } else {
                low = mid + 1;   // need faster speed
            }
        }
        return ans;
    }
    private boolean canEatAll(int[] piles, int h, int k)
    {
        long hours = 0;  // long to avoid overflow

        for (int p : piles) {
            hours += Math.ceilDiv(p,k);
            if (hours > h) return false;
        }
        return hours <= h;
    }

    /**1011. Capacity To Ship Packages Within D Days**/
    @Override
    public int shipWithinDays(int[] weights, int days){
        int low = 0, high = 0;

        for (int w : weights) {
            low = Math.max(low, w);  // minimum capacity
            high += w;               // maximum capacity
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;          // try smaller capacity
                high = mid - 1;
            } else {
                low = mid + 1;      // need bigger ship
            }
        }

        return ans;
    }
    private boolean canShip(int[] weights, int days, int cap) {
        int usedDays = 1;
        int currentLoad = 0;

        for (int w : weights) {
            if (currentLoad + w > cap) {
                usedDays++;
                currentLoad = w;
                if (usedDays > days) return false;
            } else {
                currentLoad += w;
            }
        }
        return true;
    }
    /**1283. Find the Smallest Divisor Given a Threshold
     //int smallestDivisor(int[] nums, int threshold);

     /**1482. Minimum Number of Days to Make m Bouquets*/
    @Override
    public int minDays(int[] bloomDay, int m, int k){
        //m*k totol no of flower required
        if((m*k)>bloomDay.length)return -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int b:bloomDay)
        {
            low = Math.min(low,b);
            high = Math.max(high,b);
        }
        int ans = -1;
        while (low<=high)
        {
            int mid =(low+high)/2;

            if(canMakeBouquets(bloomDay,m,k,mid))
            {
                ans=mid;
                high=mid-1;//try ealier
            }
            else low=mid+1;//need more day
        }
        return ans;
    }
    public boolean canMakeBouquets(int[] boomDays,int m,int k,int day)
    {
        int bouquets = 0;
        int consecutive = 0;
        for(int boomday:boomDays)
        {
            if(day>=boomday) {
                consecutive++;
                if(consecutive==k)
                {
                    bouquets++;
                    consecutive=0;
                    if(bouquets>=m)
                        return true;
                }
            }
            else consecutive=0;

        }
        return bouquets>=m;
    }

    /**167. Two Sum II - Input Array Is Sorted, it is 1 based indexed**/
    public int[] twoSum(int[] numbers, int target){
        int low=0,high=numbers.length-1;

        while (low<=high)
        {
            int sum= numbers[low]+numbers[high];
            if(sum==target)
                return new int[]{low+1,high+1};//=1, since 1 based indexed
            if(sum<target)
                low++;
            else high--;
        }
        return new int[]{}; // guaranteed one solution as per problem
    }
    /**125. Valid Palindrome**/
    @Override
    public boolean isPalindrome(String s){
        int l = 0, r = s.length() - 1;

        while (l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);

            if (!Character.isLetterOrDigit(left)) {
                l++;
            } else if (!Character.isLetterOrDigit(right)) {
                r--;
            } else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
    /**74. Search a 2D Matrix, O(log(m * n))**/
    @Override
    public boolean searchMatrix(int[][] matrix, int target){
        int m=matrix.length;
        int n=matrix[0].length;
        int low=0,high=m*n-1;
        while (low<=high)
        {
            int mid =(low+high)/2;
            //this r,c follow 0,1,2,3,,,in series form 0 to m*n-1;
            int r=mid/n;
            int c=mid%n;

            int val=matrix[r][c];
            if(val==target)return true;
            else if(val<target)
                low=mid+1;
            else high=mid-1;
        }
    return false;
    }

    /**283. Move Zeroes**/
    @Override
    public void moveZeroes(int[] nums){
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // swap only when fast != slow to reduce unnecessary writes
                if (slow != fast) {
                    int temp = nums[slow];
                    nums[slow] = nums[fast];
                    nums[fast] = temp;
                }
                slow++;
            }
        }
    }

    /**763. Partition Labels**/
    @Override
    public List<Integer> partitionLabels(String s){
        List<Integer> rsList = new ArrayList<>();

       int[] lastIndex = new int[26];
       for(int i=0;i<s.length();i++)
           lastIndex[s.charAt(i)-'a']=i;

       int start=0,end=0;

       for(int i=0;i<s.length();i++)
       {
           end = Math.max(end, lastIndex[s.charAt(i)-'a']);
           if(i==end)
           {
               rsList.add(end-start+1);
               start=i+1;
           }
       }
       return rsList;
    }

    /**881. Boats to Save People, only max two people can save in a boat*/
    @Override
    public int numRescueBoats(int[] peopleWeights, int limit){
        Arrays.sort(peopleWeights);
         int minBoat=0;
         int i=0,j=peopleWeights.length-1;
         while (i<=j)
         {
             if(peopleWeights[j]==limit)
                 j--;
             else if(peopleWeights[i]+peopleWeights[j]<=limit)
             {
                 i++;
                 j--;
             }
             else j--;
             minBoat++;
         }
         return minBoat;
    }
    /**55. Jump Game**/
    @Override
    public boolean canJump(int[] nums){
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;   // can't even reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }
    /**45. Jump Game II, min steps**/
    @Override
    public int jump(int[] nums){
        if(nums.length<=1) return 0;
        int maxReach = 0;
        int ans=0,end=0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return -1;   // can't even reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1)
            {
                ans++;
                break;
            }

            if(i==end)
            {
                end=maxReach;
                ans++;
            }
        }
        return ans;
    }
    /**jumps path indexes, if jums in min steps*/
    @Override
    public List<Integer> jumpPath(int[] nums){
        if(nums.length<=1) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int maxReach = 0;
        int end=0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return new ArrayList<>();   // can't even reach this index
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1)
            {
               list.add(i);
                break;
            }

            if(i==end)
            {
                list.add(i);
                end=maxReach;
            }
        }
        return list;
    }
    /**134. Gas Station**/
    @Override
    public int canCompleteCircuit(int[] gas, int[] cost){
        int totalGas = 0, totalCost = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];

            tank += gas[i] - cost[i];

            if (tank < 0) {
                start = i + 1;  // reset start
                tank = 0;       // reset tank
            }
        }

        return totalGas >= totalCost ? start : -1;
    }

    /**435. Non-overlapping Intervals**/
    @Override
    public int eraseOverlapIntervals(int[][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt((int[]x)->x[0]).thenComparing(y->y[1]));

        int[] prev=intervals[0];
        int count=0;
        for(int i=1;i<intervals.length;i++)
        {
            if(prev[1]>intervals[i][0]) {
                count++;
                //keep smallar one on overllaping
                if(intervals[i][1]<prev[1])
                    prev=intervals[i];
            }
            else prev = intervals[i];
        }
        return count;
    }

    /**135. Candy**/
    @Override
    public int candy(int[] ratings){
        int[] candy=new int[ratings.length];
        Arrays.fill(candy,1);

        for(int i=1;i<candy.length;i++)
        {
            if(ratings[i]>ratings[i-1])
                candy[i]=candy[i-1]+1;
        }
        for(int i=candy.length-1;i>0;i--)
        {
            if(ratings[i-1]>ratings[i])
                candy[i-1]=Math.max(candy[i-1],candy[i]+1);
        }
        int total = 0;
        for (int c : candy) total += c;
        return total;
    }
}
