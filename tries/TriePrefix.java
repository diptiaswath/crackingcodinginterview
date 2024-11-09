// https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode {
    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}


class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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

    private TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curCh = word.charAt(i);
            if (!node.containsKey(curCh)) {
                return null;
            }
            node = node.get(curCh);
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

// PROBLEM: Check if word1 is a prefix of word2
public boolean checkIfPrefix(String word1, String word2) {
    // check if word1 is prefix of word2
    if (word2 == null || word1 == null || word1.length() == 0 || word2.length() == 0 || word1.length() > word2.length()) {
        return false;
    }

    Trie trie = new Trie();
    trie.insert(word2);
    return trie.startsWith(word1);
}
/** THIS IS IMPORTANT
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */