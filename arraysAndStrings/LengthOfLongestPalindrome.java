import java.util.*;
// Given a string s, find the length of the longest palindrome that can be formed using characters from string

// https://www.educative.io/courses/grokking-coding-interview-patterns-java/longest-palindrome
public class Solution {
    public static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        // Create a character frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        // Iterate through the frequencies and calculate pairs of each character that can be formed
        int pairCount = 0;
        for (Integer cFreq : freqMap.values()) {
            pairCount += (int) cFreq/2;
        }

        // Multiply pairCount by 2 to find length of longest palindrome of even length
        int posLength = pairCount * 2;

        // if length of longest palindrome of even length < input string length, add 1 to account for odd length palindrome
        return (posLength < s.length()? posLength + 1 : posLength);

    }
}
