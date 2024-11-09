package arrays;

import java.util.Map;

//https://leetcode.com/problems/roman-to-integer/submissions/
public class RomanToInteger {
    private Map<Character, Integer> lookup = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public int romanToInt(String s) {
        int intValue = 0; int i = 0;

        while (i < s.length()) {
            int curValue = lookup.get(s.charAt(i));
            int nextValue = 0;

            if (i + 1 < s.length()) {
                nextValue = lookup.get(s.charAt(i+1));
            }

            if (curValue < nextValue) {
                intValue += (nextValue - curValue);
                i += 2;
            } else {
                intValue += curValue;
                i++;
            }
        }

        return intValue;
    }
}
