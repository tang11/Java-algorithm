package com.algorithm.abytype.binarySearch;

/**
 * @author tanglijuan
 * @date 2021/9/2
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                return i;
            }
        }
        return nums.length - 1;
    }

    public static int findPeakElement1(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(nums) == 2);
    }
}
