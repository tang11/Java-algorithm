package com.algorithm.bytype.recursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * @date 2021/9/1
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(res, new ArrayList<>(), nums,0);
        return res;
    }

    public void dfs( List<List<Integer>> res, List<Integer> tempList, int[] nums, int level){
        res.add(new ArrayList<>(tempList));
        for(int i = level;i< nums.length; i++) {
            if(i==level || nums[i] != nums[i-1]) {
                tempList.add(nums[i]);
                dfs(res, tempList, nums, i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }
}
