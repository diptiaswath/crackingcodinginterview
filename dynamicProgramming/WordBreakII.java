// https://www.educative.io/courses/grokking-coding-interview-patterns-java/word-break-ii
// Statement
//You are given a string, s, and an array of strings, wordDict, representing a dictionary.
// Your task is to add spaces to s to break it up into a sequence of valid words from wordDict. We are required to return an array of all possible sequences of words (sentences). The order in which the sentences are listed is not significant.

import java.util.*;
class Main {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> output = new ArrayList<>();
        Set<String> words = new HashSet<>(wordDict);

        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>(Arrays.asList(0))); // Start with position 0

        while (!queue.isEmpty()) {
            List<Integer> path = queue.remove();
            int start = path.get(path.size() - 1);

            for (int end = start + 1; end <= s.length(); end++) {
                if (words.contains(s.substring(start, end))) {
                    List<Integer> newPath = new ArrayList<>(path);
                    newPath.add(end);
                    if (end == s.length()) {
                        StringBuilder sentence = new StringBuilder();
                        for (int k = 0; k < newPath.size() - 1; k++) {
                            int wordStart = newPath.get(k);
                            int wordEnd = newPath.get(k + 1);
                            sentence.append(s.substring(wordStart, wordEnd));
                            if (k < newPath.size() - 2) {
                                sentence.append(" ");
                            }
                        }
                        output.add(sentence.toString());
                    } else { // if end!= s.length()
                        queue.add(newPath);
                    }
                }
            } // end of if words.contains
        }

        return output;
    }

}