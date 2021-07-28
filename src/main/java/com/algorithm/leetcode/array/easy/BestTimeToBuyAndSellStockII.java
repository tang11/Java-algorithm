package com.algorithm.leetcode.array.easy;

/**
 *leetcode122
 * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class BestTimeToBuyAndSellStockII {
    /**BestTimeToBuyAndSellStockI的不同之处是，BestTimeToBuyAndSellStockI是只能买卖一次，所以需要找出最低价，和最高价
     * BestTimeToBuyAndSellStockII可以每天进行买卖，如果第二天卖的钱是大于第一天的，那这笔利润可以加上去
     * 这题和
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i =1; i< prices.length; i++) {
            int tmp = prices[i] - prices[i-1];
            if(tmp >= 0) {
                profit += tmp;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] testExmaple1 = new int[]{7,1,5,3,6,4};
        System.out.println("result " +(maxProfit(testExmaple1) == 7));

        int[] testExmaple2 = new int[]{1,2,3,4,5};
        System.out.println("result " +(maxProfit(testExmaple2) == 4));

        int[] testExmaple3 = new int[]{7,6,4,3,1};
        System.out.println("result " +(maxProfit(testExmaple3) == 0));
    }

}
