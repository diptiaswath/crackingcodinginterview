// Non DP solution. Build on the brute and is O(n).
// Instead of checking if every pair of substrings in pairs is a valid parenthesis, scan the string once
// Check if the string scanned so far is valid.
// Find the length of the longest valid string.
// In order to do so, we start by pushing −1 onto the stack. For every ‘(’ encountered, we push its index onto the stack.
// For every ‘)’ encountered, we pop the topmost element. Then, the length of the currently encountered valid string of parentheses will
// be the difference between the current element's index and the top element of the stack.

public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else { // when s.charAt(i) == ')'
            stack.pop();
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                maxLen = Math.max(maxLen, i - stack.peek());
            }
        }
    }
    return maxLen;
}