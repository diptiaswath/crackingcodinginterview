package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/explore/interview/card/google/62/recursion-4/3078/
// Time complexity: O(4^N * N)where N is the length of digits.
// Note that 4 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.
public class LetterCombinationOfStringPhoneNumber {
    public void backtrack(int index, StringBuilder path, String digits, Map<Character, String[]> letters, List<String> combinations) {
        if (path.length() == digits.length()) {
            combinations.add(path.toString());
            return;
        }

        char digit = digits.charAt(index);
        String[] possibleLetters = letters.get(digit);
        for (String letter : possibleLetters) {
            path.append(letter);
            backtrack(index + 1, path, digits, letters, combinations);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String[]> digitsMapping = new HashMap<>();
        digitsMapping.put('1', new String[]{""});
        digitsMapping.put('2', new String[]{"a", "b", "c"});
        digitsMapping.put('3', new String[]{"d", "e", "f"});
        digitsMapping.put('4', new String[]{"g", "h", "i"});
        digitsMapping.put('5', new String[]{"j", "k", "l"});
        digitsMapping.put('6', new String[]{"m", "n", "o"});
        digitsMapping.put('7', new String[]{"p", "q", "r", "s"});
        digitsMapping.put('8', new String[]{"t", "u", "v"});
        digitsMapping.put('9', new String[]{"w", "x", "y", "z"});
        backtrack(0, new StringBuilder(), digits, digitsMapping, combinations);

        return combinations;
    }
}
