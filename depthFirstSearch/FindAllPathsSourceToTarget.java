package depthFirstSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/explore/featured/card/graph/619/depth-first-search-in-graph/3850/
// https://leetcode.com/problems/all-paths-from-source-to-target/solution/
public class FindAllPathsSourceToTarget {

    private void backTrack(int start, int[][] graph, LinkedList<Integer> path, List<List<Integer>> paths) {
        if (start == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        // for a directed acyclic graph, no need to maintain list of seen nodes
        int[] nextNodes = graph[start];
        for (int nextNode: nextNodes) {
            path.addLast(nextNode);
            backTrack(nextNode, graph, path, paths);
            path.removeLast();
        }
    }

    // Time Complexity:
    // For a graph with N nodes, there could be 2 ^ (N - 1) possible paths in the graph.
    // For each path, there could be at most N−2 intermediate nodes, i.e. it takes O(N)
    // time to build a path. So overall : O (2 ^ N * N)

    // Space Complexity: O(N) = N recursive calls takes O(N) space plus
    // keeping state of the current path would take another O(N) space
    // Since at most we could have 2 ^ (N−1) paths as the results and
    // each path can contain up to N nodes, we need extra O(2^N * N)  space to store and
    // return the results

    // The recursion depth can be no more than N and we need O(N) space to
    // store all the previously visited nodes while recursively traversing deeper with the current path.
    // Please note that we don't count the space usage for the output, i.e., to store all the paths we obtained
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();

        if (graph == null || graph.length == 0) {
            return paths;
        }

        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        backTrack(0, graph, path, paths);
        return paths;
    }
}
