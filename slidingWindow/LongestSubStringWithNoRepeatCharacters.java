// https://leetcode.com/explore/interview/card/facebook/5/array-and-strings/3008/
class LongestSubStringWithNoRepeatCharacters {

    // Correct approach - O(n)
    public int lengthOfLongestSubstringWithMap(String s) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        for (int right  = 0; right < s.length(); right++) {
            char curChar = s.charAt(right);
            if (charMap.containsKey(curChar) && charMap.get(curChar) >= left) {
                left = charMap.get(curChar) + 1;
            }
            charMap.put(curChar, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // This is the brute force approach
    // O(n ^ 2)
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            StringBuilder result = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (result.indexOf(String.valueOf(s.charAt(j))) != -1) {
                    break;
                }
                result.append(s.charAt(j));
                maxLength = Math.max(maxLength, result.length());
            }
        }
        return maxLength;
    }
}