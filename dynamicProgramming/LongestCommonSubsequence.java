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

    // O (m * n)
    private int memoSolve(int p1, int p2) {
        // Check whether or not we've already solved this subproblem.
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        // Recursive cases.
        int answer = 0;
        // first character of each string is the same, the length of the longest common subsequence is 1 + LCS(p1 + 1, p2 + 1)
        if (text1.charAt(p1) == text2.charAt(p2)) {
            answer = 1 + memoSolve(p1 + 1, p2 + 1);
        } else {
            // else max of LCS(p1, p2 + 1) and LCS(p1 + 1, p2)
            answer = Math.max(memoSolve(p1, p2 + 1), memoSolve(p1 + 1, p2));
        }

        // Add the best answer to the memo before returning it.
        memo[p1][p2] = answer;
        return memo[p1][p2];
    }



    // O(m * n ^2)

    int[][] memo;
    String text1;
    String text2;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }
        this.memo = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return memoSolve(0, 0);
    }

    private int memoSolve(int p1, int p2) {
        // This also covers the base cases where p1 == text1.length
        // or p2 == text2.length.
        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        // Option1: when we don't include text1[p1] in the solution
        int option1 = memoSolve(p1 + 1, p2);

        // Option2: we include text1[p1] in the solution as long as a
        // match for it is in text2 at or after p2
        int option2 = 0;
        int firstOccurence = text2.indexOf(text1.charAt(p1), p2);
        if (firstOccurence != -1) {
            option2 = 1 + memoSolve(p1 + 1, firstOccurence + 1);
        }

        memo[p1][p2] = Math.max(option1, option2);
        return memo[p1][p2];
    }



}
