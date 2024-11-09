// https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/editorial/

class LongestSubStringWithKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int maxLength = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            charFreqMap.put(rightChar, charFreqMap.getOrDefault(rightChar , 0) + 1);
            while (charFreqMap.size() > k) {
                char leftChar = s.charAt(left);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                if (charFreqMap.get(leftChar) == 0) {
                    charFreqMap.remove(leftChar);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}