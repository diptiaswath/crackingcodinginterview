package backtracking;

import java.util.ArrayList;
import java.util.List;
// Strings are of length 2n. Each position you have 2^2n = 4 ^n

// Use Leetcode: https://leetcode.com/problems/generate-parentheses/editorial/
public class GenerateParenthesis {
    private static void backtrack(List<String> result, StringBuilder curString, int leftCount, int rightCount, int n) {
        if (curString.length() == 2*n) {
            result.add(curString.toString());
            return;
        }
        if (leftCount < n) {
            curString.append("(");
            backtrack(result, curString, leftCount+1, rightCount, n);
            curString.deleteCharAt(curString.length() - 1);
        }
        if (leftCount > rightCount) {
            curString.append(")");
            backtrack(result, curString, leftCount, rightCount+1, n);
            curString.deleteCharAt(curString.length() - 1);
        }
    }
    public static ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        backtrack(result, new StringBuilder(), 0, 0 , n);
        return result;
    }
}
