package com.algorithm.leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode228. Summary Ranges
 * You are given a sorted unique integer array nums.
 * <p>
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * <p>
 * Each range [a,b] in the list should be output as:
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();

        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        List<String> result = new ArrayList<>();
        result.add("0->2");
        result.add("4->5");
        result.add("7");
        System.out.println(summaryRanges(nums));
        System.out.println("result " + (summaryRanges(nums).equals(result)));
    }
}
