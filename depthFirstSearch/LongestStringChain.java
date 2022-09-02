package depthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-string-chain/solution/
// Top down dynamic programming (Recursion + memoization)
public class LongestStringChain {

    private int dfs(String currentWord, Set<String> allSeenWords, Map<String, Integer> memo) {
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }

        int maxLen = 1;
        StringBuilder sb = new StringBuilder(currentWord);

        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            if (allSeenWords.contains(newWord)) {
                int curLen = 1 + dfs(newWord, allSeenWords, memo);
                maxLen = Math.max(maxLen, curLen);
            }
            sb.insert(i, currentWord.charAt(i));
        }

        memo.put(currentWord, maxLen);
        return maxLen;
    }

    public int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<String, Integer>();

        Set<String> allSeenWords = new HashSet<String>();
        for (String word : words) {
            allSeenWords.add(word);
        }

        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, dfs(word, allSeenWords, memo));
        }

        return ans;



    }
}
