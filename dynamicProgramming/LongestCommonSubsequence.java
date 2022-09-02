package dynamicProgramming;

// https://leetcode.com/problems/longest-common-subsequence/solution/
public class LongestCommonSubsequence {

    // Approach1: o(m*n)
    private int[][] memo;
    private String text1;
    private String text2;

    public int longestCommonSubsequence(String text1, String text2) {

        // Make the memo big enough to hold the cases where the pointers
        // go over the edges of the strings.
        this.memo = new int[text1.length() + 1][text2.length() + 1];

        // We need to initialise the memo array to -1's so that we know
        // whether or not a value has been filled in. Keep the base cases
        // as 0's to simplify the later code a bit.
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                this.memo[i][j] = -1;
            }
        }
        this.text1 = text1;
        this.text2 = text2;
        return memoSolve(0, 0);
    }

    private int memoSolve(int p1, int p2) {
        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        // Recursive cases.
        int answer = 0;
        if (text1.charAt(p1) == text2.charAt(p2)) {
            answer = 1 + memoSolve(p1 + 1, p2 + 1);
        } else {
            answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
        }

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = answer;
        return memo[p1][p2];
    }




    // Approach2: DP : For a cell (row, col), we look at whether or not text1.charAt(row) == text2.charAt(col) is true.
    // if it is, then we set grid[row][col] = 1 + grid[row + 1][col + 1].
    // Otherwise, we set grid[row][col] = max(grid[row + 1][col], grid[row][col + 1]).

    public int longestCommonSubsequenceDP(String text1, String text2) {

        //  // Make a grid of 0's with text2.length() + 1 columns
        //    // and text1.length() + 1 rows.
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int col = text2.length() - 1; col >=0; col--) {
            for (int row = text1.length() - 1; row >=0; row--) {
                if (text1.charAt(row) == text2.charAt(col)) {
                    dp[row][col] = 1 + dp[row + 1][col + 1];
                } else {
                    dp[row][col] = Math.max(dp[row+1][col], dp[row][col+1]);
                }
            }
        }

        return dp[0][0];
    }

}
