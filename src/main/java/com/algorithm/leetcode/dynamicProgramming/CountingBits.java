package com.algorithm.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * leetcode338
 * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 **/
public class CountingBits {
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = countOnes(i);
        }
        return result;
    }

    /**
     * Brian Kernighan 算法的原理是：
     * 对于任意整数 xx，令 x=x&(x-1) 该运算将 x 的二进制表示的最后一个 1 变成 0。
     * 因此，对 x 重复该操作，直到 x 变成 0，则操作次数即为 x 的「一比特数」。
     *
     * @param number
     * @return
     */
    private static int countOnes(int number) {
        int ones = 0;
        while (number > 0) {
            number = number & (number - 1);
            ones++;
        }
        return ones;
    }

    public static void main(String[] args) {
        int testExample1 = 2;
        int[] testResult1 = new int[]{0, 1, 1};

        int testExample2 = 5;
        int[] testResult2 = new int[]{0, 1, 1, 2, 1, 2};
        System.out.println("testResult1: " + (Arrays.equals(testResult1, countBits(testExample1))));
        System.out.println("testResult2: " + (Arrays.equals(testResult2, countBits(testExample2))));

    }
}
