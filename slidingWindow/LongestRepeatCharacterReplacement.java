// This is from educative.io
// Given a string s and an integer k, find the length of the longest substring in s, where all characters are identical,
// after replacing, at most, k characters with any other lowercase English character.
// VERY CONFUSING: https://www.educative.io/courses/grokking-coding-interview-patterns-java/longest-repeating-character-replacement

class LongestRepeatCharacterReplacement {

    public static int longestRepeatCharacterReplacement(String s, int k) {
        int left = 0;
        int maxLength = 0;
        int maxFreqChar = 0;
        Map<Character, Integer> charFreqMap = new HashMap<>();

        for (int right = 0 ; right < s.length(); right++) {
            char curChar = s.charAt(right);
            charFreqMap.put(curChar, charFreqMap.getOrDefault(curChar, 0) + 1);

            maxFreqChar = Math.max(maxFreqChar, charFreqMap.get(curChar));

            if (right - left + 1 - maxFreqChar > k) {
                char leftChar = s.charAt(left);
                charFreqMap.put(leftChar, charFreqMap.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}