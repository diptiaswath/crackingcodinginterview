// https://leetcode.com/problems/alien-dictionary/
class Solution {


    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjList = new HashMap<>();
        Map<Character, Integer> incomingEdgeCount = new HashMap<>();

        // Step1. Init adjacency list for all letters in the words.
        // Also, init incomingEdge counts for all letters
        for (String word: words) {
            for (char c : word.toCharArray()) {
                adjList.put(c, new ArrayList<Character>());
                incomingEdgeCount.put(c, 0);
            }
        }

        // Step2. Build the adjacency list
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            // If word2 is a prefix of word1
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    incomingEdgeCount.put(word2.charAt(j), incomingEdgeCount.get(word2.charAt(j))+ 1);
                    adjList.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        // Step3. BFS
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : incomingEdgeCount.keySet()) {
            if (incomingEdgeCount.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            Character curChar = queue.poll();
            sb.append(curChar);

            for (Character neighChar : adjList.get(curChar)) {
                incomingEdgeCount.put(neighChar, incomingEdgeCount.get(neighChar) - 1);
                if (incomingEdgeCount.get(neighChar) == 0) {
                    queue.add(neighChar);
                }
            }
        }

        if (sb.length() < incomingEdgeCount.size()) {
            return "";
        }
        return sb.toString();

    }


}