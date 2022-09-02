package dynamicProgramming;


//https://leetcode.com/problems/longest-palindromic-substring/solution/
public class LongestPalindromeSubString {

    private boolean isSubStringPalindrome(String s, int start, int end) {
        StringBuilder strBuilder = new StringBuilder(s.substring(start, end + 1));

        boolean flag = false;
        flag = strBuilder.toString().equals(strBuilder.reverse().toString());

        return flag;
    }

    // O(N ^ 3) time complexity
    // Approach1: Check each combination of substring (i, j -1) to ensure it is a substring
    public String longestPalindromeA1(String s) {

        int res = 0;
        String max = new String();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isSubStringPalindrome(s, i, j)) {
                    res = Math.max(res, j - i + 1);
                    if (res == s.substring(i, j + 1).length()) {
                        max = s.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println(max);
        return max;
    }

    // O(n ^2)
    // This yields a straight forward DP solution, which we first initialize the one and two letters palindromes,
    // and work our way up finding all three letters palindromes, and so on...

    // In fact, we could solve it in O(n^2) time using only constant space.
    //
    //We observe that a palindrome mirrors around its center. Therefore, a palindrome can be expanded from its center, and there are only 2n−12n - 12n−1 such centers.
    //
    //You might be asking why there are 2n−12n - 12n−1 but not nnn centers? The reason is the center of a palindrome can be in between two letters. Such palindromes have even number of letters (such as "abba") and its center are between the two 'b's.
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
