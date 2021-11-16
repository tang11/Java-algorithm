package com.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/16
 */
public class SubsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(new ArrayList<>(),nums,0);
        return res;
    }
    void backtrack(List<Integer> path,int[] nums,int start){
        res.add(new ArrayList<>(path));
        for(int i=start;i< nums.length;i++){
            if(i==start ||nums[i]!=nums[i-1]) {
                path.add(nums[i]);
                backtrack(path,nums,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}
