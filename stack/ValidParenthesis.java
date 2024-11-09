// https://leetcode.com/problems/valid-parentheses/editorial/
public class ValidParenthesis {
    private static Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (map.containsKey(curChar)) {
                char topElement = stack.empty()? '#' : stack.pop();

                if (topElement != map.get(curChar)) {
                    return false;
                }
            } else {
                stack.push(curChar);
            }
        }

        // if stack still contains elements, then it is invalid expression
        return stack.isEmpty();
    }
}