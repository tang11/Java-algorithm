package com.algorithm.leetcode.array.easy;

import java.util.Arrays;

/**
 * leetcode453
 *
 * @date 2021/8/2
 */
public class MinimumMovesToEqualArrayElements {

    /**
     * brute force
     * 这种解法超出时间限制
     *
     * @param nums
     * @return
     */
    public int minMoves1(int[] nums) {
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        int times = 0;
        while (nums[start] != nums[end]) {
            nums[0]++;
            nums[1]++;
            Arrays.sort(nums);
            times++;

        }
        return times;
    }

    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int times= 0;
        for (int i =1;i< nums.length; i++) {
            times += nums[i] - nums[0];
        }
        return times;
    }

    public static void main(String[] args) {
        int[] testExample = new int[]{1, 1, 1000000000};
        int result = 999999999;
        System.out.println((minMoves2(testExample) == result));
    }
}
