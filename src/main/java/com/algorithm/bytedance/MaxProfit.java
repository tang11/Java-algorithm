package com.algorithm.bytedance;

/**
 * @author tanglijuan
 * @date 2021/12/7
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            // dp[i][0] 0 表示第i天我没有持有股票，dp[i][1]表示第i天我持有股票，那最终的结果是最后一条没有持有股票的结果一定是大于持有股票的结果的。
            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[n - 1][0];
    }
}
