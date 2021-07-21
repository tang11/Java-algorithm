package com.algorithm.leetcode.dynamicProgramming;

/**
 * leetcode53
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for(int i =0; i < nums.length; i ++) {
            if(sum > 0) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return  max;
    }
    public static void main(String[] args) {
        int[] testExample1 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int testResult1 = 6;

        int[] testExample2= new int[] {1};
        int testResult2= 1;

        int[] testExample3= new int[]{0};
        int testResult3 = 0;

        int[] testExample4= new int[]{-1};
        int testResult4 = -1;
        System.out.println("testResult1 " + (maxSubArray(testExample1) == testResult1));
        System.out.println("testResult2 " + (maxSubArray(testExample2) == testResult2));
        System.out.println("testResult3 " + (maxSubArray(testExample3) == testResult3));
        System.out.println("testResult4 " + (maxSubArray(testExample4) == testResult4));

    }
}
