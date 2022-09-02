package dynamicProgramming;

// Cracking the coding interview Pg 132
public class Fibonacci {

    // Recursion
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fib(n - 1) + fib(n - 2));
    }

    // Top down programming - recursion with memoization
    public int fibWithMemo(int n) {
        return fibWithMemo(n, new int[n+1]);
    }

    private int fibWithMemo(int i, int[] memo) {
        if (i == 1) {
            return 1;
        }

        if (memo[i] == 0) {
            memo[i] = fibWithMemo(i-1, memo) + fibWithMemo(i-2, memo);
        }

        return memo[i];
    }

    // Bottoms-up dynamic programming
    public int fibWithDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

}
