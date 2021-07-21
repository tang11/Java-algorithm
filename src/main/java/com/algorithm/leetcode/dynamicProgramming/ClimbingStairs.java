package com.algorithm.leetcode.dynamicProgramming;

import java.util.Arrays;

/**
 * leetcode70
 * You are climbing a staircase. It takes n steps to reach the top.
 * <p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 */
public class ClimbingStairs {
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int testExample1 = 2;
        int testResult1 = 2;
        System.out.println("testResult1 " + (climbStairs(testExample1) == testResult1));

        int testExample2 = 3;
        int testResult2 = 3;
        System.out.println("testResult2 " + (climbStairs(testExample2) == testResult2));
    }
}
