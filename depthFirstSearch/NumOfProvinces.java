// https://leetcode.com/problems/number-of-provinces/
// There are n cities. Some of them are connected, while some are not.
// If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.
// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are
// directly connected, and isConnected[i][j] = 0 otherwise.

// UNDERSTAND THE QUESTION: Example 1: [[1,1,0], [1,1,0], [0, 0, 1]]
// There are 3 nodes Node 1, Node 2, Node 3
// Node 1's connectivity is first row = [1,1,0], isConnected(Node1 <-> Node 1) = 1, isConnected(Node1 <-> Node2) = 1, isConnected(Node1 <-> Node3) = 0
// Node 2's connectivity is second row = [1, 1, 0]
// Node 3's connectivity is third row = [0, 0, 1]

// Return the total number of provinces.
// https://leetcode.com/problems/number-of-provinces/description/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0) {
            return 0;
        }
        // TIP: NO ADJ LIST CONSTRUCTED
        int[] visited = new int[isConnected.length];
        int numComponents = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                numComponents++;
                dfs(isConnected, visited, i);
            }
        }
        return numComponents;
    }

    private void dfs(int[][] isConnected, int[] visited, int curNode) {
        visited[curNode] = 1;
        for(int i = 0 ; i < isConnected.length; i++) {
            if (visited[i] == 0 && isConnected[curNode][i] == 1) { //TIP: PAY ATTENTION TO THIS
                dfs(isConnected, visited, i);
            }
        }
    }
}

// TIP: This is an application of Number of connected components in an undirected graph.
// The # of provinces is the number of connected components in graph