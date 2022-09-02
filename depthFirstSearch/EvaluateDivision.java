package depthFirstSearch;

import java.util.*;

//https://leetcode.com/problems/evaluate-division/solution/

//Let N be the number of input equations and M be the number of queries.

//    Time Complexity: O(M⋅N)
//    Space Complexity: O(N)
public class EvaluateDivision {

    // Algorithm: DFS search 1) check if a path exists between two nodes 2) compute and return cumulative product along the path
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        // Step1: Build the graph of nodes from the list of input equations
        int i = 0;
        for (List<String> equation: equations) {
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            Double quotient = values[i++];

            if (!graph.containsKey(dividend)) {
                graph.put(dividend, new HashMap<String, Double>());
            }
            if (!graph.containsKey(divisor)) {
                graph.put(divisor, new HashMap<String, Double>());
            }
            graph.get(dividend).put(divisor, quotient);
            graph.get(divisor).put(dividend, 1/quotient);
        }

        // Step2 : Evaluate each query via backtracking (DFS) and see if there is a path from DIVIDEND TO DIVISOR
        i = 0;
        double[] result = new double[queries.size()];
        for (List<String> query: queries) {
            String dividend = query.get(0);
            String divisor = query.get(1);

            // Two edge cases to check
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i++] = -1.0;
            } else if (dividend == divisor) {
                result[i++] = 1.0;
            } else {
                result[i++] = backtrack(graph, dividend, divisor, 1, new HashSet<String>());
            }
        }
        return result;
    }

    private double backtrack(Map<String, Map<String, Double>> graph, String srcNode, String destNode,
                             double cumProduct, Set<String> visited) {
        visited.add(srcNode);
        double ret = -1.0;

        Map<String, Double> neighbors = graph.get(srcNode);
        if (neighbors.containsKey(destNode)) {
            ret = cumProduct * neighbors.get(destNode);
        } else {
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                String nextNode = entry.getKey();
                if (visited.contains(nextNode)) {
                    continue;
                }
                ret = backtrack(graph, nextNode, destNode, cumProduct * entry.getValue(), visited);
                if (ret != -1.0) {
                    break;
                }
            }
        }
        // unmark the visit for next backtracking
        visited.remove(srcNode);
        return ret;
    }
}
