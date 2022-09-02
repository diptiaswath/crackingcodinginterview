package dynamicProgramming;

// https://leetcode.com/problems/coin-change/solution/

// RECURSIVE + (Recursive + Memo)
public class CoinChangeToMakeAmountS {

    // Approach1 : Recursion
    // Space O(S), where S = amount
    // Time O(S^N), where N is the # of denominations in coins
    public int coinChange(int[] coins, int amount) {
        return recurseHelper(coins, amount);
    }

    private int recurseHelper(int[] coins, int remain) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;

        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = recurseHelper(coins, remain - coin);
            if (count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }

        return minCount == Integer.MAX_VALUE? -1 : minCount;
    }

    // Approach2: Top down with memo
    // Time O (S * N)
    // Space O(S)
    private Integer[] memo = null;
    public int coinChangeA2(int[] coins, int amount) {
        memo = new Integer[amount + 1];
        return recurseHelperA2(coins, amount);
    }

    private int recurseHelperA2(int[] coins, int remain) {
        if (remain < 0) return -1;
        if (remain == 0) return 0;

        if (memo[remain] != null) return memo[remain];

        // Compute each subproblem with N iterations, where N is the number of denominations
        int minCount = Integer.MAX_VALUE;
        for (int coin : coins) {
            int count = recurseHelperA2(coins, remain - coin);
            if (count == -1) continue;
            minCount = Math.min(minCount, count + 1);
        }

        memo[remain] = (minCount == Integer.MAX_VALUE? -1 : minCount);
        return memo[remain];
    }

}
