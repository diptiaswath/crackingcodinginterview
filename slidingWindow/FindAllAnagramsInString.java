// Find all anagrams of p in s. Return the start indices of s that have p's anagram
// https://leetcode.com/problems/find-all-anagrams-in-a-string/
// O(length of String s) = linear time complexity
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        int[] sMap = new int[26];
        int[] pMap = new int[26];

        for (int i = 0; i < pLength; i++) {
            pMap[p.charAt(i) - 'a']++;
        }

        List<Integer> output = new ArrayList<>();
        //  // sliding window on the string s
        for (int i = 0; i < sLength; i++) {
            // add one char from right into sMap
            sMap[s.charAt(i) - 'a']++;

            // drop one char from left
            if (i >= pLength) {
                sMap[s.charAt(i - pLength) - 'a']--;
            }

            if (Arrays.equals(sMap, pMap)) {
                output.add(i - pLength + 1);
            }
        }
        return output;
    }
}