package dynamicProgramming;

// https://leetcode.com/problems/climbing-stairs/solution/

// RECURSIVE + DP
public class ClimbStairs {
    // O(n) time complexity
    // Using memoization
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return climbStairs(0, n, memo);
    }

    private int climbStairs(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climbStairs(i + 1, n, memo) + climbStairs(i+2, n, memo);
        return memo[i];
    }


    //O(n) time complexity
    // no of ways to climb ith step = no of ways to climb i-1th step + no of ways to climb i-2th step
    // dynamicProgramming[i] = dynamicProgramming [i-1] + dynamicProgramming[i-2]
    int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    // O(2^n) for recursive approach
    // n this brute force approach we take all possible step combinations i.e. 1 and 2, at every step.
    // At every step we are calling the function climbStairs for step 1 and 2, and
    // return the sum of returned values of both functions.
    //
    //climbStairs(i,n)= climbStairs(i+1,n) + climbStairs(i+2,n)
    //where i defines the current step and n defines the destination step.
    private int climb(int i, int n) {
        if (i == n) {
            return 1;
        }
        if (i > n) {
            return 0;
        }
        return climb(i+1, n) + climb(i+2, n);
    }


    public int climbStairsRecursive(int n) {
        return climb(0, n);
    }
}
