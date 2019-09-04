package com.example.leetcodedemo.Array.easy;

/**
 * Created by wcxdhr on 2019/8/22.
 */

public class BestTimetoBuyandSellStock {

    public static void main(String[] args) {
        int[] digits = {7,1,5,3,6,4};
        System.out.println(maxProfit(digits));
    }

    /**
     * 精简不需要的变量和判断式
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice)
                minPrice = prices[i];
            else if (prices[i] - minPrice > profit)
                profit = prices[i] - minPrice;
        }
        return profit;
    }
}
