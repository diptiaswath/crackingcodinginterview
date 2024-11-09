package breadthFirstSearch;

import java.util.*;

// Given two words, beginWord and endWord, and a dictionary wordList,
// return the number of words in the shortest transformation sequence from beginWord to endWord,
// or 0 if no such sequence exists.
// https://leetcode.com/problems/word-ladder/

// O (m^2 * n) where m is length of each word, and n = number of words
class Pair<String, Integer> {
    String word;
    Integer level;

    public Pair(String word, Integer level) {
        this.word = word;
        this.level = level;
    }
}

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> allDict = new HashMap<String, List<String>>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) { // TIP : IMPORTANT
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1);

                List<String> transforms = allDict.getOrDefault(newWord, new ArrayList<>());
                transforms.add(word);

                allDict.put(newWord, transforms);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<Pair<String, Integer>>();
        Map<String, Boolean> visited = new HashMap<String, Boolean>();

        queue.add(new Pair<>(beginWord, 1));
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> currentWordPair = queue.poll();
            String currentWord = currentWordPair.word;
            Integer currentWordLevel = currentWordPair.level;

            for (int i = 0; i < currentWord.length(); i++) {
                String transform = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);

                for (String neighborWord: allDict.getOrDefault(transform, new ArrayList<>())) {
                    if (neighborWord.equals(endWord)) {
                        return currentWordLevel + 1;
                    }

                    if (!visited.containsKey(neighborWord)) {
                        queue.add(new Pair<>(neighborWord, currentWordLevel + 1));
                        visited.put(neighborWord, true);
                    } // IF
                } // close for for all neigh of transformed word
            } // for each index of current word
        } // while
        return 0;
    }


}
