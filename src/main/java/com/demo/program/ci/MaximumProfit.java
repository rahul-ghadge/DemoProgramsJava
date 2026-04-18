package com.demo.program.ci;

public class MaximumProfit {

    public static void main(String[] args) {
        int[] prices = {7, 5, 5, 1, -3, 6, 4}; // Example input
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            System.out.println(minPrice + " : " + prices[i] + " : " + (prices[i] - minPrice) + " : " + maxProfit);
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }

        return maxProfit;
    }
}

//-----------------------------------------------------------------------------
//        Output
//-----------------------------------------------------------------------------
//        7 : 5 : -2 : 0
//        5 : 5 : 0 : 0
//        5 : 1 : -4 : 0
//        1 : -3 : -4 : 0
//        -3 : 6 : 9 : 0
//        -3 : 4 : 7 : 9
//        Maximum Profit: 9
