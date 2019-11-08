package com.example.leetcodedemo.array.easy;

/**
 * Created by wcxdhr on 2019/8/22.
 */

public class BestTimetoBuyandSellStockII {

    public static void main(String[] args) {
        int[] digits = {1,2,1,2,3,2,1};
        System.out.println(maxProfit(digits));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1])
                maxProfit += prices[i + 1] - prices[i];
        }
        return maxProfit;
    }
}
