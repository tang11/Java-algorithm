package com.algorithm.剑指offer;

import java.util.HashSet;

/**
 * @date 2021/8/15
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsSet.contains(nums[i])) {
                return nums[i];
            } else {
                numsSet.add(nums[i]);
            }
        }
        return -1;
    }
}
