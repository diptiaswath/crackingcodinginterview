package arrays;

//
// You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

// On each day, you may decide to buy and/or sell the stock.
// You can only hold at most one share of the stock at any time.
// However, you can buy it then immediately sell it on the same day.

// Find and return the maximum profit you can achieve.


// This solution follows the logic used in Approach 2 itself,
// but with only a slight variation. In this case, instead of looking for every peak following a valley,
// we can simply go on crawling over the slope and keep on adding the profit obtained from every consecutive transaction.
// In the end,we will be using the peaks and valleys effectively, but we need not track the costs corresponding to the peaks and valleys along with the maximum profit, but we can directly keep on adding the difference between the consecutive numbers of the array if the second number is larger than the first one, and at the total sum we obtain will be the maximum profit.
public class MaxProfit {

        // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
        public int maxProfit(int[] prices) {

            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i-1]) {
                    System.out.println("prices[i] = " + prices[i] + " , prices[i-1] = " + prices[i-1]);
                    maxProfit += (prices[i] - prices[i-1]);
                }
            }
            return maxProfit;
        }
}
