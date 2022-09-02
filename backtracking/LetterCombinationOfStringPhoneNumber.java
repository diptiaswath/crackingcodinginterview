package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//https://leetcode.com/explore/interview/card/google/62/recursion-4/3078/
// Time complexity: O(4^N * N)where N is the length of digits.
// Note that 4 in this expression is referring to the maximum value length in the hash map, and not to the length of the input.
public class LetterCombinationOfStringPhoneNumber {
    private List<String> combinations = new ArrayList<>();
    private Map<Character, String> letters = Map.of('2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz");
    private String phoneDigit;

    private void combine(int start, StringBuilder path) {
        // if new stringB is same as phoneDigits.length, then add stringB and return
        if (path.length() == phoneDigit.length()) {
            combinations.add(path.toString());
            return;
        }
        String letterDigits = letters.get(phoneDigit.charAt(start));

        // iterate over all possible letters for phone digit at start
        for (char c : letterDigits.toCharArray()) {
            path.append(c);
            combine(start + 1, path);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combinations;
        }
        this.phoneDigit = digits;
        combine(0, new StringBuilder());
        return combinations;
    }
}
