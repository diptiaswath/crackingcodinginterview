// https://leetcode.com/problems/longest-valid-parentheses/editorial/
// o(n^3)
// Approach: for each substring of s (in pairs), check if a valid () can be formed
class Solution {

    // Every time we
    // encounter a ‘(’, we push it onto the stack. For every ‘)’ encountered, we pop a ‘(’ from the stack. If ‘(’ isn't
    // available on the stack for popping at anytime or if stack contains some elements after processing complete substring,
    // the substring of parentheses is invalid.
    public boolean isvalid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.isEmpty() && stack.peek() == '(') { // if s.charAt(i) == ')'
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    // Main Function
    public int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+2; j <= s.length(); j+=2) {
                if (isvalid(s.substring(i,j))) {
                    maxLen = Math.max(maxLen, j - i);
                }
            }
        }
        return maxLen;
    }
}
