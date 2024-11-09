// Given a string, s, return the number of palindromic substrings contained in it. A substring is a contiguous sequence of characters in a string. A palindrome is a phrase, word, or sequence that reads the same forward and backward.
// O(n^2) solution
// Problem is https://www.educative.io/courses/grokking-coding-interview-patterns-java/palindromic-substrings
// Used Chat GPT for optimal solution. You can also tweak O(n^3) solution to get the count
public static int countPalindromicSubstrings(String s) {
    int n = s.length();
    if (n == 0) {
        return 0;
    }

    int count = 0;

    for (int center = 0; center < 2 * n - 1; center++) {
        int left = center / 2;
        int right = left + center % 2;

        while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    return count;
}