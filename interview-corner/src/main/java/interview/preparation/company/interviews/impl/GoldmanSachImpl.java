package interview.preparation.company.interviews.impl;

import interview.preparation.company.interviews.question.IGoldmanSach;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class GoldmanSachImpl implements IGoldmanSach {

    @Override
    public double shortestDistance(String document, String word1, String word2) {
        String[] words = document.split("[,.\\s]");

        int index = 0;
        double shortest = document.length();
        double word1Loc = 0;
        double word2Loc = 0;

        for (String word : words) {
            if (word.equalsIgnoreCase(word1)) {
                word1Loc = index + (word.length() / 2.0);
            } else if (word.equalsIgnoreCase(word2)) {
                word2Loc = index + (word.length() / 2.0);
            }

            if (word1Loc > 0 && word2Loc > 0) {
                double current = Math.abs(word2Loc - word1Loc);
                if (current < shortest) {
                    shortest = current;
                }
            }

            index += word.length() + 1;
        }

        if (word1Loc == 0 || word2Loc == 0) {
            return -1;
        }

        return shortest;
    }
//{2,3,1,1,4};
    @Override
    public int minJumToReachEndOfArray(int[] a){
        int jump =0;
        int n=a.length;
        int fardest=0;
        int end=0;
        for(int i=0;i<n;i++)
        {
            // update the farthest reachable index from the current position
            fardest = Math.max(fardest,i+a[i]);
            if(fardest>=n-1) {
                jump++;
                break;
            }
            // it's time to make next jump
            if(i==end)
            {
                jump++;
                end=fardest;
            }
        }
        return jump;
    }

    /**Given two arrays start[] and finish[], representing the start and finish times of activities. A person can perform only one activity at a time, and an activity can be performed only if its start time is greater than the finish time of the last chosen activity.
     Find the maximum number of activities that can be performed without overlapping.*/
    @Override
    public int maxActivity(int[]start, int[]end){
       int[][]a = new int[start.length][2];
       for(int i=0;i<start.length;i++){
           a[i][0]=start[i];
           a[i][1]=end[i];
       }
       Arrays.sort(a, Comparator.comparing(x->x[1]));
       int countMax=1;
       int prev=a[0][1];
       for(int i=1;i<start.length;i++)
       {
           if(a[i][0]>prev)
           {
               prev=a[i][1];
               countMax++;
           }
       }
       return countMax;
    }

    /**Given a string s containing words separated by spaces, reverse the order of the words.
     A word is defined as a sequence of non-space characters.**/
    @Override
    public String reverseWords(String s){
        if (s == null || s.isBlank()) return "";

        String[] words = s.strip().split("\\s+");

        int i = 0, j = words.length - 1;
        while (i < j) {
            String temp = words[i];
            words[i] = words[j];
            words[j] = temp;
            i++;
            j--;
        }

        return String.join(" ", words);
    }

    /**given a grid of numbers move right and up find max sum**/
    @Override
    public int maxSum(int[][]mat){
        int m = mat.length;
        int n = mat[0].length;

        // Base case: bottom row (can only move RIGHT)
        for (int c = 1; c < n; c++) {
            mat[m - 1][c] += mat[m - 1][c - 1];
        }

        // Fill rest bottom-up
        for (int r = m - 2; r >= 0; r--) {
            // First column (can only come from below)
            mat[r][0] += mat[r + 1][0];

            for (int c = 1; c < n; c++) {
                mat[r][c] += Math.max(mat[r + 1][c], mat[r][c - 1]);
            }
        }
        return mat[0][n - 1]; // top-right
    }
/*nput : String[] logs = {
    "192.168.1.10 - - [10/Jan/2026:10:01:10 +0530] \"GET /home HTTP/1.1\" 200",
    "192.168.1.11 - - [10/Jan/2026:10:01:20 +0530] \"GET /login HTTP/1.1\" 200",
    "192.168.1.10 - - [10/Jan/2026:10:02:10 +0530] \"GET /profile HTTP/1.1\" 200",
    "192.168.1.12 - - [10/Jan/2026:10:03:10 +0530] \"GET /about HTTP/1.1\" 200"
};*/
    /**find least recently used ip,ie older used ip*/
    @Override
    public String lruFromLog(String[] logs){

        Map<String, ZonedDateTime> lastSeen  = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z",Locale.ENGLISH);

        for(String log:logs)
        {
            String ip = log.split("\\s+")[0];
            int start=log.indexOf("[");
            int end = log.indexOf("]");
            String timeStr = log.substring(start+1,end);
            ZonedDateTime time = ZonedDateTime.parse(timeStr,formatter);
            lastSeen .put(ip,time);
        }
        String lruIP = null;
        ZonedDateTime oldest = null;

        for(Map.Entry<String,ZonedDateTime> entry:lastSeen.entrySet())
        {
            if(oldest==null||entry.getValue().isBefore(oldest))
            {
                lruIP = entry.getKey();
                oldest = entry.getValue();
            }
        }
        return lruIP;
    }

    /**Best Average Grade**/
    @Override
    public int bestAverage(String[][] scores){
        Map<String,int[]> map = new HashMap<>();

        for(String[] score:scores)
        {
            String name = score[0];
            int sc = Integer.parseInt(score[1]);
            map.putIfAbsent(name,new int[2]);
            map.get(name)[0]+=sc; //sum of score
            map.get(name)[1]++;  //count names
        }
        int best=Integer.MIN_VALUE;

        for(int[] val :map.values())
        {
            double average = (double) val[0]/val[1];
            int floorAvg = (int)Math.floor(average);
            best = Math.max(best,floorAvg);
        }
        return best;
    }

    @Override
    public double medianSortedArrayByMerge(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int total = n + m;
        int mid1 = (total - 1) / 2, mid2 = total / 2;

        int i = 0, j = 0, k = 0;
        int prev = 0, curr = 0;

        while (k <= mid2) {
            prev = curr;
            if (i < n && (j >= m || a[i] <= b[j])) {
                curr = a[i++];
            } else {
                curr = b[j++];
            }
            k++;
        }

        return total % 2 == 0 ? (prev + curr) / 2.0 : curr;
    }
    @Override
      public double findMedianSortedArrays(int[] A, int[] B) {
        if (A.length > B.length) return findMedianSortedArrays(B, A);

        int n = A.length;
        int m = B.length;
        int low = 0, high = n;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = (n + m + 1) / 2 - i;

            int Aleft  = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int Aright = (i == n) ? Integer.MAX_VALUE : A[i];

            int Bleft  = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int Bright = (j == m) ? Integer.MAX_VALUE : B[j];

            if (Aleft <= Bright && Bleft <= Aright) {
                if ((n + m) % 2 == 0) {
                    return (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                } else {
                    return Math.max(Aleft, Bleft);
                }
            } else if (Aleft > Bright) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    /**Your local Foyle's is running a scheme to promote reading amongst users. If you sign up for the scheme,
     *  you can buy any books from the store at a fixed cost of c. You can also exchange x number of books to get 1 new book.
     *  Write an algorithm to find the maximum number of books you can read for a given amount of money m.**/
    @Override
    public int maxBooks(int m, int c, int x){
        if(x<=1) throw new RuntimeException("Exchang rate must be >=2, other wise infinte book we can read");
        if(m<c) return 0;

        int books=m/c;
        int wrappers=books;
        int totol= books;

        while (wrappers>=x)
        {
            int newBook=wrappers/x;
            totol+=newBook;
            wrappers = newBook + (wrappers%x); //wrappers%x some book left added at new wrappers
        }
        return totol;
    }

   /**3191. Minimum Operations to Make Binary Array Elements Equal to One I**/
    @Override
    public int minStepsToAllOnes(int[] nums) {
        int n = nums.length;
        int i = 0, j = 2, ans = 0;

        while (j < n) {
            if (nums[i] == 0) {
                ans++;
                for (int k = i; k < i + 3; k++) {
                    nums[k] = (nums[k] == 0) ? 1 : 0;
                }
            }
            i++;
            j++;
        }

        for (int m = 0; m < n; m++) {
            if (nums[m] == 0) {
                return -1;
            }
        }

        return ans;
    }

    /**Longest Repeating Substring **/
    @Override
    public int longestRepSubStr(String str){

        int i=0;
        int j=0;
        int max=0;
        int start=0;
        while (i<str.length()&&j<str.length())
        {
            if(str.charAt(i)==str.charAt(j))
            {
               if(max<j-i+1) {
                   start=i;
                   max = j - i + 1;
               }
                j++;
            }
            else i++;
        }
        System.out.println(str.substring(start,max+start));
        return max;
    }
    /**min sliding window**/
    @Override
    public String minSlidingWindow(String s,String t){
        if(s==null||t==null) return null;
        if(s.length()<t.length())return "";

        int[] need = new int[128];
        for(char ch:t.toCharArray())need[ch]++;

        int l=0,r=0,start=0,required = t.length();
        int minLen=Integer.MAX_VALUE;

        while (r<s.length())
        {
            char rc = s.charAt(r);
            if(need[rc]>0)required--;
            need[rc]--; //track extra char in window
            r++;
            while (required==0)//found window
            {
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }
                //check lesser window by srinking left
                char lc = s.charAt(l);
                need[lc]++;
                if (need[lc] > 0) required++;
                l++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
    /**Longest Increasing Subsequence in a String**/
    @Override
    public String longestIncreasingSubsequence(String str){
        int L = str.length();

       StringBuilder sb;
       String maxLen="";
       for(int i=0;i<L;i++)
       {
          sb = new StringBuilder();
           for(int j=i;j<L;j++)
           {
               if(sb.isEmpty())sb.append(str.charAt(j));
               else if(sb.charAt(sb.length()-1)<str.charAt(j))
                   sb.append(str.charAt(j));
           }
           if(maxLen.length()<sb.length())
               maxLen=sb.toString();
       }
    return maxLen;
    }

   /**2134. Minimum Swaps to Group All 1's Together II**/
    @Override
    public int minSwaps(int[] nums){

        int n = nums.length;
        int k=0;
        //COUNT total 1s
        for(int x:nums)k+=x;

        if(k<=1)return 0; //no need to swap
        int oneInWindow=0;
        for(int i=0;i<k;i++)oneInWindow+=nums[i];

        int maxOne = oneInWindow;

        for(int r=k;r<n+k;r++)
        {
            int addIdx = r%n; // new element entering window
            int removeIdx =(r-k)%n; // element leaving window

            oneInWindow+=nums[addIdx];
            oneInWindow-=nums[removeIdx];
            maxOne = Math.max(maxOne,oneInWindow);
        }
        // min swaps = k - max ones in any window
        return k-maxOne;
    }

    /**Find the sum of minimum and maximum element of all subarrays of size K**/
    @Override
    public int[] sumOfMinAndMax(int[] arr,int k){
        int n = arr.length;
        if (k > n || k <= 0) return new int[]{};

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        long result = 0;

        for (int i = 0; i < n; i++) {

            // remove out-of-window indices
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() <= i - k)
                maxDeque.pollFirst();
            if (!minDeque.isEmpty() && minDeque.peekFirst() <= i - k)
                minDeque.pollFirst();

            // maintain decreasing order for maxDeque
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[i])
                maxDeque.pollLast();

            // maintain increasing order for minDeque
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[i])
                minDeque.pollLast();

            maxDeque.offerLast(i);
            minDeque.offerLast(i);

            // when window is ready (size >= k)
            if (i >= k - 1) {
                result += arr[maxDeque.peekFirst()] + arr[minDeque.peekFirst()];
            }
        }

        return new int[]{(int)result};
    }

}
