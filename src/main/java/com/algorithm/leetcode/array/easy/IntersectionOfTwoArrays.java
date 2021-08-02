package com.algorithm.leetcode.array.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * leetcode349
 *
 * @date 2021/8/2
 */
public class IntersectionOfTwoArrays {
    /**
     * brute solution
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                }
            }
        }
        int[] result = new int[set.size()];
        int k = 0;

        for (Integer num : set) {
            result[k] = num;
            k++;

        }
        return result;
    }

    /**
     * 通过HashSet来解决
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (set1.contains(nums2[j])) {
                resultSet.add(nums2[j]);
            }
        }
        int k = 0;
        int[] result = new int[resultSet.size()];
        for (Integer num : resultSet) {
            result[k] = num;
            k++;
        }
        return result;
    }

    /**
     * 排序+双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int start1 = 0;
        int start2 =0;
        HashSet<Integer> set = new HashSet<>();
        while (start1 < nums1.length && start2 < nums2.length) {
            if (nums1[start1] == nums2[start2]) {
                set.add(nums1[start1]);
                start1++;
                start2++;
            } else if (nums1[start1] > nums2[start2]) {
                start2++;
            } else {
                start1++;
            }
        }
        int k = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[k] = num;
            k++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testNum1 = new int[]{1, 2, 2, 1};
        int[] testNum2 = new int[]{2, 2};
        int[] result = new int[]{9, 4};
        System.out.println(Arrays.equals(intersection3(testNum1, testNum2), result));
    }
}
