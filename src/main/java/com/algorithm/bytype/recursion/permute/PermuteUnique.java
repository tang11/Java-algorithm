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
        backtrack1(res, new ArrayList<>(), nums);
        return res;
    }

    public void backtrack1(List<List<Integer>> res, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (tempList.contains(i) && i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            tempList.add(nums[i]);
            backtrack1(res, tempList, nums);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique1(nums));
    }

}
