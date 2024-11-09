package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combinations/submissions/
// Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
// You may return the answer in any order.
public class CombinationsNOfSizeK {

    private void generateCombinations(int start, int n, int k, LinkedList<Integer> comb, List<List<Integer>> result) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            generateCombinations(i+1, n, k, comb,result);
            comb.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (k == 0) {
            return result;
        }

        LinkedList<Integer> comb = new LinkedList<>();
        generateCombinations(1, n, k, comb, result);

        return result;
    }
}
