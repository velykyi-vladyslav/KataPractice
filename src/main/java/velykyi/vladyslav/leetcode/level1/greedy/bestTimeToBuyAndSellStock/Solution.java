package velykyi.vladyslav.leetcode.level1.greedy.bestTimeToBuyAndSellStock;

/**
 * Leetcode task: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">best-time-to-buy-and-sell-stock</a>
 *
 * <p> You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p> You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock.
 * <p> Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 * <p> Example:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * <p> Explanation:
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
@SuppressWarnings("unused")
public class Solution {
    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfitFinal(prices));
    }

    /**
     * Time limit exceeded, one of two loops is redundant.
     */
    public static int maxProfit1(int[] prices) {
        int max = 0;
        int currentMax;

        for (int buy = 0; buy < prices.length - 1; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                currentMax = prices[sell] - prices[buy];
                if (max < currentMax) {
                    max = currentMax;
                }
            }
        }

        return max;
    }

    /**
     * <p> Intuition: to find minimum value and calculate from it maximum profit, if it not work - find next possible min.
     * <p> Approach: find min each time and start counting maxProfit from it,
     * if no min found - try to check profit from the previous one
     * <p> Time complexity: O(n)
     * <p> Space complexity: O(1)
     */
    public static int maxProfitFinal(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (maxProfit < price - min) {
                maxProfit = price - min;
            }
        }

        return maxProfit;
    }
}
