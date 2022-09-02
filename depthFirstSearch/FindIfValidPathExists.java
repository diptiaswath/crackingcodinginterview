package depthFirstSearch;

import java.util.*;

//https://leetcode.com/explore/featured/card/graph/619/depth-first-search-in-graph/3893/

// DFS approach to solve the problem of finding whether a path exists from the source vertex to the target vertex on an undirected graph.
public class FindIfValidPathExists {

    public boolean validPath(int n, int[][] edges, int source, int dest) {
        // construct an adjacency list
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        // its a bidirectional graph
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean[] seen = new boolean[n];
        Arrays.fill(seen, false);

        Deque<Integer> stack = new ArrayDeque<>();

        // push source onto the stack
        stack.push(source);

        // check if path exists from source -> destination by visiting each neighbor of source
        while (!stack.isEmpty()) {
            int node = stack.pop();

            if (node == dest) {
                return true;
            }

            if (seen[node]) {
                continue;
            }
            seen[node] = true;

            // visit each neighbor
            for (int curNode : adjList.get(node)) {
                stack.push(curNode);
            }
        }
        return false;
    }
}
