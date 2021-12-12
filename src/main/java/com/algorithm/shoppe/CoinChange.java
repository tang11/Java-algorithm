package com.algorithm.shoppe;

import java.util.Arrays;

/**
 * @author shenli
 * @date 2021/12/12
 */
public class CoinChange {

    /**
     * 时间复杂度：O(Sn)O(Sn)，其中 SS 是金额，nn 是面额数。我们一共需要计算 O(S)O(S) 个状态，SS 为题目所给的总金额。对于每个状态，每次需要枚举 nn 个面额来转移状态，所以一共需要 O(Sn)O(Sn) 的时间复杂度。
     * 空间复杂度：O(S)O(S)。数组 \textit{dp}dp 需要开长度为总金额 SS 的空间。

     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //PS：为啥 dp 数组初始化为 amount + 1 呢，
        // 因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），
        // 所以初始化为 amount + 1 就相当于初始化为正无穷，便于后续取最小值。
        // 为啥不直接初始化为 int 型的最大值 Integer.MAX_VALUE 呢？因为后面有 dp[i - coin] + 1，这就会导致整型溢出。
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    // 做选择，选择需要硬币最少的那个结果
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
