// In an alien language, surprisingly, they also use English lowercase letters,
// but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.

// Given a sequence of words written in the alien language, and the order of the alphabet,
// return true if and only if the given words are sorted lexicographically in this alien language.

// https://leetcode.com/problems/verifying-an-alien-dictionary/description/
class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        // Make orderMap = what order each letter appears
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        // Iterate over pairs of words
        // To compare two adjacent words words[i] and words[i+1],
        //  we want to find the first letter that is different:

        // if words[i] has the lexicographically smaller letter,
        // then we can exit from the iteration because we know words[i] and words[i+1] are in the right order;

        // however, if words[i] has the lexicographically larger letter, then we immediately return false,
        // because we found one pair of words that are in the wrong order.
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            // when word2 is a prefix of word1 (app is a prefix of apple, word2= educate is a prefix of word1=educated)
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return false;
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                int word1Char = word1.charAt(j) - 'a';
                int word2Char = word2.charAt(j) - 'a';
                if (word1Char != word2Char) {
                    if (orderMap[word1Char] > orderMap[word2Char]) { // first different letter and in order map, letter order is: word1's letter > word2's letter
                        return false;
                    } else {
                        break; // we found the first different letter and word1's letter is lexicographically smaller than word2's
                    }
                }
            } // end of for-j
        }
        return true;
    }
}

//TIP: NO NEED TO DO BFS unlike alien dict