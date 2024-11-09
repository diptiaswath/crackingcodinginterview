// https://leetcode.com/problems/longest-common-prefix/submissions/1307751797/

// Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
class Solution {
    // O(N) where N = sum of all characters in all strings
    // O(1) space
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Take 1st string as longestCommonPrefix
        String prefix = strs[0];

        // Loop through the remainder of strs from 1 to end
        for (int i = 1; i < strs.length; i++) {
            // if substring prefix is not found at the beginning of the string strs[i], drop last character of prefix
            while (!strs[i].startsWith(prefix)) { // you can also do strs[i].indexOf(prefix) != 0

                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    // Approach2: With Binary Search O(N log M) where M = LENGTH OF SHORTEST STRING AND N = sum of all characters of all strings in strs
    public String longestCommmonPrefixBinSearch(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Find the shortest length string in strs
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            minLen = Math.min(minLen, strs[i].length());
        }

        // we are assuming this minLen is the prefix length,
        // we are going to bin search to see if there exists a prefix of longer/shorter length than minLen
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid + 1; // if yes, check if even longer length prefix exists
            } else {
                high = mid - 1; // if not, check if shorter length prefix exists
            }
        }
        return strs[0].substring(0, (low+ high)/2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}