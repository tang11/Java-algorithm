package com.algorithm.leetcode.array.easy;

import java.util.HashSet;

/**
 * leetcode219
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicateII {

    /**
     * HashSet中只保存k个数字，
     * 循环数组，如果HashSet中包含nums[i]说明在k索引以内有重复的数字，
     * 不包含，添加到HashSet中，同时判断HashSet大小，大于k就删除第一个元素。
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i-k]);
            }
        }
        return false;
    }
}
