package com.algorithm.nineType.arecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/29
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, nums, 0, new ArrayList<>());
        return  res;
    }

    public static void backtrack(List<List<Integer>> res, int[] nums, int start, List<Integer> path) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(res, nums, i + 1, path);
            path.remove(path.size() - 1);
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(subsets(nums));
    }
}
