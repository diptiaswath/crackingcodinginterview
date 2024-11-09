// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
//In other words, return true if one of s1's permutations is the substring of s2.
// https://leetcode.com/problems/permutation-in-string/description/
// Time : O(l1 + 26 * (l2 - l1))
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] s1Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }

        // We can consider every possible substring in the long string s2 of the same length as that of s1 and
        // check the frequency of occurence of the characters appearing in the two.
        for (int i=0; i <= s2.length() - s1.length(); i++) {
            int[] s2Map = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                s2Map[s2.charAt(i+j) - 'a']++;
            }
            if (isMatches(s1Map, s2Map)) {
                return true;
            }
        }
        return false;
    }

    private boolean isMatches(int[] s1Map, int[] s2Map) {
        for (int i = 0; i< 26;i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}