// https://leetcode.com/problems/design-add-and-search-words-data-structure/

class TrieNode {
    // HashMap to store children nodes
    private HashMap<Character, TrieNode> links;
    private boolean isEnd;

    public TrieNode() {
        links = new HashMap<>();
    }

    public boolean containsKey(char ch) {
        return links.containsKey(ch);
    }

    public TrieNode get(char ch) {
        return links.get(ch);
    }

    public void put(char ch, TrieNode node) {
        links.put(ch, node);
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}


class WordDictionary {
    TrieNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char curCh = word.charAt(i);
            if (!node.containsKey(curCh)) {
                node.put(curCh, new TrieNode());
            }
            node = node.get(curCh);
        }
        node.setEnd();
    }

    /**
     * Returns if the word is in the Trie
     * O (N * 26 ^ M) where N = numer of words, M = length of each word = this is complexity when word contains a .
     * without a dot O(M)
     */
    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                // if the current character is '.'
                // check all possible nodes at this level
                if (ch == '.') { // TIP: THIS IS WHERE WordDictionary is different
                    for (char x = 'a'; x <= 'z'; x++) {
                        TrieNode child = node.get(x);
                        if (child != null && searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }

                // if no nodes lead to answer
                // or the current character != '.'
                return false;
            } else {
                // if the character is found
                // go down to the next level in trie
                node = node.get(ch);
            }
        }// end of for
        return node.isEnd();
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchInNode(word, root);
    }
}


// TIP: 1. Implement TrieNode with a HashMap instead of an array
// Tip  2. a word could contain a . - then in that case, need to tweak search() and searchInNode() a bit