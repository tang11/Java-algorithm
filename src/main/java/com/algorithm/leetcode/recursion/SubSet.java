package com.algorithm.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tanglijuan
 * @date 2021/11/16
 * []
 * /  \   \
 * [1]  [2]  [3]
 * | \
 * [1,2] [13]
 * <p>
 * 回溯模板
 * List<List<Integer> res = new ArrayList<>();
 * public void backtrack(路径，选择列表){
 * if 满足结束条件：
 * result.add(路径)；
 * return;
 * for 选择 in 选择列表：
 * 做选择；
 * backtrack(路径，选择列表);
 * 撤销选择；
 * }
 * 时间复杂度，为o(n!);
 */
public class SubSet {
    List<List<Integer>> res = new ArrayList<>();

    void backtrack(List<Integer> path, int[] nums, int start) {
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(path, nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
