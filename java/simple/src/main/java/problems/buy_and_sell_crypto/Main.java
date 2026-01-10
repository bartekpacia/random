package problems.buy_and_sell_crypto;

// Best Time to Buy and Sell Stock: https://neetcode.io/problems/buy-and-sell-crypto
// Best Time to Buy and Sell Stock: https://leetcode.com/problems/best-time-to-buy-and-sell-stock

public class Main {
    static void main(String[] args) {
        //@formatter:off
        int[][] prices = {
                {10, 1, 5, 6, 7, 1},
                {10, 8, 7, 5, 2},
                {7, 1, 5, 3, 6, 4},
        };
        //@formatter:on
        for (int i = 0; i < prices.length; i++) {
            int[] price = prices[i];
            System.out.println("Test case " + i + ", max profit: " + new Solution().maxProfit(price));
        }
    }
}

class Solution {
    public int maxProfit(int[] prices) {
        // Track the minimum price seen so far,
        // and at each step calculate the profit if you sold today.
        int left = 0; // buy
        int right = 1; // sell
        int maxProfit = 0;
        while (right <= prices.length - 1) {
            int profit = prices[right] - prices[left];
            if (profit > maxProfit) {
                maxProfit = profit;
            } else if (profit < 0) {
                left = right;
                System.out.println("reset left to be right");
            }
            right++;
        }

        return maxProfit;
    }
}

