// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
// Use the solution from educative.io - easier to understand

// 1. Traverse the string, while keeping track of the parenthesis alongside their indices in the stack.
// 2. If matched parenthesis is found, remove it from the stack.
// 3. Once the string has been traversed, we will be left only with the unmatched parentheses in the stack.
// 4. Create a new string without including the characters at indices still present in the stack.
class MinRemoveValidParenthesis {

    public String minRemoveToMakeValid(String s) {
        Stack<int[]> stack = new Stack();
        char[] sArray = s.toCharArray();

        int i = 0;
        for (char cur: sArray) {
            if (!stack.isEmpty() && stack.peek()[0] == '(' && cur == ')') {
                stack.pop();
            } else if (cur == '(' || cur == ')') {
                stack.push(new int[] {cur, i});
            }
            i++;
        }

        while (!stack.isEmpty()) {
            sArray[stack.pop()[1]] = '';
        }

        StringBuilder result = new StringBuilder();
        for (char c : sArray) {
            if (c != '') {
                result.append(c);
            }
        }
        return result.toString();
    }


}