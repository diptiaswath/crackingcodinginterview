package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/
// TimeComplexity: O(2^n) = because for each position, its include or do not include
public class CombinationsSumIISolution {
    private void doCombine(int remain, int start, LinkedList<Integer> comb, int[] cands, List<List<Integer>> result) {
        if (remain == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        if (remain < 0) {
            return;
        }
        for (int index = start; index < cands.length; index++) {
            if (index > start && cands[index] == cands[index-1]) {
                continue;
            }
            // optimization: early stopping
            // measure of early stopping, i.e. once the sum of current combination exceeds the target,
            // we can stop the exploration for the rest of the numbers.
            if (remain - candidates[index] < 0) {
                break;
            }
            comb.add(cands[index]);
            doCombine(remain - cands[index], index + 1, comb, cands, result);
            comb.removeLast();
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        LinkedList<Integer> comb = new LinkedList<Integer>();
        doCombine(target, 0, comb, candidates, result);
        return result;
    }
}
