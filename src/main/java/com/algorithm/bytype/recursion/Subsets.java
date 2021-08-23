package com.algorithm.bytype.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shenli
 * @date 2021/8/23
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
            backtrack(res, temList, nums, start+1);
            temList.remove(temList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums)) ;
    }
}
