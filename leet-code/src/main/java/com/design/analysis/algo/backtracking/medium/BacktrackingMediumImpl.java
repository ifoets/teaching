package com.design.analysis.algo.backtracking.medium;

import java.util.*;
import java.util.stream.Stream;

public class BacktrackingMediumImpl implements IBacktrackingMedium {

    /**17. Letter Combinations of a Phone Number**/
    List<String> phoneStr = List.of("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz");
    @Override
    public List<String> letterCombinations(String digits){
        List<String> resultList = new ArrayList<>();
        dfsPhonesStr(0,digits,new StringBuilder(),resultList);
        return resultList;
    }
    private void dfsPhonesStr(int i, String digits,StringBuilder sb, List<String> strList)
    {
        if(i==digits.length())
        {
            strList.add(sb.toString());
            return;
        }
        for(char ch:phoneStr.get(digits.charAt(i)-'0').toCharArray())
        {
            sb.append(ch);
            dfsPhonesStr(i+1,digits,sb,strList);
            sb.deleteCharAt(sb.length()-1);//remove added one on backtracking
        }
    }

    /**22. Generate Parentheses**/
    @Override
    public List<String> generateValidParenthesis(int n){
        if(n<=0)return new ArrayList<>();
        Set<String> resultSet = new HashSet<>();
        dfsValidParenthesis(0,0,n,"",resultSet);
        return new ArrayList<>(resultSet);
    }
    private void dfsValidParenthesis(int open,int close,int n,String str,Set<String> resultSet){
        if(str.length()==2*n)
        {
            resultSet.add(str);
            return;
        }
        if(open<n) dfsValidParenthesis(open+1,close,n,str+"(",resultSet);
        if(close<open) dfsValidParenthesis(open,close+1,n,str+")",resultSet);
    }

    /**39. Combination Sum**/
    @Override
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        if(candidates==null)return new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        backtrackCombinationSum(0,candidates,target,new ArrayList<>(),resultList);
        return resultList;
    }
    private void backtrackCombinationSum(int index,int[] candidates,int target,List<Integer> list,List<List<Integer>> resultList)
    {
        if(target==0)
        {
            resultList.add(new ArrayList<>(list));
            return;
        }
        if(target<0||index==candidates.length)
            return;
        // Option 1: pick the current number
        list.add(candidates[index]);
        backtrackCombinationSum(index,candidates,target-candidates[index],list,resultList);
        list.remove(list.size()-1);//backtrack

        // Option 2: skip the current number
        backtrackCombinationSum(index+1,candidates,target,list,resultList);
    }

    /**40. Combination Sum II**/
    @Override
    public List<List<Integer>> combinationSum2(int[] candidates, int target){
        if(candidates==null)return new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        backtrackCombinationSum2(0,candidates,target,new ArrayList<>(),resultList);
        //remove duplicate collections
        return resultList.stream().map(list-> list.stream().sorted().toList()).distinct().toList();
    }
    private void backtrackCombinationSum2(int index,int[] candidates,int target,List<Integer> list,List<List<Integer>> resultList)
    {
        if(target==0)
        {
            resultList.add(new ArrayList<>(list));
            return;
        }
        if(target<0||index==candidates.length)
            return;
        // Option 1: pick the current number
        list.add(candidates[index]);
        backtrackCombinationSum2(index+1,candidates,target-candidates[index],list,resultList);
        list.removeLast();//backtrack

        // Option 2: skip the current number
        backtrackCombinationSum2(index+1,candidates,target,list,resultList);
    }
    @Override
    public List<List<Integer>> combinationSum2Rec(int[] candidates, int target){
        List < List < Integer >> ans = new ArrayList < > ();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
    private static void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (target == 0) {
            ans.add(new ArrayList < > (ds));
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.removeLast();
        }
    }
    /**46. Permutations*/
    @Override
    public List<List<Integer>> permute(int[] nums){
       if(nums==null)return new ArrayList<>();

       List<List<Integer>> resultList = new ArrayList<>();
        permuteBacktrack(0,nums.length-1,nums,resultList);
       return resultList;
    }
    private void permuteBacktrack(int start,int end,int[]nums,List<List<Integer>> resultList){
        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums) perm.add(n);
            resultList.add(perm);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permuteBacktrack(start + 1,end, nums, resultList);
            swap(nums, start, i);
        }
    }
    private void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    @Override
    public List<List<Integer>> permuteX(int[] nums){
        List<List<Integer>> resultList = new ArrayList<>();
        permuteDfs(new boolean[nums.length],nums,new ArrayList<>(),resultList);
        return resultList;
    }
    private void permuteDfs(boolean[] used,int[] nums,List<Integer> path,List<List<Integer>>resultList){
        if (path.size() == used.length) {
            // make a deep copy since otherwise we'd be append the same list over and over
            resultList.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            // skip used letters
            if (used[i]) continue;
            // add letter to permutation, mark letter as used
            path.add(nums[i]);
            used[i] = true;
            permuteDfs(used, nums,path,resultList);
            // remove letter from permutation, mark letter as unused
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
    /**47. Permutations II**/
    @Override
    public List<List<Integer>> permuteUnique(int[] nums){
        Set<List<Integer>> resultList = new HashSet<>();
        permuteUniqueDfs(new boolean[nums.length],nums,new ArrayList<>(),resultList);
        return new ArrayList<>(resultList);
    }

    private void permuteUniqueDfs(boolean[] used,int[] nums,List<Integer> path,Set<List<Integer>>resultList){
        if (path.size() == used.length) {
            // make a deep copy since otherwise we'd be append the same list over and over
            resultList.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            // skip used letters
            if (used[i]) continue;
            // add letter to permutation, mark letter as used
            path.add(nums[i]);
            used[i] = true;
            permuteUniqueDfs(used, nums,path,resultList);
            // remove letter from permutation, mark letter as unused
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

}
