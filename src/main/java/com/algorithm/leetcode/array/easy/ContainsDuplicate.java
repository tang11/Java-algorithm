package com.algorithm.leetcode.array.easy;

import java.util.HashSet;

/**
 * leetcode217
 */
public class ContainsDuplicate {
    public boolean containsDuplicateSolutionOne(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}