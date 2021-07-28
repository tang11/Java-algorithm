package com.algorithm.leetcode.array.easy;

import java.util.HashSet;

/**
 * leetcode16
 */
public class SingleNumber {
    public static int singleNumberSolutionOne(int[] nums) {
        int result = 0;
        for (int i: nums) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] testExample1 = new int[]{2,2,1};
        int[] testExample2 = new int[]{4,1,2,1,2};
        int[] testExample3 = new int[]{1};

        System.out.println("Result "+ (singleNumberSolutionOne(testExample1) == 1));
        System.out.println("Result "+ (singleNumberSolutionOne(testExample2) == 4));
        System.out.println("Result "+ (singleNumberSolutionOne(testExample3) ==1));


    }
}
