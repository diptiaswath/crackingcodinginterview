// in this problem, a tree is an undirected graph that is connected and has no cycles.

//You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
// The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
// The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is
// an edge between nodes ai and bi in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes.
// If there are multiple answers, return the answer that occurs last in the input.

// https://leetcode.com/problems/redundant-connection/description/

// Consider a graph with V = {1, 2, 3, 4} and edges E = {(1, 2), (2,3), (3, 4), (1, 4), (2,4)}
// Start DFS from edge (1,2). If Node 1 can reach 2 without using edge (1, 2), then this edge is redundant
// Proceed similarly for other edges as well
class Solution {
    // Approach O(n^2): For each edge (u,v), traverse graph with DFS to see if we can connect u to v.
    // If we can, then it must be a duplicate edge. Other approach: O(n) is by Union Rank (not learned)
    Set<Integer> seen = new HashSet<>();

    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        // init adjList. if edges has duplicates, then there will be +1 for duplicate
        // a valid tree must have exactly n-1 edges.
        for (int i = 0 ; i < edges.length + 1; i++) {
            adjList.add(new ArrayList<>());
        }

        // traverse adjList with DFS to see if we can connect node u to v
        for (int[] edge : edges) {
            seen.clear();
            if (!adjList.get(edge[0]).isEmpty() && !adjList.get(edge[1]).isEmpty() && dfs(adjList, edge[0], edge[1])) {
                return edge;
            }
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        return new int[0];
    }

    private boolean dfs(List<List<Integer>> adjList, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) {
                return true;
            }
            for (int neighNode: adjList.get(source)) {
                if (dfs(adjList, neighNode, target)) {
                    return true;
                }
            }
        }
        return false;
    }
}