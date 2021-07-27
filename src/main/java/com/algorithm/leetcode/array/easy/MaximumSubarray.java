package com.algorithm.leetcode.array.easy;

/**
 * leetcode53
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++ ) {
            if (sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return  max;
    }

    public static void main(String[] args) {
        int[] testNums1 = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        int result1 = 6;
        System.out.println(maxSubArray(testNums1) == result1);
    }
}
