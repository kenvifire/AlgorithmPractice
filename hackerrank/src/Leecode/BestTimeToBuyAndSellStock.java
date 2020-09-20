package Leecode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int minPrice = prices[0];
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } else if(prices[i] - minPrice > profit){
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }

    public int maxProfit2(int[] prices) {
        if(prices.length < 2) return 0;
        int[] dp = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i] - prices[i-1];
            dp[i] = Math.max(curr, dp[i - 1] + curr);
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
