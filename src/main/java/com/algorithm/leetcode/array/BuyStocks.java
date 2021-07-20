package com.algorithm.leetcode.array;

/**
 * leetcode121
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BuyStocks {
    /**
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     * soluation 1 brute force
     * 暴力解法：如果有时间和空间复杂度的限制，这种解法不可取
     * Time complexity o(n²)
     */

    public static int maxProfitSolutionOne(int[] prices) {
        int buyIn = 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            buyIn = prices[i];
            for (int j = i; j < prices.length; j++) {
                max = Math.max(max, prices[j] - buyIn);
            }
        }
        if (max > 0) {
            return max;
        }
        return 0;

    }

    //solution 2  DP
    public static int maxProfitSolutionTwo(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int[] minPrices = new int[n];
        int[] maxProfit = new int[n];
        minPrices[0] = prices[0];
        maxProfit[0] = 0;

        for (int i = 1; i < n; ++i) {
            minPrices[i] = Math.min(minPrices[i - 1], prices[i]);
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrices[i - 1]);
        }
        return maxProfit[n - 1];

    }

    public static int maxProfitSolutionTwoOptimize(int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int[] minPrices = new int[n];
        int[] maxProfit = new int[n];
        minPrices[0] = prices[0];
        maxProfit[0] = 0;

        for (int i = 1; i < n; ++i) {
            minPrices[i] = Math.min(minPrices[i - 1], prices[i]);
            maxProfit[i] = Math.max(maxProfit[i - 1], prices[i] - minPrices[i - 1]);
        }
        return maxProfit[n - 1];

    }

    /**
     * solution3
     * price: {7,1,5,3,6,4}
     * gain {-6, 4, -2, 3,-2}
     * reduce to Maximum subarray
     * <p>
     * compute the gain of each day
     *
     * @param prices
     * @return
     */
    public static int maxProfitSolutionThree(int[] prices) {
        int n = prices.length;
        int[] gains = new int[n - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            gains[i] = prices[i + 1] - prices[i];
        }
        return maxiMumSubarray(gains);
    }

    private static int maxiMumSubarray(int[] array) {
        int sum = 0;
        int max =0;
        for(int j =0; j < array.length; j ++) {
            if (sum > 0) {
                sum += array[j];
            } else {
                sum = array[j];
            }
            max = Math.max(sum, max);
        }
        return max;

    }

    public static void main(String[] args) {
        //test solution one
        int[] pricesExample1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] pricesExample2 = new int[]{7, 6, 4, 3, 1};
        assert maxProfitSolutionOne(pricesExample1) == 5;
        System.out.println("result " + (maxProfitSolutionOne(pricesExample1) == 5));
        assert maxProfitSolutionOne(pricesExample2) == 0;
        System.out.println("result " + (maxProfitSolutionOne(pricesExample2) == 0));


        //test solution two
        assert maxProfitSolutionTwo(pricesExample1) == 5;
        System.out.println("result " + (maxProfitSolutionTwo(pricesExample1) == 5));
        assert maxProfitSolutionTwo(pricesExample2) == 0;
        System.out.println("result " + (maxProfitSolutionTwo(pricesExample2) == 0));

        //test solution three
        assert maxProfitSolutionThree(pricesExample1) == 5;
        System.out.println("result " + (maxProfitSolutionThree(pricesExample1) == 5));
        assert maxProfitSolutionThree(pricesExample2) == 0;
        System.out.println("result " + (maxProfitSolutionThree(pricesExample2) == 0));
    }
}
