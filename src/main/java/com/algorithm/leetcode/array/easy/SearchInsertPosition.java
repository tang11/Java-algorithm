package com.algorithm.leetcode.array.easy;

/**
 * leetcode35
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                return  mid;
            } else if(target > nums[mid]) {
                left = mid + 1;
            } else {
                 right = mid - 1;
            }
        }
        return left;
    }
}
