package com.algorithm.bytype.recursion.permute;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode46给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * @date 2021/8/25
 */
public class Permutations {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backtrack1(res, new ArrayList<>(), visited, nums);
        return res;
    }

    public void backtrack1(List<List<Integer>> res, List<Integer> tempList, boolean[] visited, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) {
                continue;
            }
            tempList.add(nums[i]);
            visited[i] = true;
            backtrack1(res, tempList, visited, nums);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack2(res, new ArrayList<>(), nums);
        return res;
    }

    public void backtrack2(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(nums[i])) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack2(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute1(nums));
        System.out.println(permutations.permute2(nums));
    }
}
