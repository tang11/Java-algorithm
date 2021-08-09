package com.algorithm.leetcode.array.easy;

import java.util.Arrays;

/**
 *leetcode414
 * @date 2021/8/9
 */
public class ThirdMaximumNumber {
    public static int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        if(nums.length == 2 || nums.length == 1) {
            return nums[nums.length -1];
        }
        int pre = nums[nums.length -1];
        int index =1;
        int i = nums.length -2;
       while( i>=0) {
           if(pre != nums[i]) {
               pre = nums[i];
               index ++;
           }
            if(index == 3) {
                return nums[i];
            }

           i--;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{3,2,1};
        System.out.println(thirdMax(nums1) == 1);
    }
}
