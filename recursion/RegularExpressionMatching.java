// https://leetcode.com/explore/interview/card/facebook/53/recursion-3/307/
// Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
//
//'.' Matches any single character.​​​​
//'*' Matches zero or more of the preceding element.
// The matching should cover the entire input string (not partial).
class Solution {
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                        (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch(text, pattern.substring(2)) || (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return (first_match && isMatch(text.substring(1), pattern.substring(1)));
        }
    }
}