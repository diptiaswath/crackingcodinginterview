// This can be solved as a DP problem, but hard to understand.
// Using BFS here instead with O(N^3 + m * k), where n = length of string s, m = no of words in wordDict and k = average length of words in wordDict

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//Note that the same word in the dictionary may be reused multiple times in the segmentation.
// https://leetcode.com/problems/word-break/

public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> words = new HashSet<>(wordDict);
    Queue<Integer> queue = new LinkedList<>();
    boolean[] seen = new boolean[s.length() + 1];

    queue.add(0);
    while (!queue.isEmpty()) {
        int start = queue.remove();
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (seen[end]) {
                continue;
            }

            if (words.contains(s.substring(start, end))) {
                queue.add(end);
                seen[end] = true;
            }
        }
    }
    return false;
}