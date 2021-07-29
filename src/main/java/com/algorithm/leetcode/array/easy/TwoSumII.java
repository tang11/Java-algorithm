package com.algorithm.leetcode.array.easy;

import java.util.Arrays;

/**
 * leetcode167. Two Sum II - Input array is sorted
 * <p>
 * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * <p>
 * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
 * <p>
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 */
public class TwoSumII {

    /**
     * 　和两数之和的区别是他是有序的，
     * 所以可以先固定一个位置，然后剩余的targert通过二分查找来实现
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSumSolutionOne(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1;
            int end = numbers.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (numbers[i] + numbers[mid] == target) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[i] + numbers[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumSolutionTwo(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = new int[]{1, 2};
        System.out.println("result " + (Arrays.equals(twoSumSolutionOne(numbers, target), result)));
        System.out.println("result " + (Arrays.equals(twoSumSolutionTwo(numbers, target), result)));

    }
}
