package com.algorithm.leetcode.array.easy;

/**
 * leetcode88
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * <p>
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * <p>
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        if (m == 0 || n == 0) {
            nums1 = m == 0 ? nums2 : nums1;
            return;
        }
        while (j >= 0 && i >= 0) {
            if (nums2[j] >= nums1[i]) {
                nums1[index--] = nums2[j];
                j--;
            } else {
                nums1[index--] = nums1[i];
                i--;
            }
        }
        if (j != 0) {
            for (int k = 0; k < j; k++) {
                nums1[k] = nums2[k];
            }

        }
    }

    public static void main(String[] args) {
        int[] testExampleNum1 = new int[]{1};
        int m = 1;
        int[] testExampleNum2 = new int[]{};
        int n = 0;
        merge(testExampleNum1, m, testExampleNum2, n);
        int[] testExample2Num1 = new int[]{0};
        int m2 = 0;
        int[] testExample2Num2 = new int[]{1};
        int n2 = 1;
        merge(testExample2Num1, m2, testExample2Num2, n2);
    }
}
