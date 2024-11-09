// A graph is bipartite if the nodes can be partitioned into
// two independent sets A and B such that every edge in the graph connects a node in set A and a node in set B.

// Approach: Create an array of colored nodes - init to -1 / no color
// Start a DFS from each node that is uncolored. Color it to 0 and then visit its neighbor.
// If neighbor is not colored, color it opposite of the cur node and add to stack, else if colored and color is same as curNode then return false
// Time: O(N + E)
class BiPartiteGraph {
    // https://leetcode.com/problems/is-graph-bipartite/
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0 ; i < n; i++) {
            if (color[i] == -1) {
                Stack<Integer> stack = new Stack<>();
                stack.add(i);
                color[i] = 0;

                while (!stack.isEmpty()) {
                    int curNode = stack.pop();

                    for (int neighNode: graph[curNode]) {
                        if (color[neighNode] == -1) {
                            stack.push(neighNode);
                            color[neighNode] = color[curNode] ^ 1;
                        } else if (color[neighNode] == color[curNode]) {
                            return false;
                        }
                    }
                }// end while
            }
        } // end of for
        return true;
    }
}