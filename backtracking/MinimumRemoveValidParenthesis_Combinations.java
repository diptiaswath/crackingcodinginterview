import java.util.*;
// https://leetcode.com/problems/remove-invalid-parentheses/

// Approach:
// Initialize a set to store valid expressions and a variable to keep track of the minimum number of removals required (minRemoved).
// Define a recursive function (recurse) to generate valid expressions by exploring all possible combinations of removing parentheses.
// Within the recurse function:
/*
Base case: If we reach the end of the string (index == s.length()), check if the current expression is valid. If so, add it to the set of valid expressions.
Otherwise, recursively explore two possibilities:
Remove the current character and continue recursion (removedCount + 1).
Keep the current character and continue recursion.
After exploring all possibilities, return the set of valid expressions.
*/

class Solution {
    // Set to store valid expressions
    private Set<String> validExpressions = new HashSet<>();
    // Variable to store the minimum number of parentheses to be removed
    private int minRemoved;

    // Method to reset the state of the class variables
    private void reset() {
        validExpressions.clear();
        minRemoved = Integer.MAX_VALUE;
    }

    // Method to recursively generate valid expressions by removing invalid parentheses
    private void recurse(String s, int index, int leftCount, int rightCount, StringBuilder expression, int removedCount) {
        // Base case: If we've reached the end of the string
        if (index == s.length()) {
            // Check if the current expression is valid
            if (leftCount == rightCount) {
                // Check if the current count of removed parentheses is <= the current minimum count
                if (removedCount <= minRemoved) {
                    // Convert StringBuilder to a String
                    String possibleAnswer = expression.toString();
                    // If the current count beats the overall minimum we have till now
                    if (removedCount < minRemoved) {
                        validExpressions.clear();
                        minRemoved = removedCount;
                    }
                    validExpressions.add(possibleAnswer); // Add the valid expression to the set
                }
            }
        } else {
            char currentChar = s.charAt(index);
            int length = expression.length();

            // If the current character is neither an opening bracket nor a closing one,
            // simply recurse further by adding it to the expression StringBuilder
            if (currentChar != '(' && currentChar != ')') {
                expression.append(currentChar);
                recurse(s, index + 1, leftCount, rightCount, expression, removedCount);
                expression.deleteCharAt(length);
            } else {
                // Recursion where we delete the current character and move forward
                recurse(s, index + 1, leftCount, rightCount, expression, removedCount + 1);

                expression.append(currentChar);
                // If it's an opening parenthesis, consider it and recurse
                if (currentChar == '(') {
                    recurse(s, index + 1, leftCount + 1, rightCount, expression, removedCount);
                } else if (rightCount < leftCount) {
                    // For a closing parenthesis, only recurse if right < left
                    recurse(s, index + 1, leftCount, rightCount + 1, expression, removedCount);
                }

                // Undoing the append operation for other recursions.
                expression.deleteCharAt(length);
            }
        }
    }

    // Method to remove invalid parentheses from the input string
    public List<String> removeInvalidParentheses(String s) {
        // Reset the state
        reset();
        // Start recursive backtracking to generate valid expressions
        recurse(s, 0, 0, 0, new StringBuilder(), 0);
        // Convert the set of valid expressions to a list and return
        return new ArrayList<>(validExpressions);
    }
}
