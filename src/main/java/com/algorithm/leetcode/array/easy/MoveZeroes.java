package com.algorithm.leetcode.array.easy;

import java.util.Arrays;

/**
 * leetcode283
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    /**
     * 双指针通用解法,把不为0的移到前面，后面的补0，不太符合题意移动0
     * @param nums
     * @return
     */
    public static int[] moveZeroesSolutionOne(int[] nums) {
        int numPoint =0;
        int runPoint = 0;
        for(int i =0; i < nums.length; i ++) {
            if(nums[i]==0) {
                runPoint ++;
            } else{
                nums[numPoint] = nums[i];
                numPoint ++;
            }
        }
        for(int j = numPoint; j< nums.length; j++) {
            nums[numPoint] = 0;
            numPoint++;
        }
        return nums;
    }

    public static int[] moveZeroesSolutionTwo(int[] nums) {
       int length = nums.length;
       if (length <= 1) {
           return nums;
       }
       int j =0;
       for(int i=0;i < length; i ++) {
           if (nums[i] !=0) {
               if(i > j) {
                   nums[j] = nums[i];
                   nums[i]=0;
               }
               j ++;
           }
       }
       return nums;
    }

    public static void main(String[] args) {
        int[] testExample1 = new int[]{0,1,0,3,12};
        int[] resultExample1 = new int[]{1,3,12,0,0};

        int[] testExample2= new  int[]{0};
        int[] resultExample2= new int[]{0};

        System.out.println("testExample1 result: "+(Arrays.equals(moveZeroesSolutionOne(testExample1), resultExample1)));
        System.out.println("testExample1 result: "+(Arrays.equals(moveZeroesSolutionOne(testExample2), resultExample2)));
        System.out.println("testExample2 result: "+(Arrays.equals(moveZeroesSolutionTwo(testExample1), resultExample1)));
        System.out.println("testExample2 result: "+(Arrays.equals(moveZeroesSolutionTwo(testExample2), resultExample2)));

    }
}
