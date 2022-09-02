package arrays;

import java.util.Arrays;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
public class FindWordsFormedFromChars {

    public int countCharacters(String[] words, String chars) {
        int[] letters = new int[128];
        for (int i = 0; i < chars.length(); i++) {
            letters[chars.charAt(i) - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            int[] copy = Arrays.copyOf(letters, letters.length);
            boolean pass = true;
            for (int i = 0; i < word.length(); i++) {
                if (--copy[word.charAt(i) - 'a'] < 0) {
                    pass = false;
                    break;
                }
            }
            if (pass) {
                result += word.length();
            }
        }
        return result;
    }
}
