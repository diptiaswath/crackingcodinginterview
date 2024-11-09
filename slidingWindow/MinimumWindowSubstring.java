// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/285/
// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s
// such that every character in t (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".

// Solution: explained in https://leetcode.com/problems/minimum-window-substring/


class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        if (s.isEmpty() || t.isEmpty()) return "";

        // Count of all unique characters in t
        Map<Character, Integer> dictT = new HashMap<>();
        for (char c : t.toCharArray()) {
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        // no of unique chars in T
        int required = dictT.size();

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};

        while (r < s.length()) {
            char c = s.charAt(r);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).equals(dictT.get(c))) {
                formed++;
            }

            while (l <= r && formed == required) {
                c = s.charAt(l);
                if (ans[0] == -1 || r - l + 1 < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c) < dictT.get(c)) {
                    formed--;
                }
                l++;
            } // end of inner while l<=r
            r++;
        } // end of outer while r < s.length

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}