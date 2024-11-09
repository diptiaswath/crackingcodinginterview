// A message containing letters from A-Z can be encoded into numbers using the following mapping:
//'A' -> "1"
//'B' -> "2"
//...
//'Z' -> "26"
//To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
//
//"AAJF" with the grouping (1 1 10 6)
//"KJF" with the grouping (11 10 6)
//Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
//
//Given a string s containing only digits, return the number of ways to decode it.
//
//The test cases are generated so that the answer fits in a 32-bit integer.

// https://leetcode.com/problems/decode-ways/description/
// O(N) - BEST explanation in Video - first 10 mins uses memoization
class Solution {
    // for each index key, number of ways to decode is value
    private Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return recurseHelper(0, s);
    }

    private int recurseHelper(int index, String s) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        if (index == s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (index == s.length() - 1) {
            return 1;
        }
        int ans = recurseHelper(index+1, s);
        if (Integer.parseInt(s.substring(index, index +2)) <= 26) {
            ans += recurseHelper(index+2, s);
        }
        memo.put(index, ans);
        return ans;
    }



}