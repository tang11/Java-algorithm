package com.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/17
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(res, path, nums);
            path.remove(path.size() - 1);
        }
    }
}
