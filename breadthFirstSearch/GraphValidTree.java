// https://leetcode.com/problems/graph-valid-tree/
// You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
//
//Return true if the edges of the given graph make up a valid tree, and false otherwise.
// Time = O(N + E)

// G is fully connected if, and only if, we started a iterative breadth first search from a single source and discovered all nodes in G during it.
// G contains no cycles if, and only if, the depth-first search never goes back to an already discovered node. We need to be careful though not to count trivial cycles of the form A → B → A that occur with most implementations of undirected edges.
class Solution {
    // Approach:
    // Graph is a valid tree: if every pair of nodes in Graph has an edge,
    // AND, Graph has no cycles - there is exactly one path between each pair of nodes.
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        Map<Integer, Integer> parent = new HashMap<>();
        parent.put(0, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adjacencyList.get(node)) {
                // node (parent) -> neighbor, now next line is saying neighbor is parent of node
                if (parent.get(node) == neighbour) {
                    continue;
                }
                // check if we have already seen neighbour
                if (parent.containsKey(neighbour)) {
                    return false;
                }
                queue.offer(neighbour);
                parent.put(neighbour, node);
            }
        }

        return parent.size() == n;
    }
}