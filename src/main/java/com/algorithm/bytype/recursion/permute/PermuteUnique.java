package com.algorithm.bytype.recursion.permute;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode
 *
 * @date 2021/8/25
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack1(res, new ArrayList<>(), nums, used, 0);
        return res;
    }

    public void backtrack1(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used, int index) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            used[i] = true;
            backtrack1(res, tempList, nums, used, index);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }
    }


    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack2(res, new ArrayList<>(), nums, used, 0);
        return res;
    }


    public void backtrack2(List<List<Integer>> res, List<Integer> tempList, int[] nums, boolean[] used, int index) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            //cut the tree
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }

            tempList.add(nums[i]);
            used[i] = true;
            backtrack2(res, tempList, nums, used, index);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique1(nums));
        System.out.println(permuteUnique.permuteUnique2(nums));

    }

}
