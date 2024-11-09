package dynamicProgramming;

//https://leetcode.com/problems/longest-palindromic-substring/solution/
//TIP CHECK
public class LongestPalindromeSubString {

    // Brute force O(n ^ 3)




    // Dynamic Programming O(n^2) Start outwards and move inward to check if substring is palindrome
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }

        int start = 0 ;
        int end = 0;

        boolean[][] dp = new boolean[n][n];

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        for (int i = n - 1; i >= 0; i ++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j-i == 1 || dp[i+1][j-1]); // all string of length 1 are palindromes, strings of length 2, 3 etc - we need to  check edges
                if (dp[i][j] && (j - i > end - start)) { // check is there is a larger length substring that is a palindrome
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
    }
}
