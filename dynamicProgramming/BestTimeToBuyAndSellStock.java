// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
// Catgorized as a DP problem but not quite a DP
// O(N)
class BestTimeToBuyAndSellStock {

    // Approach: Find the largest price after each valley. The difference could be maxProfit
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if ((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    // o(n^2)
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) { // TIP SEE it runs to prices.length - 1
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) maxprofit = profit;
            }
        }
        return maxprofit;
    }

}