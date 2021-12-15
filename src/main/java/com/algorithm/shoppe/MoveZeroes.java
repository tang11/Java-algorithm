package com.algorithm.shoppe;

/**
 * @author tanglijuan
 * @date 2021/12/13
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int left =0;
        int right = 0;
        while (right<n) {
            if (nums[right] !=0) {
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
