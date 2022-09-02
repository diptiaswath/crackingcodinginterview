package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combinations/submissions/
// Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
// You may return the answer in any order.
public class CombinationsNOfSizeK {

    private void generateCombinations(int k, LinkedList<Integer> comb, int first, List<Integer> input, List<List<Integer>> result) {
        if (comb.size() == k) {
            result.add(new ArrayList<>(comb));
        }
        for (int i = first; i < input.size(); i++) {
            comb.add(input.get(i));
            generateCombinations(k, comb, i + 1, input, result);
            comb.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> input = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            input.add(i);
        }

        LinkedList<Integer> comb = new LinkedList<>();
        generateCombinations(k, comb, 0, input, result);

        return result;
    }
}
