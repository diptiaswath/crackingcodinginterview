package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface Master {
    int guess(String w);
}

// https://leetcode.com/problems/guess-the-word/
// explanation in : https://www.youtube.com/watch?v=AYF3pPWRJ6o
public class GuessTheWord {

    public void findSecretWord(String[] words, Master master) {
        List<String> list = new ArrayList<>(Arrays.asList(words));

        while (!list.isEmpty()) {
            int midIdx = list.size() / 2;

            String guessWord = list.get(midIdx);

            int nMatches = master.guess(guessWord);

            if (nMatches == 6) {
                return;
            }

            list.removeIf(eachWord -> helper(guessWord, eachWord) != nMatches);

        }
    }

    private int helper(String s, String t) {
        int matches = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}

