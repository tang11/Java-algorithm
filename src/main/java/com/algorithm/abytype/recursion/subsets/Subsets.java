package com.algorithm.abytype.recursion.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/8/23
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums,0);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> temList, int[] nums,int start) {
        res.add(new ArrayList<>(temList));
        for (int i = start; i < nums.length; i++) {
            temList.add(nums[i]);
            backtrack(res, temList, nums, i+1);
            temList.remove(temList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums)) ;
    }
}
