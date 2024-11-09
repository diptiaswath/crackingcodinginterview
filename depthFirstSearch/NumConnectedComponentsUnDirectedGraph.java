// You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
//
//Return the number of connected components in the graph.
//
// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/description/

// Approach: In an undirected graph, a connected component IS a subgraph in which each pair of vertices is
// connected via a path. So essentially, all vertices in a connected component are reachable from one another.

// Create an adjacency list such that adj[v] contains all the adjacent vertices of vertex v.
//Initialize a hashmap or array, visited, to track the visited vertices.
//Define a counter variable and initialize it to zero.
//Iterate over each vertex in edges, and if the vertex is not already in visited, start a DFS from it. Add every vertex visited during the DFS to visited.
//Every time a new DFS starts, increment the counter variable by one.
//At the end, the counter variable will contain the number of connected components in the undirected graph.
class Solution {

    public int countComponents(int n, int[][] edges) {
        if (n == 0) {
            return 0;
        }

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int components = 0;

        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]==0) {
                components++; // TIP: THIS IS IT
                dfs(adjList, visited, i);
            }
        }
        return components;

    }

    private void dfs(List<List<Integer>> adjList, int[] visited, int curNode) {
        visited[curNode] = 1;
        for (Integer neighNode: adjList.get(curNode)) {
            if (visited[neighNode] == 0) {
                dfs(adjList, visited, neighNode);
            }
        }
    }
}