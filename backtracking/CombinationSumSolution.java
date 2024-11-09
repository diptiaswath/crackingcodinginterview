package backtracking;

import java.util.*;

// https://leetcode.com/problems/combination-sum/editorial/

// Let N be the number of candidates, T be the target value, and M be the minimal value among the candidates.
// Time Complexity: O(N ^ T/M)

class CombinationSumSolution {
    private void backTrack(double remain, int start, double[] candidates, LinkedList<Double> comb, List<List<Double>> results) {
        if (remain == 0) {
            results.add(new ArrayList<Double>(comb));
            return;
        } else if (remain < 0) { // exceeds the target
            return;
        }



        for (int i = start; i < candidates.length; i++) {
            comb.add(candidates[i]);
            // In this problem, we are allowed to use the same element multiple times, so we should pass i instead. AND NOT i + 1
            backTrack(remain - candidates[i], i, candidates, comb, results);
            comb.removeLast();
        }
        return;
    }


    public List<List<Double>> recursiveCombine(double target, double[] candidates) {
        List<List<Double>> results = new ArrayList<List<Double>>();
        LinkedList<Double> comb = new LinkedList<Double>();
        backTrack(target, 0, candidates, comb, results);
        return results;
    }

    public static void main(String[] args) {
        double[] a = {2.15, 5.0, 4.30};
        double target = 4.30;
        CombinationSumSolution s = new CombinationSumSolution();

        // recursive
        System.out.println(s.recursiveCombine(target, a));
    }
}
